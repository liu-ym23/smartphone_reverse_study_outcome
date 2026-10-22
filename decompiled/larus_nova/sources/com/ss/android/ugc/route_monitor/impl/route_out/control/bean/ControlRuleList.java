package com.ss.android.ugc.route_monitor.impl.route_out.control.bean;

import com.ss.android.ugc.route_monitor.utils.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0005¢\u0006\u0002\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/route_monitor/impl/route_out/control/bean/ControlRuleList;", "Ljava/util/ArrayList;", "Lcom/ss/android/ugc/route_monitor/impl/route_out/control/bean/ControlRule;", "Lkotlin/collections/ArrayList;", "()V", "toJsonArray", "Lorg/json/JSONArray;", "toJsonArray$route_monitor_release", "route-monitor_release"}, k = 1, mv = {1, 1, 16})
public final class ControlRuleList extends ArrayList<ControlRule> {
    public final JSONArray toJsonArray$route_monitor_release() {
        JSONArray r100 = new JSONArray();
        Iterator<ControlRule> r101 = iterator();     // Catch: Throwable -> L8
    L5:
        if (r101.hasNext() == false) goto L10;
        r100.put(r101.next().toJsonObject$route_monitor_release());     // Catch: Throwable -> L8
    L10:
        return r100;
    L8:
        th = move-exception;
        Logger.f454747c.d(th);
        goto L10
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    public ControlRuleList() {
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object r100) {
        if ((r100 instanceof ControlRule) == true) goto L5;
        return false;
    L5:
        return contains((ControlRule) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object r100) {
        if ((r100 instanceof ControlRule) == true) goto L5;
        return -1;
    L5:
        return indexOf((ControlRule) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object r100) {
        if ((r100 instanceof ControlRule) == true) goto L5;
        return -1;
    L5:
        return lastIndexOf((ControlRule) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object r100) {
        if ((r100 instanceof ControlRule) == true) goto L5;
        return false;
    L5:
        return remove((ControlRule) r100);
    }

    public /* bridge */ ControlRule removeAt(int r100) {
        return remove(r100);
    }

    public /* bridge */ boolean contains(ControlRule r100) {
        return super.contains(r100);
    }

    public /* bridge */ int indexOf(ControlRule r100) {
        return super.indexOf(r100);
    }

    public /* bridge */ int lastIndexOf(ControlRule r100) {
        return super.lastIndexOf(r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ ControlRule remove(int r100) {
        return removeAt(r100);
    }

    public /* bridge */ boolean remove(ControlRule r100) {
        return super.remove(r100);
    }
}
