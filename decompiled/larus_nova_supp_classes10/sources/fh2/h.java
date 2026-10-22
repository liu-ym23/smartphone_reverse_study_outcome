package fh2;

import android.content.Context;
import android.graphics.Rect;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListFragment;
import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListViewModel;
import com.bytedance.android.ui.ec.widget.guide.ECGuideBubbleView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ LiveRoomCouponListFragment b;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            r2.setVisibility(8);
        }
    }

    public final void a() {
        Context r0 = this.b.getContext();
        if (r0 == null) goto L17;
        LiveRoomCouponListFragment r1 = this.b;
        View r2 = this.a;
        int r3 = LiveRoomCouponListFragment.x;
        r1.getClass();
        Rect r4 = new Rect();
        if (r2 == null) goto L9;
        View r5 = r1.d;
        if ((r5 instanceof ViewGroup) == false) goto L9;
        r2.getFocusedRect(r4);
        ((ViewGroup) r5).offsetDescendantRectToMyCoords(r2, r4);
    L9:
        int r6 = (r4.left + r4.right) / 2;
        int r7 = r4.bottom;
        this.b.k.removeAllViews();
        this.b.k.setVisibility(0);
        ECGuideBubbleView r8 = new ECGuideBubbleView(r0);
        r8.setOnClickListener(new a());
        VM r9 = this.b.g;
        if (r9 != 0) goto L12;
    L14:
        String r10 = this.b.getString(2131896356);
    L15:
        r8.setSingleData(r6, r7, r10, "end_coupon");
        this.b.k.addFunctionLayer(r8);
        Message r11 = Message.obtain();
        r11.what = 2;
        new com.bytedance.android.livesdk.livecommerce.view.countdown.e(Looper.getMainLooper(), this.b.g).sendMessageDelayed(r11, 5000);
        return;
    L12:
        if (((LiveRoomCouponListViewModel) r9).getEndCouponHint() == null) goto L14;
        r10 = ((LiveRoomCouponListViewModel) this.b.g).getEndCouponHint();
        goto L15
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

    public h(LiveRoomCouponListFragment r1, View r2) {
        this.b = r1;
        this.a = r2;
    }
}
