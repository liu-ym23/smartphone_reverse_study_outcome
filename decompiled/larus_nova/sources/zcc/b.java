package zcc;

import adc.c;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class b extends com.ss.android.lark.widget.photopicker.animation.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f571283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TimeInterpolator f571284b;

    public b(c r100) {
        this.f571283a = r100;
    }

    @Override // com.ss.android.lark.widget.photopicker.animation.b
    public final void a(FragmentActivity r100) {
        if (this.f571284b != null) goto L5;
        this.f571284b = new AccelerateInterpolator();
    L5:
        c r101 = this.f571283a;
        TimeInterpolator r102 = this.f571284b;
        a r103 = new a(r100);
        View r104 = (View) ListProtector.get(r101.f3061d, 0);
        int r105 = r101.f3058a;
        float r106 = r101.f3059b;
        r104.setAlpha(r101.f3060c);
        long r107 = r105;
        r104.animate().setDuration(r107).setInterpolator(r102).setListener(null).alpha(r106);
        r104.postDelayed(r103, r107);
    }
}
