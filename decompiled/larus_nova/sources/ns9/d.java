package ns9;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.larus.reach.api.ReachButtonStyle;
import com.larus.reach.api.ReachButtonType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReachButtonType f520364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReachButtonStyle f520365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f520366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<b> f520367d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f520364a == r101.f520364a) goto L12;
        return false;
    L12:
        if (this.f520365b == r101.f520365b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f520366c, r101.f520366c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f520367d, r101.f520367d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f520364a.hashCode() * 31;
        ReachButtonStyle r101 = this.f520365b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f520366c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return ((r104 + r102) * 31) + this.f520367d.hashCode();
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ReachButton(type=" + this.f520364a + ", style=" + this.f520365b + ", title=" + this.f520366c + ", actions=" + this.f520367d + ')';
    }

    public final ReachButtonType getType() {
        return this.f520364a;
    }

    public d(ReachButtonType r100, ReachButtonStyle r101, String r102, List<b> r103) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r103, SlcCommonAction.KEY_ACTIONS);
        this.f520364a = r100;
        this.f520365b = r101;
        this.f520366c = r102;
        this.f520367d = r103;
    }
}
