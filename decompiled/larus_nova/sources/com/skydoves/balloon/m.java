package com.skydoves.balloon;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes34.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f406160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IconGravity f406161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f406162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f406163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f406164e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f406165f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CharSequence f406166g;

    @IconFormDsl
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f406167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Drawable f406168b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public IconGravity f406169c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f406170d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f406171e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f406172f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f406173g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final CharSequence f406174h;

        public final Context getContext() {
            return this.f406167a;
        }

        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f406167a = r100;
            this.f406169c = IconGravity.START;
            float r101 = 28;
            Resources r102 = Resources.getSystem();
            this.f406170d = MathKt.roundToInt(TypedValue.applyDimension(1, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics())));
            Resources r103 = Resources.getSystem();
            this.f406171e = MathKt.roundToInt(TypedValue.applyDimension(1, r101, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics())));
            Resources r104 = Resources.getSystem();
            this.f406172f = MathKt.roundToInt(TypedValue.applyDimension(1, 8, WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics())));
            this.f406173g = -1;
            StringCompanionObject r105 = StringCompanionObject.INSTANCE;
            this.f406174h = "";
        }
    }

    public m(a r100) {
        this.f406160a = r100.f406168b;
        this.f406161b = r100.f406169c;
        this.f406162c = r100.f406170d;
        this.f406163d = r100.f406171e;
        this.f406164e = r100.f406172f;
        this.f406165f = r100.f406173g;
        this.f406166g = r100.f406174h;
    }
}
