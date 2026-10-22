package com.bytedance.ee.bear.middleground.comment.export;

import androidx.fragment.app.DialogFragment;
import com.bytedance.ee.bear.config.CommentImageSelectorDismissReason;

/* JADX INFO: loaded from: classes18.dex */
public interface k {

    public static final class a {
        public static boolean a() {
            return l.a(ICommentHostDelegate$enableCommentVoice$1.INSTANCE);
        }
    }

    boolean c(DialogFragment r100, CommentImageSelectorDismissReason r101);

    DialogFragment e(ew4.c r100, ew4.e r101);

    boolean f();

    ew4.g l();

    boolean m();

    boolean n();

    boolean o();
}
