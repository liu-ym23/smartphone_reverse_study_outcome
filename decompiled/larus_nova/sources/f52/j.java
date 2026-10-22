package f52;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.ConflictStrategy;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.PSTopContainer;
import com.bytedance.android.livesdkapi.message.HighlightAreaPriorityConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class j<T> implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f475619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f475620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f475621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f475622d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f475623e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f475624f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f475625g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ConflictStrategy f475626h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ConflictStrategy f475627i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ConflictStrategy f475628j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f475629k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final HighlightAreaPriorityConfig f475630l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final T f475631m;

    @Override // f52.c
    public HighlightAreaPriorityConfig c() {
        return this.f475630l;
    }

    @Override // f52.c
    public final ConflictStrategy d() {
        return this.f475628j;
    }

    @Override // f52.c
    public final ConflictStrategy f() {
        return this.f475626h;
    }

    @Override // f52.c
    public final boolean g() {
        return this.f475629k;
    }

    @Override // f52.c
    public final int getDelayTime() {
        return this.f475623e;
    }

    @Override // f52.c
    public final int getDuration() {
        return this.f475624f;
    }

    @Override // f52.c
    public final long getEndTimestamp() {
        return this.f475625g;
    }

    @Override // f52.c
    public final String getId() {
        return this.f475619a;
    }

    @Override // f52.c
    public final long getStartTimestamp() {
        return this.f475621c;
    }

    @Override // f52.c
    public f getType() {
        return this.f475620b;
    }

    @Override // f52.c
    public final ConflictStrategy k() {
        return this.f475627i;
    }

    @Override // f52.c
    public final int l() {
        return this.f475622d;
    }

    @Override // f52.c
    public boolean j(c r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r100, "view");
        return true;
    }

    public final void m(b r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        if (this.f475625g <= 0) goto L5;
        return;
    L5:
        if (this.f475624f > 0) goto L10;
        r100.d(this);
        return;
    }

    @Override // f52.c
    public void e(c r100, PSTopContainer r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
    }

    public j(String r100, f r110, long r111, int r112, int r113, int r114, long r115, ConflictStrategy r116, ConflictStrategy r117, ConflictStrategy r210, boolean r211, HighlightAreaPriorityConfig r212, T r213) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r110, "type");
        Intrinsics.checkNotNullParameter(r116, "priorityLowerStrategy");
        Intrinsics.checkNotNullParameter(r117, "priorityEqualStrategy");
        Intrinsics.checkNotNullParameter(r210, "priorityHigherStrategy");
        Intrinsics.checkNotNullParameter(r213, "data");
        this.f475619a = r100;
        this.f475620b = r110;
        this.f475621c = r111;
        this.f475622d = r112;
        this.f475623e = r113;
        this.f475624f = r114;
        this.f475625g = r115;
        this.f475626h = r116;
        this.f475627i = r117;
        this.f475628j = r210;
        this.f475629k = r211;
        this.f475630l = r212;
        this.f475631m = r213;
    }

    public /* synthetic */ j(String r110, f r210, long r211, int r212, int r213, int r214, long r215, ConflictStrategy r216, ConflictStrategy r217, ConflictStrategy r310, boolean r311, HighlightAreaPriorityConfig r312, Object r313, int r314) {
        if ((r314 & 128) == 0) goto L5;
        ConflictStrategy r111 = ConflictStrategy.DISCARD;
    L7:
        if ((r314 & 256) == 0) goto L9;
        ConflictStrategy r112 = ConflictStrategy.QUEUE;
    L11:
        if ((r314 & 512) == 0) goto L13;
        ConflictStrategy r113 = ConflictStrategy.INTERRUPT;
    L15:
        if ((r314 & 1024) == 0) goto L17;
        boolean r114 = false;
    L19:
        if ((r314 & 2048) == 0) goto L21;
        HighlightAreaPriorityConfig r115 = null;
    L22:
        this(r110, r210, r211, r212, r213, r214, r215, r111, r112, r113, r114, r115, r313);
        return;
    L21:
        r115 = r312;
        goto L22
    L17:
        r114 = r311;
        goto L19
    L13:
        r113 = r310;
        goto L15
    L9:
        r112 = r217;
        goto L11
    L5:
        r111 = r216;
        goto L7
    }
}
