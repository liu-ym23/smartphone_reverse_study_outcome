package com.larus.media.model;

import com.bytedance.applet.aibridge.p;
import com.larus.media.MediaLevel;
import com.larus.media.MediaState;
import com.larus.media.MixPriority;
import com.larus.media.m0;
import com.larus.media.o;
import com.larus.media.v;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import lk9.f;
import lk9.g;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f359113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f359114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f359115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f359116d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f359117e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f359118f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f359119g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f359120h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f359121i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f359122j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f359123k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final v f359124l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public MediaState f359125m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public f f359126n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final SceneConfig.SceneConfigBean.ConfigBean.MediaActionBean f359127o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final SceneConfig.SceneConfigBean.ConfigBean.MediaActionBean f359128p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Function0<Boolean> f359129q;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f359113a, r101.f359113a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f359114b, r101.f359114b) == true) goto L15;
        return false;
    L15:
        if (this.f359115c == r101.f359115c) goto L18;
        return false;
    L18:
        if (this.f359116d == r101.f359116d) goto L21;
        return false;
    L21:
        if (this.f359117e == r101.f359117e) goto L24;
        return false;
    L24:
        if (this.f359118f == r101.f359118f) goto L27;
        return false;
    L27:
        if (this.f359119g == r101.f359119g) goto L30;
        return false;
    L30:
        if (this.f359120h == r101.f359120h) goto L33;
        return false;
    L33:
        if (this.f359121i == r101.f359121i) goto L36;
        return false;
    L36:
        if (this.f359122j == r101.f359122j) goto L39;
        return false;
    L39:
        if (this.f359123k == r101.f359123k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f359124l, r101.f359124l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f359113a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = ((r101 * 31) + this.f359114b.hashCode()) * 31;
        int r103 = 1231;
        if (this.f359115c == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (((((r102 + r104) * 31) + this.f359116d) * 31) + this.f359117e) * 31;
        if (this.f359118f == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (((r105 + r106) * 31) + this.f359119g) * 31;
        if (this.f359120h == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        if (this.f359121i == false) goto L21;
        int r110 = 1231;
    L22:
        int r111 = (((r109 + r110) * 31) + this.f359122j) * 31;
        if (this.f359123k == true) goto L27;
        r103 = 1237;
    L27:
        return ((r111 + r103) * 31) + this.f359124l.hashCode();
    L21:
        r110 = 1237;
        goto L22
    L17:
        r108 = 1237;
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "MediaRequestApplicant(key=" + this.f359113a + ", scene=" + this.f359114b + ",  focusType=" + this.f359116d + ", mixWithOthers=" + this.f359121i + ", hashCode=" + hashCode() + ')';
    }

    @Override // lk9.g
    public final String getScene() {
        return this.f359114b;
    }

    public final void a(MediaState r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f359125m = r100;
    }

    public a(String r110, String r111, boolean r112, int r113, int r210, boolean r211, int r212, boolean r213, boolean r214, int r215, boolean r216, v r217, int r218) {
        SceneConfig.SceneConfigBean.ConfigBean.MediaActionBean r100 = null;
        if ((r218 & 1) == 0) goto L5;
        String r101 = null;
    L6:
        boolean r102 = false;
        if ((r218 & 4) == 0) goto L9;
        boolean r103 = false;
    L11:
        if ((r218 & 8) == 0) goto L13;
        int r104 = 0;
    L15:
        if ((r218 & 32) == 0) goto L20;
        SceneConfig.SceneConfigBean.ConfigBean.MediaActionBean r114 = m0.b(r111, r210);
        if (r114 == null) goto L19;
        boolean r115 = r114.isEnable();
    L22:
        if ((r218 & 64) == 0) goto L27;
        SceneConfig.SceneConfigBean.ConfigBean.MediaActionBean r116 = m0.b(r111, r210);
        if (r116 == null) goto L26;
        int r117 = r116.getMixPriority();
    L28:
        boolean r118 = true;
        if ((r218 & 128) == 0) goto L34;
        SceneConfig.SceneConfigBean.ConfigBean.MediaActionBean r119 = m0.b(r111, r210);
        if (r119 == null) goto L33;
        boolean r120 = r119.getIsCanInterruptInPeer();
    L36:
        if ((r218 & 256) != 0) goto L38;
        r102 = r214;
    L47:
        if ((r218 & 512) == 0) goto L52;
        SceneConfig.SceneConfigBean.ConfigBean.MediaActionBean r121 = m0.b(r111, r210);
        if (r121 == null) goto L51;
        int r122 = r121.getInterruptPriority();
    L54:
        if ((r218 & 1024) != 0) goto L57;
        r118 = r216;
    L57:
        Intrinsics.checkNotNullParameter(r111, "scene");
        Intrinsics.checkNotNullParameter(r217, "listener");
        this.f359113a = r101;
        this.f359114b = r111;
        this.f359115c = r103;
        this.f359116d = r104;
        this.f359117e = r210;
        this.f359118f = r115;
        this.f359119g = r117;
        this.f359120h = r120;
        this.f359121i = r102;
        this.f359122j = r122;
        this.f359123k = r118;
        this.f359124l = r217;
        this.f359125m = MediaState.DEFAULT;
        SceneConfig.SceneConfigBean.ConfigBean r105 = m0.a(r111);
        if (r105 == null) goto L60;
        SceneConfig.SceneConfigBean.ConfigBean.MediaActionBean r106 = r105.a();
    L61:
        this.f359127o = r106;
        SceneConfig.SceneConfigBean.ConfigBean r107 = m0.a(r111);
        if (r107 == null) goto L64;
        r100 = r107.b();
    L64:
        this.f359128p = r100;
        this.f359129q = new p();
        return;
    L60:
        r106 = null;
        goto L61
    L51:
        r122 = MediaLevel.PLAY_DEFAULT.getValue();
        goto L54
    L52:
        r122 = r215;
        goto L54
    L38:
        if (o.a() == false) goto L47;
        SceneConfig.SceneConfigBean.ConfigBean.MediaActionBean r123 = m0.b(r111, r210);
        if (r123 == null) goto L42;
        boolean r124 = r123.getMixWithOthers();
    L43:
        if (r124 == false) goto L47;
        r102 = true;
        goto L47
    L42:
        r124 = false;
        goto L43
    L33:
        r120 = true;
        goto L36
    L34:
        r120 = r213;
        goto L36
    L26:
        r117 = MixPriority.DEFAULT.getValue();
        goto L28
    L27:
        r117 = r212;
        goto L28
    L19:
        r115 = false;
        goto L22
    L20:
        r115 = r211;
        goto L22
    L13:
        r104 = r113;
        goto L15
    L9:
        r103 = r112;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
