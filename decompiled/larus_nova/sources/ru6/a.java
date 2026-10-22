package ru6;

import android.net.Uri;
import com.bytedance.ies.bullet.prefetchv2.InternalConfigLoader;
import com.bytedance.ies.bullet.prefetchv2.b;
import com.bytedance.ies.bullet.prefetchv2.h;
import com.bytedance.ies.bullet.prefetchv2.m;
import com.bytedance.ies.bullet.prefetchv2.t;
import com.bytedance.locallife.biz.common.utils.c;
import com.bytedance.locallife.hybrid.bridge.network.LifeSaasNetwork;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class a extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f539271a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f539272b;

    /* JADX INFO: renamed from: ru6.a$a, reason: collision with other inner class name */
    public static final class C7536a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C7536a f539273a = null;

        static {
            f539273a = new C7536a();
        }

        public C7536a() {
        }

        @Override // com.bytedance.ies.bullet.prefetchv2.b
        public final h a(Uri r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "pageUri");
            Intrinsics.checkNotNullParameter(r101, "bid");
            h r103 = InternalConfigLoader.f247498a.a(r100, r101, r102);
            String r104 = null;
            if (r103 != null) goto L5;
            return null;
        L5:
            h r105 = new h(new JSONObject(r103.f247544a.toString()));
            String r106 = r103.f247545b;
            Intrinsics.checkNotNullParameter(r106, "<set-?>");
            r105.f247545b = r106;
            String r107 = r103.f247547d;
            if (r107.length() <= 0) goto L8;
            boolean r108 = true;
        L10:
            if (Boolean.valueOf(r108).booleanValue() == false) goto L12;
            r104 = r107;
        L12:
            if (r104 != null) goto L14;
            r104 = "default_bid";
        L14:
            Intrinsics.checkNotNullParameter(r104, "<set-?>");
            r105.f247547d = r104;
            Iterator r109 = ((ArrayList) r105.f247546c).iterator();
        L16:
            if (r109.hasNext() == false) goto L29;
            t r110 = (t) r109.next();
            String r111 = r110.f247584a;
            if (r111 != null) goto L20;
        L23:
            boolean r112 = true;
        L24:
            if (r112 == true) goto L16;
            String r113 = LifeSaasNetwork.b(r111);
            if (Intrinsics.areEqual(r113, r111) == true) goto L28;
            c.a("LifeSaasPrefetch", "rewrite prefetch url: " + r111 + " -> " + r113);
        L28:
            r110.f247584a = r113;
            goto L16
        L20:
            if (r111.length() == 0) goto L23;
            r112 = false;
            goto L24
        L29:
            return r105;
        L8:
            r108 = false;
            goto L10
        }
    }

    static {
        f539271a = new a();
    }

    public a() {
    }

    @Override // com.bytedance.ies.bullet.prefetchv2.m
    public final b a() {
        return C7536a.f539273a;
    }
}
