package com.larus.voice_setting.voice;

import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.service.z2;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class t2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f377006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f377007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Page f377008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f377009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f377010e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f377011f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<SpeakerVoice, Boolean> f377012g;

    public final boolean a() {
        if (this.f377010e == true) goto L5;
    L9:
        return false;
    L5:
        if (this.f377011f != 3) goto L9;
        if (this.f377006a == false) goto L9;
        return true;
    }

    public final boolean b() {
        z2 r100 = z2.f365865a;
        if (r100.I2() == false) goto L5;
    L14:
        return true;
    L5:
        if (this.f377011f != 0) goto L14;
        if (this.f377008c != Page.NON) goto L14;
        if (this.f377006a == false) goto L11;
    L13:
        return false;
    L11:
        if (r100.o3().f510331a == false) goto L13;
        goto L13
    }

    public t2(boolean r100, boolean r101, Page r102, String r103, boolean r104, int r105, Function1 r106, int r110) {
        if ((r110 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r110 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r110 & 4) == 0) goto L12;
        r102 = Page.NON;
    L12:
        if ((r110 & 8) == 0) goto L15;
        r103 = "my_tab";
    L15:
        if ((r110 & 16) == 0) goto L18;
        r104 = false;
    L18:
        if ((r110 & 32) == 0) goto L21;
        r105 = 0;
    L21:
        if ((r110 & 64) == 0) goto L23;
        r106 = null;
    L23:
        Intrinsics.checkNotNullParameter(r102, "page");
        Intrinsics.checkNotNullParameter(r103, "tabName");
        this.f377006a = r100;
        this.f377007b = r101;
        this.f377008c = r102;
        this.f377009d = r103;
        this.f377010e = r104;
        this.f377011f = r105;
        this.f377012g = r106;
    }
}
