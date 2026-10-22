package com.bytedance.ee.bear.lark.selector;

import android.app.Activity;
import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.larksuite.framework.mvp.IView;
import com.larus.nova.R;
import com.ss.android.lark.ui.CommonTitleBar;

/* JADX INFO: loaded from: classes16.dex */
public class DocsConfirmView implements IView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.lark.selector.base.b f227475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f227476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DocsConfirmAdapter f227477c;

    @BindView(11788)
    RecyclerView mRecyclerView;

    @BindView(15147)
    CommonTitleBar mTitleBar;

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        DocConfirmActivity.a r100 = (DocConfirmActivity.a) this.f227475a;
        r100.getClass();
        ButterKnife.bind(r100.f227454a);
        this.mRecyclerView = (RecyclerView) ((Activity) this.f227476b).findViewById(R.id.content_rv);
        this.mTitleBar = (CommonTitleBar) ((Activity) this.f227476b).findViewById(R.id.titlebar);
        LinearLayoutManager r101 = new LinearLayoutManager(this.f227476b, 1, false);
        this.mRecyclerView.setLayoutManager(r101);
        DocsConfirmAdapter r102 = new DocsConfirmAdapter(this.f227476b);
        this.f227477c = r102;
        this.mRecyclerView.setAdapter(r102);
        DocsConfirmAdapter r103 = this.f227477c;
        r103.f227473b = new g(this);
    }

    @Override // com.larksuite.framework.mvp.IView
    public final /* bridge */ /* synthetic */ void setViewDelegate(IView.IViewDelegate r100) {
        com.bytedance.ee.bear.lark.selector.base.a r101 = (com.bytedance.ee.bear.lark.selector.base.a) r100;
    }

    public DocsConfirmView(Context r100, DocConfirmActivity.a r101) {
        this.f227475a = r101;
        this.f227476b = r100;
    }
}
