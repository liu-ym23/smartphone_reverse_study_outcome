package com.ss.android.lark.contact.customized.externalcontact.view;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public final class n implements com.ss.android.lark.contact.base.contact_list.view.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f419233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f419234b;

    @Override // com.ss.android.lark.contact.base.contact_list.view.d
    public final void b() {
        o r100 = this.f419234b;
        RecyclerView r101 = this.f419233a;
        r100.getClass();
        int r102 = o.b(r101);
        o r103 = this.f419234b;
        RecyclerView r104 = this.f419233a;
        r103.getClass();
        Map<Integer, String> r105 = OfficeFloatingBarItemDecoration.i(o.a(r104).f418627b, r102);
        OfficeFloatingBarItemDecoration r106 = this.f419234b.f419235a;
        r106.getClass();
        if (r105 != null) goto L5;
        r105 = Collections.emptyMap();
    L5:
        r106.f419194j = new LinkedList(new LinkedHashSet(r105.values()));
        r106.f419193i = r105;
    }

    public n(o r100, CommonRecyclerView r101) {
        this.f419234b = r100;
        this.f419233a = r101;
    }
}
