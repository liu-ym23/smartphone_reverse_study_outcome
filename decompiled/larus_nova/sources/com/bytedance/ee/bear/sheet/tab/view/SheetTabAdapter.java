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
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Objects;
import mn5.c;

/* JADX INFO: loaded from: classes18.dex */
public class SheetTabAdapter extends BaseItemDraggableAdapter<SheetTabItem, a> implements RecyclerItemsDiff.b<SheetTabItem> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f238387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public jn5.a f238388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f238389c;

    public class a extends BaseViewHolder {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int f238390d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f238391a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f238392b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SheetTabAdapter f238393c;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.sheet.tab.view.SheetTabAdapter$a$a, reason: collision with other inner class name */
        public class C3427a extends GestureDetector.SimpleOnGestureListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f238394a;

            public C3427a(a r100) {
                this.f238394a = r100;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public final boolean onDoubleTapEvent(MotionEvent r100) {
                if (r100.getAction() != 1) goto L11;
                long r101 = r100.getEventTime();
                a r102 = this.f238394a;
                if (r101 <= r102.f238392b) goto L7;
                boolean r103 = true;
            L8:
                if (r103 == false) goto L10;
                r102.T3();
                goto L11
            L10:
                tt5.a.b("SheetTabAdapter", "bindTime is later than eventTime，ignore it...");
                goto L11
            L7:
                r103 = false;
            L11:
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public final boolean onSingleTapConfirmed(MotionEvent r100) {
                long r101 = r100.getEventTime();
                a r102 = this.f238394a;
                if (r101 <= r102.f238392b) goto L11;
                SheetTabItem r103 = r102.f238391a.f238401g;
                if (r103 != null) goto L8;
                return true;
            L8:
                if (r103.getSelected() == false) goto L10;
                r102.T3();
                return true;
            L10:
                r102.U3();
                return true;
            L11:
                tt5.a.b("SheetTabAdapter", "bindTime is later than eventTime, ignore it...");
                return true;
            }
        }

        public final void T3() {
            boolean r100 = j.a.f217090a.getNetworkState().a();
            SheetTabItem r101 = this.f238391a.f238401g;
            if (r101 != null) goto L5;
            return;
        L5:
            if (this.f238393c.f238388b != null) goto L7;
            return;
        L7:
            if (r101.isEnabled() == true) goto L10;
            if (r100 == true) goto L10;
            return;
        L10:
            if (this.f238391a.f238401g.getSelected() == true) goto L12;
            this.f238393c.f238388b.d(this.f238391a.f238401g);
        L12:
            this.f238393c.f238388b.e(this.f238391a.f238401g);
        }

        public final void U3() {
            SheetTabItem r100 = this.f238391a.f238401g;
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.getSelected() == true) goto L29;
            SheetTabItem r101 = this.f238391a.f238401g;
            if (r101 == null) goto L13;
            jn5.a r102 = this.f238393c.f238388b;
            if (r102 == null) goto L13;
            r102.d(r101);
        L13:
            if (this.f238391a.f238401g.isEnabled() == false) goto L30;
            b r103 = this.f238393c.f238387a;
            if (r103 == null) goto L20;
            SheetTabItem r104 = r103.f238401g;
            if (r104 == null) goto L20;
            r104.setSelected(false);
            final int r105 = this.f238393c.getData().indexOf(this.f238393c.f238387a.f238401g);
        L21:
            this.f238391a.f238401g.setSelected(true);
            SheetTabAdapter r106 = this.f238393c;
            r106.f238387a = this.f238391a;
            final int r107 = r106.getData().indexOf(this.f238391a.f238401g);
            if (r107 < 0) goto L24;
            com.bytedance.ee.util.ui.j.c(new mn5.a(this, r107));
        L24:
            if (r105 < 0) goto L28;
            com.bytedance.ee.util.ui.j.c(new mn5.b(this, r105));
            return;
        L28:
            return;
        L20:
            r105 = -1;
            goto L21
        L30:
            return;
        }

        private a(SheetTabAdapter r100, View r101) {
            this.f238393c = r100;
            super(r101);
            this.f238392b = 0;
            this.f238391a = new b(r101);
            c r102 = new c();
            r102.f514544a = new GestureDetector(r101.getContext(), new C3427a(this));
            setOnTouchListener(R.id.sheet_tab_item_layout, r102);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f238395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f238396b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f238397c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImageView f238398d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f238399e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final LinearLayout f238400f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public SheetTabItem f238401g;

        public b(View r100) {
            this.f238396b = (ImageView) r100.findViewById(R.id.iv_locked_sheet);
            this.f238399e = (TextView) r100.findViewById(R.id.tv_sheet_name);
            this.f238397c = (ImageView) r100.findViewById(R.id.iv_manage_sheet);
            this.f238395a = r100.findViewById(R.id.sheet_tab_item_layout);
            this.f238398d = (ImageView) r100.findViewById(R.id.iv_custom_icon);
            this.f238400f = (LinearLayout) r100.findViewById(R.id.iv_tab_color);
        }
    }

    public SheetTabAdapter() {
        super(R.layout.sheet_tab_item, new ArrayList());
        this.f238389c = true;
    }

    @Override // com.chad.library.adapter.base.BaseItemDraggableAdapter
    public final void onItemDragEnd(RecyclerView.ViewHolder r100) {
        super.onItemDragEnd(r100);
        if ((r100 instanceof a) == false) goto L6;
        ((a) r100).U3();
        return;
    }

    @Override // com.bytedance.ee.util.ui.RecyclerItemsDiff.b
    public final boolean areContentsTheSame(SheetTabItem r100, SheetTabItem r101) {
        return SheetTabItem.contentEquals(r100, r101);
    }

    @Override // com.bytedance.ee.util.ui.RecyclerItemsDiff.b
    public final boolean areItemsTheSame(SheetTabItem r100, SheetTabItem r101) {
        return Objects.equals(r100, r101);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder r100, Object r110) {
        a r101 = (a) r100;
        SheetTabItem r111 = (SheetTabItem) r110;
        int r102 = a.f238390d;
        r101.getClass();
        r101.f238392b = SystemClock.uptimeMillis();
        b r103 = r101.f238391a;
        boolean r104 = r101.f238393c.f238389c;
        r103.f238401g = r111;
        r103.f238395a.setTag(r111);
        r103.f238399e.setText(r111.getName());
        r103.f238399e.setMaxWidth((int) (((double) n.v()) * 0.3d));
        ImageView r105 = r103.f238396b;
        int r106 = 8;
        int r107 = 0;
        if (r111.isLocked() == false) goto L5;
        int r108 = 0;
    L6:
        r105.setVisibility(r108);
        ImageView r109 = r103.f238397c;
        if (r111.getSelected() == false) goto L10;
        if (r104 == false) goto L10;
        int r112 = 0;
    L11:
        r109.setVisibility(r112);
        if (TextUtils.isEmpty(r111.getRenderedTabColor()) == true) goto L14;
        r103.f238400f.setVisibility(0);
        r103.f238400f.setBackgroundColor(ColorUtils.h(r111.getRenderedTabColor()));
    L16:
        if (r111.getCustomIcon() == null) goto L52;
        SheetTabItem.CustomIcon r113 = r111.getCustomIcon();
        if (r113.getType() != 1) goto L21;
        r103.f238398d.setImageResource(R.drawable.icon_sheet_thirdsheet_selector);
    L51:
        r106 = 0;
        goto L52
    L21:
        if (r113.getType() != 0) goto L30;
        if (r113.isValidIconUrl() == false) goto L30;
        RequestManager r114 = Glide.with(r103.f238398d.getContext());
        if (r111.getSelected() == false) goto L27;
        String r115 = r113.getSelectedUrl();
    L28:
        r114.load(new BearGlideUrl(r115)).into(r103.f238398d);
        goto L51
    L27:
        r115 = r113.getUnselectedUrl();
    L30:
        if (r113.getType() != 2) goto L52;
        if (r113.isValidIconId() == false) goto L52;
        Context r116 = r103.f238398d.getContext();
        if (r111.getSelected() == false) goto L36;
        String r117 = r113.getSelectedUrl();
    L37:
        int r118 = n.n(r116, r117);
        if (r111.getSelected() == false) goto L43;
        if (TextUtils.isEmpty(r113.getSelectedColorId()) == true) goto L43;
        String r119 = r113.getSelectedColorId();
    L48:
        if (r119 != null) goto L50;
        r103.f238398d.setImageResource(r118);
        goto L51
    L50:
        ImageView r120 = r103.f238398d;
        r120.setImageDrawable(l.a(r120.getContext(), r118, n.i(r103.f238398d.getContext(), r119)));
    L43:
        if (r111.getSelected() == false) goto L45;
    L47:
        r119 = null;
        goto L48
    L45:
        if (TextUtils.isEmpty(r113.getUnselectedColorId()) == true) goto L47;
        r119 = r113.getUnselectedColorId();
        goto L48
    L36:
        r117 = r113.getUnselectedUrl();
    L52:
        r103.f238398d.setVisibility(r106);
        if (r106 != 0) goto L55;
        r107 = n.d(2);
    L55:
        ViewGroup.LayoutParams r121 = r103.f238396b.getLayoutParams();
        if ((r121 instanceof ViewGroup.MarginLayoutParams) == false) goto L58;
        ((ViewGroup.MarginLayoutParams) r121).leftMargin = r107;
        r103.f238396b.setLayoutParams(r121);
    L58:
        boolean r122 = r111.getSelected();
        View r123 = r103.f238395a;
        if (r122 == false) goto L61;
        float r124 = 10.0f;
    L62:
        r123.setElevation(r124);
        r103.f238395a.setSelected(r122);
        r103.f238396b.setSelected(r122);
        r103.f238399e.setSelected(r122);
        r103.f238397c.setSelected(r122);
        r103.f238398d.setSelected(r122);
        r103.f238400f.setSelected(r122);
        boolean r125 = r111.isEnabled();
        r103.f238399e.setEnabled(r125);
        if (r111.getSelected() == false) goto L66;
        SheetTabAdapter r126 = r101.f238393c;
        r126.f238387a = r101.f238391a;
        return;
    L66:
        return;
    L61:
        r124 = 0.0f;
        goto L62
    L14:
        r103.f238400f.setVisibility(8);
    L10:
        r112 = 8;
        goto L11
    L5:
        r108 = 8;
        goto L6
    }
}
