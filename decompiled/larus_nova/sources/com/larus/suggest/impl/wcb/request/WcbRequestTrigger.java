package com.larus.suggest.impl.wcb.request;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/suggest/impl/wcb/request/WcbRequestTrigger;", "", "<init>", "(Ljava/lang/String;I)V", "INITIAL", "FOREGROUND", "MODE_SWITCH", "REGENERATE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WcbRequestTrigger extends Enum<WcbRequestTrigger> {
    public static final WcbRequestTrigger FOREGROUND = null;
    public static final WcbRequestTrigger INITIAL = null;
    public static final WcbRequestTrigger MODE_SWITCH = null;
    public static final WcbRequestTrigger REGENERATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WcbRequestTrigger[] f370079a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f370080b = null;

    public static EnumEntries<WcbRequestTrigger> getEntries() {
        return f370080b;
    }

    static {
        WcbRequestTrigger r100 = new WcbRequestTrigger("INITIAL", 0);
        INITIAL = r100;
        WcbRequestTrigger r101 = new WcbRequestTrigger("FOREGROUND", 1);
        FOREGROUND = r101;
        WcbRequestTrigger r102 = new WcbRequestTrigger("MODE_SWITCH", 2);
        MODE_SWITCH = r102;
        WcbRequestTrigger r103 = new WcbRequestTrigger("REGENERATE", 3);
        REGENERATE = r103;
        WcbRequestTrigger[] r104 = {r100, r101, r102, r103};
        f370079a = r104;
        f370080b = EnumEntriesKt.enumEntries(r104);
    }

    public static WcbRequestTrigger[] values() {
        return (WcbRequestTrigger[]) f370079a.clone();
    }

    public static WcbRequestTrigger valueOf(String r100) {
        return (WcbRequestTrigger) r27.a.a(WcbRequestTrigger.class, r100);
    }

    public WcbRequestTrigger(String r100, int r101) {
        super(r100, r101);
    }
}
