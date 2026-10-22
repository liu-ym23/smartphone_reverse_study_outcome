package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u000fHÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"LCdnTrackerInfo;", "", "conditions", "", "LCondition;", "(Ljava/util/List;)V", "getConditions", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "getConditionByKey", "strategyname", "", "hashCode", "", "toString", "livefeature-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CdnTrackerInfo {
    private final List<Condition> conditions;

    /* JADX WARN: Multi-variable type inference failed */
    public CdnTrackerInfo() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CdnTrackerInfo copy$default(CdnTrackerInfo r100, List r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.conditions;
    L6:
        return r100.copy(r101);
    }

    public final List<Condition> component1() {
        return this.conditions;
    }

    public final CdnTrackerInfo copy(List<Condition> r100) {
        return new CdnTrackerInfo(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CdnTrackerInfo) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.conditions, ((CdnTrackerInfo) r100).conditions) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        List<Condition> r100 = this.conditions;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public String toString() {
        return "CdnTrackerInfo(conditions=" + this.conditions + ")";
    }

    public final List<Condition> getConditions() {
        return this.conditions;
    }

    public CdnTrackerInfo(List<Condition> r100) {
        this.conditions = r100;
    }

    public final Condition getConditionByKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "strategyname");
        List<Condition> r101 = this.conditions;
        Object r102 = null;
        if (r101 == null) goto L15;
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L11;
        Object r104 = r103.next();
        if (Intrinsics.areEqual(((Condition) r104).getStrategyName(), r100) == false) goto L6;
        r102 = r104;
    L11:
        return (Condition) r102;
    L15:
        return null;
    }

    public /* synthetic */ CdnTrackerInfo(List r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = new ArrayList();
    L5:
        this(r100);
    }
}
