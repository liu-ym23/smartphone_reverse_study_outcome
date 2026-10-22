package com.bytedance.ee.bear.list.office.preload;

import android.text.TextUtils;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.util.info.AppInfoUtils;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f229157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f229158b;

    public interface a {
        void a(ArrayList<Document> r100);
    }

    public f() {
    }

    public final boolean a(String r110, String r111, a r112) {
        if (TextUtils.isEmpty(r110) == false) goto L5;
    L44:
        return false;
    L5:
        if (TextUtils.isEmpty(r111) == true) goto L44;
        if (AppInfoUtils.f().booleanValue() == true) goto L10;
        return false;
    L10:
        ConcurrentHashMap<String, g> r100 = d.f229150a;
        long r101 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r111, "tab");
        if (r110 != null) goto L13;
    L16:
        boolean r102 = true;
    L17:
        String r103 = "NO_REQUEST";
        if (r102 == false) goto L20;
        int r104 = e.f229152e;
        e r105 = e.a.a("NO_REQUEST");
    L32:
        if (r105.f229153a == true) goto L35;
        tt5.a.h("OfficeSpacePreloadStarter", "office_space_preload_miss key=" + r110 + " tab=" + r111 + " reason=" + r105.f229154b);
        return false;
    L35:
        this.f229157a = true;
        g r106 = r105.f229156d;
        if (r106 != null) goto L38;
        long r107 = 0;
    L39:
        if (r106 != null) goto L41;
        String r108 = "";
    L42:
        tt5.a.h("OfficeSpacePreloadStarter", "office_space_preload_hit requestId=" + r108 + " key=" + r110 + " tab=" + r111 + " cache_age_ms=" + r107 + " size=" + r105.f229155c.size());
        r112.a(r105.f229155c);
        return true;
    L41:
        r108 = r106.f229159a;
        goto L42
    L38:
        r107 = System.currentTimeMillis() - r106.f229163e;
        goto L39
    L20:
        String r109 = d.a(r110, r111);
        g r113 = d.f229150a.remove(r109);
        if (r113 != null) goto L27;
        int r114 = e.f229152e;
        String r115 = d.f229151b.remove(r109);
        if (r115 == null) goto L26;
        r103 = r115;
    L26:
        r105 = e.a.a(r103);
        goto L32
    L27:
        d.f229151b.remove(r109);
        if (r113.f229164f >= r101) goto L30;
        tt5.a.h("OfficeSpacePreloadCache", "office_space_preload_cache_expired requestId=" + r113.f229159a + " key=" + r110 + " tab=" + r111);
        int r116 = e.f229152e;
        r105 = e.a.a("EXPIRED");
        goto L32
    L30:
        int r117 = e.f229152e;
        Intrinsics.checkNotNullParameter(r113, "entry");
        r105 = new e(true, UserProfileEvent.POSITION_NONE, r113.f229162d, r113);
        goto L32
    L13:
        if (r110.length() == 0) goto L16;
        r102 = false;
        goto L17
    }
}
