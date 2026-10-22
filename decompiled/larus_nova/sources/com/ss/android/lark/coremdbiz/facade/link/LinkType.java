package com.ss.android.lark.coremdbiz.facade.link;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/coremdbiz/facade/link/LinkType;", "", "<init>", "(Ljava/lang/String;I)V", "UrlInline", "CustomLink", "PossibleLink", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LinkType extends Enum<LinkType> {
    public static final LinkType CustomLink = null;
    public static final LinkType PossibleLink = null;
    public static final LinkType UrlInline = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LinkType[] f420079a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f420080b = null;

    public static EnumEntries<LinkType> getEntries() {
        return f420080b;
    }

    static {
        LinkType r100 = new LinkType("UrlInline", 0);
        UrlInline = r100;
        LinkType r101 = new LinkType("CustomLink", 1);
        CustomLink = r101;
        LinkType r102 = new LinkType("PossibleLink", 2);
        PossibleLink = r102;
        LinkType[] r103 = {r100, r101, r102};
        f420079a = r103;
        f420080b = EnumEntriesKt.enumEntries(r103);
    }

    public static LinkType[] values() {
        return (LinkType[]) f420079a.clone();
    }

    public static LinkType valueOf(String r100) {
        return (LinkType) a.a(LinkType.class, r100);
    }

    public LinkType(String r100, int r101) {
        super(r100, r101);
    }
}
