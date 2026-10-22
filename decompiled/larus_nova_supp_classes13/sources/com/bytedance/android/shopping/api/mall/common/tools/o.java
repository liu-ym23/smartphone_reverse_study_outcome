package com.bytedance.android.shopping.api.mall.common.tools;

import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.model.LocalPackageModel;
import com.bytedance.geckox.model.UpdatePackage;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public class o extends GeckoUpdateListener {
    public final String a;
    public final String b;

    public void a() {
        throw null;
    }

    public void b() {
        throw null;
    }

    public final void onLocalNewestVersion(LocalPackageModel r2) {
        super.onLocalNewestVersion(r2);
        Logger.d("puffone-GeckoUpdateWrapperListener.onLocalNewestVersion()", "");
        b();
    }

    public o(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "ak");
        Intrinsics.checkNotNullParameter(r3, "channel");
        this.a = r2;
        this.b = r3;
    }

    public final void onCheckServerVersionFail(Map<String, List<Pair<String, Long>>> r1, Throwable r2) {
        super.onCheckServerVersionFail(r1, r2);
        Logger.d("puffone-GeckoUpdateWrapperListener.onCheckServerVersionFail()", "");
        a();
    }

    public final void onCheckServerVersionSuccess(Map<String, List<Pair<String, Long>>> r5, Map<String, List<UpdatePackage>> r6) {
        super.onCheckServerVersionSuccess(r5, r6);
        Object r0 = null;
        if (r5 == null) goto L14;
        List<Pair<String, Long>> r7 = r5.get(this.a);
        if (r7 == null) goto L14;
        Iterator<T> r8 = r7.iterator();
    L8:
        if (r8.hasNext() == false) goto L12;
        Object r1 = r8.next();
        if (Intrinsics.areEqual((String) ((Pair) r1).first, this.b) == false) goto L8;
    L13:
        Pair r2 = (Pair) r1;
    L15:
        if (r6 == null) goto L25;
        List<UpdatePackage> r9 = r6.get(this.a);
        if (r9 == null) goto L25;
        Iterator<T> r10 = r9.iterator();
    L20:
        if (r10.hasNext() == false) goto L24;
        Object r11 = r10.next();
        if (Intrinsics.areEqual(((UpdatePackage) r11).getChannel(), this.b) == false) goto L20;
        r0 = r11;
    L24:
        r0 = (UpdatePackage) r0;
    L25:
        if (r2 != null) goto L35;
        if (r0 != null) goto L36;
        Logger.d("puffone-GeckoUpdateWrapperListener.onCheckServerVersionSuccess()", "");
        a();
        return;
    L36:
        return;
    L35:
        return;
    L12:
        r1 = null;
    L14:
        r2 = null;
        goto L15
    }

    public final void onUpdateFailed(UpdatePackage r1, Throwable r2) {
        super.onUpdateFailed(r1, r2);
        Logger.d("puffone-GeckoUpdateWrapperListener.onUpdateFailed()", "");
        a();
    }

    public final void onUpdateSuccess(UpdatePackage r1, long r2) {
        super.onUpdateSuccess(r1, r2);
        Logger.d("puffone-GeckoUpdateWrapperListener.onUpdateSuccess()", "");
        b();
    }

    public final void onCheckRequestIntercept(int r1, Map<String, List<Pair<String, Long>>> r2, Throwable r3) {
        super.onCheckRequestIntercept(r1, r2, r3);
        Logger.d("puffone-GeckoUpdateWrapperListener.onCheckRequestIntercept()", "");
        a();
    }
}
