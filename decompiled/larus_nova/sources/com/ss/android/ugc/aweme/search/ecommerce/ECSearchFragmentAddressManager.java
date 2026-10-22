package com.ss.android.ugc.aweme.search.ecommerce;

import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAddressService;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService;
import com.ss.android.ugc.aweme.search.service.TradeSearch;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/ecommerce/ECSearchFragmentAddressManager;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchFragmentAddressManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, String> f452766a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f452767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ECSearchFragmentAddressManager f452768c = null;

    private ECSearchFragmentAddressManager() {
    }

    static {
        f452768c = new ECSearchFragmentAddressManager();
        f452766a = new LinkedHashMap();
        f452767b = -1;
    }

    public final void b(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        int r101 = r100.hashCode();
        f452767b = r101;
        Map<Integer, String> r102 = f452766a;
        LinkedHashMap r103 = (LinkedHashMap) r102;
        CharSequence r104 = (CharSequence) r103.get(Integer.valueOf(r101));
        if (r104 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        Unit r106 = null;
        if (r105 == false) goto L12;
        r102.put(Integer.valueOf(f452767b), a(this, r100, null, 2));
        return;
    L12:
        String r107 = (String) r103.get(Integer.valueOf(f452767b));
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L22
        if (r107 == null) goto L20;
        ITradeSearchHostService r109 = TradeSearch.c(TradeSearch.f453393a);     // Catch: Throwable -> L22
        if (r109 == null) goto L20;
        ITradeSearchAddressService r110 = r109.getITradeSearchAddressService();     // Catch: Throwable -> L22
        if (r110 == null) goto L20;
        r110.setAddress(new JSONObject(r107), 1, false, false);     // Catch: Throwable -> L22
        r106 = Unit.INSTANCE;     // Catch: Throwable -> L22
    L20:
        Result.m9449constructorimpl(r106);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L5:
        if (r104.length() == 0) goto L8;
        r105 = false;
        goto L9
    }

    public static String a(ECSearchFragmentAddressManager r100, Object r101, String r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        String r104 = null;
    L12:
        r100.getClass();
        ITradeSearchHostService r105 = TradeSearch.c(TradeSearch.f453393a);
        if (r105 == null) goto L18;
        ITradeSearchAddressService r106 = r105.getITradeSearchAddressService();
        if (r106 != null) goto L17;
        return null;
    L17:
        return r106.getAddress(r101, r102, r104);
    L18:
        return null;
    L11:
        r104 = "xiaodian.supermarket_pop";
        goto L12
    }
}
