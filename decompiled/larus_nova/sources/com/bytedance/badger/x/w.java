package com.bytedance.badger.x;

import android.content.Context;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
final class w extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ f0 f199418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f199419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ z f199420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Context f199421d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ List f199422e;

    public w(f0 r100, long r101, z r102, Context r103, List r104) {
        this.f199418a = r100;
        this.f199419b = r101;
        this.f199420c = r102;
        this.f199421d = r103;
        this.f199422e = r104;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object r110) {
        a0 r100 = (a0) r110;
        boolean r101 = r100.f199366a;
        f0 r102 = this.f199418a;
        if (r101 == false) goto L5;
        long r103 = this.f199419b;
        z r111 = this.f199420c;
        String r112 = r100.f199367b;
        r102.f199387e.getClass();
        r102.c(r103, new y(0, "success", r111, r112, ShortVideoSegments.KEY_PROP_PROVIDER, 32), f0.a(this.f199418a, r100.f199369d, "provider: "), null);
    L7:
        return Unit.INSTANCE;
    L5:
        Context r104 = this.f199421d;
        long r105 = this.f199419b;
        z r106 = this.f199420c;
        List r107 = this.f199422e;
        r102.d(r104, r102.f199388f, r107, new t(r102, r105, r106, r100));
        goto L7
    }
}
