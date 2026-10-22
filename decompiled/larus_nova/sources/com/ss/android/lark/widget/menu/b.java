package com.ss.android.lark.widget.menu;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.TextView;
import com.larksuite.framework.ui.BaseDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f446472a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InterfaceC5405b f446473b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f446474c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f446475d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f446476e;

        /* JADX INFO: renamed from: com.ss.android.lark.widget.menu.b$a$a, reason: collision with other inner class name */
        public static class C5404a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public View f446477a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public TextView f446478b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public View f446479c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public View f446480d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public View f446481e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public View f446482f;

            public C5404a() {
            }
        }

        public a(String r100, InterfaceC5405b r101) {
            this.f446474c = -1;
            this.f446475d = -1;
            this.f446476e = false;
            this.f446472a = r100;
            this.f446473b = r101;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.widget.menu.b$b, reason: collision with other inner class name */
    public interface InterfaceC5405b {
        void a();
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BaseDialog f446483a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public com.ss.android.lark.widget.menu.a f446484b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public View f446485c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public View.OnClickListener f446486d;

        public c(Context r100, List r101) {
            this.f446483a = new BaseDialog(r100, R.style.PopDialog);
            View r102 = LayoutInflater.from(r100).inflate(R.layout.global_dialog_list, null);
            ListView r103 = (ListView) r102.findViewById(R.id.list_dialog);
            this.f446485c = r102.findViewById(R.id.menu_cancel_item);
            this.f446484b = new com.ss.android.lark.widget.menu.a(r100, r101);
            if (TextUtils.isEmpty(null) == true) goto L5;
            this.f446484b.f446471c = true;
            TextView r104 = (TextView) r102.findViewById(R.id.title_dialog);
            r104.setText(null);
            r104.setVisibility(0);
            r102.findViewById(R.id.divider_title).setVisibility(0);
        L5:
            r103.setAdapter(this.f446484b);
            r103.setOnItemClickListener(new com.ss.android.lark.widget.menu.c(this, r101));
            this.f446483a.setContentView(r102);
            this.f446483a.setCanceledOnTouchOutside(true);
        }
    }

    public static void a(Context r100, BaseDialog r101) {
        if ((r100 instanceof Activity) == false) goto L16;
        Activity r102 = (Activity) r100;
        boolean r103 = false;
        if (r102 != null) goto L7;
    L14:
        if (r103 == true) goto L16;
        return;
    L7:
        if (r102.isDestroyed() == false) goto L9;
    L11:
        boolean r104 = false;
    L12:
        if (r104 == false) goto L14;
        r103 = true;
        goto L14
    L9:
        if (r102.isFinishing() == true) goto L11;
        r104 = true;
    L16:
        Window r105 = r101.getWindow();
        WindowManager.LayoutParams r106 = r105.getAttributes();
        Resources r107 = r100.getResources();
        r106.width = WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics()).widthPixels;
        r106.gravity = 80;
        r105.setAttributes(r106);
        DesktopUtil.a(r100);
        r105.setWindowAnimations(R.style.AnimBottom);
        r105.setDimAmount(0.3f);
        if (DialogLancet.shouldBlockDialogShow(r101) == false) goto L23;
        DialogLancet.handleBlockedDialogShow(r101);
        return;
    L23:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L22
    L20:
        DialogLancet.beforeDialogShow(r101);
        r101.show();
        DialogLancet.afterDialogShow(r101);
    }
}
