package x98;

import com.larus.avlink.liveai.model.LiveAiEventScene;
import com.larus.avlink.n1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f562986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f562987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableSharedFlow<Integer> f562988c;

    /* JADX INFO: renamed from: x98.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C8207a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f562989a = null;

        static {
            int[] r100 = new int[LiveAiEventScene.values().length];
            r100[LiveAiEventScene.MANUAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[LiveAiEventScene.AUTO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f562989a = r100;
        }
    }

    public a() {
        MutableSharedFlow<Integer> r100 = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
        r100.tryEmit(Integer.valueOf(this.f562986a));
        this.f562988c = r100;
    }

    public final void a(b r100) {
        n1.d("DoraLiveAiMachine", "start process event " + r100);
        int r101 = r100.getType();
        boolean r102 = false;
        if (r101 == 0) goto L35;
        Boolean r103 = null;
        if (r101 != 2) goto L7;
        LiveAiEventScene r104 = r100.f562991b;
        if (r104 != null) goto L18;
        int r105 = -1;
    L20:
        if (r105 == 1) goto L24;
        if (r105 != 2) goto L43;
        this.f562986a = 1;
        this.f562988c.tryEmit(1);
        return;
    L43:
        return;
    L24:
        c r106 = this.f562987b;
        if (r106 == null) goto L27;
        r102 = r106.a(r100);
    L27:
        if (r102 == true) goto L29;
        return;
    L29:
        c r107 = this.f562987b;
        if (r107 == null) goto L33;
        r107.c(r100);
        r103 = Boolean.TRUE;
    L33:
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == false) goto L40;
        this.f562986a = 1;
        this.f562988c.tryEmit(1);
        return;
    L40:
        return;
    L18:
        r105 = C8207a.f562989a[r104.ordinal()];
        goto L20
    L7:
        if (r101 != 5) goto L42;
        c r108 = this.f562987b;
        if (r108 == null) goto L13;
        r108.b(r100);
        r103 = Boolean.FALSE;
    L13:
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == false) goto L37;
        this.f562986a = 2;
        this.f562988c.tryEmit(2);
        return;
    L37:
        return;
    L42:
        return;
    L35:
        this.f562986a = 0;
        this.f562988c.tryEmit(0);
    }

    public final void b(b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        n1.e("DoraLiveAiMachine", "receive event: " + r100);
        a(r100);
    }
}
