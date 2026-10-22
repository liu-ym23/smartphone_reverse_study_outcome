package xia;

import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class l implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f563991a = null;

    static {
        f563991a = new l();
    }

    public l() {
    }

    @Override // xia.c
    public final int a(AppEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        if ((r100 instanceof AlarmEntity) == false) goto L30;
        AlarmEntity r101 = (AlarmEntity) r100;
        int r102 = (((r101.getName().hashCode() + 0) * 31) + r101.getStartTime().hashCode()) * 31;
        int r103 = 1231;
        if (r101.isEnabled() == false) goto L7;
        int r104 = 1231;
    L8:
        int r105 = r102 + r104;
        List<Integer> r106 = r101.getRepeatDayOfWeek();
        if (r106 == null) goto L11;
        r105 = (r105 * 31) + r106.hashCode();
    L11:
        int r107 = r105 * 31;
        if (r101.getCloseInHoliday() == false) goto L14;
        int r108 = 1231;
    L15:
        int r109 = r107 + r108;
        String r110 = r101.getDate();
        if (r110 == null) goto L18;
        r109 = (r109 * 31) + r110.hashCode();
    L18:
        Boolean r111 = r101.isRinging();
        if (r111 == null) goto L25;
        int r112 = r109 * 31;
        if (r111.booleanValue() == true) goto L24;
        r103 = 1237;
    L24:
        r109 = r112 + r103;
    L25:
        Integer r113 = r101.getRepeatType();
        if (r113 == null) goto L31;
        int r114 = r109 * 31;
        return r114 + r113.intValue();
    L31:
        return r109;
    L14:
        r108 = 1237;
        goto L15
    L7:
        r104 = 1237;
        goto L8
    L30:
        throw new IllegalStateException("Check failed.".toString());
    }
}
