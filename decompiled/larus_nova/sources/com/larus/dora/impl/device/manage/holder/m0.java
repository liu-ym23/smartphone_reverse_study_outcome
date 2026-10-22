package com.larus.dora.impl.device.manage.holder;

import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.dora.impl.databinding.LarusItemDoraGDeviceManagementSodaBannerBinding;
import java.util.List;
import kotlin.collections.CollectionsKt;
import v19.i5;

/* JADX INFO: loaded from: classes27.dex */
public final /* synthetic */ class m0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SodaBannerComponent f333859a;

    public /* synthetic */ m0(SodaBannerComponent r100) {
        this.f333859a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SodaBannerComponent r100 = this.f333859a;
        LarusItemDoraGDeviceManagementSodaBannerBinding r101 = r100.f333825d;
        if (r101 == null) goto L39;
        ViewParent r102 = r101.f333405a.getParent();
        ViewGroup.MarginLayoutParams r103 = null;
        if ((r102 instanceof RecyclerView) == false) goto L8;
        RecyclerView r104 = (RecyclerView) r102;
    L9:
        if (r104 == null) goto L40;
        int r105 = r104.getChildAdapterPosition(r101.f333405a);
        if (r105 == (-1)) goto L41;
        RecyclerView.Adapter r106 = r104.getAdapter();
        if ((r106 instanceof ListAdapter) == false) goto L17;
        ListAdapter r107 = (ListAdapter) r106;
    L18:
        if (r107 == null) goto L22;
        List r108 = r107.getCurrentList();
        if (r108 == null) goto L22;
        Object r109 = CollectionsKt.getOrNull(r108, r105 - 1);
    L23:
        boolean r110 = r109 instanceof com.larus.dora.impl.device.manage.g;
        LarusItemDoraGDeviceManagementSodaBannerBinding r111 = r100.f333825d;
        if (r111 == null) goto L42;
        ViewGroup.LayoutParams r112 = r111.f333405a.getLayoutParams();
        if ((r112 instanceof ViewGroup.MarginLayoutParams) == false) goto L29;
        r103 = (ViewGroup.MarginLayoutParams) r112;
    L29:
        if (r103 == null) goto L43;
        if (r110 == false) goto L33;
        int r113 = i5.h();
    L35:
        if (r103.topMargin == r113) goto L44;
        r103.topMargin = r113;
        r111.f333405a.setLayoutParams(r103);
        return;
    L44:
        return;
    L33:
        r113 = i5.q();
        goto L35
    L43:
        return;
    L42:
        return;
    L22:
        r109 = null;
        goto L23
    L17:
        r107 = null;
        goto L18
    L41:
        return;
    L40:
        return;
    L8:
        r104 = null;
        goto L9
    }
}
