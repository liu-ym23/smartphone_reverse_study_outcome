package com.larus.bmhome.chat.layout.holder.menu.item;

import com.larus.bmhome.chat.api.ChatApi;
import com.larus.bmhome.chat.resp.FileUrlData;
import com.larus.bmhome.chat.resp.FileUrlRespData;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.rc.ResourceSignUrlData;
import com.larus.bmhome.rc.SignUrlMode;
import com.larus.im.bean.message.SendFile;
import com.larus.platform.model.upload.UploadDataType;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class SaveMenuItemKt {
    public static final Object a(SendFile r100, Continuation r101) {
        if ((r101 instanceof SaveMenuItemKt$requireDownloadFileUrl$1) == false) goto L7;
        SaveMenuItemKt$requireDownloadFileUrl$1 r102 = (SaveMenuItemKt$requireDownloadFileUrl$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L18;
        if (r106 == 1) goto L17;
        if (r106 == 2) goto L16;
        if (r106 == 3) goto L16;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r104);
    L32:
        return r104;
    L17:
        r100 = (SendFile) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L23:
        r104 = (String) r104;
        if (r104 != null) goto L32;
        r102.L$0 = null;
        r102.label = 2;
        r104 = c(r100, r102);
        if (r104 != r105) goto L32;
        return r105;
    L18:
        ResultKt.throwOnFailure(r104);
        ResourceCenter.f313541a.getClass();
        if (ResourceCenter.c() == false) goto L28;
        r102.L$0 = r100;
        r102.label = 1;
        r104 = b(r100, r102);
        if (r104 != r105) goto L23;
        return r105;
    L28:
        r102.label = 3;
        r104 = c(r100, r102);
        if (r104 != r105) goto L32;
        return r105;
    L7:
        r102 = new SaveMenuItemKt$requireDownloadFileUrl$1(r101);
        goto L8
    }

    public static final Object b(SendFile r100, Continuation<? super String> r101) {
        if ((r101 instanceof SaveMenuItemKt$requireDownloadFileUrlByResourceId$1) == false) goto L7;
        SaveMenuItemKt$requireDownloadFileUrlByResourceId$1 r102 = (SaveMenuItemKt$requireDownloadFileUrlByResourceId$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        String r107 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L21:
        ResourceSignUrlData r108 = (ResourceSignUrlData) ((Map) r104).get(r107);
        if (r108 == null) goto L26;
        String r109 = r108.getExternalUrl();
        if (r109 == null) goto L26;
        return com.larus.utils.p0.a(r109);
    L26:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        String r110 = r100.getResourceId();
        if (r110 == null) goto L26;
        r107 = com.larus.utils.p0.a(r110);
        if (r107 == null) goto L26;
        ResourceCenter r111 = ResourceCenter.f313541a;
        List<String> r112 = CollectionsKt.listOf(r107);
        SignUrlMode r113 = SignUrlMode.Outer;
        r102.L$0 = r107;
        r102.label = 1;
        r104 = r111.m(r112, r113, r102);
        if (r104 != r105) goto L21;
        return r105;
    L7:
        r102 = new SaveMenuItemKt$requireDownloadFileUrlByResourceId$1(r101);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object c(SendFile r100, Continuation<? super String> r101) {
        if ((r101 instanceof SaveMenuItemKt$requireDownloadFileUrlByTosKey$1) == false) goto L7;
        SaveMenuItemKt$requireDownloadFileUrlByTosKey$1 r102 = (SaveMenuItemKt$requireDownloadFileUrlByTosKey$1) r101;
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
    L20:
        FileUrlRespData r107 = (FileUrlRespData) ((com.larus.network.http.a) r104).f360135b;
        if (r107 == null) goto L28;
        List<FileUrlData> r108 = r107.getFileUrlList();
        if (r108 == null) goto L29;
        FileUrlData r109 = (FileUrlData) CollectionsKt.firstOrNull(r108);
        if (r109 != null) goto L27;
        return null;
    L27:
        return r109.getMainUrl();
    L29:
        return null;
    L28:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        String r110 = r100.getTosKey();
        if (r110 != null) goto L17;
        return null;
    L17:
        Lazy<ChatApi> r111 = ChatApi.f297153a;
        ChatApi r112 = ChatApi.a.a();
        List r113 = CollectionsKt.listOf(r110);
        String r114 = UploadDataType.FILE.getType();
        r102.label = 1;
        r112.getClass();
        r104 = ChatApi.e(r113, r114, r102);
        if (r104 != r105) goto L20;
        return r105;
    L7:
        r102 = new SaveMenuItemKt$requireDownloadFileUrlByTosKey$1(r101);
        goto L8
    }
}
