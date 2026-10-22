package com.bytedance.gkfs.io;

import com.bytedance.gkfs.UtilsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.UByte;
import kotlin.jvm.functions.Function2;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes19.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f245210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function2 f245211b;

    public h(g r100, Function2 r101) {
        this.f245210a = r100;
        this.f245211b = r101;
    }

    public final void a() {
        if (UtilsKt.d() == false) goto L5;
        com.bytedance.gkfs.c.b(this.f245210a.f245209h, "ChunkMetaDecoder", "start parallel decode, chunk count:" + this.f245210a.f245208g + ", fetchIndex=" + this.f245210a.f245205d, 0, false, 12);
    L5:
        g r100 = this.f245210a;
        int r101 = r100.f245207f.length - 44;
        int r102 = r100.f245208g;
    L6:
        r102 = r102 - 1;
        if (r102 < 0) goto L34;
        if (this.f245210a.f245203b.get() == true) goto L10;
        if (r102 <= this.f245210a.f245205d) goto L31;
        if (this.f245210a.f245203b.get() == true) goto L31;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L21
        byte[] r104 = this.f245210a.f245207f;     // Catch: Throwable -> L21
        StringBuilder r105 = new StringBuilder(40);     // Catch: Throwable -> L21
        int r106 = 0;
    L17:
        if (r106 >= 40) goto L19;
        r105.append((char) (r104[r101 + r106] & UByte.MAX_VALUE));     // Catch: Throwable -> L21
        r106 = r106 + 1;     // Catch: Throwable -> L21
        goto L17
    L19:
        c r107 = new c(r105.toString());     // Catch: Throwable -> L21
        int r108 = q.a(this.f245210a.f245207f, r101 + 40);     // Catch: Throwable -> L21
        r101 = r101 - 44;     // Catch: Throwable -> L21
        Object r109 = Result.m9449constructorimpl(new f(r107, ((long) r108) & BodyPartID.bodyIdMax));     // Catch: Throwable -> L21
    L24:
        if (Result.m9456isSuccessimpl(r109) == false) goto L26;
        this.f245210a.f245204c.put(Integer.valueOf(r102), (f) r109);
    L26:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L29;
        com.bytedance.gkfs.c.c(this.f245210a.f245209h, "ChunkMetaDecoder", "parallel decode error, cause:" + r110.getMessage(), r110, false, 20);
        this.f245210a.close();
    L29:
        ResultKt.throwOnFailure(r109);
        this.f245211b.invoke(Integer.valueOf(r102), (f) r109);
    L21:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L31:
        if (UtilsKt.d() == false) goto L34;
        com.bytedance.gkfs.c.b(this.f245210a.f245209h, "ChunkMetaDecoder", "quit parallel decoding, paraIndex:" + r102 + ", fetchIndex=" + this.f245210a.f245205d + ", isClosed=" + this.f245210a.f245203b.get(), 0, false, 12);
        goto L34
    L10:
        com.bytedance.gkfs.c.e(this.f245210a.f245209h, "ChunkMetaDecoder", "stop parallel decode cause closed, " + this.f245210a.f245204c.size() + " has been decoded.", 0, false, 28);
    L34:
        if (UtilsKt.d() == false) goto L46;
        com.bytedance.gkfs.c.b(this.f245210a.f245209h, "ChunkMetaDecoder", "parallel decode&IO finished", 0, false, 12);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
