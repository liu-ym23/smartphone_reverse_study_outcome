package com.bytedance.lark.open_app_android;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/lark/open_app_android/GetMessageContentErrorKind;", "", "(Ljava/lang/String;I)V", "into", "Lopen_app/proto/GetMessageContentErrorKind;", "intoInt", "", "InternalError", "MessageNotFound", "GatewayError", "ServerError", "Companion", "open_app_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum GetMessageContentErrorKind extends Enum<GetMessageContentErrorKind> {
    public static final a Companion = null;
    public static final GetMessageContentErrorKind GatewayError = null;
    public static final GetMessageContentErrorKind InternalError = null;
    public static final GetMessageContentErrorKind MessageNotFound = null;
    public static final GetMessageContentErrorKind ServerError = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GetMessageContentErrorKind[] f253404a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f253405b = null;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f253406a = null;

        static {
            int[] r100 = new int[GetMessageContentErrorKind.values().length];
            r100[GetMessageContentErrorKind.InternalError.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[GetMessageContentErrorKind.MessageNotFound.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[GetMessageContentErrorKind.GatewayError.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[GetMessageContentErrorKind.ServerError.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f253406a = r100;
        }
    }

    public static EnumEntries<GetMessageContentErrorKind> getEntries() {
        return f253405b;
    }

    public static GetMessageContentErrorKind valueOf(String r100) {
        return (GetMessageContentErrorKind) r27.a.a(GetMessageContentErrorKind.class, r100);
    }

    public static GetMessageContentErrorKind[] values() {
        return (GetMessageContentErrorKind[]) f253404a.clone();
    }

    static {
        GetMessageContentErrorKind r100 = new GetMessageContentErrorKind("InternalError", 0);
        InternalError = r100;
        GetMessageContentErrorKind r101 = new GetMessageContentErrorKind("MessageNotFound", 1);
        MessageNotFound = r101;
        GetMessageContentErrorKind r102 = new GetMessageContentErrorKind("GatewayError", 2);
        GatewayError = r102;
        GetMessageContentErrorKind r103 = new GetMessageContentErrorKind("ServerError", 3);
        ServerError = r103;
        GetMessageContentErrorKind[] r104 = {r100, r101, r102, r103};
        f253404a = r104;
        f253405b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public final open_app.proto.GetMessageContentErrorKind into() {
        int r100 = b.f253406a[ordinal()];
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L19;
        if (r100 == 3) goto L18;
        if (r100 != 4) goto L12;
        return open_app.proto.GetMessageContentErrorKind.VAR_GET_MESSAGE_CONTENT_ERROR_KIND_SERVER_ERROR;
    L12:
        throw new NoWhenBranchMatchedException();
    L18:
        return open_app.proto.GetMessageContentErrorKind.VAR_GET_MESSAGE_CONTENT_ERROR_KIND_GATEWAY_ERROR;
    L19:
        return open_app.proto.GetMessageContentErrorKind.VAR_GET_MESSAGE_CONTENT_ERROR_KIND_MESSAGE_NOT_FOUND;
    L16:
        return open_app.proto.GetMessageContentErrorKind.VAR_GET_MESSAGE_CONTENT_ERROR_KIND_INTERNAL_ERROR;
    }

    public final int intoInt() {
        int r100 = b.f253406a[ordinal()];
        if (r100 != 1) goto L5;
        return 0;
    L5:
        if (r100 != 2) goto L7;
        return 1;
    L7:
        if (r100 != 3) goto L9;
        return 2;
    L9:
        if (r100 != 4) goto L12;
        return 3;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final GetMessageContentErrorKind fromInt(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L16;
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L18;
        if (r100 != 3) goto L12;
        return ServerError;
    L12:
        throw new RuntimeException("Unmatched primitive enum value: GetMessageContentErrorKind with ");
    L18:
        return GatewayError;
    L19:
        return MessageNotFound;
    L16:
        return InternalError;
    }

    public GetMessageContentErrorKind(String r100, int r101) {
        super(r100, r101);
    }
}
