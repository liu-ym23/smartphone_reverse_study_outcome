package com.ss.android.lark.officesdk.minutes.ui.style.contract;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public interface c {

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f436891a = null;

        static {
            f436891a = new a();
        }

        public a() {
        }

        @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.c
        public final boolean a() {
            return false;
        }

        @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.c
        public final void b(i r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        }

        @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.c
        public final void c() {
        }

        @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.c
        public final void d() {
        }

        @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.c
        public final boolean e() {
            return false;
        }

        @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.c
        public final boolean f(i r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return false;
        }
    }

    boolean a();

    void b(i r100);

    void c();

    void d();

    boolean e();

    boolean f(i r100);
}
