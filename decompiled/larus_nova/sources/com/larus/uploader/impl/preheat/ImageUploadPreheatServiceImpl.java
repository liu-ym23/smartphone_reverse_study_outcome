package com.larus.uploader.impl.preheat;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.upload.ResourceUploadTokenProvider;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.IImageUploadPreheatService;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bduploader.BDImageXUploader;
import com.ss.bduploader.BDUploadUtil;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.ranges.RangesKt;
import mr9.m;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/larus/uploader/impl/preheat/ImageUploadPreheatServiceImpl;", "Lcom/larus/platform/api/IImageUploadPreheatService;", "<init>", "()V", "preheat", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "targetCount", "", "threshold", "scene", "", "dataType", "Lcom/larus/platform/model/upload/UploadDataType;", "(Landroid/content/Context;IILjava/lang/String;Lcom/larus/platform/model/upload/UploadDataType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageUploadPreheatServiceImpl implements IImageUploadPreheatService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicLong f375324a = null;

    public static final class a {
    }

    public ImageUploadPreheatServiceImpl() {
    }

    static {
        f375324a = new AtomicLong(0);
    }

    @Override // com.larus.platform.api.IImageUploadPreheatService
    public final Object a(int r110, int r210, String r211, UploadDataType r212, Continuation r213) {
        if ((r213 instanceof ImageUploadPreheatServiceImpl$preheat$1) == false) goto L7;
        ImageUploadPreheatServiceImpl$preheat$1 r100 = (ImageUploadPreheatServiceImpl$preheat$1) r213;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        long r105 = r100.J$0;
        int r106 = r100.I$1;
        int r107 = r100.I$0;
        BDImageXUploader r108 = (BDImageXUploader) r100.L$1;
        String r109 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        int r111 = r106;
    L36:
        m r112 = (m) r102;
        if (r112 == null) goto L39;
        com.larus.uploader.impl.c.a(r108, r112);
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L43
        r108.setServerParameter(c.a(r109));     // Catch: Throwable -> L43
        Object r114 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L43
    L45:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);
        if (r115 == null) goto L48;
        FLogger.f375446a.e("ImgUploadPreheat", "setServerParameter failed", r115);
    L48:
        r108.setFileNum(RangesKt.coerceAtLeast(r107, r107), RangesKt.coerceAtLeast(r111, r111));
        r108.setPreheatUploader(2);
        FLogger.f375446a.i("ImgUploadPreheat", "preheat trigger, targetCount=" + r107 + ", threshold=" + r111);
        r108.setListener(new com.larus.uploader.impl.preheat.a(r105));
        r108.startPreHeat();
        return Unit.INSTANCE;
    L43:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L45
    L39:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        String r117 = AccountService.f365697a.getUserId();
        if (r117.length() != 0) goto L17;
        boolean r118 = true;
    L18:
        if (r118 == true) goto L20;
        long r119 = System.currentTimeMillis();
        AtomicLong r120 = f375324a;
        long r121 = r120.get();
        if ((r119 - r121) >= 5000) goto L26;
        return Unit.INSTANCE;
    L26:
        if (r120.compareAndSet(r121, r119) == false) goto L28;
        long r122 = System.currentTimeMillis();
        PolarisFileWrapper r123 = new PolarisFileWrapper(AppHost.f326268a.getApplication().getCacheDir(), "BDUploadConfig");
        if (r123.exists() == true) goto L32;
        r123.mkdirs();
    L32:
        BDUploadUtil.setSDKConfigDir(r123.getAbsolutePath());
        BDImageXUploader r124 = new BDImageXUploader();
        ResourceUploadTokenProvider r125 = ResourceUploadTokenProvider.f314735a;
        r100.L$0 = r117;
        r100.L$1 = r124;
        r100.I$0 = r110;
        r111 = r210;
        r100.I$1 = r111;
        r100.J$0 = r122;
        r100.label = 1;
        Object r126 = r125.a(r211, r212, r100);
        if (r126 != r103) goto L35;
        return r103;
    L35:
        r109 = r117;
        r102 = r126;
        r108 = r124;
        r105 = r122;
        r107 = r110;
        goto L36
    L28:
        return Unit.INSTANCE;
    L20:
        return Unit.INSTANCE;
    L17:
        r118 = false;
    L7:
        r100 = new ImageUploadPreheatServiceImpl$preheat$1(this, r213);
        goto L8
    }
}
