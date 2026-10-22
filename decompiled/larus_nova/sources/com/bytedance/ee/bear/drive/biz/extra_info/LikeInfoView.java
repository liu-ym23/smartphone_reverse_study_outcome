package com.bytedance.ee.bear.drive.biz.extra_info;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.ee.util.ui.l;
import com.larus.nova.R;
import w55.n;

/* JADX INFO: loaded from: classes16.dex */
public class LikeInfoView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f222967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f222968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LikeState f222969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f222970d;

    public static final enum LikeState extends Enum<LikeState> {
        public static final LikeState LIKED = null;
        public static final LikeState UNKNOWN = null;
        public static final LikeState UNLIKE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LikeState[] f222971a = null;
        private final int value;

        static {
            LikeState r100 = new LikeState("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            LikeState r101 = new LikeState("UNLIKE", 1, 1);
            UNLIKE = r101;
            LikeState r102 = new LikeState("LIKED", 2, 2);
            LIKED = r102;
            f222971a = new LikeState[]{r100, r101, r102};
        }

        public static LikeState[] values() {
            return (LikeState[]) f222971a.clone();
        }

        public final int getNumber() {
            return this.value;
        }

        public static LikeState forNumber(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return UNKNOWN;
        L8:
            return LIKED;
        L10:
            return UNLIKE;
        }

        public static LikeState valueOf(String r100) {
            return (LikeState) r27.a.a(LikeState.class, r100);
        }

        public LikeState(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f222972a = null;

        static {
            int[] r100 = new int[LikeState.values().length];
            f222972a = r100;
            r100[LikeState.LIKED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f222972a[LikeState.UNLIKE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f222972a[LikeState.UNKNOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public final void a() {
        if (n.f558339d == false) goto L5;
        FrameLayout.inflate(getContext(), R.layout.drive_like_item_layout_v2, this);
    L6:
        this.f222967a = (ImageView) findViewById(R.id.drive_like_item_dolike);
        this.f222968b = (TextView) findViewById(R.id.drive_like_count);
        setState(LikeState.UNKNOWN);
        return;
    L5:
        FrameLayout.inflate(getContext(), R.layout.drive_like_item_layout, this);
        goto L6
    }

    public int getCurrentLikeCount() {
        return this.f222970d;
    }

    public LikeState getState() {
        return this.f222969c;
    }

    public LikeInfoView(Context r100) {
        super(r100);
        a();
    }

    private void setLikeCount(int r100) {
        if (r100 <= 99) goto L5;
        this.f222968b.setText("99+");
        this.f222968b.setVisibility(0);
        return;
    L5:
        if (r100 > 0) goto L7;
        this.f222968b.setVisibility(4);
        return;
    L7:
        this.f222968b.setText(String.valueOf(r100));
        this.f222968b.setVisibility(0);
    }

    private void setState(LikeState r100) {
        if (n.f558339d == false) goto L5;
        setStateV2(r100);
        return;
    L5:
        setStateV1(r100);
    }

    private void setStateV1(LikeState r100) {
        if (this.f222967a != null) goto L7;
        tt5.a.k("LikeInfoView", "setState: view is invalid");
        return;
    L7:
        if (r100 != this.f222969c) goto L10;
        tt5.a.k("LikeInfoView", "setState: alread is state=" + r100);
        return;
    L10:
        tt5.a.k("LikeInfoView", "setState: state=" + r100);
        this.f222969c = r100;
        int r101 = a.f222972a[r100.ordinal()];
        if (r101 != 1) goto L13;
        this.f222967a.setImageResource(R.drawable.ud_icon_thumbsup_filled);
        l.c(this.f222967a, R.color.primary_fill_default);
        this.f222967a.setImageAlpha(255);
        this.f222968b.setTextColor(getResources().getColor(R.color.primary_fill_default));
        setBackground(getResources().getDrawable(R.drawable.drive_bg_like_count, null));
        return;
    L13:
        if (r101 != 2) goto L15;
        this.f222967a.setImageResource(R.drawable.ud_icon_thumbsup_outlined);
        l.c(this.f222967a, R.color.icon_n1);
        this.f222967a.setImageAlpha(255);
        this.f222968b.setTextColor(getResources().getColor(R.color.text_caption));
        setBackgroundColor(getResources().getColor(R.color.bg_body));
        return;
    L15:
        if (r101 != 3) goto L23;
        this.f222967a.setImageResource(R.drawable.ud_icon_thumbsup_outlined);
        l.c(this.f222967a, R.color.icon_n1);
        this.f222967a.setImageAlpha(127);
        return;
    }

    private void setStateV2(LikeState r100) {
        if (this.f222967a != null) goto L7;
        tt5.a.k("LikeInfoView", "setState: view is invalid");
        return;
    L7:
        if (r100 != this.f222969c) goto L10;
        tt5.a.k("LikeInfoView", "setState: alread is state=" + r100);
        return;
    L10:
        tt5.a.k("LikeInfoView", "setState: state=" + r100);
        this.f222969c = r100;
        int r101 = a.f222972a[r100.ordinal()];
        if (r101 != 1) goto L13;
        this.f222967a.setImageResource(R.drawable.ud_icon_thumbsup_filled);
        l.c(this.f222967a, R.color.primary_fill_default);
        this.f222967a.setImageAlpha(255);
        this.f222968b.setTextColor(getResources().getColor(R.color.primary_fill_default));
        return;
    L13:
        if (r101 != 2) goto L15;
        this.f222967a.setImageResource(R.drawable.ud_icon_thumbsup_outlined);
        l.c(this.f222967a, R.color.icon_n2);
        this.f222967a.setImageAlpha(255);
        this.f222968b.setTextColor(getResources().getColor(R.color.text_caption));
        return;
    L15:
        if (r101 != 3) goto L23;
        this.f222967a.setImageResource(R.drawable.ud_icon_thumbsup_outlined);
        l.c(this.f222967a, R.color.icon_n2);
        this.f222967a.setImageAlpha(127);
        return;
    }

    public final void b(int r100) {
        setLikeCount(r100);
        this.f222970d = r100;
    }

    public final void c(boolean r100) {
        if (r100 == false) goto L4;
        setState(LikeState.LIKED);
        return;
    L4:
        setState(LikeState.UNLIKE);
    }

    public LikeInfoView(Context r100, AttributeSet r101) {
        super(r100, r101);
        a();
    }

    public LikeInfoView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a();
    }
}
