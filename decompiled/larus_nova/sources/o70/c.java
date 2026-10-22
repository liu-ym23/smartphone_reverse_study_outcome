package o70;

import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<Integer, LayerEventDispatcher> f522253a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<LayerEventDispatcher, Integer> f522254b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f522255c = null;

    static {
        f522253a = new HashMap();
        f522254b = new HashMap();
        f522255c = new Object();
    }

    @JvmStatic
    public static final LayerEventDispatcher a(Integer r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        HashMap<Integer, LayerEventDispatcher> r101 = f522253a;
        if (r101.containsKey(r100) == true) goto L15;
        Object r102 = f522255c;
        monitor-enter(r102);
        LayerEventDispatcher r103 = new LayerEventDispatcher();     // Catch: Throwable -> L12
        r101.put(r100, r103);     // Catch: Throwable -> L12
        f522254b.put(r103, r100);     // Catch: Throwable -> L12
        monitor-exit(r102);
        return r103;
    L12:
        th = move-exception;
        throw th;
    L15:
        LayerEventDispatcher r104 = r101.get(r100);
        Intrinsics.checkNotNull(r104);
        return r104;
    }
}
