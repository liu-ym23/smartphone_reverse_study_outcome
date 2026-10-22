package z51;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.r;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {
    public static w71.b a(DataCenter r100) {
        IRoomContextService r101 = (IRoomContextService) k.f(IRoomContextService.class);
        Object r102 = null;
        if (r101 == null) goto L9;
        r r103 = r101.getRoomExpService(r100, 0);
        if (r103 == null) goto L9;
        j<ViewModel> r104 = r103.s();
        if (r104 == null) goto L9;
        ViewModel r105 = r104.getValue();
    L11:
        if ((r105 instanceof w71.b) == false) goto L15;
        r102 = r105;
    L15:
        return (w71.b) r102;
    L9:
        r105 = null;
        goto L11
    }

    public static w71.a b(DataCenter r100) {
        IRoomContextService r101 = (IRoomContextService) k.f(IRoomContextService.class);
        Object r102 = null;
        if (r101 == null) goto L9;
        r r103 = r101.getRoomExpService(r100, 0);
        if (r103 == null) goto L9;
        j<ViewModel> r104 = r103.s();
        if (r104 == null) goto L9;
        ViewModel r105 = r104.getValue();
    L11:
        if ((r105 instanceof w71.a) == false) goto L15;
        r102 = r105;
    L15:
        return (w71.a) r102;
    L9:
        r105 = null;
        goto L11
    }

    public static final r d(DataContext r100) {
        Intrinsics.checkNotNullParameter(r100, "dataContext");
        IRoomContextService r101 = (IRoomContextService) k.f(IRoomContextService.class);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getRoomExpService(r100);
    }

    public static /* synthetic */ r e(DataCenter r100) {
        return c(r100, 0);
    }

    public static final o g(DataContext r100) {
        Intrinsics.checkNotNullParameter(r100, "dataContext");
        IRoomContextService r101 = (IRoomContextService) k.f(IRoomContextService.class);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getRoomDataContext(r100);
    }

    public static final r c(DataCenter r100, long r101) {
        IRoomContextService r102 = (IRoomContextService) k.f(IRoomContextService.class);
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.getRoomExpService(r100, r101);
    }

    public static final o f(DataCenter r100, long r101) {
        IRoomContextService r102 = (IRoomContextService) k.f(IRoomContextService.class);
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.getRoomDataContext(r100, r101);
    }

    public static /* synthetic */ o h(DataCenter r100, int r101) {
        if ((r101 & 1) == 0) goto L6;
        r100 = null;
    L6:
        return f(r100, 0);
    }
}
