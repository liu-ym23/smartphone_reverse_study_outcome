package com.larus.dora.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/dora/api/DoraServerResourceType;", "", "<init>", "(Ljava/lang/String;I)V", "STRING", "DRAWABLE", "LAYOUT", "RAW", "COLOR", "XML", "DIMEN", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraServerResourceType extends Enum<DoraServerResourceType> {
    public static final DoraServerResourceType COLOR = null;
    public static final DoraServerResourceType DIMEN = null;
    public static final DoraServerResourceType DRAWABLE = null;
    public static final DoraServerResourceType LAYOUT = null;
    public static final DoraServerResourceType RAW = null;
    public static final DoraServerResourceType STRING = null;
    public static final DoraServerResourceType XML = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraServerResourceType[] f331718a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f331719b = null;

    public static EnumEntries<DoraServerResourceType> getEntries() {
        return f331719b;
    }

    static {
        DoraServerResourceType r100 = new DoraServerResourceType("STRING", 0);
        STRING = r100;
        DoraServerResourceType r101 = new DoraServerResourceType("DRAWABLE", 1);
        DRAWABLE = r101;
        DoraServerResourceType r102 = new DoraServerResourceType("LAYOUT", 2);
        LAYOUT = r102;
        DoraServerResourceType r103 = new DoraServerResourceType("RAW", 3);
        RAW = r103;
        DoraServerResourceType r104 = new DoraServerResourceType("COLOR", 4);
        COLOR = r104;
        DoraServerResourceType r105 = new DoraServerResourceType("XML", 5);
        XML = r105;
        DoraServerResourceType r110 = new DoraServerResourceType("DIMEN", 6);
        DIMEN = r110;
        DoraServerResourceType[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f331718a = r111;
        f331719b = EnumEntriesKt.enumEntries(r111);
    }

    public static DoraServerResourceType[] values() {
        return (DoraServerResourceType[]) f331718a.clone();
    }

    public static DoraServerResourceType valueOf(String r100) {
        return (DoraServerResourceType) a.a(DoraServerResourceType.class, r100);
    }

    public DoraServerResourceType(String r100, int r101) {
        super(r100, r101);
    }
}
