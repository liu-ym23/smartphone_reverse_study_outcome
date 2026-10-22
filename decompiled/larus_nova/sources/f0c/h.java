package f0c;

import com.ss.android.lark.passportc.api.Scene;
import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UserState f475035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Scene f475036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final lzb.a f475037c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (this.f475035a == r101.f475035a) goto L12;
        return false;
    L12:
        if (this.f475036b == r101.f475036b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f475037c, r101.f475037c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f475035a.hashCode() * 31;
        Scene r101 = this.f475036b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f475037c.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "UserStatePayload(state=" + this.f475035a + ", scene=" + this.f475036b + ", context=" + this.f475037c + ')';
    }

    public final lzb.a getContext() {
        return this.f475037c;
    }

    public h(UserState r100, Scene r101, lzb.a r102) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f475035a = r100;
        this.f475036b = r101;
        this.f475037c = r102;
    }
}
