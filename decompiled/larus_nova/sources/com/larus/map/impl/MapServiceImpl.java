package com.larus.map.impl;

import android.content.Context;
import com.larus.bmhome.chat.map.p;
import com.larus.map.api.IMapApi;
import com.ss.android.lark.utils.statistics.PerfLog;
import kk9.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wq9.e;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J=\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\t2#\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0014"}, d2 = {"Lcom/larus/map/impl/MapServiceImpl;", "Lcom/larus/map/api/IMapApi;", "<init>", "()V", "createMapStrategy", "Lcom/larus/platform/model/map/IFlowMapStrategy;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "is3DPluginInstalled", "", "load3DMapPluginAndCheckUpgrade", "", "silentInstall", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "getMapKey", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MapServiceImpl implements IMapApi {
    public MapServiceImpl() {
    }

    @Override // com.larus.map.api.IMapApi
    public final String c() {
        return "7598aecedd644ae1000447be6668e246-o_project";
    }

    @Override // com.larus.map.api.IMapApi
    public final boolean d() {
        return true;
    }

    @Override // com.larus.map.api.IMapApi
    public final e a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new a(r100);
    }

    @Override // com.larus.map.api.IMapApi
    public final void b(Context r100, p r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r101.invoke(Boolean.TRUE);
    }
}
