package com.ss.android.ugc.aweme.discover.commodity.marketing.service;

import androidx.fragment.app.Fragment;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/marketing/service/ECSearchMarketingRitManager;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchMarketingRitManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, ECSearchMarketingService> f450348a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedList<Integer> f450349b = null;

    private ECSearchMarketingRitManager() {
    }

    static {
        new ECSearchMarketingRitManager();
        f450348a = new LinkedHashMap();
        f450349b = new LinkedList();
    }

    @JvmStatic
    public static final ECSearchMarketingService c() {
        Integer r100 = f450349b.peekLast();
        if (r100 == null) goto L5;
        int r101 = r100.intValue();
    L6:
        Logger.a("TAG", "current top hash code key: " + r101);
        Logger.a("MarketingRitManager", "get top manager instance from instanceMap, getTopInstanceKey hashCode: " + r101);
        return (ECSearchMarketingService) ((LinkedHashMap) f450348a).get(Integer.valueOf(r101));
    L5:
        r101 = 0;
        goto L6
    }

    @JvmStatic
    public static final void a(Fragment r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Logger.a("MarketingRitManager", "add manager instance to instanceMap, hashCode: " + r100.hashCode());
        f450348a.put(Integer.valueOf(r100.hashCode()), new ECSearchMarketingServiceImpl());
        f450349b.addLast(Integer.valueOf(r100.hashCode()));
    }

    @JvmStatic
    public static final ECSearchMarketingService b(Fragment r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Logger.a("MarketingRitManager", "get manager instance from instanceMap, fragment: " + r100.hashCode());
        return (ECSearchMarketingService) ((LinkedHashMap) f450348a).get(Integer.valueOf(r100.hashCode()));
    }

    @JvmStatic
    public static final void d(Fragment r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Logger.a("MarketingRitManager", "remove manager instance from instanceMap: hashCode: " + r100.hashCode());
        ECSearchMarketingService r101 = f450348a.remove(Integer.valueOf(r100.hashCode()));
        if (r101 == null) goto L7;
        Logger.a("MarketingRitManager", "fragment instance found, remove success");
        r101.release();
    L8:
        LinkedList<Integer> r102 = f450349b;
        Integer r103 = r102.peekLast();
        int r104 = r100.hashCode();
        if (r103 != null) goto L12;
    L14:
        Logger.b("MarketingRitManager", "Error: stack error: stack last value (" + r102.peekLast() + " != fragment.hashcode (" + r100.hashCode());
        if (r102.contains(Integer.valueOf(r100.hashCode())) == false) goto L19;
        r102.remove(Integer.valueOf(r100.hashCode()));
        Logger.b("MarketingRitManager", "移除成功");
        return;
    L19:
        return;
    L12:
        if (r103.intValue() != r104) goto L14;
        Logger.a("MarketingRitManager", "hashcode key stack works correctly");
        r102.pollLast();
        return;
    L7:
        Logger.b("MarketingRitManager", "Error: fragment instance not found, check if something wrong");
        goto L8
    }
}
