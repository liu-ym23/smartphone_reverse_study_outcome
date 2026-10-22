package com.ss.android.lark.imageocr.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0001'B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010#\u001a\u00020$H\u0002J\u0006\u0010%\u001a\u00020$J\u0006\u0010&\u001a\u00020$R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001c\u0010\u0019R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0013\u001a\u0004\b \u0010!¨\u0006("}, d2 = {"Lcom/ss/android/lark/imageocr/view/OCRTipView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activity", "Landroid/app/Activity;", "kvRepo", "Lcom/ss/android/lark/storage/kv/repo/KVRepo;", "getKvRepo", "()Lcom/ss/android/lark/storage/kv/repo/KVRepo;", "kvRepo$delegate", "Lkotlin/Lazy;", "tipView", "Landroid/widget/ImageView;", "clickTipDrawable", "Landroid/graphics/drawable/Drawable;", "getClickTipDrawable", "()Landroid/graphics/drawable/Drawable;", "clickTipDrawable$delegate", "twoFingerTipDrawable", "getTwoFingerTipDrawable", "twoFingerTipDrawable$delegate", "tipTxt", "Landroid/widget/TextView;", "getTipTxt", "()Landroid/widget/TextView;", "tipTxt$delegate", "initView", "", "showClickTipIfNeed", "showTwoFingerTipIfNeed", "Companion", "imageocr_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OCRTipView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f426622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f426623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f426624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f426625d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f426626e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f426627f;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OCRTipView f426628a;

        public a(OCRTipView r100) {
            this.f426628a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (this.f426628a.getVisibility() != 0) goto L6;
            this.f426628a.setVisibility(8);
            return;
        }
    }

    public static final class b {
    }

    static {
    }

    private final Drawable getClickTipDrawable() {
        return (Drawable) this.f426625d.getValue();
    }

    private final KVRepo getKvRepo() {
        return (KVRepo) this.f426623b.getValue();
    }

    private final TextView getTipTxt() {
        return (TextView) this.f426627f.getValue();
    }

    private final Drawable getTwoFingerTipDrawable() {
        return (Drawable) this.f426626e.getValue();
    }

    public final void a() {
        Log.i("OCRTipView", "showClickTipIfNeed");
        if (getKvRepo().getBoolean("KEY_HAS_SHOW_CLICK_TIP", false) == true) goto L6;
        getKvRepo().putBoolean("KEY_HAS_SHOW_CLICK_TIP", true);
        setVisibility(0);
        this.f426624c.setImageDrawable(getClickTipDrawable());
        getTipTxt().setText(UIUtils.getString(this.f426622a, R.string.Lark_IM_ImageToText_TapOrDragToSelectText));
        return;
    }

    public final void b() {
        Log.i("OCRTipView", "showTwoFingerTipIfNeed");
        if (getKvRepo().getBoolean("KEY_HAS_SHOW_TWO_FINGER_TIP", false) == true) goto L6;
        getKvRepo().putBoolean("KEY_HAS_SHOW_TWO_FINGER_TIP", true);
        setVisibility(0);
        this.f426624c.setImageDrawable(getTwoFingerTipDrawable());
        getTipTxt().setText(UIUtils.getString(this.f426622a, R.string.Lark_IM_ImageToText_ScrollWith2Fingers_Text));
        return;
    }

    public OCRTipView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public OCRTipView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public OCRTipView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Context r103 = getContext();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.app.Activity");
        Activity r104 = (Activity) r103;
        this.f426622a = r104;
        this.f426623b = LazyKt.lazy(OCRTipView$kvRepo$2.INSTANCE);
        ImageView r105 = new ImageView(getContext());
        this.f426624c = r105;
        this.f426625d = LazyKt.lazy(new OCRTipView$clickTipDrawable$2(this));
        this.f426626e = LazyKt.lazy(new OCRTipView$twoFingerTipDrawable$2(this));
        this.f426627f = LazyKt.lazy(new OCRTipView$tipTxt$2(this));
        setOrientation(1);
        setVisibility(8);
        setBackgroundColor(UIUtils.getColor(getContext(), R.color.static_black_60));
        setHorizontalGravity(17);
        setVerticalGravity(17);
        setOnClickListener(new a(this));
        removeAllViews();
        addView(r105, new LinearLayout.LayoutParams(UIUtils.dp2px(r104, 90.0f), UIUtils.dp2px(r104, 90.0f)));
        LinearLayout.LayoutParams r106 = new LinearLayout.LayoutParams(-2, -2);
        r106.topMargin = UIUtils.dp2px(r104, 18.0f);
        addView(getTipTxt(), r106);
    }
}
