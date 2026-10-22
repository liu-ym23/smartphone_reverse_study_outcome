package com.bytedance.awemeopen.domain.feed.preload;

import com.bytedance.awemeopen.domain.feed.preload.aweme.AosAwemeRequesterImpl;
import com.bytedance.awemeopen.domain.feed.preload.aweme.e;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import r14.c;

/* JADX INFO: loaded from: classes44.dex */
public final class a {
    public a() {
    }

    public static void a(final String r110, final String r111, final String r112, final String r113, final String r114, final String r115, final String r210, final String r211, final String r212, final AosPreloadCacheStrategy r213, final boolean r214, final Function1 r215) {
        Intrinsics.checkNotNullParameter(r213, "cacheStragy");
        Intrinsics.checkNotNullParameter(r215, "callBack");
        AosAwemeRequesterImpl r100 = RecFeedCacheDataHelper.f198325a;
        Intrinsics.checkNotNullParameter(r213, "cacheStragy");
        Intrinsics.checkNotNullParameter(r215, "callBack");
        final Function1<List<c>, Unit> r116 = new RecFeedCacheDataHelper$packageCacheData$callBackWrap$1(r215);
        boolean r101 = false;
        if (r110 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L32;
        if (r114 != null) goto L12;
    L15:
        boolean r103 = true;
    L16:
        if (r103 == false) goto L32;
        if (r112 != null) goto L19;
    L22:
        boolean r104 = true;
    L23:
        if (r104 == false) goto L32;
        if (r113 != null) goto L26;
    L29:
        boolean r105 = true;
    L30:
        if (r105 == false) goto L32;
        RecFeedCacheDataHelper.c(r110, r111, r212, r213, r214, r116);
        return;
    L26:
        if (r113.length() == 0) goto L29;
        r105 = false;
        goto L30
    L19:
        if (r112.length() == 0) goto L22;
        r104 = false;
        goto L23
    L12:
        if (r114.length() == 0) goto L15;
        r103 = false;
    L32:
        if (r112 != null) goto L34;
    L37:
        boolean r106 = true;
    L38:
        if (r106 == false) goto L47;
        if (r110 != null) goto L41;
    L42:
        r101 = true;
    L43:
        if (r101 == true) goto L47;
        if (com.bytedance.awemeopen.domain.feed.preload.aweme.c.f198342a.containsKey(r110) == false) goto L47;
        RecFeedCacheDataHelper.c("", r111, r212, r213, r214, r116);
        return;
    L41:
        if (r110.length() != 0) goto L43;
    L47:
        w34.a<c> r107 = e.f198344f.a(r110);
        if (r107 != null) goto L50;
    L52:
        AoPool.a(new RecFeedCacheDataHelper$packageCacheData$1(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214, r116));
        return;
    L50:
        if (r107.a() == false) goto L52;
        RecFeedCacheDataHelper.b(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214, r116);
        return;
    L34:
        if (r112.length() == 0) goto L37;
        r106 = false;
        goto L38
    L5:
        if (r110.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
