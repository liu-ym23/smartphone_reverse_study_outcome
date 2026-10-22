package com.bytedance.ee.bear.list.office.longpress;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements td5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f228941a;

    public c(Context r100) {
        this.f228941a = r100;
    }

    @Override // td5.a
    public final boolean a(Document r100) {
        Intrinsics.checkNotNullParameter(r100, "destFolder");
        FolderVersion.a r101 = FolderVersion.Companion;
        Integer r102 = Integer.valueOf(r100.L1);
        r101.getClass();
        return FolderVersion.a.c(r102);
    }

    @Override // td5.a
    public final void b(Document r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "destFolder");
        if (r101 != null) goto L5;
        r101 = this.f228941a;
    L5:
        Toast.showText(r101, this.f228941a.getString(R.string.CreationMobile_ECM_UnableShortToast));
    }
}
