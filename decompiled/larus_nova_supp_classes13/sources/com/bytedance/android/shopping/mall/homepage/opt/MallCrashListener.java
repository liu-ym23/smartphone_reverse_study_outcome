package com.bytedance.android.shopping.mall.homepage.opt;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.shopping.mall.homepage.tools.q;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICrashCallback;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class MallCrashListener {
    public boolean a;
    public final Lazy b;
    public final b c;

    public static final class a {
    }

    public static final class b implements ICrashCallback {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void onCrash(CrashType r4, String r5, Thread r6) {
            Intrinsics.checkNotNullParameter(r4, "<anonymous parameter 0>");
            IHybridHostService r7 = com.bytedance.android.ec.hybrid.a.h();
            if (r7 == null) goto L15;
            yj.i r8 = r7.getIHybridHostAppInfo();
            if (r8 == null) goto L16;
            Context r9 = r8.getApplicationContext();
            if (r9 == null) goto L17;
            SharedPreferences r10 = q.c(r9, "mall_stability_sp");
            LinkedHashSet r11 = new LinkedHashSet();
            Set<String> r0 = r10.getStringSet("mall_crash_time", null);
            if (r0 != null) goto L11;
        L13:
            r11.add(String.valueOf(System.currentTimeMillis()));
            r10.edit().putStringSet("mall_crash_time", r11).commit();
            return;
        L11:
            if (r0.size() >= 100) goto L13;
            r11.addAll(r0);
            goto L13
        L17:
            return;
        L16:
            return;
        }
    }

    static {
    }

    public MallCrashListener() {
        this.b = LazyKt.lazy(MallCrashListener$crashListenerSetting$2.INSTANCE);
        this.c = b.a;
    }
}
