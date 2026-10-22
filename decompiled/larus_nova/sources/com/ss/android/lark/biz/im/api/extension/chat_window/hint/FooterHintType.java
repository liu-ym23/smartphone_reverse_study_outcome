package com.ss.android.lark.biz.im.api.extension.chat_window.hint;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/chat_window/hint/FooterHintType;", "", "<init>", "(Ljava/lang/String;I)V", "P2P_LEGAL_HOLD", "P2P_CHATTER_DISMISSAL", "GROUP_FROZEN", "BOT_NOT_AVAILABLE", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FooterHintType extends Enum<FooterHintType> {
    public static final FooterHintType BOT_NOT_AVAILABLE = null;
    public static final FooterHintType GROUP_FROZEN = null;
    public static final FooterHintType P2P_CHATTER_DISMISSAL = null;
    public static final FooterHintType P2P_LEGAL_HOLD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FooterHintType[] f410105a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410106b = null;

    public static EnumEntries<FooterHintType> getEntries() {
        return f410106b;
    }

    static {
        FooterHintType r100 = new FooterHintType("P2P_LEGAL_HOLD", 0);
        P2P_LEGAL_HOLD = r100;
        FooterHintType r101 = new FooterHintType("P2P_CHATTER_DISMISSAL", 1);
        P2P_CHATTER_DISMISSAL = r101;
        FooterHintType r102 = new FooterHintType("GROUP_FROZEN", 2);
        GROUP_FROZEN = r102;
        FooterHintType r103 = new FooterHintType("BOT_NOT_AVAILABLE", 3);
        BOT_NOT_AVAILABLE = r103;
        FooterHintType[] r104 = {r100, r101, r102, r103};
        f410105a = r104;
        f410106b = EnumEntriesKt.enumEntries(r104);
    }

    public static FooterHintType[] values() {
        return (FooterHintType[]) f410105a.clone();
    }

    public static FooterHintType valueOf(String r100) {
        return (FooterHintType) a.a(FooterHintType.class, r100);
    }

    public FooterHintType(String r100, int r101) {
        super(r100, r101);
    }
}
