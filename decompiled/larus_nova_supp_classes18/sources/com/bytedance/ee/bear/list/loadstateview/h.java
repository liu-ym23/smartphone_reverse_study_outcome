package com.bytedance.ee.bear.list.loadstateview;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.connection.NetworkType;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.net.CloudReqFun;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.larksuite.component.universe_design.emptystate.UDEmptyState;
import java.net.SocketTimeoutException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h {
    public final LoadStateView a;
    public EmptyCategory b;
    public LoadingCategory c;
    public final Context d;
    public final MutableLiveData<LoadStateCategory> e;

    public final void g() {
        tt5.a.h("LoadStateViewWrapper", "showEmpty()...");
        LoadStateView r1 = this.a;
        EmptyCategory r2 = this.b;
        r1.getClass();
        LoadStateView.CurrentViewType r3 = LoadStateView.CurrentViewType.NONE;
        r1.setVisibility(0);
        LoadStateView.e.a(r1.a);
        UDEmptyState r4 = r1.c.a;
        if (r4 == null) goto L5;
        r4.setVisibility(8);
    L5:
        final LoadStateView.b r5 = r1.b;
        i.a r6 = null;
        if (r5.b != null) goto L8;
        View r7 = View.inflate(r5.e.getContext(), 2131563573, null);
        r5.a = r7.findViewById(2131378174);
        r5.b = (SpaceEmptyState) r7.findViewById(2131378175);
        r5.c = (TextView) r7.findViewById(2131378176);
        LoadStateView r8 = r5.e;
        r8.addView(r7, LoadStateView.a(r8));
        r5.b.setPrimaryClickListener(new a(r5));
        r5.b.setSecondaryClickListener(new b(r5));
        r5.c.setOnClickListener(new c(r5));
    L8:
        i r9 = i.a(r5.e);
        if (r9 == null) goto L13;
        r6 = r9.a;
    L13:
        if (r6 == null) goto L28;
        int r10 = r6.a;
        int r11 = r6.b;
        int r12 = r6.c;
        int r13 = r6.d;
        if (r11 == (-1)) goto L17;
        r5.b.setImageSizeResource(r11);
    L17:
        if (r10 == (-1)) goto L19;
        r5.b.setImageRes(Integer.valueOf(r10));
    L19:
        if (r12 != (-1)) goto L21;
        r5.b.setTitle("");
    L22:
        r5.b.setDesc("");
        if (r13 != (-1)) goto L25;
        r5.b.setPrimaryText("");
    L26:
        r5.b.setSecondaryText("");
        r5.c.setVisibility(8);
    L50:
        View r14 = r5.a;
        if (r14 == null) goto L53;
        r14.setVisibility(0);
    L53:
        tt5.a.h("LoadStateViewWrapper", "showEmpty()...loadStateVisibility = " + this.a.getVisibility() + ", emptyCategory = " + this.b + ", wrapperHash = " + System.identityHashCode(this));
        this.e.postValue(LoadStateCategory.LOADED_SUCCESS_EMPTY);
        return;
    L25:
        r5.b.setPrimaryText(r5.e.getContext().getString(r13));
        goto L26
    L21:
        r5.b.setTitle(r5.e.getContext().getString(r12));
        goto L22
    L28:
        if (r2.getImageRes() == (-1)) goto L31;
        r5.b.setImageRes(Integer.valueOf(r2.getImageRes()));
    L31:
        if (r2.getTitleTextRes() != (-1)) goto L33;
        r5.b.setTitle("");
    L35:
        if (r2.getDescTextRes() != (-1)) goto L37;
        r5.b.setDesc("");
    L39:
        if (r2.getLintBtnTextRes() != (-1)) goto L41;
        r5.c.setVisibility(8);
    L43:
        if (r2.getPrimaryBtnTextRes() != (-1)) goto L45;
        r5.b.setPrimaryText("");
    L47:
        if (r2.getSecondaryBtnTextRes() != (-1)) goto L49;
        r5.b.setSecondaryText("");
        goto L50
    L49:
        r5.b.setSecondaryText(r5.e.getContext().getString(r2.getSecondaryBtnTextRes()));
        goto L50
    L45:
        r5.b.setPrimaryText(r5.e.getContext().getString(r2.getPrimaryBtnTextRes()));
        goto L47
    L41:
        r5.c.setVisibility(0);
        r5.c.setText(r5.e.getContext().getString(r2.getLintBtnTextRes()));
        goto L43
    L37:
        r5.b.setDesc(r5.e.getContext().getString(r2.getDescTextRes()));
        goto L39
    L33:
        r5.b.setTitle(r5.e.getContext().getString(r2.getTitleTextRes()));
        goto L35
    }

    public final void i() {
        tt5.a.h("LoadStateViewWrapper", "showLoadSuccess()...");
        this.a.setVisibility(4);
        tt5.a.h("LoadStateViewWrapper", "showLoadSuccess()...loadStateVisibility = " + this.a.getVisibility() + ", wrapperHash = " + System.identityHashCode(this));
        this.e.postValue(LoadStateCategory.LOADED_SUCCESS);
    }

    public final void j() {
        tt5.a.h("LoadStateViewWrapper", "startLoading()...");
        LoadStateView r0 = this.a;
        r0.a.c = this.c;
        r0.setVisibility(0);
        LoadStateView.CurrentViewType r2 = LoadStateView.CurrentViewType.NONE;
        r0.setVisibility(0);
        View r3 = r0.b.a;
        if (r3 == null) goto L5;
        r3.setVisibility(8);
    L5:
        UDEmptyState r4 = r0.c.a;
        if (r4 == null) goto L8;
        r4.setVisibility(8);
    L8:
        LoadStateView.e r1 = r0.a;
        if (r1.a != null) goto L11;
        View r5 = View.inflate(r1.d.getContext(), 2131563574, null);
        r1.a = (FrameLayout) r5.findViewById(2131378178);
        r1.b = r5.findViewById(2131378177);
        LoadStateView r6 = r1.d;
        r6.addView(r5, LoadStateView.a(r6));
    L11:
        BearLottieView r7 = r1.b;
        if (r7 != null) goto L14;
    L19:
        FrameLayout r8 = r1.a;
        if (r8 == null) goto L22;
        r8.setVisibility(0);
    L22:
        this.e.postValue(LoadStateCategory.LOADING);
        return;
    L14:
        if (r7.isAnimating() == true) goto L19;
        LoadingCategory r9 = r1.c;
        if (r9 == null) goto L18;
        r1.b.setAnimation(r9.getResId());
        r1.c = null;
    L18:
        r1.b.playAnimation();
        goto L19
    }

    public h(LoadStateView r2) {
        this.e = new MutableLiveData();
        this.a = r2;
        this.d = r2.getContext();
    }

    public final void a(EmptyCategory r2) {
        LoadingCategory r0 = LoadingCategory.CATEGORY_LIST;
        this.b = r2;
        this.c = r0;
    }

    public final void b(Throwable r3) {
        tt5.a.h("LoadStateViewWrapper", "loadedFail()...throwable = " + r3.getMessage());
        if (fw4.d.b(this.d) != NetworkType.NETWORK_NO) goto L6;
        h(LoadFailCategory.NO_NETWORK);
        return;
    L6:
        if ((r3 instanceof CloudReqFun.OkHttpReqException) == false) goto L8;
        boolean r4 = ((CloudReqFun.OkHttpReqException) r3).exception.equals(SocketTimeoutException.class.getName());
    L9:
        if (r4 == false) goto L11;
        h(LoadFailCategory.OVERTIME);
        return;
    L11:
        h(LoadFailCategory.UNKNOWN);
        return;
    L8:
        r4 = r3 instanceof SocketTimeoutException;
        goto L9
    }

    public final void c(int r3) {
        tt5.a.h("LoadStateViewWrapper", "loadedSuccess()...dataCount = " + r3);
        if (r3 <= 0) goto L5;
        i();
        return;
    L5:
        g();
        if (fw4.d.b(this.d) != NetworkType.NETWORK_NO) goto L10;
        h(LoadFailCategory.NO_NETWORK);
        return;
    }

    public final void d(LoadStateView.a r2) {
        LoadStateView r0 = this.a;
        if (r2 != null) goto L5;
        r0.getClass();
        tt5.a.d("LoadStateView", "registerEmptyStateClickHandler: EmptyStateHandler is invalid");
        return;
    L5:
        r0.b.d = r2;
    }

    public final void e(LoadStateView.c r2) {
        this.a.c.b = r2;
    }

    public final void f(EmptyCategory r3) {
        tt5.a.h("LoadStateViewWrapper", "setEmptyCategory()...category=" + r3);
        this.b = r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v25, types: [android.view.View, com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void h(LoadFailCategory r9) {
        tt5.a.h("LoadStateViewWrapper", "showLoadFail()...category = " + r9);
        LoadStateView r0 = this.a;
        r0.getClass();
        LoadStateView.CurrentViewType r1 = LoadStateView.CurrentViewType.NONE;
        r0.setVisibility(0);
        LoadStateView.e.a(r0.a);
        View r2 = r0.b.a;
        if (r2 == null) goto L5;
        r2.setVisibility(8);
    L5:
        final LoadStateView.d r3 = r0.c;
        if (r3.a != null) goto L8;
        ?? r4 = new SpaceEmptyState(r3.c.getContext());
        r3.a = r4;
        LoadStateView r5 = r3.c;
        r5.addView(r4, LoadStateView.a(r5));
        r3.a.setOnClickListener(new d(r3));
        r3.a.setPrimaryClickListener(new e(r3));
        r3.a.setSecondaryClickListener(new f(r3));
    L8:
        r3.a.setImageSizeResource(2131165486);
        i r6 = i.a(r3.c);
        if (r6 != null) goto L11;
        i.a r7 = null;
    L13:
        if (r7 == null) goto L28;
        int r10 = r7.a;
        int r8 = r7.b;
        int r11 = r7.c;
        int r12 = r7.d;
        if (r8 == (-1)) goto L17;
        r3.a.setImageSizeResource(r8);
    L17:
        if (r10 == (-1)) goto L19;
        r3.a.setImageRes(Integer.valueOf(r10));
    L19:
        if (r11 != (-1)) goto L21;
        r3.a.setTitle("");
    L22:
        r3.a.setDesc("");
        if (r12 != (-1)) goto L25;
        r3.a.setPrimaryText("");
    L26:
        r3.a.setSecondaryText("");
    L46:
        UDEmptyState r13 = r3.a;
        if (r13 == null) goto L49;
        r13.setVisibility(0);
    L49:
        this.e.postValue(LoadStateCategory.LOADED_FAIL);
        return;
    L25:
        r3.a.setPrimaryText(r3.c.getContext().getString(r12));
        goto L26
    L21:
        r3.a.setTitle(r3.c.getContext().getString(r11));
        goto L22
    L28:
        if (r9.getImageRes() == (-1)) goto L31;
        r3.a.setImageRes(Integer.valueOf(r9.getImageRes()));
    L31:
        if (r9.getTitleTextRes() != (-1)) goto L33;
        r3.a.setTitle("");
    L35:
        if (r9.getDescTextRes() != (-1)) goto L37;
        r3.a.setDesc("");
    L39:
        if (r9.getPrimaryTextRes() != (-1)) goto L41;
        r3.a.setPrimaryText("");
    L43:
        if (r9.getSecondaryTextRes() != (-1)) goto L45;
        r3.a.setSecondaryText("");
        goto L46
    L45:
        r3.a.setSecondaryText(r3.c.getContext().getString(r9.getSecondaryTextRes()));
        goto L46
    L41:
        r3.a.setPrimaryText(r3.c.getContext().getString(r9.getPrimaryTextRes()));
        goto L43
    L37:
        r3.a.setDesc(r3.c.getContext().getString(r9.getDescTextRes()));
        goto L39
    L33:
        r3.a.setTitle(r3.c.getContext().getString(r9.getTitleTextRes()));
        goto L35
    L11:
        r7 = r6.b;
        goto L13
    }
}
