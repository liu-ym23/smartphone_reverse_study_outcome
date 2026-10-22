package com.ss.android.lark.officewebview.monitor.webview;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officewebview/monitor/webview/LarkWebViewMonitorParams$BIZ;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", PreloadConfigModel.VERSION_CHECK_TYPE_DOC, "GADGET", "MAIL", "webview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LarkWebViewMonitorParams$BIZ extends Enum<LarkWebViewMonitorParams$BIZ> {
    public static final LarkWebViewMonitorParams$BIZ DEFAULT = null;
    public static final LarkWebViewMonitorParams$BIZ DOC = null;
    public static final LarkWebViewMonitorParams$BIZ GADGET = null;
    public static final LarkWebViewMonitorParams$BIZ MAIL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LarkWebViewMonitorParams$BIZ[] f437472a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f437473b = null;

    public static EnumEntries<LarkWebViewMonitorParams$BIZ> getEntries() {
        return f437473b;
    }

    static {
        LarkWebViewMonitorParams$BIZ r100 = new LarkWebViewMonitorParams$BIZ("DEFAULT", 0);
        DEFAULT = r100;
        LarkWebViewMonitorParams$BIZ r101 = new LarkWebViewMonitorParams$BIZ(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 1);
        DOC = r101;
        LarkWebViewMonitorParams$BIZ r102 = new LarkWebViewMonitorParams$BIZ("GADGET", 2);
        GADGET = r102;
        LarkWebViewMonitorParams$BIZ r103 = new LarkWebViewMonitorParams$BIZ("MAIL", 3);
        MAIL = r103;
        LarkWebViewMonitorParams$BIZ[] r104 = {r100, r101, r102, r103};
        f437472a = r104;
        f437473b = EnumEntriesKt.enumEntries(r104);
    }

    public static LarkWebViewMonitorParams$BIZ[] values() {
        return (LarkWebViewMonitorParams$BIZ[]) f437472a.clone();
    }

    public static LarkWebViewMonitorParams$BIZ valueOf(String r100) {
        return (LarkWebViewMonitorParams$BIZ) a.a(LarkWebViewMonitorParams$BIZ.class, r100);
    }

    public LarkWebViewMonitorParams$BIZ(String r100, int r101) {
        super(r100, r101);
    }
}
