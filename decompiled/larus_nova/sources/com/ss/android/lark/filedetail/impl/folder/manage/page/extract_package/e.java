package com.ss.android.lark.filedetail.impl.folder.manage.page.extract_package;

import android.view.View;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ExtractPackageFragment f421723a;

    public e(ExtractPackageFragment r100) {
        this.f421723a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        int r101 = pfb.d.f529030a;
        String r102 = this.f421723a.f421696d.f421495b;
        Intrinsics.checkNotNullParameter("download", "click");
        Intrinsics.checkNotNullParameter("none", PickerReporterConstants.KEY.TARGET);
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L12;
        pfb.d.a.b(r102, "im_file_decompress_fail_not_support_click", MapsKt.mapOf(new Pair[]{TuplesKt.to("click", "download"), TuplesKt.to(PickerReporterConstants.KEY.TARGET, "none")}));
    L12:
        this.f421723a.f421697e.f();
        return;
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L9
    }
}
