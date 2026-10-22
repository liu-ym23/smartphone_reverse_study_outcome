package y87;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import e97.g;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: y87.a$a, reason: collision with other inner class name */
    public static final class C8314a {
        public static void a(ClassLoader r100, File r101) throws Throwable {
            Object r102 = g.a(r100.getClass(), "pathList").get(r100);
            Field r103 = g.a(r102.getClass(), "nativeLibraryDirectories");
            File[] r104 = (File[]) r103.get(r102);
            ArrayList r105 = new ArrayList(r104.length + 1);
            r105.add(r101);
            int r106 = r104.length;
            int r107 = 0;
        L3:
            if (r107 >= r106) goto L8;
            File r108 = r104[r107];
            if (r101.equals(r108) == true) goto L7;
            r105.add(r108);
        L7:
            r107 = r107 + 1;
            goto L3
        L8:
            r103.set(r102, r105.toArray(new File[0]));
        }
    }

    public static final class b {
        public static void a(ClassLoader r100, File r101) throws Throwable {
            Object r102 = g.a(r100.getClass(), "pathList").get(r100);
            List r103 = (List) g.a(r102.getClass(), "nativeLibraryDirectories").get(r102);
            if (r103 != null) goto L5;
            r103 = new ArrayList(2);
        L5:
            Iterator r104 = r103.iterator();
        L7:
            if (r104.hasNext() == false) goto L11;
            if (r101.equals((File) r104.next()) == false) goto L7;
            r104.remove();
        L11:
            ListProtector.add(r103, 0, r101);
            List r105 = (List) g.a(r102.getClass(), "systemNativeLibraryDirectories").get(r102);
            if (r105 != null) goto L14;
            r105 = new ArrayList(2);
        L14:
            ArrayList r106 = new ArrayList((r103.size() + r105.size()) + 1);
            r106.addAll(r103);
            r106.addAll(r105);
            g.a(r102.getClass(), "nativeLibraryPathElements").set(r102, (Object[]) g.b(r102, "makePathElements", new Class[]{List.class, File.class, List.class}).invoke(r102, new Object[]{r106, null, new ArrayList()}));
        }
    }

    public static final class c {
        public static void a(ClassLoader r100, File r101) throws Throwable {
            Object r102 = g.a(r100.getClass(), "pathList").get(r100);
            List r103 = (List) g.a(r102.getClass(), "nativeLibraryDirectories").get(r102);
            if (r103 != null) goto L5;
            r103 = new ArrayList(2);
        L5:
            Iterator r104 = r103.iterator();
        L7:
            if (r104.hasNext() == false) goto L11;
            if (r101.equals((File) r104.next()) == false) goto L7;
            r104.remove();
        L11:
            ListProtector.add(r103, 0, r101);
            List r105 = (List) g.a(r102.getClass(), "systemNativeLibraryDirectories").get(r102);
            if (r105 != null) goto L14;
            r105 = new ArrayList(2);
        L14:
            ArrayList r106 = new ArrayList((r103.size() + r105.size()) + 1);
            r106.addAll(r103);
            r106.addAll(r105);
            g.a(r102.getClass(), "nativeLibraryPathElements").set(r102, (Object[]) g.b(r102, "makePathElements", new Class[]{List.class}).invoke(r102, new Object[]{r106}));
        }
    }

    public a() {
    }
}
