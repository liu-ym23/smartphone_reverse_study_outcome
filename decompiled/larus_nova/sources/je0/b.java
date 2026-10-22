package je0;

import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    public static final class a extends BaseAnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f498786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AnimatedDrawable2 f498787b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0 f498788c;

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationStop(AnimatedDrawable2 r100) {
            Intrinsics.checkNotNullParameter(r100, "drawable");
            Function0 r101 = this.f498788c;
            if (r101 == null) goto L6;
            Unit r102 = (Unit) r101.invoke();
            return;
        }

        public a(AnimatedDrawable2 r100, Function0 r101) {
            this.f498787b = r100;
            this.f498788c = r101;
            this.f498786a = -1;
        }

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationFrame(AnimatedDrawable2 r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "drawable");
            if (r101 >= this.f498786a) goto L5;
            this.f498787b.stop();
        L5:
            this.f498786a = r101;
        }
    }

    public static final void a(AnimatedDrawable2 r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$playOnce");
        r100.setAnimationListener(new a(r100, r101));
    }
}
