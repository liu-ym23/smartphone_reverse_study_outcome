package com.larus.office.base.net;

import com.larus.utils.g0;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes29.dex */
public final class h implements g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f360588a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList<b> f360589b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f360590c = null;

    public h() {
    }

    static {
        f360588a = new h();
        f360589b = new CopyOnWriteArrayList();
        f360590c = CollectionsKt.listOf(new String[]{"update_version_code", "device_platform", "device_brand", EffectConfiguration.KEY_REGION, "sys_region", "carrier_region", "channel", "version_code", "pkg_type", "flow_app_variant"});
    }

    @Override // com.larus.utils.g0
    public final void a() {
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new OfficeNetworkCommonParamsProvider$notifyChange$1(null), 2, null);
    }
}
