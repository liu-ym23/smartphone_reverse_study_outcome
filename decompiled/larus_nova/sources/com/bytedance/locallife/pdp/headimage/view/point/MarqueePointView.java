package com.bytedance.locallife.pdp.headimage.view.point;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ViewSwitcher;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.lighten.core.CircleOptions;
import com.bytedance.lighten.loader.SmartImageView;
import com.bytedance.locallife.dito.utils.e;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import df6.q;
import df6.u;
import java.util.List;
import jx6.z;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000fB'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/locallife/pdp/headimage/view/point/MarqueePointView;", "Landroid/widget/FrameLayout;", "", "Ljx6/z;", "vo", "", "setVO", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class MarqueePointView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewSwitcher f261493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DuxTextView f261494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SmartImageView f261495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DuxTextView f261496d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SmartImageView f261497e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<z> f261498f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f261499g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f261500h;

    public static final class a {
    }

    public static final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MarqueePointView f261501a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            if (r100.what != 1) goto L20;
            MarqueePointView r101 = this.f261501a;
            if (r101.f261493a.getDisplayedChild() != 0) goto L7;
            int r102 = r101.f261499g;
            int r103 = r102 + 1;
        L8:
            List<z> r104 = r101.f261498f;
            if (r104 == null) goto L13;
            z r105 = (z) ListProtector.get(r104, r101.a(r102));
            if (r105 == null) goto L13;
            MarqueePointView.b(r101.f261495c, r101.f261494b, r105);
        L13:
            List<z> r106 = r101.f261498f;
            if (r106 == null) goto L18;
            z r107 = (z) ListProtector.get(r106, r101.a(r103));
            if (r107 == null) goto L18;
            MarqueePointView.b(r101.f261497e, r101.f261496d, r107);
        L18:
            r101.post(new ix6.a(r101));
            Message r108 = Message.obtain();
            r108.what = 1;
            sendMessageDelayed(r108, 2000);
            return;
        L7:
            r103 = r101.f261499g;
            r102 = r103 + 1;
            goto L8
        }

        public b(MarqueePointView r100, Looper r101) {
            this.f261501a = r100;
            super(r101);
        }
    }

    static {
    }

    public MarqueePointView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MarqueePointView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f261500h.removeCallbacksAndMessages(null);
    }

    public final int a(int r100) {
        List<z> r101 = this.f261498f;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.size();
    L6:
        if (r100 < r103) goto L12;
        List<z> r104 = this.f261498f;
        if (r104 == null) goto L11;
        r102 = r104.size();
    L11:
        return r100 - r102;
    L12:
        return r100;
    L5:
        r103 = 0;
        goto L6
    }

    public final void setVO(List<z> r100) {
        if (r100 == null) goto L5;
        int r101 = r100.size();
    L6:
        if (r101 > 0) goto L8;
        setVisibility(8);
        return;
    L8:
        if (r100 == null) goto L10;
        int r102 = r100.size();
    L12:
        if (r102 != 1) goto L18;
        setVisibility(0);
        if (r100 == null) goto L21;
        z r103 = (z) ListProtector.get(r100, 0);
        if (r103 == null) goto L22;
        b(this.f261495c, this.f261494b, r103);
        return;
    L22:
        return;
    L21:
        return;
    L18:
        setVisibility(0);
        this.f261498f = r100;
        b r104 = this.f261500h;
        Message r105 = Message.obtain();
        r105.what = 1;
        r104.sendMessage(r105);
        return;
    L10:
        r102 = 0;
        goto L12
    L5:
        r101 = 0;
        goto L6
    }

    public MarqueePointView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.f261500h = new b(this, Looper.getMainLooper());
        LayoutInflater.from(r110).inflate(R.layout.life_pdp_marquee_point_view, this, true);
        ViewSwitcher r113 = (ViewSwitcher) findViewById(R.id.view_switcher);
        this.f261493a = r113;
        this.f261494b = (DuxTextView) findViewById(R.id.first_text);
        this.f261496d = (DuxTextView) findViewById(R.id.second_text);
        this.f261495c = (SmartImageView) findViewById(R.id.first_image);
        this.f261497e = (SmartImageView) findViewById(R.id.second_image);
        TranslateAnimation r114 = new TranslateAnimation(0, 0.0f, 0, 0.0f, 2, 1.0f, 2, 0.0f);
        r114.setDuration(500);
        r113.setInAnimation(r114);
        TranslateAnimation r115 = new TranslateAnimation(0, 0.0f, 0, 0.0f, 2, 0.0f, 2, -1.0f);
        r115.setDuration(500);
        r113.setOutAnimation(r115);
    }

    public static void b(SmartImageView r100, DuxTextView r101, z r102) {
        Intrinsics.checkNotNullParameter(r100, "imageView");
        Intrinsics.checkNotNullParameter(r101, "textView");
        Intrinsics.checkNotNullParameter(r102, "vo");
        u r103 = q.d(r102.a());
        CircleOptions.a r104 = new CircleOptions.a();
        r104.f254610d = e.b(7);
        r103.f468289o = new CircleOptions(r104);
        r103.f468294t = r100;
        r103.c();
        r101.setText(r102.b());
    }

    public /* synthetic */ MarqueePointView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
