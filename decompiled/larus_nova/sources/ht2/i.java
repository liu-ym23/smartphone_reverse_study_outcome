package ht2;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdkapi.depend.model.live.ActivityRoomSkinInfo;
import com.bytedance.android.livesdkapi.depend.model.live.ActivityRoomSkinWrapper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Consumer;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f487114a = null;

    static {
        f487114a = new i();
    }

    public i() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Response r101 = (Response) r100;
        ActivityRoomSkinWrapper r102 = (ActivityRoomSkinWrapper) r101.data;
        if (r102 == null) goto L13;
        List<ActivityRoomSkinInfo> r103 = r102.skins;
        if (r103 == null) goto L13;
        ActivityRoomSkinInfo r104 = (ActivityRoomSkinInfo) ListProtector.get(r103, 0);
        if (r104 == null) goto L13;
        Map<Integer, py.k> r105 = r104.getVerticalImages();
        if (r105 == null) goto L13;
        Collection<py.k> r106 = r105.values();
        if (r106 == null) goto L13;
        k.c(r106);
    L13:
        ActivityRoomSkinWrapper r107 = (ActivityRoomSkinWrapper) r101.data;
        if (r107 == null) goto L25;
        List<ActivityRoomSkinInfo> r108 = r107.skins;
        if (r108 == null) goto L26;
        ActivityRoomSkinInfo r109 = (ActivityRoomSkinInfo) ListProtector.get(r108, 0);
        if (r109 == null) goto L27;
        Map<Integer, py.k> r110 = r109.getHorizontalImages();
        if (r110 == null) goto L28;
        Collection<py.k> r111 = r110.values();
        if (r111 == null) goto L29;
        k.c(r111);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    }
}
