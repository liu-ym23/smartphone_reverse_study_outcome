package com.ss.android.lark.passport.flow.mfa;

import android.app.Activity;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passport.flow.core.router.FlowStep;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f437905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FlowMfaFlowSession f437906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FlowStep f437907c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f437905a, r101.f437905a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f437906b, r101.f437906b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f437907c, r101.f437907c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f437905a.hashCode() * 31) + this.f437906b.hashCode()) * 31) + this.f437907c.hashCode();
    }

    public final String toString() {
        return "FlowMfaRouterContext(activity=" + this.f437905a + ", session=" + this.f437906b + ", step=" + this.f437907c + ')';
    }

    public final Activity getActivity() {
        return this.f437905a;
    }

    public m(Activity r100, FlowMfaFlowSession r101, FlowStep r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r102, "step");
        this.f437905a = r100;
        this.f437906b = r101;
        this.f437907c = r102;
    }
}
