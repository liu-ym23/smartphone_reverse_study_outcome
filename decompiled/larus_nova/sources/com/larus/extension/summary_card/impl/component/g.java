package com.larus.extension.summary_card.impl.component;

import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f343019h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f343020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f343021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f343022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f343023d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f343024e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f343025f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f343026g;

    public static final class a {
        public static g a(Message r100) {
            String r101 = null;
            if (r100 == null) goto L5;
            String r102 = r100.getMessageId();
        L6:
            if (r102 != null) goto L8;
        L11:
            boolean r103 = true;
        L12:
            if (r103 == false) goto L20;
            if (r100 == null) goto L18;
            Map<String, String> r104 = r100.getBusinessExt();
            if (r104 == null) goto L18;
            r101 = r104.get("expand_status_non_collapsed");
        L18:
            if (Intrinsics.areEqual(r101, "1") == false) goto L20;
            f r105 = f.d.f343018a;
        L22:
            return new g(r105, 125);
        L20:
            r105 = f.a.f343015a;
            goto L22
        L8:
            if (r102.length() == 0) goto L11;
            r103 = false;
            goto L12
        L5:
            r102 = null;
            goto L6
        }
    }

    static {
    }

    public g() {
        this(null, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f343020a, r101.f343020a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f343021b, r101.f343021b) == true) goto L15;
        return false;
    L15:
        if (this.f343022c == r101.f343022c) goto L18;
        return false;
    L18:
        if (this.f343023d == r101.f343023d) goto L21;
        return false;
    L21:
        if (this.f343024e == r101.f343024e) goto L24;
        return false;
    L24:
        if (this.f343025f == r101.f343025f) goto L27;
        return false;
    L27:
        if (this.f343026g == r101.f343026g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        Message r100 = this.f343020a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = ((r101 * 31) + this.f343021b.hashCode()) * 31;
        int r103 = 1231;
        if (this.f343022c == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r102 + r104) * 31;
        if (this.f343023d == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f343024e == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (((r107 + r108) * 31) + this.f343025f) * 31;
        if (this.f343026g == true) goto L23;
        r103 = 1237;
    L23:
        return r109 + r103;
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
        return "SummaryCardStatus(message=" + this.f343020a + ", expandStatus=" + this.f343021b + ", firstBind=" + this.f343022c + ", realSummaryFirstExposure=" + this.f343023d + ", placeholderFirstExposure=" + this.f343024e + ", unExpandHeight=" + this.f343025f + ", mLastIsPlaceholder=" + this.f343026g + ')';
    }

    public /* synthetic */ g(f r100, int r110) {
        if ((r110 & 2) == 0) goto L5;
        r100 = f.a.f343015a;
    L5:
        f r101 = r100;
        if ((r110 & 4) == 0) goto L8;
        boolean r102 = true;
    L10:
        if ((r110 & 8) == 0) goto L12;
        boolean r103 = true;
    L14:
        if ((r110 & 16) == 0) goto L16;
        boolean r104 = true;
    L17:
        this(null, r101, r102, r103, r104, 0, false);
        return;
    L16:
        r104 = false;
        goto L17
    L12:
        r103 = false;
        goto L14
    L8:
        r102 = false;
        goto L10
    }

    public g(Message r100, f r101, boolean r102, boolean r103, boolean r104, int r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r101, "expandStatus");
        this.f343020a = r100;
        this.f343021b = r101;
        this.f343022c = r102;
        this.f343023d = r103;
        this.f343024e = r104;
        this.f343025f = r105;
        this.f343026g = r106;
    }

    public static g a(g r100, Message r101, f r110, boolean r111, int r112, boolean r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        r101 = r100.f343020a;
    L5:
        Message r102 = r101;
        if ((r114 & 2) == 0) goto L8;
        r110 = r100.f343021b;
    L8:
        f r103 = r110;
        if ((r114 & 4) == 0) goto L11;
        r111 = r100.f343022c;
    L11:
        boolean r104 = r111;
        if ((r114 & 8) == 0) goto L14;
        boolean r105 = r100.f343023d;
    L16:
        if ((r114 & 16) == 0) goto L18;
        boolean r106 = r100.f343024e;
    L20:
        if ((r114 & 32) == 0) goto L22;
        r112 = r100.f343025f;
    L22:
        int r107 = r112;
        if ((r114 & 64) == 0) goto L25;
        r113 = r100.f343026g;
    L25:
        Intrinsics.checkNotNullParameter(r103, "expandStatus");
        return new g(r102, r103, r104, r105, r106, r107, r113);
    L18:
        r106 = false;
        goto L20
    L14:
        r105 = false;
        goto L16
    }
}
