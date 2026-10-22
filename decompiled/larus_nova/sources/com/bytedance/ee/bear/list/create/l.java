package com.bytedance.ee.bear.list.create;

import com.bytedance.ee.bear.content.creation.location.CreateSelectResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f227746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f227747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f227748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f227749d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Boolean f227750e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Boolean f227751f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f227752g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Boolean f227753h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f227754i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Boolean f227755j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f227756k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f227757l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CreateSelectResult f227758m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f227759n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Integer f227760o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public er5.c f227761p;

    public l(String r110, int r111, boolean r112, String r113) {
        CreateSelectResult.CREATOR.getClass();
        this(r110, r111, "", true, "", r112, r113, null, CreateSelectResult.a.b());
    }

    public l(String r100, int r101, String r102, boolean r103, String r104, boolean r105, String r106, String r110, CreateSelectResult r111) {
        Intrinsics.checkNotNullParameter(r111, "createSelectResult");
        this.f227748c = 0;
        Boolean r107 = Boolean.FALSE;
        this.f227749d = r107;
        this.f227750e = r107;
        this.f227751f = r107;
        this.f227753h = r107;
        this.f227755j = r107;
        this.f227759n = "";
        this.f227746a = r100;
        this.f227747b = "";
        this.f227748c = Integer.valueOf(r101);
        this.f227749d = r107;
        this.f227750e = r107;
        this.f227751f = r107;
        this.f227752g = r102;
        this.f227753h = Boolean.valueOf(r103);
        this.f227754i = r104;
        this.f227755j = Boolean.valueOf(r105);
        this.f227756k = r106;
        this.f227757l = r110;
        this.f227758m = r111;
        this.f227759n = "";
    }

    public l(String r100, String r101, int r102, boolean r103, String r104, boolean r105, String r106, String r110, CreateSelectResult r111, String r112) {
        Intrinsics.checkNotNullParameter(r111, "createSelectResult");
        Intrinsics.checkNotNullParameter(r112, "spaceId");
        this.f227748c = 0;
        Boolean r107 = Boolean.FALSE;
        this.f227749d = r107;
        this.f227750e = r107;
        this.f227751f = r107;
        this.f227753h = r107;
        this.f227755j = r107;
        this.f227759n = "";
        this.f227746a = r100;
        this.f227747b = r101;
        this.f227748c = Integer.valueOf(r102);
        this.f227749d = Boolean.valueOf(r103);
        this.f227750e = r107;
        this.f227751f = r107;
        this.f227752g = r104;
        this.f227753h = Boolean.valueOf(r105);
        this.f227754i = r106;
        this.f227755j = r107;
        this.f227756k = "";
        this.f227757l = r110;
        this.f227758m = r111;
        this.f227759n = r112;
    }
}
