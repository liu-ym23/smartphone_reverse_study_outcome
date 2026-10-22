package sp8;

import com.bytedance.keva.Keva;
import com.larus.bmhome.input.api.EnterKeyAction;
import com.larus.platform.service.o;
import com.larus.platform.service.z2;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnterKeyAction f542909a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f542910b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final StateFlowImpl f542911c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b1 f542912d = null;

    static {
        f542909a = EnterKeyAction.NEWLINE;
        Lazy r100 = LazyKt.lazy(new a());
        f542910b = r100;
        StateFlowImpl r101 = j1.a(a(((Keva) r100.getValue()).getInt("user_enter_key_behavior_".concat(o.f365780a.getDeviceId()), -1)));
        f542911c = r101;
        f542912d = e.b(r101);
    }

    public static EnterKeyAction a(int r100) {
        if (z2.f365865a.enableEnterKeyBehaviorSetting() == false) goto L5;
        Iterator<EnterKeyAction> r101 = EnterKeyAction.getEntries().iterator();
    L8:
        if (r101.hasNext() == false) goto L15;
        EnterKeyAction r102 = r101.next();
        if (r102.getValue() != r100) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L8;
    L16:
        EnterKeyAction r104 = r102;
        if (r104 == null) goto L19;
        return r104;
    L19:
        return f542909a;
    L12:
        r103 = false;
        goto L13
    L15:
        r102 = null;
        goto L16
    L5:
        return f542909a;
    }
}
