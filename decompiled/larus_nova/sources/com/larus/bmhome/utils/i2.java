package com.larus.bmhome.utils;

import android.os.Handler;
import com.larus.utils.logger.FLogger;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class i2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f315023a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f315024b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, f2.b> f315025c = null;

    /* JADX INFO: loaded from: classes26.dex */
    public static final class a implements f2.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f315026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f315027b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f315028c;

        @Override // com.larus.bmhome.utils.f2.b
        public final void b() {
        }

        @Override // com.larus.bmhome.utils.f2.b
        public final void onFirstFrame() {
        }

        @Override // com.larus.bmhome.utils.f2.b
        public final void a(String r100) {
            FLogger.f375446a.i("LaunchFirstFeedShowUtils", "launchAfterFirstFeedShow[end]: " + this.f315026a + ", " + r100);
            i2.f315025c.remove(this.f315026a);
            f2.f315012d.remove(this);
            SoftReference<Handler> r101 = com.larus.utils.y.f375498a;
            Runnable r102 = this.f315027b;
            long r103 = this.f315028c;
            Intrinsics.checkNotNullParameter(r102, "action");
            com.larus.utils.y.d(r102, r103);
        }

        public a(String r100, Runnable r101, long r102) {
            this.f315026a = r100;
            this.f315027b = r101;
            this.f315028c = r102;
        }
    }

    static {
        f315023a = LazyKt.lazy(new h2());
        f315024b = new LinkedHashSet();
        f315025c = new LinkedHashMap();
    }

    public static hq9.j a() {
        return (hq9.j) f315023a.getValue();
    }

    public static void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "outScene");
        Map<String, f2.b> r101 = f315025c;
        if (r101.isEmpty() == false) goto L5;
        return;
    L5:
        if (com.bytedance.apm.util.u.a() == false) goto L13;
        f2.b r102 = r101.remove(r100);
        if (r102 == null) goto L12;
        f315024b.remove(r100);
        f2.f315012d.remove(r102);
        return;
    L12:
        return;
    }

    public static void b(String r100, long r101, Runnable r102) {
        Intrinsics.checkNotNullParameter(r100, "outScene");
        Intrinsics.checkNotNullParameter(r102, "action");
        if (f2.f315009a != FirstFeedSceneEnum.CHAT_DETAIL) goto L5;
    L6:
        Set<String> r103 = f315024b;
        if (r103.contains(r100) == false) goto L9;
    L15:
        FLogger.f375446a.i("LaunchFirstFeedShowUtils", "Execute Immediately: ".concat(r100));
        r102.run();
        return;
    L9:
        if (f2.f315010b == true) goto L15;
        if (com.bytedance.apm.util.u.a() == false) goto L15;
        FLogger.f375446a.i("LaunchFirstFeedShowUtils", "launchAfterFirstFeedShow[start]: ".concat(r100));
        r103.add(r100);
        a r104 = new a(r100, r102, r101);
        f315025c.put(r100, r104);
        f2.f315012d.add(r104);
        return;
    L5:
        if (f2.f315009a != FirstFeedSceneEnum.CHAT_DETAIL_NEW_CONVERSATION) goto L15;
        goto L6
    }
}
