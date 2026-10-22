package com.bytedance.ies.xbridge.ui.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"com/bytedance/ies/xbridge/ui/model/XShowActionSheetResultModel$ResultAction", "", "Lcom/bytedance/ies/xbridge/ui/model/XShowActionSheetResultModel$ResultAction;", "", "action", "Ljava/lang/String;", "getAction", "()Ljava/lang/String;", "SELECT", "DISMISS", "anniex-deprecated_release"}, k = 1, mv = {1, 4, 3})
public final enum XShowActionSheetResultModel$ResultAction extends Enum<XShowActionSheetResultModel$ResultAction> {
    public static final XShowActionSheetResultModel$ResultAction DISMISS = null;
    public static final XShowActionSheetResultModel$ResultAction SELECT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ XShowActionSheetResultModel$ResultAction[] f249552a = null;
    private final String action;

    public static XShowActionSheetResultModel$ResultAction valueOf(String r100) {
        return (XShowActionSheetResultModel$ResultAction) a.a(XShowActionSheetResultModel$ResultAction.class, r100);
    }

    public static XShowActionSheetResultModel$ResultAction[] values() {
        return (XShowActionSheetResultModel$ResultAction[]) f249552a.clone();
    }

    static {
        XShowActionSheetResultModel$ResultAction r100 = new XShowActionSheetResultModel$ResultAction("SELECT", 0, "select");
        SELECT = r100;
        XShowActionSheetResultModel$ResultAction r101 = new XShowActionSheetResultModel$ResultAction("DISMISS", 1, "dismiss");
        DISMISS = r101;
        f249552a = new XShowActionSheetResultModel$ResultAction[]{r100, r101};
    }

    public final String getAction() {
        return this.action;
    }

    public XShowActionSheetResultModel$ResultAction(String r100, int r101, String r102) {
        super(r100, r101);
        this.action = r102;
    }
}
