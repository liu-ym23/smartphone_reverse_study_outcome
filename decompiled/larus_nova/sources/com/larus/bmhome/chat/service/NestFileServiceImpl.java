package com.larus.bmhome.chat.service;

import android.content.Context;
import com.larus.bmhome.chat.layout.item.t1;
import com.larus.bmhome.chat.list.cell.nested_file.NestedFileClickHelper;
import com.larus.bmhome.chat.list.cell.nested_file.NestedFileDownloader;
import com.larus.bmhome.nestedfile.INestFileService;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.nova.R;
import com.larus.office.base.w;
import com.obric.assistant.omnidetailpage.componment.OmniDetailContentComponent;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import t19.s;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010JH\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016JH\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016JR\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016¨\u0006 "}, d2 = {"Lcom/larus/bmhome/chat/service/NestFileServiceImpl;", "Lcom/larus/bmhome/nestedfile/INestFileService;", "<init>", "()V", "createNestedFileView", "Lcom/larus/NestedFileViewInterface;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "openResourceOnClick", "", "params", "Lcom/larus/bmhome/nestedfile/OpenResourceOnClickParams;", "requireFileUrl", "", "fileInfo", "Lcom/larus/im/bean/message/UplinkFileInfo;", "(Landroid/content/Context;Lcom/larus/im/bean/message/UplinkFileInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadFile", "Lcom/larus/bmhome/nestedfile/StepResult;", "openAudio", "key", "path", "message", "Lcom/larus/im/bean/message/Message;", "cxt", "botId", "delegate", "Lcom/larus/bmhome/nestedfile/INestedFileClickDelegate;", "openFile", "targetFileName", "openFileAfterSign", "previewUrl", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NestFileServiceImpl implements INestFileService {
    public NestFileServiceImpl() {
    }

    @Override // com.larus.bmhome.nestedfile.INestFileService
    public final void c(lr8.f r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        NestedFileClickHelper.f305409a.getClass();
        NestedFileClickHelper.i(r100);
    }

    @Override // com.larus.bmhome.nestedfile.INestFileService
    public final h38.d e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new t1(r100);
    }

    @Override // com.larus.bmhome.nestedfile.INestFileService
    public final Object a(Context r100, UplinkFileInfo r110, Continuation<? super String> r111) {
        if ((r111 instanceof NestFileServiceImpl$requireFileUrl$1) == false) goto L7;
        NestFileServiceImpl$requireFileUrl$1 r101 = (NestFileServiceImpl$requireFileUrl$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        r100 = (Context) r101.L$0;
        ResultKt.throwOnFailure(r112);
    L17:
        Context r105 = r100;
        lr8.g r113 = (lr8.g) r112;
        Integer r106 = r113.f510466b;
        if (r106 == null) goto L25;
        if (r106.intValue() != 14007) goto L25;
        s.j(s.f544207a, r105, r105.getString(R.string.larus_LarkIM_FileMsg_NoPerm_Empty), null, false, 28);
        return null;
    L25:
        return r113.f510467c;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        NestedFileDownloader r114 = NestedFileDownloader.f305412a;
        r101.L$0 = r100;
        r101.label = 1;
        r112 = r114.f(r110, r101);
        if (r112 != r103) goto L17;
        return r103;
    L7:
        r101 = new NestFileServiceImpl$requireFileUrl$1(this, r111);
        goto L8
    }

    @Override // com.larus.bmhome.nestedfile.INestFileService
    public final Object f(Context r110, UplinkFileInfo r111, Continuation<? super lr8.g> r112) {
        if ((r112 instanceof NestFileServiceImpl$downloadFile$1) == false) goto L7;
        NestFileServiceImpl$downloadFile$1 r100 = (NestFileServiceImpl$downloadFile$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        NestFileServiceImpl$downloadFile$1 r102 = r100;
        Object r113 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r113);
    L17:
        NestedFileDownloader.a r114 = (NestedFileDownloader.a) r113;
        return new lr8.g(r114.f305413a, null, null, null, null, r114.f305414b, r114.f305415c, r114.f305416d, null, MediaPlayer.MEDIA_PLAYER_OPTION_PREPARE_CACHE_MS);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        NestedFileDownloader r105 = NestedFileDownloader.f305412a;
        r102.label = 1;
        r113 = r105.c(r110, r111, null, null, r102);
        if (r113 != r103) goto L17;
        return r103;
    L7:
        r100 = new NestFileServiceImpl$downloadFile$1(this, r112);
        goto L8
    }

    @Override // com.larus.bmhome.nestedfile.INestFileService
    public final void d(Context r100, String r110, UplinkFileInfo r111, Message r112, String r113, w.a r114) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "message");
        Intrinsics.checkNotNullParameter(r114, "delegate");
        NestedFileClickHelper.f305409a.getClass();
        NestedFileClickHelper.g(r100, r110, r111, null, r112, null, r113, r114);
    }

    @Override // com.larus.bmhome.nestedfile.INestFileService
    public final void b(Context r100, String r101, String r102, UplinkFileInfo r103, Message r104, String r105, w.a r106) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, "message");
        Intrinsics.checkNotNullParameter(r106, "delegate");
        NestedFileClickHelper.f305409a.getClass();
        NestedFileClickHelper.h(r100, r101, r102, r103, r104, r105, r106);
    }

    @Override // com.larus.bmhome.nestedfile.INestFileService
    public final void g(String r100, String r101, Message r102, Context r103, UplinkFileInfo r104, String r105, OmniDetailContentComponent.b r106) {
        Intrinsics.checkNotNullParameter(r102, "message");
        Intrinsics.checkNotNullParameter(r103, "cxt");
        Intrinsics.checkNotNullParameter(r106, "delegate");
        NestedFileClickHelper.f305409a.getClass();
        NestedFileClickHelper.f(r100, r101, r102, r103, r104, r105, r106);
    }
}
