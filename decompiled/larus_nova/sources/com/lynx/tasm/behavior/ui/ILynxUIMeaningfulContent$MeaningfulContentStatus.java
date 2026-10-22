package com.lynx.tasm.behavior.ui;

/* JADX INFO: loaded from: classes32.dex */
public final enum ILynxUIMeaningfulContent$MeaningfulContentStatus extends Enum<ILynxUIMeaningfulContent$MeaningfulContentStatus> {
    public static final ILynxUIMeaningfulContent$MeaningfulContentStatus IRRELEVANT = null;
    public static final ILynxUIMeaningfulContent$MeaningfulContentStatus PENDING = null;
    public static final ILynxUIMeaningfulContent$MeaningfulContentStatus PRESENTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ILynxUIMeaningfulContent$MeaningfulContentStatus[] f382342a = null;

    static {
        ILynxUIMeaningfulContent$MeaningfulContentStatus r100 = new ILynxUIMeaningfulContent$MeaningfulContentStatus("IRRELEVANT", 0);
        IRRELEVANT = r100;
        ILynxUIMeaningfulContent$MeaningfulContentStatus r101 = new ILynxUIMeaningfulContent$MeaningfulContentStatus("PENDING", 1);
        PENDING = r101;
        ILynxUIMeaningfulContent$MeaningfulContentStatus r102 = new ILynxUIMeaningfulContent$MeaningfulContentStatus("PRESENTED", 2);
        PRESENTED = r102;
        f382342a = new ILynxUIMeaningfulContent$MeaningfulContentStatus[]{r100, r101, r102};
    }

    public static ILynxUIMeaningfulContent$MeaningfulContentStatus[] values() {
        return (ILynxUIMeaningfulContent$MeaningfulContentStatus[]) f382342a.clone();
    }

    public static ILynxUIMeaningfulContent$MeaningfulContentStatus valueOf(String r100) {
        return (ILynxUIMeaningfulContent$MeaningfulContentStatus) r27.a.a(ILynxUIMeaningfulContent$MeaningfulContentStatus.class, r100);
    }

    public ILynxUIMeaningfulContent$MeaningfulContentStatus(String r100, int r101) {
        super(r100, r101);
    }
}
