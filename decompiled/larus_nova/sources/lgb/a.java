package lgb;

import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.flow.chat.message.downgrade.data.LarkDowngradeCalendarContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class a implements y6b.d<mgb.a> {
    public a() {
    }

    @Override // y6b.d
    public final CharSequence b(MessageInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "messageInfo");
        return d(r100);
    }

    @Override // y6b.d
    public final CharSequence d(f5b.b r100) {
        Intrinsics.checkNotNullParameter(r100, "messageInfo");
        return ((LarkDowngradeCalendarContent) r100.getMessage().getContent()).getTitle();
    }

    @Override // y6b.d
    public final v5b.a c(v r100, f5b.b r101) {
        Intrinsics.checkNotNullParameter(r100, "containerOwner");
        Intrinsics.checkNotNullParameter(r101, "messageInfo");
        return new mgb.a((LarkDowngradeCalendarContent) r101.getMessage().getContent());
    }
}
