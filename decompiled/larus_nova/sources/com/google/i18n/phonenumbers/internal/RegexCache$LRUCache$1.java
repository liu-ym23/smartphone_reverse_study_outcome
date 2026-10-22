package com.google.i18n.phonenumbers.internal;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
class RegexCache$LRUCache$1 extends LinkedHashMap<Object, Object> {
    final /* synthetic */ a this$0;

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<Object, Object> r100) {
        size();
        throw null;
    }

    public RegexCache$LRUCache$1(a r100, int r101, float r102, boolean r103) {
        super(r101, r102, r103);
    }
}
