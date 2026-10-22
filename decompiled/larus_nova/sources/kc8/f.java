package kc8;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f502475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f502476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f502477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f502478d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h f502479e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f502480f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public e f502481g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ra8.b f502482h;

    public f(Message r110, Boolean r111, boolean r112, boolean r210, h r211, String r212, int r213) {
        if ((r213 & 1) == 0) goto L5;
        Message r100 = null;
    L7:
        if ((r213 & 2) == 0) goto L9;
        Boolean r101 = null;
    L11:
        if ((r213 & 4) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r213 & 8) == 0) goto L17;
        boolean r103 = true;
    L19:
        if ((r213 & 16) == 0) goto L21;
        h r104 = null;
    L23:
        if ((r213 & 32) == 0) goto L25;
        String r113 = "default";
    L26:
        Intrinsics.checkNotNullParameter(r113, "containerScene");
        this.f502475a = r100;
        this.f502476b = r101;
        this.f502477c = r102;
        this.f502478d = r103;
        this.f502479e = r104;
        this.f502480f = r113;
        this.f502481g = null;
        this.f502482h = new ra8.b(null, null, null, false, null, r113, 95);
        return;
    L25:
        r113 = r212;
        goto L26
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
