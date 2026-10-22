package mi8;

import android.content.Context;
import com.larus.bmhome.chat.quickreply.MoaGrantingDecision;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f514120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MoaGrantingDecision f514121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f514122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakReference<Context> f514123d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f514124e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f514120a, r101.f514120a) == true) goto L12;
        return false;
    L12:
        if (this.f514121b == r101.f514121b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f514122c, r101.f514122c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f514123d, r101.f514123d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f514124e, r101.f514124e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f514120a.hashCode() * 31) + this.f514121b.hashCode()) * 31) + this.f514122c.hashCode()) * 31;
        WeakReference<Context> r101 = this.f514123d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Function0<Unit> r105 = this.f514124e;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MoaGrantingOperateRequest(schemaPayload=" + this.f514120a + ", decision=" + this.f514121b + ", messageContext=" + this.f514122c + ", uiContext=" + this.f514123d + ", onWaitingForAction=" + this.f514124e + ')';
    }

    public g(String r100, MoaGrantingDecision r101, f r102, WeakReference r103, qm8.a r104) {
        Intrinsics.checkNotNullParameter(r100, "schemaPayload");
        Intrinsics.checkNotNullParameter(r101, "decision");
        Intrinsics.checkNotNullParameter(r102, "messageContext");
        this.f514120a = r100;
        this.f514121b = r101;
        this.f514122c = r102;
        this.f514123d = r103;
        this.f514124e = r104;
    }
}
