package com.ss.android.lark.conditional.access.auth.v2;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012$\b\u0002\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006HÆ\u0003J/\u0010\r\u001a\u00020\u00002$\b\u0002\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R6\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/conditional/access/auth/v2/SenderTenantMap;", "", "senderIdMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/util/HashMap;)V", "getSenderIdMap", "()Ljava/util/HashMap;", "setSenderIdMap", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SenderTenantMap {
    private HashMap<Long, Boolean> senderIdMap;

    /* JADX WARN: Multi-variable type inference failed */
    public SenderTenantMap() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SenderTenantMap copy$default(SenderTenantMap r100, HashMap r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.senderIdMap;
    L6:
        return r100.copy(r101);
    }

    public final HashMap<Long, Boolean> component1() {
        return this.senderIdMap;
    }

    public final SenderTenantMap copy(HashMap<Long, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "senderIdMap");
        return new SenderTenantMap(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SenderTenantMap) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.senderIdMap, ((SenderTenantMap) r100).senderIdMap) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.senderIdMap.hashCode();
    }

    public String toString() {
        return "SenderTenantMap(senderIdMap=" + this.senderIdMap + ')';
    }

    public final HashMap<Long, Boolean> getSenderIdMap() {
        return this.senderIdMap;
    }

    public SenderTenantMap(HashMap<Long, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "senderIdMap");
        this.senderIdMap = r100;
    }

    public final void setSenderIdMap(HashMap<Long, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.senderIdMap = r100;
    }

    public /* synthetic */ SenderTenantMap(HashMap r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = new HashMap();
    L5:
        this(r100);
    }
}
