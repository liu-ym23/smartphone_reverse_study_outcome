package com.larus.uaigc.createpage.component.sendmessage;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/uaigc/createpage/component/sendmessage/CreationPendingResourceInputType;", "", "<init>", "(Ljava/lang/String;I)V", "LOCAL_PATH", "CONTENT_URI", "FILE_URI", "TOS_KEY", "REMOTE_URL", "INVALID", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CreationPendingResourceInputType extends Enum<CreationPendingResourceInputType> {
    public static final CreationPendingResourceInputType CONTENT_URI = null;
    public static final CreationPendingResourceInputType FILE_URI = null;
    public static final CreationPendingResourceInputType INVALID = null;
    public static final CreationPendingResourceInputType LOCAL_PATH = null;
    public static final CreationPendingResourceInputType REMOTE_URL = null;
    public static final CreationPendingResourceInputType TOS_KEY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CreationPendingResourceInputType[] f372323a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f372324b = null;

    public static EnumEntries<CreationPendingResourceInputType> getEntries() {
        return f372324b;
    }

    static {
        CreationPendingResourceInputType r100 = new CreationPendingResourceInputType("LOCAL_PATH", 0);
        LOCAL_PATH = r100;
        CreationPendingResourceInputType r101 = new CreationPendingResourceInputType("CONTENT_URI", 1);
        CONTENT_URI = r101;
        CreationPendingResourceInputType r102 = new CreationPendingResourceInputType("FILE_URI", 2);
        FILE_URI = r102;
        CreationPendingResourceInputType r103 = new CreationPendingResourceInputType("TOS_KEY", 3);
        TOS_KEY = r103;
        CreationPendingResourceInputType r104 = new CreationPendingResourceInputType("REMOTE_URL", 4);
        REMOTE_URL = r104;
        CreationPendingResourceInputType r105 = new CreationPendingResourceInputType("INVALID", 5);
        INVALID = r105;
        CreationPendingResourceInputType[] r110 = {r100, r101, r102, r103, r104, r105};
        f372323a = r110;
        f372324b = EnumEntriesKt.enumEntries(r110);
    }

    public static CreationPendingResourceInputType[] values() {
        return (CreationPendingResourceInputType[]) f372323a.clone();
    }

    public static CreationPendingResourceInputType valueOf(String r100) {
        return (CreationPendingResourceInputType) r27.a.a(CreationPendingResourceInputType.class, r100);
    }

    public CreationPendingResourceInputType(String r100, int r101) {
        super(r100, r101);
    }
}
