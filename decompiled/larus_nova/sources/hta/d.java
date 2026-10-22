package hta;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes34.dex */
public final class d extends Dialog implements DialogInterface {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f487188b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f487189a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b.C6195b f487190a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f487191b;

        public final void a() {
            d r100 = new d(this.f487190a.f487179a, this.f487191b);
            b.C6195b r101 = this.f487190a;
            b r102 = r100.f487189a;
            CharSequence r103 = r101.f487180b;
            if (r103 == null) goto L7;
            r102.f487163d = r103;
            TextView r104 = r102.f487173n;
            if (r104 == null) goto L7;
            r104.setText(r103);
        L7:
            CharSequence r105 = r101.f487181c;
            if (r105 == null) goto L12;
            r102.f487164e = r105;
            TextView r106 = r102.f487174o;
            if (r106 == null) goto L12;
            r106.setText(r105);
        L12:
            CharSequence r107 = r101.f487182d;
            if (r107 == null) goto L19;
            DialogInterface.OnClickListener r108 = r101.f487183e;
            if (r108 == null) goto L17;
            Message r109 = r102.f487176q.obtainMessage(-1, r108);
        L18:
            r102.f487166g = r107;
            r102.f487167h = r109;
            goto L19
        L17:
            r109 = null;
        L19:
            this.f487190a.getClass();
            r100.setCancelable(true);
            this.f487190a.getClass();
            r100.setCanceledOnTouchOutside(true);
            this.f487190a.getClass();
            r100.setOnCancelListener(null);
            this.f487190a.getClass();
            r100.setOnDismissListener(null);
            this.f487190a.getClass();
            if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L32;
            DialogLancet.handleBlockedDialogShow(r100);     // Catch: Exception -> L28
        L29:
            return;
        L32:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L27
        L25:
            DialogLancet.beforeDialogShow(r100);     // Catch: Exception -> L28
            r100.show();     // Catch: Exception -> L28
            DialogLancet.afterDialogShow(r100);     // Catch: Exception -> L28
        }

        public Context getContext() {
            return this.f487190a.f487179a;
        }

        public a(Context r100) {
            int r101 = d.f487188b;
            this.f487190a = new b.C6195b(new ContextThemeWrapper(r100, R.style.SSTheme_Dialog_Alert));
            this.f487191b = 0;
        }
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r110) {
        super.onCreate(r110);
        final b r111 = this.f487189a;
        r111.f487162c.requestFeature(1);
        r111.f487162c.setContentView(r111.f487175p);
        ViewGroup r100 = (ViewGroup) r111.f487162c.findViewById(R.id.contentPanel);
        ScrollView r101 = (ScrollView) r111.f487162c.findViewById(R.id.scrollView);
        r111.f487170k = r101;
        boolean r102 = false;
        r101.setFocusable(false);
        TextView r103 = (TextView) r111.f487162c.findViewById(R.id.message);
        r111.f487174o = r103;
        if (r103 == null) goto L19;
        CharSequence r104 = r111.f487164e;
        if (r104 == null) goto L8;
        r103.setText(r104);
    L9:
        View r105 = r111.f487162c.findViewById(R.id.scrollIndicatorUp);
        View r106 = r111.f487162c.findViewById(R.id.scrollIndicatorDown);
        if (r105 != null) goto L13;
        if (r106 == null) goto L19;
    L13:
        if (r111.f487164e == null) goto L15;
        r111.f487170k.post(new c(r111, r105, r106));
        goto L19
    L15:
        if (r105 == null) goto L17;
        r100.removeView(r105);
    L17:
        if (r106 == null) goto L19;
        r100.removeView(r106);
        goto L19
    L8:
        r103.setVisibility(8);
        r111.f487170k.removeView(r111.f487174o);
        r100.setVisibility(8);
    L19:
        Button r107 = (Button) r111.f487162c.findViewById(R.id.button1);
        r111.f487165f = r107;
        r107.setOnClickListener(r111.f487177r);
        if (TextUtils.isEmpty(r111.f487166g) == false) goto L22;
        r111.f487165f.setVisibility(8);
        int r108 = 0;
    L23:
        Button r109 = (Button) r111.f487162c.findViewById(R.id.button2);
        r111.f487168i = r109;
        r109.setOnClickListener(r111.f487177r);
        r111.getClass();
        if (TextUtils.isEmpty(null) == false) goto L26;
        r111.f487168i.setVisibility(8);
    L27:
        Button r112 = (Button) r111.f487162c.findViewById(R.id.button3);
        r111.f487169j = r112;
        r112.setOnClickListener(r111.f487177r);
        r111.getClass();
        if (TextUtils.isEmpty(null) == false) goto L30;
        r111.f487169j.setVisibility(8);
    L31:
        if (r108 == 0) goto L33;
        boolean r113 = true;
    L34:
        ViewGroup r114 = (ViewGroup) r111.f487162c.findViewById(R.id.topPanel);
        r111.f487172m = (ImageView) r111.f487162c.findViewById(R.id.icon);
        if ((!TextUtils.isEmpty(r111.f487163d)) == false) goto L41;
        TextView r115 = (TextView) r111.f487162c.findViewById(R.id.alertTitle);
        r111.f487173n = r115;
        r115.setText(r111.f487163d);
        int r116 = r111.f487171l;
        if (r116 == 0) goto L39;
        r111.f487172m.setImageResource(r116);
    L40:
        boolean r117 = true;
    L42:
        View r118 = r111.f487162c.findViewById(R.id.buttonPanel);
        if (r113 == true) goto L45;
        r118.setVisibility(8);
        CharSequence r119 = r111.f487164e;
    L45:
        FrameLayout r120 = (FrameLayout) r111.f487162c.findViewById(R.id.customPanel);
        r111.f487162c.setFlags(131072, 131072);
        r120.setVisibility(8);
        if (r117 == false) goto L54;
        if (r111.f487164e != null) goto L50;
        View r121 = r111.f487162c.findViewById(R.id.titleDividerTop);
    L51:
        if (r121 == null) goto L54;
        r121.setVisibility(0);
        goto L54
    L50:
        r121 = r111.f487162c.findViewById(R.id.titleDivider);
    L54:
        if (r100.getVisibility() != 0) goto L56;
        r102 = true;
    L56:
        if (r113 == false) goto L60;
        if (r117 == false) goto L60;
        if (r102 == true) goto L60;
        UIUtils.updateLayoutMargin(r114, -3, -3, -3, (int) UIUtils.dip2Px(r111.f487160a, 16.0f));
    L60:
        View r122 = r111.f487162c.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L65;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r123 = ThreadMethodProxy.currentThread();
        if (r123 == com.larus.home.impl.utils.c.f346341a) goto L65;
        com.larus.home.impl.utils.c.a(r123, "getDecorView");
    L65:
        final View r124 = r111.f487162c.findViewById(R.id.parentPanel);
        if (r124 == null) goto L70;
        if (r122 == null) goto L71;
        r122.setOnApplyWindowInsetsListener(new hta.a(r111, r124));
        r122.setFitsSystemWindows(true);
        r122.requestApplyInsets();
        return;
    L71:
        return;
    L70:
        return;
    L39:
        r111.f487173n.setPadding(r111.f487172m.getPaddingLeft(), r111.f487172m.getPaddingTop(), r111.f487172m.getPaddingRight(), r111.f487172m.getPaddingBottom());
        r111.f487172m.setVisibility(8);
        goto L40
    L41:
        r111.f487162c.findViewById(R.id.title_template).setVisibility(8);
        r111.f487172m.setVisibility(8);
        r114.setVisibility(8);
        r117 = false;
        goto L42
    L33:
        r113 = false;
        goto L34
    L30:
        Button r125 = r111.f487169j;
        r111.getClass();
        r125.setText(null);
        r111.f487169j.setVisibility(0);
        r108 = r108 | 4;
        goto L31
    L26:
        Button r126 = r111.f487168i;
        r111.getClass();
        r126.setText(null);
        r111.f487168i.setVisibility(0);
        r108 = r108 | 2;
        goto L27
    L22:
        r111.f487165f.setText(r111.f487166g);
        r111.f487165f.setVisibility(0);
        r108 = 1;
        goto L23
    }

    @Override // android.app.Dialog
    public final void setTitle(CharSequence r100) {
        super.setTitle(r100);
        b r101 = this.f487189a;
        r101.f487163d = r100;
        TextView r102 = r101.f487173n;
        if (r102 == null) goto L6;
        r102.setText(r100);
        return;
    }

    public d(Context r100, int r101) {
        if (r101 != 1) goto L6;
    L4:
        r101 = R.style.SSTheme_Dialog_Alert;
    L10:
        super(r100, r101);
        this.f487189a = new b(getContext(), this, getWindow());
        return;
    L6:
        if (r101 != 2) goto L9;
        r101 = R.style.SSTheme_Dialog_Alert_Night;
        goto L10
    L9:
        if (r101 < 16777216) goto L4;
        goto L4
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int r100, KeyEvent r101) {
        ScrollView r102 = this.f487189a.f487170k;
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L11;
        return true;
    L11:
        return super.onKeyDown(r100, r101);
    L5:
        if (r102.executeKeyEvent(r101) == false) goto L7;
        r103 = true;
        goto L8
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int r100, KeyEvent r101) {
        ScrollView r102 = this.f487189a.f487170k;
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L11;
        return true;
    L11:
        return super.onKeyUp(r100, r101);
    L5:
        if (r102.executeKeyEvent(r101) == false) goto L7;
        r103 = true;
        goto L8
    }
}
