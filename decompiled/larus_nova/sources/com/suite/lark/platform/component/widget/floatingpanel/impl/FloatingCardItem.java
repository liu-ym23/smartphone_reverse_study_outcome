package com.suite.lark.platform.component.widget.floatingpanel.impl;

import android.content.Context;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import yoc.c;

/* JADX INFO: loaded from: classes36.dex */
public final class FloatingCardItem<Card extends yoc.c> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f460656h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Card f460657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f460658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f460659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f460660d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f460661e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f460662f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f460663g;

    public static final class a {
        public static String a(yoc.c r100) {
            Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
            return r100.getType() + '_' + r100.getId();
        }
    }

    static {
    }

    public final Context getContext() {
        return this.f460658b;
    }

    public FloatingCardItem(Card r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f460657a = r100;
        this.f460658b = r101;
        LazyThreadSafetyMode r102 = LazyThreadSafetyMode.NONE;
        this.f460659c = LazyKt.lazy(r102, new FloatingCardItem$view$2(this));
        this.f460660d = LazyKt.lazy(r102, new FloatingCardItem$lazyView$2(this));
        this.f460661e = a.a(r100);
        this.f460662f = r100.getType();
        this.f460663g = r100.getId();
    }
}
