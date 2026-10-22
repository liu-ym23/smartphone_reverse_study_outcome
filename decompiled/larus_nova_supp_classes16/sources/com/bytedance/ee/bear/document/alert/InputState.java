package com.bytedance.ee.bear.document.alert;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/document/alert/InputState;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "ACTIVE", "ERROR", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InputState extends Enum<InputState> {
    public static final InputState ACTIVE = null;
    public static final InputState ERROR = null;
    public static final InputState NORMAL = null;
    public static final /* synthetic */ InputState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<InputState> getEntries() {
        return b;
    }

    static {
        InputState r0 = new InputState("NORMAL", 0);
        NORMAL = r0;
        InputState r1 = new InputState("ACTIVE", 1);
        ACTIVE = r1;
        InputState r3 = new InputState("ERROR", 2);
        ERROR = r3;
        InputState[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static InputState[] values() {
        return (InputState[]) a.clone();
    }

    public static InputState valueOf(String r1) {
        return (InputState) r27.a.a(InputState.class, r1);
    }

    public InputState(String r1, int r2) {
        super(r1, r2);
    }
}
