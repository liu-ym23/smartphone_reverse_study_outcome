package og0;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c extends BaseAnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f523176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f523177b;

    public c(d r100, int r101) {
        this.f523176a = r100;
        this.f523177b = r101;
    }

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationFrame(AnimatedDrawable2 r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        super.onAnimationFrame(r100, r101);
        if (r101 != (this.f523177b - 1)) goto L9;
        HSImageView r102 = this.f523176a.f523178a.f523169e;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("likeEffect");
    L7:
        UtilityKotlinExtentionsKt.t(r102);
        return;
    }
}
