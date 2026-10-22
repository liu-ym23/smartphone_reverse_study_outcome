package com.bytedance.ee.bear.wikiv2.browser.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.BasePluginV2;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.s4;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.selector.SelectorScope;
import com.bytedance.ee.bear.list.selector.SelectorType;
import com.bytedance.ee.bear.list.t4;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.wikiv2.wikitreev2.WikiTreeObserver;
import com.bytedance.ee.bear.wikiv2.wikitreev2.panel.WikiTreePanelDialog;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiDetailInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.MoveSource;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiAction;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.e3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView;
import io.reactivex.disposables.CompositeDisposable;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0006\u0010\u0013\u001a\u00020\fJ\b\u0010\u0014\u001a\u00020\fH\u0002J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\"\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/browser/plugin/WikiMovePlugin;", "Lcom/bytedance/ee/bear/browser/plugin/BasePluginV2;", "Lcom/bytedance/ee/bear/facade/common/ActivityResultHandler;", "<init>", "()V", "wikiViewModel", "Lcom/bytedance/ee/bear/wikiv2/browser/plugin/WikiViewModel;", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "userComponentAbility", "Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "doMove", "treeSync", "onDetachFromHost", "onActivityResult", "requestCode", "", "resultCode", WikiFolderPushPlugin.DATA, "Landroid/content/Intent;", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiMovePlugin extends BasePluginV2 implements sa5.a {
    public static final a Companion = null;
    private static final String TAG = "WikiMovePlugin";
    private final CompositeDisposable disposables;
    private ce5.a userComponentAbility;
    private WikiViewModel wikiViewModel;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ WikiDialogs a;
        public final /* synthetic */ PluginHost b;
        public final /* synthetic */ WikiMovePlugin c;
        public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b d;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[WikiAction.values().length];
                r0[WikiAction.MOV.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
            L4:
                a = r0;
            }
        }

        public b(WikiDialogs r1, PluginHost r2, WikiMovePlugin r3, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void onChanged(Object r8) {
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h r9 = (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h) r8;
            if ((r9 instanceof com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.d) == false) goto L10;
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.d r10 = (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.d) r9;
            if (r10.d != MoveSource.FROM_DETAIL.getValue()) goto L7;
        L8:
            WikiDialogs r0 = this.a;
            Context r1 = this.b.getContext();
            Map<String, Integer> r2 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.a;
            r0.m(r1, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.e(r10.a));
            return;
        L7:
            if (r10.d == MoveSource.FROM_FOLDER_BLOCK.getValue()) goto L8;
            return;
        L10:
            if ((r9 instanceof com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.a) == false) goto L26;
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.a r11 = (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.a) r9;
            if (r11.e == MoveSource.FROM_DETAIL.getValue()) goto L16;
            if (r11.e == MoveSource.FROM_FOLDER_BLOCK.getValue()) goto L16;
            return;
        L16:
            if (com.bytedance.ee.bear.contract.k0.c(r11.d) == false) goto L19;
            return;
        L19:
            if (tp5.b.a(r11.d) != 900099011) goto L22;
            return;
        L22:
            if (tp5.b.a(r11.d) != 233525002) goto L24;
            this.a.i(tp5.b.a(r11.d), this.b.getContext());
            return;
        L24:
            WikiDialogs r3 = this.a;
            Context r4 = this.b.getContext();
            Map<String, Integer> r5 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.a;
            int r12 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.d(r11.a, r11.d);
            r3.getClass();
            WikiDialogs.j(r4, r12);
            return;
        L26:
            if ((r9 instanceof com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g) == false) goto L50;
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g r6 = (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g) r9;
            int r7 = r6.w;
            MoveSource r13 = MoveSource.FROM_DETAIL;
            if (r7 != r13.getValue()) goto L30;
        L31:
            this.a.d();
            WikiDialogs r14 = this.a;
            Context r15 = WikiMovePlugin.access$getContext(this.c);
            Map<String, Integer> r16 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.a;
            int r17 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.f(r6.a);
            r14.getClass();
            if (r15 == null) goto L37;
            if (r17 == (-1)) goto L37;
            Toast.showSuccessText(r15, r15.getResources().getString(r17), 0);
        L37:
            if (a.a[r6.a.ordinal()] != 1) goto L57;
            String r18 = r6.n;
            String r19 = r6.k;
            SpaceInfo r20 = this.d.getSpaceInfo();
            if (r20 == null) goto L42;
            String r21 = r20.space_id;
            if (r21 == null) goto L42;
        L44:
            if ((!TextUtils.equals(r18, r21)) == true) goto L46;
            return;
        L46:
            if (r6.w != r13.getValue()) goto L59;
            tt5.a.h(WikiMovePlugin.TAG, "crossWorkspace， jump to detail page");
            Serializable r22 = new WikiInfo();
            r22.setSpaceId(r6.n);
            r22.setWikiToken(r19);
            r22.setInSpace(false);
            r22.setObjToken(r6.t);
            r22.setObjType(r6.u);
            Bundle r23 = new Bundle();
            r23.putSerializable("wiki_info", r22);
            com.bytedance.ee.util.ui.j.d(new l0(r9, r19, r23, this.c), 500);
            return;
        L59:
            return;
        L42:
            r21 = "";
            goto L44
        L57:
            return;
        L30:
            if (r6.w == MoveSource.FROM_FOLDER_BLOCK.getValue()) goto L31;
            return;
        L50:
            throw new NoWhenBranchMatchedException();
        }
    }

    static {
        Companion = new a();
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void treeSync() {
        WikiViewModel r0 = this.wikiViewModel;
        if (r0 == null) goto L35;
        String r1 = r0.getSpaceId();
        WikiViewModel r2 = this.wikiViewModel;
        ce5.a r3 = null;
        if (r2 == null) goto L7;
        String r4 = r2.getWikiToken();
    L8:
        WikiViewModel r5 = this.wikiViewModel;
        if (r5 == null) goto L11;
        String r6 = r5.getUniqueUiId();
    L13:
        if (TextUtils.isEmpty(r1) == false) goto L15;
    L33:
        tt5.a.h(TAG, "invalid params, return. ");
        return;
    L15:
        if (TextUtils.isEmpty(r4) == true) goto L33;
        int r7 = WikiTreePanelDialog.w;
        ViewModelStoreOwner r8 = getHost();
        if (ForsetiHelper.s(r8.getHostFragment()) == true) goto L21;
        r8 = null;
    L21:
        if (r8 != null) goto L24;
        r8 = getActivity();
    L24:
        Intrinsics.checkNotNull(r8);
        ce5.a r9 = this.userComponentAbility;
        if (r9 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("userComponentAbility");
    L28:
        e3 r10 = WikiTreePanelDialog.a.a(r8, r3);
        g3.a.a.a(r10);
        StringBuilder r11 = new StringBuilder("activity destroy. treeSync, send tree changed. snapshot: ");
        if (r10 == null) goto L31;
        boolean r12 = true;
    L32:
        r11.append(r12);
        tt5.a.h(TAG, r11.toString());
        WikiTreeObserver.a.e(new com.bytedance.ee.bear.wikiv2.wikitreev2.f(String.valueOf(r1), String.valueOf(r4), r6));
        return;
    L31:
        r12 = false;
        goto L32
    L27:
        r3 = r9;
        goto L28
    L11:
        r6 = null;
        goto L13
    L7:
        r4 = null;
        goto L8
    }

    public final void doMove() {
        this.wikiViewModel = g1.a(getHost());
        if (ForsetiHelper.s(getHost().getHostFragment()) == false) goto L5;
        treeSync();
    L5:
        WikiViewModel r1 = this.wikiViewModel;
        String r2 = null;
        if (r1 == null) goto L8;
        TreeNode r3 = r1.getWikiMeta();
    L9:
        WikiViewModel r4 = this.wikiViewModel;
        if (r4 == null) goto L12;
        WikNodePerm r12 = r4.getWikiPerm();
    L13:
        if (r12 == null) goto L37;
        if (r3 == null) goto L37;
        s4 r5 = getHostAbilityOrNull(s4.class);
        if (r5 == null) goto L19;
        Fragment r6 = r5.getFragment();
    L20:
        Bundle r14 = new Bundle();
        r14.putInt("srcIsLock", r12.is_locked ? 1 : 0);
        r14.putString("src_space_id", r3.space_id);
        r14.putString("src_parent_token", r3.parent_wiki_token);
        r14.putString("src_token", r3.wiki_token);
        r14.putInt("src_obj_type", r3.obj_type);
        r14.putInt("EXTRA_PAGE_MODE", 2);
        r14.putString("trigger_location", "wiki_tree");
        r14.putBoolean("src_is_shortcut", r3.isShortcut());
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).setActivity(getHost().getActivity());
        qc5.a.j();
        if (r3.isShortcut() == true) goto L30;
        Context r7 = getContext();
        String r8 = r3.space_id;
        String r9 = r3.parent_wiki_token;
        String r10 = r3.wiki_token;
        boolean r11 = r3.has_child;
        String r13 = r3.title;
        WikiInfoPlugin r15 = getHost().findPlugin(WikiInfoPlugin.class);
        if (r15 == null) goto L25;
        boolean r16 = r15.isMyLib();
    L26:
        WikiDetailInfo r17 = r3.detail_info;
        if (r17 == null) goto L29;
        r2 = r17.owner_id;
    L29:
        com.bytedance.ee.bear.wikiv2.wikitreev2.main.o.d(new com.bytedance.ee.bear.wikiv2.wikitreev2.main.b(r6, r7, r8, r9, r10, r11, r13, r12, DocUserPermission.USER_PERM_FULL_ACCESS, r14, r16, t4.a(r2), r3.obj_token, r3.obj_type));
        return;
    L25:
        r16 = false;
        goto L26
    L30:
        SelectorConfig r18 = new SelectorConfig();
        r18.c(SelectorType.WIKI_MOVE_TO);
        r18.a(SelectorScope.WIKI_ONLY);
        r18.g = DocUserPermission.USER_PERM_FULL_ACCESS;
        r18.d = true;
        Context r19 = getContext();
        if (r19 == null) goto L34;
        String r20 = r19.getString(2131889814);
        if (r20 == null) goto L34;
    L35:
        Intrinsics.checkNotNullParameter(r20, "<set-?>");
        r18.b = r20;
        r14.putParcelable("extra_config", r18);
        com.bytedance.ee.bear.wikiv2.wikitreev2.main.o.f(r6, r14);
        gq5.d.j("move_to", r3.space_id);
        return;
    L34:
        r20 = "";
        goto L35
    L19:
        r6 = null;
    L37:
        tt5.a.h(TAG, "doMoveTo, perm or target not found. return. ");
        return;
    L12:
        r12 = null;
        goto L13
    L8:
        r3 = null;
        goto L9
    }

    public WikiMovePlugin() {
        this.disposables = new CompositeDisposable();
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(WikiMovePlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ Context access$getContext(WikiMovePlugin r0) {
        return r0.getContext();
    }

    public void onAttachToHost(PluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r3);
        tt5.a.h(TAG, "onAttachToHost. ");
        this.userComponentAbility = new ce5.a(r3.getUserComponent());
    }

    public void onDetachFromHost(PluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r2);
        this.disposables.clear();
    }

    public void onAttachToUIContainer(PluginHost r5, com.bytedance.ee.bear.browser.plugin.t r6) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r5, r6);
        if (r5 == null) goto L17;
        int r7 = WikiTreeCtrlView.q;
        ce5.a r0 = null;
        if (Boolean.valueOf(ForsetiHelper.s(r5.getHostFragment())).booleanValue() == false) goto L7;
        PluginHost r8 = r5;
    L8:
        if (r8 != null) goto L11;
        r8 = getActivity();
    L11:
        Intrinsics.checkNotNull(r8);
        ce5.a r1 = this.userComponentAbility;
        if (r1 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("userComponentAbility");
    L15:
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r9 = WikiTreeCtrlView.a.a(r8, r0);
        r9.getWikiUIList().observe(r5.getLifecycleOwner(), new b(new WikiDialogs(), r5, this, r9));
        return;
    L14:
        r0 = r1;
        goto L15
    L7:
        r8 = null;
        goto L8
    }

    public void onDetachFromUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r1, r2);
    }

    public void onActivityResult(int r12, int r13, Intent r14) {
        tt5.a.h(TAG, "onActivityResult()...requestCode = " + r12 + ", resultCode = " + r13);
        Boolean r3 = null;
        if (r13 == (-1)) goto L21;
        if (r13 != 102) goto L49;
        if (r14 == null) goto L9;
        Boolean r15 = Boolean.valueOf(r14.getBooleanExtra("src_is_from_folderblock", false));
    L11:
        if (Intrinsics.areEqual(r15, Boolean.TRUE) == false) goto L13;
        return;
    L13:
        if (ForsetiHelper.s(getHost().getHostFragment()) == false) goto L19;
        Fragment r16 = getHost().getHostFragment();
        if (r16 == null) goto L43;
        com.suite.lark.component.navroute.forseti.g r17 = com.suite.lark.component.navroute.forseti.f.b(r16);
        if (r17 == null) goto L44;
        r17.g(null);
        return;
    L44:
        return;
    L43:
        return;
    L19:
        getActivity().finish();
        return;
    L9:
        r15 = null;
        goto L11
    L49:
        return;
    L21:
        if (r12 != 1024) goto L47;
        String[] r18 = com.bytedance.ee.bear.wikiv2.wikitreev2.main.o.g(r14);
        int r19 = WikiTreeCtrlView.q;
        ViewModelStoreOwner r110 = getHost();
        if (ForsetiHelper.s(r110.getHostFragment()) == true) goto L26;
        r110 = null;
    L26:
        if (r110 != null) goto L29;
        r110 = getActivity();
    L29:
        Intrinsics.checkNotNull(r110);
        ce5.a r0 = this.userComponentAbility;
        if (r0 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("userComponentAbility");
        r0 = null;
    L32:
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r4 = WikiTreeCtrlView.a.a(r110, r0);
        if (r14 == null) goto L35;
        r3 = Boolean.valueOf(r14.getBooleanExtra("src_is_from_folderblock", false));
    L35:
        if (r18 == null) goto L48;
        String r5 = r18[0];
        boolean r8 = r4.isContainInParent(r4.getFocusToken(), r5);
        String r6 = r18[1];
        String r7 = r18[2];
        String r9 = r4.getFocusToken();
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L39;
        MoveSource r111 = MoveSource.FROM_FOLDER_BLOCK;
    L40:
        r4.moveTo(r5, r6, r7, r8, r9, r111.getValue());
        return;
    L39:
        r111 = MoveSource.FROM_DETAIL;
        goto L40
    L48:
        return;
    }
}
