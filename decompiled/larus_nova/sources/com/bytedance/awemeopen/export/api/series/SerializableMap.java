package com.bytedance.awemeopen.export.api.series;

import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public class SerializableMap<K, V> implements Serializable {
    private Map<K, V> map;

    public Map<K, V> getMap() {
        return this.map;
    }

    public SerializableMap(Map<K, V> r100) {
        this.map = r100;
    }

    public void setMap(Map<K, V> r100) {
        this.map = r100;
    }
}
