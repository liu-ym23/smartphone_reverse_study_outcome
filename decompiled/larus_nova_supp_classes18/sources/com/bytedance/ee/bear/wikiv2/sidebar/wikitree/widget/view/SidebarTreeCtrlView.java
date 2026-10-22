package com.bytedance.ee.bear.wikiv2.sidebar.wikitree.widget.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.more.more3.SpaceDocMoreProvider;
import com.bytedance.ee.bear.list.more.more3.SpaceMoreItemFactory;
import com.bytedance.ee.bear.list.more.more3.l;
import com.bytedance.ee.bear.more.protocol3.extension.BaseMoreProvider;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.bytedance.ee.bear.widgets.u;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiAction;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiSpaceMoreProvider;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeMoreProvider;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.c0;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.f1;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kq5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000«\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0007*\u0001I\u0018\u0000 N2\u00020\u0001:\u0001NB1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0014J\b\u0010(\u001a\u00020%H\u0016J8\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u0018\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0002J\u0010\u0010;\u001a\u00020%2\u0006\u0010<\u001a\u00020=H\u0016J\u0018\u0010>\u001a\u00020%2\u0006\u0010?\u001a\u00020\u001d2\b\b\u0002\u0010@\u001a\u00020:J\u0010\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020=H\u0016J\u0018\u0010C\u001a\u00020%2\u000e\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010F0EH\u0002J\b\u0010G\u001a\u00020%H\u0014J\b\u0010K\u001a\u00020%H\u0002J\b\u0010L\u001a\u00020%H\u0002J\b\u0010M\u001a\u00020%H\u0016R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u00020IX\u0082\u0004¢\u0006\u0004\n\u0002\u0010J¨\u0006O"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/sidebar/wikitree/widget/view/SidebarTreeCtrlView;", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "loadingViewFromXml", "Landroidx/appcompat/widget/AppCompatImageView;", "getLoadingViewFromXml", "()Landroidx/appcompat/widget/AppCompatImageView;", "setLoadingViewFromXml", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "account", "Lcom/bytedance/ee/bear/contract/AccountService$Account;", "kotlin.jvm.PlatformType", "skeleton", "Lcom/ethanhua/skeleton/ViewSkeletonScreen;", "wikiTreeEmptyView", "Lcom/bytedance/ee/bear/wikiv2/sidebar/wikitree/widget/view/SidebarWikiTreeEmptyView;", "getWikiTreeEmptyView", "()Lcom/bytedance/ee/bear/wikiv2/sidebar/wikitree/widget/view/SidebarWikiTreeEmptyView;", "setWikiTreeEmptyView", "(Lcom/bytedance/ee/bear/wikiv2/sidebar/wikitree/widget/view/SidebarWikiTreeEmptyView;)V", "currentEmptyState", "Lcom/bytedance/ee/bear/wikiv2/sidebar/wikitree/widget/view/SidebarEmptyState;", "getCurrentEmptyState", "()Lcom/bytedance/ee/bear/wikiv2/sidebar/wikitree/widget/view/SidebarEmptyState;", "setCurrentEmptyState", "(Lcom/bytedance/ee/bear/wikiv2/sidebar/wikitree/widget/view/SidebarEmptyState;)V", "skeletonRunnable", "Ljava/lang/Runnable;", "doInit", "", "initConfig", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlViewInitConfig;", "inflateLayout", "getMoreProvider", "Lcom/bytedance/ee/bear/more/protocol3/extension/BaseMoreProvider;", "wikiNode", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/TreeNode;", "node", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/UITreeNode;", "wikiPerm", "Lcom/bytedance/ee/bear/contract/route/parcelable/WikNodePerm;", "delegate", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiDialogs$ItemMoreViewDelegate;", "userComponentAbility", "Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "getSpaceMoreParam", "Lcom/bytedance/ee/bear/list/more/more3/ShowMoreV3Param;", "document", "Lcom/bytedance/ee/bear/list/dto/Document;", "isShared", "", "updateEmptyView", "result", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/Result;", "updateSidebarEmptyView", "state", "isDataFlow", "updateSidebarEmptyViewWithPush", "ok", "updatePersonalSidebarEmptyView", "spaceIdList", "", "", "scrollToCenterWhenInit", "attachListener", "com/bytedance/ee/bear/wikiv2/sidebar/wikitree/widget/view/SidebarTreeCtrlView$attachListener$1", "Lcom/bytedance/ee/bear/wikiv2/sidebar/wikitree/widget/view/SidebarTreeCtrlView$attachListener$1;", "showSkeletonAnim", "hideSkeletonAnim", "initEmptyView", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SidebarTreeCtrlView extends WikiTreeCtrlView {
    public static final /* synthetic */ int y = 0;
    public AppCompatImageView r;
    public final AccountService.Account s;
    public lt7.d t;
    public SidebarWikiTreeEmptyView u;
    public SidebarEmptyState v;
    public final d w;
    public final c x;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[WikiAction.values().length];
            r0[WikiAction.ADD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[WikiAction.PUSH_ADD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[WikiAction.PUSH_BATCH_ADD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[WikiAction.DEL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[WikiAction.PUSH_DEL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[WikiAction.MOV.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[WikiAction.PUSH_MOV.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[WikiAction.PUSH_BATCH_MOV.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            a = r0;
        }
    }

    public static final class c implements View.OnAttachStateChangeListener {
        public final /* synthetic */ SidebarTreeCtrlView a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
        }

        public c(SidebarTreeCtrlView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            AppCompatImageView r3 = this.a.getLoadingViewFromXml();
            if (r3 == null) goto L6;
            r3.removeCallbacks(this.a.w);
            return;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ SidebarTreeCtrlView a;

        public d(SidebarTreeCtrlView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            SidebarTreeCtrlView r0 = this.a;     // Catch: Throwable -> L4
            int r1 = SidebarTreeCtrlView.y;     // Catch: Throwable -> L4
            r0.t();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public SidebarTreeCtrlView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 0, 14);
    }

    public SidebarTreeCtrlView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 12);
    }

    public SidebarTreeCtrlView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, r4, 8);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView
    public final void j() {
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView
    public final void p() {
    }

    public final AppCompatImageView getLoadingViewFromXml() {
        AppCompatImageView r0 = this.r;
        if (r0 != null) goto L6;
        r0 = findViewById(2131379091);
        this.r = r0;
    L6:
        return r0;
    }

    public final void s() {
        lt7.d r0 = this.t;     // Catch: Exception -> L12
        if (r0 == null) goto L5;
        r0.a();     // Catch: Exception -> L12
    L5:
        AppCompatImageView r1 = getLoadingViewFromXml();     // Catch: Exception -> L12
        if (r1 == null) goto L8;
        r1.removeOnAttachStateChangeListener(this.x);     // Catch: Exception -> L12
    L8:
        AppCompatImageView r2 = getLoadingViewFromXml();     // Catch: Exception -> L12
        if (r2 == null) goto L17;
        r2.setVisibility(8);     // Catch: Exception -> L12
        return;
    L17:
        return;
    L12:
        e = move-exception;
        tt5.a.e("SidebarTreeCtrlView", "hideSkeletonAnim(): ", e, false);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView
    public final void h() {
        LayoutInflater.from(getContext()).inflate(2131564868, this);
        t();
    }

    public final void t() {
        AppCompatImageView r0 = getLoadingViewFromXml();
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        lt7.d.a r1 = u.a(getLoadingViewFromXml());
        r1.b = 2131564870;
        r1.a(2131100549);
        this.t = r1.b();
    }

    public final SidebarEmptyState getCurrentEmptyState() {
        return this.v;
    }

    public final SidebarWikiTreeEmptyView getWikiTreeEmptyView() {
        return this.u;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView
    public final void d(f1 r3) {
        Intrinsics.checkNotNullParameter(r3, "initConfig");
        r3.e.s = true;
        super.d(r3);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView
    public final void q(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h r4) {
        Intrinsics.checkNotNullParameter(r4, "result");
        if ((r4 instanceof com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.d) == false) goto L6;
        t();
        return;
    L6:
        if ((r4 instanceof com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g) == false) goto L25;
        s();
        if (getViewModel().isPersonalEmpty() == true) goto L10;
    L13:
        v(SidebarEmptyState.OK, true);
    L15:
        if (Intrinsics.areEqual(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.c(r4.b, 0), getViewModel().getRootToken()) == false) goto L29;
        WikiAction r5 = r4.a;
        if (r5 != WikiAction.COLLAPSE) goto L20;
        v(SidebarEmptyState.OK, false);
        return;
    L20:
        if (r5 != WikiAction.EXPAND) goto L31;
        SidebarEmptyState r6 = this.v;
        if (r6 == null) goto L32;
        v(r6, false);
        return;
    L32:
        return;
    L31:
        return;
    L29:
        return;
    L10:
        if (getViewModel().needShowMyLibrary() == false) goto L13;
        v(SidebarEmptyState.EMPTY, true);
        goto L15
    L25:
        if ((r4 instanceof com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.a) == false) goto L34;
        s();
        return;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView
    public final void r(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h r5) {
        Intrinsics.checkNotNullParameter(r5, "ok");
        Intrinsics.checkNotNullParameter(r5, "result");
        if ((r5 instanceof com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g) == true) goto L6;
        return;
    L6:
        switch(b.a[r5.a.ordinal()]) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            default: goto L27;
        };
    L8:
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g r6 = (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g) r5;
        u(CollectionsKt.listOf(new String[]{r6.f, r6.n}));
        return;
    L9:
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g r7 = (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g) r5;
        u(CollectionsKt.listOf(new String[]{r7.f, r7.n}));
        return;
    L10:
        u(CollectionsKt.listOf(((com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g) r5).n));
        WikiTreeCtrlView.d r8 = getViewDelegate();
        if (r8 == null) goto L21;
        r8.m(CollectionsKt.listOf(m.a));
        return;
    L21:
        return;
    L13:
        u(CollectionsKt.listOf(((com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g) r5).f));
        return;
    L14:
        u(CollectionsKt.listOf(((com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g) r5).f));
        return;
    L15:
        u(CollectionsKt.listOf(((com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g) r5).f));
        return;
    L16:
        u(CollectionsKt.listOf(((com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g) r5).f));
        return;
    L17:
        u(CollectionsKt.listOf(((com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g) r5).f));
        return;
    }

    public final void setCurrentEmptyState(SidebarEmptyState r1) {
        this.v = r1;
    }

    public final void setLoadingViewFromXml(AppCompatImageView r1) {
        this.r = r1;
    }

    public final void setWikiTreeEmptyView(SidebarWikiTreeEmptyView r1) {
        this.u = r1;
    }

    public final void u(List<String> r4) {
        Iterator<String> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        String r0 = r5.next();
        if (getViewModel().isSameSpace(r0) == false) goto L4;
        boolean r6 = true;
    L9:
        if (r6 == true) goto L11;
        return;
    L11:
        if (getViewModel().isPersonalEmpty() == true) goto L13;
        v(SidebarEmptyState.OK, true);
        return;
    L13:
        v(SidebarEmptyState.EMPTY, true);
        return;
    L8:
        r6 = false;
        goto L9
    }

    public final void v(SidebarEmptyState r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "state");
        tt5.a.h("SidebarTreeCtrlView", "updateSidebarEmptyView state is " + r7);
        if (r8 == false) goto L5;
        this.v = r7;
    L5:
        final SidebarWikiTreeEmptyView r9 = this.u;
        if (r9 == null) goto L53;
        ce5.a r1 = getUserComponentAbility();
        int r3 = 0;
        if (r1 == null) goto L16;
        BenefitManagerAPI r2 = r1.g;
        if (r2 == null) goto L16;
        BenefitStore r4 = r2.n1();
        if (r4 == null) goto L16;
        if (r4.hasBenefit("common_wiki_node_management") == true) goto L16;
        boolean r5 = true;
    L17:
        boolean r6 = !r5;
        Function1<Boolean, Unit> r10 = new SidebarTreeCtrlView$updateSidebarEmptyView$1$1(this, r9);
        Function0<Unit> r11 = new SidebarTreeCtrlView$updateSidebarEmptyView$1$2(this);
        Intrinsics.checkNotNullParameter(r7, "state");
        Intrinsics.checkNotNullParameter(r10, "listener");
        Intrinsics.checkNotNullParameter(r11, "addListener");
        r9.a = (LinearLayout) r9.findViewById(2131386423);
        r9.b = (LinearLayout) r9.findViewById(2131386424);
        int r12 = SidebarWikiTreeEmptyView.a.a[r7.ordinal()];
        if (r12 != 1) goto L20;
        r9.setVisibility(0);
        LinearLayout r13 = r9.a;
        if (r13 == null) goto L48;
        r13.setVisibility(8);
    L48:
        LinearLayout r14 = r9.b;
        if (r14 == null) goto L51;
        r14.setVisibility(0);
    L51:
        r10.invoke(Boolean.TRUE);
        return;
    L20:
        if (r12 != 2) goto L22;
        r9.setVisibility(0);
        LinearLayout r15 = r9.a;
        if (r15 == null) goto L28;
        r15.setVisibility(0);
    L28:
        LinearLayout r16 = r9.a;
        if (r16 == null) goto L36;
        Button r17 = (Button) r16.findViewById(2131371608);
        if (r17 == null) goto L36;
        if (r6 == true) goto L35;
        r3 = 8;
    L35:
        r17.setVisibility(r3);
    L36:
        LinearLayout r18 = r9.a;
        if (r18 == null) goto L41;
        Button r19 = (Button) r18.findViewById(2131371608);
        if (r19 == null) goto L41;
        r19.setOnClickListener(new j(r11));
    L41:
        LinearLayout r20 = r9.b;
        if (r20 == null) goto L44;
        r20.setVisibility(8);
    L44:
        r10.invoke(Boolean.TRUE);
        return;
    L22:
        if (r12 != 3) goto L56;
        r9.setVisibility(8);
        r10.invoke(Boolean.FALSE);
        return;
    L56:
        return;
    L16:
        r5 = false;
        goto L17
    }

    public SidebarTreeCtrlView(Context r3, AttributeSet r4, int r5, int r6) {
        SidebarWikiTreeEmptyView r1 = null;
        if ((r6 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r5 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5, 0);
        this.s = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        View r7 = LayoutInflater.from(r3).inflate(2131564869, null);
        if ((r7 instanceof SidebarWikiTreeEmptyView) == false) goto L11;
        r1 = (SidebarWikiTreeEmptyView) r7;
    L11:
        this.u = r1;
        this.w = new d(this);
        this.x = new c(this);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView
    public final BaseMoreProvider f(TreeNode r18, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r19, WikNodePerm r20, c0 r21, ce5.a r22) {
        Intrinsics.checkNotNullParameter(r19, "node");
        Intrinsics.checkNotNullParameter(r20, "wikiPerm");
        if (r18 != null) goto L5;
        return null;
    L5:
        SpaceInfo r3 = getViewModel().getSpaceInfo();
        if (r3 != null) goto L8;
        return null;
    L8:
        int r4 = r18.wiki_node_type;
        boolean r8 = true;
        if (r4 != (-8)) goto L11;
        Document r10 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.top.c.b(r18);
        if (TextUtils.equals("wikiroot%title_root_share_token", com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.c(r19.n, 0)) == false) goto L44;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r0 = getViewModel();
        if (r0 != null) goto L39;
    L41:
        boolean r1 = false;
    L42:
        if (r1 == false) goto L44;
    L45:
        Fragment r9 = getViewLifecycleOwner();
        AccountService.Account r11 = this.s;
        if (r8 == false) goto L48;
        String r5 = "SharedView";
    L49:
        com.bytedance.ee.bear.list.more.more3.m r2 = new com.bytedance.ee.bear.list.more.more3.m(r9, r10, r11, "quick_access", "none", true, null, r5);
        if (r22 == null) goto L56;
        SpaceMoreItemFactory r6 = new SpaceMoreItemFactory(r2, r22);
        Document r7 = r2.b;
        String r12 = r2.i;
        if (sbb.g.b(r18.obj_type) == false) goto L55;
        return new l(r7, r12, r6);
    L55:
        return new SpaceDocMoreProvider(r7, r12, r6);
    L56:
        return null;
    L48:
        r5 = "PinView";
        goto L49
    L39:
        if (r0.isSidebarShared(r18.wiki_token) != true) goto L41;
        r1 = true;
    L44:
        r8 = false;
        goto L45
    L11:
        if (r4 == (-7)) goto L25;
        SpaceInfo r13 = r3.clone();
        if (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.c.a(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.c(r19.n, 0)) == false) goto L22;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r14 = getViewModel();
        if (r14 != null) goto L17;
    L19:
        boolean r15 = false;
    L20:
        if (r15 == false) goto L22;
        boolean r16 = true;
    L23:
        WikiTreeMoreProvider r17 = new WikiTreeMoreProvider(r18, r20, r13, r16, r22);
        r17.r = r21;
        return r17;
    L17:
        if (r14.isCloudPinDocument(r18.wiki_token) != true) goto L19;
        r15 = true;
    L22:
        r16 = false;
        goto L23
    L25:
        Context r23 = getContext();
        if (r22 == null) goto L28;
        NetService r24 = r22.c;
    L29:
        if (r22 == null) goto L31;
        BenefitManagerAPI r25 = r22.g;
    L33:
        return new WikiSpaceMoreProvider(r23, r24, r25, (com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6), r18);
    L31:
        r25 = null;
        goto L33
    L28:
        r24 = null;
        goto L29
    }
}
