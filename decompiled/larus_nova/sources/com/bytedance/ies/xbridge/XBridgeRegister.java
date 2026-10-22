package com.bytedance.ies.xbridge;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class XBridgeRegister {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f249438a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, n> f249439a;

        public a() {
            this.f249439a = new LinkedHashMap();
            new LinkedHashMap();
        }
    }

    public XBridgeRegister() {
        this.f249438a = LazyKt.lazy(XBridgeRegister$table$2.INSTANCE);
    }

    public final void a(String r100, n r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "methodProvider");
        a r102 = (a) this.f249438a.getValue();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "methodProvider");
        r102.f249439a.put(r100, r101);
    }
}
