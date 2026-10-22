package com.bytedance.android.livesdk.livecommerce.intro.card.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.c0;
import com.bytedance.android.ec.core.widget.f;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.intro.event.IntroCardEventCenter;
import com.bytedance.android.livesdk.livecommerce.intro.event.IntroCardEventCenter$doShowPurchaseButtonEvent$1;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.k0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.l0;
import com.bytedance.android.livesdk.livecommerce.intro.model.setting.ECLiveSkinViewUIConfig;
import com.bytedance.android.livesdk.livecommerce.intro.utils.IntroSkinHelper;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.skin.PromotionCardStyleHelper;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.MonitorLevel;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveLayoutConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinBackgroundElement;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.o0;
import com.bytedance.android.livesdk.livecommerce.view.ECRoundedLinearLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import oh2.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001%B'\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003R$\u0010\f\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/IntroCardButtonComponent;", "Lcom/bytedance/android/livesdk/livecommerce/view/ECRoundedLinearLayout;", "", "", "getComponentContentDescription", "Loh2/e;", "b", "Loh2/e;", "getArgument", "()Loh2/e;", "setArgument", "(Loh2/e;)V", "argument", "Loh2/c;", "c", "Loh2/c;", "getContainerAbility", "()Loh2/c;", "setContainerAbility", "(Loh2/c;)V", "containerAbility", "Lcom/bytedance/android/livesdk/livecommerce/intro/card/presenter/a;", "d", "Lcom/bytedance/android/livesdk/livecommerce/intro/card/presenter/a;", "getPresenter", "()Lcom/bytedance/android/livesdk/livecommerce/intro/card/presenter/a;", "setPresenter", "(Lcom/bytedance/android/livesdk/livecommerce/intro/card/presenter/a;)V", "presenter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroCardButtonComponent extends ECRoundedLinearLayout {
    public e b;
    public oh2.c c;
    public com.bytedance.android.livesdk.livecommerce.intro.card.presenter.a d;
    public final TextView e;

    public static final class a {
    }

    static {
    }

    public IntroCardButtonComponent(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public IntroCardButtonComponent(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final String getComponentContentDescription() {
        CharSequence r0 = this.e.getContentDescription();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toString();
    }

    public e getArgument() {
        return this.b;
    }

    public oh2.c getContainerAbility() {
        return this.c;
    }

    public final com.bytedance.android.livesdk.livecommerce.intro.card.presenter.a getPresenter() {
        return this.d;
    }

    public void setArgument(e r1) {
        this.b = r1;
    }

    public void setContainerAbility(oh2.c r1) {
        this.c = r1;
    }

    public final void setPresenter(com.bytedance.android.livesdk.livecommerce.intro.card.presenter.a r1) {
        this.d = r1;
    }

    public final void a(k0 r23, Integer r24) {
        Intrinsics.checkNotNullParameter(r23, "purchase");
        final l0 r1 = r23.a();
        ECLiveSkinViewUIConfig r2 = null;
        Drawable r3 = null;
        r2 = null;
        if (r1 == null) goto L31;
        TextView r5 = this.e;
        String r6 = r1.b();
        if (r6 != null) goto L8;
        r6 = "";
    L8:
        r5.setText(r6);
        this.e.setContentDescription(this.e.getText().toString() + th.a.g(getContext(), 2131896355));
        String r7 = r1.b();
        if (r7 != null) goto L11;
        String r11 = "";
    L13:
        if (r11.length() <= 4) goto L15;
        int r8 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.b.a;
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.b.b(13, 4, this.e.getLayoutParams().width, r11, this.e, UtilityKotlinExtentionsKt.d(6) * 2);
    L17:
        if (r1.c() != 150) goto L19;
        setBackgroundResource(2131234603);
    L20:
        long r9 = r1.e();
        if (r9 != 0) goto L24;
        setAlpha(1.0f);
    L26:
        f.c(this.e, null, null, new IntroCardButtonComponent$updateBuyButton$1(this, r1), 3);
        e r4 = getArgument();
        if (r4 == null) goto L31;
        IntroCardEventCenter r10 = r4.a;
        if (r10 == null) goto L31;
        IntroCardEventCenter.b(new IntroCardEventCenter$doShowPurchaseButtonEvent$1(r10));
        goto L31
    L24:
        if (r9 != 1) goto L26;
        setAlpha(0.65f);
        goto L26
    L19:
        setBackgroundResource(2131234603);
        goto L20
    L15:
        this.e.setTextSize(13);
        goto L17
    L11:
        r11 = r7;
    L31:
        th2.b r12 = ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_STYLE_CONFIG().get(r24);
        if (r12 == null) goto L100;
        ECLiveSkinViewUIConfig r13 = r12.g();
        if (r13 == null) goto L100;
        ECLiveLayoutConfig r14 = r13.getLayout();
        int r15 = 30;
        int r16 = 80;
        if (r14 != null) goto L38;
        r14 = new ECLiveLayoutConfig(null, null, null, null, null, null, null, null, 80, 30, null, 1279, null);
    L38:
        Integer r17 = r14.getHeight();
        if (r17 != null) goto L41;
    L49:
        o0.d(this, UtilityKotlinExtentionsKt.d(Integer.valueOf(r15)));
        o0.d(this.e, UtilityKotlinExtentionsKt.d(Integer.valueOf(r15)));
        Integer r18 = r14.getWidth();
        if (r18 != null) goto L52;
    L60:
        o0.f(this, UtilityKotlinExtentionsKt.d(Integer.valueOf(r16)));
        o0.f(this.e, UtilityKotlinExtentionsKt.d(Integer.valueOf(r16)));
        ECLiveSkinBackgroundElement r19 = r13.getBackground();
        if (r19 == null) goto L96;
        List<String> r20 = r19.getColor();
        if (r20 == null) goto L96;
        int r21 = IntroSkinHelper.a;
        List<Integer> r22 = r13.getRadius();
        Intrinsics.checkNotNullParameter(r20, "$this$convertDrawable");
        int[] r25 = CollectionsKt.toIntArray(PromotionCardStyleHelper.ButtonHelper.a(r20));
        int r26 = r25.length;
        if (r26 == 1) goto L80;
        if (r26 == 4) goto L79;
        GradientDrawable r27 = new GradientDrawable();
        r27.setColors(r25);
        r27.setGradientType(0);
        r27.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        r3 = r27;
        if (r22 == null) goto L95;
        List<Integer> r28 = r22;
        ArrayList r29 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r28, 10));
        Iterator<T> r30 = r28.iterator();
    L71:
        if (r30.hasNext() == false) goto L74;
        r29.add(Float.valueOf(UtilityKotlinExtentionsKt.c(Float.valueOf(((Number) r30.next()).intValue()))));
        goto L71
    L74:
        if (r29.size() != 4) goto L76;
        r27.setCornerRadii(CollectionsKt.toFloatArray(r29));
        r3 = r27;
        goto L95
    L76:
        Float r31 = (Float) CollectionsKt.firstOrNull(r29);
        r3 = r27;
        if (r31 == null) goto L95;
        r27.setCornerRadius(r31.floatValue());
        r3 = r27;
    L95:
        if (r3 == null) goto L96;
    L97:
        if (r3 == null) goto L99;
        setBackground(r3);
    L99:
        r2 = r13;
        goto L100
    L79:
        r3 = new com.bytedance.android.livesdk.livecommerce.promotion.cardV2.skin.a(r25, new float[]{0.0f, 0.38f, 0.62f, 1.0f}, 111.0f, 0.0f);
        goto L95
    L80:
        Integer r32 = ArraysKt.firstOrNull(r25);
        if (r32 == null) goto L95;
        int r33 = r32.intValue();
        GradientDrawable r34 = new GradientDrawable();
        r34.setColor(r33);
        if (r22 == null) goto L94;
        List<Integer> r35 = r22;
        ArrayList r36 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r35, 10));
        Iterator<T> r37 = r35.iterator();
    L86:
        if (r37.hasNext() == false) goto L89;
        r36.add(Float.valueOf(UtilityKotlinExtentionsKt.c(Float.valueOf(((Number) r37.next()).intValue()))));
        goto L86
    L89:
        if (r36.size() != 4) goto L91;
        r34.setCornerRadii(CollectionsKt.toFloatArray(r36));
        goto L94
    L91:
        Float r38 = (Float) CollectionsKt.firstOrNull(r36);
        if (r38 == null) goto L94;
        r34.setCornerRadius(r38.floatValue());
    L94:
        r3 = r34;
    L96:
        r3 = getContext().getDrawable(2131234603);
        goto L97
    L52:
        if (r18.intValue() <= 0) goto L54;
        boolean r39 = true;
    L55:
        if (r39 == true) goto L58;
        r18 = null;
    L58:
        if (r18 == null) goto L60;
        r16 = r18.intValue();
        goto L60
    L54:
        r39 = false;
        goto L55
    L41:
        if (r17.intValue() <= 0) goto L43;
        boolean r110 = true;
    L44:
        if (r110 == true) goto L47;
        r17 = null;
    L47:
        if (r17 == null) goto L49;
        r15 = r17.intValue();
        goto L49
    L43:
        r110 = false;
    L100:
        UtilityKotlinExtentionsKt.h(r2, new IntroCardButtonComponent$updateShowStyle$2(this));
    }

    public IntroCardButtonComponent(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        th.a.c(r2, 2131560751, this, true);
        setRadius(UtilityKotlinExtentionsKt.c(15));
        TextView r5 = (TextView) findViewById(2131390257);
        this.e = r5;
        c0.b(r5, MonitorLevel.FATAL);
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_STYLE_FIX() == false) goto L6;
        r5.setBackground(null);
        return;
    }

    public /* synthetic */ IntroCardButtonComponent(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
