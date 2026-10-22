package wc2;

import com.bytedance.android.live.base.model.n;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.message.model.fl;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.ShortTermIndicatorConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.g;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "showShortTouchArea")
public final class c extends g<a, Object> {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lwc2/c$a;", "", "", "roomId", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "", ReportConstant.COMMON_ACTION_TYPE, "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "Lcom/bytedance/android/live/base/model/n;", "shortTouchArea", "Lcom/bytedance/android/live/base/model/n;", "c", "()Lcom/bytedance/android/live/base/model/n;", "setShortTouchArea", "(Lcom/bytedance/android/live/base/model/n;)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("message_type")
        private final int actionType;

        @SerializedName("room_id")
        private final Long roomId;

        @SerializedName("shortTouchArea")
        private n shortTouchArea;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L8;
            return false;
        L8:
            if (this.actionType == r101.actionType) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.shortTouchArea, r101.shortTouchArea) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            Long r100 = this.roomId;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = ((r102 * 31) + this.actionType) * 31;
            n r104 = this.shortTouchArea;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Params(roomId=" + this.roomId + ", actionType=" + this.actionType + ", shortTouchArea=" + this.shortTouchArea + ")";
        }

        public a() {
            this.roomId = null;
            this.actionType = 0;
            this.shortTouchArea = null;
        }

        public final int a() {
            return this.actionType;
        }

        public final Long b() {
            return this.roomId;
        }

        public final n c() {
            return this.shortTouchArea;
        }
    }

    public c() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(a r100, CallContext r110) {
        a r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r110, "p1");
        if (r101.b() != null) goto L5;
        ALogger.e("ShortTouchMethod", "roomId is null");
        return null;
    L5:
        RoomContext.a r111 = RoomContext.Companion;
        long r102 = r101.b().longValue();
        r111.getClass();
        RoomContext r112 = RoomContext.a.a(null, r102);
        if (r112 != null) goto L8;
        ALogger.e("ShortTouchMethod", "roomContext is null");
        return null;
    L8:
        Room r103 = r112.getRoom().getValue();
        if (r103.f162599id != 0) goto L12;
        ALogger.e("ShortTouchMethod", "room is error");
        return null;
    L12:
        if (r101.c() != null) goto L14;
        ALogger.e("ShortTouchMethod", "shortTouchArea is null");
        return null;
    L14:
        n r104 = r101.c();
        Intrinsics.checkNotNull(r104);
        int r105 = r104.type;
        n r106 = r101.c();
        Intrinsics.checkNotNull(r106);
        int r107 = r106.priority;
        ShortTermIndicatorConfig r108 = r103.getShortTermIndicatorConfig();
        if (r108 == null) goto L24;
        Map<Integer, ShortTermIndicatorConfig.Element> r109 = r108.getElements();
        if (r109 == null) goto L24;
        Iterator<Map.Entry<Integer, ShortTermIndicatorConfig.Element>> r113 = r109.entrySet().iterator();
    L20:
        if (r113.hasNext() == false) goto L24;
        if (r113.next().getValue().getType() != r105) goto L20;
        boolean r114 = true;
    L25:
        if (r114 == true) goto L27;
        ALogger.i("ShortTouchMethod", "not in white list");
        return null;
    L27:
        HashMap r115 = new HashMap();
        r115.put("source", String.valueOf(1));
        fl r116 = new fl();
        r116.H(Integer.valueOf(r101.a()));
        r116.P(r101.c());
        r116.messageExtra = r115;
        vlc.d r117 = r112.getMessageManager().getValue();
        if (r117 == null) goto L30;
        r117.j(r116, true);
    L30:
        JSONObject r118 = new JSONObject();
        r118.put("code", 1);
        return r118;
    L24:
        r114 = false;
        goto L25
    }
}
