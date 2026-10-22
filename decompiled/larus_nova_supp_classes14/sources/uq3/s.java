package uq3;

import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class s implements QModel {
    public static final /* synthetic */ int c = 0;
    public final String a;
    public final long b;

    public static final class a {
        public static s a(com.bytedance.android.window.shop.repository.dto.g r4) {
            Intrinsics.checkNotNullParameter(r4, "dto");
            String r0 = r4.b();
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == false) goto L12;
            return null;
        L12:
            String r2 = r4.b();
            if (r2 != null) goto L15;
            r2 = "";
        L15:
            Long r5 = r4.a();
            if (r5 == null) goto L18;
            long r3 = r5.longValue();
        L20:
            return new s(r2, r3);
        L18:
            r3 = 0;
            goto L20
        L5:
            if (StringsKt.isBlank(r0) == true) goto L8;
            r1 = false;
            goto L9
        }
    }

    static {
    }

    public final int modelType() {
        return 0;
    }

    public s(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "replaySchema");
        this.a = r2;
        this.b = r3;
    }
}
