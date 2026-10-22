package com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.normal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.SupervisorKt;
import lsc.y;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001(B'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\b\u001a\u00020\u0007H\u0002R\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\"\u0010\u001c\u001a\u00020\u00058\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006)"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/replacementspan/normal/DefaultMarkdownCodeView;", "Landroid/widget/FrameLayout;", "", "getLanguage", "getCode", "", "getFinishState", "Landroid/widget/TextView;", "getMarkdownTextView", "Letc/b;", "b", "Lkotlin/Lazy;", "getHighlight", "()Letc/b;", "highlight", "d", "Ljava/lang/String;", "getCurrentCode", "()Ljava/lang/String;", "setCurrentCode", "(Ljava/lang/String;)V", "currentCode", "e", "getCurrentLanguage", "setCurrentLanguage", "currentLanguage", "f", "Z", "isFinish", "()Z", "setFinish", "(Z)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "markdown-impl_release"}, k = 1, mv = {1, 7, 1})
public final class DefaultMarkdownCodeView extends FrameLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f320642h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f320643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f320644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f320645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f320646d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f320647e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f320648f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CoroutineScope f320649g;

    public static final class a {
    }

    static {
    }

    public DefaultMarkdownCodeView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DefaultMarkdownCodeView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final etc.b getHighlight() {
        return (etc.b) this.f320644b.getValue();
    }

    private final TextView getMarkdownTextView() {
        return this.f320643a;
    }

    public final String getCode() {
        return this.f320646d;
    }

    public final String getCurrentCode() {
        return this.f320646d;
    }

    public final String getCurrentLanguage() {
        return this.f320647e;
    }

    public final boolean getFinishState() {
        return this.f320648f;
    }

    public final String getLanguage() {
        return this.f320647e;
    }

    public static final /* synthetic */ etc.b a(DefaultMarkdownCodeView r100) {
        return r100.getHighlight();
    }

    public final void setCurrentCode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f320646d = r100;
    }

    public final void setCurrentLanguage(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f320647e = r100;
    }

    public final void setFinish(boolean r100) {
        this.f320648f = r100;
    }

    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "language");
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L10;
        setVisibility(8);
        return;
    L10:
        String r103 = StringsKt.substringBefore$default(r101, " ", null, 2, null);
        if (Intrinsics.areEqual(r103, "STDOUT") == false) goto L14;
        setVisibility(8);
        return;
    L14:
        setVisibility(0);
        this.f320646d = r100;
        this.f320647e = r103;
        this.f320648f = true;
        int r104 = rw8.a.f539729a;
        String r105 = rw8.a.a(r100, this.f320645c);
        getMarkdownTextView().setText(new y(getHighlight().a(this.f320647e, r105)).h());
        TextView r106 = getMarkdownTextView();
        if (this.f320648f == false) goto L17;
        int r107 = 48;
    L19:
        if ((r106.getGravity() & 112) == r107) goto L22;
        r106.setGravity(r107 | (r106.getGravity() & 7));
        r106.requestLayout();
        return;
    L22:
        return;
    L17:
        r107 = 80;
        goto L19
    L5:
        r102 = false;
        goto L7
    }

    public DefaultMarkdownCodeView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f320643a = new TextView(r100);
        this.f320644b = LazyKt.lazy(DefaultMarkdownCodeView$highlight$2.INSTANCE);
        ((Number) MarkdownDimensExtKt.T.getValue()).intValue();
        this.f320645c = 20;
        this.f320646d = "";
        this.f320647e = "";
        this.f320649g = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new b())).plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public /* synthetic */ DefaultMarkdownCodeView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
