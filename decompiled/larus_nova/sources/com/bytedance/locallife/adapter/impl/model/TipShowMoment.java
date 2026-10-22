package com.bytedance.locallife.adapter.impl.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/adapter/impl/model/TipShowMoment;", "", "", "value", "I", "getValue", "()I", "ON_SHARE_START", "SHARE_SUCCESS_WITH_USER", "SEND_AFTER", "locallife-adapter-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum TipShowMoment extends Enum<TipShowMoment> {
    public static final TipShowMoment ON_SHARE_START = null;
    public static final TipShowMoment SEND_AFTER = null;
    public static final TipShowMoment SHARE_SUCCESS_WITH_USER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TipShowMoment[] f256489a = null;
    private final int value;

    public static TipShowMoment valueOf(String r100) {
        return (TipShowMoment) a.a(TipShowMoment.class, r100);
    }

    public static TipShowMoment[] values() {
        return (TipShowMoment[]) f256489a.clone();
    }

    static {
        TipShowMoment r100 = new TipShowMoment("ON_SHARE_START", 0, 0);
        ON_SHARE_START = r100;
        TipShowMoment r101 = new TipShowMoment("SHARE_SUCCESS_WITH_USER", 1, 1);
        SHARE_SUCCESS_WITH_USER = r101;
        TipShowMoment r102 = new TipShowMoment("SEND_AFTER", 2, 2);
        SEND_AFTER = r102;
        f256489a = new TipShowMoment[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public TipShowMoment(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
