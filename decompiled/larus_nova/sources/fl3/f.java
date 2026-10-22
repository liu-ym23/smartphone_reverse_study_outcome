package fl3;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes14.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f477700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f477701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f477702c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f477703d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f477704e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f477705f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f477706g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f477707h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f477708i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FrameLayout f477709j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LinearLayout f477710k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public RelativeLayout f477711l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f477712m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f477713n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f477714o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f477715p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f477716q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final DialogInterface.OnClickListener f477717r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final DialogInterface.OnClickListener f477718s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f477719t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f477720u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public AlertDialog f477721v;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f477722a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f477723b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f477724c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public DialogInterface.OnClickListener f477725d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public DialogInterface.OnClickListener f477726e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Context f477727f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f477728g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f477729h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f477730i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f477731j;

        public a(Context r100) {
            this.f477727f = r100;
            this.f477728g = th.a.a(r100, R.color.ec_uikit_dialog_title);
            this.f477729h = th.a.a(r100, R.color.ec_uikit_dialog_title);
        }
    }

    public f(a r100) {
        Context r101 = r100.f477727f;
        this.f477700a = r101;
        this.f477712m = r100.f477722a;
        this.f477714o = r100.f477724c;
        this.f477713n = r100.f477723b;
        this.f477717r = r100.f477725d;
        this.f477718s = r100.f477726e;
        this.f477720u = r100.f477731j;
        this.f477719t = r100.f477730i;
        this.f477715p = r100.f477729h;
        this.f477716q = r100.f477728g;
        View r102 = th.a.c(th.a.e(r101, true), R.layout.layout_dmt_dialog_legacy, null, false);
        this.f477706g = r102;
        this.f477701b = (TextView) r102.findViewById(R.id.tv_title);
        this.f477702c = (TextView) this.f477706g.findViewById(R.id.tv_content);
        TextView r103 = (TextView) this.f477706g.findViewById(R.id.tv_second_content);
        ImageView r104 = (ImageView) this.f477706g.findViewById(R.id.ic_img);
        this.f477703d = (TextView) this.f477706g.findViewById(R.id.tv_left);
        this.f477704e = (TextView) this.f477706g.findViewById(R.id.tv_right);
        this.f477705f = (TextView) this.f477706g.findViewById(R.id.tv_line);
        this.f477711l = (RelativeLayout) this.f477706g.findViewById(R.id.rootview);
        RelativeLayout r105 = (RelativeLayout) this.f477706g.findViewById(R.id.rl_custom_view);
        this.f477709j = (FrameLayout) this.f477706g.findViewById(R.id.rl_top);
        this.f477710k = (LinearLayout) this.f477706g.findViewById(R.id.ll_below_top);
        this.f477707h = this.f477706g.findViewById(R.id.divider_line);
        this.f477708i = this.f477706g.findViewById(R.id.close_iv);
    }
}
