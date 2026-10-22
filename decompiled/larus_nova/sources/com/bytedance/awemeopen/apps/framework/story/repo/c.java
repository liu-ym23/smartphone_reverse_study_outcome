package com.bytedance.awemeopen.apps.framework.story.repo;

import com.bytedance.awemeopen.domain.base.repo.ConstantsKt;
import com.bytedance.awemeopen.domain.base.repo.GsonHolder;
import com.bytedance.awemeopen.domain.base.repo.e;
import com.bytedance.awemeopen.infra.base.net.AoNet;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f197647a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f197648b = null;

    static {
        String r100 = ConstantsKt.a();
        f197647a = r100 + "/aweme/open/export_sdk/user_item_list";
        f197648b = r100 + "/aweme/open/export_sdk/item/seen";
    }

    public static e a(Long r100, String r101, long r102, long r103, boolean r110) {
        Intrinsics.checkNotNullParameter(r101, "userOpenId");
        d r104 = null;
        LinkedHashMap r105 = new LinkedHashMap();     // Catch: Throwable -> L21
        if (r110 == false) goto L6;
        String r111 = "1";
    L7:
        r105.put("need_live", r111);     // Catch: Throwable -> L21
        if (r100 == null) goto L10;
        r100.longValue();     // Catch: Throwable -> L21
        r105.put("room_id", r100);     // Catch: Throwable -> L21
    L10:
        r105.put("user_open_id", r101);     // Catch: Throwable -> L21
        r105.put("count", Long.valueOf(r102));     // Catch: Throwable -> L21
        r105.put(EffectConfiguration.KEY_CURSOR, Long.valueOf(r103));     // Catch: Throwable -> L21
        int r106 = com.bytedance.awemeopen.domain.base.repo.b.f198240b;     // Catch: Throwable -> L21
        Pair r107 = AoNet.c(com.bytedance.awemeopen.domain.base.repo.b.a.a(f197647a, r105));     // Catch: Throwable -> L21
        CharSequence r108 = (CharSequence) r107.getFirst();     // Catch: Throwable -> L21
        if (r108 != null) goto L13;
    L16:
        boolean r109 = true;
    L17:
        if (r109 == true) goto L19;
        Exception r112 = null;
        r104 = (d) GsonHolder.a().fromJson((String) r107.getFirst(), d.class);     // Catch: Throwable -> L21
    L24:
        return new e(r104, r112);
    L19:
        r112 = new Exception("fetchFeed but got empty body result, logid = " + ((String) r107.getSecond()));     // Catch: Throwable -> L21
        goto L24
    L13:
        if (r108.length() == 0) goto L16;
        r109 = false;
        goto L17
    L6:
        r111 = "0";
    L21:
        th = move-exception;
        r112 = new Exception(th);
        goto L24
    }
}
