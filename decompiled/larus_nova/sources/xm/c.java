package xm;

import android.view.View;
import android.widget.TextView;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, qn.a<? extends Object>> f564527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, LinkedList<TextView>> f564528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f564529c;

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> extends qn.a<T> {
        @Override // qn.a
        public final void c() {
            this.f533978a.clear();
            this.f533979b.clear();
        }

        public a(int r100) {
            super(r100);
        }
    }

    public c() {
        this.f564529c = 1;
        this.f564527a = new LinkedHashMap();
        this.f564528b = new HashMap();
    }

    public final void c(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        String r101 = r100.getText().toString();
        LinkedList<TextView> r102 = this.f564528b.get(r101);
        if (r102 != null) goto L5;
        r102 = new LinkedList();
        this.f564528b.put(r101, r102);
    L5:
        r102.push(r100);
    }

    public final synchronized <T extends View> T a(Class<T> r100, Function0<? extends T> r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "clazz");     // Catch: Throwable -> L15
        Intrinsics.checkNotNullParameter(r101, "resourceGenerator");     // Catch: Throwable -> L15
        if (this.f564527a.containsKey(r100) == true) goto L6;
    L12:
        a r102 = new a(this.f564529c);     // Catch: Throwable -> L15
        this.f564527a.put(r100, r102);     // Catch: Throwable -> L15
        T r103 = (T) r102.a(r101);     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
        return r103;
    L6:
        if (((LinkedHashMap) this.f564527a).get(r100) == null) goto L12;
        Object r104 = ((LinkedHashMap) this.f564527a).get(r100);     // Catch: Throwable -> L15
        if (r104 == null) goto L11;
        r103 = (T) ((qn.a) r104).a(r101);     // Catch: Throwable -> L15
        goto L13
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.store.utils.window.SimplePool<T>");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public final synchronized <T extends View> void b(Class<T> r100, T r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "clazz");     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r101, "resource");     // Catch: Throwable -> L11
        Object r102 = ((LinkedHashMap) this.f564527a).get(r100);     // Catch: Throwable -> L11
        if ((r102 instanceof qn.a) == true) goto L6;
        r102 = null;
    L6:
        qn.a r103 = (qn.a) r102;     // Catch: Throwable -> L11
        if (r103 == null) goto L9;
        r103.b(r101);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
