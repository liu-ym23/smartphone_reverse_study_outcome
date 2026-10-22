package com.bytedance.lark.inject_request_android;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/lark/inject_request_android/FetchInfoType;", "", "(Ljava/lang/String;I)V", "into", "Linject_request/proto/FetchInfoType;", "intoInt", "", "Cookie", "Companion", "inject_request_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum FetchInfoType extends Enum<FetchInfoType> {
    public static final a Companion = null;
    public static final FetchInfoType Cookie = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FetchInfoType[] f252927a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f252928b = null;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f252929a = null;

        static {
            int[] r100 = new int[FetchInfoType.values().length];
            r100[FetchInfoType.Cookie.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f252929a = r100;
        }
    }

    public static EnumEntries<FetchInfoType> getEntries() {
        return f252928b;
    }

    public static FetchInfoType valueOf(String r100) {
        return (FetchInfoType) r27.a.a(FetchInfoType.class, r100);
    }

    public static FetchInfoType[] values() {
        return (FetchInfoType[]) f252927a.clone();
    }

    static {
        FetchInfoType r100 = new FetchInfoType();
        Cookie = r100;
        FetchInfoType[] r101 = {r100};
        f252927a = r101;
        f252928b = EnumEntriesKt.enumEntries(r101);
        Companion = new a();
    }

    public FetchInfoType() {
        super("Cookie", 0);
    }

    public final inject_request.proto.FetchInfoType into() {
        if (b.f252929a[ordinal()] != 1) goto L7;
        return inject_request.proto.FetchInfoType.VAR_FETCH_INFO_TYPE_COOKIE;
    L7:
        throw new NoWhenBranchMatchedException();
    }

    public final int intoInt() {
        if (b.f252929a[ordinal()] != 1) goto L7;
        return 0;
    L7:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final FetchInfoType fromInt(int r100) {
        Companion.getClass();
        if (r100 != 0) goto L7;
        return Cookie;
    L7:
        throw new RuntimeException("Unmatched primitive enum value: FetchInfoType with ");
    }
}
