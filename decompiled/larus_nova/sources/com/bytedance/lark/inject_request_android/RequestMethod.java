package com.bytedance.lark.inject_request_android;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/lark/inject_request_android/RequestMethod;", "", "(Ljava/lang/String;I)V", "into", "Linject_request/proto/RequestMethod;", "intoInt", "", "Get", "Post", "Delete", "Put", "Patch", "Head", "Connect", "Options", "Trace", "Companion", "inject_request_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum RequestMethod extends Enum<RequestMethod> {
    public static final a Companion = null;
    public static final RequestMethod Connect = null;
    public static final RequestMethod Delete = null;
    public static final RequestMethod Get = null;
    public static final RequestMethod Head = null;
    public static final RequestMethod Options = null;
    public static final RequestMethod Patch = null;
    public static final RequestMethod Post = null;
    public static final RequestMethod Put = null;
    public static final RequestMethod Trace = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RequestMethod[] f252939a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f252940b = null;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f252941a = null;

        static {
            int[] r100 = new int[RequestMethod.values().length];
            r100[RequestMethod.Get.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r100[RequestMethod.Post.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L39:
            r100[RequestMethod.Delete.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L29:
            r100[RequestMethod.Put.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L31:
            r100[RequestMethod.Patch.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L23:
            r100[RequestMethod.Head.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L33:
            r100[RequestMethod.Connect.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L35:
            r100[RequestMethod.Options.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L27:
            r100[RequestMethod.Trace.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L12:
            f252941a = r100;
        }
    }

    public static EnumEntries<RequestMethod> getEntries() {
        return f252940b;
    }

    public static RequestMethod valueOf(String r100) {
        return (RequestMethod) r27.a.a(RequestMethod.class, r100);
    }

    public static RequestMethod[] values() {
        return (RequestMethod[]) f252939a.clone();
    }

    static {
        RequestMethod r100 = new RequestMethod("Get", 0);
        Get = r100;
        RequestMethod r101 = new RequestMethod("Post", 1);
        Post = r101;
        RequestMethod r102 = new RequestMethod("Delete", 2);
        Delete = r102;
        RequestMethod r103 = new RequestMethod("Put", 3);
        Put = r103;
        RequestMethod r104 = new RequestMethod("Patch", 4);
        Patch = r104;
        RequestMethod r105 = new RequestMethod("Head", 5);
        Head = r105;
        RequestMethod r110 = new RequestMethod("Connect", 6);
        Connect = r110;
        RequestMethod r111 = new RequestMethod("Options", 7);
        Options = r111;
        RequestMethod r112 = new RequestMethod("Trace", 8);
        Trace = r112;
        RequestMethod[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f252939a = r113;
        f252940b = EnumEntriesKt.enumEntries(r113);
        Companion = new a();
    }

    public final inject_request.proto.RequestMethod into() {
        switch(b.f252941a[ordinal()]) {
            case 1: goto L15;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L19;
            case 7: goto L18;
            case 8: goto L17;
            case 9: goto L16;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L16:
        return inject_request.proto.RequestMethod.VAR_REQUEST_METHOD_TRACE;
    L17:
        return inject_request.proto.RequestMethod.VAR_REQUEST_METHOD_OPTIONS;
    L18:
        return inject_request.proto.RequestMethod.VAR_REQUEST_METHOD_CONNECT;
    L19:
        return inject_request.proto.RequestMethod.VAR_REQUEST_METHOD_HEAD;
    L20:
        return inject_request.proto.RequestMethod.VAR_REQUEST_METHOD_PATCH;
    L21:
        return inject_request.proto.RequestMethod.VAR_REQUEST_METHOD_PUT;
    L22:
        return inject_request.proto.RequestMethod.VAR_REQUEST_METHOD_DELETE;
    L23:
        return inject_request.proto.RequestMethod.VAR_REQUEST_METHOD_POST;
    L15:
        return inject_request.proto.RequestMethod.VAR_REQUEST_METHOD_GET;
    }

    public final int intoInt() {
        switch(b.f252941a[ordinal()]) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            case 9: goto L6;
            default: goto L5;
        };
    L6:
        return 8;
    L7:
        return 7;
    L8:
        return 6;
    L9:
        return 5;
    L10:
        return 4;
    L11:
        return 3;
    L12:
        return 2;
    L13:
        return 1;
    L14:
        return 0;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final RequestMethod fromInt(int r100) {
        Companion.getClass();
        switch(r100) {
            case 0: goto L15;
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L17;
            case 8: goto L16;
            default: goto L5;
        };
    L5:
        throw new RuntimeException("Unmatched primitive enum value: RequestMethod with ");
    L16:
        return Trace;
    L17:
        return Options;
    L18:
        return Connect;
    L19:
        return Head;
    L20:
        return Patch;
    L21:
        return Put;
    L22:
        return Delete;
    L23:
        return Post;
    L15:
        return Get;
    }

    public RequestMethod(String r100, int r101) {
        super(r100, r101);
    }
}
