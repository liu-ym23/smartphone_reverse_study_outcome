package com.larksuite.component.blockit.hashtag.list;

import android.view.View;
import com.larksuite.component.blockit.entity.BlockEntity;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class HashTagListPresenter extends BasePresenter<j, k, k.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BlockEntity f283023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f283024b;

    public final class ViewDelegate implements k.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HashTagListPresenter f283025a;

        @Override // com.larksuite.component.blockit.hashtag.list.k.a
        public final String I6() {
            return this.f283025a.f283023a.getBlockTypeID();
        }

        public ViewDelegate(HashTagListPresenter r100) {
            this.f283025a = r100;
        }

        @Override // com.larksuite.component.blockit.hashtag.list.k.a
        public final void M3(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tagId");
            Intrinsics.checkNotNullParameter(r101, "tagInstanceId");
            j r102 = this.f283025a.getModel();
            final HashTagListPresenter r103 = this.f283025a;
            r102.G7(r100, r101, new UIGetDataCallback(new HashTagListPresenter$ViewDelegate$onDeleteTag$1(r103)));
        }
    }

    @Override // com.larksuite.framework.mvp.BasePresenter
    public final IView.IViewDelegate createViewDelegate() {
        return new ViewDelegate(this);
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        super.create();
        H8(true);
    }

    public final void H8(final boolean r100) {
        getModel().B4(this.f283023a.getBlockID(), new UIGetDataCallback(new HashTagListPresenter$loadData$1(this, r100)));
    }

    public HashTagListPresenter(View r100, HashTagListFragment.a r101, BlockEntity r102, String r103, Map r104) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r101, "viewDependency");
        Intrinsics.checkNotNullParameter(r102, "blockEntity");
        this.f283023a = r102;
        this.f283024b = r104;
        setView(new b(r100, r101, r104));
        getView().setViewDelegate(new ViewDelegate(this));
        setModel(new a(r102, r103));
    }
}
