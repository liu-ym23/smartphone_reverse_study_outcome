package fh2;

import android.content.Context;
import android.graphics.Rect;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListFragment;
import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListViewModel;
import com.bytedance.android.livesdk.livecommerce.event.q0;
import com.bytedance.android.ui.ec.widget.guide.ECButtonCoverLayer;
import com.bytedance.android.ui.ec.widget.guide.ECGuideBubbleView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ LiveRoomCouponListFragment b;

    public class a implements View.OnClickListener {
        public final /* synthetic */ Context a;
        public final /* synthetic */ i b;

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            LiveRoomCouponListFragment r4 = this.b.b;
            int r0 = LiveRoomCouponListFragment.x;
            ((LiveRoomCouponListViewModel) r4.g).openDistributeCouponDescFragment(this.a, r4.getFragmentManager());
            com.bytedance.android.livesdk.livecommerce.event.u r5 = new com.bytedance.android.livesdk.livecommerce.event.u();
            r5.f("anchor_id", this.b.b.w);
            r5.f("room_id", this.b.b.v);
            r5.f("bubble_type", "coupon_detail");
            r5.f("page_name", "within_live");
            r5.f("carrier_type", "bubble");
            r5.k();
        }

        public a(i r1, Context r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ i a;

        public b(i r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            com.bytedance.android.livesdk.livecommerce.event.u r4 = new com.bytedance.android.livesdk.livecommerce.event.u();
            r4.f("anchor_id", this.a.b.w);
            r4.f("room_id", this.a.b.v);
            r4.f("bubble_type", "coupon_detail");
            r4.f("page_name", "before_live");
            r4.f("carrier_type", "button");
            r4.k();
            this.a.b.l.performClick();
        }
    }

    public final void a() {
        Context r0 = this.b.getContext();
        if (r0 == null) goto L11;
        LiveRoomCouponListFragment r1 = this.b;
        ImageView r2 = r1.l;
        Rect r3 = new Rect();
        if (r2 == null) goto L9;
        View r4 = r1.d;
        if ((r4 instanceof ViewGroup) == false) goto L9;
        r2.getFocusedRect(r3);
        ((ViewGroup) r4).offsetDescendantRectToMyCoords(r2, r3);
    L9:
        int r5 = (r3.left + r3.right) / 2;
        int r6 = r3.bottom;
        this.b.k.removeAllViews();
        this.b.k.setVisibility(0);
        ECGuideBubbleView r7 = new ECGuideBubbleView(r0);
        r7.setOnClickListener(new a(this, r0));
        r7.setSingleData(r5, r6, this.a, "coupon_detail");
        ECButtonCoverLayer r8 = new ECButtonCoverLayer(r0);
        r8.setData(r3);
        r8.setOnClickListener(new b(this));
        this.b.k.addFunctionLayer(r7).addFunctionLayer(r8);
        Message r9 = Message.obtain();
        r9.what = 1;
        new com.bytedance.android.livesdk.livecommerce.view.countdown.e(Looper.getMainLooper(), this.b.g).sendMessageDelayed(r9, 5000);
        LiveRoomCouponListFragment r10 = this.b;
        new q0(r10.v, r10.w).k();
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public i(LiveRoomCouponListFragment r1, String r2) {
        this.b = r1;
        this.a = r2;
    }
}
