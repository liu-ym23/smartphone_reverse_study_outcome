package vd8;

import com.larus.bmhome.chat.bubble.floating.ReachSpacerState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f554234a = 0;

    public static final class a implements com.larus.bmhome.chat.list.cell.spacer.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f554235a = null;

        static {
            f554235a = new a();
        }

        public a() {
        }

        @Override // com.larus.bmhome.chat.list.cell.spacer.i
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "spacerId");
            pc8.l r101 = pc8.k.f528602a;
            pc8.l r102 = pc8.k.f528602a;
            if (r102 == null) goto L6;
            r102.e(r100);
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
        public static final /* synthetic */ int[] f554236a = null;

        static {
            int[] r100 = new int[ReachSpacerState.values().length];
            r100[ReachSpacerState.WAITING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[ReachSpacerState.ENTERING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[ReachSpacerState.VISIBLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[ReachSpacerState.EXITING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f554236a = r100;
        }
    }

    static {
    }
}
