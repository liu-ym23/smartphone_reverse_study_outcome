package com.bytedance.ee.bear.lark.selector;

import android.app.Activity;
import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.larksuite.framework.mvp.IView;
import com.ss.android.lark.ui.CommonTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocsConfirmView implements IView {
    public final com.bytedance.ee.bear.lark.selector.base.b a;
    public final Context b;
    public DocsConfirmAdapter c;

    @BindView(11788)
    RecyclerView mRecyclerView;

    @BindView(15147)
    CommonTitleBar mTitleBar;

    public final void destroy() {
    }

    public final void create() {
        DocConfirmActivity.a r0 = (DocConfirmActivity.a) this.a;
        r0.getClass();
        ButterKnife.bind(r0.a);
        this.mRecyclerView = ((Activity) this.b).findViewById(2131367849);
        this.mTitleBar = ((Activity) this.b).findViewById(2131388928);
        LinearLayoutManager r1 = new LinearLayoutManager(this.b, 1, false);
        this.mRecyclerView.setLayoutManager(r1);
        DocsConfirmAdapter r2 = new DocsConfirmAdapter(this.b);
        this.c = r2;
        this.mRecyclerView.setAdapter(r2);
        DocsConfirmAdapter r3 = this.c;
        r3.b = new g(this);
    }

    public final /* bridge */ /* synthetic */ void setViewDelegate(IView.IViewDelegate r1) {
        com.bytedance.ee.bear.lark.selector.base.a r2 = (com.bytedance.ee.bear.lark.selector.base.a) r1;
    }

    public DocsConfirmView(Context r1, DocConfirmActivity.a r2) {
        this.a = r2;
        this.b = r1;
    }
}
