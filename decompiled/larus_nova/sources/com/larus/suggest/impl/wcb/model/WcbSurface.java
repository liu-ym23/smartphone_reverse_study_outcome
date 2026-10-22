package com.larus.suggest.impl.wcb.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/suggest/impl/wcb/model/WcbSurface;", "", "<init>", "(Ljava/lang/String;I)V", "MAIN_CONVERSATION", "NEW_CONVERSATION", "NOT_SUPPORT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WcbSurface extends Enum<WcbSurface> {
    public static final WcbSurface MAIN_CONVERSATION = null;
    public static final WcbSurface NEW_CONVERSATION = null;
    public static final WcbSurface NOT_SUPPORT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WcbSurface[] f369950a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f369951b = null;

    public static EnumEntries<WcbSurface> getEntries() {
        return f369951b;
    }

    static {
        WcbSurface r100 = new WcbSurface("MAIN_CONVERSATION", 0);
        MAIN_CONVERSATION = r100;
        WcbSurface r101 = new WcbSurface("NEW_CONVERSATION", 1);
        NEW_CONVERSATION = r101;
        WcbSurface r102 = new WcbSurface("NOT_SUPPORT", 2);
        NOT_SUPPORT = r102;
        WcbSurface[] r103 = {r100, r101, r102};
        f369950a = r103;
        f369951b = EnumEntriesKt.enumEntries(r103);
    }

    public static WcbSurface[] values() {
        return (WcbSurface[]) f369950a.clone();
    }

    public static WcbSurface valueOf(String r100) {
        return (WcbSurface) a.a(WcbSurface.class, r100);
    }

    public WcbSurface(String r100, int r101) {
        super(r100, r101);
    }
}
