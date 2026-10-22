package com.obric.assistant.activation.presentation.contract;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/assistant/activation/presentation/contract/ObricListeningVisualMode;", "", "<init>", "(Ljava/lang/String;I)V", "HIDDEN", "LOADING", "CLICK_TALK", "PRESS_TALK", "contract_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricListeningVisualMode extends Enum<ObricListeningVisualMode> {
    public static final ObricListeningVisualMode CLICK_TALK = null;
    public static final ObricListeningVisualMode HIDDEN = null;
    public static final ObricListeningVisualMode LOADING = null;
    public static final ObricListeningVisualMode PRESS_TALK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ObricListeningVisualMode[] f385273a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f385274b = null;

    public static EnumEntries<ObricListeningVisualMode> getEntries() {
        return f385274b;
    }

    static {
        ObricListeningVisualMode r100 = new ObricListeningVisualMode("HIDDEN", 0);
        HIDDEN = r100;
        ObricListeningVisualMode r101 = new ObricListeningVisualMode("LOADING", 1);
        LOADING = r101;
        ObricListeningVisualMode r102 = new ObricListeningVisualMode("CLICK_TALK", 2);
        CLICK_TALK = r102;
        ObricListeningVisualMode r103 = new ObricListeningVisualMode("PRESS_TALK", 3);
        PRESS_TALK = r103;
        ObricListeningVisualMode[] r104 = {r100, r101, r102, r103};
        f385273a = r104;
        f385274b = EnumEntriesKt.enumEntries(r104);
    }

    public static ObricListeningVisualMode[] values() {
        return (ObricListeningVisualMode[]) f385273a.clone();
    }

    public static ObricListeningVisualMode valueOf(String r100) {
        return (ObricListeningVisualMode) a.a(ObricListeningVisualMode.class, r100);
    }

    public ObricListeningVisualMode(String r100, int r101) {
        super(r100, r101);
    }
}
