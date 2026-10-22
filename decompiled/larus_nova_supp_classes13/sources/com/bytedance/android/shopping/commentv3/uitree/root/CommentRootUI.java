package com.bytedance.android.shopping.commentv3.uitree.root;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.anchorv3.comment.model.BottomProductCardInfo;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentParams;
import com.bytedance.android.shopping.anchorv4.containers.h;
import com.bytedance.android.shopping.commentv3.base.BaseCommentUI;
import com.bytedance.android.shopping.commentv3.base.BaseUI$bindLogic$1;
import com.bytedance.android.shopping.commentv3.base.c;
import com.bytedance.android.shopping.commentv3.data.interfaces.ToastData;
import com.bytedance.android.shopping.commentv3.uitree.bottomcard.BottomProductCardUI;
import com.bytedance.android.shopping.commentv3.uitree.list.CommentListUI;
import com.bytedance.android.shopping.commentv3.uitree.p000float.FloatWindowUI;
import com.bytedance.android.shopping.commentv3.uitree.title.CommentTitleLogic;
import com.bytedance.android.shopping.commentv3.uitree.title.CommentTitleUI;
import com.bytedance.android.shopping.commentv3.utils.InteractionPerfMonitor;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/uitree/root/CommentRootUI;", "Lcom/bytedance/android/shopping/commentv3/base/BaseCommentUI;", "Lcom/bytedance/android/shopping/commentv3/uitree/root/a;", "Lcom/bytedance/android/shopping/commentv3/uitree/root/CommentRootLogic;", "Lcom/bytedance/android/shopping/commentv3/uitree/root/b;", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentRootUI extends BaseCommentUI<com.bytedance.android.shopping.commentv3.uitree.root.a, CommentRootLogic> implements com.bytedance.android.shopping.commentv3.uitree.root.b {
    public Lifecycle i;
    public boolean j;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ CommentRootUI a;

        public b(CommentRootUI r1) {
            this.a = r1;
        }

        public final void onChanged(Object r7) {
            com.bytedance.android.shopping.commentv3.uitree.root.a r8 = (com.bytedance.android.shopping.commentv3.uitree.root.a) r7;
            if (r8 == null) goto L7;
            ToastData r9 = r8.a;
            if (r9 == null) goto L7;
            String r10 = r9.getMsg();
        L8:
            String r2 = r10;
            if (r2 != null) goto L11;
        L14:
            boolean r0 = true;
        L15:
            if (r0 == true) goto L23;
            CommentRootUI r1 = this.a;
            if (r1.j == true) goto L24;
            Context r3 = r1.getContext();
            if (r3 == null) goto L21;
            ECToast.showToast$default(ECToast.INSTANCE, r3, r2, null, 4, null);
        L21:
            this.a.j = true;
            return;
        L24:
            return;
        L23:
            return;
        L11:
            if (r2.length() == 0) goto L14;
            r0 = false;
        L7:
            r10 = null;
            goto L8
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.commentv3.uitree.root.b
    public final int b() {
        c r0 = this.g;
        Fragment r1 = null;
        if (r0 == null) goto L5;
        Fragment r2 = r0.b;
    L6:
        if (r2 == null) goto L9;
        r1 = r2.getParentFragment();
    L9:
        if ((r1 instanceof h) == false) goto L12;
        return 0;
    L12:
        return j56.a.b(getContext());
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.commentv3.base.BaseCommentUI
    public final void j() {
        CommentTitleUI r0 = new CommentTitleUI();
        oc3.a r6 = null;
        if (BaseCommentUI.h(this, r0) == false) goto L40;
        Intrinsics.checkNotNullParameter(r0, "child");
        if ((r0 instanceof CommentRootUI) == true) goto L110;
        BaseCommentUI<?, ?> r1 = this.f;
        if (r1 == null) goto L12;
        View r2 = r1.c;
        if (r2 == null) goto L12;
        View r3 = r2.findViewById(2131388843);
    L13:
        int r7 = com.bytedance.android.shopping.commentv3.utils.b.a;
        Intrinsics.checkNotNullParameter("CommentRootUI", "enterFrom");
        if (r3 != null) goto L16;
        dm.a.a("CommentViewHelper_v3").i("rawView is null, enterFrom: ".concat("CommentRootUI"));
    L22:
        View r10 = null;
    L27:
        r0.c = r10;
        goto L110
    L16:
        ViewParent r8 = r3.getParent();
        if ((r8 instanceof ViewGroup) == true) goto L19;
        r8 = null;
    L19:
        ViewGroup r9 = (ViewGroup) r8;
        if (r9 != null) goto L23;
        dm.a.a("CommentViewHelper_v3").i("parent is null, enterFrom: ".concat("CommentRootUI"));
        goto L22
    L23:
        dm.a.a("CommentViewHelper_v3").i("enterFrom: ".concat("CommentRootUI"));
        int r11 = r9.indexOfChild(r3);
        ViewGroup.LayoutParams r12 = r3.getLayoutParams();
        r10 = th.a.c(r9.getContext(), 2131560431, r9, false);
        r9.removeViewInLayout(r3);
        if (r12 == null) goto L26;
        r9.addView(r10, r11, r12);
        goto L27
    L26:
        r9.addView(r10, r11);
    L12:
        r3 = null;
    L110:
        Object r4 = CommentTitleLogic.class.getConstructors()[0].newInstance(new Object[0]);     // Catch: Exception -> L34
        if ((r4 instanceof CommentTitleLogic) == true) goto L32;
        r4 = null;
    L32:
        CommentTitleLogic r5 = (CommentTitleLogic) r4;     // Catch: Exception -> L34
    L36:
        if (r5 != null) goto L38;
        dm.a.a("BaseUI_v3").i("logicInstance or stateInstance is null");
    L39:
        BaseCommentUI.g(this, r0);
        BaseCommentUI.i(r0, this);
        goto L40
    L38:
        r0.a = r5;
        r5.d(r0.p(), new BaseUI$bindLogic$1(r0));
    L34:
        e = move-exception;
        ECExceptionMonitor.e(e);
        dm.a.b r13 = dm.a.a;
        dm.a.a("CommentRootUI").b(e.getMessage(), e);
        r5 = null;
    L40:
        CommentListUI r14 = new CommentListUI();
        View r15 = this.c;
        if (r15 == null) goto L43;
        View r16 = r15.findViewById(2131367384);
    L45:
        if (BaseCommentUI.h(this, r14) == false) goto L59;
        r14.c = r16;
        Object r17 = com.bytedance.android.shopping.commentv3.uitree.list.a.class.getConstructors()[0].newInstance(new Object[0]);     // Catch: Exception -> L53
        if ((r17 instanceof com.bytedance.android.shopping.commentv3.uitree.list.a) == true) goto L51;
        r17 = null;
    L51:
        com.bytedance.android.shopping.commentv3.uitree.list.a r18 = (com.bytedance.android.shopping.commentv3.uitree.list.a) r17;     // Catch: Exception -> L53
    L55:
        if (r18 != null) goto L57;
        dm.a.a("BaseUI_v3").i("logicInstance or stateInstance is null");
    L58:
        BaseCommentUI.g(this, r14);
        BaseCommentUI.i(r14, this);
        goto L59
    L57:
        r14.a = r18;
        r18.d(r14.o(), new BaseUI$bindLogic$1(r14));
    L53:
        e = move-exception;
        ECExceptionMonitor.e(e);
        dm.a.b r19 = dm.a.a;
        dm.a.a("CommentRootUI").b(e.getMessage(), e);
        r18 = null;
    L59:
        FloatWindowUI r20 = new FloatWindowUI();
        View r21 = this.c;
        if (r21 == null) goto L62;
        View r22 = r21.findViewById(2131372986);
    L64:
        if (BaseCommentUI.h(this, r20) == false) goto L78;
        r20.c = r22;
        Object r23 = com.bytedance.android.shopping.commentv3.uitree.p000float.b.class.getConstructors()[0].newInstance(new Object[0]);     // Catch: Exception -> L72
        if ((r23 instanceof com.bytedance.android.shopping.commentv3.uitree.p000float.b) == true) goto L70;
        r23 = null;
    L70:
        com.bytedance.android.shopping.commentv3.uitree.p000float.b r24 = (com.bytedance.android.shopping.commentv3.uitree.p000float.b) r23;     // Catch: Exception -> L72
    L74:
        if (r24 != null) goto L76;
        dm.a.a("BaseUI_v3").i("logicInstance or stateInstance is null");
    L77:
        BaseCommentUI.g(this, r20);
        BaseCommentUI.i(r20, this);
        goto L78
    L76:
        r20.a = r24;
        r24.d(r20.o(), new BaseUI$bindLogic$1(r20));
    L72:
        e = move-exception;
        ECExceptionMonitor.e(e);
        dm.a.b r25 = dm.a.a;
        dm.a.a("CommentRootUI").b(e.getMessage(), e);
        r24 = null;
    L78:
        com.bytedance.android.shopping.commentv3.data.b r26 = this.e;
        if (r26 == null) goto L87;
        CommentParams r27 = r26.a;
        if (r27 == null) goto L87;
        BottomProductCardInfo r28 = r27.getBottomProductCardInfo();
        if (r28 == null) goto L87;
        boolean r29 = true;
        if (r28.getShowProductCard() != true) goto L87;
    L88:
        if (r29 == false) goto L108;
        BottomProductCardUI r30 = new BottomProductCardUI();
        View r31 = this.c;
        if (r31 == null) goto L92;
        View r32 = r31.findViewById(2131364498);
    L94:
        if (BaseCommentUI.h(this, r30) == false) goto L108;
        r30.c = r32;
        Object r33 = oc3.a.class.getConstructors()[0].newInstance(new Object[0]);     // Catch: Exception -> L102
        if ((r33 instanceof oc3.a) == true) goto L100;
        r33 = null;
    L100:
        r6 = (oc3.a) r33;     // Catch: Exception -> L102
    L104:
        if (r6 != null) goto L106;
        dm.a.a("BaseUI_v3").i("logicInstance or stateInstance is null");
    L107:
        BaseCommentUI.g(this, r30);
        BaseCommentUI.i(r30, this);
        goto L108
    L106:
        r30.a = r6;
        r6.d(new oc3.b(), new BaseUI$bindLogic$1(r30));
    L102:
        e = move-exception;
        ECExceptionMonitor.e(e);
        dm.a.b r34 = dm.a.a;
        dm.a.a("CommentRootUI").b(e.getMessage(), e);
        goto L104
    L92:
        r32 = null;
    L108:
        this.b.observe(this, new b(this));
        return;
    L87:
        r29 = false;
        goto L88
    L62:
        r22 = null;
        goto L64
    L43:
        r16 = null;
        goto L45
    }

    public final com.bytedance.android.shopping.commentv3.base.b o() {
        return new com.bytedance.android.shopping.commentv3.uitree.root.a(null);
    }

    @Override // com.bytedance.android.shopping.commentv3.base.BaseCommentUI
    public final Lifecycle rK() {
        Lifecycle r0 = this.i;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_lifecycle");
    L5:
        return r0;
    }

    public CommentRootUI() {
        this.f = this;
        CommentRootLogic r1 = null;
        Object r0 = CommentRootLogic.class.getConstructors()[0].newInstance(new Object[0]);     // Catch: Exception -> L8
        if ((r0 instanceof CommentRootLogic) == true) goto L6;
        r0 = null;
    L6:
        r1 = (CommentRootLogic) r0;     // Catch: Exception -> L8
    L10:
        if (r1 != null) goto L12;
        dm.a.a("BaseUI_v3").i("logicInstance or stateInstance is null");
        return;
    L12:
        this.a = r1;
        r1.d(o(), new BaseUI$bindLogic$1(this));
        return;
    L8:
        e = move-exception;
        ECExceptionMonitor.e(e);
        dm.a.b r2 = dm.a.a;
        dm.a.a("CommentRootUI").b(e.getMessage(), e);
        goto L10
    }

    @Override // com.bytedance.android.shopping.commentv3.base.BaseCommentUI, com.bytedance.android.shopping.commentv3.base.BaseUI, com.bytedance.android.shopping.commentv3.base.LifecycleUI
    public final void onCreate() {
        super.onCreate();
        int r0 = j56.a.b(getContext());
        View r1 = this.c;
        if (r1 == null) goto L5;
        r1.setPadding(r1.getPaddingLeft(), r1.getPaddingTop() + r0, r1.getPaddingRight(), r1.getPaddingBottom());
    L5:
        dm.a.a("CommentRootUI_v3").i("onCreate");
    }

    @Override // com.bytedance.android.shopping.commentv3.base.BaseUI, com.bytedance.android.shopping.commentv3.base.LifecycleUI
    public final void onDestroy() {
        super.onDestroy();
        InteractionPerfMonitor.j.getClass();
        ((Map) InteractionPerfMonitor.i.getValue()).clear();
        com.bytedance.android.shopping.commentv3.uitree.list.rvkit.b.a.clear();
        com.bytedance.android.shopping.commentv3.uitree.list.rvkit.b.b = 4;
        com.bytedance.android.shopping.commentv3.uitree.list.rvkit.b.c = 1;
    }
}
