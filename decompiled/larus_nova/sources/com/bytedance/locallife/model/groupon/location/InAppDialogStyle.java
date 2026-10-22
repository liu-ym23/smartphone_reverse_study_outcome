package com.bytedance.locallife.model.groupon.location;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/locallife/model/groupon/location/InAppDialogStyle;", "", "", "reportName", "Ljava/lang/String;", "MIDDLE", "BOTTOM", "BOTTOM_BAR", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final enum InAppDialogStyle extends Enum<InAppDialogStyle> {
    public static final InAppDialogStyle BOTTOM = null;
    public static final InAppDialogStyle BOTTOM_BAR = null;
    public static final InAppDialogStyle MIDDLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InAppDialogStyle[] f260852a = null;
    public final String reportName;

    public static InAppDialogStyle valueOf(String r100) {
        return (InAppDialogStyle) a.a(InAppDialogStyle.class, r100);
    }

    public static InAppDialogStyle[] values() {
        return (InAppDialogStyle[]) f260852a.clone();
    }

    static {
        InAppDialogStyle r100 = new InAppDialogStyle("MIDDLE", 0, "middle");
        MIDDLE = r100;
        InAppDialogStyle r101 = new InAppDialogStyle("BOTTOM", 1, "below");
        BOTTOM = r101;
        InAppDialogStyle r102 = new InAppDialogStyle("BOTTOM_BAR", 2, "bottom_bar");
        BOTTOM_BAR = r102;
        f260852a = new InAppDialogStyle[]{r100, r101, r102};
    }

    public InAppDialogStyle(String r100, int r101, String r102) {
        super(r100, r101);
        this.reportName = r102;
    }
}
