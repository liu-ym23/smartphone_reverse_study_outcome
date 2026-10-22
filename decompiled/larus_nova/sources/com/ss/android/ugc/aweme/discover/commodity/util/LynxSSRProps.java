package com.ss.android.ugc.aweme.discover.commodity.util;

import android.content.Context;
import com.bytedance.common.utility.UIUtils;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchPadSplitService;
import com.ss.android.ugc.aweme.search.service.TradeSearch;
import com.ss.android.ugc.aweme.search.utils.extensions.DimenExtensionsKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/util/LynxSSRProps;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxSSRProps {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JSONObject f450369a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LynxSSRProps f450370b = null;

    private LynxSSRProps() {
    }

    static {
        f450370b = new LynxSSRProps();
        JSONObject r100 = new JSONObject();
        f450369a = r100;
        ITradeSearchHostService r101 = TradeSearch.c(TradeSearch.f453393a);
        if (r101 == null) goto L7;
        ITradeSearchHostAppInfo r102 = r101.getITradeSearchHostAppInfo();
        if (r102 == null) goto L7;
        Context r103 = r102.getApplicationContext();
    L8:
        boolean r104 = false;
        ITradeSearchHostService r105 = TradeSearch.b(0);
        if (r105 == null) goto L22;
        ITradeSearchPadSplitService r106 = r105.getITradeSearchPadSplitService();
        if (r106 == null) goto L22;
        r104 = r106.isPad();
    L22:
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L19
        if (r104 == false) goto L16;
        String r108 = "android_pad";
    L17:
        r100.put("devicePlatform", r108);     // Catch: Throwable -> L19
        r100.put("screenWidth", UIUtils.px2dip(r103, UIUtils.getScreenWidth(r103)));     // Catch: Throwable -> L19
        Result.m9449constructorimpl(r100.put("screenHeight", UIUtils.px2dip(r103, UIUtils.getScreenHeight(r103))));     // Catch: Throwable -> L19
        return;
    L16:
        r108 = "android";
    L19:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L7:
        r103 = null;
        goto L8
    }

    public static void b(List r100) {
        Intrinsics.checkNotNullParameter(r100, "keys");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        Iterator r102 = r100.iterator();     // Catch: Throwable -> L9
    L5:
        if (r102.hasNext() == false) goto L7;
        String r103 = (String) r102.next();     // Catch: Throwable -> L9
        f450369a.remove(r103);     // Catch: Throwable -> L9
        goto L5
    L7:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static String a(LynxSSRProps r100, boolean r101, int r102, int r103, int r104, int r105, boolean r110, int r111, Map r112, int r113) {
        if ((r113 & 1) == 0) goto L6;
        r101 = false;
    L6:
        if ((r113 & 2) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r113 & 4) == 0) goto L12;
        r103 = -1;
    L12:
        if ((r113 & 8) == 0) goto L15;
        r104 = -1;
    L15:
        if ((r113 & 16) == 0) goto L18;
        r105 = -1;
    L18:
        if ((r113 & 32) == 0) goto L21;
        r110 = false;
    L21:
        if ((r113 & 64) == 0) goto L23;
        r111 = -1;
    L23:
        Context r106 = null;
        if ((r113 & 128) == 0) goto L26;
        r112 = null;
    L26:
        r100.getClass();
        ITradeSearchHostService r107 = TradeSearch.c(TradeSearch.f453393a);
        if (r107 == null) goto L32;
        ITradeSearchHostAppInfo r108 = r107.getITradeSearchHostAppInfo();
        if (r108 == null) goto L32;
        Object r109 = r108.getCurrentFontScale();
        if (r109 == null) goto L32;
    L33:
        JSONObject r114 = f450369a;
        r114.put("fontScale", r109);
        if (r101 == false) goto L36;
        r114.put("sidebarWidth", r102);
    L37:
        if (r103 <= 0) goto L39;
        r114.put("cardPaddingHybrid", r103);
    L39:
        if (r104 <= 0) goto L41;
        r114.put("cardPadding", r104);
    L41:
        if (r105 <= 0) goto L44;
        r114.put("cardRadius", r105);
    L44:
        if (r110 == false) goto L60;
        if (r111 > 0) goto L58;
        ITradeSearchHostService r115 = TradeSearch.b(0);
        if (r115 == null) goto L52;
        ITradeSearchPadSplitService r116 = r115.getITradeSearchPadSplitService();
        if (r116 == null) goto L52;
        Object r117 = DimenExtensionsKt.d(Integer.valueOf(r116.getSpiltWidth()));
        if (r117 == null) goto L52;
    L59:
        r114.put("screenWidth", r117);
    L66:
        if (r112 == null) goto L76;
        Intrinsics.checkNotNullParameter(r114, "<this>");
        Iterator r118 = r112.entrySet().iterator();
    L69:
        if (r118.hasNext() == false) goto L76;
        Map.Entry r119 = (Map.Entry) r118.next();
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L73
        Result.m9449constructorimpl(r114.put((String) r119.getKey(), r119.getValue()));     // Catch: Throwable -> L73
    L73:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L76:
        return f450369a.toString();
    L52:
        ITradeSearchHostService r122 = TradeSearch.b(0);
        if (r122 == null) goto L57;
        ITradeSearchHostAppInfo r123 = r122.getITradeSearchHostAppInfo();
        if (r123 == null) goto L57;
        r106 = r123.getApplicationContext();
    L57:
        r117 = DimenExtensionsKt.d(Integer.valueOf(UIUtils.getScreenWidth(r106)));
        goto L59
    L58:
        r117 = Integer.valueOf(r111);
        goto L59
    L60:
        ITradeSearchHostService r124 = TradeSearch.b(0);
        if (r124 == null) goto L65;
        ITradeSearchHostAppInfo r125 = r124.getITradeSearchHostAppInfo();
        if (r125 == null) goto L65;
        r106 = r125.getApplicationContext();
    L65:
        r114.put("screenWidth", DimenExtensionsKt.d(Integer.valueOf(UIUtils.getScreenWidth(r106))));
        goto L66
    L36:
        r114.put("sidebarWidth", 0);
    L32:
        r109 = Double.valueOf(1.0d);
        goto L33
    }
}
