package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import android.view.ViewGroup;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.nav.controls.TopRightControlsMeta;
import com.bytedance.android.shopping.anchorv4.nav.controls.TopRightControlsVO;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.TagsScrollBoxComponentView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class z extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
    public final /* synthetic */ TopRightControlsComponent c;
    public final /* synthetic */ TopRightControlsVO d;

    @Override // java.lang.Runnable
    public final void run() {
        if (com.bytedance.android.shopping.anchorv4.experiment.e.a() == true) goto L10;
        ViewGroup r1 = this.c.d;
        if (r1 == null) goto L7;
        r1.setVisibility(0);
    L7:
        TagsScrollBoxComponentView r2 = this.c.e;
        if (r2 == null) goto L10;
        TagsScrollBoxComponentView.b(r2, this.d.getLightElements(), this.d.getShowExtraElement(), 12);
    L10:
        TagsScrollBoxComponent r3 = new TagsScrollBoxComponent(null, null, 0, 0, null, false, 0, null, null, null, 1023, null);
        TagsScrollBoxComponent r4 = this.d.getLightElements();
        TopRightControlsMeta r5 = null;
        if (r4 == null) goto L34;
        List r6 = r4.getButtonList();
        if (r6 == null) goto L34;
        ArrayList r7 = new ArrayList();
        Iterator r8 = r6.iterator();
    L16:
        if (r8.hasNext() == false) goto L35;
        Object r9 = r8.next();
        TextWithOneIconElement r10 = (TextWithOneIconElement) r9;
        Action r11 = r10.getAction();
        if (r11 == null) goto L20;
        String r12 = r11.getId();
    L22:
        if (Intrinsics.areEqual(r12, "action_share") == true) goto L31;
        Action r13 = r10.getAction();
        if (r13 == null) goto L26;
        String r14 = r13.getId();
    L28:
        if (Intrinsics.areEqual(r14, "action_collect") == true) goto L31;
        boolean r15 = false;
    L32:
        if (r15 == false) goto L16;
        r7.add(r9);
        goto L16
    L26:
        r14 = null;
    L31:
        r15 = true;
        goto L32
    L20:
        r12 = null;
    L35:
        r3.setButtonList(r7);
        TagsScrollBoxComponentView r16 = this.c.f;
        if (r16 == null) goto L38;
        TagsScrollBoxComponentView.b(r16, r3, null, 14);
    L38:
        TopRightControlsComponent r17 = this.c;
        TagsScrollBoxComponentView r18 = r17.e;
        TagsScrollBoxComponent r19 = this.d.getLightElements();
        TopRightControlsVO r20 = this.c.a;
        if (r20 == null) goto L41;
        r5 = r20.getTopRightMeta();
    L41:
        TopRightControlsMeta r21 = r5;
        TopRightControlsComponent r22 = this.c;
        TopRightWidgetController r23 = new TopRightWidgetController(r18, r19, r21, r22.l, r22.c);
        Iterator<T> r24 = r23.b.iterator();
    L43:
        if (r24.hasNext() == false) goto L45;
        ((com.bytedance.android.shopping.anchorv4.nav.controls.d) r24.next()).a();
        goto L43
    L45:
        Unit r25 = Unit.INSTANCE;
        r17.b = r23;
        TopRightControlsComponent r26 = this.c;
        TagsScrollBoxComponentView r27 = r26.e;
        if (r27 == null) goto L48;
        ExtensionsKt.e(r27, r26);
    L48:
        TopRightControlsComponent r28 = this.c;
        TagsScrollBoxComponentView r29 = r28.h;
        if (r29 == null) goto L51;
        ExtensionsKt.e(r29, r28);
    L51:
        TopRightControlsComponent r30 = this.c;
        TagsScrollBoxComponentView r31 = r30.f;
        if (r31 == null) goto L54;
        ExtensionsKt.e(r31, r30);
    L54:
        TopRightControlsComponent r32 = this.c;
        r32.c.q(r32, this.d, 0);
        return;
    L34:
        r7 = null;
        goto L35
    }

    public z(TopRightControlsComponent r1, TopRightControlsVO r2) {
        this.c = r1;
        this.d = r2;
        super("bindIconsInnerOpt_AfterReportFirstFrame");
    }
}
