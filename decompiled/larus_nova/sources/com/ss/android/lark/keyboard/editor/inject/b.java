package com.ss.android.lark.keyboard.editor.inject;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.keyboard.base.d;
import com.ss.android.lark.keyboard.event.k;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.keyboard.b f428792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<d.a<?>, d<?>> f428793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<d.a<?>, View> f428794c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f428795d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f428796e;

    public b(ViewGroup r100, com.ss.android.lark.keyboard.b r101) {
        Intrinsics.checkNotNullParameter(r100, "inputBottomContainer");
        Intrinsics.checkNotNullParameter(r101, ObricActionBarTrackType.KEY_BOARD);
        this.f428792a = r101;
        this.f428793b = new LinkedHashMap();
        this.f428794c = new LinkedHashMap();
        this.f428795d = r101.e();
        FrameLayout r102 = new FrameLayout(r100.getContext());
        r102.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f428796e = r102;
        r100.addView(r102);
    }
}
