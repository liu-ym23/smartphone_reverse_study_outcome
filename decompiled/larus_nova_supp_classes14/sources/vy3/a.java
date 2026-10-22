package vy3;

import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import com.bytedance.awemeopen.apps.framework.comment.widget.view.CommentMentionEditText;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import m44.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements d {
    public final EditText a;
    public final b b;
    public final InputConnection c;

    /* JADX WARN: Multi-variable type inference failed */
    public a(CommentMentionEditText r2, b r3) {
        Intrinsics.checkNotNullParameter(r2, "editText");
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.a = r2;
        this.b = r3;
        this.c = r2.onCreateInputConnection(new EditorInfo());
    }

    public final void a(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "emojiText");
        this.b.e(r3);
        if (r4 != 2) goto L5;
        this.b.q(r3, r4);
    L5:
        int r5 = this.a.getSelectionStart();
        int r0 = this.a.getSelectionEnd();
        int r6 = RangesKt.coerceAtLeast(0, r5);
        int r1 = RangesKt.coerceAtLeast(0, r0);
        if (r6 != r1) goto L12;
        this.a.getText().insert(r6, r3);
    L9:
        int r7 = r6 + r3.length();
        EditText r8 = this.a;
        r8.setSelection(Math.min(r7, r8.length()));
        return;
    L12:
        this.a.getText().replace(r6, r1, r3);     // Catch: IndexOutOfBoundsException -> L11
        goto L9
    }
}
