package com.obric.miniapp.aibridge;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.common.apphost.AppHost;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/obric/miniapp/aibridge/OpenMemoryDetailMethod;", "Lcom/obric/miniapp/aibridge/AbsOpenMemoryDetailMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/obric/miniapp/aibridge/AbsOpenMemoryDetailMethodIDL$CheckMemoryExistParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/obric/miniapp/aibridge/AbsOpenMemoryDetailMethodIDL$CheckMemoryExistResultModel;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenMemoryDetailMethod extends AbsOpenMemoryDetailMethodIDL {

    public static final class a {
    }

    static {
    }

    public OpenMemoryDetailMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r101, f3.h r102) {
        AbsOpenMemoryDetailMethodIDL.a r103 = (AbsOpenMemoryDetailMethodIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        ContentResolver r104 = AppHost.f326268a.getApplication().getContentResolver();     // Catch: Exception -> L15
        Uri r105 = UriProtector.parse("content://com.obric.memorydata.memory.provider");     // Catch: Exception -> L15
        Bundle r106 = new Bundle();     // Catch: Exception -> L15
        r106.putString(ST.UUID_DEVICE, r103.getMemoryUuid());     // Catch: Exception -> L15
        r106.putInt("entityType", r103.getEntityType());     // Catch: Exception -> L15
        Unit r107 = Unit.INSTANCE;     // Catch: Exception -> L15
        Bundle r108 = r104.call(r105, "openMemoryDetail", null, r106);     // Catch: Exception -> L15
        int r109 = 1;
        if (r108 != null) goto L6;
    L8:
        boolean r110 = false;
    L9:
        Intrinsics.checkNotNullParameter(AbsOpenMemoryDetailMethodIDL.b.class, "<this>");     // Catch: Exception -> L15
        BaseModel r111 = k3.c.a(AbsOpenMemoryDetailMethodIDL.b.class);     // Catch: Exception -> L15
        AbsOpenMemoryDetailMethodIDL.b r112 = (AbsOpenMemoryDetailMethodIDL.b) r111;     // Catch: Exception -> L15
        if (r110 == true) goto L13;
        r109 = 0;
    L13:
        r112.setResult(r109);     // Catch: Exception -> L15
        r102.b((ResultModel) r111, "");     // Catch: Exception -> L15
        return;
    L6:
        if (r108.getBoolean("result", false) != true) goto L8;
        r110 = true;
    L15:
        e = move-exception;
        f3.h.a.a(r102, "OpenMemoryDetailMethod error: " + e.getMessage(), null, null, 14);
    }
}
