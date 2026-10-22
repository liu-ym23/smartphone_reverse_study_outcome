package cv;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.larus.nova.R;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f465449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DialogInterface f465450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Window f465451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CharSequence f465452d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f465453e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Button f465454f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CharSequence f465455g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Message f465456h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Button f465457i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CharSequence f465458j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Message f465459k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Button f465460l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CharSequence f465461m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Message f465462n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ScrollView f465463o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f465464p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ImageView f465465q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TextView f465466r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TextView f465467s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f465468t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final b f465469u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ViewOnClickListenerC5592a f465470v;

    /* JADX INFO: renamed from: cv.a$a, reason: collision with other inner class name */
    public class ViewOnClickListenerC5592a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f465471a;

        public ViewOnClickListenerC5592a(a r100) {
            this.f465471a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            a r101 = this.f465471a;
            if (r100 != r101.f465454f) goto L8;
            Message r102 = r101.f465456h;
            if (r102 == null) goto L8;
            Message r103 = Message.obtain(r102);
        L18:
            if (r103 == null) goto L20;
            r103.sendToTarget();
        L20:
            a r104 = this.f465471a;
            r104.f465469u.obtainMessage(1, r104.f465450b).sendToTarget();
            return;
        L8:
            if (r100 != r101.f465457i) goto L13;
            Message r105 = r101.f465459k;
            if (r105 == null) goto L13;
            r103 = Message.obtain(r105);
        L13:
            if (r100 != r101.f465460l) goto L17;
            Message r106 = r101.f465462n;
            if (r106 == null) goto L17;
            r103 = Message.obtain(r106);
        L17:
            r103 = null;
            goto L18
        }
    }

    public static final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<DialogInterface> f465472a;

        public b(DialogInterface r100) {
            this.f465472a = new WeakReference(r100);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            int r101 = r100.what;
            if (r101 != (-3)) goto L5;
        L12:
            ((DialogInterface.OnClickListener) r100.obj).onClick(this.f465472a.get(), r100.what);
            return;
        L5:
            if (r101 == (-2)) goto L12;
            if (r101 == (-1)) goto L12;
            if (r101 != 1) goto L15;
            ((DialogInterface) r100.obj).dismiss();
            return;
        }
    }

    public a(Context r100, DialogInterface r101, Window r102) {
        this.f465464p = 0;
        this.f465470v = new ViewOnClickListenerC5592a(this);
        this.f465449a = r100;
        this.f465450b = r101;
        this.f465451c = r102;
        this.f465469u = new b(r101);
        this.f465468t = R.layout.gamecp_liveuikit_ss_alert_dialog;
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

    public final void b(int r100, CharSequence r101, DialogInterface.OnClickListener r102) {
        if (r102 == null) goto L4;
        Message r103 = this.f465469u.obtainMessage(r100, r102);
    L6:
        if (r100 != (-3)) goto L8;
        this.f465461m = r101;
        this.f465462n = r103;
        return;
    L8:
        if (r100 != (-2)) goto L10;
        this.f465458j = r101;
        this.f465459k = r103;
        return;
    L10:
        if (r100 != (-1)) goto L13;
        this.f465455g = r101;
        this.f465456h = r103;
        return;
    L13:
        throw new IllegalArgumentException("Button does not exist");
    L4:
        r103 = null;
        goto L6
    }
}
