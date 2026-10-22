package rh9;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WeakHashMap<com.ss.android.lark.feed.export.feedcard.d, Map<String, WeakReference<View>>> f537817a = null;

    static {
        f537817a = new WeakHashMap();
    }

    public static void a(com.ss.android.lark.feed.export.feedcard.d r100, String r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, "feedContext");
        Intrinsics.checkNotNullParameter(r101, "feedId");
        Intrinsics.checkNotNullParameter(r102, "itemView");
        WeakHashMap<com.ss.android.lark.feed.export.feedcard.d, Map<String, WeakReference<View>>> r103 = f537817a;
        Map<String, WeakReference<View>> r104 = r103.get(r100);
        if (r104 != null) goto L5;
        r104 = new LinkedHashMap();
        r103.put(r100, r104);
    L5:
        r104.put(r101, new WeakReference(r102));
    }

    public static void b(com.ss.android.lark.feed.export.feedcard.d r100, String r101, View r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 != null) goto L6;
    L9:
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
        return;
    L12:
        WeakHashMap<com.ss.android.lark.feed.export.feedcard.d, Map<String, WeakReference<View>>> r104 = f537817a;
        Map<String, WeakReference<View>> r105 = r104.get(r100);
        if (r105 != null) goto L15;
        return;
    L15:
        WeakReference<View> r106 = r105.get(r101);
        if (r106 == null) goto L18;
        View r107 = r106.get();
    L19:
        if (r107 == null) goto L21;
        if (r107 == r102) goto L21;
        return;
    L21:
        r105.remove(r101);
        if (r105.isEmpty() == false) goto L26;
        r104.remove(r100);
        return;
    L26:
        return;
    L18:
        r107 = null;
        goto L19
    L6:
        if (r101.length() == 0) goto L9;
        r103 = false;
        goto L10
    }
}
