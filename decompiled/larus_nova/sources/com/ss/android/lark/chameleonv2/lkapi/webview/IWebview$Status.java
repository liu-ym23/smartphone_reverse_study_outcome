package com.ss.android.lark.chameleonv2.lkapi.webview;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001a\u00020\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/webview/IWebview$Status;", "Lcom/bytedance/ee/util/io/NonProguard;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Attached", "Visible", "Hidden", "Detached", "toString", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IWebview$Status extends Enum<IWebview$Status> implements NonProguard {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ IWebview$Status[] $VALUES = null;
    public static final IWebview$Status Attached = null;
    public static final IWebview$Status Detached = null;
    public static final IWebview$Status Hidden = null;
    public static final IWebview$Status Visible = null;
    private final String value;

    private static final /* synthetic */ IWebview$Status[] $values() {
        return new IWebview$Status[]{Attached, Visible, Hidden, Detached};
    }

    public static EnumEntries<IWebview$Status> getEntries() {
        return $ENTRIES;
    }

    static {
        Attached = new IWebview$Status("Attached", 0, "attached");
        Visible = new IWebview$Status("Visible", 1, "visible");
        Hidden = new IWebview$Status("Hidden", 2, "hidden");
        Detached = new IWebview$Status("Detached", 3, "detached");
        IWebview$Status[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static IWebview$Status[] values() {
        return (IWebview$Status[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static IWebview$Status valueOf(String r100) {
        return (IWebview$Status) a.a(IWebview$Status.class, r100);
    }

    private IWebview$Status(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
