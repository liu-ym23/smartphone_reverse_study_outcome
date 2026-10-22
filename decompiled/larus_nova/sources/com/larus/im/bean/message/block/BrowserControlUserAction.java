package com.larus.im.bean.message.block;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/larus/im/bean/message/block/BrowserControlUserAction;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "WAIT", "JUMP", "DOING", "WAIT_TIMEOUT", "DONE", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BrowserControlUserAction extends Enum<BrowserControlUserAction> {
    public static final a Companion = null;
    public static final BrowserControlUserAction DOING = null;
    public static final BrowserControlUserAction DONE = null;
    public static final BrowserControlUserAction JUMP = null;
    public static final BrowserControlUserAction WAIT = null;
    public static final BrowserControlUserAction WAIT_TIMEOUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BrowserControlUserAction[] f346820a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f346821b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<BrowserControlUserAction> getEntries() {
        return f346821b;
    }

    static {
        BrowserControlUserAction r100 = new BrowserControlUserAction("WAIT", 0, 0);
        WAIT = r100;
        BrowserControlUserAction r101 = new BrowserControlUserAction("JUMP", 1, 1);
        JUMP = r101;
        BrowserControlUserAction r102 = new BrowserControlUserAction("DOING", 2, 2);
        DOING = r102;
        BrowserControlUserAction r103 = new BrowserControlUserAction("WAIT_TIMEOUT", 3, 3);
        WAIT_TIMEOUT = r103;
        BrowserControlUserAction r104 = new BrowserControlUserAction("DONE", 4, 4);
        DONE = r104;
        BrowserControlUserAction[] r105 = {r100, r101, r102, r103, r104};
        f346820a = r105;
        f346821b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static BrowserControlUserAction[] values() {
        return (BrowserControlUserAction[]) f346820a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static BrowserControlUserAction valueOf(String r100) {
        return (BrowserControlUserAction) r27.a.a(BrowserControlUserAction.class, r100);
    }

    public BrowserControlUserAction(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
