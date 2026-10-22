package com.larus.bmhome.chat.component.showcase;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.larus.bmhome.databinding.LarusCaseTitleLayoutBinding;
import com.larus.bmhome.view.TitleAvatarImageView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 /2\u00020\u0001:\u0001/B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\nJ\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J\u000e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u001dJ\b\u0010 \u001a\u00020\rH\u0002J\b\u0010!\u001a\u00020\u0014H\u0002J\u000e\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u001dJ\u0018\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020\u0012H\u0002J\b\u0010)\u001a\u00020\u0014H\u0002J\u000e\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020\u00142\u0006\u0010+\u001a\u00020,J\u000e\u0010.\u001a\u00020\u00142\u0006\u0010+\u001a\u00020,R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/larus/bmhome/chat/component/showcase/ShowCaseTitleBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/larus/bmhome/databinding/LarusCaseTitleLayoutBinding;", "binding", "getBinding", "()Lcom/larus/bmhome/databinding/LarusCaseTitleLayoutBinding;", "navigatorSimplify", "", "init", "", "initView", "setupSubTitle", "setBackIconRes", "iconResId", "setSubtitleVisible", "isVisible", com.alipay.sdk.m.x.d.f25925o, "title", "", "setSubTitle", "subTitle", "generateBinding", "setupCreateCvs", "setAvatar", "iconUrl", "loadImg", "imgUrl", "builder", "Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;", "enableReplaceCall2Create", "adjustNavigatorSimplify", "setOnBackClickListener", "listener", "Landroid/view/View$OnClickListener;", "setOnSubClickListener", "setOnshareClickListener", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShowCaseTitleBar extends ConstraintLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f301631c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LarusCaseTitleLayoutBinding f301632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f301633b;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.showcase.ShowCaseTitleBar$setAvatar$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.showcase.ShowCaseTitleBar$setAvatar$1", f = "ShowCaseTitleBar.kt", i = {}, l = {145}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $iconUrl;
        int label;
        final /* synthetic */ ShowCaseTitleBar this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.component.showcase.ShowCaseTitleBar$setAvatar$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.bmhome.chat.component.showcase.ShowCaseTitleBar$setAvatar$1$1", f = "ShowCaseTitleBar.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C40511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PipelineDraweeControllerBuilder $builder;
            final /* synthetic */ String $iconUrl;
            int label;
            final /* synthetic */ ShowCaseTitleBar this$0;

            public C40511(ShowCaseTitleBar r100, String r101, PipelineDraweeControllerBuilder r102, Continuation<? super C40511> r103) {
                this.this$0 = r100;
                this.$iconUrl = r101;
                this.$builder = r102;
                super(2, r103);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                return new C40511(this.this$0, this.$iconUrl, this.$builder, r101);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                return invoke2(r100, r101);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                return ((C40511) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r100) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r100);
                ShowCaseTitleBar r101 = this.this$0;
                String r102 = this.$iconUrl;
                PipelineDraweeControllerBuilder r103 = this.$builder;
                Intrinsics.checkNotNull(r103);
                int r104 = ShowCaseTitleBar.f301631c;
                r101.S5(r102, r103);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(ShowCaseTitleBar r100, String r101, Continuation<? super AnonymousClass1> r102) {
            this.this$0 = r100;
            this.$iconUrl = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, this.$iconUrl, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            PipelineDraweeControllerBuilder r103 = Fresco.newDraweeControllerBuilder();
            MainCoroutineDispatcher r104 = Dispatchers.getMain();
            C40511 r105 = new C40511(this.this$0, this.$iconUrl, r103, null);
            this.label = 1;
            if (BuildersKt.withContext(r104, r105, this) != r101) goto L12;
            return r101;
        }
    }

    static {
    }

    public final LarusCaseTitleLayoutBinding getBinding() {
        LarusCaseTitleLayoutBinding r100 = this.f301632a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public ShowCaseTitleBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f301633b = z2.f365865a.getChatNavigatorConfig().f486625b;
        R5(r100, null);
    }

    private final void setSubtitleVisible(boolean r100) {
        TextView r101 = getBinding().f310786h;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        if (r100 == false) goto L9;
        getBinding().f310787i.setTextSize(0, i5.o());
        getBinding().f310787i.setTypeface(Typeface.defaultFromStyle(0));
        return;
    L9:
        getBinding().f310787i.setTextSize(0, i5.v());
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void setAvatar(String r100) {
        Intrinsics.checkNotNullParameter(r100, "iconUrl");
        if (this.f301633b == false) goto L5;
        return;
    L5:
        getBinding().f310783e.setVisibility(0);
        if (TextUtils.isEmpty(r100) == false) goto L9;
        getBinding().f310780b.setActualImageResource(R.drawable.larus_common_ui_avatar_placeholder);
        return;
    L9:
        getBinding().f310780b.getHierarchy().setFadeDuration(200);
        Object r101 = getContext();
        if ((r101 instanceof LifecycleOwner) == true) goto L12;
    L14:
        S5(r100, Fresco.newDraweeControllerBuilder());
        return;
    L12:
        if (z2.f365865a.isLazyMainComponentEnable() == false) goto L14;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) r101), Dispatchers.getIO(), null, new AnonymousClass1(this, r100, null), 2, null);
    }

    public final void setBackIconRes(int r100) {
        getBinding().f310781c.setImageResource(r100);
    }

    public final void setOnBackClickListener(final View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        e1.d(getBinding().f310781c, new z(r100));
    }

    public final void setOnSubClickListener(final View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        e1.d(getBinding().f310782d, new b0(r100));
    }

    public final void setOnshareClickListener(final View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        e1.d(getBinding().f310785g, new a0(r100));
    }

    public final void setSubTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "subTitle");
        LarusCaseTitleLayoutBinding r101 = getBinding();
        if (r101 == null) goto L8;
        TextView r102 = r101.f310786h;
        if (r102 == null) goto L9;
        r102.setText(r100);
        return;
    L9:
        return;
    }

    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "title");
        LarusCaseTitleLayoutBinding r101 = getBinding();
        if (r101 == null) goto L8;
        TextView r102 = r101.f310787i;
        if (r102 == null) goto L9;
        r102.setText(r100);
        return;
    L9:
        return;
    }

    public ShowCaseTitleBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f301633b = z2.f365865a.getChatNavigatorConfig().f486625b;
        R5(r100, r101);
    }

    public final void R5(Context r110, AttributeSet r111) {
        Context r112 = getContext();
        z2 r113 = z2.f365865a;
        if (r113.enablePreloadChatPageView().b() == false) goto L7;
        o37.c.f521918e.getClass();
        if (o37.c.f("chat_fragment_nita") == false) goto L7;
        boolean r114 = r112 instanceof Activity;
    L7:
        LayoutInflater.from(getContext()).inflate(R.layout.larus_case_title_layout, this);
        int r115 = R.id.avatar;
        TitleAvatarImageView r100 = (TitleAvatarImageView) ViewBindings.findChildViewById(this, R.id.avatar);
        if (r100 == null) goto L36;
        r115 = R.id.back_icon;
        AppCompatImageView r101 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.back_icon);
        if (r101 == null) goto L36;
        r115 = R.id.create_new_cvs;
        ImageView r102 = (ImageView) ViewBindings.findChildViewById(this, R.id.create_new_cvs);
        if (r102 == null) goto L36;
        r115 = R.id.img_cover_container;
        ConstraintLayout r103 = (ConstraintLayout) ViewBindings.findChildViewById(this, R.id.img_cover_container);
        if (r103 == null) goto L36;
        r115 = R.id.main_container;
        ConstraintLayout r104 = (ConstraintLayout) ViewBindings.findChildViewById(this, R.id.main_container);
        if (r104 == null) goto L36;
        r115 = R.id.main_container_end_barrier;
        if (((Barrier) ViewBindings.findChildViewById(this, R.id.main_container_end_barrier)) == null) goto L36;
        r115 = R.id.share;
        AppCompatImageView r105 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.share);
        if (r105 == null) goto L36;
        r115 = R.id.subtitle;
        TextView r106 = (TextView) ViewBindings.findChildViewById(this, R.id.subtitle);
        if (r106 == null) goto L36;
        r115 = R.id.title;
        TextView r116 = (TextView) ViewBindings.findChildViewById(this, R.id.title);
        if (r116 == null) goto L36;
        LarusCaseTitleLayoutBinding r117 = new LarusCaseTitleLayoutBinding(this, r100, r101, r102, r103, r104, r105, r106, r116);
        Intrinsics.checkNotNull(r117);
        this.f301632a = r117;
        if (this.f301633b == false) goto L29;
        ConstraintLayout r118 = getBinding().f310784f;
        ViewGroup.LayoutParams r107 = r118.getLayoutParams();
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r108 = (ConstraintLayout.LayoutParams) r107;
        r108.endToEnd = 0;
        r108.endToStart = -1;
        r108.horizontalBias = 0.5f;
        r108.setMarginStart(0);
        r118.setLayoutParams(r108);
        TextView r119 = getBinding().f310787i;
        ViewGroup.LayoutParams r109 = r119.getLayoutParams();
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r120 = (ConstraintLayout.LayoutParams) r109;
        ((ViewGroup.MarginLayoutParams) r120).width = -2;
        r120.setMarginStart(0);
        r120.setMarginEnd(0);
        r120.constrainedWidth = true;
        r120.horizontalChainStyle = 2;
        r120.horizontalBias = 0.5f;
        r120.startToStart = getBinding().f310784f.getId();
        r119.setLayoutParams(r120);
        r119.setMaxWidth(com.larus.utils.i.d(getContext()) - (i5.d() * 2));
        TextView r121 = getBinding().f310786h;
        ViewGroup.LayoutParams r122 = getBinding().f310786h.getLayoutParams();
        Intrinsics.checkNotNull(r122, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r123 = (ConstraintLayout.LayoutParams) r122;
        ((ViewGroup.MarginLayoutParams) r123).width = -2;
        r123.horizontalBias = 0.5f;
        r123.setMarginStart(0);
        r121.setLayoutParams(r123);
    L29:
        if (r113.o0().f486637a == false) goto L32;
        getBinding().f310782d.setImageResource(com.larus.bmhome.utils.t.a());
        e1.x(getBinding().f310782d);
    L32:
        if (r113.o0().f486639c == false) goto L37;
        setSubtitleVisible(false);
        return;
    L37:
        return;
    L36:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r115)));
    }

    public final void S5(String r100, final PipelineDraweeControllerBuilder r101) {
        ImageLoaderKt.w(getBinding().f310780b, r100, "chat.bot_avatar", new c0(r101), null);
        getBinding().f310780b.setColorFilter(ContextCompat.getColor(getContext(), v19.c.b(R.attr.larus_primary_50, getContext(), R.color.larus_primary_50)));
    }

    public ShowCaseTitleBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f301633b = z2.f365865a.getChatNavigatorConfig().f486625b;
        R5(r100, r101);
    }
}
