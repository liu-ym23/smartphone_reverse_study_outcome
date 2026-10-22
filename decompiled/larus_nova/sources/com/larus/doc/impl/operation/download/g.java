package com.larus.doc.impl.operation.download;

import com.larus.platform.audit.BehaviorAuditApi;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class g implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f331371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.larus.platform.audit.b f331372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f331373c;

    @Override // com.larus.doc.impl.operation.download.p
    public final void onSuccess(String r100) {
        Intrinsics.checkNotNullParameter(r100, "filePath");
        this.f331371a.onSuccess(r100);
        BehaviorAuditApi.c(this.f331372b, MapsKt.mapOf(TuplesKt.to("scene", this.f331373c)));
    }

    @Override // com.larus.doc.impl.operation.download.p
    public final void a(Integer r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        this.f331371a.a(r100, r101);
        com.larus.platform.audit.b r102 = this.f331372b;
        Pair[] r103 = new Pair[3];
        r103[0] = TuplesKt.to("scene", this.f331373c);
        if (r100 == null) goto L5;
        int r104 = r100.intValue();
    L6:
        r103[1] = TuplesKt.to("error_code", Integer.valueOf(r104));
        r103[2] = TuplesKt.to("error_msg", r101);
        BehaviorAuditApi.c(r102, MapsKt.mapOf(r103));
        return;
    L5:
        r104 = -1;
        goto L6
    }

    public g(p r100, com.larus.platform.audit.b r101, String r102) {
        this.f331371a = r100;
        this.f331372b = r101;
        this.f331373c = r102;
    }
}
