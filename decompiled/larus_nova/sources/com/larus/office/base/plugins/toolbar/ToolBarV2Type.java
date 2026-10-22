package com.larus.office.base.plugins.toolbar;

import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/office/base/plugins/toolbar/ToolBarV2Type;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", "Down", ServiceType.DOC, "Sheet", "EQUATION", "OKR", "Slides", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ToolBarV2Type extends Enum<ToolBarV2Type> {
    public static final ToolBarV2Type Doc = null;
    public static final ToolBarV2Type Down = null;
    public static final ToolBarV2Type EQUATION = null;
    public static final ToolBarV2Type OKR = null;
    public static final ToolBarV2Type Sheet = null;
    public static final ToolBarV2Type Slides = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ToolBarV2Type[] f360814a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f360815b = null;
    private int value;

    public static EnumEntries<ToolBarV2Type> getEntries() {
        return f360815b;
    }

    static {
        ToolBarV2Type r100 = new ToolBarV2Type("Down", 0, 0);
        Down = r100;
        ToolBarV2Type r101 = new ToolBarV2Type(ServiceType.DOC, 1, 2);
        Doc = r101;
        ToolBarV2Type r102 = new ToolBarV2Type("Sheet", 2, 3);
        Sheet = r102;
        ToolBarV2Type r103 = new ToolBarV2Type("EQUATION", 3, 4);
        EQUATION = r103;
        ToolBarV2Type r104 = new ToolBarV2Type("OKR", 4, 6);
        OKR = r104;
        ToolBarV2Type r110 = new ToolBarV2Type("Slides", 5, 30);
        Slides = r110;
        ToolBarV2Type[] r111 = {r100, r101, r102, r103, r104, r110};
        f360814a = r111;
        f360815b = EnumEntriesKt.enumEntries(r111);
    }

    public static ToolBarV2Type[] values() {
        return (ToolBarV2Type[]) f360814a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ToolBarV2Type valueOf(String r100) {
        return (ToolBarV2Type) r27.a.a(ToolBarV2Type.class, r100);
    }

    public final void setValue(int r100) {
        this.value = r100;
    }

    public ToolBarV2Type(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
