package android.view;

import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ViewFastCompat extends View {
    public ViewFastCompat(Context r1) {
        super(r1);
    }

    public static void finishInflate(View r0) {
        r0.onFinishInflate();
    }
}
