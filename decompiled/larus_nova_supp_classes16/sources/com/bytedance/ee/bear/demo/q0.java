package com.bytedance.ee.bear.demo;

import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class q0 implements View.OnClickListener {
    public final /* synthetic */ OfficeCCMDemoActivity a;

    public q0(OfficeCCMDemoActivity r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [android.content.Context, com.bytedance.ee.bear.demo.OfficeCCMDemoActivity, java.lang.Object] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        ?? r6 = this.a;
        int r0 = OfficeCCMDemoActivity.e;
        r6.getClass();
        SpaceEditText r1 = new SpaceEditText(r6);
        r1.setHint("请输入文档 URL");
        r1.setInputType(17);
        r1.setSingleLine(true);
        r1.setPadding(50, 20, 50, 20);
        AlertDialog r2 = new AlertDialog.Builder(r6).setTitle("预拉取数据").setView(r1).setNegativeButton("取消", null).setPositiveButton("确定", null).create();
        r2.setOnShowListener(new y0(r2, r1, r6));
        if (DialogLancet.shouldBlockDialogShow(r2) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r2);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r2);
        r2.show();
        DialogLancet.afterDialogShow(r2);
    }
}
