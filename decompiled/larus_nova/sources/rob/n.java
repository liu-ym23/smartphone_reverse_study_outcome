package rob;

import android.view.View;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.VoiceMoreActionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class n implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VoiceMoreActionAdapter f538825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f538826b;

    public n(VoiceMoreActionAdapter r100, g r101) {
        this.f538825a = r100;
        this.f538826b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        d r101 = this.f538825a.f430183b;
        if (r101 == null) goto L6;
        Object r102 = this.f538826b.a();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.IconWithTitleData");
        r101.a((e) r102);
        return;
    }
}
