package com.bytedance.awemeopen.apps.framework.profile.works;

import android.animation.TypeEvaluator;
import android.util.Pair;
import android.view.ViewGroup;
import java.util.Stack;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g {
    public final Stack<Pair<ViewGroup, boolean[]>> a;

    public static final class a implements TypeEvaluator<b> {
        public a() {
        }

        @Override // android.animation.TypeEvaluator
        public final b evaluate(float r4, b r5, b r6) {
            b r7 = r5;
            b r8 = r6;
            Intrinsics.checkNotNullParameter(r7, "startValue");
            Intrinsics.checkNotNullParameter(r8, "endValue");
            b r0 = new b();
            float r1 = r7.a;
            r0.a = r1 + ((r8.a - r1) * r4);
            float r9 = r7.b;
            r0.b = r9 + (r4 * (r8.b - r9));
            return r0;
        }
    }

    public static final class b {
        public float a;
        public float b;

        public b() {
        }

        public b(float r1, float r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public g() {
        this.a = new Stack();
    }
}
