package py0;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f530977a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f530978b = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(a.class, "aioLinkWorkerThreadWhiteList", "getAioLinkWorkerThreadWhiteList()Ljava/util/List;", 1))};
        f530977a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("aiolink_worker_thread_white_list", CollectionsKt.listOf(new String[]{"core.service.NativeHostService", "webcast.revenue.biz.foundation.SettingService", "webcast.revenue.biz.foundation.StorageService", "webcast.revenue.biz.foundation.NetworkService", "webcast.revenue.biz.user.UserService", "webcast.revenue.biz.room.RoomService"}), hn3.a.f486092b, false);
        f530978b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
    }
}
