package com.bytedance.ee.bear.bitable.jsapi.report.common;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.locallife.cube.PrefetchTiming;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/bitable/jsapi/report/common/ReportModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "time", "", "token", "", PrefetchTiming.ROUTER, "", "event", "extra", "Lcom/alibaba/fastjson/JSONObject;", "<init>", "(JLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;)V", "getTime", "()J", "getToken", "()Ljava/lang/String;", "getRouter", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getEvent", "getExtra", "()Lcom/alibaba/fastjson/JSONObject;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReportModel implements NonProguard {
    private final String event;
    private final JSONObject extra;
    private final String[] router;
    private final long time;
    private final String token;

    public final String getEvent() {
        return this.event;
    }

    public final JSONObject getExtra() {
        return this.extra;
    }

    public final String[] getRouter() {
        return this.router;
    }

    public final long getTime() {
        return this.time;
    }

    public final String getToken() {
        return this.token;
    }

    public ReportModel(long r100, String r101, String[] r102, String r103, JSONObject r104) {
        Intrinsics.checkNotNullParameter(r101, "token");
        Intrinsics.checkNotNullParameter(r103, "event");
        this.time = r100;
        this.token = r101;
        this.router = r102;
        this.event = r103;
        this.extra = r104;
    }
}
