package com.ss.android.ugc.aweme.discover.dynamic.gecko;

import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.model.LocalPackageModel;
import com.bytedance.geckox.model.UpdatePackage;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/dynamic/gecko/ECSearchGeckoUpdateWrapperListener;", "Lcom/bytedance/geckox/listener/GeckoUpdateListener;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECSearchGeckoUpdateWrapperListener extends GeckoUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f450454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f450455b;

    public void a() {
        throw null;
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onLocalNewestVersion(LocalPackageModel r100) {
        super.onLocalNewestVersion(r100);
        Logger.d("ec_search_puffone-GeckoUpdateWrapperListener.onLocalNewestVersion()", "");
    }

    public ECSearchGeckoUpdateWrapperListener(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "ak");
        Intrinsics.checkNotNullParameter(r101, "channel");
        this.f450454a = r100;
        this.f450455b = r101;
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onCheckServerVersionFail(Map<String, List<Pair<String, Long>>> r100, Throwable r101) {
        super.onCheckServerVersionFail(r100, r101);
        Logger.d("ec_search_puffone-GeckoUpdateWrapperListener.onCheckServerVersionFail()", "");
        a();
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onCheckServerVersionSuccess(Map<String, List<Pair<String, Long>>> r100, Map<String, List<UpdatePackage>> r101) {
        super.onCheckServerVersionSuccess(r100, r101);
        Object r102 = null;
        if (r100 == null) goto L14;
        List<Pair<String, Long>> r103 = r100.get(this.f450454a);
        if (r103 == null) goto L14;
        Iterator<T> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L12;
        Object r105 = r104.next();
        if (Intrinsics.areEqual((String) ((Pair) r105).first, this.f450455b) == false) goto L8;
    L13:
        Pair r106 = (Pair) r105;
    L15:
        if (r101 == null) goto L25;
        List<UpdatePackage> r107 = r101.get(this.f450454a);
        if (r107 == null) goto L25;
        Iterator<T> r108 = r107.iterator();
    L20:
        if (r108.hasNext() == false) goto L24;
        Object r109 = r108.next();
        if (Intrinsics.areEqual(((UpdatePackage) r109).getChannel(), this.f450455b) == false) goto L20;
        r102 = r109;
    L24:
        r102 = (UpdatePackage) r102;
    L25:
        if (r106 != null) goto L35;
        if (r102 != null) goto L36;
        Logger.d("ec_search_puffone-GeckoUpdateWrapperListener.onCheckServerVersionSuccess()", "");
        a();
        return;
    L36:
        return;
    L35:
        return;
    L12:
        r105 = null;
    L14:
        r106 = null;
        goto L15
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onUpdateFailed(UpdatePackage r100, Throwable r101) {
        super.onUpdateFailed(r100, r101);
        Logger.d("ec_search_puffone-GeckoUpdateWrapperListener.onUpdateFailed()", "");
        a();
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onUpdateSuccess(UpdatePackage r100, long r101) {
        super.onUpdateSuccess(r100, r101);
        Logger.d("ec_search_puffone-GeckoUpdateWrapperListener.onUpdateSuccess()", "");
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onCheckRequestIntercept(int r100, Map<String, List<Pair<String, Long>>> r101, Throwable r102) {
        super.onCheckRequestIntercept(r100, r101, r102);
        Logger.d("ec_search_puffone-GeckoUpdateWrapperListener.onCheckRequestIntercept()", "");
        a();
    }
}
