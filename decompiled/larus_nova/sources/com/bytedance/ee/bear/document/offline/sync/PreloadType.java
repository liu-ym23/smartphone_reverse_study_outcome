package com.bytedance.ee.bear.document.offline.sync;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/document/offline/sync/PreloadType;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "CLIENTVAR", "SSR", AccountType.ALL, "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PreloadType extends Enum<PreloadType> {
    public static final PreloadType ALL = null;
    public static final PreloadType CLIENTVAR = null;
    public static final PreloadType NONE = null;
    public static final PreloadType SSR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreloadType[] f220560a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f220561b = null;

    public static EnumEntries<PreloadType> getEntries() {
        return f220561b;
    }

    static {
        PreloadType r100 = new PreloadType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        PreloadType r101 = new PreloadType("CLIENTVAR", 1);
        CLIENTVAR = r101;
        PreloadType r102 = new PreloadType("SSR", 2);
        SSR = r102;
        PreloadType r103 = new PreloadType(AccountType.ALL, 3);
        ALL = r103;
        PreloadType[] r104 = {r100, r101, r102, r103};
        f220560a = r104;
        f220561b = EnumEntriesKt.enumEntries(r104);
    }

    public static PreloadType[] values() {
        return (PreloadType[]) f220560a.clone();
    }

    public static PreloadType valueOf(String r100) {
        return (PreloadType) r27.a.a(PreloadType.class, r100);
    }

    public PreloadType(String r100, int r101) {
        super(r100, r101);
    }
}
