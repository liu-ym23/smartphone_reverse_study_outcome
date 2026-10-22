package com.bytedance.ee.bear.mindnote;

import android.os.Build;
import androidx.core.graphics.ColorUtils;
import androidx.fragment.app.FragmentActivity;
import bp5.c;
import com.bytedance.ee.bear.document.DocumentFragment;
import com.larksuite.framework.utils.UIUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class MindNoteFragment extends DocumentFragment {
    public final void onDestroyView() {
        super/*com.bytedance.ee.bear.document.WebViewFragment*/.onDestroyView();
        FragmentActivity r0 = getActivity();
        if (Build.VERSION.SDK_INT < 23) goto L5;
        int r1 = getResources().getColor(2131100548, r0.getTheme());
    L7:
        if (ColorUtils.calculateContrast(-1, UIUtils.getColor(getContext(), 2131100548)) > 3.0d) goto L9;
        boolean r2 = true;
    L10:
        c.e(r0, null, r1, r2);
        return;
    L9:
        r2 = false;
        goto L10
    L5:
        r1 = getResources().getColor(2131100548);
        goto L7
    }

    static {
    }

    public MindNoteFragment() {
    }
}
