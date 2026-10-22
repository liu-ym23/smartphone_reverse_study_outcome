package com.ss.android.lark.contact.impl.group.manage;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.contact.impl.group.ContactsMyGroupAdapter;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.widget.ChatWindowPtrLoadingHeader;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import q9b.m;
import zdc.h;

/* JADX INFO: loaded from: classes35.dex */
public class MyManageGroupView implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f419505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f419506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b.a f419507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ContactsMyGroupAdapter f419508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f419509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m f419510f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f419511g;

    @BindView(8790)
    View mEmptyLayout;

    @BindView(9182)
    RecyclerView mMyManageGroupRV;

    @BindView(9181)
    LKUIPtrClassicFrameLayout mPtrFrame;

    public interface a {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        this.f419506b = null;
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        MyManageGroupFragment r100 = ((c) this.f419506b).f419513a;
        int r101 = MyManageGroupFragment.f419497i;
        ButterKnife.bind(this, r100.getView());
        this.f419505a = this.mMyManageGroupRV.getContext();
        h.a(this.mMyManageGroupRV);
        this.mMyManageGroupRV.setLayoutManager(new LinearLayoutManager(this.f419505a));
        this.f419508d = new ContactsMyGroupAdapter();
        this.mMyManageGroupRV.setItemAnimator(null);
        this.mMyManageGroupRV.setAdapter(this.f419508d);
        int r102 = DesktopUtil.f420394a;
        ContactsMyGroupAdapter r103 = this.f419508d;
        ContactsMyGroupAdapter.b r104 = new e(this);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "onItemClickListener");
        r103.f419457d = r104;
        this.f419508d.getClass();
        ContactsMyGroupAdapter r105 = this.f419508d;
        r105.f419458e = this.f419511g;
        r105.f419459f = null;
        ChatWindowPtrLoadingHeader r106 = new ChatWindowPtrLoadingHeader(this.f419505a);
        this.mPtrFrame.setKeepHeaderWhenRefresh(true);
        this.mPtrFrame.setFooterView(r106);
        this.mPtrFrame.addPtrUIHandler(r106);
        this.mPtrFrame.disableWhenHorizontalMove(true);
        this.mPtrFrame.setPtrHandler(new g(this));
    }

    @Override // com.ss.android.lark.contact.impl.group.manage.b
    public final void n() {
        this.mPtrFrame.refreshComplete();
    }

    @Override // com.ss.android.lark.contact.impl.group.manage.b
    public final void refresh() {
        ContactsMyGroupAdapter r100 = this.f419508d;
        if (r100 == null) goto L6;
        r100.notifyDataSetChanged();
        return;
    }

    @Override // com.ss.android.lark.contact.impl.group.manage.b
    public final void B5(List<Chat> r100) {
        if (CollectionUtils.isEmpty(r100) == false) goto L5;
        this.mMyManageGroupRV.setVisibility(8);
        this.mEmptyLayout.setVisibility(0);
        y9c.d.k(this.mEmptyLayout);
    L6:
        fsb.f.b().f(this.mMyManageGroupRV);
        return;
    L5:
        this.mMyManageGroupRV.setVisibility(0);
        this.mEmptyLayout.setVisibility(8);
        this.f419508d.diff(r100);
        goto L6
    }

    @Override // com.ss.android.lark.contact.impl.group.manage.b
    public final void i8(List<Chat> r100) {
        this.f419508d.diff(r100);
        this.mMyManageGroupRV.getRootView().requestLayout();
    }

    @Override // com.ss.android.lark.contact.impl.group.manage.b
    public final void setEnableChatPreview(boolean r100) {
        this.f419511g = false;
        this.f419508d.f419458e = false;
    }

    @Override // com.ss.android.lark.contact.impl.group.manage.b
    public final void setExtras(Bundle r100) {
        this.f419508d.f419459f = null;
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f419507c = (b.a) r100;
    }

    public MyManageGroupView(c r100, List r101, m r102) {
        this.f419511g = false;
        this.f419506b = r100;
        this.f419509e = r101;
        this.f419510f = r102;
    }
}
