package com.bytedance.livesdk.ktvcommon.midi.view.midihitanim;

import android.animation.Animator;
import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.livesdk.ktvcommon.midi.view.LiveDegradeFpsAnimator;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.security.SecureRandom;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SecureRandom f256117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Animator> f256118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a<LiveDegradeFpsAnimator> f256119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a<LiveDegradeFpsAnimator> f256120d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a<LiveDegradeFpsAnimator> f256121e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a<LiveDegradeFpsAnimator> f256122f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a<LiveDegradeFpsAnimator> f256123g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f256124h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ViewGroup f256125i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f256126j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final KtvHitResourceManager f256127k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.livesdk.ktvcommon.midi.view.midihitanim.a f256128l;

    public static final class a<T extends LiveDegradeFpsAnimator> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayDeque<T> f256129a;

        public a() {
            this.f256129a = new ArrayDeque();
        }

        public final T a(Function0<? extends T> r100) {
            Intrinsics.checkNotNullParameter(r100, "create");
            T r101 = this.f256129a.poll();
            if (r101 == null) goto L5;
            return r101;
        L5:
            return r100.invoke();
        }

        public final void b(T r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            if (this.f256129a.size() >= 15) goto L6;
            r100.cancel();
            r100.removeAllUpdateListeners();
            r100.removeAllListeners();
            this.f256129a.offer(r100);
            return;
        }
    }

    public static int a(boolean r100) {
        if (r100 == false) goto L5;
        return Math.min(2, KtvSettingHelper.k());
    L5:
        return Math.min(4, KtvSettingHelper.k());
    }

    public d(Context r100, ViewGroup r101, b r102, KtvHitResourceManager r103, com.bytedance.livesdk.ktvcommon.midi.view.midihitanim.a r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "parent");
        Intrinsics.checkNotNullParameter(r102, "config");
        Intrinsics.checkNotNullParameter(r103, "resourceManager");
        Intrinsics.checkNotNullParameter(r104, "imagePoolManager");
        this.f256125i = r101;
        this.f256126j = r102;
        this.f256127k = r103;
        this.f256128l = r104;
        this.f256117a = new SecureRandom();
        this.f256118b = new ArrayList();
        this.f256119c = new a();
        this.f256120d = new a();
        this.f256121e = new a();
        this.f256122f = new a();
        this.f256123g = new a();
        this.f256124h = 30;
    }
}
