package com.larus.bmhome.chat.screenshot;

import com.larus.utils.logger.FLogger;
import com.ss.android.lark.camera_export.CameraParam;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class k implements Consumer {
    public /* synthetic */ k() {
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r100) {
        Integer r101 = (Integer) r100;
        Intrinsics.checkNotNullParameter(r101, "state");
        int r102 = r101.intValue();
        if (r102 != 0) goto L5;
        FLogger.f375446a.i("ScreenRecordManager", "System Callback: End Recording / Recording Not active");
        CopyOnWriteArrayList<WeakReference<e>> r103 = ScreenRecordManager.f308569a;
        ScreenRecordManager.b(CameraParam.TYPE_SYSTEM_CAMERA);
        return;
    L5:
        if (r102 != 1) goto L50;
        FLogger.f375446a.i("ScreenRecordManager", "System callback: Start Recording");
        if (ScreenRecordManager.f308574f == true) goto L51;
        ScreenRecordManager.f308574f = true;
        ScreenRecordManager.f308575g = UUID.randomUUID().toString();
        Object r104 = ScreenRecordManager.f308573e;
        monitor-enter(r104);
        ScreenRecordManager.f308571c.clear();     // Catch: Throwable -> L33
        ScreenRecordManager.f308572d.clear();     // Catch: Throwable -> L33
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L33
        monitor-exit(r104);
        String r106 = ScreenRecordManager.f308575g;
        if (r106 == null) goto L52;
        CopyOnWriteArrayList<WeakReference<e>> r107 = ScreenRecordManager.f308569a;
        Iterator<WeakReference<e>> r108 = r107.iterator();
    L19:
        if (r108.hasNext() == false) goto L27;
        WeakReference<e> r109 = r108.next();
        WeakReference<e> r110 = r109;
        Intrinsics.checkNotNullParameter(r110, "it");
        if (r110.get() != null) goto L23;
        boolean r111 = true;
    L25:
        if (Boolean.valueOf(r111).booleanValue() == false) goto L19;
        r107.remove(r109);
        goto L19
    L23:
        r111 = false;
        goto L25
    L27:
        Iterator<WeakReference<e>> r112 = r107.iterator();
    L29:
        if (r112.hasNext() == false) goto L53;
        e r113 = r112.next().get();
        if (r113 == null) goto L29;
        r113.a(r106);
        goto L29
    L53:
        return;
    L52:
        return;
    L33:
        th = move-exception;
        throw th;
    L51:
        return;
    }
}
