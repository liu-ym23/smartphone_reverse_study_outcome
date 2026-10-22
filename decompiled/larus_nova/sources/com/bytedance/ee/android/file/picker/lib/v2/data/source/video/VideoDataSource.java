package com.bytedance.ee.android.file.picker.lib.v2.data.source.video;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import com.bytedance.ee.android.file.picker.lib.v2.data.entity.FileEntry;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.utils.MediaStoreUtil;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.permission.StoragePermissionUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import dagger.hilt.android.qualifiers.ApplicationContext;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.c1;
import rm4.b;
import um4.d;

/* JADX INFO: loaded from: classes15.dex */
public final class VideoDataSource implements um4.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f206038d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f206039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f206040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f206041c;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ee.android.file.picker.lib.v2.data.source.video.VideoDataSource$load$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Cursor, FileEntry> {
        public AnonymousClass1(Object r100) {
            super(1, r100, VideoDataSource.class, "cursor2Entry", "cursor2Entry(Landroid/database/Cursor;)Lcom/bytedance/ee/android/file/picker/lib/v2/data/entity/FileEntry;", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final FileEntry invoke2(Cursor r110) {
            Intrinsics.checkNotNullParameter(r110, "p0");
            VideoDataSource r100 = (VideoDataSource) this.receiver;
            int r101 = VideoDataSource.f206038d;
            r100.getClass();
            Uri r102 = ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, r110.getLong(r110.getColumnIndexOrThrow(DBDefinition.ID)));
            String r103 = r110.getString(r110.getColumnIndexOrThrow("_data"));
            long r104 = r110.getLong(r110.getColumnIndexOrThrow("_size"));
            String r105 = r110.getString(r110.getColumnIndexOrThrow("_display_name"));
            int r111 = r110.getInt(r110.getColumnIndexOrThrow("duration"));
            int r106 = b.f538545a;
            if (r111 > 0) goto L5;
            String r112 = "";
        L6:
            String r113 = UIHelper.mustacheFormat(R.string.Lark_Legacy_VideoDuration, "duration", r112);
            Intrinsics.checkNotNull(r105);
            Intrinsics.checkNotNull(r103);
            Intrinsics.checkNotNull(r113);
            return new FileEntry(r105, r102, r103, r104, "video_thumb", r113, "video", 128);
        L5:
            int r114 = r111 / 1000;
            int r107 = r114 % 60;
            int r115 = r114 / 60;
            r112 = b.a(r115 / 60) + ':' + b.a(r115 % 60) + ':' + b.a(r107);
            goto L6
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ FileEntry invoke(Cursor r100) {
            return invoke2(r100);
        }
    }

    static {
    }

    @Override // um4.a
    public final Flow<List<FileEntry>> load() {
        Log.i("VideoDataSource", "start load");
        int r100 = d.f550664a;
        Context r101 = this.f206039a;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = Build.VERSION.SDK_INT;
        boolean r103 = true;
        if (r102 <= 29) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L9;
        Log.i("VideoDataSource", "no permission, return empty flow");
        return kotlinx.coroutines.flow.d.f504845a;
    L9:
        ContentResolver r105 = this.f206039a.getContentResolver();
        Set<String> r106 = MediaStoreUtil.f285910a;
        if (r102 >= 29) goto L13;
        r103 = false;
    L13:
        if (r103 == false) goto L15;
        Uri r107 = MediaStore.Video.Media.getContentUri("external_primary");
    L16:
        final c1 r108 = com.bytedance.ee.android.file.picker.lib.v2.util.content.b.b(com.bytedance.ee.android.file.picker.lib.v2.util.content.b.c(r105, r107, this.f206040b, "mime_type like ?", this.f206041c, "date_added DESC", new Token("LARK-PSDA-messenger_video_data_source"), 32), new AnonymousClass1(this));
        return new VideoDataSource$load$$inlined$map$1(r108, this);
    L15:
        r107 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        goto L16
    L5:
        r104 = StoragePermissionUtils.d(r101, 4);
        goto L6
    }

    @Inject
    public VideoDataSource(@ApplicationContext Context r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        this.f206039a = r100;
        this.f206040b = new String[]{DBDefinition.ID, "_data", "_size", "_display_name", "duration"};
        this.f206041c = new String[]{"video/%"};
    }
}
