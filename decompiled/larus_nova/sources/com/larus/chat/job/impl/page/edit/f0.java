package com.larus.chat.job.impl.page.edit;

import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.platform.model.SlashMentionConfig;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f325248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f325249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f325250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f325251d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<ChatJobEditWeekday> f325252e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f325253f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f325254g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final h f325255h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e0 f325256i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f325257j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f325258k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f325259l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f325260m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f325261n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f325262o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f325263p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final d0 f325264q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f325265r;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f0) == true) goto L8;
        return false;
    L8:
        f0 r101 = (f0) r100;
        if (Intrinsics.areEqual(this.f325248a, r101.f325248a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f325249b, r101.f325249b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f325250c, r101.f325250c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f325251d, r101.f325251d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f325252e, r101.f325252e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f325253f, r101.f325253f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f325254g, r101.f325254g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f325255h, r101.f325255h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f325256i, r101.f325256i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f325257j, r101.f325257j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f325258k, r101.f325258k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f325259l, r101.f325259l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f325260m, r101.f325260m) == true) goto L48;
        return false;
    L48:
        if (this.f325261n == r101.f325261n) goto L51;
        return false;
    L51:
        if (this.f325262o == r101.f325262o) goto L54;
        return false;
    L54:
        if (this.f325263p == r101.f325263p) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f325264q, r101.f325264q) == true) goto L60;
        return false;
    L60:
        if (this.f325265r == r101.f325265r) goto L62;
        return false;
    L62:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((((((((((((((((this.f325248a.hashCode() * 31) + this.f325249b.hashCode()) * 31) + this.f325250c.hashCode()) * 31) + this.f325251d.hashCode()) * 31) + this.f325252e.hashCode()) * 31) + this.f325253f.hashCode()) * 31) + this.f325254g.hashCode()) * 31) + this.f325255h.hashCode()) * 31) + this.f325256i.hashCode()) * 31) + this.f325257j.hashCode()) * 31) + this.f325258k.hashCode()) * 31) + this.f325259l.hashCode()) * 31) + this.f325260m.hashCode()) * 31) + this.f325261n) * 31;
        int r101 = 1231;
        if (this.f325262o == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f325263p == true) goto L10;
        r101 = 1237;
    L10:
        int r104 = (r103 + r101) * 31;
        d0 r105 = this.f325264q;
        if (r105 != null) goto L13;
        int r106 = 0;
    L15:
        return ((r104 + r106) * 31) + this.f325265r;
    L13:
        r106 = r105.hashCode();
        goto L15
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ChatJobEditUiState(title=" + this.f325248a + ", prompt=" + this.f325249b + ", repeat=" + this.f325250c + ", frequency=" + this.f325251d + ", selectedWeekdays=" + this.f325252e + ", customFrequencyInput=" + this.f325253f + ", customFrequencyResult=" + this.f325254g + ", date=" + this.f325255h + ", time=" + this.f325256i + ", runTime=" + this.f325257j + ", model=" + this.f325258k + ", environment=" + this.f325259l + ", project=" + this.f325260m + ", status=" + this.f325261n + ", isDirty=" + this.f325262o + ", isSaving=" + this.f325263p + ", subPage=" + this.f325264q + ", jobType=" + this.f325265r + ')';
    }

    public final boolean b() {
        if (this.f325262o == true) goto L5;
    L13:
        return false;
    L5:
        if (this.f325263p == true) goto L13;
        if ((!StringsKt.isBlank(this.f325248a)) == false) goto L13;
        if ((!StringsKt.isBlank(this.f325249b)) == false) goto L13;
        int r100 = com.larus.chat.job.impl.page.g0.f325370a;
        if (com.larus.chat.job.impl.page.g0.b(this.f325265r) == false) goto L13;
        return true;
    }

    public final boolean c() {
        if (this.f325265r == 1) goto L7;
        return false;
    L7:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f0(String r110, String r111, String r112, String r113, Set<? extends ChatJobEditWeekday> r210, String r211, String r212, h r213, e0 r214, String r215, String r216, String r217, String r218, int r219, boolean r310, boolean r311, d0 r312, int r313) {
        Intrinsics.checkNotNullParameter(r110, "title");
        Intrinsics.checkNotNullParameter(r111, EventConstant.Key.RETAIN_PROMPT);
        Intrinsics.checkNotNullParameter(r112, SalesInfoStruct.REPEAT);
        Intrinsics.checkNotNullParameter(r113, "frequency");
        Intrinsics.checkNotNullParameter(r210, "selectedWeekdays");
        Intrinsics.checkNotNullParameter(r211, "customFrequencyInput");
        Intrinsics.checkNotNullParameter(r212, "customFrequencyResult");
        Intrinsics.checkNotNullParameter(r213, "date");
        Intrinsics.checkNotNullParameter(r214, "time");
        Intrinsics.checkNotNullParameter(r215, "runTime");
        Intrinsics.checkNotNullParameter(r216, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r217, "environment");
        Intrinsics.checkNotNullParameter(r218, SlashMentionConfig.SLASH_CONTENT_PROJECT);
        this.f325248a = r110;
        this.f325249b = r111;
        this.f325250c = r112;
        this.f325251d = r113;
        this.f325252e = r210;
        this.f325253f = r211;
        this.f325254g = r212;
        this.f325255h = r213;
        this.f325256i = r214;
        this.f325257j = r215;
        this.f325258k = r216;
        this.f325259l = r217;
        this.f325260m = r218;
        this.f325261n = r219;
        this.f325262o = r310;
        this.f325263p = r311;
        this.f325264q = r312;
        this.f325265r = r313;
    }

    public static f0 a(f0 r110, String r111, String r112, String r210, String r211, Set r212, String r213, String r214, h r215, e0 r216, String r217, String r218, String r219, String r310, int r311, boolean r312, boolean r313, d0 r314, int r315, int r316) {
        if ((r316 & 1) == 0) goto L5;
        String r100 = r110.f325248a;
    L7:
        if ((r316 & 2) == 0) goto L9;
        String r101 = r110.f325249b;
    L11:
        if ((r316 & 4) == 0) goto L13;
        String r102 = r110.f325250c;
    L15:
        if ((r316 & 8) == 0) goto L17;
        String r103 = r110.f325251d;
    L19:
        if ((r316 & 16) == 0) goto L21;
        Set r104 = r110.f325252e;
    L23:
        if ((r316 & 32) == 0) goto L25;
        String r105 = r110.f325253f;
    L27:
        if ((r316 & 64) == 0) goto L29;
        String r106 = r110.f325254g;
    L31:
        if ((r316 & 128) == 0) goto L33;
        h r107 = r110.f325255h;
    L35:
        if ((r316 & 256) == 0) goto L37;
        e0 r113 = r110.f325256i;
    L39:
        if ((r316 & 512) == 0) goto L41;
        String r114 = r110.f325257j;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        String r115 = r110.f325258k;
    L47:
        if ((r316 & 2048) == 0) goto L49;
        String r116 = r110.f325259l;
    L51:
        if ((r316 & 4096) == 0) goto L53;
        String r117 = r110.f325260m;
    L55:
        if ((r316 & 8192) == 0) goto L57;
        int r118 = r110.f325261n;
    L58:
        int r317 = r118;
        if ((r316 & 16384) == 0) goto L61;
        boolean r119 = r110.f325262o;
    L62:
        boolean r318 = r119;
        if ((r316 & 32768) == 0) goto L65;
        boolean r120 = r110.f325263p;
    L66:
        boolean r319 = r120;
        if ((r316 & 65536) == 0) goto L69;
        d0 r121 = r110.f325264q;
    L71:
        if ((r316 & 131072) == 0) goto L73;
        int r108 = r110.f325265r;
    L74:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, EventConstant.Key.RETAIN_PROMPT);
        Intrinsics.checkNotNullParameter(r102, SalesInfoStruct.REPEAT);
        Intrinsics.checkNotNullParameter(r103, "frequency");
        Intrinsics.checkNotNullParameter(r104, "selectedWeekdays");
        Intrinsics.checkNotNullParameter(r105, "customFrequencyInput");
        Intrinsics.checkNotNullParameter(r106, "customFrequencyResult");
        Intrinsics.checkNotNullParameter(r107, "date");
        Intrinsics.checkNotNullParameter(r113, "time");
        Intrinsics.checkNotNullParameter(r114, "runTime");
        Intrinsics.checkNotNullParameter(r115, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r116, "environment");
        Intrinsics.checkNotNullParameter(r117, SlashMentionConfig.SLASH_CONTENT_PROJECT);
        return new f0(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r317, r318, r319, r121, r108);
    L73:
        r108 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L71
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
