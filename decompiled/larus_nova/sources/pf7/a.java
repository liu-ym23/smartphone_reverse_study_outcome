package pf7;

import android.media.AudioRecord;
import com.bytedance.supervisor.token.AtomicInfoDef;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lf7.d;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f528872a = null;

    static {
        f528872a = new a();
    }

    public a() {
    }

    @Override // pf7.c
    public final void b(AudioRecord r100, Token r101) throws SensitiveAPIException {
        Intrinsics.checkNotNullParameter(r100, "record");
        Intrinsics.checkNotNullParameter(r101, "token");
        rf7.a.a(r101, new of7.b(CollectionsKt.listOf(AtomicInfoDef.AUDIO_RECORD_START_RECORDING)));
        lf7.b r102 = d.f509087a;
        Intrinsics.checkNotNullParameter(this, "this");
        lf7.a r103 = d.a("audio_record");
        if ((r103 instanceof c) == false) goto L5;
        c r104 = (c) r103;
    L6:
        r104.b(r100, r101);
        return;
    L5:
        r104 = new b();
        goto L6
    }
}
