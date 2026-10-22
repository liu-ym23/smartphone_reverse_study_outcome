package ida;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.cocreationreview.s3;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f489408a = null;

    static {
        f489408a = new d();
    }

    public d() {
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "recordId");
        if ((!StringsKt.isBlank(r100)) == true) goto L6;
        r100 = null;
    L6:
        if (r100 != null) goto L8;
        return;
    L8:
        Context r101 = AppHost.f326268a.getApplication().getApplicationContext();
        Intent r102 = new Intent();
        r102.setClassName("com.obric.recorder", "com.bytedanceos.recorder.activity.RecorderPlayActivity");
        r102.putExtra("RECORD_URI", r100);
        r102.setFlags(268468224);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        r101.startActivity(r102);     // Catch: Throwable -> L11
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L14:
        if (Result.m9456isSuccessimpl(r104) == false) goto L16;
        Unit r105 = (Unit) r104;
        int r106 = s3.f387719a;
        s3.b("audio_memory_original_record", "open recordId=".concat(r100));
    L16:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r104);
        if (r107 == null) goto L22;
        int r108 = s3.f387719a;
        s3.c("audio_memory_original_record", "open failed recordId=" + r100 + " error=" + r107.getMessage());
        Toast.makeText(r101, "原始录音暂不可用", 0).show();
        return;
    L22:
        return;
    L11:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }
}
