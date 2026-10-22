package yhc;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.update.UpdateContentLinearLayout;

/* JADX INFO: loaded from: classes40.dex */
public final class u extends Dialog implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f567731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f567732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f567733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.ss.android.update.d f567734d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f567735e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f567736f;

    @Override // yhc.h
    public final boolean b() {
        return isShowing();
    }

    public u(Context r100) {
        super(r100);
        this.f567736f = false;
        this.f567735e = r100;
    }

    @Override // yhc.h
    public final void a(int r100) {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        this.f567734d.e0(false);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(this);
        show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        requestWindowFeature(1);
        setContentView(R.layout.update_check_dialog_layout);
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        r101.setBackgroundDrawableResource(R.drawable.transparent);
        r101.setLayout(-2, -2);
        r101.setGravity(17);
    L5:
        this.f567731a = (TextView) findViewById(R.id.update_check_ok_btn);
        this.f567732b = (ImageView) findViewById(R.id.update_check_cancel_btn);
        this.f567733c = (LinearLayout) findViewById(R.id.update_content_root);
        com.ss.android.update.d r102 = com.ss.android.update.d.x();
        this.f567734d = r102;
        if (r102 == null) goto L31;
        boolean r103 = r102.g();
        String r104 = r102.K();
        if (TextUtils.isEmpty(r104) == true) goto L20;
        if (r104.contains("\n") == false) goto L18;
        String[] r105 = r104.split("\n");
        int r106 = r105.length;
        int r107 = 0;
    L13:
        if (r107 >= r106) goto L20;
        String r108 = r105[r107];
        if (TextUtils.isEmpty(r108) == true) goto L17;
        UpdateContentLinearLayout r109 = new UpdateContentLinearLayout(this.f567735e);
        r109.a(r108);
        this.f567733c.addView(r109);
    L17:
        r107 = r107 + 1;
        goto L13
    L18:
        UpdateContentLinearLayout r110 = new UpdateContentLinearLayout(this.f567735e);
        r110.a(r104);
        this.f567733c.addView(r110);
    L20:
        if (TextUtils.isEmpty(this.f567734d.f455275l0) == true) goto L26;
        if (r103 == false) goto L26;
        if (this.f567734d.f455275l0.contains("\n") == false) goto L25;
        String r111 = this.f567734d.f455275l0.replace("\n", "");
        this.f567731a.setText(r111);
        goto L26
    L25:
        this.f567731a.setText(this.f567734d.f455275l0);
    L26:
        this.f567732b.setOnClickListener(new r(this));
        this.f567731a.setOnClickListener(new s(this, r103));
        setOnDismissListener(new t(this));
        return;
    }
}
