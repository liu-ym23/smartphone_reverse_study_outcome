package com.larus.bmhome.chat.search;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/search/SourceFrom;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "Unknown", "BaiKe", "TikTok", "DouYin", "Toutiao", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SourceFrom extends Enum<SourceFrom> {

    @SerializedName("1")
    public static final SourceFrom BaiKe = null;
    public static final a Companion = null;

    @SerializedName("3")
    public static final SourceFrom DouYin = null;

    @SerializedName("2")
    public static final SourceFrom TikTok = null;

    @SerializedName("4")
    public static final SourceFrom Toutiao = null;

    @SerializedName("0")
    public static final SourceFrom Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SourceFrom[] f308603a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f308604b = null;
    public final int value;

    public static EnumEntries<SourceFrom> getEntries() {
        return f308604b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.search.SourceFrom$a] */
    static {
        SourceFrom r100 = new SourceFrom("Unknown", 0, 0);
        Unknown = r100;
        SourceFrom r101 = new SourceFrom("BaiKe", 1, 1);
        BaiKe = r101;
        SourceFrom r102 = new SourceFrom("TikTok", 2, 2);
        TikTok = r102;
        SourceFrom r103 = new SourceFrom("DouYin", 3, 3);
        DouYin = r103;
        SourceFrom r104 = new SourceFrom("Toutiao", 4, 4);
        Toutiao = r104;
        SourceFrom[] r105 = {r100, r101, r102, r103, r104};
        f308603a = r105;
        f308604b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static SourceFrom[] values() {
        return (SourceFrom[]) f308603a.clone();
    }

    public static SourceFrom valueOf(String r100) {
        return (SourceFrom) r27.a.a(SourceFrom.class, r100);
    }

    public SourceFrom(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
