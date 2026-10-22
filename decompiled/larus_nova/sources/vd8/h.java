package vd8;

import com.larus.bmhome.chat.bubble.floating.BubbleBannerRenderPart;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerState;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerTransitionType;
import com.larus.bmhome.chat.bubble.floating.runtime.IBubbleBannerRuntimeService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f554220a = null;

    public static final class a implements com.larus.bmhome.chat.list.cell.spacer.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f554221a = null;

        static {
            f554221a = new a();
        }

        public a() {
        }

        @Override // com.larus.bmhome.chat.list.cell.spacer.i
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "spacerId");
            pc8.e r101 = com.larus.bmhome.chat.bubble.floating.runtime.k.b(r100);
            if (r101 == null) goto L6;
            h.f554220a.getClass();
            h.a(r101);
            return;
        }

        @Override // com.larus.bmhome.chat.list.cell.spacer.i
        public final void b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "spacerId");
        }

        @Override // com.larus.bmhome.chat.list.cell.spacer.i
        public final void c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "spacerId");
        }

        @Override // com.larus.bmhome.chat.list.cell.spacer.i
        public final void d(String r100) {
            Intrinsics.checkNotNullParameter(r100, "spacerId");
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f554222a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f554223b = null;

        static {
            int[] r100 = new int[BubbleBannerState.values().length];
            r100[BubbleBannerState.RESOLVED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[BubbleBannerState.ENTERING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L29:
            r100[BubbleBannerState.VISIBLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L23:
            r100[BubbleBannerState.EXITING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L8:
            f554222a = r100;
            int[] r101 = new int[BubbleBannerTransitionType.values().length];
            r101[BubbleBannerTransitionType.ENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L25:
            r101[BubbleBannerTransitionType.EXIT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L11:
            f554223b = r101;
        }
    }

    static {
        f554220a = new h();
    }

    public h() {
    }

    public static void a(pc8.e r100) {
        pc8.i r101 = r100.f528585j;
        if (r101 != null) goto L5;
    L10:
        r101 = null;
    L12:
        if (r101 != null) goto L17;
        int r102 = com.larus.bmhome.chat.bubble.floating.runtime.k.f297555a;
        String r103 = r100.f528576a;
        Intrinsics.checkNotNullParameter(r103, "promptId");
        IBubbleBannerRuntimeService r104 = com.larus.bmhome.chat.bubble.floating.runtime.k.c();
        if (r104 == null) goto L21;
        r104.b(r103);
        return;
    L21:
        return;
    L17:
        int r105 = com.larus.bmhome.chat.bubble.floating.runtime.k.f297555a;
        String r106 = r100.f528576a;
        String r107 = r101.f528598a;
        BubbleBannerRenderPart r108 = BubbleBannerRenderPart.SPACER;
        Intrinsics.checkNotNullParameter(r106, "promptId");
        Intrinsics.checkNotNullParameter(r107, "transitionId");
        Intrinsics.checkNotNullParameter(r108, "part");
        IBubbleBannerRuntimeService r109 = com.larus.bmhome.chat.bubble.floating.runtime.k.c();
        if (r109 == null) goto L22;
        r109.k(r106, r107, r108);
        return;
    L22:
        return;
    L5:
        if (r101.getType() != BubbleBannerTransitionType.EXIT) goto L7;
        boolean r110 = true;
    L8:
        if (r110 == false) goto L10;
    L7:
        r110 = false;
        goto L8
    }
}
