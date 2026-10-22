package ub8;

import com.larus.im.callback.IIMError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f549373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f549374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f549375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IIMError f549376d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f549373a == r101.f549373a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f549374b, r101.f549374b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f549375c, r101.f549375c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f549376d, r101.f549376d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.f549373a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((((r100 * 31) + this.f549374b.hashCode()) * 31) + this.f549375c.hashCode()) * 31;
        IIMError r102 = this.f549376d;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "ConversationUpdateResult(success=" + this.f549373a + ", conversationId=" + this.f549374b + ", name=" + this.f549375c + ", fail=" + this.f549376d + ')';
    }

    public e(boolean r100, String r101, String r102, IIMError r103) {
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        Intrinsics.checkNotNullParameter(r102, "name");
        this.f549373a = r100;
        this.f549374b = r101;
        this.f549375c = r102;
        this.f549376d = r103;
    }
}
