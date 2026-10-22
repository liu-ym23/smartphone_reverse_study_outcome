package com.bytedance.ee.bear.sheet.tab.view;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.sheet.tab.jsdata.SheetTabItem;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.ee.util.ui.RecyclerItemsDiff;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.Objects;
import mn5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetTabAdapter extends BaseItemDraggableAdapter<SheetTabItem, a> implements RecyclerItemsDiff.b<SheetTabItem> {
    public b a;
    public jn5.a b;
    public boolean c;

    public class a extends BaseViewHolder {
        public static final /* synthetic */ int d = 0;
        public final b a;
        public long b;
        public final /* synthetic */ SheetTabAdapter c;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.sheet.tab.view.SheetTabAdapter$a$a, reason: collision with other inner class name */
        public class C0180a extends GestureDetector.SimpleOnGestureListener {
            public final /* synthetic */ a a;

            public C0180a(a r1) {
                this.a = r1;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public final boolean onDoubleTapEvent(MotionEvent r7) {
                if (r7.getAction() != 1) goto L11;
                long r2 = r7.getEventTime();
                a r8 = this.a;
                if (r2 <= r8.b) goto L7;
                boolean r0 = true;
            L8:
                if (r0 == false) goto L10;
                r8.T3();
                goto L11
            L10:
                tt5.a.b("SheetTabAdapter", "bindTime is later than eventTime，ignore it...");
                goto L11
            L7:
                r0 = false;
            L11:
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public final boolean onSingleTapConfirmed(MotionEvent r6) {
                long r0 = r6.getEventTime();
                a r7 = this.a;
                if (r0 <= r7.b) goto L11;
                SheetTabItem r1 = r7.a.g;
                if (r1 != null) goto L8;
                return true;
            L8:
                if (r1.getSelected() == false) goto L10;
                r7.T3();
                return true;
            L10:
                r7.U3();
                return true;
            L11:
                tt5.a.b("SheetTabAdapter", "bindTime is later than eventTime, ignore it...");
                return true;
            }
        }

        public final void T3() {
            boolean r0 = j.a.a.getNetworkState().a();
            SheetTabItem r1 = this.a.g;
            if (r1 != null) goto L5;
            return;
        L5:
            if (this.c.b != null) goto L7;
            return;
        L7:
            if (r1.isEnabled() == true) goto L10;
            if (r0 == true) goto L10;
            return;
        L10:
            if (this.a.g.getSelected() == true) goto L12;
            this.c.b.d(this.a.g);
        L12:
            this.c.b.e(this.a.g);
        }

        public final void U3() {
            SheetTabItem r0 = this.a.g;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.getSelected() == true) goto L29;
            SheetTabItem r1 = this.a.g;
            if (r1 == null) goto L13;
            jn5.a r2 = this.c.b;
            if (r2 == null) goto L13;
            r2.d(r1);
        L13:
            if (this.a.g.isEnabled() == false) goto L30;
            b r3 = this.c.a;
            if (r3 == null) goto L20;
            SheetTabItem r4 = r3.g;
            if (r4 == null) goto L20;
            r4.setSelected(false);
            final int r5 = this.c.getData().indexOf(this.c.a.g);
        L21:
            this.a.g.setSelected(true);
            SheetTabAdapter r6 = this.c;
            r6.a = this.a;
            final int r7 = r6.getData().indexOf(this.a.g);
            if (r7 < 0) goto L24;
            com.bytedance.ee.util.ui.j.c(new mn5.a(this, r7));
        L24:
            if (r5 < 0) goto L28;
            com.bytedance.ee.util.ui.j.c(new mn5.b(this, r5));
            return;
        L28:
            return;
        L20:
            r5 = -1;
            goto L21
        L30:
            return;
        }

        private a(SheetTabAdapter r3, View r4) {
            this.c = r3;
            super(r4);
            this.b = 0;
            this.a = new b(r4);
            c r5 = new c();
            r5.a = new GestureDetector(r4.getContext(), new C0180a(this));
            setOnTouchListener(2131386194, r5);
        }
    }

    public static class b {
        public final View a;
        public final ImageView b;
        public final ImageView c;
        public final ImageView d;
        public final TextView e;
        public final LinearLayout f;
        public SheetTabItem g;

        public b(View r2) {
            this.b = (ImageView) r2.findViewById(2131376385);
            this.e = (TextView) r2.findViewById(2131391419);
            this.c = (ImageView) r2.findViewById(2131376393);
            this.a = r2.findViewById(2131386194);
            this.d = (ImageView) r2.findViewById(2131376161);
            this.f = (LinearLayout) r2.findViewById(2131376653);
        }
    }

    public SheetTabAdapter() {
        super(2131564588, new ArrayList());
        this.c = true;
    }

    public final void onItemDragEnd(RecyclerView.ViewHolder r2) {
        super.onItemDragEnd(r2);
        if ((r2 instanceof a) == false) goto L6;
        ((a) r2).U3();
        return;
    }

    public final boolean areContentsTheSame(Object r1, Object r2) {
        return SheetTabItem.contentEquals((SheetTabItem) r1, (SheetTabItem) r2);
    }

    public final boolean areItemsTheSame(Object r1, Object r2) {
        return Objects.equals((SheetTabItem) r1, (SheetTabItem) r2);
    }

    public final void convert(BaseViewHolder r9, Object r10) {
        a r11 = (a) r9;
        SheetTabItem r12 = (SheetTabItem) r10;
        int r0 = a.d;
        r11.getClass();
        r11.b = SystemClock.uptimeMillis();
        b r1 = r11.a;
        boolean r2 = r11.c.c;
        r1.g = r12;
        r1.a.setTag(r12);
        r1.e.setText(r12.getName());
        r1.e.setMaxWidth((int) (((double) n.v()) * 0.3d));
        ImageView r3 = r1.b;
        int r4 = 8;
        int r5 = 0;
        if (r12.isLocked() == false) goto L5;
        int r6 = 0;
    L6:
        r3.setVisibility(r6);
        ImageView r7 = r1.c;
        if (r12.getSelected() == false) goto L10;
        if (r2 == false) goto L10;
        int r8 = 0;
    L11:
        r7.setVisibility(r8);
        if (TextUtils.isEmpty(r12.getRenderedTabColor()) == true) goto L14;
        r1.f.setVisibility(0);
        r1.f.setBackgroundColor(ColorUtils.h(r12.getRenderedTabColor()));
    L16:
        if (r12.getCustomIcon() == null) goto L52;
        SheetTabItem.CustomIcon r13 = r12.getCustomIcon();
        if (r13.getType() != 1) goto L21;
        r1.d.setImageResource(2131238066);
    L51:
        r4 = 0;
        goto L52
    L21:
        if (r13.getType() != 0) goto L30;
        if (r13.isValidIconUrl() == false) goto L30;
        RequestManager r14 = Glide.with(r1.d.getContext());
        if (r12.getSelected() == false) goto L27;
        String r15 = r13.getSelectedUrl();
    L28:
        r14.load(new BearGlideUrl(r15)).into(r1.d);
        goto L51
    L27:
        r15 = r13.getUnselectedUrl();
    L30:
        if (r13.getType() != 2) goto L52;
        if (r13.isValidIconId() == false) goto L52;
        Context r16 = r1.d.getContext();
        if (r12.getSelected() == false) goto L36;
        String r17 = r13.getSelectedUrl();
    L37:
        int r18 = n.n(r16, r17);
        if (r12.getSelected() == false) goto L43;
        if (TextUtils.isEmpty(r13.getSelectedColorId()) == true) goto L43;
        String r19 = r13.getSelectedColorId();
    L48:
        if (r19 != null) goto L50;
        r1.d.setImageResource(r18);
        goto L51
    L50:
        ImageView r20 = r1.d;
        r20.setImageDrawable(l.a(r20.getContext(), r18, n.i(r1.d.getContext(), r19)));
    L43:
        if (r12.getSelected() == false) goto L45;
    L47:
        r19 = null;
        goto L48
    L45:
        if (TextUtils.isEmpty(r13.getUnselectedColorId()) == true) goto L47;
        r19 = r13.getUnselectedColorId();
        goto L48
    L36:
        r17 = r13.getUnselectedUrl();
    L52:
        r1.d.setVisibility(r4);
        if (r4 != 0) goto L55;
        r5 = n.d(2);
    L55:
        ViewGroup.LayoutParams r21 = r1.b.getLayoutParams();
        if ((r21 instanceof ViewGroup.MarginLayoutParams) == false) goto L58;
        ((ViewGroup.MarginLayoutParams) r21).leftMargin = r5;
        r1.b.setLayoutParams(r21);
    L58:
        boolean r22 = r12.getSelected();
        View r23 = r1.a;
        if (r22 == false) goto L61;
        float r24 = 10.0f;
    L62:
        r23.setElevation(r24);
        r1.a.setSelected(r22);
        r1.b.setSelected(r22);
        r1.e.setSelected(r22);
        r1.c.setSelected(r22);
        r1.d.setSelected(r22);
        r1.f.setSelected(r22);
        boolean r25 = r12.isEnabled();
        r1.e.setEnabled(r25);
        if (r12.getSelected() == false) goto L66;
        SheetTabAdapter r110 = r11.c;
        r110.a = r11.a;
        return;
    L66:
        return;
    L61:
        r24 = 0.0f;
        goto L62
    L14:
        r1.f.setVisibility(8);
    L10:
        r8 = 8;
        goto L11
    L5:
        r6 = 8;
        goto L6
    }
}
