package com.bytedance.android.livesdk.livecommerce.iron.widgets;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ec.core.hybrid.utils.j;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.c0;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategoryImage;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.MonitorLevel;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinBackgroundElement;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.o0;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0018B'\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0006\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007R(\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/widgets/TopCategoryView;", "Landroid/widget/FrameLayout;", "Lkotlin/Function1;", "Landroid/view/View;", "", "clickListener", "setDisableClickListener", "", "row", "setTabRow", "Lcom/bytedance/android/livesdk/livecommerce/network/response/PromotionCategory;", "<set-?>", "h", "Lcom/bytedance/android/livesdk/livecommerce/network/response/PromotionCategory;", "getCurrentCategory", "()Lcom/bytedance/android/livesdk/livecommerce/network/response/PromotionCategory;", "currentCategory", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TopCategoryView extends FrameLayout {
    public static final /* synthetic */ int l = 0;
    public final AppCompatTextView a;
    public final ImageView b;
    public final ECDraweeView c;
    public final ECDraweeView d;
    public int e;
    public String f;
    public com.bytedance.android.livesdk.livecommerce.skin.f g;
    public PromotionCategory h;
    public Boolean i;
    public final boolean j;
    public Function1<? super View, Unit> k;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ TopCategoryView a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ Drawable c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ boolean e;

        public b(TopCategoryView r1, boolean r2, Drawable r3, boolean r4, boolean r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TopCategoryView r0 = this.a;     // Catch: Throwable -> L4
            boolean r1 = this.b;     // Catch: Throwable -> L4
            Drawable r2 = this.c;     // Catch: Throwable -> L4
            int r3 = TopCategoryView.l;     // Catch: Throwable -> L4
            r0.a(r1, r2);     // Catch: Throwable -> L4
            this.a.f(this.d, this.e);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ TopCategoryView a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        public c(TopCategoryView r1, boolean r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TopCategoryView r0 = this.a;     // Catch: Throwable -> L4
            boolean r1 = this.b;     // Catch: Throwable -> L4
            boolean r2 = this.c;     // Catch: Throwable -> L4
            int r3 = TopCategoryView.l;     // Catch: Throwable -> L4
            r0.f(r1, r2);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public TopCategoryView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public TopCategoryView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final PromotionCategory getCurrentCategory() {
        return this.h;
    }

    public final void b(boolean r4) {
        boolean r1 = true;
        if ((!Intrinsics.areEqual(this.i, Boolean.valueOf(r4))) == false) goto L13;
        PromotionCategory r0 = this.h;
        if (r0 == null) goto L7;
        r0.setSelected(r4);
    L7:
        boolean r2 = this.j;
        if (this.i == null) goto L11;
        r1 = false;
    L11:
        c(r2, r4, r1);
        this.i = Boolean.valueOf(r4);
        return;
    }

    public final void d(int r6) {
        if (this.e != r6) goto L5;
        return;
    L5:
        this.e = r6;
        boolean r7 = this.j;
        Boolean r0 = this.i;
        Boolean r1 = Boolean.TRUE;
        c(r7, Intrinsics.areEqual(r0, r1), false);
        e(this.e, this.j, Intrinsics.areEqual(this.i, r1));
        ViewGroup.LayoutParams r8 = this.a.getLayoutParams();
        bi2.a r2 = bi2.a.a;
        int r3 = this.e;
        r2.getClass();
        if (r3 == 2) goto L12;
        if (r3 != 3) goto L9;
        int r4 = UtilityKotlinExtentionsKt.d(24);
    L13:
        r8.height = r4;
        this.a.setLayoutParams(r8);
        ViewGroup.LayoutParams r9 = getLayoutParams();
        if (this.e == 3) goto L16;
        int r5 = UtilityKotlinExtentionsKt.d(42);
    L17:
        r9.height = r5;
        setLayoutParams(r9);
        return;
    L16:
        r5 = UtilityKotlinExtentionsKt.d(24);
        goto L17
    L9:
        if (r3 == 4) goto L12;
        r4 = UtilityKotlinExtentionsKt.d(Float.valueOf(26.0f)) + 2;
    L12:
        r4 = -1;
        goto L13
    }

    public final void setDisableClickListener(Function1<? super View, Unit> r1) {
        this.k = r1;
    }

    public final void setTabRow(int r2) {
        PromotionCategory r0 = this.h;
        if (r0 == null) goto L6;
        r0.setTabRow(r2);
        return;
    }

    public final void a(boolean r2, Drawable r3) {
        if (r2 == true) goto L6;
        if (this.b.getDrawable() == null) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT >= 28) goto L8;
    L10:
        this.b.setImageDrawable(r3);
        boolean r4 = r3 instanceof Animatable;
        Object r5 = r3;
        if (r4 == true) goto L13;
        r5 = null;
    L13:
        Animatable r6 = (Animatable) r5;
        if (r6 == null) goto L18;
        r6.start();
        return;
    L18:
        return;
    L8:
        if ((r3 instanceof AnimatedImageDrawable) == false) goto L10;
        ((AnimatedImageDrawable) r3).setRepeatCount(0);
        goto L10
    }

    public final void f(boolean r21, boolean r22) {
        AppCompatTextView r3 = this.a;
        bi2.a r4 = bi2.a.a;
        Context r5 = getContext();
        int r6 = this.e;
        com.bytedance.android.livesdk.livecommerce.skin.f r7 = this.g;
        String r8 = this.f;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "context");
        String r10 = null;
        if (r21 == false) goto L5;
        if (r22 == false) goto L48;
        if (r6 == 3) goto L36;
        if (r6 == 4) goto L31;
        if (r7 == null) goto L30;
        Integer r9 = r7.c(r21, r22);
        if (r9 == null) goto L30;
        int r11 = r9.intValue();
    L79:
        r3.setTextColor(r11);
        e(this.e, r21, r22);
        AppCompatTextView r12 = this.a;
        TextPaint r13 = r12.getPaint();
        int r14 = this.e;
        if (r14 == 3) goto L92;
        if (r14 == 4) goto L86;
        if (r21 == false) goto L85;
        if (r22 == false) goto L85;
        Typeface r15 = Typeface.DEFAULT_BOLD;
    L113:
        r12.setTypeface(r15);
        PromotionCategory r16 = this.h;
        if (r16 == null) goto L238;
        Integer r17 = Integer.valueOf(r16.getEnhanceType());
        if (r17.intValue() <= 0) goto L118;
        boolean r18 = true;
    L119:
        if (r18 == true) goto L122;
        r17 = null;
    L122:
        if (r17 == null) goto L239;
        int r19 = r17.intValue();
        if (this.e != 4) goto L245;
        int r20 = ci2.a.a;
        PromotionCategory r23 = this.h;
        if (r23 == null) goto L129;
        String r24 = r23.getUniqueIndex();
    L131:
        if (r24 == null) goto L144;
        HashMap r25 = j.a;
        JSONObject r26 = j.i(q.a.getString("ec_live_tab_enhance_control_show", ""));
        if (r26 == null) goto L144;
        Integer r27 = Integer.valueOf(r26.optInt(r24, 0));
        if (r27.intValue() <= 0) goto L138;
        boolean r28 = true;
    L139:
        if (r28 == true) goto L142;
        r27 = null;
    L142:
        if (r27 == null) goto L144;
        r27.intValue();
        boolean r29 = true;
    L145:
        if (r29 == true) goto L231;
        PromotionCategory r30 = this.h;
        if (r30 == null) goto L149;
        String r31 = r30.getUniqueIndex();
    L150:
        if (r31 == null) goto L163;
        HashMap r32 = j.a;
        JSONObject r33 = j.i(q.a.getString("ec_live_tab_enhance_control_click", ""));
        if (r33 == null) goto L163;
        Integer r34 = Integer.valueOf(r33.optInt(r31, 0));
        if (r34.intValue() <= 0) goto L157;
        boolean r35 = true;
    L158:
        if (r35 == true) goto L161;
        r34 = null;
    L161:
        if (r34 == null) goto L163;
        r34.intValue();
        boolean r36 = true;
    L164:
        if (r36 == true) goto L231;
        com.bytedance.android.livesdk.livecommerce.skin.f r37 = this.g;
        if (r37 == null) goto L208;
        com.bytedance.android.livesdk.livecommerce.skin.b r38 = r37.f();
        if (r38 == null) goto L208;
        int[] r39 = r38.b(r19, r21, r22);
        if (r39 == null) goto L208;
        if (r39.length < 2) goto L196;
        PromotionCategory r40 = this.h;
        if (r40 == null) goto L217;
        String r41 = r40.getName();
        if (r41 == null) goto L217;
        if (r41.length() <= 0) goto L181;
        boolean r42 = true;
    L182:
        if (r42 == false) goto L184;
        r10 = r41;
    L184:
        if (r10 == null) goto L217;
        Integer r43 = ArraysKt.firstOrNull(r39);
        if (r43 == null) goto L188;
        this.a.setTextColor(r43.intValue());
    L188:
        TextPaint r44 = this.a.getPaint();
        if (r44 == null) goto L191;
        Number r45 = Float.valueOf(r44.measureText(r10));
    L192:
        TextPaint r46 = this.a.getPaint();
        if (r46 == null) goto L217;
        r46.setShader(new LinearGradient(0.0f, 0.0f, r45.floatValue(), 0.0f, r39, null, Shader.TileMode.CLAMP));
        goto L217
    L191:
        r45 = 0;
        goto L192
    L181:
        r42 = false;
    L217:
        com.bytedance.android.livesdk.livecommerce.skin.f r47 = this.g;
        if (r47 == null) goto L224;
        com.bytedance.android.livesdk.livecommerce.skin.b r48 = r47.f();
        if (r48 == null) goto L224;
        Integer r49 = r48.c(r19, r21, r22);
        if (r49 == null) goto L224;
        this.a.setTextSize(1, r49.intValue());
    L224:
        com.bytedance.android.livesdk.livecommerce.skin.f r50 = this.g;
        if (r50 == null) goto L240;
        com.bytedance.android.livesdk.livecommerce.skin.b r51 = r50.f();
        if (r51 == null) goto L241;
        Integer r1 = r51.d(r19, r21, r22);
        if (r1 == null) goto L242;
        int r2 = r1.intValue();
        int r52 = c0.a;
        c0.b(this.a, r2);
        return;
    L242:
        return;
    L241:
        return;
    L240:
        return;
    L196:
        if (r39.length != 1) goto L200;
        Integer r53 = ArraysKt.firstOrNull(r39);
        if (r53 == null) goto L217;
        this.a.setTextColor(r53.intValue());
        goto L217
    L200:
        TextPaint r54 = this.a.getPaint();
        if (r54 == null) goto L203;
        Shader r55 = r54.getShader();
    L204:
        if (r55 == null) goto L217;
        TextPaint r56 = this.a.getPaint();
        if (r56 == null) goto L217;
        r56.setShader(null);
        goto L217
    L203:
        r55 = null;
    L208:
        TextPaint r57 = this.a.getPaint();
        if (r57 == null) goto L211;
        Shader r58 = r57.getShader();
    L212:
        if (r58 == null) goto L216;
        TextPaint r59 = this.a.getPaint();
        if (r59 == null) goto L216;
        r59.setShader(null);
    L216:
        Unit r60 = Unit.INSTANCE;
        goto L217
    L211:
        r58 = null;
        goto L212
    L157:
        r35 = false;
    L163:
        r36 = false;
        goto L164
    L149:
        r31 = null;
    L231:
        AppCompatTextView r61 = this.a;
        TextPaint r62 = r61.getPaint();
        if (r62 == null) goto L234;
        Shader r63 = r62.getShader();
    L235:
        if (r63 == null) goto L244;
        r61.getPaint().setShader(null);
        return;
    L244:
        return;
    L234:
        r63 = null;
        goto L235
    L138:
        r28 = false;
    L144:
        r29 = false;
        goto L145
    L129:
        r24 = null;
        goto L131
    L245:
        return;
    L239:
        return;
    L118:
        r18 = false;
        goto L119
    L238:
        return;
    L85:
        r15 = Typeface.DEFAULT;
        goto L113
    L86:
        if (r13 != null) goto L88;
        r15 = Typeface.DEFAULT;
        goto L113
    L88:
        if (r22 == false) goto L90;
        r15 = c0.a(r13, 600);
        goto L113
    L90:
        r15 = c0.a(r13, MonitorLevel.ERROR);
        goto L113
    L92:
        if (r22 == false) goto L104;
        if (Build.VERSION.SDK_INT < 28) goto L99;
        if (r13 == null) goto L97;
        Typeface r64 = r13.getTypeface();
    L98:
        r15 = Typeface.create(r64, MonitorLevel.FATAL, false);
        goto L113
    L97:
        r64 = null;
        goto L98
    L99:
        if (r21 == false) goto L102;
        if (r22 == false) goto L102;
        r15 = Typeface.DEFAULT_BOLD;
    L102:
        r15 = Typeface.DEFAULT;
        goto L113
    L104:
        if (Build.VERSION.SDK_INT < 28) goto L109;
        if (r13 == null) goto L107;
        Typeface r65 = r13.getTypeface();
    L108:
        r15 = Typeface.create(r65, MonitorLevel.ERROR, false);
        goto L113
    L107:
        r65 = null;
        goto L108
    L109:
        if (r21 == false) goto L112;
        if (r22 == false) goto L112;
        r15 = Typeface.DEFAULT_BOLD;
    L112:
        r15 = Typeface.DEFAULT;
    L30:
        r11 = th.a.a(r5, 2131106181);
        goto L79
    L31:
        if (r7 == null) goto L35;
        Integer r66 = r7.c(r21, r22);
        if (r66 == null) goto L35;
        r11 = r66.intValue();
    L35:
        r11 = th.a.a(r5, 2131101635);
        goto L79
    L36:
        int r67 = s.a;
        int r68 = wh2.c.a;
        List r69 = wh2.b.a("live_list_tab_text_selected_color", r8);
        if (r69 == null) goto L39;
        String r70 = (String) CollectionsKt.firstOrNull(r69);
    L40:
        Integer r71 = s.b(r70);
        if (r71 != null) goto L45;
        if (r7 == null) goto L44;
        r71 = r7.c(r21, r22);
        goto L45
    L44:
        r71 = null;
    L45:
        if (r71 == null) goto L47;
        r11 = r71.intValue();
        goto L79
    L47:
        r11 = th.a.a(r5, 2131106034);
        goto L79
    L39:
        r70 = null;
        goto L40
    L48:
        if (r6 != 1) goto L50;
        if (r7 == null) goto L78;
        Integer r72 = r7.c(r21, r22);
        if (r72 == null) goto L78;
        r11 = r72.intValue();
    L78:
        r11 = th.a.a(r5, 2131105982);
        goto L79
    L50:
        if (r6 == 3) goto L62;
        if (r6 == 4) goto L57;
        if (r7 == null) goto L56;
        Integer r73 = r7.c(r21, r22);
        if (r73 == null) goto L56;
        r11 = r73.intValue();
    L56:
        r11 = th.a.a(r5, 2131106228);
        goto L79
    L57:
        if (r7 == null) goto L61;
        Integer r74 = r7.c(r21, r22);
        if (r74 == null) goto L61;
        r11 = r74.intValue();
    L61:
        r11 = th.a.a(r5, 2131106047);
        goto L79
    L62:
        int r75 = s.a;
        int r76 = wh2.c.a;
        List r77 = wh2.b.a("live_list_tab_text_unselected_color", r8);
        if (r77 == null) goto L65;
        String r78 = (String) CollectionsKt.firstOrNull(r77);
    L66:
        Integer r79 = s.b(r78);
        if (r79 != null) goto L71;
        if (r7 == null) goto L70;
        r79 = r7.c(r21, r22);
        goto L71
    L70:
        r79 = null;
    L71:
        if (r79 == null) goto L73;
        r11 = r79.intValue();
        goto L79
    L73:
        r11 = th.a.a(r5, 2131106228);
        goto L79
    L65:
        r78 = null;
        goto L66
    L5:
        if (r6 == 3) goto L11;
        if (r7 == null) goto L10;
        Integer r80 = r7.c(r21, r22);
        if (r80 == null) goto L10;
        r11 = r80.intValue();
    L10:
        r11 = th.a.a(r5, 2131101616);
        goto L79
    L11:
        int r81 = s.a;
        int r82 = wh2.c.a;
        List r83 = wh2.b.a("live_list_tab_text_disabled_color", r8);
        if (r83 == null) goto L14;
        String r85 = (String) CollectionsKt.firstOrNull(r83);
    L15:
        Integer r86 = s.b(r85);
        if (r86 != null) goto L20;
        if (r7 == null) goto L19;
        r86 = r7.c(r21, r22);
        goto L20
    L19:
        r86 = null;
    L20:
        if (r86 == null) goto L22;
        r11 = r86.intValue();
        goto L79
    L22:
        r11 = th.a.a(r5, 2131101616);
        goto L79
    L14:
        r85 = null;
        goto L15
    }

    public TopCategoryView(Context r16, AttributeSet r17, int r18) {
        Intrinsics.checkNotNullParameter(r16, "context");
        super(r16, r17, r18);
        this.j = true;
        ViewGroup.LayoutParams r1 = new FrameLayout.LayoutParams(-2, UtilityKotlinExtentionsKt.d(42));
        o0.c(this, 17);
        Unit r2 = Unit.INSTANCE;
        setLayoutParams(r1);
        ECDraweeView r11 = new ECDraweeView(r16, null, 0, 6, null);
        r11.setAdjustMode(33);
        r11.setVisibility(8);
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(-2, -2);
        r3.gravity = 17;
        r11.setLayoutParams(r3);
        addView(r11);
        this.c = r11;
        ImageView r4 = new ImageView(r16);
        r4.setVisibility(8);
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(-2, -2);
        r5.gravity = 8388693;
        r5.setMarginEnd(UtilityKotlinExtentionsKt.d(3));
        r5.bottomMargin = UtilityKotlinExtentionsKt.d(8);
        r4.setLayoutParams(r5);
        addView(r4);
        this.b = r4;
        ECDraweeView r12 = new ECDraweeView(r16, null, 0, 6, null);
        r12.setAdjustMode(33);
        r12.setVisibility(8);
        FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(-2, -2);
        r6.gravity = 17;
        r12.setLayoutParams(r6);
        addView(r12);
        this.d = r12;
        AppCompatTextView r7 = new AppCompatTextView(r16);
        FrameLayout.LayoutParams r8 = new FrameLayout.LayoutParams(-2, UtilityKotlinExtentionsKt.d(Float.valueOf(26.0f)) + 2);
        r8.gravity = 17;
        r7.setLayoutParams(r8);
        r7.setGravity(16);
        r7.setTextColor(th.a.a(r16, 2131106228));
        addView(r7);
        this.a = r7;
        e(this.e, true, false);
        int r9 = ph.b.a;
        Intrinsics.checkNotNullParameter(this, "view");
        if (com.bytedance.android.ec.core.opt.ab.j.a().k() == false) goto L6;
        ph.b.b(this);
        return;
    }

    public final void c(boolean r20, boolean r21, boolean r22) {
        int r2 = 4;
        ECUrlModel r8 = null;
        if (this.e != 3) goto L62;
        bi2.a r0 = bi2.a.a;
        com.bytedance.android.livesdk.livecommerce.skin.f r1 = this.g;
        String r3 = this.f;
        r0.getClass();
        if (r20 == true) goto L24;
        if (r1 == null) goto L13;
        ECLiveSkinBackgroundElement r4 = r1.e(r20, r21);
        if (r4 == null) goto L13;
        List<String> r5 = r4.getColor();
        if (r5 == null) goto L13;
        String r6 = (String) CollectionsKt.firstOrNull(r5);
        if (r6 == null) goto L13;
    L17:
        if (r1 == null) goto L23;
        List r7 = r1.g();
        if (r7 == null) goto L23;
        Integer r9 = (Integer) CollectionsKt.firstOrNull(r7);
        if (r9 == null) goto L23;
        r2 = r9.intValue();
    L23:
        Drawable r10 = bi2.a.c(r6, r2);
    L61:
        setBackground(r10);
        this.b.setVisibility(8);
        f(r20, r21);
    L98:
        PromotionCategory r11 = this.h;
        if (r11 != null) goto L101;
    L118:
        this.a.setVisibility(0);
        this.d.setVisibility(8);
        Unit r12 = Unit.INSTANCE;
        return;
    L101:
        if (r11.getImage() == null) goto L118;
        this.a.setVisibility(8);
        this.d.setVisibility(0);
        if (r21 == false) goto L109;
        PromotionCategory r13 = this.h;
        if (r13 == null) goto L114;
        PromotionCategoryImage r14 = r13.getImage();
        if (r14 == null) goto L114;
        r8 = r14.getSelectedImage();
    L114:
        ECUrlModel r15 = r8;
        if (r15 == null) goto L117;
        ViewGroup.LayoutParams r16 = this.d.getLayoutParams();
        r16.width = UtilityKotlinExtentionsKt.d(Integer.valueOf(r15.getWidth()));
        r16.height = UtilityKotlinExtentionsKt.d(Integer.valueOf(r15.getHeight()));
        this.d.setLayoutParams(r16);
        this.a.setVisibility(8);
        this.d.setVisibility(0);
        h0.d(this.d, r15, new r("ec_live", "promotion_list_category_tab"), null, null, null, new h(this), 56);
        return;
    L117:
        this.a.setVisibility(0);
        this.d.setVisibility(8);
        Unit r17 = Unit.INSTANCE;
        return;
    L109:
        PromotionCategory r18 = this.h;
        if (r18 == null) goto L114;
        PromotionCategoryImage r19 = r18.getImage();
        if (r19 == null) goto L114;
        r8 = r19.getDefaultImage();
    L13:
        int r23 = wh2.c.a;
        List r24 = wh2.b.a("live_list_tab_bg_disabled_color", r3);
        if (r24 == null) goto L16;
        r6 = (String) CollectionsKt.firstOrNull(r24);
        goto L17
    L16:
        r6 = null;
        goto L17
    L24:
        if (r21 == false) goto L43;
        if (r1 == null) goto L32;
        ECLiveSkinBackgroundElement r25 = r1.e(r20, r21);
        if (r25 == null) goto L32;
        List<String> r26 = r25.getColor();
        if (r26 == null) goto L32;
        String r27 = (String) CollectionsKt.firstOrNull(r26);
        if (r27 == null) goto L32;
    L36:
        if (r1 == null) goto L42;
        List r28 = r1.g();
        if (r28 == null) goto L42;
        Integer r29 = (Integer) CollectionsKt.firstOrNull(r28);
        if (r29 == null) goto L42;
        r2 = r29.intValue();
    L42:
        r10 = bi2.a.c(r27, r2);
    L32:
        int r30 = wh2.c.a;
        List r31 = wh2.b.a("live_list_tab_bg_selected_color", r3);
        if (r31 == null) goto L35;
        r27 = (String) CollectionsKt.firstOrNull(r31);
        goto L36
    L35:
        r27 = null;
        goto L36
    L43:
        if (r1 == null) goto L50;
        ECLiveSkinBackgroundElement r32 = r1.e(r20, r21);
        if (r32 == null) goto L50;
        List<String> r33 = r32.getColor();
        if (r33 == null) goto L50;
        String r34 = (String) CollectionsKt.firstOrNull(r33);
        if (r34 == null) goto L50;
    L54:
        if (r1 == null) goto L60;
        List r35 = r1.g();
        if (r35 == null) goto L60;
        Integer r36 = (Integer) CollectionsKt.firstOrNull(r35);
        if (r36 == null) goto L60;
        r2 = r36.intValue();
    L60:
        r10 = bi2.a.c(r34, r2);
    L50:
        int r37 = wh2.c.a;
        List r38 = wh2.b.a("live_list_tab_bg_unselected_color", r3);
        if (r38 == null) goto L53;
        r34 = (String) CollectionsKt.firstOrNull(r38);
        goto L54
    L53:
        r34 = null;
        goto L54
    L62:
        setBackground(null);
        this.b.setVisibility(0);
        bi2.a r39 = bi2.a.a;
        Context r40 = getContext();
        int r41 = this.e;
        com.bytedance.android.livesdk.livecommerce.skin.f r42 = this.g;
        ECDraweeView r110 = this.c;
        r39.getClass();
        Intrinsics.checkNotNullParameter(r40, "context");
        if (r20 == true) goto L73;
        if (r41 == 4) goto L67;
        Drawable r43 = th.a.b(r40, bi2.a.a(r41, r20, r21));
    L66:
        Drawable r44 = r43;
    L87:
        if ((r44 instanceof Animatable) == false) goto L97;
        if (r22 == false) goto L91;
        if (r21 == true) goto L91;
        this.b.setImageDrawable(new ColorDrawable(0));
        f(r20, r21);
    L91:
        boolean r45 = !Intrinsics.areEqual(this.i, Boolean.valueOf(r21));
        if (r21 == false) goto L96;
        if (r22 == false) goto L95;
        a(r45, r44);
        f(r20, r21);
        goto L98
    L95:
        postDelayed(new b(this, r45, r44, r20, r21), 150);
        goto L98
    L96:
        postDelayed(new c(this, r20, r21), 150);
        a(r45, r44);
        goto L98
    L97:
        this.b.setImageDrawable(r44);
        f(r20, r21);
        goto L98
    L67:
        if (r42 == null) goto L72;
        Drawable r46 = r42.d(r40, r20, r21, r110);
        if (r46 == null) goto L72;
    L71:
        r44 = r46;
    L72:
        r43 = th.a.b(r40, 2131106784);
        goto L66
    L73:
        if (r21 == false) goto L80;
        if (r41 == 4) goto L76;
        r43 = th.a.b(r40, bi2.a.a(r41, r20, r21));
        goto L66
    L76:
        if (r42 == null) goto L79;
        r43 = r42.d(r40, r20, r21, r110);
        if (r43 != null) goto L66;
    L79:
        r43 = th.a.b(r40, 2131234616);
        goto L66
    L80:
        if (r41 == 4) goto L82;
        r43 = th.a.b(r40, bi2.a.a(r41, r20, r21));
        goto L66
    L82:
        if (r42 == null) goto L85;
        r46 = r42.d(r40, r20, r21, r110);
        if (r46 != null) goto L71;
    L85:
        r43 = th.a.b(r40, 2131106784);
        goto L66
    }

    public final void e(int r13, boolean r14, boolean r15) {
        bi2.a.a.getClass();
        float r2 = 14.0f;
        Float r3 = Float.valueOf(14.0f);
        Float r6 = Float.valueOf(12.0f);
        if (r13 == 1) goto L11;
        if (r13 == 2) goto L10;
        if (r13 == 3) goto L9;
        if (r13 == 4) goto L8;
        bi2.a.C0000a r4 = new bi2.a.C0000a(UtilityKotlinExtentionsKt.d(r6), UtilityKotlinExtentionsKt.d(r6));
    L12:
        this.a.setPadding(r4.a, r4.b, r4.c, r4.d);
        wg.a.f(this.d, r4.a, r4.b, r4.c, r4.d);
        AppCompatTextView r5 = this.a;
        com.bytedance.android.livesdk.livecommerce.skin.f r7 = this.g;
        if (r7 == null) goto L17;
        Integer r16 = r7.a(r14, r15);
        if (r16 == null) goto L17;
        r2 = r16.intValue();
    L26:
        r5.setTextSize(1, r2);
        return;
    L17:
        if (r13 == 1) goto L26;
        if (r13 == 2) goto L25;
        if (r13 == 3) goto L25;
        if (r13 != 4) goto L25;
        if (r15 != true) goto L24;
        r2 = 16.0f;
        goto L26
    L24:
        r2 = 13.0f;
    L25:
        r2 = 12.0f;
        goto L26
    L8:
        r4 = new bi2.a.C0000a(UtilityKotlinExtentionsKt.d(Float.valueOf(10.0f)), UtilityKotlinExtentionsKt.d(Float.valueOf(10.0f)));
        goto L12
    L9:
        r4 = new bi2.a.C0000a(UtilityKotlinExtentionsKt.d(r6), UtilityKotlinExtentionsKt.d(r6));
        goto L12
    L10:
        r4 = new bi2.a.C0000a(UtilityKotlinExtentionsKt.d(r3), UtilityKotlinExtentionsKt.d(r3));
        goto L12
    L11:
        r4 = new bi2.a.C0000a(UtilityKotlinExtentionsKt.d(r6), UtilityKotlinExtentionsKt.d(Float.valueOf(15.0f)));
        goto L12
    }

    public /* synthetic */ TopCategoryView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
