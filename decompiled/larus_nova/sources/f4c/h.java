package f4c;

import android.text.TextUtils;
import android.view.View;
import com.larksuite.framework.utils.UIUtils;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.widget.EllipsizedEmojiconTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class h implements b08.b<EllipsizedEmojiconTextView, w3c.h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f475604a = null;

    static {
        f475604a = new h();
    }

    public h() {
    }

    @Override // b08.b
    public final void unbind(View r100) {
        EllipsizedEmojiconTextView r101 = (EllipsizedEmojiconTextView) r100;
        Intrinsics.checkNotNullParameter(r101, "view");
        r101.setVisibility(8);
    }

    @Override // b08.b
    public final void bind(View r100, w3c.h r101) {
        EllipsizedEmojiconTextView r102 = (EllipsizedEmojiconTextView) r100;
        w3c.h r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "view");
        Intrinsics.checkNotNullParameter(r103, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        boolean r104 = false;
        r102.setVisibility(0);
        r102.setText(r103.f558242a);
        r102.setEllipsize(r103.f558244c);
        TextUtils.TruncateAt r105 = r103.f558244c;
        r102.f445616j = r105;
        if (r105 == null) goto L5;
        r104 = true;
    L5:
        r102.setShouldEllipsized(r104);
        r102.setTextColor(UIUtils.getColor(r102.getContext(), r103.f558243b));
    }
}
