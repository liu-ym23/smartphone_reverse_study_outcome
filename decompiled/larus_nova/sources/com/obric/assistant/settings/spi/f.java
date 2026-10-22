package com.obric.assistant.settings.spi;

import android.view.View;
import com.bytedance.applet.aibridge.p;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class f extends e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Boolean> f392396e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function2<Boolean, View, Unit> f392397f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CharSequence f392398g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<Continuation<? super Boolean>, Object> f392399h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<Boolean> f392400i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f392401j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f392402k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f392403l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function0<Boolean> f392404m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f392405n;

    public f() {
        throw null;
    }

    @Override // com.obric.assistant.settings.spi.e
    public final Object a(Continuation<? super Boolean> r100) {
        return this.f392399h.invoke(r100);
    }

    public f(String r110, String r111, CharSequence r112, int r113, Function0 r210, Function2 r211, CharSequence r212, Function1 r213, boolean r214, String r215, Function0 r216, String r217, int r218) {
        if ((r218 & 64) == 0) goto L5;
        CharSequence r100 = null;
    L7:
        if ((r218 & 128) == 0) goto L9;
        Function1 r101 = new SwitchSettingItem$1(null);
    L11:
        if ((r218 & 256) == 0) goto L13;
        zb8.c r102 = new zb8.c();
    L15:
        if ((r218 & 512) == 0) goto L17;
        boolean r103 = false;
    L19:
        if ((r218 & 2048) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r218 & 4096) == 0) goto L25;
        Function0 r114 = new p();
    L27:
        if ((r218 & 8192) == 0) goto L29;
        String r105 = null;
    L30:
        Intrinsics.checkNotNullParameter(r110, "groupId");
        Intrinsics.checkNotNullParameter(r111, "id");
        Intrinsics.checkNotNullParameter(r112, "title");
        Intrinsics.checkNotNullParameter(r210, "isChecked");
        Intrinsics.checkNotNullParameter(r211, "onCheckedChange");
        Intrinsics.checkNotNullParameter(r101, "visibleCheck");
        Intrinsics.checkNotNullParameter(r102, "showRedPot");
        Intrinsics.checkNotNullParameter(r114, "enabled");
        super(r110, r111, r112, r113);
        this.f392396e = r210;
        this.f392397f = r211;
        this.f392398g = r100;
        this.f392399h = r101;
        this.f392400i = r102;
        this.f392401j = r103;
        this.f392402k = null;
        this.f392403l = r104;
        this.f392404m = r114;
        this.f392405n = r105;
        return;
    L29:
        r105 = r217;
        goto L30
    L25:
        r114 = r216;
        goto L27
    L21:
        r104 = r215;
        goto L23
    L17:
        r103 = r214;
        goto L19
    L13:
        r102 = null;
        goto L15
    L9:
        r101 = r213;
        goto L11
    L5:
        r100 = r212;
        goto L7
    }
}
