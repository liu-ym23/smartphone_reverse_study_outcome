package com.larus.trace;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/trace/SendingTextEditTriggeredScene;", "", "<init>", "(Ljava/lang/String;I)V", "ASR", "EDIT_TEXT", "ACTION_MENU_ENTRANCE", "trace_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SendingTextEditTriggeredScene extends Enum<SendingTextEditTriggeredScene> {
    public static final SendingTextEditTriggeredScene ACTION_MENU_ENTRANCE = null;
    public static final SendingTextEditTriggeredScene ASR = null;
    public static final SendingTextEditTriggeredScene EDIT_TEXT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SendingTextEditTriggeredScene[] f370155a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f370156b = null;

    public static EnumEntries<SendingTextEditTriggeredScene> getEntries() {
        return f370156b;
    }

    static {
        SendingTextEditTriggeredScene r100 = new SendingTextEditTriggeredScene("ASR", 0);
        ASR = r100;
        SendingTextEditTriggeredScene r101 = new SendingTextEditTriggeredScene("EDIT_TEXT", 1);
        EDIT_TEXT = r101;
        SendingTextEditTriggeredScene r102 = new SendingTextEditTriggeredScene("ACTION_MENU_ENTRANCE", 2);
        ACTION_MENU_ENTRANCE = r102;
        SendingTextEditTriggeredScene[] r103 = {r100, r101, r102};
        f370155a = r103;
        f370156b = EnumEntriesKt.enumEntries(r103);
    }

    public static SendingTextEditTriggeredScene[] values() {
        return (SendingTextEditTriggeredScene[]) f370155a.clone();
    }

    public static SendingTextEditTriggeredScene valueOf(String r100) {
        return (SendingTextEditTriggeredScene) a.a(SendingTextEditTriggeredScene.class, r100);
    }

    public SendingTextEditTriggeredScene(String r100, int r101) {
        super(r100, r101);
    }
}
