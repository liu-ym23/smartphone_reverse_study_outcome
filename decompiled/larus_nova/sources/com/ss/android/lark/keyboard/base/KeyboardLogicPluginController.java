package com.ss.android.lark.keyboard.base;

import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.keyboard.event.ImeState;
import com.ss.android.lark.keyboard.plugin.input.base.InputSupportType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class KeyboardLogicPluginController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.keyboard.b f428223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.keyboard.event.k f428224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<g.a<?>, g<?>> f428225c;

    public KeyboardLogicPluginController(com.ss.android.lark.keyboard.b r100) {
        Intrinsics.checkNotNullParameter(r100, ObricActionBarTrackType.KEY_BOARD);
        this.f428223a = r100;
        com.ss.android.lark.keyboard.event.k r101 = r100.e();
        this.f428224b = r101;
        this.f428225c = new LinkedHashMap();
        com.ss.android.lark.keyboard.event.l r102 = r101.of(this);
        r102.d(InputSupportType.class, new KeyboardLogicPluginController$1$1(this));
        r102.d(cya.h.class, new KeyboardLogicPluginController$1$2(this));
        r102.d(ImeState.class, new KeyboardLogicPluginController$1$3(this));
        r102.d(com.ss.android.lark.keyboard.event.n.class, new KeyboardLogicPluginController$1$4(this));
        r102.d(com.ss.android.lark.keyboard.event.r.class, new KeyboardLogicPluginController$1$5(this));
        r102.c(com.ss.android.lark.keyboard.event.q.a.class, new KeyboardLogicPluginController$1$6(this));
        r102.c(com.ss.android.lark.keyboard.event.q.b.class, new KeyboardLogicPluginController$1$7(this));
    }
}
