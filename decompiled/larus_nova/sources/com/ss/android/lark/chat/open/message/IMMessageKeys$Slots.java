package com.ss.android.lark.chat.open.message;

import com.ss.android.lark.blueprint.v;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/chat/open/message/IMMessageKeys$Slots;", "Lcom/ss/android/lark/blueprint/ISlotId;", "", "<init>", "(Ljava/lang/String;I)V", "CONTENT", "AVATAR", "TOP", "HEADER", "FOOTER", "CORNER_1", "CORNER_2", "BOTTOM", "ROOF", "DING_ICON", "SELECT", "INNER_EXPOSURE", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IMMessageKeys$Slots extends Enum<IMMessageKeys$Slots> implements v {
    public static final IMMessageKeys$Slots AVATAR = null;
    public static final IMMessageKeys$Slots BOTTOM = null;
    public static final IMMessageKeys$Slots CONTENT = null;
    public static final IMMessageKeys$Slots CORNER_1 = null;
    public static final IMMessageKeys$Slots CORNER_2 = null;
    public static final IMMessageKeys$Slots DING_ICON = null;
    public static final IMMessageKeys$Slots FOOTER = null;
    public static final IMMessageKeys$Slots HEADER = null;
    public static final IMMessageKeys$Slots INNER_EXPOSURE = null;
    public static final IMMessageKeys$Slots ROOF = null;
    public static final IMMessageKeys$Slots SELECT = null;
    public static final IMMessageKeys$Slots TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IMMessageKeys$Slots[] f415967a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f415968b = null;

    public static EnumEntries<IMMessageKeys$Slots> getEntries() {
        return f415968b;
    }

    static {
        IMMessageKeys$Slots r100 = new IMMessageKeys$Slots("CONTENT", 0);
        CONTENT = r100;
        IMMessageKeys$Slots r101 = new IMMessageKeys$Slots("AVATAR", 1);
        AVATAR = r101;
        IMMessageKeys$Slots r102 = new IMMessageKeys$Slots("TOP", 2);
        TOP = r102;
        IMMessageKeys$Slots r103 = new IMMessageKeys$Slots("HEADER", 3);
        HEADER = r103;
        IMMessageKeys$Slots r104 = new IMMessageKeys$Slots("FOOTER", 4);
        FOOTER = r104;
        IMMessageKeys$Slots r105 = new IMMessageKeys$Slots("CORNER_1", 5);
        CORNER_1 = r105;
        IMMessageKeys$Slots r110 = new IMMessageKeys$Slots("CORNER_2", 6);
        CORNER_2 = r110;
        IMMessageKeys$Slots r111 = new IMMessageKeys$Slots("BOTTOM", 7);
        BOTTOM = r111;
        IMMessageKeys$Slots r112 = new IMMessageKeys$Slots("ROOF", 8);
        ROOF = r112;
        IMMessageKeys$Slots r113 = new IMMessageKeys$Slots("DING_ICON", 9);
        DING_ICON = r113;
        IMMessageKeys$Slots r114 = new IMMessageKeys$Slots("SELECT", 10);
        SELECT = r114;
        IMMessageKeys$Slots r115 = new IMMessageKeys$Slots("INNER_EXPOSURE", 11);
        INNER_EXPOSURE = r115;
        IMMessageKeys$Slots[] r106 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
        f415967a = r106;
        f415968b = EnumEntriesKt.enumEntries(r106);
    }

    public static IMMessageKeys$Slots[] values() {
        return (IMMessageKeys$Slots[]) f415967a.clone();
    }

    public static IMMessageKeys$Slots valueOf(String r100) {
        return (IMMessageKeys$Slots) a.a(IMMessageKeys$Slots.class, r100);
    }

    public IMMessageKeys$Slots(String r100, int r101) {
        super(r100, r101);
    }
}
