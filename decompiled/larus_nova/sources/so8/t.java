package so8;

import com.larus.bmhome.chat.zoom.IZoomInAnimationProvider;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f542785a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, List<IZoomInAnimationProvider>> f542786b = null;

    public t() {
    }

    static {
        f542785a = new t();
        f542786b = new LinkedHashMap();
        Iterator r100 = ServiceManager.get().getServices(IZoomInAnimationProvider.class, true).iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        IZoomInAnimationProvider r101 = (IZoomInAnimationProvider) r100.next();
        t r102 = f542785a;
        Intrinsics.checkNotNull(r101);
        r102.getClass();
        r101.h();
        Map<String, List<IZoomInAnimationProvider>> r103 = f542786b;
        List<IZoomInAnimationProvider> r104 = r103.get(r101.h());
        if (r104 != null) goto L8;
        r104 = new ArrayList();
    L8:
        r104.add(r101);
        r103.put(r101.h(), r104);
        goto L4
    }
}
