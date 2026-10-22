package mq0;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.android.livesdk.config.ce0;
import com.bytedance.android.livesdk.config.sc1;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f514780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f514781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f514782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Long, Long> f514783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f514784e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final oq0.a f514785f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.live.openplatform.impl.miniappaudience.intention.a f514786g;

    /* JADX INFO: renamed from: mq0.a$a, reason: collision with other inner class name */
    public static final class C6839a {
    }

    public static final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f514787a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            if (r100.what != 1) goto L7;
            this.f514787a.f514786g.a("auto_show_explain_card");
            return;
        }

        public b(a r100, Looper r101) {
            this.f514787a = r100;
            super(r101);
        }
    }

    static {
    }

    public a(oq0.a r100, com.bytedance.android.live.openplatform.impl.miniappaudience.intention.a r101) {
        Intrinsics.checkNotNullParameter(r100, "prefHelper");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f514785f = r100;
        this.f514786g = r101;
        sc1 r102 = ce0.f119941a.getValue().b();
        if (r102 == null) goto L5;
        long r103 = r102.c();
    L6:
        this.f514780a = r103;
        if (r102 == null) goto L9;
        long r104 = r102.e();
    L10:
        long r105 = 1000;
        this.f514781b = r104 * r105;
        if (r102 == null) goto L13;
        long r106 = r102.a();
    L14:
        this.f514782c = r106 * r105;
        this.f514783d = new LinkedHashMap();
        this.f514784e = new b(this, Looper.getMainLooper());
        return;
    L13:
        r106 = 10;
        goto L14
    L9:
        r104 = 600;
        goto L10
    L5:
        r103 = 1;
        goto L6
    }
}
