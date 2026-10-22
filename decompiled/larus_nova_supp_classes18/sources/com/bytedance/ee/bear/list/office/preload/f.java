package com.bytedance.ee.bear.list.office.preload;

import android.text.TextUtils;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.util.info.AppInfoUtils;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f {
    public boolean a;
    public boolean b;

    public interface a {
        void a(ArrayList<Document> r1);
    }

    public f() {
    }

    public final boolean a(String r12, String r13, a r14) {
        if (TextUtils.isEmpty(r12) == false) goto L5;
    L44:
        return false;
    L5:
        if (TextUtils.isEmpty(r13) == true) goto L44;
        if (AppInfoUtils.f().booleanValue() == true) goto L10;
        return false;
    L10:
        ConcurrentHashMap<String, g> r0 = d.a;
        long r2 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r13, "tab");
        if (r12 != null) goto L13;
    L16:
        boolean r4 = true;
    L17:
        String r7 = "NO_REQUEST";
        if (r4 == false) goto L20;
        int r3 = e.e;
        e r5 = e.a.a("NO_REQUEST");
    L32:
        if (r5.a == true) goto L35;
        tt5.a.h("OfficeSpacePreloadStarter", "office_space_preload_miss key=" + r12 + " tab=" + r13 + " reason=" + r5.b);
        return false;
    L35:
        this.a = true;
        g r1 = r5.d;
        if (r1 != null) goto L38;
        long r8 = 0;
    L39:
        if (r1 != null) goto L41;
        String r6 = "";
    L42:
        tt5.a.h("OfficeSpacePreloadStarter", "office_space_preload_hit requestId=" + r6 + " key=" + r12 + " tab=" + r13 + " cache_age_ms=" + r8 + " size=" + r5.c.size());
        r14.a(r5.c);
        return true;
    L41:
        r6 = r1.a;
        goto L42
    L38:
        r8 = System.currentTimeMillis() - r1.e;
        goto L39
    L20:
        String r9 = d.a(r12, r13);
        g r10 = d.a.remove(r9);
        if (r10 != null) goto L27;
        int r11 = e.e;
        String r15 = d.b.remove(r9);
        if (r15 == null) goto L26;
        r7 = r15;
    L26:
        r5 = e.a.a(r7);
        goto L32
    L27:
        d.b.remove(r9);
        if (r10.f >= r2) goto L30;
        tt5.a.h("OfficeSpacePreloadCache", "office_space_preload_cache_expired requestId=" + r10.a + " key=" + r12 + " tab=" + r13);
        int r16 = e.e;
        r5 = e.a.a("EXPIRED");
        goto L32
    L30:
        int r17 = e.e;
        Intrinsics.checkNotNullParameter(r10, "entry");
        r5 = new e(true, "NONE", r10.d, r10);
        goto L32
    L13:
        if (r12.length() == 0) goto L16;
        r4 = false;
        goto L17
    }
}
