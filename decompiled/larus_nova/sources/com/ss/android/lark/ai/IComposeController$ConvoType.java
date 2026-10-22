package com.ss.android.lark.ai;

import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum IComposeController$ConvoType extends Enum<IComposeController$ConvoType> {
    public static final IComposeController$ConvoType CHAT = null;
    public static final IComposeController$ConvoType THREAD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IComposeController$ConvoType[] f408634a = null;
    private String value;

    static {
        IComposeController$ConvoType r100 = new IComposeController$ConvoType("THREAD", 0, "thread");
        THREAD = r100;
        IComposeController$ConvoType r101 = new IComposeController$ConvoType("CHAT", 1, "chat");
        CHAT = r101;
        f408634a = new IComposeController$ConvoType[]{r100, r101};
    }

    public static IComposeController$ConvoType[] values() {
        return (IComposeController$ConvoType[]) f408634a.clone();
    }

    public String getValue() {
        return this.value;
    }

    public static IComposeController$ConvoType valueOf(String r100) {
        return (IComposeController$ConvoType) a.a(IComposeController$ConvoType.class, r100);
    }

    public IComposeController$ConvoType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
