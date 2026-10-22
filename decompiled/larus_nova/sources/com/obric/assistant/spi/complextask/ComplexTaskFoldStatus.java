package com.obric.assistant.spi.complextask;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/assistant/spi/complextask/ComplexTaskFoldStatus;", "", "<init>", "(Ljava/lang/String;I)V", "CompleteFold", "HalfFold", "CompleteExpand", "None", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ComplexTaskFoldStatus extends Enum<ComplexTaskFoldStatus> {
    public static final ComplexTaskFoldStatus CompleteExpand = null;
    public static final ComplexTaskFoldStatus CompleteFold = null;
    public static final ComplexTaskFoldStatus HalfFold = null;
    public static final ComplexTaskFoldStatus None = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ComplexTaskFoldStatus[] f392866a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f392867b = null;

    public static EnumEntries<ComplexTaskFoldStatus> getEntries() {
        return f392867b;
    }

    static {
        ComplexTaskFoldStatus r100 = new ComplexTaskFoldStatus("CompleteFold", 0);
        CompleteFold = r100;
        ComplexTaskFoldStatus r101 = new ComplexTaskFoldStatus("HalfFold", 1);
        HalfFold = r101;
        ComplexTaskFoldStatus r102 = new ComplexTaskFoldStatus("CompleteExpand", 2);
        CompleteExpand = r102;
        ComplexTaskFoldStatus r103 = new ComplexTaskFoldStatus("None", 3);
        None = r103;
        ComplexTaskFoldStatus[] r104 = {r100, r101, r102, r103};
        f392866a = r104;
        f392867b = EnumEntriesKt.enumEntries(r104);
    }

    public static ComplexTaskFoldStatus[] values() {
        return (ComplexTaskFoldStatus[]) f392866a.clone();
    }

    public static ComplexTaskFoldStatus valueOf(String r100) {
        return (ComplexTaskFoldStatus) a.a(ComplexTaskFoldStatus.class, r100);
    }

    public ComplexTaskFoldStatus(String r100, int r101) {
        super(r100, r101);
    }
}
