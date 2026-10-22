package com.bytedance.locallife.dito.plugin;

import android.os.SystemClock;
import com.bytedance.locallife.dito.data.DitoNode;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f258635o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long f258636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f258637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f258638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f258639d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f258640e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f258641f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DitoComponentStage f258642g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f258643h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f258644i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f258645j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.bytedance.locallife.dito.model.b f258646k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f258647l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f258648m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public DitoComponentStage f258649n;

    public static final class a {
        public static d a(String r100, DitoNode r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "node");
            d r102 = new d();
            r102.f258638c = r100;
            r102.f258639d = r101.getCustomTag();
            r102.f258640e = r101.getSubType();
            Map<String, String> r103 = r101.getTemplate();
            if (r103 == null) goto L5;
            String r104 = r103.get("url");
        L6:
            r102.f258645j = r104;
            com.bytedance.locallife.dito.data.c r105 = r101.getConfig();
            if (r105 == null) goto L11;
            boolean r106 = true;
            if (r105.f() != true) goto L11;
        L12:
            r102.f258643h = r106;
            return r102;
        L11:
            r106 = false;
            goto L12
        L5:
            r104 = null;
            goto L6
        }
    }

    static {
    }

    public final void b() {
        Long r100 = this.f258636a;
        if (r100 == null) goto L6;
        this.f258637b += (SystemClock.uptimeMillis() - r100.longValue()) / 1000.0d;
        this.f258636a = null;
        return;
    }

    public final String toString() {
        return "DitoComponentStats(longestStage=" + this.f258642g + ", firstErrorStage=" + this.f258649n + ", lastResumeTimestamp=" + this.f258636a + ", foregroundDurationInS=" + this.f258637b + ", subType=" + this.f258640e + ", tag=" + this.f258638c + ", customTag=" + this.f258639d + ", isViewStub=" + this.f258643h + ", logId=" + this.f258644i + ", url=" + this.f258645j + ", errorMsg=" + this.f258647l + ", errorType=" + this.f258648m + ", customComponentStatics=" + this.f258646k + ')';
    }

    public d() {
        DitoComponentStage r100 = DitoComponentStage.UNKNOWN;
        this.f258642g = r100;
        this.f258649n = r100;
    }

    public final void a(DitoComponentStage r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f258642g = (DitoComponentStage) RangesKt.coerceAtLeast(this.f258642g, r100);
    }
}
