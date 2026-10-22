package k6;

import android.content.Context;
import android.view.View;
import com.bytedance.android.accessibilityLib_Core.processor.ViewAccessibilityDelegateProcessor;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakHashMap<View, WeakReference<ViewAccessibilityDelegateProcessor.a>> f501936a;

    public a() {
        this.f501936a = new WeakHashMap();
    }

    public final ViewAccessibilityDelegateProcessor.a a(View r100, int r101) {
        WeakReference<ViewAccessibilityDelegateProcessor.a> r102 = this.f501936a.get(r100);     // Catch: Exception -> L18
        if (r102 == null) goto L7;
        ViewAccessibilityDelegateProcessor.a r103 = r102.get();     // Catch: Exception -> L18
        if (r103 == null) goto L7;
        r103.f38294b = r101;     // Catch: Exception -> L18
    L8:
        if (r103 != null) goto L14;
        r103 = new ViewAccessibilityDelegateProcessor.a(new WeakReference(r100), r101);     // Catch: Exception -> L18
        WeakHashMap<View, WeakReference<ViewAccessibilityDelegateProcessor.a>> r104 = this.f501936a;     // Catch: Exception -> L18
        monitor-enter(r104);     // Catch: Exception -> L18
        this.f501936a.put(r100, new WeakReference(r103));     // Catch: Throwable -> L15
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r104);     // Catch: Exception -> L18
        goto L14
    L15:
        th = move-exception;
        throw th;     // Catch: Exception -> L18
    L14:
        return r103;
    L7:
        r103 = null;
    L18:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L23;
        Context r106 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L23:
        return new ViewAccessibilityDelegateProcessor.a(new WeakReference(r100), r101);
    }
}
