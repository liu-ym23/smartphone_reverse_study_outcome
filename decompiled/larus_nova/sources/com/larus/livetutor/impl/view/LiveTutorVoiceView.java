package com.larus.livetutor.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.livetutor.impl.databinding.LiveTutorVoiceViewLayoutBinding;
import com.larus.livetutor.impl.repository.viewmodel.LiveTutorViewModel;
import com.larus.livetutor.impl.rtc.adpter.LiveTutorConnectedStatus;
import com.larus.livetutor.impl.tutor.data.LiveTutorPauseEvent;
import com.larus.livetutor.impl.typing.TypingTextView;
import com.larus.livetutor.impl.typing.datasource.DefaultTypingDataSource;
import com.larus.livetutor.impl.typing.datasource.StreamStatus;
import com.larus.livetutor.impl.typing.enumeration.TypingMode;
import com.larus.livetutor.impl.typing.enumeration.TypingStreamStatus;
import com.larus.livetutor.impl.typing.looper.TypingLooper;
import com.larus.livetutor.impl.typing.service.TypingService;
import com.larus.livetutor.impl.utils.UtilsKt;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 42\u00020\u0001:\u00014B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010(\u001a\u00020)H\u0003J\u0010\u0010*\u001a\u00020)2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0014\u0010+\u001a\u00020)*\u00020\u000b2\u0006\u0010,\u001a\u00020-H\u0002J\u0012\u0010.\u001a\u00020)2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\b\u00101\u001a\u00020)H\u0002J\b\u00102\u001a\u00020)H\u0014J\b\u00103\u001a\u00020)H\u0014R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR(\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u000f\u001a\u0004\b!\u0010\"R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u00020'8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/larus/livetutor/impl/view/LiveTutorVoiceView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/livetutor/impl/databinding/LiveTutorVoiceViewLayoutBinding;", "getBinding", "()Lcom/larus/livetutor/impl/databinding/LiveTutorVoiceViewLayoutBinding;", "binding$delegate", "Lkotlin/Lazy;", "value", "Lcom/larus/livetutor/impl/repository/viewmodel/LiveTutorViewModel;", "viewModel", "getViewModel", "()Lcom/larus/livetutor/impl/repository/viewmodel/LiveTutorViewModel;", "setViewModel", "(Lcom/larus/livetutor/impl/repository/viewmodel/LiveTutorViewModel;)V", "subtitleTouchDownX", "", "subtitleTouchDownY", "typingDataSource", "Lcom/larus/livetutor/impl/typing/datasource/DefaultTypingDataSource;", "getTypingDataSource", "()Lcom/larus/livetutor/impl/typing/datasource/DefaultTypingDataSource;", "typingDataSource$delegate", "typingService", "Lcom/larus/livetutor/impl/typing/service/ITypingService;", "getTypingService", "()Lcom/larus/livetutor/impl/typing/service/ITypingService;", "typingService$delegate", "textLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "touchListener", "Landroid/view/View$OnTouchListener;", "initView", "", "initObserver", "updateUIByState", "state", "Lcom/larus/livetutor/impl/rtc/api/BusinessConnectedStatus;", "appendSubtitleStream", "content", "", BasicTestActionHandler.TEST_ACTION_RESET, "onAttachedToWindow", "onDetachedFromWindow", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LiveTutorVoiceView extends ConstraintLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f356766h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f356767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LiveTutorViewModel f356768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f356769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f356770d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f356771e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f356772f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final z1 f356773g;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f356774a;

        public b(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f356774a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f356774a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f356774a.invoke(r100);
        }
    }

    static {
    }

    public LiveTutorVoiceView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LiveTutorVoiceView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final LiveTutorVoiceViewLayoutBinding getBinding() {
        return (LiveTutorVoiceViewLayoutBinding) this.f356767a.getValue();
    }

    private final DefaultTypingDataSource getTypingDataSource() {
        return (DefaultTypingDataSource) this.f356771e.getValue();
    }

    private final com.larus.livetutor.impl.typing.service.a getTypingService() {
        return (com.larus.livetutor.impl.typing.service.a) this.f356772f.getValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        CustomMarkdownTextView r100 = getBinding().f355999d.getMarkdownTextView();
        if (r100 == null) goto L6;
        r100.addOnLayoutChangeListener(this.f356773g);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CustomMarkdownTextView r100 = getBinding().f355999d.getMarkdownTextView();
        if (r100 == null) goto L6;
        r100.removeOnLayoutChangeListener(this.f356773g);
        return;
    }

    public final LiveTutorViewModel getViewModel() {
        return this.f356768b;
    }

    public static TypingService T5(LiveTutorVoiceView r100) {
        com.larus.livetutor.impl.typing.service.a.f356633a.getClass();
        TypingService r101 = new TypingService();
        Intrinsics.checkNotNullParameter("TypingService-LiveTutor", "serviceName");
        r101.f356614c = "TypingService-LiveTutor";
        TypingMode r102 = TypingMode.FlushTypingMode;
        Intrinsics.checkNotNullParameter(r102, "typingMode");
        r101.f356615d = r102;
        com.larus.livetutor.impl.typing.rhythm.a r103 = new com.larus.livetutor.impl.typing.rhythm.a();
        Intrinsics.checkNotNullParameter(r103, "controller");
        r101.f356616e = r103;
        DefaultTypingDataSource r104 = r100.getTypingDataSource();
        Intrinsics.checkNotNullParameter(r104, "dataSource");
        if (r104 == null) goto L5;
        r104.c(r101);
    L5:
        TypingLooper r105 = (TypingLooper) r101.f356620i.getValue();
        r105.f356607b = r101.f356616e;
        com.larus.livetutor.impl.typing.service.f r106 = new com.larus.livetutor.impl.typing.service.f(r101);
        Intrinsics.checkNotNullParameter(r106, "getter");
        r105.f356608c = r106;
        Intrinsics.checkNotNullParameter(r101, "callback");
        r105.f356609d = r101;
        return r101;
    }

    public static final /* synthetic */ LiveTutorVoiceViewLayoutBinding V5(LiveTutorVoiceView r100) {
        return r100.getBinding();
    }

    public static final void Y5(LiveTutorVoiceView r100) {
        r100.getClass();
        kj9.b.a("[subtitleText]: reset");
        r100.getTypingDataSource().b(StreamStatus.STOP);
        r100.getTypingDataSource().a("");
        DefaultTypingDataSource r101 = r100.getTypingDataSource();
        r101.getClass();
        r101.f356591b = DefaultTypingDataSource.DataSourceUpdateMode.Create;
        r101.f356592c = true;
        StringsKt.clear(r101.f356594e);
        r101.f356595f = 0;
    }

    public final void setViewModel(final LiveTutorViewModel r100) {
        this.f356768b = r100;
        if (r100 != null) goto L5;
        return;
    L5:
        LifecycleOwner r101 = r100.getLifecycleOwner();
        if (r101 == null) goto L10;
        r100.getSubtitleState().observe(r101, new b(new b2(r100, this)));
        UtilsKt.m(ViewModelKt.getViewModelScope(r100), null, new LiveTutorVoiceView$initObserver$2(r100, this, null), 3);
        r100.registerSubtitleListener(new e2(this));
        r100.getPauseRtc().observe(r101, new b(new c2(r100, this)));
        r100.getSaveBoardUuid().observe(r101, new b(new d2()));
        return;
    }

    public static final void U5(LiveTutorVoiceView r100, String r101) {
        r100.getClass();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        return;
    L12:
        if (r100.getTypingService().a() == TypingStreamStatus.Streaming) goto L14;
        r100.getTypingDataSource().b(StreamStatus.STREAMING);
    L14:
        r100.getTypingDataSource().a(r101);
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public final void Z5(LiveTutorVoiceViewLayoutBinding r100, ij9.a r101) {
        TextView r102 = r100.f355997b;
        Intrinsics.checkNotNull(r102);
        int r103 = 0;
        if ((r101 instanceof LiveTutorConnectedStatus.Thinking) == true) goto L5;
    L15:
        boolean r104 = true;
    L17:
        if (r104 == false) goto L19;
        int r105 = 4;
    L20:
        r102.setVisibility(r105);
        r102.setText(r102.getContext().getString(R.string.larus_tutor_thinking_cn));
        r102.setTextColor(ContextCompat.getColor(r102.getContext(), R.color.live_tutor_Gray_Text_3));
        TypingTextView r106 = r100.f355999d;
        LiveTutorViewModel r107 = this.f356768b;
        if (r107 == null) goto L25;
        MutableLiveData<Boolean> r108 = r107.getSubtitleState();
        if (r108 == null) goto L25;
        boolean r109 = Intrinsics.areEqual(r108.getValue(), Boolean.FALSE);
    L26:
        if (r109 == false) goto L28;
        Intrinsics.checkNotNull(r106);
        com.larus.utils.e1.o(r106);
        return;
    L28:
        boolean r110 = kj9.b.f503724a;
        kj9.b.a("[LiveTutorVoiceView] updateSubtitle visibility = " + com.larus.livetutor.impl.tutor.controller.m0.a(r101));
        Intrinsics.checkNotNull(r106);
        if ((!com.larus.livetutor.impl.tutor.controller.m0.a(r101)) == false) goto L31;
        r103 = 4;
    L31:
        r106.setVisibility(r103);
        return;
    L25:
        r109 = false;
        goto L26
    L19:
        r105 = 0;
        goto L20
    L5:
        if (((LiveTutorConnectedStatus.Thinking) r101).getShowMsg() == false) goto L15;
        LiveTutorViewModel r111 = this.f356768b;
        if (r111 != null) goto L9;
    L11:
        boolean r112 = false;
    L12:
        if (r112 == true) goto L15;
        r104 = false;
        goto L17
    L9:
        if (r111.isPause() != true) goto L11;
        r112 = true;
        goto L12
    }

    /* JADX WARN: Type inference failed for: r6v7, types: [com.larus.livetutor.impl.view.z1] */
    public LiveTutorVoiceView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f356767a = LazyKt.lazy(new w1(r100, this));
        this.f356771e = LazyKt.lazy(new x1());
        this.f356772f = LazyKt.lazy(new y1(this));
        this.f356773g = new z1();
        View.OnTouchListener r103 = new a2(this, r100);
        TypingTextView r104 = getBinding().f355999d;
        CustomMarkdownTextView r105 = r104.getMarkdownTextView();
        if (r105 == null) goto L5;
        r105.setTextSize(1, 15.0f);
        r105.setTextColor(ContextCompat.getColor(r105.getContext(), R.color.live_tutor_voice_subtitle_text));
        r105.setLineHeight(i5.C());
        r105.setVerticalScrollBarEnabled(false);
        r105.setMovementMethod(null);
        r105.setMaxLines(2);
        ViewTreeObserver r106 = r105.getViewTreeObserver();
        r105.getViewTreeObserver().addOnGlobalLayoutListener(new f2(r105, r106, r105));
        r105.setOnTouchListener(r103);
    L5:
        com.larus.livetutor.impl.typing.service.a r107 = getTypingService();
        qj9.a r108 = new qj9.a();
        r108.f533434b = r104.getMarkdownTextView();
        r107.g(r108);
        r104.bindService(getTypingService(), true);
        getBinding().f355998c.setOnTouchListener(r103);
    }

    public static Unit R5(LiveTutorViewModel r100, LiveTutorVoiceView r101, Boolean r102) {
        if (r102.booleanValue() == false) goto L8;
        ij9.a r103 = r100.getCurrentContentState();
        if (r103 == null) goto L7;
        r101.Z5(r101.getBinding(), r103);
    L7:
        UtilsKt.q(r101.getBinding().f355998c, i5.g0());
    L10:
        return Unit.INSTANCE;
    L8:
        com.larus.utils.e1.o(r101.getBinding().f355999d);
        UtilsKt.q(r101.getBinding().f355998c, -2);
        goto L10
    }

    public static Unit S5(LiveTutorViewModel r100, LiveTutorVoiceView r101, LiveTutorPauseEvent r102) {
        boolean r103 = kj9.b.f503724a;
        kj9.b.a("[LiveTutorVoiceView] pauseRtc = " + r102);
        ij9.a r104 = r100.getCurrentContentState();
        if (r104 == null) goto L6;
        r101.Z5(r101.getBinding(), r104);
    L6:
        return Unit.INSTANCE;
    }

    public /* synthetic */ LiveTutorVoiceView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
