package com.bytedance.ee.bear.more.copylink;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/more/copylink/CopyLinkFailReason;", "", "<init>", "(Ljava/lang/String;I)V", "EMPTY_URL", "INVALID_URL", "CLIPBOARD_FAILED", "features-more-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CopyLinkFailReason extends Enum<CopyLinkFailReason> {
    public static final CopyLinkFailReason CLIPBOARD_FAILED = null;
    public static final CopyLinkFailReason EMPTY_URL = null;
    public static final CopyLinkFailReason INVALID_URL = null;
    public static final /* synthetic */ CopyLinkFailReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CopyLinkFailReason> getEntries() {
        return b;
    }

    static {
        CopyLinkFailReason r0 = new CopyLinkFailReason("EMPTY_URL", 0);
        EMPTY_URL = r0;
        CopyLinkFailReason r1 = new CopyLinkFailReason("INVALID_URL", 1);
        INVALID_URL = r1;
        CopyLinkFailReason r3 = new CopyLinkFailReason("CLIPBOARD_FAILED", 2);
        CLIPBOARD_FAILED = r3;
        CopyLinkFailReason[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static CopyLinkFailReason[] values() {
        return (CopyLinkFailReason[]) a.clone();
    }

    public static CopyLinkFailReason valueOf(String r1) {
        return (CopyLinkFailReason) a.a(CopyLinkFailReason.class, r1);
    }

    public CopyLinkFailReason(String r1, int r2) {
        super(r1, r2);
    }
}
