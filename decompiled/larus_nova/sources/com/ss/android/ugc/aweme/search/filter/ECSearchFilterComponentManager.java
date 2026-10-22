package com.ss.android.ugc.aweme.search.filter;

import android.app.Application;
import android.widget.Toast;
import com.bytedance.ies.bullet.pool.util.PoolUtilKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.search.utils.ApplicationUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/ECSearchFilterComponentManager;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchFilterComponentManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, List<ECSearchBaseFilterViewHolder>> f452815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, List<ECSearchBaseFilterViewHolder>> f452816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f452817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f452818d;

    public final void a() {
        Iterator r100 = ((LinkedHashMap) this.f452815a).entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        Map.Entry r101 = (Map.Entry) r100.next();
        String r102 = (String) r101.getKey();
        Iterator r103 = ((List) r101.getValue()).iterator();
    L7:
        if (r103.hasNext() == false) goto L4;
        b(r102, (ECSearchBaseFilterViewHolder) r103.next());
        goto L7
    L9:
        ((LinkedHashMap) this.f452815a).clear();
    }

    public ECSearchFilterComponentManager() {
        this.f452815a = new LinkedHashMap();
        this.f452816b = new LinkedHashMap();
        this.f452817c = LazyKt.lazy(ECSearchFilterComponentManager$isTest$2.INSTANCE);
    }

    public final ECSearchBaseFilterViewHolder d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "componentName");
        if (((Boolean) this.f452817c.getValue()).booleanValue() == true) goto L5;
    L10:
        List r101 = (List) ((LinkedHashMap) this.f452816b).get(r100);
        if (r101 != null) goto L13;
    L15:
        return null;
    L13:
        if (r101.size() <= 0) goto L15;
        return (ECSearchBaseFilterViewHolder) ListProtector.remove(r101, 0);
    L5:
        if (this.f452818d == true) goto L10;
        this.f452818d = true;
        ApplicationUtil.f453396a.getClass();     // Catch: Exception -> L9
        Toast.makeText((Application) ApplicationUtil.f453397b.getValue(), "使用筛选复用池", 0).show();     // Catch: Exception -> L9
        goto L10
    }

    public final void b(String r100, ECSearchBaseFilterViewHolder r101) {
        Intrinsics.checkNotNullParameter(r100, "componentName");
        if (r101 != null) goto L5;
        return;
    L5:
        List<ECSearchBaseFilterViewHolder> r102 = (List) ((LinkedHashMap) this.f452816b).get(r100);
        if (r102 != null) goto L9;
        r102 = new ArrayList();
        this.f452816b.put(r100, r102);
    L9:
        if (r102.contains(r101) == true) goto L12;
        PoolUtilKt.a(r101.f452782j);
        r101.o();
        r102.add(r101);
        return;
    }

    public final void c(String r100, ECSearchBaseFilterViewHolder r101) {
        Intrinsics.checkNotNullParameter(r100, "componentName");
        if (r101 != null) goto L5;
        return;
    L5:
        List<ECSearchBaseFilterViewHolder> r102 = (List) ((LinkedHashMap) this.f452815a).get(r100);
        if (r102 != null) goto L8;
        r102 = new ArrayList();
        this.f452815a.put(r100, r102);
    L8:
        r102.add(r101);
    }

    public final ECSearchBaseFilterViewHolder e(String r100, ECSearchBaseFilterViewHolder r101) {
        Intrinsics.checkNotNullParameter(r100, "componentName");
        if (r101 == null) goto L12;
        List r102 = (List) ((LinkedHashMap) this.f452815a).get(r100);
        if (r102 != null) goto L7;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == false) goto L14;
        return r101;
    L14:
        return null;
    L7:
        if (r102.contains(r101) == false) goto L9;
        r103 = r102.remove(r101);
        goto L10
    L12:
        return null;
    }
}
