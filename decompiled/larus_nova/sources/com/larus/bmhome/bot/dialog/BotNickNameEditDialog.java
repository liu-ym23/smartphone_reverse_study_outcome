package com.larus.bmhome.bot.dialog;

import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.doubao.relax.profile.edit.ProfileEditRelaxPage;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.databinding.LarusDialogNicknameInputBottomBinding;
import com.larus.bmhome.utils.x1;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotSourceType;
import com.larus.im.bean.conversation.BotConversationType;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \u0018\u0000 ?2\u00020\u0001:\u0005?@ABCB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0002J$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010'\u001a\u00020\u000fH\u0016J\b\u0010(\u001a\u00020\u001aH\u0002J+\u0010)\u001a\u00020\r2\n\b\u0001\u0010*\u001a\u0004\u0018\u00010\u000f2\n\b\u0001\u0010+\u001a\u0004\u0018\u00010\u000f2\u0006\u0010,\u001a\u00020\u0007¢\u0006\u0002\u0010-J\b\u0010.\u001a\u00020\u001aH\u0002J\u0012\u0010/\u001a\u00020\u001a2\b\u00100\u001a\u0004\u0018\u00010\nH\u0002J\u001c\u00101\u001a\u00020\u001a2\b\u00102\u001a\u0004\u0018\u00010\r2\b\u00103\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u00104\u001a\u00020\u001a2\b\u00102\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u00105\u001a\u00020\r2\u0006\u00106\u001a\u00020\rH\u0002J\u0010\u00107\u001a\u00020\u001a2\u0006\u00108\u001a\u00020\u0007H\u0002J\u0010\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\rH\u0002J\u0010\u0010;\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\rH\u0002J \u0010<\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\r2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\u0013\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/larus/bmhome/bot/dialog/BotNickNameEditDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/bmhome/databinding/LarusDialogNicknameInputBottomBinding;", "mCheckInputNull", "", "Ljava/lang/Boolean;", "mTitle", "", "mSubTitle", "mText", "", "mMaxInputLength", "", "mBotId", "mConversationId", "isLoading", "mHintText", "mNickNameEditResultListener", "Lcom/larus/bmhome/bot/dialog/BotNickNameEditDialog$NickNameEditResultListener;", "imeManager", "Lcom/larus/bmhome/utils/ImeManager;", "mCurrentPage", "onResume", "", "onStop", ProfileEditRelaxPage.METHOD_HIDE_KEYBOARD, "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "getTheme", "trackShowEvent", "getChatType", "botConversationType", "botType", "isOwnBot", "(Ljava/lang/Integer;Ljava/lang/Integer;Z)Ljava/lang/String;", "setupView", "checkTextInputEnable", "text", "updateHintText", "botId", "conversationId", "updateContent", "setupNickNameEditTitle", "input", "isShowLoadingView", "show", "tryUpdateNickName", "nickName", "updateSelfProfile", "trackChangeUserNickName", "overallChange", "isSuccess", "Companion", "ImeStatus", "NickNameEditResponse", "Builder", "NickNameEditResultListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotNickNameEditDialog extends DialogFragment {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f296558n = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusDialogNicknameInputBottomBinding f296559d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f296560e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f296561f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f296562g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f296563h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f296564i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Boolean f296565j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public c f296566k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public x1 f296567l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f296568m;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/bot/dialog/BotNickNameEditDialog$ImeStatus;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "SHOW", "HIDE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ImeStatus extends Enum<ImeStatus> {
        public static final ImeStatus HIDE = null;
        public static final ImeStatus NONE = null;
        public static final ImeStatus SHOW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ImeStatus[] f296569a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f296570b = null;

        public static EnumEntries<ImeStatus> getEntries() {
            return f296570b;
        }

        static {
            ImeStatus r100 = new ImeStatus(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            ImeStatus r101 = new ImeStatus("SHOW", 1);
            SHOW = r101;
            ImeStatus r102 = new ImeStatus("HIDE", 2);
            HIDE = r102;
            ImeStatus[] r103 = {r100, r101, r102};
            f296569a = r103;
            f296570b = EnumEntriesKt.enumEntries(r103);
        }

        public static ImeStatus[] values() {
            return (ImeStatus[]) f296569a.clone();
        }

        public static ImeStatus valueOf(String r100) {
            return (ImeStatus) r27.a.a(ImeStatus.class, r100);
        }

        public ImeStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0004\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/bot/dialog/BotNickNameEditDialog$NickNameEditResponse;", "", "firstMessage", "", "isUpdateProfile", "", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "getFirstMessage", "()Ljava/lang/String;", "setFirstMessage", "(Ljava/lang/String;)V", "()Ljava/lang/Boolean;", "setUpdateProfile", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/bmhome/bot/dialog/BotNickNameEditDialog$NickNameEditResponse;", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("first_message")
        private String firstMessage;

        @SerializedName("is_update_profile_name")
        private Boolean isUpdateProfile;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.firstMessage, r101.firstMessage) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.isUpdateProfile, r101.isUpdateProfile) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r100 = this.firstMessage;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Boolean r104 = this.isUpdateProfile;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "NickNameEditResponse(firstMessage=" + this.firstMessage + ", isUpdateProfile=" + this.isUpdateProfile + ')';
        }

        public b() {
            Boolean r100 = Boolean.FALSE;
            this.firstMessage = null;
            this.isUpdateProfile = r100;
        }

        public final String a() {
            return this.firstMessage;
        }

        public final Boolean b() {
            return this.isUpdateProfile;
        }
    }

    public interface c {
        void a(String r100, String r101);

        void onCancel();
    }

    /* JADX INFO: renamed from: com.larus.bmhome.bot.dialog.BotNickNameEditDialog$onResume$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.bot.dialog.BotNickNameEditDialog$onResume$2", f = "BotNickNameEditDialog.kt", i = {}, l = {91, 92}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ BotNickNameEditDialog this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.bot.dialog.BotNickNameEditDialog$onResume$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.bmhome.bot.dialog.BotNickNameEditDialog$onResume$2$1", f = "BotNickNameEditDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ BotNickNameEditDialog this$0;

            public AnonymousClass1(BotNickNameEditDialog r100, Continuation<? super AnonymousClass1> r101) {
                this.this$0 = r100;
                super(2, r101);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                return new AnonymousClass1(this.this$0, r101);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                return invoke2(r100, r101);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            public static void INVOKEVIRTUAL_com_larus_bmhome_bot_dialog_BotNickNameEditDialog$onResume$2$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(BotNickNameEditDialog r100) {
                r100.dismissAllowingStateLoss();     // Catch: Exception -> L4
                return;
            L4:
                e = move-exception;
                com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
                Throwable r101 = DialogFragmentLancet.sLastShowStack;
                if (r101 == null) goto L11;
                com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
                return;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r100) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L13;
                ResultKt.throwOnFailure(r100);
                LarusDialogNicknameInputBottomBinding r101 = this.this$0.f296559d;
                if (r101 != null) goto L7;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r101 = null;
            L7:
                ViewTreeObserver r102 = r101.f310854a.getViewTreeObserver();
                if (r102 == null) goto L11;
                final BotNickNameEditDialog r103 = this.this$0;
                r102.addOnGlobalLayoutListener(new k(r103));
            L11:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass2(BotNickNameEditDialog r100, Continuation<? super AnonymousClass2> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L10;
            if (r102 == 1) goto L9;
            if (r102 != 2) goto L8;
            ResultKt.throwOnFailure(r100);
        L17:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r100);
        L13:
            MainCoroutineDispatcher r103 = Dispatchers.getMain();
            AnonymousClass1 r104 = new AnonymousClass1(this.this$0, null);
            this.label = 2;
            if (BuildersKt.withContext(r103, r104, this) != r101) goto L17;
            return r101;
        L10:
            ResultKt.throwOnFailure(r100);
            this.label = 1;
            if (DelayKt.delay(500, this) != r101) goto L13;
            return r101;
        }
    }

    static {
    }

    @Override // androidx.fragment.app.DialogFragment
    public final int getTheme() {
        return R.style.larus_EditBottomDialog;
    }

    public BotNickNameEditDialog() {
        Boolean r100 = Boolean.FALSE;
        this.f296560e = r100;
        this.f296561f = "";
        this.f296565j = r100;
    }

    public final void hideKeyboard() {
        FragmentActivity r100 = getActivity();
        LarusDialogNicknameInputBottomBinding r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.getSystemService("input_method");
    L7:
        if ((r102 instanceof InputMethodManager) == false) goto L9;
        InputMethodManager r103 = (InputMethodManager) r102;
    L10:
        if (r103 == null) goto L23;
        LarusDialogNicknameInputBottomBinding r104 = this.f296559d;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L15:
        r103.hideSoftInputFromWindow(r101.f310858e.getWindowToken(), 0);
        goto L23
    L14:
        r101 = r104;
    L23:
        dismissAllowingStateLoss();     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r105 = DialogFragmentLancet.sLastShowStack;
        if (r105 == null) goto L25;
        com.bytedance.crash.d.d(r105, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L25:
        return;
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        Dialog r100 = getDialog();
        if (r100 == null) goto L7;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L7;
        r101.setLayout(-1, -2);
        WindowManager.LayoutParams r102 = r101.getAttributes();
        Resources r103 = r101.getWindowStyle().getResources();
        r102.width = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).widthPixels;
        r101.setAttributes(r102);
    L7:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new AnonymousClass2(this, null), 2, null);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        hideKeyboard();
        c r100 = this.f296566k;
        if (r100 == null) goto L6;
        r100.onCancel();
        return;
    }

    public final void T90(CharSequence r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        LarusDialogNicknameInputBottomBinding r102 = null;
        if (r101 == false) goto L12;
    L22:
        LarusDialogNicknameInputBottomBinding r103 = this.f296559d;
        if (r103 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r103 = null;
    L25:
        r103.f310857d.setAlpha(0.3f);
        LarusDialogNicknameInputBottomBinding r104 = this.f296559d;
        if (r104 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L29:
        r102.f310857d.setEnabled(false);
        return;
    L28:
        r102 = r104;
        goto L29
    L12:
        if (r100.length() < 2) goto L22;
        LarusDialogNicknameInputBottomBinding r105 = this.f296559d;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r105 = null;
    L17:
        r105.f310857d.setAlpha(1.0f);
        LarusDialogNicknameInputBottomBinding r106 = this.f296559d;
        if (r106 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L21:
        r102.f310857d.setEnabled(true);
        return;
    L20:
        r102 = r106;
        goto L21
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final void V90(boolean r100) {
        LarusDialogNicknameInputBottomBinding r101 = null;
        if (r100 == false) goto L12;
        this.f296565j = Boolean.TRUE;
        LarusDialogNicknameInputBottomBinding r102 = this.f296559d;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r102 = null;
    L7:
        r102.f310861h.setVisibility(0);
        LarusDialogNicknameInputBottomBinding r103 = this.f296559d;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L11:
        r101.f310857d.setVisibility(4);
        return;
    L10:
        r101 = r103;
        goto L11
    L12:
        this.f296565j = Boolean.FALSE;
        LarusDialogNicknameInputBottomBinding r104 = this.f296559d;
        if (r104 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r104 = null;
    L15:
        r104.f310857d.setVisibility(0);
        LarusDialogNicknameInputBottomBinding r105 = this.f296559d;
        if (r105 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L19:
        r101.f310861h.setVisibility(4);
        return;
    L18:
        r101 = r105;
        goto L19
    }

    public final void W90(String r100) {
        if (Intrinsics.areEqual(this.f296565j, Boolean.TRUE) == false) goto L5;
        return;
    L5:
        V90(true);
        AppHost.f326268a.getApplication();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new BotNickNameEditDialog$tryUpdateNickName$1(this, r100, null), 3, null);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r110);
        if (Intrinsics.areEqual(this.f296560e, Boolean.TRUE) == false) goto L15;
        LarusDialogNicknameInputBottomBinding r101 = this.f296559d;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r101 = null;
    L7:
        T90(r101.f310858e.getText());
        LarusDialogNicknameInputBottomBinding r102 = this.f296559d;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r102 = null;
    L10:
        r102.f310858e.addTextChangedListener(new l(this));
        LarusDialogNicknameInputBottomBinding r103 = this.f296559d;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r103 = null;
    L13:
        r103.f310858e.setOnEditorActionListener(new m(this));
    L15:
        if (this.f296562g <= 0) goto L20;
        LarusDialogNicknameInputBottomBinding r104 = this.f296559d;
        if (r104 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r104 = null;
    L19:
        r104.f310858e.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(this.f296562g)});
    L20:
        LarusDialogNicknameInputBottomBinding r105 = this.f296559d;
        if (r105 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r105 = null;
    L23:
        r105.f310858e.requestFocus();
        LarusDialogNicknameInputBottomBinding r106 = this.f296559d;
        if (r106 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r106 = null;
    L26:
        r106.f310857d.setOnClickListener(new h(this));
        LarusDialogNicknameInputBottomBinding r107 = this.f296559d;
        if (r107 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r107 = null;
    L29:
        r107.f310856c.setOnClickListener(new i(this));
        LarusDialogNicknameInputBottomBinding r108 = this.f296559d;
        if (r108 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r108 = null;
    L32:
        r108.f310855b.setOnClickListener(new j(this));
        String r109 = this.f296563h;
        if (r109 == null) goto L36;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new BotNickNameEditDialog$updateContent$1(r109, this, null), 2, null);
    L36:
        String r111 = this.f296563h;
        String r112 = this.f296564i;
        if (r111 == null) goto L42;
        if (r112 == null) goto L42;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new BotNickNameEditDialog$updateHintText$1(r112, r111, this, null), 2, null);
    L42:
        Dialog r113 = getDialog();
        if (r113 == null) goto L45;
        r113.setCanceledOnTouchOutside(true);
    L45:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new BotNickNameEditDialog$trackShowEvent$1(this, null), 2, null);
    }

    public static String U90(@BotConversationType Integer r100, @BotSourceType Integer r101, boolean r102) {
        if (r100 != null) goto L5;
    L7:
        if (r100 != null) goto L10;
    L12:
        if (r101 != null) goto L15;
    L19:
        return "other_default";
    L15:
        if (r101.intValue() != 0) goto L19;
        if (r102 == false) goto L18;
        return "self_created";
    L18:
        return "others_created";
    L10:
        if (r100.intValue() != 3) goto L12;
        return "default_new";
    L5:
        if (r100.intValue() != 1) goto L7;
        return "default";
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r113 = r110.inflate(R.layout.larus_dialog_nickname_input_bottom, r111, false);
        int r114 = R.id.background;
        View r100 = ViewBindings.findChildViewById(r113, R.id.background);
        if (r100 == null) goto L27;
        r114 = R.id.cancel;
        AppCompatImageView r101 = (AppCompatImageView) ViewBindings.findChildViewById(r113, R.id.cancel);
        if (r101 == null) goto L27;
        r114 = R.id.confirm;
        ImageView r102 = (ImageView) ViewBindings.findChildViewById(r113, R.id.confirm);
        if (r102 == null) goto L27;
        r114 = R.id.dialog_input;
        EditText r103 = (EditText) ViewBindings.findChildViewById(r113, R.id.dialog_input);
        if (r103 == null) goto L27;
        r114 = R.id.dialog_sub_title;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r113, R.id.dialog_sub_title);
        if (r104 == null) goto L27;
        r114 = R.id.dialog_title;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r113, R.id.dialog_title);
        if (r105 == null) goto L27;
        r114 = R.id.loading_view;
        ProgressBar r106 = (ProgressBar) ViewBindings.findChildViewById(r113, R.id.loading_view);
        if (r106 == null) goto L27;
        LarusDialogNicknameInputBottomBinding r115 = new LarusDialogNicknameInputBottomBinding((RelativeLayout) r113, r100, r101, r102, r103, r104, r105, r106);
        this.f296559d = r115;
        this.f296567l = new x1(r115.f310858e);
        Dialog r116 = getDialog();
        if (r116 == null) goto L21;
        Window r117 = r116.getWindow();
        if (r117 == null) goto L21;
        r117.setGravity(80);
        r117.setBackgroundDrawable(new ColorDrawable(0));
    L21:
        LarusDialogNicknameInputBottomBinding r118 = this.f296559d;
        if (r118 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r118 = null;
    L25:
        return r118.f310854a;
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r114)));
    }

    public static final void S90(BotNickNameEditDialog r110, String r111, boolean r112, boolean r113) {
        r110.getClass();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r110), Dispatchers.getIO(), null, new BotNickNameEditDialog$trackChangeUserNickName$1(r110, r111, r112, r113, null), 2, null);
    }
}
