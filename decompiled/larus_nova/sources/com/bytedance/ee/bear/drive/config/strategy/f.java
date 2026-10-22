package com.bytedance.ee.bear.drive.config.strategy;

import android.content.Context;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class f implements com.bytedance.ee.drive.render.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.drive.render.k.a f224096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ee.drive.render.k.b f224097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.ee.drive.render.k.e f224098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.ee.drive.render.k.h f224099d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.ee.drive.render.k.f f224100e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.ee.drive.render.k.c f224101f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.ee.drive.render.k.d f224102g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.ee.drive.render.k.g f224103h;

    @Override // com.bytedance.ee.drive.render.k
    public final com.bytedance.ee.drive.render.k.b a() {
        return this.f224097b;
    }

    @Override // com.bytedance.ee.drive.render.k
    public final com.bytedance.ee.drive.render.k.d b() {
        return this.f224102g;
    }

    @Override // com.bytedance.ee.drive.render.k
    public final com.bytedance.ee.drive.render.k.e c() {
        return this.f224098c;
    }

    @Override // com.bytedance.ee.drive.render.k
    public final com.bytedance.ee.drive.render.k.c d() {
        return this.f224101f;
    }

    @Override // com.bytedance.ee.drive.render.k
    public final com.bytedance.ee.drive.render.k.a getContainer() {
        return this.f224096a;
    }

    @Override // com.bytedance.ee.drive.render.k
    public final com.bytedance.ee.drive.render.k.f getText() {
        return this.f224100e;
    }

    @Override // com.bytedance.ee.drive.render.k
    public final com.bytedance.ee.drive.render.k.g getTitleBar() {
        return this.f224103h;
    }

    @Override // com.bytedance.ee.drive.render.k
    public final com.bytedance.ee.drive.render.k.h getVideo() {
        return this.f224099d;
    }

    public f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f224096a = new com.bytedance.ee.drive.render.k.a(true);
        int r101 = xo5.a.a(14.0f);
        int r102 = r100.getResources().getColor(R.color.text_caption);
        int r103 = r100.getResources().getColor(R.color.colorful_blue);
        this.f224097b = new com.bytedance.ee.drive.render.k.b(r101, r102, r100.getResources().getColor(R.color.ud_N300), r103);
        this.f224098c = new com.bytedance.ee.drive.render.k.e(Boolean.FALSE);
        this.f224099d = new com.bytedance.ee.drive.render.k.h(true, true, 4);
        this.f224100e = new com.bytedance.ee.drive.render.k.f(true);
        this.f224101f = new com.bytedance.ee.drive.render.k.c(false, false, 65);
        this.f224102g = new com.bytedance.ee.drive.render.k.d(true);
        this.f224103h = new com.bytedance.ee.drive.render.k.g(true, true);
    }
}
