package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.RequestPasswordView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0011J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\tH\u0002J\u0018\u0010 \u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\tH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFContentView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "passwordView", "Lcom/bytedance/ee/bear/middleground/permission/setting/linkshare/linkpassword/RequestPasswordView;", "viewDelegate", "Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFContentView$ViewDelegate;", "getViewDelegate", "()Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFContentView$ViewDelegate;", "setViewDelegate", "(Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFContentView$ViewDelegate;)V", "onInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "setVisible", "", "visible", "showRenderView", "renderView", "Landroid/view/View;", "showPasswordView", "viewOwner", "Lcom/bytedance/ee/bear/drive/view/preview/wrapper/ViewOwner;", "status", "", "createRequestPasswordView", "onSetUp", "ViewDelegate", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PDFContentView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RequestPasswordView f225218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f225219b;

    public static final class a {
    }

    public interface b {
        void a();

        void b(String r100);
    }

    static {
    }

    public final b getViewDelegate() {
        return this.f225219b;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        b r101 = this.f225219b;
        if (r101 == null) goto L6;
        r101.a();
    L6:
        return super.onInterceptTouchEvent(r100);
    }

    public final void setViewDelegate(b r100) {
        this.f225219b = r100;
    }

    public final void setVisible(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = 0;
    L5:
        setVisibility(r101);
        return;
    L4:
        r101 = 8;
        goto L5
    }

    public PDFContentView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.drive_ttreader_pdf_view, this, true);
    }
}
