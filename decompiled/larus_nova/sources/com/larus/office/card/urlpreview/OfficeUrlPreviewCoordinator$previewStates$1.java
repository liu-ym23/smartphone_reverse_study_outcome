package com.larus.office.card.urlpreview;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bH\u0014¨\u0006\t"}, d2 = {"com/larus/office/card/urlpreview/OfficeUrlPreviewCoordinator$previewStates$1", "Ljava/util/LinkedHashMap;", "Lcom/larus/office/card/urlpreview/OfficeUrlPreviewRequestKey;", "Lcom/larus/office/card/urlpreview/OfficeUrlPreviewCoordinator$PreviewState;", "Lkotlin/collections/LinkedHashMap;", "removeEldestEntry", "", "eldest", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeUrlPreviewCoordinator$previewStates$1 extends LinkedHashMap<c2, OfficeUrlPreviewCoordinator.b> {
    public OfficeUrlPreviewCoordinator$previewStates$1() {
        super(401, 0.75f, true);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<c2, OfficeUrlPreviewCoordinator.b>> entrySet() {
        return getEntries();
    }

    public /* bridge */ Set<Map.Entry<c2, OfficeUrlPreviewCoordinator.b>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<c2> getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<OfficeUrlPreviewCoordinator.b> getValues() {
        return super.values();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<c2> keySet() {
        return getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<OfficeUrlPreviewCoordinator.b> values() {
        return getValues();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object r100) {
        if ((r100 instanceof c2) == true) goto L7;
        return false;
    L7:
        return containsKey((c2) r100);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object r100) {
        if ((r100 instanceof OfficeUrlPreviewCoordinator.b) == true) goto L7;
        return false;
    L7:
        return containsValue((OfficeUrlPreviewCoordinator.b) r100);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ OfficeUrlPreviewCoordinator.b get(Object r100) {
        if ((r100 instanceof c2) == true) goto L7;
        return null;
    L7:
        return get((c2) r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ OfficeUrlPreviewCoordinator.b remove(Object r100) {
        if ((r100 instanceof c2) == true) goto L7;
        return null;
    L7:
        return remove((c2) r100);
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<c2, OfficeUrlPreviewCoordinator.b> r100) {
        if (size() <= 400) goto L5;
        return true;
    L5:
        return false;
    }

    public /* bridge */ boolean containsKey(c2 r100) {
        return super.containsKey(r100);
    }

    public /* bridge */ boolean containsValue(OfficeUrlPreviewCoordinator.b r100) {
        return super.containsValue(r100);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object r100) {
        if ((r100 instanceof c2) == true) goto L7;
        return null;
    L7:
        return get((c2) r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object r100) {
        if ((r100 instanceof c2) == true) goto L7;
        return null;
    L7:
        return remove((c2) r100);
    }

    public /* bridge */ OfficeUrlPreviewCoordinator.b get(c2 r100) {
        return (OfficeUrlPreviewCoordinator.b) super.get(r100);
    }

    public /* bridge */ OfficeUrlPreviewCoordinator.b remove(c2 r100) {
        return (OfficeUrlPreviewCoordinator.b) super.remove(r100);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object r100, Object r101) {
        if ((r100 instanceof c2) == true) goto L6;
        return r101;
    L6:
        return getOrDefault((c2) r100, (OfficeUrlPreviewCoordinator.b) r101);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object r100, Object r101) {
        if ((r100 instanceof c2) == true) goto L6;
        return false;
    L6:
        if ((r101 instanceof OfficeUrlPreviewCoordinator.b) == true) goto L9;
        return false;
    L9:
        return remove((c2) r100, (OfficeUrlPreviewCoordinator.b) r101);
    }

    public final /* bridge */ OfficeUrlPreviewCoordinator.b getOrDefault(Object r100, OfficeUrlPreviewCoordinator.b r101) {
        if ((r100 instanceof c2) == true) goto L6;
        return r101;
    L6:
        return getOrDefault((c2) r100, r101);
    }

    public /* bridge */ boolean remove(c2 r100, OfficeUrlPreviewCoordinator.b r101) {
        return super.remove(r100, r101);
    }

    public /* bridge */ OfficeUrlPreviewCoordinator.b getOrDefault(c2 r100, OfficeUrlPreviewCoordinator.b r101) {
        return (OfficeUrlPreviewCoordinator.b) super.getOrDefault(r100, r101);
    }
}
