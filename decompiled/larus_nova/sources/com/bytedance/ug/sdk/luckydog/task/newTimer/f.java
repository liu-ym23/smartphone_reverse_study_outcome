package com.bytedance.ug.sdk.luckydog.task.newTimer;

import com.bytedance.ug.sdk.luckydog.task.newTimer.network.LuckyTimerReportWrapper;
import org.json.JSONObject;
import zm7.m;

/* JADX INFO: loaded from: classes22.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public dm7.a f272040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.ug.sdk.luckydog.task.newTimer.pendant.d f272041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public fm7.b f272042c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f272043d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f272044e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m f272045f;

    public static final class a {
    }

    static {
    }

    public f(String r100, String r101, JSONObject r110, m r111) {
        this.f272043d = r100;
        this.f272044e = r101;
        this.f272045f = r111;
        dm7.a r102 = new dm7.a(r111);
        com.bytedance.ug.sdk.luckydog.task.newTimer.pendant.d r103 = new com.bytedance.ug.sdk.luckydog.task.newTimer.pendant.d(r111, r110);
        this.f272041b = r103;
        this.f272040a = r102;
        this.f272042c = new fm7.b(r100, r101, r111, new g(this, new LuckyTimerReportWrapper(this.f272043d, this.f272044e, this.f272045f, r102, r103), r102));
    }
}
