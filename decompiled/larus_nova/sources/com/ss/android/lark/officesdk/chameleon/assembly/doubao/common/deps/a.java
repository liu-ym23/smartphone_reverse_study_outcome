package com.ss.android.lark.officesdk.chameleon.assembly.doubao.common.deps;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.permission.StoragePermissionUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a implements ntb.b {

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.chameleon.assembly.doubao.common.deps.a$a, reason: collision with other inner class name */
    public static final class C5149a implements com.ss.android.lark.utils.h.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f433131a;

        public C5149a(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f433131a = r100;
        }

        @Override // com.ss.android.lark.utils.h.e
        public final /* synthetic */ void a(boolean r100) {
            this.f433131a.invoke(Boolean.valueOf(r100));
        }
    }

    public a() {
    }

    @Override // ntb.b
    public final boolean P(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return StoragePermissionUtils.d(r100, 14);
    }

    @Override // ntb.b
    public final void n0(FragmentActivity r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "callback");
        com.ss.android.lark.utils.h.b(r100, new C5149a(r101));
    }
}
