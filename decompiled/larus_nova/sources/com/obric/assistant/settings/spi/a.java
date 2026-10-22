package com.obric.assistant.settings.spi;

import android.view.View;
import com.bytedance.applet.aibridge.p;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.obric.assistant.settings.provider.w1;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a extends e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<View, Unit> f392381e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<String> f392382f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<String> f392383g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<Continuation<? super Boolean>, Object> f392384h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<Boolean> f392385i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f392386j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function0<Boolean> f392387k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f392388l;

    public a() {
        throw null;
    }

    @Override // com.obric.assistant.settings.spi.e
    public final Object a(Continuation<? super Boolean> r100) {
        return this.f392384h.invoke(r100);
    }

    public a(String r100, String r101, CharSequence r102, int r103, Function1 r104, Function0 r105, Function0 r106, Function1 r110, w1 r111, boolean r112, Function0 r113, String r114, int r115) {
        if ((r115 & 32) == 0) goto L6;
        r105 = null;
    L6:
        if ((r115 & 64) == 0) goto L9;
        r106 = null;
    L9:
        if ((r115 & 128) == 0) goto L11;
        r110 = new ActionSettingItem$1(null);
    L11:
        Function0<Boolean> r116 = r111;
        if ((r115 & 512) == 0) goto L15;
        r116 = new zb8.c();
    L15:
        if ((r115 & 1024) == 0) goto L18;
        r112 = false;
    L18:
        if ((r115 & 2048) == 0) goto L21;
        r113 = new p();
    L21:
        if ((r115 & 4096) == 0) goto L23;
        r114 = null;
    L23:
        Intrinsics.checkNotNullParameter(r100, "groupId");
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r102, "title");
        Intrinsics.checkNotNullParameter(r104, SendEventContainerMethodParamModel.EventKinds.onClick);
        Intrinsics.checkNotNullParameter(r110, "visibleCheck");
        Intrinsics.checkNotNullParameter(r116, "showSubtitleRedPot");
        Intrinsics.checkNotNullParameter(r113, "enabled");
        super(r100, r101, r102, r103);
        this.f392381e = r104;
        this.f392382f = r105;
        this.f392383g = r106;
        this.f392384h = r110;
        this.f392385i = r116;
        this.f392386j = r112;
        this.f392387k = r113;
        this.f392388l = r114;
    }
}
