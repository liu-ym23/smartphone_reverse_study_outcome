package om3;

import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.bytedance.android.livesdk.chatroom.view.k;
import com.bytedance.android.uicomponent.popover.PopLayout;
import com.bytedance.android.uicomponent.popover.PopTextView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public class e extends PopupWindow {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f524256n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f524257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f524258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f524259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f524260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f524261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PopLayout f524262f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PopTextView f524263g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f524264h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f524265i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AnimatorSet f524266j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Context f524267k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public c f524268l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Runnable f524269m;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f524270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f524271b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f524272c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f524273d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f524274e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f524275f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f524276g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f524277h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public c f524278i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f524279j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final float f524280k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f524281l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f524282m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final float f524283n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final Context f524284o;

        public final Context getContext() {
            return this.f524284o;
        }

        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f524284o = r100;
            this.f524270a = r100.getResources().getColor(R.color.ttlive_std_bg_tooltip);
            this.f524271b = r100.getResources().getColor(R.color.ttlive_std_bg_tooltip);
            this.f524273d = 5000;
            this.f524274e = "";
            this.f524275f = 220.0f;
            this.f524276g = r100.getResources().getDimensionPixelSize(R.dimen.uicomponent_popover_text_size);
            this.f524277h = r100.getResources().getColor(R.color.ttlive_std_text_tooltip);
            this.f524279j = true;
            this.f524280k = r100.getResources().getDimensionPixelSize(R.dimen.uicomponent_popover_horizontal_padding);
            this.f524281l = true;
            this.f524282m = r100.getResources().getColor(R.color.ttlive_std_line_3);
            this.f524283n = r100.getResources().getDimensionPixelSize(R.dimen.uicomponent_popover_border_radius);
        }
    }

    public static final class b {
    }

    public interface c {
        void bubbleDismiss();
    }

    static {
    }

    public final void b() {
        if (this.f524264h == true) goto L9;
        PopLayout r100 = this.f524262f;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L7:
        r100.setVisibility(8);
        c();
        getContentView().removeCallbacks(this.f524269m);
        return;
    }

    public final void c() {
        AnimatorSet r100 = this.f524266j;
        if (r100 == null) goto L5;
        r100.removeAllListeners();
    L5:
        AnimatorSet r101 = this.f524266j;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        this.f524266j = null;
        if (isShowing() == true) goto L14;
        return;
    L14:
        PopupWindowLancet.handleDismissBeforeOrigin(this);     // Catch: Exception -> L13
        super.dismiss();     // Catch: Exception -> L13
        return;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (this.f524264h == true) goto L6;
        a(false);
        getContentView().removeCallbacks(this.f524269m);
        return;
    }

    public e(k.a r110) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        this.f524260d = 5000;
        Context r100 = r110.getContext();
        this.f524267k = r100;
        this.f524257a = 0;
        this.f524258b = 0.0f;
        int r101 = r110.f524270a;
        int r102 = r110.f524271b;
        boolean r103 = r110.f524272c;
        this.f524259c = false;
        this.f524260d = r110.f524273d;
        String r104 = r110.f524274e;
        float r105 = r110.f524275f;
        float r106 = r110.f524276g;
        int r107 = r110.f524277h;
        this.f524268l = r110.f524278i;
        boolean r108 = r110.f524279j;
        float r111 = r110.f524280k;
        boolean r112 = r110.f524281l;
        int r113 = r110.f524282m;
        float r114 = r110.f524283n;
        fm3.e.a(r100, 3.0f);
        setWidth(-2);
        setHeight(-2);
        setFocusable(false);
        setOutsideTouchable(r112);
        setClippingEnabled(false);
        setBackgroundDrawable(new ColorDrawable(0));
        setInputMethodMode(1);
        setSoftInputMode(16);
        PopTextView r109 = new PopTextView(this.f524267k, null);
        this.f524263g = r109;
        if (r107 == 0) goto L5;
        r109.setTextColor(r107);
    L6:
        PopTextView r115 = this.f524263g;
        if (r115 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L9:
        r115.setTextSize(1, 13.0f);
        PopTextView r116 = this.f524263g;
        if (r116 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L12:
        r116.setTextAlignment(5);
        PopTextView r117 = this.f524263g;
        if (r117 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L15:
        r117.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        PopTextView r118 = this.f524263g;
        if (r118 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L18:
        r118.setGravity(17);
        PopTextView r119 = this.f524263g;
        if (r119 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L21:
        r119.setMaxWidth((int) fm3.e.a(r100, r105));
        PopTextView r120 = this.f524263g;
        if (r120 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L24:
        r120.setMaxLines(2);
        PopTextView r121 = this.f524263g;
        if (r121 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L27:
        PopLayout r122 = new PopLayout(r100);
        this.f524262f = r122;
        r122.setBackgroundColor(0);
        PopLayout r123 = this.f524262f;
        if (r123 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L30:
        r123.addView(r121);
        PopLayout r124 = this.f524262f;
        if (r124 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L33:
        r124.setGravity(17);
        ViewGroup.MarginLayoutParams r125 = new ViewGroup.MarginLayoutParams(-2, -2);
        PopLayout r126 = this.f524262f;
        if (r126 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L36:
        r126.setLayoutParams(r125);
        PopLayout r127 = this.f524262f;
        if (r127 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L39:
        r127.setVisibility(8);
        if (r101 == 0) goto L45;
        PopLayout r128 = this.f524262f;
        if (r128 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L44:
        r128.setMBgColor(r101);
    L45:
        PopLayout r129 = this.f524262f;
        if (r129 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L48:
        r129.setMNeedPath(r103);
        PopLayout r130 = this.f524262f;
        if (r130 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L51:
        r130.setMNeedArrow(r108);
        PopLayout r131 = this.f524262f;
        if (r131 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L54:
        r131.setMNeedPressFade(false);
        PopLayout r132 = this.f524262f;
        if (r132 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L57:
        r132.setMNeedShadow(false);
        PopLayout r133 = this.f524262f;
        if (r133 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L60:
        r133.setMShadowColor(r113);
        PopLayout r134 = this.f524262f;
        if (r134 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L63:
        r134.setOnClickListener(new h(this));
        PopLayout r135 = this.f524262f;
        if (r135 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L66:
        setContentView(r135);
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        int r136 = 1;
        this.f524259c = true;
        if (TextUtils.isEmpty(r104) == true) goto L73;
        PopTextView r137 = this.f524263g;
        if (r137 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L71:
        r137.setText(r104);
    L73:
        if (r106 == 0.0f) goto L78;
        PopTextView r138 = this.f524263g;
        if (r138 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L77:
        r138.setTextSize(0, r106);
    L78:
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        boolean r139 = this.f524259c;
        if (r139 == false) goto L83;
        if (r139 == false) goto L83;
        getContentView().setSystemUiVisibility(4102);
    L83:
        if (r101 == 0) goto L88;
        PopLayout r140 = this.f524262f;
        if (r140 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L87:
        r140.setMBgColor(r101);
    L88:
        if (r102 == 0) goto L93;
        PopLayout r141 = this.f524262f;
        if (r141 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L92:
        r141.setMBorderColor(r102);
    L93:
        PopLayout r142 = this.f524262f;
        if (r142 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L96:
        r142.setNeedAddColor(false);
        PopLayout r143 = this.f524262f;
        if (r143 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L99:
        r143.setMNeedPath(r103);
        PopLayout r144 = this.f524262f;
        if (r144 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L102:
        int r145 = this.f524257a;
        if (r145 != 3) goto L105;
        r136 = 2;
    L114:
        r144.setBubbleOrientation(r136);
        if (r111 == 0.0f) goto L121;
        PopLayout r146 = this.f524262f;
        if (r146 != null) goto L119;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L119:
        r146.setMPadding(r111);
    L121:
        if (r114 == 0.0f) goto L126;
        PopLayout r147 = this.f524262f;
        if (r147 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L125:
        r147.setMCornerRadius(r114);
    L126:
        this.f524269m = new g(this);
        return;
    L105:
        if (r145 == 5) goto L114;
        if (r145 != 48) goto L109;
        r136 = 3;
        goto L114
    L109:
        if (r145 != 80) goto L114;
        r136 = 0;
        goto L114
    L5:
        r109.setTextColor(r100.getResources().getColor(R.color.ttlive_std_text_tooltip));
        goto L6
    }

    public final void a(boolean r100) {
        PopLayout r101 = this.f524262f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L5:
        if (r100 == true) goto L7;
        this.f524264h = true;
    L7:
        this.f524266j = new AnimatorSet();
        if (r101 == null) goto L11;
        r101.post(new f(this, r101, r100));
        return;
    }

    public final void d(View r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getWindowToken() == null) goto L29;
        r100.getMeasuredHeight();
        r100.getMeasuredWidth();
        getContentView().removeCallbacks(this.f524269m);
        this.f524257a = 80;
        PopLayout r101 = this.f524262f;
        if (r101 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L9:
        this.f524265i = r101.getPADDING();
        if (isShowing() == true) goto L24;
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        if (this.f524261e == true) goto L14;
        this.f524258b += this.f524265i * 8;
        this.f524261e = true;
    L14:
        PopLayout r102 = this.f524262f;
        if (r102 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L17:
        r102.f187731s = 0.0f + this.f524258b;
        r102.f187732t = 0;
        r100.getLocationOnScreen(new int[2]);
        int r103 = ((int) fm3.e.a(this.f524267k, 1.4f)) + 0;
        int r104 = ((int) fm3.e.a(this.f524267k, 1.3f)) + 0;
        k r105 = (k) this;
        OverlaySource r106 = PopupWindowLancet.resolveSource(r100);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r105, r100, r106) == true) goto L21;
        r105.showAsDropDown(r100, r103, r104);
        PopupWindowLancet.trackAfterShow(r105, r106, r100);
    L21:
        a(true);
        this.f524264h = false;
        if (this.f524260d <= 0) goto L27;
        getContentView().postDelayed(this.f524269m, this.f524260d);
        return;
    L27:
        return;
    L24:
        PopupWindowLancet.handleDismissBeforeOrigin(this);
        super.dismiss();
        return;
    }

    @Override // android.widget.PopupWindow
    public final void showAtLocation(View r100, int r101, int r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (PopupWindowLancet.hasSubWindowToken(r100) == false) goto L7;
    L13:
        a(true);     // Catch: Exception -> L15
        return;
    L7:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(this) == false) goto L9;
        super.showAtLocation(r100, r101, r110, r111);     // Catch: Exception -> L15
        goto L13
    L9:
        OverlaySource r102 = PopupWindowLancet.resolveSource(r100);     // Catch: Exception -> L15
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(this, r100, r102, r101, r110, r111) == true) goto L13;
        super.showAtLocation(r100, r101, r110, r111);     // Catch: Exception -> L15
        PopupWindowLancet.trackAfterShow(this, r102, r100);     // Catch: Exception -> L15
    }
}
