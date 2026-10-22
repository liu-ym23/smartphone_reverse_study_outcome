package com.larksuite.component.card.component.text;

import android.view.View;
import com.ss.android.lark.widget.span.UrlInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class k implements mcc.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UniversalCardTextLynxUI f283654a;

    @Override // mcc.o
    public final boolean t(View r100, UrlInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "urlInfo");
        return false;
    }

    public k(UniversalCardTextLynxUI r100) {
        this.f283654a = r100;
    }

    @Override // mcc.o
    public final void r(View r100, UrlInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "urlInfo");
        UniversalCardTextLynxUI r102 = this.f283654a;
        int r103 = UniversalCardTextLynxUI.f283581g;
        r102.P(r101);
    }
}
