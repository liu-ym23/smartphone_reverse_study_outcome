package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.model.ECShopShareQrCodeInfo;
import com.google.gson.Gson;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f {
    public static final /* synthetic */ int c = 0;
    public ECShopShareQrCodeInfo a;
    public ECShopToolsInfo b;

    public static final class a {
        public static f a(ECShopBlockInfoDTO r5) {
            Intrinsics.checkNotNullParameter(r5, "response");
            Gson r0 = new Gson();
            f r1 = new f();
            Blcok r6 = r5.getBlock();
            if (r6 == null) goto L20;
            List<Module> r7 = r6.getModuleList();
            if (r7 == null) goto L20;
            Iterator<T> r8 = r7.iterator();
        L8:
            if (r8.hasNext() == false) goto L20;
            Module r2 = (Module) r8.next();
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L18
            String r4 = r2.getName();     // Catch: Throwable -> L18
            if (Intrinsics.areEqual(r4, ECShopModuleType.SHOP_SHARE_CARD_INFO.getType()) == false) goto L14;
            r1.a = (ECShopShareQrCodeInfo) r0.fromJson(r2.getData(), ECShopShareQrCodeInfo.class);     // Catch: Throwable -> L18
        L16:
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L18
            goto L8
        L14:
            if (Intrinsics.areEqual(r4, ECShopModuleType.SHOP_TOOLS_INFO.getType()) == false) goto L16;
            r1.b = (ECShopToolsInfo) r0.fromJson(r2.getData(), ECShopToolsInfo.class);     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            Result.Companion r9 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        L20:
            return r1;
        }
    }

    static {
    }

    public f() {
    }
}
