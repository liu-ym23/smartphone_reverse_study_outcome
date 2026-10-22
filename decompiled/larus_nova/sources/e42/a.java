package e42;

import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import com.bytedance.android.livesdkapi.depend.model.live.CommentPinContent;
import g42.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends h<CommentPinContent> {
    public a(CommentPinContent r100) {
        Intrinsics.checkNotNullParameter(r100, "commentPinContent");
        super(PinType.Comment, r100, r100.getCommentMsgId());
    }
}
