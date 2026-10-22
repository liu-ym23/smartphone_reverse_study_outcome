package com.larus.home.impl.route;

import android.R;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.larus.common.apphost.AppHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class d1 extends ArrayAdapter<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c1 f346069a;

    public d1(Activity r100, String[] r101, c1 r102) {
        this.f346069a = r102;
        super(r100, R.layout.simple_list_item_1, r101);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int r100, View r101, ViewGroup r102) {
        Intrinsics.checkNotNullParameter(r102, "parent");
        View r103 = super.getView(r100, r101, r102);
        if ((r103 instanceof TextView) == false) goto L11;
        this.f346069a.getClass();
        boolean r104 = true;
        if (AppHost.f326268a.getApplication().getResources().getConfiguration().getLayoutDirection() == 1) goto L8;
        r104 = false;
    L8:
        if (r104 == false) goto L10;
        ((TextView) r103).setGravity(21);
        goto L11
    L10:
        ((TextView) r103).setGravity(19);
    L11:
        return r103;
    }
}
