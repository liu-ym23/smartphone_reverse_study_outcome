package com.bytedance.ee.bear.document.ai.citation;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ DocAICitationFragment a;

    public c(DocAICitationFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r7) {
        ShowCitationData r8 = (ShowCitationData) r7;
        DocAICitationFragment r0 = this.a;
        if (r8 != null) goto L5;
        int r9 = DocAICitationFragment.r;
        r0.getClass();
        return;
    L5:
        r0.q = r8;
        List<Citation> r1 = r8.getCitations();
        int r2 = 0;
        if (r1 == null) goto L8;
        int r3 = r1.size();
    L9:
        String r4 = r0.getResources().getQuantityString(2131755031, r3, new Object[]{Integer.valueOf(r3)});
        TextView r5 = r0.n;
        if (r5 == null) goto L12;
        r5.setText(r4);
    L12:
        ImageView r6 = r0.o;
        if (r6 != null) goto L15;
    L19:
        DocAICitationFragment.CitationAdapter r10 = r0.m;
        if (r10 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r10 = null;
    L22:
        List<Citation> r11 = r8.getCitations();
        if (r11 != null) goto L25;
        r11 = CollectionsKt.emptyList();
    L25:
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "list");
        r10.a.clear();
        r10.a.addAll(r11);
        r10.notifyDataSetChanged();
        return;
    L15:
        if (r8.getDeletable() == true) goto L18;
        r2 = 8;
    L18:
        r6.setVisibility(r2);
        goto L19
    L8:
        r3 = 0;
        goto L9
    }
}
