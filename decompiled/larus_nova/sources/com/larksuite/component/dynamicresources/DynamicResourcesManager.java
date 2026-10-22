package com.larksuite.component.dynamicresources;

import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes24.dex */
public final class DynamicResourcesManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile DynamicResourcesManager f283993a;

    public static class DynamicResourcesRefLeakException extends RuntimeException {
        public DynamicResourcesRefLeakException(String r100) {
            super(r100);
        }
    }

    static {
        new HashSet(Arrays.asList(new Class[]{String.class, Integer.class, Long.class, Short.class, Character.class, Byte.class, Float.class, Double.class}));
    }

    public DynamicResourcesManager() {
        new WeakHashMap();
        new WeakHashMap();
        new ArrayList();
        new WeakHashMap();
        new CopyOnWriteArrayList();
        Log.i("DynamicResourcesManager", "DynamicResourcesManager <init>");
    }
}
