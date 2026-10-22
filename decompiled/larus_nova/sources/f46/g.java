package f46;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.dux.api.IDuxComponentService;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes19.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f475532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f475533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f475534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f475535d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f475536e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f475537f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f475538g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f475539h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f475540i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FrameLayout f475541j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LinearLayout f475542k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public RelativeLayout f475543l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f475544m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f475545n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f475546o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f475547p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f475548q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f475549r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final DialogInterface.OnClickListener f475550s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final DialogInterface.OnClickListener f475551t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final DialogInterface.OnCancelListener f475552u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f475553v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f475554w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f475555x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public AlertDialog f475556y;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f475557a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f475558b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f475559c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f475560d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public DialogInterface.OnClickListener f475561e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public DialogInterface.OnClickListener f475562f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public DialogInterface.OnCancelListener f475563g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Context f475564h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f475565i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f475566j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f475567k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f475568l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f475569m;

        public a(Context r100) {
            this.f475569m = true;
            this.f475564h = r100;
            this.f475565i = ContextCompat.getColor(r100, R.color.uikit_dialog_title);
            this.f475566j = ContextCompat.getColor(r100, R.color.uikit_dialog_title);
        }
    }

    public final AlertDialog a() {
        this.f475543l.setAlpha(0.0f);
        AlertDialog.Builder r100 = new AlertDialog.Builder(this.f475532a);
        r100.setView(this.f475538g);
        this.f475533b.setText(this.f475544m);
        this.f475534c.setText(this.f475545n);
        this.f475534c.setGravity(17);
        if (TextUtils.isEmpty(this.f475545n) == false) goto L5;
        this.f475534c.setVisibility(8);
    L5:
        this.f475536e.setText(this.f475546o);
        this.f475536e.setTextColor(this.f475549r);
        this.f475541j.setBackgroundColor(0);
        if (TextUtils.isEmpty(this.f475547p) == false) goto L8;
        this.f475535d.setVisibility(8);
        this.f475537f.setVisibility(8);
        this.f475536e.setBackgroundResource(R.drawable.uikit_bg_bottom_selector);
    L10:
        if (TextUtils.isEmpty(this.f475544m) == false) goto L14;
        this.f475533b.setVisibility(8);
        if (TextUtils.isEmpty(null) == false) goto L14;
        LinearLayout.LayoutParams r101 = (LinearLayout.LayoutParams) this.f475534c.getLayoutParams();
        r101.topMargin = (int) dm4.a.a(this.f475532a, 32.0f);
        r101.bottomMargin = (int) dm4.a.a(this.f475532a, 8.0f);
        this.f475534c.setLayoutParams(r101);
    L14:
        this.f475541j.setVisibility(8);
        this.f475542k.setBackgroundResource(R.drawable.uikit_bg_dialog);
        r100.setOnCancelListener(new f46.a(this));
        r100.setCancelable(this.f475555x);
        this.f475556y = r100.create();
        this.f475535d.setOnClickListener(new b(this));
        this.f475536e.setOnClickListener(new c(this));
        this.f475540i.setOnClickListener(new d(this));
        AlertDialog r102 = this.f475556y;
        RelativeLayout r103 = this.f475543l;     // Catch: Exception -> L37
        if (r103 == null) goto L20;
        r103.post(new e(r103, true));     // Catch: Exception -> L37
    L20:
        if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L40;
        DialogLancet.handleBlockedDialogShow(r102);     // Catch: Exception -> L37
    L25:
        Window r104 = r102.getWindow();     // Catch: Exception -> L37
        if (r104 == null) goto L35;
        r104.setBackgroundDrawableResource(R.color.SDQuaternary);     // Catch: Exception -> L37
        WindowManager.LayoutParams r105 = r104.getAttributes();     // Catch: Exception -> L37
        r105.dimAmount = 0.5f;     // Catch: Exception -> L37
        r104.addFlags(2);     // Catch: Exception -> L37
        r105.gravity = 1;     // Catch: Exception -> L37
        r105.width = (int) dm4.a.a(r102.getContext(), 280.0f);     // Catch: Exception -> L37
        View r106 = r104.getDecorView();     // Catch: Exception -> L37
        if (com.larus.home.impl.utils.c.f346345e == false) goto L33;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Exception -> L37
        Thread r107 = ThreadMethodProxy.currentThread();     // Catch: Exception -> L37
        if (r107 == com.larus.home.impl.utils.c.f346341a) goto L33;
        com.larus.home.impl.utils.c.a(r107, "getDecorView");     // Catch: Exception -> L37
    L33:
        r106.setPadding(0, 0, 0, 0);     // Catch: Exception -> L37
        r104.setAttributes(r105);     // Catch: Exception -> L37
        goto L35
    L40:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L36
    L24:
        DialogLancet.beforeDialogShow(r102);     // Catch: Exception -> L37
        r102.show();     // Catch: Exception -> L37
        DialogLancet.afterDialogShow(r102);     // Catch: Exception -> L37
    L35:
        return this.f475556y;
    L8:
        this.f475535d.setText(this.f475547p);
        this.f475535d.setTextColor(this.f475548q);
        goto L10
    }

    public g(a r100) {
        Context r101 = r100.f475564h;
        this.f475532a = r101;
        this.f475544m = r100.f475557a;
        this.f475545n = r100.f475558b;
        this.f475547p = r100.f475560d;
        this.f475546o = r100.f475559c;
        this.f475550s = r100.f475561e;
        this.f475551t = r100.f475562f;
        this.f475554w = r100.f475568l;
        this.f475553v = r100.f475567k;
        this.f475555x = r100.f475569m;
        this.f475548q = r100.f475566j;
        this.f475549r = r100.f475565i;
        this.f475552u = r100.f475563g;
        if (((IDuxComponentService) ServiceManager.get().getService(IDuxComponentService.class)).isPad() == false) goto L5;
        View r102 = LayoutInflater.from(r101).inflate(R.layout.layout_dmt_dialog_pad, null);
    L6:
        this.f475538g = r102;
        this.f475533b = (TextView) r102.findViewById(R.id.tv_title);
        this.f475534c = (TextView) this.f475538g.findViewById(R.id.tv_content);
        TextView r103 = (TextView) this.f475538g.findViewById(R.id.tv_second_content);
        ImageView r104 = (ImageView) this.f475538g.findViewById(R.id.ic_img);
        this.f475535d = (TextView) this.f475538g.findViewById(R.id.tv_left);
        this.f475536e = (TextView) this.f475538g.findViewById(R.id.tv_right);
        this.f475537f = (TextView) this.f475538g.findViewById(R.id.tv_line);
        this.f475543l = (RelativeLayout) this.f475538g.findViewById(R.id.rootview);
        RelativeLayout r105 = (RelativeLayout) this.f475538g.findViewById(R.id.rl_custom_view);
        this.f475541j = (FrameLayout) this.f475538g.findViewById(R.id.rl_top);
        this.f475542k = (LinearLayout) this.f475538g.findViewById(R.id.ll_below_top);
        this.f475539h = this.f475538g.findViewById(R.id.divider_line);
        this.f475540i = this.f475538g.findViewById(R.id.close_iv);
        ViewCompat.setAccessibilityDelegate(this.f475535d, new f());
        ViewCompat.setAccessibilityDelegate(this.f475536e, new f());
        return;
    L5:
        r102 = LayoutInflater.from(r101).inflate(R.layout.layout_dmt_dialog, null);
        goto L6
    }
}
