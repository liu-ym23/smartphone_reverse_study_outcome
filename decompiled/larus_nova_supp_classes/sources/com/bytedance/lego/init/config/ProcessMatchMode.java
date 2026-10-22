package com.bytedance.lego.init.config;

import android.util.EventsUtils;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/lego/init/config/ProcessMatchMode;", XmlPullParser.NO_NAMESPACE, "(Ljava/lang/String;I)V", "STRICT", "ENDWITH", "CONTAIN", "initscheduler_release"}, k = 1, mv = {1, 1, EventsUtils.FEAT_TYPE_PERF_COMMON_DATA})
public final enum ProcessMatchMode extends Enum<ProcessMatchMode> {
    private static final /* synthetic */ ProcessMatchMode[] $VALUES = null;
    public static final ProcessMatchMode CONTAIN = null;
    public static final ProcessMatchMode ENDWITH = null;
    public static final ProcessMatchMode STRICT = null;

    static {
        ProcessMatchMode r1 = new ProcessMatchMode("STRICT", 0);
        STRICT = r1;
        ProcessMatchMode r2 = new ProcessMatchMode("ENDWITH", 1);
        ENDWITH = r2;
        ProcessMatchMode r3 = new ProcessMatchMode("CONTAIN", 2);
        CONTAIN = r3;
        $VALUES = new ProcessMatchMode[]{r1, r2, r3};
    }

    public static ProcessMatchMode valueOf(String r1) {
        return (ProcessMatchMode) a.a(ProcessMatchMode.class, r1);
    }

    public static ProcessMatchMode[] values() {
        return (ProcessMatchMode[]) $VALUES.clone();
    }

    public ProcessMatchMode(String r1, int r2) {
        super(r1, r2);
    }
}
