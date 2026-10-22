package com.ss.android.lark.message.card.view.richtext;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.android.VirtualYogaLayout;
import com.facebook.yoga.android.YogaLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Field;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f432100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public YogaLayout f432101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public VirtualYogaLayout f432102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HashMap<View, YogaNode> f432103d;

    public v0(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f432100a = r100;
    }

    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        boolean r101 = r100 instanceof YogaLayout;
        if (r101 == false) goto L12;
        if (this.f432102c == null) goto L12;
        YogaLayout r102 = new YogaLayout(this.f432100a);
        VirtualYogaLayout r103 = this.f432102c;
        if (r103 == null) goto L9;
        YogaNode r104 = r103.getYogaNode();
    L10:
        r102.addView(r103, r104);
        this.f432102c = null;
        this.f432101b = r102;
    L18:
        ViewGroup r105 = this.f432101b;
        if (r105 != null) goto L22;
        r105 = this.f432102c;
    L22:
        if (r105 == null) goto L25;
        r105.addView(r100);
        return;
    L25:
        return;
    L9:
        r104 = null;
    L12:
        if (this.f432101b != null) goto L18;
        if (this.f432102c != null) goto L18;
        if (r101 == false) goto L17;
        this.f432101b = new YogaLayout(this.f432100a);
        goto L18
    L17:
        this.f432102c = new VirtualYogaLayout(this.f432100a);
        goto L18
    }

    public final YogaNode b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        YogaLayout r101 = this.f432101b;
        if (r101 == null) goto L6;
        return r101.getYogaNodeForView(r100);
    L6:
        if (this.f432103d != null) goto L22;
        VirtualYogaLayout r102 = this.f432102c;
        if (r102 == null) goto L22;
        String r103 = "mYogaNodes";
        Class<?> r104 = r102.getClass();
    L11:
        if (r104 == Object.class) goto L15;
        Field r105 = r104.getDeclaredField(r103);     // Catch: Exception -> L14
    L16:
        r105.setAccessible(true);
        Object r106 = r105.get(r102);     // Catch: Exception -> L19
    L21:
        this.f432103d = (HashMap) r106;
    L19:
        e = move-exception;
        e.printStackTrace();
        r106 = null;
    L14:
        r104 = r104.getSuperclass();
        goto L11
    L15:
        r105 = null;
    L22:
        HashMap<View, YogaNode> r107 = this.f432103d;
        if (r107 == null) goto L26;
        return r107.get(r100);
    L26:
        return null;
    }
}
