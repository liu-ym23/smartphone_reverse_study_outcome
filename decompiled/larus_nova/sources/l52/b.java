package l52;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.l;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k;
import com.bytedance.android.livesdk.interactivity.square.h;
import java.util.ArrayDeque;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j52.b f507489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super List<? extends h52.c>, Unit> f507490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f507491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m52.b f507492d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k52.a f507493e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f507494f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l f507495g;

    public b(k52.a r100, h r101, l r102) {
        Intrinsics.checkNotNullParameter(r100, "pipelineConfig");
        Intrinsics.checkNotNullParameter(r101, "messageRepo");
        Intrinsics.checkNotNullParameter(r102, "publicScreenContext");
        this.f507493e = r100;
        this.f507494f = r101;
        this.f507495g = r102;
        r100.getClass();
        new ArrayDeque();
        this.f507489a = new j52.b(r100.f501827c, r100.f501828d);
        this.f507491c = new a(this);
        k<h52.c> r103 = r100.f501830f;
        Handler r104 = new Handler(Looper.getMainLooper());
        m52.c r105 = m52.c.f512103a;
        this.f507492d = new m52.b(r103, r104);
    }
}
