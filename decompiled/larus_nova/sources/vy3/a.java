package vy3;

import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import com.bytedance.awemeopen.apps.framework.comment.widget.view.CommentMentionEditText;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import m44.d;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EditText f557608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f557609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InputConnection f557610c;

    public a(CommentMentionEditText r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "editText");
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f557608a = r100;
        this.f557609b = r101;
        this.f557610c = r100.onCreateInputConnection(new EditorInfo());
    }

    @Override // m44.d
    public final void a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "emojiText");
        this.f557609b.e(r100);
        if (r101 != 2) goto L5;
        this.f557609b.q(r100, r101);
    L5:
        int r102 = this.f557608a.getSelectionStart();
        int r103 = this.f557608a.getSelectionEnd();
        int r104 = RangesKt.coerceAtLeast(0, r102);
        int r105 = RangesKt.coerceAtLeast(0, r103);
        if (r104 != r105) goto L12;
        this.f557608a.getText().insert(r104, r100);
    L9:
        int r106 = r104 + r100.length();
        EditText r107 = this.f557608a;
        r107.setSelection(Math.min(r106, r107.length()));
        return;
    L12:
        this.f557608a.getText().replace(r104, r105, r100);     // Catch: IndexOutOfBoundsException -> L11
        goto L9
    }
}
