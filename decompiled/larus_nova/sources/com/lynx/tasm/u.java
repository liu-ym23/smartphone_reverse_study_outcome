package com.lynx.tasm;

import com.lynx.tasm.base.LLog;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<TemplateBundle, LinkedList<LynxEngine>> f383802a;

    public class a implements TemplateBundle.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkedList f383803a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TemplateBundle f383804b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ u f383805c;

        public a(u r100, LinkedList r101, TemplateBundle r102) {
            this.f383805c = r100;
            this.f383803a = r101;
            this.f383804b = r102;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final u f383806a = null;

        static {
            f383806a = new u();
        }
    }

    public u() {
        this.f383802a = new HashMap();
    }

    public final synchronized LinkedList<LynxEngine> a(TemplateBundle r100) {
        monitor-enter(this);
        if (r100 != null) goto L7;
        LinkedList<LynxEngine> r101 = new LinkedList();     // Catch: Throwable -> L12
        monitor-exit(this);
        return r101;
    L7:
        LinkedList<LynxEngine> r102 = (LinkedList) ((HashMap) this.f383802a).get(r100);     // Catch: Throwable -> L12
        if (r102 != null) goto L10;
        r102 = new LinkedList();     // Catch: Throwable -> L12
        ((HashMap) this.f383802a).put(r100, r102);     // Catch: Throwable -> L12
        r100.f381773f = new a(this, r102, r100);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return r102;
    L12:
        th = move-exception;
        throw th;
    }

    public void delete(LynxEngine r100) {
        TemplateBundle r101 = r100.f381650c;
        if (r101 != null) goto L5;
        return;
    L5:
        LinkedList<LynxEngine> r102 = a(r101);
        LLog.i("LynxEnginePool", "deleteEngine EngineQueue Cache: " + r102 + ", bundle:" + r101);
        monitor-enter(this);
        r102.remove(r100);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
