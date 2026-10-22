package k99;

import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d {
    public static final boolean a(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<String, String> r101 = r100.getExt();
        if (r101 == null) goto L5;
        String r102 = r101.get("is_offline_msg");
    L7:
        return Intrinsics.areEqual(r102, "1");
    L5:
        r102 = null;
        goto L7
    }
}
