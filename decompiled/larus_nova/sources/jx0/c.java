package jx0;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Ljx0/c;", "", "", "eventGroup", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setEventGroup", "(Ljava/lang/String;)V", "eventName", "b", "setEventName", "", "eventTime", "J", "c", "()J", "setEventTime", "(J)V", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.recharge.trace.ReportEventRequest")
public final class c {

    @SerializedName("event_group")
    private String eventGroup;

    @SerializedName(ReportCardMonitorPlugin.EVENT_NAME)
    private String eventName;

    @SerializedName("event_time")
    private long eventTime;

    public c() {
        this.eventGroup = "";
        this.eventName = "";
    }

    public final String a() {
        return this.eventGroup;
    }

    public final String b() {
        return this.eventName;
    }

    public final long c() {
        return this.eventTime;
    }
}
