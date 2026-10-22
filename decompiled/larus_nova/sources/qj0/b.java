package qj0;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.bytedance.android.livesdk.utils.t6;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f533278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f533279b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f533280a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f533281b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public DialogInterface.OnClickListener f533282c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f533283d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public DialogInterface.OnClickListener f533284e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f533285f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Context f533286g;

        public final void a() {
            b r100 = new b(this.f533286g, this);
            if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L9;
            DialogLancet.handleBlockedDialogShow(r100);
            return;
        L9:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            DialogLancet.beforeDialogShow(r100);
            r100.show();
            DialogLancet.afterDialogShow(r100);
        }

        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, "mContext");
            this.f533286g = r100;
        }
    }

    /* JADX INFO: renamed from: qj0.b$b, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC7334b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f533287a;

        public ViewOnClickListenerC7334b(b r100) {
            this.f533287a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            b r101 = this.f533287a;
            DialogInterface.OnClickListener r102 = r101.f533279b.f533282c;
            if (r102 == null) goto L6;
            r102.onClick(r101, 0);
            return;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f533288a;

        public c(b r100) {
            this.f533288a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            b r101 = this.f533288a;
            DialogInterface.OnClickListener r102 = r101.f533279b.f533284e;
            if (r102 == null) goto L6;
            r102.onClick(r101, 1);
            return;
        }
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L24;
        DialogLancet.handleBlockedDialogShow(this);
    L8:
        if (getWindow() == null) goto L26;
        Window r100 = getWindow();
        if (r100 == null) goto L12;
        WindowManager.LayoutParams r101 = r100.getAttributes();
    L13:
        if (r101 == null) goto L15;
        r101.width = (int) t6.a(getContext(), this.f533278a);
    L15:
        if (r101 == null) goto L17;
        r101.height = -2;
    L17:
        if (r101 == null) goto L19;
        r101.gravity = 17;
    L19:
        Window r102 = getWindow();
        if (r102 == null) goto L27;
        r102.setAttributes(r101);
        return;
    L27:
        return;
    L12:
        r101 = null;
        goto L13
    L26:
        return;
    L24:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L23
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L8
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        View r101 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_link_alert, null);
        setContentView(r101);
        setCancelable(false);
        ((TextView) r101.findViewById(R.id.title)).setText(this.f533279b.f533280a);
        ((TextView) r101.findViewById(R.id.message)).setText(this.f533279b.f533281b);
        ((TextView) r101.findViewById(R.id.btn_left)).setText(this.f533279b.f533283d);
        ((TextView) r101.findViewById(R.id.btn_right)).setText(this.f533279b.f533285f);
        ((TextView) r101.findViewById(R.id.btn_left)).setOnClickListener(new ViewOnClickListenerC7334b(this));
        ((TextView) r101.findViewById(R.id.btn_right)).setOnClickListener(new c(this));
    }

    public b(Context r100, a r101) {
        super(r100, R.style.ttlive_live_dialog);
        this.f533279b = r101;
        this.f533278a = 280;
    }
}
