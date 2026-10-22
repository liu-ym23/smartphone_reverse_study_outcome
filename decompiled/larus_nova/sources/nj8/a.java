package nj8;

import android.content.Context;
import com.larus.bmhome.chat.standarduikit.codeartifact.viewmodel.CodeArtifactVMData;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a implements mj8.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f519461a;

    public a(b r100) {
        this.f519461a = r100;
    }

    @Override // mj8.d
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        b r101 = this.f519461a;
        CodeArtifactVMData r102 = r101.f519462a;
        if (r102 == null) goto L8;
        c r103 = r101.f519463b;
        if (r103 == null) goto L9;
        r103.a(r100, r102);
        return;
    L9:
        return;
    }
}
