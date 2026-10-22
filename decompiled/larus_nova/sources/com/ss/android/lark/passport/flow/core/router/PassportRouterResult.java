package com.ss.android.lark.passport.flow.core.router;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class PassportRouterResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Status f437785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f437786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f437787c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/passport/flow/core/router/PassportRouterResult$Status;", "", "<init>", "(Ljava/lang/String;I)V", "INVALID_NEXT_STEP", "TERMINAL", "DISPATCHED", "UNSUPPORTED", "flow-passport-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Status extends Enum<Status> {
        public static final Status DISPATCHED = null;
        public static final Status INVALID_NEXT_STEP = null;
        public static final Status TERMINAL = null;
        public static final Status UNSUPPORTED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Status[] f437788a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f437789b = null;

        public static EnumEntries<Status> getEntries() {
            return f437789b;
        }

        static {
            Status r100 = new Status("INVALID_NEXT_STEP", 0);
            INVALID_NEXT_STEP = r100;
            Status r101 = new Status("TERMINAL", 1);
            TERMINAL = r101;
            Status r102 = new Status("DISPATCHED", 2);
            DISPATCHED = r102;
            Status r103 = new Status("UNSUPPORTED", 3);
            UNSUPPORTED = r103;
            Status[] r104 = {r100, r101, r102, r103};
            f437788a = r104;
            f437789b = EnumEntriesKt.enumEntries(r104);
        }

        public static Status[] values() {
            return (Status[]) f437788a.clone();
        }

        public static Status valueOf(String r100) {
            return (Status) r27.a.a(Status.class, r100);
        }

        public Status(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PassportRouterResult) == true) goto L8;
        return false;
    L8:
        PassportRouterResult r101 = (PassportRouterResult) r100;
        if (this.f437785a == r101.f437785a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f437786b, r101.f437786b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f437787c, r101.f437787c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f437785a.hashCode() * 31;
        String r101 = this.f437786b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f437787c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "PassportRouterResult(status=" + this.f437785a + ", nextStep=" + this.f437786b + ", actionName=" + this.f437787c + ')';
    }

    public final boolean a() {
        Status r100 = this.f437785a;
        if (r100 != Status.TERMINAL) goto L5;
    L8:
        return true;
    L5:
        if (r100 == Status.DISPATCHED) goto L8;
        return false;
    }

    public PassportRouterResult(Status r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "status");
        this.f437785a = r100;
        this.f437786b = r101;
        this.f437787c = r102;
    }
}
