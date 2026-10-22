package q47;

import android.net.Uri;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.pia.core.misc.LRUCache;
import com.bytedance.pia.core.utils.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f<String, a> f531672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LRUCache<Uri, String> f531673b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f531674a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<String> f531675b;

        public static a a(Uri r110) {
            int r100 = j.f266400a;
            if (r110 == null) goto L7;
            String r101 = r110.getHost();
            if (r101 == null) goto L7;
            List r102 = StringsKt.split$default(r101, new char[]{'.'}, false, 0, 6, null);
        L8:
            if (r102 != null) goto L10;
            r102 = CollectionsKt.emptyList();
        L10:
            ArrayList r103 = new ArrayList();
            Iterator r104 = r102.iterator();
        L12:
            if (r104.hasNext() == false) goto L20;
            Object r105 = r104.next();
            if (((String) r105).length() <= 0) goto L16;
            boolean r106 = true;
        L17:
            if (r106 == false) goto L12;
            r103.add(r105);
            goto L12
        L16:
            r106 = false;
            goto L17
        L20:
            if (r103.isEmpty() == false) goto L22;
            return null;
        L22:
            r103.add(HTTP.URL_DEFAULT);
            if (r110 == null) goto L25;
            List<String> r107 = r110.getPathSegments();
        L26:
            if (r107 != null) goto L28;
            r107 = CollectionsKt.emptyList();
        L28:
            ArrayList r108 = new ArrayList();
            Iterator<T> r109 = r107.iterator();
        L30:
            if (r109.hasNext() == false) goto L41;
            List r111 = StringsKt.split$default((String) r109.next(), new char[]{'.'}, false, 0, 6, null);
            ArrayList r112 = new ArrayList();
            Iterator r113 = r111.iterator();
        L33:
            if (r113.hasNext() == false) goto L40;
            Object r114 = r113.next();
            if (((String) r114).length() <= 0) goto L37;
            boolean r115 = true;
        L38:
            if (r115 == false) goto L33;
            r112.add(r114);
            goto L33
        L37:
            r115 = false;
            goto L38
        L40:
            CollectionsKt.addAll(r108, r112);
            goto L30
        L41:
            r103.addAll(r108);
            Set<String> r116 = UriProtector.getQueryParameterNames(r110);
            if (r116.isEmpty() == false) goto L46;
            return new a(r103, null);
        L46:
            return new a(r103, new ArrayList(r116));
        L25:
            r107 = null;
        L7:
            r102 = null;
            goto L8
        }

        public a(List<String> r100, List<String> r101) {
            this.f531674a = r100;
            this.f531675b = r101;
        }
    }

    public g() {
        this.f531672a = new f();
        this.f531673b = new LRUCache(16);
    }
}
