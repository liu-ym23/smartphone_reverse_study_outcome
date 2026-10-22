package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b2\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u008f\u0001\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b@\u0010AJ\b\u0010B\u001a\u00020CH\u0016R+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R+\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R+\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017R+\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0019\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R+\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010\u0019\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017R+\u0010\b\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010\u0019\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017R+\u0010\t\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010\u0019\u001a\u0004\b)\u0010\u0015\"\u0004\b*\u0010\u0017R+\u0010\n\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010\u0019\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010\u0017R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b1\u0010\u0019\u001a\u0004\b/\u0010\u0015\"\u0004\b0\u0010\u0017R+\u0010\f\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b4\u0010\u0019\u001a\u0004\b2\u0010\u0015\"\u0004\b3\u0010\u0017R+\u0010\r\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b7\u0010\u0019\u001a\u0004\b5\u0010\u0015\"\u0004\b6\u0010\u0017R+\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b:\u0010\u0019\u001a\u0004\b8\u0010\u0015\"\u0004\b9\u0010\u0017R+\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00108F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b>\u0010\u0019\u001a\u0004\b\u000f\u0010;\"\u0004\b<\u0010=¨\u0006D"}, d2 = {"Landroidx/compose/material/Colors;", "", "primary", "Landroidx/compose/ui/graphics/Color;", "primaryVariant", "secondary", "secondaryVariant", "background", "surface", "error", "onPrimary", "onSecondary", "onBackground", "onSurface", "onError", "isLight", "", "<init>", "(JJJJJJJJJJJJZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "getPrimary-0d7_KjU", "()J", "setPrimary-8_81llA$material", "(J)V", "primary$delegate", "Landroidx/compose/runtime/MutableState;", "getPrimaryVariant-0d7_KjU", "setPrimaryVariant-8_81llA$material", "primaryVariant$delegate", "getSecondary-0d7_KjU", "setSecondary-8_81llA$material", "secondary$delegate", "getSecondaryVariant-0d7_KjU", "setSecondaryVariant-8_81llA$material", "secondaryVariant$delegate", "getBackground-0d7_KjU", "setBackground-8_81llA$material", "background$delegate", "getSurface-0d7_KjU", "setSurface-8_81llA$material", "surface$delegate", "getError-0d7_KjU", "setError-8_81llA$material", "error$delegate", "getOnPrimary-0d7_KjU", "setOnPrimary-8_81llA$material", "onPrimary$delegate", "getOnSecondary-0d7_KjU", "setOnSecondary-8_81llA$material", "onSecondary$delegate", "getOnBackground-0d7_KjU", "setOnBackground-8_81llA$material", "onBackground$delegate", "getOnSurface-0d7_KjU", "setOnSurface-8_81llA$material", "onSurface$delegate", "getOnError-0d7_KjU", "setOnError-8_81llA$material", "onError$delegate", "()Z", "setLight$material", "(Z)V", "isLight$delegate", "copy", "copy-pvPzIIM", "(JJJJJJJJJJJJZ)Landroidx/compose/material/Colors;", "toString", "", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Colors {
    public static final int $stable = 0;
    private final MutableState background$delegate;
    private final MutableState error$delegate;
    private final MutableState isLight$delegate;
    private final MutableState onBackground$delegate;
    private final MutableState onError$delegate;
    private final MutableState onPrimary$delegate;
    private final MutableState onSecondary$delegate;
    private final MutableState onSurface$delegate;
    private final MutableState primary$delegate;
    private final MutableState primaryVariant$delegate;
    private final MutableState secondary$delegate;
    private final MutableState secondaryVariant$delegate;
    private final MutableState surface$delegate;

    public /* synthetic */ Colors(long r1, long r3, long r5, long r7, long r9, long r11, long r13, long r15, long r17, long r19, long r21, long r23, boolean r25, DefaultConstructorMarker r26) {
        this(r1, r3, r5, r7, r9, r11, r13, r15, r17, r19, r21, r23, r25);
    }

    /* JADX INFO: renamed from: getBackground-0d7_KjU, reason: not valid java name */
    public final long m1992getBackground0d7_KjU() {
        return ((Color) this.background$delegate.getValue()).unbox-impl();
    }

    /* JADX INFO: renamed from: getError-0d7_KjU, reason: not valid java name */
    public final long m1993getError0d7_KjU() {
        return ((Color) this.error$delegate.getValue()).unbox-impl();
    }

    /* JADX INFO: renamed from: getOnBackground-0d7_KjU, reason: not valid java name */
    public final long m1994getOnBackground0d7_KjU() {
        return ((Color) this.onBackground$delegate.getValue()).unbox-impl();
    }

    /* JADX INFO: renamed from: getOnError-0d7_KjU, reason: not valid java name */
    public final long m1995getOnError0d7_KjU() {
        return ((Color) this.onError$delegate.getValue()).unbox-impl();
    }

    /* JADX INFO: renamed from: getOnPrimary-0d7_KjU, reason: not valid java name */
    public final long m1996getOnPrimary0d7_KjU() {
        return ((Color) this.onPrimary$delegate.getValue()).unbox-impl();
    }

    /* JADX INFO: renamed from: getOnSecondary-0d7_KjU, reason: not valid java name */
    public final long m1997getOnSecondary0d7_KjU() {
        return ((Color) this.onSecondary$delegate.getValue()).unbox-impl();
    }

    /* JADX INFO: renamed from: getOnSurface-0d7_KjU, reason: not valid java name */
    public final long m1998getOnSurface0d7_KjU() {
        return ((Color) this.onSurface$delegate.getValue()).unbox-impl();
    }

    /* JADX INFO: renamed from: getPrimary-0d7_KjU, reason: not valid java name */
    public final long m1999getPrimary0d7_KjU() {
        return ((Color) this.primary$delegate.getValue()).unbox-impl();
    }

    /* JADX INFO: renamed from: getPrimaryVariant-0d7_KjU, reason: not valid java name */
    public final long m2000getPrimaryVariant0d7_KjU() {
        return ((Color) this.primaryVariant$delegate.getValue()).unbox-impl();
    }

    /* JADX INFO: renamed from: getSecondary-0d7_KjU, reason: not valid java name */
    public final long m2001getSecondary0d7_KjU() {
        return ((Color) this.secondary$delegate.getValue()).unbox-impl();
    }

    /* JADX INFO: renamed from: getSecondaryVariant-0d7_KjU, reason: not valid java name */
    public final long m2002getSecondaryVariant0d7_KjU() {
        return ((Color) this.secondaryVariant$delegate.getValue()).unbox-impl();
    }

    /* JADX INFO: renamed from: getSurface-0d7_KjU, reason: not valid java name */
    public final long m2003getSurface0d7_KjU() {
        return ((Color) this.surface$delegate.getValue()).unbox-impl();
    }

    public final boolean isLight() {
        return ((Boolean) this.isLight$delegate.getValue()).booleanValue();
    }

    public String toString() {
        return "Colors(primary=" + Color.toString-impl(m1999getPrimary0d7_KjU()) + ", primaryVariant=" + Color.toString-impl(m2000getPrimaryVariant0d7_KjU()) + ", secondary=" + Color.toString-impl(m2001getSecondary0d7_KjU()) + ", secondaryVariant=" + Color.toString-impl(m2002getSecondaryVariant0d7_KjU()) + ", background=" + Color.toString-impl(m1992getBackground0d7_KjU()) + ", surface=" + Color.toString-impl(m2003getSurface0d7_KjU()) + ", error=" + Color.toString-impl(m1993getError0d7_KjU()) + ", onPrimary=" + Color.toString-impl(m1996getOnPrimary0d7_KjU()) + ", onSecondary=" + Color.toString-impl(m1997getOnSecondary0d7_KjU()) + ", onBackground=" + Color.toString-impl(m1994getOnBackground0d7_KjU()) + ", onSurface=" + Color.toString-impl(m1998getOnSurface0d7_KjU()) + ", onError=" + Color.toString-impl(m1995getOnError0d7_KjU()) + ", isLight=" + isLight() + ')';
    }

    /* JADX INFO: renamed from: setBackground-8_81llA$material, reason: not valid java name */
    public final void m2004setBackground8_81llA$material(long r2) {
        this.background$delegate.setValue(Color.box-impl(r2));
    }

    /* JADX INFO: renamed from: setError-8_81llA$material, reason: not valid java name */
    public final void m2005setError8_81llA$material(long r2) {
        this.error$delegate.setValue(Color.box-impl(r2));
    }

    public final void setLight$material(boolean r2) {
        this.isLight$delegate.setValue(Boolean.valueOf(r2));
    }

    /* JADX INFO: renamed from: setOnBackground-8_81llA$material, reason: not valid java name */
    public final void m2006setOnBackground8_81llA$material(long r2) {
        this.onBackground$delegate.setValue(Color.box-impl(r2));
    }

    /* JADX INFO: renamed from: setOnError-8_81llA$material, reason: not valid java name */
    public final void m2007setOnError8_81llA$material(long r2) {
        this.onError$delegate.setValue(Color.box-impl(r2));
    }

    /* JADX INFO: renamed from: setOnPrimary-8_81llA$material, reason: not valid java name */
    public final void m2008setOnPrimary8_81llA$material(long r2) {
        this.onPrimary$delegate.setValue(Color.box-impl(r2));
    }

    /* JADX INFO: renamed from: setOnSecondary-8_81llA$material, reason: not valid java name */
    public final void m2009setOnSecondary8_81llA$material(long r2) {
        this.onSecondary$delegate.setValue(Color.box-impl(r2));
    }

    /* JADX INFO: renamed from: setOnSurface-8_81llA$material, reason: not valid java name */
    public final void m2010setOnSurface8_81llA$material(long r2) {
        this.onSurface$delegate.setValue(Color.box-impl(r2));
    }

    /* JADX INFO: renamed from: setPrimary-8_81llA$material, reason: not valid java name */
    public final void m2011setPrimary8_81llA$material(long r2) {
        this.primary$delegate.setValue(Color.box-impl(r2));
    }

    /* JADX INFO: renamed from: setPrimaryVariant-8_81llA$material, reason: not valid java name */
    public final void m2012setPrimaryVariant8_81llA$material(long r2) {
        this.primaryVariant$delegate.setValue(Color.box-impl(r2));
    }

    /* JADX INFO: renamed from: setSecondary-8_81llA$material, reason: not valid java name */
    public final void m2013setSecondary8_81llA$material(long r2) {
        this.secondary$delegate.setValue(Color.box-impl(r2));
    }

    /* JADX INFO: renamed from: setSecondaryVariant-8_81llA$material, reason: not valid java name */
    public final void m2014setSecondaryVariant8_81llA$material(long r2) {
        this.secondaryVariant$delegate.setValue(Color.box-impl(r2));
    }

    /* JADX INFO: renamed from: setSurface-8_81llA$material, reason: not valid java name */
    public final void m2015setSurface8_81llA$material(long r2) {
        this.surface$delegate.setValue(Color.box-impl(r2));
    }

    private Colors(long r4, long r6, long r8, long r10, long r12, long r14, long r16, long r18, long r20, long r22, long r24, long r26, boolean r28) {
        this.primary$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(r4), SnapshotStateKt.structuralEqualityPolicy());
        this.primaryVariant$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(r6), SnapshotStateKt.structuralEqualityPolicy());
        this.secondary$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(r8), SnapshotStateKt.structuralEqualityPolicy());
        this.secondaryVariant$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(r10), SnapshotStateKt.structuralEqualityPolicy());
        this.background$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(r12), SnapshotStateKt.structuralEqualityPolicy());
        this.surface$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(r14), SnapshotStateKt.structuralEqualityPolicy());
        this.error$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(r16), SnapshotStateKt.structuralEqualityPolicy());
        this.onPrimary$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(r18), SnapshotStateKt.structuralEqualityPolicy());
        this.onSecondary$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(r20), SnapshotStateKt.structuralEqualityPolicy());
        this.onBackground$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(r22), SnapshotStateKt.structuralEqualityPolicy());
        this.onSurface$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(r24), SnapshotStateKt.structuralEqualityPolicy());
        this.onError$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(r26), SnapshotStateKt.structuralEqualityPolicy());
        this.isLight$delegate = SnapshotStateKt.mutableStateOf(Boolean.valueOf(r28), SnapshotStateKt.structuralEqualityPolicy());
    }

    /* JADX INFO: renamed from: copy-pvPzIIM, reason: not valid java name */
    public final Colors m1991copypvPzIIM(long r29, long r31, long r33, long r35, long r37, long r39, long r41, long r43, long r45, long r47, long r49, long r51, boolean r53) {
        return new Colors(r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, null);
    }

    /* JADX INFO: renamed from: copy-pvPzIIM$default, reason: not valid java name */
    public static /* synthetic */ Colors m1990copypvPzIIM$default(Colors r17, long r18, long r20, long r22, long r24, long r26, long r28, long r30, long r32, long r34, long r36, long r38, long r40, boolean r42, int r43, Object r44) {
        if ((r43 & 1) == 0) goto L5;
        long r1 = r17.m1999getPrimary0d7_KjU();
    L7:
        if ((r43 & 2) == 0) goto L9;
        long r3 = r17.m2000getPrimaryVariant0d7_KjU();
    L11:
        if ((r43 & 4) == 0) goto L13;
        long r5 = r17.m2001getSecondary0d7_KjU();
    L15:
        if ((r43 & 8) == 0) goto L17;
        long r7 = r17.m2002getSecondaryVariant0d7_KjU();
    L19:
        if ((r43 & 16) == 0) goto L21;
        long r9 = r17.m1992getBackground0d7_KjU();
    L23:
        if ((r43 & 32) == 0) goto L25;
        long r11 = r17.m2003getSurface0d7_KjU();
    L27:
        if ((r43 & 64) == 0) goto L29;
        long r13 = r17.m1993getError0d7_KjU();
    L31:
        if ((r43 & 128) == 0) goto L33;
        long r15 = r17.m1996getOnPrimary0d7_KjU();
    L34:
        long r33 = r15;
        if ((r43 & 256) == 0) goto L37;
        long r16 = r17.m1997getOnSecondary0d7_KjU();
    L38:
        long r35 = r16;
        if ((r43 & 512) == 0) goto L41;
        long r19 = r17.m1994getOnBackground0d7_KjU();
    L42:
        long r37 = r19;
        if ((r43 & 1024) == 0) goto L45;
        long r110 = r17.m1998getOnSurface0d7_KjU();
    L46:
        long r39 = r110;
        if ((r43 & 2048) == 0) goto L49;
        long r111 = r17.m1995getOnError0d7_KjU();
    L51:
        if ((r43 & 4096) == 0) goto L53;
        boolean r0 = r17.isLight();
    L55:
        return r17.m1991copypvPzIIM(r1, r3, r5, r7, r9, r11, r13, r33, r35, r37, r39, r111, r0);
    L53:
        r0 = r42;
        goto L55
    L49:
        r111 = r40;
        goto L51
    L45:
        r110 = r38;
        goto L46
    L41:
        r19 = r36;
        goto L42
    L37:
        r16 = r34;
        goto L38
    L33:
        r15 = r32;
        goto L34
    L29:
        r13 = r30;
        goto L31
    L25:
        r11 = r28;
        goto L27
    L21:
        r9 = r26;
        goto L23
    L17:
        r7 = r24;
        goto L19
    L13:
        r5 = r22;
        goto L15
    L9:
        r3 = r20;
        goto L11
    L5:
        r1 = r18;
        goto L7
    }
}
