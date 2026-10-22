package wx3;

import android.R;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.awemeopen.apps.framework.utils.d0;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final float d = 0.0f;
    public final C0183a a;
    public final PopupWindow b;
    public final View c;

    /* JADX INFO: renamed from: wx3.a$a, reason: collision with other inner class name */
    public static final class C0183a {
        public final Activity a;
        public Drawable b;
        public String c;
        public Function1<? super TextView, Unit> d;
        public Drawable e;
        public String f;
        public Function1<? super TextView, Unit> g;
        public View h;
        public final int i;
        public int j;
        public int k;
        public final long l;
        public b m;
        public int n;
        public int o;
        public boolean p;
        public boolean q;
        public final Integer r;
        public final boolean s;

        public C0183a(Activity r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            this.a = r3;
            this.i = 81;
            this.k = (int) n0.a(r3, 12.0f);
            this.l = 5000;
            this.n = d0.d(r3);
            this.o = (int) n0.a(r3, 40.0f);
            this.p = true;
            this.r = 2131954112;
            this.s = true;
        }
    }

    public interface b {
        void a(a r1);

        void b(a r1);

        void c(a r1);

        void d(a r1);
    }

    public static final class c {
    }

    public final class d extends ViewOutlineProvider {
        public final int a;
        public final float b;
        public final float c;
        public final Rect d;

        public d(int r1) {
            this.a = r1;
            this.b = 1.0f;
            this.c = 0.9f;
            this.d = new Rect();
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r7, Outline r8) {
            if (r7 == null) goto L6;
            Drawable r9 = r7.getBackground();
            if (r9 == null) goto L6;
            r9.copyBounds(this.d);
        L6:
            Rect r10 = this.d;
            float r0 = this.b;
            boolean r1 = true;
            if (r0 != 1.0f) goto L9;
            boolean r4 = true;
        L11:
            if (r4 == true) goto L13;
            r10.left = (int) ((r10.left * r0) + 0.5f);
            r10.right = (int) ((r10.right * r0) + 0.5f);
        L13:
            float r2 = this.c;
            if (r2 == 1.0f) goto L17;
            r1 = false;
        L17:
            if (r1 == true) goto L19;
            r10.top = (int) ((r10.top * r2) + 0.5f);
            r10.bottom = (int) ((r10.bottom * r2) + 0.5f);
        L19:
            r10.offset(0, this.a);
            if (r8 == null) goto L22;
            r8.setRoundRect(this.d, a.d);
        L22:
            if (r8 == null) goto L26;
            r8.setAlpha(0.5f);
            return;
        L26:
            return;
        L9:
            r4 = false;
            goto L11
        }
    }

    public final class e extends CountDownTimer {
        public final /* synthetic */ a a;

        @Override // android.os.CountDownTimer
        public final void onTick(long r1) {
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            this.a.a();
        }

        public e(a r1, long r2, long r4) {
            this.a = r1;
            super(r2, r4);
        }
    }

    static {
        Resources r1 = Resources.getSystem();
        d = TypedValue.applyDimension(1, 12, WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()));
    }

    public final void a() {
        if (this.b.isShowing() == true) goto L5;
        return;
    L5:
        b r0 = this.a.m;
        if (r0 == null) goto L9;
        r0.a(this);
    L9:
        if (this.a.a.isFinishing() == false) goto L12;
    L13:
        boolean r1 = false;
    L15:
        if (r1 == true) goto L23;
    L19:
        b r2 = this.a.m;
        if (r2 == null) goto L25;
        r2.c(this);
        return;
    L25:
        return;
    L23:
        PopupWindow r3 = this.b;     // Catch: Exception -> L18
        PopupWindowLancet.handleDismissBeforeOrigin(r3);     // Catch: Exception -> L18
        r3.dismiss();     // Catch: Exception -> L18
    L18:
        AoLogger.c("InteractivePopView", new Object[]{"popWindow dismiss failure"});
        goto L19
    L12:
        if (this.a.a.isDestroyed() == true) goto L13;
        r1 = true;
        goto L15
    }

    public final void b() {
        if (this.b.isShowing() == true) goto L65;
        C0183a r0 = this.a;
        if (r0.l > 0) goto L7;
        return;
    L7:
        if (r0.a.isFinishing() == false) goto L9;
        return;
    L9:
        if (this.a.a.isDestroyed() == true) goto L69;
        b r1 = this.a.m;
        if (r1 == null) goto L15;
        r1.d(this);
    L15:
        if (this.a.l == Long.MAX_VALUE) goto L21;
        long r7 = this.a.l;
        if ((r7 / ((long) 10)) != 0) goto L19;
        long r2 = 1;
    L20:
        new e(this, r7, r2).start();
        goto L21
    L19:
        r2 = (long) Math.pow(10.0d, ((int) Math.log10(r7)) - 1);
    L21:
        C0183a r3 = this.a;
        View r4 = r3.h;
        boolean r5 = true;
        if (r4 == null) goto L27;
        PopupWindow r6 = this.b;
        int r8 = r3.j;
        int r9 = (-Math.abs(r3.k)) - this.a.o;
        Resources r10 = Resources.getSystem();
        int r11 = r9 - MathKt.roundToInt(TypedValue.applyDimension(1, 12, WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics())));
        OverlaySource r12 = PopupWindowLancet.resolveSource(r4);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r6, r4, r12) == true) goto L50;
        r6.showAsDropDown(r4, r8, r11, 81);
        PopupWindowLancet.trackAfterShow(r6, r12, r4);
    L50:
        if (this.a.s == false) goto L61;
        TextView r13 = (TextView) this.c.findViewById(2131390853);
        if (r13 == null) goto L61;
        r13.requestFocus();
        r13.sendAccessibilityEvent(8);
        CharSequence r14 = r13.getText();
        if (r14 != null) goto L56;
    L59:
        if (r5 == true) goto L61;
        r13.announceForAccessibility(r13.getText());
        goto L61
    L56:
        if (r14.length() == 0) goto L59;
        r5 = false;
    L61:
        b r15 = this.a.m;
        if (r15 == null) goto L68;
        r15.b(this);
        return;
    L68:
        return;
    L27:
        Activity r16 = r3.a;
        View r17 = null;
        if ((r16 instanceof Activity) == true) goto L31;
        r16 = null;
    L31:
        if (r16 == null) goto L47;
        View r18 = r16.findViewById(R.id.content);
        if (r18 == null) goto L47;
        PopupWindow r19 = this.b;
        C0183a r20 = this.a;
        int r110 = r20.i;
        int r111 = r20.j;
        int r21 = r20.k;
        if (PopupWindowLancet.hasSubWindowToken(r18) == false) goto L38;
    L46:
        r17 = r18;
        goto L47
    L38:
        if ((r19 instanceof PopupWindow) == true) goto L40;
    L42:
        OverlaySource r112 = PopupWindowLancet.resolveSource(r18);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r19, r18, r112, r110, r111, r21) == true) goto L46;
        r19.showAtLocation(r18, r110, r111, r21);
        PopupWindowLancet.trackAfterShow(r19, r112, r18);
        goto L46
    L40:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r19) == false) goto L42;
        r19.showAtLocation(r18, r110, r111, r21);
    L47:
        if (r17 != null) goto L50;
        AoLogger.c("InteractivePopView", new Object[]{"both anchorView and parentView are null"});
        Unit r22 = Unit.INSTANCE;
        goto L50
    L69:
        return;
    }

    public a(C0183a r10) {
        Intrinsics.checkNotNullParameter(r10, "builder");
        this.a = r10;
        View r0 = LayoutInflater.from(r10.a).inflate(2131558672, null);
        this.c = r0;
        View r1 = r0.findViewById(2131382759);
        if (r1 == null) goto L5;
        GradientDrawable r3 = new GradientDrawable();
        r3.setCornerRadius(d);
        r3.setColor(ContextCompat.getColorStateList(r10.a, 2131100363));
        r3.setStroke(1, ContextCompat.getColor(r10.a, 2131099895));
        r1.setBackground(r3);
        Resources r4 = Resources.getSystem();
        r1.setElevation(TypedValue.applyDimension(1, 10, WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics())));
        Resources r5 = Resources.getSystem();
        r1.setOutlineProvider(new d(-MathKt.roundToInt(TypedValue.applyDimension(1, 5, WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics())))));
    L5:
        TextView r2 = (TextView) r0.findViewById(2131390853);
        if (r2 == null) goto L13;
        Function1<? super TextView, Unit> r6 = r10.d;
        if (r6 == null) goto L10;
        r6.invoke(r2);
    L10:
        String r7 = r10.c;
        if (r7 == null) goto L13;
        r2.setText(r7);
    L13:
        TextView r8 = (TextView) r0.findViewById(2131391310);
        int r9 = 8;
        if (r8 == null) goto L31;
        Function1<? super TextView, Unit> r11 = r10.g;
        if (r11 == null) goto L18;
        r11.invoke(r8);
    L18:
        String r12 = r10.f;
        if (r12 == null) goto L21;
        r8.setText(r12);
    L21:
        CharSequence r13 = r8.getText();
        if (r13 != null) goto L24;
    L27:
        boolean r14 = true;
    L28:
        if (r14 == false) goto L30;
        r8.setVisibility(8);
        goto L31
    L30:
        r8.setVisibility(0);
        goto L31
    L24:
        if (r13.length() == 0) goto L27;
        r14 = false;
    L31:
        ImageView r15 = (ImageView) r0.findViewById(2131376346);
        if (r15 == null) goto L36;
        Drawable r16 = r10.b;
        if (r16 == null) goto L36;
        r15.setImageDrawable(r16);
    L36:
        ImageView r17 = (ImageView) r0.findViewById(2131376557);
        if (r17 == null) goto L45;
        Drawable r18 = r10.e;
        if (r18 == null) goto L42;
        r17.setImageDrawable(r18);
    L42:
        if (r17.getDrawable() == null) goto L44;
        r9 = 0;
    L44:
        r17.setVisibility(r9);
    L45:
        int r19 = r10.n;
        int r20 = r10.o;
        Resources r21 = Resources.getSystem();
        PopupWindow r22 = new PopupWindow(r0, r19, r20 + MathKt.roundToInt(TypedValue.applyDimension(1, 20, WindowDisplayMetricsOverride.apply(r21, r21.getDisplayMetrics()))), true);
        this.b = r22;
        r22.setOutsideTouchable(r10.q);
        r22.setFocusable(r10.p);
        r22.setBackgroundDrawable(new ColorDrawable(0));
        Integer r110 = r10.r;
        if (r110 == null) goto L49;
        r22.setAnimationStyle(r110.intValue());
        return;
    }
}
