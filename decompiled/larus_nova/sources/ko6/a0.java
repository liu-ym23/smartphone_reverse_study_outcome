package ko6;

import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.annotation.XBridgeMethodName;
import com.bytedance.ies.xbridge.annotation.XBridgeModelExtension;
import com.bytedance.ies.xbridge.annotation.XBridgeParamField;
import com.bytedance.ies.xbridge.annotation.XBridgeParamModel;
import com.bytedance.ies.xbridge.annotation.XBridgePermission;
import com.bytedance.ies.xbridge.annotation.XBridgeResultModel;
import com.bytedance.ies.xbridge.model.idl.XBaseModel;
import com.bytedance.ies.xbridge.model.idl.XBaseParamModel;
import com.bytedance.ies.xbridge.model.idl.XBaseResultModel;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes21.dex */
public abstract class a0 extends v56.c<b, c> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f504432d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgeMethodName(name = "poi_location_service", params = {"enterFrom", "serviceRequestAlertConfig", "authRequestAlertConfig", "ignoreAlertInterval", "extraReportParams", "dialogStyle", "authRequestBottomBarConfig", "bid", "containerID"}, results = {"allow", "error"})
    public final String f504433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f504434c;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "authRequestAlertConfig", nestedClassType = d.class, required = false)
        d getAuthRequestAlertConfig();

        @XBridgeParamField(isGetter = true, keyPath = "authRequestBottomBarConfig", nestedClassType = e.class, required = false)
        e getAuthRequestBottomBarConfig();

        @XBridgeParamField(isGetter = true, keyPath = "bid", required = false)
        String getBid();

        @XBridgeParamField(isGetter = true, keyPath = "containerID", required = false)
        String getContainerID();

        @XBridgeParamField(isGetter = true, keyPath = "dialogStyle", required = false)
        Number getDialogStyle();

        @XBridgeParamField(isGetter = true, keyPath = "enterFrom", required = true)
        String getEnterFrom();

        @XBridgeParamField(isGetter = true, keyPath = "extraReportParams", required = false)
        String getExtraReportParams();

        @XBridgeParamField(isGetter = true, keyPath = "ignoreAlertInterval", required = false)
        Boolean getIgnoreAlertInterval();

        @XBridgeParamField(isGetter = true, keyPath = "serviceRequestAlertConfig", nestedClassType = g.class, required = false)
        g getServiceRequestAlertConfig();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "allow", required = true)
        Boolean getAllow();

        @XBridgeParamField(isGetter = true, keyPath = "error", nestedClassType = f.class, required = false)
        f getError();

        @XBridgeParamField(isGetter = false, keyPath = "allow", required = true)
        void setAllow(Boolean r100);

        @XBridgeParamField(isGetter = false, keyPath = "error", nestedClassType = f.class, required = false)
        void setError(f r100);
    }

    public interface d extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "actionText", required = false)
        String getActionText();

        @XBridgeParamField(isGetter = true, keyPath = "cancelText", required = false)
        String getCancelText();

        @XBridgeParamField(isGetter = true, keyPath = "dialogStyle", required = false)
        Number getDialogStyle();

        @XBridgeParamField(isGetter = true, keyPath = "showAuthorizationInAppAlert", required = false)
        Boolean getShowAuthorizationInAppAlert();

        @XBridgeParamField(isGetter = true, keyPath = "subtitle", required = false)
        String getSubtitle();

        @XBridgeParamField(isGetter = true, keyPath = "title", required = false)
        String getTitle();

        @XBridgeParamField(isGetter = true, keyPath = "withBottomBar", required = false)
        Boolean getWithBottomBar();
    }

    public interface e extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "actionText", required = false)
        String getActionText();

        @XBridgeParamField(isGetter = true, keyPath = "bottomOffset", required = false)
        Number getBottomOffset();

        @XBridgeParamField(isGetter = true, keyPath = RXScreenCaptureService.KEY_CONTENT_TEXT, required = false)
        String getContentText();

        @XBridgeParamField(isGetter = true, keyPath = "dismissTime", required = false)
        Number getDismissTime();
    }

    public interface f extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "errorCode", required = true)
        Number getErrorCode();

        @XBridgeParamField(isGetter = true, keyPath = "errorDesc", required = true)
        String getErrorDesc();

        @XBridgeParamField(isGetter = false, keyPath = "errorCode", required = true)
        void setErrorCode(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "errorDesc", required = true)
        void setErrorDesc(String r100);
    }

    public interface g extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "actionText", required = false)
        String getActionText();

        @XBridgeParamField(isGetter = true, keyPath = "cancelText", required = false)
        String getCancelText();

        @XBridgeParamField(isGetter = true, keyPath = "dialogStyle", required = false)
        Number getDialogStyle();

        @XBridgeParamField(isGetter = true, keyPath = "showServiceInAppAlert", required = false)
        Boolean getShowServiceInAppAlert();

        @XBridgeParamField(isGetter = true, keyPath = "subtitle", required = false)
        String getSubtitle();

        @XBridgeParamField(isGetter = true, keyPath = "title", required = false)
        String getTitle();
    }

    static {
        f504432d = MapsKt.mapOf(TuplesKt.to("TicketID", "38115"));
    }

    public a0() {
        this.f504433b = "poi_location_service";
        this.f504434c = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // v56.c, com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f504434c;
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final String getName() {
        return this.f504433b;
    }
}
