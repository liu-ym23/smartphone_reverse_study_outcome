package jd7;

import com.android.ttcjpaysdk.integrated.counter.outerpay.CJOuterPayManager;
import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes22.dex */
public abstract class a extends XCoreIDLBridgeMethod<c, d> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f498645c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.getUserInfo", params = {""}, results = {Keys.API_RETURN_KEY_IS_LOGIN, "hasLoggedIn", "userInfo"})
    public final String f498646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f498647b;

    /* JADX INFO: renamed from: jd7.a$a, reason: collision with other inner class name */
    public static final class C6418a {
    }

    public interface b extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "avatarURL", required = false)
        String getAvatarURL();

        @XBridgeParamField(isGetter = true, keyPath = CJOuterPayManager.KEY_BINDPHONE, required = false)
        String getBindPhone();

        @XBridgeParamField(isGetter = true, keyPath = "hasBoundPhone", required = false)
        Boolean getHasBoundPhone();

        @XBridgeParamField(isGetter = true, keyPath = InstantPlayContext.NICKNAME, required = false)
        String getNickname();

        @XBridgeParamField(isGetter = true, keyPath = "secUserID", required = false)
        String getSecUserID();

        @XBridgeParamField(isGetter = true, keyPath = "shortID", required = false)
        String getShortID();

        @XBridgeParamField(isGetter = true, keyPath = "uniqueID", required = false)
        String getUniqueID();

        @XBridgeParamField(isGetter = true, keyPath = "userID", required = false)
        String getUserID();

        @XBridgeParamField(isGetter = true, keyPath = "isBoundPhone", required = false)
        Boolean isBoundPhone();

        @XBridgeParamField(isGetter = false, keyPath = "avatarURL", required = false)
        void setAvatarURL(String r100);

        @XBridgeParamField(isGetter = false, keyPath = CJOuterPayManager.KEY_BINDPHONE, required = false)
        void setBindPhone(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "isBoundPhone", required = false)
        void setBoundPhone(Boolean r100);

        @XBridgeParamField(isGetter = false, keyPath = "hasBoundPhone", required = false)
        void setHasBoundPhone(Boolean r100);

        @XBridgeParamField(isGetter = false, keyPath = InstantPlayContext.NICKNAME, required = false)
        void setNickname(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "secUserID", required = false)
        void setSecUserID(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "shortID", required = false)
        void setShortID(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "uniqueID", required = false)
        void setUniqueID(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "userID", required = false)
        void setUserID(String r100);
    }

    @XBridgeParamModel
    public interface c extends XBaseParamModel {
    }

    @XBridgeResultModel
    public interface d extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "hasLoggedIn", required = true)
        Boolean getHasLoggedIn();

        @XBridgeParamField(isGetter = true, keyPath = "userInfo", nestedClassType = b.class, required = false)
        b getUserInfo();

        @XBridgeParamField(isGetter = true, keyPath = Keys.API_RETURN_KEY_IS_LOGIN, required = true)
        Boolean isLogin();

        @XBridgeParamField(isGetter = false, keyPath = "hasLoggedIn", required = true)
        void setHasLoggedIn(Boolean r100);

        @XBridgeParamField(isGetter = false, keyPath = Keys.API_RETURN_KEY_IS_LOGIN, required = true)
        void setLogin(Boolean r100);

        @XBridgeParamField(isGetter = false, keyPath = "userInfo", nestedClassType = b.class, required = false)
        void setUserInfo(b r100);
    }

    static {
        f498645c = MapsKt.mapOf(TuplesKt.to("TicketID", "32019"));
    }

    public a() {
        this.f498646a = "x.getUserInfo";
        this.f498647b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f498647b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f498646a;
    }
}
