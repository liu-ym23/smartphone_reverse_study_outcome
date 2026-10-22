package com.ss.android.lark.officesdk.minutes.service.foundation.network.core.internal;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.lark.sdk.StreamDataSource;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u0004\u0018\u00010\tj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/core/internal/MmNetReqStrategy;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "PREFER_NETWORK", "PREFER_CACHE", "FORCE_LOCAL", "toSource", "Lcom/bytedance/lark/sdk/StreamDataSource;", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmNetReqStrategy extends Enum<MmNetReqStrategy> {
    public static final MmNetReqStrategy FORCE_LOCAL = null;
    public static final MmNetReqStrategy NONE = null;
    public static final MmNetReqStrategy PREFER_CACHE = null;
    public static final MmNetReqStrategy PREFER_NETWORK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmNetReqStrategy[] f433934a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433935b = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f433936a = null;

        static {
            int[] r100 = new int[MmNetReqStrategy.values().length];
            r100[MmNetReqStrategy.PREFER_CACHE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[MmNetReqStrategy.FORCE_LOCAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[MmNetReqStrategy.PREFER_NETWORK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f433936a = r100;
        }
    }

    public static EnumEntries<MmNetReqStrategy> getEntries() {
        return f433935b;
    }

    static {
        MmNetReqStrategy r100 = new MmNetReqStrategy(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        MmNetReqStrategy r101 = new MmNetReqStrategy("PREFER_NETWORK", 1);
        PREFER_NETWORK = r101;
        MmNetReqStrategy r102 = new MmNetReqStrategy("PREFER_CACHE", 2);
        PREFER_CACHE = r102;
        MmNetReqStrategy r103 = new MmNetReqStrategy("FORCE_LOCAL", 3);
        FORCE_LOCAL = r103;
        MmNetReqStrategy[] r104 = {r100, r101, r102, r103};
        f433934a = r104;
        f433935b = EnumEntriesKt.enumEntries(r104);
    }

    public static MmNetReqStrategy[] values() {
        return (MmNetReqStrategy[]) f433934a.clone();
    }

    public final StreamDataSource toSource() {
        int r100 = a.f433936a[ordinal()];
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L15;
        if (r100 == 3) goto L14;
        return null;
    L14:
        return StreamDataSource.ONCE_NET;
    L15:
        return StreamDataSource.ONCE_LOCAL;
    L12:
        return StreamDataSource.DEFAULT_SMART;
    }

    public static MmNetReqStrategy valueOf(String r100) {
        return (MmNetReqStrategy) r27.a.a(MmNetReqStrategy.class, r100);
    }

    public MmNetReqStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
