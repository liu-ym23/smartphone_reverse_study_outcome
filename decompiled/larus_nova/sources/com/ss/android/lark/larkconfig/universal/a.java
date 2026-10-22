package com.ss.android.lark.larkconfig.universal;

import com.bytedance.lark.pb.basic.v1.UniversalUserSetting;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f431126a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, UniversalUserSetting> f431127b = null;

    public a() {
    }

    static {
        f431126a = new a();
        f431127b = new LinkedHashMap();
    }

    public static void a(String r100, UniversalUserSetting r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "data");
        f431127b.put(r100, r101);
    }
}
