package com.bytedance.android.livesdk.livecommerce.skin;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.livesdk.livecommerce.largemode.model.ComponentLargeModeConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.AbsECLiveSkinBaseUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinBackgroundElement;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinBaseViewUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinTabUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinTextElement;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECLiveListSkinUIHelper implements f {
    public Map<String, ? extends AbsECLiveSkinBaseUIConfig> a;
    public final d b;
    public final Lazy c;
    public List<String> d;
    public final com.bytedance.android.livesdk.livecommerce.largemode.b e;

    @Override // com.bytedance.android.livesdk.livecommerce.skin.f
    public final b f() {
        return (b) this.c.getValue();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.f
    public final List g() {
        Map<String, ? extends AbsECLiveSkinBaseUIConfig> r0 = this.a;
        if (r0 == null) goto L5;
        AbsECLiveSkinBaseUIConfig r1 = r0.get("tab");
    L7:
        if ((r1 instanceof ECLiveSkinTabUIConfig) == true) goto L9;
        r1 = null;
    L9:
        ECLiveSkinTabUIConfig r2 = (ECLiveSkinTabUIConfig) r1;
        if (r2 != null) goto L13;
        return null;
    L13:
        return r2.getRadius();
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.f
    public final d b() {
        return this.b;
    }

    public final void h(List<String> r4) {
        Intrinsics.checkNotNullParameter(r4, "themes");
        ECLiveSkinUtil r1 = ECLiveSkinUtil.l;
        List<String> r2 = this.d;
        r1.getClass();
        if ((!Intrinsics.areEqual(ECLiveSkinUtil.h(r2), ECLiveSkinUtil.h(r4))) == false) goto L8;
        this.d = r4;
        this.a = ECLiveSkinUtil.f("list", r4);
        d r5 = this.b;
        List<String> r3 = this.d;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r3, "themes");
        if ((!Intrinsics.areEqual(ECLiveSkinUtil.h(r5.b), ECLiveSkinUtil.h(r3))) == false) goto L9;
        r5.b = r3;
        r5.a = ECLiveSkinUtil.f("promotion_card", r3);
        return;
    L9:
        return;
    }

    public ECLiveListSkinUIHelper(List<String> r2, com.bytedance.android.livesdk.livecommerce.largemode.b r3) {
        Intrinsics.checkNotNullParameter(r2, "themes");
        this.d = r2;
        this.e = r3;
        ECLiveSkinUtil.l.getClass();
        this.a = ECLiveSkinUtil.f("list", r2);
        this.b = new d(this.d);
        this.c = LazyKt.lazy(ECLiveListSkinUIHelper$listTabEnhanceHelper$2.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.f
    public final Integer a(boolean r4, boolean r5) {
        Map<String, ? extends AbsECLiveSkinBaseUIConfig> r0 = this.a;
        if (r0 == null) goto L5;
        AbsECLiveSkinBaseUIConfig r1 = r0.get("tab");
    L7:
        if ((r1 instanceof ECLiveSkinTabUIConfig) == true) goto L9;
        r1 = null;
    L9:
        ECLiveSkinTabUIConfig r2 = (ECLiveSkinTabUIConfig) r1;
        if (r2 != null) goto L13;
        return null;
    L13:
        if (r4 == true) goto L29;
        com.bytedance.android.livesdk.livecommerce.largemode.b r6 = this.e;
        if (r6 == null) goto L24;
        ComponentLargeModeConfig r7 = r6.b("List", "List.Tab.Text.Disabled");
        if (r7 == null) goto L24;
        hi2.a r8 = r7.getTextConfig();
        if (r8 == null) goto L24;
        Integer r9 = r8.a();
        if (r9 == null) goto L24;
    L57:
        return r9;
    L24:
        ECLiveSkinBaseViewUIConfig r10 = r2.getDisabled();
        if (r10 == null) goto L58;
        ECLiveSkinTextElement r11 = r10.getText();
        if (r11 != null) goto L60;
        return null;
    L60:
        return Integer.valueOf(r11.getFontSize());
    L58:
        return null;
    L29:
        if (r5 == false) goto L43;
        com.bytedance.android.livesdk.livecommerce.largemode.b r12 = this.e;
        if (r12 == null) goto L38;
        ComponentLargeModeConfig r13 = r12.b("List", "List.Tab.Text.Selected");
        if (r13 == null) goto L38;
        hi2.a r14 = r13.getTextConfig();
        if (r14 == null) goto L38;
        r9 = r14.a();
        if (r9 != null) goto L57;
    L38:
        ECLiveSkinBaseViewUIConfig r15 = r2.getSelected();
        if (r15 == null) goto L61;
        ECLiveSkinTextElement r16 = r15.getText();
        if (r16 != null) goto L63;
        return null;
    L63:
        return Integer.valueOf(r16.getFontSize());
    L61:
        return null;
    L43:
        com.bytedance.android.livesdk.livecommerce.largemode.b r17 = this.e;
        if (r17 == null) goto L51;
        ComponentLargeModeConfig r18 = r17.b("List", "List.Tab.Text.Unselected");
        if (r18 == null) goto L51;
        hi2.a r19 = r18.getTextConfig();
        if (r19 == null) goto L51;
        r9 = r19.a();
        if (r9 != null) goto L57;
    L51:
        ECLiveSkinBaseViewUIConfig r20 = r2.getUnselected();
        if (r20 == null) goto L64;
        ECLiveSkinTextElement r21 = r20.getText();
        if (r21 != null) goto L56;
        return null;
    L56:
        return Integer.valueOf(r21.getFontSize());
    L64:
        return null;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.f
    public final Integer c(boolean r4, boolean r5) {
        Map<String, ? extends AbsECLiveSkinBaseUIConfig> r0 = this.a;
        String r1 = null;
        if (r0 == null) goto L5;
        AbsECLiveSkinBaseUIConfig r2 = r0.get("tab");
    L7:
        if ((r2 instanceof ECLiveSkinTabUIConfig) == true) goto L9;
        r2 = null;
    L9:
        ECLiveSkinTabUIConfig r3 = (ECLiveSkinTabUIConfig) r2;
        if (r3 != null) goto L12;
        return null;
    L12:
        if (r4 == true) goto L21;
        int r6 = s.a;
        ECLiveSkinBaseViewUIConfig r7 = r3.getDisabled();
        if (r7 == null) goto L39;
        ECLiveSkinTextElement r8 = r7.getText();
        if (r8 == null) goto L39;
        List<String> r9 = r8.getColor();
        if (r9 == null) goto L39;
        r1 = (String) CollectionsKt.firstOrNull(r9);
    L39:
        return s.b(r1);
    L21:
        if (r5 == false) goto L30;
        int r10 = s.a;
        ECLiveSkinBaseViewUIConfig r11 = r3.getSelected();
        if (r11 == null) goto L40;
        ECLiveSkinTextElement r12 = r11.getText();
        if (r12 == null) goto L40;
        List<String> r13 = r12.getColor();
        if (r13 == null) goto L40;
        r1 = (String) CollectionsKt.firstOrNull(r13);
    L40:
        return s.b(r1);
    L30:
        int r14 = s.a;
        ECLiveSkinBaseViewUIConfig r15 = r3.getUnselected();
        if (r15 == null) goto L38;
        ECLiveSkinTextElement r16 = r15.getText();
        if (r16 == null) goto L38;
        List<String> r17 = r16.getColor();
        if (r17 == null) goto L38;
        r1 = (String) CollectionsKt.firstOrNull(r17);
    L38:
        return s.b(r1);
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.f
    public final ECLiveSkinBackgroundElement e(boolean r4, boolean r5) {
        Map<String, ? extends AbsECLiveSkinBaseUIConfig> r0 = this.a;
        if (r0 == null) goto L5;
        AbsECLiveSkinBaseUIConfig r1 = r0.get("tab");
    L7:
        if ((r1 instanceof ECLiveSkinTabUIConfig) == true) goto L9;
        r1 = null;
    L9:
        ECLiveSkinTabUIConfig r2 = (ECLiveSkinTabUIConfig) r1;
        if (r2 != null) goto L12;
        return null;
    L12:
        if (r4 == true) goto L16;
        ECLiveSkinBaseViewUIConfig r6 = r2.getDisabled();
        if (r6 != null) goto L25;
        return null;
    L25:
        return r6.getBackground();
    L16:
        if (r5 == false) goto L20;
        ECLiveSkinBaseViewUIConfig r7 = r2.getSelected();
        if (r7 != null) goto L27;
        return null;
    L27:
        return r7.getBackground();
    L20:
        ECLiveSkinBaseViewUIConfig r8 = r2.getUnselected();
        if (r8 != null) goto L23;
        return null;
    L23:
        return r8.getBackground();
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.f
    public final Drawable d(Context r4, boolean r5, boolean r6, ECDraweeView r7) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Map<String, ? extends AbsECLiveSkinBaseUIConfig> r0 = this.a;
        if (r0 == null) goto L5;
        AbsECLiveSkinBaseUIConfig r1 = r0.get("tab");
    L7:
        if ((r1 instanceof ECLiveSkinTabUIConfig) == true) goto L10;
        r1 = null;
    L10:
        if (((ECLiveSkinTabUIConfig) r1) != null) goto L12;
        return null;
    L12:
        ECLiveSkinBackgroundElement r8 = e(r5, r6);
        if (r8 != null) goto L15;
        return null;
    L15:
        return ECLiveSkinBackgroundElement.a.b(ECLiveSkinBackgroundElement.Companion, r8, r4, r7, 2);
    L5:
        r1 = null;
        goto L7
    }
}
