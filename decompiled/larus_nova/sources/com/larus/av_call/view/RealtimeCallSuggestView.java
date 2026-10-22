package com.larus.av_call.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u001f\u0010\u000e\u001a\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\u0002\b\u0013J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/av_call/view/RealtimeCallSuggestView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "delegate", "Lcom/larus/av_call/view/SuggestAdapterDelegate;", "", "getDelegate", "updateStyle", "", "config", "Lkotlin/Function1;", "Landroid/widget/TextView;", "Lkotlin/ExtensionFunctionType;", "initAndGetDelegate", "av-call_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallSuggestView extends FrameLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f290576b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o<String> f290577a;

    public RealtimeCallSuggestView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RealtimeCallSuggestView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.av_call.view.f] */
    public final o<String> getDelegate() {
        o<String> r100 = this.f290577a;
        if (r100 != null) goto L13;
        final TextSwitcher r101 = (TextSwitcher) findViewById(R.id.suggest_switcher);
        final Ref.ObjectRef r102 = new Ref.ObjectRef();
        r102.element = "";
        final Ref.IntRef r103 = new Ref.IntRef();
        r103.element = -1;
        final Ref.BooleanRef r104 = new Ref.BooleanRef();
        r104.element = true;
        o<String> r105 = new o(new f(r101, r102, r103, r104));
        this.f290577a = r105;
        final n r106 = r105.f290694h;
        r101.setFactory(new g(r106, r101));
        Context r107 = r101.getContext();
        r106.getClass();
        r101.setInAnimation(r107, R.anim.larus_fade_in_slide_in_bottom);
        r101.setOutAnimation(r101.getContext(), R.anim.larus_fade_out_slide_out_top);
        View r108 = findViewById(R.id.container);
        if (r108 == null) goto L8;
        com.larus.utils.e1.d(r108, new h(r106, r102, r103));
    L8:
        o<String> r109 = this.f290577a;
        if (r109 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("delegate");
        return null;
    L12:
        return r109;
    L13:
        return r100;
    }

    public final void a(Function1<? super TextView, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        r100.invoke(findViewById(R.id.suggest_title));
    }

    public RealtimeCallSuggestView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        FrameLayout.inflate(r100, R.layout.larus_layout_view_realtime_call_suggest, this);
    }

    public /* synthetic */ RealtimeCallSuggestView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
