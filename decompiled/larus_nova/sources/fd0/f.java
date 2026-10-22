package fd0;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.liveinteract.animator.LiveAnimator;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveAnimator f476453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View[] f476454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Animator> f476455c;

    public final void a() {
        c("alpha", new float[]{0.0f, 0.25f, 0.5f, 0.75f, 1.0f});
    }

    public final void b() {
        c("alpha", new float[]{1.0f, 0.75f, 0.5f, 0.25f, 0.0f});
    }

    public final LiveAnimator e() {
        this.f476453a.c();
        return this.f476453a;
    }

    public final void d(float... r100) {
        c(LiveDegradeFpsAnimator.SCALE_X, r100);
        c(LiveDegradeFpsAnimator.SCALE_Y, r100);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [fd0.d] */
    public final void f(float... r100) {
        ?? r101 = new d();
        View[] r102 = this.f476454b;
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        View r105 = r102[r104];
        ValueAnimator r106 = ValueAnimator.ofFloat(r100);
        r106.addUpdateListener(new e(r101, r105));
        ((ArrayList) this.f476455c).add(r106);
        r104 = r104 + 1;
        goto L3
    }

    public f(LiveAnimator r100, View... r101) {
        this.f476455c = new ArrayList();
        this.f476453a = r100;
        this.f476454b = r101;
    }

    public final void c(String r100, float... r101) {
        View[] r102 = this.f476454b;
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        View r105 = r102[r104];
        List<Animator> r106 = this.f476455c;
        ArrayList r107 = (ArrayList) r106;
        r107.add(ObjectAnimator.ofFloat(r105, r100, r101));
        r104 = r104 + 1;
        goto L3
    }
}
