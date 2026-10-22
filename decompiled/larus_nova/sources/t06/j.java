package t06;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010 \n\u0002\b\u000f\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR*\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R0\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR0\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR0\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001a\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u001c\u0010%\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006R\u001c\u0010'\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006R\u001c\u0010)\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006R\u001c\u0010+\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006R\u001c\u0010-\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\"\u00102\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u0001018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010\u0004\u001a\u0004\b7\u0010\u0006R\"\u00108\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u0001018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b8\u00103\u001a\u0004\b9\u00105R\u001c\u0010:\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010\u0004\u001a\u0004\b;\u0010\u0006R\u001c\u0010<\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010.\u001a\u0004\b=\u00100R\"\u0010>\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u0001018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b>\u00103\u001a\u0004\b?\u00105¨\u0006@"}, d2 = {"Lt06/j;", "Lt06/a;", "", "enableWebForcePrivate", "Ljava/lang/Boolean;", "h", "()Ljava/lang/Boolean;", "setEnableWebForcePrivate", "(Ljava/lang/Boolean;)V", "", "", "webPublicMethods", "[Ljava/lang/String;", "m", "()[Ljava/lang/String;", "setWebPublicMethods", "([Ljava/lang/String;)V", "enableLynxForcePrivate", "d", "setEnableLynxForcePrivate", "lynxPublicMethods", ce.f26395j, "setLynxPublicMethods", "", "", "commonSecureMethods", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "setCommonSecureMethods", "(Ljava/util/Map;)V", "webSecureMethods", OfficeSDKRequestTag.KEY_NEW_USER, "setWebSecureMethods", "lynxSecureMethods", ce.f26396k, "setLynxSecureMethods", "enableLynxJsbAuth", "e", "enableLynxJsbCallLimit", "f", "enableWebJsbAuth", RXScreenCaptureService.KEY_INDEX, "enableWebJsbCallLimit", "getEnableWebJsbCallLimit", "webTokenAuthMode", "Ljava/lang/Integer;", "getWebTokenAuthMode", "()Ljava/lang/Integer;", "", "webTokenAuthDegradeList", "Ljava/util/List;", "getWebTokenAuthDegradeList", "()Ljava/util/List;", "disableAllContent", "b", "disableContentHost", "c", "enableUseWebContentDisable", ce.f26391f, "sampleLevel", "l", "webPrivateDomains", "getWebPrivateDomains", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class j extends a {

    @SerializedName("common_secure_method")
    private Map<String, Integer> commonSecureMethods;

    @SerializedName("disable_all_content")
    private final Boolean disableAllContent;

    @SerializedName("disable_content_host")
    private final List<String> disableContentHost;

    @SerializedName("enable_lynx_force_private")
    private Boolean enableLynxForcePrivate;

    @SerializedName("enable_lynx_jsb_auth")
    private final Boolean enableLynxJsbAuth;

    @SerializedName("enable_lynx_jsb_call_limit")
    private final Boolean enableLynxJsbCallLimit;

    @SerializedName("enable_use_web_content_disable")
    private final Boolean enableUseWebContentDisable;

    @SerializedName("enable_web_force_private")
    private Boolean enableWebForcePrivate;

    @SerializedName("enable_web_jsb_auth")
    private final Boolean enableWebJsbAuth;

    @SerializedName("enable_web_jsb_call_limit")
    private final Boolean enableWebJsbCallLimit;

    @SerializedName("lynx_public_method")
    private String[] lynxPublicMethods;

    @SerializedName("lynx_secure_method")
    private Map<String, Integer> lynxSecureMethods;

    @SerializedName("web_content_disable_report_sample")
    private final Integer sampleLevel;

    @SerializedName("private_domains")
    private final List<String> webPrivateDomains;

    @SerializedName("web_public_method")
    private String[] webPublicMethods;

    @SerializedName("web_secure_method")
    private Map<String, Integer> webSecureMethods;

    @SerializedName("web_token_auth_degrade_list")
    private final List<String> webTokenAuthDegradeList;

    @SerializedName("web_token_auth_mode")
    private final Integer webTokenAuthMode;

    public j() {
        Boolean r100 = Boolean.FALSE;
        Boolean r101 = Boolean.TRUE;
        Map<String, Integer> r102 = MapsKt.emptyMap();
        Map<String, Integer> r103 = MapsKt.emptyMap();
        Map<String, Integer> r104 = MapsKt.emptyMap();
        List<String> r105 = CollectionsKt.emptyList();
        List<String> r106 = CollectionsKt.emptyList();
        this.enableWebForcePrivate = r100;
        this.webPublicMethods = new String[0];
        this.enableLynxForcePrivate = r101;
        this.lynxPublicMethods = new String[0];
        this.commonSecureMethods = r102;
        this.webSecureMethods = r103;
        this.lynxSecureMethods = r104;
        this.enableLynxJsbAuth = null;
        this.enableLynxJsbCallLimit = null;
        this.enableWebJsbAuth = null;
        this.enableWebJsbCallLimit = null;
        this.webTokenAuthMode = null;
        this.webTokenAuthDegradeList = null;
        this.disableAllContent = null;
        this.disableContentHost = r105;
        this.enableUseWebContentDisable = null;
        this.sampleLevel = null;
        this.webPrivateDomains = r106;
    }

    public final Map<String, Integer> a() {
        return this.commonSecureMethods;
    }

    public final Boolean b() {
        return this.disableAllContent;
    }

    public final List<String> c() {
        return this.disableContentHost;
    }

    public final Boolean d() {
        return this.enableLynxForcePrivate;
    }

    public final Boolean e() {
        return this.enableLynxJsbAuth;
    }

    public final Boolean f() {
        return this.enableLynxJsbCallLimit;
    }

    public final Boolean g() {
        return this.enableUseWebContentDisable;
    }

    public final Boolean h() {
        return this.enableWebForcePrivate;
    }

    public final Boolean i() {
        return this.enableWebJsbAuth;
    }

    public final String[] j() {
        return this.lynxPublicMethods;
    }

    public final Map<String, Integer> k() {
        return this.lynxSecureMethods;
    }

    public final Integer l() {
        return this.sampleLevel;
    }

    public final String[] m() {
        return this.webPublicMethods;
    }

    public final Map<String, Integer> n() {
        return this.webSecureMethods;
    }
}
