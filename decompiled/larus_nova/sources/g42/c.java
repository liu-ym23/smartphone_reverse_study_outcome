package g42;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public interface c {
    void a(g r100);

    String c(HighlightItem r100);

    void d(g r100);

    long e();

    List<d> g(PinType r100);

    Context getContext();

    String getCurrentUserId();

    DataCenter getDataCenter();

    RoomContext getDataContext();

    boolean i(HighlightItem r100);

    BehaviorSubject k();

    f m(HighlightItem r100);

    void n(PinType r100, d r101);

    Map<String, HighlightItem> o();
}
