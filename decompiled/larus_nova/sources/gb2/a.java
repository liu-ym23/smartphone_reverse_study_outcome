package gb2;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;
import vh7.f;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final IRoom f480675a = null;

    static {
        f480675a = (IRoom) f.c(IRoom.class);
    }

    public static /* synthetic */ boolean b(DataCenter r100) {
        return a(r100, false);
    }

    public static /* synthetic */ boolean d(DataCenter r100) {
        return c(r100, true);
    }

    public static final IRoom e(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$room");
        return (IRoom) r100.get("data_room", f480675a);
    }

    public static final boolean a(DataCenter r100, boolean r101) {
        Boolean r102 = Boolean.valueOf(r101);
        if (r100 == null) goto L14;
        Object r103 = null;
        Object r104 = r100.get("data_is_anchor", null);
        if ((r104 instanceof Boolean) == false) goto L9;
        r103 = r104;
    L9:
        Boolean r105 = (Boolean) r103;
        if (r105 == null) goto L14;
        r102 = r105;
    L14:
        return r102.booleanValue();
    }

    public static final boolean c(DataCenter r100, boolean r101) {
        Boolean r102 = Boolean.valueOf(r101);
        if (r100 == null) goto L14;
        Object r103 = null;
        Object r104 = r100.get("data_is_portrait", null);
        if ((r104 instanceof Boolean) == false) goto L9;
        r103 = r104;
    L9:
        Boolean r105 = (Boolean) r103;
        if (r105 == null) goto L14;
        r102 = r105;
    L14:
        return r102.booleanValue();
    }
}
