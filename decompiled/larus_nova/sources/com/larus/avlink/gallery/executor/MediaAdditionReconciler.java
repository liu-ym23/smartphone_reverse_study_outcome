package com.larus.avlink.gallery.executor;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.camera.video.AudioStats;
import com.larus.avlink.gallery.business.MediaLifecycleStateManager;
import com.larus.avlink.gallery.database.AlbumDataBaseHelper;
import com.larus.avlink.gallery.model.MediaLifecycleState;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes25.dex */
public final class MediaAdditionReconciler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MediaAdditionReconciler f292495a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ContentResolver f292496b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MediaLifecycleStateManager f292497c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<Long> f292498d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f292499e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Job f292500f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final CoroutineScope f292501g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f292502h = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f292503a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f292504b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f292505c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f292506d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f292507e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f292508f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f292509g;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f292503a, r101.f292503a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f292504b, r101.f292504b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f292505c, r101.f292505c) == true) goto L18;
            return false;
        L18:
            if (this.f292506d == r101.f292506d) goto L21;
            return false;
        L21:
            if (this.f292507e == r101.f292507e) goto L24;
            return false;
        L24:
            if (this.f292508f == r101.f292508f) goto L27;
            return false;
        L27:
            if (this.f292509g == r101.f292509g) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f292503a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = ((r102 * 31) + this.f292504b.hashCode()) * 31;
            String r104 = this.f292505c;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            int r105 = (r103 + r101) * 31;
            long r106 = this.f292506d;
            int r107 = (((((r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31) + this.f292507e) * 31) + this.f292508f) * 31;
            long r108 = this.f292509g;
            return r107 + ((int) (r108 ^ (r108 >>> 32)));
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "ImageRow(relativePath=" + this.f292503a + ", dataPath=" + this.f292504b + ", displayName=" + this.f292505c + ", size=" + this.f292506d + ", width=" + this.f292507e + ", height=" + this.f292508f + ", createTimeMs=" + this.f292509g + ')';
        }

        public final boolean a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "albumDir");
            if (Build.VERSION.SDK_INT < 29) goto L5;
            com.larus.avlink.gallery.e r101 = com.larus.avlink.gallery.e.f292493a;
            String r102 = this.f292503a;
            r101.getClass();
            return com.larus.avlink.gallery.e.j(r102);
        L5:
            com.larus.avlink.gallery.e r103 = com.larus.avlink.gallery.e.f292493a;
            String r104 = this.f292504b;
            r103.getClass();
            return com.larus.avlink.gallery.e.h(r104);
        }

        public a(String r100, String r101, String r102, long r103, int r104, int r105, long r106) {
            Intrinsics.checkNotNullParameter(r101, "dataPath");
            this.f292503a = r100;
            this.f292504b = r101;
            this.f292505c = r102;
            this.f292506d = r103;
            this.f292507e = r104;
            this.f292508f = r105;
            this.f292509g = r106;
        }
    }

    public MediaAdditionReconciler() {
    }

    static {
        f292495a = new MediaAdditionReconciler();
        f292496b = AppHost.f326268a.getApplication().getContentResolver();
        f292497c = MediaLifecycleStateManager.f292361b.a();
        f292498d = new LinkedHashSet();
        f292499e = new Object();
        f292501g = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f292502h = new ConcurrentHashMap();
    }

    public static void j() {
        com.larus.avlink.gallery.e.f292493a.getClass();
        if (com.larus.avlink.gallery.e.i() == true) goto L5;
        return;
    L5:
        String r100 = AccountService.f365697a.getUserId();
        if (r100.length() != 0) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        r100 = "default";
    L12:
        if (f292502h.putIfAbsent(r100, Boolean.TRUE) == null) goto L14;
        return;
    L14:
        BuildersKt.launch$default(f292501g, null, null, new MediaAdditionReconciler$reconcileAllFromPublicAlbumAsync$1(null), 3, null);
        return;
    L8:
        r101 = false;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [T, android.database.Cursor] */
    public static a f(long r210) {
        Uri r100 = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, r210);
        List r101 = CollectionsKt.mutableListOf(new String[]{"_data", "_display_name", "_size", "width", "height", "date_added"});
        int r102 = Build.VERSION.SDK_INT;
        if (r102 < 29) goto L5;
        r101.add(LynxEventReporter.PROP_NAME_RELATIVE_PATH);
        r101.add("datetaken");
    L5:
        Ref.ObjectRef r103 = new Ref.ObjectRef();
        ?? r104 = c(f292496b, r100, (String[]) r101.toArray(new String[0]), null, null);     // Catch: Throwable -> L41 Exception -> L43
        r103.element = r104;     // Catch: Throwable -> L41 Exception -> L43
        if (r104 != 0) goto L9;
    L37:
        Cursor r105 = (Cursor) r103.element;
        if (r105 == null) goto L40;
        r105.close();
    L40:
        return null;
    L9:
        if (((Cursor) r104).moveToFirst() == false) goto L37;
        if (r102 < 29) goto L14;
        long r110 = h(r103, "datetaken");     // Catch: Throwable -> L41 Exception -> L43
    L15:
        long r111 = h(r103, "date_added");     // Catch: Throwable -> L41 Exception -> L43
        if (r110 <= 0) goto L19;
    L17:
        long r211 = r110;
        if (r102 < 29) goto L25;
        String r112 = i(r103, LynxEventReporter.PROP_NAME_RELATIVE_PATH);     // Catch: Throwable -> L41 Exception -> L43
    L26:
        String r113 = i(r103, "_data");     // Catch: Throwable -> L41 Exception -> L43
        if (r113 != null) goto L32;
        Cursor r106 = (Cursor) r103.element;
        if (r106 == null) goto L31;
        r106.close();
    L31:
        return null;
    L32:
        a r107 = new a(r112, r113, i(r103, "_display_name"), h(r103, "_size"), g(r103, "width"), g(r103, "height"), r211);     // Catch: Throwable -> L41 Exception -> L43
        Cursor r108 = (Cursor) r103.element;
        if (r108 == null) goto L56;
        r108.close();
    L56:
        return r107;
    L25:
        r112 = null;
        goto L26
    L19:
        if (r111 <= 0) goto L21;
        r110 = r111 * ((long) 1000);     // Catch: Throwable -> L41 Exception -> L43
        goto L17
    L21:
        r110 = System.currentTimeMillis();     // Catch: Throwable -> L41 Exception -> L43
        goto L17
    L14:
        r110 = 0;
    L43:
        e = move-exception;
        FLogger.f375446a.w("MediaAdditionReconciler", "Error querying image row " + r210 + ": " + e.getMessage());     // Catch: Throwable -> L41
        Cursor r109 = (Cursor) r103.element;
        if (r109 == null) goto L57;
        r109.close();
        return null;
    L57:
        return null;
    L41:
        th = move-exception;
        Cursor r114 = (Cursor) r103.element;
        if (r114 == null) goto L52;
        r114.close();
    L52:
        throw th;
    }

    public final Object e(Continuation<? super Boolean> r100) {
        if ((r100 instanceof MediaAdditionReconciler$hasInFlightSync$1) == false) goto L7;
        MediaAdditionReconciler$hasInFlightSync$1 r101 = (MediaAdditionReconciler$hasInFlightSync$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = true;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        ResultKt.throwOnFailure(r103);
    L25:
        if ((!((Collection) r103).isEmpty()) == true) goto L29;
        r106 = false;
    L29:
        return Boxing.boxBoolean(r106);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r103);
    L20:
        if ((!((Collection) r103).isEmpty()) == true) goto L29;
        MediaLifecycleStateManager r107 = f292497c;
        MediaLifecycleState r108 = MediaLifecycleState.PROCESSED;
        r101.label = 2;
        r107.getClass();
        r103 = MediaLifecycleStateManager.d(r108, r101);
        if (r103 != r104) goto L25;
        return r104;
    L16:
        ResultKt.throwOnFailure(r103);
        MediaLifecycleStateManager r109 = f292497c;
        MediaLifecycleState r110 = MediaLifecycleState.SYNCING_TO_SYSTEM_ALBUM;
        r101.label = 1;
        r109.getClass();
        r103 = MediaLifecycleStateManager.d(r110, r101);
        if (r103 != r104) goto L20;
        return r104;
    L7:
        r101 = new MediaAdditionReconciler$hasInFlightSync$1(this, r100);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.larus.avlink.gallery.executor.MediaAdditionReconciler, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v40, types: [com.larus.avlink.gallery.database.AlbumDataBaseHelper] */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v28, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v32, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:114:0x02d2 -> B:116:0x02d5). Please report as a decompilation issue!!! */
    public static final Object b(MediaAdditionReconciler r110, Continuation r111) {
        r110.getClass();
        if ((r111 instanceof MediaAdditionReconciler$reconcileAllFromPublicAlbum$1) == false) goto L7;
        MediaAdditionReconciler$reconcileAllFromPublicAlbum$1 r100 = (MediaAdditionReconciler$reconcileAllFromPublicAlbum$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        Cursor r104 = null;
        switch(r103) {
            case 0: goto L32;
            case 1: goto L31;
            case 2: goto L26;
            case 3: goto L23;
            case 4: goto L20;
            case 5: goto L17;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        long r105 = r100.J$0;
        r103 = r100.I$0;
        Iterator r106 = (Iterator) r100.L$1;
        String r107 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Exception -> L15 CancellationException -> L124
    L116:
        int r113 = r103 + 1;
        Boxing.boxInt(r103);     // Catch: Exception -> L119 CancellationException -> L124
    L85:
        if (r106.hasNext() == false) goto L130;
        r105 = ((Number) r106.next()).longValue();
        r110.getClass();     // Catch: Exception -> L122 CancellationException -> L124
        a r108 = f(r105);     // Catch: Exception -> L122 CancellationException -> L124
        if (r108 == null) goto L85;
        if (r108.a(r107) == false) goto L85;
        AlbumDataBaseHelper r114 = AlbumDataBaseHelper.f292393a;     // Catch: Exception -> L122 CancellationException -> L124
        List<Long> r115 = CollectionsKt.listOf(Boxing.boxLong(r105));     // Catch: Exception -> L122 CancellationException -> L124
        r100.L$0 = r107;     // Catch: Exception -> L122 CancellationException -> L124
        r100.L$1 = r106;     // Catch: Exception -> L122 CancellationException -> L124
        r100.L$2 = r108;     // Catch: Exception -> L122 CancellationException -> L124
        r100.I$0 = r113;     // Catch: Exception -> L122 CancellationException -> L124
        r100.J$0 = r105;     // Catch: Exception -> L122 CancellationException -> L124
        r100.label = 2;     // Catch: Exception -> L122 CancellationException -> L124
        Object r116 = r114.v(r115, r100);     // Catch: Exception -> L122 CancellationException -> L124
        if (r116 == r102) goto L178;
        r103 = r113;
        r112 = r116;
        String r117 = r107;
        Iterator r109 = r106;
        a r118 = r108;
    L96:
        if ((!((Collection) r112).isEmpty()) == true) goto L121;
        r100.L$0 = r117;     // Catch: Exception -> L29 CancellationException -> L124
        r100.L$1 = r109;     // Catch: Exception -> L29 CancellationException -> L124
        r100.L$2 = r118;     // Catch: Exception -> L29 CancellationException -> L124
        r100.I$0 = r103;     // Catch: Exception -> L29 CancellationException -> L124
        r100.J$0 = r105;     // Catch: Exception -> L29 CancellationException -> L124
        r100.label = 3;     // Catch: Exception -> L29 CancellationException -> L124
        r112 = r110.e(r100);     // Catch: Exception -> L29 CancellationException -> L124
        if (r112 != r102) goto L102;
        return r102;
    L102:
        if (((Boolean) r112).booleanValue() == false) goto L112;
        r100.L$0 = r117;     // Catch: Exception -> L29 CancellationException -> L124
        r100.L$1 = r109;     // Catch: Exception -> L29 CancellationException -> L124
        r100.L$2 = r118;     // Catch: Exception -> L29 CancellationException -> L124
        r100.I$0 = r103;     // Catch: Exception -> L29 CancellationException -> L124
        r100.J$0 = r105;     // Catch: Exception -> L29 CancellationException -> L124
        r100.label = 4;     // Catch: Exception -> L29 CancellationException -> L124
        if (DelayKt.delay(1500, r100) == r102) goto L175;
    L106:
        AlbumDataBaseHelper r119 = AlbumDataBaseHelper.f292393a;     // Catch: Exception -> L29 CancellationException -> L124
        List<Long> r120 = CollectionsKt.listOf(Boxing.boxLong(r105));     // Catch: Exception -> L29 CancellationException -> L124
        r100.L$0 = r117;     // Catch: Exception -> L29 CancellationException -> L124
        r100.L$1 = r109;     // Catch: Exception -> L29 CancellationException -> L124
        r100.L$2 = r118;     // Catch: Exception -> L29 CancellationException -> L124
        r100.I$0 = r103;     // Catch: Exception -> L29 CancellationException -> L124
        r100.J$0 = r105;     // Catch: Exception -> L29 CancellationException -> L124
        r100.label = 5;     // Catch: Exception -> L29 CancellationException -> L124
        r112 = r119.v(r120, r100);     // Catch: Exception -> L29 CancellationException -> L124
        if (r112 != r102) goto L111;
        return r102;
    L111:
        if ((!((Collection) r112).isEmpty()) == false) goto L112;
    L121:
        r113 = r103;
        r106 = r109;
        r107 = r117;
        goto L85
    L175:
        return r102;
    L112:
        a r121 = r118;
        r106 = r109;
        r107 = r117;
        r100.L$0 = r107;     // Catch: Exception -> L15 CancellationException -> L124
        r100.L$1 = r106;     // Catch: Exception -> L15 CancellationException -> L124
        r100.L$2 = null;     // Catch: Exception -> L15 CancellationException -> L124
        r100.I$0 = r103;     // Catch: Exception -> L15 CancellationException -> L124
        r100.J$0 = r105;     // Catch: Exception -> L15 CancellationException -> L124
        r100.label = 6;     // Catch: Exception -> L15 CancellationException -> L124
        if (r110.d(r105, r121, r100) != r102) goto L116;
        return r102;
    L152:
        r113 = r103;
        r106 = r109;
        r107 = r117;
        goto L85
    L178:
        return r102;
    L122:
        e = move-exception;
        r103 = r113;
        e = e;
    L127:
        int r122 = r103;
        Exception r123 = e;
        r113 = r122;
        FLogger.f375446a.e("MediaAdditionReconciler", "Full reconcile: error on " + r105 + ": " + r123.getMessage(), r123);
        goto L85
    L130:
        FLogger.f375446a.i("MediaAdditionReconciler", "=== Full Reconcile Completed: " + r113 + " image(s) registered ===");
        return Unit.INSTANCE;
    L119:
        e = move-exception;
        FLogger.f375446a.e("MediaAdditionReconciler", "Full reconcile: error on " + r105 + ": " + e.getMessage(), e);
    L15:
        e = e;
        goto L127
    L17:
        r105 = r100.J$0;
        r103 = r100.I$0;
        r118 = (a) r100.L$2;
        r109 = (Iterator) r100.L$1;
        r117 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Exception -> L29 CancellationException -> L124
        goto L111
    L20:
        r105 = r100.J$0;
        r103 = r100.I$0;
        r118 = (a) r100.L$2;
        r109 = (Iterator) r100.L$1;
        r117 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Exception -> L29 CancellationException -> L124
        goto L106
    L23:
        r105 = r100.J$0;
        r103 = r100.I$0;
        r118 = (a) r100.L$2;
        r109 = (Iterator) r100.L$1;
        r117 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Exception -> L29 CancellationException -> L124
        goto L102
    L26:
        r105 = r100.J$0;
        r103 = r100.I$0;
        r118 = (a) r100.L$2;
        r109 = (Iterator) r100.L$1;
        r117 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Exception -> L29 CancellationException -> L124
        goto L96
    L31:
        List r124 = (List) r100.L$1;
        String r125 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);
        ?? r126 = r124;
    L68:
        ArrayList r127 = new ArrayList();
        Iterator r128 = ((Iterable) r112).iterator();
    L70:
        if (r128.hasNext() == false) goto L74;
        Long r129 = ((MediaMetadata) r128.next()).getSystemGalleryId();
        if (r129 == null) goto L70;
        r127.add(r129);
        goto L70
    L74:
        Set r130 = CollectionsKt.toSet(r127);
        ArrayList r131 = new ArrayList();
        Iterator r132 = ((Iterable) r126).iterator();
    L76:
        if (r132.hasNext() == false) goto L80;
        Object r133 = r132.next();
        if (r130.contains(Boxing.boxLong(((Number) r133).longValue())) == true) goto L76;
        r131.add(r133);
        goto L76
    L80:
        FLogger.f375446a.i("MediaAdditionReconciler", "Full reconcile: disk=" + r126.size() + ", registered=" + r130.size() + ", missing=" + r131.size());
        if (r131.isEmpty() == true) goto L173;
        r106 = r131.iterator();
        r107 = r125;
        r113 = 0;
        goto L85
    L173:
        return Unit.INSTANCE;
    L32:
        ResultKt.throwOnFailure(r112);
        com.larus.avlink.gallery.e.f292493a.getClass();
        r125 = com.larus.avlink.gallery.e.l();
        if (Build.VERSION.SDK_INT < 29) goto L35;
        String[] r134 = {r125 + "/%"};
        String r135 = "relative_path LIKE ?";
    L149:
        Cursor r136 = c(f292496b, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{DBDefinition.ID}, r135, r134);     // Catch: Throwable -> L54 Exception -> L56
        if (r136 != null) goto L148;
        List r137 = CollectionsKt.emptyList();     // Catch: Throwable -> L54 Exception -> L56
    L44:
        ?? r138 = r137;
    L63:
        if (r138.isEmpty() == false) goto L65;
        FLogger.f375446a.i("MediaAdditionReconciler", "Full reconcile: no image under " + r125);
        return Unit.INSTANCE;
    L65:
        ?? r139 = AlbumDataBaseHelper.f292393a;
        r100.L$0 = r125;
        r100.L$1 = r138;
        r100.label = 1;
        r112 = r139.v(r138, r100);
        r126 = r138;
        if (r112 != r102) goto L68;
        return r102;
    L148:
        int r140 = r136.getColumnIndex(DBDefinition.ID);     // Catch: Throwable -> L50 Exception -> L52
        if (r140 >= 0) goto L45;
        r137 = CollectionsKt.emptyList();     // Catch: Throwable -> L50 Exception -> L52
        r136.close();
        goto L44
    L45:
        ?? r141 = new ArrayList();     // Catch: Throwable -> L50 Exception -> L52
    L47:
        if (r136.moveToNext() == false) goto L60;
        r141.add(Long.valueOf(r136.getLong(r140)));     // Catch: Throwable -> L50 Exception -> L52
    L60:
        r136.close();
        ?? r142 = r141;
    L61:
        r138 = r142;
    L52:
        e = e;
    L142:
        FLogger.f375446a.w("MediaAdditionReconciler", "queryAlbumDirImageIds failed: " + e.getMessage());     // Catch: Throwable -> L132
        r141 = CollectionsKt.emptyList();     // Catch: Throwable -> L132
        r142 = r141;
        if (r136 == null) goto L61;
    L132:
        th = th;
        r104 = r136;
    L134:
        r136 = r104;
    L135:
        if (r136 == null) goto L137;
        r136.close();
    L137:
        throw th;
    L50:
        th = th;
    L56:
        e = e;
        r136 = null;
    L54:
        th = th;
        goto L134
    L35:
        r134 = new String[]{"%/" + r125 + "/%"};
        r135 = "_data LIKE ?";
        goto L149
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L29:
        e = e;
        r106 = r109;
        r107 = r117;
    L124:
        e = move-exception;
        throw e;
    L7:
        r100 = new MediaAdditionReconciler$reconcileAllFromPublicAlbum$1(r110, r111);
        goto L8
    }

    public static final int g(Ref.ObjectRef<Cursor> r100, String r101) {
        Integer r102 = Integer.valueOf(r100.element.getColumnIndex(r101));
        if (r102.intValue() < 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L9;
        r102 = null;
    L9:
        if (r102 == null) goto L12;
        int r104 = r102.intValue();
        return r100.element.getInt(r104);
    L12:
        return 0;
    L5:
        r103 = false;
        goto L6
    }

    public static final long h(Ref.ObjectRef<Cursor> r100, String r101) {
        Integer r102 = Integer.valueOf(r100.element.getColumnIndex(r101));
        if (r102.intValue() < 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L9;
        r102 = null;
    L9:
        if (r102 == null) goto L11;
        int r104 = r102.intValue();
        return r100.element.getLong(r104);
    L11:
        return 0;
    L5:
        r103 = false;
        goto L6
    }

    public static final String i(Ref.ObjectRef<Cursor> r100, String r101) {
        Integer r102 = Integer.valueOf(r100.element.getColumnIndex(r101));
        if (r102.intValue() < 0) goto L5;
        boolean r103 = true;
    L7:
        if (r103 == true) goto L10;
        r102 = null;
    L10:
        if (r102 != null) goto L12;
        return null;
    L12:
        return r100.element.getString(r102.intValue());
    L5:
        r103 = false;
        goto L7
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x0197 -> B:77:0x0199). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x01d5 -> B:95:0x01f8). Please report as a decompilation issue!!! */
    public static final Object a(MediaAdditionReconciler r210, List r211, Continuation r212) {
        r210.getClass();
        if ((r212 instanceof MediaAdditionReconciler$reconcileAdded$1) == false) goto L7;
        MediaAdditionReconciler$reconcileAdded$1 r100 = (MediaAdditionReconciler$reconcileAdded$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
        MediaAdditionReconciler r102 = r210;
    L8:
        Object r103 = r100.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r100.label;
        int r106 = 3;
        int r107 = 2;
        String r110 = "MediaAdditionReconciler";
        if (r105 == 0) goto L36;
        if (r105 == 1) goto L31;
        if (r105 == 2) goto L28;
        if (r105 == 3) goto L25;
        if (r105 == 4) goto L22;
        if (r105 != 5) goto L21;
        long r111 = r100.J$0;
        r105 = r100.I$0;
        Iterator r112 = (Iterator) r100.L$1;
        String r113 = (String) r100.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L18
    L77:
        int r108 = r105 + 1;
        Boxing.boxInt(r105);     // Catch: Exception -> L80
        Object r109 = r104;
        int r114 = r108;
        String r115 = r110;
        Iterator r116 = r112;
    L95:
        MediaAdditionReconciler$reconcileAdded$1 r117 = r100;
        String r118 = r113;
    L96:
        r106 = 3;
        r107 = 2;
    L38:
        if (r116.hasNext() == false) goto L97;
        long r119 = ((Number) r116.next()).longValue();
        r102.getClass();     // Catch: Exception -> L90
        a r120 = f(r119);     // Catch: Exception -> L90
        if (r120 == null) goto L96;
        if (r120.a(r118) == false) goto L42;
        AlbumDataBaseHelper r121 = AlbumDataBaseHelper.f292393a;     // Catch: Exception -> L90
        List<Long> r122 = CollectionsKt.listOf(Boxing.boxLong(r119));     // Catch: Exception -> L90
        r117.L$0 = r118;     // Catch: Exception -> L90
        r117.L$1 = r116;     // Catch: Exception -> L90
        r117.L$2 = r120;     // Catch: Exception -> L90
        r117.I$0 = r114;     // Catch: Exception -> L90
        r117.J$0 = r119;     // Catch: Exception -> L90
        r117.label = 1;     // Catch: Exception -> L90
        Object r123 = r121.v(r122, r117);     // Catch: Exception -> L90
    L46:
        if (r123 == r109) goto L120;
        String r124 = r118;
        r100 = r117;
        r104 = r109;
        r105 = r114;
        a r125 = r120;
        r103 = r123;
        Iterator r126 = r116;
        r110 = r115;
        r111 = r119;
    L113:
    L88:
        e = e;
        Object r127 = r104;
        r117 = r100;
        r118 = r124;
        int r128 = r105;
        r109 = r127;
        long r129 = r111;
        r114 = r128;
        r115 = r110;
        r116 = r126;
        r119 = r129;
    L92:
        r124 = r118;
        r100 = r117;
        r104 = r109;
        r105 = r114;
        r126 = r116;
        r110 = r115;
        r111 = r119;
    L93:
        r112 = r126;
        r113 = r124;
    L94:
        FLogger.f375446a.e(r110, "Error reconciling media " + r111 + ": " + e.getMessage(), e);
        r114 = r105;
        r115 = r110;
        r116 = r112;
        r109 = r104;
        goto L95
    L50:
        if ((!((Collection) r103).isEmpty()) == true) goto L86;
        r100.L$0 = r124;     // Catch: Exception -> L88
        r100.L$1 = r126;     // Catch: Exception -> L88
        r100.L$2 = r125;     // Catch: Exception -> L88
        r100.I$0 = r105;     // Catch: Exception -> L88
        r100.J$0 = r111;     // Catch: Exception -> L88
        r100.label = r107;     // Catch: Exception -> L88
        r103 = r102.e(r100);     // Catch: Exception -> L88
        if (r103 == r104) goto L119;
    L107:
        if (((Boolean) r103).booleanValue() == true) goto L105;
    L71:
        r100.L$0 = r124;     // Catch: Exception -> L84
        r100.L$1 = r126;     // Catch: Exception -> L84
        r100.L$2 = null;     // Catch: Exception -> L84
        r100.I$0 = r105;     // Catch: Exception -> L84
        r100.J$0 = r111;     // Catch: Exception -> L84
        r100.label = 5;     // Catch: Exception -> L82
        if (r102.d(r111, r125, r100) == r104) goto L119;
        r112 = r126;
        r113 = r124;
    L82:
        e = e;
        goto L93
    L105:
        r100.L$0 = r124;     // Catch: Exception -> L67
        r100.L$1 = r126;     // Catch: Exception -> L67
        r100.L$2 = r125;     // Catch: Exception -> L67
        r100.I$0 = r105;     // Catch: Exception -> L67
        r100.J$0 = r111;     // Catch: Exception -> L67
        r100.label = r106;     // Catch: Exception -> L67
        if (DelayKt.delay(1500, r100) == r104) goto L119;
    L59:
        AlbumDataBaseHelper r130 = AlbumDataBaseHelper.f292393a;     // Catch: Exception -> L34
        List<Long> r131 = CollectionsKt.listOf(Boxing.boxLong(r111));     // Catch: Exception -> L34
        r100.L$0 = r124;     // Catch: Exception -> L34
        r100.L$1 = r126;     // Catch: Exception -> L34
        r100.L$2 = r125;     // Catch: Exception -> L34
        r100.I$0 = r105;     // Catch: Exception -> L34
        r100.J$0 = r111;     // Catch: Exception -> L34
        r100.label = 4;     // Catch: Exception -> L34
        r103 = r130.v(r131, r100);     // Catch: Exception -> L34
        if (r103 == r104) goto L119;
    L64:
        if ((!((Collection) r103).isEmpty()) == false) goto L71;
        r114 = r105;
        r115 = r110;
        r116 = r126;
        r109 = r104;
        r117 = r100;
        r118 = r124;
    L67:
        e = e;
    L70:
        r112 = r126;
        r113 = r124;
    L84:
        e = e;
    L119:
        return r104;
    L86:
        r114 = r105;
        r115 = r110;
        r116 = r126;
        r109 = r104;
        r117 = r100;
        r118 = r124;
        goto L96
    L120:
        return r109;
    L90:
        e = e;
        goto L92
    L97:
        if (r114 <= 0) goto L100;
        FLogger.f375446a.i(r115, "=== Addition Reconcile Completed: " + r114 + " externally added image(s) registered ===");
    L100:
        return Unit.INSTANCE;
    L80:
        e = e;
        r105 = r108;
    L18:
        e = e;
        goto L94
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L22:
        r111 = r100.J$0;
        r105 = r100.I$0;
        r125 = (a) r100.L$2;
        r126 = (Iterator) r100.L$1;
        r124 = (String) r100.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L34
        goto L64
    L25:
        r111 = r100.J$0;
        r105 = r100.I$0;
        r125 = (a) r100.L$2;
        r126 = (Iterator) r100.L$1;
        r124 = (String) r100.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L34
        goto L59
    L28:
        r111 = r100.J$0;
        r105 = r100.I$0;
        r125 = (a) r100.L$2;
        r126 = (Iterator) r100.L$1;
        r124 = (String) r100.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L34
        goto L107
    L31:
        r111 = r100.J$0;
        r105 = r100.I$0;
        r125 = (a) r100.L$2;
        r126 = (Iterator) r100.L$1;
        r124 = (String) r100.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L34
        goto L113
    L36:
        ResultKt.throwOnFailure(r103);
        com.larus.avlink.gallery.e.f292493a.getClass();
        String r132 = com.larus.avlink.gallery.e.l();
        r115 = "MediaAdditionReconciler";
        r114 = 0;
        r116 = r211.iterator();
        r109 = r104;
        r117 = r100;
        r118 = r132;
    L34:
        e = e;
    L7:
        r102 = r210;
        r100 = new MediaAdditionReconciler$reconcileAdded$1(r102, r212);
        goto L8
    }

    public final Object d(long r410, a r411, Continuation<? super Unit> r412) {
        long r100 = r410;
        if ((r412 instanceof MediaAdditionReconciler$createExternalMetadata$1) == false) goto L7;
        MediaAdditionReconciler$createExternalMetadata$1 r101 = (MediaAdditionReconciler$createExternalMetadata$1) r412;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        MediaAdditionReconciler$createExternalMetadata$1 r103 = r101;
        Object r104 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        boolean r107 = true;
        if (r106 == 0) goto L18;
        if (r106 == 1) goto L17;
        if (r106 == 2) goto L16;
        if (r106 != 3) goto L15;
        String r108 = (String) r103.L$1;
        a r109 = (a) r103.L$0;
        ResultKt.throwOnFailure(r104);
    L52:
        FLogger.f375446a.i("MediaAdditionReconciler", "Registered externally added image: uniqId=" + r108 + ", path=" + r109.f292504b);
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r108 = (String) r103.L$1;
        r109 = (a) r103.L$0;
        ResultKt.throwOnFailure(r104);
    L49:
        MediaLifecycleStateManager r110 = f292497c;
        MediaLifecycleState r111 = MediaLifecycleState.COMPLETED;
        r103.L$0 = r109;
        r103.L$1 = r108;
        r103.label = 3;
        if (MediaLifecycleStateManager.g(r110, r108, r111, null, r103, 4) != r105) goto L52;
        return r105;
    L17:
        r100 = r103.J$0;
        String r112 = (String) r103.L$1;
        a r113 = (a) r103.L$0;
        ResultKt.throwOnFailure(r104);
    L21:
        long r114 = r100;
        a r115 = r113;
        if (r104 != null) goto L24;
        Long r116 = Boxing.boxLong(r114);
        String r117 = r115.f292505c;
        Long r118 = Boxing.boxLong(r115.f292506d);
        Integer r119 = Boxing.boxInt(r115.f292507e);
        if (r119.intValue() <= 0) goto L28;
        boolean r120 = true;
    L29:
        Integer r121 = null;
        if (r120 == true) goto L33;
        r119 = null;
    L33:
        if (r119 == null) goto L35;
        int r122 = r119.intValue();
    L36:
        Integer r123 = Boxing.boxInt(r115.f292508f);
        if (r123.intValue() > 0) goto L40;
        r107 = false;
    L40:
        if (r107 == false) goto L42;
        r121 = r123;
    L42:
        if (r121 == null) goto L44;
        int r124 = r121.intValue();
    L45:
        MediaMetadata r125 = new MediaMetadata(r112, r114, r116, r117, r118, "image", r122, r124, 0, 0, 0, AudioStats.AUDIO_AMPLITUDE_NONE, r115.f292509g, null, null, MediaLifecycleState.SYNCING_TO_SYSTEM_ALBUM, null, null, null, null, null, null, r115.f292504b, 0, 12545536, null);
        AlbumDataBaseHelper r126 = AlbumDataBaseHelper.f292393a;
        r103.L$0 = r115;
        r103.L$1 = r112;
        r103.label = 2;
        if (r126.h(r125, r103) != r105) goto L48;
        return r105;
    L48:
        r109 = r115;
        r108 = r112;
        goto L49
    L44:
        r124 = MediaPlayer.MEDIA_PLAYER_OPTION_TAKE_SCREEN_SHOT_SYNC;
        goto L45
    L35:
        r122 = 3024;
        goto L36
    L28:
        r120 = false;
        goto L29
    L24:
        return Unit.INSTANCE;
    L18:
        ResultKt.throwOnFailure(r104);
        r112 = "ext_" + r100;
        AlbumDataBaseHelper r127 = AlbumDataBaseHelper.f292393a;
        r113 = r411;
        r103.L$0 = r113;
        r103.L$1 = r112;
        r103.J$0 = r100;
        r103.label = 1;
        r104 = r127.o(r112, r103);
        if (r104 != r105) goto L21;
        return r105;
    L7:
        r101 = new MediaAdditionReconciler$createExternalMetadata$1(this, r412);
        goto L8
    }

    public static Cursor c(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, r113, r114, null};
        f06.b r115 = new f06.b();
        f06.d r116 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r115);
        if (r116.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r115, false);
        return (Cursor) r116.f474983b;
    L6:
        Cursor r117 = r110.query(r111, r112, r113, r114, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r117, r115, true);
        return r117;
    }
}
