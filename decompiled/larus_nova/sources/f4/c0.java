package f4;

import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import com.alibaba.gaiax.template.GXTemplateKey;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c0 extends WindowInsetsAnimation.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f475441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f475442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Runnable f475443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f475444d;

    @Override // android.view.WindowInsetsAnimation.Callback
    public final WindowInsets onProgress(WindowInsets r100, List<WindowInsetsAnimation> r101) {
        Intrinsics.checkNotNullParameter(r100, "insets");
        Intrinsics.checkNotNullParameter(r101, "runningAnimations");
        return r100;
    }

    @Override // android.view.WindowInsetsAnimation.Callback
    public final void onEnd(WindowInsetsAnimation r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onEnd(r100);
        if (this.f475441a.compareAndSet(false, true) == false) goto L6;
        this.f475442b.removeCallbacks(this.f475443c);
        this.f475444d.invoke();
        return;
    }

    public c0(AtomicBoolean r100, View r101, a0 r102, z r103) {
        this.f475441a = r100;
        this.f475442b = r101;
        this.f475443c = r102;
        this.f475444d = r103;
        super(1);
    }
}
