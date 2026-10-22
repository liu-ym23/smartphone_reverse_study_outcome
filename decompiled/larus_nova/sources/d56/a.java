package d56;

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

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f467036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DialogInterface f467037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Window f467038c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CharSequence f467039d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Button f467040e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Button f467041f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Button f467042g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ScrollView f467043h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f467044i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ImageView f467045j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f467046k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f467047l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f467048m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b f467049n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ViewOnClickListenerC5638a f467050o;

    /* JADX INFO: renamed from: d56.a$a, reason: collision with other inner class name */
    public class ViewOnClickListenerC5638a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f467051a;

        public ViewOnClickListenerC5638a(a r100) {
            this.f467051a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            a r101 = this.f467051a;
            if (r100 != r101.f467040e) goto L6;
            r101.getClass();
        L6:
            if (r100 != r101.f467041f) goto L9;
            r101.getClass();
        L9:
            if (r100 != r101.f467042g) goto L11;
            r101.getClass();
        L11:
            a r102 = this.f467051a;
            r102.f467049n.obtainMessage(1, r102.f467037b).sendToTarget();
        }
    }

    public static final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<DialogInterface> f467052a;

        public b(DialogInterface r100) {
            this.f467052a = new WeakReference(r100);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            int r101 = r100.what;
            if (r101 != (-3)) goto L5;
        L12:
            ((DialogInterface.OnClickListener) r100.obj).onClick(this.f467052a.get(), r100.what);
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
        this.f467044i = 0;
        this.f467050o = new ViewOnClickListenerC5638a(this);
        this.f467036a = r100;
        this.f467037b = r101;
        this.f467038c = r102;
        this.f467049n = new b(r101);
        this.f467048m = R.layout.ss_alert_dialog;
    }
}
