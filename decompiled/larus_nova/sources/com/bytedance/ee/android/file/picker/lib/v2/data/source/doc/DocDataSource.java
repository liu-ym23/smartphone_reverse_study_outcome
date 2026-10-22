package com.bytedance.ee.android.file.picker.lib.v2.data.source.doc;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.MediaStore;
import com.bytedance.ee.android.file.picker.lib.v2.data.entity.FileEntry;
import com.bytedance.ee.android.file.picker.lib.v2.util.content.b;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.utils.MediaStoreUtil;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.permission.StoragePermissionUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import dagger.hilt.android.qualifiers.ApplicationContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.c1;
import um4.d;

/* JADX INFO: loaded from: classes15.dex */
public final class DocDataSource implements um4.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f206026f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f206027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f206028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f206029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f206030d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f206031e;

    public static final class a {
    }

    static {
    }

    @Override // um4.a
    public final Flow<List<FileEntry>> load() {
        int r100 = d.f550664a;
        Context r101 = this.f206027a;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = Build.VERSION.SDK_INT;
        boolean r103 = true;
        if (r102 <= 29) goto L5;
        boolean r104 = true;
    L7:
        if (r104 == true) goto L10;
        Log.i("DocDataSource", "no permission, return empty flow");
        return kotlinx.coroutines.flow.d.f504845a;
    L10:
        Log.i("DocDataSource", "start load, selection:" + this.f206030d);
        ContentResolver r105 = this.f206027a.getContentResolver();
        Set<String> r106 = MediaStoreUtil.f285910a;
        if (r102 >= 29) goto L14;
        r103 = false;
    L14:
        if (r103 == false) goto L16;
        String r107 = "external_primary";
    L17:
        final c1 r108 = b.b(b.c(r105, MediaStore.Files.getContentUri(r107), null, this.f206030d, this.f206029c, this.f206031e, new Token("LARK-PSDA-messenger_doc_data_source"), 34), new AnonymousClass1(this));
        return new DocDataSource$load$$inlined$map$1(r108, this);
    L16:
        r107 = "external";
        goto L17
    L5:
        r104 = StoragePermissionUtils.d(r101, 4);
        goto L7
    }

    @Inject
    public DocDataSource(@ApplicationContext Context r110) {
        Intrinsics.checkNotNullParameter(r110, "mContext");
        this.f206027a = r110;
        if (Build.VERSION.SDK_INT < 29) goto L5;
        String r111 = "_display_name";
    L6:
        this.f206028b = r111.concat(" like ?");
        String[] r112 = {"doc", DocumentType.DOCX_NAME, "xls", "xlsx", "ppt", ExportFileExtension.PPTX, ExportFileExtension.PDF};
        ArrayList r100 = new ArrayList(7);
        int r101 = 0;
    L7:
        if (r101 >= 7) goto L9;
        r100.add("%." + r112[r101]);
        r101 = r101 + 1;
        goto L7
    L9:
        String[] r102 = (String[]) r100.toArray(new String[0]);
        this.f206029c = r102;
        this.f206030d = ArraysKt.joinToString$default(r102, " OR ", null, null, 0, null, new DocDataSource$mMultiSelection$1(this), 30, null);
        this.f206031e = "date_added DESC";
        return;
    L5:
        r111 = "_data";
        goto L6
    }
}
