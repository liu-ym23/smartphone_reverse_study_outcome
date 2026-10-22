package com.bytedance.ee.bear.docshost;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j implements k {
    public j() {
    }

    @Override // com.bytedance.ee.bear.docshost.k
    public final boolean c() {
        l r0 = new l();
        Intrinsics.checkNotNullParameter("REMOVE_ORG", "featureKey");
        Map<LoginIdentifyService$LoginIdentify, Object> r1 = r0.b.get("REMOVE_ORG");
        Object r2 = null;
        if (r1 == null) goto L5;
        Object r3 = r1.get(r0.a);
    L6:
        if (r3 == null) goto L10;
        r2 = r3;
    L10:
        return ((Boolean) r2).booleanValue();
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.docshost.k
    public final void d(String r3) {
        b(r3, true, null);
    }

    @Override // com.bytedance.ee.bear.docshost.k
    public final Disposable e(String r2, CharSequence r3) {
        return a(r2, r3, false);
    }

    @Override // com.bytedance.ee.bear.docshost.k
    public final Disposable a(final String r3, final CharSequence r4, final boolean r5) {
        return Flowable.just("").subscribeOn(fo5.d.b()).map(new f()).map(new g(r4, r3, r5)).subscribe(new h(), new i());
    }

    @Override // com.bytedance.ee.bear.docshost.k
    public final void b(String r6, boolean r7, Bundle r8) {
        final Uri r0 = UriProtector.parse(r6);
        if (r0.isHierarchical() == false) goto L12;
        Uri.Builder r9 = new Uri.Builder().scheme(r0.getScheme()).authority(r0.getAuthority()).path(r0.getPath()).fragment(r0.getEncodedFragment());
        Iterator r1 = UriProtector.getQueryParameterNames(r0).iterator();
    L6:
        if (r1.hasNext() == false) goto L11;
        String r2 = (String) r1.next();
        if (r7 == true) goto L9;
        r9.appendQueryParameter(r2, UriProtector.getQueryParameter(r0, r2));
        goto L6
    L9:
        r9.appendQueryParameter(r2, Uri.encode(UriProtector.getQueryParameter(r0, r2)));
        goto L6
    L11:
        r6 = r9.build().toString();
    L12:
        boolean r3 = false;
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.mobile.open_external_link_without_scheme") == true) goto L28;
        ArrayList<String> r10 = ((DocxUrlUnAddSchemeListConfig) com.bytedance.ee.bear.appsetting.c.a.a.c(DocxUrlUnAddSchemeListConfig.GET_APP_SCHEME_KEY, DocxUrlUnAddSchemeListConfig.class, new DocxUrlUnAddSchemeListConfig())).unAddSchemeList;
        if (r10 != null) goto L19;
        r10 = new ArrayList();
    L19:
        if (TextUtils.isEmpty(r0.getScheme()) == true) goto L27;
        int r4 = 0;
    L22:
        if (r4 >= r10.size()) goto L27;
        if (TextUtils.equals(r0.getScheme(), (CharSequence) ListProtector.get(r10, r4)) == true) goto L28;
        r4 = r4 + 1;
    L27:
        r3 = true;
    L28:
        if (r3 == false) goto L30;
        r0 = new Uri.Builder().scheme("lark").authority("client").path("/web").appendQueryParameter("url", r6).build();
    L30:
        final HashMap r11 = new HashMap();
        if (r8 == null) goto L38;
        Iterator<String> r12 = r8.keySet().iterator();
    L34:
        if (r12.hasNext() == false) goto L38;
        String r5 = r12.next();
        Object r13 = r8.get(r5);
        if (r13 == null) goto L34;
        r11.put(r5, r13.toString());
    L38:
        Flowable.just("").subscribeOn(fo5.d.b()).map(new b()).map(new c(r0, r11)).subscribe(new d(), new e());
    }
}
