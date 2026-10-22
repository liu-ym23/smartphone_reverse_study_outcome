package xk2;

import android.os.Bundle;
import android.os.Handler;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.livesdk.livecommerce.network.response.ECRedPacketResponse;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import io.reactivex.disposables.Disposable;
import java.util.Random;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements bk2.d {
    public static final C0189a h = null;
    public final String a;
    public final String b;
    public final String c;
    public final JSONObject d;
    public final e e;
    public final b f;
    public final bk2.d g;

    /* JADX INFO: renamed from: xk2.a$a, reason: collision with other inner class name */
    public static final class C0189a {
        public C0189a() {
        }

        public static JSONObject a(Bundle r1) {
            if (r1 == null) goto L12;
            String r2 = r1.getString("EXTRA_JSON_STR_ACTIVITY_TRANSMISSION");
            if (r2 == null) goto L12;
            Object r3 = new JSONObject(r2).opt("ad_red_packet_ecp");     // Catch: Exception -> L14
            if ((r3 instanceof JSONObject) == false) goto L9;
            JSONObject r4 = (JSONObject) r3;     // Catch: Exception -> L14
        L15:
            return r4;
        L9:
            if ((r3 instanceof String) == false) goto L12;
            r4 = new JSONObject((String) r3);     // Catch: Exception -> L14
        L12:
            r4 = null;
            goto L15
        }
    }

    @Override // bk2.d
    public final Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        return this.g.add(r2);
    }

    @Override // bk2.d
    public final void clearDisposable() {
        this.g.clearDisposable();
    }

    @Override // bk2.d
    public final Disposable ignore(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        return this.g.ignore(r2);
    }

    @Override // bk2.d
    public final void remove(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.g.remove(r2);
    }

    static {
        h = new C0189a();
    }

    public final void c() {
        e r0 = this.e;
        if (r0 == null) goto L7;
        UtilityKotlinExtentionsKt.b.removeCallbacks(r0);
        return;
    }

    public final void d() {
        e r0 = this.e;
        if (r0 == null) goto L6;
        UtilityKotlinExtentionsKt.b.removeCallbacks(r0);
    L6:
        clearDisposable();
        ECLiveHybridUtil.p("ecom.redpacket.load", this.f);
    }

    public a(ECContext r3) {
        bk2.b r0 = new bk2.b();
        Intrinsics.checkNotNullParameter(r3, "ecContext");
        Intrinsics.checkNotNullParameter(r0, "disposableContext");
        this.g = r0;
        this.a = (String) r3.getRoomId().getValue();
        this.b = (String) r3.getAnchorId().getValue();
        this.c = (String) r3.getAnchorSecId().getValue();
        C0189a r1 = h;
        Bundle r4 = (Bundle) r3.getExtras().getValue();
        r1.getClass();
        this.d = C0189a.a(r4);
        this.e = new e(this);
        this.f = new b(this);
    }

    public final void b(boolean r2) {
        if (r2 == false) goto L4;
        e(true);
    L4:
        ECLiveHybridUtil.m("ecom.redpacket.load", this.f);
    }

    public final void e(boolean r7) {
        float r0 = new Random().nextFloat();
        if (r7 == false) goto L5;
        long r1 = (long) ((4 + (r0 * 2)) * 1000);
    L6:
        e r8 = this.e;
        if (r8 == null) goto L11;
        Handler r2 = UtilityKotlinExtentionsKt.b;
        r2.removeCallbacks(r8);
        r2.postDelayed(r8, r1);
        return;
    L11:
        return;
    L5:
        r1 = ((long) 1000) * (((long) (r0 * 420)) + 180);
        goto L6
    }

    public static final void a(a r4, ECRedPacketResponse r5) {
        if (r5 == null) goto L9;
        r4.getClass();
        Long r6 = r5.getExpireDuration();
        if (r6 == null) goto L9;
        long r0 = r6.longValue();
        e r7 = r4.e;
        long r1 = r0 * ((long) 1000);
        if (r7 == null) goto L12;
        Handler r8 = UtilityKotlinExtentionsKt.b;
        r8.removeCallbacks(r7);
        r8.postDelayed(r7, r1);
        return;
    L12:
        return;
    L9:
        r4.e(false);
    }
}
