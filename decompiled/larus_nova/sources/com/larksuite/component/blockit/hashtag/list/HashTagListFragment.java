package com.larksuite.component.blockit.hashtag.list;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larksuite.component.blockit.entity.BlockEntity;
import com.larksuite.component.blockit.hashtag.add.AddHashTagActivity;
import com.larus.nova.R;
import com.ss.android.lark.base.fragment.BaseFragment;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\"\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0006\u0010\u0018\u001a\u00020\u0019R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/larksuite/component/blockit/hashtag/list/HashTagListFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "mPresenter", "Lcom/larksuite/component/blockit/hashtag/list/HashTagListPresenter;", "mAddTagRequestCode", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityCreated", "", "initMVP", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "", "Dependency", "blockit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HashTagListFragment extends BaseFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HashTagListPresenter f283020d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f283021e;

    public final class a implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HashTagListFragment f283022a;

        @Override // com.larksuite.component.blockit.hashtag.list.b.a
        public final void a() {
            if (this.f283022a.getActivity() == null) goto L18;
            HashTagListFragment r100 = this.f283022a;
            Bundle r101 = r100.getArguments();
            Serializable r102 = null;
            if (r101 == null) goto L7;
            Serializable r103 = r101.getSerializable("extra.block.entity");
        L8:
            Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.larksuite.component.blockit.entity.BlockEntity");
            BlockEntity r104 = (BlockEntity) r103;
            Bundle r105 = r100.getArguments();
            if (r105 == null) goto L11;
            String r106 = r105.getString("extra.context.json");
        L12:
            Bundle r107 = r100.getArguments();
            if (r107 == null) goto L15;
            r102 = r107.getSerializable("extra.hit_point.params");
        L15:
            if (r104 == null) goto L19;
            r100.startActivityForResult(new Intent(r100.getContext(), AddHashTagActivity.class).putExtra("extra.block.entity", r104).putExtra("extra.context.json", r106).putExtra("extra.hit_point.params", r102), r100.f283021e);
            return;
        L19:
            return;
        L11:
            r106 = null;
            goto L12
        L7:
            r103 = null;
            goto L8
        }

        @Override // com.larksuite.component.blockit.hashtag.list.b.a
        public final FragmentActivity b() {
            return this.f283022a.getActivity();
        }

        public a(HashTagListFragment r100) {
            this.f283022a = r100;
        }
    }

    public HashTagListFragment() {
        this.f283021e = 1;
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        View r101 = getView();
        if (r101 == null) goto L22;
        Bundle r102 = getArguments();
        Object r103 = null;
        if (r102 == null) goto L7;
        Serializable r104 = r102.getSerializable("extra.block.entity");
    L8:
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.larksuite.component.blockit.entity.BlockEntity");
        BlockEntity r105 = (BlockEntity) r104;
        Bundle r106 = getArguments();
        if (r106 == null) goto L11;
        String r107 = r106.getString("extra.context.json");
    L12:
        Bundle r108 = getArguments();
        if (r108 == null) goto L15;
        r103 = r108.get("extra.hit_point.params");
    L15:
        Map r109 = (Map) r103;
        if (r109 != null) goto L18;
        Map r110 = new HashMap();
    L19:
        if (r105 == null) goto L23;
        HashTagListPresenter r111 = new HashTagListPresenter(r101, new a(this), r105, r107, r110);
        this.f283020d = r111;
        r111.create();
        return;
    L23:
        return;
    L18:
        r110 = r109;
        goto L19
    L11:
        r107 = null;
        goto L12
    L7:
        r104 = null;
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        if (r100 == this.f283021e) goto L5;
        return;
    L5:
        if (r101 != (-1)) goto L11;
        HashTagListPresenter r103 = this.f283020d;
        if (r103 == null) goto L12;
        r103.H8(false);
        return;
    L12:
        return;
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.fragment_hash_tag_list, r101, false);
    }
}
