package com.ivy.ivykit.plugin.impl.jsb;

import androidx.core.app.NotificationCompat;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.ivy.ivykit.api.bridge.e f278380a;

    public static final class a extends id7.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final id7.a f278381a;

        public a(id7.a r100) {
            this.f278381a = r100;
        }

        @Override // id7.a
        public final void a(le7.a<?> r110, Object r111) {
            Intrinsics.checkNotNullParameter(r110, NotificationCompat.CATEGORY_CALL);
            com.ivy.ivykit.api.bridge.e r100 = b.f278380a;
            if (r100 == null) goto L14;
            String r101 = r110.f508945c;
            String r102 = r110.f508943a;
            int r103 = r110.f508953k;
            Object r104 = r110.b();
            if ((r104 instanceof JSONObject) == false) goto L8;
            int r105 = gx7.a.f483121a;
            Map r106 = gx7.a.b((JSONObject) r104);
        L7:
            Map r107 = r106;
            r100.b(new com.ivy.ivykit.api.bridge.c(r101, r102, r103, r107, r110.f508946d, r110.f508954l, r110.f508955m, r110.d(), r110.f508944b, r110.c().name()));
            goto L14
        L8:
            boolean r108 = r104 instanceof Map;
            if (r108 == false) goto L12;
            if (r108 == false) goto L12;
            r106 = (Map) r104;
        L12:
            r106 = null;
        L14:
            id7.a r109 = this.f278381a;
            if (r109 == null) goto L18;
            r109.a(r110, r111);
            return;
        }

        @Override // id7.a
        public final boolean b(le7.a r100, me7.d r101, com.bytedance.sdk.xbridge.cn.protocol.d r102) {
            Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, "callback");
            com.ivy.ivykit.api.bridge.e r103 = b.f278380a;
            if (r103 == null) goto L5;
            r103.a(r100.f508945c, r101.f513516a.f513512b);
        L5:
            id7.a r104 = this.f278381a;
            if (r104 != null) goto L8;
        L10:
            return false;
        L8:
            if (r104.b(r100, r101, r102) != true) goto L10;
            return true;
        }
    }

    static {
    }
}
