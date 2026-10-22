package com.larus.bmhome.chat.auth;

import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.chat.auth.model.PluginItem;
import com.larus.bmhome.chat.auth.model.PluginItemData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes25.dex */
public final class PluginItemPagingCache {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f297284g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f297285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function5<String, Integer, Integer, DowngradeSource, Continuation<? super PluginItemData>, Object> f297286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f297287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArrayList<PluginItem> f297288d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f297289e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f297290f;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PluginItemPagingCache(String r100, Function5<? super String, ? super Integer, ? super Integer, ? super DowngradeSource, ? super Continuation<? super PluginItemData>, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        Intrinsics.checkNotNullParameter(r101, "requestPluginList");
        this.f297285a = r100;
        this.f297286b = r101;
        this.f297288d = new CopyOnWriteArrayList();
    }

    public final Object b(DowngradeSource r100, Continuation<? super Unit> r110) {
        if ((r110 instanceof PluginItemPagingCache$updateFirstPage$1) == false) goto L7;
        PluginItemPagingCache$updateFirstPage$1 r101 = (PluginItemPagingCache$updateFirstPage$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        PluginItemPagingCache$updateFirstPage$1 r103 = r101;
        Object r111 = r103.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L17:
        PluginItemData r112 = (PluginItemData) r111;
        if (r112 == null) goto L22;
        Integer r106 = r112.total;
        if (r106 == null) goto L22;
        this.f297287c = r106.intValue();
    L22:
        if (r112 == null) goto L48;
        List<PluginItem> r107 = r112.items;
        if (r107 == null) goto L48;
        Iterator<T> r108 = r107.iterator();
    L27:
        if (r108.hasNext() == false) goto L48;
        PluginItem r113 = (PluginItem) r108.next();
        if (r113 == null) goto L27;
        Iterator<T> r109 = this.f297288d.iterator();
    L32:
        if (r109.hasNext() == false) goto L36;
        Object r114 = r109.next();
        if (Intrinsics.areEqual(((PluginItem) r114).pluginId, r113.pluginId) == false) goto L32;
    L37:
        PluginItem r115 = (PluginItem) r114;
        if (r115 != null) goto L39;
        Boxing.boxBoolean(this.f297288d.add(r113));
        goto L27
    L39:
        int r116 = this.f297288d.indexOf(r115);
        boolean r117 = false;
        if (r116 >= 0) goto L42;
    L44:
        if (r117 == false) goto L27;
        this.f297288d.set(r116, r113);
        goto L27
    L42:
        if (r116 >= this.f297288d.size()) goto L44;
        r117 = true;
        goto L44
    L36:
        r114 = null;
    L48:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        Function5<String, Integer, Integer, DowngradeSource, Continuation<? super PluginItemData>, Object> r118 = this.f297286b;
        String r119 = this.f297285a;
        Integer r120 = Boxing.boxInt(1);
        Integer r121 = Boxing.boxInt(20);
        r103.label = 1;
        r111 = r118.invoke(r119, r120, r121, r100, r103);
        if (r111 != r104) goto L17;
        return r104;
    L7:
        r101 = new PluginItemPagingCache$updateFirstPage$1(this, r110);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(boolean r110, DowngradeSource r111, Continuation<? super List<PluginItem>> r112) {
        if ((r112 instanceof PluginItemPagingCache$requestNextPage$1) == false) goto L7;
        PluginItemPagingCache$requestNextPage$1 r100 = (PluginItemPagingCache$requestNextPage$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        PluginItemPagingCache$requestNextPage$1 r102 = r100;
        Object r113 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        ResultKt.throwOnFailure(r113);
    L39:
        PluginItemData r114 = (PluginItemData) r113;
        if (r114 == null) goto L44;
        Integer r115 = r114.total;
        if (r115 == null) goto L44;
        this.f297287c = r115.intValue();
    L44:
        if (r114 == null) goto L53;
        List<PluginItem> r116 = r114.items;
        if (r116 == null) goto L53;
        Iterator<T> r117 = r116.iterator();
    L49:
        if (r117.hasNext() == false) goto L53;
        PluginItem r118 = (PluginItem) r117.next();
        if (r118 == null) goto L49;
        this.f297288d.add(r118);
    L53:
        CopyOnWriteArrayList<PluginItem> r119 = this.f297288d;
        ArrayList r120 = new ArrayList();
        Iterator<PluginItem> r121 = r119.iterator();
    L55:
        if (r121.hasNext() == false) goto L62;
        PluginItem r122 = r121.next();
        if (r122 == null) goto L59;
        boolean r105 = true;
    L60:
        if (r105 == false) goto L55;
        r120.add(r122);
        goto L55
    L59:
        r105 = false;
        goto L60
    L62:
        HashSet r123 = new HashSet();
        ArrayList r124 = new ArrayList();
        Iterator r125 = r120.iterator();
    L64:
        if (r125.hasNext() == false) goto L69;
        Object r106 = r125.next();
        if (r123.add(((PluginItem) r106).pluginId) == false) goto L64;
        r124.add(r106);
        goto L64
    L69:
        if (r124.size() >= this.f297288d.size()) goto L71;
        this.f297288d.clear();
        this.f297288d.addAll(r124);
    L71:
        this.f297290f = false;
        return r124;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        boolean r126 = r102.Z$0;
        r111 = (DowngradeSource) r102.L$0;
        ResultKt.throwOnFailure(r113);
        int r127 = r126;
    L25:
        DowngradeSource r107 = r111;
        if ((!this.f297288d.isEmpty()) == false) goto L34;
        if (this.f297288d.size() != this.f297287c) goto L34;
        if (RangesKt.coerceAtLeast(this.f297289e, r127) <= 0) goto L34;
        this.f297290f = false;
        return this.f297288d;
    L34:
        if (this.f297288d.isEmpty() == false) goto L36;
        this.f297289e = 0;
    L36:
        int r128 = this.f297289e + 1;
        this.f297289e = r128;
        Function5<String, Integer, Integer, DowngradeSource, Continuation<? super PluginItemData>, Object> r108 = this.f297286b;
        String r129 = this.f297285a;
        Integer r109 = Boxing.boxInt(r128);
        Integer r130 = Boxing.boxInt(20);
        r102.L$0 = null;
        r102.label = 2;
        r113 = r108.invoke(r129, r109, r130, r107, r102);
        if (r113 != r103) goto L39;
        return r103;
    L16:
        ResultKt.throwOnFailure(r113);
        if (this.f297290f == true) goto L19;
        this.f297290f = true;
        r127 = r110;
        if (r110 == false) goto L25;
        r102.L$0 = r111;
        r102.Z$0 = r110;
        r102.label = 1;
        r127 = r110;
        if (b(r111, r102) != r103) goto L25;
        return r103;
    L19:
        return this.f297288d;
    L7:
        r100 = new PluginItemPagingCache$requestNextPage$1(this, r112);
        goto L8
    }
}
