package com.ss.android.ainote.list;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
public final class k implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ xra.b f407083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AINoteGalleryView f407084b;

    public k(xra.b r100, AINoteGalleryView r101) {
        this.f407083a = r100;
        this.f407084b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        int r101 = com.ss.android.ainote.t.f407207a;
        StringBuilder r102 = new StringBuilder("retry clicked, imageId=");
        r102.append(this.f407083a.f564919a);
        r102.append(", uploadState=");
        r102.append(this.f407083a.f564926h);
        r102.append(", hasLocal=");
        boolean r103 = true;
        r102.append(!StringsKt.isBlank(this.f407083a.f564920b));
        r102.append(", hasRemote=");
        if (this.f407083a.b() != null) goto L6;
        r103 = false;
    L6:
        r102.append(r103);
        r102.append(", lastError=");
        r102.append(this.f407083a.f564928j);
        com.ss.android.ainote.t.d("AINoteGalleryView", r102.toString());
        Function1<String, Unit> r104 = this.f407084b.getOnImageRetry();
        if (r104 == null) goto L10;
        r104.invoke(this.f407083a.f564919a);
        return;
    }
}
