package com.larus.bmhome.interactionpanel;

import android.view.View;
import com.larus.nova.R;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 B2\u00060\u0001j\u0002`\u0002:\u0001BB\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000203H\u0016J\b\u00107\u001a\u000203H\u0002J\b\u00108\u001a\u000203H\u0002J\u0010\u00109\u001a\u0002032\u0006\u0010:\u001a\u00020*H\u0002J\u0010\u0010;\u001a\u0002032\u0006\u0010<\u001a\u00020=H\u0002J\b\u0010>\u001a\u000201H\u0002J\b\u0010?\u001a\u000203H\u0002J\b\u0010@\u001a\u000203H\u0002J\b\u0010A\u001a\u000203H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010-\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/larus/bmhome/interactionpanel/MainConversationInteractionPanelHostComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "manager", "Lcom/larus/bmhome/interactionpanel/IInteractionPanelQueueManager;", "<init>", "(Lcom/larus/bmhome/interactionpanel/IInteractionPanelQueueManager;)V", "contentViewId", "", "getContentViewId", "()I", "setContentViewId", "(I)V", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "clarificationAbility", "Lcom/larus/bmhome/clarification/IClarificationAbility;", "getClarificationAbility", "()Lcom/larus/bmhome/clarification/IClarificationAbility;", "inputAreaBlockAbility", "Lcom/larus/bmhome/inputarea/IInputAreaBlockAbility;", "getInputAreaBlockAbility", "()Lcom/larus/bmhome/inputarea/IInputAreaBlockAbility;", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "skillAbility", "Lcom/larus/bmhome/chat/component/skill/ISkillAbility;", "getSkillAbility", "()Lcom/larus/bmhome/chat/component/skill/ISkillAbility;", "renderer", "Lcom/larus/bmhome/interactionpanel/InteractionPanelRenderer;", "getRenderer", "()Lcom/larus/bmhome/interactionpanel/InteractionPanelRenderer;", "renderer$delegate", "Lkotlin/Lazy;", "observeJob", "Lkotlinx/coroutines/Job;", "currentConversationId", "", "currentEntry", "Lcom/larus/bmhome/interactionpanel/InteractionPanelEntry;", "conversationListener", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility$ChangeListener;", "Lcom/larus/im/bean/conversation/Conversation;", "bottomPcHintHiddenForPanel", "", "onViewCreated", "", "view", "Landroid/view/View;", "onFragmentViewDestroyed", "installConversationListener", "uninstallConversationListener", "bindConversationScope", "reason", "handleSnapshot", "snapshot", "Lcom/larus/bmhome/interactionpanel/InteractionPanelSnapshot;", "canShowHost", "temporaryHideBottomPcHintIfNeeded", "restoreBottomPcHintIfNeeded", "closeCotDetailFragmentIfNeeded", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MainConversationInteractionPanelHostComponent extends BaseContentWidget {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f312292u = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final g f312293m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f312294n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f312295o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Job f312296p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f312297q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public m f312298r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public d0 f312299s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f312300t;

    public static final class a {
    }

    static {
    }

    public MainConversationInteractionPanelHostComponent() {
        this(0);
    }

    public final u Y2() {
        return (u) this.f312295o.getValue();
    }

    public final void pC() {
        if (this.f312300t == true) goto L5;
        return;
    L5:
        be8.a r100 = (be8.a) s1a.d.a(this).getAbility(be8.a.class);
        if (r100 == null) goto L8;
        r100.pC();
    L8:
        this.f312300t = false;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void A2() {
        com.larus.bmhome.chat.component.cvs.y r100 = (com.larus.bmhome.chat.component.cvs.y) s1a.d.a(this).getAbility(com.larus.bmhome.chat.component.cvs.y.class);
        if (r100 == null) goto L5;
        r100.lQ(this.f312299s);
    L5:
        this.f312299s = null;
        Job r101 = this.f312296p;
        if (r101 == null) goto L8;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L8:
        this.f312296p = null;
        Y2().a(this.f312298r, "page_destroyed");
        pC();
        this.f312298r = null;
        this.f312297q = null;
    }

    public final void h3() {
        be8.a r100 = (be8.a) s1a.d.a(this).getAbility(be8.a.class);
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.qX() == false) goto L9;
        r100.aB();
        this.f312300t = true;
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseContentWidget
    public final int U2() {
        return this.f312294n;
    }

    public MainConversationInteractionPanelHostComponent(int r100) {
        g r101 = s.a();
        Intrinsics.checkNotNullParameter(r101, "manager");
        this.f312293m = r101;
        this.f312294n = R.id.chat_root;
        this.f312295o = LazyKt.lazy(new y(this));
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseContentWidget
    public final void X2(int r100) {
        this.f312294n = r100;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget
    public final void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r100, "view");
        if (this.f312299s != null) goto L9;
        d0 r101 = new d0(this);
        com.larus.bmhome.chat.component.cvs.y r102 = (com.larus.bmhome.chat.component.cvs.y) s1a.d.a(this).getAbility(com.larus.bmhome.chat.component.cvs.y.class);
        if (r102 == null) goto L8;
        com.larus.bmhome.chat.component.cvs.y.b.b(r102, r101);
    L8:
        this.f312299s = r101;
    L9:
        F2().post(new z(this, "onViewCreated"));
    }
}
