package com.bytedance.ee.bear.templates.preview.announce;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ d a;

    public c(d r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        AnnounceTemplateViewModel r5 = this.a.g;
        if (r5 == null) goto L18;
        Intrinsics.checkNotNull(r5);
        if (r5.getTemplates().getValue() == null) goto L19;
        AnnounceTemplateViewModel r6 = this.a.g;
        if (r6 == null) goto L11;
        MutableLiveData<Integer> r7 = r6.getCurrTemplatePos();
        if (r7 == null) goto L11;
        Integer r8 = (Integer) r7.getValue();
    L12:
        if (r8 == null) goto L20;
        Integer r9 = Integer.valueOf(r8.intValue() + 1);
        AnnounceTemplateViewModel r0 = this.a.g;
        if (r0 == null) goto L16;
        r0.loadAnnounceUrl(r9.intValue(), false);
    L16:
        this.a.a(r9.intValue());
        return;
    L20:
        return;
    L11:
        r8 = null;
        goto L12
    L19:
        return;
    }
}
