package com.bytedance.live.artist.render;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public final class RenderRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TreeSet<RenderEntity> f254842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient float f254843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<RenderEntity, Unit> f254844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<RenderEntity, Unit> f254845d;

    public static final class a implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f254846a = null;

        static {
            f254846a = new a();
        }

        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            RenderEntity r102 = (RenderEntity) r100;
            RenderEntity r103 = (RenderEntity) r101;
            int r104 = r102.f254831f;
            int r105 = r103.f254831f;
            if (r104 != r105) goto L9;
            if ((r102.f254832g - r103.f254832g) <= 0) goto L7;
            return 1;
        L7:
            return -1;
        L9:
            return r104 - r105;
        }
    }

    public RenderRequest() {
        this.f254842a = new TreeSet(a.f254846a);
        this.f254844c = RenderRequest$renderStartAction$1.INSTANCE;
        this.f254845d = RenderRequest$renderEndAction$1.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(Function1<? super RenderEntity, Unit> r100) {
        Iterator<T> r101 = this.f254842a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.invoke(r101.next());
        goto L4
    }
}
