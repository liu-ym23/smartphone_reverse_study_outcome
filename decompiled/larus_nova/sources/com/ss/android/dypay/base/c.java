package com.ss.android.dypay.base;

import android.app.Activity;
import java.util.Stack;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f408438a = null;

    public static final class a extends Lambda implements Function0<Stack<Activity>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f408439a = null;

        static {
            f408439a = new a();
        }

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Stack<Activity> invoke() {
            return new Stack();
        }
    }

    static {
        f408438a = LazyKt.lazy(a.f408439a);
    }
}
