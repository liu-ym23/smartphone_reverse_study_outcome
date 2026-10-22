package com.ss.android.ugc.aweme.search.dynamic.core.ability;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/dynamic/core/ability/SearchAbilityManager;", "", "<init>", "()V", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final class SearchAbilityManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SearchAbilityManager f452655a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, ISearchDynamicAbility.IFactory> f452656b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, ISearchDynamicAbility.IFactory> f452657c = null;

    private SearchAbilityManager() {
    }

    static {
        f452655a = new SearchAbilityManager();
        f452656b = new LinkedHashMap();
        f452657c = new LinkedHashMap();
        Iterator r100 = ServiceManager.get().getServices(ISearchDynamicAbility.IFactory.class, true).iterator();
    L4:
        if (r100.hasNext() == false) goto L13;
        ISearchDynamicAbility.IFactory r101 = (ISearchDynamicAbility.IFactory) r100.next();
        String r102 = r101.getName();
        Map<String, ISearchDynamicAbility.IFactory> r103 = f452656b;
        if (r103.containsKey(r102) == true) goto L12;
        if (r101.getScope() != 0) goto L10;
        f452657c.put(r102, r101);
    L10:
        r103.put(r102, r101);
        goto L4
    L12:
        throw new IllegalArgumentException("multi ability name!: " + r102);
    }

    public static void a(Set r100, Set r101, SearchAbilityDispatcher r102) {
        Intrinsics.checkNotNullParameter(r100, "optionalAbilityList");
        Intrinsics.checkNotNullParameter(r101, "basicAbilityBlackList");
        Intrinsics.checkNotNullParameter(r102, "owner");
        Iterator r103 = ((LinkedHashMap) f452657c).entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Map.Entry r104 = (Map.Entry) r103.next();
        if (r101.contains(r104.getKey()) == true) goto L4;
        r102.n(((ISearchDynamicAbility.IFactory) r104.getValue()).create());
        goto L4
    L8:
        Iterator r105 = r100.iterator();
    L10:
        if (r105.hasNext() == false) goto L22;
        String r106 = (String) r105.next();
        ISearchDynamicAbility.IFactory r107 = (ISearchDynamicAbility.IFactory) ((LinkedHashMap) f452656b).get(r106);
        if (r107 != null) goto L14;
    L16:
        boolean r108 = false;
    L17:
        if (r108 == true) goto L10;
        if (r107 == null) goto L20;
        ISearchDynamicAbility r109 = r107.create();
    L21:
        r102.n(r109);
        goto L10
    L20:
        r109 = null;
        goto L21
    L14:
        if (r107.getScope() != 0) goto L16;
        r108 = true;
        goto L17
    }
}
