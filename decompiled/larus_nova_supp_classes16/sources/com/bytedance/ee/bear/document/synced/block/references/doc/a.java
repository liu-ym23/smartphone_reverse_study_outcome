package com.bytedance.ee.bear.document.synced.block.references.doc;

import android.view.View;
import com.bytedance.ee.bear.document.synced.block.references.entity.DocReferencesResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ SyncedSourceDocReferencesAdapter a;
    public final /* synthetic */ DocReferencesResult.References b;

    public a(SyncedSourceDocReferencesAdapter r1, DocReferencesResult.References r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.a.a(this.b);
    }
}
