package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.AuditoryRecordingEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class t implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f563999a = null;

    static {
        f563999a = new t();
    }

    public t() {
    }

    @Override // xia.c
    public final int a(AppEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        if ((r100 instanceof AuditoryRecordingEntity) == false) goto L24;
        AuditoryRecordingEntity r101 = (AuditoryRecordingEntity) r100;
        int r102 = ((((((r101.getName().hashCode() + 0) * 31) + r101.getState()) * 31) + r101.getFile().hashCode()) * 31) + r101.getDuration();
        FileEntity r103 = r101.getTranscript();
        if (r103 == null) goto L7;
        r102 = (r102 * 31) + r103.hashCode();
    L7:
        String r104 = r101.getSummary();
        if (r104 == null) goto L10;
        r102 = (r102 * 31) + r104.hashCode();
    L10:
        List<String> r105 = r101.getTodoList();
        if (r105 == null) goto L13;
        r102 = (r102 * 31) + r105.hashCode();
    L13:
        List<Integer> r106 = r101.getMarkers();
        if (r106 == null) goto L16;
        r102 = (r102 * 31) + r106.hashCode();
    L16:
        String r107 = r101.getSourceAppName();
        if (r107 == null) goto L19;
        r102 = (r102 * 31) + r107.hashCode();
    L19:
        String r108 = r101.getSourceAppPackage();
        if (r108 != null) goto L22;
        return r102;
    L22:
        return (r102 * 31) + r108.hashCode();
    L24:
        throw new IllegalStateException("Check failed.".toString());
    }
}
