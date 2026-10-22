package nc0;

import com.bytedance.android.live.anchorlink.network.model.MultiChannelData;
import com.bytedance.android.livesdk.link.model.bridge.r1;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements Function1<r1, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f518602a;

    public a(Function1 r100) {
        this.f518602a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(r1 r100) {
        r1 r101 = r100;
        Function1 r102 = this.f518602a;
        if (r101 == null) goto L5;
        vh7.c r103 = k.a(r101);
    L6:
        r102.invoke((MultiChannelData) r103);
        return Unit.INSTANCE;
    L5:
        r103 = null;
        goto L6
    }
}
