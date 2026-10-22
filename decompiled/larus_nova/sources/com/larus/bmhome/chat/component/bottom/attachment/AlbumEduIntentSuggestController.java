package com.larus.bmhome.chat.component.bottom.attachment;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.LruCache;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.common.util.UriUtil;
import com.larus.camera.api.IFlowCamera;
import com.larus.camera.api.vlm.VLMFileDataType;
import com.larus.camera.api.vlm.VLMIntentScene;
import com.larus.camera.api.vlm.VLMIntentTrackSource;
import com.larus.platform.api.FlowDriveFileType;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.model.action.SuggestedActionKey;
import com.larus.platform.model.action.SuggestedActionScene;
import com.larus.platform.service.FlowDriveSdkService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class AlbumEduIntentSuggestController {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final LruCache<String, ix8.d> f297990h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f297991i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static a.C4029a f297992j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final CoroutineScope f297993k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f297994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<bc8.a> f297995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<g> f297996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f297997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Job f297998e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f297999f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f298000g;

    public static final class a {

        /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.attachment.AlbumEduIntentSuggestController$a$a, reason: collision with other inner class name */
        public static final class C4029a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Deferred<ix8.d> f298001a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f298002b;

            public C4029a(Deferred r100) {
                Intrinsics.checkNotNullParameter(r100, "deferred");
                this.f298001a = r100;
                this.f298002b = 1;
            }
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f298003a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, String> f298004b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f298003a, r101.f298003a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f298004b, r101.f298004b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f298003a.hashCode() * 31) + this.f298004b.hashCode();
        }

        public final String toString() {
            return "RenderedSolveQuestionExt(firstImageKey=" + this.f298003a + ", messageExt=" + this.f298004b + ')';
        }

        public b(String r100, Map<String, String> r101) {
            Intrinsics.checkNotNullParameter(r100, "firstImageKey");
            Intrinsics.checkNotNullParameter(r101, "messageExt");
            this.f298003a = r100;
            this.f298004b = r101;
        }
    }

    static {
        f297990h = new LruCache(200);
        f297993k = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
    }

    public final void c() {
        if (this.f297998e == null) goto L5;
    L6:
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("[clear] cancel active detection, imageId=");
        r101.append(this.f297999f);
        r101.append(", jobActive=");
        Job r102 = this.f297998e;
        boolean r103 = false;
        if (r102 != null) goto L9;
    L11:
        r101.append(r103);
        r100.i("AlbumEduIntentSuggest", r101.toString());
    L12:
        Job r104 = this.f297998e;
        if (r104 == null) goto L15;
        Job.DefaultImpls.cancel$default(r104, null, 1, null);
    L15:
        this.f297998e = null;
        this.f297999f = null;
        this.f298000g = null;
        return;
    L9:
        if (r102.isActive() != true) goto L11;
        r103 = true;
        goto L11
    L5:
        if (this.f297999f == null) goto L12;
        goto L6
    }

    public static boolean f(SuggestedAction r100) {
        if (Intrinsics.areEqual(r100.getSuggestedActionKey(), SuggestedActionKey.EduSolveQuestionAlbum.getValue()) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r100.getSuggestedActionKey(), SuggestedActionKey.EduCorrectionAlbum.getValue()) == true) goto L8;
        return false;
    }

    public static List l(List r100) {
        List r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        String r104 = ((SuggestedAction) r103.next()).getSuggestedActionKey();
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        r102.add(r104);
        goto L4
    L9:
        return r102;
    }

    public final InputStream h(Uri r100) {
        String r101 = r100.getScheme();
        if (r101 == null) goto L21;
        int r102 = r101.hashCode();
        if (r102 == (-368816979)) goto L18;
        if (r102 == 3143036) goto L15;
        if (r102 != 951530617) goto L21;
        if (r101.equals("content") == false) goto L21;
    L32:
        return ContentResolverWrapper.openInputStream(this.f297997d.getContentResolver(), r100);
    L15:
        if (r101.equals("file") == true) goto L32;
    L18:
        if (r101.equals(UriUtil.QUALIFIED_RESOURCE_SCHEME) == true) goto L32;
    L21:
        String r103 = r100.getPath();
        if (r103 != null) goto L24;
        r103 = r100.toString();
    L24:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r103);
        if (r104.exists() == true) goto L28;
        r104 = null;
    L28:
        if (r104 == null) goto L31;
        return new PolarisFileInputStreamWrapper(r104);
    L31:
        return null;
    }

    public final String k(g r100) {
        g r101 = this.f297996c.invoke();
        if (r101 != null) goto L7;
        return "current_snapshot_unavailable";
    L7:
        if (Intrinsics.areEqual(r101.f298116a, r100.f298116a) == true) goto L10;
        return "conversation_changed";
    L10:
        if (Intrinsics.areEqual(r101.f298117b, r100.f298117b) == true) goto L13;
        return "first_image_changed";
    L13:
        if (r101.f298119d == r100.f298119d) goto L16;
        return "base_scene_changed";
    L16:
        if (Intrinsics.areEqual(r101.f298120e, r100.f298120e) == true) goto L19;
        return "biz_scene_changed";
    L19:
        if (r101.f298122g == r100.f298122g) goto L21;
        return "draft_state_changed";
    L21:
        return null;
    }

    public final void update(final g r100) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        FLogger.f375446a.i("AlbumEduIntentSuggest", "[update] start, " + h.a(r100));
        g(r100, new com.larus.bmhome.chat.component.bottom.attachment.b(this, r100));
    }

    public final void g(final g r100, final Function2<? super List<SuggestedAction>, ? super List<SuggestedAction>, Unit> r101) {
        final bc8.a r102 = this.f297995b.invoke();
        if (r102 != null) goto L6;
        FLogger.f375446a.w("AlbumEduIntentSuggest", "[loadActions] suggested action ability unavailable, " + h.a(r100));
        return;
    L6:
        FLogger.f375446a.i("AlbumEduIntentSuggest", "[loadActions] request base actions, " + h.a(r100));
        r102.cL(r100.f298119d, r100.f298120e, r100.f298122g, r100.f298121f, new c(r100, r102, r101));
    }

    public final void i(g r110, List<SuggestedAction> r111) {
        String r100 = k(r110);
        if (r100 == null) goto L6;
        FLogger.f375446a.i("AlbumEduIntentSuggest", "[render] ignore stale state, reason=" + r100 + ", " + h.a(r110));
        return;
    L6:
        bc8.a r101 = this.f297995b.invoke();
        if (r101 != null) goto L10;
        FLogger.f375446a.w("AlbumEduIntentSuggest", "[render] suggested action ability unavailable, " + h.a(r110));
        return;
    L10:
        FLogger.f375446a.i("AlbumEduIntentSuggest", "[render] bind actions, actionKeys=" + l(r111) + ", " + h.a(r110));
        r101.Zv(r110.f298119d, r110.f298120e, r111, r110.f298122g, false);
        m(r110, r111);
        r101.np();
    }

    public final void m(g r100, List<SuggestedAction> r101) {
        Iterator<T> r102 = r101.iterator();
    L3:
        b r103 = null;
        if (r102.hasNext() == false) goto L8;
        Object r104 = r102.next();
        if (Intrinsics.areEqual(((SuggestedAction) r104).getSuggestedActionKey(), SuggestedActionKey.EduSolveQuestionAlbum.getValue()) == false) goto L3;
    L9:
        SuggestedAction r105 = (SuggestedAction) r104;
        if (r105 == null) goto L14;
        Map<String, String> r106 = r105.getMsgExt();
        if (r106 == null) goto L14;
        String r107 = r106.get("Copilot:hippo:hippo_ext");
    L15:
        if (r107 == null) goto L32;
        String r108 = r100.f298117b;
        String r109 = r107;
        if (z2.f365865a.albumUnifiedAgent() == true) goto L34;
    L31:
        r103 = new b(r108, MapsKt.mapOf(TuplesKt.to("Copilot:hippo:hippo_ext", r109)));
        goto L32
    L34:
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L21
        JSONObject r111 = new JSONObject(r107);     // Catch: Throwable -> L21
        JSONObject r112 = new JSONObject(r111.optString("data"));     // Catch: Throwable -> L21
        r112.put("detection_scene_type", 120);     // Catch: Throwable -> L21
        Object r113 = Result.m9449constructorimpl(r111.put("data", r112.toString()).toString());     // Catch: Throwable -> L21
    L23:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);
        if (r114 == null) goto L26;
        FLogger.f375446a.e("AlbumEduIntentSuggest", "[freeInputHippoExt] rewrite detection_scene_type failed", r114);
    L26:
        Object r115 = r107;
        if (Result.m9455isFailureimpl(r113) == true) goto L30;
        r115 = r113;
    L30:
        r109 = (String) r115;
    L21:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L32:
        this.f298000g = r103;
        return;
    L14:
        r107 = null;
        goto L15
    L8:
        r104 = null;
        goto L9
    }

    public static final Object a(AlbumEduIntentSuggestController r210, g r211, Continuation r212) {
        r210.getClass();
        if ((r212 instanceof AlbumEduIntentSuggestController$awaitSharedDetect$1) == false) goto L7;
        AlbumEduIntentSuggestController$awaitSharedDetect$1 r100 = (AlbumEduIntentSuggestController$awaitSharedDetect$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        boolean r105 = true;
        if (r104 == 0) goto L18;
        if (r104 != 1) goto L17;
        a.C4029a r106 = (a.C4029a) r100.L$1;
        String r107 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L14
    L39:
        r103 = (ix8.d) r102;     // Catch: Throwable -> L14
        int r108 = r106.f298002b;
        if (r108 <= 0) goto L43;
        r106.f298002b = r108 - 1;
    L43:
        int r109 = r106.f298002b;
        if (f297992j != r106) goto L46;
        boolean r110 = true;
    L47:
        if (r109 != 0) goto L52;
        if (r110 == false) goto L52;
        f297991i = null;
        f297992j = null;
        if (r106.f298001a.isCompleted() == true) goto L52;
        Job.DefaultImpls.cancel$default(r106.f298001a, null, 1, null);
    L53:
        FLogger.f375446a.i("AlbumEduIntentSuggest", "[awaitSharedDetect] release, remainingSubscribers=" + r109 + ", wasCurrentTask=" + r110 + ", cancelSharedTask=" + r105 + ", imageId=" + r107);
    L54:
        return r103;
    L52:
        r105 = false;
        goto L53
    L46:
        r110 = false;
    L14:
        th = th;
        String r111 = r107;
    L57:
        int r112 = r106.f298002b;
        if (r112 <= 0) goto L60;
        r106.f298002b = r112 - 1;
    L60:
        int r113 = r106.f298002b;
        if (f297992j != r106) goto L63;
        boolean r114 = true;
    L64:
        if (r113 != 0) goto L69;
        if (r114 == false) goto L69;
        f297991i = null;
        f297992j = null;
        if (r106.f298001a.isCompleted() == true) goto L69;
        Job.DefaultImpls.cancel$default(r106.f298001a, null, 1, null);
    L70:
        FLogger.f375446a.i("AlbumEduIntentSuggest", "[awaitSharedDetect] release, remainingSubscribers=" + r113 + ", wasCurrentTask=" + r114 + ", cancelSharedTask=" + r105 + ", imageId=" + r111);
        throw th;
    L69:
        r105 = false;
        goto L70
    L63:
        r114 = false;
        goto L64
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r102);
        r111 = r211.f298117b;
        a.C4029a r115 = f297992j;
        if (Intrinsics.areEqual(f297991i, r111) == false) goto L22;
        if (r115 == null) goto L22;
        r115.f298002b++;
        Pair r116 = TuplesKt.to(r115, Boxing.boxBoolean(false));
    L30:
        r106 = (a.C4029a) r116.component1();
        boolean r117 = ((Boolean) r116.component2()).booleanValue();
        r106.f298001a.start();
        FLogger r118 = FLogger.f375446a;
        StringBuilder r119 = new StringBuilder("[awaitSharedDetect] role=");
        if (r117 == false) goto L33;
        String r120 = "starter";
    L34:
        r119.append(r120);
        r119.append(", subscriberCount=");
        r119.append(r106.f298002b);
        r119.append(", taskActive=");
        r119.append(r106.f298001a.isActive());
        r119.append(", imageId=");
        r119.append(r111);
        r118.i("AlbumEduIntentSuggest", r119.toString());
        Deferred<ix8.d> r121 = r106.f298001a;     // Catch: Throwable -> L56
        r100.L$0 = r111;     // Catch: Throwable -> L56
        r100.L$1 = r106;     // Catch: Throwable -> L56
        r100.label = 1;     // Catch: Throwable -> L56
        Object r122 = r121.await(r100);     // Catch: Throwable -> L56
        if (r122 == r103) goto L54;
        r107 = r111;
        r102 = r122;
    L56:
        th = th;
        goto L57
    L33:
        r120 = "joiner";
    L22:
        if (r115 == null) goto L24;
        FLogger.f375446a.i("AlbumEduIntentSuggest", "[awaitSharedDetect] replace, previousImageId=" + f297991i + ", previousSubscriberCount=" + r115.f298002b + ", previousTaskActive=" + r115.f298001a.isActive() + ", nextImageId=" + r111);
    L24:
        f297991i = null;
        f297992j = null;
        if (r115 == null) goto L29;
        Deferred<ix8.d> r123 = r115.f298001a;
        if (r123 == null) goto L29;
        Job.DefaultImpls.cancel$default(r123, null, 1, null);
    L29:
        a.C4029a r124 = new a.C4029a(BuildersKt.async$default(f297993k, null, CoroutineStart.LAZY, new AlbumEduIntentSuggestController$awaitSharedDetect$newTask$1(r210, r211, r111, null), 1, null));
        f297991i = r111;
        f297992j = r124;
        r116 = TuplesKt.to(r124, Boxing.boxBoolean(true));
    L7:
        r100 = new AlbumEduIntentSuggestController$awaitSharedDetect$1(r210, r212);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r0v40 */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r0v54 */
    /* JADX WARN: Type inference failed for: r0v58 */
    /* JADX WARN: Type inference failed for: r0v59 */
    /* JADX WARN: Type inference failed for: r0v60 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v29 */
    /* JADX WARN: Type inference failed for: r12v36 */
    /* JADX WARN: Type inference failed for: r12v37 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v40 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.graphics.Bitmap, com.larus.bmhome.chat.component.bottom.attachment.g, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10, types: [android.graphics.Bitmap, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v22, types: [oq9.c] */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v30, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33, types: [com.larus.bmhome.chat.component.bottom.attachment.g, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r1v46 */
    /* JADX WARN: Type inference failed for: r1v47 */
    /* JADX WARN: Type inference failed for: r1v48 */
    /* JADX WARN: Type inference failed for: r1v49 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v50 */
    /* JADX WARN: Type inference failed for: r1v51 */
    /* JADX WARN: Type inference failed for: r1v52 */
    /* JADX WARN: Type inference failed for: r1v53 */
    /* JADX WARN: Type inference failed for: r1v54 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v10, types: [oq9.c] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26, types: [java.lang.Object, oq9.c] */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v31, types: [java.lang.Object, oq9.c] */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v13, types: [com.larus.bmhome.chat.component.bottom.attachment.g] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v1, types: [com.larus.bmhome.chat.component.bottom.attachment.g] */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v3, types: [com.larus.bmhome.chat.component.bottom.attachment.g] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [com.larus.bmhome.chat.component.bottom.attachment.g, java.lang.Object] */
    public static final Object b(AlbumEduIntentSuggestController r210, g r211, Continuation r212) {
        ?? r100 = r211;
        r210.getClass();
        if ((r212 instanceof AlbumEduIntentSuggestController$detect$1) == false) goto L7;
        AlbumEduIntentSuggestController$detect$1 r101 = (AlbumEduIntentSuggestController$detect$1) r212;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        ?? r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        char r110 = 2;
        ?? r111 = 2;
        boolean r112 = true;
        if (r105 != 0) goto L121;
        ResultKt.throwOnFailure(r103);
        r103 = z2.f365865a.getAttachmentAlbumDetectConfig();
        FLogger.f375446a.i("AlbumEduIntentSuggest", "[detect] decode start, source=" + h.b(r100.f298118c) + ", resizeShortSide=" + r103.d() + ", timeoutMs=" + r103.a() + ", compressQuality=" + r103.c() + ", imageId=" + r100.f298117b);
        com.larus.bmhome.chat.component.bottom.attachment.a r106 = r100.f298118c;     // Catch: Exception -> L83 CancellationException -> L107
        if ((r106 instanceof com.larus.bmhome.chat.component.bottom.attachment.a.b) == false) goto L53;
        CoroutineDispatcher r107 = Dispatchers.getIO();     // Catch: Exception -> L83 CancellationException -> L107
        Bitmap r113 = null;
        AlbumEduIntentSuggestController$detect$bitmap$1 r114 = new AlbumEduIntentSuggestController$detect$bitmap$1(r210, r106, r103, null);     // Catch: Exception -> L81 CancellationException -> L111
        r101.L$0 = r100;     // Catch: Exception -> L81 CancellationException -> L111
        r101.L$1 = r103;     // Catch: Exception -> L81 CancellationException -> L111
        r101.label = 1;     // Catch: Exception -> L81 CancellationException -> L111
        Object r108 = BuildersKt.withContext(r107, r114, r101);     // Catch: Exception -> L81 CancellationException -> L111
        ?? r109 = r108;
        ?? r115 = r100;
        ?? r116 = r103;
        if (r108 == r104) goto L122;
    L52:
        Bitmap r117 = (Bitmap) r109;     // Catch: Exception -> L81 CancellationException -> L111
        ?? r118 = r115;
        ?? r119 = r116;
        Bitmap r120 = r113;
    L78:
        ?? r121 = r118;
        ?? r122 = r117;
        ?? r123 = r119;
        r111 = r120;
    L87:
        if (r122 != 0) goto L89;
        FLogger.f375446a.w("AlbumEduIntentSuggest", "[detect] image decode returned null, source=" + h.b(r121.f298118c) + ", imageId=" + r121.f298117b);
        return new ix8.d.a(new ix8.e.b("album image decode failed"));
    L89:
        FLogger r124 = FLogger.f375446a;
        r124.i("AlbumEduIntentSuggest", "[detect] decode success, bitmapWidth=" + r122.getWidth() + ", bitmapHeight=" + r122.getHeight() + ", imageId=" + r121.f298117b);
        IFlowCamera r125 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);     // Catch: Throwable -> L20 Exception -> L100 CancellationException -> L110
        if (r125 != null) goto L93;
        r124.w("AlbumEduIntentSuggest", "[detect] camera service unavailable, imageId=" + r121.f298117b);     // Catch: Throwable -> L20 Exception -> L100 CancellationException -> L110
        Object r126 = new ix8.d.a(new ix8.e.b("camera service unavailable"));     // Catch: Throwable -> L20 Exception -> L100 CancellationException -> L110
        ?? r127 = r122;
    L103:
        r127.recycle();
        return r126;
    L93:
        r124.i("AlbumEduIntentSuggest", "[detect] request VLM intent, imageId=" + r121.f298117b);     // Catch: Throwable -> L20 Exception -> L100 CancellationException -> L110
        ix8.c r128 = new ix8.c(CollectionsKt.listOf(new ix8.b(r122, VLMFileDataType.IMAGE)), null, new ix8.a(Boxing.boxLong(r123.a()), r123.d(), r123.c(), true, false, false), VLMIntentTrackSource.ALBUM, 10);     // Catch: Throwable -> L20 Exception -> L100 CancellationException -> L110
        r101.L$0 = r121;     // Catch: Throwable -> L20 Exception -> L100 CancellationException -> L110
        r101.L$1 = r122;     // Catch: Throwable -> L20 Exception -> L100 CancellationException -> L110
        r101.label = 5;     // Catch: Throwable -> L20 Exception -> L100 CancellationException -> L110
        Object r129 = r125.d(r128, r101);     // Catch: Throwable -> L20 Exception -> L100 CancellationException -> L110
        if (r129 == r104) goto L128;
        ?? r130 = r121;
        r122 = r122;
        ?? r131 = r129;
    L97:
        Object r132 = (ix8.d) r131;     // Catch: Throwable -> L20 Exception -> L22 CancellationException -> L110
        ?? r133 = r122;
    L98:
        r126 = r132;
        r127 = r133;
    L22:
        Exception e100 = e;
        r121 = r130;
    L101:
        FLogger.f375446a.e("AlbumEduIntentSuggest", "[detect] request failed, imageId=" + r121.f298117b, e100);     // Catch: Throwable -> L20
        r132 = new ix8.d.a(new ix8.e.b(e100.getMessage()));     // Catch: Throwable -> L20
        r133 = r122;
        goto L98
    L128:
        return r104;
    L100:
        e100 = e;
    L106:
        r122.recycle();
        goto L109
    L122:
        return r104;
    L53:
        Bitmap r134 = null;
        Bitmap r135 = null;
        Bitmap r136 = null;
        if ((r106 instanceof com.larus.bmhome.chat.component.bottom.attachment.a.c) == false) goto L59;
        String r137 = ((com.larus.bmhome.chat.component.bottom.attachment.a.c) r106).f298083a;     // Catch: Exception -> L81 CancellationException -> L111
        float r138 = r103.d();     // Catch: Exception -> L81 CancellationException -> L111
        r101.L$0 = r100;     // Catch: Exception -> L81 CancellationException -> L111
        r101.L$1 = r103;     // Catch: Exception -> L81 CancellationException -> L111
        r101.label = 2;     // Catch: Exception -> L81 CancellationException -> L111
        Object r139 = d(r137, r138, r101);     // Catch: Exception -> L81 CancellationException -> L111
        ?? r140 = r139;
        ?? r141 = r100;
        ?? r142 = r103;
        if (r139 == r104) goto L123;
    L58:
        r117 = (Bitmap) r140;     // Catch: Exception -> L81 CancellationException -> L111
        r118 = r141;
        r119 = r142;
        r120 = r135;
        goto L78
    L123:
        return r104;
    L59:
        ?? r143 = r100;
        ?? r144 = r103;
        if ((r106 instanceof com.larus.bmhome.chat.component.bottom.attachment.a.C4030a) == false) goto L76;
        FlowDriveSdkService r145 = FlowDriveSdkService.f365704a;     // Catch: Exception -> L81 CancellationException -> L111
        String r146 = ((com.larus.bmhome.chat.component.bottom.attachment.a.C4030a) r106).f298081a;     // Catch: Exception -> L81 CancellationException -> L111
        FlowDriveFileType r147 = FlowDriveFileType.IMAGE;     // Catch: Exception -> L81 CancellationException -> L111
        r101.L$0 = r100;     // Catch: Exception -> L81 CancellationException -> L111
        r101.L$1 = r103;     // Catch: Exception -> L81 CancellationException -> L111
        r101.label = 3;     // Catch: Exception -> L81 CancellationException -> L111
        Object r148 = r145.i(r146, r147, r101);     // Catch: Exception -> L81 CancellationException -> L111
        ?? r149 = r148;
        ?? r150 = r100;
        ?? r151 = r103;
        if (r148 == r104) goto L124;
    L64:
        String r152 = (String) r149;     // Catch: Exception -> L81 CancellationException -> L111
        if (r152 != null) goto L67;
    L70:
        if (r112 == false) goto L72;
        FLogger.f375446a.w("AlbumEduIntentSuggest", "[detect] drive url unavailable, imageId=" + r150.f298117b);     // Catch: Exception -> L81 CancellationException -> L111
        r143 = r150;
        r144 = r151;
        r134 = r136;
    L77:
        r117 = r134;
        r118 = r143;
        r119 = r144;
        r120 = r134;
        goto L78
    L72:
        float r153 = r151.d();     // Catch: Exception -> L81 CancellationException -> L111
        r101.L$0 = r150;     // Catch: Exception -> L81 CancellationException -> L111
        r101.L$1 = r151;     // Catch: Exception -> L81 CancellationException -> L111
        r101.label = 4;     // Catch: Exception -> L81 CancellationException -> L111
        Object r154 = d(r152, r153, r101);     // Catch: Exception -> L81 CancellationException -> L111
        ?? r155 = r154;
        ?? r156 = r150;
        ?? r157 = r151;
        Bitmap r158 = r136;
        if (r154 == r104) goto L125;
    L75:
        r117 = (Bitmap) r155;     // Catch: Exception -> L81 CancellationException -> L111
        r118 = r156;
        r119 = r157;
        r120 = r158;
        goto L78
    L125:
        return r104;
    L67:
        if (StringsKt.isBlank(r152) == true) goto L70;
        r112 = false;
        goto L70
    L124:
        return r104;
    L76:
        if (r106 == null) goto L77;
        throw new NoWhenBranchMatchedException();     // Catch: Exception -> L81 CancellationException -> L111
    L83:
        e = e;
        r110 = 0;
    L85:
        ?? r159 = r100;
        ?? r160 = r103;
        ?? r161 = r110;
    L86:
        FLogger.f375446a.e("AlbumEduIntentSuggest", "[detect] image decode failed, source=" + h.b(r159.f298118c) + ", imageId=" + r159.f298117b, e);
        r123 = r160;
        r122 = r161;
        r121 = r159;
        r111 = r161;
        goto L87
    L121:
        if (r105 == 1) goto L38;
        if (r105 == 2) goto L35;
        if (r105 != 3) goto L14;
        r100 = (oq9.c) r101.L$1;
        Object r162 = (g) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L33 CancellationException -> L107
        r149 = r103;
        r136 = null;
        r151 = r100;
        r150 = r162;
    L33:
        e = e;
    L43:
        r161 = 0;
        r160 = r100;
        r159 = r162;
        goto L86
    L14:
        if (r105 != 4) goto L16;
        oq9.c r163 = (oq9.c) r101.L$1;
        g r164 = (g) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L41 CancellationException -> L107
        r155 = r103;
        r158 = null;
        r157 = r163;
        r156 = r164;
        goto L75
    L16:
        if (r105 != 5) goto L26;
        r122 = (Bitmap) r101.L$1;
        r130 = (g) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L20 Exception -> L22 CancellationException -> L24
        r122 = r122;
        r131 = r103;
        r130 = r130;
    L24:
        r111 = 0;
        goto L106
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L35:
        oq9.c r165 = (oq9.c) r101.L$1;
        g r166 = (g) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L41 CancellationException -> L107
        r140 = r103;
        r135 = null;
        r142 = r165;
        r141 = r166;
        goto L58
    L38:
        oq9.c r167 = (oq9.c) r101.L$1;
        g r168 = (g) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L41 CancellationException -> L107
        r109 = r103;
        r113 = null;
        r116 = r167;
        r115 = r168;
    L41:
        e = e;
        r162 = "[detect] drive url unavailable, imageId=";
    L20:
        th = move-exception;
        r100.recycle();
        throw th;
    L107:
        r111 = 0;
    L81:
        e = e;
    L109:
        return r111;
    L7:
        r101 = new AlbumEduIntentSuggestController$detect$1(r210, r212);
        goto L8
    }

    public static Object d(String r100, float r101, Continuation r102) {
        Float r103 = Boxing.boxFloat(r101);
        if (r103.floatValue() <= 0.0f) goto L5;
        boolean r104 = true;
    L7:
        if (r104 == true) goto L10;
        r103 = null;
    L10:
        if (r103 == null) goto L12;
        int r105 = (int) r103.floatValue();
    L14:
        return BuildersKt.withContext(Dispatchers.getIO(), new AlbumEduIntentSuggestController$decodeRemoteBitmap$2(r100, r105, null), r102);
    L12:
        r105 = 720;
        goto L14
    L5:
        r104 = false;
        goto L7
    }

    public static SuggestedAction n(SuggestedAction r110, ix8.d r111, int r112) {
        if ((r111 instanceof ix8.d.b) == false) goto L5;
        ix8.d.b r100 = (ix8.d.b) r111;
    L6:
        if (r100 == null) goto L17;
        String r101 = r100.f496401i;
        if (r101 == null) goto L17;
        JSONObject r102 = new JSONObject();
        r102.put(EventConstant.Key.DETECTION_TYPE, 2);
        r102.put("request_id", r101);
        r102.put("edu_camera_sdk_version", "10400");
        r102.put("picture_source", 3);
        r102.put("os", 2);
        r102.put("detection_scene_type", r112);
        r102.put("subject_type", 2);
        JSONObject r103 = new JSONObject();
        r103.put("data", r102.toString());
        r103.put("to_module_unit", new JSONArray().put(new JSONObject().put("to_module", 4)));
        String r104 = r103.toString();
        Map<String, String> r105 = r110.getMsgExt();
        if (r105 == null) goto L14;
        Map r106 = MapsKt.toMutableMap(r105);
        if (r106 == null) goto L14;
    L15:
        Map r113 = r106;
        r113.put("Copilot:hippo:hippo_ext", r104);
        Unit r107 = Unit.INSTANCE;
        return SuggestedAction.copy$default(r110, null, 0, 0, null, false, null, null, null, null, null, null, r113, 2047, null);
    L14:
        r106 = new LinkedHashMap();
    L17:
        return r110;
    L5:
        r100 = null;
        goto L6
    }

    public final void e(g r100, List<SuggestedAction> r101, Set<String> r102) {
        String r103 = k(r100);
        if (r103 == null) goto L6;
        FLogger.f375446a.i("AlbumEduIntentSuggest", "[insertWithAnimate] ignore stale state, reason=" + r103 + ", " + h.a(r100));
        return;
    L6:
        bc8.a r104 = this.f297995b.invoke();
        if (r104 != null) goto L10;
        FLogger.f375446a.w("AlbumEduIntentSuggest", "[insertWithAnimate] suggested action ability unavailable, " + h.a(r100));
        return;
    L10:
        FLogger.f375446a.i("AlbumEduIntentSuggest", "[insertWithAnimate] insert actions, actionKeys=" + l(r101) + ", removeActionKeys=" + r102 + ", " + h.a(r100));
        r104.r40(r100.f298119d, r100.f298120e, r101, r102);
        m(r100, r101);
        r104.np();
    }

    public AlbumEduIntentSuggestController(Context r100, LifecycleCoroutineScope r101, c0 r102, d0 r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "scope");
        Intrinsics.checkNotNullParameter(r102, "suggestedActionAbility");
        Intrinsics.checkNotNullParameter(r103, "currentSnapshot");
        this.f297994a = r101;
        this.f297995b = r102;
        this.f297996c = r103;
        this.f297997d = r100.getApplicationContext();
    }

    public final void j(g r110, List<SuggestedAction> r111, List<SuggestedAction> r112, ix8.d r113, boolean r114) {
        String r100 = null;
        if ((r113 instanceof ix8.d.b) == false) goto L5;
        ix8.d.b r101 = (ix8.d.b) r113;
    L6:
        if (r101 == null) goto L8;
        String r102 = r101.f496401i;
    L9:
        boolean r103 = false;
        if (r102 != null) goto L12;
    L15:
        boolean r104 = true;
    L16:
        if (r104 == false) goto L18;
        List<VLMIntentScene> r105 = CollectionsKt.listOf(VLMIntentScene.COMMON);
    L19:
        ArrayList r106 = new ArrayList();
        Iterator<T> r107 = r112.iterator();
    L21:
        if (r107.hasNext() == false) goto L46;
        SuggestedAction r108 = (SuggestedAction) r107.next();
        String r109 = r108.getSuggestedActionKey();
        if (Intrinsics.areEqual(r109, SuggestedActionKey.EduSolveQuestionAlbum.getValue()) == false) goto L31;
        if (r105.contains(VLMIntentScene.QUESTION_SOLVING) == true) goto L28;
        r108 = null;
    L28:
        if (r108 == null) goto L43;
        SuggestedAction r115 = n(r108, r113, 110);
    L44:
        if (r115 == null) goto L21;
        r106.add(r115);
    L43:
        r115 = null;
        goto L44
    L31:
        if (Intrinsics.areEqual(r109, SuggestedActionKey.EduCorrectionAlbum.getValue()) == false) goto L43;
        if (r110.f298119d == SuggestedActionScene.AttachmentAreaSingleImg) goto L35;
    L37:
        boolean r116 = false;
    L38:
        if (r116 == true) goto L41;
        r108 = null;
    L41:
        if (r108 == null) goto L43;
        r115 = n(r108, r113, 111);
        goto L44
    L35:
        if (r105.contains(VLMIntentScene.HOMEWORK_CORRECTION) == false) goto L37;
        r116 = true;
        goto L38
    L46:
        FLogger r117 = FLogger.f375446a;
        StringBuilder r118 = new StringBuilder("[renderResult] resultType=");
        r118.append(r113.getClass().getSimpleName());
        r118.append(", status=");
        r118.append(r113.b().getClass().getSimpleName());
        r118.append(", hasRequestId=");
        if (r101 == null) goto L49;
        r100 = r101.f496401i;
    L49:
        if (r100 != null) goto L51;
    L52:
        r103 = true;
    L53:
        r118.append(!r103);
        r118.append(", scenes=");
        r118.append(r105);
        r118.append(", animate=");
        r118.append(r114);
        r118.append(", baseActionCount=");
        r118.append(r111.size());
        r118.append(", albumEduActionCount=");
        r118.append(r112.size());
        r118.append(", educationActionKeys=");
        r118.append(l(r106));
        r118.append(", ");
        r118.append(h.a(r110));
        r117.i("AlbumEduIntentSuggest", r118.toString());
        if (r114 == false) goto L56;
        e(r110, r106, SetsKt.setOf(SuggestedActionKey.Loading.getValue()));
        return;
    L56:
        i(r110, CollectionsKt.plus(r106, r111));
        return;
    L51:
        if (StringsKt.isBlank(r100) == false) goto L53;
    L18:
        r105 = ix8.i.a(r113).f496411a;
        goto L19
    L12:
        if (StringsKt.isBlank(r102) == true) goto L15;
        r104 = false;
        goto L16
    L8:
        r102 = null;
        goto L9
    L5:
        r101 = null;
        goto L6
    }
}
