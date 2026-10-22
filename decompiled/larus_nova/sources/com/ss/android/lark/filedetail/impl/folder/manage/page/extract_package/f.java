package com.ss.android.lark.filedetail.impl.folder.manage.page.extract_package;

import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.larksuite.component.universe_design.progress.UDProgress;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class f<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ExtractPackageFragment f421724a;

    public f(ExtractPackageFragment r100) {
        this.f421724a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        float r101 = ((Number) r100).floatValue();
        ExtractPackageFragment.U90(this.f421724a, false, true, false, false, 13);
        int r102 = (int) (r101 * 100);
        UDProgress r103 = this.f421724a.f421700h;
        TextView r104 = null;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("extractProgress");
        r103 = null;
    L5:
        r103.setProgress(r102);
        TextView r105 = this.f421724a.f421701i;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("extractProgressDesc");
    L9:
        StringBuilder r106 = new StringBuilder();
        r106.append(r102);
        r106.append('%');
        r104.setText(r106.toString());
        return;
    L8:
        r104 = r105;
        goto L9
    }
}
