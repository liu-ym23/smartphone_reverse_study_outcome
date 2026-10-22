package com.ss.android.lark.contact.customized.externalcontact.view;

import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.contact.base.common_ui.IndexBar;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f419251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f419252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IndexBar f419253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f419254d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f419255e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Vibrator f419256f;

    public u(ViewGroup r100) {
        this.f419251a = (FrameLayout) r100.findViewById(R.id.index_bar_layout);
        TextView r101 = (TextView) r100.findViewById(R.id.index_bar_tip);
        this.f419252b = r101;
        this.f419253c = (IndexBar) r100.findViewById(R.id.index_bar);
        View r102 = r100.findViewById(R.id.index_bar_search);
        this.f419254d = r102;
        this.f419255e = false;
        if (r102 == null) goto L5;
        r102.setVisibility(8);
    L5:
        r101.setVisibility(8);
    }

    public final void a(Map<Integer, String> r100) {
        if (r100.isEmpty() == false) goto L11;
        FrameLayout r101 = this.f419251a;
        if (r101 == null) goto L7;
        r101.setVisibility(8);
    L7:
        this.f419253c.setNavigators(new ArrayList());
        View r102 = this.f419254d;
        if (r102 == null) goto L24;
        r102.setVisibility(8);
        return;
    L24:
        return;
    L11:
        FrameLayout r103 = this.f419251a;
        if (r103 == null) goto L14;
        r103.setVisibility(0);
    L14:
        boolean r104 = this.f419255e;
        final ArrayList r105 = new ArrayList(r100.size() + (r104 ? 1 : 0));
        if (this.f419255e == false) goto L17;
        r105.add("");
    L17:
        r105.addAll(r100.values());
        this.f419253c.setNavigators(r105);
        if (this.f419255e == false) goto L20;
        this.f419253c.post(new r(this, r105));
        return;
    L20:
        View r106 = this.f419254d;
        if (r106 == null) goto L26;
        r106.setVisibility(8);
        return;
    }
}
