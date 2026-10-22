package com.obric.memorydata.sdk.assistant;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/sdk/assistant/WindowState;", "", "<init>", "(Ljava/lang/String;I)V", "NA", "CHAT_WINDOW", "HALF_WINDOW", "FULL_SCREEN", "INVISIBLE", "Companion", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum WindowState extends Enum<WindowState> {
    public static final WindowState CHAT_WINDOW = null;
    public static final a Companion = null;
    public static final WindowState FULL_SCREEN = null;
    public static final WindowState HALF_WINDOW = null;
    public static final WindowState INVISIBLE = null;
    public static final WindowState NA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WindowState[] f397081a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f397082b = null;

    public static EnumEntries<WindowState> getEntries() {
        return f397082b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.memorydata.sdk.assistant.WindowState$a] */
    static {
        WindowState r100 = new WindowState("NA", 0);
        NA = r100;
        WindowState r101 = new WindowState("CHAT_WINDOW", 1);
        CHAT_WINDOW = r101;
        WindowState r102 = new WindowState("HALF_WINDOW", 2);
        HALF_WINDOW = r102;
        WindowState r103 = new WindowState("FULL_SCREEN", 3);
        FULL_SCREEN = r103;
        WindowState r104 = new WindowState("INVISIBLE", 4);
        INVISIBLE = r104;
        WindowState[] r105 = {r100, r101, r102, r103, r104};
        f397081a = r105;
        f397082b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static WindowState[] values() {
        return (WindowState[]) f397081a.clone();
    }

    public static WindowState valueOf(String r100) {
        return (WindowState) r27.a.a(WindowState.class, r100);
    }

    public WindowState(String r100, int r101) {
        super(r100, r101);
    }
}
