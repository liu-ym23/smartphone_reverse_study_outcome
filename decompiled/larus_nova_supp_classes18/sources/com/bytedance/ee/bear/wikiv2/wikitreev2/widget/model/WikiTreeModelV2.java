package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import android.text.TextUtils;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.ee.bear.wikiv2.wikitreev2.notification.WikiTreeNotificationServiceImpl;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationInsert;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationMakeCopy$TreeNodeMakeCopyParams;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationMove$TreeNodeMoveToWikiParams;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationShortcut$TreeNodeShortcutParams;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationUpdate$TreeNodeUpdateTitleAndIconParams;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationUpdate$TreeNodeUpdateTokenParams;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class WikiTreeModelV2 extends WikiTreeModel {
    private s2 treeResponse;

    public WikiTreeModelV2() {
        this.treeResponse = new s2(this, this.disposables);
        Lazy<WikiTreeNotificationServiceImpl> r0 = WikiTreeNotificationServiceImpl.b;
        WikiTreeNotificationServiceImpl r1 = WikiTreeNotificationServiceImpl.a.a();
        s2 r2 = this.treeResponse;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "listener");
        com.bytedance.ee.bear.wikiv2.wikitreev2.notification.h r3 = r1.a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r2, "listener");
        Iterator<Map.Entry<Class<? extends com.bytedance.ee.bear.wikiv2.wikitreev2.notification.g>, CopyOnWriteArrayList<WeakReference<com.bytedance.ee.bear.wikiv2.wikitreev2.notification.g>>>> r4 = r3.a.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Map.Entry<Class<? extends com.bytedance.ee.bear.wikiv2.wikitreev2.notification.g>, CopyOnWriteArrayList<WeakReference<com.bytedance.ee.bear.wikiv2.wikitreev2.notification.g>>> r5 = r4.next();
        if (ArraysKt.contains(r2.getClass().getInterfaces(), r5.getKey()) == false) goto L4;
        r5.getValue().add(new WeakReference(r2));
        goto L4
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiTreeModel
    public void onCleared() {
        super.onCleared();
        Lazy<WikiTreeNotificationServiceImpl> r0 = WikiTreeNotificationServiceImpl.b;
        WikiTreeNotificationServiceImpl r1 = WikiTreeNotificationServiceImpl.a.a();
        s2 r2 = this.treeResponse;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "listener");
        com.bytedance.ee.bear.wikiv2.wikitreev2.notification.h r3 = r1.a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r2, "listener");
        Iterator<Map.Entry<Class<? extends com.bytedance.ee.bear.wikiv2.wikitreev2.notification.g>, CopyOnWriteArrayList<WeakReference<com.bytedance.ee.bear.wikiv2.wikitreev2.notification.g>>>> r4 = r3.a.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L18;
        Map.Entry<Class<? extends com.bytedance.ee.bear.wikiv2.wikitreev2.notification.g>, CopyOnWriteArrayList<WeakReference<com.bytedance.ee.bear.wikiv2.wikitreev2.notification.g>>> r5 = r4.next();
        if (ArraysKt.contains(r2.getClass().getInterfaces(), r5.getKey()) == false) goto L4;
        CopyOnWriteArrayList<WeakReference<com.bytedance.ee.bear.wikiv2.wikitreev2.notification.g>> r6 = r5.getValue();
        int r7 = r6.size();
        int r8 = 0;
        int r9 = -1;
    L8:
        if (r8 >= r7) goto L13;
        if (Intrinsics.areEqual(r6.get(r8).get(), r2) == false) goto L12;
        r9 = r8;
    L12:
        r8 = r8 + 1;
        goto L8
    L13:
        if (r9 == (-1)) goto L4;
        r6.remove(r9);     // Catch: Exception -> L16
    L16:
        e = move-exception;
        tt5.a.d("WikiTreeNotificationActionProvider", "removeListener fail: " + e);
        goto L4
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiTreeModel, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void favorite(String r1) {
        super.favorite(r1);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiTreeModel, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void insert(IOperationInsert.TreeNodeInsertParams r5) {
        tt5.a.h(this.mTAG, String.format("WikiTreeModelV2.insert, parentToken: %s, forceExpand: %s", new Object[]{yu5.c.j(r5.parentToken), String.valueOf(r5.forceExpand)}));
        TreeNode r0 = this.workspace.m(r5.parentToken);
        if (r0 != null) goto L6;
        tt5.a.k(this.mTAG, "WikiTreeModelV2.insert, node not found. ");
        return;
    L6:
        r5.parentSpaceId = r0.getSpaceId();
        r5.parentOriginSpaceId = r0.getOriginSpaceId();
        r5.parentOriginToken = r0.getOriginToken();
        r5.chainPushUUid = getChainPushUuid(r5.parentOriginSpaceId);
        int r1 = zq5.q.a;
        new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.b().insert(this.userComponentAbility, r5, this.disposables);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiTreeModel, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void unfavorite(String r1) {
        super.unfavorite(r1);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiTreeModel
    public void updateToken(com.bytedance.ee.bear.wikiv2.wikitreev2.h r6) {
        String r0 = r6.b;
        TreeNode r7 = r6.c;
        boolean r1 = this.workspace.x(r0);
        tt5.a.h(this.mTAG, "WikiTreeModelV2.updateToken, fakeToken: " + yu5.c.j(r0) + ", wikiToken: " + yu5.c.j(r7.wiki_token) + ", newTitle: " + yu5.c.j(r7.title) + ", hasNode: " + r1);
        if (r1 == false) goto L6;
        IOperationUpdate$TreeNodeUpdateTokenParams r2 = new IOperationUpdate$TreeNodeUpdateTokenParams(r7);
        r2.oldWikiToken = r0;
        r2.chainPushUUid = getChainPushUuid(r7.space_id);
        int r8 = zq5.q.a;
        ce5.a r9 = this.userComponentAbility;
        CompositeDisposable r3 = this.disposables;
        Intrinsics.checkNotNullParameter(r9, "userAbility");
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "disposables");
        r3.add(Flowable.just("").subscribe(new zq5.o(r2), zq5.p.a));
        return;
    }

    public static b newInstance(ViewModelStoreOwner r2, ce5.a r3) {
        b r4 = new ViewModelProvider(r2, new ViewModelProvider.NewInstanceFactory()).get(WikiTreeModelV2.class);
        r4.setUserComponentAbility(r3);
        return r4;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiTreeModel, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void delete(String r5, String r6) {
        tt5.a.h(this.mTAG, String.format("WikiTreeModelV2.delete, wikiToken: %s", new Object[]{yu5.c.j(r6)}));
        if (this.workspace.x(r6) == true) goto L6;
        tt5.a.k(this.mTAG, "WikiTreeModelV2.delete, node not found. ");
        return;
    L6:
        TreeNode r0 = this.workspace.m(r6);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a.C0218a r1 = new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a.C0218a();
        r1.a = r5;
        r1.b = r6;
        r1.chainPushUUid = getChainPushUuid(r5);
        r1.c = WikiAction.DEL;
        if (r0 == null) goto L9;
        r1.e = Integer.valueOf(r0.obj_type);
    L9:
        int r7 = zq5.q.a;
        new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.b().delete(this.userComponentAbility, r1, this.disposables);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiTreeModel, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void deleteCurrentOnly(String r5, String r6) {
        tt5.a.h(this.mTAG, String.format("WikiTreeModelV2.deleteCurrentOnly, wikiToken: %s", new Object[]{yu5.c.j(r6)}));
        if (this.workspace.x(r6) == true) goto L6;
        tt5.a.k(this.mTAG, "WikiTreeModelV2.deleteCurrentOnly, node not found. ");
        return;
    L6:
        TreeNode r0 = this.workspace.m(r6);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a.C0218a r1 = new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a.C0218a();
        r1.a = r5;
        r1.b = r6;
        r1.chainPushUUid = getChainPushUuid(r5);
        r1.c = WikiAction.DEL_CURRENT_ONLY;
        if (r0 == null) goto L9;
        r1.e = Integer.valueOf(r0.obj_type);
    L9:
        int r7 = zq5.q.a;
        ce5.a r8 = this.userComponentAbility;
        CompositeDisposable r9 = this.disposables;
        Intrinsics.checkNotNullParameter(r8, "userAbility");
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r9, "disposables");
        r9.add(Flowable.just("").flatMap(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.c(r1, r8)).observeOn(fo5.d.e()).subscribe(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.d(r1), new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.e(r1)));
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiTreeModel, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void rename(String r1, String r2) {
        super.rename(r1, r2);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiTreeModel, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void updatePinStatus(String r1, boolean r2) {
        super.updatePinStatus(r1, r2);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiTreeModel, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void updateStarStatus(String r1, boolean r2) {
        super.updateStarStatus(r1, r2);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiTreeModel, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void pin(String r1, String r2, int r3) {
        super.pin(r1, r2, r3);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiTreeModel, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void unPin(String r1, String r2, int r3) {
        super.unPin(r1, r2, r3);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiTreeModel
    public void updateTitleAndIcon(String r5, String r6, String r7) {
        tt5.a.h(this.mTAG, String.format("WikiTreeModelV2.updateTitleAndIcon, wikiToken: %s, newTitle: %s ,newIconInfo: %s", new Object[]{yu5.c.j(r5), yu5.c.j(r6), yu5.c.j(r7)}));
        TreeNode r0 = this.workspace.m(r5);
        if (r0 != null) goto L6;
        tt5.a.k(this.mTAG, "WikiTreeModelV2.updateTitleAndIcon, node not found. ");
        return;
    L6:
        IOperationUpdate$TreeNodeUpdateTitleAndIconParams r1 = new IOperationUpdate$TreeNodeUpdateTitleAndIconParams();
        r1.wikiToken = r5;
        String r8 = r0.space_id;
        r1.spaceId = r8;
        r1.newTitle = r6;
        r1.newIconInfo = r7;
        r1.chainPushUUid = getChainPushUuid(r8);
        int r9 = zq5.q.a;
        ce5.a r10 = this.userComponentAbility;
        CompositeDisposable r11 = this.disposables;
        Intrinsics.checkNotNullParameter(r10, "userAbility");
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r11, "disposables");
        r11.add(Flowable.just("").subscribe(new zq5.m(r1), zq5.n.a));
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiTreeModel, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void makeCopyTo(String r5, String r6, String r7, TreeNode r8) {
        tt5.a.k(this.mTAG, String.format("WikiTreeModelV2.makeCopyTo, srcToken: %s, destSpaceName: %s", new Object[]{yu5.c.j(r5), yu5.c.j(r7)}));
        TreeNode r0 = this.workspace.m(r5);
        if (r0 != null) goto L6;
        tt5.a.k(this.mTAG, "WikiTreeModelV2.makeCopyTo, node not found. ");
        return;
    L6:
        IOperationMakeCopy$TreeNodeMakeCopyParams r1 = new IOperationMakeCopy$TreeNodeMakeCopyParams(r8);
        r1.srcToken = r5;
        r1.destParentToken = r6;
        r1.destSpaceName = r7;
        r1.chainPushUUid = getChainPushUuid(r0.space_id);
        int r9 = zq5.q.a;
        ce5.a r10 = this.userComponentAbility;
        CompositeDisposable r11 = this.disposables;
        Intrinsics.checkNotNullParameter(r10, "userAbility");
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r11, "disposables");
        r11.add(Flowable.just("").subscribe(new zq5.g(r1), zq5.h.a));
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiTreeModel, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void shortcutTo(String r5, String r6, String r7, TreeNode r8) {
        tt5.a.k(this.mTAG, String.format("WikiTreeModelV2.shortcutTo, srcToken: %s, destParentToken: %s", new Object[]{yu5.c.j(r5), yu5.c.j(r6)}));
        TreeNode r0 = this.workspace.m(r5);
        if (r0 != null) goto L6;
        tt5.a.k(this.mTAG, "WikiTreeModelV2.shortcutTo, node not found. ");
        return;
    L6:
        IOperationShortcut$TreeNodeShortcutParams r1 = new IOperationShortcut$TreeNodeShortcutParams(r8);
        r1.srcToken = r5;
        r1.destParentToken = r6;
        r1.destSpaceName = r7;
        r1.chainPushUUid = getChainPushUuid(r0.space_id);
        int r9 = zq5.q.a;
        ce5.a r10 = this.userComponentAbility;
        CompositeDisposable r11 = this.disposables;
        Intrinsics.checkNotNullParameter(r10, "userAbility");
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r11, "disposables");
        r11.add(Flowable.just("").subscribe(new zq5.s(r1), zq5.t.a));
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiTreeModel, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b
    public void moveTo(String r6, String r7, String r8, boolean r9, String r10, int r11) {
        TreeNode r0 = this.workspace.m(r6);
        if (r6 == null) goto L8;
        if (r0 == null) goto L8;
        tt5.a.h(this.mTAG, String.format("WikiTreeModelV2.moveTo, srcToken: %s, destSpaceId: %s, destParentToken: %s, forceExpand: %s, isSameSpace: %s", new Object[]{yu5.c.j(r6), yu5.c.j(r7), yu5.c.j(r8), Boolean.valueOf(r9), Boolean.valueOf(TextUtils.equals(r0.space_id, r7))}));
        IOperationMove$TreeNodeMoveToWikiParams r1 = new IOperationMove$TreeNodeMoveToWikiParams();
        r1.srcToken = r6;
        r1.srcParentToken = r0.parent_wiki_token;
        String r12 = r0.space_id;
        r1.srcSpaceId = r12;
        r1.destParentToken = r8;
        r1.destSpaceId = r7;
        r1.forceExpand = r9;
        r1.expandToToken = r10;
        r1.moveSource = r11;
        r1.chainPushUUid = getChainPushUuid(r12);
        int r13 = zq5.q.a;
        ce5.a r14 = this.userComponentAbility;
        CompositeDisposable r15 = this.disposables;
        Intrinsics.checkNotNullParameter(r14, "userAbility");
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r15, "disposables");
        r15.add(Flowable.just("").flatMap(new zq5.j(r1, r14)).observeOn(fo5.d.e()).subscribe(new zq5.k(r1), zq5.l.a));
        return;
    L8:
        tt5.a.k(this.mTAG, "WikiTreeModelV2.moveTo, node not found. ");
    }
}
