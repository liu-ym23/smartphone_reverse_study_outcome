package com.relax.relaxreact;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/relax/relaxreact/ContextType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "kJSContext", "kCoreContext", "kUIContext", "kDevTool", "kNative", "kEngine", "kUnknown", "relax-kmp-runtime_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum ContextType extends Enum<ContextType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContextType[] f405398a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f405399b = null;
    public static final ContextType kCoreContext = null;
    public static final ContextType kDevTool = null;
    public static final ContextType kEngine = null;
    public static final ContextType kJSContext = null;
    public static final ContextType kNative = null;
    public static final ContextType kUIContext = null;
    public static final ContextType kUnknown = null;
    private final int value;

    public static EnumEntries<ContextType> getEntries() {
        return f405399b;
    }

    public static ContextType valueOf(String r100) {
        return (ContextType) r27.a.a(ContextType.class, r100);
    }

    public static ContextType[] values() {
        return (ContextType[]) f405398a.clone();
    }

    static {
        ContextType r100 = new ContextType("kJSContext", 0, 0);
        kJSContext = r100;
        ContextType r101 = new ContextType("kCoreContext", 1, 1);
        kCoreContext = r101;
        ContextType r102 = new ContextType("kUIContext", 2, 2);
        kUIContext = r102;
        ContextType r103 = new ContextType("kDevTool", 3, 3);
        kDevTool = r103;
        ContextType r104 = new ContextType("kNative", 4, 4);
        kNative = r104;
        ContextType r105 = new ContextType("kEngine", 5, 5);
        kEngine = r105;
        ContextType r110 = new ContextType("kUnknown", 6, 6);
        kUnknown = r110;
        ContextType[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f405398a = r111;
        f405399b = EnumEntriesKt.enumEntries(r111);
    }

    public final int getValue() {
        return this.value;
    }

    public ContextType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
