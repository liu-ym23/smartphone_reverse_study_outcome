package h7c;

import com.obric.miniapp.alarm.AlarmSessionType;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements hua.a {
    public c() {
    }

    @Override // hua.a
    public final String getBizName() {
        return AlarmSessionType.TODO;
    }

    @Override // hua.a
    public final List<iua.a> a() {
        return Collections.unmodifiableList(a.f484050a);
    }
}
