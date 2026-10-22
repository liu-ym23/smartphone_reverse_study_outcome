package io.noties.markwon.ext.onetex;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import com.edu.onetex.latex.LaTeXParam;
import com.edu.onetex.latex.icon.LaTeXIcon;
import com.edu.onetex.latex.icon.LaTeXIconBuilder;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.capabilitykit.common.ErrorCode;
import io.noties.markwon.onetex.LatexMathBlock;
import io.noties.markwon.onetex.LatexMathNode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public class o extends lsc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f492451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f492452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f492453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f492454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f492455e;

    public static final class a {
    }

    public static class b extends wsc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f492456a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<wsc.a, Future<?>> f492457b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final f f492458c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Context f492459d;

        /* JADX INFO: loaded from: classes41.dex */
        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f492460a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ boolean f492461b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ wsc.a f492462c;

            /* JADX INFO: renamed from: io.noties.markwon.ext.onetex.o$b$a$a, reason: collision with other inner class name */
            public static final class RunnableC6317a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ a f492463a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ LaTeXIcon f492464b;

                public RunnableC6317a(a r100, LaTeXIcon r101) {
                    this.f492463a = r100;
                    this.f492464b = r101;
                }

                public final void a() {
                    a r100 = this.f492463a;
                    Context r101 = r100.f492460a.f492459d;
                    wsc.a r102 = r100.f492462c;
                    if ((r102 instanceof io.noties.markwon.ext.onetex.b) == true) goto L5;
                    r102 = null;
                L5:
                    io.noties.markwon.ext.onetex.b r103 = (io.noties.markwon.ext.onetex.b) r102;
                    if (r103 == null) goto L10;
                    Integer r104 = r103.f492395o;
                    if (r104 == null) goto L10;
                    int r105 = r104.intValue();
                L11:
                    f r106 = this.f492463a.f492460a.f492458c;
                    g r107 = new g(r101, r105, r106.f492402a.f492473d, this.f492464b, r106.f492411j, r106.f492414m, r106.f492415n);
                    if (r107.getBounds().isEmpty() == false) goto L14;
                    r107.setBounds(wsc.m.a(r107));
                L14:
                    this.f492463a.f492462c.setResult(r107);
                    a r108 = this.f492463a;
                    r108.f492460a.f492457b.remove(r108.f492462c);
                    return;
                L10:
                    r105 = 0;
                    goto L11
                }

                @Override // java.lang.Runnable
                public final void run() {
                    a();     // Catch: Throwable -> L4
                    return;
                L4:
                    th = move-exception;
                    if (RunnableProtector.intercept(th) == false) goto L8;
                    return;
                L8:
                    throw th;
                }
            }

            public a(b r100, boolean r101, wsc.a r102) {
                this.f492460a = r100;
                this.f492461b = r101;
                this.f492462c = r102;
            }

            public final void a() {
                boolean r100 = this.f492461b;     // Catch: Throwable -> L35
                if (r100 == false) goto L6;
                int r101 = this.f492460a.f492458c.f492402a.f492474e;     // Catch: Throwable -> L35
            L7:
                if (r100 == false) goto L9;
                this.f492460a.f492458c.f492402a.getClass();     // Catch: Throwable -> L35
            L11:
                if (this.f492461b == false) goto L13;
                this.f492460a.f492458c.f492402a.getClass();     // Catch: Throwable -> L35
            L15:
                if (this.f492461b == false) goto L17;
                float r102 = this.f492460a.f492458c.f492402a.f492470a;     // Catch: Throwable -> L35
            L18:
                Resources r103 = this.f492460a.f492459d.getResources();     // Catch: Throwable -> L35
                DisplayMetrics r104 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics());     // Catch: Throwable -> L35
                String r105 = this.f492462c.f561116a;     // Catch: Throwable -> L35
                zs7.a r106 = new zs7.a(Float.MAX_VALUE, 0);     // Catch: Throwable -> L35
                zs7.a r107 = new zs7.a(r102, 0);     // Catch: Throwable -> L35
                if (r101 != 0) goto L22;
                r101 = -16777216;
            L22:
                LaTeXParam r110 = new LaTeXParam(r105, r106, r107, r104.density, 0, AudioStats.AUDIO_AMPLITUDE_NONE, null, r101, 0, false, false, null, false, ErrorCode.EventTask.LOCATION_DATA_EMPTY, null);     // Catch: Throwable -> L35
                long r108 = System.currentTimeMillis();     // Catch: Throwable -> L35
                wsc.a r109 = this.f492462c;     // Catch: Throwable -> L35
                if ((r109 instanceof io.noties.markwon.ext.onetex.b) == true) goto L25;
                r109 = null;
            L25:
                io.noties.markwon.ext.onetex.b r111 = (io.noties.markwon.ext.onetex.b) r109;     // Catch: Throwable -> L35
                if (r111 == null) goto L30;
                LaTeXIcon r112 = r111.f492394n;     // Catch: Throwable -> L35
                if (r112 == null) goto L30;
            L31:
                if (r112 == null) goto L34;
                this.f492460a.f492456a.post(new RunnableC6317a(this, r112));     // Catch: Throwable -> L35
                return;
            L34:
                return;
            L30:
                r112 = new LaTeXIconBuilder(r110).build();     // Catch: Throwable -> L35
                LaTexHelper r113 = LaTexHelper.f492379d;     // Catch: Throwable -> L35
                r113.a(r110.getContent());     // Catch: Throwable -> L35
                r113.b(System.currentTimeMillis() - r108);     // Catch: Throwable -> L35
                goto L31
            L17:
                r102 = this.f492460a.f492458c.f492402a.f492471b;     // Catch: Throwable -> L35
                goto L18
            L13:
                this.f492460a.f492458c.f492402a.getClass();     // Catch: Throwable -> L35
                goto L15
            L9:
                this.f492460a.f492458c.f492402a.getClass();     // Catch: Throwable -> L35
                goto L11
            L6:
                r101 = this.f492460a.f492458c.f492402a.f492475f;     // Catch: Throwable -> L35
            L35:
                this.f492460a.f492458c.getClass();
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // wsc.b
        public final void c(wsc.a r100) {
        }

        @Override // wsc.b
        public final void a(wsc.a r100) {
            Future<?> r101 = this.f492457b.remove(r100);
            if (r101 == null) goto L6;
            r101.cancel(true);
            return;
        }

        @Override // wsc.b
        public final void b(wsc.a r100) {
            if ((r100 instanceof io.noties.markwon.ext.onetex.b) == true) goto L5;
            wsc.a r101 = null;
        L6:
            io.noties.markwon.ext.onetex.b r102 = (io.noties.markwon.ext.onetex.b) r101;
            boolean r103 = true;
            if (r102 != null) goto L9;
        L12:
            Future<?> r104 = this.f492458c.f492406e.submit(new a(this, r103, r100));
            this.f492457b.put(r100, r104);
            return;
        L9:
            if (r102.f492393m != true) goto L12;
            r103 = false;
            goto L12
        L5:
            r101 = r100;
            goto L6
        }

        public b(f r100, Context r101) {
            this.f492458c = r100;
            this.f492459d = r101;
            this.f492456a = new Handler(Looper.getMainLooper());
            this.f492457b = new LinkedHashMap();
        }
    }

    static {
    }

    public wsc.f o(msc.s r100, String r101) {
        throw null;
    }

    public wsc.f p(msc.s r100, String r101, boolean r102, LaTeXIcon r103, Integer r104, Integer r105, Float r106) {
        throw null;
    }

    public List<LaTeXIcon> q(LaTeXParam r100) {
        throw null;
    }

    public static String r(String r100) {
        String r101 = StringsKt.replace$default(r100, '\n', ' ', false, 4, null);
        int r102 = r101.length() - 1;
        int r103 = 0;
        boolean r104 = false;
    L3:
        if (r103 > r102) goto L19;
        if (r104 == true) goto L6;
        int r105 = r103;
    L8:
        if (r101.charAt(r105) > ' ') goto L10;
        boolean r106 = true;
    L11:
        if (r104 == false) goto L12;
        if (r106 == false) goto L19;
        r102 = r102 - 1;
        goto L3
    L12:
        if (r106 == false) goto L13;
        r103 = r103 + 1;
        goto L3
    L13:
        r104 = true;
        goto L3
    L10:
        r106 = false;
        goto L11
    L6:
        r105 = r102;
    L19:
        return r101.subSequence(r103, r102 + 1).toString();
    }

    @Override // lsc.a, lsc.j
    public void G4(TextView r100) {
        Integer r101 = (Integer) r100.getTag(R.id.markwon_drawables_scheduler_last_text_hashcode);
        int r102 = r100.getText().hashCode();
        if (r101 != null) goto L5;
    L7:
        r100.setTag(R.id.markwon_drawables_scheduler_last_text_hashcode, Integer.valueOf(r102));
        wsc.f[] r103 = wsc.e.a(r100);
        if (r103 != null) goto L10;
        return;
    L10:
        if (r103.length > 0) goto L12;
        return;
    L12:
        if (r100.getTag(R.id.markwon_drawables_scheduler) != null) goto L14;
        wsc.d r104 = new wsc.d(r100);
        r100.addOnAttachStateChangeListener(r104);
        r100.setTag(R.id.markwon_drawables_scheduler, r104);
    L14:
        wsc.e.b r105 = new wsc.e.b(r100);
        int r106 = r103.length;
        int r107 = 0;
    L15:
        if (r107 >= r106) goto L21;
        wsc.a r108 = r103[r107].f561138b;
        r108.c(new wsc.e.a(r100, r105, r108.getBounds()));
        r107 = r107 + 1;
        goto L15
    L21:
        return;
    L5:
        if (r101.intValue() != r102) goto L7;
    }

    @Override // lsc.a, lsc.j
    public final void c(lsc.p.a r100) {
        f r101 = this.f492455e;
        if (r101.f492407f == false) goto L11;
        if (r101.f492403b == false) goto L8;
        r100.a(LatexMathBlock.class, new r(this));
    L8:
        if (this.f492455e.f492404c == false) goto L17;
        r100.a(LatexMathNode.class, new s(this));
        return;
    L17:
        return;
    L11:
        if (r101.f492403b == false) goto L14;
        r100.a(LatexMathBlock.class, new p(this));
    L14:
        if (this.f492455e.f492404c == false) goto L19;
        r100.a(LatexMathNode.class, new q(this));
        return;
    }

    public o(Context r100, f r101) {
        this.f492454d = r100;
        this.f492455e = r101;
        this.f492451a = new b(r101, r100);
        this.f492452b = new d(r101.f492402a.f492472c);
        this.f492453c = new k(r101.f492402a.f492472c);
    }

    public static final boolean n(o r100, String r101) {
        List<String> r102 = r100.f492455e.f492409h;
        if (r102.isEmpty() == true) goto L15;
        Iterator<T> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L16;
        if (StringsKt.contains$default(r101, (String) r103.next(), false, 2, null) == false) goto L7;
        return false;
    L16:
        return true;
    L15:
        return true;
    }
}
