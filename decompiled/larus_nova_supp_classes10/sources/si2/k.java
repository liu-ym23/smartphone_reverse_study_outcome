package si2;

import android.text.TextUtils;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k extends com.bytedance.android.ec.core.utils.i {
    public static final /* synthetic */ int c = 0;

    public static final class a {
        @JvmStatic
        public static k a(String r1, String r2) {
            if (TextUtils.isEmpty(r1) == false) goto L5;
        L8:
            return null;
        L5:
            if (TextUtils.isEmpty(r2) == true) goto L8;
            return new k(r1, r2);
        }
    }

    static {
    }

    public k(String r1, String r2) {
        super(r1, r2);
    }
}
