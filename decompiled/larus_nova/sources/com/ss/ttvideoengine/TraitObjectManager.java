package com.ss.ttvideoengine;

import com.ss.ttm.player.TraitObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public class TraitObjectManager {
    private Map<Integer, TraitObject> mTraitObjects;

    public Map<Integer, TraitObject> getAll() {
        return new HashMap(this.mTraitObjects);
    }

    public void removeAll() {
        if (this.mTraitObjects.size() > 0) goto L5;
        return;
    L5:
        HashMap r100 = new HashMap();
        monitor-enter(this);
        r100.putAll(this.mTraitObjects);     // Catch: Throwable -> L16
        this.mTraitObjects.clear();     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        Iterator r101 = r100.entrySet().iterator();
    L11:
        if (r101.hasNext() == false) goto L15;
        Map.Entry r102 = (Map.Entry) r101.next();
        if (r102.getValue() == null) goto L11;
        ((TraitObject) r102.getValue()).release();
        goto L11
    L15:
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public TraitObjectManager() {
        this.mTraitObjects = new HashMap();
    }

    public TraitObject get(int r100) {
        return this.mTraitObjects.get(Integer.valueOf(r100));
    }

    public int remove(int r100) {
        monitor-enter(this);
        TraitObject r101 = this.mTraitObjects.get(Integer.valueOf(r100));     // Catch: Throwable -> L12
        if (r101 != null) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L12
        return -1;
    L8:
        this.mTraitObjects.remove(Integer.valueOf(r100));     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        r101.release();
        return 0;
    L12:
        th = move-exception;
        throw th;
    }

    public void put(int r100, TraitObject r101) {
        monitor-enter(this);
        TraitObject r102 = this.mTraitObjects.get(Integer.valueOf(r100));     // Catch: Throwable -> L20
        if (r102 != null) goto L8;
        if (r101 != null) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L20
        return;
    L8:
        if (r102 == r101) goto L18;
        if (r102 != null) goto L11;
    L13:
        this.mTraitObjects.put(Integer.valueOf(r100), r101);     // Catch: Throwable -> L20
        monitor-exit(this);     // Catch: Throwable -> L20
        if (r102 == null) goto L24;
        r102.release();
        return;
    L24:
        return;
    L11:
        if (r102.sameAs(r101) == false) goto L13;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    }
}
