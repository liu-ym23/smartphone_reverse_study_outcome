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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class h implements ValueCallback {
    public final /* synthetic */ i a;
    public final /* synthetic */ Menu b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ ActionMode d;
    public final /* synthetic */ com.bytedance.ee.bear.contract.d e;

    public /* synthetic */ h(i r1, Menu r2, boolean r3, ActionMode r4, com.bytedance.ee.bear.contract.d r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r12) {
        i r0 = this.a;
        Menu r1 = this.b;
        boolean r2 = this.c;
        ActionMode r3 = this.d;
        com.bytedance.ee.bear.contract.d r4 = this.e;
        String r13 = (String) r12;
        r0.getClass();
        boolean r6 = true;
        if (TextUtils.isEmpty(r13) == false) goto L5;
        String r14 = "";
    L12:
        r0.g = r14;
        if (TextUtils.isEmpty(r14) == true) goto L66;
        int r16 = r1.size() - 1;
    L15:
        if (r16 < 0) goto L25;
        if (r1.getItem(r16).getGroupId() != r0.b) goto L20;
        if (r2 == false) goto L20;
    L54:
        if (com.larksuite.framework.utils.x.a() == false) goto L56;
        r3.invalidateContentRect();
    L56:
        HashMap r17 = new HashMap();
        r17.put("menu_item_total_num", Integer.valueOf(r1.size()));
        r4.v("menu_item_total", r17);
        return;
    L20:
        int r5 = r1.getItem(r16).getGroupId();
        int r8 = r0.b;
        if (r5 != r8) goto L24;
        if (r2 == true) goto L24;
        r1.removeGroup(r8);
    L24:
        r16 = r16 - 1;
        goto L15
    L25:
        if (r2 == false) goto L54;
        if (r1.size() > 0) goto L30;
    L32:
        r0.e.clear();
        PackageManager r18 = r0.a.getContext().getPackageManager();
        Intent r7 = new Intent("android.intent.action.WEB_SEARCH");
        r7.addFlags(268435456);
        if (((ArrayList) c.b(r0.a.getContext(), r7, r18)).size() != 0) goto L36;
        r6 = false;
    L36:
        if (r6 == false) goto L38;
        r0.e.put(r1.add(r0.b, 0, r0.d, 2131911650), r7);
        goto L54
    L38:
        List r9 = c.b(r0.a.getContext(), new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain"), r18);
        if (((b0) org.koin.java.a.a(b0.class)).s() == true) goto L51;
        HashMap r10 = new HashMap();
        int r11 = 0;
    L42:
        if (r11 >= ((ArrayList) r9).size()) goto L44;
        r10.put(((ResolveInfo) ListProtector.get(r9, r11)).activityInfo.packageName, Integer.valueOf(r11));
        r11 = r11 + 1;
        goto L42
    L44:
        String[] r19 = c.f;
        int r20 = r19.length;
        int r21 = 0;
    L45:
        if (r21 >= r20) goto L51;
        Integer r110 = (Integer) r10.get(r19[r21]);
        if (r110 != null) goto L48;
        r21 = r21 + 1;
        goto L45
    L48:
        r0.a(r1, (ResolveInfo) ListProtector.get(r9, r110.intValue()), r110.intValue(), r18);
    L51:
        if (((ArrayList) r9).size() == 0) goto L54;
        r0.a(r1, (ResolveInfo) ListProtector.get(r9, 0), 0, r18);
        goto L54
    L30:
        if (r1.getItem(0).getGroupId() != 6767771) goto L32;
        tt5.a.h(r0.c, "group is hyper link, return");
        goto L54
    L66:
        return;
    L5:
        r14 = r13.replace("\\n", " ").trim();
        if (r14.length() <= 1) goto L12;
        if (r14.charAt(0) != '\"') goto L12;
        if (r14.charAt(r14.length() - 1) != '\"') goto L12;
        r14 = r14.substring(1, r14.length() - 1).trim();
        goto L12
    }
}
