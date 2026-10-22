package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.wikiv2.wikitreev2.WikiTreeObserver;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationInsert;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationMakeCopy$TreeNodeMakeCopyParams;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationMove$TreeNodeMoveToWikiParams;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationShortcut$TreeNodeShortcutParams;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationUpdate$TreeNodeUpdateTitleAndIconParams;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationUpdate$TreeNodeUpdateTokenParams;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s2 implements com.bytedance.ee.bear.wikiv2.wikitreev2.notification.b, com.bytedance.ee.bear.wikiv2.wikitreev2.notification.a, com.bytedance.ee.bear.wikiv2.wikitreev2.notification.f, com.bytedance.ee.bear.wikiv2.wikitreev2.notification.d, com.bytedance.ee.bear.wikiv2.wikitreev2.notification.e, com.bytedance.ee.bear.wikiv2.wikitreev2.notification.c {
    public final WikiTreeModelV2 a;
    public final CompositeDisposable b;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ s2 a;
        public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a.C0218a b;

        public a(s2 r1, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a.C0218a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r3) {
            Intrinsics.checkNotNullParameter((String) r3, "it");
            WikiTreeModelV2 r4 = this.a.a;
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a.C0218a r0 = this.b;
            String r5 = t1.d(r4, r0.a, r0.b);
            this.a.a.workspace.I(this.b.b);
            return r5;
        }
    }

    public static final class a0<T> implements Consumer {
        public final /* synthetic */ s2 a;

        public a0(s2 r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            tt5.a.d(this.a.a.mTAG, "WikiTreeResponseImpl.onTreeNodeTokenChanged, update fail. " + ((Throwable) r4));
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ s2 a;

        public b(s2 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            wwc.c r3 = (wwc.c) r2;
            MutableLiveData<com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h> r4 = this.a.a.getWikiUIList();
            int r0 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h.c;
            r4.setValue(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h.a.b(WikiAction.DEL));
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a.C0218a a;
        public final /* synthetic */ s2 b;
        public final /* synthetic */ TreeNode c;

        public c(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a.C0218a r1, s2 r2, TreeNode r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            String r5 = (String) r4;
            String r0 = this.a.b;
            int r1 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h.c;
            WikiAction r2 = WikiAction.DEL;
            int r3 = v2.a;
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g r6 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h.a.c(r2, v2.a.a(this.b.a));
            r6.f = this.a.a;
            Intrinsics.checkNotNull(r5);
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            r6.i = r5;
            this.b.a.getWikiUIList().setValue(r6);
            if (this.b.a.isSidebarEnable == false) goto L5;
            WikiTreeObserver.a().e(new com.bytedance.ee.bear.wikiv2.wikitreev2.a(r0));
        L5:
            ((com.bytedance.ee.bear.contract.c0) org.koin.java.a.c(com.bytedance.ee.bear.contract.c0.class, null, null, 6)).f0(this.c.obj_token, r0);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ s2 a;

        public d(s2 r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            tt5.a.d(this.a.a.mTAG, "WikiTreeResponseImpl.onTreeNodeDeleteChanged, delete fail. " + r5);
            MutableLiveData<com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h> r0 = this.a.a.getWikiUIList();
            int r1 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h.c;
            WikiAction r2 = WikiAction.DEL;
            Intrinsics.checkNotNull(r5);
            r0.postValue(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h.a.a(r2, r5));
        }
    }

    public static final class e<T, R> implements Function {
        public final /* synthetic */ s2 a;
        public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a.C0218a b;

        public e(s2 r1, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a.C0218a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r3) {
            Intrinsics.checkNotNullParameter((String) r3, "it");
            WikiTreeModelV2 r4 = this.a.a;
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a.C0218a r0 = this.b;
            return t1.e(r4, r0.a, r0.b);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ s2 a;

        public f(s2 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            wwc.c r3 = (wwc.c) r2;
            MutableLiveData<com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h> r4 = this.a.a.getWikiUIList();
            int r0 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h.c;
            r4.setValue(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h.a.b(WikiAction.DEL));
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a.C0218a a;
        public final /* synthetic */ s2 b;
        public final /* synthetic */ TreeNode c;

        public g(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a.C0218a r1, s2 r2, TreeNode r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            String r5 = (String) r4;
            String r0 = this.a.b;
            int r1 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h.c;
            WikiAction r2 = WikiAction.DEL;
            int r3 = v2.a;
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g r6 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h.a.c(r2, v2.a.a(this.b.a));
            r6.f = this.a.a;
            Intrinsics.checkNotNull(r5);
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            r6.i = r5;
            this.b.a.getWikiUIList().setValue(r6);
            if (this.b.a.isSidebarEnable == false) goto L5;
            WikiTreeObserver.a().e(new com.bytedance.ee.bear.wikiv2.wikitreev2.a(r0));
        L5:
            ((com.bytedance.ee.bear.contract.c0) org.koin.java.a.c(com.bytedance.ee.bear.contract.c0.class, null, null, 6)).f0(this.c.obj_token, r0);
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ s2 a;

        public h(s2 r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            tt5.a.d(this.a.a.mTAG, "WikiTreeResponseImpl.onTreeNodeDeleteCurrentOnlyChanged, delete fail. " + r5);
            MutableLiveData<com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h> r0 = this.a.a.getWikiUIList();
            int r1 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h.c;
            WikiAction r2 = WikiAction.DEL_CURRENT_ONLY;
            Intrinsics.checkNotNull(r5);
            r0.postValue(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h.a.a(r2, r5));
        }
    }

    public static final class i<T, R> implements Function {
        public final /* synthetic */ s2 a;
        public final /* synthetic */ IOperationInsert.TreeNodeInsertResult b;

        public i(s2 r1, IOperationInsert.TreeNodeInsertResult r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((String) r2, "it");
            TreeNode r3 = this.a.a.workspace.m(this.b.parentToken);
            if (r3 != null) goto L6;
            int r4 = up5.b.b;
            Flowable r5 = Flowable.just(up5.b.a.a());
            Intrinsics.checkNotNull(r5);
            return r5;
        L6:
            return t1.h(this.a.a, r3);
        }
    }

    public static final class j<T, R> implements Function {
        public final /* synthetic */ s2 a;
        public final /* synthetic */ IOperationInsert.TreeNodeInsertResult b;

        public j(s2 r1, IOperationInsert.TreeNodeInsertResult r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r5) {
            up5.b r6 = (up5.b) r5;
            Intrinsics.checkNotNullParameter(r6, "parent");
            if (r6.b() == true) goto L5;
            e3 r0 = this.a.a.workspace;
            TreeNode r7 = (TreeNode) r6.a();
            Map<String, TreeNode> r1 = r0.g;
            ConcurrentHashMap r2 = (ConcurrentHashMap) r1;
            r2.put(r7.wiki_token, r7);
        L5:
            WikiTreeModelV2 r8 = this.a.a;
            IOperationInsert.TreeNodeInsertResult r3 = this.b;
            return t1.b(r8, r3.parentOriginToken, r3.newInsertNode, r3.forceExpand, r3.uid);
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ s2 a;
        public final /* synthetic */ IOperationInsert.TreeNodeInsertResult b;

        public k(s2 r1, IOperationInsert.TreeNodeInsertResult r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            String r6 = (String) r5;
            int r0 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h.c;
            WikiAction r1 = WikiAction.ADD;
            int r2 = v2.a;
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g r3 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h.a.c(r1, v2.a.a(this.a.a));
            IOperationInsert.TreeNodeInsertResult r4 = this.b;
            s2 r7 = this.a;
            r3.f = r4.parentSpaceId;
            Intrinsics.checkNotNull(r6);
            Intrinsics.checkNotNullParameter(r6, "<set-?>");
            r3.g = r6;
            String r8 = r7.a.workspace.p(r6, r4.uid);
            Intrinsics.checkNotNullParameter(r8, "<set-?>");
            r3.b = r8;
            this.a.a.getWikiUIList().postValue(r3);
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ s2 a;

        public l(s2 r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            tt5.a.d(this.a.a.mTAG, "WikiTreeResponseImpl.onTreeNodeInsertChanged, insert fail. " + r5);
            if (r5 == null) goto L6;
            MutableLiveData<com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h> r0 = this.a.a.getWikiUIList();
            int r1 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h.c;
            r0.postValue(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h.a.a(WikiAction.ADD, r5));
            return;
        }
    }

    public static final class m<T, R> implements Function {
        public final /* synthetic */ s2 a;
        public final /* synthetic */ IOperationMakeCopy$TreeNodeMakeCopyParams b;

        public m(s2 r1, IOperationMakeCopy$TreeNodeMakeCopyParams r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r5) {
            Intrinsics.checkNotNullParameter((String) r5, "it");
            WikiTreeModelV2 r6 = this.a.a;
            IOperationMakeCopy$TreeNodeMakeCopyParams r0 = this.b;
            return t1.b(r6, r0.destParentToken, r0.makeCopyNode, false, "");
        }
    }

    public static final class n<T> implements Consumer {
        public final /* synthetic */ s2 a;
        public final /* synthetic */ IOperationMakeCopy$TreeNodeMakeCopyParams b;

        public n(s2 r1, IOperationMakeCopy$TreeNodeMakeCopyParams r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            String r6 = (String) r5;
            tt5.a.h(this.a.a.mTAG, "WikiTreeResponseImpl.onTreeNodeMakeCopyChanged, addNode success.");
            TreeNode r7 = this.b.makeCopyNode;
            int r0 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h.c;
            WikiAction r1 = WikiAction.MAKE_COPY;
            int r2 = v2.a;
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g r3 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h.a.c(r1, v2.a.a(this.a.a));
            IOperationMakeCopy$TreeNodeMakeCopyParams r4 = this.b;
            String r8 = r7.wiki_token;
            Intrinsics.checkNotNullParameter(r8, "<set-?>");
            r3.g = r8;
            r3.d(r7.space_id);
            String r9 = r4.destSpaceName;
            Intrinsics.checkNotNullParameter(r9, "<set-?>");
            r3.o = r9;
            String r10 = r7.obj_token;
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            r3.t = r10;
            r3.u = r7.obj_type;
            this.a.a.getWikiUIList().postValue(r3);
        }
    }

    public static final class o<T> implements Consumer {
        public final /* synthetic */ s2 a;

        public o(s2 r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            tt5.a.d(this.a.a.mTAG, "WikiTreeResponseImpl.onTreeNodeMakeCopyChanged, addNode fail. " + ((Throwable) r4));
        }
    }

    public static final class p<T, R> implements Function {
        public final /* synthetic */ IOperationMove$TreeNodeMoveToWikiParams a;
        public final /* synthetic */ s2 b;

        public p(IOperationMove$TreeNodeMoveToWikiParams r1, s2 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r14) {
            Intrinsics.checkNotNullParameter((String) r14, "it");
            IOperationMove$TreeNodeMoveToWikiParams r15 = this.a;
            if (TextUtils.equals(r15.srcSpaceId, r15.destSpaceId) == true) goto L6;
            WikiTreeModelV2 r16 = this.b.a;
            IOperationMove$TreeNodeMoveToWikiParams r0 = this.a;
            t1.d(r16, r0.srcSpaceId, r0.srcToken);
        L10:
            return Boolean.TRUE;
        L6:
            if (this.b.a.isSameSpace(this.a.srcSpaceId) == false) goto L8;
            e3 r17 = this.b.a.workspace;
            IOperationMove$TreeNodeMoveToWikiParams r1 = this.a;
            r17.M(r1.srcToken, r1.destSpaceId);
        L8:
            WikiTreeModelV2 r18 = this.b.a;
            IOperationMove$TreeNodeMoveToWikiParams r2 = this.a;
            t1.i(r18, r2.srcParentToken, new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.f(r2.srcToken, r2.destParentToken, r2.sortId, r2.forceExpand, r2.expandToToken, null, null, r2.destSpaceId));
            goto L10
        }
    }

    public static final class q<T> implements Consumer {
        public final /* synthetic */ s2 a;
        public final /* synthetic */ IOperationMove$TreeNodeMoveToWikiParams b;

        public q(s2 r1, IOperationMove$TreeNodeMoveToWikiParams r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            wwc.c r4 = (wwc.c) r3;
            MutableLiveData<com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h> r5 = this.a.a.getWikiUIList();
            int r0 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h.c;
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.d r1 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h.a.b(WikiAction.MOV);
            r1.d = this.b.moveSource;
            r5.postValue(r1);
        }
    }

    public static final class r<T> implements Consumer {
        public final /* synthetic */ s2 a;
        public final /* synthetic */ IOperationMove$TreeNodeMoveToWikiParams b;

        public r(s2 r1, IOperationMove$TreeNodeMoveToWikiParams r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            Boolean r6 = (Boolean) r5;
            String r7 = this.a.a.getFocusToken();
            String r0 = this.a.a.workspace.l(r7);
            this.a.a.setFocus(r7, r0);
            int r1 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h.c;
            WikiAction r2 = WikiAction.MOV;
            int r3 = v2.a;
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g r4 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h.a.c(r2, v2.a.a(this.a.a));
            IOperationMove$TreeNodeMoveToWikiParams r8 = this.b;
            String r9 = r8.srcToken;
            Intrinsics.checkNotNullParameter(r9, "<set-?>");
            r4.k = r9;
            r4.d(r8.destSpaceId);
            Intrinsics.checkNotNull(r7);
            Intrinsics.checkNotNullParameter(r7, "<set-?>");
            r4.p = r7;
            r4.s = r8.forceExpand;
            r4.w = r8.moveSource;
            this.a.a.getWikiUIList().postValue(r4);
        }
    }

    public static final class s<T> implements Consumer {
        public final /* synthetic */ s2 a;
        public final /* synthetic */ IOperationMove$TreeNodeMoveToWikiParams b;

        public s(s2 r1, IOperationMove$TreeNodeMoveToWikiParams r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            tt5.a.d(this.a.a.mTAG, "WikiTreeResponseImpl.onTreeNodeMoveChanged, move fail. " + r5);
            int r0 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h.c;
            WikiAction r1 = WikiAction.MOV;
            Intrinsics.checkNotNull(r5);
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.a r6 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h.a.a(r1, r5);
            r6.e = this.b.moveSource;
            this.a.a.getWikiUIList().postValue(r6);
        }
    }

    public static final class t<T, R> implements Function {
        public final /* synthetic */ s2 a;
        public final /* synthetic */ IOperationShortcut$TreeNodeShortcutParams b;

        public t(s2 r1, IOperationShortcut$TreeNodeShortcutParams r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r5) {
            Intrinsics.checkNotNullParameter((String) r5, "it");
            WikiTreeModelV2 r6 = this.a.a;
            IOperationShortcut$TreeNodeShortcutParams r0 = this.b;
            return t1.b(r6, r0.destParentToken, r0.shortcutNode, false, "");
        }
    }

    public static final class u<T> implements Consumer {
        public final /* synthetic */ s2 a;
        public final /* synthetic */ IOperationShortcut$TreeNodeShortcutParams b;

        public u(s2 r1, IOperationShortcut$TreeNodeShortcutParams r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            String r6 = (String) r5;
            tt5.a.h(this.a.a.mTAG, "WikiTreeResponseImpl.onTreeNodeShortcutChanged, addNode success.");
            TreeNode r7 = this.b.shortcutNode;
            int r0 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h.c;
            WikiAction r1 = WikiAction.SHORTCUT;
            int r2 = v2.a;
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g r3 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h.a.c(r1, v2.a.a(this.a.a));
            IOperationShortcut$TreeNodeShortcutParams r4 = this.b;
            String r8 = r7.wiki_token;
            Intrinsics.checkNotNullParameter(r8, "<set-?>");
            r3.m = r8;
            r3.d(r7.space_id);
            String r9 = r4.destSpaceName;
            Intrinsics.checkNotNullParameter(r9, "<set-?>");
            r3.o = r9;
            this.a.a.getWikiUIList().postValue(r3);
        }
    }

    public static final class v<T> implements Consumer {
        public final /* synthetic */ s2 a;

        public v(s2 r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            tt5.a.d(this.a.a.mTAG, "WikiTreeResponseImpl.onTreeNodeShortcutChanged, addNode fail. " + ((Throwable) r4));
        }
    }

    public static final class w<T, R> implements Function {
        public final /* synthetic */ s2 a;
        public final /* synthetic */ IOperationUpdate$TreeNodeUpdateTitleAndIconParams b;

        public w(s2 r1, IOperationUpdate$TreeNodeUpdateTitleAndIconParams r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r3) {
            Intrinsics.checkNotNullParameter((String) r3, "it");
            TreeNode r4 = this.a.a.workspace.m(this.b.wikiToken);
            if (r4 == null) goto L6;
            IOperationUpdate$TreeNodeUpdateTitleAndIconParams r0 = this.b;
            r4.title = r0.newTitle;
            r4.iconInfo = r0.newIconInfo;
            Flowable.fromCallable(new t2(r0)).subscribeOn(fo5.d.f()).subscribe(Functions.emptyConsumer(), up5.e.a);
            return Boolean.TRUE;
        L6:
            return Boolean.FALSE;
        }
    }

    public static final class x<T> implements Consumer {
        public final /* synthetic */ s2 a;
        public final /* synthetic */ IOperationUpdate$TreeNodeUpdateTitleAndIconParams b;

        public x(s2 r1, IOperationUpdate$TreeNodeUpdateTitleAndIconParams r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            if (((Boolean) r3).booleanValue() == false) goto L6;
            int r4 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h.c;
            WikiAction r5 = WikiAction.PUSH_UDE_NAME_ICON;
            int r0 = v2.a;
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g r6 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h.a.c(r5, v2.a.a(this.a.a));
            String r1 = this.b.wikiToken;
            Intrinsics.checkNotNullParameter(r1, "<set-?>");
            r6.j = r1;
            this.a.a.getWikiUIList().postValue(r6);
            return;
        }
    }

    public static final class y<T> implements Consumer {
        public final /* synthetic */ s2 a;

        public y(s2 r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            tt5.a.d(this.a.a.mTAG, "WikiTreeResponseImpl.onTreeNodeTitleAndIconChanged, update fail. " + ((Throwable) r4));
        }
    }

    public static final class z<T> implements Consumer {
        public final /* synthetic */ IOperationUpdate$TreeNodeUpdateTokenParams a;
        public final /* synthetic */ s2 b;

        public z(IOperationUpdate$TreeNodeUpdateTokenParams r1, s2 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r6) {
            String r7 = (String) r6;
            IOperationUpdate$TreeNodeUpdateTokenParams r8 = this.a;
            String r0 = r8.oldWikiToken;
            TreeNode r9 = r8.newTreeNode;
            String r1 = r9.parent_wiki_token;
            TreeNode r2 = this.b.a.workspace.m(r0);
            if (r2 == null) goto L5;
            r2.title = r9.title;
            r2.origin_wiki_token = r9.origin_wiki_token;
            r2.wiki_token = r9.wiki_token;
            r2.obj_token = r9.obj_token;
            r2.sort_id = r9.sort_id;
        L6:
            e3 r3 = this.b.a.workspace;
            if (r2 != null) goto L9;
            r2 = r9;
        L9:
            r3.L(r1, r2, r0);
            Flowable.fromCallable(new u2(this.b, r9, r0, r1)).subscribeOn(fo5.d.f()).subscribe(Functions.emptyConsumer(), up5.e.a);
            return;
        L5:
            r2 = null;
            goto L6
        }
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.notification.d
    public final void a() {
        Intrinsics.checkNotNullParameter(null, "params");
        String r0 = this.a.mHashCode;
        throw null;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.notification.d
    public final void b() {
        Intrinsics.checkNotNullParameter(null, "params");
        String r0 = this.a.mHashCode;
        throw null;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.notification.d
    public final void c(IOperationMove$TreeNodeMoveToWikiParams r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        if (r5.isHitThisTreeModel(this.a.mHashCode) == true) goto L5;
        return;
    L5:
        this.b.add(Flowable.just("").map(new p(r5, this)).observeOn(fo5.d.d()).doOnSubscribe(new q(this, r5)).subscribe(new r(this, r5), new s(this, r5)));
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.notification.a
    public final void d(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a.C0218a r5) {
        Intrinsics.checkNotNullParameter(r5, "result");
        if (r5.isHitThisTreeModel(this.a.mHashCode) == true) goto L5;
        return;
    L5:
        TreeNode r0 = this.a.workspace.m(r5.b);
        if (r0 != null) goto L9;
        tt5.a.k(this.a.mTAG, "WikiTreeModelV2.deleteCurrentOnly, node not found. ");
        return;
    L9:
        this.b.add(Flowable.just("").observeOn(fo5.d.e()).map(new e(this, r5)).observeOn(fo5.d.d()).doOnSubscribe(new f(this)).subscribeOn(fo5.d.d()).subscribe(new g(r5, this, r0), new h(this)));
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.notification.f
    public final void e(IOperationUpdate$TreeNodeUpdateTokenParams r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        if (r4.isHitThisTreeModel(this.a.mHashCode) == true) goto L5;
        return;
    L5:
        this.b.add(Flowable.just("").subscribe(new z(r4, this), new a0(this)));
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.notification.b
    public final void f(IOperationInsert.TreeNodeInsertResult r4) {
        Intrinsics.checkNotNullParameter(r4, "result");
        if (r4.isHitThisTreeModel(this.a.mHashCode) == true) goto L5;
        return;
    L5:
        this.b.add(Flowable.just("").observeOn(fo5.d.e()).flatMap(new i(this, r4)).map(new j(this, r4)).subscribe(new k(this, r4), new l(this)));
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.notification.f
    public final void g(IOperationUpdate$TreeNodeUpdateTitleAndIconParams r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        if (r4.isHitThisTreeModel(this.a.mHashCode) == true) goto L5;
        return;
    L5:
        this.b.add(Flowable.just("").map(new w(this, r4)).subscribe(new x(this, r4), new y(this)));
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.notification.e
    public final void h(IOperationShortcut$TreeNodeShortcutParams r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        if (r4.isHitThisTreeModel(this.a.mHashCode) == true) goto L5;
        return;
    L5:
        this.b.add(Flowable.just("").observeOn(fo5.d.b()).map(new t(this, r4)).observeOn(fo5.d.d()).subscribe(new u(this, r4), new v(this)));
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.notification.a
    public final void i(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a.C0218a r4) {
        Intrinsics.checkNotNullParameter(r4, "result");
        if (r4.isHitThisTreeModel(this.a.mHashCode) == true) goto L5;
        return;
    L5:
        Throwable r0 = r4.d;
        if (r0 == null) goto L9;
        MutableLiveData<com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h> r1 = this.a.getWikiUIList();
        int r2 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h.c;
        r1.postValue(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.h.a.a(r4.c, r0));
        return;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.notification.c
    public final void j(IOperationMakeCopy$TreeNodeMakeCopyParams r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        if (r4.isHitThisTreeModel(this.a.mHashCode) == true) goto L5;
        return;
    L5:
        this.b.add(Flowable.just("").observeOn(fo5.d.b()).map(new m(this, r4)).observeOn(fo5.d.d()).subscribe(new n(this, r4), new o(this)));
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.notification.a
    public final void k(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a.C0218a r5) {
        Intrinsics.checkNotNullParameter(r5, "result");
        if (r5.isHitThisTreeModel(this.a.mHashCode) == true) goto L5;
        return;
    L5:
        TreeNode r0 = this.a.workspace.m(r5.b);
        if (r0 != null) goto L9;
        tt5.a.k(this.a.mTAG, "WikiTreeModelV2.delete, node not found. ");
        return;
    L9:
        this.b.add(Flowable.just("").observeOn(fo5.d.e()).map(new a(this, r5)).observeOn(fo5.d.d()).doOnSubscribe(new b(this)).subscribeOn(fo5.d.d()).subscribe(new c(r5, this, r0), new d(this)));
    }

    public s2(WikiTreeModelV2 r2, CompositeDisposable r3) {
        Intrinsics.checkNotNullParameter(r2, "treeModelV2");
        Intrinsics.checkNotNullParameter(r3, "disposables");
        this.a = r2;
        this.b = r3;
    }
}
