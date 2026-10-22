package i77;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.push.PushBody;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Long, Pair<PushBody, Integer>> f488469a;

    public b() {
        this.f488469a = new ConcurrentHashMap();
    }

    @Override // i77.a
    public final int A0(PushBody r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        Map<Long, Pair<PushBody, Integer>> r101 = this.f488469a;
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;
        Pair r103 = (Pair) r102.get(Long.valueOf(r100.f266713b));
        if (r103 != null) goto L9;
        return 0;
    L9:
        return ((Integer) r103.second).intValue();
    }

    @Override // i77.a
    public final boolean i0(String r100) {
        Iterator r101 = ((ConcurrentHashMap) this.f488469a).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L14;
        Pair r102 = (Pair) ((Map.Entry) r101.next()).getValue();
        if (r102 == null) goto L4;
        Object r103 = r102.first;
        if (r103 == null) goto L4;
        if (TextUtils.equals(((PushBody) r103).f266722k.toString(), r100) == false) goto L4;
        return true;
    L14:
        return false;
    }

    @Override // i77.a
    public final PushBody y0(long r100) {
        Map<Long, Pair<PushBody, Integer>> r101 = this.f488469a;
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;
        Pair r103 = (Pair) r102.get(Long.valueOf(r100));
        if (r103 != null) goto L5;
        return null;
    L5:
        return (PushBody) r103.first;
    }

    @Override // i77.a
    public final void T(PushBody r100, int r101) {
        Map<Long, Pair<PushBody, Integer>> r102 = this.f488469a;
        ConcurrentHashMap r103 = (ConcurrentHashMap) r102;
        r103.put(Long.valueOf(r100.f266713b), new Pair(r100, Integer.valueOf(r101)));
    }
}
