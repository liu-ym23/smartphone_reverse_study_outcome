package com.larus.community.impl.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.community.host.databinding.LarusFragmentCreationDetailHostBinding;
import com.larus.nova.R;
import com.larus.platform.api.creation.UserCreation;
import com.larus.trace.tracknode.TraceFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0015H\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0012H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/community/impl/detail/CreationDetailHostFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/community/api/spi/ICommunityDetailContainer;", "<init>", "()V", "binding", "Lcom/larus/community/host/databinding/LarusFragmentCreationDetailHostBinding;", "gson", "Lcom/google/gson/Gson;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onCommunityDetailLoaded", "", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "handleCommunityActivityResult", "data", "Landroid/content/Intent;", "onCommunityBackPressed", "findCreationDetailResultHandler", "Lcom/larus/community/api/spi/ICommunityDetailActivityResultHandler;", "autoLogEnterPage", "getCurrentPageName", "", "onDestroyView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailHostFragment extends TraceFragment implements e29.g {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f329188g = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LarusFragmentCreationDetailHostBinding f329189e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Gson f329190f;

    @Override // com.larus.trace.tracknode.TraceFragment
    public final boolean S90() {
        return false;
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "CreationDetailHostFragment";
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        this.f329189e = null;
        super.onDestroyView();
    }

    @Override // e29.g
    public final boolean K20() {
        LarusFragmentCreationDetailHostBinding r100 = this.f329189e;
        if (r100 == null) goto L9;
        ViewPager2 r101 = r100.f328766b;
        if (r101 == null) goto L9;
        if (r101.getCurrentItem() != 1) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L16;
        LarusFragmentCreationDetailHostBinding r103 = this.f329189e;
        if (r103 == null) goto L18;
        ViewPager2 r104 = r103.f328766b;
        if (r104 == null) goto L19;
        r104.setCurrentItem(0, true);
        return true;
    L19:
        return true;
    L18:
        return true;
    L16:
        return false;
    L9:
        r102 = false;
        goto L10
    }

    public CreationDetailHostFragment() {
        this.f329190f = new Gson();
    }

    @Override // e29.g
    public final boolean g40(final UserCreation r100) {
        Intrinsics.checkNotNullParameter(r100, "userCreation");
        LarusFragmentCreationDetailHostBinding r101 = this.f329189e;
        if (r101 == null) goto L12;
        final ViewPager2 r102 = r101.f328766b;
        if (r102 == null) goto L14;
        final Bundle r103 = getArguments();
        if (r103 != null) goto L10;
        r103 = new Bundle();
        setArguments(r103);
    L10:
        r103.putString("creation", GsonProtectorUtils.toJson(this.f329190f, r100));
        r102.post(new e0(this, r102, r103, r100));
        return true;
    L14:
        return false;
    L12:
        return false;
    }

    @Override // e29.g
    public final void j6(Intent r100) {
        List<Fragment> r101 = getChildFragmentManager().getFragments();
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Object r104 = r103.next();
        if ((r104 instanceof e29.f) == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        e29.f r105 = (e29.f) CollectionsKt.firstOrNull(r102);
        if (r105 == null) goto L17;
        r105.j6(r100);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Bundle r102 = getArguments();
        if (r102 != null) goto L5;
        r102 = new Bundle();
    L5:
        String r103 = r102.getString("creation");
        boolean r104 = true;
        Object r105 = null;
        if (r103 != null) goto L8;
    L21:
        LarusFragmentCreationDetailHostBinding r106 = this.f329189e;
        if (r106 == null) goto L37;
        ViewPager2 r107 = r106.f328766b;
        if (r107 != null) goto L26;
        return;
    L26:
        if (r105 == null) goto L28;
        boolean r108 = true;
    L29:
        r107.setAdapter(new CreationDetailHostPagerAdapter(this, r102, r108));
        r107.setOffscreenPageLimit(1);
        if (r105 != null) goto L33;
        r104 = false;
    L33:
        r107.setUserInputEnabled(r104);
        r107.setCurrentItem(0, false);
        r107.setPageTransformer(new d0());
        return;
    L28:
        r108 = false;
        goto L29
    L37:
        return;
    L8:
        if ((!StringsKt.isBlank(r103)) == true) goto L11;
        r103 = null;
    L11:
        if (r103 == null) goto L21;
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L14
        Object r110 = Result.m9449constructorimpl((UserCreation) xt7.d.f565073b.c(UserCreation.Companion.serializer(), r103));     // Catch: Throwable -> L14
    L17:
        if (Result.m9455isFailureimpl(r110) == true) goto L20;
        r105 = r110;
    L20:
        r105 = (UserCreation) r105;
    L14:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.larus_fragment_creation_detail_host, r101, false);
        ViewPager2 r104 = (ViewPager2) ViewBindings.findChildViewById(r103, R.id.view_pager_host);
        if (r104 == null) goto L7;
        ConstraintLayout r105 = (ConstraintLayout) r103;
        this.f329189e = new LarusFragmentCreationDetailHostBinding(r105, r104);
        return r105;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(R.id.view_pager_host)));
    }
}
