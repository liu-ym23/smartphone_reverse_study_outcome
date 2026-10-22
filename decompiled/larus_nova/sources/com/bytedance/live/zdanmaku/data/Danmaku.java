package com.bytedance.live.zdanmaku.data;

import com.bytedance.live.artist.render.RenderEntity;
import com.bytedance.live.artist.render.RenderEntity$prepareAsync$1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public class Danmaku {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile State f255833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f255834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RenderEntity f255835c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/live/zdanmaku/data/Danmaku$State;", "", "CREATED", "PREPARE", "VISIBLE", "HIDDEN", "zdanmaku_release"}, k = 1, mv = {1, 4, 0})
    public static final enum State extends Enum<State> {
        public static final State CREATED = null;
        public static final State HIDDEN = null;
        public static final State PREPARE = null;
        public static final State VISIBLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f255836a = null;

        static {
            State r100 = new State("CREATED", 0);
            CREATED = r100;
            State r101 = new State("PREPARE", 1);
            PREPARE = r101;
            State r102 = new State("VISIBLE", 2);
            VISIBLE = r102;
            State r103 = new State("HIDDEN", 3);
            HIDDEN = r103;
            f255836a = new State[]{r100, r101, r102, r103};
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public static State[] values() {
            return (State[]) f255836a.clone();
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final float a() {
        RenderEntity r100 = this.f255835c;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("renderEntity");
    L6:
        return r100.f254829d.f254847a;
    }

    public final RenderEntity b() {
        RenderEntity r100 = this.f255835c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("renderEntity");
    L5:
        return r100;
    }

    public final void update() {
        RenderEntity r100 = this.f255835c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("renderEntity");
    L5:
        com.bytedance.live.artist.core.b r101 = r100.f254835j;
        RenderEntity$prepareAsync$1 r102 = new RenderEntity$prepareAsync$1(r100, false, null);
        r101.f254824b.d(r102);
    }

    public Danmaku() {
        this.f255833a = State.CREATED;
    }

    public final float c() {
        float r100 = a();
        RenderEntity r101 = this.f255835c;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("renderEntity");
    L6:
        return r100 + r101.f254828c.f254852a;
    }

    public final void f(State r100) {
        State r101 = this.f255833a;
        this.f255833a = r100;
        if (r101 != r100) goto L6;
        return;
    L6:
        if (r101.compareTo(r100) >= 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L23;
        int r103 = a.f255837a[r100.ordinal()];
        if (r103 == 1) goto L21;
        if (r103 != 2) goto L25;
        RenderEntity r104 = this.f255835c;
        if (r104 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("renderEntity");
    L18:
        Function0<Unit> r105 = new Danmaku$onPrepare$1(this);
        com.bytedance.live.artist.core.b r106 = r104.f254835j;
        r106.f254824b.d(new RenderEntity$prepareAsync$1(r104, false, r105));
        return;
    L25:
        return;
    L21:
        throw new IllegalStateException("Shouldn't set state to CREATED.");
    L23:
        throw new IllegalStateException(("Wrong state! Prev: " + r101 + ", Target: " + r100).toString());
    L8:
        r102 = false;
        goto L9
    }

    public final void d(float r100, float r101) {
        RenderEntity r102 = this.f255835c;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("renderEntity");
    L5:
        RenderEntity r103 = this.f255835c;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("renderEntity");
    L8:
        float r104 = r103.f254829d.f254847a + r100;
        RenderEntity r105 = this.f255835c;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("renderEntity");
    L11:
        float r106 = r105.f254829d.f254848b + r101;
        com.bytedance.live.artist.render.b r107 = r102.f254829d;
        r107.f254847a = r104;
        r107.f254848b = r106;
    }

    public final void e(float r100, float r101) {
        RenderEntity r102 = this.f255835c;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("renderEntity");
    L5:
        com.bytedance.live.artist.render.b r103 = r102.f254829d;
        r103.f254847a = r100;
        r103.f254848b = r101;
    }
}
