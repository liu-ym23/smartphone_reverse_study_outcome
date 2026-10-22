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
import com.larus.nova.R;

/* JADX INFO: loaded from: classes10.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f476969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LiveRoomCouponListFragment f476970b;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            r100.setVisibility(8);
        }
    }

    public final void a() {
        Context r100 = this.f476970b.getContext();
        if (r100 == null) goto L17;
        LiveRoomCouponListFragment r101 = this.f476970b;
        View r102 = this.f476969a;
        int r103 = LiveRoomCouponListFragment.f147680x;
        r101.getClass();
        Rect r104 = new Rect();
        if (r102 == null) goto L9;
        View r105 = r101.f147647d;
        if ((r105 instanceof ViewGroup) == false) goto L9;
        r102.getFocusedRect(r104);
        ((ViewGroup) r105).offsetDescendantRectToMyCoords(r102, r104);
    L9:
        int r106 = (r104.left + r104.right) / 2;
        int r107 = r104.bottom;
        this.f476970b.f147683k.removeAllViews();
        this.f476970b.f147683k.setVisibility(0);
        ECGuideBubbleView r108 = new ECGuideBubbleView(r100);
        r108.setOnClickListener(new a());
        VM r109 = this.f476970b.f147650g;
        if (r109 != 0) goto L12;
    L14:
        String r110 = this.f476970b.getString(R.string.ec_can_end_distribute_coupon);
    L15:
        r108.setSingleData(r106, r107, r110, "end_coupon");
        this.f476970b.f147683k.addFunctionLayer(r108);
        Message r111 = Message.obtain();
        r111.what = 2;
        new com.bytedance.android.livesdk.livecommerce.view.countdown.e(Looper.getMainLooper(), (com.bytedance.android.livesdk.livecommerce.view.countdown.e.a) this.f476970b.f147650g).sendMessageDelayed(r111, 5000);
        return;
    L12:
        if (((LiveRoomCouponListViewModel) r109).getEndCouponHint() == null) goto L14;
        r110 = ((LiveRoomCouponListViewModel) this.f476970b.f147650g).getEndCouponHint();
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

    public h(LiveRoomCouponListFragment r100, View r101) {
        this.f476970b = r100;
        this.f476969a = r101;
    }
}
