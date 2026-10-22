package o88;

import com.larus.avatar.impl.scan.statemachine.ScanMessageType;
import com.larus.avatar.impl.scan.view.ScanErrorType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class b extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ScanErrorType f522391b;

    public b(ScanErrorType r100) {
        Intrinsics.checkNotNullParameter(r100, "errorType");
        super(ScanMessageType.FAIL);
        this.f522391b = r100;
    }
}
