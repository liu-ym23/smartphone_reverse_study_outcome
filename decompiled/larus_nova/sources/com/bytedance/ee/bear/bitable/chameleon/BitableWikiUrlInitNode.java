package com.bytedance.ee.bear.bitable.chameleon;

import android.net.Uri;
import android.os.Bundle;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bitable.chameleon.render.cache.BitablePreloadLoader;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.Serializable;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import s45.p;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableWikiUrlInitNode implements bk5.b {

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bk5.a f209642a;

        public b(bk5.a r100) {
            this.f209642a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f209642a.w();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public BitableWikiUrlInitNode() {
    }

    public final String toString() {
        return "BitableWikiUrlInitNode";
    }

    @Override // bk5.b
    public final boolean b(BearUrl r100, bk5.e r101, bk5.a r102) {
        Intrinsics.checkNotNullParameter(r100, "bearUrl");
        Intrinsics.checkNotNullParameter(r101, "loaderTypeBefore");
        Intrinsics.checkNotNullParameter(r102, KtvSubElement.CONTAINER);
        return fx4.a.g(r100);
    }

    @Override // bk5.b
    public final Object a(BearUrl r100, bk5.e r101, bk5.a r110, Continuation<? super bk5.e> r111) {
        if ((r111 instanceof BitableWikiUrlInitNode$run$1) == false) goto L7;
        BitableWikiUrlInitNode$run$1 r102 = (BitableWikiUrlInitNode$run$1) r111;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r112 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        boolean r106 = true;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        r110 = (bk5.a) r102.L$2;
        r101 = (bk5.e) r102.L$1;
        r100 = (BearUrl) r102.L$0;
        ResultKt.throwOnFailure(r112);
    L21:
        j r113 = (j) r112;
        BitableSubType r107 = r113.f209653a;
        if (r107 == BitableSubType.BaseMain) goto L27;
        if (r107 == BitableSubType.BaseApp) goto L27;
        return r101;
    L27:
        if (r107 == BitableSubType.BaseApp) goto L31;
        r106 = false;
    L31:
        if (r106 == true) goto L33;
    L66:
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L54
        Object r109 = Result.m9449constructorimpl((bn4.a) org.koin.java.a.c(bn4.a.class, null, null, 6));     // Catch: Throwable -> L54
    L56:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r109);
        if (r114 != null) goto L64;
        bn4.a r115 = (bn4.a) r109;
        BitablePreloadLoader.f209683a.getClass();
        BitablePreloadLoader.d(r100, r113);
        Map<String, String> r116 = MapsKt.toMutableMap(r100.f222563d);
        if (r106 == false) goto L61;
        r115.c();
        r115.f();
        String r117 = r116.put("isbaseapp", "1");
    L62:
        String r118 = p.a().Fd(r100.f222564e, sbb.e.f541303n.getType(), r100.f222561b, r116);
        BearUrl r119 = p.a().Z(r118);
        r100.f222564e = r119.f222564e;
        r100.f222563d = r119.f222563d;
        Bundle r120 = r110.h9();
        r120.putString("url", r118);
        r120.putParcelable("bear_url", r100);
        tt5.a.h("BitableWikiUrlInitNode", "resolve Wiki Bitable URL, isBaseApp=" + r106);
        return r101;
    L61:
        r115.c();
        String r121 = r116.remove("isbaseapp");
        goto L62
    L64:
        tt5.a.e("BitableWikiUrlInitNode", "get Bitable App service failed", r114, false);
        return r101;
    L54:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L56
    L33:
        if (AppInfoUtils.f().booleanValue() == false) goto L66;
        String r123 = r100.f222564e;
        Result.Companion r124 = Result.Companion;     // Catch: Throwable -> L41
        Uri r125 = UriProtector.parse(r123);     // Catch: Throwable -> L41
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r125, "ccm_skip_officesdk_route"), "1") == false) goto L38;
        String r126 = r123;
    L39:
        Object r127 = Result.m9449constructorimpl(r126);     // Catch: Throwable -> L41
    L43:
        Throwable r128 = Result.m9452exceptionOrNullimpl(r127);
        if (r128 == null) goto L46;
        tt5.a.e("BitableWikiUrlInitNode", "build OfficeSDK web fallback URL failed", r128, false);
    L46:
        Object r129 = r123;
        if (Result.m9455isFailureimpl(r127) == true) goto L50;
        r129 = r127;
    L50:
        tt5.a.h("BitableWikiUrlInitNode", "fallback Wiki Base App to host web route");
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).u5((String) r129);
        com.bytedance.ee.util.ui.j.d(new b(r110), 500);
        return r101;
    L38:
        String r130 = r125.buildUpon().appendQueryParameter("ccm_skip_officesdk_route", "1").build().toString();     // Catch: Throwable -> L41
        Intrinsics.checkNotNull(r130);     // Catch: Throwable -> L41
        r126 = r130;
    L41:
        th = move-exception;
        Result.Companion r131 = Result.Companion;
        r127 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L43
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        Serializable r132 = r110.h9().getSerializable("wiki_info");
        if ((r132 instanceof WikiInfo) == false) goto L17;
        WikiInfo r133 = (WikiInfo) r132;
    L18:
        BitableWikiChecker r134 = BitableWikiChecker.f209632a;
        r102.L$0 = r100;
        r102.L$1 = r101;
        r102.L$2 = r110;
        r102.label = 1;
        r112 = r134.a(r100, r133, r102);
        if (r112 != r104) goto L21;
        return r104;
    L17:
        r133 = null;
    L7:
        r102 = new BitableWikiUrlInitNode$run$1(this, r111);
        goto L8
    }
}
