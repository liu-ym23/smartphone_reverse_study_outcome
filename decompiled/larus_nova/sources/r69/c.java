package r69;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f536363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f536364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f536365c;

    @Override // r69.a
    public final ConstraintLayout a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        View r101 = LayoutInflater.from(r100).cloneInContext(r100).inflate(R.layout.larus_dora_toast_headphone_mode_g, null, false);
        ConstraintLayout r102 = (ConstraintLayout) r101;
        int r103 = R.id.dora_g_headphone_mode_toast_content_layout;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r101, R.id.dora_g_headphone_mode_toast_content_layout)) == null) goto L13;
        r103 = R.id.dora_g_headphone_mode_toast_icon;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(r101, R.id.dora_g_headphone_mode_toast_icon);
        if (r104 == null) goto L13;
        r103 = R.id.dora_g_headphone_mode_toast_subtitle;
        DoraTextView r105 = (DoraTextView) ViewBindings.findChildViewById(r101, R.id.dora_g_headphone_mode_toast_subtitle);
        if (r105 == null) goto L13;
        r103 = R.id.dora_g_headphone_mode_toast_title;
        DoraTextView r106 = (DoraTextView) ViewBindings.findChildViewById(r101, R.id.dora_g_headphone_mode_toast_title);
        if (r106 == null) goto L13;
        r104.setImageDrawable(this.f536363a);
        r106.setText(this.f536364b);
        r105.setText(this.f536365c);
        return r102;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r103)));
    }

    public c(Drawable r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "deviceName");
        Intrinsics.checkNotNullParameter(r102, "subtitle");
        this.f536363a = r100;
        this.f536364b = r101;
        this.f536365c = r102;
    }
}
