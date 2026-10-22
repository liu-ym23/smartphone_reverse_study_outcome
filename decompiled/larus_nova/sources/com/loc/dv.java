package com.loc;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.Serializable;

/* JADX INFO: loaded from: classes32.dex */
public abstract class dv implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f380008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f380009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f380010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f380011d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f380012e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f380013f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f380014g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f380015h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f380016i;

    public dv() {
        this.f380008a = "";
        this.f380009b = "";
        this.f380010c = 99;
        this.f380011d = Integer.MAX_VALUE;
        this.f380012e = 0;
        this.f380013f = 0;
        this.f380014g = 0;
        this.f380016i = true;
    }

    public dv(boolean r100, boolean r101) {
        this.f380008a = "";
        this.f380009b = "";
        this.f380010c = 99;
        this.f380011d = Integer.MAX_VALUE;
        this.f380012e = 0;
        this.f380013f = 0;
        this.f380014g = 0;
        this.f380015h = r100;
        this.f380016i = r101;
    }

    public abstract dv a();

    public final void a(dv r100) {
        this.f380008a = r100.f380008a;
        this.f380009b = r100.f380009b;
        this.f380010c = r100.f380010c;
        this.f380011d = r100.f380011d;
        this.f380012e = r100.f380012e;
        this.f380013f = r100.f380013f;
        this.f380014g = r100.f380014g;
        this.f380015h = r100.f380015h;
        this.f380016i = r100.f380016i;
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return a();
    }

    public String toString() {
        return "AmapCell{mcc=" + this.f380008a + ", mnc=" + this.f380009b + ", signalStrength=" + this.f380010c + ", asulevel=" + this.f380011d + ", lastUpdateSystemMills=" + this.f380012e + ", lastUpdateUtcMills=" + this.f380013f + ", age=" + this.f380014g + ", main=" + this.f380015h + ", newapi=" + this.f380016i + '}';
    }

    public final int b() {
        return CastIntegerProtector.parseInt(this.f380008a);
    L5:
        return 0;
    }

    public final int c() {
        return CastIntegerProtector.parseInt(this.f380009b);
    L5:
        return 0;
    }
}
