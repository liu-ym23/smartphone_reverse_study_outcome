package com.bytedance.lark.inject_request_android;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/lark/inject_request_android/RequestHandleAction;", "", "(Ljava/lang/String;I)V", "into", "Linject_request/proto/RequestHandleAction;", "intoInt", "", "Add", "Replace", "RedirectPolicy", "Companion", "inject_request_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum RequestHandleAction extends Enum<RequestHandleAction> {
    public static final RequestHandleAction Add = null;
    public static final a Companion = null;
    public static final RequestHandleAction RedirectPolicy = null;
    public static final RequestHandleAction Replace = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RequestHandleAction[] f252933a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f252934b = null;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f252935a = null;

        static {
            int[] r100 = new int[RequestHandleAction.values().length];
            r100[RequestHandleAction.Add.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[RequestHandleAction.Replace.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[RequestHandleAction.RedirectPolicy.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f252935a = r100;
        }
    }

    public static EnumEntries<RequestHandleAction> getEntries() {
        return f252934b;
    }

    public static RequestHandleAction valueOf(String r100) {
        return (RequestHandleAction) r27.a.a(RequestHandleAction.class, r100);
    }

    public static RequestHandleAction[] values() {
        return (RequestHandleAction[]) f252933a.clone();
    }

    static {
        RequestHandleAction r100 = new RequestHandleAction("Add", 0);
        Add = r100;
        RequestHandleAction r101 = new RequestHandleAction("Replace", 1);
        Replace = r101;
        RequestHandleAction r102 = new RequestHandleAction("RedirectPolicy", 2);
        RedirectPolicy = r102;
        RequestHandleAction[] r103 = {r100, r101, r102};
        f252933a = r103;
        f252934b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public final inject_request.proto.RequestHandleAction into() {
        int r100 = b.f252935a[ordinal()];
        if (r100 == 1) goto L13;
        if (r100 == 2) goto L15;
        if (r100 != 3) goto L10;
        return inject_request.proto.RequestHandleAction.VAR_REQUEST_HANDLE_ACTION_REDIRECT_POLICY;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return inject_request.proto.RequestHandleAction.VAR_REQUEST_HANDLE_ACTION_REPLACE;
    L13:
        return inject_request.proto.RequestHandleAction.VAR_REQUEST_HANDLE_ACTION_ADD;
    }

    public final int intoInt() {
        int r100 = b.f252935a[ordinal()];
        if (r100 != 1) goto L5;
        return 0;
    L5:
        if (r100 != 2) goto L7;
        return 1;
    L7:
        if (r100 != 3) goto L10;
        return 2;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final RequestHandleAction fromInt(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L13;
        if (r100 == 1) goto L15;
        if (r100 != 2) goto L10;
        return RedirectPolicy;
    L10:
        throw new RuntimeException("Unmatched primitive enum value: RequestHandleAction with ");
    L15:
        return Replace;
    L13:
        return Add;
    }

    public RequestHandleAction(String r100, int r101) {
        super(r100, r101);
    }
}
