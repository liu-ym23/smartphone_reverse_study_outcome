package odc;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.widget.photopickerimpl.bean.Photo;
import com.ss.android.lark.widget.photopickerimpl.bean.c;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes38.dex */
public abstract class a<DATA extends Photo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f522913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InterfaceC7038a f522914b;

    /* JADX INFO: renamed from: odc.a$a, reason: collision with other inner class name */
    public interface InterfaceC7038a {
        float[] a(View r100);

        void b(a<?> r100, c r101);

        void c(KClass<? extends a<?>> r100, c r101);

        void d(a<?> r100);
    }

    public interface b {
        void a();

        void b();
    }

    public a() {
    }

    public void a(int r100, int r101, Intent r102) {
        Intrinsics.checkNotNullParameter(r102, "data");
    }

    public abstract void b();

    public abstract View c(ViewGroup r100);

    public abstract void d();

    public abstract void e(c r100);

    public abstract void f();

    public abstract void g(List<DATA> r100, int r101, boolean r102);

    public void h(Map<Integer, com.ss.android.lark.widget.photopickerimpl.bean.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "dirInfos");
    }
}
