package com.larus.sheet.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vm9.b;
import vm9.e;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 #2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001#B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0015H\u0016J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\tH\u0002J\u0012\u0010\u001e\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010 \u001a\u00020\u0011H\u0016J\b\u0010!\u001a\u00020\u0011H\u0016J\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\tH\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006$"}, d2 = {"Lcom/larus/sheet/impl/view/SheetLoadLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnTouchListener;", "Lcom/larus/office/base/page/IHostLoadingAndErrorLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mOnRetryListener", "Lcom/larus/office/base/page/OnRetryListener;", "lastErrorCode", "Ljava/lang/Integer;", "init", "", "onTouch", "", BaseSwitches.V, "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "fail", "errCode", "message", "", "getView", "showStatusViewWithNewErrorOpt", "setOnRetryListener", "listener", "loading", "hide", "isDocDeleteError", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SheetLoadLayout extends FrameLayout implements View.OnTouchListener, b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f369053c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f369054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f369055b;

    public static final class a {
    }

    static {
    }

    public SheetLoadLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SheetLoadLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // vm9.b
    public final void b() {
        setVisibility(0);
        FLogger.f375446a.d("SheetLoadLayout", "final loading");
        this.f369055b = null;
        findViewById(R.id.sheet_loading_image_container).setVisibility(0);
        findViewById(R.id.sheet_load_error_container).setVisibility(8);
        setOnClickListener(null);
    }

    public View getView() {
        return this;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r101, "event");
        return true;
    }

    @Override // vm9.b
    public final void hide() {
        setVisibility(8);
        FLogger.f375446a.d("SheetLoadLayout", "final hide");
        this.f369055b = null;
    }

    @Override // vm9.b
    public void setOnRetryListener(e r100) {
        this.f369054a = r100;
    }

    @Override // vm9.b
    public final void a(final int r100, String r101) {
        Integer r102 = this.f369055b;
        if (r102 != null) goto L6;
    L9:
        this.f369055b = Integer.valueOf(r100);
        boolean r103 = false;
        setVisibility(0);
        View r104 = findViewById(R.id.sheet_loading_image_container);
        if (r104 == null) goto L12;
        r104.setVisibility(8);
    L12:
        FLogger.f375446a.i("SheetLoadLayout", "Sheet load failed: errCode=" + r100 + ", message=" + r101 + ", loading=" + r104);
        findViewById(R.id.sheet_load_error_container).setVisibility(0);
        ImageView r105 = (ImageView) findViewById(R.id.sheet_load_error_icon);
        TextView r106 = (TextView) findViewById(R.id.sheet_load_error_msg);
        if (r100 != (-55)) goto L15;
        r103 = true;
    L15:
        if (r103 == false) goto L17;
        r105.setImageResource(R.drawable.larus_office_deleted_icon);
        r106.setText(R.string.larus_LarkCCM_DoubaoSheets_Deleted_Empty);
        r106.setTextColor(getContext().getResources().getColor(R.color.larus_neutral_50));
        return;
    L17:
        r105.setImageResource(R.drawable.larus_office_icon_reload);
        r106.setText(R.string.larus_aiDoc_viewFailed_errorMsg);
        r106.setTextColor(getContext().getResources().getColor(R.color.larus_neutral_100));
        findViewById(R.id.sheet_loading_and_result_layout).setOnClickListener(new ow9.a(this, r100));
        return;
    L6:
        if (r102.intValue() != (-55)) goto L9;
        if (r100 == (-55)) goto L9;
    }

    public SheetLoadLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        FrameLayout.inflate(getContext(), R.layout.larus_sheet_loading_and_result_layout, this);
        b();
    }

    public /* synthetic */ SheetLoadLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        int r104 = -1;
    L9:
        this(r100, r101, r104);
        return;
    L8:
        r104 = 0;
        goto L9
    }
}
