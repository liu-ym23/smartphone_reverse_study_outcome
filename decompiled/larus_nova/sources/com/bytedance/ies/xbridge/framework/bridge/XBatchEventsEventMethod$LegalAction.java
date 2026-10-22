package com.bytedance.ies.xbridge.framework.bridge;

import com.bytedance.pitaya.api.PTYSocketStateCallback;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"com/bytedance/ies/xbridge/framework/bridge/XBatchEventsEventMethod$LegalAction", "", "Lcom/bytedance/ies/xbridge/framework/bridge/XBatchEventsEventMethod$LegalAction;", "", ReportConstant.COMMON_ACTION_TYPE, "Ljava/lang/String;", "getActionType", "()Ljava/lang/String;", PTYSocketStateCallback.CLOSED, "anniex-deprecated_release"}, k = 1, mv = {1, 4, 3})
public final enum XBatchEventsEventMethod$LegalAction extends Enum<XBatchEventsEventMethod$LegalAction> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ XBatchEventsEventMethod$LegalAction[] f249495a = null;
    public static final XBatchEventsEventMethod$LegalAction closed = null;
    private final String actionType;

    public XBatchEventsEventMethod$LegalAction() {
        super(PTYSocketStateCallback.CLOSED, 0);
        this.actionType = PTYSocketStateCallback.CLOSED;
    }

    public static XBatchEventsEventMethod$LegalAction valueOf(String r100) {
        return (XBatchEventsEventMethod$LegalAction) a.a(XBatchEventsEventMethod$LegalAction.class, r100);
    }

    public static XBatchEventsEventMethod$LegalAction[] values() {
        return (XBatchEventsEventMethod$LegalAction[]) f249495a.clone();
    }

    static {
        XBatchEventsEventMethod$LegalAction r100 = new XBatchEventsEventMethod$LegalAction();
        closed = r100;
        f249495a = new XBatchEventsEventMethod$LegalAction[]{r100};
    }

    public final String getActionType() {
        return this.actionType;
    }
}
