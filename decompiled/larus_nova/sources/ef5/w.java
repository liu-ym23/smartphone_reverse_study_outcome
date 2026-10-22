package ef5;

import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyDataForInsert;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class w implements gf5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SmartReplyDataForInsert f472513a;

    public final String toString() {
        return "InsertToDraftEvent(data=" + this.f472513a + ')';
    }

    public w(SmartReplyDataForInsert r100) {
        Intrinsics.checkNotNullParameter(r100, "smartReplyDataForInsert");
        this.f472513a = r100;
    }
}
