package com.larus.asr;

import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public final class x4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y4 f288246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f288247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f288248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f288249d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f288250e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f288251f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function2<? super String, ? super Integer, Unit> f288252g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function0<Unit> f288253h;

    public static final class a {
    }

    static {
    }

    public x4() {
        this.f288252g = new v4();
        this.f288253h = new w4();
    }

    public static final void a(x4 r110, long r111) {
        boolean r100 = false;
        if (r110.f288251f == true) goto L5;
    L7:
        String r101 = "";
    L9:
        if (r101.length() != 0) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == true) goto L14;
    L16:
        int r112 = 1;
    L17:
        Pair r113 = TuplesKt.to(r101, Integer.valueOf(r112));
        if (((CharSequence) r113.getFirst()).length() <= 0) goto L20;
        r100 = true;
    L20:
        if (r100 == true) goto L23;
        r113 = null;
    L23:
        if (r113 == null) goto L26;
        r110.f288252g.invoke(r113.getFirst(), r113.getSecond());
        return;
    L26:
        return;
    L14:
        if (r110.f288250e == false) goto L16;
        long r103 = (r110.f288247b - r111) / ((long) 1000);
        StringCompanionObject r114 = StringCompanionObject.INSTANCE;
        r112 = 2;
        long r104 = 60;
        r101 = AppHost.f326268a.getApplication().getResources().getString(R.string.larus_cici_handsfree_recording_label, new Object[]{String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r103 / r104), Long.valueOf(r103 % r104)}, 2))});
        goto L17
    L11:
        r102 = false;
        goto L12
    L5:
        if (r111 >= r110.f288249d) goto L7;
        StringCompanionObject r105 = StringCompanionObject.INSTANCE;
        r101 = String.format(AppHost.f326268a.getApplication().getResources().getString(R.string.larus_recording_voice_countdown), Arrays.copyOf(new Object[]{Integer.valueOf(((int) (r111 / ((long) 1000))) + 1)}, 1));
        goto L9
    }
}
