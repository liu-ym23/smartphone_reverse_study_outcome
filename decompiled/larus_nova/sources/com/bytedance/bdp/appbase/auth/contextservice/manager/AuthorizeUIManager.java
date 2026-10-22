package com.bytedance.bdp.appbase.auth.contextservice.manager;

import android.app.Activity;
import b94.b;
import com.bytedance.bdp.appbase.auth.constant.AuthEvent;
import com.bytedance.bdp.appbase.auth.constant.PrivacyScopeAuthorizeStatus;
import com.bytedance.bdp.appbase.auth.contextservice.ILifecycle;
import com.bytedance.bdp.appbase.auth.ui.entity.AuthViewProperty;
import com.bytedance.bdp.appbase.context.BdpAppContext;
import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import d94.c;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b'\u0018\u0000 72\u00020\u0001:\u00018B\u000f\u0012\u0006\u00101\u001a\u000200¢\u0006\u0004\b5\u00106J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H'J=\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J8\u0010\u0012\u001a\u0004\u0018\u00010\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\f2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H&J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0014H\u0016J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0014H&J\b\u0010\u001e\u001a\u00020\u001dH&J$\u0010$\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010#H\u0017J'\u0010'\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160%H\u0016¢\u0006\u0004\b'\u0010(J\u0010\u0010,\u001a\u00020+2\u0006\u0010*\u001a\u00020)H&J\b\u0010.\u001a\u00020-H\u0016J\b\u0010/\u001a\u00020-H\u0016R\u0017\u00101\u001a\u0002008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u00069"}, d2 = {"Lcom/bytedance/bdp/appbase/auth/contextservice/manager/AuthorizeUIManager;", "Lcom/bytedance/bdp/appbase/auth/contextservice/ILifecycle;", "Landroid/app/Activity;", "activity", "Lcom/bytedance/bdp/appbase/auth/ui/entity/AuthViewProperty;", KFAnimation.PROPERTY_TYPE_JSON_FIELD, "Ld94/a;", "callback", "", "showAuthDialog", "", "authViewType", "", "", "permissionInfoList", "permissionId", "Lcom/bytedance/bdp/appbase/auth/constant/PrivacyScopeAuthorizeStatus;", "privacyScopeAuthorizeStatus", "createAuthViewProperty", "(ILjava/util/List;Ljava/lang/Integer;Lcom/bytedance/bdp/appbase/auth/constant/PrivacyScopeAuthorizeStatus;)Lcom/bytedance/bdp/appbase/auth/ui/entity/AuthViewProperty;", "Lb94/b;", "needAuthAppPermissions", "", "permissionKeyList", "Le94/b;", ControlRule.KEY_EXTRA_DATA, "bdpPermission", "getPermissionName", "getPermissionDesc", "Ld94/c;", "getDefaultValueConfig", "Lc94/a;", "authDialog", "Lcom/bytedance/bdp/appbase/auth/constant/AuthEvent;", "eventType", "Lorg/json/JSONObject;", "onAuthViewEvent", "", "neverAskPermissions", "handleSystemNeverShowPermissionDialog", "(Landroid/app/Activity;[Ljava/lang/String;)V", "Ld94/b$a;", "layout", "Ld94/b;", "createAuthViewStyle", "", "clickAuthViewAllowButton", "clickAuthViewCancelButton", "Lcom/bytedance/bdp/appbase/context/BdpAppContext;", "appContext", "Lcom/bytedance/bdp/appbase/context/BdpAppContext;", "getAppContext", "()Lcom/bytedance/bdp/appbase/context/BdpAppContext;", "<init>", "(Lcom/bytedance/bdp/appbase/context/BdpAppContext;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "bdp-eco-core_release"}, k = 1, mv = {1, 4, 0})
public abstract class AuthorizeUIManager implements ILifecycle {
    public static final a Companion = null;
    private static final String TAG = "AuthorizeUIManager";
    private final BdpAppContext appContext;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public boolean clickAuthViewAllowButton() {
        return false;
    }

    public boolean clickAuthViewCancelButton() {
        return false;
    }

    public abstract AuthViewProperty createAuthViewProperty(int r100, List<Object> r101, Integer r102, PrivacyScopeAuthorizeStatus r103);

    public abstract AuthViewProperty createAuthViewProperty(List<? extends b> r100, PrivacyScopeAuthorizeStatus r101, List<String> r102, e94.b r103);

    public abstract d94.b createAuthViewStyle(d94.b.a r100);

    public abstract c getDefaultValueConfig();

    public abstract String getPermissionDesc(b r100);

    public void handleSystemNeverShowPermissionDialog(Activity r100, String[] r101) {
    }

    public abstract void showAuthDialog(Activity r100, AuthViewProperty r101, d94.a r102);

    public final BdpAppContext getAppContext() {
        return this.appContext;
    }

    public AuthorizeUIManager(BdpAppContext r100) {
        this.appContext = r100;
    }

    public String getPermissionName(b r100) {
        return r100.a(this.appContext.f200764d);
    }

    public void onAuthViewEvent(c94.a r100, AuthEvent r101, JSONObject r102) {
        g94.b.d(TAG, new Object[]{"auth view event not handled"});
    }

    public static /* synthetic */ void onAuthViewEvent$default(AuthorizeUIManager r100, c94.a r101, AuthEvent r102, JSONObject r103, int r104, Object r105) {
        if (r105 != null) goto L9;
        if ((r104 & 4) == 0) goto L6;
        r103 = null;
    L6:
        r100.onAuthViewEvent(r101, r102, r103);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onAuthViewEvent");
    }

    public static /* synthetic */ AuthViewProperty createAuthViewProperty$default(AuthorizeUIManager r100, int r101, List r102, Integer r103, PrivacyScopeAuthorizeStatus r104, int r105, Object r106) {
        if (r106 != null) goto L12;
        if ((r105 & 4) == 0) goto L7;
        r103 = null;
    L7:
        if ((r105 & 8) == 0) goto L9;
        r104 = PrivacyScopeAuthorizeStatus.DO_NOT_NEED_AUTHORIZE;
    L9:
        r100.createAuthViewProperty(r101, r102, r103, r104);
        return null;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createAuthViewProperty");
    }
}
