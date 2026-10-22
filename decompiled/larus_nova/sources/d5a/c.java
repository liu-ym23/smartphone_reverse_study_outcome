package d5a;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.lynx.base.memory.MemoryPressureCallback;
import com.lynx.clay.embedding.engine.memory.MemoryPressureListener;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes32.dex */
public final class c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f467088h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f467089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f467090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f467091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f467092d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f467093e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f467094f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f467095g;

    public class a implements ComponentCallbacks2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f467096a;

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration r100) {
        }

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
            c r100 = this.f467096a;
            r100.getClass();
            Object r101 = com.lynx.clay.util.a.f380953a;
            if (r100.f467092d == false) goto L5;
            r100.f467091c = 2;
            return;
        L5:
            r100.a(2);
        }

        public a(c r100) {
            this.f467096a = r100;
        }

        @Override // android.content.ComponentCallbacks2
        public final void onTrimMemory(int r100) {
            if (r100 < 80) goto L5;
        L11:
            Integer r101 = 2;
        L12:
            if (r101 == null) goto L18;
            c r102 = this.f467096a;
            int r103 = r101.intValue();
            r102.getClass();
            Object r104 = com.lynx.clay.util.a.f380953a;
            if (r102.f467092d == false) goto L16;
            r102.f467091c = Integer.valueOf(r103);
            return;
        L16:
            r102.a(r103);
            return;
        L18:
            return;
        L5:
            if (r100 == 15) goto L11;
            if (r100 < 40) goto L10;
            r101 = 1;
            goto L12
        L10:
            r101 = null;
            goto L12
        }
    }

    static {
        f467088h = new c();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [d5a.b] */
    public c() {
        this.f467090b = 0;
        this.f467094f = new b(this);
        this.f467095g = new a(this);
        this.f467089a = 60000;
        this.f467092d = false;
    }

    public final void a(int r100) {
        com.lynx.clay.util.a.a().postDelayed(this.f467094f, this.f467089a);
        this.f467092d = true;
        this.f467090b = r100;
        ArrayList<MemoryPressureCallback> r101 = MemoryPressureListener.f380749a;
        if (r101 == null) goto L9;
        Iterator<MemoryPressureCallback> r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        r102.next().onPressure(r100);
        goto L7
    L11:
        return;
    }
}
