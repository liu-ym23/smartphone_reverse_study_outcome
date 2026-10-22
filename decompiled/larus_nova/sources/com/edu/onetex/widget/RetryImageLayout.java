package com.edu.onetex.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001*B'\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tJ\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u00020\u00038\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006+"}, d2 = {"Lcom/edu/onetex/widget/RetryImageLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", BaseSwitches.V, "", "doClick", "clickListener", "setOnRetryClickListener", "", "visible", "setRetryVisible", SendEventContainerMethodParamModel.EventKinds.onClick, "Landroid/widget/ImageView;", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "setImageView", "(Landroid/widget/ImageView;)V", "retryBtn", "Landroid/view/View;", "getRetryBtn", "()Landroid/view/View;", "setRetryBtn", "(Landroid/view/View;)V", "enabledClick", "Z", "Ljava/lang/Runnable;", "enableAgain", "Ljava/lang/Runnable;", "outerRetryListener", "Landroid/view/View$OnClickListener;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "onetex_release"}, k = 1, mv = {1, 4, 2})
public final class RetryImageLayout extends FrameLayout implements View.OnClickListener {
    public static final a Companion = null;
    private static final long DEFAULT_INTERVAL = 500;
    private static final Handler HANDLER = null;
    private HashMap _$_findViewCache;
    private final Runnable enableAgain;
    private boolean enabledClick;
    public ImageView imageView;
    private View.OnClickListener outerRetryListener;
    public View retryBtn;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RetryImageLayout f273706a;

        public b(RetryImageLayout r100) {
            this.f273706a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RetryImageLayout.access$setEnabledClick$p(this.f273706a, true);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public RetryImageLayout(Context r100) {
        this(r100, null, 0, 6, null);
    }

    public RetryImageLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 4, null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap r100 = this._$_findViewCache;
        if (r100 == null) goto L6;
        r100.clear();
        return;
    }

    public View _$_findCachedViewById(int r100) {
        if (this._$_findViewCache != null) goto L5;
        this._$_findViewCache = new HashMap();
    L5:
        View r101 = (View) this._$_findViewCache.get(Integer.valueOf(r100));
        if (r101 != null) goto L9;
        View r102 = findViewById(r100);
        this._$_findViewCache.put(Integer.valueOf(r100), r102);
        return r102;
    L9:
        return r101;
    }

    static {
        Companion = new a();
        HANDLER = new Handler(Looper.getMainLooper());
    }

    public final ImageView getImageView() {
        ImageView r100 = this.imageView;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("imageView");
    L5:
        return r100;
    }

    public final View getRetryBtn() {
        View r100 = this.retryBtn;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("retryBtn");
    L5:
        return r100;
    }

    public static final /* synthetic */ boolean access$getEnabledClick$p(RetryImageLayout r100) {
        return r100.enabledClick;
    }

    private final void doClick(View r100) {
        View.OnClickListener r101 = this.outerRetryListener;
        if (r101 == null) goto L6;
        r101.onClick(r100);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r100) {
        View r101 = this.retryBtn;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("retryBtn");
    L6:
        if ((!Intrinsics.areEqual(r101, r100)) == false) goto L9;
        return;
    L9:
        if (this.enabledClick == false) goto L12;
        this.enabledClick = false;
        HANDLER.postDelayed(this.enableAgain, 500);
        doClick(r100);
        return;
    }

    public final void setImageView(ImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.imageView = r100;
    }

    public final void setOnRetryClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "clickListener");
        this.outerRetryListener = r100;
    }

    public final void setRetryBtn(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.retryBtn = r100;
    }

    public final void setRetryVisible(boolean r100) {
        View r101 = this.retryBtn;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("retryBtn");
    L5:
        if (r100 == false) goto L7;
        int r102 = 0;
    L8:
        r101.setVisibility(r102);
        return;
    L7:
        r102 = 8;
        goto L8
    }

    public static final /* synthetic */ void access$setEnabledClick$p(RetryImageLayout r100, boolean r101) {
        r100.enabledClick = r101;
    }

    public RetryImageLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.enabledClick = true;
        this.enableAgain = new b(this);
        FrameLayout.inflate(r100, R.layout.onetex_retry_image_layout, this);
        this.imageView = (ImageView) findViewById(R.id.onetex_image_iv);
        View r103 = findViewById(R.id.onetex_image_retry_tv);
        this.retryBtn = r103;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("retryBtn");
    L5:
        r103.setOnClickListener(this);
    }

    public /* synthetic */ RetryImageLayout(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
