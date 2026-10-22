package i7a;

import android.graphics.Path;
import com.lynx.tasm.utils.LRUHashMap;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LRUHashMap<Path, a> f488498a = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f488499a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<Float> f488500b;

        public a() {
            this.f488500b = new ArrayList();
        }
    }

    static {
        f488498a = new LRUHashMap(10);
    }
}
