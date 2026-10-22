package com.larus.office.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mn9.c;
import vm9.b;
import vm9.e;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000  2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001 B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0017J\b\u0010\u001a\u001a\u00020\u0013H\u0016J\u001a\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0012\u0010\u001c\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u001e\u001a\u00020\u000fH\u0016J\b\u0010\u001f\u001a\u00020\u000fH\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/office/base/view/DocLoadAndErrorLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnTouchListener;", "Lcom/larus/office/base/page/IHostLoadingAndErrorLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mOnRetryListener", "Lcom/larus/office/base/page/OnRetryListener;", "init", "", "onTouch", "", BaseSwitches.V, "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "fail", "errCode", "message", "", "getView", "showStatusViewWithNewErrorOpt", "setOnRetryListener", "onRetryListener", "loading", "hide", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocLoadAndErrorLayout extends FrameLayout implements View.OnTouchListener, b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f361209b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f361210a;

    public static final class a {
    }

    static {
    }

    public DocLoadAndErrorLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DocLoadAndErrorLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // vm9.b
    public final void b() {
        setVisibility(0);
        findViewById(R.id.doc_loading_image_container).setVisibility(0);
        findViewById(R.id.doc_load_error_container).setVisibility(8);
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
    }

    @Override // vm9.b
    public void setOnRetryListener(e r100) {
        this.f361210a = r100;
    }

    @Override // vm9.b
    public final void a(final int r100, String r101) {
        setVisibility(0);
        if (findViewById(R.id.doc_loading_image_container) == null) goto L5;
        findViewById(R.id.doc_loading_image_container).setVisibility(8);
    L5:
        findViewById(R.id.doc_load_error_container).setVisibility(0);
        ImageView r102 = (ImageView) findViewById(R.id.doc_load_error_icon);
        TextView r103 = (TextView) findViewById(R.id.doc_load_error_msg);
        Button r104 = (Button) findViewById(R.id.doc_upgrade_btn);
        if (r100 != (-55)) goto L8;
        r102.setImageResource(R.drawable.larus_office_deleted_icon);
        r103.setText(R.string.larus_aiDoc_msgCard_deletedDoc);
        r103.setTextColor(getContext().getResources().getColor(R.color.larus_neutral_50));
        Intrinsics.checkNotNull(r104);
        e1.o(r104);
        return;
    L8:
        if (r100 == 700) goto L12;
        r102.setImageResource(R.drawable.larus_office_icon_reload);
        r103.setText(R.string.larus_aiDoc_viewFailed_errorMsg);
        r103.setTextColor(getContext().getResources().getColor(R.color.larus_neutral_100));
        findViewById(R.id.doc_loading_and_result_layout).setOnClickListener(new c(this, r100));
        Intrinsics.checkNotNull(r104);
        e1.o(r104);
        return;
    }

    public DocLoadAndErrorLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        FrameLayout.inflate(getContext(), R.layout.larus_doc_loading_and_result_layout, this);
    }

    public /* synthetic */ DocLoadAndErrorLayout(Context r100, AttributeSet r101, int r102, int r103) {
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
