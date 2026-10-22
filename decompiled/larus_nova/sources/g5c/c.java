package g5c;

import android.content.Context;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.ss.android.lark.SpDefaultSpConfigProviderImpl;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile b f480110a;

    public static a a(Context r100, String r101, b1c.c r102, b1c.b r103) {
        if (f480110a != null) goto L9;
        com.ss.android.lark.b r104 = (com.ss.android.lark.b) ClaymoreServiceLoader.loadFirstOrNull(com.ss.android.lark.b.class);
        if (r104 != null) goto L7;
        r104 = new SpDefaultSpConfigProviderImpl();
    L7:
        f480110a = r104.getSpConfig().f420584a;
        Log.i("SpInit", "sp creator not init, use default: " + f480110a.type());
    L9:
        return f480110a.a(r100, r101, r102);
    }
}
