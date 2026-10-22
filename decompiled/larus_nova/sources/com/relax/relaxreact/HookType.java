package com.relax.relaxreact;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/relax/relaxreact/HookType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "State", "Effect", "LayoutEffect", "Ref", "Memo", "Provider", "Context", "relax-kmp-runtime_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum HookType extends Enum<HookType> {
    public static final HookType Context = null;
    public static final HookType Effect = null;
    public static final HookType LayoutEffect = null;
    public static final HookType Memo = null;
    public static final HookType Provider = null;
    public static final HookType Ref = null;
    public static final HookType State = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HookType[] f405411a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f405412b = null;
    private final int value;

    public static EnumEntries<HookType> getEntries() {
        return f405412b;
    }

    public static HookType valueOf(String r100) {
        return (HookType) r27.a.a(HookType.class, r100);
    }

    public static HookType[] values() {
        return (HookType[]) f405411a.clone();
    }

    static {
        HookType r100 = new HookType("State", 0, 0);
        State = r100;
        HookType r101 = new HookType("Effect", 1, 1);
        Effect = r101;
        HookType r102 = new HookType("LayoutEffect", 2, 2);
        LayoutEffect = r102;
        HookType r103 = new HookType("Ref", 3, 3);
        Ref = r103;
        HookType r104 = new HookType("Memo", 4, 4);
        Memo = r104;
        HookType r105 = new HookType("Provider", 5, 5);
        Provider = r105;
        HookType r110 = new HookType("Context", 6, 6);
        Context = r110;
        HookType[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f405411a = r111;
        f405412b = EnumEntriesKt.enumEntries(r111);
    }

    public final int getValue() {
        return this.value;
    }

    public HookType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
