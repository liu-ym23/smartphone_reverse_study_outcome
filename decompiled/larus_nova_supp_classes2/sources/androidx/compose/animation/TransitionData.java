package androidx.compose.animation;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0018\b\u0002\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003J\u0019\u0010#\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u000f0\rHÆ\u0003J]\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0018\b\u0002\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u000f0\rHÆ\u0001J\u0013\u0010%\u001a\u00020\u000b2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR!\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006+"}, d2 = {"Landroidx/compose/animation/TransitionData;", "", "fade", "Landroidx/compose/animation/Fade;", "slide", "Landroidx/compose/animation/Slide;", "changeSize", "Landroidx/compose/animation/ChangeSize;", "scale", "Landroidx/compose/animation/Scale;", "hold", "", "effectsMap", "", "Landroidx/compose/animation/TransitionEffectKey;", "Landroidx/compose/animation/TransitionEffect;", "<init>", "(Landroidx/compose/animation/Fade;Landroidx/compose/animation/Slide;Landroidx/compose/animation/ChangeSize;Landroidx/compose/animation/Scale;ZLjava/util/Map;)V", "getFade", "()Landroidx/compose/animation/Fade;", "getSlide", "()Landroidx/compose/animation/Slide;", "getChangeSize", "()Landroidx/compose/animation/ChangeSize;", "getScale", "()Landroidx/compose/animation/Scale;", "getHold", "()Z", "getEffectsMap", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TransitionData {
    public static final int $stable = 0;
    private final ChangeSize changeSize;
    private final Map<TransitionEffectKey<?>, TransitionEffect> effectsMap;
    private final Fade fade;
    private final boolean hold;
    private final Scale scale;
    private final Slide slide;

    public TransitionData() {
        this(null, null, null, null, false, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TransitionData copy$default(TransitionData r4, Fade r5, Slide r6, ChangeSize r7, Scale r8, boolean r9, Map r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.fade;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.slide;
    L8:
        Slide r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.changeSize;
    L11:
        ChangeSize r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.scale;
    L14:
        Scale r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.hold;
    L17:
        boolean r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.effectsMap;
    L20:
        Fade r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final Fade component1() {
        return this.fade;
    }

    public final Slide component2() {
        return this.slide;
    }

    public final ChangeSize component3() {
        return this.changeSize;
    }

    public final Scale component4() {
        return this.scale;
    }

    public final boolean component5() {
        return this.hold;
    }

    public final Map<TransitionEffectKey<?>, TransitionEffect> component6() {
        return this.effectsMap;
    }

    public final TransitionData copy(Fade r9, Slide r10, ChangeSize r11, Scale r12, boolean r13, Map<TransitionEffectKey<?>, ? extends TransitionEffect> r14) {
        return new TransitionData(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TransitionData) == true) goto L8;
        return false;
    L8:
        TransitionData r6 = (TransitionData) r5;
        if (Intrinsics.areEqual(this.fade, r6.fade) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.slide, r6.slide) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.changeSize, r6.changeSize) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.scale, r6.scale) == true) goto L21;
        return false;
    L21:
        if (this.hold == r6.hold) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.effectsMap, r6.effectsMap) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        Fade r0 = this.fade;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Slide r4 = this.slide;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        ChangeSize r7 = this.changeSize;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Scale r10 = this.scale;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        int r11 = (r9 + r1) * 31;
        if (this.hold == false) goto L21;
        int r12 = 1231;
    L23:
        return ((r11 + r12) * 31) + this.effectsMap.hashCode();
    L21:
        r12 = 1237;
        goto L23
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "TransitionData(fade=" + this.fade + ", slide=" + this.slide + ", changeSize=" + this.changeSize + ", scale=" + this.scale + ", hold=" + this.hold + ", effectsMap=" + this.effectsMap + ')';
    }

    public final ChangeSize getChangeSize() {
        return this.changeSize;
    }

    public final Map<TransitionEffectKey<?>, TransitionEffect> getEffectsMap() {
        return this.effectsMap;
    }

    public final Fade getFade() {
        return this.fade;
    }

    public final boolean getHold() {
        return this.hold;
    }

    public final Scale getScale() {
        return this.scale;
    }

    public final Slide getSlide() {
        return this.slide;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TransitionData(Fade r1, Slide r2, ChangeSize r3, Scale r4, boolean r5, Map<TransitionEffectKey<?>, ? extends TransitionEffect> r6) {
        this.fade = r1;
        this.slide = r2;
        this.changeSize = r3;
        this.scale = r4;
        this.hold = r5;
        this.effectsMap = r6;
    }

    public /* synthetic */ TransitionData(Fade r5, Slide r6, ChangeSize r7, Scale r8, boolean r9, Map r10, int r11, DefaultConstructorMarker r12) {
        Scale r0 = null;
        if ((r11 & 1) == 0) goto L5;
        Fade r13 = null;
    L7:
        if ((r11 & 2) == 0) goto L9;
        Slide r1 = null;
    L11:
        if ((r11 & 4) == 0) goto L13;
        ChangeSize r2 = null;
    L15:
        if ((r11 & 8) != 0) goto L19;
        r0 = r8;
    L19:
        if ((r11 & 16) == 0) goto L21;
        boolean r3 = false;
    L23:
        if ((r11 & 32) == 0) goto L25;
        r10 = MapsKt.emptyMap();
    L25:
        this(r13, r1, r2, r0, r3, r10);
        return;
    L21:
        r3 = r9;
        goto L23
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r13 = r5;
        goto L7
    }
}
