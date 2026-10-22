package xk2;

import android.os.Bundle;
import android.os.Handler;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.livesdk.livecommerce.network.response.ECRedPacketResponse;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdkapi.room.state.RoomState;
import io.reactivex.disposables.Disposable;
import java.util.Random;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class a implements bk2.d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C8247a f564179h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f564180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f564181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f564182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JSONObject f564183d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f564184e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f564185f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final bk2.d f564186g;

    /* JADX INFO: renamed from: xk2.a$a, reason: collision with other inner class name */
    public static final class C8247a {
        public C8247a() {
        }

        public static JSONObject a(Bundle r100) {
            if (r100 == null) goto L12;
            String r101 = r100.getString(RoomState.EXTRA_JSON_STR_ACTIVITY_TRANSMISSION);
            if (r101 == null) goto L12;
            Object r102 = new JSONObject(r101).opt("ad_red_packet_ecp");     // Catch: Exception -> L14
            if ((r102 instanceof JSONObject) == false) goto L9;
            JSONObject r103 = (JSONObject) r102;     // Catch: Exception -> L14
        L15:
            return r103;
        L9:
            if ((r102 instanceof String) == false) goto L12;
            r103 = new JSONObject((String) r102);     // Catch: Exception -> L14
        L12:
            r103 = null;
            goto L15
        }
    }

    @Override // bk2.d
    public final Disposable add(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        return this.f564186g.add(r100);
    }

    @Override // bk2.d
    public final void clearDisposable() {
        this.f564186g.clearDisposable();
    }

    @Override // bk2.d
    public final Disposable ignore(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        return this.f564186g.ignore(r100);
    }

    @Override // bk2.d
    public final void remove(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.f564186g.remove(r100);
    }

    static {
        f564179h = new C8247a();
    }

    public final void c() {
        e r100 = this.f564184e;
        if (r100 == null) goto L7;
        UtilityKotlinExtentionsKt.f153057b.removeCallbacks(r100);
        return;
    }

    public final void d() {
        e r100 = this.f564184e;
        if (r100 == null) goto L6;
        UtilityKotlinExtentionsKt.f153057b.removeCallbacks(r100);
    L6:
        clearDisposable();
        ECLiveHybridUtil.p("ecom.redpacket.load", this.f564185f);
    }

    public a(ECContext r100) {
        bk2.b r101 = new bk2.b();
        Intrinsics.checkNotNullParameter(r100, "ecContext");
        Intrinsics.checkNotNullParameter(r101, "disposableContext");
        this.f564186g = r101;
        this.f564180a = r100.getRoomId().getValue();
        this.f564181b = r100.getAnchorId().getValue();
        this.f564182c = r100.getAnchorSecId().getValue();
        C8247a r102 = f564179h;
        Bundle r103 = r100.getExtras().getValue();
        r102.getClass();
        this.f564183d = C8247a.a(r103);
        this.f564184e = new e(this);
        this.f564185f = new b(this);
    }

    public final void b(boolean r100) {
        if (r100 == false) goto L4;
        e(true);
    L4:
        ECLiveHybridUtil.m("ecom.redpacket.load", this.f564185f);
    }

    public final void e(boolean r100) {
        float r101 = new Random().nextFloat();
        if (r100 == false) goto L5;
        long r102 = (long) ((4 + (r101 * 2)) * 1000);
    L6:
        e r103 = this.f564184e;
        if (r103 == null) goto L11;
        Handler r104 = UtilityKotlinExtentionsKt.f153057b;
        r104.removeCallbacks(r103);
        r104.postDelayed(r103, r102);
        return;
    L11:
        return;
    L5:
        r102 = ((long) 1000) * (((long) (r101 * 420)) + 180);
        goto L6
    }

    public static final void a(a r100, ECRedPacketResponse r101) {
        if (r101 == null) goto L9;
        r100.getClass();
        Long r102 = r101.getExpireDuration();
        if (r102 == null) goto L9;
        long r103 = r102.longValue();
        e r104 = r100.f564184e;
        long r105 = r103 * ((long) 1000);
        if (r104 == null) goto L12;
        Handler r106 = UtilityKotlinExtentionsKt.f153057b;
        r106.removeCallbacks(r104);
        r106.postDelayed(r104, r105);
        return;
    L12:
        return;
    L9:
        r100.e(false);
    }
}
