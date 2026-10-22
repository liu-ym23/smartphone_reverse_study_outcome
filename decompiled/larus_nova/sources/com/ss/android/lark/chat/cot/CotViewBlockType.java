package com.ss.android.lark.chat.cot;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.ss.android.lark.banner.export.entity.BannerBizName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/cot/CotViewBlockType;", "", "<init>", "(Ljava/lang/String;I)V", "RUN", "STEP", CardAdapter.TEXT, "TOOL_CALL", BannerBizName.ACTIVITY, "REASONING", "RAW", "CUSTOM", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CotViewBlockType extends Enum<CotViewBlockType> {
    public static final CotViewBlockType ACTIVITY = null;
    public static final CotViewBlockType CUSTOM = null;
    public static final CotViewBlockType RAW = null;
    public static final CotViewBlockType REASONING = null;
    public static final CotViewBlockType RUN = null;
    public static final CotViewBlockType STEP = null;
    public static final CotViewBlockType TEXT = null;
    public static final CotViewBlockType TOOL_CALL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CotViewBlockType[] f414785a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f414786b = null;

    public static EnumEntries<CotViewBlockType> getEntries() {
        return f414786b;
    }

    static {
        CotViewBlockType r100 = new CotViewBlockType("RUN", 0);
        RUN = r100;
        CotViewBlockType r101 = new CotViewBlockType("STEP", 1);
        STEP = r101;
        CotViewBlockType r102 = new CotViewBlockType(CardAdapter.TEXT, 2);
        TEXT = r102;
        CotViewBlockType r103 = new CotViewBlockType("TOOL_CALL", 3);
        TOOL_CALL = r103;
        CotViewBlockType r104 = new CotViewBlockType(BannerBizName.ACTIVITY, 4);
        ACTIVITY = r104;
        CotViewBlockType r105 = new CotViewBlockType("REASONING", 5);
        REASONING = r105;
        CotViewBlockType r110 = new CotViewBlockType("RAW", 6);
        RAW = r110;
        CotViewBlockType r111 = new CotViewBlockType("CUSTOM", 7);
        CUSTOM = r111;
        CotViewBlockType[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f414785a = r112;
        f414786b = EnumEntriesKt.enumEntries(r112);
    }

    public static CotViewBlockType[] values() {
        return (CotViewBlockType[]) f414785a.clone();
    }

    public static CotViewBlockType valueOf(String r100) {
        return (CotViewBlockType) r27.a.a(CotViewBlockType.class, r100);
    }

    public CotViewBlockType(String r100, int r101) {
        super(r100, r101);
    }
}
