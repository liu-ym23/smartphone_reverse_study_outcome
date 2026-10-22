package com.larksuite.rucket.impl.base.request;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.lark.sdk.StreamDataSource;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u0004\u0018\u00010\tj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\n"}, d2 = {"Lcom/larksuite/rucket/impl/base/request/RequestStrategy;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "PREFER_NETWORK", "PREFER_CACHE", "FORCE_LOCAL", "toSource", "Lcom/bytedance/lark/sdk/StreamDataSource;", "rucket_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RequestStrategy extends Enum<RequestStrategy> {
    public static final RequestStrategy FORCE_LOCAL = null;
    public static final RequestStrategy NONE = null;
    public static final RequestStrategy PREFER_CACHE = null;
    public static final RequestStrategy PREFER_NETWORK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RequestStrategy[] f286062a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f286063b = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f286064a = null;

        static {
            int[] r100 = new int[RequestStrategy.values().length];
            r100[RequestStrategy.PREFER_CACHE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[RequestStrategy.FORCE_LOCAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[RequestStrategy.PREFER_NETWORK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f286064a = r100;
        }
    }

    public static EnumEntries<RequestStrategy> getEntries() {
        return f286063b;
    }

    static {
        RequestStrategy r100 = new RequestStrategy(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        RequestStrategy r101 = new RequestStrategy("PREFER_NETWORK", 1);
        PREFER_NETWORK = r101;
        RequestStrategy r102 = new RequestStrategy("PREFER_CACHE", 2);
        PREFER_CACHE = r102;
        RequestStrategy r103 = new RequestStrategy("FORCE_LOCAL", 3);
        FORCE_LOCAL = r103;
        RequestStrategy[] r104 = {r100, r101, r102, r103};
        f286062a = r104;
        f286063b = EnumEntriesKt.enumEntries(r104);
    }

    public static RequestStrategy[] values() {
        return (RequestStrategy[]) f286062a.clone();
    }

    public final StreamDataSource toSource() {
        int r100 = a.f286064a[ordinal()];
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

    public static RequestStrategy valueOf(String r100) {
        return (RequestStrategy) r27.a.a(RequestStrategy.class, r100);
    }

    public RequestStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
