package com.unicom.online.account.kernel;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;

/* JADX INFO: loaded from: classes41.dex */
public final class w extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f462098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f462099b;

    public w(q r100) {
        super(r100.A);
        this.f462098a = CastIntegerProtector.parseInt(r100.f462094z);
        this.f462099b = r100.A;
    }

    public w(q r100, Exception r101) {
        super(r100.A);
        this.f462098a = CastIntegerProtector.parseInt(r100.f462094z);
        this.f462099b = r100.A + " case by : " + r101.getMessage();
    }
}
