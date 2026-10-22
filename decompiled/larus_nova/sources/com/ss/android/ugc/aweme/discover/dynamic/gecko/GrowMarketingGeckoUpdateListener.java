package com.ss.android.ugc.aweme.discover.dynamic.gecko;

import android.util.Pair;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.model.LocalPackageModel;
import com.bytedance.geckox.model.UpdatePackage;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.ugc.aweme.search.common.utils.FormatExtensionKtKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/dynamic/gecko/GrowMarketingGeckoUpdateListener;", "Lcom/bytedance/geckox/listener/GeckoUpdateListener;", "", "c", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "type", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GrowMarketingGeckoUpdateListener extends GeckoUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f450465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f450466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f450467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f450468d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f450469e;

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onCheckServerVersionSuccess(Map<String, List<Pair<String, Long>>> r100, Map<String, List<UpdatePackage>> r101) {
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onClean(String r100) {
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onDownloadProgress(UpdatePackage r100, long r101, long r102) {
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onUpdateFailed(String r100, Throwable r101) {
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onUpdateFinish() {
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onUpdateSuccess(String r100, long r101) {
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onUpdating(String r100) {
    }

    public final String getType() {
        return this.f450467c;
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onActivateSuccess(UpdatePackage r100) {
        if (r100 == null) goto L5;
        String r101 = r100.getChannel();
        if (r101 == null) goto L5;
    L6:
        AppLogNewUtils.onEventV3("ecom_search_grow_marketing_offline_package_download_status", a(r101, CJPayConstant.CJ_PAY_CREDIT_PAY_ACTIVATE_STATUS_SUCCESS, ""));
        return;
    L5:
        r101 = "no_channel";
        goto L6
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onDownloadSuccess(UpdatePackage r100) {
        if (r100 == null) goto L5;
        String r101 = r100.getChannel();
        if (r101 == null) goto L5;
    L6:
        AppLogNewUtils.onEventV3("ecom_search_grow_marketing_offline_package_download_status", a(r101, "download_success", ""));
        return;
    L5:
        r101 = "no_channel";
        goto L6
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onLocalNewestVersion(LocalPackageModel r100) {
        if (r100 == null) goto L5;
        String r101 = r100.getChannel();
        if (r101 == null) goto L5;
    L6:
        AppLogNewUtils.onEventV3("ecom_search_grow_marketing_offline_package_download_status", a(r101, "is_newest_version", ""));
        return;
    L5:
        r101 = "no_channel";
        goto L6
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onUpdateStart(UpdatePackage r100) {
        if (r100 == null) goto L5;
        String r101 = r100.getChannel();
        if (r101 == null) goto L5;
    L6:
        AppLogNewUtils.onEventV3("ecom_search_grow_marketing_offline_package_download_status", a(r101, "start", ""));
        return;
    L5:
        r101 = "no_channel";
        goto L6
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onActivateFail(UpdatePackage r100, Throwable r101) {
        if (r100 == null) goto L5;
        String r102 = r100.getChannel();
        if (r102 == null) goto L5;
    L6:
        if (r101 == null) goto L9;
        String r103 = r101.getMessage();
        if (r103 == null) goto L9;
    L10:
        AppLogNewUtils.onEventV3("ecom_search_grow_marketing_offline_package_download_status", a(r102, "activate_fail", r103));
        return;
    L9:
        r103 = "";
    L5:
        r102 = "no_channel";
        goto L6
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onCheckServerVersionFail(Map<String, List<Pair<String, Long>>> r100, Throwable r101) {
        if (r100 == null) goto L8;
        List<Pair<String, Long>> r102 = r100.get(this.f450465a);
        if (r102 == null) goto L8;
        Pair r103 = (Pair) CollectionsKt.firstOrNull(r102);
        if (r103 == null) goto L8;
        String r104 = (String) r103.first;
    L9:
        String r105 = "";
        if (r104 != null) goto L13;
        r104 = "";
    L13:
        if (r104.length() <= 0) goto L15;
        boolean r106 = true;
    L16:
        if (r106 == false) goto L24;
        if (r101 == null) goto L22;
        String r107 = r101.getMessage();
        if (r107 == null) goto L22;
        r105 = r107;
    L22:
        AppLogNewUtils.onEventV3("ecom_search_grow_marketing_offline_package_download_status", a(r104, "network_interface", r105));
        return;
    L24:
        return;
    L15:
        r106 = false;
    L8:
        r104 = null;
        goto L9
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onDownloadFail(UpdatePackage r100, Throwable r101) {
        if (r100 == null) goto L5;
        String r102 = r100.getChannel();
        if (r102 == null) goto L5;
    L6:
        if (r101 == null) goto L9;
        String r103 = r101.getMessage();
        if (r103 == null) goto L9;
    L10:
        AppLogNewUtils.onEventV3("ecom_search_grow_marketing_offline_package_download_status", a(r102, "download_fail", r103));
        return;
    L9:
        r103 = "";
    L5:
        r102 = "no_channel";
        goto L6
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onUpdateFailed(UpdatePackage r100, Throwable r101) {
        if (r100 == null) goto L5;
        String r102 = r100.getChannel();
        if (r102 == null) goto L5;
    L6:
        if (r101 == null) goto L9;
        String r103 = r101.getMessage();
        if (r103 == null) goto L9;
    L10:
        AppLogNewUtils.onEventV3("ecom_search_grow_marketing_offline_package_download_status", a(r102, "update_fail", r103));
        return;
    L9:
        r103 = "";
    L5:
        r102 = "no_channel";
        goto L6
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onUpdateSuccess(UpdatePackage r100, long r101) {
        if (r100 == null) goto L5;
        String r102 = r100.getChannel();
        if (r102 == null) goto L5;
    L6:
        AppLogNewUtils.onEventV3("ecom_search_grow_marketing_offline_package_download_status", a(r102, "update_success", ""));
        return;
    L5:
        r102 = "no_channel";
        goto L6
    }

    public final JSONObject a(String r100, String r101, String r102) {
        kotlin.Pair[] r103 = new kotlin.Pair[9];
        r103[0] = TuplesKt.to("fetch_when", this.f450466b);
        r103[1] = TuplesKt.to("ak", this.f450465a);
        r103[2] = TuplesKt.to(a.KEY_EVENT_ORIGIN_FEATURE, a.VALUE_TEMAI);
        r103[3] = TuplesKt.to("type", this.f450467c);
        r103[4] = TuplesKt.to("name", this.f450468d);
        if (this.f450469e == false) goto L5;
        String r104 = "1";
    L6:
        r103[5] = TuplesKt.to("is_delay_trigger", r104);
        r103[6] = TuplesKt.to("channel", r100);
        r103[7] = TuplesKt.to("status", r101);
        r103[8] = TuplesKt.to("message", r102);
        return FormatExtensionKtKt.a(MapsKt.mutableMapOf(r103));
    L5:
        r104 = "0";
        goto L6
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onCheckRequestIntercept(int r100, Map<String, List<Pair<String, Long>>> r101, Throwable r102) {
        if (r101 == null) goto L8;
        List<Pair<String, Long>> r103 = r101.get(this.f450465a);
        if (r103 == null) goto L8;
        Pair r104 = (Pair) CollectionsKt.firstOrNull(r103);
        if (r104 == null) goto L8;
        String r105 = (String) r104.first;
    L9:
        String r106 = "";
        if (r105 != null) goto L13;
        r105 = "";
    L13:
        if (r105.length() <= 0) goto L15;
        boolean r107 = true;
    L16:
        if (r107 == false) goto L24;
        if (r102 == null) goto L22;
        String r108 = r102.getMessage();
        if (r108 == null) goto L22;
        r106 = r108;
    L22:
        AppLogNewUtils.onEventV3("ecom_search_grow_marketing_offline_package_download_status", a(r105, "intercept", r106));
        return;
    L24:
        return;
    L15:
        r107 = false;
    L8:
        r105 = null;
        goto L9
    }

    public GrowMarketingGeckoUpdateListener(String r100, String r101, String r102, String r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "ak");
        Intrinsics.checkNotNullParameter(r101, "fetchWhen");
        Intrinsics.checkNotNullParameter(r102, "type");
        Intrinsics.checkNotNullParameter(r103, "name");
        this.f450465a = r100;
        this.f450466b = r101;
        this.f450467c = r102;
        this.f450468d = r103;
        this.f450469e = r104;
    }
}
