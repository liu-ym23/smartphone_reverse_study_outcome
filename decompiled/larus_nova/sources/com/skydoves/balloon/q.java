package com.skydoves.balloon;

import android.content.Context;
import android.graphics.Typeface;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes34.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f406188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f406189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f406190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f406191d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f406192e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Typeface f406193f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Float f406194g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f406195h;

    @TextFormDsl
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f406196a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CharSequence f406197b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f406198c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f406199d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f406200e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f406201f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Typeface f406202g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Float f406203h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f406204i;

        public final Context getContext() {
            return this.f406196a;
        }

        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f406196a = r100;
            StringCompanionObject r101 = StringCompanionObject.INSTANCE;
            this.f406197b = "";
            this.f406198c = 12.0f;
            this.f406199d = -1;
            this.f406204i = 17;
        }
    }

    public q(a r100) {
        this.f406188a = r100.f406197b;
        this.f406189b = r100.f406198c;
        this.f406190c = r100.f406199d;
        this.f406191d = r100.f406200e;
        this.f406192e = r100.f406201f;
        this.f406193f = r100.f406202g;
        this.f406194g = r100.f406203h;
        this.f406195h = r100.f406204i;
    }
}
