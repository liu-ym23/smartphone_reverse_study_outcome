package n10;

import android.view.View;
import android.widget.CompoundButton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f516660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View.OnClickListener f516661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompoundButton.OnCheckedChangeListener f516662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f516663d;

    public h(boolean r100) {
        e r101 = e.f516657a;
        Intrinsics.checkNotNullParameter("性能面板展示开关", "title");
        Intrinsics.checkNotNullParameter(r101, "checkedBtnListener");
        this.f516660a = "";
        this.f516660a = "性能面板展示开关";
        this.f516663d = r100;
        this.f516662c = r101;
    }

    public h(String r100, View.OnClickListener r101) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "onItemClickListener");
        this.f516660a = "";
        this.f516660a = r100;
        this.f516661b = r101;
    }
}
