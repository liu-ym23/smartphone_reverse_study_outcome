package com.bytedance.live.bizlink.impl.platform.dynamic.base;

import ch6.e;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/live/bizlink/impl/platform/dynamic/base/MultiLinkHybMediaGetAction;", "", "Lch6/e;", "", ReportConstant.COMMON_ACTION_TYPE, "Ljava/lang/String;", "getActionType", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "GetLiveCoreInfo", "GetRtcExtInfo", "GetRTCLocalMediaStatus", "GetIsRtcEngineOn", "GetIsSingleViewMode", "GetRtcStreamMixType", "multi-biz-link-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MultiLinkHybMediaGetAction extends Enum<MultiLinkHybMediaGetAction> implements e {
    public static final a Companion = null;
    public static final MultiLinkHybMediaGetAction GetIsRtcEngineOn = null;
    public static final MultiLinkHybMediaGetAction GetIsSingleViewMode = null;
    public static final MultiLinkHybMediaGetAction GetLiveCoreInfo = null;
    public static final MultiLinkHybMediaGetAction GetRTCLocalMediaStatus = null;
    public static final MultiLinkHybMediaGetAction GetRtcExtInfo = null;
    public static final MultiLinkHybMediaGetAction GetRtcStreamMixType = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MultiLinkHybMediaGetAction[] f254894a = null;
    private final String actionType;

    public static final class a {
        public a() {
        }
    }

    static {
        MultiLinkHybMediaGetAction r100 = new MultiLinkHybMediaGetAction("GetLiveCoreInfo", 0, "get_live_core_info");
        GetLiveCoreInfo = r100;
        MultiLinkHybMediaGetAction r101 = new MultiLinkHybMediaGetAction("GetRtcExtInfo", 1, "get_rtc_ext_info");
        GetRtcExtInfo = r101;
        MultiLinkHybMediaGetAction r102 = new MultiLinkHybMediaGetAction("GetRTCLocalMediaStatus", 2, "get_local_media_status");
        GetRTCLocalMediaStatus = r102;
        MultiLinkHybMediaGetAction r103 = new MultiLinkHybMediaGetAction("GetIsRtcEngineOn", 3, "rtc_is_rtc_engine_on");
        GetIsRtcEngineOn = r103;
        MultiLinkHybMediaGetAction r104 = new MultiLinkHybMediaGetAction("GetIsSingleViewMode", 4, "rtc_is_single_view_mode");
        GetIsSingleViewMode = r104;
        MultiLinkHybMediaGetAction r105 = new MultiLinkHybMediaGetAction("GetRtcStreamMixType", 5, "get_rtc_stream_mix_type");
        GetRtcStreamMixType = r105;
        f254894a = new MultiLinkHybMediaGetAction[]{r100, r101, r102, r103, r104, r105};
        Companion = new a();
    }

    public static MultiLinkHybMediaGetAction valueOf(String r100) {
        return (MultiLinkHybMediaGetAction) r27.a.a(MultiLinkHybMediaGetAction.class, r100);
    }

    public static MultiLinkHybMediaGetAction[] values() {
        return (MultiLinkHybMediaGetAction[]) f254894a.clone();
    }

    public final String getActionType() {
        return this.actionType;
    }

    public MultiLinkHybMediaGetAction(String r100, int r101, String r102) {
        super(r100, r101);
        this.actionType = r102;
    }
}
