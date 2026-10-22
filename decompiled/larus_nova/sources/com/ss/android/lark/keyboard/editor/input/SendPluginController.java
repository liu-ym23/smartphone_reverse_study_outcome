package com.ss.android.lark.keyboard.editor.input;

import android.view.View;
import android.view.ViewGroup;
import com.obric.trace.ObricActionBarTrackType;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class SendPluginController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f428858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.keyboard.b f428859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<mob.a, View> f428860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Integer, uxa.a> f428861d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Integer, View> f428862e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f428863f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.ss.android.lark.keyboard.base.f f428864g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set<com.ss.android.lark.keyboard.base.j> f428865h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Set<com.ss.android.lark.keyboard.base.h> f428866i;

    public static final class a {
    }

    static {
    }

    public SendPluginController(ViewGroup r100, com.ss.android.lark.keyboard.b r101) {
        Intrinsics.checkNotNullParameter(r100, "btnRegionParent");
        Intrinsics.checkNotNullParameter(r101, ObricActionBarTrackType.KEY_BOARD);
        this.f428858a = r100;
        this.f428859b = r101;
        this.f428860c = new HashMap();
        this.f428861d = new HashMap();
        this.f428862e = new HashMap();
        this.f428865h = new LinkedHashSet();
        this.f428866i = new LinkedHashSet();
        r101.e().of(this).d(com.ss.android.lark.keyboard.event.n.class, new SendPluginController$1$1(this));
    }

    public final void a(int r100, mob.a r101) {
        if (r100 != 0) goto L4;
        Object r102 = ((HashMap) this.f428860c).get(r101);
    L5:
        View r103 = (View) r102;
        if (r103 != null) goto L8;
        return;
    L8:
        this.f428858a.removeAllViews();
        this.f428858a.addView(r103);
        return;
    L4:
        Map<Integer, View> r104 = this.f428862e;
        HashMap r105 = (HashMap) r104;
        r102 = r105.get(Integer.valueOf(r100));
        goto L5
    }
}
