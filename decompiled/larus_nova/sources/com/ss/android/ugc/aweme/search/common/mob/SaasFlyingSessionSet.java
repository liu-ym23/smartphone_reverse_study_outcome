package com.ss.android.ugc.aweme.search.common.mob;

import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/mob/SaasFlyingSessionSet;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SaasFlyingSessionSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ECSearchSaasResultShowEvent f451770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<ECSearchResultSceneKey, ECSearchSaasResultShowEvent> f451771b;

    public SaasFlyingSessionSet() {
        this.f451771b = new LinkedHashMap();
    }

    public final ECSearchSaasResultShowEvent a(ECSearchResultSceneKey r100) {
        Intrinsics.checkNotNullParameter(r100, "sceneKey");
        if ((!Intrinsics.areEqual(r100, ECSearchSaasResultShowEventTrackerKt.f451756a)) == false) goto L8;
        ECSearchSaasResultShowEvent r101 = (ECSearchSaasResultShowEvent) ((LinkedHashMap) this.f451771b).get(r100);
        if (r101 == null) goto L8;
        Logger.a("EventTrackerDebug", "FlyingSessionSet get sceneKey = " + r100 + ", find event = " + r101.hashCode());
        return r101;
    L8:
        StringBuilder r102 = new StringBuilder("FlyingSessionSet get sceneKey = ");
        r102.append(r100);
        r102.append(", use justStartedSession = ");
        ECSearchSaasResultShowEvent r103 = this.f451770a;
        if (r103 == null) goto L11;
        int r104 = r103.hashCode();
    L12:
        r102.append(r104);
        Logger.a("EventTrackerDebug", r102.toString());
        ECSearchSaasResultShowEvent r105 = this.f451770a;
        if (r105 == null) goto L15;
        return r105;
    L15:
        return null;
    L11:
        r104 = 0;
        goto L12
    }

    public final void c(ECSearchResultSceneKey r100) {
        Intrinsics.checkNotNullParameter(r100, "sceneKey");
        if ((!Intrinsics.areEqual(r100, ECSearchSaasResultShowEventTrackerKt.f451756a)) == false) goto L8;
        if (this.f451771b.remove(r100) == null) goto L8;
        return;
    L8:
        if (this.f451770a == null) goto L11;
        this.f451770a = null;
        return;
    }

    public final void b(ECSearchResultSceneKey r100, ECSearchSaasResultShowEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "sceneKey");
        Intrinsics.checkNotNullParameter(r101, "event");
        ECSearchResultSceneKey r102 = ECSearchSaasResultShowEventTrackerKt.f451756a;
        if ((!Intrinsics.areEqual(r100, r102)) == true) goto L5;
        this.f451770a = r101;
    L11:
        StringBuilder r103 = new StringBuilder("FlyingSessionSet put session sceneKey = ");
        r103.append(r100);
        r103.append(" justStartedSession = ");
        ECSearchSaasResultShowEvent r104 = this.f451770a;
        if (r104 == null) goto L14;
        int r105 = r104.hashCode();
    L15:
        r103.append(r105);
        Logger.a("EventTrackerDebug", r103.toString());
        return;
    L14:
        r105 = 0;
        goto L15
    L5:
        if (Intrinsics.areEqual(r101.f451750x, r102) == false) goto L7;
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r101.f451750x = r100;
    L7:
        this.f451771b.put(r100, r101);
        if (Intrinsics.areEqual(r101, this.f451770a) == false) goto L11;
        this.f451770a = null;
        goto L11
    }
}
