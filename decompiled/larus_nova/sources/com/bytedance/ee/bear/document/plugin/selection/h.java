package com.bytedance.ee.bear.document.plugin.selection;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.Menu;
import android.webkit.ValueCallback;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class h implements ValueCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f220930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Menu f220931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f220932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ActionMode f220933d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.contract.d f220934e;

    public /* synthetic */ h(i r100, Menu r101, boolean r102, ActionMode r103, com.bytedance.ee.bear.contract.d r104) {
        this.f220930a = r100;
        this.f220931b = r101;
        this.f220932c = r102;
        this.f220933d = r103;
        this.f220934e = r104;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r110) {
        i r100 = this.f220930a;
        Menu r101 = this.f220931b;
        boolean r102 = this.f220932c;
        ActionMode r103 = this.f220933d;
        com.bytedance.ee.bear.contract.d r104 = this.f220934e;
        String r111 = (String) r110;
        r100.getClass();
        boolean r105 = true;
        if (TextUtils.isEmpty(r111) == false) goto L5;
        String r112 = "";
    L12:
        r100.f220935g = r112;
        if (TextUtils.isEmpty(r112) == true) goto L66;
        int r113 = r101.size() - 1;
    L15:
        if (r113 < 0) goto L25;
        if (r101.getItem(r113).getGroupId() != r100.f220923b) goto L20;
        if (r102 == false) goto L20;
    L54:
        if (com.larksuite.framework.utils.x.a() == false) goto L56;
        r103.invalidateContentRect();
    L56:
        HashMap r114 = new HashMap();
        r114.put("menu_item_total_num", Integer.valueOf(r101.size()));
        r104.v("menu_item_total", r114);
        return;
    L20:
        int r106 = r101.getItem(r113).getGroupId();
        int r107 = r100.f220923b;
        if (r106 != r107) goto L24;
        if (r102 == true) goto L24;
        r101.removeGroup(r107);
    L24:
        r113 = r113 - 1;
        goto L15
    L25:
        if (r102 == false) goto L54;
        if (r101.size() > 0) goto L30;
    L32:
        r100.f220926e.clear();
        PackageManager r115 = r100.f220922a.getContext().getPackageManager();
        Intent r108 = new Intent("android.intent.action.WEB_SEARCH");
        r108.addFlags(268435456);
        if (((ArrayList) c.b(r100.f220922a.getContext(), r108, r115)).size() != 0) goto L36;
        r105 = false;
    L36:
        if (r105 == false) goto L38;
        r100.f220926e.put(r101.add(r100.f220923b, 0, r100.f220925d, R.string.lkui_navigation_search), r108);
        goto L54
    L38:
        List r109 = c.b(r100.f220922a.getContext(), new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain"), r115);
        if (((b0) org.koin.java.a.a(b0.class)).s() == true) goto L51;
        HashMap r116 = new HashMap();
        int r117 = 0;
    L42:
        if (r117 >= ((ArrayList) r109).size()) goto L44;
        r116.put(((ResolveInfo) ListProtector.get(r109, r117)).activityInfo.packageName, Integer.valueOf(r117));
        r117 = r117 + 1;
        goto L42
    L44:
        String[] r118 = c.f220921f;
        int r119 = r118.length;
        int r120 = 0;
    L45:
        if (r120 >= r119) goto L51;
        Integer r121 = (Integer) r116.get(r118[r120]);
        if (r121 != null) goto L48;
        r120 = r120 + 1;
        goto L45
    L48:
        r100.a(r101, (ResolveInfo) ListProtector.get(r109, r121.intValue()), r121.intValue(), r115);
    L51:
        if (((ArrayList) r109).size() == 0) goto L54;
        r100.a(r101, (ResolveInfo) ListProtector.get(r109, 0), 0, r115);
        goto L54
    L30:
        if (r101.getItem(0).getGroupId() != 6767771) goto L32;
        tt5.a.h(r100.f220924c, "group is hyper link, return");
        goto L54
    L66:
        return;
    L5:
        r112 = r111.replace("\\n", " ").trim();
        if (r112.length() <= 1) goto L12;
        if (r112.charAt(0) != '\"') goto L12;
        if (r112.charAt(r112.length() - 1) != '\"') goto L12;
        r112 = r112.substring(1, r112.length() - 1).trim();
        goto L12
    }
}
