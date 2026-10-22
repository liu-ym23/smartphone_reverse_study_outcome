package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ecom.arch.slice.SlcContext;
import com.bytedance.android.ecom.arch.slice.action.ActionContext;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryVO;
import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.b0;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.AnchorV4HeadV2View;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l extends com.bytedance.android.shopping.anchorv4.voavhs.head.k implements com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.v {
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.e b;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.k, d83.c
    public final View e() {
        return this.b.m;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.v
    public final List<String> getImages() {
        AnchorV4HeadV2VO r0 = this.b.e;
        if (r0 == null) goto L24;
        List<HeaderContentModel> r1 = r0.getCells();
        if (r1 == null) goto L25;
        List<HeaderContentModel> r2 = r1;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L8:
        if (r4.hasNext() == false) goto L20;
        HeaderMediaModel r5 = ((HeaderContentModel) r4.next()).getMedia();
        if (r5 == null) goto L17;
        ECUrlModel r6 = HeaderMediaModel.getImageUrl$default(r5, false, 1, null);
        if (r6 == null) goto L17;
        List r7 = r6.getUrlList();
        if (r7 == null) goto L17;
        String r8 = (String) CollectionsKt.getOrNull(r7, 0);
        if (r8 == null) goto L17;
    L18:
        r3.add(r8);
    L17:
        r8 = "";
        goto L18
    L20:
        return r3;
    L25:
        return null;
    L24:
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.v
    public final Rect m9() {
        RecyclerView r0 = this.b.m;
        if (r0 != null) goto L7;
        return null;
    L7:
        return new Rect(r0.getLeft(), r0.getTop(), r0.getLeft() + r0.getWidth(), r0.getTop() + r0.getHeight());
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.v
    public final ActionContext n0() {
        SlcContext r0 = this.b.h.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.r0;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.v
    public final float n9() {
        return this.b.s00();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.v
    public final SlcContext q9() {
        return this.b.h.b;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.v
    public final void r9() {
        this.b.g.d = true;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.v
    public final boolean s() {
        return this.b.s();
    }

    public l(com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.e r2) {
        Intrinsics.checkNotNullParameter(r2, "headAbility");
        super(r2);
        this.b = r2;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.v
    public final void k0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "targetSliceId");
        this.b.k0(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.v
    public final void l9(GalleryVO r2) {
        Intrinsics.checkNotNullParameter(r2, "galleryVO");
        this.b.l9(r2);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.v
    public final void s9(int r7) {
        View r0 = this.b.E;
        if ((r0 instanceof i83.c) == true) goto L5;
        r0 = null;
    L5:
        i83.c r1 = (i83.c) r0;
        if (r1 == null) goto L18;
        AnchorV4HeadV2View r2 = r1.getHeadView();
        if (r2 == null) goto L22;
        RecyclerView r3 = r2.b;
        int r4 = r3.getChildCount();
        int r5 = 0;
    L10:
        if (r5 >= r4) goto L23;
        Object r6 = r3.getChildAt(r5);
        if ((r6 instanceof w) == true) goto L14;
        r6 = null;
    L14:
        w r8 = (w) r6;
        if (r8 == null) goto L17;
        r8.y(r7);
    L17:
        r5 = r5 + 1;
        goto L10
    L23:
        return;
    L22:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.v
    public final void t(b0 r7) {
        Intrinsics.checkNotNullParameter(r7, "info");
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.e r0 = this.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r7, "playerEventInfo");
        Object r1 = r7.c.get("identifier");
        AnchorV4Param r2 = r0.rR().c();
        Object r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.getSessionId();
    L7:
        if (Intrinsics.areEqual(r1, r4) == false) goto L54;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.l r5 = r0.g.c(r0.getCurrentPosition());
        if (r5 == null) goto L56;
        x73.a r6 = r5.e;
        if (r6 == null) goto L57;
        String r8 = r7.b;
        int r9 = r8.hashCode();
        if (r9 == (-140225600)) goto L21;
        if (r9 == 1983683869) goto L18;
        return;
    L18:
        if (r8.equals("PDPChangeHeaderTabViewHiddenStatus") == false) goto L58;
        r0.f.a(Intrinsics.areEqual(r7.c.get("status"), "hidden"));
        return;
    L58:
        return;
    L21:
        if (r8.equals("PDPPlayerControl") == false) goto L60;
        Object r10 = r7.c.get("command");
        if ((r10 instanceof String) == false) goto L26;
        r3 = r10;
    L26:
        String r11 = (String) r3;
        if (r11 != null) goto L30;
        r11 = "";
    L30:
        switch(r11.hashCode()) {
            case 3363353: goto L52;
            case 3443508: goto L47;
            case 3526264: goto L39;
            case 3540994: goto L37;
            case 106440182: goto L33;
            default: goto L74;
        };
    L37:
        r11.equals("stop");
        return;
    L74:
        return;
    L33:
        if (r11.equals("pause") == true) goto L35;
        return;
    L35:
        if (r6.isPlaying() == false) goto L62;
        r6.pausePlay();
        return;
    L62:
        return;
    L39:
        if (r11.equals("seek") == false) goto L65;
        Object r12 = r7.c.get("progress");
        float r13 = 0.0f;
        if (r12 == null) goto L44;
        r13 = com.bytedance.android.ecom.arch.slice.render.util.b.c(r12, 0.0f);
    L44:
        if (r13 <= 0) goto L66;
        r6.seek(r13);
        return;
    L66:
        return;
    L65:
        return;
    L47:
        if (r11.equals("play") == true) goto L49;
        return;
    L49:
        if (r6.isPlaying() == true) goto L69;
        r6.startPlay();
        return;
    L69:
        return;
    L52:
        if (r11.equals("mute") == false) goto L71;
        r6.f(Intrinsics.areEqual(r7.c.get("mute"), 1), false);
        return;
    L71:
        return;
    L60:
        return;
    L57:
        return;
    L56:
        return;
    L54:
        dm.a.a("HeadAbilityManager").b("handelLynxPlayerEvent, not match identifier", null);
        return;
    L5:
        r4 = null;
        goto L7
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.v
    public final void w5(Map<Integer, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "galleryFindSameSchemaMap");
        this.b.w5(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.v
    public final void x(com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.b.f.x(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.v
    public final void y5(String r2) {
        Intrinsics.checkNotNullParameter(r2, "specId");
        this.b.y5(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.v
    public final void z5(boolean r2) {
        this.b.p = r2;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.v
    public final void l0(int r2, String r3) {
        this.b.l0(r2, r3);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.v
    public final boolean m0(Boolean r2, boolean r3) {
        return this.b.g.g(r2, r3);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.v
    public final void o9(boolean r2, int r3) {
        this.b.f.d(r2, r3);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.v
    public final void p9(com.bytedance.android.ecom.arch.slice.g r6, IAction r7, View r8, Map<String, ? extends Object> r9) {
        Intrinsics.checkNotNullParameter(r7, "action");
        SlcContext r1 = this.b.h.b;
        if (r1 == null) goto L37;
        Intrinsics.checkNotNullParameter(r1, "$this$handleAction");
        Intrinsics.checkNotNullParameter(r7, "action");
        int r2 = 0;
        if (r9 == null) goto L7;
        int r3 = r9.size();
    L8:
        if (r6 == null) goto L14;
        com.bytedance.android.ecom.arch.slice.p r4 = r6.getParent();
        if (r4 == null) goto L14;
        Map r5 = r4.getTrackMeta();
        if (r5 == null) goto L14;
        int r10 = r5.size();
    L15:
        int r11 = r3 + r10;
        if (r6 == null) goto L20;
        Map r12 = r6.getTrackMeta();
        if (r12 == null) goto L20;
        r2 = r12.size();
    L20:
        HashMap r0 = new HashMap((int) (((r11 + r2) / 0.75f) + 1.0f));
        if (r9 == null) goto L23;
        r0.putAll(r9);
    L23:
        if (r6 == null) goto L29;
        com.bytedance.android.ecom.arch.slice.p r13 = r6.getParent();
        if (r13 == null) goto L29;
        Map r14 = r13.getTrackMeta();
        if (r14 == null) goto L29;
        r0.putAll(r14);
    L29:
        if (r6 == null) goto L33;
        Map r15 = r6.getTrackMeta();
        if (r15 == null) goto L33;
        r0.putAll(r15);
    L33:
        ActionContext r16 = r1.r0;
        if (r16 == null) goto L38;
        com.bytedance.android.ecom.arch.slice.action.c r17 = new com.bytedance.android.ecom.arch.slice.action.c(r8, r0);
        com.bytedance.android.ecom.arch.slice.action.b.g(r17, r1);
        com.bytedance.android.ecom.arch.slice.action.b.h(r17, r6);
        Unit r18 = Unit.INSTANCE;
        int r19 = ActionContext.h;
        r16.b(r7, r17, null);
        return;
    L38:
        return;
    L14:
        r10 = 0;
        goto L15
    L7:
        r3 = 0;
        goto L8
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.v
    public final void z(View r2, String r3, Map<String, ? extends Object> r4, Map<String, ? extends Object> r5) {
        this.b.n(r2, r3, r4, r5);
    }
}
