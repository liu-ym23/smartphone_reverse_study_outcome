package v2a;

import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.voice_setting.voice.mix.VoiceMixBar;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class t implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VoiceMixBar f552762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f552763b;

    public /* synthetic */ t(VoiceMixBar r100, Function0 r101) {
        this.f552762a = r100;
        this.f552763b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        VoiceMixBar r101 = this.f552762a;
        Function0 r102 = this.f552763b;
        int r103 = VoiceMixBar.f376909h;
        Intrinsics.checkNotNullParameter((AppCompatImageView) r100, "it");
        AppBarLayout r104 = r101.f376913d;
        if (r104 == null) goto L5;
        r104.setExpanded(true);
    L5:
        r102.invoke();
        return Unit.INSTANCE;
    }
}
