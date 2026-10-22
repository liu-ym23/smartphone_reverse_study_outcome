package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.miui.easygo.constant.EasyGoConstant;
import com.vivo.push.model.InsideNotificationItem;

/* JADX INFO: loaded from: classes41.dex */
public final class k implements BaseNotifyDataAdapter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f462580e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f462581f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Resources f462582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f462583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f462584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f462585d;

    public k() {
    }

    private static boolean a(int r100) {
        if (r100 == (-1)) goto L7;
        if (r100 == 0) goto L9;
        return true;
    L9:
        return false;
    L7:
        return false;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getNotifyMode(InsideNotificationItem r100) {
        return 2;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultNotifyIcon() {
        if (a(f462580e) == true) goto L5;
        String r100 = this.f462585d;
        if (a(r100) == true) goto L9;
        t.d("DefaultNotifyDataAdapter", "getNotifyIconByArdVersion isSystemCodeUsable is false ");
        int r101 = -1;
    L10:
        f462580e = r101;
        if (a(r101) == true) goto L13;
        String r102 = this.f462584c;
    L15:
        t.d("DefaultNotifyDataAdapter", "getNotifyIconByRomVersion codeReg = ".concat(String.valueOf(r102)));
        if (TextUtils.isEmpty(r102) == true) goto L18;
        int r103 = this.f462582a.getIdentifier("vivo_push_rom" + r102 + "_notifyicon", "drawable", this.f462583b);
        if (r103 > 0) goto L21;
        r102 = r102.substring(0, r102.length() - 1);
        goto L15
    L21:
        t.d("DefaultNotifyDataAdapter", "getNotifyIconByRomVersion find notifyicon = vivo_push_rom" + r102 + "_notifyicon");
        return r103;
    L18:
        return this.f462582a.getIdentifier("vivo_push_notifyicon", "drawable", this.f462583b);
    L13:
        return f462580e;
    L9:
        r101 = a(r100, "_notifyicon");
        goto L10
    L5:
        return f462580e;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultSmallIconId() {
        if (a(f462581f) == true) goto L5;
        String r100 = this.f462585d;
        if (a(r100) == true) goto L9;
        t.d("DefaultNotifyDataAdapter", "getSmallIconByArdVersion isSystemCodeUsable is false ");
        int r101 = -1;
    L10:
        f462581f = r101;
        if (a(r101) == true) goto L13;
        String r102 = this.f462584c;
    L15:
        t.d("DefaultNotifyDataAdapter", "getSmallIconByRomVersion codeReg = ".concat(String.valueOf(r102)));
        if (TextUtils.isEmpty(r102) == true) goto L18;
        int r103 = this.f462582a.getIdentifier("vivo_push_rom" + r102 + "_icon", "drawable", this.f462583b);
        if (r103 > 0) goto L21;
        r102 = r102.substring(0, r102.length() - 1);
        goto L15
    L21:
        t.d("DefaultNotifyDataAdapter", "getSmallIconByRomVersion find smallIcon = vivo_push_rom" + r102 + "_icon");
        return r103;
    L18:
        return this.f462582a.getIdentifier("vivo_push_icon", "drawable", this.f462583b);
    L13:
        return f462581f;
    L9:
        r101 = a(r100, "_icon");
        goto L10
    L5:
        return f462581f;
    }

    private static boolean a(String r100) {
        if (Build.VERSION.SDK_INT >= 26) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L9;
        t.d("DefaultNotifyDataAdapter", "systemVersion is not suit ");
        return false;
    L9:
        return true;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final void init(Context r100) {
        this.f462583b = r100.getPackageName();
        this.f462582a = r100.getResources();
        this.f462584c = m.a();
        this.f462585d = Build.VERSION.RELEASE;
    }

    private int a(String r100, String r101) {
        t.d("DefaultNotifyDataAdapter", "getIcon systemVersion = " + r100 + " suffix= " + r101);
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L21:
        return -1;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L21;
        String[] r102 = r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        if (r102 != null) goto L10;
    L22:
        int r103 = CastIntegerProtector.parseInt(r100);     // Catch: Exception -> L19
    L13:
        if (r103 <= 0) goto L21;
        String r104 = "vivo_push_ard" + r103 + r101;     // Catch: Exception -> L19
        t.c("DefaultNotifyDataAdapter", "get notify icon : ".concat(String.valueOf(r104)));     // Catch: Exception -> L19
        int r105 = this.f462582a.getIdentifier(r104, "drawable", this.f462583b);     // Catch: Exception -> L19
        if (r105 > 0) goto L16;
        r103 = r103 - 1;
        goto L13
    L16:
        t.c("DefaultNotifyDataAdapter", "find notify icon : ".concat(String.valueOf(r104)));     // Catch: Exception -> L19
        return r105;
    L19:
        e = move-exception;
        t.a("DefaultNotifyDataAdapter", e);
        goto L21
    L10:
        if (r102.length <= 0) goto L22;
        r100 = r102[0];
        goto L22
    }
}
