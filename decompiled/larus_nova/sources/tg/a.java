package tg;

import com.bytedance.android.ec.core.event.eventdumper.model.DumpedEventKey;
import com.bytedance.android.ec.core.event.eventdumper.model.DumpedEventParam;
import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public interface a {
    Map<DumpedEventKey, DumpedEventParam> getDumpedDumpedEventParams();

    int getEventClassVersion();

    String getEventName();
}
