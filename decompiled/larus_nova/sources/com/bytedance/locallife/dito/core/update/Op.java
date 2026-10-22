package com.bytedance.locallife.dito.core.update;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/dito/core/update/Op;", "", "UPDATE", "REMOVE", "ADD", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final enum Op extends Enum<Op> {
    public static final Op ADD = null;
    public static final Op REMOVE = null;
    public static final Op UPDATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Op[] f257991a = null;

    public static Op valueOf(String r100) {
        return (Op) a.a(Op.class, r100);
    }

    public static Op[] values() {
        return (Op[]) f257991a.clone();
    }

    static {
        Op r100 = new Op("UPDATE", 0);
        UPDATE = r100;
        Op r101 = new Op("REMOVE", 1);
        REMOVE = r101;
        Op r102 = new Op("ADD", 2);
        ADD = r102;
        f257991a = new Op[]{r100, r101, r102};
    }

    public Op(String r100, int r101) {
        super(r100, r101);
    }
}
