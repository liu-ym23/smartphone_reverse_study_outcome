package gj9;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u00002\u00020\u0001B9\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR&\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/larus/livetutor/impl/hybrid/jsb/LiveTutorSaveBoardEvent;", "Lcom/larus/livetutor/impl/hybrid/jsb/JSBEventData;", "enterTime", "", ST.UUID_DEVICE, "queryData", "", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getEnterTime", "()Ljava/lang/String;", "getUuid", "getQueryData", "()Ljava/util/Map;", "getEventName", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d implements a {

    @SerializedName("enterTime")
    private final String enterTime;

    @SerializedName("queryData")
    private final Map<String, Object> queryData;

    @SerializedName(ST.UUID_DEVICE)
    private final String uuid;

    public d() {
        this(null, null, null);
    }

    @Override // gj9.a
    public final String getEventName() {
        return "liveTutorSaveBoard";
    }

    public d(String r100, String r101, Map<String, ? extends Object> r102) {
        this.enterTime = r100;
        this.uuid = r101;
        this.queryData = r102;
    }
}
