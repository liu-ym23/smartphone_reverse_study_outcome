package com.larus.livetutor.impl.typing;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.OneShotPreDrawListener;
import androidx.viewbinding.ViewBindings;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.livetutor.impl.databinding.LayoutTypingTextviewBinding;
import com.larus.livetutor.impl.typing.enumeration.TypingMode;
import com.larus.livetutor.impl.typing.enumeration.TypingStreamStatus;
import com.larus.livetutor.impl.typing.service.TextContent;
import com.larus.livetutor.impl.typing.service.TypingService;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u0017J\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u001e\u0010\u001e\u001a\u00020\u00152\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013J\u0018\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020#H\u0016J \u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020#H\u0016J \u0010'\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010)\u001a\u00020\u0015H\u0014J\b\u0010*\u001a\u00020\u0015H\u0014J\u0010\u0010+\u001a\u00020\u00142\u0006\u0010,\u001a\u00020\u0014H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/larus/livetutor/impl/typing/TypingTextView;", "Landroid/widget/FrameLayout;", "Lcom/larus/livetutor/impl/typing/service/TypingService$ITextUpdateListener;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/livetutor/impl/databinding/LayoutTypingTextviewBinding;", "typingService", "Lcom/larus/livetutor/impl/typing/service/TypingService;", "typingText", "", "maskColor", "renderEndCallback", "Lkotlin/Function1;", "Lcom/larus/livetutor/impl/typing/enumeration/TypingStreamStatus;", "", "renderEndCalled", "", "bindService", "service", "Lcom/larus/livetutor/impl/typing/service/ITypingService;", "withTextUpdate", "getMarkdownTextView", "Lcom/larus/bmhome/view/textview/impl/CustomMarkdownTextView;", "setRenderEndCallback", "callback", "onIndexUpdate", "index", "typingMode", "Lcom/larus/livetutor/impl/typing/enumeration/TypingMode;", "onTextUpdate", "textContent", "Lcom/larus/livetutor/impl/typing/service/TextContent;", "onTextFlush", "streamStatus", "onAttachedToWindow", "onDetachedFromWindow", "getTypingStreamStatus", "defaultStreamStatus", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TypingTextView extends FrameLayout implements TypingService.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LayoutTypingTextviewBinding f356584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TypingService f356585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super TypingStreamStatus, Unit> f356586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f356587d;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f356588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TypingTextView f356589b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TypingStreamStatus f356590c;

        public b(View r100, TypingTextView r101, TypingStreamStatus r102) {
            this.f356588a = r100;
            this.f356589b = r101;
            this.f356590c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Function1<? super TypingStreamStatus, Unit> r100 = this.f356589b.f356586c;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.invoke(this.f356590c);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    public TypingTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TypingTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final CustomMarkdownTextView getMarkdownTextView() {
        LayoutTypingTextviewBinding r100 = this.f356584a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f355935b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public final void setRenderEndCallback(Function1<? super TypingStreamStatus, Unit> r100) {
        this.f356586c = r100;
    }

    public final void bindService(com.larus.livetutor.impl.typing.service.a r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "service");
        this.f356587d = false;
        if ((r100 instanceof TypingService) == false) goto L5;
        TypingService r102 = (TypingService) r100;
    L6:
        this.f356585b = r102;
        if (r101 == false) goto L10;
        if (r102 == null) goto L10;
        r102.m();
    L10:
        TypingService r103 = this.f356585b;
        if (r103 == null) goto L14;
        Intrinsics.checkNotNullParameter(this, "listener");
        r103.f356617f = this;
        return;
    L14:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.larus.livetutor.impl.typing.service.TypingService.b
    public final void c(int r100, TypingMode r101) {
        Intrinsics.checkNotNullParameter(r101, "typingMode");
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("TypingTextView, ");
        TypingService r104 = this.f356585b;
        if (r104 == null) goto L5;
        String r105 = r104.f356614c;
    L6:
        r103.append(r105);
        r103.append(", onIndexUpdate, index: ");
        r103.append(r100);
        r103.append('.');
        r102.i("TypingTextView", r103.toString());
        this.f356587d = false;
        return;
    L5:
        r105 = null;
        goto L6
    }

    public TypingTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.layout_typing_textview, this);
        CustomMarkdownTextView r103 = (CustomMarkdownTextView) ViewBindings.findChildViewById(this, R.id.markdownTextView);
        if (r103 == null) goto L7;
        this.f356584a = new LayoutTypingTextviewBinding(this, r103);
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{android.R.attr.lineSpacingExtra, android.R.attr.lineSpacingMultiplier, R.attr.stream_mask_color, R.attr.stream_text_style});
        int r105 = r104.getResourceId(3, -1);
        r104.getColor(2, -1);
        TypedArray r106 = r100.obtainStyledAttributes(r105, new int[]{android.R.attr.lineSpacingExtra, android.R.attr.lineSpacingMultiplier, R.attr.stream_mask_color, R.attr.stream_text_style});
        float r107 = r106.getFloat(1, 1.0f);
        r103.setLineSpacing(r106.getDimension(0, 0.0f), r107);
        r106.recycle();
        r104.recycle();
        return;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(R.id.markdownTextView)));
    }

    @Override // com.larus.livetutor.impl.typing.service.TypingService.b
    public final void a(TextContent r100, TypingStreamStatus r101, TypingMode r102) {
        Intrinsics.checkNotNullParameter(r100, "textContent");
        Intrinsics.checkNotNullParameter(r101, "streamStatus");
        Intrinsics.checkNotNullParameter(r102, "typingMode");
        r100.getText();
        TypingStreamStatus r103 = TypingStreamStatus.Finish;
        TypingService r104 = this.f356585b;
        if (r104 == null) goto L6;
        TypingStreamStatus r105 = r104.f356629r;
        if (r105 == null) goto L6;
    L7:
        FLogger r106 = FLogger.f375446a;
        StringBuilder r107 = new StringBuilder("TypingTextView, ");
        TypingService r108 = this.f356585b;
        if (r108 == null) goto L10;
        String r109 = r108.f356614c;
    L11:
        r107.append(r109);
        r107.append(", onTextFlush, isStreaming: ");
        r107.append(r101);
        r107.append(", text: ");
        r107.append(r100.getText());
        r107.append('.');
        r106.i("TypingTextView", r107.toString());
        LayoutTypingTextviewBinding r110 = this.f356584a;
        if (r110 == null) goto L16;
        CustomMarkdownTextView r111 = r110.f355935b;
        if (r111 == null) goto L16;
        r111.setMarkdown(r100.getMarkdown());
    L16:
        if (r105 == r103) goto L18;
        return;
    L18:
        if (this.f356587d == true) goto L22;
        OneShotPreDrawListener.add(this, new b(this, this, r105));
        this.f356587d = true;
        return;
    L22:
        return;
    L10:
        r109 = null;
    L6:
        r105 = r103;
        goto L7
    }

    @Override // com.larus.livetutor.impl.typing.service.TypingService.b
    public final void b(TextContent r100, int r101, TypingMode r102) {
        Intrinsics.checkNotNullParameter(r100, "textContent");
        Intrinsics.checkNotNullParameter(r102, "typingMode");
        r100.getText();
        this.f356587d = false;
        TypingStreamStatus r103 = TypingStreamStatus.Initial;
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("TypingTextView, ");
        TypingService r106 = this.f356585b;
        if (r106 == null) goto L5;
        String r107 = r106.f356614c;
    L6:
        r105.append(r107);
        r105.append(", onTextUpdate, index: ");
        r105.append(r101);
        r105.append(", text: ");
        r105.append(r100.getText());
        r105.append('.');
        r104.i("TypingTextView", r105.toString());
        LayoutTypingTextviewBinding r108 = this.f356584a;
        if (r108 == null) goto L12;
        CustomMarkdownTextView r109 = r108.f355935b;
        if (r109 == null) goto L13;
        r109.setMarkdown(r100.getMarkdown());
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r107 = null;
        goto L6
    }

    public /* synthetic */ TypingTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
