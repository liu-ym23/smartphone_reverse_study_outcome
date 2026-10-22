package si2;

import android.text.TextUtils;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes10.dex */
public final class k extends com.bytedance.android.ec.core.utils.i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f542177c = 0;

    public static final class a {
        @JvmStatic
        public static k a(String r100, String r101) {
            if (TextUtils.isEmpty(r100) == false) goto L5;
        L8:
            return null;
        L5:
            if (TextUtils.isEmpty(r101) == true) goto L8;
            return new k(r100, r101);
        }
    }

    static {
    }

    public k(String r100, String r101) {
        super(r100, r101);
    }
}
