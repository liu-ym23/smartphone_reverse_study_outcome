package com.lynx.clay.embedding.engine.memory;

import com.lynx.base.memory.MemoryPressureCallback;
import com.lynx.clay.util.a;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes32.dex */
public class MemoryPressureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ArrayList<MemoryPressureCallback> f380749a;

    public MemoryPressureListener() {
    }

    private static native void nativeOnMemoryPressure(int r100);

    private static void addNativeCallback() {
        Object r100 = a.f380953a;
        MemoryPressureCallback r101 = new d5a.a();
        if (f380749a != null) goto L6;
        f380749a = new ArrayList();
    L6:
        if (f380749a.contains(r101) == true) goto L9;
        f380749a.add(r101);
        return;
    }

    public static /* synthetic */ void a(int r100) {
        nativeOnMemoryPressure(r100);
    }
}
