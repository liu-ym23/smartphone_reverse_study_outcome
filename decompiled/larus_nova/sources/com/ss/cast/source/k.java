package com.ss.cast.source;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.Dispatcher;
import com.byted.cast.common.api.ICastSource;
import com.byted.cast.common.bean.MediaInfo;
import com.byted.cast.common.config.IMediaInfoListener;
import com.byted.cast.common.source.IPlayerListener;
import com.ss.cast.sourcecommon.monitor.SourceMonitor;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes40.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ICastSource f456578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ICastSource f456579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ICastSource f456580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ICastSource f456581d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ICastSource f456582e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ICastSource f456583f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ICastSource f456584g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, ICastSource> f456585h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<String> f456586i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public IMediaInfoListener f456587j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CastLogger f456588k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final SourceMonitor f456589l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Set<IPlayerListener> f456590m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Object f456591n;

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f456592a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            if (r100.what != 1) goto L12;
            Object r101 = this.f456592a.f456591n;
            monitor-enter(r101);
            this.f456592a.getClass();     // Catch: Throwable -> L9
            monitor-exit(r101);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        L12:
            super.handleMessage(r100);
        }

        public a(k r100, Looper r101) {
            this.f456592a = r100;
            super(r101);
        }
    }

    public class b implements com.byted.cast.common.api.IPlayerListener {
    }

    public class c implements IPlayerListener {
    }

    public class d implements IMediaInfoListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f456593a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k f456594b;

        @Override // com.byted.cast.common.config.IMediaInfoListener
        public final void onSuccess(MediaInfo r100) {
            k r101 = this.f456594b;
            if (r101.f456587j == null) goto L6;
            r101.f456589l.g(this.f456593a, true);
            this.f456594b.f456587j.onSuccess(r100);
            return;
        }

        public d(k r100, String r101) {
            this.f456594b = r100;
            this.f456593a = r101;
        }

        @Override // com.byted.cast.common.config.IMediaInfoListener
        public final void onFail(int r100, String r101) {
            k r102 = this.f456594b;
            if (r102.f456587j == null) goto L6;
            r102.f456589l.g(this.f456593a, false);
            this.f456594b.f456587j.onFail(r100, r101);
            return;
        }
    }

    public final void a() {
        this.f456588k.w("PlayerController", "isAllowDramaCmd, currentServiceInfoWrapper or serviceInfo is null.");
        Iterator r100 = ((CopyOnWriteArraySet) this.f456590m).iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        IPlayerListener r101 = (IPlayerListener) r100.next();
        if (r101 == null) goto L4;
        r101.onError(com.byted.cast.common.api.IPlayerListener.PUSH_ERROR_LIST, 210129);
        goto L4
    }

    public k(ContextManager.CastContext r100, Map<String, ICastSource> r101, List<String> r102) {
        this.f456590m = new CopyOnWriteArraySet();
        this.f456591n = new Object();
        this.f456585h = r101;
        ContextManager.getTeaEventTrack(r100);
        this.f456589l = SourceMonitor.b(r100);
        this.f456586i = r102;
        new a(this, Dispatcher.getInstance().getByteCastThreadLooper());
    }
}
