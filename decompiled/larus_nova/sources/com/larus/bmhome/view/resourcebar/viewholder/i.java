package com.larus.bmhome.view.resourcebar.viewholder;

import com.larus.bmhome.chat.layout.widget.i0;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;

/* JADX INFO: loaded from: classes26.dex */
public final class i implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseResourceViewHolder.a f317194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ResourceItemBean f317195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ EntityResourceViewHolder f317196c;

    @Override // com.larus.bmhome.chat.layout.widget.i0
    public final void a() {
        BaseResourceViewHolder.a r100 = this.f317194a;
        if (r100 == null) goto L6;
        r100.a(this.f317195b.getKey(), 107, this.f317196c.f317161b.f323974s);
        return;
    }

    @Override // com.larus.bmhome.chat.layout.widget.i0
    public final void b() {
        BaseResourceViewHolder.a r100 = this.f317194a;
        if (r100 == null) goto L6;
        r100.a(this.f317195b.getKey(), 108, this.f317196c.f317161b.f323974s);
        return;
    }

    public i(lt8.a r100, ResourceItemBean r101, EntityResourceViewHolder r102) {
        this.f317194a = r100;
        this.f317195b = r101;
        this.f317196c = r102;
    }
}
