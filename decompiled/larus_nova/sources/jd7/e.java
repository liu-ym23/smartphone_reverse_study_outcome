package jd7;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.getUserInfo")
public final class e extends a {
    public e() {
        ConcurrentHashMap<Class<? extends IDLXBridgeMethod>, id7.b> r100 = id7.e.f489350a;
        id7.e.a(e.class, new id7.b(a.c.class, a.d.class));
    }

    public static void a(IBDXBridgeContext r100, a.c r101, CompletionBlock r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        int r103 = com.bytedance.sdk.xbridge.cn.utils.g.f270260a;
        XBaseRuntime.f270095a.getClass();
        IHostUserDepend r104 = XBaseRuntime.f270103i;
        Unit r105 = null;
        if (r104 == null) goto L42;
        XBaseModel r106 = ne7.e.c(Reflection.getOrCreateKotlinClass(a.d.class));
        a.d r107 = (a.d) r106;
        boolean r108 = r104.hasLogin();
        r107.setHasLoggedIn(Boolean.valueOf(r108));
        r107.setLogin(Boolean.valueOf(r108));
        if (r108 == false) goto L41;
        a.b r109 = (a.b) ne7.e.c(Reflection.getOrCreateKotlinClass(a.b.class));
        String r110 = r104.getUserId();
        String r111 = "";
        if (r110 != null) goto L9;
        r110 = "";
    L9:
        r109.setUserID(r110);
        String r112 = r104.getSecUid();
        if (r112 != null) goto L12;
        r112 = "";
    L12:
        r109.setSecUserID(r112);
        String r113 = r104.getUniqueID();
        if (r113 != null) goto L15;
        r113 = "";
    L15:
        r109.setUniqueID(r113);
        String r114 = r104.getNickname();
        if (r114 != null) goto L18;
        r114 = "";
    L18:
        r109.setNickname(r114);
        String r115 = r104.getAvatarURL();
        if (r115 != null) goto L21;
        r115 = "";
    L21:
        r109.setAvatarURL(r115);
        String r116 = r104.getBoundPhone();
        if (r116 != null) goto L25;
        r116 = "";
    L25:
        if (r116.length() <= 0) goto L27;
        boolean r117 = true;
    L28:
        r109.setHasBoundPhone(Boolean.valueOf(r117));
        r109.setBoundPhone(r109.getHasBoundPhone());
        String r118 = r104.getBoundPhone();
        if (r118 != null) goto L31;
        r118 = "";
    L31:
        r109.setBindPhone(r118);
        if (Intrinsics.areEqual(r107.getHasLoggedIn(), Boolean.TRUE) == false) goto L40;
        IHostUserDepend.UserModelExt r119 = r104.getUserModelExt();
        if (r119 == null) goto L39;
        String r120 = r119.getShortID();
        if (r120 == null) goto L39;
        r111 = r120;
    L39:
        r109.setShortID(r111);
    L40:
        r107.setUserInfo(r109);
        goto L41
    L27:
        r117 = false;
    L41:
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) r106, null, 2, null);
        r105 = Unit.INSTANCE;
    L42:
        if (r105 != null) goto L45;
        CompletionBlock.DefaultImpls.onFailure$default(r102, 0, "hostUserDepend is null", null, 4, null);
        return;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final /* bridge */ /* synthetic */ void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        a(r100, (a.c) r101, r102);
    }
}
