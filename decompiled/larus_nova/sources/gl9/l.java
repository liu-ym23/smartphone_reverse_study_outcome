package gl9;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.mirabridge.impl.ui.PluginCircularProgressView;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes30.dex */
public final class l extends ProgressDialog {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f481621d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f481622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CharSequence f481623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f481624c;

    public l(Context r100) {
        super(r100, 3);
    }

    @Override // android.app.ProgressDialog, android.app.AlertDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setContentView(R.layout.larus_layout_plugin_custom_progressdialog);
        setMessage(this.f481623b);
        setIndeterminate(false);
        setProgress(this.f481624c);
        setCancelable(true);
        setMax(100);
        findViewById(android.R.id.content).setOnClickListener(new j(this));     // Catch: Exception -> L5
        findViewById(R.id.root).setOnClickListener(new k());     // Catch: Exception -> L5
    L7:
        this.f481622a = true;
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("PluginProgressDialog", e.getMessage());
        goto L7
    }

    @Override // android.app.ProgressDialog
    public final void setIndeterminate(boolean r100) {
        super.setIndeterminate(r100);
        if (this.f481622a == false) goto L13;
        PluginCircularProgressView r101 = (PluginCircularProgressView) findViewById(R.id.iv_loading);
        if (r101 == null) goto L7;
        r101.setIndeterminate(r100);
    L7:
        TextView r102 = (TextView) findViewById(R.id.progress);
        if (r100 == false) goto L10;
        int r103 = 4;
    L11:
        r102.setVisibility(r103);
        return;
    L10:
        r103 = 0;
        goto L11
    }

    @Override // android.app.ProgressDialog, android.app.AlertDialog
    public final void setMessage(CharSequence r100) {
        super.setMessage(r100);
        if (this.f481622a == false) goto L7;
        TextView r101 = (TextView) findViewById(R.id.message);
        if (r101 == null) goto L7;
        r101.setText(r100);
    L7:
        this.f481623b = r100;
    }

    @Override // android.app.ProgressDialog
    public final void setProgress(int r100) {
        if (this.f481624c <= r100) goto L5;
        return;
    L5:
        super.setProgress(r100);
        if (this.f481622a == true) goto L8;
    L15:
        this.f481624c = r100;
        return;
    L8:
        if (isShowing() == false) goto L15;
        TextView r101 = (TextView) findViewById(R.id.progress);
        if (r101 == null) goto L12;
        r101.setText(r100 + GXTemplateKey.GAIAX_PE);
    L12:
        PluginCircularProgressView r102 = (PluginCircularProgressView) findViewById(R.id.iv_loading);
        if (r102 == null) goto L15;
        r102.setProgress(r100);
        goto L15
    }
}
