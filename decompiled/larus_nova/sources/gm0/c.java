package gm0;

import com.bytedance.android.live.room.api.messagewindow.trigger.TriggerId;
import com.bytedance.android.livesdk.message.model.i3;
import com.bytedance.android.livesdk.message.model.j3;
import com.bytedance.android.livesdk.message.model.y1;
import com.bytedance.android.livesdk.message.model.z1;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.text.StringsKt;
import mm0.e;

/* JADX INFO: loaded from: classes46.dex */
public final class c extends gm0.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i3 f481652d;

    public static final class a {
    }

    static {
    }

    @Override // g71.b
    public final List<u71.b> b() {
        i3 r100 = this.f481652d;
        if (r100 == null) goto L7;
        j3 r101 = r100.cardDisplayInfo;
        if (r101 == null) goto L7;
        z1 r102 = r101.triggerConfig;
    L8:
        int r103 = 0;
        if (r102 == null) goto L24;
        List<y1> r104 = r102.commonTriggerList;
        if (r104 == null) goto L24;
        Iterator<T> r105 = r104.iterator();
    L14:
        if (r105.hasNext() == false) goto L24;
        y1 r106 = (y1) r105.next();
        DataCenter r107 = this.f481650c;
        int r108 = r106.type;
        Long r109 = r106.value;
        i3 r110 = this.f481652d;
        if (r110 == null) goto L20;
        Integer r111 = r110.type;
        if (r111 == null) goto L20;
        int r112 = r111.intValue();
    L21:
        lm0.a r113 = e.a(r107, r108, r109, r112);
        if (r113 == null) goto L14;
        ((ArrayList) this.f481648a).add(r113);
    L20:
        r112 = 0;
    L24:
        if (r102 == null) goto L45;
        Map<String, String> r114 = r102.customTriggerMap;
        if (r114 == null) goto L45;
        Iterator<Map.Entry<String, String>> r115 = r114.entrySet().iterator();
    L29:
        if (r115.hasNext() == false) goto L45;
        Map.Entry<String, String> r116 = r115.next();
        String r117 = r116.getKey();
        if (r117.hashCode() != 1570418086) goto L29;
        if (r117.equals("before_ofchannel_finish") == false) goto L29;
        DataCenter r118 = this.f481650c;
        int r119 = TriggerId.EXIT_MIC_TIME_LIMIT.getValue();
        Long r120 = StringsKt.toLongOrNull(r116.getValue());
        i3 r121 = this.f481652d;
        if (r121 == null) goto L40;
        Integer r122 = r121.type;
        if (r122 == null) goto L40;
        int r123 = r122.intValue();
    L41:
        lm0.a r124 = e.a(r118, r119, r120, r123);
        if (r124 == null) goto L29;
        ((ArrayList) this.f481648a).add(r124);
    L40:
        r123 = 0;
    L45:
        if (((ArrayList) this.f481648a).isEmpty() == false) goto L55;
        DataCenter r125 = this.f481650c;
        int r126 = TriggerId.ENTER_ROOM_TIME_LIMIT.getValue();
        i3 r127 = this.f481652d;
        if (r127 == null) goto L51;
        Integer r128 = r127.type;
        if (r128 == null) goto L51;
        r103 = r128.intValue();
    L51:
        lm0.a r129 = e.a(r125, r126, 0L, r103);
        if (r129 == null) goto L55;
        ((ArrayList) this.f481648a).add(r129);
    L55:
        return this.f481648a;
    L7:
        r102 = null;
        goto L8
    }

    public c(i3 r100, DataCenter r101) {
        super(r101);
        this.f481652d = r100;
    }
}
