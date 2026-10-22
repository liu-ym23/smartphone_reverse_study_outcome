package com.larus.im.internal.protocol.bean;

import af9.j1;
import java.lang.annotation.Annotation;
import juc.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import nuc.i0;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0081\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/im/internal/protocol/bean/PageType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "PageType_UNKNOWN", "PageType_CHAT", "PageType_IMG_TMPL", "PageType_VIDEO", "PageType_MUSIC_TMPL", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum PageType extends Enum<PageType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ PageType[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final a Companion = null;

    @SerialName("1")
    public static final PageType PageType_CHAT = null;

    @SerialName("2")
    public static final PageType PageType_IMG_TMPL = null;

    @SerialName("4")
    public static final PageType PageType_MUSIC_TMPL = null;

    @SerialName("0")
    public static final PageType PageType_UNKNOWN = null;

    @SerialName("3")
    public static final PageType PageType_VIDEO = null;
    public final int value;

    private static final /* synthetic */ PageType[] $values() {
        return new PageType[]{PageType_UNKNOWN, PageType_CHAT, PageType_IMG_TMPL, PageType_VIDEO, PageType_MUSIC_TMPL};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    public static EnumEntries<PageType> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.larus.im.internal.protocol.bean.PageType$a] */
    static {
        PageType_UNKNOWN = new PageType("PageType_UNKNOWN", 0, 0);
        PageType_CHAT = new PageType("PageType_CHAT", 1, 1);
        PageType_IMG_TMPL = new PageType("PageType_IMG_TMPL", 2, 2);
        PageType_VIDEO = new PageType("PageType_VIDEO", 3, 3);
        PageType_MUSIC_TMPL = new PageType("PageType_MUSIC_TMPL", 4, 4);
        PageType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new j1());
    }

    public static PageType[] values() {
        return (PageType[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.protocol.bean.PageType", values(), new String[]{"0", "1", "2", "3", "4"}, new Annotation[][]{null, null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static PageType valueOf(String r100) {
        return (PageType) r27.a.a(PageType.class, r100);
    }

    private PageType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
