package com.larus.dora.obric.onboarding;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/obric/onboarding/ActionEvent;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "TOAST", "DIALOG", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActionEvent extends Enum<ActionEvent> {
    public static final ActionEvent DIALOG = null;
    public static final ActionEvent TOAST = null;
    public static final ActionEvent UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ActionEvent[] f340702a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f340703b = null;

    public static EnumEntries<ActionEvent> getEntries() {
        return f340703b;
    }

    static {
        ActionEvent r100 = new ActionEvent("UNKNOWN", 0);
        UNKNOWN = r100;
        ActionEvent r101 = new ActionEvent("TOAST", 1);
        TOAST = r101;
        ActionEvent r102 = new ActionEvent("DIALOG", 2);
        DIALOG = r102;
        ActionEvent[] r103 = {r100, r101, r102};
        f340702a = r103;
        f340703b = EnumEntriesKt.enumEntries(r103);
    }

    public static ActionEvent[] values() {
        return (ActionEvent[]) f340702a.clone();
    }

    public static ActionEvent valueOf(String r100) {
        return (ActionEvent) r27.a.a(ActionEvent.class, r100);
    }

    public ActionEvent(String r100, int r101) {
        super(r100, r101);
    }
}
