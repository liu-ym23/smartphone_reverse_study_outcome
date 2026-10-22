package com.ss.ugc.effectplatform.model.algorithm;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0016j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/ugc/effectplatform/model/algorithm/FetchModelType;", "", "", "value", "fromValue", "ORIGIN", "ZIP", "effect_model_release"}, k = 1, mv = {1, 4, 0})
public final enum FetchModelType extends Enum<FetchModelType> {
    public static final FetchModelType ORIGIN = null;
    public static final FetchModelType ZIP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FetchModelType[] f457412a = null;

    static {
        FetchModelType r100 = new FetchModelType("ORIGIN", 0);
        ORIGIN = r100;
        FetchModelType r101 = new FetchModelType("ZIP", 1);
        ZIP = r101;
        f457412a = new FetchModelType[]{r100, r101};
    }

    public static FetchModelType valueOf(String r100) {
        return (FetchModelType) a.a(FetchModelType.class, r100);
    }

    public static FetchModelType[] values() {
        return (FetchModelType[]) f457412a.clone();
    }

    public FetchModelType fromValue(int r100) {
        FetchModelType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        FetchModelType r104 = r101[r103];
        if (r104.ordinal() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return ORIGIN;
    }

    public FetchModelType(String r100, int r101) {
        super(r100, r101);
    }
}
