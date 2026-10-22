package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2RedirectData;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("live.LiveHighHeatMessage")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lsi2/x;", "Lsg2/a;", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2RedirectData;", "redirectData", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2RedirectData;", "", "routeRule", "Ljava/lang/String;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class x extends sg2.a {

    @SerializedName("redirect_data")
    public ECV2RedirectData redirectData;

    @SerializedName("route_rule")
    public String routeRule;

    @Override // sg2.a
    public final String toJsonString() {
        return new Gson().toJson(this);
    L5:
        return toString();
    }

    public x() {
    }
}
