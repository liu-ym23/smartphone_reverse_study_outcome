package p05;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.document.customheader.CustomHeaderFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a<T> implements Observer {
    public final /* synthetic */ CustomHeaderFragment a;
    public final /* synthetic */ int b;
    public final /* synthetic */ boolean c;

    public a(CustomHeaderFragment r1, int r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onChanged(Object r4) {
        if (((Boolean) r4).booleanValue() == false) goto L5;
        CustomHeaderFragment r5 = this.a;
        int r1 = r5.getResources().getColor(2131103546);
        int r2 = CustomHeaderFragment.z;
        r5.Z90(r1, true);
        return;
    L5:
        CustomHeaderFragment r6 = this.a;
        int r3 = this.b;
        boolean r0 = true ^ this.c;
        int r7 = CustomHeaderFragment.z;
        r6.Z90(r3, r0);
    }
}
