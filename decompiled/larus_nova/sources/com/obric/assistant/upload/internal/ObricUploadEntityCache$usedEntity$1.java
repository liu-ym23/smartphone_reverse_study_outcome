package com.obric.assistant.upload.internal;

import com.larus.im.bean.message.UplinkFileEntity;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\bH\u0014¨\u0006\t"}, d2 = {"com/obric/assistant/upload/internal/ObricUploadEntityCache$usedEntity$1", "Ljava/util/LinkedHashMap;", "", "Lcom/larus/im/bean/message/UplinkFileEntity;", "Lkotlin/collections/LinkedHashMap;", "removeEldestEntry", "", "eldest", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricUploadEntityCache$usedEntity$1 extends LinkedHashMap<String, UplinkFileEntity> {
    public ObricUploadEntityCache$usedEntity$1() {
        super(10, 0.75f, true);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, UplinkFileEntity>> entrySet() {
        return getEntries();
    }

    public /* bridge */ Set<Map.Entry<String, UplinkFileEntity>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<UplinkFileEntity> getValues() {
        return super.values();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<UplinkFileEntity> values() {
        return getValues();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return false;
    L7:
        return containsKey((String) r100);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object r100) {
        if ((r100 instanceof UplinkFileEntity) == true) goto L7;
        return false;
    L7:
        return containsValue((UplinkFileEntity) r100);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ UplinkFileEntity get(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ UplinkFileEntity remove(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r100);
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<String, UplinkFileEntity> r100) {
        Intrinsics.checkNotNullParameter(r100, "eldest");
        if (size() <= 20) goto L5;
        return true;
    L5:
        return false;
    }

    public /* bridge */ boolean containsKey(String r100) {
        return super.containsKey(r100);
    }

    public /* bridge */ boolean containsValue(UplinkFileEntity r100) {
        return super.containsValue(r100);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r100);
    }

    public /* bridge */ UplinkFileEntity get(String r100) {
        return (UplinkFileEntity) super.get(r100);
    }

    public /* bridge */ UplinkFileEntity remove(String r100) {
        return (UplinkFileEntity) super.remove(r100);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object r100, Object r101) {
        if ((r100 instanceof String) == true) goto L6;
        return r101;
    L6:
        return getOrDefault((String) r100, (UplinkFileEntity) r101);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object r100, Object r101) {
        if ((r100 instanceof String) == true) goto L6;
        return false;
    L6:
        if ((r101 instanceof UplinkFileEntity) == true) goto L9;
        return false;
    L9:
        return remove((String) r100, (UplinkFileEntity) r101);
    }

    public final /* bridge */ UplinkFileEntity getOrDefault(Object r100, UplinkFileEntity r101) {
        if ((r100 instanceof String) == true) goto L6;
        return r101;
    L6:
        return getOrDefault((String) r100, r101);
    }

    public /* bridge */ boolean remove(String r100, UplinkFileEntity r101) {
        return super.remove(r100, r101);
    }

    public /* bridge */ UplinkFileEntity getOrDefault(String r100, UplinkFileEntity r101) {
        return (UplinkFileEntity) super.getOrDefault(r100, r101);
    }
}
