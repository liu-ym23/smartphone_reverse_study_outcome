package v2a;

import com.larus.voice_setting.voice.mix.SingleVoiceBar;
import com.larus.voice_setting.voice.mix.VoiceSingleView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class h implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f552746a;

    public /* synthetic */ h(Function0 r100) {
        this.f552746a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        Function0 r101 = this.f552746a;
        int r102 = SingleVoiceBar.f376897b;
        Intrinsics.checkNotNullParameter((VoiceSingleView) r100, "it");
        r101.invoke();
        return Unit.INSTANCE;
    }
}
