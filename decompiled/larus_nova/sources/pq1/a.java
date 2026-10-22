package pq1;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes8.dex */
public final class a extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HSImageView f530261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f530262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f530263c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f530264d;

    /* JADX INFO: renamed from: pq1.a$a, reason: collision with other inner class name */
    public static final class C7226a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f530265a;

        public final void b(int r100) {
            Context r101 = this.f530265a.f530269b;
            if (r101 == null) goto L5;
            CharSequence r102 = r101.getText(r100);
        L6:
            this.f530265a.f530271d = r102;
            return;
        L5:
            r102 = null;
            goto L6
        }

        public C7226a(Context r100, int r101) {
            d r102 = new d();
            this.f530265a = r102;
            r102.f530269b = r100;
            r102.f530268a = r101;
        }

        public final void a(int r100, int r101, DialogInterface.OnClickListener r102) {
            Context r103 = this.f530265a.f530269b;
            if (r103 == null) goto L6;
            CharSequence r104 = r103.getText(r101);
            if (r104 == null) goto L6;
        L8:
            if (r100 > 4) goto L15;
            b[] r105 = this.f530265a.f530272e;
            b r106 = r105[r100];
            if (r106 != null) goto L13;
            r106 = new b();
            r105[r100] = r106;
        L13:
            r106.f530266a = r104;
            r106.f530267b = r102;
            return;
        L15:
            return;
        L6:
            r104 = "";
            goto L8
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CharSequence f530266a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public DialogInterface.OnClickListener f530267b;

        public b() {
        }
    }

    public static final class c {
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f530268a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Context f530269b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f530270c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public CharSequence f530271d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final b[] f530272e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f530273f;

        public d() {
            this.f530272e = new b[5];
            this.f530273f = true;
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f530274a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f530275b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f530276c;

        public e(a r100, b r101, int r102) {
            this.f530274a = r100;
            this.f530275b = r101;
            this.f530276c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            DialogInterface.OnClickListener r101 = this.f530275b.f530267b;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101 == null) goto L8;
            r101.onClick(this.f530274a, this.f530276c);
            return;
        }
    }

    static {
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        int r101 = pq1.b.f530277a - 1;
        pq1.b.f530277a = r101;
        if (r101 >= 0) goto L26;
        pq1.b.f530277a = 0;
        return;
    L26:
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r102 == null) goto L16;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        pq1.b.f530277a++;
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public final void b(d r100) {
        this.f530261a = (HSImageView) findViewById(R.id.replay_dialog_image);
        this.f530262b = (TextView) findViewById(R.id.replay_dialog_title);
        this.f530263c = (TextView) findViewById(R.id.replay_dialog_message);
        r100.getClass();
        HSImageView r101 = this.f530261a;
        if (r101 == null) goto L5;
        r101.setVisibility(8);
    L5:
        findViewById(R.id.replay_dialog_image_block).setVisibility(8);
        CharSequence r102 = r100.f530270c;
        if (r102 == null) goto L13;
        TextView r103 = this.f530262b;
        if (r103 == null) goto L10;
        r103.setText(r102);
    L10:
        TextView r104 = this.f530262b;
        if (r104 == null) goto L17;
        r104.setVisibility(0);
    L17:
        CharSequence r105 = r100.f530271d;
        if (r105 == null) goto L22;
        TextView r106 = this.f530263c;
        if (r106 == null) goto L26;
        r106.setText(r105);
    L26:
        int r107 = r100.f530268a;
        if (r107 != 0) goto L29;
    L30:
        b[] r108 = r100.f530272e;
        if (r108[0] == null) goto L33;
    L36:
        boolean r109 = true;
    L38:
        if (r109 == true) goto L40;
        findViewById(R.id.replay_dialog_container).setVisibility(8);
    L41:
        setCancelable(r100.f530273f);
        setCanceledOnTouchOutside(true);
        setOnCancelListener(null);
        setOnDismissListener(null);
        setOnShowListener(null);
        return;
    L40:
        a((Button) findViewById(R.id.replay_dialog_btn_1), 0, null, r100);
        a((Button) findViewById(R.id.replay_dialog_btn_2), 1, findViewById(R.id.replay_dialog_divider_vertical), r100);
        this.f530264d = findViewById(R.id.replay_dialog_title_message_block);
        goto L41
    L33:
        if (r108[1] != null) goto L36;
    L35:
        r109 = false;
        goto L38
    L29:
        if (4 != r107) goto L35;
    L22:
        TextView r110 = this.f530263c;
        if (r110 == null) goto L25;
        r110.setVisibility(8);
    L25:
        findViewById(R.id.replay_dialog_title_message_block).setVisibility(8);
        goto L26
    L13:
        TextView r111 = this.f530262b;
        if (r111 == null) goto L16;
        r111.setVisibility(8);
    L16:
        findViewById(R.id.replay_dialog_title_message_block).setVisibility(8);
        goto L17
    }

    @Override // android.app.Dialog
    public final void setTitle(int r100) {
        setTitle(getContext().getText(r100));
    }

    @Override // android.app.Dialog
    public final void setTitle(CharSequence r100) {
        TextView r101 = this.f530262b;
        if (r101 == null) goto L7;
        if (r101 == null) goto L8;
        r101.setText(r100);
        return;
    L8:
        return;
    }

    public a(Context r100, d r101) {
        super(r100, R.style.ttlive_replay_dialog);
        if (r101.f530268a != 4) goto L5;
        setContentView(LayoutInflater.from(getContext()).inflate(R.layout.ttlive_replay_dialog_common_horizontal_new, null));
        b(r101);
        return;
    L5:
        setContentView(LayoutInflater.from(getContext()).inflate(R.layout.ttlive_replay_dialog_common_horizontal, null));
        b(r101);
    }

    public final void a(Button r100, int r101, View r102, d r103) {
        b r104 = r103.f530272e[r101];
        if (r104 == null) goto L11;
        if (r100 == null) goto L6;
        r100.setText(r104.f530266a);
    L6:
        if (r100 == null) goto L8;
        r100.setOnClickListener(new e(this, r104, r101));
    L8:
        if (r100 == null) goto L16;
        r100.setTypeface(null, 0);
        return;
    L16:
        return;
    L11:
        if (r100 == null) goto L13;
        r100.setVisibility(8);
    L13:
        if (r102 == null) goto L18;
        r102.setVisibility(8);
        return;
    }
}
