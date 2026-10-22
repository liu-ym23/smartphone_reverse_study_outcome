package ef5;

import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyDataForInsert;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class w implements gf5.c {
    public final SmartReplyDataForInsert a;

    public final String toString() {
        return "InsertToDraftEvent(data=" + this.a + ')';
    }

    public w(SmartReplyDataForInsert r2) {
        Intrinsics.checkNotNullParameter(r2, "smartReplyDataForInsert");
        this.a = r2;
    }
}
