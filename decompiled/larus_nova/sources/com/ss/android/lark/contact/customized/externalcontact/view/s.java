package com.ss.android.lark.contact.customized.externalcontact.view;

import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.contact.base.common_ui.IndexBar;
import com.ss.android.lark.contact.base.contact_list.view.IndexRecyclerViewAdapter;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;

/* JADX INFO: loaded from: classes35.dex */
public final class s implements IndexBar.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IndexRecyclerViewAdapter.b f419242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IndexRecyclerViewAdapter f419243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f419244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f419245d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ u f419246e;

    @Override // com.ss.android.lark.contact.base.common_ui.IndexBar.b
    public final void b() {
        TextView r100 = this.f419246e.f419252b;
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        this.f419242a = null;
    }

    @Override // com.ss.android.lark.contact.base.common_ui.IndexBar.b
    public final void a(String r100) {
        u r101 = this.f419246e;
        if (r101.f419256f != null) goto L5;
        r101.f419256f = (Vibrator) LarkContext.getApplication().getSystemService("vibrator");
    L5:
        r101.f419256f.vibrate(10);
        d(r100);
        int r102 = com.ss.android.lark.contact.base.statistics.a.f418949a;
        Statistics.sendEvent("contact_external_letter_click");
    }

    @Override // com.ss.android.lark.contact.base.common_ui.IndexBar.b
    public final void c(String r100) {
        u r101 = this.f419246e;
        if (r101.f419256f != null) goto L5;
        r101.f419256f = (Vibrator) LarkContext.getApplication().getSystemService("vibrator");
    L5:
        r101.f419256f.vibrate(10);
        d(r100);
    }

    public final void d(String r100) {
        if (this.f419246e.f419255e == true) goto L5;
    L10:
        IndexRecyclerViewAdapter.b r101 = this.f419242a;
        if (r101 != null) goto L13;
    L15:
        IndexRecyclerViewAdapter r102 = this.f419243b;
        r102.getClass();
        IndexRecyclerViewAdapter.b r103 = new IndexRecyclerViewAdapter.a(r102).b(r100);
        this.f419242a = r103;
        if (r103 == null) goto L25;
        int r104 = this.f419244c + r103.f418632c;
        u r105 = this.f419246e;
        RecyclerView r106 = this.f419245d;
        r105.getClass();
        ((LinearLayoutManager) r106.getLayoutManager()).scrollToPositionWithOffset(r104, 0);
        u r107 = this.f419246e;
        boolean r108 = r107.f419255e;
        IndexRecyclerViewAdapter.b r109 = this.f419242a;
        int r110 = r109.f418630a + (r108 ? 1 : 0);
        float r111 = r109.f418634e + (r108 ? 1 : 0);
        float r112 = ((r110 + 0.5f) - (r111 / 2.0f)) * ((r107.f419253c.getHeight() * 1.0f) / r111);
        u r113 = this.f419246e;
        TextView r114 = r113.f419252b;
        if (r114 == null) goto L22;
        r114.setVisibility(0);
        r113.f419252b.setText(r100);
        ViewGroup.LayoutParams r115 = r113.f419252b.getLayoutParams();
        if ((r115 instanceof ViewGroup.MarginLayoutParams) == false) goto L22;
        ((ViewGroup.MarginLayoutParams) r115).topMargin = (int) r112;
        r113.f419252b.setLayoutParams(r115);
    L22:
        this.f419246e.f419253c.setFocusIndex(r110);
        return;
    L25:
        return;
    L13:
        if (TextUtils.equals(r100, r101.f418631b) == false) goto L15;
        return;
    L5:
        if (TextUtils.equals(r100, "") == false) goto L10;
        this.f419242a = null;
        View r116 = this.f419246e.f419254d;
        if (r116 == null) goto L24;
        r116.performClick();
        return;
    }

    public s(u r100, IndexRecyclerViewAdapter r101, int r102, CommonRecyclerView r103) {
        this.f419246e = r100;
        this.f419243b = r101;
        this.f419244c = r102;
        this.f419245d = r103;
    }
}
