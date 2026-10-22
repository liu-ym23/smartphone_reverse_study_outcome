package com.bytedance.lark.inject_request_android;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/bytedance/lark/inject_request_android/RequestHandleTarget;", "", "(Ljava/lang/String;I)V", "into", "Linject_request/proto/RequestHandleTarget;", "intoInt", "", "Header", "Host", "Companion", "inject_request_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum RequestHandleTarget extends Enum<RequestHandleTarget> {
    public static final a Companion = null;
    public static final RequestHandleTarget Header = null;
    public static final RequestHandleTarget Host = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RequestHandleTarget[] f252936a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f252937b = null;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f252938a = null;

        static {
            int[] r100 = new int[RequestHandleTarget.values().length];
            r100[RequestHandleTarget.Header.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[RequestHandleTarget.Host.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f252938a = r100;
        }
    }

    public static EnumEntries<RequestHandleTarget> getEntries() {
        return f252937b;
    }

    public static RequestHandleTarget valueOf(String r100) {
        return (RequestHandleTarget) r27.a.a(RequestHandleTarget.class, r100);
    }

    public static RequestHandleTarget[] values() {
        return (RequestHandleTarget[]) f252936a.clone();
    }

    static {
        RequestHandleTarget r100 = new RequestHandleTarget("Header", 0);
        Header = r100;
        RequestHandleTarget r101 = new RequestHandleTarget("Host", 1);
        Host = r101;
        RequestHandleTarget[] r102 = {r100, r101};
        f252936a = r102;
        f252937b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public final inject_request.proto.RequestHandleTarget into() {
        int r100 = b.f252938a[ordinal()];
        if (r100 == 1) goto L10;
        if (r100 != 2) goto L8;
        return inject_request.proto.RequestHandleTarget.VAR_REQUEST_HANDLE_TARGET_HOST;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return inject_request.proto.RequestHandleTarget.VAR_REQUEST_HANDLE_TARGET_HEADER;
    }

    public final int intoInt() {
        int r100 = b.f252938a[ordinal()];
        if (r100 != 1) goto L5;
        return 0;
    L5:
        if (r100 != 2) goto L8;
        return 1;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final RequestHandleTarget fromInt(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L10;
        if (r100 != 1) goto L8;
        return Host;
    L8:
        throw new RuntimeException("Unmatched primitive enum value: RequestHandleTarget with ");
    L10:
        return Header;
    }

    public RequestHandleTarget(String r100, int r101) {
        super(r100, r101);
    }
}
