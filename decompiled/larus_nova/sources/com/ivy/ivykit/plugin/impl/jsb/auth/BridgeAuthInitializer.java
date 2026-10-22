package com.ivy.ivykit.plugin.impl.jsb.auth;

import com.bytedance.keva.Keva;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.HeaderMap;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes23.dex */
public final class BridgeAuthInitializer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Keva f278379a = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001JF\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u001a\b\u0001\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\tH'¨\u0006\n"}, d2 = {"Lcom/ivy/ivykit/plugin/impl/jsb/auth/BridgeAuthInitializer$BridgePermissionAPI;", "", "doPost", "Lcom/bytedance/retrofit2/Call;", "", "url", "headerMap", "", ContainerPosition.BODY, "Lcom/bytedance/retrofit2/mime/TypedOutput;", "ivy_plugin_impl_bullet_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface BridgePermissionAPI {
        @POST
        Call<String> doPost(@Url String r100, @HeaderMap Map<String, String> r101, @Body TypedOutput r102);
    }

    static {
        f278379a = Keva.getRepo("bridge_auth_cn", 0);
    }
}
