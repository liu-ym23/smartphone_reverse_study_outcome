package com.bytedance.badger;

import com.bytedance.badger.collect.impl.interfaces.INetworkApi;
import com.bytedance.badger.collect.impl.model.TTResponse;
import com.bytedance.badger.network.a0;
import com.bytedance.badger.network.b0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements INetworkApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BadgerCore f199209a;

    public u(BadgerCore r100) {
        this.f199209a = r100;
    }

    @Override // com.bytedance.badger.collect.impl.interfaces.INetworkApi
    public final TTResponse get(String r100, Map r101) {
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L12
        Iterator r103 = r101.entrySet().iterator();     // Catch: Throwable -> L12
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry r104 = (Map.Entry) r103.next();     // Catch: Throwable -> L12
        r102.add(new Pair(r104.getKey(), r104.getValue()));     // Catch: Throwable -> L12
        goto L4
    L6:
        b0 r105 = BadgerCore.access$getNetRequestInterface$p(this.f199209a).a(new a0(r100, r102, MapsKt.emptyMap()));     // Catch: Throwable -> L12
        HashMap r106 = new HashMap();     // Catch: Throwable -> L12
        Iterator<T> r107 = r105.f199084c.iterator();     // Catch: Throwable -> L12
    L8:
        if (r107.hasNext() == false) goto L10;
        Pair r108 = (Pair) r107.next();     // Catch: Throwable -> L12
        r106.put(r108.getFirst(), r108.getSecond());     // Catch: Throwable -> L12
        goto L8
    L10:
        return new TTResponse(r100, r105.f199083b, r106, r105.f199085d);
    L12:
        th = move-exception;
        return TTResponse.failed(th);
    }

    @Override // com.bytedance.badger.collect.impl.interfaces.INetworkApi
    public final TTResponse post(String r100, Map r101, Map r102) {
        ArrayList r103 = new ArrayList();     // Catch: Throwable -> L12
        Iterator r104 = r101.entrySet().iterator();     // Catch: Throwable -> L12
    L4:
        if (r104.hasNext() == false) goto L6;
        Map.Entry r105 = (Map.Entry) r104.next();     // Catch: Throwable -> L12
        r103.add(new Pair(r105.getKey(), r105.getValue()));     // Catch: Throwable -> L12
        goto L4
    L6:
        b0 r106 = BadgerCore.access$getNetRequestInterface$p(this.f199209a).b(new a0(r100, r103, r102));     // Catch: Throwable -> L12
        HashMap r107 = new HashMap();     // Catch: Throwable -> L12
        Iterator<T> r108 = r106.f199084c.iterator();     // Catch: Throwable -> L12
    L8:
        if (r108.hasNext() == false) goto L10;
        Pair r109 = (Pair) r108.next();     // Catch: Throwable -> L12
        r107.put(r109.getFirst(), r109.getSecond());     // Catch: Throwable -> L12
        goto L8
    L10:
        return new TTResponse(r100, r106.f199083b, r107, r106.f199085d);
    L12:
        th = move-exception;
        return TTResponse.failed(th);
    }
}
