package com.larus.avlink.gallery.business;

import androidx.camera.video.AudioStats;
import com.larus.avlink.gallery.database.AlbumDataBaseHelper;
import com.larus.avlink.gallery.model.MediaLifecycleState;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes25.dex */
public final class MediaLifecycleStateManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f292361b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile MediaLifecycleStateManager f292362c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<r98.b> f292363a;

    public static final class a {
        public final MediaLifecycleStateManager a() {
            MediaLifecycleStateManager r100 = MediaLifecycleStateManager.f292362c;
            if (r100 != null) goto L13;
            monitor-enter(this);
            r100 = MediaLifecycleStateManager.f292362c;     // Catch: Throwable -> L10
            if (r100 != null) goto L8;
            r100 = new MediaLifecycleStateManager();     // Catch: Throwable -> L10
            MediaLifecycleStateManager.f292362c = r100;     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r100;
        }

        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f292364a = null;

        static {
            int[] r100 = new int[MediaLifecycleState.values().length];
            r100[MediaLifecycleState.DOWNLOAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[MediaLifecycleState.DOWNLOADED_TEMP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[MediaLifecycleState.PROCESSING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[MediaLifecycleState.PROCESSED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[MediaLifecycleState.SYNCING_TO_SYSTEM_ALBUM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[MediaLifecycleState.COMPLETED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[MediaLifecycleState.FAILED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f292364a = r100;
        }
    }

    static {
        f292361b = new a();
    }

    public MediaLifecycleStateManager() {
        this.f292363a = new ArrayList();
    }

    public final void e(r98.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        List<r98.b> r101 = this.f292363a;
        monitor-enter(r101);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (((ArrayList) this.f292363a).contains(r100) == true) goto L7;
        ((ArrayList) this.f292363a).add(r100);     // Catch: Throwable -> L10
        FLogger.f375446a.d("MediaLifecycleStateManager", "Registered listener: ".concat(r100.getClass().getSimpleName()));     // Catch: Throwable -> L10
    L7:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r101);
    }

    public final void h(r98.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        List<r98.b> r101 = this.f292363a;
        monitor-enter(r101);
        ((ArrayList) this.f292363a).remove(r100);     // Catch: Throwable -> L7
        FLogger.f375446a.d("MediaLifecycleStateManager", "Unregistered listener: ".concat(r100.getClass().getSimpleName()));     // Catch: Throwable -> L7
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static Object d(MediaLifecycleState r100, Continuation r101) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MediaLifecycleStateManager$queryByState$2(r100, null), r101);
    }

    public final Object b(String r100, String r101, Continuation<? super Unit> r102) {
        Object r103 = BuildersKt.withContext(Dispatchers.getIO(), new MediaLifecycleStateManager$markFailed$2(r100, r101, this, null), r102);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Unit.INSTANCE;
    }

    public final void c(String r100, MediaLifecycleState r101, MediaLifecycleState r110, MediaMetadata r111) {
        List<r98.b> r102 = this.f292363a;
        monitor-enter(r102);
        List r103 = CollectionsKt.toList(this.f292363a);     // Catch: Throwable -> L15
        monitor-exit(r102);
        Iterator r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L14;
        r98.b r105 = (r98.b) r104.next();
        r105.b(r100, r101, r110, r111);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        FLogger.f375446a.e("MediaLifecycleStateManager", "Error notifying listener " + r105.getClass().getSimpleName() + ": " + e.getMessage(), e);
        goto L8
    L14:
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public static final void a(MediaLifecycleStateManager r100, String r101, MediaLifecycleState r102, String r103, MediaMetadata r110) {
        List<r98.b> r104 = r100.f292363a;
        monitor-enter(r104);
        List r105 = CollectionsKt.toList(r100.f292363a);     // Catch: Throwable -> L15
        monitor-exit(r104);
        Iterator r106 = r105.iterator();
    L8:
        if (r106.hasNext() == false) goto L14;
        r98.b r107 = (r98.b) r106.next();
        r107.a(r101, r102, r103, r110);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        FLogger.f375446a.e("MediaLifecycleStateManager", "Error notifying listener " + r107.getClass().getSimpleName() + ": " + e.getMessage(), e);
        goto L8
    L14:
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public final Object f(String r410, MediaLifecycleState r510, Function1<? super MediaMetadata, MediaMetadata> r511, boolean r512, Continuation<? super Unit> r513) {
        if ((r513 instanceof MediaLifecycleStateManager$transitionTo$1) == false) goto L7;
        MediaLifecycleStateManager$transitionTo$1 r100 = (MediaLifecycleStateManager$transitionTo$1) r513;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L30;
        if (r104 == 1) goto L25;
        if (r104 == 2) goto L20;
        if (r104 != 3) goto L19;
        boolean r105 = r100.Z$0;
        MediaMetadata r106 = (MediaMetadata) r100.L$3;
        MediaLifecycleState r107 = (MediaLifecycleState) r100.L$2;
        MediaLifecycleState r108 = (MediaLifecycleState) r100.L$1;
        String r109 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L16
    L78:
        String r110 = r109;
        MediaLifecycleState r111 = r108;
    L79:
        c(r110, r107, r111, r106);     // Catch: Exception -> L28
        FLogger r112 = FLogger.f375446a;     // Catch: Exception -> L28
        StringBuilder r113 = new StringBuilder("State transition: ");     // Catch: Exception -> L28
        r113.append(r110);     // Catch: Exception -> L28
        r113.append(": ");     // Catch: Exception -> L28
        r113.append(r107);     // Catch: Exception -> L28
        r113.append(" -> ");     // Catch: Exception -> L28
        r113.append(r111);     // Catch: Exception -> L28
        r113.append(" (cleanup: ");     // Catch: Exception -> L28
        if (r105 == false) goto L82;
        boolean r114 = true;
    L83:
        r113.append(r114);     // Catch: Exception -> L28
        r113.append(')');     // Catch: Exception -> L28
        r112.i("MediaLifecycleStateManager", r113.toString());     // Catch: Exception -> L28
    L90:
        return Unit.INSTANCE;
    L82:
        r114 = false;
    L16:
        e = e;
        r110 = r109;
    L88:
        FLogger.f375446a.e("MediaLifecycleStateManager", "Error during state transition for " + r110 + ": " + e.getMessage(), e);
        goto L90
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        r105 = r100.Z$0;
        r106 = (MediaMetadata) r100.L$3;
        r107 = (MediaLifecycleState) r100.L$2;
        r111 = (MediaLifecycleState) r100.L$1;
        String r115 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L23
        r110 = r115;
    L70:
        if (r105 == false) goto L79;
        r100.L$0 = r110;     // Catch: Exception -> L28
        r100.L$1 = r111;     // Catch: Exception -> L28
        r100.L$2 = r107;     // Catch: Exception -> L28
        r100.L$3 = r106;     // Catch: Exception -> L28
        r100.Z$0 = r105;     // Catch: Exception -> L28
        r100.label = 3;     // Catch: Exception -> L28
        Object r116 = BuildersKt.withContext(Dispatchers.getIO(), new MediaLifecycleStateManager$cleanupObsoleteFiles$2(r106, null), r100);     // Catch: Exception -> L28
        if (r116 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L75;
        r116 = Unit.INSTANCE;     // Catch: Exception -> L28
    L75:
        if (r116 != r103) goto L77;
        return r103;
    L77:
        r108 = r111;
        r109 = r110;
    L23:
        e = e;
        r110 = r115;
        goto L88
    L25:
        r105 = r100.Z$0;
        Function1<? super MediaMetadata, MediaMetadata> r117 = (Function1) r100.L$2;
        MediaLifecycleState r118 = (MediaLifecycleState) r100.L$1;
        r110 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L28
        Function1<? super MediaMetadata, MediaMetadata> r119 = r117;
        r111 = r118;
    L35:
        MediaMetadata r120 = (MediaMetadata) r102;     // Catch: Exception -> L28
        if (r120 != null) goto L39;
        FLogger.f375446a.e("MediaLifecycleStateManager", "Cannot transition: metadata not found for " + r110);     // Catch: Exception -> L28
        return Unit.INSTANCE;
    L39:
        r107 = r120.getLifecycleState();     // Catch: Exception -> L28
        if (r111 != MediaLifecycleState.FAILED) goto L43;
    L59:
        boolean r121 = true;
    L61:
        if (r121 == true) goto L64;
        FLogger.f375446a.w("MediaLifecycleStateManager", "Invalid state transition: " + r107 + " -> " + r111 + " for " + r110);     // Catch: Exception -> L28
        return Unit.INSTANCE;
    L64:
        if (r119 == null) goto L66;
        r120 = r119.invoke(r120);     // Catch: Exception -> L28
    L66:
        MediaMetadata r122 = MediaMetadata.copy$default(r120, null, 0, null, null, null, null, 0, 0, 0, 0, 0, AudioStats.AUDIO_AMPLITUDE_NONE, 0, null, null, r111, null, null, null, null, null, null, null, 0, 16744447, null);     // Catch: Exception -> L28
        AlbumDataBaseHelper r123 = AlbumDataBaseHelper.f292393a;     // Catch: Exception -> L28
        r100.L$0 = r110;     // Catch: Exception -> L28
        r100.L$1 = r111;     // Catch: Exception -> L28
        r100.L$2 = r107;     // Catch: Exception -> L28
        r100.L$3 = r122;     // Catch: Exception -> L28
        r100.Z$0 = r105;     // Catch: Exception -> L28
        r100.label = 2;     // Catch: Exception -> L28
        if (r123.y(r122, r100) != r103) goto L69;
        return r103;
    L69:
        r106 = r122;
        goto L70
    L43:
        switch(b.f292364a[r107.ordinal()]) {
            case 1: goto L58;
            case 2: goto L55;
            case 3: goto L52;
            case 4: goto L49;
            case 5: goto L46;
            case 6: goto L60;
            case 7: goto L60;
            default: goto L85;
        };     // Catch: Exception -> L28
    L60:
        r121 = false;
        goto L61
    L85:
        throw new NoWhenBranchMatchedException();     // Catch: Exception -> L28
    L46:
        if (r111 != MediaLifecycleState.COMPLETED) goto L60;
    L49:
        if (r111 != MediaLifecycleState.SYNCING_TO_SYSTEM_ALBUM) goto L60;
    L52:
        if (r111 != MediaLifecycleState.PROCESSED) goto L60;
    L55:
        if (r111 != MediaLifecycleState.PROCESSING) goto L60;
    L58:
        if (r111 != MediaLifecycleState.DOWNLOADED_TEMP) goto L60;
    L28:
        e = e;
        goto L88
    L30:
        ResultKt.throwOnFailure(r102);
        AlbumDataBaseHelper r124 = AlbumDataBaseHelper.f292393a;     // Catch: Exception -> L86
        r100.L$0 = r410;     // Catch: Exception -> L86
        r111 = r510;
        r100.L$1 = r111;     // Catch: Exception -> L86
        r119 = r511;
        r100.L$2 = r119;     // Catch: Exception -> L86
        r100.Z$0 = r512;     // Catch: Exception -> L86
        r100.label = 1;     // Catch: Exception -> L86
        r102 = r124.o(r410, r100);     // Catch: Exception -> L86
        if (r102 != r103) goto L34;
        return r103;
    L34:
        r110 = r410;
        r105 = r512;
    L86:
        e = e;
        r110 = r410;
    L7:
        r100 = new MediaLifecycleStateManager$transitionTo$1(this, r513);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object g(MediaLifecycleStateManager r100, String r101, MediaLifecycleState r102, Function1 r103, Continuation r110, int r111) {
        if ((r111 & 4) == 0) goto L5;
        r103 = null;
    L5:
        Function1 r104 = r103;
        if ((r111 & 8) == 0) goto L8;
        boolean r105 = true;
    L10:
        return r100.f(r101, r102, r104, r105, r110);
    L8:
        r105 = false;
        goto L10
    }
}
