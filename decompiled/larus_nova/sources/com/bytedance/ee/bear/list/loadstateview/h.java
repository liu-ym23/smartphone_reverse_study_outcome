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
import com.larus.nova.R;
import java.net.SocketTimeoutException;

/* JADX INFO: loaded from: classes18.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LoadStateView f228647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public EmptyCategory f228648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LoadingCategory f228649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f228650d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<LoadStateCategory> f228651e;

    public final void g() {
        tt5.a.h("LoadStateViewWrapper", "showEmpty()...");
        LoadStateView r100 = this.f228647a;
        EmptyCategory r101 = this.f228648b;
        r100.getClass();
        LoadStateView.CurrentViewType r102 = LoadStateView.CurrentViewType.NONE;
        r100.setVisibility(0);
        LoadStateView.e.a(r100.f228621a);
        SpaceEmptyState r103 = r100.f228623c.f228630a;
        if (r103 == null) goto L5;
        r103.setVisibility(8);
    L5:
        final LoadStateView.b r104 = r100.f228622b;
        i.a r105 = null;
        if (r104.f228626b != null) goto L8;
        View r106 = View.inflate(r104.f228629e.getContext(), R.layout.load_state_empty_layout, null);
        r104.f228625a = r106.findViewById(R.id.list_state_empty_root);
        r104.f228626b = (SpaceEmptyState) r106.findViewById(R.id.list_state_empty_state);
        r104.f228627c = (TextView) r106.findViewById(R.id.list_state_empty_text_btn);
        LoadStateView r107 = r104.f228629e;
        r107.addView(r106, LoadStateView.a(r107));
        r104.f228626b.setPrimaryClickListener(new a(r104));
        r104.f228626b.setSecondaryClickListener(new b(r104));
        r104.f228627c.setOnClickListener(new c(r104));
    L8:
        i r108 = i.a(r104.f228629e);
        if (r108 == null) goto L13;
        r105 = r108.f228652a;
    L13:
        if (r105 == null) goto L28;
        int r109 = r105.f228654a;
        int r110 = r105.f228655b;
        int r111 = r105.f228656c;
        int r112 = r105.f228657d;
        if (r110 == (-1)) goto L17;
        r104.f228626b.setImageSizeResource(r110);
    L17:
        if (r109 == (-1)) goto L19;
        r104.f228626b.setImageRes(Integer.valueOf(r109));
    L19:
        if (r111 != (-1)) goto L21;
        r104.f228626b.setTitle("");
    L22:
        r104.f228626b.setDesc("");
        if (r112 != (-1)) goto L25;
        r104.f228626b.setPrimaryText("");
    L26:
        r104.f228626b.setSecondaryText("");
        r104.f228627c.setVisibility(8);
    L50:
        View r113 = r104.f228625a;
        if (r113 == null) goto L53;
        r113.setVisibility(0);
    L53:
        tt5.a.h("LoadStateViewWrapper", "showEmpty()...loadStateVisibility = " + this.f228647a.getVisibility() + ", emptyCategory = " + this.f228648b + ", wrapperHash = " + System.identityHashCode(this));
        this.f228651e.postValue(LoadStateCategory.LOADED_SUCCESS_EMPTY);
        return;
    L25:
        r104.f228626b.setPrimaryText(r104.f228629e.getContext().getString(r112));
        goto L26
    L21:
        r104.f228626b.setTitle(r104.f228629e.getContext().getString(r111));
        goto L22
    L28:
        if (r101.getImageRes() == (-1)) goto L31;
        r104.f228626b.setImageRes(Integer.valueOf(r101.getImageRes()));
    L31:
        if (r101.getTitleTextRes() != (-1)) goto L33;
        r104.f228626b.setTitle("");
    L35:
        if (r101.getDescTextRes() != (-1)) goto L37;
        r104.f228626b.setDesc("");
    L39:
        if (r101.getLintBtnTextRes() != (-1)) goto L41;
        r104.f228627c.setVisibility(8);
    L43:
        if (r101.getPrimaryBtnTextRes() != (-1)) goto L45;
        r104.f228626b.setPrimaryText("");
    L47:
        if (r101.getSecondaryBtnTextRes() != (-1)) goto L49;
        r104.f228626b.setSecondaryText("");
        goto L50
    L49:
        r104.f228626b.setSecondaryText(r104.f228629e.getContext().getString(r101.getSecondaryBtnTextRes()));
        goto L50
    L45:
        r104.f228626b.setPrimaryText(r104.f228629e.getContext().getString(r101.getPrimaryBtnTextRes()));
        goto L47
    L41:
        r104.f228627c.setVisibility(0);
        r104.f228627c.setText(r104.f228629e.getContext().getString(r101.getLintBtnTextRes()));
        goto L43
    L37:
        r104.f228626b.setDesc(r104.f228629e.getContext().getString(r101.getDescTextRes()));
        goto L39
    L33:
        r104.f228626b.setTitle(r104.f228629e.getContext().getString(r101.getTitleTextRes()));
        goto L35
    }

    public final void i() {
        tt5.a.h("LoadStateViewWrapper", "showLoadSuccess()...");
        this.f228647a.setVisibility(4);
        tt5.a.h("LoadStateViewWrapper", "showLoadSuccess()...loadStateVisibility = " + this.f228647a.getVisibility() + ", wrapperHash = " + System.identityHashCode(this));
        this.f228651e.postValue(LoadStateCategory.LOADED_SUCCESS);
    }

    public final void j() {
        tt5.a.h("LoadStateViewWrapper", "startLoading()...");
        LoadStateView r100 = this.f228647a;
        r100.f228621a.f228635c = this.f228649c;
        r100.setVisibility(0);
        LoadStateView.CurrentViewType r101 = LoadStateView.CurrentViewType.NONE;
        r100.setVisibility(0);
        View r102 = r100.f228622b.f228625a;
        if (r102 == null) goto L5;
        r102.setVisibility(8);
    L5:
        SpaceEmptyState r103 = r100.f228623c.f228630a;
        if (r103 == null) goto L8;
        r103.setVisibility(8);
    L8:
        LoadStateView.e r104 = r100.f228621a;
        if (r104.f228633a != null) goto L11;
        View r105 = View.inflate(r104.f228636d.getContext(), R.layout.load_state_loading_layout, null);
        r104.f228633a = (FrameLayout) r105.findViewById(R.id.list_state_loading_root);
        r104.f228634b = (BearLottieView) r105.findViewById(R.id.list_state_loading_Lottie_view);
        LoadStateView r106 = r104.f228636d;
        r106.addView(r105, LoadStateView.a(r106));
    L11:
        BearLottieView r107 = r104.f228634b;
        if (r107 != null) goto L14;
    L19:
        FrameLayout r108 = r104.f228633a;
        if (r108 == null) goto L22;
        r108.setVisibility(0);
    L22:
        this.f228651e.postValue(LoadStateCategory.LOADING);
        return;
    L14:
        if (r107.isAnimating() == true) goto L19;
        LoadingCategory r109 = r104.f228635c;
        if (r109 == null) goto L18;
        r104.f228634b.setAnimation(r109.getResId());
        r104.f228635c = null;
    L18:
        r104.f228634b.playAnimation();
        goto L19
    }

    public h(LoadStateView r100) {
        this.f228651e = new MutableLiveData();
        this.f228647a = r100;
        this.f228650d = r100.getContext();
    }

    public final void a(EmptyCategory r100) {
        LoadingCategory r101 = LoadingCategory.CATEGORY_LIST;
        this.f228648b = r100;
        this.f228649c = r101;
    }

    public final void b(Throwable r100) {
        tt5.a.h("LoadStateViewWrapper", "loadedFail()...throwable = " + r100.getMessage());
        if (fw4.d.b(this.f228650d) != NetworkType.NETWORK_NO) goto L6;
        h(LoadFailCategory.NO_NETWORK);
        return;
    L6:
        if ((r100 instanceof CloudReqFun.OkHttpReqException) == false) goto L8;
        boolean r101 = ((CloudReqFun.OkHttpReqException) r100).exception.equals(SocketTimeoutException.class.getName());
    L9:
        if (r101 == false) goto L11;
        h(LoadFailCategory.OVERTIME);
        return;
    L11:
        h(LoadFailCategory.UNKNOWN);
        return;
    L8:
        r101 = r100 instanceof SocketTimeoutException;
        goto L9
    }

    public final void c(int r100) {
        tt5.a.h("LoadStateViewWrapper", "loadedSuccess()...dataCount = " + r100);
        if (r100 <= 0) goto L5;
        i();
        return;
    L5:
        g();
        if (fw4.d.b(this.f228650d) != NetworkType.NETWORK_NO) goto L10;
        h(LoadFailCategory.NO_NETWORK);
        return;
    }

    public final void d(LoadStateView.a r100) {
        LoadStateView r101 = this.f228647a;
        if (r100 != null) goto L5;
        r101.getClass();
        tt5.a.d("LoadStateView", "registerEmptyStateClickHandler: EmptyStateHandler is invalid");
        return;
    L5:
        r101.f228622b.f228628d = r100;
    }

    public final void e(LoadStateView.c r100) {
        this.f228647a.f228623c.f228631b = r100;
    }

    public final void f(EmptyCategory r100) {
        tt5.a.h("LoadStateViewWrapper", "setEmptyCategory()...category=" + r100);
        this.f228648b = r100;
    }

    public final void h(LoadFailCategory r100) {
        tt5.a.h("LoadStateViewWrapper", "showLoadFail()...category = " + r100);
        LoadStateView r101 = this.f228647a;
        r101.getClass();
        LoadStateView.CurrentViewType r102 = LoadStateView.CurrentViewType.NONE;
        r101.setVisibility(0);
        LoadStateView.e.a(r101.f228621a);
        View r103 = r101.f228622b.f228625a;
        if (r103 == null) goto L5;
        r103.setVisibility(8);
    L5:
        final LoadStateView.d r104 = r101.f228623c;
        if (r104.f228630a != null) goto L8;
        SpaceEmptyState r105 = new SpaceEmptyState(r104.f228632c.getContext());
        r104.f228630a = r105;
        LoadStateView r106 = r104.f228632c;
        r106.addView(r105, LoadStateView.a(r106));
        r104.f228630a.setOnClickListener(new d(r104));
        r104.f228630a.setPrimaryClickListener(new e(r104));
        r104.f228630a.setSecondaryClickListener(new f(r104));
    L8:
        r104.f228630a.setImageSizeResource(R.dimen.ccm_emptystate_image_size_middle);
        i r107 = i.a(r104.f228632c);
        if (r107 != null) goto L11;
        i.a r108 = null;
    L13:
        if (r108 == null) goto L28;
        int r109 = r108.f228654a;
        int r110 = r108.f228655b;
        int r111 = r108.f228656c;
        int r112 = r108.f228657d;
        if (r110 == (-1)) goto L17;
        r104.f228630a.setImageSizeResource(r110);
    L17:
        if (r109 == (-1)) goto L19;
        r104.f228630a.setImageRes(Integer.valueOf(r109));
    L19:
        if (r111 != (-1)) goto L21;
        r104.f228630a.setTitle("");
    L22:
        r104.f228630a.setDesc("");
        if (r112 != (-1)) goto L25;
        r104.f228630a.setPrimaryText("");
    L26:
        r104.f228630a.setSecondaryText("");
    L46:
        SpaceEmptyState r113 = r104.f228630a;
        if (r113 == null) goto L49;
        r113.setVisibility(0);
    L49:
        this.f228651e.postValue(LoadStateCategory.LOADED_FAIL);
        return;
    L25:
        r104.f228630a.setPrimaryText(r104.f228632c.getContext().getString(r112));
        goto L26
    L21:
        r104.f228630a.setTitle(r104.f228632c.getContext().getString(r111));
        goto L22
    L28:
        if (r100.getImageRes() == (-1)) goto L31;
        r104.f228630a.setImageRes(Integer.valueOf(r100.getImageRes()));
    L31:
        if (r100.getTitleTextRes() != (-1)) goto L33;
        r104.f228630a.setTitle("");
    L35:
        if (r100.getDescTextRes() != (-1)) goto L37;
        r104.f228630a.setDesc("");
    L39:
        if (r100.getPrimaryTextRes() != (-1)) goto L41;
        r104.f228630a.setPrimaryText("");
    L43:
        if (r100.getSecondaryTextRes() != (-1)) goto L45;
        r104.f228630a.setSecondaryText("");
        goto L46
    L45:
        r104.f228630a.setSecondaryText(r104.f228632c.getContext().getString(r100.getSecondaryTextRes()));
        goto L46
    L41:
        r104.f228630a.setPrimaryText(r104.f228632c.getContext().getString(r100.getPrimaryTextRes()));
        goto L43
    L37:
        r104.f228630a.setDesc(r104.f228632c.getContext().getString(r100.getDescTextRes()));
        goto L39
    L33:
        r104.f228630a.setTitle(r104.f228632c.getContext().getString(r100.getTitleTextRes()));
        goto L35
    L11:
        r108 = r107.f228653b;
        goto L13
    }
}
