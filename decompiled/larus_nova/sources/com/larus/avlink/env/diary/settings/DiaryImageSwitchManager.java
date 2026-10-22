package com.larus.avlink.env.diary.settings;

import com.google.gson.annotations.SerializedName;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.network.http.y;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class DiaryImageSwitchManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DiaryImageSwitchManager f292080a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Boolean f292081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f292082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<Function1<Boolean, Unit>> f292083d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f292084e = null;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003HÆ\u0003J#\u0010\n\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R&\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/larus/avlink/env/diary/settings/DiaryImageSwitchManager$DiaryDeviceInfoResponse;", "", "info", "", "", "<init>", "(Ljava/util/Map;)V", "getInfo", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        @SerializedName("info")
        private final Map<String, Object> info;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.info, ((a) r100).info) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            Map<String, Object> r100 = this.info;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "DiaryDeviceInfoResponse(info=" + this.info + ')';
        }

        public a() {
            this.info = null;
        }

        public final Map<String, Object> a() {
            return this.info;
        }
    }

    public DiaryImageSwitchManager() {
    }

    static {
        f292080a = new DiaryImageSwitchManager();
        f292083d = new ArrayList();
        f292084e = LazyKt.lazy(new com.larus.avlink.env.diary.settings.a());
    }

    public static void d(boolean r100) {
        f292081b = Boolean.valueOf(r100);
        FLogger.f375446a.i("DiaryImageSwitch", "setInsertPhotoEnabled: " + r100);
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new DiaryImageSwitchManager$setInsertPhotoEnabled$1(r100, null), 2, null);
    }

    public final void c(Function1<? super Boolean, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Boolean r101 = f292081b;
        if (r101 == null) goto L6;
        r100.invoke(Boolean.valueOf(r101.booleanValue()));
        return;
    L6:
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L8:
        if (f292082c == false) goto L13;
        ((ArrayList) f292083d).add(r100);     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L13:
        f292082c = true;     // Catch: Throwable -> L17
        ((ArrayList) f292083d).add(r100);     // Catch: Throwable -> L17
        monitor-exit(this);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DiaryImageSwitchManager$getInsertPhotoEnabled$3(null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object a(DiaryImageSwitchManager r110, Continuation r111) {
        r110.getClass();
        if ((r111 instanceof DiaryImageSwitchManager$fetchFromNetwork$1) == false) goto L7;
        DiaryImageSwitchManager$fetchFromNetwork$1 r100 = (DiaryImageSwitchManager$fetchFromNetwork$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r113 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = r100.label;
        boolean r103 = false;
        boolean r104 = true;
        String r105 = null;
        if (r102 == 0) goto L15;
        if (r102 != 1) goto L14;
        ResultKt.throwOnFailure(r112);     // Catch: Exception -> L59
    L34:
        com.larus.network.http.a r114 = (com.larus.network.http.a) r112;     // Catch: Exception -> L59
        if ((r114 instanceof y) == false) goto L57;
        Long r115 = ((y) r114).f360205g;     // Catch: Exception -> L59
        if (r115 == null) goto L57;
        if (r115.longValue() != 0) goto L57;
        a r116 = (a) ((y) r114).f360135b;     // Catch: Exception -> L59
        if (r116 == null) goto L44;
        Map<String, Object> r117 = r116.a();     // Catch: Exception -> L59
    L45:
        if (r117 == null) goto L50;
        Object r118 = r117.get("diary_image_switch");     // Catch: Exception -> L59
        if (r118 == null) goto L50;
        r105 = r118.toString();     // Catch: Exception -> L59
    L50:
        if (Intrinsics.areEqual(r105, "0") == true) goto L52;
        boolean r119 = true;
    L53:
        FLogger r120 = FLogger.f375446a;     // Catch: Exception -> L59
        StringBuilder r106 = new StringBuilder("fetchFromNetwork success, value=");     // Catch: Exception -> L59
        r106.append(r105);     // Catch: Exception -> L59
        r106.append(", enabled=");     // Catch: Exception -> L59
        if (r119 == false) goto L56;
        r103 = true;
    L56:
        r106.append(r103);     // Catch: Exception -> L59
        r120.i("DiaryImageSwitch", r106.toString());     // Catch: Exception -> L59
        r104 = r119;
    L62:
        return Boxing.boxBoolean(r104);
    L52:
        r119 = false;
        goto L53
    L44:
        r117 = null;
    L57:
        FLogger.f375446a.e("DiaryImageSwitch", "fetchFromNetwork failed, response=" + r114);     // Catch: Exception -> L59
        goto L62
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r112);
        IDoraService r121 = (IDoraService) f292084e.getValue();     // Catch: Exception -> L59
        if (r121 == null) goto L19;
        DeviceService r122 = r121.device();     // Catch: Exception -> L59
    L20:
        if (r122 == null) goto L22;
        String r107 = r122.m();     // Catch: Exception -> L59
    L23:
        if (r107 != null) goto L25;
    L28:
        boolean r108 = true;
    L29:
        if (r108 == false) goto L31;
        FLogger.f375446a.w("DiaryImageSwitch", "fetchFromNetwork: device sn is empty, use default value");     // Catch: Exception -> L59
        return Boxing.boxBoolean(true);
    L31:
        int r123 = r122.y();     // Catch: Exception -> L59
        com.larus.dora.api.network.a r109 = com.larus.dora.api.network.a.f331768a;     // Catch: Exception -> L59
        Map r124 = MapsKt.mapOf(new Pair[]{TuplesKt.to("w_did", r107), TuplesKt.to("product_id", String.valueOf(r123)), TuplesKt.to("keys", "diary_image_switch")});     // Catch: Exception -> L59
        r100.label = 1;     // Catch: Exception -> L59
        r112 = com.larus.dora.api.network.a.b(r109, a.class, "/alice/w/device/info", r124, r100);     // Catch: Exception -> L59
        if (r112 != r113) goto L34;
        return r113;
    L25:
        if (r107.length() == 0) goto L28;
        r108 = false;
        goto L29
    L22:
        r107 = null;
        goto L23
    L19:
        r122 = null;
    L59:
        e = move-exception;
        FLogger.f375446a.e("DiaryImageSwitch", "fetchFromNetwork error", e);
    L7:
        r100 = new DiaryImageSwitchManager$fetchFromNetwork$1(r110, r111);
        goto L8
    }

    public static final Object b(DiaryImageSwitchManager r110, boolean r111, Continuation r112) {
        r110.getClass();
        if ((r112 instanceof DiaryImageSwitchManager$syncToNetwork$1) == false) goto L7;
        DiaryImageSwitchManager$syncToNetwork$1 r100 = (DiaryImageSwitchManager$syncToNetwork$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        DiaryImageSwitchManager$syncToNetwork$1 r102 = r100;
        Object r113 = r102.result;
        Object r114 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r102.label;
        boolean r115 = false;
        if (r103 == 0) goto L16;
        if (r103 != 1) goto L15;
        r111 = r102.Z$0;
        ResultKt.throwOnFailure(r113);     // Catch: Exception -> L51
    L38:
        com.larus.network.http.a r116 = (com.larus.network.http.a) r113;     // Catch: Exception -> L51
        if ((r116 instanceof y) == false) goto L49;
        Long r117 = ((y) r116).f360205g;     // Catch: Exception -> L51
        if (r117 == null) goto L49;
        if (r117.longValue() != 0) goto L49;
        FLogger r118 = FLogger.f375446a;     // Catch: Exception -> L51
        StringBuilder r119 = new StringBuilder("syncToNetwork success, enabled=");     // Catch: Exception -> L51
        if (r111 == false) goto L48;
        r115 = true;
    L48:
        r119.append(r115);     // Catch: Exception -> L51
        r118.i("DiaryImageSwitch", r119.toString());     // Catch: Exception -> L51
    L54:
        return Unit.INSTANCE;
    L49:
        FLogger.f375446a.e("DiaryImageSwitch", "syncToNetwork failed, response=" + r116);     // Catch: Exception -> L51
        goto L54
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r113);
        IDoraService r120 = (IDoraService) f292084e.getValue();     // Catch: Exception -> L51
        String r104 = null;
        if (r120 == null) goto L20;
        DeviceService r121 = r120.device();     // Catch: Exception -> L51
    L21:
        if (r121 == null) goto L23;
        r104 = r121.m();     // Catch: Exception -> L51
    L23:
        if (r104 != null) goto L25;
    L28:
        boolean r105 = true;
    L29:
        if (r105 == false) goto L31;
        FLogger.f375446a.w("DiaryImageSwitch", "syncToNetwork: device sn is empty, skip sync");     // Catch: Exception -> L51
        return Unit.INSTANCE;
    L31:
        int r122 = r121.y();     // Catch: Exception -> L51
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L51
        r106.put("w_did", r104);     // Catch: Exception -> L51
        JSONObject r107 = new JSONObject();     // Catch: Exception -> L51
        if (r111 == false) goto L34;
        String r108 = "1";
    L35:
        r107.put("diary_image_switch", r108);     // Catch: Exception -> L51
        Unit r109 = Unit.INSTANCE;     // Catch: Exception -> L51
        r106.put("info", r107);     // Catch: Exception -> L51
        r106.put("product_id", String.valueOf(r122));     // Catch: Exception -> L51
        r106.put("uid", AccountService.f365697a.getUserId());     // Catch: Exception -> L51
        com.larus.dora.api.network.a r123 = com.larus.dora.api.network.a.f331768a;     // Catch: Exception -> L51
        r102.Z$0 = r111;     // Catch: Exception -> L51
        r102.label = 1;     // Catch: Exception -> L51
        r113 = com.larus.dora.api.network.a.c(r123, Object.class, "/alice/w/device/sync_info", r106, null, r102, 248);     // Catch: Exception -> L51
        if (r113 != r114) goto L38;
        return r114;
    L34:
        r108 = "0";
        goto L35
    L25:
        if (r104.length() == 0) goto L28;
        r105 = false;
        goto L29
    L20:
        r121 = null;
    L51:
        e = move-exception;
        FLogger.f375446a.e("DiaryImageSwitch", "syncToNetwork error", e);
    L7:
        r100 = new DiaryImageSwitchManager$syncToNetwork$1(r110, r112);
        goto L8
    }
}
