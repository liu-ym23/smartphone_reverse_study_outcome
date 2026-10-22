package k4b;

import com.ss.android.lark.chat.entity.message.Pin;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements Function1<f5b.b, Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f501772a;

    public d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "chatterId");
        this.f501772a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(f5b.b r100) {
        f5b.b r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "chatMessage");
        Pin r102 = r101.getPin();
        if (r102 == null) goto L8;
        if (Intrinsics.areEqual(r102.getOperatorId(), this.f501772a) == false) goto L8;
        return Boolean.TRUE;
    L8:
        return Boolean.FALSE;
    }
}
