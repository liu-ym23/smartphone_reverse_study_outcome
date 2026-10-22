package com.larus.voicecall.impl.utils;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larus.platform.model.NotificationBusiness;
import com.larus.utils.o0;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class RealtimeMobUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f379512a = 0;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/voicecall/impl/utils/RealtimeMobUtil$Business;", "", "businessTag", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getBusinessTag", "()Ljava/lang/String;", NotificationBusiness.REAL_TIME, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Business extends Enum<Business> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Business[] f379513a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f379514b = null;
        public static final Business realtime = null;
        private final String businessTag;

        public static EnumEntries<Business> getEntries() {
            return f379514b;
        }

        static {
            Business r100 = new Business();
            realtime = r100;
            Business[] r101 = {r100};
            f379513a = r101;
            f379514b = EnumEntriesKt.enumEntries(r101);
        }

        public Business() {
            super(NotificationBusiness.REAL_TIME, 0);
            this.businessTag = NotificationBusiness.REALTIME_CALL;
        }

        public static Business[] values() {
            return (Business[]) f379513a.clone();
        }

        public final String getBusinessTag() {
            return this.businessTag;
        }

        public static Business valueOf(String r100) {
            return (Business) r27.a.a(Business.class, r100);
        }
    }

    static {
    }

    public static void b(String r110, String r111, String r112, String r113) {
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new RealtimeMobUtil$mobRealtimeCallRouterStart$1(r110, r111, r112, r113, null), 2, null);
    }

    public static void a(String r110, String r111, String r112, String r113, boolean r114, String r115) {
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new RealtimeMobUtil$mobRealtimeCallRouterEnd$1(r110, r111, r112, r113, r114, r115, null), 2, null);
    }

    public static void c(Business r100, long r101, boolean r102, List r103, String r104, Map r105) {
        Intrinsics.checkNotNullParameter(r100, "business");
        Intrinsics.checkNotNullParameter(r103, "picKeyList");
        Intrinsics.checkNotNullParameter(r105, "extra");
        com.larus.platform.service.o r106 = com.larus.platform.service.o.f365780a;
        JSONObject r107 = new JSONObject();
        r107.put("business", r100.getBusinessTag());
        r107.put("duration_ms", r101);
        r107.put("is_success", r102 ? 1 : 0);
        r107.put("pic_key_list", r103);
        r107.put("pic_num", 1);
        if (o0.d(r104) == false) goto L5;
        r107.put(LocationMonitorConst.ERR_MSG, r104);
    L5:
        Iterator r108 = r105.entrySet().iterator();
    L7:
        if (r108.hasNext() == false) goto L9;
        Map.Entry r109 = (Map.Entry) r108.next();
        r107.put((String) r109.getKey(), r109.getValue());
        goto L7
    L9:
        Unit r110 = Unit.INSTANCE;
        r106.reportEvent("upload_photo_result", r107);
    }
}
