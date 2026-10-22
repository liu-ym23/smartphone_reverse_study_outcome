package com.bytedance.locallife.pdp.entity;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/locallife/pdp/entity/SourceType;", "", "", "type", "I", "getType", "()I", "LIVE_ROOM", "LIVE_ANCHOR", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum SourceType extends Enum<SourceType> {
    public static final SourceType LIVE_ANCHOR = null;
    public static final SourceType LIVE_ROOM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SourceType[] f261394a = null;
    private final int type;

    public static SourceType valueOf(String r100) {
        return (SourceType) a.a(SourceType.class, r100);
    }

    public static SourceType[] values() {
        return (SourceType[]) f261394a.clone();
    }

    static {
        SourceType r100 = new SourceType("LIVE_ROOM", 0, 1);
        LIVE_ROOM = r100;
        SourceType r101 = new SourceType("LIVE_ANCHOR", 1, 2);
        LIVE_ANCHOR = r101;
        f261394a = new SourceType[]{r100, r101};
    }

    public final int getType() {
        return this.type;
    }

    public SourceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
