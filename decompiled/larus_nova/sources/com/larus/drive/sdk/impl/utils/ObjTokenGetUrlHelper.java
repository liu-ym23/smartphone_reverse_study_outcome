package com.larus.drive.sdk.impl.utils;

import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.bmhome.chat.resp.FileUrlData;
import com.larus.bmhome.chat.resp.FileUrlRespData;
import com.larus.bmhome.rc.GetVideoModelResultItem;
import com.larus.bmhome.rc.GetVideoModelResults;
import com.larus.bmhome.rc.ResourceApi;
import com.larus.bmhome.rc.VideoUrlResult;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.platform.api.FlowDriveFileType;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.utils.logger.FLogger;
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
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final class ObjTokenGetUrlHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ObjTokenGetUrlHelper f342013a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f342014a = null;

        static {
            int[] r100 = new int[FlowDriveFileType.values().length];
            r100[FlowDriveFileType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[FlowDriveFileType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L29:
            r100[FlowDriveFileType.AUDIO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            f342014a = r100;
            int[] r101 = new int[DriveFileType.values().length];
            r101[DriveFileType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L25:
            r101[DriveFileType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L31:
            r101[DriveFileType.AUDIO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L21:
            r101[DriveFileType.FOLDER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
            return;
        }
    }

    static {
        f342013a = new ObjTokenGetUrlHelper();
    }

    public ObjTokenGetUrlHelper() {
    }

    public final Object c(String r100, Continuation<? super String> r101) {
        if ((r101 instanceof ObjTokenGetUrlHelper$requireAudioUrl$1) == false) goto L7;
        ObjTokenGetUrlHelper$requireAudioUrl$1 r102 = (ObjTokenGetUrlHelper$requireAudioUrl$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L17:
        dm9.a r107 = (dm9.a) r104;
        if ((r107 instanceof dm9.a.C5690a) == false) goto L21;
        return null;
    L21:
        if ((r107 instanceof dm9.a.b) == false) goto L33;
        GetVideoModelResults r108 = (GetVideoModelResults) ((dm9.a.b) r107).f469231a.getData();
        if (r108 == null) goto L34;
        List<GetVideoModelResultItem> r109 = r108.getResults();
        if (r109 == null) goto L35;
        GetVideoModelResultItem r110 = (GetVideoModelResultItem) CollectionsKt.firstOrNull(r109);
        if (r110 == null) goto L36;
        VideoUrlResult r111 = r110.getVideoUrlResult();
        if (r111 != null) goto L31;
        return null;
    L31:
        return r111.getVideoUrl();
    L36:
        return null;
    L35:
        return null;
    L34:
        return null;
    L33:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        ResourceApi.a r112 = ResourceApi.f313539a;
        ObjTokenGetUrlHelper$requireAudioUrl$2 r113 = new ObjTokenGetUrlHelper$requireAudioUrl$2(r100, null);
        r102.label = 1;
        r112.getClass();
        r104 = ResourceApi.a.a("/alice/resource/get_video_model", r113, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new ObjTokenGetUrlHelper$requireAudioUrl$1(this, r101);
        goto L8
    }

    public static Object d(List r110, UploadDataType r111, Continuation r112) {
        JSONObject r100 = new JSONObject();
        r100.put("uris", new JSONArray(r110));
        r100.put("type", r111.getType());
        Unit r113 = Unit.INSTANCE;
        return HttpExtKt.k(ServiceType.DRIVE, FileUrlRespData.class, "/alice/message/get_file_url", r100, null, null, false, null, null, null, r112, 1008);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object b(String r100, FlowDriveFileType r101, Continuation<? super String> r102) {
        if ((r102 instanceof ObjTokenGetUrlHelper$getUrlByTokenSuspend$1) == false) goto L7;
        ObjTokenGetUrlHelper$getUrlByTokenSuspend$1 r103 = (ObjTokenGetUrlHelper$getUrlByTokenSuspend$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L16;
        if (r107 == 1) goto L15;
        if (r107 != 2) goto L14;
        ResultKt.throwOnFailure(r105);
    L31:
        FileUrlRespData r108 = (FileUrlRespData) ((com.larus.network.http.a) r105).f360135b;
        if (r108 == null) goto L40;
        List<FileUrlData> r109 = r108.getFileUrlList();
        if (r109 == null) goto L40;
        FileUrlData r110 = (FileUrlData) CollectionsKt.firstOrNull(r109);
        if (r110 == null) goto L40;
        String r111 = r110.getMainUrl();
        if (r111 == null) goto L43;
        return r111;
    L43:
        return r110.getBackUrl();
    L40:
        return null;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r105);
    L25:
        return r105;
    L16:
        ResultKt.throwOnFailure(r105);
        int r112 = a.f342014a[r101.ordinal()];
        if (r112 == 1) goto L27;
        if (r112 != 2) goto L20;
        UploadDataType r113 = UploadDataType.VIDEO;
    L28:
        List r114 = CollectionsKt.listOf(r100);
        r103.label = 2;
        r105 = d(r114, r113, r103);
        if (r105 != r106) goto L31;
        return r106;
    L20:
        if (r112 == 3) goto L22;
        r113 = UploadDataType.FILE;
        goto L28
    L22:
        r103.label = 1;
        r105 = c(r100, r103);
        if (r105 != r106) goto L25;
        return r106;
    L27:
        r113 = UploadDataType.IMAGE;
    L7:
        r103 = new ObjTokenGetUrlHelper$getUrlByTokenSuspend$1(this, r102);
        goto L8
    }

    public static void a(String r110, FlowDriveFileType r111, LifecycleCoroutineScope r112, Function1 r113, Function1 r114) {
        Intrinsics.checkNotNullParameter(r110, "objTokenString");
        Intrinsics.checkNotNullParameter(r111, "fileType");
        Intrinsics.checkNotNullParameter(r112, "scope");
        Intrinsics.checkNotNullParameter(r113, "onSuccess");
        if (r111 != FlowDriveFileType.NON_FILE) goto L6;
        FLogger.f375446a.i("ObjTokenGetUrlHelper", "[getUrlByToken] This is not a file, stop get url");
        return;
    L6:
        BuildersKt.launch$default(r112, Dispatchers.getIO(), null, new ObjTokenGetUrlHelper$getUrlByToken$1(r111, r110, r112, r113, r114, null), 2, null);
    }
}
