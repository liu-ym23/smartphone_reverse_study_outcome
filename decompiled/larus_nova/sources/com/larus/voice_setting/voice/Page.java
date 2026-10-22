package com.larus.voice_setting.voice;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/voice_setting/voice/Page;", "", "<init>", "(Ljava/lang/String;I)V", "MULTI_TAB", "UGC_RECOMMEND_TAB", "VOICE_RECOMMEND_TAB", "NON", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Page extends Enum<Page> {
    public static final Page MULTI_TAB = null;
    public static final Page NON = null;
    public static final Page UGC_RECOMMEND_TAB = null;
    public static final Page VOICE_RECOMMEND_TAB = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Page[] f376247a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f376248b = null;

    public static EnumEntries<Page> getEntries() {
        return f376248b;
    }

    static {
        Page r100 = new Page("MULTI_TAB", 0);
        MULTI_TAB = r100;
        Page r101 = new Page("UGC_RECOMMEND_TAB", 1);
        UGC_RECOMMEND_TAB = r101;
        Page r102 = new Page("VOICE_RECOMMEND_TAB", 2);
        VOICE_RECOMMEND_TAB = r102;
        Page r103 = new Page("NON", 3);
        NON = r103;
        Page[] r104 = {r100, r101, r102, r103};
        f376247a = r104;
        f376248b = EnumEntriesKt.enumEntries(r104);
    }

    public static Page[] values() {
        return (Page[]) f376247a.clone();
    }

    public static Page valueOf(String r100) {
        return (Page) r27.a.a(Page.class, r100);
    }

    public Page(String r100, int r101) {
        super(r100, r101);
    }
}
