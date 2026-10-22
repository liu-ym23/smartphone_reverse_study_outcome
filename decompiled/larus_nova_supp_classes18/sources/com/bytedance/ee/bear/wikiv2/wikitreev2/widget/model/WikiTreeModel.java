package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import android.app.Application;
import android.text.TextUtils;
import android.util.Pair;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.offline.OfflineRenameData;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.wikitreev2.NonStickyMutableLiveData;
import com.bytedance.ee.bear.wikiv2.wikitreev2.WikiTreeObserver;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.DelNodePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.DelSingleNodePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.FavoritePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetBatchNodePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetChildPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetMoveNodeAuthorizedUserInfoPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetNodePermPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetNodePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetRelationPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetRootPermPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.MoveNodePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.MoveToSpacePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.MoveToSpaceStatusPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.PinPuller$Params;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.PinPuller$Result;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.UnPinPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.UnfavoritePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpacePerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceUserPerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.VirtualNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiHomePageV2;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationInsert;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.AddV3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.BatchAddV3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.BatchMovV3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.DelAndMovUpV3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.DelV3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.DesV3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.LocalPush;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.MovV3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.PinAddV1;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.PinDeleteV1;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.PinMoveV1;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.ReaV3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.SpacePinAddV1;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.SpacePinDelV1;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.SpacePinMoveV1;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.UdeNodePermV3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.UdeV3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONException;
import org.json.JSONObject;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class WikiTreeModel extends ViewModel implements b, cr5.d.a, LocalPush.b {
    private final cr5.a chainPushManager;
    private Function<TreeNode, Boolean> dataFilter;
    protected final CompositeDisposable disposables;
    private List<Function<TreeNode, Boolean>> enableCheckers;
    private List<Function<TreeNode, Boolean>> enableSwipeCheckers;
    boolean favoriteEnable;
    private String focusToken;
    private String focusUid;
    boolean isSidebarEnable;
    boolean isSidebarSynergyEnable;
    boolean isWikiSupportSharedEnable;
    private final AtomicLong loadSequence;
    private LocalPush localPush;
    private boolean localPushEnable;
    private boolean localPushFocusTokenDisable;
    public final String mHashCode;
    public String mTAG;
    private boolean needExpandAfterInit;
    public NetService netService;
    private List<Function<j, Boolean>> singleNodeFilters;
    protected String tagSuffix;
    public ce5.a userComponentAbility;
    private WikiTreeCtrlView.c viewConfig;
    private final MutableLiveData<h> wikiList;
    volatile e3 workspace;

    public class a implements Function1<Boolean, Unit> {
        public final /* synthetic */ TreeNode a;
        public final /* synthetic */ WikiTreeModel b;

        public final Object invoke(Object r2) {
            Boolean r3 = (Boolean) r2;
            t1.l(this.b, this.a.parent_wiki_token);
            return null;
        }

        public a(WikiTreeModel r1, TreeNode r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public static /* synthetic */ void Ap(WikiTreeModel r0, String r1, String r2, TreeNode r3, String r4) {
        r0.lambda$deleteCurrentOnly$17(r1, r2, r3, r4);
    }

    public static /* synthetic */ void Bp(WikiTreeModel r0, boolean r1, long r2, WikiAction r4, AtomicReference r5, Throwable r6) {
        r0.lambda$loadInternal$2(r1, r2, r4, r5, r6);
    }

    public static /* synthetic */ void Cp(WikiTreeModel r0, wwc.c r1) {
        r0.lambda$unfavorite$30(r1);
    }

    public static /* synthetic */ void Dp(WikiTreeModel r0, String r1, String r2, Boolean r3) {
        r0.lambda$rename$45(r1, r2, r3);
    }

    public static /* synthetic */ void Fp(WikiTreeModel r0, Throwable r1) {
        r0.lambda$unfavorite$32(r1);
    }

    public static /* synthetic */ void Gp(WikiTreeModel r0, String r1, String r2, TreeNode r3, Throwable r4) {
        r0.lambda$deleteCurrentOnly$18(r1, r2, r3, r4);
    }

    public static /* synthetic */ WikNodePerm Hp(WikiTreeModel r0, TreeNode r1, WikNodePerm r2) {
        return r0.lambda$requestNodePerm$47(r1, r2);
    }

    public static /* synthetic */ void Ip(WikiTreeModel r0, UnPinPuller.Result r1) {
        r0.lambda$unPin$37(r1);
    }

    public static /* synthetic */ void Jp(WikiTreeModel r0, PinPuller$Result r1) {
        r0.lambda$pin$34(r1);
    }

    public static /* synthetic */ void Kp(WikiTreeModel r0, int r1, Throwable r2) {
        r0.lambda$moveTo$24(r1, r2);
    }

    public static /* synthetic */ void Lp(WikiTreeModel r0, TreeNode r1, IOperationInsert.TreeNodeInsertParams r2, String r3) {
        r0.lambda$insert$14(r1, r2, r3);
    }

    public static /* synthetic */ void Mo(WikiTreeModel r0, String r1, TreeNode r2) {
        r0.lambda$makeCopyTo$43(r1, r2);
    }

    public static /* synthetic */ void Mp(WikiTreeModel r0, Throwable r1) {
        r0.lambda$favorite$28(r1);
    }

    public static /* synthetic */ void No(WikiTreeModel r0, wwc.c r1) {
        r0.lambda$deleteCurrentOnly$16(r1);
    }

    public static /* synthetic */ void Np(WikiTreeModel r0, Throwable r1) {
        r0.lambda$shortcutTo$41(r1);
    }

    public static /* synthetic */ TreeNode Oo(WikiTreeModel r0, String r1, TreeNode r2) {
        return r0.lambda$makeCopyTo$42(r1, r2);
    }

    public static /* synthetic */ void Op(WikiTreeModel r0, boolean r1, long r2, AtomicReference r4, AtomicReference r5, boolean r6, WikiAction r7, AtomicReference r8, ar5.b r9) {
        r0.lambda$loadInternal$1(r1, r2, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ Boolean Po(WikiTreeModel r0, String r1, Boolean r2) {
        return r0.lambda$favorite$25(r1, r2);
    }

    public static /* synthetic */ TreeNode Pp(WikiTreeModel r0, String r1, TreeNode r2) {
        return r0.lambda$shortcutTo$39(r1, r2);
    }

    public static /* synthetic */ void Qo(WikiTreeModel r0, Throwable r1) {
        r0.lambda$pin$35(r1);
    }

    public static /* synthetic */ void Qp(WikiTreeModel r0, String r1) {
        r0.lambda$expandSpace$8(r1);
    }

    public static /* synthetic */ void Rp(WikiTreeModel r0, String r1, Boolean r2) {
        r0.lambda$favorite$27(r1, r2);
    }

    public static /* synthetic */ void So(WikiTreeModel r0, Throwable r1) {
        r0.lambda$unPin$38(r1);
    }

    public static /* synthetic */ void Sp(WikiTreeModel r0, String r1, String r2, TreeNode r3, Throwable r4) {
        r0.lambda$delete$21(r1, r2, r3, r4);
    }

    public static /* synthetic */ void To(WikiTreeModel r0, String r1, String r2, TreeNode r3, String r4) {
        r0.lambda$delete$20(r1, r2, r3, r4);
    }

    public static /* synthetic */ void Up(WikiTreeModel r0, String r1, wwc.c r2) {
        r0.lambda$expand$5(r1, r2);
    }

    public static /* synthetic */ void Vp(WikiTreeModel r0, String r1, AtomicReference r2, Boolean r3) {
        r0.lambda$expand$6(r1, r2, r3);
    }

    public static /* synthetic */ void Wo(WikiTreeModel r0, WikiAction r1, wwc.c r2) {
        r0.lambda$loadInternal$0(r1, r2);
    }

    public static /* synthetic */ Boolean Wp(WikiTreeModel r0, String r1, List r2) {
        return r0.lambda$removeFromWiki$49(r1, r2);
    }

    public static /* synthetic */ Publisher Yo(TreeNode r0, Throwable r1) {
        return lambda$requestNodePerm$48(r0, r1);
    }

    public static /* synthetic */ void Zo(WikiTreeModel r0, wwc.c r1) {
        r0.lambda$delete$19(r1);
    }

    public static /* synthetic */ void ap(WikiTreeModel r0, String r1, wwc.c r2) {
        r0.lambda$expandSpace$10(r1, r2);
    }

    public static /* synthetic */ PinPuller$Result bp(String r0, String r1, PinPuller$Result r2) {
        return lambda$pin$33(r0, r1, r2);
    }

    public static /* synthetic */ void cp(WikiTreeModel r0, AtomicReference r1, String r2, Throwable r3) {
        r0.lambda$expand$7(r1, r2, r3);
    }

    public static /* synthetic */ void dp(WikiTreeModel r0, String r1, String r2, boolean r3, int r4, Boolean r5) {
        r0.lambda$moveTo$23(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Publisher ep(WikiTreeModel r0, String r1, Boolean r2) {
        return r0.lambda$expand$4(r1, r2);
    }

    public static /* synthetic */ void hp(WikiTreeModel r0, Throwable r1) {
        r0.lambda$rename$46(r1);
    }

    public static /* synthetic */ void ip(WikiTreeModel r0, Throwable r1) {
        r0.lambda$insert$15(r1);
    }

    public static /* synthetic */ void kp(WikiTreeModel r0, TreeNode r1, Boolean r2) {
        r0.lambda$removeFromWiki$50(r1, r2);
    }

    public static /* synthetic */ UnPinPuller.Result lp(String r0, String r1, UnPinPuller.Result r2) {
        return lambda$unPin$36(r0, r1, r2);
    }

    public static /* synthetic */ void np(WikiTreeModel r0, AtomicReference r1, String r2, Throwable r3) {
        r0.lambda$expandSpace$12(r1, r2, r3);
    }

    public static /* synthetic */ void pp(WikiTreeModel r0, int r1, wwc.c r2) {
        r0.lambda$moveTo$22(r1, r2);
    }

    public static /* synthetic */ void rp(WikiTreeModel r0, String r1, TreeNode r2) {
        r0.lambda$shortcutTo$40(r1, r2);
    }

    public static /* synthetic */ void sp(WikiTreeModel r0, String r1, Boolean r2) {
        r0.lambda$unfavorite$31(r1, r2);
    }

    public static /* synthetic */ void tp(WikiTreeModel r0, Throwable r1) {
        r0.lambda$makeCopyTo$44(r1);
    }

    public static /* synthetic */ Boolean up(WikiTreeModel r0, String r1, Boolean r2) {
        return r0.lambda$unfavorite$29(r1, r2);
    }

    public static /* synthetic */ void vp(WikiTreeModel r0, String r1) {
        r0.lambda$expand$3(r1);
    }

    public static /* synthetic */ void wp(WikiTreeModel r0, wwc.c r1) {
        r0.lambda$favorite$26(r1);
    }

    public static /* synthetic */ Publisher xp(WikiTreeModel r0, String r1, Boolean r2) {
        return r0.lambda$expandSpace$9(r1, r2);
    }

    public static /* synthetic */ void yo(WikiTreeModel r0, String r1, AtomicReference r2, Boolean r3) {
        r0.lambda$expandSpace$11(r1, r2, r3);
    }

    public static /* synthetic */ void yp(WikiTreeModel r0, Throwable r1) {
        r0.lambda$removeFromWiki$51(r1);
    }

    public static /* synthetic */ void zp(WikiTreeModel r0, wwc.c r1) {
        r0.lambda$insert$13(r1);
    }

    private d3 provideUiList() {
        int r0 = v2.a;
        return v2.a.a(this);
    }

    private void registerPush() {
        registerChainPush(i.a(this.workspace));
        registerLocalPush();
    }

    private void reloadTitleCloud() {
        ArrayList<String> r0 = new AnonymousClass2(this);
        if (this.isSidebarEnable == true) goto L5;
        return;
    L5:
        if (this.viewConfig.s == false) goto L9;
        reload(r0);
        return;
    }

    private void reloadTitleSpace() {
        ArrayList<String> r0 = new AnonymousClass3(this);
        if (this.isSidebarEnable == true) goto L5;
        return;
    L5:
        if (this.viewConfig.s == true) goto L7;
        return;
    L7:
        if (this.isSidebarSynergyEnable == false) goto L12;
        reload(r0);
        return;
    }

    private void unRegisterPush() {
        unRegisterChainPush(i.a(this.workspace));
        unRegisterLocalPush();
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public boolean canShowAi() {
        SpaceInfo r0 = this.workspace.j;
        SpacePerm r1 = this.workspace.l;
        if (r0 == null) goto L12;
        if (r1 == null) goto L12;
        boolean r2 = r0.isDocsLib();
        boolean r3 = r1.canManageSpace;
        boolean r4 = r1.isWikiMember;
        tt5.a.h(this.mTAG, "canShowAi: docsLib=" + r2 + ", canManageSpace=" + r3 + ", isWikiMember=" + r4);
        if (r2 == true) goto L14;
        if (r3 == true) goto L10;
        if (r4 == true) goto L10;
        return false;
    L10:
        return true;
    L14:
        return false;
    L12:
        tt5.a.k(this.mTAG, "canShowAi: spaceInfo == null || spacePerm == null");
        return false;
    }

    public void clears() {
        tt5.a.h(this.mTAG, "clears");
        onCleared();
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public e3 cloneWorkspace() {
        if (this.workspace.w() == false) goto L9;
        e3 r1 = this.workspace;
        ce5.a r2 = this.userComponentAbility;
        r1.getClass();
        ConcurrentHashMap r3 = new ConcurrentHashMap();
        Iterator r4 = ((ConcurrentHashMap) r1.h).entrySet().iterator();
    L6:
        if (r4.hasNext() == false) goto L12;
        Map.Entry r5 = (Map.Entry) r4.next();
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r6 = ((com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a) r5.getValue()).a();
        r6.d = false;
        r6.e = 0;
        r3.put((String) r5.getKey(), r6);
        goto L6
    L12:
        return new e3(new f3(r1.b, r1.a, r1.c, r1.d, r1.e, r1.c(), r1.b(), r1.j.clone(), r1.k.clone(), r1.l.clone(), r1.p, r1.e(), r1.d()), r2);
    L9:
        return null;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public String getFocusToken() {
        if (this.workspace.x(this.focusToken) == true) goto L5;
        this.focusToken = "";
    L5:
        String r0 = this.focusToken;
        if (r0 != null) goto L8;
        return "";
    L8:
        return r0;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public String getRootToken() {
        e3 r0 = this.workspace;
        if (TextUtils.isEmpty(r0.b) == false) goto L7;
        return "";
    L7:
        return r0.b;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public String getRootUid() {
        e3 r0 = this.workspace;
        if (TextUtils.isEmpty(r0.b) == true) goto L6;
        String r1 = r0.b;
        return com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.a(r1, r1, 0, "");
    L6:
        return "";
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public SpaceInfo getSpaceInfo() {
        return this.workspace.j;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public SpacePerm getSpacePerm() {
        return this.workspace.l;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public SpaceUserPerm getSpaceUserPerm() {
        return this.workspace.k;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public boolean isEmpty() {
        e3 r0 = this.workspace;
        if (hu5.a.e(r0.g) == false) goto L5;
    L10:
        return true;
    L5:
        if (hu5.a.e(r0.f) == true) goto L10;
        if (hu5.a.d(r0.f.get(r0.b)) == true) goto L10;
        return false;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public boolean isPersonalEmpty() {
        e3 r0 = this.workspace;
        Map<String, List<String>> r1 = r0.f;
        ConcurrentHashMap r2 = (ConcurrentHashMap) r1;
        return hu5.a.d((List) r2.get(r0.b));
    }

    public boolean isPersonalError() {
        e3 r0 = this.workspace;
        r0.getClass();
        return TextUtils.equals(VirtualNode.TITLE_ROOT_PERSONAL.getRootToken(), r0.b);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public boolean needShowMyLibrary() {
        return this.workspace.q.hasBenefit("ccm_my_doc_library_entrance");
    }

    public void onCleared() {
        tt5.a.h(this.mTAG, "onCleared. ");
        unRegisterPush();
        cr5.a r0 = this.chainPushManager;
        tt5.a.h(r0.a, "cleanAllChainPush");
        Iterator<T> r1 = r0.c.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        cr5.d r2 = (cr5.d) r1.next();
        if (r2 == null) goto L4;
        r2.a();
        goto L4
    L8:
        r0.c.clear();
        CompositeDisposable r3 = this.disposables;
        if (r3 == null) goto L12;
        r3.clear();
    L12:
        if (this.workspace == null) goto L20;
        e3 r4 = this.workspace;
        r4.j = null;
        r4.a = "";
        r4.b = "";
        ((ConcurrentHashMap) r4.f).clear();
        ((ConcurrentHashMap) r4.g).clear();
        this.workspace = e3.r;
        return;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void refresh() {
        if (this.workspace.w() == true) goto L5;
        return;
    L5:
        tt5.a.h(this.mTAG, "WikiTreeModel.refresh. ");
        g r0 = h.c(WikiAction.REFRESH, provideUiList());
        this.wikiList.setValue(r0);
    }

    public void registerLocalPush() {
        if (this.localPushEnable == true) goto L6;
        tt5.a.h(this.mTAG, "WikiTreeModel.registerLocalPush. localPushEnable=false");
        return;
    L6:
        boolean r0 = this.workspace.w();
        String r1 = this.mTAG;
        StringBuilder r2 = new StringBuilder("WikiTreeModel.registerLocalPush. valid=");
        r2.append(r0);
        r2.append(", localPush=");
        if (this.localPush != null) goto L9;
        boolean r3 = true;
    L10:
        r2.append(r3);
        tt5.a.h(r1, r2.toString());
        if (r0 == true) goto L13;
        return;
    L13:
        if (this.localPush != null) goto L17;
        LocalPush r4 = new LocalPush(this);
        this.localPush = r4;
        tt5.a.h("Wiki_LocalPush", "LocalPush attach. ");
        WikiTreeObserver.a.a(r4.b);
        WikiTreeObserver.e.a(r4.c);
        WikiTreeObserver.f.a(r4.d);
        WikiTreeObserver.b.a(r4.e);
        WikiTreeObserver.d.a(r4.f);
        WikiTreeObserver.b().a(r4.g);
        WikiTreeObserver.a().a(r4.h);
        WikiTreeObserver.c.a(r4.i);
        ((NonStickyMutableLiveData) WikiTreeObserver.j.getValue()).a(r4.j);
        return;
    L17:
        return;
    L9:
        r3 = false;
        goto L10
    }

    public void unRegisterLocalPush() {
        String r0 = this.mTAG;
        StringBuilder r1 = new StringBuilder("WikiTreeModel.unRegisterLocalPush. localPush=");
        if (this.localPush != null) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        tt5.a.h(r0, r1.toString());
        LocalPush r3 = this.localPush;
        if (r3 == null) goto L10;
        tt5.a.h("Wiki_LocalPush", "LocalPush detach. ");
        WikiTreeObserver.a.d(r3.b);
        WikiTreeObserver.e.d(r3.c);
        WikiTreeObserver.f.d(r3.d);
        WikiTreeObserver.b.d(r3.e);
        WikiTreeObserver.d.d(r3.f);
        WikiTreeObserver.b().d(r3.g);
        WikiTreeObserver.a().d(r3.h);
        WikiTreeObserver.c.d(r3.i);
        ((NonStickyMutableLiveData) WikiTreeObserver.j.getValue()).d(r3.j);
        this.localPush = null;
        return;
    L10:
        return;
    L5:
        r2 = false;
        goto L6
    }

    public WikiTreeModel() {
        String r0 = Integer.toHexString(hashCode());
        this.mHashCode = r0;
        this.mTAG = "Wiki_WikiTreeModel#" + r0;
        this.tagSuffix = "";
        this.wikiList = new MutableLiveData();
        this.workspace = e3.r;
        this.chainPushManager = new cr5.a();
        this.favoriteEnable = true;
        this.isSidebarEnable = false;
        this.isSidebarSynergyEnable = false;
        this.isWikiSupportSharedEnable = false;
        this.disposables = new CompositeDisposable();
        this.focusToken = "";
        this.viewConfig = new WikiTreeCtrlView.c();
        this.loadSequence = new AtomicLong();
        this.needExpandAfterInit = true;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public String getFocusUid() {
        String r0 = getFocusToken();
        if (TextUtils.isEmpty(r0) == false) goto L6;
        this.focusUid = "";
    L8:
        String r1 = this.focusUid;
        if (r1 != null) goto L11;
        return "";
    L11:
        return r1;
    L6:
        if (TextUtils.isEmpty(this.focusUid) == false) goto L8;
        this.focusUid = this.workspace.l(r0);
        goto L8
    }

    public WikiTreeCtrlView.c getViewConfig() {
        return this.viewConfig;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public MutableLiveData<h> getWikiUIList() {
        return this.wikiList;
    }

    private static Flowable<Boolean> fromCallable(Runnable r0) {
        if (r0 == null) goto L5;
        r0.run();
    L5:
        return Flowable.just(Boolean.TRUE);
    }

    private /* synthetic */ void lambda$delete$19(wwc.c r2) throws Exception {
        this.wikiList.setValue(h.b(WikiAction.DEL));
    }

    private /* synthetic */ void lambda$deleteCurrentOnly$16(wwc.c r2) throws Exception {
        this.wikiList.setValue(h.b(WikiAction.DEL));
    }

    private /* synthetic */ void lambda$expand$3(String r2) {
        this.workspace.C(r2);
    }

    private /* synthetic */ void lambda$expandSpace$8(String r2) {
        this.workspace.C(r2);
    }

    private /* synthetic */ void lambda$favorite$26(wwc.c r2) throws Exception {
        this.wikiList.setValue(h.b(WikiAction.FAVORITE));
    }

    private void lambda$favorite$28(Throwable r4) throws Exception {
        tt5.a.e(this.mTAG, "WikiTreeModel.favorite, favorite fail. ", r4, false);
        this.wikiList.setValue(h.a(WikiAction.FAVORITE, r4));
    }

    private /* synthetic */ void lambda$insert$13(wwc.c r2) throws Exception {
        this.wikiList.setValue(h.b(WikiAction.ADD));
    }

    private void lambda$insert$15(Throwable r4) throws Exception {
        tt5.a.e(this.mTAG, "WikiTreeModel.insert, insert fail. ", r4, false);
        if (((com.bytedance.ee.bear.quoto.t) org.koin.java.a.a(com.bytedance.ee.bear.quoto.t.class)).a(r4, null) == false) goto L5;
    L9:
        MutableLiveData<h> r5 = this.wikiList;
        WikiAction r0 = WikiAction.UNKNOWN;
        int r2 = h.c;
        r5.setValue(h.a.c(r0, null));
        return;
    L5:
        if (((com.bytedance.ee.bear.quoto.t) org.koin.java.a.a(com.bytedance.ee.bear.quoto.t.class)).p(r4, null, false) == true) goto L9;
        MutableLiveData<h> r1 = this.wikiList;
        WikiAction r3 = WikiAction.ADD;
        int r6 = h.c;
        r1.setValue(h.a.a(r3, r4));
    }

    private void lambda$makeCopyTo$44(Throwable r4) throws Exception {
        tt5.a.e(this.mTAG, "WikiTreeModel.makeCopyTo, addNode fail. ", r4, false);
    }

    private /* synthetic */ void lambda$pin$34(PinPuller$Result r4) throws Exception {
        tt5.a.h(this.mTAG, "WikiTreeModel.pin, pin success");
        Application r5 = eu5.b.a;
        String r0 = xo5.a.c(r5, 2131889648, "SidebarSection", r5.getString(2131889647));
        if (this.isSidebarEnable == false) goto L5;
        Toast.showSuccessText(r5, r0, 0);
        return;
    L5:
        Toast.showSuccessText(r5, r5.getString(2131887877), 0);
    }

    private void lambda$pin$35(Throwable r4) throws Exception {
        tt5.a.e(this.mTAG, "WikiTreeModel.pin, pin fail. ", r4, false);
        Application r0 = eu5.b.a;
        if ((r4 instanceof NetService.ServerErrorException) == true) goto L5;
    L8:
        Toast.showFailureText(r0, r0.getString(2131887874), 0);
        return;
    L5:
        if (((NetService.ServerErrorException) r4).getCode() != 4001) goto L8;
        Toast.showFailureText(r0, r0.getString(2131887875), 0);
    }

    private void lambda$removeFromWiki$51(Throwable r4) throws Exception {
        tt5.a.e(this.mTAG, "WikiTreeModel.removeFromWiki, removeFromWiki fail. ", r4, false);
    }

    private void lambda$rename$46(Throwable r4) throws Exception {
        tt5.a.e(this.mTAG, "WikiTreeModel.rename, rename fail. ", r4, false);
        this.wikiList.setValue(h.a(WikiAction.RENAME, r4));
    }

    private void lambda$shortcutTo$41(Throwable r4) throws Exception {
        tt5.a.e(this.mTAG, "WikiTreeModel.shortcutTo, addNode fail. ", r4, false);
    }

    private /* synthetic */ void lambda$unPin$37(UnPinPuller.Result r4) throws Exception {
        tt5.a.h(this.mTAG, "WikiTreeModel.unPin, unPin success");
        Application r5 = eu5.b.a;
        String r0 = xo5.a.c(r5, 2131889644, "SidebarSection", r5.getString(2131889647));
        if (this.isSidebarEnable == false) goto L5;
        Toast.showSuccessText(r5, r0, 0);
        return;
    L5:
        Toast.showSuccessText(r5, r5.getString(2131887960), 0);
    }

    private void lambda$unPin$38(Throwable r4) throws Exception {
        tt5.a.e(this.mTAG, "WikiTreeModel.unPin, unPin fail. ", r4, false);
        Application r5 = eu5.b.a;
        Toast.showFailureText(r5, r5.getString(2131887959), 0);
    }

    private /* synthetic */ void lambda$unfavorite$30(wwc.c r2) throws Exception {
        this.wikiList.setValue(h.b(WikiAction.UNFAVORITE));
    }

    private void lambda$unfavorite$32(Throwable r4) throws Exception {
        tt5.a.e(this.mTAG, "WikiTreeModel.unfavorite, unfavorite fail. ", r4, false);
        this.wikiList.setValue(h.a(WikiAction.UNFAVORITE, r4));
    }

    private Pair<List<TreeNode>, Throwable> reverseGetBatchNode(List<String> r6) {
        List r0 = null;
        r0 = (List) new GetBatchNodePuller(this.netService).d(new GetBatchNodePuller.Params(r6)).blockingSingle();     // Catch: Exception -> L5
        e = null;
    L8:
        return new Pair(r0, e);
    L5:
        e = e;
        tt5.a.e(this.mTAG, "WikiTreeModel.reverseGetNode, pull node fail. ", e, false);
        goto L8
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void collapse(String r7) {
        String r1 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.c(r7, 1);
        tt5.a.h(this.mTAG, String.format("WikiTreeModel.collapse, wikiToken: %s, uid: %s", new Object[]{yu5.c.j(r1), yu5.c.j(r7)}));
        if (this.workspace.x(r1) == true) goto L6;
        tt5.a.k(this.mTAG, "WikiTreeModel.collapse, node not found. ");
        return;
    L6:
        e3 r0 = this.workspace;
        if (r0.y(r7) == false) goto L9;
        ((com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a) ((ConcurrentHashMap) r0.h).get(r7)).d = false;
    L9:
        WikiAction r2 = WikiAction.COLLAPSE;
        d3 r3 = provideUiList();
        int r4 = h.c;
        g r5 = h.a.c(r2, r3);
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r5.b = r7;
        this.wikiList.setValue(r5);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void collapseSpace(String r7) {
        String r1 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.c(r7, 1);
        tt5.a.h(this.mTAG, String.format("WikiTreeModel.collapseSpace, wikiToken: %s, uid: %s", new Object[]{yu5.c.j(r1), yu5.c.j(r7)}));
        if (this.workspace.x(r1) == true) goto L6;
        tt5.a.k(this.mTAG, "WikiTreeModel.collapseSpace, node not found. ");
        return;
    L6:
        e3 r0 = this.workspace;
        if (r0.y(r7) == false) goto L9;
        ((com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a) ((ConcurrentHashMap) r0.h).get(r7)).d = false;
    L9:
        MutableLiveData<h> r8 = this.wikiList;
        WikiAction r2 = WikiAction.COLLAPSE;
        d3 r3 = provideUiList();
        int r4 = h.c;
        r8.setValue(h.a.c(r2, r3));
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void expand(final String r9) {
        String r1 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.c(r9, 1);
        tt5.a.h(this.mTAG, String.format("WikiTreeModel.expand, wikiToken: %s, uid: %s", new Object[]{yu5.c.j(r1), yu5.c.j(r9)}));
        if (this.workspace.x(r1) == true) goto L6;
        tt5.a.k(this.mTAG, "WikiTreeModel.expand, node not found. ");
        return;
    L6:
        final AtomicReference r0 = new AtomicReference(Boolean.FALSE);
        CompositeDisposable r2 = this.disposables;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r1, WikiFolderPushPlugin.WIKI_TOKEN);
        if (TextUtils.equals(r1, this.workspace.a) == false) goto L9;
        Flowable r3 = Flowable.just(Boolean.TRUE);
    L13:
        r2.add(r3.flatMap(new r(this, r9)).observeOn(fo5.d.d()).doOnSubscribe(new c0(this, r9)).subscribe(new n0(this, r9, r0), new y0(this, r0, r9)));
        return;
    L9:
        TreeNode r4 = this.workspace.m(r1);
        final String r5 = r4.getOriginToken();
        String r6 = r4.getOriginSpaceId();
        if (this.workspace.v(r5) == false) goto L12;
        r3 = Flowable.just(Boolean.TRUE);
        goto L13
    L12:
        Function2<List<? extends TreeNode>, Boolean, Boolean> r7 = new WikiTreeRepositoryKt$requestChildren$insertChildrenFun$1(this, r5);
        Intrinsics.checkNotNull(r4);
        r3 = Flowable.zip(t1.h(this, r4), com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.l0.a(this.netService).a(new GetChildPuller.Params(r6, r5)), new b2(this, r7)).map(new a2(this, r5));
        goto L13
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void expandSpace(final String r11) {
        String r1 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.c(r11, 1);
        tt5.a.h(this.mTAG, String.format("WikiTreeModel.expandSpace, wikiToken: %s, uid: %s", new Object[]{yu5.c.j(r1), yu5.c.j(r11)}));
        if (this.workspace.x(r1) == true) goto L6;
        tt5.a.k(this.mTAG, "WikiTreeModel.expandSpace, node not found. ");
        return;
    L6:
        final AtomicReference r0 = new AtomicReference(Boolean.FALSE);
        CompositeDisposable r2 = this.disposables;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r1, WikiFolderPushPlugin.WIKI_TOKEN);
        if (TextUtils.equals(r1, this.workspace.a) == false) goto L9;
        Flowable r3 = Flowable.just(Boolean.TRUE);
    L13:
        r2.add(r3.flatMap(new z(this, r11)).observeOn(fo5.d.d()).doOnSubscribe(new a0(this, r11)).subscribe(new b0(this, r11, r0), new d0(this, r0, r11)));
        return;
    L9:
        TreeNode r4 = this.workspace.m(r1);
        final String r5 = r4.getOriginToken();
        String r6 = r4.getOriginSpaceId();
        if (this.workspace.v(r5) == false) goto L12;
        r3 = Flowable.just(Boolean.TRUE);
        goto L13
    L12:
        Function2<List<? extends TreeNode>, Boolean, Boolean> r7 = new WikiTreeRepositoryKt$requestSpaceChildren$insertChildrenFun$1(this, r5);
        Intrinsics.checkNotNull(r4);
        Flowable<up5.b<TreeNode>> r8 = t1.h(this, r4);
        Flowable r9 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.l0.a(this.netService).a(new GetChildPuller.Params(r6, r5));
        a3 r10 = a3.a;
        Intrinsics.checkNotNull(r6);
        r10.getClass();
        Intrinsics.checkNotNullParameter(r6, "spaceId");
        Flowable r12 = Flowable.just("").observeOn(fo5.d.c()).map(new x2(r6)).flatMap(new z2(r6));
        Intrinsics.checkNotNullParameter(r12, "<this>");
        r3 = Flowable.zip(r8, r9, r12.map(up5.c.a).observeOn(fo5.d.d()), new g2(this, r7)).map(new f2(this, r5));
        goto L13
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void favorite(final String r6) {
        tt5.a.h(this.mTAG, String.format("WikiTreeModel.favorite, wikiToken: %s", new Object[]{yu5.c.j(r6)}));
        if (this.workspace.x(r6) == true) goto L6;
        tt5.a.k(this.mTAG, "WikiTreeModel.favorite, node not found. ");
        return;
    L6:
        this.disposables.add(new FavoritePuller(this.netService).c(new FavoritePuller.Params(i.b(this.workspace, r6, this.userComponentAbility), r6)).map(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.v()).map(new g0(this, r6)).observeOn(fo5.d.d()).doOnSubscribe(new h0(this)).subscribe(new i0(this, r6), new j0(this)));
    }

    public void filterSingleNode(d3 r6) {
        List<Function<j, Boolean>> r0 = this.singleNodeFilters;
        Iterator r7 = ((ArrayList) r6.a).iterator();
    L4:
        if (r7.hasNext() == false) goto L19;
        j r1 = (j) r7.next();
        boolean r2 = false;
        if (r0 != null) goto L8;
    L17:
        if (r2 == false) goto L4;
        r7.remove();
        goto L4
    L8:
        if (hu5.a.f(r0) == false) goto L17;
        Iterator<Function<j, Boolean>> r3 = r0.iterator();     // Catch: Exception -> L15
    L11:
        if (r3.hasNext() == false) goto L17;
        if (((Boolean) r3.next().apply(r1)).booleanValue() == false) goto L11;
        r2 = true;
    L15:
        e = move-exception;
        tt5.a.e("Wiki_WikiUIList", "filterSingleNode apply err. ", e, false);
        goto L17
    }

    public String getChainPushUuid(String r3) {
        return this.mHashCode + "#" + r3;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public Flowable<MoveToSpaceStatusPuller.Result> getMoveToSpaceStatus(String r3) {
        return new MoveToSpaceStatusPuller(this.netService).d(new MoveToSpaceStatusPuller.Params(r3));
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public TreeNode getNode(String r2) {
        return this.workspace.m(r2);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public String getTitle(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return "";
    L5:
        e3 r0 = this.workspace;
        TreeNode r5 = r0.g.get(r4);
        if (r5 != null) goto L8;
        return "";
    L8:
        if (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.c.c(r5.wiki_node_type) == false) goto L11;
        return r0.j.getSpaceName();
    L11:
        return r5.title;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void insert(final IOperationInsert.TreeNodeInsertParams r7) {
        tt5.a.h(this.mTAG, String.format("WikiTreeModel.insert, parentToken: %s, forceExpand: %s", new Object[]{yu5.c.j(r7.parentToken), String.valueOf(r7.forceExpand)}));
        if (this.workspace.x(r7.parentToken) == true) goto L6;
        tt5.a.k(this.mTAG, "WikiTreeModel.insert, node not found. ");
        return;
    L6:
        final TreeNode r0 = this.workspace.m(r7.parentToken);
        CompositeDisposable r1 = this.disposables;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r7, "params");
        TreeNode r2 = this.workspace.m(r7.parentToken);
        String r3 = r2.getOriginToken();
        String r4 = r2.getOriginSpaceId();
        Intrinsics.checkNotNull(r2);
        r1.add(t1.h(this, r2).flatMap(new y1(this, r4, r3, r7)).observeOn(fo5.d.e()).map(new z1(this, r3, r7)).observeOn(fo5.d.d()).doOnSubscribe(new r0(this)).subscribe(new s0(this, r0, r7), new t0(this)));
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public boolean isCloudPinDocument(String r3) {
        String r0 = VirtualNode.TITLE_ROOT_CLOUD_DOCUMENT.getRootToken();
        return ((ArrayList) this.workspace.i(r0)).contains(r3);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public boolean isFavorite(String r3) {
        e3 r0 = this.workspace;
        Map<String, List<String>> r1 = r0.f;
        ConcurrentHashMap r2 = (ConcurrentHashMap) r1;
        List r4 = (List) r2.get(r0.a);
        if (hu5.a.d(r4) == false) goto L7;
        return false;
    L7:
        return r4.contains(r3);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public boolean isSameSpace(String r2) {
        if (this.workspace.w() == true) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(i.a(this.workspace), r2) == false) goto L7;
        return true;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public boolean isSidebarShared(String r3) {
        String r0 = VirtualNode.TITLE_ROOT_SHARE.getRootToken();
        return ((ArrayList) this.workspace.i(r0)).contains(r3);
    }

    @Override // cr5.d.a
    public void onAddHomePageV3(AddV3 r9) {
        if (yp5.c.i() == true) goto L5;
        return;
    L5:
        tt5.a.h(this.mTAG, "WikiTreeModel.onAddHomePageV3, addV3: " + r9);
        if (r9 != null) goto L8;
    L47:
        tt5.a.k(this.mTAG, "WikiTreeModel.onAddHomePageV3, invalid params. ");
        return;
    L8:
        if (TextUtils.isEmpty(r9.spaceId) == true) goto L47;
        e3 r1 = this.workspace;
        String r2 = r9.spaceId;
        ce5.a r3 = this.userComponentAbility;
        int r4 = i.a;
        String r5 = i.a.b(r1, r2, r3);
        NetService r6 = this.netService;     // Catch: Throwable -> L44
        GetRelationPuller.Params r7 = new GetRelationPuller.Params(r5, r9.wikiToken);     // Catch: Throwable -> L44
        if (TextUtils.isEmpty(r7.wiki_token) == false) goto L14;
        r7.wiki_token = null;     // Catch: Throwable -> L44
    L14:
        WikiRelation r10 = (WikiRelation) new GetRelationPuller(r6).c(r7).flatMap(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.i0()).blockingSingle();     // Catch: Throwable -> L44
        if (r10 == null) goto L17;
        SpaceInfo r11 = r10.space;
    L18:
        if (r11 == null) goto L20;
        WikiHomePageV2 r12 = r11.homePageV2;
    L21:
        if (r12 != null) goto L23;
    L42:
        tt5.a.k(this.mTAG, "WikiTreeModel.onAddHomePageV3, homePageV2 empty. ");
        return;
    L23:
        if (r12.isValid() == false) goto L42;
        a3 r8 = a3.a;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r5, "spaceId");
        Intrinsics.checkNotNullParameter(r12, "homePageV2");
        if (r12.isValid() == false) goto L36;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L30
        WikiDatabase r14 = WikiDatabase.c();     // Catch: Throwable -> L30
        r14.runInTransaction(new b3(r14, r5, r8, r12));     // Catch: Throwable -> L30
        tt5.a.h("WikiTreeSpaceInfoDataManager", "updateHomePage success, spaceId=".concat(r5));     // Catch: Throwable -> L30
        Object r0 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L30
    L32:
        Throwable r15 = Result.exceptionOrNull-impl(r0);
        if (r15 == null) goto L36;
        tt5.a.e("WikiTreeSpaceInfoDataManager", "updateHomePage fail, spaceId=".concat(r5), r15, false);
    L30:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
    L36:
        if (TextUtils.equals(this.workspace.o(), r5) == false) goto L40;
        SpaceInfo r17 = this.workspace.j;
        if (r17 == null) goto L40;
        r17.homePageV2 = r12;
    L40:
        WikiAction r18 = WikiAction.REFRESH;
        int r19 = h.c;
        g r20 = h.a.c(r18, null);
        r20.f = r5;
        this.wikiList.postValue(r20);
        return;
    L20:
        r12 = null;
        goto L21
    L17:
        r11 = null;
    L44:
        th = move-exception;
        tt5.a.e(this.mTAG, "WikiTreeModel.onAddHomePageV3, pull relation fail. ", th, false);
    }

    @Override // cr5.d.a
    public void onAddV3(AddV3 r5) {
        tt5.a.h(this.mTAG, "WikiTreeModel.onAddV3, addV3: " + r5);
        if (this.workspace.x(r5.parentWikiToken) == true) goto L5;
    L13:
        tt5.a.k(this.mTAG, "WikiTreeModel.onAddV3, node not found. ");
        return;
    L5:
        if (this.workspace.x(r5.wikiToken) == true) goto L13;
        TreeNode r0 = (TreeNode) reverseGetNode(r5.spaceId, r5.wikiToken).first;
        if (r0 != null) goto L11;
        tt5.a.k(this.mTAG, "WikiTreeModel.onAddV3, reverse fail. ");
        return;
    L11:
        t1.b(this, r5.parentWikiToken, r0, false, "");
        WikiAction r1 = WikiAction.PUSH_ADD;
        d3 r2 = provideUiList();
        int r3 = h.c;
        g r4 = h.a.c(r1, r2);
        r4.f = r5.spaceId;
        String r6 = r5.wikiToken;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r4.g = r6;
        this.wikiList.postValue(r4);
    }

    @Override // cr5.d.a
    public void onBatchAddV3(BatchAddV3 r9) {
        tt5.a.h(this.mTAG, "WikiTreeModel.onBatchAddV3, batchAddV3: " + r9);
        if (this.workspace.x(r9.parentWikiToken) == true) goto L7;
        tt5.a.k(this.mTAG, "WikiTreeModel.onBatchAddV3, parent node not found. ");
        return;
    L7:
        if (hu5.a.d(r9.wikiTokens) == false) goto L10;
        tt5.a.k(this.mTAG, "WikiTreeModel.onBatchAddV3, wiki_tokens empty. ");
        return;
    L10:
        ArrayList r0 = new ArrayList();
        Iterator<String> r1 = r9.wikiTokens.iterator();
    L12:
        if (r1.hasNext() == false) goto L18;
        String r2 = r1.next();
        if (this.workspace.x(r2) == true) goto L15;
        r0.add(r2);
        goto L12
    L15:
        tt5.a.k(this.mTAG, "WikiTreeModel.onBatchAddV3, node is already exist");
        goto L12
    L18:
        if (hu5.a.d(r0) == false) goto L21;
        tt5.a.k(this.mTAG, "WikiTreeModel.onBatchAddV3, addTokens empty");
        return;
    L21:
        List<TreeNode> r3 = (List) reverseGetBatchNode(r0).first;
        if (hu5.a.d(r3) == false) goto L25;
        tt5.a.k(this.mTAG, "WikiTreeModel.onBatchAddV3, reverse fail. ");
        return;
    L25:
        String r4 = r9.parentWikiToken;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r4, "parentToken");
        Intrinsics.checkNotNullParameter(r3, "newInsertNodeList");
        tt5.a.h("Wiki_WikiTreeRepository", "addBatchNodes start. ");
        StringCompanionObject r5 = StringCompanionObject.INSTANCE;
        tt5.a.h("Wiki_WikiTreeRepository", String.format("batchInsert, srcToken: %s, toInsertNode size: %s, forceExpand: %s", Arrays.copyOf(new Object[]{yu5.c.j(r4), Integer.valueOf(r3.size()), String.valueOf(false)}, 3)));
        if (this.workspace.v(r4) == false) goto L28;
        this.workspace.s(r4, r3);
    L28:
        Flowable.fromCallable(new s1(this, r4)).subscribeOn(fo5.d.f()).subscribe(Functions.emptyConsumer(), up5.e.a);
        g r6 = h.c(WikiAction.PUSH_BATCH_ADD, provideUiList());
        r6.f = r9.spaceId;
        ArrayList<String> r10 = r9.wikiTokens;
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r6.h = r10;
        this.wikiList.postValue(r6);
    }

    @Override // cr5.d.a
    public void onBatchMovV3(BatchMovV3 r28) {
        tt5.a.h(this.mTAG, "WikiTreeModel.onBatchMovV3, movV3: " + r28);
        if (this.workspace.w() == true) goto L7;
        tt5.a.k(this.mTAG, "WikiTreeModel.onBatchMovV3, space not init. ");
        return;
    L7:
        if (hu5.a.d(r28.wikiTokens) == false) goto L10;
        tt5.a.k(this.mTAG, "WikiTreeModel.onBatchMovV3, wiki_tokens is empty");
        return;
    L10:
        TreeNode r0 = this.workspace.m(r28.from);
        TreeNode r3 = this.workspace.m(r28.to);
        ArrayList r4 = new ArrayList();
        Iterator<String> r5 = r28.wikiTokens.iterator();
    L12:
        if (r5.hasNext() == false) goto L23;
        String r6 = r5.next();
        TreeNode r7 = this.workspace.m(r6);
        if (r7 == null) goto L15;
        if (TextUtils.isEmpty(r7.parent_wiki_token) == true) goto L21;
        if (TextUtils.equals(r7.parent_wiki_token, r28.from) == true) goto L21;
        tt5.a.k(this.mTAG, "WikiTreeModel.onBatchMovV3, treeNode.parent and fromNode.parent no equals. return. ");
    L21:
        r4.add(r6);
        goto L12
    L15:
        tt5.a.k(this.mTAG, "WikiTreeModel.onBatchMovV3, moveNode not found, return. ");
        goto L12
    L23:
        if (hu5.a.d(r4) == false) goto L26;
        tt5.a.k(this.mTAG, "WikiTreeModel.onBatchMovV3, moveTokenList is empty. return. ");
        return;
    L26:
        String r13 = r28.newSpaceId;
        if (this.chainPushManager.c.containsKey(r13) == true) goto L30;
        tt5.a.k(this.mTAG, "WikiTreeModel.onBatchMovV3, moveNode out of origin space. return. ");
        t1.c(this, r4, r28.from, r28.oldSpaceId);
        WikiAction r1 = WikiAction.PUSH_BATCH_MOV;
        d3 r8 = provideUiList();
        int r9 = h.c;
        g r2 = h.a.c(r1, r8);
        r2.f = r28.oldSpaceId;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r2.l = r4;
        r2.d(r13);
        String r10 = this.focusToken;
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r2.p = r10;
        this.wikiList.postValue(r2);
        return;
    L30:
        if (r0 != null) goto L34;
        if (r3 != null) goto L34;
        tt5.a.k(this.mTAG, "WikiTreeModel.onBatchMovV3, fromNode and destNode both not found. return. ");
        return;
    L34:
        Pair<List<TreeNode>, Throwable> r11 = reverseGetBatchNode(r4);
        List r12 = (List) r11.first;
        Throwable r14 = (Throwable) r11.second;
        if (hu5.a.d(r12) == false) goto L41;
        if (r14 != null) goto L38;
        return;
    L38:
        if (tp5.b.d(r14) == false) goto L86;
        tt5.a.l(this.mTAG, "WikiTreeModel.onBatchMovV3, moveNode not found, pull moveNode fail. return. ", r14);
        t1.c(this, r4, r28.from, r13);
        WikiAction r15 = WikiAction.PUSH_BATCH_MOV;
        d3 r16 = provideUiList();
        int r17 = h.c;
        g r18 = h.a.c(r15, r16);
        r18.f = r28.oldSpaceId;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r18.l = r4;
        r18.d(r13);
        this.wikiList.postValue(r18);
        return;
    L86:
        return;
    L41:
        Iterator r19 = r4.iterator();
    L43:
        if (r19.hasNext() == false) goto L47;
        String r20 = (String) r19.next();
        if (this.workspace.t(this.focusToken, r20) == false) goto L43;
        String r21 = r20;
    L49:
        if (TextUtils.isEmpty(r21) == true) goto L63;
        if (r3 != null) goto L52;
    L69:
        NetService r22 = this.netService;     // Catch: Exception -> L58
        GetRelationPuller.Params r23 = new GetRelationPuller.Params(r13, r28.to);     // Catch: Exception -> L58
        if (TextUtils.isEmpty(r23.wiki_token) == false) goto L56;
        r23.wiki_token = null;     // Catch: Exception -> L58
    L56:
        WikiRelation r110 = (WikiRelation) new GetRelationPuller(r22).c(r23).flatMap(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.i0()).blockingSingle();     // Catch: Exception -> L58
    L64:
        e r24 = new e(r28.from, r28.to, r21, this.focusToken, r12, r110, r13);
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r24, "bean");
        tt5.a.h("Wiki_WikiTreeRepository", "movBatchNodes start. ");
        boolean r25 = this.workspace.q(r24.b);
        ArrayList r26 = new ArrayList();
        int r27 = r24.e.size();
        int r29 = 0;
    L65:
        if (r29 >= r27) goto L67;
        t1.j(this, new f(((TreeNode) ListProtector.get(r24.e, r29)).wiki_token, r24.b, ((TreeNode) ListProtector.get(r24.e, r29)).sort_id, TextUtils.equals(((TreeNode) ListProtector.get(r24.e, r29)).wiki_token, r24.c), r24.d, (TreeNode) ListProtector.get(r24.e, r29), r24.f, r24.g));
        r26.add(((TreeNode) ListProtector.get(r24.e, r29)).wiki_token);
        r29 = r29 + 1;
        r27 = r27;
        r13 = r13;
        goto L65
    L67:
        Flowable.fromCallable(new x1(r24, r26, r25, this)).subscribeOn(fo5.d.f()).subscribe(Functions.emptyConsumer(), up5.e.a);
        WikiAction r30 = WikiAction.PUSH_BATCH_MOV;
        d3 r31 = provideUiList();
        int r32 = h.c;
        g r33 = h.a.c(r30, r31);
        r33.f = r28.oldSpaceId;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r33.l = r4;
        r33.d(r13);
        this.wikiList.postValue(r33);
        return;
    L58:
        e = move-exception;
        tt5.a.i(this.mTAG, "WikiTreeModel.onMovV3, destNode not found, pull destNode fail. return. ", e);
        if (tp5.b.d(e) == false) goto L87;
        t1.c(this, r4, r28.from, r13);
        WikiAction r34 = WikiAction.PUSH_BATCH_MOV;
        d3 r35 = provideUiList();
        int r36 = h.c;
        g r37 = h.a.c(r34, r35);
        r37.f = r28.oldSpaceId;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r37.l = r4;
        r37.d(r13);
        this.wikiList.postValue(r37);
        return;
    L87:
        return;
    L52:
        if (this.workspace.q(r3.wiki_token) == false) goto L69;
    L63:
        r110 = null;
        goto L64
    L47:
        r21 = null;
        goto L49
    }

    @Override // cr5.d.a
    public void onDelAndMovUPV3(DelAndMovUpV3 r4) {
        tt5.a.h(this.mTAG, "WikiTreeModel.onDelAndMovUPV3, delAndMovUpV3: " + r4);
        removeFromWiki(r4.parentWikiToken, r4.wikiToken);
    }

    @Override // cr5.d.a
    public void onDelHomePageV3(DelV3 r15) {
        if (yp5.c.i() == true) goto L5;
        return;
    L5:
        tt5.a.h(this.mTAG, "WikiTreeModel.onDelHomePageV3, delV3: " + r15);
        if (r15 != null) goto L8;
    L47:
        tt5.a.k(this.mTAG, "WikiTreeModel.onDelHomePageV3, invalid params. ");
        return;
    L8:
        if (TextUtils.isEmpty(r15.spaceId) == true) goto L47;
        if (TextUtils.isEmpty(r15.wikiToken) == true) goto L47;
        e3 r0 = this.workspace;
        String r1 = r15.spaceId;
        ce5.a r2 = this.userComponentAbility;
        int r3 = i.a;
        String r4 = i.a.b(r0, r1, r2);
        String r5 = i.a(this.workspace);
        if (TextUtils.equals(this.workspace.o(), r4) == true) goto L15;
        TextUtils.equals(r5, r4);
    L15:
        SpaceInfo r6 = this.workspace.j;
        if (r6 == null) goto L20;
        WikiHomePageV2 r7 = r6.homePageV2;
        if (r7 == null) goto L20;
        String r8 = r7.wikiToken;
    L22:
        if (r6 != null) goto L24;
    L26:
        boolean r9 = false;
    L27:
        a3 r10 = a3.a;
        String r11 = r15.wikiToken;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r4, "spaceId");
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L30
        WikiDatabase r13 = WikiDatabase.c();     // Catch: Throwable -> L30
        Ref.BooleanRef r14 = new Ref.BooleanRef();     // Catch: Throwable -> L30
        r13.runInTransaction(new y2(r13, r4, r11, r10, r14));     // Catch: Throwable -> L30
        boolean r16 = r14.element;     // Catch: Throwable -> L30
        tt5.a.h("WikiTreeSpaceInfoDataManager", "deleteHomePageIfMatch " + r16 + ", spaceId=" + r4);     // Catch: Throwable -> L30
        Object r17 = Result.constructor-impl(Boolean.valueOf(r16));     // Catch: Throwable -> L30
    L32:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L35;
        tt5.a.e("WikiTreeSpaceInfoDataManager", "deleteHomePageIfMatch fail, spaceId=".concat(r4), r18, false);
    L35:
        Boolean r19 = Boolean.FALSE;
        if (Result.isFailure-impl(r17) == false) goto L38;
        r17 = r19;
    L38:
        boolean r110 = ((Boolean) r17).booleanValue();
        if (r110 == true) goto L43;
        if (r9 == true) goto L43;
        tt5.a.h(this.mTAG, "WikiTreeModel.onDelHomePageV3, ignore not matched. ");
        return;
    L43:
        if (r110 == false) goto L45;
        tt5.a.h(this.mTAG, "WikiTreeModel.onDelHomePageV3, deleted done");
    L45:
        WikiAction r111 = WikiAction.REFRESH;
        int r20 = h.c;
        g r112 = h.a.c(r111, null);
        r112.f = r4;
        this.wikiList.postValue(r112);
        return;
    L30:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L32
    L24:
        if (TextUtils.equals(r8, r15.wikiToken) == false) goto L26;
        r6.homePageV2 = null;
        r9 = true;
    L20:
        r8 = null;
        goto L22
    }

    @Override // cr5.d.a
    public void onDelV3(DelV3 r4) {
        tt5.a.h(this.mTAG, "WikiTreeModel.onDelV3, delV3: " + r4);
        if (this.workspace.x(r4.wikiToken) == true) goto L7;
        tt5.a.k(this.mTAG, "WikiTreeModel.onDelV3, node not found. ");
        return;
    L7:
        if (TextUtils.equals(this.workspace.m(r4.wikiToken).parent_wiki_token, r4.parentWikiToken) == true) goto L10;
        tt5.a.h(this.mTAG, "WikiTreeModel.onDelV3, parent not the same. ");
        return;
    L10:
        t1.d(this, r4.spaceId, r4.wikiToken);
        this.workspace.I(r4.wikiToken);
        WikiAction r0 = WikiAction.PUSH_DEL;
        d3 r1 = provideUiList();
        int r2 = h.c;
        g r3 = h.a.c(r0, r1);
        r3.f = r4.spaceId;
        String r5 = r4.parentWikiToken;
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r3.i = r5;
        this.wikiList.postValue(r3);
    }

    @Override // cr5.d.a
    public void onDesV3(DesV3 r4) {
        tt5.a.h(this.mTAG, "WikiTreeModel.onDesV3, desV3: " + r4);
        this.wikiList.postValue(h.a(WikiAction.PUSH_DES, new Throwable()));
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.LocalPush.b
    public void onDoExploreFavorite(com.bytedance.ee.bear.wikiv2.wikitreev2.b r3) {
        tt5.a.h(this.mTAG, "WikiTreeModel.onDoExploreFavorite.");
        if (this.workspace.w() == false) goto L6;
        this.workspace.G(r3.b, r3.c);
        return;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.LocalPush.b
    public void onDoFavorite(com.bytedance.ee.bear.wikiv2.wikitreev2.b r6) {
        boolean r3 = false;
        tt5.a.h(this.mTAG, String.format("WikiTreeModel.onDoFavorite. spaceId: %s, wikiToken: %s", new Object[]{yu5.c.j(r6.a), yu5.c.j(r6.b)}));
        if (isSameSpace(r6.a) == false) goto L18;
        e3 r0 = this.workspace;
        String r1 = r6.b;
        List r2 = (List) ((ConcurrentHashMap) r0.f).get(r0.a);
        if (hu5.a.d(r2) == true) goto L7;
        r3 = r2.contains(r1);
    L7:
        boolean r4 = r6.c;
        if (r4 != r3) goto L10;
        return;
    L10:
        if (r4 == false) goto L12;
        t1.f(this, r6.b);
    L14:
        if (this.workspace.u() == false) goto L16;
        MutableLiveData<h> r7 = this.wikiList;
        WikiAction r5 = WikiAction.PUSH_FAVORITE;
        d3 r8 = provideUiList();
        int r9 = h.c;
        r7.setValue(h.a.c(r5, r8));
        return;
    L16:
        MutableLiveData<h> r10 = this.wikiList;
        WikiAction r11 = WikiAction.PUSH_FAVORITE;
        int r12 = h.c;
        r10.setValue(h.a.c(r11, null));
        return;
    L12:
        t1.m(this, r6.b);
        goto L14
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.LocalPush.b
    public void onDoPin(com.bytedance.ee.bear.wikiv2.wikitreev2.d r5) {
        tt5.a.h(this.mTAG, String.format("WikiTreeModel.onDoPin. spaceId: %s, wikiToken: %s", new Object[]{yu5.c.j(r5.a), yu5.c.j(r5.b)}));
        if (this.workspace.w() == true) goto L5;
    L7:
        ((NonStickyMutableLiveData) WikiTreeObserver.j.getValue()).e(new com.bytedance.ee.bear.wikiv2.wikitreev2.e(r5.a));
        return;
    L5:
        if (isSameSpace(r5.a) == false) goto L7;
        this.workspace.H(r5.b, r5.c);
        goto L7
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.LocalPush.b
    public void onDoReload(com.bytedance.ee.bear.wikiv2.wikitreev2.e r4) {
        tt5.a.h(this.mTAG, "WikiTreeModel.onDoReload, doReload: " + r4);
        reloadTitleCloud();
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.LocalPush.b
    public void onFocusChange(com.bytedance.ee.bear.wikiv2.wikitreev2.f r8) {
        if (this.localPushFocusTokenDisable == false) goto L6;
        tt5.a.h(this.mTAG, "WikiTreeModel.onFocusChange. disable!");
        return;
    L6:
        tt5.a.h(this.mTAG, String.format("WikiTreeModel.onFocusChange. spaceId: %s, wikiToken: %s", new Object[]{yu5.c.j(r8.a), yu5.c.j(r8.b)}));
        gq5.b.a = null;
        e3 r2 = g3.a.a.a.getAndSet(null);
        if (r2 != null) goto L9;
        return;
    L9:
        if (r2.w() == true) goto L11;
        return;
    L11:
        if (isSameSpace(i.a(r2)) == false) goto L20;
        String r3 = r8.b;
        String r4 = r8.c;
        if (r2.x(r3) == true) goto L15;
        return;
    L15:
        if (TextUtils.equals(this.focusToken, r3) == true) goto L22;
        setFocus(r3, r4);
        load(r2, r3, r4, true, this.needExpandAfterInit);
        return;
    L22:
        return;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.LocalPush.b
    public void onLocalDelete(com.bytedance.ee.bear.wikiv2.wikitreev2.a r4) {
        tt5.a.h(this.mTAG, "WikiTreeModel.onSpaceDelete, doDelete: " + r4);
        reloadTitleCloud();
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.LocalPush.b
    public void onLocalMove(com.bytedance.ee.bear.wikiv2.wikitreev2.c r4) {
        tt5.a.h(this.mTAG, "WikiTreeModel.onLocalMove, doMove: " + r4);
        reloadTitleCloud();
    }

    @Override // cr5.d.a
    public void onMovV3(MovV3 r19) {
        tt5.a.h(this.mTAG, "WikiTreeModel.onMovV3, movV3: " + r19);
        if (this.workspace.w() == true) goto L6;
        tt5.a.k(this.mTAG, "WikiTreeModel.onMovV3, space not init. ");
        return;
    L6:
        TreeNode r0 = this.workspace.m(r19.from);
        TreeNode r3 = this.workspace.m(r19.to);
        TreeNode r4 = this.workspace.m(r19.wikiToken);
        if (r4 != null) goto L9;
    L14:
        String r5 = r19.newSpaceId;
        if (this.chainPushManager.c.containsKey(r5) == true) goto L18;
        tt5.a.k(this.mTAG, "WikiTreeModel.onMovV3, moveNode out of origin space. return. ");
        t1.d(this, r19.oldSpaceId, r19.wikiToken);
        WikiAction r1 = WikiAction.PUSH_MOV;
        d3 r6 = provideUiList();
        int r7 = h.c;
        g r2 = h.a.c(r1, r6);
        r2.f = r19.oldSpaceId;
        String r8 = r19.wikiToken;
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r2.k = r8;
        r2.d(r5);
        String r9 = this.focusToken;
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r2.p = r9;
        this.wikiList.postValue(r2);
        return;
    L18:
        if (r0 != null) goto L22;
        if (r3 != null) goto L22;
        tt5.a.k(this.mTAG, "WikiTreeModel.onMovV3, fromNode and destNode both not found. return. ");
        return;
    L22:
        Pair<TreeNode, Throwable> r10 = reverseGetNode(r3.space_id, r19.wikiToken);
        TreeNode r15 = (TreeNode) r10.first;
        Throwable r11 = (Throwable) r10.second;
        if (r15 != null) goto L31;
        if (r11 != null) goto L26;
        return;
    L26:
        if (tp5.b.d(r11) == false) goto L52;
        tt5.a.l(this.mTAG, "WikiTreeModel.onMovV3, moveNode not found, pull moveNode fail. return. ", r11);
        if (this.workspace.x(r19.wikiToken) == false) goto L53;
        e3 r12 = this.workspace;
        String r13 = r19.wikiToken;
        ce5.a r14 = this.userComponentAbility;
        int r16 = i.a;
        t1.d(this, i.a.b(r12, r13, r14), r19.wikiToken);
        WikiAction r17 = WikiAction.PUSH_MOV;
        d3 r18 = provideUiList();
        int r20 = h.c;
        g r21 = h.a.c(r17, r18);
        r21.f = r19.oldSpaceId;
        String r22 = r19.wikiToken;
        Intrinsics.checkNotNullParameter(r22, "<set-?>");
        r21.k = r22;
        r21.d(r5);
        this.wikiList.postValue(r21);
        return;
    L53:
        return;
    L52:
        return;
    L31:
        boolean r23 = this.workspace.t(this.focusToken, r19.wikiToken);
        if (r23 == true) goto L34;
    L46:
        WikiRelation r110 = null;
    L47:
        t1.i(this, r19.from, new f(r19.wikiToken, r19.to, r15.sort_id, r23, this.focusToken, r15, r110, r19.newSpaceId));
        WikiAction r24 = WikiAction.PUSH_MOV;
        d3 r25 = provideUiList();
        int r26 = h.c;
        g r27 = h.a.c(r24, r25);
        setFocus(this.focusToken, this.workspace.l(this.focusToken));
        r27.f = r19.oldSpaceId;
        String r28 = r19.wikiToken;
        Intrinsics.checkNotNullParameter(r28, "<set-?>");
        r27.k = r28;
        r27.d(r5);
        r27.s = r23;
        this.wikiList.postValue(r27);
        return;
    L34:
        if (this.workspace.q(r3.wiki_token) == true) goto L46;
        NetService r29 = this.netService;     // Catch: Exception -> L40
        GetRelationPuller.Params r30 = new GetRelationPuller.Params(r5, r19.to);     // Catch: Exception -> L40
        if (TextUtils.isEmpty(r30.wiki_token) == false) goto L38;
        r30.wiki_token = null;     // Catch: Exception -> L40
    L38:
        r110 = (WikiRelation) new GetRelationPuller(r29).c(r30).flatMap(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.i0()).blockingSingle();     // Catch: Exception -> L40
    L40:
        e = move-exception;
        tt5.a.i(this.mTAG, "WikiTreeModel.onMovV3, destNode not found, pull destNode fail. return. ", e);
        if (tp5.b.d(e) == false) goto L54;
        if (r4 == null) goto L55;
        t1.d(this, r4.space_id, r19.wikiToken);
        WikiAction r31 = WikiAction.PUSH_MOV;
        d3 r32 = provideUiList();
        int r33 = h.c;
        g r34 = h.a.c(r31, r32);
        r34.f = r19.oldSpaceId;
        String r35 = r19.wikiToken;
        Intrinsics.checkNotNullParameter(r35, "<set-?>");
        r34.k = r35;
        r34.d(r5);
        this.wikiList.postValue(r34);
        return;
    L55:
        return;
    L54:
        return;
    L9:
        if (TextUtils.isEmpty(r4.parent_wiki_token) == true) goto L14;
        if (TextUtils.equals(r4.parent_wiki_token, r19.from) == true) goto L14;
        tt5.a.k(this.mTAG, "WikiTreeModel.onMovV3, treeNode.parent and fromNode.parent no equals. return. ");
    }

    @Override // cr5.d.a
    public void onPinAdd(PinAddV1 r1) {
        if (this.isSidebarSynergyEnable == false) goto L6;
        reloadTitleCloud();
        return;
    }

    @Override // cr5.d.a
    public void onPinDelete(PinDeleteV1 r1) {
        if (this.isSidebarSynergyEnable == false) goto L6;
        reloadTitleCloud();
        return;
    }

    @Override // cr5.d.a
    public void onPinMove(PinMoveV1 r1) {
        if (this.isSidebarSynergyEnable == false) goto L6;
        reloadTitleCloud();
        return;
    }

    @Override // cr5.d.a
    public void onReaV3(ReaV3 r3) {
        AddV3 r0 = new AddV3();
        r0.spaceId = r3.spaceId;
        r0.wikiToken = r3.wikiToken;
        r0.parentWikiToken = r3.parentWikiToken;
        onAddV3(r0);
    }

    @Override // cr5.d.a
    public void onSpacePinAdd(SpacePinAddV1 r1) {
        reloadTitleSpace();
    }

    @Override // cr5.d.a
    public void onSpacePinDelete(SpacePinDelV1 r1) {
        reloadTitleSpace();
    }

    @Override // cr5.d.a
    public void onSpacePinMove(SpacePinMoveV1 r1) {
        reloadTitleSpace();
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.LocalPush.b
    public void onTitleChange(com.bytedance.ee.bear.wikiv2.wikitreev2.g r5) {
        tt5.a.h(this.mTAG, String.format("WikiTreeModel.onTitleChange. spaceId: %s, wikiToken: %s", new Object[]{yu5.c.j(r5.a), yu5.c.j(r5.b)}));
        updateTitleAndIcon(r5.b, r5.c, this.workspace.m(r5.b).iconInfo);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.LocalPush.b
    public void onTokenChange(com.bytedance.ee.bear.wikiv2.wikitreev2.h r5) {
        tt5.a.h(this.mTAG, String.format("WikiTreeModel.onTokenChange. spaceId: %s, fakeToken: %s", new Object[]{yu5.c.j(r5.a), yu5.c.j(r5.b)}));
        updateToken(r5);
    }

    @Override // cr5.d.a
    public void onUdeNodePermV3(UdeNodePermV3 r5) {
        tt5.a.h(this.mTAG, "WikiTreeModel.UdeNodePermV3, UdeNodePermV3: " + r5);
        if (r5.effect() == true) goto L7;
        tt5.a.h(this.mTAG, "WikiTreeModel.UdeNodePermV3, not effect. return. ");
        return;
    L7:
        if (this.workspace.x(r5.parent) == true) goto L9;
    L23:
        tt5.a.k(this.mTAG, "WikiTreeModel.UdeNodePermV3, parent not found. ");
        return;
    L9:
        if (this.workspace.q(r5.parent) == false) goto L23;
        Pair<TreeNode, Throwable> r0 = reverseGetNode(r5.spaceId, r5.wikiToken);
        TreeNode r1 = (TreeNode) r0.first;
        Throwable r2 = (Throwable) r0.second;
        TreeNode r3 = this.workspace.m(r5.wikiToken);
        if (r1 == null) goto L16;
        if (r3 == null) goto L15;
        r3.perm = null;
        return;
    L15:
        t1.b(this, r5.parent, r1, false, "");
        this.wikiList.postValue(h.c(WikiAction.PUSH_UDE_NODE_PERM, provideUiList()));
        return;
    L16:
        if (r2 != null) goto L18;
    L21:
        tt5.a.e(this.mTAG, "WikiTreeModel.UdeNodePermV3, reverse fail. ", r2, false);
        return;
    L18:
        if (tp5.b.d(r2) == false) goto L21;
        if (r3 == null) goto L27;
        t1.d(this, r5.spaceId, r5.wikiToken);
        this.wikiList.postValue(h.c(WikiAction.PUSH_UDE_NODE_PERM, provideUiList()));
        return;
    }

    @Override // cr5.d.a
    public void onUdeV3(UdeV3 r4) {
        tt5.a.h(this.mTAG, "WikiTreeModel.onUdeV3, udeV3: " + r4);
        if (this.workspace.x(r4.wikiToken) == true) goto L6;
        tt5.a.k(this.mTAG, "WikiTreeModel.onUdeV3, node not found. ");
        return;
    L6:
        TreeNode r0 = (TreeNode) reverseGetNode(r4.spaceId, r4.wikiToken).first;
        if (r0 != null) goto L11;
        tt5.a.k(this.mTAG, "WikiTreeModel.onUdeV3, reverse fail. ");
        return;
    L11:
        if (yp5.c.i() == true) goto L13;
    L15:
        updateTitleAndIcon(r4.wikiToken, r0.title, r0.iconInfo);
        OfflineRenameData r5 = new OfflineRenameData();
        r5.setNewName(r0.title);
        if (r0.isShortcut() == false) goto L18;
        r5.setObjToken(r0.wiki_token);
    L19:
        r5.setNewIconInfo(r0.iconInfo);
        ((rc5.a) org.koin.java.a.a(rc5.a.class)).Y(r5);
        return;
    L18:
        r5.setObjToken(r0.obj_token);
        goto L19
    L13:
        if (r0.isWikiHomePage == false) goto L15;
        handleUpdateWikiHomePageTitleInternal(r4, r0);
        goto L15
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void registerChainPush(String r5) {
        boolean r0 = this.workspace.w();
        tt5.a.h(this.mTAG, "WikiTreeModel.registerChainPush. valid=" + r0);
        if (r0 == false) goto L6;
        this.chainPushManager.a(r5, getChainPushUuid(r5), this.tagSuffix, this);
        return;
    }

    public void reload(List<String> r3) {
        if (this.workspace.w() == true) goto L5;
        return;
    L5:
        tt5.a.h(this.mTAG, "WikiTreeModel.reload. ");
        g r0 = h.c(WikiAction.RELOAD, null);
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r0.x = r3;
        this.wikiList.postValue(r0);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void setChainPushEnable(boolean r2) {
        this.chainPushManager.b = r2;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void setDataFilter(Function<TreeNode, Boolean> r2) {
        this.dataFilter = r2;
        if (this.workspace.w() == false) goto L6;
        this.workspace.m = r2;
        return;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void setDisableLocalPushFocusToken(boolean r1) {
        this.localPushFocusTokenDisable = r1;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void setEnableCheckers(List<Function<TreeNode, Boolean>> r2) {
        this.enableCheckers = r2;
        if (this.workspace.w() == false) goto L6;
        this.workspace.n = r2;
        return;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void setEnableSwipeCheckers(List<Function<TreeNode, Boolean>> r2) {
        this.enableSwipeCheckers = r2;
        if (this.workspace.w() == false) goto L6;
        this.workspace.o = r2;
        return;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void setFavoriteEnable(boolean r1) {
        this.favoriteEnable = r1;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void setLocalPushEnable(boolean r1) {
        this.localPushEnable = r1;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void setSingleNodeFilters(List<Function<j, Boolean>> r1) {
        this.singleNodeFilters = r1;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void setTagSuffix(String r3) {
        this.tagSuffix = r3;
        this.mTAG = "Wiki_WikiTreeModel@" + r3;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void setUserComponentAbility(ce5.a r4) {
        this.userComponentAbility = r4;
        this.netService = r4.c;
        this.isSidebarEnable = qc5.a.g(r4);
        Intrinsics.checkNotNullParameter(r4, "userComponentAbility");
        boolean r0 = ex4.a.a(r4.d);
        tt5.a.h("SpaceFeatureGatingV2", "isSidebarSynergyEnable()...enable = " + r0);
        this.isSidebarSynergyEnable = r0;
        this.isWikiSupportSharedEnable = qc5.a.m(r4);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void setViewConfig(WikiTreeCtrlView.c r1) {
        this.viewConfig = r1;
    }

    public void unRegisterChainPush(String r5) {
        boolean r0 = this.workspace.w();
        tt5.a.h(this.mTAG, "WikiTreeModel.unRegisterChainPush. valid=" + r0);
        if (r0 == false) goto L11;
        cr5.a r1 = this.chainPushManager;
        tt5.a.h(r1.a, "unRegisterChainPush, spaceId=" + r5);
        if (r5 == null) goto L12;
        cr5.d r2 = r1.c.get(r5);
        if (r2 == null) goto L9;
        r2.a();
    L9:
        cr5.d r6 = r1.c.remove(r5);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void unfavorite(final String r6) {
        tt5.a.h(this.mTAG, String.format("WikiTreeModel.unfavorite, wikiToken: %s", new Object[]{yu5.c.j(r6)}));
        if (this.workspace.x(r6) == true) goto L6;
        tt5.a.k(this.mTAG, "WikiTreeModel.unfavorite, node not found. ");
        return;
    L6:
        this.disposables.add(new UnfavoritePuller(this.netService).c(new UnfavoritePuller.Params(i.b(this.workspace, r6, this.userComponentAbility), r6)).map(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.z()).map(new f1(this, r6)).observeOn(fo5.d.d()).doOnSubscribe(new g1(this)).subscribe(new h1(this, r6), new i1(this)));
    }

    public void updateToken(com.bytedance.ee.bear.wikiv2.wikitreev2.h r7) {
        String r0 = r7.b;
        TreeNode r1 = r7.c;
        boolean r2 = this.workspace.x(r0);
        tt5.a.h(this.mTAG, "WikiTreeModel.updateToken, fakeToken: " + yu5.c.j(r0) + ", wikiToken: " + yu5.c.j(r1.wiki_token) + ", newTitle: " + yu5.c.j(r1.title) + ", hasNode: " + r2);
        if (r2 == false) goto L13;
        String r3 = r1.parent_wiki_token;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r3, "parentToken");
        Intrinsics.checkNotNullParameter(r0, "fakeToken");
        Intrinsics.checkNotNullParameter(r1, "newTreeNode");
        tt5.a.h("Wiki_WikiTreeRepository", "updateNodeToken start. ");
        TreeNode r4 = this.workspace.m(r0);
        if (r4 == null) goto L7;
        r4.title = r1.title;
        r4.origin_wiki_token = r1.origin_wiki_token;
        r4.wiki_token = r1.wiki_token;
        r4.obj_token = r1.obj_token;
        r4.sort_id = r1.sort_id;
    L8:
        e3 r5 = this.workspace;
        if (r4 != null) goto L11;
        r4 = r1;
    L11:
        r5.L(r3, r4, r0);
        Flowable.fromCallable(new r2(r1, r0, this, r3)).subscribeOn(fo5.d.f()).subscribe(Functions.emptyConsumer(), up5.e.a);
        this.workspace.F(r1.wiki_token, true);
        WikiAction r6 = WikiAction.PUSH_TOKEN;
        d3 r8 = provideUiList();
        int r9 = h.c;
        g r10 = h.a.c(r6, r8);
        String r11 = r7.b;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r10.v = r11;
        String r12 = r7.c.wiki_token;
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r10.j = r12;
        this.wikiList.postValue(r10);
        return;
    L7:
        r4 = null;
        goto L8
    }

    private void handleUpdateWikiHomePageTitleInternal(UdeV3 r14, TreeNode r15) {
        e3 r0 = this.workspace;
        String r16 = r14.spaceId;
        ce5.a r1 = this.userComponentAbility;
        int r2 = i.a;
        String r17 = i.a.b(r0, r16, r1);
        a3 r3 = a3.a;
        String r6 = r15.wiki_token;
        String r7 = r15.title;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r17, "spaceId");
        boolean r4 = true;
        if (r6 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == false) goto L37;
    L22:
        String r8 = i.a(this.workspace);
        if (TextUtils.equals(this.workspace.o(), r17) == false) goto L25;
    L28:
        if (r4 == false) goto L39;
        SpaceInfo r18 = this.workspace.j;
        if (r18 == null) goto L40;
        WikiHomePageV2 r9 = r18.homePageV2;
        if (r9 != null) goto L34;
        return;
    L34:
        if (TextUtils.equals(r9.wikiToken, r15.wiki_token) == false) goto L42;
        r18.homePageV2.title = r15.title;
        return;
    L42:
        return;
    L40:
        return;
    L39:
        return;
    L25:
        if (TextUtils.equals(r8, r17) == true) goto L28;
        r4 = false;
        goto L28
    L37:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L13
        WikiDatabase r11 = WikiDatabase.c();     // Catch: Throwable -> L13
        Ref.BooleanRef r12 = new Ref.BooleanRef();     // Catch: Throwable -> L13
        r11.runInTransaction(new c3(r11, r17, r6, r7, r12));     // Catch: Throwable -> L13
        boolean r13 = r12.element;     // Catch: Throwable -> L13
        tt5.a.h("WikiTreeSpaceInfoDataManager", "updateHomePageTitleIfMatch " + r12.element + ", spaceId=" + r17);     // Catch: Throwable -> L13
        Object r19 = Result.constructor-impl(Boolean.valueOf(r13));     // Catch: Throwable -> L13
    L15:
        Throwable r20 = Result.exceptionOrNull-impl(r19);
        if (r20 == null) goto L18;
        tt5.a.e("WikiTreeSpaceInfoDataManager", "updateHomePageTitleIfMatch fail, spaceId=".concat(r17), r20, false);
    L18:
        Boolean r21 = Boolean.FALSE;
        if (Result.isFailure-impl(r19) == false) goto L21;
        r19 = r21;
    L21:
        ((Boolean) r19).booleanValue();
    L13:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L5:
        if (r6.length() == 0) goto L8;
        r5 = false;
        goto L9
    }

    private /* synthetic */ Publisher lambda$expand$4(final String r1, Boolean r2) throws Exception {
        return fromCallable(new w(this, r1));
    }

    private void lambda$expand$5(String r2, wwc.c r3) throws Exception {
        d r4 = h.b(WikiAction.EXPAND);
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r4.b = r2;
        this.wikiList.setValue(r4);
    }

    private void lambda$expandSpace$10(String r2, wwc.c r3) throws Exception {
        d r4 = h.b(WikiAction.EXPAND);
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r4.b = r2;
        this.wikiList.setValue(r4);
    }

    private /* synthetic */ Publisher lambda$expandSpace$9(final String r1, Boolean r2) throws Exception {
        return fromCallable(new s(this, r1));
    }

    private /* synthetic */ Boolean lambda$favorite$25(String r1, Boolean r2) throws Exception {
        t1.f(this, r1);
        return r2;
    }

    private void lambda$favorite$27(String r3, Boolean r4) throws Exception {
        String r5 = this.workspace.a;
        if (hu5.a.c(this.workspace.i(r5)) != 1) goto L6;
        this.workspace.F(r5, true);
    L6:
        if (this.workspace.u() == false) goto L8;
        WikiAction r6 = WikiAction.FAVORITE;
        d3 r0 = provideUiList();
        int r1 = h.c;
        g r7 = h.a.c(r6, r0);
    L9:
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r7.q = r3;
        this.wikiList.setValue(r7);
        return;
    L8:
        WikiAction r8 = WikiAction.FAVORITE;
        int r2 = h.c;
        r7 = h.a.c(r8, null);
        goto L9
    }

    private void lambda$loadInternal$0(WikiAction r2, wwc.c r3) throws Exception {
        MutableLiveData<h> r4 = this.wikiList;
        int r0 = h.c;
        r4.setValue(h.a.b(r2));
    }

    private /* synthetic */ TreeNode lambda$makeCopyTo$42(String r3, TreeNode r4) throws Exception {
        t1.b(this, r3, r4, false, "");
        return r4;
    }

    private void lambda$makeCopyTo$43(String r4, TreeNode r5) throws Exception {
        tt5.a.h(this.mTAG, "WikiTreeModel.makeCopyTo, addNode success.");
        WikiAction r0 = WikiAction.MAKE_COPY;
        d3 r1 = provideUiList();
        int r2 = h.c;
        g r3 = h.a.c(r0, r1);
        String r6 = r5.wiki_token;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r3.g = r6;
        r3.d(r5.space_id);
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r3.o = r4;
        String r7 = r5.obj_token;
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r3.t = r7;
        r3.u = r5.obj_type;
        this.wikiList.setValue(r3);
    }

    private void lambda$moveTo$22(int r1, wwc.c r2) throws Exception {
        d r3 = h.b(WikiAction.MOV);
        r3.d = r1;
        this.wikiList.setValue(r3);
    }

    private void lambda$moveTo$24(int r4, Throwable r5) throws Exception {
        tt5.a.e(this.mTAG, "WikiTreeModel.moveTo, moveTo fail. ", r5, false);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.a r6 = h.a(WikiAction.MOV, r5);
        r6.e = r4;
        this.wikiList.setValue(r6);
    }

    private /* synthetic */ Boolean lambda$removeFromWiki$49(String r2, List r3) throws Exception {
        this.workspace.B(r2, r3);
        return Boolean.TRUE;
    }

    private void lambda$removeFromWiki$50(TreeNode r2, Boolean r3) throws Exception {
        g r4 = h.c(WikiAction.PUSH_DEL, provideUiList());
        r4.f = r2.space_id;
        this.wikiList.setValue(r4);
    }

    private /* synthetic */ WikNodePerm lambda$requestNodePerm$47(TreeNode r2, WikNodePerm r3) throws Exception {
        r3.can_create = r3.getOriginCanCreate(r2.isShortcut());
        if (r3.can_star == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        r3.can_star = r0;
        r2.perm = r3;
        return r3;
    L5:
        if (isSameSpace(r2.space_id) == false) goto L7;
        r0 = true;
        goto L8
    }

    private static /* synthetic */ Publisher lambda$requestNodePerm$48(TreeNode r1, Throwable r2) throws Exception {
        if (tp5.b.b(r2, 920004012) == false) goto L7;
        WikNodePerm r3 = WikNodePerm.defaulted();
        r1.perm = r3;
        return Flowable.just(r3);
    L7:
        return Flowable.error(r2);
    }

    private /* synthetic */ TreeNode lambda$shortcutTo$39(String r3, TreeNode r4) throws Exception {
        t1.b(this, r3, r4, false, "");
        return r4;
    }

    private void lambda$shortcutTo$40(String r4, TreeNode r5) throws Exception {
        tt5.a.h(this.mTAG, "WikiTreeModel.shortcutTo, addNode success.");
        WikiAction r0 = WikiAction.SHORTCUT;
        d3 r1 = provideUiList();
        int r2 = h.c;
        g r3 = h.a.c(r0, r1);
        String r6 = r5.wiki_token;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r3.m = r6;
        r3.d(r5.space_id);
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r3.o = r4;
        this.wikiList.setValue(r3);
    }

    private /* synthetic */ Boolean lambda$unfavorite$29(String r1, Boolean r2) throws Exception {
        t1.m(this, r1);
        return r2;
    }

    private void lambda$unfavorite$31(String r3, Boolean r4) throws Exception {
        int r5 = hu5.a.c(this.workspace.i(this.workspace.a));
        if (this.workspace.u() == true) goto L7;
        if (r5 == 0) goto L7;
        WikiAction r6 = WikiAction.UNFAVORITE;
        int r0 = h.c;
        g r7 = h.a.c(r6, null);
    L8:
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r7.r = r3;
        this.wikiList.setValue(r7);
        return;
    L7:
        WikiAction r8 = WikiAction.UNFAVORITE;
        d3 r1 = provideUiList();
        int r2 = h.c;
        r7 = h.a.c(r8, r1);
        goto L8
    }

    public static b newInstance(ViewModelStoreOwner r2, ce5.a r3) {
        b r4 = new ViewModelProvider(r2, new ViewModelProvider.NewInstanceFactory()).get(WikiTreeModel.class);
        r4.setUserComponentAbility(r3);
        return r4;
    }

    private Pair<TreeNode, Throwable> reverseGetNode(String r6, String r7) {
        TreeNode r0 = null;
        e3 r1 = this.workspace;     // Catch: Exception -> L5
        ce5.a r2 = this.userComponentAbility;     // Catch: Exception -> L5
        int r3 = i.a;     // Catch: Exception -> L5
        r0 = (TreeNode) new GetNodePuller(this.netService).d(new GetNodePuller.Params(i.a.b(r1, r6, r2), r7)).blockingSingle();     // Catch: Exception -> L5
        e = null;
    L8:
        return new Pair(r0, e);
    L5:
        e = e;
        tt5.a.e(this.mTAG, "WikiTreeModel.reverseGetNode, pull node fail. ", e, false);
        goto L8
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void delete(final String r6, final String r7) {
        tt5.a.h(this.mTAG, String.format("WikiTreeModel.delete, wikiToken: %s", new Object[]{yu5.c.j(r7)}));
        if (this.workspace.x(r7) == true) goto L6;
        tt5.a.k(this.mTAG, "WikiTreeModel.delete, node not found. ");
        return;
    L6:
        final TreeNode r0 = this.workspace.m(r7);
        CompositeDisposable r1 = this.disposables;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r6, "spaceId");
        Intrinsics.checkNotNullParameter(r7, WikiFolderPushPlugin.WIKI_TOKEN);
        r1.add(new DelNodePuller(this.netService).d(new DelNodePuller.Params(r6, r7, getChainPushUuid(r6))).observeOn(fo5.d.e()).map(new c2(this, r6, r7)).observeOn(fo5.d.d()).doOnSubscribe(new t(this)).subscribe(new u(this, r6, r7, r0), new v(this, r6, r7, r0)));
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void deleteCurrentOnly(final String r6, final String r7) {
        tt5.a.h(this.mTAG, String.format("WikiTreeModel.deleteCurrentOnly, wikiToken: %s", new Object[]{yu5.c.j(r7)}));
        if (this.workspace.x(r7) == true) goto L6;
        tt5.a.k(this.mTAG, "WikiTreeModel.deleteCurrentOnly, node not found. ");
        return;
    L6:
        final TreeNode r0 = this.workspace.m(r7);
        CompositeDisposable r1 = this.disposables;
        NetService r2 = this.netService;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r6, "spaceId");
        Intrinsics.checkNotNullParameter(r7, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r2, "netService");
        r1.add(new DelSingleNodePuller(r2).c(new DelSingleNodePuller.Params(r6, r7, getChainPushUuid(r6))).map(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.a0()).flatMap(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.k0(r2)).observeOn(fo5.d.e()).map(new d2(this, r6, r7)).observeOn(fo5.d.d()).doOnSubscribe(new c1(this)).subscribe(new d1(this, r6, r7, r0), new e1(this, r6, r7, r0)));
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public Flowable<GetMoveNodeAuthorizedUserInfoPuller.Result> getMoveNodeAuthorizedUserInfo(String r3, String r4) {
        return new GetMoveNodeAuthorizedUserInfoPuller(this.netService).d(new GetMoveNodeAuthorizedUserInfoPuller.Params(r3, r4));
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public boolean isContainInParent(String r2, String r3) {
        return this.workspace.t(r2, r3);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public Flowable<MoveToSpacePuller.Result> moveToSpace(String r3, String r4) {
        return new MoveToSpacePuller(this.netService).d(new MoveToSpacePuller.Params(r3, getChainPushUuid(r4)));
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void removeFromWiki(String r5, final String r6) {
        tt5.a.k(this.mTAG, String.format("WikiTreeModel.removeFromWiki, wikiToken: %s", new Object[]{yu5.c.j(r6)}));
        if (this.workspace.x(r6) == true) goto L6;
        tt5.a.k(this.mTAG, "WikiTreeModel.removeFromWiki, node not found. ");
        return;
    L6:
        final TreeNode r0 = this.workspace.m(r6);
        if (TextUtils.equals(r0.parent_wiki_token, r5) == true) goto L10;
        tt5.a.k(this.mTAG, "WikiTreeModel.removeFromWiki, parent not the same. ");
        return;
    L10:
        Flowable r7 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.l0.a(this.netService).a(new GetChildPuller.Params(r0.space_id, r0.parent_wiki_token)).map(new z0(this, r6));
        a r8 = new a(this, r0);
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "consumer");
        this.disposables.add(r7.map(new up5.f(r8)).subscribe(new a1(this, r0), new b1(this)));
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void rename(final String r11, final String r12) {
        tt5.a.h(this.mTAG, String.format("WikiTreeModel.rename, wikiToken: %s", new Object[]{yu5.c.j(r11)}));
        TreeNode r0 = this.workspace.m(r11);
        if (r0 != null) goto L7;
        tt5.a.k(this.mTAG, "WikiTreeModel.rename, node not found. ");
        return;
    L7:
        if (bx4.b.b(r11) == false) goto L10;
        tt5.a.h(this.mTAG, "WikiTreeModel.rename fake document, success");
        updateTitleAndIcon(r11, r12, this.workspace.m(r11).iconInfo);
        return;
    L10:
        this.disposables.add(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.l0.f(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.q(r12, r11, r0.obj_token, Integer.valueOf(r0.obj_type), r0.isShortcut(), this.netService)).subscribe(new e0(this, r11, r12), new f0(this)));
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public Flowable<WikNodePerm> requestNodePerm(String r5, String r6) {
        tt5.a.h(this.mTAG, String.format("WikiTreeModel.getNodePerm, wikiToken: %s", new Object[]{yu5.c.j(r6)}));
        final TreeNode r0 = this.workspace.m(r6);
        if (r0 != null) goto L7;
        return Flowable.error(new Throwable("node not found. "));
    L7:
        return new GetNodePermPuller(this.netService).d(new GetNodePermPuller.Params(r5, r6)).observeOn(fo5.d.d()).map(new x(this, r0)).onErrorResumeNext(new y(r0));
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void setFocus(String r1, String r2) {
        this.focusToken = r1;
        this.focusUid = r2;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void updatePinStatus(String r2, boolean r3) {
        this.workspace.H(r2, r3);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void updateStarStatus(String r2, boolean r3) {
        this.workspace.G(r2, r3);
    }

    private void lambda$expand$6(String r2, AtomicReference r3, Boolean r4) throws Exception {
        if (r4.booleanValue() == true) goto L5;
        return;
    L5:
        g r5 = h.c(WikiAction.EXPAND, provideUiList());
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r5.b = r2;
        this.wikiList.setValue(r5);
        r3.set(Boolean.TRUE);
    }

    private void lambda$expand$7(AtomicReference r4, String r5, Throwable r6) throws Exception {
        tt5.a.e(this.mTAG, "WikiTreeModel.expand, expand fail. ", r6, false);
        if (((Boolean) r4.get()).booleanValue() == true) goto L6;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.a r7 = h.a(WikiAction.EXPAND, r6);
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r7.b = r5;
        this.wikiList.setValue(r7);
        return;
    }

    private void lambda$expandSpace$11(String r2, AtomicReference r3, Boolean r4) throws Exception {
        if (r4.booleanValue() == true) goto L5;
        return;
    L5:
        g r5 = h.c(WikiAction.EXPAND, provideUiList());
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r5.b = r2;
        this.wikiList.setValue(r5);
        r3.set(Boolean.TRUE);
    }

    private void lambda$expandSpace$12(AtomicReference r4, String r5, Throwable r6) throws Exception {
        tt5.a.e(this.mTAG, "WikiTreeModel.expandSpace, expand fail. ", r6, false);
        if (((Boolean) r4.get()).booleanValue() == true) goto L6;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.a r7 = h.a(WikiAction.EXPAND, r6);
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r7.b = r5;
        this.wikiList.setValue(r7);
        return;
    }

    private void lambda$insert$14(TreeNode r4, IOperationInsert.TreeNodeInsertParams r5, String r6) throws Exception {
        WikiAction r0 = WikiAction.ADD;
        d3 r1 = provideUiList();
        int r2 = h.c;
        g r3 = h.a.c(r0, r1);
        r3.f = r4.getSpaceId();
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r3.g = r6;
        String r7 = this.workspace.p(r6, r5.uid);
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r3.b = r7;
        this.wikiList.setValue(r3);
    }

    private static PinPuller$Result lambda$pin$33(String r3, String r4, PinPuller$Result r5) throws Exception {
        WikiTreeObserver.d.e(new com.bytedance.ee.bear.wikiv2.wikitreev2.d(r3, r4, true));
        return r5;
    }

    private /* synthetic */ void lambda$rename$45(String r2, String r3, Boolean r4) throws Exception {
        tt5.a.h(this.mTAG, "WikiTreeModel.rename, success");
        updateTitleAndIcon(r2, r3, this.workspace.m(r2).iconInfo);
    }

    private static UnPinPuller.Result lambda$unPin$36(String r3, String r4, UnPinPuller.Result r5) throws Exception {
        WikiTreeObserver.d.e(new com.bytedance.ee.bear.wikiv2.wikitreev2.d(r3, r4, false));
        return r5;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void pin(final String r6, final String r7, int r8) {
        tt5.a.h(this.mTAG, String.format("WikiTreeModel.pin, wikiToken: %s", new Object[]{yu5.c.j(r7)}) + ", type: " + r8);
        this.disposables.add(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.l0.d(new PinPuller$Params(r7, r8), this.netService).map(new k1(r6, r7)).observeOn(fo5.d.d()).subscribe(new l1(this), new m1(this)));
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void unPin(final String r6, final String r7, int r8) {
        tt5.a.h(this.mTAG, String.format("WikiTreeModel.unPin, wikiToken: %s", new Object[]{yu5.c.j(r7)}) + ", type: " + r8);
        this.disposables.add(new UnPinPuller(this.netService).c(new UnPinPuller.Params(r7, r8)).map(new o0(r6, r7)).observeOn(fo5.d.d()).subscribe(new p0(this), new q0(this)));
    }

    public void updateTitleAndIcon(String r8, String r9, String r10) {
        tt5.a.h(this.mTAG, String.format("WikiTreeModel.updateTitle, wikiToken: %s, newTitle: %s ,newIconInfo: %s", new Object[]{yu5.c.j(r8), yu5.c.j(r9), yu5.c.j(r10)}));
        if (this.workspace.x(r8) == false) goto L6;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r8, WikiFolderPushPlugin.WIKI_TOKEN);
        TreeNode r3 = this.workspace.m(r8);
        r3.title = r9;
        r3.iconInfo = r10;
        Flowable.fromCallable(new q2(this, r3, r8, r9, r10)).subscribeOn(fo5.d.f()).subscribe(Functions.emptyConsumer(), up5.e.a);
        g r11 = h.c(WikiAction.PUSH_UDE_NAME_ICON, provideUiList());
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r11.j = r8;
        this.wikiList.postValue(r11);
        return;
    }

    private void lambda$delete$20(String r4, String r5, TreeNode r6, String r7) throws Exception {
        WikiAction r0 = WikiAction.DEL;
        d3 r1 = provideUiList();
        int r2 = h.c;
        g r3 = h.a.c(r0, r1);
        r3.f = r4;
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r3.i = r7;
        this.wikiList.setValue(r3);
        if (this.isSidebarEnable == false) goto L5;
        WikiTreeObserver.a().e(new com.bytedance.ee.bear.wikiv2.wikitreev2.a(r5));
    L5:
        ((com.bytedance.ee.bear.contract.c0) org.koin.java.a.a(com.bytedance.ee.bear.contract.c0.class)).f0(r6.obj_token, r5);
        jw4.a.g("delete", Integer.valueOf(r6.obj_type));
    }

    private void lambda$delete$21(String r4, String r5, TreeNode r6, Throwable r7) throws Exception {
        tt5.a.e(this.mTAG, "WikiTreeModel.delete, delete fail. ", r7, false);
        if (tp5.b.a(r7) == 233525003) goto L5;
    L8:
        this.wikiList.setValue(h.a(WikiAction.DEL, r7));
        jw4.a.h("delete", r7, Integer.valueOf(r6.obj_type));
        return;
    L5:
        if ((r7 instanceof NetService.ServerErrorException) == false) goto L8;
        JSONObject r1 = new JSONObject(((NetService.ServerErrorException) r7).getData());     // Catch: JSONException -> L10
        r1.put("isDeleteWithSub", true);     // Catch: JSONException -> L10
        r1.put("spaceId", r4);     // Catch: JSONException -> L10
        r1.put(ResourceData.KEY_TOKEN, r5);     // Catch: JSONException -> L10
        ((NetService.ServerErrorException) r7).setData(r1.toString());     // Catch: JSONException -> L10
        goto L8
    }

    private void lambda$deleteCurrentOnly$17(String r4, String r5, TreeNode r6, String r7) throws Exception {
        WikiAction r0 = WikiAction.DEL;
        d3 r1 = provideUiList();
        int r2 = h.c;
        g r3 = h.a.c(r0, r1);
        r3.f = r4;
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r3.i = r7;
        this.wikiList.setValue(r3);
        if (this.isSidebarEnable == false) goto L5;
        WikiTreeObserver.a().e(new com.bytedance.ee.bear.wikiv2.wikitreev2.a(r5));
    L5:
        ((com.bytedance.ee.bear.contract.c0) org.koin.java.a.a(com.bytedance.ee.bear.contract.c0.class)).f0(r6.obj_token, r5);
        jw4.a.g("delete", Integer.valueOf(r6.obj_type));
    }

    private void lambda$deleteCurrentOnly$18(String r4, String r5, TreeNode r6, Throwable r7) throws Exception {
        tt5.a.e(this.mTAG, "WikiTreeModel.deleteCurrentOnly, delete fail. ", r7, false);
        if ((r7 instanceof NetService.ServerErrorException) == true) goto L9;
    L6:
        this.wikiList.setValue(h.a(WikiAction.DEL_CURRENT_ONLY, r7));
        jw4.a.h("delete", r7, Integer.valueOf(r6.obj_type));
        return;
    L9:
        JSONObject r1 = new JSONObject(((NetService.ServerErrorException) r7).getData());     // Catch: JSONException -> L8
        r1.put("isDeleteWithSub", false);     // Catch: JSONException -> L8
        r1.put("spaceId", r4);     // Catch: JSONException -> L8
        r1.put(ResourceData.KEY_TOKEN, r5);     // Catch: JSONException -> L8
        ((NetService.ServerErrorException) r7).setData(r1.toString());     // Catch: JSONException -> L8
        goto L6
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void load(String r10, String r11, String r12, boolean r13) {
        tt5.a.h(this.mTAG, String.format("WikiTreeModel.load, spaceId: %s, wikiToken: %s", new Object[]{yu5.c.j(r10), yu5.c.j(r11)}));
        long r7 = this.loadSequence.incrementAndGet();
        WikiTreeCtrlView.c r0 = this.viewConfig;
        ar5.a r1 = r0.t;
        r0.t = null;
        if (r1 != null) goto L5;
    L7:
        ar5.a r6 = r1;
    L8:
        if (r6 == null) goto L10;
    L12:
        loadInternal(r10, r11, r13, WikiAction.INIT_LOAD, r6, r7);
        return;
    L10:
        if (this.workspace.x(r11) == false) goto L12;
        this.workspace.D(r11, r12, r13);
        g r14 = h.c(WikiAction.INIT_LOAD, provideUiList());
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r14.e = r11;
        this.wikiList.setValue(r14);
        return;
    L5:
        if (TextUtils.equals(r1.c, r11) == true) goto L7;
        r6 = null;
        goto L8
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void makeCopyTo(String r5, final String r6, final String r7, TreeNode r8) {
        tt5.a.k(this.mTAG, String.format("WikiTreeModel.makeCopyTo, srcToken: %s, destSpaceName: %s", new Object[]{yu5.c.j(r5), yu5.c.j(r7)}));
        if (this.workspace.x(r5) == true) goto L6;
        tt5.a.k(this.mTAG, "WikiTreeModel.makeCopyTo, node not found. ");
        return;
    L6:
        this.disposables.add(Flowable.just(r8).observeOn(fo5.d.b()).map(new j1(this, r6)).observeOn(fo5.d.d()).subscribe(new n1(this, r7), new o1(this)));
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void shortcutTo(String r5, final String r6, final String r7, TreeNode r8) {
        tt5.a.k(this.mTAG, String.format("WikiTreeModel.shortcutTo, srcToken: %s, destParentToken: %s", new Object[]{yu5.c.j(r5), yu5.c.j(r6)}));
        if (this.workspace.x(r5) == true) goto L6;
        tt5.a.k(this.mTAG, "WikiTreeModel.shortcutTo, node not found. ");
        return;
    L6:
        this.disposables.add(Flowable.just(r8).observeOn(fo5.d.b()).map(new k0(this, r6)).observeOn(fo5.d.d()).subscribe(new l0(this, r7), new m0(this)));
    }

    private void lambda$loadInternal$2(boolean r3, long r4, WikiAction r6, AtomicReference r7, Throwable r8) throws Exception {
        if (r3 == true) goto L4;
    L6:
        tt5.a.e(this.mTAG, "WikiTreeModel.loadInternal, load fail, action: " + r6.name() + ", showing: " + r7.get(), r8, false);
        if (((Boolean) r7.get()).booleanValue() == true) goto L9;
    L10:
        MutableLiveData<h> r5 = this.wikiList;
        int r9 = h.c;
        r5.setValue(h.a.a(r6, r8));
        return;
    L9:
        if ((r8 instanceof NetService.ServerErrorException) == true) goto L10;
        return;
    L4:
        if (r4 == this.loadSequence.get()) goto L6;
    }

    private void lambda$moveTo$23(String r3, String r4, boolean r5, int r6, Boolean r7) throws Exception {
        WikiAction r8 = WikiAction.MOV;
        d3 r0 = provideUiList();
        int r1 = h.c;
        g r9 = h.a.c(r8, r0);
        String r2 = this.workspace.l(this.focusToken);
        setFocus(this.focusToken, r2);
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r9.k = r3;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r9.n = r4;
        String r10 = this.focusToken;
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r9.p = r10;
        r9.s = r5;
        r9.w = r6;
        this.wikiList.setValue(r9);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void load(e3 r5, String r6, String r7, boolean r8, boolean r9) {
        tt5.a.h(this.mTAG, String.format("WikiTreeModel.load, workspace: %s, wikiToken: %s", new Object[]{yu5.c.j(i.a(r5)), yu5.c.j(r6)}));
        this.loadSequence.incrementAndGet();
        if (isSameSpace(i.a(r5)) == true) goto L5;
        unRegisterPush();
    L5:
        this.workspace = r5;
        this.workspace.m = this.dataFilter;
        this.workspace.n = this.enableCheckers;
        this.workspace.o = this.enableSwipeCheckers;
        this.needExpandAfterInit = r9;
        if (TextUtils.isEmpty(r6) == true) goto L8;
    L12:
        if (r9 == false) goto L14;
        this.workspace.D(r6, r7, r8);
    L14:
        WikiAction r10 = WikiAction.INIT_LOAD;
        d3 r11 = provideUiList();
        int r12 = h.c;
        g r13 = h.a.c(r10, r11);
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r13.e = r6;
        this.wikiList.setValue(r13);
        registerPush();
        return;
    L8:
        if (TextUtils.isEmpty(r5.b) == true) goto L10;
        String r14 = r5.b;
    L11:
        r6 = r14;
        goto L12
    L10:
        r14 = "";
        goto L11
    }

    private void loadInternal(String r17, String r18, final boolean r19, final WikiAction r20, ar5.a r21, final long r22) {
        if (r21 == null) goto L5;
    L8:
        boolean r11 = true;
    L10:
        if (isSameSpace(r17) == true) goto L13;
        unRegisterPush();
    L13:
        if (r18 != null) goto L15;
        String r3 = "";
    L16:
        final AtomicReference r6 = new AtomicReference(r3);
        final AtomicReference r12 = new AtomicReference(Boolean.FALSE);
        final AtomicReference r5 = new AtomicReference("");
        if (r21 == null) goto L22;
        String r2 = (String) r6.get();
        ce5.a r4 = this.userComponentAbility;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r17, "spaceId");
        Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r21, "context");
        Intrinsics.checkNotNullParameter(r4, "userComponentAbility");
        GetRelationPuller.Params r7 = new GetRelationPuller.Params(r17, r2);
        getViewConfig().getClass();
        r7.setPathResolve(r21.a, Integer.valueOf(r21.b));
        NetService r8 = this.netService;
        if (TextUtils.isEmpty(r7.wiki_token) == false) goto L21;
        r7.wiki_token = null;
    L21:
        Flowable r0 = Flowable.zip(new GetRelationPuller(r8).c(r7).flatMap(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.i0()), com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.l0.b(this.netService).a(new GetRootPermPuller.Params(r21.a)), l2.a).flatMap(new n2(this, r21)).map(new o2(r21, r4)).onErrorReturn(p2.a).flatMap(new k2(this, r17, r2, r4));
    L23:
        final boolean r9 = r11;
        this.disposables.add(r0.observeOn(fo5.d.d()).doOnSubscribe(new v0(this, r20)).subscribe(new w0(this, r9, r22, r5, r6, r19, r20, r12), new x0(this, r9, r22, r20, r12)));
        return;
    L22:
        r0 = t1.k(this, r17, (String) r6.get(), this.userComponentAbility).map(new u0());
        goto L23
    L15:
        r3 = r18;
        goto L16
    L5:
        if (yp5.c.h() == true) goto L8;
        r11 = false;
        goto L10
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void moveTo(final String r18, final String r19, String r20, final boolean r21, String r22, final int r23) {
        TreeNode r0 = this.workspace.m(r18);
        if (r0 != null) goto L6;
        tt5.a.k(this.mTAG, "WikiTreeModel.moveTo, node not found. ");
        return;
    L6:
        boolean r1 = TextUtils.equals(r0.space_id, r19);
        tt5.a.h(this.mTAG, String.format("WikiTreeModel.moveTo, srcToken: %s, destSpaceId: %s, destParentToken: %s, forceExpand: %s, isSameSpace: %s", new Object[]{yu5.c.j(r18), yu5.c.j(r19), yu5.c.j(r20), Boolean.valueOf(r21), Boolean.valueOf(r1)}));
        CompositeDisposable r14 = this.disposables;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r18, "srcToken");
        Intrinsics.checkNotNullParameter(r19, "destSpaceId");
        Intrinsics.checkNotNullParameter(r20, "destParentToken");
        TreeNode r2 = this.workspace.m(r18);
        String r8 = r2.space_id;
        String r9 = r2.parent_wiki_token;
        r14.add(new MoveNodePuller(this.netService).d(new MoveNodePuller.Params(r8, r9, r19, r20, r18, getChainPushUuid(r8))).observeOn(fo5.d.e()).map(new e2(TextUtils.equals(r8, r19), this, r8, r18, r19, r9, r20, r21, r22)).observeOn(fo5.d.d()).doOnSubscribe(new p1(this, r23)).subscribe(new q1(this, r18, r19, r21, r23), new r1(this, r23)));
    }

    private void lambda$loadInternal$1(boolean r3, long r4, AtomicReference r6, AtomicReference r7, boolean r8, WikiAction r9, AtomicReference r10, ar5.b r11) throws Exception {
        if (r3 == false) goto L7;
        if (r4 == this.loadSequence.get()) goto L7;
        return;
    L7:
        if ((r11 instanceof ar5.b.C0004b) == false) goto L9;
        ar5.b.C0004b r12 = (ar5.b.C0004b) r11;
        this.workspace = r12.a;
        r6.set(r12.c);
        boolean r5 = true;
    L10:
        if (r5 == true) goto L13;
        return;
    L13:
        if (TextUtils.isEmpty((CharSequence) r7.get()) == false) goto L19;
        e3 r13 = this.workspace;
        if (TextUtils.isEmpty(r13.b) == true) goto L17;
        String r14 = r13.b;
    L18:
        r7.set(r14);
        goto L19
    L17:
        r14 = "";
    L19:
        e3 r15 = this.workspace;
        r15.m = this.dataFilter;
        e3 r16 = this.workspace;
        r16.n = this.enableCheckers;
        e3 r17 = this.workspace;
        r17.o = this.enableSwipeCheckers;
        if (TextUtils.isEmpty((CharSequence) r6.get()) == false) goto L22;
        this.workspace.F((String) r7.get(), r8);
    L23:
        d3 r18 = provideUiList();
        int r19 = h.c;
        g r20 = h.a.c(r9, r18);
        String r21 = (String) r7.get();
        Intrinsics.checkNotNullParameter(r21, "<set-?>");
        r20.e = r21;
        this.wikiList.setValue(r20);
        r10.set(Boolean.TRUE);
        registerPush();
        return;
    L22:
        this.workspace.D((String) r7.get(), (String) r6.get(), r8);
        setFocus((String) r7.get(), (String) r6.get());
        goto L23
    L9:
        r5 = ((ar5.b.a) r11).a;
        goto L10
    }
}
