package com.ss.android.lark.contact.impl.group.join;

import android.content.Context;
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
public class MyJoinGroupView implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f419485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b.a f419486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f419487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ContactsMyGroupAdapter f419488d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m f419489e;

    @BindView(8790)
    View mEmptyLayout;

    @BindView(9182)
    RecyclerView mMyJoinGroupRV;

    @BindView(9181)
    LKUIPtrClassicFrameLayout mPtrFrame;

    public interface a {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        this.f419487c = null;
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        ButterKnife.bind(this, ((MyJoinGroupFragment.a) this.f419487c).f419482a.getView());
        this.f419485a = this.mMyJoinGroupRV.getContext();
        h.a(this.mMyJoinGroupRV);
        this.mMyJoinGroupRV.setLayoutManager(new LinearLayoutManager(this.f419485a));
        ContactsMyGroupAdapter r100 = new ContactsMyGroupAdapter();
        this.f419488d = r100;
        ContactsMyGroupAdapter.b r101 = new d(this);
        Intrinsics.checkNotNullParameter(r101, "onItemClickListener");
        r100.f419457d = r101;
        this.mMyJoinGroupRV.setAdapter(this.f419488d);
        int r102 = DesktopUtil.f420394a;
        ChatWindowPtrLoadingHeader r103 = new ChatWindowPtrLoadingHeader(this.f419485a);
        this.mPtrFrame.setKeepHeaderWhenRefresh(true);
        this.mPtrFrame.setFooterView(r103);
        this.mPtrFrame.addPtrUIHandler(r103);
        this.mPtrFrame.disableWhenHorizontalMove(true);
        this.mPtrFrame.setPtrHandler(new e(this));
    }

    @Override // com.ss.android.lark.contact.impl.group.join.b
    public final void n() {
        this.mPtrFrame.refreshComplete();
    }

    @Override // com.ss.android.lark.contact.impl.group.join.b
    public final void refresh() {
        ContactsMyGroupAdapter r100 = this.f419488d;
        if (r100 == null) goto L6;
        r100.notifyDataSetChanged();
        return;
    }

    @Override // com.ss.android.lark.contact.impl.group.join.b
    public final void D6(List<Chat> r100) {
        this.f419488d.diff(r100);
    }

    @Override // com.ss.android.lark.contact.impl.group.join.b
    public final void X7(List<Chat> r100) {
        if (CollectionUtils.isEmpty(r100) == false) goto L5;
        this.mMyJoinGroupRV.setVisibility(8);
        this.mEmptyLayout.setVisibility(0);
        y9c.d.k(this.mEmptyLayout);
        return;
    L5:
        this.mMyJoinGroupRV.setVisibility(0);
        this.mEmptyLayout.setVisibility(8);
        this.f419488d.diff(r100);
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f419486b = (b.a) r100;
    }

    public MyJoinGroupView(MyJoinGroupFragment.a r100, m r101) {
        this.f419487c = r100;
        this.f419489e = r101;
    }
}
