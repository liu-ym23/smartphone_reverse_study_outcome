package dl1;

import com.ss.ttvideoengine.IPreLoaderItemCallBackListener;
import com.ss.ttvideoengine.PreLoaderItemCallBackInfo;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class k implements IPreLoaderItemCallBackListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f469109a;

    public k(i r100) {
        this.f469109a = r100;
    }

    @Override // com.ss.ttvideoengine.IPreLoaderItemCallBackListener
    public final void preloadItemInfo(PreLoaderItemCallBackInfo r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.getKey());
    L6:
        if (r101 != null) goto L9;
    L15:
        if (r101 != null) goto L18;
    L24:
        if (r101 != null) goto L27;
        return;
    L27:
        if (r101.intValue() != 5) goto L35;
        ConcurrentHashMap<String, i> r102 = l.f469110a;
        ConcurrentHashMap<String, i> r103 = l.f469110a;
        String r104 = this.f469109a.f469099a;
        if (r103 == null) goto L32;
        TypeIntrinsics.asMutableMap(r103).remove(r104);
        return;
    L32:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    L35:
        return;
    L18:
        if (r101.intValue() != 3) goto L24;
        ConcurrentHashMap<String, i> r105 = l.f469110a;
        ConcurrentHashMap<String, i> r106 = l.f469110a;
        String r107 = this.f469109a.f469099a;
        if (r106 == null) goto L23;
        TypeIntrinsics.asMutableMap(r106).remove(r107);
        return;
    L23:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    L9:
        if (r101.intValue() != 2) goto L15;
        ConcurrentHashMap<String, i> r108 = l.f469110a;
        ConcurrentHashMap<String, i> r109 = l.f469110a;
        String r110 = this.f469109a.f469099a;
        if (r109 == null) goto L14;
        TypeIntrinsics.asMutableMap(r109).remove(r110);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    L4:
        r101 = null;
        goto L6
    }
}
