package hta;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.larus.nova.R;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f487160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DialogInterface f487161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Window f487162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CharSequence f487163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f487164e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Button f487165f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CharSequence f487166g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Message f487167h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Button f487168i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Button f487169j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ScrollView f487170k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f487171l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ImageView f487172m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f487173n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TextView f487174o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f487175p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final c f487176q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final a f487177r;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f487178a;

        public a(b r100) {
            this.f487178a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            b r101 = this.f487178a;
            if (r100 != r101.f487165f) goto L8;
            Message r102 = r101.f487167h;
            if (r102 == null) goto L8;
            Message r103 = Message.obtain(r102);
        L14:
            if (r103 == null) goto L16;
            r103.sendToTarget();
        L16:
            b r104 = this.f487178a;
            r104.f487176q.obtainMessage(1, r104.f487161b).sendToTarget();
            return;
        L8:
            if (r100 != r101.f487168i) goto L11;
            r101.getClass();
        L11:
            if (r100 != r101.f487169j) goto L13;
            r101.getClass();
        L13:
            r103 = null;
            goto L14
        }
    }

    /* JADX INFO: renamed from: hta.b$b, reason: collision with other inner class name */
    public static class C6195b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f487179a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CharSequence f487180b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f487181c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public CharSequence f487182d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public DialogInterface.OnClickListener f487183e;

        public C6195b(Context r100) {
            this.f487179a = r100;
            LayoutInflater r101 = (LayoutInflater) r100.getSystemService("layout_inflater");
        }
    }

    public static final class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<DialogInterface> f487184a;

        public c(DialogInterface r100) {
            this.f487184a = new WeakReference(r100);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            int r101 = r100.what;
            if (r101 != (-3)) goto L5;
        L12:
            ((DialogInterface.OnClickListener) r100.obj).onClick(this.f487184a.get(), r100.what);
            return;
        L5:
            if (r101 == (-2)) goto L12;
            if (r101 == (-1)) goto L12;
            if (r101 != 1) goto L15;
            ((DialogInterface) r100.obj).dismiss();
            return;
        }
    }

    public b(Context r100, DialogInterface r101, Window r102) {
        this.f487171l = 0;
        this.f487177r = new a(this);
        this.f487160a = r100;
        this.f487161b = r101;
        this.f487162c = r102;
        this.f487176q = new c(r101);
        this.f487175p = R.layout.ss_alert_dialog;
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
