package n04;

import android.content.Context;
import android.widget.RelativeLayout;
import com.bytedance.awemeopen.apps.framework.profile.m;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class c extends RelativeLayout {
    public abstract void a(b r100);

    public abstract void b(m r100);

    public abstract void c(m r100);

    public abstract void d(m r100);

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100);
    }
}
