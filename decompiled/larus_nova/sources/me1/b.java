package me1;

import com.bytedance.android.livesdk.arch.state.source.TbRecordState;
import ne1.c;
import ne1.d;
import ne1.f;
import z51.e;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e<ne1.e> f513449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e<TbRecordState> f513450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e<f> f513451d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e<d> f513452e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e<c> f513453f;

    public b() {
        int r100 = e.f570057c;
        this.f513449b = e.a.a();
        this.f513450c = e.a.a();
        this.f513451d = e.a.a();
        this.f513452e = e.a.a();
        this.f513453f = e.a.a();
    }

    @Override // me1.a
    public final e a() {
        return this.f513452e;
    }

    @Override // me1.a
    public final e b() {
        return this.f513450c;
    }

    @Override // me1.a
    public final e c() {
        return this.f513451d;
    }

    @Override // me1.a
    public final e content() {
        return this.f513453f;
    }

    @Override // me1.a
    public final e lifecycle() {
        return this.f513449b;
    }
}
