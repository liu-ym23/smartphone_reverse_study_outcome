package com.ss.android.lark.todo.impl.features.detail.customfields;

import android.view.View;
import com.bytedance.lark.pb.todo.v1.SelectFieldOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import z7c.e;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f443039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CustomFieldOptionSelectAdapter f443040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SelectFieldOption f443041c;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = this.f443039a;
        long r102 = System.currentTimeMillis();
        this.f443039a = r102;
        if ((r102 - r101) >= 500) goto L5;
        return;
    L5:
        CustomFieldOptionSelectAdapter r103 = this.f443040b;
        if (r103.f443035d == false) goto L34;
        ArrayList<SelectFieldOption> r104 = r103.f443033b;
        boolean r105 = true;
        if ((r104 instanceof Collection) == true) goto L10;
    L12:
        Iterator<T> r106 = r104.iterator();
    L14:
        if (r106.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(((SelectFieldOption) r106.next()).guid, this.f443041c.guid) == false) goto L14;
        r105 = false;
    L18:
        if (r105 == false) goto L26;
        CustomFieldOptionSelectAdapter r107 = this.f443040b;
        if (r107.f443032a == false) goto L23;
        r107.f443033b.add(this.f443041c);
    L27:
        this.f443040b.notifyDataSetChanged();
        e.a r108 = this.f443040b.f443036e;
        if (r108 == null) goto L35;
        r108.a();
        return;
    L35:
        return;
    L23:
        if (r107.f443033b.isEmpty() == false) goto L25;
        this.f443040b.f443033b.add(this.f443041c);
        goto L27
    L25:
        this.f443040b.f443033b.clear();
        this.f443040b.f443033b.add(this.f443041c);
        goto L27
    L26:
        ArrayList<SelectFieldOption> r109 = this.f443040b.f443033b;
        final SelectFieldOption r110 = this.f443041c;
        CollectionsKt.removeAll(r109, new CustomFieldOptionSelectAdapter$onBindViewHolder$2$2(r110));
        goto L27
    L10:
        if (r104.isEmpty() == false) goto L12;
    }

    public a(CustomFieldOptionSelectAdapter r100, SelectFieldOption r101) {
        this.f443040b = r100;
        this.f443041c = r101;
    }
}
