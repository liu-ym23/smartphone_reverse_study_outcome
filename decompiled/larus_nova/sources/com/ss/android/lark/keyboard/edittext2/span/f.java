package com.ss.android.lark.keyboard.edittext2.span;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public interface f extends k {

    public static final class a {
        public static k.a b(int r100, int r101, Spannable r102) {
            Intrinsics.checkNotNullParameter(r102, "text");
            Log.d("InlineBlockSpan", "selectImpl: text len : " + r102.length() + ", start: " + r100 + ", end : " + r101);
            Selection.setSelection(r102, r100, r101);
            return new k.a(r100, r101);
        }

        public static k.a a(f r100, int r101, int r102, Editable r103) {
            Intrinsics.checkNotNullParameter(r103, "text");
            Log.d("InlineBlockSpan", "reselect: text len : " + r103.length() + ", start: " + r101 + ", end : " + r102);
            int r104 = r103.getSpanStart(r100);
            int r105 = r103.getSpanEnd(r100);
            int r106 = r104 + 1;
            boolean r107 = false;
            if (r106 > r101) goto L6;
            if (r101 >= r105) goto L6;
            boolean r108 = true;
        L7:
            if (r108 == true) goto L10;
            r104 = r101;
        L10:
            if (r106 > r102) goto L13;
            if (r102 >= r105) goto L13;
            r107 = true;
        L13:
            if (r107 == true) goto L16;
            r105 = r102;
        L16:
            if (r104 != r101) goto L21;
            if (r105 != r102) goto L21;
            return null;
        L21:
            Selection.setSelection(r103, r104, r105);
            return new k.a(r104, r105);
        L6:
            r108 = false;
            goto L7
        }
    }

    k.a a(int r100, int r101, Spannable r102);
}
