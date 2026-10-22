package com.story.ai.biz.comment;

import android.app.Dialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.bmhome.view.actionbar.segment.BotCommentRemoteHttpApi;
import com.larus.nova.R;
import com.larus.platform.model.comment.ICommentService;
import com.larus.platform.model.comment.api.CommentHttpApi$GetCommentListData;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.story.ai.biz.comment.bot.BotCommentDialogFragment;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0096@¢\u0006\u0002\u0010\u001aJ\f\u0010\u001b\u001a\u00060\u001cj\u0002`\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 H\u0016R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006!"}, d2 = {"Lcom/story/ai/biz/comment/CommentServiceImpl;", "Lcom/larus/platform/model/comment/ICommentService;", "<init>", "()V", "latestCommentPanelHash", "", "Ljava/lang/Integer;", "showBotCommentPanel", "", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "params", "Lcom/larus/platform/model/comment/api/ICommentInitData;", "dataMediator", "Lcom/larus/platform/model/comment/api/IDataMediator;", com.bytedance.android.ec.core.event.a.KEY_TRACKER, "Lcom/larus/platform/model/comment/api/ICommentTracker;", "commentCallback", "Lcom/larus/platform/model/comment/api/ICommentCallback;", "releaseBotCommentPanel", "preloadBotCommentData", "Lcom/larus/platform/model/comment/api/CommentHttpApi$GetCommentListData;", "commentHttpApi", "Lcom/larus/platform/model/comment/api/CommentHttpApi;", "botId", "", "(Lcom/larus/platform/model/comment/api/CommentHttpApi;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "accessCommentComponentClazz", "Lcom/larus/ui/arch/component/external/delegate/BaseSlotWidget;", "Lcom/larus/ui/arch/component/external/SlotComponent;", "initialize", "initParams", "Lcom/larus/platform/model/comment/api/CommentComponentInitParams;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentServiceImpl implements ICommentService {
    public CommentServiceImpl() {
    }

    @Override // com.larus.platform.model.comment.ICommentService
    public final CommentComponent d() {
        return new CommentComponent();
    }

    @Override // com.larus.platform.model.comment.ICommentService
    public final void a(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        FragmentManager r101 = r100.getChildFragmentManager();     // Catch: IllegalStateException -> L24
        Fragment r102 = r101.findFragmentByTag("comment_dialog");     // Catch: IllegalStateException -> L24
        if ((r102 instanceof BotCommentDialogFragment) == false) goto L6;
        BotCommentDialogFragment r103 = (BotCommentDialogFragment) r102;     // Catch: IllegalStateException -> L24
    L7:
        if (r103 != null) goto L9;
        return;
    L9:
        Dialog r104 = r103.getDialog();     // Catch: IllegalStateException -> L24
        boolean r105 = false;
        if (r104 != null) goto L12;
    L14:
        if (r105 == false) goto L27;
        return;
    L27:
        r103.dismiss();     // Catch: Exception -> L18
    L22:
        FragmentTransaction r106 = r101.beginTransaction();     // Catch: IllegalStateException -> L24
        r106.setCustomAnimations(R.anim.larus_ui_components_bottom_sheet_slide_in, R.anim.larus_ui_components_bottom_sheet_slide_out);     // Catch: IllegalStateException -> L24
        r106.setReorderingAllowed(true);     // Catch: IllegalStateException -> L24
        r106.remove(r103);     // Catch: IllegalStateException -> L24
        r106.commitNow();     // Catch: IllegalStateException -> L24
        return;
    L18:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: IllegalStateException -> L24
        Throwable r107 = DialogFragmentLancet.sLastShowStack;     // Catch: IllegalStateException -> L24
        if (r107 == null) goto L22;
        com.bytedance.crash.d.d(r107, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: IllegalStateException -> L24
        goto L22
    L12:
        if (r104.isShowing() != true) goto L14;
        r105 = true;
        goto L14
    L6:
        r103 = null;
    L24:
        e = move-exception;
        FLogger.f375446a.e("CommentServiceImpl", "hideCommentPanel error: " + e.getMessage());
    }

    @Override // com.larus.platform.model.comment.ICommentService
    public final void c(Fragment r100, rq9.a r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "initParams");
        s1a.a.g(r100).n(r101, rq9.a.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.platform.model.comment.ICommentService
    public final Object b(BotCommentRemoteHttpApi r100, String r101, Continuation r110) {
        if ((r110 instanceof CommentServiceImpl$preloadBotCommentData$1) == false) goto L7;
        CommentServiceImpl$preloadBotCommentData$1 r102 = (CommentServiceImpl$preloadBotCommentData$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r111 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L17:
        com.larus.network.http.a r112 = (com.larus.network.http.a) r111;
        boolean r106 = r112 instanceof com.larus.network.http.y;
        if (r106 == false) goto L28;
        com.larus.network.http.y r107 = (com.larus.network.http.y) r112;
        Long r108 = r107.f360205g;
        if (r108 == null) goto L28;
        if (r108.longValue() != 0) goto L28;
        CommentHttpApi$GetCommentListData r109 = (CommentHttpApi$GetCommentListData) r107.f360135b;
        if (r109 == null) goto L34;
        return r109;
    L34:
        return new CommentHttpApi$GetCommentListData(0);
    L28:
        if ((r112 instanceof com.larus.network.http.f) == false) goto L30;
        FLogger r113 = FLogger.f375446a;
        StringBuilder r114 = new StringBuilder("preload failed error: ");
        com.larus.network.http.f r115 = (com.larus.network.http.f) r112;
        r114.append(r115.f360157d.getCode());
        r114.append(' ');
        r114.append(r115.f360157d.getMessage());
        r113.e("CommentServiceImpl", r114.toString());
        return null;
    L30:
        if (r106 == false) goto L36;
        FLogger r116 = FLogger.f375446a;
        StringBuilder r117 = new StringBuilder("preload failed error: ");
        com.larus.network.http.y r118 = (com.larus.network.http.y) r112;
        r117.append(r118.f360205g);
        r117.append(' ');
        r117.append(r118.f360204f);
        r116.e("CommentServiceImpl", r117.toString());
        return null;
    L36:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        r102.label = 1;
        r111 = r100.a(r101, null, null, r102);
        if (r111 != r104) goto L17;
        return r104;
    L7:
        r102 = new CommentServiceImpl$preloadBotCommentData$1(this, r110);
        goto L8
    }
}
