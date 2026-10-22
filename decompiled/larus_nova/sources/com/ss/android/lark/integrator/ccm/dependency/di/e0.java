package com.ss.android.lark.integrator.ccm.dependency.di;

import android.content.Context;
import androidx.arch.core.util.Function;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e0 implements com.bytedance.ee.bear.lynx.api.f {

    public static final class a implements com.bytedance.ee.bear.lark.dependency.p0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function<String, Boolean> f427851a;

        public a(Function<String, Boolean> r100) {
            this.f427851a = r100;
        }

        @Override // com.bytedance.ee.bear.lark.dependency.p0
        public final boolean a(String r100) {
            return this.f427851a.apply(r100).booleanValue();
        }
    }

    public e0() {
    }

    @Override // com.bytedance.ee.bear.lynx.api.f
    public final void b() {
        com.bytedance.ee.bear.lark.dependency.z r100 = (com.bytedance.ee.bear.lark.dependency.z) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.z.class);
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    @Override // com.bytedance.ee.bear.lynx.api.f
    public final void a(Context r100, Function<String, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "resultCallback");
        a r102 = new a(r101);
        ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).J0(r100, new int[]{0}, r102);
    }
}
