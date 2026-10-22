package f4c;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.widget.EllipsizedEmojiconTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements b08.b<TextView, w3c.f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f475601a = null;

    static {
        f475601a = new e();
    }

    public e() {
    }

    @Override // b08.b
    public final void unbind(View r100) {
        TextView r101 = (TextView) r100;
        Intrinsics.checkNotNullParameter(r101, "view");
        r101.setVisibility(8);
    }

    public final void a(TextView r100, w3c.f r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Float r102 = r101.f558233f;
        if (r102 == null) goto L6;
        r100.setTextSize(0, a08.b.a(r102.floatValue(), r100.getContext()));
        r100.getLayoutParams().height = -2;
    L6:
        if (r101.f558231d == null) goto L10;
        r100.setVisibility(0);
        r100.setText("");
        Drawable r103 = r101.f558231d;
        Intrinsics.checkNotNullParameter(r100, "view");
        if (r103 == null) goto L28;
        Drawable[] r104 = r100.getCompoundDrawables();
        r100.setCompoundDrawables(r104[0], r104[1], r103, r104[3]);
        return;
    L28:
        return;
    L10:
        r100.setCompoundDrawables(null, null, null, null);
        if (TextUtils.isEmpty(r101.f558228a) == false) goto L13;
    L26:
        r100.setVisibility(8);
        return;
    L13:
        if (r101.f558229b == false) goto L26;
        r100.setVisibility(0);
        r100.setEllipsize(r101.f558234g);
        if ((r100 instanceof EllipsizedEmojiconTextView) == false) goto L19;
        TextUtils.TruncateAt r105 = r101.f558234g;
        ((EllipsizedEmojiconTextView) r100).f445616j = r105;
    L19:
        if (r101.f558232e == false) goto L21;
        int r106 = r100.getContext().getResources().getColor(R.color.primary_pri_500);
    L22:
        r100.setTextColor(r106);
        if (CollectionUtils.isEmpty(r101.f558230c) == false) goto L25;
        r100.setText(r101.f558228a);
        return;
    L25:
        j4c.a.a(new SpannableStringBuilder(r101.f558228a), r100, r101.f558230c, r100.getContext().getResources().getColor(R.color.primary_fill_default));
        return;
    L21:
        r106 = r100.getContext().getResources().getColor(R.color.text_placeholder);
        goto L22
    }

    @Override // b08.b
    public final /* bridge */ /* synthetic */ void bind(View r100, w3c.f r101) {
        a((TextView) r100, r101);
    }
}
