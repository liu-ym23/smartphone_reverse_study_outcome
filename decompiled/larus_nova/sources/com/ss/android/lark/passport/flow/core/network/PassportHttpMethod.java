package com.ss.android.lark.passport.flow.core.network;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/passport/flow/core/network/PassportHttpMethod;", "", "<init>", "(Ljava/lang/String;I)V", "GET", "POST", "DELETE", "PUT", "PATCH", "HEAD", "OPTIONS", "flow-passport-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PassportHttpMethod extends Enum<PassportHttpMethod> {
    public static final PassportHttpMethod DELETE = null;
    public static final PassportHttpMethod GET = null;
    public static final PassportHttpMethod HEAD = null;
    public static final PassportHttpMethod OPTIONS = null;
    public static final PassportHttpMethod PATCH = null;
    public static final PassportHttpMethod POST = null;
    public static final PassportHttpMethod PUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PassportHttpMethod[] f437749a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f437750b = null;

    public static EnumEntries<PassportHttpMethod> getEntries() {
        return f437750b;
    }

    static {
        PassportHttpMethod r100 = new PassportHttpMethod("GET", 0);
        GET = r100;
        PassportHttpMethod r101 = new PassportHttpMethod("POST", 1);
        POST = r101;
        PassportHttpMethod r102 = new PassportHttpMethod("DELETE", 2);
        DELETE = r102;
        PassportHttpMethod r103 = new PassportHttpMethod("PUT", 3);
        PUT = r103;
        PassportHttpMethod r104 = new PassportHttpMethod("PATCH", 4);
        PATCH = r104;
        PassportHttpMethod r105 = new PassportHttpMethod("HEAD", 5);
        HEAD = r105;
        PassportHttpMethod r110 = new PassportHttpMethod("OPTIONS", 6);
        OPTIONS = r110;
        PassportHttpMethod[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f437749a = r111;
        f437750b = EnumEntriesKt.enumEntries(r111);
    }

    public static PassportHttpMethod[] values() {
        return (PassportHttpMethod[]) f437749a.clone();
    }

    public static PassportHttpMethod valueOf(String r100) {
        return (PassportHttpMethod) r27.a.a(PassportHttpMethod.class, r100);
    }

    public PassportHttpMethod(String r100, int r101) {
        super(r100, r101);
    }
}
