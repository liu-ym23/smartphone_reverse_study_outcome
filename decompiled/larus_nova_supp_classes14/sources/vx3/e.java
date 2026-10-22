package vx3;

import android.util.LruCache;
import com.facebook.keyframes.model.KFImage;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e {
    public static final /* synthetic */ int b = 0;
    public final a a;

    public class a extends LruCache<String, KFImage> {
        public a() {
            super(5242880);
        }

        @Override // android.util.LruCache
        public final int sizeOf(String r5, KFImage r6) {
            KFImage r7 = r6;
            if (r7 != null) goto L5;
        L12:
            return 1;
        L5:
            if (r7.getCanvasSize() == null) goto L12;
            if (r7.getCanvasSize().length <= 0) goto L12;
            float[] r8 = r7.getCanvasSize();
            int r0 = r8.length;
            float r1 = 1.0f;
            int r2 = 0;
        L9:
            if (r2 >= r0) goto L11;
            r1 = r1 + r8[r2];
            r2 = r2 + 1;
            goto L9
        L11:
            int r9 = e.b;
            r7.toString();
            return (int) r1;
        }
    }

    public static class b {
        public static final e a = null;

        static {
            a = new e();
        }
    }

    public e() {
        this.a = new a();
    }

    static {
    }
}
