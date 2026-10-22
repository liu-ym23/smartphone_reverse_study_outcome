package hu1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.dsl.util.DSLActionEnum;
import com.bytedance.android.livesdk.dsl.util.c;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import yt1.h;
import yt1.j;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements h {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // yt1.h
    public final String a() {
        return null;
    }

    @Override // yt1.h
    public final DSLActionEnum getName() {
        return DSLActionEnum.LiveLocalALogger;
    }

    @Override // yt1.h
    public final void b(Map r100, j r101) {
        String r102 = c.d(r100, "tag");
        if (r102 == null) goto L19;
        StringBuilder r103 = new StringBuilder();
        if (r100 == null) goto L12;
        Iterator r104 = r100.entrySet().iterator();
    L8:
        if (r104.hasNext() == false) goto L12;
        Map.Entry r105 = (Map.Entry) r104.next();
        if ((!Intrinsics.areEqual((String) r105.getKey(), "tag")) == false) goto L8;
        r103.append(((String) r105.getKey()) + ContainerUtils.KEY_VALUE_DELIMITER + String.valueOf(r105.getValue()));
        r103.append(",");
    L12:
        ALogger.i(r102, r103.toString());
        return;
    }
}
