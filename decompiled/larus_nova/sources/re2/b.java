package re2;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes10.dex */
public final class b extends com.bytedance.android.live.liveinteract.a {
    public final ImageView C;
    public final ObjectAnimator D;
    public final ObjectAnimator E;
    public final ObjectAnimator F;
    public final ObjectAnimator G;
    public final ObjectAnimator H;
    public final ObjectAnimator I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final ObjectAnimator f537416J;
    public final ObjectAnimator K;
    public final ObjectAnimator L;
    public final ObjectAnimator M;
    public ObjectAnimator N;

    @Override // com.bytedance.android.live.liveinteract.a
    public final void b() {
        this.C.setAlpha(1.0f);
        super.b();
    }

    @Override // com.bytedance.android.live.liveinteract.a
    public final void c() {
        if (this.f70878j == true) goto L5;
        this.f70891w.playTogether(new Animator[]{this.D, this.f70879k, this.E, this.f70880l, this.F, this.G, this.H});
        this.f70892x.playTogether(new Animator[]{this.f70882n, this.f70883o, this.I, this.f537416J});
        this.f70893y.playTogether(new Animator[]{this.f70884p, this.f70885q, this.L, this.K, this.f70886r});
        this.f70894z.playTogether(new Animator[]{this.f70887s, this.f70890v, this.f70889u, this.f70888t, this.M});
        super.a();
        this.f70894z.addListener(new a(this));
        this.f70878j = true;
    L5:
        this.A = true;
        this.f70891w.start();
    }

    public b(View r110) {
        Intrinsics.checkNotNullParameter(r110, "itemView");
        super(r110);
        ImageView r100 = (ImageView) r110.findViewById(R.id.ttlive_empty_avatar);
        this.C = r100;
        ObjectAnimator r101 = ObjectAnimator.ofFloat(this.f70873e, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{s1.f(36.0f), 0.0f});
        r101.setDuration(400);
        r101.setInterpolator(this.f70876h);
        ((ArrayList) this.f70877i).add(r101);
        Unit r102 = Unit.INSTANCE;
        this.D = r101;
        ObjectAnimator r103 = ObjectAnimator.ofFloat(this.f70874f, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{s1.f(4.0f), 0.0f});
        r103.setDuration(400);
        r103.setInterpolator(this.f70876h);
        ((ArrayList) this.f70877i).add(r103);
        this.E = r103;
        ObjectAnimator r104 = ObjectAnimator.ofFloat(this.f70875g, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{s1.f(4.0f), 0.0f});
        r104.setDuration(400);
        r104.setInterpolator(this.f70876h);
        ((ArrayList) this.f70877i).add(r104);
        this.F = r104;
        Drawable r105 = this.f70875g.getBackground();
        if (r105 == null) goto L15;
        int r106 = (int) 3003121664L;
        ObjectAnimator r107 = ObjectAnimator.ofInt((GradientDrawable) r105, "color", new int[]{0, r106});
        r107.setDuration(400);
        r107.setEvaluator(new ArgbEvaluator());
        ((ArrayList) this.f70877i).add(r107);
        this.G = r107;
        ObjectAnimator r108 = ObjectAnimator.ofFloat(r100, "alpha", new float[]{1.0f, 0.0f});
        r108.setDuration(300);
        ((ArrayList) this.f70877i).add(r108);
        this.H = r108;
        ObjectAnimator r109 = ObjectAnimator.ofFloat(this.f70875g, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 0.81f});
        r109.setDuration(400);
        ((ArrayList) this.f70877i).add(r109);
        this.I = r109;
        Drawable r111 = this.f70875g.getBackground();
        if (r111 == null) goto L13;
        int r112 = (int) BodyPartID.bodyIdMax;
        ObjectAnimator r113 = ObjectAnimator.ofInt((GradientDrawable) r111, "color", new int[]{r106, r112});
        r113.setDuration(400);
        r113.setEvaluator(new ArgbEvaluator());
        ((ArrayList) this.f70877i).add(r113);
        this.f537416J = r113;
        Drawable r114 = this.f70875g.getBackground();
        if (r114 == null) goto L11;
        ObjectAnimator r115 = ObjectAnimator.ofInt((GradientDrawable) r114, "color", new int[]{r112, r106});
        r115.setDuration(400);
        r115.setEvaluator(new ArgbEvaluator());
        ((ArrayList) this.f70877i).add(r115);
        this.K = r115;
        ObjectAnimator r116 = ObjectAnimator.ofFloat(this.f70875g, LiveDegradeFpsAnimator.SCALE_X, new float[]{0.81f, 0.95f});
        r116.setDuration(400);
        ((ArrayList) this.f70877i).add(r116);
        this.L = r116;
        ObjectAnimator r117 = ObjectAnimator.ofFloat(r100, "alpha", new float[]{0.0f, 1.0f});
        r117.setDuration(300);
        ((ArrayList) this.f70877i).add(r117);
        this.M = r117;
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    }
}
