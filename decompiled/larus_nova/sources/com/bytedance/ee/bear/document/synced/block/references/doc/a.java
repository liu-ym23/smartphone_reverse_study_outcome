package com.bytedance.ee.bear.document.synced.block.references.doc;

import android.view.View;
import com.bytedance.ee.bear.document.synced.block.references.entity.DocReferencesResult;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SyncedSourceDocReferencesAdapter f221951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DocReferencesResult.References f221952b;

    public a(SyncedSourceDocReferencesAdapter r100, DocReferencesResult.References r101) {
        this.f221951a = r100;
        this.f221952b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f221951a.f221919a.a(this.f221952b);
    }
}
