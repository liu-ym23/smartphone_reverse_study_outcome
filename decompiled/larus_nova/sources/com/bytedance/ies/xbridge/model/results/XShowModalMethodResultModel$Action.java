package com.bytedance.ies.xbridge.model.results;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/bytedance/ies/xbridge/model/results/XShowModalMethodResultModel$Action", "", "Lcom/bytedance/ies/xbridge/model/results/XShowModalMethodResultModel$Action;", "CONFIRM", "CANCEL", "MASK", "anniex-deprecated_release"}, k = 1, mv = {1, 4, 3})
public final enum XShowModalMethodResultModel$Action extends Enum<XShowModalMethodResultModel$Action> {
    public static final XShowModalMethodResultModel$Action CANCEL = null;
    public static final XShowModalMethodResultModel$Action CONFIRM = null;
    public static final XShowModalMethodResultModel$Action MASK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ XShowModalMethodResultModel$Action[] f249509a = null;

    public static XShowModalMethodResultModel$Action valueOf(String r100) {
        return (XShowModalMethodResultModel$Action) a.a(XShowModalMethodResultModel$Action.class, r100);
    }

    public static XShowModalMethodResultModel$Action[] values() {
        return (XShowModalMethodResultModel$Action[]) f249509a.clone();
    }

    static {
        XShowModalMethodResultModel$Action r100 = new XShowModalMethodResultModel$Action("CONFIRM", 0);
        CONFIRM = r100;
        XShowModalMethodResultModel$Action r101 = new XShowModalMethodResultModel$Action("CANCEL", 1);
        CANCEL = r101;
        XShowModalMethodResultModel$Action r102 = new XShowModalMethodResultModel$Action("MASK", 2);
        MASK = r102;
        f249509a = new XShowModalMethodResultModel$Action[]{r100, r101, r102};
    }

    public XShowModalMethodResultModel$Action(String r100, int r101) {
        super(r100, r101);
    }
}
