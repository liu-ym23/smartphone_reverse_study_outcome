package androidx.compose.animation;

import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0012\u0010\u0004\u001a\u00020\u0005X \u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0001\u0012¨\u0006\u0013"}, d2 = {"Landroidx/compose/animation/EnterTransition;", "", "<init>", "()V", "data", "Landroidx/compose/animation/TransitionData;", "getData$animation", "()Landroidx/compose/animation/TransitionData;", "plus", "enter", "toString", "", "equals", "", "other", "hashCode", "", "Companion", "Landroidx/compose/animation/EnterTransitionImpl;", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class EnterTransition {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final EnterTransition None = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/animation/EnterTransition$Companion;", "", "<init>", "()V", "None", "Landroidx/compose/animation/EnterTransition;", "getNone", "()Landroidx/compose/animation/EnterTransition;", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final EnterTransition getNone() {
            return EnterTransition.access$getNone$cp();
        }
    }

    private EnterTransition() {
    }

    public /* synthetic */ EnterTransition(DefaultConstructorMarker r1) {
        this();
    }

    public abstract TransitionData getData$animation();

    static {
        Companion = new Companion(null);
        None = new EnterTransitionImpl(new TransitionData(null, null, null, null, false, null, 63, null));
    }

    public String toString() {
        if (Intrinsics.areEqual(this, None) == false) goto L5;
        return "EnterTransition.None";
    L5:
        TransitionData r0 = getData$animation();
        StringBuilder r1 = new StringBuilder("EnterTransition: \nFade - ");
        Fade r2 = r0.getFade();
        String r3 = null;
        if (r2 == null) goto L8;
        String r4 = r2.toString();
    L9:
        r1.append(r4);
        r1.append(",\nSlide - ");
        Slide r5 = r0.getSlide();
        if (r5 == null) goto L12;
        String r6 = r5.toString();
    L13:
        r1.append(r6);
        r1.append(",\nShrink - ");
        ChangeSize r7 = r0.getChangeSize();
        if (r7 == null) goto L16;
        String r8 = r7.toString();
    L17:
        r1.append(r8);
        r1.append(",\nScale - ");
        Scale r9 = r0.getScale();
        if (r9 == null) goto L20;
        r3 = r9.toString();
    L20:
        r1.append(r3);
        return r1.toString();
    L16:
        r8 = null;
        goto L17
    L12:
        r6 = null;
        goto L13
    L8:
        r4 = null;
        goto L9
    }

    public int hashCode() {
        return getData$animation().hashCode();
    }

    public static final /* synthetic */ EnterTransition access$getNone$cp() {
        return None;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof EnterTransition) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(((EnterTransition) r2).getData$animation(), getData$animation()) == false) goto L7;
        return true;
    }

    public final EnterTransition plus(EnterTransition r12) {
        Fade r1 = r12.getData$animation().getFade();
        if (r1 != null) goto L5;
        r1 = getData$animation().getFade();
    L5:
        Fade r2 = r1;
        Slide r3 = r12.getData$animation().getSlide();
        if (r3 != null) goto L8;
        r3 = getData$animation().getSlide();
    L8:
        Slide r4 = r3;
        ChangeSize r5 = r12.getData$animation().getChangeSize();
        if (r5 != null) goto L11;
        r5 = getData$animation().getChangeSize();
    L11:
        ChangeSize r6 = r5;
        Scale r7 = r12.getData$animation().getScale();
        if (r7 != null) goto L15;
        r7 = getData$animation().getScale();
    L15:
        return new EnterTransitionImpl(new TransitionData(r2, r4, r6, r7, false, MapsKt.plus(getData$animation().getEffectsMap(), r12.getData$animation().getEffectsMap()), 16, null));
    }
}
