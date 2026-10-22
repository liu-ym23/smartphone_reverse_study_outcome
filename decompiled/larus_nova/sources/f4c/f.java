package f4c;

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
public final class f implements b08.b<TextView, w3c.f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f475602a = null;

    static {
        f475602a = new f();
    }

    public f() {
    }

    @Override // b08.b
    public final void unbind(View r100) {
        TextView r101 = (TextView) r100;
        Intrinsics.checkNotNullParameter(r101, "view");
        r101.setVisibility(8);
    }

    @Override // b08.b
    public final void bind(View r100, w3c.f r101) {
        TextView r102 = (TextView) r100;
        w3c.f r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "view");
        Intrinsics.checkNotNullParameter(r103, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if (TextUtils.isEmpty(r103.f558228a) == false) goto L5;
    L18:
        r102.setVisibility(8);
        return;
    L5:
        if (r103.f558229b == false) goto L18;
        r102.setVisibility(0);
        r102.setEllipsize(r103.f558234g);
        if ((r102 instanceof EllipsizedEmojiconTextView) == false) goto L11;
        TextUtils.TruncateAt r104 = r103.f558234g;
        ((EllipsizedEmojiconTextView) r102).f445616j = r104;
    L11:
        if (r103.f558232e == false) goto L13;
        int r105 = r102.getContext().getResources().getColor(R.color.primary_pri_500);
    L14:
        r102.setTextColor(r105);
        if (CollectionUtils.isEmpty(r103.f558230c) == false) goto L17;
        r102.setText(r103.f558228a);
        return;
    L17:
        j4c.a.a(new SpannableStringBuilder(r103.f558228a), r102, r103.f558230c, r102.getContext().getResources().getColor(R.color.primary_fill_default));
        return;
    L13:
        r105 = r102.getContext().getResources().getColor(R.color.text_placeholder);
        goto L14
    }
}
