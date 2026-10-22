package com.ss.android.ugc.aweme.kiwi.util;

import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/kiwi/util/Query;", "", "kiwi_release"}, k = 1, mv = {1, 4, 0})
public final class Query {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<View> f450936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f450937b;

    public final void c() {
        g(8);
    }

    public final boolean d() {
        View r100 = this.f450937b;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getVisibility() != 0) goto L10;
        return true;
    L10:
        return false;
    }

    public final <T extends View> T f() {
        T r100 = (T) this.f450937b;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new TypeCastException("null cannot be cast to non-null type T");
    }

    public Query(View r100) {
        this.f450937b = r100;
        this.f450936a = new SparseArray();
    }

    public final void a(View.OnClickListener r100) {
        View r101 = this.f450937b;
        if (r101 == null) goto L6;
        r101.setOnClickListener(r100);
        return;
    }

    public final Query b(int r100) {
        View r101 = this.f450936a.get(r100);
        if (r101 != null) goto L7;
        View r102 = this.f450937b;
        if (r102 == null) goto L7;
        r101 = r102.findViewById(r100);
    L7:
        this.f450936a.put(r100, r101);
        return new Query(r101);
    }

    public final void e(CharSequence r100) {
        View r101 = this.f450937b;
        if ((r101 instanceof TextView) == false) goto L6;
        ((TextView) r101).setText(r100);
        return;
    }

    public final void g(int r100) {
        View r101 = this.f450937b;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getVisibility() == r100) goto L9;
        this.f450937b.setVisibility(r100);
        return;
    }
}
