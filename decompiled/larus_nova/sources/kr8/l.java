package kr8;

import android.util.LruCache;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.ixigua.lib.track.TrackParams;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public interface l {

    public static final class a {
        public static void a(l r100, by7.e r101, JSONObject r102) {
            LruCache<String, Boolean> r103 = q.f505883a;
            Intrinsics.checkNotNullParameter(r100, "mobData");
            JSONObject r104 = new JSONObject(GsonProtectorUtils.toJson(q.f505887e, r100));
            if (r102 == null) goto L9;
            Iterator<String> r105 = r102.keys();
            if (r105 == null) goto L9;
        L7:
            if (r105.hasNext() == false) goto L9;
            String r106 = r105.next();
            r104.put(r106, r102.opt(r106));
        L9:
            TrackParams r107 = new TrackParams().merge(r104);
            String r108 = r100.a();
            if (r108 != null) goto L12;
            r108 = "";
        L12:
            by7.a r109 = new by7.a(r108);
            if (r101 == null) goto L15;
            r109.f21464b = r101;
        L15:
            r109.f21463a.merge(r107);
            r109.b();
        }

        public static /* synthetic */ void b(l r100, JSONObject r101, int r102) {
            if ((r102 & 2) == 0) goto L5;
            r101 = null;
        L5:
            r100.b(null, r101);
        }
    }

    String a();

    void b(by7.e r100, JSONObject r101);
}
