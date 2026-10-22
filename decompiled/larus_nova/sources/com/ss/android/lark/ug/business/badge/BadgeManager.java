package com.ss.android.lark.ug.business.badge;

import com.bytedance.lark.pb.ugreach.v1.ScenarioContext;
import com.ss.android.lark.pb.ug_reach.BadgeMaterial;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class BadgeManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f444410a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f444411b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f444412c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, b> f444413d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<String, b> f444414e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<String, ScenarioContext> f444415f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final BadgeManager$getScenarioCallback$1 f444416g = null;

    /* JADX WARN: Type inference failed for: r0v8, types: [com.ss.android.lark.ug.business.badge.BadgeManager$getScenarioCallback$1] */
    static {
        f444410a = new j();
        f444411b = LazyKt.lazy(BadgeManager$badgeService$2.INSTANCE);
        f444412c = new AtomicBoolean(false);
        f444413d = new LinkedHashMap();
        f444414e = new ConcurrentHashMap();
        f444415f = new LinkedHashMap();
        f444416g = new BadgeManager$getScenarioCallback$1();
    }

    public static void a(String r100, b r101) {
        j r102 = f444410a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "key");
        k r103 = (k) ((LinkedHashMap) r102.f444425b).get(r100);
        BadgeMaterial r104 = null;
        if (r103 == null) goto L5;
        a r105 = r103.f444428b;
    L6:
        if (r105 == null) goto L8;
        r104 = r105.f444420b;
    L8:
        if (r104 == null) goto L21;
        BadgeMaterial r106 = r105.f444420b;
        Intrinsics.checkNotNullParameter(r106, "<this>");
        BadgeMaterial.BadgeType r107 = r106.mtype;
        if (r107 != null) goto L12;
        int r108 = -1;
    L14:
        if (r108 != 1) goto L16;
        int r109 = w9c.g.f558797a;
        w9c.g.a(r106.mViewText);
    L20:
        Intrinsics.checkNotNullParameter(r106.mtype, "badgeType");
        r101.onShow();
        return;
    L16:
        if (r108 != 2) goto L20;
        Integer r110 = r106.mViewNumber;
        goto L20
    L12:
        r108 = f.f444423a[r107.ordinal()];
        goto L14
    L21:
        r101.onHide();
        return;
    L5:
        r105 = null;
        goto L6
    }
}
