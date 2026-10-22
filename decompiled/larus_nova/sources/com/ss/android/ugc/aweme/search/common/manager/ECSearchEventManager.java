package com.ss.android.ugc.aweme.search.common.manager;

import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import com.ss.android.ugc.aweme.search.common.IECSearchEventListener;
import com.ss.android.ugc.aweme.search.common.viewpager.IECSearchBaseFragment;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/manager/ECSearchEventManager;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchEventManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, JsEventSubscriber> f451715a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Integer, IECSearchBaseFragment> f451716b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<IECSearchBaseFragment, List<IECSearchEventListener>> f451717c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f451718d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ECSearchEventManager f451719e = null;

    private ECSearchEventManager() {
    }

    static {
        f451719e = new ECSearchEventManager();
        f451715a = new LinkedHashMap();
        f451716b = new LinkedHashMap();
        f451717c = new LinkedHashMap();
        f451718d = -1;
    }
}
