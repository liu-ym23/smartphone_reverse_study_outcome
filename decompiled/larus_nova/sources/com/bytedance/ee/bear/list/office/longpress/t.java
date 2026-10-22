package com.bytedance.ee.bear.list.office.longpress;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.selector.SpaceSelectorBean;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class t implements td5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SpaceSelectorBean f229078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f229079b;

    @Override // td5.a
    public final boolean a(Document r100) {
        Intrinsics.checkNotNullParameter(r100, "destFolder");
        if (this.f229078a.f229391g == false) goto L8;
        FolderVersion.a r101 = FolderVersion.Companion;
        Integer r102 = Integer.valueOf(r100.L1);
        r101.getClass();
        if (FolderVersion.a.c(r102) == true) goto L8;
        return false;
    L8:
        if (this.f229078a.f229391g == true) goto L12;
        FolderVersion.a r103 = FolderVersion.Companion;
        Integer r104 = Integer.valueOf(r100.L1);
        r103.getClass();
        if (FolderVersion.a.c(r104) == false) goto L14;
        return false;
    L14:
        return true;
    L12:
        return true;
    }

    public t(SpaceSelectorBean r100, Context r101) {
        this.f229078a = r100;
        this.f229079b = r101;
    }

    @Override // td5.a
    public final void b(Document r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "destFolder");
        if (r101 != null) goto L6;
        r101 = this.f229079b;
    L6:
        if (this.f229078a.f229391g == false) goto L11;
        FolderVersion.a r102 = FolderVersion.Companion;
        Integer r103 = Integer.valueOf(r100.L1);
        r102.getClass();
        if (FolderVersion.a.c(r103) == true) goto L11;
        Toast.showText(r101, r101.getString(R.string.CreationMobile_ECM_UnableDuplicateDocToast));
    L11:
        if (this.f229078a.f229391g == true) goto L16;
        FolderVersion.a r104 = FolderVersion.Companion;
        Integer r105 = Integer.valueOf(r100.L1);
        r104.getClass();
        if (FolderVersion.a.c(r105) == false) goto L17;
        Toast.showText(r101, r101.getString(R.string.CreationMobile_ECM_UnableDuplicateToast));
        return;
    L17:
        return;
    }
}
