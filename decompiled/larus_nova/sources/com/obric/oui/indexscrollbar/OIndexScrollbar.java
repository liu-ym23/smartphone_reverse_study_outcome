package com.obric.oui.indexscrollbar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.ttnet.org.chromium.net.NetError;
import dma.g;
import dma.h;
import dma.i;
import dma.j;
import dma.k;
import dma.l;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0004\u001c!78B\u001b\u0012\u0006\u00102\u001a\u000201\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000103¢\u0006\u0004\b5\u00106J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0013\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0002J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\bJ\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019R\u001a\u0010 \u001a\u00020\u001b8\u0006X\u0086D¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010%\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001a\u0010*\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001a\u0010-\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b+\u0010'\u001a\u0004\b,\u0010)R\u001a\u00100\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b.\u0010'\u001a\u0004\b/\u0010)¨\u00069"}, d2 = {"Lcom/obric/oui/indexscrollbar/OIndexScrollbar;", "Landroid/widget/LinearLayout;", "", "hostWidth", "", "setHostWidth", "state", "setState", "", "showBg", "setLettersBarBg", "visible", "setShadowVisible", "getScreenWidth", "getParentxPos", "Lcom/obric/oui/indexscrollbar/OIndexScrollbar$c;", "listener", "setQBListener", "Lcom/obric/oui/indexscrollbar/OIndexScrollbar$d;", "setSurnameListener", "setPoundVisibility", "position", "setPoundPosition", "enabled", "setLongPressEnabled", "Lcom/obric/oui/indexscrollbar/LettersBar;", "getLetterBar", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/lang/String;", "getOIndexScrollbar_TAG", "()Ljava/lang/String;", "OIndexScrollbar_TAG", "b", "Z", "getOIndexScrollbar_DEBUG", "()Z", "OIndexScrollbar_DEBUG", BaseSwitches.V, "I", "getPOUND_POSITION_TOP", "()I", "POUND_POSITION_TOP", "w", "getPOUND_POSITION_BOTTOM", "POUND_POSITION_BOTTOM", "C", "getVISIBILITY_LIMIT", "VISIBILITY_LIMIT", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "c", "d", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OIndexScrollbar extends LinearLayout {
    public static final /* synthetic */ int E = 0;
    public int A;
    public int B;
    public final int C;
    public boolean D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f401105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f401106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f401107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LettersBar f401108d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public GridView f401109e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f401110f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f401111g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f401112h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f401113i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f401114j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f401115k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f401116l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f401117m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f401118n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f401119o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f401120p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f401121q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f401122r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f401123s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final List<dma.b> f401124t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f401125u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f401126v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f401127w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f401128x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public PopupWindow f401129y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f401130z;

    public final class a extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f401131a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String[] f401132b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f401133c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f401134d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ OIndexScrollbar f401135e;

        @Override // android.widget.Adapter
        public final long getItemId(int r100) {
            return r100;
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            if (this.f401132b != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mAlphabets");
        L5:
            String[] r100 = this.f401132b;
            if (r100 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("mAlphabets");
            r100 = null;
        L9:
            return r100.length;
        }

        public final String a(int r100) {
            String[] r101 = this.f401132b;
            if (r101 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("mAlphabets");
            r101 = null;
        L6:
            return r101[r100];
        }

        @Override // android.widget.Adapter
        public final /* bridge */ /* synthetic */ Object getItem(int r100) {
            return a(r100);
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public final boolean isEnabled(int r100) {
            String[] r101 = dma.a.f469233a;
            String[] r102 = this.f401132b;
            if (r102 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mAlphabets");
            r102 = null;
        L5:
            String r103 = r102[r100];
            Intrinsics.checkNotNullParameter(r103, "alphabet");
            if (Intrinsics.areEqual(".~", r103) == true) goto L19;
            String[] r104 = this.f401132b;
            if (r104 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("mAlphabets");
            r104 = null;
        L10:
            String r105 = r104[r100];
            if (r105 != null) goto L13;
        L15:
            boolean r106 = false;
        L16:
            if (r106 == true) goto L20;
            return true;
        L20:
            return false;
        L13:
            if (StringsKt.startsWith$default(r105, "*", false, 2, null) == false) goto L15;
            r106 = true;
            goto L16
        L19:
            return false;
        }

        public a(OIndexScrollbar r100, Context r101) {
            Intrinsics.checkNotNullParameter(r100, "this$0");
            this.f401135e = r100;
            this.f401131a = r101;
            String r102 = Locale.getDefault().getLanguage();
            String[] r103 = dma.a.f469233a;
            Intrinsics.checkNotNullParameter(r102, "language");
            if (Intrinsics.areEqual(Locale.KOREA.getLanguage(), r102) == false) goto L6;
        L11:
            float r104 = 9.0f;
        L12:
            this.f401133c = r104;
            int r105 = ((int) Math.ceil(r104)) - 1;
            GridView r106 = r100.f401109e;
            Intrinsics.checkNotNull(r106);
            this.f401134d = r105 * r106.getVerticalSpacing();
            return;
        L6:
            if (Intrinsics.areEqual(Locale.JAPAN.getLanguage(), r102) == false) goto L9;
        L10:
            r104 = 12.5f;
            goto L12
        L9:
            if (Intrinsics.areEqual("ru", r102) == false) goto L11;
            goto L10
        }

        @Override // android.widget.Adapter
        public final View getView(int r100, View r110, ViewGroup r111) {
            Intrinsics.checkNotNullParameter(r111, "parent");
            String[] r112 = this.f401132b;
            if (r112 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mAlphabets");
            r112 = null;
        L5:
            String r113 = r112[r100];
            float r101 = this.f401135e.f401117m - this.f401134d;
            float r102 = this.f401133c;
            int r103 = (int) (r101 / r102);
            int r104 = (int) (r101 - (r103 * r102));
            if (r102 != 9.0f) goto L8;
            boolean r105 = true;
        L9:
            if (r105 == true) goto L11;
        L26:
            View r114 = r110;
            if (r110 != null) goto L45;
            String[] r115 = dma.a.f469233a;
            Intrinsics.checkNotNullParameter(r113, "alphabet");
            if (Intrinsics.areEqual(".>", r113) == false) goto L31;
            ImageView r116 = new ImageView(this.f401131a);
            r116.setImageResource(R.drawable.letter_bar_unfold_button);
            r116.setScaleType(ImageView.ScaleType.CENTER);
            r116.setMinimumHeight(r103);
            r114 = r116;
            goto L45
        L31:
            AlphabetView r106 = new AlphabetView(this.f401131a, null, 6, 0);
            r106.setHeight(r103);
            if (StringsKt.startsWith$default(r113, "*", false, 2, null) == false) goto L34;
            boolean r107 = true;
        L35:
            if (r107 == false) goto L37;
            r106.setTextColor(ColorProtector.parseColor("#80000000"));
            r113 = r113.substring(1);
        L37:
            Intrinsics.checkNotNullParameter(r113, "alphabet");
            if (Intrinsics.areEqual(".~", r113) == true) goto L41;
            r106.setText(r113);
        L41:
            if (dma.a.a(r113) == false) goto L43;
            r106.setTypeface(null, 0);
        L43:
            r114 = r106;
            goto L45
        L34:
            r107 = false;
        L45:
            if (((r100 / 3) % 2) != 0) goto L47;
            Context r108 = this.f401131a;
            Intrinsics.checkNotNull(r108);
            Drawable r109 = r108.getResources().getDrawable(R.drawable.quickbar_ex_alphabet_text_light_colorlist);
        L48:
            r114.setBackground(r109);
            return r114;
        L47:
            Context r117 = this.f401131a;
            Intrinsics.checkNotNull(r117);
            r109 = r117.getResources().getDrawable(R.drawable.quickbar_ex_alphabet_text_dark_colorlist);
            goto L48
        L11:
            if (((int) (r101 % r102)) == 0) goto L13;
            boolean r118 = true;
        L14:
            if (r118 == false) goto L26;
            if (r100 != (getCount() - 1)) goto L18;
        L23:
            boolean r119 = true;
        L24:
            if (r119 == false) goto L26;
            r103 = r103 + r104;
            goto L26
        L18:
            if (r100 == (getCount() - 2)) goto L23;
            if (r100 == (getCount() - 3)) goto L23;
            r119 = false;
            goto L24
        L13:
            r118 = false;
            goto L14
        L8:
            r105 = false;
            goto L9
        }
    }

    public static final class b {
    }

    public interface c {
    }

    public interface d {
    }

    public static final class e implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OIndexScrollbar f401136a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "arg0");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "arg0");
        }

        public e(OIndexScrollbar r100) {
            this.f401136a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "arg0");
            OIndexScrollbar r101 = this.f401136a;
            r101.getClass();
            r101.f();
            this.f401136a.getClass();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "arg0");
            this.f401136a.getClass();
        }
    }

    static {
    }

    public final void setQBListener(c r100) {
    }

    public final void setSurnameListener(d r100) {
    }

    private final void getParentxPos() {
        if (this.A == this.f401130z) goto L5;
        return;
    L5:
        Object r100 = getParent();
        if ((r100 instanceof View) == false) goto L9;
        int[] r101 = new int[2];
        ((View) r100).getLocationInWindow(r101);
        this.A = r101[0];
        return;
    }

    private final int getScreenWidth() {
        Point r100 = new Point();
        Context r101 = this.f401107c;
        Intrinsics.checkNotNull(r101);
        Object r102 = r101.getSystemService(LiveEndPageData.TAG_WINDOW);
        if (r102 == null) goto L7;
        ((WindowManager) r102).getDefaultDisplay().getSize(r100);
        return r100.x;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    public final void d() {
        PopupWindow r100 = this.f401129y;
        if (r100 == null) goto L6;
        Intrinsics.checkNotNull(r100);
        PopupWindowLancet.handleDismissBeforeOrigin(r100);
        r100.dismiss();
        this.f401129y = null;
        return;
    }

    public final void f() {
        setState(this.f401118n);
        setX(this.f401112h);
        setLettersBarBg(false);
    }

    public final void e() {
        d();
        AnimatorSet r100 = new AnimatorSet();
        r100.play(ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("x", new float[]{getX(), this.f401112h})}));
        r100.setDuration(200);
        r100.addListener(new e(this));
        r100.start();
    }

    public final LettersBar getLetterBar() {
        return this.f401108d;
    }

    public final boolean getOIndexScrollbar_DEBUG() {
        return this.f401106b;
    }

    public final String getOIndexScrollbar_TAG() {
        return this.f401105a;
    }

    public final int getPOUND_POSITION_BOTTOM() {
        return this.f401127w;
    }

    public final int getPOUND_POSITION_TOP() {
        return this.f401126v;
    }

    public final int getVISIBILITY_LIMIT() {
        return this.C;
    }

    public static final void a(OIndexScrollbar r100) {
        r100.setX(r100.f401113i);
        r100.setState(r100.f401120p);
        r100.setLettersBarBg(true);
    }

    public static final /* synthetic */ void b(OIndexScrollbar r100) {
        r100.setLettersBarBg(true);
    }

    private final void setHostWidth(int r100) {
        int r101 = (r100 - this.f401115k) - this.f401116l;
        this.f401112h = r101;
        int r102 = r100 - this.f401114j;
        this.f401113i = r102;
        int r103 = this.f401121q;
        if (r103 != this.f401118n) goto L6;
        float r104 = r101;
    L9:
        setX(r104);
        if (this.f401106b == false) goto L12;
        Intrinsics.stringPlus("mStartX = ", Integer.valueOf(this.f401112h));
    L12:
        invalidate();
        return;
    L6:
        if (r103 != this.f401120p) goto L8;
        r104 = r102;
        goto L9
    L8:
        r104 = getX();
        goto L9
    }

    private final void setLettersBarBg(boolean r100) {
        LettersBar r101 = this.f401108d;
        Intrinsics.checkNotNull(r101);
        r101.setShowBg(r100);
        setShadowVisible(r100);
    }

    private final void setShadowVisible(boolean r100) {
        View r101 = this.f401110f;
        Intrinsics.checkNotNull(r101);
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 4;
        goto L6
    }

    private final void setState(int r100) {
        this.f401121q = r100;
        LettersBar r101 = this.f401108d;
        Intrinsics.checkNotNull(r101);
        if (r100 != this.f401118n) goto L5;
        boolean r102 = true;
    L6:
        r101.setSettled(r102);
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        String[] r101 = dma.a.f469233a;
        String r102 = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullParameter(r102, "language");
        if (Intrinsics.areEqual(Locale.CHINESE.getLanguage(), r102) == false) goto L6;
    L16:
        boolean r103 = true;
    L18:
        if (r103 == false) goto L20;
        getParentxPos();
        int r104 = r100.getAction();
        r100.getX();
        r100.getY();
        float r105 = r100.getRawX() - this.A;
        if (r104 != 0) goto L24;
        this.f401123s = r105;
        this.f401122r = r105;
    L58:
        boolean r106 = false;
    L59:
        if (r106 == false) goto L61;
        return true;
    L61:
        if (super.dispatchTouchEvent(r100) == true) goto L66;
        return false;
    L66:
        return true;
    L24:
        if (r104 == 1) goto L43;
        if (r104 != 2) goto L27;
        float r107 = this.f401123s;
        this.f401122r = r107;
        this.f401123s = r105;
        int r108 = this.f401121q;
        if (r108 == this.f401118n) goto L58;
        if (r108 == this.f401119o) goto L58;
        if (r108 != this.f401120p) goto L58;
        if ((r105 - r107) <= this.B) goto L58;
        if (r107 <= this.f401113i) goto L58;
    L56:
        r106 = true;
        goto L59
    L27:
        if (r104 != 3) goto L58;
    L43:
        if (getX() != this.f401112h) goto L45;
        boolean r109 = true;
    L46:
        if (r109 == false) goto L49;
        setLettersBarBg(false);
        goto L58
    L49:
        if (this.f401121q != this.f401119o) goto L58;
        if ((this.f401123s - this.f401122r) <= 0.0f) goto L53;
    L55:
        e();
        goto L56
    L53:
        if (getX() >= (getScreenWidth() + NetError.ERR_SSL_PINNED_KEY_NOT_IN_CERT_CHAIN)) goto L55;
        AnimatorSet r110 = new AnimatorSet();
        r110.play(ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("x", new float[]{getX(), this.f401113i})}));
        r110.setDuration(200);
        r110.addListener(new l(this));
        r110.start();
        goto L56
    L45:
        r109 = false;
        goto L46
    L20:
        return super.dispatchTouchEvent(r100);
    L6:
        if (Intrinsics.areEqual(Locale.ENGLISH.getLanguage(), r102) == true) goto L16;
        if (Intrinsics.areEqual(Locale.KOREA.getLanguage(), r102) == true) goto L16;
        if (Intrinsics.areEqual(Locale.JAPAN.getLanguage(), r102) == true) goto L16;
        if (Intrinsics.areEqual("ru", r102) == true) goto L16;
        r103 = false;
        goto L18
    }

    public final void setLongPressEnabled(boolean r100) {
        this.D = r100;
    }

    public final void setPoundPosition(int r100) {
        this.f401128x = r100;
    }

    public final void setPoundVisibility(boolean r100) {
        this.f401125u = r100;
    }

    public OIndexScrollbar(Context r110, AttributeSet r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111);
        this.f401105a = "OIndexScrollbar";
        this.f401106b = Log.isLoggable("OIndexScrollbar", 3);
        this.f401118n = 1;
        this.f401119o = 2;
        this.f401120p = 3;
        this.f401121q = 1;
        ArrayList r100 = new ArrayList();
        this.f401124t = r100;
        this.f401125u = true;
        this.f401126v = 1;
        this.f401127w = 2;
        this.f401128x = 2;
        this.f401130z = DocMetaInfo.DEFAULT_SEC_TYPE;
        this.A = DocMetaInfo.DEFAULT_SEC_TYPE;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f401107c = r110;
        Intrinsics.checkNotNull(r110);
        Resources r112 = r110.getResources();
        LayoutInflater.from(this.f401107c).inflate(R.layout.o_index_scrollbar, this, true);
        this.f401115k = pla.d.n(this, 22);
        int r101 = r112.getDimensionPixelOffset(R.dimen.bytedance_quickbar_grid_item_space);
        int r102 = r112.getDimensionPixelOffset(R.dimen.quickbar_ex_grid_column_width);
        this.B = r112.getDimensionPixelOffset(R.dimen.bytedance_quickbar_min_distance);
        this.f401116l = r112.getDrawable(R.drawable.letters_bar_background_shadow).getIntrinsicWidth();
        int r103 = (r101 * 2) + this.f401115k;
        Context r113 = this.f401107c;
        Intrinsics.checkNotNull(r113);
        this.f401114j = (r103 + (r102 * r113.getResources().getInteger(R.integer.bytedance_letterbar_gridview_column_num))) + this.f401116l;
        View r114 = findViewById(R.id.quickbar_left_letters_bar);
        if (r114 == null) goto L60;
        LettersBar r115 = (LettersBar) r114;
        this.f401108d = r115;
        Intrinsics.checkNotNull(r115);
        r115.setLetters(r100);
        LettersBar r116 = this.f401108d;
        Intrinsics.checkNotNull(r116);
        r116.setListener(new j(this));
        LettersBar r117 = this.f401108d;
        Intrinsics.checkNotNull(r117);
        r117.setOnBackgroundVisibleChangedListener(new k(this));
        r100.clear();
        String[] r118 = dma.e.f469243a;
        String r119 = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullParameter(r119, "language");
        if (Intrinsics.areEqual(Locale.KOREA.getLanguage(), r119) == false) goto L8;
        String[] r120 = dma.e.f469244b;
    L14:
        int r104 = r120.length - 1;
        int r105 = 0;
    L15:
        if (r105 >= r104) goto L38;
        int r106 = r105 + 1;
        String[] r107 = dma.e.f469243a;
        String r108 = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullParameter(r108, "language");
        if (Intrinsics.areEqual(Locale.KOREA.getLanguage(), r108) == false) goto L22;
        if (r105 < 14) goto L30;
    L31:
        boolean r109 = false;
    L33:
        if (r109 == false) goto L35;
        List<dma.b> r121 = this.f401124t;
        dma.b r122 = dma.b.f469237d;
        String r123 = r120[r105];
        Intrinsics.checkNotNullParameter(r123, "letter");
        ArrayList r124 = (ArrayList) r121;
        r124.add(new dma.b(1, r123));
    L36:
        r105 = r106;
        goto L15
    L35:
        List<dma.b> r125 = this.f401124t;
        dma.b r126 = dma.b.f469237d;
        String r127 = r120[r105];
        Intrinsics.checkNotNullParameter(r127, "letter");
        ArrayList r128 = (ArrayList) r125;
        r128.add(new dma.b(0, r127));
    L30:
        r109 = true;
        goto L33
    L22:
        if (Intrinsics.areEqual(Locale.JAPAN.getLanguage(), r108) == false) goto L27;
        if (r105 >= 10) goto L31;
    L27:
        if (Intrinsics.areEqual("ru", r108) == false) goto L31;
        if (r105 >= 5) goto L31;
    L38:
        if (this.f401125u == true) goto L40;
    L43:
        invalidate();
        View r129 = findViewById(R.id.quickbar_right_grid_view);
        if (r129 == null) goto L58;
        this.f401109e = (GridView) r129;
        a r130 = new a(this, this.f401107c);
        this.f401111g = r130;
        Intrinsics.checkNotNull(r130);
        String[] r131 = dma.a.f469233a;
        String r132 = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullParameter(r132, "language");
        if (Intrinsics.areEqual(Locale.KOREA.getLanguage(), r132) == false) goto L49;
        String[] r133 = dma.a.f469234b;
    L55:
        r130.f401132b = r133;
        GridView r134 = this.f401109e;
        Intrinsics.checkNotNull(r134);
        r134.setAdapter(this.f401111g);
        GridView r135 = this.f401109e;
        Intrinsics.checkNotNull(r135);
        r135.setOnItemClickListener(new g(this));
        GridView r136 = this.f401109e;
        Intrinsics.checkNotNull(r136);
        r136.setOnTouchListener(new h(this));
        GridView r137 = this.f401109e;
        Intrinsics.checkNotNull(r137);
        r137.setOnItemLongClickListener(new i(this));
        this.f401110f = findViewById(R.id.iv_letter_bar_shadow);
        setLettersBarBg(false);
        this.C = 30;
        this.D = true;
        return;
    L49:
        if (Intrinsics.areEqual(Locale.JAPAN.getLanguage(), r132) == false) goto L52;
        r133 = dma.a.f469235c;
        goto L55
    L52:
        if (Intrinsics.areEqual("ru", r132) == false) goto L54;
        r133 = dma.a.f469236d;
        goto L55
    L54:
        r133 = dma.a.f469233a;
        goto L55
    L58:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.GridView");
    L40:
        if (this.f401128x != this.f401126v) goto L42;
        ListProtector.add(this.f401124t, 0, dma.b.f469237d);
        goto L43
    L42:
        List<dma.b> r138 = this.f401124t;
        ArrayList r139 = (ArrayList) r138;
        r139.add(dma.b.f469237d);
        goto L43
    L8:
        if (Intrinsics.areEqual(Locale.JAPAN.getLanguage(), r119) == false) goto L11;
        r120 = dma.e.f469245c;
        goto L14
    L11:
        if (Intrinsics.areEqual("ru", r119) == false) goto L13;
        r120 = dma.e.f469246d;
        goto L14
    L13:
        r120 = dma.e.f469243a;
        goto L14
    L60:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.indexscrollbar.LettersBar");
    }

    public static final /* synthetic */ void c(OIndexScrollbar r100, boolean r101) {
        r100.setShadowVisible(r101);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        this.f401117m = View.MeasureSpec.getSize(r101);
        View.MeasureSpec.getSize(r100);
        Object r102 = getParent();
        if (r102 == null) goto L8;
        int r103 = ((View) r102).getMeasuredWidth();
        if (r103 <= 0) goto L8;
        setHostWidth(r103);
    L8:
        if (this.f401106b == true) goto L10;
        return;
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
