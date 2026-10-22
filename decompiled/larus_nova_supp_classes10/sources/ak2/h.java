package ak2;

import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.commerce.param.ILivePromotionActionListener;
import com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomFunctionHandler;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h implements com.bytedance.android.livesdk.livecommerce.room.api.c {
    public final Object a;

    public static final class a implements be.b {
        public final /* synthetic */ h a;

        public a(h r1) {
            this.a = r1;
        }

        public final void onClickPromotion(String r3, String r4, String r5, JSONObject r6) {
            Object r0 = this.a.a;
            if ((r0 instanceof ILiveRoomFunctionHandler) == false) goto L10;
            if (r0 == null) goto L8;
            ((ILiveRoomFunctionHandler) r0).getLogger(ILivePromotionActionListener.class).onClickPromotion(r3, r4, r5, r6);
            return;
        L8:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.room.handler.ILiveRoomFunctionHandler");
        L10:
            throw new Exception("realHandler must be ILiveRoomFunctionHandler");
        }
    }

    public static final class b<T, R> implements Function {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((IBaseUser) r2, "it");
            return new ge.a();
        }
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.c
    public final void h(String r2, Bundle r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "businesskey");
        Intrinsics.checkNotNullParameter(r3, "businessBundle");
        Intrinsics.checkNotNullParameter(r4, "clickMethod");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.c
    public final void previewCompShowEvent() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.c
    public final void sendLogger(String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "logExtra");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.c
    public final void e() {
        Object r0 = this.a;
        if ((r0 instanceof td.b) == false) goto L6;
        ((td.b) r0).e();
        return;
    L6:
        if ((r0 instanceof IBaseLiveRoomFunctionHandler) == false) goto L10;
        ((IBaseLiveRoomFunctionHandler) r0).startVBoost(0);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.c
    public final boolean isLinkmic() {
        Object r0 = this.a;
        if ((r0 instanceof td.b) == false) goto L7;
        ((td.b) r0).isLinkmic();
        return false;
    L7:
        if ((r0 instanceof IBaseLiveRoomFunctionHandler) == false) goto L11;
        return ((IBaseLiveRoomFunctionHandler) r0).isLinkmic();
    L11:
        throw new IllegalStateException("functionHandler is illegal");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.c
    public final void onPurchasingIntentionAction() {
        Object r0 = this.a;
        if ((r0 instanceof td.b) == false) goto L6;
        ((td.b) r0).onPurchasingIntentionAction();
        return;
    L6:
        if ((r0 instanceof IBaseLiveRoomFunctionHandler) == false) goto L10;
        ((IBaseLiveRoomFunctionHandler) r0).onPurchasingIntentionAction();
        return;
    }

    public h(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        this.a = r2;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.c
    public final void b(int r3) {
        Object r0 = this.a;
        if ((r0 instanceof td.b) == false) goto L6;
        ((td.b) r0).b(r3);
        return;
    L6:
        if ((r0 instanceof IBaseLiveRoomFunctionHandler) == false) goto L10;
        ((IBaseLiveRoomFunctionHandler) r0).fullDialogHoverStateChange(r3, false);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.c
    public final void c(boolean r3) {
        Object r0 = this.a;
        if ((r0 instanceof td.b) == false) goto L6;
        ((td.b) r0).c(r3);
        return;
    L6:
        if ((r0 instanceof IBaseLiveRoomFunctionHandler) == false) goto L10;
        ((IBaseLiveRoomFunctionHandler) r0).onPermissionChange(0, r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.c
    public final <T extends be.a> T getLogger(Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "loggerClass");
        Object r0 = this.a;
        if ((r0 instanceof td.b) == false) goto L7;
        return ((td.b) r0).getLogger(r3);
    L7:
        if ((r0 instanceof IBaseLiveRoomFunctionHandler) == false) goto L15;
        if (Intrinsics.areEqual(r3, be.b.class) == false) goto L13;
        return new a(this);
    L13:
        throw new Exception("unknown logger class");
    L15:
        throw new IllegalStateException("functionHandler is illegal");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.c
    public final void i(f<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "bitmapObserver");
        Object r0 = this.a;
        if ((r0 instanceof td.b) == false) goto L6;
        ((td.b) r0).h(r3);
        return;
    L6:
        if ((r0 instanceof IBaseLiveRoomFunctionHandler) == false) goto L10;
        ((IBaseLiveRoomFunctionHandler) r0).takeLiveRoomScreenshot(r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.c
    public final Observable<ge.a> g(Context r4, ge.b r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "params");
        Object r0 = this.a;
        if ((r0 instanceof td.b) == false) goto L7;
        return ((td.b) r0).g(r4, r5);
    L7:
        if ((r0 instanceof IBaseLiveRoomFunctionHandler) == false) goto L14;
        IBaseLiveRoomFunctionHandler r1 = (IBaseLiveRoomFunctionHandler) r0;
        com.bytedance.android.livesdk.user.l.a r2 = new com.bytedance.android.livesdk.user.l.a();
        r2.d = r5.d;
        r2.g = r5.f;
        r2.e = r5.e;
        r2.c = r5.c;
        r2.b = r5.b;
        r2.a = r5.a;
        Bundle r6 = r5.g;
        if (r6 == Bundle.EMPTY) goto L11;
        r2.h = r6;
    L11:
        Unit r7 = Unit.INSTANCE;
        return r1.loginIn(r4, new com.bytedance.android.livesdk.user.l(r2)).map(b.a);
    L14:
        throw new IllegalStateException("functionHandler is illegal");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.c
    public final void a(FragmentActivity r3, String r4, Window r5) {
        Object r0 = this.a;
        if ((r0 instanceof td.b) == false) goto L6;
        ((td.b) r0).f();
        return;
    L6:
        if ((r0 instanceof IBaseLiveRoomFunctionHandler) == false) goto L10;
        ((IBaseLiveRoomFunctionHandler) r0).detachWindow(r3, r4, r5);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.c
    public final void f(FragmentActivity r3, String r4, Window r5) {
        Object r0 = this.a;
        if ((r0 instanceof td.b) == false) goto L6;
        ((td.b) r0).a();
        return;
    L6:
        if ((r0 instanceof IBaseLiveRoomFunctionHandler) == false) goto L10;
        ((IBaseLiveRoomFunctionHandler) r0).toHalfScreen(r3, r4, r5);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.c
    public final boolean insertLegalMessage(long r3, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "content");
        Object r0 = this.a;
        if ((r0 instanceof td.b) == false) goto L7;
        return ((td.b) r0).insertLegalMessage(r3, r5);
    L7:
        if ((r0 instanceof IBaseLiveRoomFunctionHandler) == false) goto L11;
        return ((IBaseLiveRoomFunctionHandler) r0).insertLegalMessage(r3, r5, r6);
    L11:
        throw new IllegalStateException("functionHandler is illegal");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.c
    public final void d(FragmentActivity r3, String r4, Window r5, Function2 r6) {
        Object r0 = this.a;
        if ((r0 instanceof td.b) == false) goto L6;
        ((td.b) r0).d();
        return;
    L6:
        if ((r0 instanceof IBaseLiveRoomFunctionHandler) == false) goto L10;
        ((IBaseLiveRoomFunctionHandler) r0).attachWindow(r3, r4, r5, r6);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.c
    public final void jetDanmaku(String r9, long r10, String r12, String r13) {
        Object r0 = this.a;
        if ((r0 instanceof td.b) == false) goto L6;
        ((td.b) r0).jetDanmaku(r9, r10, r12, r13);
        return;
    L6:
        if ((r0 instanceof IBaseLiveRoomFunctionHandler) == false) goto L10;
        ((IBaseLiveRoomFunctionHandler) r0).jetDanmaku(r9, r10, r12, r13);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.c
    public final void onCouponMessage(int r12, long r13, String r15, int r16, long r17) {
        Object r1 = this.a;
        if ((r1 instanceof td.b) == false) goto L6;
        ((td.b) r1).onCouponMessage(r12, r13, r15, r16, r17);
        return;
    L6:
        if ((r1 instanceof IBaseLiveRoomFunctionHandler) == false) goto L10;
        ((IBaseLiveRoomFunctionHandler) r1).onCouponMessage(r12, r13, r15, r16, r17);
        return;
    }
}
