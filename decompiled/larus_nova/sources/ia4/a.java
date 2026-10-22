package ia4;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.larus.nova.R;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f488874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DialogInterface f488875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Window f488876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CharSequence f488877d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ListView f488878e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Button f488879f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Button f488880g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Button f488881h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ScrollView f488882i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f488883j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ImageView f488884k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f488885l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f488886m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ListAdapter f488887n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f488888o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f488889p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f488890q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f488891r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final c f488892s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ViewOnClickListenerC6246a f488893t;

    /* JADX INFO: renamed from: ia4.a$a, reason: collision with other inner class name */
    public class ViewOnClickListenerC6246a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f488894a;

        public ViewOnClickListenerC6246a(a r100) {
            this.f488894a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            a r101 = this.f488894a;
            Button r102 = r101.f488879f;
            Button r103 = r101.f488880g;
            Button r104 = r101.f488881h;
            r101.f488892s.obtainMessage(1, r101.f488875b).sendToTarget();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LayoutInflater f488895a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CharSequence f488896b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public DialogInterface.OnCancelListener f488897c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public CharSequence[] f488898d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ListAdapter f488899e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public DialogInterface.OnClickListener f488900f;

        public b(Context r100) {
            this.f488895a = (LayoutInflater) r100.getSystemService("layout_inflater");
        }
    }

    public static final class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<DialogInterface> f488901a;

        public c(DialogInterface r100) {
            this.f488901a = new WeakReference(r100);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            int r101 = r100.what;
            if (r101 != (-3)) goto L5;
        L12:
            ((DialogInterface.OnClickListener) r100.obj).onClick(this.f488901a.get(), r100.what);
            return;
        L5:
            if (r101 == (-2)) goto L12;
            if (r101 == (-1)) goto L12;
            if (r101 != 1) goto L15;
            ((DialogInterface) r100.obj).dismiss();
            return;
        }
    }

    public static class d extends ArrayAdapter<CharSequence> {
        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public final long getItemId(int r100) {
            return r100;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public final boolean hasStableIds() {
            return true;
        }

        public d(Context r100, int r101, CharSequence[] r102) {
            super(r100, r101, R.id.bdp_text1, r102);
        }
    }

    public a(Context r100, DialogInterface r101, Window r102) {
        this.f488883j = 0;
        this.f488888o = -1;
        this.f488893t = new ViewOnClickListenerC6246a(this);
        this.f488874a = r100;
        this.f488875b = r101;
        this.f488876c = r102;
        this.f488892s = new c(r101);
        this.f488889p = R.layout.bdp_alert_dialog;
        this.f488890q = R.layout.bdp_select_dialog;
        this.f488891r = R.layout.bdp_select_dialog_item;
    }

    public static void a(View r100, View r101, View r102) {
        int r103 = 4;
        if (r101 != null) goto L5;
    L9:
        if (r102 != null) goto L11;
        return;
    L11:
        if (r100.canScrollVertically(1) == false) goto L13;
        r103 = 0;
    L13:
        r102.setVisibility(r103);
        return;
    L5:
        if (r100.canScrollVertically(-1) == false) goto L7;
        int r104 = 0;
    L8:
        r101.setVisibility(r104);
        goto L9
    L7:
        r104 = 4;
        goto L8
    }
}
