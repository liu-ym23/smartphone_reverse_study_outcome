package com.larus.bmhome;

import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.home.impl.main.side_bar.data.ComponentTypeEnum;
import com.larus.home.impl.main.side_bar.view.SideBarContentFragment;
import com.larus.home.impl.main.side_bar.view.adapter.SideBarComponentAdapter;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import hq9.m2;
import hq9.v2;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class l0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f312455g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SideBarContentFragment f312456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f312457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile OfficeSDKUserApi f312458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile v2 f312459d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n0 f312460e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j0 f312461f;

    public static final class a {
    }

    static {
    }

    public final void b() {
        if (this.f312456a.isAdded() == true) goto L6;
        FLogger.f375446a.w("SideBarLarkBadgeManager", "refreshAddressBookBadge skip: fragment not added");
        return;
    L6:
        FLogger.f375446a.i("SideBarLarkBadgeManager", "refreshAddressBookBadge count=" + this.f312457b.get());
        ConcatAdapter r100 = this.f312456a.f344774g;
        if (r100 == null) goto L30;
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> r101 = r100.getAdapters();
        if (r101 == null) goto L38;
        Iterator<T> r102 = r101.iterator();
    L12:
        if (r102.hasNext() == false) goto L39;
        RecyclerView.Adapter r103 = (RecyclerView.Adapter) r102.next();
        if ((r103 instanceof SideBarComponentAdapter) == false) goto L12;
        SideBarComponentAdapter r104 = (SideBarComponentAdapter) r103;
        Iterator<T> r105 = r104.getCurrentList().iterator();
        int r106 = 0;
    L17:
        if (r105.hasNext() == false) goto L12;
        Object r107 = r105.next();
        int r108 = r106 + 1;
        if (r106 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        com.larus.home.impl.main.side_bar.data.j0 r109 = (com.larus.home.impl.main.side_bar.data.j0) r107;
        com.larus.home.impl.main.side_bar.data.p r110 = r109.f344509d;
        if (r110 != null) goto L24;
    L26:
        boolean r111 = false;
    L27:
        if (r111 == false) goto L29;
        r109.f344515j = this.f312457b.get();
        r104.notifyItemChanged(r106);
    L29:
        r106 = r108;
        goto L17
    L24:
        if (r110.getType() != ComponentTypeEnum.LARK_ADDRESS_BOOK.getType()) goto L26;
        r111 = true;
        goto L27
    L39:
        return;
    L38:
        return;
    }

    public final void c() {
        Object r100 = xp9.o.f564776a;
        xp9.o.d(this.f312461f);
        d();
        this.f312457b.set(0);
        com.larus.utils.y.c(new k0(this));
    }

    public final void d() {
        OfficeSDKUserApi r100 = this.f312458c;
        n0 r101 = this.f312460e;
        if (r100 == null) goto L8;
        if (r101 == null) goto L8;
        ktb.a r102 = (ktb.a) r100.getService(ktb.a.class);
        if (r102 == null) goto L8;
        r102.t1(r101);
    L8:
        this.f312458c = null;
        this.f312459d = null;
        this.f312460e = null;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.larus.bmhome.j0] */
    public l0(SideBarContentFragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f312456a = r100;
        this.f312457b = new AtomicInteger(0);
        this.f312461f = new j0(this);
    }

    public final boolean a(OfficeSDKUserApi r100, v2 r101) {
        LarkSocialExp.f365340a.getClass();
        if (LarkSocialExp.e() == true) goto L5;
    L13:
        return false;
    L5:
        if (xp9.o.f564776a != r100) goto L13;
        if (this.f312458c != r100) goto L13;
        if (Intrinsics.areEqual(this.f312459d, r101) == false) goto L13;
        if (Intrinsics.areEqual(((m2) LarkSocialExp.f365344e.getValue()).f486673b, r101) == false) goto L13;
        return true;
    }
}
