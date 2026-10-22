package com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/core/httptypes/MmHttpMethod;", "", "<init>", "(Ljava/lang/String;I)V", "GET", "POST", "PUT", "DELETE", "PATCH", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmHttpMethod extends Enum<MmHttpMethod> {
    public static final MmHttpMethod DELETE = null;
    public static final MmHttpMethod GET = null;
    public static final MmHttpMethod PATCH = null;
    public static final MmHttpMethod POST = null;
    public static final MmHttpMethod PUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmHttpMethod[] f433932a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433933b = null;

    public static EnumEntries<MmHttpMethod> getEntries() {
        return f433933b;
    }

    static {
        MmHttpMethod r100 = new MmHttpMethod("GET", 0);
        GET = r100;
        MmHttpMethod r101 = new MmHttpMethod("POST", 1);
        POST = r101;
        MmHttpMethod r102 = new MmHttpMethod("PUT", 2);
        PUT = r102;
        MmHttpMethod r103 = new MmHttpMethod("DELETE", 3);
        DELETE = r103;
        MmHttpMethod r104 = new MmHttpMethod("PATCH", 4);
        PATCH = r104;
        MmHttpMethod[] r105 = {r100, r101, r102, r103, r104};
        f433932a = r105;
        f433933b = EnumEntriesKt.enumEntries(r105);
    }

    public static MmHttpMethod[] values() {
        return (MmHttpMethod[]) f433932a.clone();
    }

    public static MmHttpMethod valueOf(String r100) {
        return (MmHttpMethod) a.a(MmHttpMethod.class, r100);
    }

    public MmHttpMethod(String r100, int r101) {
        super(r100, r101);
    }
}
