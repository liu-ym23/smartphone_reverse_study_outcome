package com.bytedance.ee.bear.drive.biz.extra_info;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.ee.util.ui.l;
import w55.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class LikeInfoView extends FrameLayout {
    public ImageView a;
    public TextView b;
    public LikeState c;
    public int d;

    public static final enum LikeState extends Enum<LikeState> {
        public static final LikeState LIKED = null;
        public static final LikeState UNKNOWN = null;
        public static final LikeState UNLIKE = null;
        public static final /* synthetic */ LikeState[] a = null;
        private final int value;

        static {
            LikeState r0 = new LikeState("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            LikeState r1 = new LikeState("UNLIKE", 1, 1);
            UNLIKE = r1;
            LikeState r3 = new LikeState("LIKED", 2, 2);
            LIKED = r3;
            a = new LikeState[]{r0, r1, r3};
        }

        public static LikeState[] values() {
            return (LikeState[]) a.clone();
        }

        public final int getNumber() {
            return this.value;
        }

        public static LikeState forNumber(int r1) {
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L8;
            return UNKNOWN;
        L8:
            return LIKED;
        L10:
            return UNLIKE;
        }

        public static LikeState valueOf(String r1) {
            return (LikeState) r27.a.a(LikeState.class, r1);
        }

        public LikeState(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[LikeState.values().length];
            a = r0;
            r0[LikeState.LIKED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            a[LikeState.UNLIKE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            a[LikeState.UNKNOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public final void a() {
        if (n.d == false) goto L5;
        FrameLayout.inflate(getContext(), 2131560205, this);
    L6:
        this.a = (ImageView) findViewById(2131370280);
        this.b = (TextView) findViewById(2131370275);
        setState(LikeState.UNKNOWN);
        return;
    L5:
        FrameLayout.inflate(getContext(), 2131560204, this);
        goto L6
    }

    public int getCurrentLikeCount() {
        return this.d;
    }

    public LikeState getState() {
        return this.c;
    }

    public LikeInfoView(Context r1) {
        super(r1);
        a();
    }

    private void setLikeCount(int r3) {
        if (r3 <= 99) goto L5;
        this.b.setText("99+");
        this.b.setVisibility(0);
        return;
    L5:
        if (r3 > 0) goto L7;
        this.b.setVisibility(4);
        return;
    L7:
        this.b.setText(String.valueOf(r3));
        this.b.setVisibility(0);
    }

    private void setState(LikeState r2) {
        if (n.d == false) goto L5;
        setStateV2(r2);
        return;
    L5:
        setStateV1(r2);
    }

    private void setStateV1(LikeState r5) {
        if (this.a != null) goto L7;
        tt5.a.k("LikeInfoView", "setState: view is invalid");
        return;
    L7:
        if (r5 != this.c) goto L10;
        tt5.a.k("LikeInfoView", "setState: alread is state=" + r5);
        return;
    L10:
        tt5.a.k("LikeInfoView", "setState: state=" + r5);
        this.c = r5;
        int r6 = a.a[r5.ordinal()];
        if (r6 != 1) goto L13;
        this.a.setImageResource(2131256002);
        l.c(this.a, 2131105548);
        this.a.setImageAlpha(255);
        this.b.setTextColor(getResources().getColor(2131105548));
        setBackground(getResources().getDrawable(2131234012, null));
        return;
    L13:
        if (r6 != 2) goto L15;
        this.a.setImageResource(2131256003);
        l.c(this.a, 2131102418);
        this.a.setImageAlpha(255);
        this.b.setTextColor(getResources().getColor(2131106607));
        setBackgroundColor(getResources().getColor(2131100548));
        return;
    L15:
        if (r6 != 3) goto L23;
        this.a.setImageResource(2131256003);
        l.c(this.a, 2131102418);
        this.a.setImageAlpha(127);
        return;
    }

    private void setStateV2(LikeState r5) {
        if (this.a != null) goto L7;
        tt5.a.k("LikeInfoView", "setState: view is invalid");
        return;
    L7:
        if (r5 != this.c) goto L10;
        tt5.a.k("LikeInfoView", "setState: alread is state=" + r5);
        return;
    L10:
        tt5.a.k("LikeInfoView", "setState: state=" + r5);
        this.c = r5;
        int r6 = a.a[r5.ordinal()];
        if (r6 != 1) goto L13;
        this.a.setImageResource(2131256002);
        l.c(this.a, 2131105548);
        this.a.setImageAlpha(255);
        this.b.setTextColor(getResources().getColor(2131105548));
        return;
    L13:
        if (r6 != 2) goto L15;
        this.a.setImageResource(2131256003);
        l.c(this.a, 2131102419);
        this.a.setImageAlpha(255);
        this.b.setTextColor(getResources().getColor(2131106607));
        return;
    L15:
        if (r6 != 3) goto L23;
        this.a.setImageResource(2131256003);
        l.c(this.a, 2131102419);
        this.a.setImageAlpha(127);
        return;
    }

    public final void b(int r1) {
        setLikeCount(r1);
        this.d = r1;
    }

    public final void c(boolean r1) {
        if (r1 == false) goto L4;
        setState(LikeState.LIKED);
        return;
    L4:
        setState(LikeState.UNLIKE);
    }

    public LikeInfoView(Context r1, AttributeSet r2) {
        super(r1, r2);
        a();
    }

    public LikeInfoView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a();
    }
}
