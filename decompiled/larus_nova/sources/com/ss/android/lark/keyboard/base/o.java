package com.ss.android.lark.keyboard.base;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class o {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f428239f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f428240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f428241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f428242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f428243d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f428244e;

    public static final class a implements n.a<o> {
        public a() {
        }
    }

    static {
        f428239f = new a();
    }

    public o() {
        this(0);
    }

    public final int hashCode() {
        long r100 = this.f428240a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        int r102 = 1231;
        if (this.f428241b == false) goto L5;
        int r103 = 1231;
    L6:
        int r104 = (r101 + r103) * 31;
        p r105 = this.f428242c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f428243d.hashCode()) * 31;
        if (this.f428244e == true) goto L15;
        r102 = 1237;
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = 1237;
        goto L6
    }

    public final String toString() {
        return "ScheduleInfo(selectedTime=" + this.f428240a + ", is24HourClock=" + this.f428241b + ", sceneData=" + this.f428242c + ", scheduleMessageId=" + this.f428243d + ", isPreScheduleMessage=" + this.f428244e + ')';
    }

    public /* synthetic */ o(int r100) {
        this(0, false, null, "", false);
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof o) == true) goto L5;
        return false;
    L5:
        o r101 = (o) r100;
        if (this.f428240a == r101.f428240a) goto L8;
        return false;
    L8:
        if (this.f428241b == r101.f428241b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f428243d, r101.f428243d) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public o(long r100, boolean r101, p r102, String r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r103, "scheduleMessageId");
        this.f428240a = r100;
        this.f428241b = r101;
        this.f428242c = r102;
        this.f428243d = r103;
        this.f428244e = r104;
    }
}
