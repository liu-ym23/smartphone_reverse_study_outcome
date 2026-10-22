package com.bytedance.ee.bear.list.sidebar.homedrive.pinfolder.banner;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.homepage.banner.f;
import com.bytedance.ee.bear.list.homepage.banner.g;
import com.bytedance.ee.bear.list.homepage.navigation.NavigationEnum;
import com.larksuite.framework.mvp.IModel;
import com.larksuite.framework.mvp.IView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends com.bytedance.ee.bear.list.homepage.banner.a<f, g<g.a>, g.a> {
    public final ce5.a g;

    @Override // com.bytedance.ee.bear.list.homepage.banner.a
    public final String J8() {
        return "new_drive";
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.a
    public final String M8() {
        return "";
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.a
    public final void I8() {
        this.g.e.w2("/list/space/activity").j("extra_destination", NavigationEnum.PIN_FOLDER.id).e();
    }

    public final IModel getModel() {
        return this.c;
    }

    public final IView getView() {
        return this.d;
    }

    public final void setModel(IModel r2) {
        M r3 = (M) r2;
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        this.c = r3;
    }

    public final void setView(IView r2) {
        V r3 = (V) r2;
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        this.d = r3;
    }

    public b(ce5.a r7, LifeCycleFragment r8, Context r9, a r10, c r11) {
        super(r8, r9, r10, r11, r7);
        this.g = r7;
    }
}
