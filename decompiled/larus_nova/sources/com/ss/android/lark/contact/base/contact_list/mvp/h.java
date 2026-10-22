package com.ss.android.lark.contact.base.contact_list.mvp;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.contact.base.contact_list.view.FloatingBarItemDecoration;
import com.ss.android.lark.contact.base.contact_list.view.IndexRecyclerViewAdapter;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public final class h implements com.ss.android.lark.contact.base.contact_list.view.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f418601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ExternalContactView2.a f418602b;

    @Override // com.ss.android.lark.contact.base.contact_list.view.d
    public final void b() {
        FloatingBarItemDecoration r100 = this.f418602b.f418583a;
        Map<Integer, String> r101 = ((IndexRecyclerViewAdapter) this.f418601a.getAdapter()).f418627b;
        r100.getClass();
        LinkedHashMap r102 = (LinkedHashMap) r101;
        r100.f418625i = new LinkedList(new LinkedHashSet(r102.values()));
        r100.f418624h = r102;
    }

    public h(ExternalContactView2.a r100, RecyclerView r101) {
        this.f418602b = r100;
        this.f418601a = r101;
    }
}
