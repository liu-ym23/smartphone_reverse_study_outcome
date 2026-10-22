package com.larus.office.card.urlpreview;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bH\u0014¨\u0006\t"}, d2 = {"com/larus/office/card/urlpreview/OfficeUrlPreviewCoordinator$renderFailures$1", "Ljava/util/LinkedHashMap;", "Lcom/larus/office/card/urlpreview/OfficeUrlPreviewCoordinator$RenderFailureKey;", "", "Lkotlin/collections/LinkedHashMap;", "removeEldestEntry", "", "eldest", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeUrlPreviewCoordinator$renderFailures$1 extends LinkedHashMap<OfficeUrlPreviewCoordinator.c, Unit> {
    public OfficeUrlPreviewCoordinator$renderFailures$1() {
        super(401, 0.75f, true);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<OfficeUrlPreviewCoordinator.c, Unit>> entrySet() {
        return getEntries();
    }

    public /* bridge */ Set<Map.Entry<OfficeUrlPreviewCoordinator.c, Unit>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<OfficeUrlPreviewCoordinator.c> getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<Unit> getValues() {
        return super.values();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<OfficeUrlPreviewCoordinator.c> keySet() {
        return getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<Unit> values() {
        return getValues();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object r100) {
        if ((r100 instanceof OfficeUrlPreviewCoordinator.c) == true) goto L7;
        return false;
    L7:
        return containsKey((OfficeUrlPreviewCoordinator.c) r100);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object r100) {
        if ((r100 instanceof Unit) == true) goto L7;
        return false;
    L7:
        return containsValue((Unit) r100);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object r100) {
        if ((r100 instanceof OfficeUrlPreviewCoordinator.c) == true) goto L7;
        return null;
    L7:
        return get((OfficeUrlPreviewCoordinator.c) r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object r100) {
        if ((r100 instanceof OfficeUrlPreviewCoordinator.c) == true) goto L7;
        return null;
    L7:
        return remove((OfficeUrlPreviewCoordinator.c) r100);
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<OfficeUrlPreviewCoordinator.c, Unit> r100) {
        if (size() <= 400) goto L5;
        return true;
    L5:
        return false;
    }

    public /* bridge */ boolean containsKey(OfficeUrlPreviewCoordinator.c r100) {
        return super.containsKey(r100);
    }

    public /* bridge */ boolean containsValue(Unit r100) {
        return super.containsValue(r100);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Unit get(Object r100) {
        if ((r100 instanceof OfficeUrlPreviewCoordinator.c) == true) goto L7;
        return null;
    L7:
        return get((OfficeUrlPreviewCoordinator.c) r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Unit remove(Object r100) {
        if ((r100 instanceof OfficeUrlPreviewCoordinator.c) == true) goto L7;
        return null;
    L7:
        return remove((OfficeUrlPreviewCoordinator.c) r100);
    }

    public /* bridge */ Unit get(OfficeUrlPreviewCoordinator.c r100) {
        return (Unit) super.get(r100);
    }

    public /* bridge */ Unit remove(OfficeUrlPreviewCoordinator.c r100) {
        return (Unit) super.remove(r100);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object r100, Object r101) {
        if ((r100 instanceof OfficeUrlPreviewCoordinator.c) == true) goto L5;
        return r101;
    L5:
        getOrDefault((OfficeUrlPreviewCoordinator.c) r100, (Unit) r101);
        return Unit.INSTANCE;
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object r100, Object r101) {
        if ((r100 instanceof OfficeUrlPreviewCoordinator.c) == true) goto L6;
        return false;
    L6:
        if ((r101 instanceof Unit) == true) goto L9;
        return false;
    L9:
        return remove((OfficeUrlPreviewCoordinator.c) r100, (Unit) r101);
    }

    public final /* bridge */ void getOrDefault(Object r100, Unit r101) {
        if ((r100 instanceof OfficeUrlPreviewCoordinator.c) == true) goto L5;
        return;
    L5:
        getOrDefault((OfficeUrlPreviewCoordinator.c) r100, r101);
    }

    public /* bridge */ boolean remove(OfficeUrlPreviewCoordinator.c r100, Unit r101) {
        return super.remove(r100, r101);
    }

    public /* bridge */ void getOrDefault(OfficeUrlPreviewCoordinator.c r100, Unit r101) {
        super.getOrDefault(r100, r101);
    }
}
