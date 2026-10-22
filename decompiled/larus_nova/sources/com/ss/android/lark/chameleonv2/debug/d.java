package com.ss.android.lark.chameleonv2.debug;

import android.app.AlertDialog;
import android.preference.Preference;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements Preference.OnPreferenceClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChameleonDebugActivity f411379a;

    public d(ChameleonDebugActivity r100) {
        this.f411379a = r100;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public final boolean onPreferenceClick(Preference r110) {
        ChameleonDebugActivity r111 = this.f411379a;
        r111.f411365a.getClass();
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r100 = CmlDebugSettingUtil.a("chameleon_header_username", "");
        String r101 = CmlDebugSettingUtil.a("chameleon_header_pwd", "");
        TextView r102 = new TextView(r111);
        r102.setText("账号");
        EditText r103 = new EditText(r111);
        boolean r104 = false;
        if (r100.length() <= 0) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L8;
        r103.setText(r100);
        r103.setSelection(r100.length());
    L8:
        r103.setPadding(16, 16, 16, 16);
        TextView r106 = new TextView(r111);
        r106.setText("密码");
        EditText r107 = new EditText(r111);
        if (r101.length() <= 0) goto L11;
        r104 = true;
    L11:
        if (r104 == false) goto L13;
        r107.setText(r101);
        r107.setSelection(r101.length());
    L13:
        r107.setPadding(16, 16, 16, 16);
        LinearLayout r108 = new LinearLayout(r111);
        r108.setOrientation(1);
        r108.setPadding(32, 16, 32, 16);
        r108.addView(r102);
        r108.addView(r103);
        r108.addView(r106);
        r108.addView(r107);
        new AlertDialog.Builder(r111).setTitle("配置header下载鉴权").setView(r108).setPositiveButton("保存", new k(r103, r107)).setNegativeButton("取消", null).show();
        return true;
    L5:
        r105 = false;
        goto L6
    }
}
