package i75;

import com.larus.im.internal.network.proto2.AvCmd;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes16.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Integer> f488467a = null;

    static {
        f488467a = CollectionsKt.listOf(new Integer[]{1001, 90001041, 90003041, 90001044, 90003044, 90001043, 90003043, 11001, Integer.valueOf(AvCmd.CommandEventType.TRIGGER_NOISY_VALUE), 233527007, 2004, 1039});
    }

    @JvmStatic
    public static final boolean a(int r100) {
        boolean r101 = !f488467a.contains(Integer.valueOf(r100));
        tt5.a.h("DriveTransmissionCheckerManager", "canRetryUpload: errorCode=" + r100 + ", result=" + r101);
        return r101;
    }
}
