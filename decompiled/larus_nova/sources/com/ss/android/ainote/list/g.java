package com.ss.android.ainote.list;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes34.dex */
public final class g implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AINoteGalleryView f407076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ xra.b f407077b;

    public g(AINoteGalleryView r100, xra.b r101) {
        this.f407076a = r100;
        this.f407077b = r101;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        Function0<Boolean> r101 = this.f407076a.getCanHandleLongPress();
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L9:
        if (r102 == false) goto L12;
        int r103 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteGalleryView", "image long click ignored by canHandleLongPress, imageId=" + this.f407077b.f564919a);
        return false;
    L12:
        int r104 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteGalleryView", "image long click, imageId=" + this.f407077b.f564919a);
        Function1<xra.b, Unit> r105 = this.f407076a.getOnImageLongClick();
        if (r105 == null) goto L15;
        r105.invoke(this.f407077b);
    L15:
        return true;
    L5:
        if (r101.invoke().booleanValue() == true) goto L7;
        r102 = true;
        goto L9
    }
}
