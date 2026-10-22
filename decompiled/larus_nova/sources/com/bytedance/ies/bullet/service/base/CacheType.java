package com.bytedance.ies.bullet.service.base;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/CacheType;", "", "PRE_RENDER", "REUSE", UserProfileEvent.POSITION_NONE, "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum CacheType extends Enum<CacheType> {
    public static final CacheType NONE = null;
    public static final CacheType PRE_RENDER = null;
    public static final CacheType REUSE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CacheType[] f247771a = null;

    public static CacheType valueOf(String r100) {
        return (CacheType) r27.a.a(CacheType.class, r100);
    }

    public static CacheType[] values() {
        return (CacheType[]) f247771a.clone();
    }

    static {
        CacheType r100 = new CacheType("PRE_RENDER", 0);
        PRE_RENDER = r100;
        CacheType r101 = new CacheType("REUSE", 1);
        REUSE = r101;
        CacheType r102 = new CacheType(UserProfileEvent.POSITION_NONE, 2);
        NONE = r102;
        f247771a = new CacheType[]{r100, r101, r102};
    }

    public CacheType(String r100, int r101) {
        super(r100, r101);
    }
}
