package com.larus.audio.flow.client.kmp_com;

import com.bytedance.flow_audio.api.business.asr.error.FlowAsrErrorType;
import com.bytedance.flow_audio.api.business.asr.source.FlowAsrFileAudioDataProvider;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.capabilitykit.common.ErrorCode;
import java.io.BufferedInputStream;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kw5.c;
import kw5.d;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u0000 \t2\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/larus/audio/flow/client/kmp_com/AsrFileAudioDataProvider;", "Lcom/bytedance/flow_audio/api/business/asr/source/FlowAsrFileAudioDataProvider;", "<init>", "()V", "openFileAudioData", "Lcom/bytedance/flow_audio/api/business/asr/source/FlowAsrFileAudioDataOpenResult;", "filePath", "", "AndroidFileAudioDataStream", "Companion", "audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AsrFileAudioDataProvider implements FlowAsrFileAudioDataProvider {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f289744b = 0;

    public static final class a implements d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BufferedInputStream f289745b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f289746c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f289747d;

        @Override // kw5.d
        public final c Y() {
            if (this.f289747d == true) goto L5;
            Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L12
            int r101 = this.f289745b.read(this.f289746c);     // Catch: Throwable -> L12
            if (r101 != (-1)) goto L9;
            Object r102 = c.a.f506397a;     // Catch: Throwable -> L12
        L10:
            Object r103 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L12
        L14:
            Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
            if (r104 == null) goto L19;
            c68.b.c("AsrFileAudioDataProvider", "read file audio data failed", r104);
            int r105 = AsrFileAudioDataProvider.f289744b;
            r103 = new c.b(b.a(FlowAsrErrorType.CLIENT_ERROR, -1004, r104.getMessage(), r104.toString()));
        L19:
            return (c) r103;
        L9:
            r102 = new c.C6620c(new kw5.a(Arrays.copyOf(this.f289746c, r101), r101));     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            Result.Companion r106 = Result.Companion;
            r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L14
        L5:
            return c.a.f506397a;
        }

        @Override // kw5.d
        public final void close() {
            if (this.f289747d == false) goto L5;
            return;
        L5:
            this.f289747d = true;
            Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L8
            this.f289745b.close();     // Catch: Throwable -> L8
            Object r101 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        L10:
            Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
            if (r102 == null) goto L16;
            c68.b.c("AsrFileAudioDataProvider", "close file audio data failed", r102);
            return;
        L16:
            return;
        L8:
            th = move-exception;
            Result.Companion r103 = Result.Companion;
            r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L10
        }

        public a(BufferedInputStream r100) {
            Intrinsics.checkNotNullParameter(r100, "inputStream");
            this.f289745b = r100;
            this.f289746c = new byte[ErrorCode.Memory.ERROR_UPDATE_BUT_TYPE_NOT_SUPPORT];
        }
    }

    public static final class b {
        public b() {
        }

        public static final hw5.a a(FlowAsrErrorType r100, int r101, String r102, String r103) {
            int r104 = AsrFileAudioDataProvider.f289744b;
            if (r102 != null) goto L5;
        L9:
            r102 = "ASR file data error, code=" + r101;
        L11:
            if (StringsKt.isBlank(r103) == false) goto L14;
            r103 = "code=" + r101 + ",message=" + r102;
        L14:
            return new hw5.a(r100, r102, r101, r103);
        L5:
            if ((!StringsKt.isBlank(r102)) == true) goto L8;
            r102 = null;
        L8:
            if (r102 != null) goto L11;
            goto L9
        }
    }

    static {
        new b();
    }

    public AsrFileAudioDataProvider() {
    }

    @Override // com.bytedance.flow_audio.api.business.asr.source.FlowAsrFileAudioDataProvider
    public final kw5.b D2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "filePath");
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == false) goto L5;
        long r102 = r101.length();
        if (r102 <= 0) goto L9;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L12
        Object r104 = Result.m9449constructorimpl(new kw5.b.C6619b(new a(new BufferedInputStream(new PolarisFileInputStreamWrapper(r101)))));     // Catch: Throwable -> L12
    L14:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L19;
        int r106 = c68.b.f22600a;
        c68.b.c("AsrFileAudioDataProvider", "open file audio data failed path=" + r100, r105);
        r104 = new kw5.b.a(b.a(FlowAsrErrorType.CLIENT_ERROR, -1002, r105.getMessage(), r105.toString()));
    L19:
        return (kw5.b) r104;
    L12:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L9:
        return new kw5.b.a(b.a(FlowAsrErrorType.CLIENT_ERROR, -1004, "ASR retry file is empty", "fileLength=" + r102));
    L5:
        return new kw5.b.a(b.a(FlowAsrErrorType.SOURCE_PREPARE_FAILED, -1001, "ASR retry file not found", "fileExists=false"));
    }
}
