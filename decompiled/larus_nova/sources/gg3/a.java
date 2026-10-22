package gg3;

import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f481106a = 0;

    static {
    }

    public static boolean a(e r100) {
        if (r100 == null) goto L8;
        com.bytedance.kmp.ec.yata.common.protocol.data.c r101 = r100.g();
        if (r101 == null) goto L8;
        Map<String, Object> r102 = r101.g();
        if (r102 == null) goto L8;
        Object r103 = r102.get("chunk_index");
    L10:
        return Intrinsics.areEqual(r103, 0);
    L8:
        r103 = null;
        goto L10
    }
}
