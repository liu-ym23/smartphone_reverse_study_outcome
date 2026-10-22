package y22;

import com.bytedance.android.livesdk.event.c0;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentBusinessType;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentContentType;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentFlowContext;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentInputConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {
    public static final boolean a(CommentFlowContext r100) {
        if (r100 == null) goto L6;
        CommentInputConfig r101 = r100.f133051d;
        if (r101 == null) goto L6;
        return r101.f133076o;
    L6:
        return false;
    }

    public static final boolean b(c0 r100) {
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.f123334g;
    L7:
        if ((r102 instanceof CommentFlowContext) == false) goto L10;
        r101 = r102;
    L10:
        CommentFlowContext r103 = (CommentFlowContext) r101;
        if (r103 != null) goto L14;
        return false;
    L14:
        CommentContentType r104 = CommentContentType.Image;
        CommentBusinessType r105 = CommentBusinessType.Normal;
        Intrinsics.checkNotNullParameter(r104, "contentType");
        Intrinsics.checkNotNullParameter(r105, "businessType");
        Intrinsics.checkNotNullParameter(r100, "emojiEvent");
        r103.f133048a = CommentFlowContext.State.Send;
        r103.f133052e = r104;
        r103.f133053f = r105;
        r103.f133055h = r100;
        return r103.a();
    L5:
        r102 = null;
        goto L7
    }
}
