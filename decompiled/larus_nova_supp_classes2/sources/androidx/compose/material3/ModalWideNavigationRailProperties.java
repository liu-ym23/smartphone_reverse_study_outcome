package androidx.compose.material3;

import androidx.compose.ui.window.SecureFlagPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0013\b\u0016\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\bJ\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Landroidx/compose/material3/ModalWideNavigationRailProperties;", "", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "shouldDismissOnBackPress", "", "<init>", "(Landroidx/compose/ui/window/SecureFlagPolicy;Z)V", "(Z)V", "getSecurePolicy", "()Landroidx/compose/ui/window/SecureFlagPolicy;", "getShouldDismissOnBackPress", "()Z", "equals", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ModalWideNavigationRailProperties {
    public static final int $stable = 0;
    private final SecureFlagPolicy securePolicy;
    private final boolean shouldDismissOnBackPress;

    public ModalWideNavigationRailProperties() {
        SecureFlagPolicy r2 = null;
        this(r2, false, 3, r2);
    }

    public int hashCode() {
        int r0 = this.securePolicy.hashCode() * 31;
        if (this.shouldDismissOnBackPress == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final SecureFlagPolicy getSecurePolicy() {
        return this.securePolicy;
    }

    public final boolean getShouldDismissOnBackPress() {
        return this.shouldDismissOnBackPress;
    }

    public ModalWideNavigationRailProperties(boolean r2) {
        this(SecureFlagPolicy.Inherit, r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof ModalWideNavigationRailProperties) == true) goto L9;
        return false;
    L9:
        if (this.securePolicy == ((ModalWideNavigationRailProperties) r4).securePolicy) goto L11;
        return false;
    L11:
        return true;
    }

    public ModalWideNavigationRailProperties(SecureFlagPolicy r1, boolean r2) {
        this.securePolicy = r1;
        this.shouldDismissOnBackPress = r2;
    }

    public /* synthetic */ ModalWideNavigationRailProperties(boolean r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        this(r1);
    }

    public /* synthetic */ ModalWideNavigationRailProperties(SecureFlagPolicy r1, boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = SecureFlagPolicy.Inherit;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = true;
    L8:
        this(r1, r2);
    }
}
