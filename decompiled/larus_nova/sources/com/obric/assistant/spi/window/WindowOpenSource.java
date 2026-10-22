package com.obric.assistant.spi.window;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/spi/window/WindowOpenSource;", "", "<init>", "(Ljava/lang/String;I)V", "OPEN", "POP", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WindowOpenSource extends Enum<WindowOpenSource> {
    public static final WindowOpenSource OPEN = null;
    public static final WindowOpenSource POP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WindowOpenSource[] f392928a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f392929b = null;

    public static EnumEntries<WindowOpenSource> getEntries() {
        return f392929b;
    }

    static {
        WindowOpenSource r100 = new WindowOpenSource("OPEN", 0);
        OPEN = r100;
        WindowOpenSource r101 = new WindowOpenSource("POP", 1);
        POP = r101;
        WindowOpenSource[] r102 = {r100, r101};
        f392928a = r102;
        f392929b = EnumEntriesKt.enumEntries(r102);
    }

    public static WindowOpenSource[] values() {
        return (WindowOpenSource[]) f392928a.clone();
    }

    public static WindowOpenSource valueOf(String r100) {
        return (WindowOpenSource) a.a(WindowOpenSource.class, r100);
    }

    public WindowOpenSource(String r100, int r101) {
        super(r100, r101);
    }
}
