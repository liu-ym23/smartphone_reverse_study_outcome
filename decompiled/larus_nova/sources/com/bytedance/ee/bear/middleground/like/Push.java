package com.bytedance.ee.bear.middleground.like;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes18.dex */
public final class Push {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f232749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f232750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f232751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f232752d;

    public static final class a {
    }

    static {
    }

    public Push(String r100, int r101, int r102) {
        this.f232749a = r100;
        this.f232750b = r101;
        this.f232751c = r102;
        this.f232752d = LazyKt.lazy(new Push$rnPushProtocol$2(this));
    }
}
