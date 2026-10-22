package com.larus.e_commerce.impl.applet;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/e_commerce/impl/applet/PageState;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "GOING", "CREATED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PageState extends Enum<PageState> {
    public static final PageState CREATED = null;
    public static final PageState GOING = null;
    public static final PageState UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PageState[] f342366a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f342367b = null;

    public static EnumEntries<PageState> getEntries() {
        return f342367b;
    }

    static {
        PageState r100 = new PageState("UNKNOWN", 0);
        UNKNOWN = r100;
        PageState r101 = new PageState("GOING", 1);
        GOING = r101;
        PageState r102 = new PageState("CREATED", 2);
        CREATED = r102;
        PageState[] r103 = {r100, r101, r102};
        f342366a = r103;
        f342367b = EnumEntriesKt.enumEntries(r103);
    }

    public static PageState[] values() {
        return (PageState[]) f342366a.clone();
    }

    public static PageState valueOf(String r100) {
        return (PageState) a.a(PageState.class, r100);
    }

    public PageState(String r100, int r101) {
        super(r100, r101);
    }
}
