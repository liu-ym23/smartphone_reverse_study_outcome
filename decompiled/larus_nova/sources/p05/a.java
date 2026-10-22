package p05;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.document.customheader.CustomHeaderFragment;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class a<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomHeaderFragment f527287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f527288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f527289c;

    public a(CustomHeaderFragment r100, int r101, boolean r102) {
        this.f527287a = r100;
        this.f527288b = r101;
        this.f527289c = r102;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (((Boolean) r100).booleanValue() == false) goto L5;
        CustomHeaderFragment r101 = this.f527287a;
        int r102 = r101.getResources().getColor(R.color.lkui_transparent);
        int r103 = CustomHeaderFragment.f219406z;
        r101.Z90(r102, true);
        return;
    L5:
        CustomHeaderFragment r104 = this.f527287a;
        int r105 = this.f527288b;
        boolean r106 = true ^ this.f527289c;
        int r107 = CustomHeaderFragment.f219406z;
        r104.Z90(r105, r106);
    }
}
