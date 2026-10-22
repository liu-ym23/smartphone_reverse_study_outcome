package pg8;

import android.text.TextUtils;
import com.larus.bmhome.chat.api.q0;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a implements tg8.b {
    public a() {
    }

    @Override // tg8.b
    public final boolean c(t1a.b r100, Message r101, q0 r102) {
        Intrinsics.checkNotNullParameter(r101, "message");
        if (Intrinsics.areEqual(r101.getBizContentType(), "deep_search_card") == true) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(com.larus.im.bean.message.a.Q(r101)) == true) goto L10;
        return true;
    L10:
        return false;
    }
}
