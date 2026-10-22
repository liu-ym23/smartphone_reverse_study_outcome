package com.larus.paging;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.open.SocialConstants;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes29.dex */
public final class k0<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k0<Object> f363874c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Flow<PageEvent<T>> f363875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e1 f363876b;

    public static final class a implements e1 {
        public a() {
        }

        @Override // com.larus.paging.e1
        public final void a(f1 r100) {
            Intrinsics.checkNotNullParameter(r100, "viewportHint");
        }

        @Override // com.larus.paging.e1
        public final void retry() {
        }
    }

    public static final class b {
    }

    static {
        a r100 = new a();
        f363874c = new k0(new kotlinx.coroutines.flow.n(PageEvent.Insert.f363671g), r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k0(Flow<? extends PageEvent<T>> r100, e1 r101) {
        Intrinsics.checkNotNullParameter(r100, BytedCertConstant.CertKey.FLOW);
        Intrinsics.checkNotNullParameter(r101, SocialConstants.PARAM_RECEIVER);
        this.f363875a = r100;
        this.f363876b = r101;
    }
}
