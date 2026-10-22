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

/* JADX INFO: loaded from: classes10.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f476971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LiveRoomCouponListFragment f476972b;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f476973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f476974b;

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            LiveRoomCouponListFragment r101 = this.f476974b.f476972b;
            int r102 = LiveRoomCouponListFragment.f147680x;
            ((LiveRoomCouponListViewModel) r101.f147650g).openDistributeCouponDescFragment(this.f476973a, r101.getFragmentManager());
            com.bytedance.android.livesdk.livecommerce.event.u r103 = new com.bytedance.android.livesdk.livecommerce.event.u();
            r103.f("anchor_id", this.f476974b.f476972b.f147695w);
            r103.f("room_id", this.f476974b.f476972b.f147694v);
            r103.f("bubble_type", "coupon_detail");
            r103.f("page_name", "within_live");
            r103.f("carrier_type", "bubble");
            r103.k();
        }

        public a(i r100, Context r101) {
            this.f476974b = r100;
            this.f476973a = r101;
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f476975a;

        public b(i r100) {
            this.f476975a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            com.bytedance.android.livesdk.livecommerce.event.u r101 = new com.bytedance.android.livesdk.livecommerce.event.u();
            r101.f("anchor_id", this.f476975a.f476972b.f147695w);
            r101.f("room_id", this.f476975a.f476972b.f147694v);
            r101.f("bubble_type", "coupon_detail");
            r101.f("page_name", "before_live");
            r101.f("carrier_type", "button");
            r101.k();
            this.f476975a.f476972b.f147684l.performClick();
        }
    }

    public final void a() {
        Context r100 = this.f476972b.getContext();
        if (r100 == null) goto L11;
        LiveRoomCouponListFragment r101 = this.f476972b;
        ImageView r102 = r101.f147684l;
        Rect r103 = new Rect();
        if (r102 == null) goto L9;
        View r104 = r101.f147647d;
        if ((r104 instanceof ViewGroup) == false) goto L9;
        r102.getFocusedRect(r103);
        ((ViewGroup) r104).offsetDescendantRectToMyCoords(r102, r103);
    L9:
        int r105 = (r103.left + r103.right) / 2;
        int r106 = r103.bottom;
        this.f476972b.f147683k.removeAllViews();
        this.f476972b.f147683k.setVisibility(0);
        ECGuideBubbleView r107 = new ECGuideBubbleView(r100);
        r107.setOnClickListener(new a(this, r100));
        r107.setSingleData(r105, r106, this.f476971a, "coupon_detail");
        ECButtonCoverLayer r108 = new ECButtonCoverLayer(r100);
        r108.setData(r103);
        r108.setOnClickListener(new b(this));
        this.f476972b.f147683k.addFunctionLayer(r107).addFunctionLayer(r108);
        Message r109 = Message.obtain();
        r109.what = 1;
        new com.bytedance.android.livesdk.livecommerce.view.countdown.e(Looper.getMainLooper(), (com.bytedance.android.livesdk.livecommerce.view.countdown.e.a) this.f476972b.f147650g).sendMessageDelayed(r109, 5000);
        LiveRoomCouponListFragment r110 = this.f476972b;
        new q0(r110.f147694v, r110.f147695w).k();
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

    public i(LiveRoomCouponListFragment r100, String r101) {
        this.f476972b = r100;
        this.f476971a = r101;
    }
}
