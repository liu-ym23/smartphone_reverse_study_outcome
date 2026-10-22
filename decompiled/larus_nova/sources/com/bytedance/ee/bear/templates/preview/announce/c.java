package com.bytedance.ee.bear.templates.preview.announce;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f239171a;

    public c(d r100) {
        this.f239171a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        AnnounceTemplateViewModel r101 = this.f239171a.f239178g;
        if (r101 == null) goto L18;
        Intrinsics.checkNotNull(r101);
        if (r101.getTemplates().getValue() == null) goto L19;
        AnnounceTemplateViewModel r102 = this.f239171a.f239178g;
        if (r102 == null) goto L11;
        MutableLiveData<Integer> r103 = r102.getCurrTemplatePos();
        if (r103 == null) goto L11;
        Integer r104 = r103.getValue();
    L12:
        if (r104 == null) goto L20;
        Integer r105 = Integer.valueOf(r104.intValue() + 1);
        AnnounceTemplateViewModel r106 = this.f239171a.f239178g;
        if (r106 == null) goto L16;
        r106.loadAnnounceUrl(r105.intValue(), false);
    L16:
        this.f239171a.a(r105.intValue());
        return;
    L20:
        return;
    L11:
        r104 = null;
        goto L12
    L19:
        return;
    }
}
