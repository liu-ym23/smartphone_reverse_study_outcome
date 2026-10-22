package va3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewGroupManager;
import com.bytedance.android.shopping.extensions.k;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e extends com.bytedance.android.ecom.arch.slice.render.elements.a<h> {
    public float W3;
    public float X3;
    public String Y3;

    public static final class a {
    }

    static {
    }

    public final void A1() {
        Iterator r0 = com.bytedance.commerce.base.view.b.a(I1()).iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        ViewGroup.LayoutParams r1 = ((View) r0.next()).getLayoutParams();
        if (r1 == null) goto L4;
        if ((r1 instanceof FrameLayout.LayoutParams) == true) goto L10;
        r1 = null;
    L10:
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) r1;
        if (r2 == null) goto L4;
        r2.gravity = 17;
        goto L4
    }

    public e(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "slcTemplateContext");
        super(r2);
        this.W3 = 5.0f;
        this.X3 = 1.0f;
        this.Y3 = "up";
        ((BaseSlcViewGroupManager) this).O3 = false;
        ((BaseSlcViewGroupManager) this).Q3 = true;
    }

    public final void H0(Map<String, ? extends Object> r17) {
        Intrinsics.checkNotNullParameter(r17, "props");
        Object r2 = r17.get("interval_second");
        Object r4 = null;
        if ((r2 instanceof String) == true) goto L5;
        r2 = null;
    L5:
        String r3 = (String) r2;
        if (r3 == null) goto L10;
        Float r5 = StringsKt.toFloatOrNull(r3);
        if (r5 == null) goto L10;
        float r6 = r5.floatValue();
    L11:
        this.W3 = r6;
        Object r7 = r17.get("animation_second");
        if ((r7 instanceof String) == true) goto L14;
        r7 = null;
    L14:
        String r8 = (String) r7;
        if (r8 == null) goto L19;
        Float r9 = StringsKt.toFloatOrNull(r8);
        if (r9 == null) goto L19;
        float r10 = r9.floatValue();
    L20:
        this.X3 = r10;
        Object r1 = r17.get("scroll_direction");
        if ((r1 instanceof String) == false) goto L24;
        r4 = r1;
    L24:
        String r11 = (String) r4;
        if (r11 != null) goto L27;
        r11 = "up";
    L27:
        this.Y3 = r11;
        h r12 = (h) I1();
        float r13 = this.X3;
        float r14 = this.W3 - r13;
        String r15 = this.Y3;
        r12.getClass();
        Intrinsics.checkNotNullParameter(this, "viewManager");
        if (r15 == null) goto L48;
        int r16 = r15.hashCode();
        if (r16 == 3739) goto L46;
        if (r16 == 3089570) goto L43;
        if (r16 == 3317767) goto L40;
        if (r16 != 108511772) goto L48;
        if (r15.equals("right") == false) goto L48;
        Animation r18 = AnimationUtils.loadAnimation(r12.getContext(), 2130772100);
    L49:
        float r19 = 1000;
        long r20 = (long) (r13 * r19);
        r18.setDuration(r20);
        r18.setFillEnabled(true);
        r18.setRepeatMode(0);
        r18.setFillAfter(false);
        r18.setFillBefore(true);
        r18.setAnimationListener(new f(r12, this));
        Unit r110 = Unit.INSTANCE;
        r12.setInAnimation(r18);
        if (r15 == null) goto L72;
        int r111 = r15.hashCode();
        if (r111 == 3739) goto L70;
        if (r111 == 3089570) goto L67;
        if (r111 == 3317767) goto L64;
        if (r111 != 108511772) goto L72;
        if (r15.equals("right") == false) goto L72;
        Animation r21 = AnimationUtils.loadAnimation(r12.getContext(), 2130772103);
    L73:
        r21.setDuration(r20);
        r21.setFillEnabled(true);
        r21.setRepeatMode(0);
        r21.setFillAfter(false);
        r21.setFillBefore(true);
        r21.setAnimationListener(new g(r12, r14));
        r12.setOutAnimation(r21);
        r12.postDelayed(r12.a, (long) (k.d(Float.valueOf(r14)) * r19));
        return;
    L64:
        if (r15.equals("left") == false) goto L72;
        r21 = AnimationUtils.loadAnimation(r12.getContext(), 2130772101);
        goto L73
    L67:
        if (r15.equals("down") == false) goto L72;
        r21 = AnimationUtils.loadAnimation(r12.getContext(), 2130772099);
        goto L73
    L70:
        if (r15.equals("up") == false) goto L72;
        r21 = AnimationUtils.loadAnimation(r12.getContext(), 2130772105);
    L72:
        r21 = AnimationUtils.loadAnimation(r12.getContext(), 2130772105);
        goto L73
    L40:
        if (r15.equals("left") == false) goto L48;
        r18 = AnimationUtils.loadAnimation(r12.getContext(), 2130772102);
        goto L49
    L43:
        if (r15.equals("down") == false) goto L48;
        r18 = AnimationUtils.loadAnimation(r12.getContext(), 2130772104);
        goto L49
    L46:
        if (r15.equals("up") == false) goto L48;
        r18 = AnimationUtils.loadAnimation(r12.getContext(), 2130772098);
    L48:
        r18 = AnimationUtils.loadAnimation(r12.getContext(), 2130772098);
    L19:
        r10 = 1.0f;
    L10:
        r6 = 5.0f;
        goto L11
    }

    public final ViewGroup K1(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new h(r2);
    }
}
