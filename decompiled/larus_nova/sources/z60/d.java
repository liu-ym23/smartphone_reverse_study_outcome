package z60;

import com.bytedance.android.live.core.setting.d6;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d extends a {
    public d() {
    }

    @Override // z60.a
    public final void a(Map<String, ? extends Object> r100, Map<String, ? extends Object> r101) {
        Map<String, Long> r102 = a70.b.f1985a;
        StringBuilder r103 = new StringBuilder("添加数据为：");
        Integer r104 = null;
        if (r101 == null) goto L5;
        String r105 = r101.toString();
    L6:
        r103.append(r105);
        r103.append("，删除数据长度为：");
        if (r100 == null) goto L9;
        r104 = Integer.valueOf(r100.size());
    L9:
        r103.append(r104);
        String r106 = r103.toString();
        Intrinsics.checkNotNullParameter(r106, "msg");
        if (a70.b.c("_MAIN", r106) == false) goto L13;
        d6.c("SettingReportMonitor", r106);
        return;
    L13:
        return;
    L5:
        r105 = null;
        goto L6
    }

    @Override // z60.a
    public final void b(boolean r100, boolean r110, Map<String, ? extends Object> r111, Map<String, ? extends Object> r112) {
        Intrinsics.checkNotNullParameter(r111, "deleteMap");
        Intrinsics.checkNotNullParameter(r112, "updateOrAdd");
        int r101 = !r100 ? 1 : 0;
        if (r110 == false) goto L5;
        String r102 = "full";
    L6:
        a70.c.a(r101, r102, "frontier", a70.b.b(), r112.size(), r111.size(), "update数据");
        return;
    L5:
        r102 = "incr";
        goto L6
    }
}
