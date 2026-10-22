package com.larus.larkfeed.impl.lark.holder.content.longpress;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/larkfeed/impl/lark/holder/content/longpress/DouBaoMenuScene;", "", "<init>", "(Ljava/lang/String;I)V", CardAdapter.TEXT, "PURE_VIDEO", "CREATION_IMAGE", "CREATION_VIDEO", "WIDGET_CARD", "MUSIC_CARD", "GENERIC_CARD", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DouBaoMenuScene extends Enum<DouBaoMenuScene> {
    public static final DouBaoMenuScene CREATION_IMAGE = null;
    public static final DouBaoMenuScene CREATION_VIDEO = null;
    public static final DouBaoMenuScene GENERIC_CARD = null;
    public static final DouBaoMenuScene MUSIC_CARD = null;
    public static final DouBaoMenuScene PURE_VIDEO = null;
    public static final DouBaoMenuScene TEXT = null;
    public static final DouBaoMenuScene WIDGET_CARD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DouBaoMenuScene[] f355362a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f355363b = null;

    public static EnumEntries<DouBaoMenuScene> getEntries() {
        return f355363b;
    }

    static {
        DouBaoMenuScene r100 = new DouBaoMenuScene(CardAdapter.TEXT, 0);
        TEXT = r100;
        DouBaoMenuScene r101 = new DouBaoMenuScene("PURE_VIDEO", 1);
        PURE_VIDEO = r101;
        DouBaoMenuScene r102 = new DouBaoMenuScene("CREATION_IMAGE", 2);
        CREATION_IMAGE = r102;
        DouBaoMenuScene r103 = new DouBaoMenuScene("CREATION_VIDEO", 3);
        CREATION_VIDEO = r103;
        DouBaoMenuScene r104 = new DouBaoMenuScene("WIDGET_CARD", 4);
        WIDGET_CARD = r104;
        DouBaoMenuScene r105 = new DouBaoMenuScene("MUSIC_CARD", 5);
        MUSIC_CARD = r105;
        DouBaoMenuScene r110 = new DouBaoMenuScene("GENERIC_CARD", 6);
        GENERIC_CARD = r110;
        DouBaoMenuScene[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f355362a = r111;
        f355363b = EnumEntriesKt.enumEntries(r111);
    }

    public static DouBaoMenuScene[] values() {
        return (DouBaoMenuScene[]) f355362a.clone();
    }

    public static DouBaoMenuScene valueOf(String r100) {
        return (DouBaoMenuScene) r27.a.a(DouBaoMenuScene.class, r100);
    }

    public DouBaoMenuScene(String r100, int r101) {
        super(r100, r101);
    }
}
