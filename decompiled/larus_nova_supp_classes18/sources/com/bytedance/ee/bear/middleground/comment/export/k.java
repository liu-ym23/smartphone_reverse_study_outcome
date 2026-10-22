package com.bytedance.ee.bear.middleground.comment.export;

import androidx.fragment.app.DialogFragment;
import com.bytedance.ee.bear.config.CommentImageSelectorDismissReason;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface k {

    public static final class a {
        public static boolean a() {
            return l.a(ICommentHostDelegate$enableCommentVoice$1.INSTANCE);
        }
    }

    boolean c(DialogFragment r1, CommentImageSelectorDismissReason r2);

    DialogFragment e(ew4.c r1, ew4.e r2);

    boolean f();

    ew4.g l();

    boolean m();

    boolean n();

    boolean o();
}
