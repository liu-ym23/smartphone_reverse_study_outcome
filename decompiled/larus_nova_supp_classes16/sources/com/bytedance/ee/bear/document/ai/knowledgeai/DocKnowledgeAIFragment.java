package com.bytedance.ee.bear.document.ai.knowledgeai;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.document.databinding.DialogFragmentDocKnowledgeAiBinding;
import com.bytedance.ee.bear.facade.common.FragmentBackPressedHelperKt;
import com.bytedance.ee.bear.lark.dependency.q;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.inline.ai.api.knowledgeai.KnowledgeAIMessage;
import com.ss.android.lark.inline.ai.api.knowledgeai.KnowledgeAIPageMode;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010 \u001a\u00020\u001e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010!\u001a\u00020\u001eH\u0016J\"\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020$H\u0016J\b\u0010+\u001a\u00020\u001eH\u0016J\b\u0010,\u001a\u00020\u001eH\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u0006."}, d2 = {"Lcom/bytedance/ee/bear/document/ai/knowledgeai/DocKnowledgeAIFragment;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "Lcom/bytedance/ee/bear/facade/common/BackPressHandler;", "<init>", "()V", "ccmKnowledgeAISdk", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/CCMKnowledgeAISdk;", "getCcmKnowledgeAISdk", "()Lcom/ss/android/lark/inline/ai/api/knowledgeai/CCMKnowledgeAISdk;", "setCcmKnowledgeAISdk", "(Lcom/ss/android/lark/inline/ai/api/knowledgeai/CCMKnowledgeAISdk;)V", "binding", "Lcom/bytedance/ee/bear/document/databinding/DialogFragmentDocKnowledgeAiBinding;", "innerFragment", "Landroidx/fragment/app/Fragment;", "knowledgeAIDependency", "Lcom/bytedance/ee/bear/lark/dependency/IKnowledgeAIDependency;", "getKnowledgeAIDependency", "()Lcom/bytedance/ee/bear/lark/dependency/IKnowledgeAIDependency;", "knowledgeAIDependency$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onCreate", "onResume", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "", "getTheme", "onStart", "onDestroy", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocKnowledgeAIFragment extends AppCompatDialogFragment implements sa5.d {
    public static final /* synthetic */ int h = 0;
    public com.ss.android.lark.inline.ai.api.knowledgeai.c d;
    public DialogFragmentDocKnowledgeAiBinding e;
    public Fragment f;
    public final Lazy g;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnKeyListener {
        public final /* synthetic */ DocKnowledgeAIFragment a;

        public b(DocKnowledgeAIFragment r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface r1, int r2, KeyEvent r3) {
            if (r2 == 4) goto L5;
            return false;
        L5:
            if (r3.getAction() != 0) goto L12;
            DocKnowledgeAIFragment r4 = this.a;
            int r5 = DocKnowledgeAIFragment.h;
            q r6 = (q) r4.g.getValue();
            if (r6 == null) goto L13;
            Fragment r7 = this.a.f;
            r6.b();
            return false;
        L13:
            return false;
        L12:
            return false;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ DocKnowledgeAIFragment a;

        public c(DocKnowledgeAIFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ai.knowledgeai.DocKnowledgeAIFragment$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ee.bear.document.ai.knowledgeai.DocKnowledgeAIFragment$onCreate$1", f = "DocKnowledgeAIFragment.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.ss.android.lark.inline.ai.api.knowledgeai.c $ccmKnowledgeAISdk;
        final /* synthetic */ Fragment $innerFragment;
        final /* synthetic */ com.ss.android.lark.inline.ai.api.knowledgeai.d $knowledgeAIViewModel;
        int label;
        final /* synthetic */ DocKnowledgeAIFragment this$0;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ai.knowledgeai.DocKnowledgeAIFragment$onCreate$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ Fragment a;
            public final /* synthetic */ DocKnowledgeAIFragment b;
            public final /* synthetic */ com.ss.android.lark.inline.ai.api.knowledgeai.c c;

            /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ai.knowledgeai.DocKnowledgeAIFragment$onCreate$1$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0052a {
                public static final /* synthetic */ int[] a = null;

                static {
                    int[] r0 = new int[KnowledgeAIPageMode.values().length];
                    r0[KnowledgeAIPageMode.HIDE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
                L11:
                    r0[KnowledgeAIPageMode.BOTTOM_SHEET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
                L15:
                    r0[KnowledgeAIPageMode.KEYBOARD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
                L6:
                    a = r0;
                }
            }

            public a(Fragment r1, DocKnowledgeAIFragment r2, com.ss.android.lark.inline.ai.api.knowledgeai.c r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            public final Object emit(Object r4, Continuation r5) {
                KnowledgeAIPageMode r6 = (KnowledgeAIPageMode) r4;
                Log.i("DocKnowledgeAIFragment", "Page mode changed to: " + r6.name());
                int r7 = C0052a.a[r6.ordinal()];
                if (r7 != 1) goto L5;
                Log.d("DocKnowledgeAIFragment", "Hiding AI interface");
            L23:
                return Unit.INSTANCE;
            L5:
                if (r7 != 2) goto L7;
                Log.d("DocKnowledgeAIFragment", "Showing bottom sheet AI interface");
                if (this.a.isAdded() == true) goto L23;
                Log.d("DocKnowledgeAIFragment", "Adding inner fragment to container");
                FragmentTransaction r8 = this.b.getChildFragmentManager().beginTransaction();
                DialogFragmentDocKnowledgeAiBinding r9 = this.b.e;
                if (r9 != null) goto L16;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r9 = null;
            L16:
                int r10 = r9.c.getId();
                Fragment r1 = this.a;
                if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r8, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, r10) == true) goto L20;
                r8 = r8.add(r10, r1);
            L20:
                r8.commit();
                goto L23
            L7:
                if (r7 != 3) goto L10;
                Log.d("DocKnowledgeAIFragment", "Showing keyboard AI interface");
                com.ss.android.lark.inline.ai.api.knowledgeai.c r11 = this.c;
                final DocKnowledgeAIFragment r0 = this.b;
                r11.c(new DocKnowledgeAIFragment$onCreate$1$1$1(r0));
                goto L23
            L10:
                throw new NoWhenBranchMatchedException();
            }
        }

        public AnonymousClass1(com.ss.android.lark.inline.ai.api.knowledgeai.d r1, Fragment r2, DocKnowledgeAIFragment r3, com.ss.android.lark.inline.ai.api.knowledgeai.c r4, Continuation<? super AnonymousClass1> r5) {
            this.$knowledgeAIViewModel = r1;
            this.$innerFragment = r2;
            this.this$0 = r3;
            this.$ccmKnowledgeAISdk = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.$knowledgeAIViewModel, this.$innerFragment, this.this$0, this.$ccmKnowledgeAISdk, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r7);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            StateFlowImpl r8 = this.$knowledgeAIViewModel.g();
            a r2 = new a(this.$innerFragment, this.this$0, this.$ccmKnowledgeAISdk);
            this.label = 1;
            if (r8.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    static {
    }

    public final int getTheme() {
        Log.d("DocKnowledgeAIFragment", "getTheme: Using fullscreen theme without title bar");
        if (getShowsDialog() == false) goto L7;
        return 2131953795;
    L7:
        return super/*androidx.fragment.app.DialogFragment*/.getTheme();
    }

    @Override // sa5.d
    public final boolean onBackPressed() {
        Log.d("DocKnowledgeAIFragment", "onBackPressed: Handling back press");
        if (Intrinsics.areEqual(CollectionsKt.lastOrNull(getParentFragmentManager().getFragments()), this) == true) goto L5;
        return false;
    L5:
        q r0 = (q) this.g.getValue();
        if (r0 == null) goto L8;
        r0.b();
    L8:
        boolean r1 = isVisible();
        dismissAllowingStateLoss();     // Catch: Exception -> L11
    L15:
        if (r1 == false) goto L20;
        return true;
    L20:
        return false;
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L15;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L15
    }

    public final void onDestroy() {
        Log.d("DocKnowledgeAIFragment", "onDestroy: Fragment destroying, sending close panel message");
        com.ss.android.lark.inline.ai.api.knowledgeai.c r0 = this.d;
        if (r0 == null) goto L5;
        r0.a();
        com.ss.android.lark.inline.ai.c.a.e(new com.ss.android.lark.inline.ai.api.knowledgeai.e.b(new KnowledgeAIMessage.ClosePanelMessage(null, 1, null)));
    L5:
        super/*androidx.fragment.app.Fragment*/.onDestroy();
    }

    public DocKnowledgeAIFragment() {
        this.g = LazyKt.lazy(DocKnowledgeAIFragment$knowledgeAIDependency$2.INSTANCE);
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        if (getShowsDialog() == true) goto L6;
        FragmentBackPressedHelperKt.a(this, this);
        return;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        Log.d("DocKnowledgeAIFragment", "onStart: Fragment started, configuring dialog window");
        Dialog r0 = getDialog();
        if (r0 == null) goto L5;
        com.ss.android.lark.insets.f r2 = WindowInsetsUtils.a(r0);
        r2.c(false);
        r2.o(true);
        r2.f(false);
        r2.b(0);
        r2.k(true);
        r0.setOnKeyListener(new b(this));
    L5:
        com.ss.android.lark.inline.ai.api.knowledgeai.c r1 = this.d;
        if (r1 == null) goto L9;
        r1.a();
        com.ss.android.lark.inline.ai.c.a.e(new com.ss.android.lark.inline.ai.api.knowledgeai.e.b(new KnowledgeAIMessage.OpenPanelMessage(null, 1, null)));
        return;
    }

    public final void onCreate(Bundle r8) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r8);
        com.ss.android.lark.inline.ai.api.knowledgeai.c r4 = this.d;
        if (r4 != null) goto L6;
        Log.w("DocKnowledgeAIFragment", "onCreate: CCMKnowledgeAISdk is null, skipping setup");
        return;
    L6:
        final WeakReference r9 = new WeakReference(this);
        new DocKnowledgeAIFragment$onCreate$innerFragment$1(r9);
        Fragment r2 = r4.b();
        this.f = r2;
        r4.a();
        com.ss.android.lark.inline.ai.c r1 = com.ss.android.lark.inline.ai.c.a;
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new AnonymousClass1(r1, r2, this, r4, null));
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        r2.setOnClickListener(new c(this));
    }

    public final void onActivityResult(int r1, int r2, Intent r3) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r1, r2, r3);
        com.ss.android.lark.inline.ai.api.knowledgeai.c r4 = this.d;
        if (r4 == null) goto L6;
        r4.onActivityResult();
        return;
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Log.d("DocKnowledgeAIFragment", "onCreateView: Creating fragment view");
        View r6 = r3.inflate(2131560032, r4, false);
        int r7 = 2131364437;
        FrameLayout r8 = (FrameLayout) ViewBindings.findChildViewById(r6, 2131364437);
        if (r8 == null) goto L11;
        r7 = 2131367812;
        FrameLayout r0 = (FrameLayout) ViewBindings.findChildViewById(r6, 2131367812);
        if (r0 == null) goto L11;
        r7 = 2131384840;
        FrameLayout r1 = (FrameLayout) ViewBindings.findChildViewById(r6, 2131384840);
        if (r1 == null) goto L11;
        DialogFragmentDocKnowledgeAiBinding r9 = new DialogFragmentDocKnowledgeAiBinding((FrameLayout) r6, r8, r0, r1);
        this.e = r9;
        return r9.a;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }
}
