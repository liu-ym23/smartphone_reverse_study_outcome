package com.bytedance.ies.argus.api.params;

import android.net.Uri;
import com.bytedance.ies.argus.api.ArgusResourceType;
import java.net.URI;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f245749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f245750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f245751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f245752d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f245753e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f245754f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Long f245755g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArgusResourceFrom f245756h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f245757i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f245758j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f245759k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Uri f245760l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Long f245761m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f245762n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f245763o;

    public final String toString() {
        return "LynxSignResourceInfo(verifyUrl=" + this.f245763o + ", sourceUrl=" + this.f245749a + ", cdnUrl=" + this.f245750b + ", channel=" + this.f245751c + ", bundle=" + this.f245752d + ", schemaUrl=" + this.f245753e + ", loaderName=" + this.f245754f + ", resourceVersion=" + this.f245755g + ')';
    }

    public j(String r110, String r111, String r112, String r210, String r211, Long r212, ArgusResourceType r213, ArgusResourceFrom r214, String r215, String r216, String r217, Uri r218, Long r219, int r310) {
        String r100 = r110;
        String r101 = null;
        if ((r310 & 2) == 0) goto L5;
        String r102 = null;
    L7:
        if ((r310 & 4) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r310 & 8) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r310 & 64) == 0) goto L17;
        Long r113 = null;
    L19:
        if ((r310 & 256) == 0) goto L21;
        ArgusResourceFrom r114 = null;
    L23:
        if ((r310 & 512) == 0) goto L25;
        String r115 = null;
    L27:
        if ((r310 & 1024) == 0) goto L29;
        String r116 = null;
    L31:
        if ((r310 & 8192) == 0) goto L33;
        Long r105 = null;
    L34:
        Intrinsics.checkNotNullParameter(r100, "sourceUrl");
        Intrinsics.checkNotNullParameter(r211, "loaderName");
        Intrinsics.checkNotNullParameter(r213, "resourceType");
        Intrinsics.checkNotNullParameter(r217, "accessKey");
        Intrinsics.checkNotNullParameter(r218, "srcUri");
        this.f245749a = r100;
        this.f245750b = r102;
        this.f245751c = r103;
        this.f245752d = r104;
        this.f245753e = null;
        this.f245754f = r211;
        this.f245755g = r113;
        this.f245756h = r114;
        this.f245757i = r115;
        this.f245758j = r116;
        this.f245759k = r217;
        this.f245760l = r218;
        this.f245761m = r105;
        if (StringsKt.startsWith$default(r100, "argus://", false, 2, null) == true) goto L65;
    L40:
        r100 = null;
    L41:
        if (r100 != null) goto L63;
        String r106 = this.f245750b;
        if (r106 == null) goto L50;
        if (StringsKt.startsWith$default(r106, "http://", false, 2, null) == false) goto L47;
    L48:
        r100 = this.f245750b;
        goto L63
    L47:
        if (StringsKt.startsWith$default(this.f245750b, "https://", false, 2, null) == true) goto L48;
    L50:
        if (this.f245751c == null) goto L55;
        StringBuilder r107 = new StringBuilder("gecko://");
        r107.append(this.f245751c);
        r107.append('/');
        String r108 = this.f245752d;
        if (r108 == null) goto L54;
        r101 = StringsKt.trimStart(r108, new char[]{'/'});
    L54:
        r107.append(r101);
        r100 = r107.toString();
        goto L63
    L55:
        String r109 = this.f245753e;
        if (r109 != null) goto L58;
    L62:
        r100 = "unknown://biz/" + this.f245749a;
        goto L63
    L58:
        if (StringsKt.startsWith$default(r109, "http://", false, 2, null) == false) goto L60;
    L61:
        r100 = this.f245753e;
        goto L63
    L60:
        if (StringsKt.startsWith$default(this.f245753e, "https://", false, 2, null) == false) goto L62;
    L63:
        this.f245763o = r100;
        return;
    L65:
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L38
        this.f245762n = new URI(r100).getHost();     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L40
    L33:
        r105 = r219;
        goto L34
    L29:
        r116 = r216;
        goto L31
    L25:
        r115 = r215;
        goto L27
    L21:
        r114 = r214;
        goto L23
    L17:
        r113 = r212;
        goto L19
    L13:
        r104 = r210;
        goto L15
    L9:
        r103 = r112;
        goto L11
    L5:
        r102 = r111;
        goto L7
    }
}
