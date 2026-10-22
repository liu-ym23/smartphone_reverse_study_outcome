package com.larus.larkfeed.impl.lark.holder.content.longpress;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/larkfeed/impl/lark/holder/content/longpress/ImMenuBlockType;", "", "<init>", "(Ljava/lang/String;I)V", CardAdapter.TEXT, "CODE", "IMAGE", "RICH_MEDIA", "DEEP_THINK", "FILE", "VIDEO", "UNKNOWN", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ImMenuBlockType extends Enum<ImMenuBlockType> {
    public static final ImMenuBlockType CODE = null;
    public static final a Companion = null;
    public static final ImMenuBlockType DEEP_THINK = null;
    public static final ImMenuBlockType FILE = null;
    public static final ImMenuBlockType IMAGE = null;
    public static final ImMenuBlockType RICH_MEDIA = null;
    public static final ImMenuBlockType TEXT = null;
    public static final ImMenuBlockType UNKNOWN = null;
    public static final ImMenuBlockType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ImMenuBlockType[] f355372a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f355373b = null;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<ImMenuBlockType> getEntries() {
        return f355373b;
    }

    static {
        ImMenuBlockType r100 = new ImMenuBlockType(CardAdapter.TEXT, 0);
        TEXT = r100;
        ImMenuBlockType r101 = new ImMenuBlockType("CODE", 1);
        CODE = r101;
        ImMenuBlockType r102 = new ImMenuBlockType("IMAGE", 2);
        IMAGE = r102;
        ImMenuBlockType r103 = new ImMenuBlockType("RICH_MEDIA", 3);
        RICH_MEDIA = r103;
        ImMenuBlockType r104 = new ImMenuBlockType("DEEP_THINK", 4);
        DEEP_THINK = r104;
        ImMenuBlockType r105 = new ImMenuBlockType("FILE", 5);
        FILE = r105;
        ImMenuBlockType r110 = new ImMenuBlockType("VIDEO", 6);
        VIDEO = r110;
        ImMenuBlockType r111 = new ImMenuBlockType("UNKNOWN", 7);
        UNKNOWN = r111;
        ImMenuBlockType[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f355372a = r112;
        f355373b = EnumEntriesKt.enumEntries(r112);
        Companion = new a();
    }

    public static ImMenuBlockType[] values() {
        return (ImMenuBlockType[]) f355372a.clone();
    }

    public static ImMenuBlockType valueOf(String r100) {
        return (ImMenuBlockType) r27.a.a(ImMenuBlockType.class, r100);
    }

    public ImMenuBlockType(String r100, int r101) {
        super(r100, r101);
    }
}
