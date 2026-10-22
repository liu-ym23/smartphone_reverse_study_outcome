package com.bytedance.ee.bear.drive.view.preview.action;

import android.os.Build;
import android.view.ActionMode;
import com.bytedance.ee.bear.widgets.universedesign.SpaceTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    static {
    }

    public static void a(SpaceTextView r3) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return;
    L5:
        if (r3 == null) goto L7;
        ActionMode.Callback r1 = r3.getCustomSelectionActionModeCallback();
    L8:
        if (r1 != null) goto L20;
        if (r3 != null) goto L11;
    L13:
        boolean r2 = false;
    L14:
        if (r2 == true) goto L22;
        if (r3 == null) goto L21;
        r3.setCustomSelectionActionModeCallback(((fu5.a) org.koin.java.a.c(fu5.a.class, null, null, 6)).t(DriveActionModeProxy$setCustomSelectionActionModeCallback$1.INSTANCE));
        return;
    L21:
        return;
    L22:
        return;
    L11:
        if (r3.isTextSelectable() == true) goto L13;
        r2 = true;
        goto L14
    L20:
        return;
    L7:
        r1 = null;
        goto L8
    }
}
