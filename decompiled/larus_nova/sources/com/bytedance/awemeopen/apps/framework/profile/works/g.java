package com.bytedance.awemeopen.apps.framework.profile.works;

import android.animation.TypeEvaluator;
import android.util.Pair;
import android.view.ViewGroup;
import java.util.Stack;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Stack<Pair<ViewGroup, boolean[]>> f197586a;

    public static final class a implements TypeEvaluator<b> {
        public a() {
        }

        @Override // android.animation.TypeEvaluator
        public final b evaluate(float r100, b r101, b r102) {
            b r103 = r101;
            b r104 = r102;
            Intrinsics.checkNotNullParameter(r103, "startValue");
            Intrinsics.checkNotNullParameter(r104, "endValue");
            b r105 = new b();
            float r106 = r103.f197587a;
            r105.f197587a = r106 + ((r104.f197587a - r106) * r100);
            float r107 = r103.f197588b;
            r105.f197588b = r107 + (r100 * (r104.f197588b - r107));
            return r105;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f197587a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f197588b;

        public b() {
        }

        public b(float r100, float r101) {
            this.f197587a = r100;
            this.f197588b = r101;
        }
    }

    public g() {
        this.f197586a = new Stack();
    }
}
