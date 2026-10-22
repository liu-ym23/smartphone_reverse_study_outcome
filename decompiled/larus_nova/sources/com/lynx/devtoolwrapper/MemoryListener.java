package com.lynx.devtoolwrapper;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public class MemoryListener {
    private CopyOnWriteArrayList<MemoryReporter> mMemoryReporters;

    /* JADX INFO: renamed from: com.lynx.devtoolwrapper.MemoryListener$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class MemoryListenerLoader {
        private static final MemoryListener INSTANCE = null;

        private MemoryListenerLoader() {
        }

        static {
            INSTANCE = new MemoryListener(null);
        }

        public static /* synthetic */ MemoryListener access$100() {
            return INSTANCE;
        }
    }

    public interface MemoryReporter {
        void uploadImageInfo(JSONObject r100);
    }

    public boolean hasAvailableReporter() {
        return !this.mMemoryReporters.isEmpty();
    }

    private MemoryListener() {
        this.mMemoryReporters = new CopyOnWriteArrayList();
    }

    public static MemoryListener getInstance() {
        return MemoryListenerLoader.access$100();
    }

    public /* synthetic */ MemoryListener(AnonymousClass1 r100) {
        this();
    }

    public void addMemoryReporter(MemoryReporter r100) {
        this.mMemoryReporters.add(r100);
    }

    public void removeMemoryReporter(MemoryReporter r100) {
        this.mMemoryReporters.remove(r100);
    }

    public void uploadImageInfo(JSONObject r100) {
        Iterator<MemoryReporter> r101 = this.mMemoryReporters.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().uploadImageInfo(r100);
        goto L4
    }
}
