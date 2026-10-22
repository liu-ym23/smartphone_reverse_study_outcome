package r69;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f536359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f536360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f536361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f536362d;

    @Override // r69.a
    public final ConstraintLayout a(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r100 = 0;
        View r111 = LayoutInflater.from(r110).inflate(R.layout.larus_dora_toast_wearing_detection, null, false);
        ConstraintLayout r101 = (ConstraintLayout) r111;
        int r102 = R.id.inner_content;
        if (((LinearLayout) ViewBindings.findChildViewById(r111, R.id.inner_content)) == null) goto L43;
        r102 = R.id.left_icon;
        ImageView r103 = (ImageView) ViewBindings.findChildViewById(r111, R.id.left_icon);
        if (r103 == null) goto L43;
        r102 = R.id.left_icon_view;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(r111, R.id.left_icon_view);
        if (r104 == null) goto L43;
        r102 = R.id.left_text;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r111, R.id.left_text);
        if (r105 == null) goto L43;
        r102 = R.id.right_icon;
        ImageView r106 = (ImageView) ViewBindings.findChildViewById(r111, R.id.right_icon);
        if (r106 == null) goto L43;
        r102 = R.id.right_text;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r111, R.id.right_text);
        if (r107 == null) goto L43;
        r102 = R.id.title_text_view;
        TextView r108 = (TextView) ViewBindings.findChildViewById(r111, R.id.title_text_view);
        if (r108 == null) goto L43;
        r104.setImageResource(this.f536359a);
        r108.setText(this.f536360b);
        boolean r109 = true;
        if (this.f536361c == null) goto L19;
        boolean r112 = true;
    L20:
        StringBuilder r113 = new StringBuilder();
        r113.append(this.f536361c);
        r113.append('%');
        r105.setText(r113.toString());
        if (r112 == false) goto L23;
        int r114 = 0;
    L24:
        r105.setVisibility(r114);
        if (r112 == false) goto L27;
        int r115 = 0;
    L28:
        r103.setVisibility(r115);
        if (this.f536362d != null) goto L32;
        r109 = false;
    L32:
        StringBuilder r116 = new StringBuilder();
        r116.append(this.f536362d);
        r116.append('%');
        r107.setText(r116.toString());
        if (r109 == false) goto L35;
        int r117 = 0;
    L36:
        r107.setVisibility(r117);
        if (r109 == true) goto L40;
        r100 = 8;
    L40:
        r106.setVisibility(r100);
        return r101;
    L35:
        r117 = 8;
        goto L36
    L27:
        r115 = 8;
        goto L28
    L23:
        r114 = 8;
        goto L24
    L19:
        r112 = false;
    L43:
        throw new NullPointerException("Missing required view with ID: ".concat(r111.getResources().getResourceName(r102)));
    }

    public b(String r100, Integer r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "title");
        this.f536359a = R.drawable.larus_dora_phone_icon;
        this.f536360b = r100;
        this.f536361c = r101;
        this.f536362d = r102;
    }
}
