package com.bytedance.android.livesdk.livecommerce.skin;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.livesdk.livecommerce.skin.model.AbsECLiveSkinBaseUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinBackgroundElement;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinBaseViewUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinBorderElement;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinBtnUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinImageElement;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinPriceUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinTextElement;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements i {
    public Map<String, ? extends AbsECLiveSkinBaseUIConfig> a;
    public List<String> b;

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Integer a() {
        ECLiveSkinBaseViewUIConfig r0 = G("find_similar_btn", true);
        int r1 = s.a;
        if (r0 == null) goto L9;
        ECLiveSkinTextElement r2 = r0.getText();
        if (r2 == null) goto L9;
        List<String> r3 = r2.getColor();
        if (r3 == null) goto L9;
        String r4 = (String) CollectionsKt.firstOrNull(r3);
    L10:
        Integer r5 = s.b(r4);
        if (r5 != null) goto L13;
        return null;
    L13:
        return Integer.valueOf(r5.intValue());
    L9:
        r4 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Drawable k() {
        ECLiveSkinBaseViewUIConfig r0 = G("find_similar_btn", true);
        if (r0 == null) goto L5;
        ECLiveSkinBackgroundElement r1 = r0.getBackground();
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        return ECLiveSkinBackgroundElement.a.b(ECLiveSkinBackgroundElement.Companion, r1, null, null, 6);
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final String t() {
        ECLiveSkinBaseViewUIConfig r0 = G("stepper_sub", true);
        if (r0 == null) goto L7;
        ECLiveSkinImageElement r1 = r0.getImage();
        if (r1 == null) goto L7;
        return r1.getUrl();
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Integer D() {
        Map<String, ? extends AbsECLiveSkinBaseUIConfig> r0 = this.a;
        if (r0 == null) goto L5;
        AbsECLiveSkinBaseUIConfig r1 = r0.get("price_desc");
    L7:
        if ((r1 instanceof ECLiveSkinBaseViewUIConfig) == true) goto L9;
        r1 = null;
    L9:
        ECLiveSkinBaseViewUIConfig r2 = (ECLiveSkinBaseViewUIConfig) r1;
        if (r2 == null) goto L15;
        ECLiveSkinTextElement r3 = r2.getText();
        if (r3 != null) goto L14;
        return null;
    L14:
        return Integer.valueOf(r3.getFontSize());
    L15:
        return null;
    L5:
        r1 = null;
        goto L7
    }

    public final ECLiveSkinBaseViewUIConfig H() {
        Map<String, ? extends AbsECLiveSkinBaseUIConfig> r0 = this.a;
        AbsECLiveSkinBaseUIConfig r1 = null;
        if (r0 == null) goto L5;
        AbsECLiveSkinBaseUIConfig r2 = r0.get("explain_banner");
    L7:
        if ((r2 instanceof ECLiveSkinBaseViewUIConfig) == false) goto L11;
        r1 = r2;
    L11:
        return (ECLiveSkinBaseViewUIConfig) r1;
    L5:
        r2 = null;
        goto L7
    }

    public final ECLiveSkinPriceUIConfig I() {
        Map<String, ? extends AbsECLiveSkinBaseUIConfig> r0 = this.a;
        AbsECLiveSkinBaseUIConfig r1 = null;
        if (r0 == null) goto L5;
        AbsECLiveSkinBaseUIConfig r2 = r0.get("origin_price");
    L7:
        if ((r2 instanceof ECLiveSkinPriceUIConfig) == false) goto L11;
        r1 = r2;
    L11:
        return (ECLiveSkinPriceUIConfig) r1;
    L5:
        r2 = null;
        goto L7
    }

    public final ECLiveSkinPriceUIConfig J() {
        Map<String, ? extends AbsECLiveSkinBaseUIConfig> r0 = this.a;
        AbsECLiveSkinBaseUIConfig r1 = null;
        if (r0 == null) goto L5;
        AbsECLiveSkinBaseUIConfig r2 = r0.get("price");
    L7:
        if ((r2 instanceof ECLiveSkinPriceUIConfig) == false) goto L11;
        r1 = r2;
    L11:
        return (ECLiveSkinPriceUIConfig) r1;
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final int e() {
        Map<String, ? extends AbsECLiveSkinBaseUIConfig> r0 = this.a;
        AbsECLiveSkinBaseUIConfig r1 = null;
        if (r0 == null) goto L5;
        AbsECLiveSkinBaseUIConfig r2 = r0.get("buy_btn");
    L7:
        if ((r2 instanceof ECLiveSkinBtnUIConfig) == false) goto L10;
        r1 = r2;
    L10:
        ECLiveSkinBtnUIConfig r3 = (ECLiveSkinBtnUIConfig) r1;
        if (r3 != null) goto L13;
        return 0;
    L13:
        ECLiveSkinBaseViewUIConfig r4 = r3.getEnabled();
        if (r4 == null) goto L19;
        ECLiveSkinTextElement r5 = r4.getText();
        if (r5 != null) goto L18;
        return 0;
    L18:
        return r5.getFontSize();
    L19:
        return 0;
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Integer f() {
        int r0 = s.a;
        ECLiveSkinBaseViewUIConfig r1 = G("buy_btn", true);
        if (r1 == null) goto L9;
        ECLiveSkinTextElement r2 = r1.getText();
        if (r2 == null) goto L9;
        List<String> r3 = r2.getColor();
        if (r3 == null) goto L9;
        String r4 = (String) CollectionsKt.firstOrNull(r3);
    L11:
        return s.b(r4);
    L9:
        r4 = null;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Drawable l() {
        Map<String, ? extends AbsECLiveSkinBaseUIConfig> r0 = this.a;
        List<String> r1 = null;
        if (r0 == null) goto L5;
        AbsECLiveSkinBaseUIConfig r2 = r0.get("explain_bg");
    L7:
        if ((r2 instanceof ECLiveSkinBaseViewUIConfig) == true) goto L9;
        r2 = null;
    L9:
        ECLiveSkinBaseViewUIConfig r3 = (ECLiveSkinBaseViewUIConfig) r2;
        if (r3 == null) goto L64;
        int r4 = j.a;
        ECLiveSkinBackgroundElement r5 = r3.getBackground();
        ECLiveSkinBorderElement r6 = r3.getBorder();
        List<Integer> r7 = r3.getRadius();
        if (r5 != null) goto L15;
        if (r6 != null) goto L15;
        return null;
    L15:
        GradientDrawable r8 = new GradientDrawable();
        if (r7 == null) goto L27;
        List<Integer> r9 = r7;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r11 = r9.iterator();
    L19:
        if (r11.hasNext() == false) goto L22;
        r10.add(Float.valueOf(UtilityKotlinExtentionsKt.c(Float.valueOf(((Number) r11.next()).intValue()))));
        goto L19
    L22:
        if (r10.size() != 4) goto L24;
        r8.setCornerRadii(CollectionsKt.toFloatArray(r10));
        goto L27
    L24:
        Float r12 = (Float) CollectionsKt.firstOrNull(r10);
        if (r12 == null) goto L27;
        r8.setCornerRadius(r12.floatValue());
    L27:
        if (r5 == null) goto L48;
        List<String> r13 = r5.getColor();
        if (r13 == null) goto L48;
        if ((!r13.isEmpty()) == false) goto L33;
        r1 = r13;
    L33:
        if (r1 == null) goto L48;
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r1.iterator();
    L36:
        if (r15.hasNext() == false) goto L41;
        Integer r16 = s.b((String) r15.next());
        if (r16 == null) goto L36;
        r14.add(Integer.valueOf(r16.intValue()));
        goto L36
    L41:
        if (r14.size() != 1) goto L46;
        Integer r17 = (Integer) CollectionsKt.firstOrNull(r14);
        if (r17 == null) goto L48;
        r8.setColor(r17.intValue());
        goto L48
    L46:
        if (r14.size() <= 1) goto L48;
        r8.setColors(CollectionsKt.toIntArray(r14));
        r8.setGradientType(0);
        r8.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
    L48:
        if (r6 == null) goto L57;
        List<String> r18 = r6.getColor();
        if (r18 == null) goto L57;
        String r19 = (String) CollectionsKt.firstOrNull(r18);
        if (r19 == null) goto L57;
        Integer r20 = s.b(r19);
        if (r20 == null) goto L57;
        r8.setStroke((int) UtilityKotlinExtentionsKt.c(Float.valueOf(r6.getBorderWidth())), r20.intValue());
    L57:
        return r8;
    L64:
        return null;
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Boolean p() {
        return Boolean.valueOf(this.b.contains("instant_add_cart_large_size"));
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Integer u() {
        Map<String, ? extends AbsECLiveSkinBaseUIConfig> r0 = this.a;
        if (r0 == null) goto L5;
        AbsECLiveSkinBaseUIConfig r1 = r0.get("stepper_count");
    L7:
        if ((r1 instanceof ECLiveSkinBaseViewUIConfig) == true) goto L9;
        r1 = null;
    L9:
        ECLiveSkinBaseViewUIConfig r2 = (ECLiveSkinBaseViewUIConfig) r1;
        if (r2 != null) goto L12;
        return null;
    L12:
        ECLiveSkinTextElement r3 = r2.getText();
        if (r3 != null) goto L15;
        return null;
    L15:
        return Integer.valueOf(r3.getFontSize());
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final List<Integer> v() {
        Map<String, ? extends AbsECLiveSkinBaseUIConfig> r0 = this.a;
        if (r0 == null) goto L5;
        AbsECLiveSkinBaseUIConfig r1 = r0.get("explain_bg");
    L7:
        if ((r1 instanceof ECLiveSkinBaseViewUIConfig) == true) goto L9;
        r1 = null;
    L9:
        ECLiveSkinBaseViewUIConfig r2 = (ECLiveSkinBaseViewUIConfig) r1;
        if (r2 != null) goto L12;
        return null;
    L12:
        return r2.getRadius();
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final List<Integer> w() {
        Map<String, ? extends AbsECLiveSkinBaseUIConfig> r0 = this.a;
        if (r0 == null) goto L5;
        AbsECLiveSkinBaseUIConfig r1 = r0.get("buy_btn");
    L7:
        if ((r1 instanceof ECLiveSkinBtnUIConfig) == true) goto L9;
        r1 = null;
    L9:
        ECLiveSkinBtnUIConfig r2 = (ECLiveSkinBtnUIConfig) r1;
        if (r2 != null) goto L13;
        return null;
    L13:
        return r2.getRadius();
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final String x() {
        Map<String, ? extends AbsECLiveSkinBaseUIConfig> r0 = this.a;
        if (r0 == null) goto L5;
        AbsECLiveSkinBaseUIConfig r1 = r0.get("price_desc");
    L7:
        if ((r1 instanceof ECLiveSkinBaseViewUIConfig) == true) goto L9;
        r1 = null;
    L9:
        ECLiveSkinBaseViewUIConfig r2 = (ECLiveSkinBaseViewUIConfig) r1;
        if (r2 == null) goto L17;
        ECLiveSkinTextElement r3 = r2.getText();
        if (r3 == null) goto L18;
        List<String> r4 = r3.getColor();
        if (r4 != null) goto L16;
        return null;
    L16:
        return (String) CollectionsKt.firstOrNull(r4);
    L18:
        return null;
    L17:
        return null;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Integer y() {
        Map<String, ? extends AbsECLiveSkinBaseUIConfig> r0 = this.a;
        if (r0 == null) goto L5;
        AbsECLiveSkinBaseUIConfig r1 = r0.get("stepper_count");
    L7:
        if ((r1 instanceof ECLiveSkinBaseViewUIConfig) == true) goto L9;
        r1 = null;
    L9:
        ECLiveSkinBaseViewUIConfig r2 = (ECLiveSkinBaseViewUIConfig) r1;
        if (r2 != null) goto L12;
        return null;
    L12:
        int r3 = s.a;
        ECLiveSkinTextElement r4 = r2.getText();
        if (r4 == null) goto L17;
        List<String> r5 = r4.getColor();
        if (r5 == null) goto L17;
        String r6 = (String) CollectionsKt.firstOrNull(r5);
    L18:
        Integer r7 = s.b(r6);
        if (r7 != null) goto L21;
        return null;
    L21:
        return Integer.valueOf(r7.intValue());
    L17:
        r6 = null;
        goto L18
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Integer A() {
        ECLiveSkinPriceUIConfig r0 = I();
        if (r0 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r0.getIntegerFontSize());
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Integer B() {
        ECLiveSkinPriceUIConfig r0 = I();
        if (r0 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r0.getSuffixFontSize());
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final String C() {
        ECLiveSkinPriceUIConfig r0 = I();
        if (r0 == null) goto L7;
        List<String> r1 = r0.getColor();
        if (r1 == null) goto L7;
        return (String) CollectionsKt.firstOrNull(r1);
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Integer E() {
        ECLiveSkinPriceUIConfig r0 = I();
        if (r0 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r0.getYuanTagFontSize());
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final String b() {
        ECLiveSkinBaseViewUIConfig r0 = H();
        if (r0 == null) goto L9;
        ECLiveSkinTextElement r1 = r0.getText();
        if (r1 == null) goto L9;
        List<String> r2 = r1.getColor();
        if (r2 == null) goto L9;
        return (String) CollectionsKt.firstOrNull(r2);
    L9:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Integer c() {
        ECLiveSkinBaseViewUIConfig r0 = H();
        if (r0 == null) goto L7;
        ECLiveSkinTextElement r1 = r0.getText();
        if (r1 == null) goto L7;
        return Integer.valueOf(r1.getFontSize());
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final String g() {
        ECLiveSkinPriceUIConfig r0 = J();
        if (r0 == null) goto L7;
        List<String> r1 = r0.getColor();
        if (r1 == null) goto L7;
        return (String) CollectionsKt.firstOrNull(r1);
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Integer h() {
        ECLiveSkinPriceUIConfig r0 = J();
        if (r0 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r0.getPrefixFontSize());
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Integer i() {
        ECLiveSkinPriceUIConfig r0 = J();
        if (r0 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r0.getYuanTagFontSize());
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Integer j() {
        ECLiveSkinPriceUIConfig r0 = J();
        if (r0 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r0.getSuffixFontSize());
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Integer m() {
        ECLiveSkinPriceUIConfig r0 = J();
        if (r0 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r0.getIntegerFontSize());
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Integer q() {
        ECLiveSkinPriceUIConfig r0 = I();
        if (r0 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r0.getDecimalFontSize());
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Integer r() {
        ECLiveSkinPriceUIConfig r0 = I();
        if (r0 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r0.getPrefixFontSize());
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final String s() {
        ECLiveSkinBaseViewUIConfig r0 = H();
        if (r0 == null) goto L12;
        ECLiveSkinImageElement r1 = r0.getImage();
        if (r1 == null) goto L12;
        String r2 = r1.getResourceName();
        if (r2 == null) goto L12;
        ECLiveSkinUtil.l.getClass();
        String r3 = ECLiveSkinUtil.b.get(r2);
        if (r3 != null) goto L14;
        return r2;
    L14:
        return r3;
    L12:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Integer z() {
        ECLiveSkinPriceUIConfig r0 = J();
        if (r0 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r0.getDecimalFontSize());
    }

    public d(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "themes");
        this.b = r2;
        ECLiveSkinUtil.l.getClass();
        this.a = ECLiveSkinUtil.f("promotion_card", r2);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Integer F(boolean r3) {
        ECLiveSkinBaseViewUIConfig r4 = G("add_cart_btn", r3);
        if (r4 == null) goto L7;
        ECLiveSkinImageElement r5 = r4.getImage();
        if (r5 == null) goto L7;
        String r6 = r5.getResourceName();
    L8:
        if (r6 != null) goto L15;
        return null;
    L15:
        ECLiveSkinUtil.l.getClass();     // Catch: Exception -> L12
        return ECLiveSkinUtil.b(r6);
    L12:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return null;
    L7:
        r6 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final String d(boolean r2) {
        ECLiveSkinBaseViewUIConfig r3 = G("stepper_add", r2);
        if (r3 == null) goto L7;
        ECLiveSkinImageElement r4 = r3.getImage();
        if (r4 == null) goto L7;
        return r4.getUrl();
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Drawable n(boolean r4) {
        ECLiveSkinBaseViewUIConfig r5 = G("buy_btn", r4);
        if (r5 == null) goto L5;
        ECLiveSkinBackgroundElement r6 = r5.getBackground();
    L6:
        if (r6 != null) goto L8;
        return null;
    L8:
        return ECLiveSkinBackgroundElement.a.b(ECLiveSkinBackgroundElement.Companion, r6, null, null, 6);
    L5:
        r6 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.i
    public final Drawable o(boolean r4) {
        ECLiveSkinBaseViewUIConfig r5 = G("add_cart_btn", r4);
        if (r5 == null) goto L5;
        ECLiveSkinBackgroundElement r6 = r5.getBackground();
    L6:
        if (r6 != null) goto L8;
        return null;
    L8:
        return ECLiveSkinBackgroundElement.a.b(ECLiveSkinBackgroundElement.Companion, r6, null, null, 6);
    L5:
        r6 = null;
        goto L6
    }

    public final ECLiveSkinBaseViewUIConfig G(String r3, boolean r4) {
        Map<String, ? extends AbsECLiveSkinBaseUIConfig> r0 = this.a;
        if (r0 == null) goto L5;
        AbsECLiveSkinBaseUIConfig r5 = r0.get(r3);
    L7:
        if ((r5 instanceof ECLiveSkinBtnUIConfig) == true) goto L9;
        r5 = null;
    L9:
        ECLiveSkinBtnUIConfig r6 = (ECLiveSkinBtnUIConfig) r5;
        if (r6 != null) goto L12;
        return null;
    L12:
        if (r4 == false) goto L15;
        return r6.getEnabled();
    L15:
        return r6.getDisabled();
    L5:
        r5 = null;
        goto L7
    }
}
