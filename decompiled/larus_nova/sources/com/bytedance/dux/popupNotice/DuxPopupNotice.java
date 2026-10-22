package com.bytedance.dux.popupNotice;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import com.bytedance.dux.button.DuxButton;
import com.bytedance.dux.common.DuxConfig;
import com.bytedance.dux.common.PadAdaptScene;
import com.bytedance.dux.window.controller.DuxBreakPointController;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttm.player.MediaPlayer;
import em4.g;
import em4.n;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
public final class DuxPopupNotice {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final float f205488i = 0.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f205489j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final INoticeGlobalInterceptor f205490k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Function2<Context, hm4.d, Integer> f205491l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Function2<Context, hm4.d, Integer> f205492m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Lambda f205493n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f205494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PopupWindow f205495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f205496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f205497d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f205498e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f205499f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f f205500g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.dux.window.controller.a f205501h;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/dux/popupNotice/DuxPopupNotice$HideReason;", "", "HIDE_AUTO", "HIDE_MANUAL", "HIDE_CONFLICT", "dux_release"}, k = 1, mv = {1, 7, 1})
    public static final enum HideReason extends Enum<HideReason> {
        public static final HideReason HIDE_AUTO = null;
        public static final HideReason HIDE_CONFLICT = null;
        public static final HideReason HIDE_MANUAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ HideReason[] f205502a = null;

        public static HideReason valueOf(String r100) {
            return (HideReason) r27.a.a(HideReason.class, r100);
        }

        public static HideReason[] values() {
            return (HideReason[]) f205502a.clone();
        }

        static {
            HideReason r100 = new HideReason("HIDE_AUTO", 0);
            HIDE_AUTO = r100;
            HideReason r101 = new HideReason("HIDE_MANUAL", 1);
            HIDE_MANUAL = r101;
            HideReason r102 = new HideReason("HIDE_CONFLICT", 2);
            HIDE_CONFLICT = r102;
            f205502a = new HideReason[]{r100, r101, r102};
        }

        public HideReason(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a implements PopupWindow.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DuxPopupNotice f205503a;

        public a(DuxPopupNotice r100) {
            this.f205503a = r100;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            DuxPopupNotice r100 = this.f205503a;
            if (r100.f205499f == true) goto L6;
            r100.f205494a.getClass();
            this.f205503a.f205494a.getClass();
            return;
        }
    }

    public static final class b implements jm4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DuxPopupNotice f205504a;

        public b(DuxPopupNotice r100) {
            this.f205504a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.functions.Function2, kotlin.jvm.internal.Lambda] */
        @Override // jm4.b
        public final void a(hm4.d r110) {
            Intrinsics.checkNotNullParameter(r110, "breakPointUpdate");
            int r111 = ((Number) DuxPopupNotice.f205493n.invoke(this.f205504a.f205494a.f205505a, r110)).intValue();
            this.f205504a.f205496c.measure(View.MeasureSpec.makeMeasureSpec(r111, 1073741824), 0);
            DuxPopupNotice r100 = this.f205504a;
            c r101 = r100.f205494a;
            View r102 = r101.f205509e;
            if (r102 == null) goto L14;
            PopupWindow r103 = r100.f205495b;
            int r104 = r101.f205512h - ((r111 - r102.getWidth()) / 2);
            int r105 = (-Math.abs(r100.f205494a.f205513i)) - r100.f205498e;
            int r112 = r100.f205494a.f205516l;
            if ((r103 instanceof PopupWindow) == false) goto L10;
            if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r103) == false) goto L10;
            r103.update(r102, r104, r105, r111, r112);
            return;
        L10:
            if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r103, r102, r104, r105, r111, r112) == true) goto L48;
            r103.update(r102, r104, r105, r111, r112);
            return;
        L48:
            return;
        L14:
            if (r101.f205510f == null) goto L24;
            PopupWindow r106 = r100.f205495b;
            int r107 = r101.f205512h;
            int r108 = r101.f205513i;
            int r109 = r101.f205516l;
            if ((r106 instanceof PopupWindow) == false) goto L21;
            if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r106) == false) goto L21;
            r106.update(r107, r108, r111, r109);
            return;
        L21:
            if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r106, r107, r108, r111, r109) == true) goto L49;
            r106.update(r107, r108, r111, r109);
            return;
        L49:
            return;
        L24:
            Activity r113 = r101.f205505a;
            if ((r113 instanceof Activity) == true) goto L28;
            r113 = null;
        L28:
            if (r113 != null) goto L30;
            return;
        L30:
            if (r113.findViewById(R.id.content) == null) goto L46;
            DuxPopupNotice r114 = this.f205504a;
            PopupWindow r115 = r114.f205495b;
            c r116 = r114.f205494a;
            int r117 = r116.f205512h;
            int r118 = r116.f205513i;
            int r119 = r116.f205516l;
            if ((r115 instanceof PopupWindow) == false) goto L37;
            if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r115) == false) goto L37;
            r115.update(r117, r118, r111, r119);
            return;
        L37:
            if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r115, r117, r118, r111, r119) == true) goto L50;
            r115.update(r117, r118, r111, r119);
            return;
        L50:
            return;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Activity f205505a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Function1<? super ImageView, Unit> f205506b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Function1<? super TextView, Unit> f205507c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Function1<? super ImageView, Unit> f205508d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public View f205509e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View f205510f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f205511g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f205512h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f205513i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final long f205514j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f205515k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f205516l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f205517m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final Integer f205518n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f205519o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f205520p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final Function0<Unit> f205521q;

        public c(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f205505a = r100;
            this.f205511g = 81;
            Resources r101 = Resources.getSystem();
            this.f205513i = MathKt.roundToInt(TypedValue.applyDimension(1, 12, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics())));
            this.f205514j = 5000;
            int r102 = g.e(r100);
            Resources r103 = Resources.getSystem();
            int r104 = r102 - MathKt.roundToInt(TypedValue.applyDimension(1, 16, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics())));
            float r105 = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEBUG_UI_NOTIFY;
            Resources r106 = Resources.getSystem();
            this.f205515k = Math.min(r104, MathKt.roundToInt(TypedValue.applyDimension(1, r105, WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics()))));
            this.f205516l = -2;
            this.f205517m = true;
            this.f205518n = Integer.valueOf(com.larus.nova.R.style.NoticePopupAnim);
            this.f205519o = true;
            this.f205521q = new DuxPopupNotice$Builder$setDefaultAnchorView$1(this);
        }
    }

    public static final class d {
    }

    public final class e extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f205522a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f205523b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f205524c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Rect f205525d;

        public e() {
            this.f205522a = -4;
            this.f205523b = 1.0f;
            this.f205524c = 0.9f;
            this.f205525d = new Rect();
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            if (r100 == null) goto L6;
            Drawable r102 = r100.getBackground();
            if (r102 == null) goto L6;
            r102.copyBounds(this.f205525d);
        L6:
            Rect r103 = this.f205525d;
            float r104 = this.f205523b;
            boolean r105 = true;
            if (r104 != 1.0f) goto L9;
            boolean r106 = true;
        L11:
            if (r106 == true) goto L13;
            r103.left = (int) ((r103.left * r104) + 0.5f);
            r103.right = (int) ((r103.right * r104) + 0.5f);
        L13:
            float r107 = this.f205524c;
            if (r107 == 1.0f) goto L17;
            r105 = false;
        L17:
            if (r105 == true) goto L19;
            r103.top = (int) ((r103.top * r107) + 0.5f);
            r103.bottom = (int) ((r103.bottom * r107) + 0.5f);
        L19:
            r103.offset(0, this.f205522a);
            if (r101 == null) goto L23;
            r101.setRoundRect(this.f205525d, DuxPopupNotice.f205488i);
            return;
        L23:
            return;
        L9:
            r106 = false;
            goto L11
        }
    }

    public final class f extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DuxPopupNotice f205526a;

        @Override // android.os.CountDownTimer
        public final void onTick(long r100) {
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            this.f205526a.c(HideReason.HIDE_AUTO);
        }

        public f(DuxPopupNotice r100, long r101, long r102) {
            this.f205526a = r100;
            super(r101, r102);
        }
    }

    static {
        f205488i = TypedValue.applyDimension(1, 12, b(Resources.getSystem()));
        f205489j = MathKt.roundToInt(TypedValue.applyDimension(1, 14, b(Resources.getSystem())));
        f205490k = (INoticeGlobalInterceptor) ServiceManager.get().getService(INoticeGlobalInterceptor.class);
        DuxPopupNotice$Companion$COMMON_WIDTH_PROVIDER_IMPL$1 r100 = DuxPopupNotice$Companion$COMMON_WIDTH_PROVIDER_IMPL$1.INSTANCE;
        f205491l = r100;
        DuxPopupNotice$Companion$PAD_WIDTH_PROVIDER_IMPL$1 r101 = DuxPopupNotice$Companion$PAD_WIDTH_PROVIDER_IMPL$1.INSTANCE;
        f205492m = r101;
        Map<PadAdaptScene, Boolean> r102 = DuxConfig.f204897a;
        Lambda r103 = r100;
        if (DuxConfig.a(PadAdaptScene.BOTTOM_NOTICE) == false) goto L5;
        r103 = r101;
    L5:
        f205493n = r103;
    }

    public DuxPopupNotice(c r110) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        this.f205494a = r110;
        ViewGroup.MarginLayoutParams r100 = null;
        View r101 = LayoutInflater.from(r110.f205505a).inflate(com.larus.nova.R.layout.dux_popup_notice, null);
        this.f205496c = r101;
        this.f205497d = "";
        r101.findViewById(com.larus.nova.R.id.pop_view_content);
        if (r110.f205520p == false) goto L5;
        int r102 = MathKt.roundToInt(TypedValue.applyDimension(1, 20 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f), b(Resources.getSystem())));
    L6:
        FrameLayout r103 = (FrameLayout) r101.findViewById(com.larus.nova.R.id.fl_left_container);
        if (r103 == null) goto L35;
        r103.removeAllViews();
        ImageView r104 = new ImageView(r110.f205505a);
        r104.setLayoutParams(new ViewGroup.LayoutParams(r102, r102));
        r104.setImageTintList(ContextCompat.getColorStateList(r110.f205505a, com.larus.nova.R.color.TextReverse));
        r104.setImageResource(com.larus.nova.R.drawable.ic_s_s_checkmarkcircle_filled_20);
        Function1<? super ImageView, Unit> r111 = r110.f205506b;
        if (r111 == null) goto L11;
        r111.invoke(r104);
    L11:
        n.g(r104);
        r103.addView(r104);
        Iterator<View> r112 = ViewGroupKt.getChildren(r103).iterator();
    L13:
        if (r112.hasNext() == false) goto L20;
        View r105 = r112.next();
        if (r105.getVisibility() == 8) goto L17;
        boolean r106 = true;
    L18:
        if (r106 == false) goto L13;
    L21:
        if (r105 != null) goto L23;
        boolean r113 = true;
    L24:
        if (r113 == true) goto L27;
        r103 = null;
    L27:
        if (r103 == null) goto L35;
        ViewGroup.LayoutParams r114 = r103.getLayoutParams();
        if ((r114 instanceof ViewGroup.MarginLayoutParams) == false) goto L31;
        ViewGroup.MarginLayoutParams r115 = (ViewGroup.MarginLayoutParams) r114;
    L32:
        if (r115 == null) goto L34;
        r115.setMarginStart(MathKt.roundToInt(TypedValue.applyDimension(1, 8, b(Resources.getSystem()))));
        r100 = r115;
    L34:
        r103.setLayoutParams(r100);
        goto L35
    L31:
        r115 = null;
        goto L32
    L23:
        r113 = false;
        goto L24
    L17:
        r106 = false;
        goto L18
    L20:
        r105 = null;
    L35:
        TextView r116 = (TextView) this.f205496c.findViewById(com.larus.nova.R.id.tv_left);
        if (r116 == null) goto L41;
        this.f205494a.getClass();
        r116.setTextColor(ContextCompat.getColorStateList(this.f205494a.f205505a, com.larus.nova.R.color.TextReverse));
        this.f205494a.getClass();
        Function1<? super TextView, Unit> r107 = this.f205494a.f205507c;
        if (r107 == null) goto L40;
        r107.invoke(r116);
    L40:
        this.f205494a.getClass();
        this.f205497d += r116.getText();
    L41:
        TextView r117 = (TextView) this.f205496c.findViewById(com.larus.nova.R.id.tv_left_subtitle);
        if (r117 == null) goto L54;
        this.f205494a.getClass();
        r117.setTextColor(ContextCompat.getColorStateList(this.f205494a.f205505a, com.larus.nova.R.color.TextReverse2));
        this.f205494a.getClass();
        this.f205494a.getClass();
        this.f205494a.getClass();
        CharSequence r108 = r117.getText();
        if (r108 != null) goto L46;
    L49:
        boolean r109 = true;
    L50:
        if (r109 == false) goto L52;
        int r118 = 8;
    L53:
        r117.setVisibility(r118);
        this.f205497d += r117.getText();
        goto L54
    L52:
        r118 = 0;
        goto L53
    L46:
        if (r108.length() == 0) goto L49;
        r109 = false;
    L54:
        ViewStub r119 = (ViewStub) this.f205496c.findViewById(com.larus.nova.R.id.vs_right_container);
        if (r119 == null) goto L57;
        this.f205494a.getClass();
        r119.setLayoutResource(com.larus.nova.R.layout.dux_popup_notice_r_text);
        r119.inflate();
    L57:
        DuxButton r120 = (DuxButton) this.f205496c.findViewById(com.larus.nova.R.id.tv_right);
        if (r120 == null) goto L70;
        this.f205494a.getClass();
        r120.setClickable(false);
        this.f205494a.getClass();
        this.f205494a.getClass();
        CharSequence r121 = r120.getText();
        if (r121 != null) goto L62;
    L65:
        boolean r122 = true;
    L66:
        if (r122 == false) goto L68;
        int r123 = 8;
    L69:
        r120.setVisibility(r123);
        this.f205497d += r120.getText();
        goto L70
    L68:
        r123 = 0;
        goto L69
    L62:
        if (r121.length() == 0) goto L65;
        r122 = false;
    L70:
        ImageView r124 = (ImageView) this.f205496c.findViewById(com.larus.nova.R.id.iv_right);
        if (r124 == null) goto L80;
        this.f205494a.getClass();
        r124.setImageTintList(ContextCompat.getColorStateList(this.f205494a.f205505a, com.larus.nova.R.color.TextReverse));
        this.f205494a.getClass();
        Function1<? super ImageView, Unit> r125 = this.f205494a.f205508d;
        if (r125 == null) goto L75;
        r125.invoke(r124);
    L75:
        this.f205494a.getClass();
        if (r124.getDrawable() == null) goto L78;
        int r126 = 0;
    L79:
        r124.setVisibility(r126);
        n.a(r124, MathKt.roundToInt(TypedValue.applyDimension(1, 44, b(Resources.getSystem()))));
        goto L80
    L78:
        r126 = 8;
    L80:
        this.f205496c.setMinimumHeight(r102 + (f205489j * 2));
        if (this.f205494a.f205520p == false) goto L90;
        TextView r127 = (TextView) this.f205496c.findViewById(com.larus.nova.R.id.tv_left);
        if (r127 == null) goto L86;
        com.bytedance.dux.largefont.a.c(r127, 15.0f);
    L86:
        TextView r128 = (TextView) this.f205496c.findViewById(com.larus.nova.R.id.tv_left_subtitle);
        if (r128 == null) goto L89;
        com.bytedance.dux.largefont.a.c(r128, 13.0f);
    L89:
        DuxButton r129 = (DuxButton) this.f205496c.findViewById(com.larus.nova.R.id.tv_right);
        ImageView r130 = (ImageView) this.f205496c.findViewById(com.larus.nova.R.id.iv_right);
        this.f205494a.getClass();
        com.bytedance.dux.largefont.a.c(r129, 15.0f);
        com.bytedance.dux.largefont.a.a(r130, 12, 12);
    L90:
        this.f205496c.measure(View.MeasureSpec.makeMeasureSpec(this.f205494a.f205515k, 1073741824), 0);
        int r131 = this.f205496c.getMeasuredHeight();
        this.f205498e = r131;
        em4.e.a("DuxPopupNotice: check innerHeightOfPopV=" + r131);
        View r132 = this.f205496c;
        c r133 = this.f205494a;
        PopupWindow r134 = new PopupWindow(r132, r133.f205515k, r133.f205516l);
        this.f205495b = r134;
        this.f205494a.getClass();
        r134.setOutsideTouchable(false);
        this.f205494a.getClass();
        r134.setFocusable(false);
        Integer r135 = this.f205494a.f205518n;
        if (r135 == null) goto L93;
        Intrinsics.checkNotNull(r135);
        r134.setAnimationStyle(r135.intValue());
    L94:
        r134.setElevation(TypedValue.applyDimension(1, 8, b(Resources.getSystem())));
        View r136 = this.f205496c;
        GradientDrawable r137 = new GradientDrawable();
        r137.setCornerRadius(f205488i);
        this.f205494a.getClass();
        r137.setColor(ContextCompat.getColorStateList(this.f205494a.f205505a, com.larus.nova.R.color.BGReverse));
        r137.setStroke(1, ContextCompat.getColor(this.f205494a.f205505a, com.larus.nova.R.color.LineTertiary));
        r136.setBackground(r137);
        this.f205496c.setOutlineProvider(new e());
        this.f205494a.getClass();
        this.f205494a.getClass();
        r134.setOnDismissListener(new a(this));
        this.f205494a.getClass();
        gm4.a.b(new hm4.c(this.f205496c), new b(this));
        this.f205501h = com.bytedance.dux.window.controller.a.f205935a;
        return;
    L93:
        r134.setAnimationStyle(0);
        goto L94
    L5:
        r102 = MathKt.roundToInt(TypedValue.applyDimension(2, 20, b(Resources.getSystem())));
        goto L6
    }

    public static DisplayMetrics b(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public final void c(HideReason r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        if (this.f205495b.isShowing() == true) goto L5;
        return;
    L5:
        this.f205499f = true;
        this.f205494a.getClass();
        this.f205494a.getClass();
        PopupWindow r101 = this.f205495b;     // Catch: Exception -> L8
        PopupWindowLancet.handleDismissBeforeOrigin(r101);     // Catch: Exception -> L8
        r101.dismiss();     // Catch: Exception -> L8
    L10:
        f r102 = this.f205500g;
        if (r102 == null) goto L13;
        r102.cancel();
    L13:
        DuxBreakPointController r103 = gm4.a.f481672a;
        com.bytedance.dux.window.controller.a r104 = this.f205501h;
        if (r104 == null) goto L17;
        gm4.a.f481672a.a(r104);
    L17:
        this.f205494a.getClass();
        this.f205494a.getClass();
        return;
    L8:
        e = move-exception;
        int r105 = em4.d.f473061a;
        em4.d.b("DuxPopupNotice", "hide: " + e.getMessage());
        goto L10
    }

    public static void a(PopupWindow r100, View r101, int r102, int r110, int r111) {
        if (PopupWindowLancet.hasSubWindowToken(r101) == false) goto L6;
        return;
    L6:
        if ((r100 instanceof PopupWindow) == true) goto L8;
    L11:
        OverlaySource r103 = PopupWindowLancet.resolveSource(r101);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r100, r101, r103, r102, r110, r111) == false) goto L14;
        return;
    L14:
        r100.showAtLocation(r101, r102, r110, r111);
        PopupWindowLancet.trackAfterShow(r100, r103, r101);
        return;
    L8:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r100) == false) goto L11;
        r100.showAtLocation(r101, r102, r110, r111);
    }
}
