package ub0;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f549304a;

    /* JADX INFO: renamed from: ub0.a$a, reason: collision with other inner class name */
    public static final class C7854a extends a {
        public C7854a(long r100) {
            super(r100);
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<com.bytedance.component.lyric.model.b> f549305b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f549306c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f549307d;

        public /* synthetic */ b(long r100, List r110, int r111) {
            this(r100, r110, r111, 0);
        }

        public b(long r100, List<com.bytedance.component.lyric.model.b> r101, int r102, long r103) {
            Intrinsics.checkNotNullParameter(r101, "lineInfoList");
            super(r100);
            this.f549305b = r101;
            this.f549306c = r102;
            this.f549307d = r103;
        }
    }

    public final List<com.bytedance.component.lyric.model.b> a() {
        if ((this instanceof b) == true) goto L7;
        return null;
    L7:
        return ((b) this).f549305b;
    }

    public final String toString() {
        return "LyricsChangeEvent(mId=" + this.f549304a + ')';
    }

    public a(long r100) {
        this.f549304a = r100;
    }

    public final boolean b(a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof b) == true) goto L5;
    L17:
        return false;
    L5:
        if ((this instanceof b) == false) goto L17;
        if (r100.f549304a != this.f549304a) goto L17;
        b r101 = (b) r100;
        b r102 = (b) this;
        if (r101.f549306c != r102.f549306c) goto L17;
        if ((!r101.f549305b.isEmpty()) == false) goto L17;
        if ((!r102.f549305b.isEmpty()) == false) goto L17;
        if (r101.f549305b.size() != r102.f549305b.size()) goto L17;
        return true;
    }
}
