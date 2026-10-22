package com.larus.audio.audiov3.task.sami.v2.flow;

import com.larus.audio.audiov3.config.BusinessTypeEnum;
import com.larus.audio.audiov3.task.sami.v2.a0;
import com.mammon.audiosdk.SAMICore;
import com.mammon.audiosdk.SAMICoreCallBackListener;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import g58.n;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class a extends SAMICore implements r78.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f288579b;

    @Override // r78.c
    public final void b() {
        a0.f288553a.getClass();
        a0.m(this);
    }

    @Override // r78.c
    public final void d() {
        a0.f288553a.getClass();
        a0.g(this);
    }

    @Override // r78.c
    public final void e() {
        this.f288579b.f288580a.clear();
        super.setListener(null);
    }

    public a() {
        this.f288579b = new b(new SAMICoreCallBackListener[0]);
    }

    @Override // r78.c
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        a0.f288553a.getClass();
        a0.b(r100, this);
    }

    @Override // r78.c
    public final void f(x58.a r100) {
        a0.f288553a.getClass();
        a0.f(r100, this, null);
    }

    public final void h(SAMICoreCallBackListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        b r101 = this.f288579b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        r101.f288580a.add(r100);
        if (this.f288579b.f288580a.size() != 1) goto L6;
        super.setListener(this.f288579b);
        return;
    }

    public final void i(n r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        h(new c(r100));
    }

    @Override // com.mammon.audiosdk.SAMICore
    @Deprecated(message = "use addListener instead")
    public final void setListener(SAMICoreCallBackListener r100) {
        if (r100 != null) goto L4;
        e();
        return;
    L4:
        this.f288579b.f288580a.clear();
        h(r100);
    }

    @Override // r78.c
    public final void a(String r100, byte[] r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "data");
        a0.f288553a.getClass();
        a0.n(r100, r101, r102, this);
    }

    @Override // r78.c
    public final void g(BusinessTypeEnum r110, x58.a r111, y58.a r112, Integer r113, JSONObject r114, Integer r115, String r116) {
        Intrinsics.checkNotNullParameter(r110, "businessType");
        a0.f288553a.getClass();
        a0.k(r110, r111, r112, null, this, null, r113, r114, r115, r116);
    }
}
