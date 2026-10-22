package com.ss.android.lark.audit.auth;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/audit/auth/ForceClearModel;", "", "forceClearMap", "", "", "", "<init>", "(Ljava/util/Map;)V", "getForceClearMap", "()Ljava/util/Map;", "audit-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForceClearModel {
    private final Map<Integer, Boolean> forceClearMap;

    public final Map<Integer, Boolean> getForceClearMap() {
        return this.forceClearMap;
    }

    public ForceClearModel(Map<Integer, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "forceClearMap");
        this.forceClearMap = r100;
    }
}
