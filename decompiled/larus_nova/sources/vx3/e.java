package vx3;

import android.util.LruCache;
import com.facebook.keyframes.model.KFImage;

/* JADX INFO: loaded from: classes14.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f557473b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f557474a;

    public class a extends LruCache<String, KFImage> {
        public a() {
            super(5242880);
        }

        @Override // android.util.LruCache
        public final int sizeOf(String r100, KFImage r101) {
            KFImage r102 = r101;
            if (r102 != null) goto L5;
        L12:
            return 1;
        L5:
            if (r102.getCanvasSize() == null) goto L12;
            if (r102.getCanvasSize().length <= 0) goto L12;
            float[] r103 = r102.getCanvasSize();
            int r104 = r103.length;
            float r105 = 1.0f;
            int r106 = 0;
        L9:
            if (r106 >= r104) goto L11;
            r105 = r105 + r103[r106];
            r106 = r106 + 1;
            goto L9
        L11:
            int r107 = e.f557473b;
            r102.toString();
            return (int) r105;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f557475a = null;

        static {
            f557475a = new e();
        }
    }

    public e() {
        this.f557474a = new a();
    }

    static {
    }
}
