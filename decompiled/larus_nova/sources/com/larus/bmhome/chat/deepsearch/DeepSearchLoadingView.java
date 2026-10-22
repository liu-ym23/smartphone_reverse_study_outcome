package com.larus.bmhome.chat.deepsearch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larus.common_ui.widget.roundlayout.RoundImageView;
import com.larus.mainbot.impl.databinding.LarusDeepSearchLoadingBinding;
import com.larus.nova.R;
import com.lynx.lottieadapter.LottieAdapterView;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\rH\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/chat/deepsearch/DeepSearchLoadingView;", "Landroid/widget/RelativeLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusDeepSearchLoadingBinding;", DyPayConstant.KEY_START_TIME, "", "showLottieView", "", "onDetachedFromWindow", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeepSearchLoadingView extends RelativeLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f302622c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusDeepSearchLoadingBinding f302623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f302624b;

    public static final class a {
    }

    static {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f302623a.f358569c.cancelAnimation();
    }

    public DeepSearchLoadingView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public DeepSearchLoadingView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        View r102 = LayoutInflater.from(r100).inflate(R.layout.larus_deep_search_loading, this, false);
        addView(r102);
        int r103 = R.id.deep_search_loading_bg;
        RoundImageView r104 = (RoundImageView) ViewBindings.findChildViewById(r102, R.id.deep_search_loading_bg);
        if (r104 == null) goto L11;
        r103 = R.id.deep_search_loading_lottie;
        LottieAdapterView r105 = (LottieAdapterView) ViewBindings.findChildViewById(r102, R.id.deep_search_loading_lottie);
        if (r105 == null) goto L11;
        r103 = R.id.deep_search_loading_text;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r102, R.id.deep_search_loading_text);
        if (r106 == null) goto L11;
        this.f302623a = new LarusDeepSearchLoadingBinding((RelativeLayout) r102, r104, r105, r106);
        this.f302624b = System.currentTimeMillis();
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
