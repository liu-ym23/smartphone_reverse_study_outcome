package gh1;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.widget.y;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.k;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f481246c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f481247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y f481248b;

    /* JADX INFO: renamed from: gh1.a$a, reason: collision with other inner class name */
    public static final class C6019a {
        @JvmStatic
        public static void a(DataCenter r100, y r101) {
            Intrinsics.checkNotNullParameter(r101, "behavior");
            RoomContext r102 = RoomContext.a.c(RoomContext.Companion, r100, 0, 2);
            if (r102 == null) goto L12;
            a r103 = new a(1, r101);
            List<a> r104 = r102.getStickyBehaviorEvents();
            if (r104 == null) goto L7;
            r104.add(r103);
            return;
        L7:
            k<a> r105 = r102.getGestureLayoutBehaviorEvent();
            if (r105 == null) goto L10;
            r105.post(r103);
        L10:
            Unit r106 = Unit.INSTANCE;
            return;
        }

        @JvmStatic
        public static void b(DataCenter r100, y r101) {
            Intrinsics.checkNotNullParameter(r101, "behavior");
            RoomContext r102 = RoomContext.a.c(RoomContext.Companion, r100, 0, 2);
            if (r102 == null) goto L12;
            a r103 = new a(2, r101);
            List<a> r104 = r102.getStickyBehaviorEvents();
            if (r104 == null) goto L7;
            r104.add(r103);
            return;
        L7:
            k<a> r105 = r102.getGestureLayoutBehaviorEvent();
            if (r105 == null) goto L10;
            r105.post(r103);
        L10:
            Unit r106 = Unit.INSTANCE;
            return;
        }
    }

    static {
    }

    public a(int r100, y r101) {
        this.f481247a = -1;
        this.f481247a = r100;
        this.f481248b = r101;
    }
}
