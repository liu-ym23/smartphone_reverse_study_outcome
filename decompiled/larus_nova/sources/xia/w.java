package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class w implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f564002a = null;

    static {
        f564002a = new w();
    }

    public w() {
    }

    @Override // xia.c
    public final int a(AppEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        if ((r100 instanceof CallHistoryEntity) == false) goto L32;
        CallHistoryEntity r101 = (CallHistoryEntity) r100;
        int r102 = ((((r101.getTelephones().hashCode() + 0) * 31) + r101.getCallType().name().hashCode()) * 31) + r101.getDuration();
        String r103 = r101.getTag();
        if (r103 == null) goto L7;
        r102 = (r102 * 31) + r103.hashCode();
    L7:
        int r104 = r102 * 31;
        int r105 = 1231;
        if (r101.isAIPickup() == false) goto L10;
        int r106 = 1231;
    L11:
        int r107 = (r104 + r106) * 31;
        if (r101.getHasTranscript() == true) goto L15;
        r105 = 1237;
    L15:
        int r108 = r107 + r105;
        String r109 = r101.getTranscript();
        if (r109 == null) goto L18;
        r108 = (r108 * 31) + r109.hashCode();
    L18:
        List<String> r110 = r101.getCarriers();
        if (r110 == null) goto L21;
        r108 = (r108 * 31) + r110.hashCode();
    L21:
        List<String> r111 = r101.getTodoList();
        if (r111 == null) goto L24;
        r108 = (r108 * 31) + r111.hashCode();
    L24:
        String r112 = r101.getTranscriptTitle();
        if (r112 == null) goto L27;
        r108 = (r108 * 31) + r112.hashCode();
    L27:
        String r113 = r101.getSourceNumber();
        if (r113 != null) goto L30;
        return r108;
    L30:
        return (r108 * 31) + r113.hashCode();
    L10:
        r106 = 1237;
        goto L11
    L32:
        throw new IllegalStateException("Check failed.".toString());
    }
}
