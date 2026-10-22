package yvb;

import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.span.PrefixSpan;

/* JADX INFO: loaded from: classes37.dex */
public final class c {
    public static final void a(PrefixSpan.b r100) {
        if (r100.f448592g.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        r100.f448589d = 0.0f;
        return;
    L9:
        if (r100.getType() != PrefixSpan.Type.LIST_NUM) goto L17;
        int r102 = r100.f448592g.length();
        if (r102 != 2) goto L13;
        r100.f448589d = UIHelper.dp2px(14.0f);
        return;
    L13:
        if (r102 == 3) goto L15;
        r100.f448589d = fec.b.d(r100.f448592g, UIHelper.getDimens(R.dimen.local_font_size_default));
        return;
    L15:
        r100.f448589d = UIHelper.dp2px(24.0f);
        return;
    L17:
        r100.f448589d = fec.b.d(r100.f448592g, UIHelper.getDimens(R.dimen.local_font_size_default));
        return;
    L5:
        r101 = false;
        goto L6
    }
}
