package com.bytedance.ee.bear.bitable.cardview.viewsetting;

import android.view.View;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class j<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CardViewSettingFragment$initUnselectFieldList$2 f209268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f209269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f209270c;

    public j(CardViewSettingFragment$initUnselectFieldList$2 r100, View r101, RecyclerView r102) {
        this.f209268a = r100;
        this.f209269b = r101;
        this.f209270c = r102;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        List r101 = (List) r100;
        CardViewSettingFragment$initUnselectFieldList$2 r102 = this.f209268a;
        Intrinsics.checkNotNull(r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, SlcCommonAction.KEY_PARAMS);
        RecyclerView r103 = r102.f209247e;
        if (r103 == null) goto L5;
        r103.post(new uq4.c(r102, r101));
    L5:
        View r104 = this.f209269b;
        int r105 = 0;
        if (r101.isEmpty() == false) goto L8;
        int r106 = 0;
    L9:
        r104.setVisibility(r106);
        RecyclerView r107 = this.f209270c;
        if ((!r101.isEmpty()) == true) goto L13;
        r105 = 8;
    L13:
        r107.setVisibility(r105);
        return;
    L8:
        r106 = 8;
        goto L9
    }
}
