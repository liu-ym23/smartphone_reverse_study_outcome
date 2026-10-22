package jq4;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.card.model.enums.ETableType;
import com.bytedance.ee.util.ui.ColorUtils;
import com.larus.nova.R;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f500054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public cp4.a f500055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f500056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f500057d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f500058e;

    public t(l r100) {
        this.f500057d = true;
        this.f500058e = com.bytedance.ee.bear.appsetting.c.a.f206237a.h("ccm.bitable.mobile.support_remote_compute");
        this.f500056c = r100;
        this.f500054a = r100.getRootView().getContext();
    }

    public final void a(cp4.a r100, boolean r101) {
        tt5.a.b("RecordPresenter_record", "setRecord: " + r100 + " needScrollTo: " + r101);
        this.f500055b = r100;
        if (this.f500057d == false) goto L22;
        if (r101 == false) goto L22;
        this.f500056c.d(r100.f464634a.f464667k);
        cp4.a r102 = this.f500055b;
        cp4.b r103 = r102.f464634a;
        String r104 = r103.f464670n;
        if (TextUtils.equals(r102.f464635b, r103.f464669m) == true) goto L8;
    L12:
        boolean r105 = false;
    L13:
        if (r105 == false) goto L21;
        cp4.a r106 = this.f500055b;
        String r107 = r106.f464634a.f464667k;
        Iterator<dp4.a> r108 = r106.f464646m.iterator();
    L17:
        if (r108.hasNext() == false) goto L21;
        dp4.a r109 = r108.next();
        if (TextUtils.equals(r107, r109.f469587a.f478255b) == false) goto L17;
        r109.f469589c = this.f500055b.f464634a.f464671o;
    L21:
        this.f500057d = false;
        goto L22
    L8:
        if (TextUtils.isEmpty(r104) == false) goto L10;
    L11:
        r105 = true;
        goto L13
    L10:
        if (TextUtils.equals(this.f500055b.f464645l, r104) == false) goto L12;
    L22:
        int r110 = this.f500054a.getResources().getColor(R.color.primary_fill_default);
        if (TextUtils.isEmpty(r100.f464638e) == false) goto L53;
    L28:
        this.f500056c.setHeaderColor(r110);
        this.f500056c.setFiltered(r100.f464639f);
        if (this.f500058e == false) goto L35;
        cp4.b r111 = r100.f464634a;
        if (r111.f464675s != ETableType.LINK) goto L35;
        if (r111.f464681y == false) goto L35;
        this.f500056c.setTitle(r100.f464637d);
    L43:
        this.f500056c.setAddRecordTitleBarVisibility(Boolean.valueOf(r100.f464634a.g()));
        l r112 = this.f500056c;
        boolean r113 = r100.f464643j;
        cp4.b r114 = r100.f464634a;
        r112.k(r113, r114.f464675s, r114.f464681y);
        cp4.b r115 = r100.f464634a;
        if (r115.f464675s != ETableType.LINK) goto L51;
        String r116 = r115.f464661e;
        if (TextUtils.isEmpty(r116) == true) goto L48;
    L50:
        this.f500056c.setTableTitle(r116);
        goto L51
    L48:
        if (this.f500058e == false) goto L50;
        r116 = this.f500054a.getString(R.string.Bitable_AdvancedPermission_NotAccessibleTable);
    L51:
        this.f500056c.j(r100);
        return;
    L35:
        l r117 = this.f500056c;
        cp4.a r118 = this.f500055b;
        List<dp4.a> r119 = r118.f464646m;
        String r120 = r118.f464636c;
        Iterator<dp4.a> r121 = r119.iterator();
    L37:
        if (r121.hasNext() == false) goto L41;
        dp4.a r122 = r121.next();
        if (TextUtils.equals(r120, r122.f469587a.f478255b) == false) goto L37;
    L42:
        r117.setTitle(r122);
        goto L43
    L41:
        r122 = null;
        goto L42
    L53:
        r110 = ColorUtils.h(r100.f464638e);     // Catch: IllegalArgumentException -> L26
    L26:
        e = move-exception;
        tt5.a.e("RecordPresenter", "parse color error", e, false);
        goto L28
    }
}
