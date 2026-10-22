package com.bytedance.android.livesdk.livecommerce.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListFragment;
import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListViewModel;
import fh2.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class ECHostNoCouponLayout extends FrameLayout {
    public View a;
    public TextView b;
    public TextView c;
    public b d;

    public class a implements View.OnClickListener {
        public final /* synthetic */ ECHostNoCouponLayout a;

        public a(ECHostNoCouponLayout r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            b r3 = this.a.d;
            if (r3 == null) goto L6;
            LiveRoomCouponListFragment r4 = ((o) r3).a;
            int r0 = LiveRoomCouponListFragment.x;
            ((LiveRoomCouponListViewModel) r4.g).bindCoupon(r4.getFragmentManager());
            return;
        }
    }

    public interface b {
    }

    public abstract TextView a(View r1);

    public abstract TextView b(View r1);

    public TextView getBindCouponTextView() {
        return this.b;
    }

    public ECHostNoCouponLayout(Context r1) {
        super(r1);
        c(r1);
    }

    public final void c(Context r4) {
        ScrollView r0 = new ScrollView(r4);
        r0.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r0.setFillViewport(true);
        addView(r0);
        View r5 = View.inflate(r4, 2131560767, r0);
        this.a = r5;
        this.b = b(r5);
        this.c = a(this.a);
        TextView r6 = this.b;
        if (r6 == null) goto L6;
        r6.setOnClickListener(new a(this));
        return;
    }

    public void setBindCouponClickListener(b r1) {
        this.d = r1;
    }

    public void setBindNotice(String r2) {
        TextView r0 = this.c;
        if (r0 == null) goto L6;
        r0.setText(r2);
        return;
    }

    public ECHostNoCouponLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        c(r1);
    }

    public ECHostNoCouponLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        c(r1);
    }
}
