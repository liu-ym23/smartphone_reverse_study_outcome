package rob;

import android.view.View;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.VoiceMoreActionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class m implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VoiceMoreActionAdapter f538823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f538824b;

    public m(VoiceMoreActionAdapter r100, g r101) {
        this.f538823a = r100;
        this.f538824b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        d r101 = this.f538823a.f430183b;
        if (r101 == null) goto L6;
        Object r102 = this.f538824b.a();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.AsrLanguageData");
        r101.d((b) r102);
        return;
    }
}
