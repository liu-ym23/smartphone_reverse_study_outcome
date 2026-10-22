package wx3;

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
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float f561791d = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C8171a f561792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PopupWindow f561793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f561794c;

    /* JADX INFO: renamed from: wx3.a$a, reason: collision with other inner class name */
    public static final class C8171a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Activity f561795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Drawable f561796b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f561797c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Function1<? super TextView, Unit> f561798d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Drawable f561799e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f561800f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Function1<? super TextView, Unit> f561801g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public View f561802h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f561803i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f561804j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f561805k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final long f561806l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public b f561807m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f561808n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f561809o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f561810p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f561811q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final Integer f561812r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final boolean f561813s;

        public C8171a(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f561795a = r100;
            this.f561803i = 81;
            this.f561805k = (int) n0.a(r100, 12.0f);
            this.f561806l = 5000;
            this.f561808n = d0.d(r100);
            this.f561809o = (int) n0.a(r100, 40.0f);
            this.f561810p = true;
            this.f561812r = Integer.valueOf(R.style.aos_collection_notice_style_fade_in);
            this.f561813s = true;
        }
    }

    public interface b {
        void a(a r100);

        void b(a r100);

        void c(a r100);

        void d(a r100);
    }

    public static final class c {
    }

    public final class d extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f561814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f561815b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f561816c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Rect f561817d;

        public d(int r100) {
            this.f561814a = r100;
            this.f561815b = 1.0f;
            this.f561816c = 0.9f;
            this.f561817d = new Rect();
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            if (r100 == null) goto L6;
            Drawable r102 = r100.getBackground();
            if (r102 == null) goto L6;
            r102.copyBounds(this.f561817d);
        L6:
            Rect r103 = this.f561817d;
            float r104 = this.f561815b;
            boolean r105 = true;
            if (r104 != 1.0f) goto L9;
            boolean r106 = true;
        L11:
            if (r106 == true) goto L13;
            r103.left = (int) ((r103.left * r104) + 0.5f);
            r103.right = (int) ((r103.right * r104) + 0.5f);
        L13:
            float r107 = this.f561816c;
            if (r107 == 1.0f) goto L17;
            r105 = false;
        L17:
            if (r105 == true) goto L19;
            r103.top = (int) ((r103.top * r107) + 0.5f);
            r103.bottom = (int) ((r103.bottom * r107) + 0.5f);
        L19:
            r103.offset(0, this.f561814a);
            if (r101 == null) goto L22;
            r101.setRoundRect(this.f561817d, a.f561791d);
        L22:
            if (r101 == null) goto L26;
            r101.setAlpha(0.5f);
            return;
        L26:
            return;
        L9:
            r106 = false;
            goto L11
        }
    }

    public final class e extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f561818a;

        @Override // android.os.CountDownTimer
        public final void onTick(long r100) {
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            this.f561818a.a();
        }

        public e(a r100, long r101, long r102) {
            this.f561818a = r100;
            super(r101, r102);
        }
    }

    static {
        Resources r100 = Resources.getSystem();
        f561791d = TypedValue.applyDimension(1, 12, WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()));
    }

    public final void a() {
        if (this.f561793b.isShowing() == true) goto L5;
        return;
    L5:
        b r100 = this.f561792a.f561807m;
        if (r100 == null) goto L9;
        r100.a(this);
    L9:
        if (this.f561792a.f561795a.isFinishing() == false) goto L12;
    L13:
        boolean r101 = false;
    L15:
        if (r101 == true) goto L23;
    L19:
        b r102 = this.f561792a.f561807m;
        if (r102 == null) goto L25;
        r102.c(this);
        return;
    L25:
        return;
    L23:
        PopupWindow r103 = this.f561793b;     // Catch: Exception -> L18
        PopupWindowLancet.handleDismissBeforeOrigin(r103);     // Catch: Exception -> L18
        r103.dismiss();     // Catch: Exception -> L18
    L18:
        AoLogger.c("InteractivePopView", new Object[]{"popWindow dismiss failure"});
        goto L19
    L12:
        if (this.f561792a.f561795a.isDestroyed() == true) goto L13;
        r101 = true;
        goto L15
    }

    public final void b() {
        if (this.f561793b.isShowing() == true) goto L65;
        C8171a r100 = this.f561792a;
        if (r100.f561806l > 0) goto L7;
        return;
    L7:
        if (r100.f561795a.isFinishing() == false) goto L9;
        return;
    L9:
        if (this.f561792a.f561795a.isDestroyed() == true) goto L69;
        b r101 = this.f561792a.f561807m;
        if (r101 == null) goto L15;
        r101.d(this);
    L15:
        if (this.f561792a.f561806l == Long.MAX_VALUE) goto L21;
        long r102 = this.f561792a.f561806l;
        if ((r102 / ((long) 10)) != 0) goto L19;
        long r103 = 1;
    L20:
        new e(this, r102, r103).start();
        goto L21
    L19:
        r103 = (long) Math.pow(10.0d, ((int) Math.log10(r102)) - 1);
    L21:
        C8171a r104 = this.f561792a;
        View r105 = r104.f561802h;
        boolean r106 = true;
        if (r105 == null) goto L27;
        PopupWindow r107 = this.f561793b;
        int r108 = r104.f561804j;
        int r109 = (-Math.abs(r104.f561805k)) - this.f561792a.f561809o;
        Resources r110 = Resources.getSystem();
        int r111 = r109 - MathKt.roundToInt(TypedValue.applyDimension(1, 12, WindowDisplayMetricsOverride.apply(r110, r110.getDisplayMetrics())));
        OverlaySource r112 = PopupWindowLancet.resolveSource(r105);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r107, r105, r112) == true) goto L50;
        r107.showAsDropDown(r105, r108, r111, 81);
        PopupWindowLancet.trackAfterShow(r107, r112, r105);
    L50:
        if (this.f561792a.f561813s == false) goto L61;
        TextView r113 = (TextView) this.f561794c.findViewById(R.id.tv_left);
        if (r113 == null) goto L61;
        r113.requestFocus();
        r113.sendAccessibilityEvent(8);
        CharSequence r114 = r113.getText();
        if (r114 != null) goto L56;
    L59:
        if (r106 == true) goto L61;
        r113.announceForAccessibility(r113.getText());
        goto L61
    L56:
        if (r114.length() == 0) goto L59;
        r106 = false;
    L61:
        b r115 = this.f561792a.f561807m;
        if (r115 == null) goto L68;
        r115.b(this);
        return;
    L68:
        return;
    L27:
        Activity r116 = r104.f561795a;
        View r117 = null;
        if ((r116 instanceof Activity) == true) goto L31;
        r116 = null;
    L31:
        if (r116 == null) goto L47;
        View r118 = r116.findViewById(android.R.id.content);
        if (r118 == null) goto L47;
        PopupWindow r119 = this.f561793b;
        C8171a r120 = this.f561792a;
        int r121 = r120.f561803i;
        int r122 = r120.f561804j;
        int r123 = r120.f561805k;
        if (PopupWindowLancet.hasSubWindowToken(r118) == false) goto L38;
    L46:
        r117 = r118;
        goto L47
    L38:
        if ((r119 instanceof PopupWindow) == true) goto L40;
    L42:
        OverlaySource r124 = PopupWindowLancet.resolveSource(r118);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r119, r118, r124, r121, r122, r123) == true) goto L46;
        r119.showAtLocation(r118, r121, r122, r123);
        PopupWindowLancet.trackAfterShow(r119, r124, r118);
        goto L46
    L40:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r119) == false) goto L42;
        r119.showAtLocation(r118, r121, r122, r123);
    L47:
        if (r117 != null) goto L50;
        AoLogger.c("InteractivePopView", new Object[]{"both anchorView and parentView are null"});
        Unit r125 = Unit.INSTANCE;
        goto L50
    L69:
        return;
    }

    public a(C8171a r110) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        this.f561792a = r110;
        View r100 = LayoutInflater.from(r110.f561795a).inflate(R.layout.aos_layout_interactive_pop_view, null);
        this.f561794c = r100;
        View r101 = r100.findViewById(R.id.pop_view_content);
        if (r101 == null) goto L5;
        GradientDrawable r102 = new GradientDrawable();
        r102.setCornerRadius(f561791d);
        r102.setColor(ContextCompat.getColorStateList(r110.f561795a, R.color.aos_white_ff));
        r102.setStroke(1, ContextCompat.getColor(r110.f561795a, R.color.LineTertiary));
        r101.setBackground(r102);
        Resources r103 = Resources.getSystem();
        r101.setElevation(TypedValue.applyDimension(1, 10, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics())));
        Resources r104 = Resources.getSystem();
        r101.setOutlineProvider(new d(-MathKt.roundToInt(TypedValue.applyDimension(1, 5, WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics())))));
    L5:
        TextView r105 = (TextView) r100.findViewById(R.id.tv_left);
        if (r105 == null) goto L13;
        Function1<? super TextView, Unit> r106 = r110.f561798d;
        if (r106 == null) goto L10;
        r106.invoke(r105);
    L10:
        String r107 = r110.f561797c;
        if (r107 == null) goto L13;
        r105.setText(r107);
    L13:
        TextView r108 = (TextView) r100.findViewById(R.id.tv_right);
        int r109 = 8;
        if (r108 == null) goto L31;
        Function1<? super TextView, Unit> r111 = r110.f561801g;
        if (r111 == null) goto L18;
        r111.invoke(r108);
    L18:
        String r112 = r110.f561800f;
        if (r112 == null) goto L21;
        r108.setText(r112);
    L21:
        CharSequence r113 = r108.getText();
        if (r113 != null) goto L24;
    L27:
        boolean r114 = true;
    L28:
        if (r114 == false) goto L30;
        r108.setVisibility(8);
        goto L31
    L30:
        r108.setVisibility(0);
        goto L31
    L24:
        if (r113.length() == 0) goto L27;
        r114 = false;
    L31:
        ImageView r115 = (ImageView) r100.findViewById(R.id.iv_left);
        if (r115 == null) goto L36;
        Drawable r116 = r110.f561796b;
        if (r116 == null) goto L36;
        r115.setImageDrawable(r116);
    L36:
        ImageView r117 = (ImageView) r100.findViewById(R.id.iv_right);
        if (r117 == null) goto L45;
        Drawable r118 = r110.f561799e;
        if (r118 == null) goto L42;
        r117.setImageDrawable(r118);
    L42:
        if (r117.getDrawable() == null) goto L44;
        r109 = 0;
    L44:
        r117.setVisibility(r109);
    L45:
        int r119 = r110.f561808n;
        int r120 = r110.f561809o;
        Resources r121 = Resources.getSystem();
        PopupWindow r122 = new PopupWindow(r100, r119, r120 + MathKt.roundToInt(TypedValue.applyDimension(1, 20, WindowDisplayMetricsOverride.apply(r121, r121.getDisplayMetrics()))), true);
        this.f561793b = r122;
        r122.setOutsideTouchable(r110.f561811q);
        r122.setFocusable(r110.f561810p);
        r122.setBackgroundDrawable(new ColorDrawable(0));
        Integer r123 = r110.f561812r;
        if (r123 == null) goto L49;
        r122.setAnimationStyle(r123.intValue());
        return;
    }
}
