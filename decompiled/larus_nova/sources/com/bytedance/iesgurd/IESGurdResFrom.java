package com.bytedance.iesgurd;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/iesgurd/IESGurdResFrom;", "", UserProfileEvent.POSITION_NONE, "OFFLINE", "OFFLINE_FROM_CDN", "OFFLINE_FROM_UPDATE", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final enum IESGurdResFrom extends Enum<IESGurdResFrom> {
    public static final IESGurdResFrom NONE = null;
    public static final IESGurdResFrom OFFLINE = null;
    public static final IESGurdResFrom OFFLINE_FROM_CDN = null;
    public static final IESGurdResFrom OFFLINE_FROM_UPDATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IESGurdResFrom[] f250625a = null;

    static {
        IESGurdResFrom r100 = new IESGurdResFrom(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        IESGurdResFrom r101 = new IESGurdResFrom("OFFLINE", 1);
        OFFLINE = r101;
        IESGurdResFrom r102 = new IESGurdResFrom("OFFLINE_FROM_CDN", 2);
        OFFLINE_FROM_CDN = r102;
        IESGurdResFrom r103 = new IESGurdResFrom("OFFLINE_FROM_UPDATE", 3);
        OFFLINE_FROM_UPDATE = r103;
        f250625a = new IESGurdResFrom[]{r100, r101, r102, r103};
    }

    public static IESGurdResFrom valueOf(String r100) {
        return (IESGurdResFrom) r27.a.a(IESGurdResFrom.class, r100);
    }

    public static IESGurdResFrom[] values() {
        return (IESGurdResFrom[]) f250625a.clone();
    }

    public IESGurdResFrom(String r100, int r101) {
        super(r100, r101);
    }
}
