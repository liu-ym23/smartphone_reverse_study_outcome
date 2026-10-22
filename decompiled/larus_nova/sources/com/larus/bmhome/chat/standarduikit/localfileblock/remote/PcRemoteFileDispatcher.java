package com.larus.bmhome.chat.standarduikit.localfileblock.remote;

import com.larus.im.internal.jni.bean.DeviceStatusChangePayload;
import com.larus.im.internal.jni.bean.DispatchCommand;
import com.larus.im.internal.jni.bean.DispatchCommandBody;
import com.larus.im.internal.jni.bean.DispatchCommandPayload;
import com.larus.im.internal.jni.bean.DispatchErrorCode;
import com.larus.im.internal.jni.bean.FileContent;
import com.larus.im.internal.jni.bean.FileMeta;
import com.larus.im.internal.jni.bean.GetMetaRequestPayload;
import com.larus.im.internal.jni.bean.GetMetaResponsePayload;
import com.larus.im.internal.jni.bean.GetRemoteFilesContentRequestPayload;
import com.larus.im.internal.jni.bean.GetRemoteFilesContentResponsePayload;
import com.larus.im.internal.jni.bean.InteractionAskResultPayload;
import com.larus.im.internal.jni.bean.InteractionAskResultV2Payload;
import com.larus.im.internal.jni.bean.InteractionAuthorizeFolderResultPayload;
import com.larus.im.internal.jni.bean.InteractionRequestActionPayload;
import com.larus.im.internal.jni.bean.InteractionWarnResultPayload;
import com.larus.im.internal.jni.bean.OmniDispatchCommandResponse;
import com.larus.im.internal.jni.bean.StartRoomRequest;
import com.larus.im.internal.jni.bean.StartRoomResponse;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes26.dex */
public final class PcRemoteFileDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PcRemoteFileDispatcher f309430a = null;

    static {
        f309430a = new PcRemoteFileDispatcher();
    }

    public PcRemoteFileDispatcher() {
    }

    public final Object b(g r310, Continuation<? super String> r311) {
        if ((r311 instanceof PcRemoteFileDispatcher$requestUrl$1) == false) goto L7;
        PcRemoteFileDispatcher$requestUrl$1 r100 = (PcRemoteFileDispatcher$requestUrl$1) r311;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L22;
        if (r104 != 1) goto L21;
        String r105 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L14 PcRemoteFileException -> L16 CancellationException -> L18 TimeoutCancellationException -> L41
    L49:
        return r102;
    L14:
        e = e;
    L37:
        FLogger.f375446a.e("PcRemoteFilePreview", "stage=url_request_failed command_id=" + r105 + " exception=" + e.getClass().getSimpleName());
        throw new PcRemoteFileException(PcRemoteFileError.NETWORK_ERROR, null, 2, null);
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L22:
        ResultKt.throwOnFailure(r102);
        r310.b();
        String r110 = o.f365780a.getDeviceId();
        if (StringsKt.isBlank(r110) == false) goto L25;
        boolean r106 = true;
    L26:
        if (r106 == true) goto L44;
        String r107 = UUID.randomUUID().toString();
        DispatchCommand r111 = DispatchCommand.GET_REMOTE_FILES_CONTENT_REQUEST;
        GetMetaRequestPayload r112 = null;
        GetMetaResponsePayload r113 = null;
        DeviceStatusChangePayload r114 = null;
        InteractionAskResultPayload r115 = null;
        InteractionRequestActionPayload r210 = null;
        InteractionWarnResultPayload r211 = null;
        InteractionAuthorizeFolderResultPayload r212 = null;
        InteractionAskResultV2Payload r213 = null;
        StartRoomRequest r214 = null;
        StartRoomResponse r215 = null;
        String r116 = r310.f309469c;
        String r117 = r310.f309471e;
        if (r117 != null) goto L30;
        r117 = "";
    L30:
        DefaultConstructorMarker r312 = null;
        PcRemoteFileDispatcher$requestUrl$2 r108 = new PcRemoteFileDispatcher$requestUrl$2(r310, new DispatchCommandPayload(r111, r107, new DispatchCommandBody(r112, r113, r114, r115, r210, r211, r212, r213, r214, r215, new GetRemoteFilesContentRequestPayload(CollectionsKt.listOf(new FileMeta(r116, r117)), 0, 2, r312), null, null, null, 15359, r312), null, r110, null, 0, null, null, TTVideoEngineInterface.PLAYER_OPTION_DISABLE_MC_REUSE, null), r107, null);     // Catch: PcRemoteFileException -> L16 CancellationException -> L18 Exception -> L35 TimeoutCancellationException -> L41
        r100.L$0 = r107;     // Catch: PcRemoteFileException -> L16 CancellationException -> L18 Exception -> L35 TimeoutCancellationException -> L41
        r100.label = 1;     // Catch: PcRemoteFileException -> L16 CancellationException -> L18 Exception -> L35 TimeoutCancellationException -> L41
        r102 = TimeoutKt.b(900000, r108, r100);     // Catch: PcRemoteFileException -> L16 CancellationException -> L18 Exception -> L35 TimeoutCancellationException -> L41
        if (r102 != r103) goto L49;
        return r103;
    L35:
        e = e;
        r105 = r107;
        goto L37
    L44:
        throw new PcRemoteFileException(PcRemoteFileError.INVALID_REQUEST, null, 2, null);
    L25:
        r106 = false;
    L16:
        e = move-exception;
        throw e;
    L18:
        e = move-exception;
        throw e;
    L42:
        throw new PcRemoteFileException(PcRemoteFileError.REQUEST_TIMEOUT, null, 2, null);
    L7:
        r100 = new PcRemoteFileDispatcher$requestUrl$1(this, r311);
        goto L8
    }

    public static String a(OmniDispatchCommandResponse r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "response");
        Intrinsics.checkNotNullParameter(r101, "commandId");
        Intrinsics.checkNotNullParameter(r102, "filePath");
        DispatchCommandPayload r103 = r100.payload;
        if (r103 == null) goto L86;
        if (Intrinsics.areEqual(r103.commandId, r101) == false) goto L84;
        if (r103.command != DispatchCommand.GET_REMOTE_FILES_CONTENT_RESPONSE) goto L82;
        if (r103.errorCode != DispatchErrorCode.DISPATCH_ERROR_CODE_SUCCESS) goto L80;
        DispatchCommandBody r104 = r103.body;
        if (r104 == null) goto L78;
        GetRemoteFilesContentResponsePayload r105 = r104.getRemoteFilesContentResponse;
        if (r105 == null) goto L78;
        List<FileContent> r106 = r105.fileContents;
        if (r106 == null) goto L76;
        Iterator<T> r107 = r106.iterator();
    L18:
        if (r107.hasNext() == false) goto L26;
        Object r108 = r107.next();
        FileMeta r109 = ((FileContent) r108).meta;
        if (r109 == null) goto L22;
        String r110 = r109.filePath;
    L24:
        if (Intrinsics.areEqual(r110, r102) == false) goto L18;
    L27:
        FileContent r111 = (FileContent) r108;
        if (r111 == null) goto L76;
        String r112 = r111.url;
        if (r112 != null) goto L87;
        r112 = "";
    L87:
        URI r113 = new URI(r112);     // Catch: Exception -> L34
    L35:
        boolean r114 = false;
        int r115 = 0;
    L37:
        if (r115 >= r112.length()) goto L48;
        char r116 = r112.charAt(r115);
        if (CharsKt.isWhitespace(r116) == false) goto L41;
    L44:
        boolean r117 = true;
    L45:
        if (r117 == true) goto L46;
        r115 = r115 + 1;
        goto L37
    L46:
        boolean r118 = true;
    L49:
        if (r118 == true) goto L74;
        if (r113 == null) goto L52;
        String r119 = r113.getHost();
    L53:
        if (r119 != null) goto L55;
    L56:
        r114 = true;
    L57:
        if (r114 == true) goto L74;
        if (r113 == null) goto L60;
        String r120 = r113.getScheme();
    L62:
        if (StringsKt.equals(r120, "https", true) == true) goto L68;
        if (r113 == null) goto L65;
        String r121 = r113.getScheme();
    L67:
        if (StringsKt.equals(r121, "http", true) == false) goto L74;
    L65:
        r121 = null;
    L68:
        if (r113 == null) goto L70;
        String r122 = r113.getRawUserInfo();
    L71:
        if (r122 != null) goto L74;
        return r112;
    L70:
        r122 = null;
        goto L71
    L60:
        r120 = null;
        goto L62
    L55:
        if (StringsKt.isBlank(r119) == false) goto L57;
    L52:
        r119 = null;
    L74:
        throw new PcRemoteFileException(PcRemoteFileError.INVALID_URL, null, 2, null);
    L41:
        if (Character.isISOControl(r116) == true) goto L44;
        r117 = false;
        goto L45
    L48:
        r118 = false;
    L34:
        r113 = null;
        goto L35
    L22:
        r110 = null;
        goto L24
    L26:
        r108 = null;
    L76:
        throw new PcRemoteFileException(PcRemoteFileError.FILE_NOT_FOUND, null, 2, null);
    L78:
        throw new PcRemoteFileException(PcRemoteFileError.INVALID_RESPONSE, null, 2, null);
    L80:
        throw new PcRemoteFileException(PcRemoteFileError.SERVER_ERROR, Integer.valueOf(r103.errorCode.value));
    L82:
        throw new PcRemoteFileException(PcRemoteFileError.UNEXPECTED_COMMAND, null, 2, null);
    L84:
        throw new PcRemoteFileException(PcRemoteFileError.MISMATCHED_COMMAND, null, 2, null);
    L86:
        throw new PcRemoteFileException(PcRemoteFileError.INVALID_RESPONSE, null, 2, null);
    }
}
