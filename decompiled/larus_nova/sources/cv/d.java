package cv;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes44.dex */
public final class d extends Dialog implements DialogInterface {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f465478b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cv.a f465479a;

    public interface a {
    }

    public d(Context r100) {
        super(r100, R.style.gamecp_CommonBottomDialog);
        this.f465479a = new cv.a(getContext(), this, getWindow());
        if (f465478b == null) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("NightMode is NUll");
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r110) {
        super.onCreate(r110);
        cv.a r111 = this.f465479a;
        r111.f465451c.requestFeature(1);
        r111.f465451c.setContentView(r111.f465468t);
        ViewGroup r100 = (ViewGroup) r111.f465451c.findViewById(R.id.contentPanel);
        ScrollView r101 = (ScrollView) r111.f465451c.findViewById(R.id.scrollView);
        r111.f465463o = r101;
        boolean r102 = false;
        r101.setFocusable(false);
        TextView r103 = (TextView) r111.f465451c.findViewById(R.id.message);
        r111.f465467s = r103;
        if (r103 == null) goto L19;
        CharSequence r104 = r111.f465453e;
        if (r104 == null) goto L8;
        r103.setText(r104);
    L9:
        View r105 = r111.f465451c.findViewById(R.id.scrollIndicatorUp);
        View r106 = r111.f465451c.findViewById(R.id.scrollIndicatorDown);
        if (r105 != null) goto L13;
        if (r106 == null) goto L19;
    L13:
        if (r111.f465453e == null) goto L15;
        r111.f465463o.post(new c(r111, r105, r106));
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
        r111.f465463o.removeView(r111.f465467s);
        r100.setVisibility(8);
    L19:
        Button r107 = (Button) r111.f465451c.findViewById(R.id.button1);
        r111.f465454f = r107;
        r107.setOnClickListener(r111.f465470v);
        if (TextUtils.isEmpty(r111.f465455g) == false) goto L22;
        r111.f465454f.setVisibility(8);
        int r108 = 0;
    L23:
        Button r109 = (Button) r111.f465451c.findViewById(R.id.button2);
        r111.f465457i = r109;
        r109.setOnClickListener(r111.f465470v);
        if (TextUtils.isEmpty(r111.f465458j) == false) goto L26;
        r111.f465457i.setVisibility(8);
    L27:
        Button r112 = (Button) r111.f465451c.findViewById(R.id.button3);
        r111.f465460l = r112;
        r112.setOnClickListener(r111.f465470v);
        if (TextUtils.isEmpty(r111.f465461m) == false) goto L30;
        r111.f465460l.setVisibility(8);
    L31:
        if (r108 == 0) goto L33;
        boolean r113 = true;
    L34:
        ViewGroup r114 = (ViewGroup) r111.f465451c.findViewById(R.id.topPanel);
        r111.f465465q = (ImageView) r111.f465451c.findViewById(R.id.icon);
        if ((!TextUtils.isEmpty(r111.f465452d)) == false) goto L41;
        TextView r115 = (TextView) r111.f465451c.findViewById(R.id.alertTitle);
        r111.f465466r = r115;
        r115.setText(r111.f465452d);
        int r116 = r111.f465464p;
        if (r116 == 0) goto L39;
        r111.f465465q.setImageResource(r116);
    L40:
        boolean r117 = true;
    L42:
        View r118 = r111.f465451c.findViewById(R.id.buttonPanel);
        if (r113 == true) goto L45;
        r118.setVisibility(8);
        CharSequence r119 = r111.f465453e;
    L45:
        FrameLayout r120 = (FrameLayout) r111.f465451c.findViewById(R.id.customPanel);
        r111.f465451c.setFlags(131072, 131072);
        r120.setVisibility(8);
        if (r100.getVisibility() != 0) goto L48;
        r102 = true;
    L48:
        if (r113 == false) goto L52;
        if (r117 == false) goto L52;
        if (r102 == true) goto L52;
        UIUtils.updateLayoutMargin(r114, -3, -3, -3, (int) UIUtils.dip2Px(r111.f465449a, 16.0f));
    L52:
        View r121 = r111.f465451c.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L57;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r122 = ThreadMethodProxy.currentThread();
        if (r122 == com.larus.home.impl.utils.c.f346341a) goto L57;
        com.larus.home.impl.utils.c.a(r122, "getDecorView");
    L57:
        View r123 = r111.f465451c.findViewById(R.id.parentPanel);
        if (r123 == null) goto L62;
        if (r121 == null) goto L63;
        r121.setOnApplyWindowInsetsListener(new b(r111, r123));
        r121.setFitsSystemWindows(true);
        r121.requestApplyInsets();
        return;
    L63:
        return;
    L62:
        return;
    L39:
        r111.f465466r.setPadding(r111.f465465q.getPaddingLeft(), r111.f465465q.getPaddingTop(), r111.f465465q.getPaddingRight(), r111.f465465q.getPaddingBottom());
        r111.f465465q.setVisibility(8);
        goto L40
    L41:
        r111.f465451c.findViewById(R.id.title_template).setVisibility(8);
        r111.f465465q.setVisibility(8);
        r114.setVisibility(8);
        r117 = false;
        goto L42
    L33:
        r113 = false;
        goto L34
    L30:
        r111.f465460l.setText(r111.f465461m);
        r111.f465460l.setVisibility(0);
        r108 = r108 | 4;
        goto L31
    L26:
        r111.f465457i.setText(r111.f465458j);
        r111.f465457i.setVisibility(0);
        r108 = r108 | 2;
        goto L27
    L22:
        r111.f465454f.setText(r111.f465455g);
        r111.f465454f.setVisibility(0);
        r108 = 1;
        goto L23
    }

    @Override // android.app.Dialog
    public final void setTitle(CharSequence r100) {
        super.setTitle(r100);
        cv.a r101 = this.f465479a;
        r101.f465452d = r100;
        TextView r102 = r101.f465466r;
        if (r102 == null) goto L6;
        r102.setText(r100);
        return;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int r100, KeyEvent r101) {
        ScrollView r102 = this.f465479a.f465463o;
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
        ScrollView r102 = this.f465479a.f465463o;
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
