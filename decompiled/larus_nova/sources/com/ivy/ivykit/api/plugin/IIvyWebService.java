package com.ivy.ivykit.api.plugin;

import android.content.Context;
import android.graphics.Bitmap;
import com.ss.android.lark.utils.statistics.PerfLog;
import ix7.e;
import ix7.f;
import ix7.g;
import ix7.h;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ivy/ivykit/api/plugin/IIvyWebService;", "", "Companion", "ivy_api_release"}, k = 1, mv = {1, 7, 1})
public interface IIvyWebService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f278339a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ivy/ivykit/api/plugin/IIvyWebService$Companion;", "Lcom/ivy/ivykit/api/plugin/IIvyWebService;", "<init>", "()V", "ivy_api_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion implements IIvyWebService {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f278340b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<IIvyWebService> f278341c = null;

        private Companion() {
        }

        static {
            f278340b = new Companion();
            f278341c = LazyKt.lazy(IIvyWebService$Companion$impl$2.INSTANCE);
        }

        @Override // com.ivy.ivykit.api.plugin.IIvyWebService
        public final void c(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            IIvyWebService r101 = f278341c.getValue();
            if (r101 == null) goto L6;
            r101.c(r100);
            return;
        }

        @Override // com.ivy.ivykit.api.plugin.IIvyWebService
        public final kx7.c b(String r100, lx7.a r101, Context r102) {
            Intrinsics.checkNotNullParameter(r100, "schema");
            Intrinsics.checkNotNullParameter(r101, "webViewClient");
            Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
            IIvyWebService r103 = f278341c.getValue();
            if (r103 != null) goto L7;
            return null;
        L7:
            return r103.b(r100, r101, r102);
        }

        @Override // com.ivy.ivykit.api.plugin.IIvyWebService
        public final lx7.a a(String r110, String r111, e r112, ix7.d r113, f r114, h r115, g r116, Bitmap r117) {
            Intrinsics.checkNotNullParameter(r110, "bizId");
            Intrinsics.checkNotNullParameter(r111, "schema");
            IIvyWebService r100 = f278341c.getValue();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.a(r110, r111, r112, r113, r114, r115, r116, r117);
        }
    }

    /* JADX INFO: loaded from: classes23.dex */
    public static final class a {
        public static /* synthetic */ lx7.a a(Companion r110, String r111, String r112, e r113, ix7.d.a r114, f r115, h r116, g r117, Bitmap r210, int r211) {
            if ((r211 & 8) == 0) goto L5;
            ix7.d.a r100 = null;
        L7:
            if ((r211 & 16) == 0) goto L9;
            f r101 = null;
        L11:
            if ((r211 & 32) == 0) goto L13;
            h r102 = null;
        L15:
            if ((r211 & 64) == 0) goto L17;
            g r118 = null;
        L19:
            if ((r211 & 128) == 0) goto L21;
            Bitmap r119 = null;
        L23:
            return r110.a(r111, r112, r113, r100, r101, r102, r118, r119);
        L21:
            r119 = r210;
            goto L23
        L17:
            r118 = r117;
            goto L19
        L13:
            r102 = r116;
            goto L15
        L9:
            r101 = r115;
            goto L11
        L5:
            r100 = r114;
            goto L7
        }
    }

    static {
        f278339a = Companion.f278340b;
    }

    lx7.a a(String r100, String r101, e r102, ix7.d r103, f r104, h r105, g r106, Bitmap r107);

    kx7.c b(String r100, lx7.a r101, Context r102);

    void c(Context r100);
}
