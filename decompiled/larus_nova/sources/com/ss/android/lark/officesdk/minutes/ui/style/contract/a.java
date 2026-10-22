package com.ss.android.lark.officesdk.minutes.ui.style.contract;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C5216a f436888a = null;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.style.contract.a$a, reason: collision with other inner class name */
    public static final class C5216a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C5216a f436889a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C5217a f436890b = null;

        /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.style.contract.a$a$a, reason: collision with other inner class name */
        public static final class C5217a implements a {
            public C5217a() {
            }

            @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.a
            public final void create(Context r100) {
                Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            }
        }

        public C5216a() {
        }

        static {
            f436889a = new C5216a();
            f436890b = new C5217a();
        }
    }

    static {
        f436888a = C5216a.f436889a;
    }

    void create(Context r100);
}
