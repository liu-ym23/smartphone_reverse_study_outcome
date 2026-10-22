package com.bytedance.lark.lark_bitable_android;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/bytedance/lark/lark_bitable_android/ErrorContent;", "", "(Ljava/lang/String;I)V", "into", "Llark_bitable/proto/ErrorContent;", "intoInt", "", "NoPermission", "NoContent", "Companion", "lark_bitable_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum ErrorContent extends Enum<ErrorContent> {
    public static final a Companion = null;
    public static final ErrorContent NoContent = null;
    public static final ErrorContent NoPermission = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ErrorContent[] f252952a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f252953b = null;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f252954a = null;

        static {
            int[] r100 = new int[ErrorContent.values().length];
            r100[ErrorContent.NoPermission.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ErrorContent.NoContent.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f252954a = r100;
        }
    }

    public static EnumEntries<ErrorContent> getEntries() {
        return f252953b;
    }

    public static ErrorContent valueOf(String r100) {
        return (ErrorContent) r27.a.a(ErrorContent.class, r100);
    }

    public static ErrorContent[] values() {
        return (ErrorContent[]) f252952a.clone();
    }

    static {
        ErrorContent r100 = new ErrorContent("NoPermission", 0);
        NoPermission = r100;
        ErrorContent r101 = new ErrorContent("NoContent", 1);
        NoContent = r101;
        ErrorContent[] r102 = {r100, r101};
        f252952a = r102;
        f252953b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public final lark_bitable.proto.ErrorContent into() {
        int r100 = b.f252954a[ordinal()];
        if (r100 == 1) goto L10;
        if (r100 != 2) goto L8;
        return lark_bitable.proto.ErrorContent.VAR_ERROR_CONTENT_NO_CONTENT;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return lark_bitable.proto.ErrorContent.VAR_ERROR_CONTENT_NO_PERMISSION;
    }

    public final int intoInt() {
        int r100 = b.f252954a[ordinal()];
        if (r100 != 1) goto L5;
        return 0;
    L5:
        if (r100 != 2) goto L8;
        return 1;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final ErrorContent fromInt(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L10;
        if (r100 != 1) goto L8;
        return NoContent;
    L8:
        throw new RuntimeException("Unmatched primitive enum value: ErrorContent with ");
    L10:
        return NoPermission;
    }

    public ErrorContent(String r100, int r101) {
        super(r100, r101);
    }
}
