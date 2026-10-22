package com.ss.android.lark.flow.feed.status;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;
import com.ss.android.lark.feed.shared.page.status.FeedBackgroundStatusView;
import com.ss.android.lark.flow.feed.databinding.FlowFeedBackgroundStatusBinding;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/flow/feed/status/FlowBackgroundPageStatusView;", "Lcom/ss/android/lark/feed/shared/page/status/FeedBackgroundStatusView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/ss/android/lark/flow/feed/databinding/FlowFeedBackgroundStatusBinding;", "retryAction", "Lkotlin/Function0;", "", "setStatus", "status", "Lcom/ss/android/lark/feed/shared/page/status/FeedBackgroundStatusView$FeedPageStatus;", "description", "", "onRetry", "flow-feed_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowBackgroundPageStatusView extends FeedBackgroundStatusView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FlowFeedBackgroundStatusBinding f423625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f423626c;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowBackgroundPageStatusView f423627a;

        public a(FlowBackgroundPageStatusView r100) {
            this.f423627a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function0<Unit> r101 = this.f423627a.f423626c;
            if (r101 == null) goto L6;
            r101.invoke();
            return;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f423628a = null;

        static {
            int[] r100 = new int[FeedBackgroundStatusView.FeedPageStatus.values().length];
            r100[FeedBackgroundStatusView.FeedPageStatus.LOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[FeedBackgroundStatusView.FeedPageStatus.EMPTY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[FeedBackgroundStatusView.FeedPageStatus.ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f423628a = r100;
        }
    }

    public FlowBackgroundPageStatusView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.flow_feed_background_status, this, false);
        addView(r103);
        int r104 = R.id.btn_retry;
        AppCompatButton r105 = (AppCompatButton) ViewBindings.findChildViewById(r103, R.id.btn_retry);
        if (r105 == null) goto L19;
        r104 = R.id.empty_image;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r103, R.id.empty_image)) == null) goto L19;
        r104 = R.id.iv_error_icon;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r103, R.id.iv_error_icon)) == null) goto L19;
        r104 = R.id.load_empty;
        LinearLayout r106 = (LinearLayout) ViewBindings.findChildViewById(r103, R.id.load_empty);
        if (r106 == null) goto L19;
        r104 = R.id.load_error;
        LinearLayout r107 = (LinearLayout) ViewBindings.findChildViewById(r103, R.id.load_error);
        if (r107 == null) goto L19;
        r104 = R.id.loading_view;
        AppCompatImageView r108 = (AppCompatImageView) ViewBindings.findChildViewById(r103, R.id.loading_view);
        if (r108 == null) goto L19;
        r104 = R.id.tv_error_title;
        if (((TextView) ViewBindings.findChildViewById(r103, R.id.tv_error_title)) == null) goto L19;
        this.f423625b = new FlowFeedBackgroundStatusBinding((RelativeLayout) r103, r105, r106, r107, r108);
        r105.setOnClickListener(new a(this));
        return;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }

    @Override // com.ss.android.lark.feed.shared.page.status.FeedBackgroundStatusView
    public final void a(FeedBackgroundStatusView.FeedPageStatus r100, String r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "status");
        Intrinsics.checkNotNullParameter(r101, "description");
        this.f423626c = r102;
        int r103 = b.f423628a[r100.ordinal()];
        if (r103 != 1) goto L5;
        setVisibility(0);
        this.f423625b.f423376d.setVisibility(0);
        this.f423625b.f423374b.setVisibility(8);
        this.f423625b.f423375c.setVisibility(8);
        return;
    L5:
        if (r103 != 2) goto L7;
        setVisibility(0);
        this.f423625b.f423376d.setVisibility(8);
        this.f423625b.f423374b.setVisibility(0);
        this.f423625b.f423375c.setVisibility(8);
        return;
    L7:
        if (r103 == 3) goto L9;
        setVisibility(8);
        return;
    L9:
        setVisibility(0);
        this.f423625b.f423376d.setVisibility(8);
        this.f423625b.f423374b.setVisibility(8);
        this.f423625b.f423375c.setVisibility(0);
    }
}
