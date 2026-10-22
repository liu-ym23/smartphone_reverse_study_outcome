package n1b;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.LKAPIModules;
import com.ss.android.lark.chameleonv2.lkapi.tea.ITea$Internal$EventItem;
import com.ss.android.lark.chameleonv2.lkapi.tea.ITea$Internal$Events;
import com.ss.android.lark.statistics.Statistics;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends z0b.a {

    /* JADX INFO: renamed from: n1b.a$a, reason: collision with other inner class name */
    public static final class C6881a {
    }

    public final class b extends AbsChameleonHandler<ITea$Internal$Events> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f516681a;

        public b() {
            this.f516681a = LKAPIModules.Internal.Tea.TrackNoReturn.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.f516681a;
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(ITea$Internal$Events r100, Callback r101) {
            ITea$Internal$Events r102 = r100;
            Intrinsics.checkNotNullParameter(r102, HiAnalyticsConstant.Direction.REQUEST);
            Intrinsics.checkNotNullParameter(r101, "callback");
            Iterator<T> r103 = r102.getValue().iterator();
        L4:
            if (r103.hasNext() == false) goto L6;
            ITea$Internal$EventItem r104 = (ITea$Internal$EventItem) r103.next();
            Statistics.sendEvent(r104.getEventName(), new JSONObject(r104.getParams()));
            goto L4
        }
    }

    static {
    }

    @Override // z0b.a
    public final List<AbsChameleonHandler<?>> c() {
        return CollectionsKt.arrayListOf(new b[]{new b()});
    }

    public a() {
    }
}
