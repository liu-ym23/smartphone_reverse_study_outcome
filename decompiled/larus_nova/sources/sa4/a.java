package sa4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONException;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final va4.b f541162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f541163b;

    /* JADX INFO: renamed from: sa4.a$a, reason: collision with other inner class name */
    public static final class C7591a<T> implements Comparator<T> {
        public C7591a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Long.valueOf(((ta4.a) r101).f545168b), Long.valueOf(((ta4.a) r100).f545168b));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v3, types: [T, ta4.b] */
    public final void a() throws IOException, JSONException {
        monitor-enter(a.class);
        Ref.ObjectRef r100 = new Ref.ObjectRef();     // Catch: Throwable -> L39
        b r101 = this.f541163b;     // Catch: Throwable -> L39
        ta4.b r102 = r101.f541164a;     // Catch: Throwable -> L39
        if (r102 == null) goto L7;
        ?? r103 = r102;
    L8:
        r100.element = r103;     // Catch: Throwable -> L39
        if (r103 != 0) goto L13;
        FilesKt.deleteRecursively(this.f541162a.a());     // Catch: Throwable -> L39
        monitor-exit(a.class);
        return;
    L13:
        ta4.a r104 = r103.f545170a;     // Catch: Throwable -> L39
        ArrayList r105 = null;
        if (r104 == null) goto L16;
        String r106 = r104.f545167a;     // Catch: Throwable -> L39
    L17:
        List<ta4.a> r107 = b(r103.f545171b, r106);     // Catch: Throwable -> L39
        if (r107 == null) goto L23;
        r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));     // Catch: Throwable -> L39
        Iterator r108 = ((ArrayList) r107).iterator();     // Catch: Throwable -> L39
    L21:
        if (r108.hasNext() == false) goto L23;
        r105.add(((ta4.a) r108.next()).f545167a);     // Catch: Throwable -> L39
    L23:
        File r109 = this.f541162a.a();     // Catch: Throwable -> L39
        if (r109.isDirectory() == false) goto L34;
        File[] r110 = r109.listFiles();     // Catch: Throwable -> L39
        int r111 = r110.length;     // Catch: Throwable -> L39
        int r112 = 0;
    L26:
        if (r112 >= r111) goto L34;
        File r113 = r110[r112];     // Catch: Throwable -> L39
        if (r113.isDirectory() == false) goto L33;
        if (r105 != null) goto L31;
    L32:
        FilesKt.deleteRecursively(r113);     // Catch: Throwable -> L39
        goto L33
    L31:
        if (r105.contains(r113.getName()) == false) goto L32;
    L33:
        r112 = r112 + 1;     // Catch: Throwable -> L39
    L34:
        if (r107 == null) goto L36;
        ((ta4.b) r100.element).f545171b = r107;     // Catch: Throwable -> L39
    L36:
        this.f541163b.b((ta4.b) r100.element);     // Catch: Throwable -> L39
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L39
        monitor-exit(a.class);
        return;
    L16:
        r106 = null;
        goto L17
    L7:
        ta4.b r115 = b.a(r101.f541165b);     // Catch: Throwable -> L39
        r101.f541164a = r115;     // Catch: Throwable -> L39
        r103 = r115;
    L39:
        th = move-exception;
        throw th;
    }

    public a(va4.b r100, b r101) {
        this.f541162a = r100;
        this.f541163b = r101;
    }

    public static List b(List r100, String r101) {
        Object r102 = null;
        if (r101 != null) goto L5;
        return null;
    L5:
        List r103 = CollectionsKt.sortedWith(r100, new C7591a());
        Iterator r104 = r103.iterator();
    L7:
        if (r104.hasNext() == false) goto L11;
        Object r105 = r104.next();
        if (Intrinsics.areEqual(((ta4.a) r105).f545167a, r101) == false) goto L7;
        r102 = r105;
    L11:
        ta4.a r106 = (ta4.a) r102;
        ArrayList r107 = new ArrayList();
        if (r106 == null) goto L14;
        r107.add(r106);
    L14:
        Iterator r108 = r103.iterator();
    L16:
        if (r108.hasNext() == false) goto L23;
        ta4.a r109 = (ta4.a) r108.next();
        if (r107.size() >= 4) goto L23;
        if (r107.contains(r109) == true) goto L16;
        r107.add(r109);
    L23:
        return r107;
    }
}
