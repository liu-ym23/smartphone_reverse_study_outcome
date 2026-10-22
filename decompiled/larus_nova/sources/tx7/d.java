package tx7;

import android.content.Context;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostMediaDepend;
import com.ivy.ivykit.api.bridge.inject.IChooseMediaResultCallback;
import com.ss.android.lark.utils.statistics.PerfLog;
import hx7.j;
import hx7.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class d implements IHostMediaDepend {

    public static final class a implements IChooseMediaResultCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.sdk.xbridge.cn.runtime.depend.IChooseMediaResultCallback f547827a;

        public a(com.bytedance.sdk.xbridge.cn.runtime.depend.IChooseMediaResultCallback r100) {
            this.f547827a = r100;
        }

        @Override // com.ivy.ivykit.api.bridge.inject.IChooseMediaResultCallback
        public final void onFailure(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "msg");
            this.f547827a.onFailure(r100, r101);
        }

        @Override // com.ivy.ivykit.api.bridge.inject.IChooseMediaResultCallback
        public final void onSuccess(k r110, String r111) {
            Intrinsics.checkNotNullParameter(r110, "result");
            Intrinsics.checkNotNullParameter(r111, "msg");
            com.bytedance.sdk.xbridge.cn.runtime.depend.IChooseMediaResultCallback r100 = this.f547827a;
            re7.d r101 = new re7.d();
            List<k.a> r112 = r110.f487517a;
            if (r112 == null) goto L8;
            List<k.a> r113 = r112;
            ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
            Iterator<T> r114 = r113.iterator();
        L6:
            if (r114.hasNext() == false) goto L9;
            k.a r103 = (k.a) r114.next();
            re7.d.a r104 = new re7.d.a(r103.f487518a, r103.f487519b, r103.f487520c);
            r104.f537448d = r103.f487521d;
            r102.add(r104);
        L9:
            r101.f537444a = r102;
            r100.onSuccess(r101, r111);
            return;
        L8:
            r102 = null;
            goto L9
        }
    }

    public d() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostMediaDepend
    public final void handleJsInvoke(Context r100, re7.c r110, com.bytedance.sdk.xbridge.cn.runtime.depend.IChooseMediaResultCallback r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        j r101 = new j(r110.f537437a, r110.f537438b, r110.f537439c, r110.f537440d, r110.f537441e, r110.f537442f);
        r101.f487516g = r110.f537443g;
        a r112 = new a(r111);
        Map<Class<?>, com.ivy.ivykit.api.bridge.d<?>> r113 = com.ivy.ivykit.api.bridge.b.f278301a;
        hx7.c r114 = (hx7.c) com.ivy.ivykit.api.bridge.b.a(hx7.c.class);
        if (r114 == null) goto L6;
        r114.a(r100, r101, r112);
        return;
    }
}
