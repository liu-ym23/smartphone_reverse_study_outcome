package om8;

import android.content.Context;
import com.larus.bmhome.chat.standarduikit.miaodaartifact.viewmodel.MiaodaArtifactVMData;
import com.larus.platform.service.LarkConnectorArtifactService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a implements nm8.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f524310a;

    public final void b() {
        MiaodaArtifactVMData r100 = this.f524310a.f524311a;
        if (r100 != null) goto L6;
        return;
    L6:
        if (LarkConnectorArtifactService.f365709a.c(r100.f309528a) == false) goto L8;
        return;
    L8:
        String r101 = r100.f309529b;
        if (r101 != null) goto L11;
        return;
    L11:
        if (r101.length() <= 0) goto L13;
        boolean r102 = true;
    L14:
        if (r102 == true) goto L17;
        r101 = null;
    L17:
        if (r101 == null) goto L23;
        c r103 = this.f524310a.f524312b;
        if (r103 == null) goto L24;
        r103.b(r101);
        return;
    L24:
        return;
    L23:
        return;
    L13:
        r102 = false;
        goto L14
    }

    public a(b r100) {
        this.f524310a = r100;
    }

    @Override // nm8.d
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        b r101 = this.f524310a;
        MiaodaArtifactVMData r102 = r101.f524311a;
        if (r102 == null) goto L8;
        c r103 = r101.f524312b;
        if (r103 == null) goto L9;
        r103.a(r100, r102);
        return;
    L9:
        return;
    }
}
