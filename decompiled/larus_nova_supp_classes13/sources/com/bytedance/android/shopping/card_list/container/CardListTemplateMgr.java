package com.bytedance.android.shopping.card_list.container;

import android.content.Context;
import com.bytedance.android.ec.core.slice.ectag.ECTagTemplatePreload;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcGeckoTemplateMgr;
import com.bytedance.android.ecom.slice.ext.template.gecko.g;
import com.bytedance.android.ecom.slice.ext.template.gecko.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J4\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\tR\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/card_list/container/CardListTemplateMgr;", "", "Lcom/bytedance/android/ecom/slice/ext/template/gecko/g;", "getPreloadList", "Landroid/content/Context;", "context", "", "channel", "bizCode", "", "", "map", "", "preload", "templatePrefixUrl", "Ljava/lang/String;", "sliceTemplateList", "Ljava/util/Map;", "sliceTemplateChannel", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardListTemplateMgr {
    public static final CardListTemplateMgr INSTANCE = null;
    private static String bizCode = null;
    private static String sliceTemplateChannel = null;
    private static Map<String, Integer> sliceTemplateList = null;
    private static final String templatePrefixUrl = "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/";

    private CardListTemplateMgr() {
    }

    static {
        INSTANCE = new CardListTemplateMgr();
        bizCode = "";
        sliceTemplateChannel = "";
    }

    private final g getPreloadList() {
        ArrayList r0 = new ArrayList();
        Map<String, Integer> r1 = sliceTemplateList;
        if (r1 == null) goto L9;
        Iterator<Map.Entry<String, Integer>> r2 = r1.entrySet().iterator();
    L6:
        if (r2.hasNext() == false) goto L9;
        Map.Entry<String, Integer> r3 = r2.next();
        r0.add(new j(r3.getKey(), "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource//" + sliceTemplateChannel + '/' + r3.getKey() + "/main.json", r3.getValue().intValue()));
    L9:
        return new g(r0, 6);
    }

    public static final /* synthetic */ g access$getPreloadList(CardListTemplateMgr r0) {
        return r0.getPreloadList();
    }

    public final void preload(Context r2, String r3, String r4, Map<String, Integer> r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "channel");
        Intrinsics.checkNotNullParameter(r4, "bizCode");
        sliceTemplateList = r5;
        bizCode = r4;
        sliceTemplateChannel = r3;
        ECTagTemplatePreload.a(r2, false);
        SlcGeckoTemplateMgr.f(SlcGeckoTemplateMgr.l, bizCode, sliceTemplateChannel, wh.a.b(r2), AnonymousClass1.INSTANCE);
    }
}
