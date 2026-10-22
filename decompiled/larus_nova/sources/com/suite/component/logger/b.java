package com.suite.component.logger;

import com.suite.component.logger.api.LogLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LogLevel f460107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f460108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f460109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f460110d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f460111e;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f460107a == r101.f460107a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f460108b, r101.f460108b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f460109c, r101.f460109c) == true) goto L18;
        return false;
    L18:
        if (this.f460110d == r101.f460110d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f460111e, r101.f460111e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f460107a.hashCode() * 31) + this.f460108b.hashCode()) * 31;
        String r101 = this.f460109c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f460110d == false) goto L9;
        int r104 = 1231;
    L11:
        return ((r103 + r104) * 31) + this.f460111e.hashCode();
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "LogContext(level=" + this.f460107a + ", logDir=" + this.f460108b + ", tempLogDir=" + this.f460109c + ", debug=" + this.f460110d + ", processName=" + this.f460111e + ')';
    }

    public /* synthetic */ b(int r100) {
        this(LogLevel.INFO, "", "", false, "");
    }

    public b(LogLevel r100, String r101, String r102, boolean r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "level");
        Intrinsics.checkNotNullParameter(r101, "logDir");
        Intrinsics.checkNotNullParameter(r104, "processName");
        this.f460107a = r100;
        this.f460108b = r101;
        this.f460109c = r102;
        this.f460110d = r103;
        this.f460111e = r104;
    }
}
