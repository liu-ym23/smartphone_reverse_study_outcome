package com.bytedance.locallife.live.view;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes21.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f260830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f260831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f260832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super Integer, Unit> f260833d;

    public static final class a {
    }

    static {
    }

    public abstract void b(int r100);

    public final int a() {
        int r100 = this.f260830a;
        int r101 = this.f260831b;
        int r102 = r100 - r101;
        int r103 = 1;
        if (this.f260832c > 0) goto L5;
        this.f260832c = 1;
    L5:
        int r104 = this.f260832c;
        int r105 = r102 / r104;
        if ((r102 % r104) == 0) goto L11;
        if (r102 > 0) goto L10;
        r103 = -1;
    L10:
        r105 = r105 + r103;
    L11:
        this.f260832c = r104 - 1;
        int r106 = r101 + r105;
        this.f260831b = r106;
        return r106;
    }

    public m() {
        this.f260830a = -1;
        this.f260831b = -1;
        this.f260832c = 1;
    }
}
