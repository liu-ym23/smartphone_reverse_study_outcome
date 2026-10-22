package com.ss.android.lark.ug.dialog;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/ug/dialog/LinkType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "APPLINK", "URL", "ug-dialog_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LinkType extends Enum<LinkType> {
    public static final LinkType APPLINK = null;
    public static final LinkType URL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LinkType[] f444435a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f444436b = null;

    public static EnumEntries<LinkType> getEntries() {
        return f444436b;
    }

    static {
        LinkType r100 = new LinkType("APPLINK", 0);
        APPLINK = r100;
        LinkType r101 = new LinkType("URL", 1);
        URL = r101;
        LinkType[] r102 = {r100, r101};
        f444435a = r102;
        f444436b = EnumEntriesKt.enumEntries(r102);
    }

    public static LinkType[] values() {
        return (LinkType[]) f444435a.clone();
    }

    public static LinkType valueOf(String r100) {
        return (LinkType) r27.a.a(LinkType.class, r100);
    }

    public LinkType(String r100, int r101) {
        super(r100, r101);
    }
}
