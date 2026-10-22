package com.ss.android.ugc.aweme.debug.tag.base;

import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.ugc.aweme.debug.LtedLogger;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/debug/tag/base/LtedTagManager;", "", "<init>", "()V", "localtest_manager_release"}, k = 1, mv = {1, 4, 3})
public final class LtedTagManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LtedTagManager f450007a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<? extends Class<? extends LocalTestTag>> f450008b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<Class<? extends LocalTestTag>, Boolean> f450009c = null;

    private LtedTagManager() {
    }

    static {
        f450007a = new LtedTagManager();
        f450008b = SetsKt.emptySet();
        f450009c = new ConcurrentHashMap();
    }

    public static boolean a(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        long r101 = System.currentTimeMillis();
        ConcurrentHashMap<Class<? extends LocalTestTag>, Boolean> r102 = f450009c;
        if (r102.contains(r100) == true) goto L5;
    L11:
        Intrinsics.throwUninitializedPropertyAccessException(CloudControlInf.SP);
        r100.getClass();
        throw null;
    L5:
        if (r102.get(r100) == null) goto L11;
        LtedLogger r103 = LtedLogger.f450005a;
        StringBuilder r104 = new StringBuilder("命中缓存，");
        r104.append(r100.getName());
        r104.append(" = ");
        r104.append(r102.get(r100));
        r104.append(", ");
        r104.append("计算时间: " + ((System.currentTimeMillis() - r101) / 1000.0f) + " s");
        String r105 = r104.toString();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r105, "msg");
        Boolean r106 = r102.get(r100);
        if (r106 != null) goto L10;
        r106 = Boolean.FALSE;
    L10:
        return r106.booleanValue();
    }
}
