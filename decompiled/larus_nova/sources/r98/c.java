package r98;

import com.larus.avlink.gallery.model.MediaLifecycleState;
import com.larus.avlink.gallery.model.MediaMetadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f536739a = null;

        static {
            int[] r100 = new int[MediaLifecycleState.values().length];
            r100[MediaLifecycleState.DOWNLOADED_TEMP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[MediaLifecycleState.PROCESSING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[MediaLifecycleState.PROCESSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[MediaLifecycleState.SYNCING_TO_SYSTEM_ALBUM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[MediaLifecycleState.DOWNLOAD.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[MediaLifecycleState.COMPLETED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[MediaLifecycleState.FAILED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f536739a = r100;
        }
    }

    public static final boolean a(MediaMetadata r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        MediaLifecycleState r101 = r100.getLifecycleState();
        switch(a.f536739a[r101.ordinal()]) {
            case 1: goto L7;
            case 2: goto L7;
            case 3: goto L7;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L6;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        return false;
    L7:
        return true;
    L5:
        throw new NoWhenBranchMatchedException();
    }
}
