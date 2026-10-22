package com.bytedance.sdk.xbridge.cn.auth;

import com.bytedance.sdk.xbridge.cn.auth.bean.RequestCheckAction;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ld7.j f269815d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f269816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, ld7.d> f269817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f269818c;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.xbridge.cn.auth.b$b, reason: collision with other inner class name */
    public /* synthetic */ class C3771b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f269819a = null;

        static {
            int[] r100 = new int[RequestCheckAction.values().length];
            r100[RequestCheckAction.DISABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[RequestCheckAction.TOGGLE_OFF.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[RequestCheckAction.REPORT_ONLY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[RequestCheckAction.CHECK.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f269819a = r100;
        }
    }

    public static final class c {
        public c() {
        }
    }

    static {
        f269815d = new ld7.j(1000, 999);
    }

    public b() {
        this(new f(null, null, 255));
    }

    public b(f r100) {
        Intrinsics.checkNotNullParameter(r100, "feAuthConfig");
        this.f269816a = r100;
        this.f269817b = new HashMap();
        this.f269818c = new c();
    }

    public final void a(String r100) {
        this.f269818c.getClass();
        Intrinsics.checkNotNullParameter("AuthV2VerifyHelper", "tag");
        Intrinsics.checkNotNullParameter(r100, "msg");
    }
}
