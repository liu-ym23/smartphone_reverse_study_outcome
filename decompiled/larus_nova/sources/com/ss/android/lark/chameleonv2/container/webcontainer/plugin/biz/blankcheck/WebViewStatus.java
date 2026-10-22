package com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.blankcheck;

import com.bytedance.map.api.monitor.MapMonitorConst;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chameleonv2/container/webcontainer/plugin/biz/blankcheck/WebViewStatus;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", EffectConstants.NORMAL, "DESTROY", "UN_ATTACHED", "UN_SHOWN", "UN_KNOWN", "chameleon_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WebViewStatus extends Enum<WebViewStatus> {
    public static final WebViewStatus DESTROY = null;
    public static final WebViewStatus NORMAL = null;
    public static final WebViewStatus UN_ATTACHED = null;
    public static final WebViewStatus UN_KNOWN = null;
    public static final WebViewStatus UN_SHOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WebViewStatus[] f411223a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f411224b = null;
    private final String type;

    public static EnumEntries<WebViewStatus> getEntries() {
        return f411224b;
    }

    static {
        WebViewStatus r100 = new WebViewStatus(EffectConstants.NORMAL, 0, "normal");
        NORMAL = r100;
        WebViewStatus r101 = new WebViewStatus("DESTROY", 1, MapMonitorConst.EVENT_DESTROY);
        DESTROY = r101;
        WebViewStatus r102 = new WebViewStatus("UN_ATTACHED", 2, "un_attached");
        UN_ATTACHED = r102;
        WebViewStatus r103 = new WebViewStatus("UN_SHOWN", 3, "un_shown");
        UN_SHOWN = r103;
        WebViewStatus r104 = new WebViewStatus("UN_KNOWN", 4, "un_known");
        UN_KNOWN = r104;
        WebViewStatus[] r105 = {r100, r101, r102, r103, r104};
        f411223a = r105;
        f411224b = EnumEntriesKt.enumEntries(r105);
    }

    public static WebViewStatus[] values() {
        return (WebViewStatus[]) f411223a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static WebViewStatus valueOf(String r100) {
        return (WebViewStatus) r27.a.a(WebViewStatus.class, r100);
    }

    public WebViewStatus(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
