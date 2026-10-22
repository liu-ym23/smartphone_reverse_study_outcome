package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/WikNodeType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "TITLE_ROOT", "TITLE", "SPACE", "DOCUMENT", "ROOT", "DIR", "LEAF", UserProfileEvent.POSITION_NONE, "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WikNodeType extends Enum<WikNodeType> {
    public static final WikNodeType DIR = null;
    public static final WikNodeType DOCUMENT = null;
    public static final WikNodeType LEAF = null;
    public static final WikNodeType NONE = null;
    public static final WikNodeType ROOT = null;
    public static final WikNodeType SPACE = null;
    public static final WikNodeType TITLE = null;
    public static final WikNodeType TITLE_ROOT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WikNodeType[] f241729a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f241730b = null;
    private final int value;

    public static EnumEntries<WikNodeType> getEntries() {
        return f241730b;
    }

    static {
        WikNodeType r100 = new WikNodeType("TITLE_ROOT", 0, -4);
        TITLE_ROOT = r100;
        WikNodeType r101 = new WikNodeType("TITLE", 1, -3);
        TITLE = r101;
        WikNodeType r102 = new WikNodeType("SPACE", 2, -2);
        SPACE = r102;
        WikNodeType r103 = new WikNodeType("DOCUMENT", 3, -1);
        DOCUMENT = r103;
        WikNodeType r104 = new WikNodeType("ROOT", 4, 0);
        ROOT = r104;
        WikNodeType r105 = new WikNodeType("DIR", 5, 2);
        DIR = r105;
        WikNodeType r110 = new WikNodeType("LEAF", 6, 3);
        LEAF = r110;
        WikNodeType r111 = new WikNodeType(UserProfileEvent.POSITION_NONE, 7, 4);
        NONE = r111;
        WikNodeType[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f241729a = r112;
        f241730b = EnumEntriesKt.enumEntries(r112);
    }

    public static WikNodeType[] values() {
        return (WikNodeType[]) f241729a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static WikNodeType valueOf(String r100) {
        return (WikNodeType) r27.a.a(WikNodeType.class, r100);
    }

    public WikNodeType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
