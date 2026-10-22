package yj;

import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.common.Priority;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public interface l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f568006a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Map<String, BufferedDiskCache> f568007a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a f568008b = null;

        public a() {
        }

        static {
            f568008b = new a();
            f568007a = new HashMap();
        }
    }

    public static final class b {
        public static /* synthetic */ boolean a(l r100, SimpleDraweeView r101, ControllerListener r102, String r103, String r104, String r105, HashMap r106, int r107) {
            if ((r107 & 32) == 0) goto L5;
            r106 = new HashMap();
        L5:
            r100.f(r101, r103, r106);
            return false;
        }

        public static /* synthetic */ void b(l r100, String r101, Priority r102, String r103, String r110, HashMap r111, boolean r112, String r113, int r114) {
            if ((r114 & 16) == 0) goto L5;
            r111 = new HashMap();
        L5:
            r100.b(r101, r102, r103, r110, r111);
        }
    }

    static {
        f568006a = a.f568008b;
    }

    void a(List r100, Priority r101, String r102, String r103, HashMap r104);

    void b(String r100, Priority r101, String r102, String r103, HashMap r104);

    Map<String, BufferedDiskCache> c();

    void d(GenericDraweeView r100, String r101, HashMap r102);

    void e();

    void f(SimpleDraweeView r100, String r101, HashMap r102);

    void g(String r100, String r101, String r102);

    void initFirstScreenImageRecord();
}
