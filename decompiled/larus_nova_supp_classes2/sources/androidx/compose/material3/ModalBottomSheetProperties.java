package androidx.compose.material3;

import androidx.compose.ui.window.SecureFlagPolicy;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u001d\b\u0016\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0007B'\b\u0016\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\nB7\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\rB\u0011\b\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u000eB\u001d\b\u0017\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u000fB-\b\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0010J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u00020\u00058G¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016¨\u0006\u001d"}, d2 = {"Landroidx/compose/material3/ModalBottomSheetProperties;", "", "<init>", "()V", "shouldDismissOnBackPress", "", "shouldDismissOnClickOutside", "(ZZ)V", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "(Landroidx/compose/ui/window/SecureFlagPolicy;ZZ)V", "isAppearanceLightStatusBars", "isAppearanceLightNavigationBars", "(ZZLandroidx/compose/ui/window/SecureFlagPolicy;ZZ)V", "(Z)V", "(Landroidx/compose/ui/window/SecureFlagPolicy;Z)V", "(ZZLandroidx/compose/ui/window/SecureFlagPolicy;Z)V", "getSecurePolicy", "()Landroidx/compose/ui/window/SecureFlagPolicy;", "getShouldDismissOnBackPress", "()Z", "isAppearanceLightStatusBars$material3", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "isAppearanceLightNavigationBars$material3", "equals", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ModalBottomSheetProperties {
    public static final int $stable = 0;
    private final Boolean isAppearanceLightNavigationBars;
    private final Boolean isAppearanceLightStatusBars;
    private final SecureFlagPolicy securePolicy;
    private final boolean shouldDismissOnBackPress;
    private final boolean shouldDismissOnClickOutside;

    public int hashCode() {
        int r0 = this.securePolicy.hashCode() * 31;
        int r2 = 1231;
        if (this.shouldDismissOnBackPress == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        Boolean r4 = this.isAppearanceLightStatusBars;
        int r5 = 0;
        if (r4 == null) goto L9;
        int r6 = r4.hashCode();
    L10:
        int r7 = (r3 + r6) * 31;
        Boolean r8 = this.isAppearanceLightNavigationBars;
        if (r8 == null) goto L13;
        r5 = r8.hashCode();
    L13:
        int r9 = (r7 + r5) * 31;
        if (this.shouldDismissOnClickOutside == true) goto L18;
        r2 = 1237;
    L18:
        return r9 + r2;
    L9:
        r6 = 0;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public ModalBottomSheetProperties() {
        this.securePolicy = SecureFlagPolicy.Inherit;
        this.shouldDismissOnBackPress = true;
        this.shouldDismissOnClickOutside = true;
        this.isAppearanceLightStatusBars = null;
        this.isAppearanceLightNavigationBars = null;
    }

    public final SecureFlagPolicy getSecurePolicy() {
        return this.securePolicy;
    }

    public final boolean getShouldDismissOnBackPress() {
        return this.shouldDismissOnBackPress;
    }

    public final Boolean isAppearanceLightNavigationBars$material3() {
        return this.isAppearanceLightNavigationBars;
    }

    public final Boolean isAppearanceLightStatusBars$material3() {
        return this.isAppearanceLightStatusBars;
    }

    public final boolean shouldDismissOnClickOutside() {
        return this.shouldDismissOnClickOutside;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced with additional shouldDismissOnScrimClick param constructor.")
    public /* synthetic */ ModalBottomSheetProperties(boolean r2) {
        this(r2, true);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ModalBottomSheetProperties) == true) goto L8;
        return false;
    L8:
        ModalBottomSheetProperties r6 = (ModalBottomSheetProperties) r5;
        if (this.securePolicy == r6.securePolicy) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isAppearanceLightStatusBars, r6.isAppearanceLightStatusBars) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.isAppearanceLightNavigationBars, r6.isAppearanceLightNavigationBars) == true) goto L18;
        return false;
    L18:
        if (this.shouldDismissOnClickOutside == r6.shouldDismissOnClickOutside) goto L21;
        return false;
    L21:
        if (this.shouldDismissOnBackPress == r6.shouldDismissOnBackPress) goto L23;
        return false;
    L23:
        return true;
    }

    public ModalBottomSheetProperties(boolean r2, boolean r3) {
        this.securePolicy = SecureFlagPolicy.Inherit;
        this.shouldDismissOnBackPress = r2;
        this.shouldDismissOnClickOutside = r3;
        this.isAppearanceLightNavigationBars = null;
        this.isAppearanceLightStatusBars = null;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use empty constructor or constructor including shouldDismissOnScrimClick param.")
    public /* synthetic */ ModalBottomSheetProperties(SecureFlagPolicy r2, boolean r3) {
        this(r2, r3, true);
    }

    public ModalBottomSheetProperties(SecureFlagPolicy r1, boolean r2, boolean r3) {
        this.securePolicy = r1;
        this.shouldDismissOnBackPress = r2;
        this.shouldDismissOnClickOutside = r3;
        this.isAppearanceLightNavigationBars = null;
        this.isAppearanceLightStatusBars = null;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use empty constructor or constructor including shouldDismissOnScrimClick param.")
    public /* synthetic */ ModalBottomSheetProperties(boolean r1, boolean r2, SecureFlagPolicy r3, boolean r4) {
        this.shouldDismissOnBackPress = r4;
        this.shouldDismissOnClickOutside = true;
        this.securePolicy = r3;
        this.isAppearanceLightStatusBars = Boolean.valueOf(r1);
        this.isAppearanceLightNavigationBars = Boolean.valueOf(r2);
    }

    public /* synthetic */ ModalBottomSheetProperties(SecureFlagPolicy r1, boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = SecureFlagPolicy.Inherit;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = true;
    L8:
        this(r1, r2);
    }

    public /* synthetic */ ModalBottomSheetProperties(boolean r2, boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = true;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = true;
    L8:
        this(r2, r3);
    }

    public ModalBottomSheetProperties(boolean r1, boolean r2, SecureFlagPolicy r3, boolean r4, boolean r5) {
        this.shouldDismissOnBackPress = r4;
        this.shouldDismissOnClickOutside = r5;
        this.securePolicy = r3;
        this.isAppearanceLightStatusBars = Boolean.valueOf(r1);
        this.isAppearanceLightNavigationBars = Boolean.valueOf(r2);
    }

    public /* synthetic */ ModalBottomSheetProperties(SecureFlagPolicy r2, boolean r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = SecureFlagPolicy.Inherit;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = true;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = true;
    L11:
        this(r2, r3, r4);
    }

    public /* synthetic */ ModalBottomSheetProperties(boolean r1, boolean r2, SecureFlagPolicy r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = SecureFlagPolicy.Inherit;
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = true;
    L8:
        this(r1, r2, r3, r4);
    }

    public /* synthetic */ ModalBottomSheetProperties(boolean r7, boolean r8, SecureFlagPolicy r9, boolean r10, boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r9 = SecureFlagPolicy.Inherit;
    L5:
        SecureFlagPolicy r3 = r9;
        if ((r12 & 8) == 0) goto L8;
        boolean r4 = true;
    L10:
        if ((r12 & 16) == 0) goto L12;
        boolean r5 = true;
    L13:
        this(r7, r8, r3, r4, r5);
        return;
    L12:
        r5 = r11;
        goto L13
    L8:
        r4 = r10;
        goto L10
    }
}
