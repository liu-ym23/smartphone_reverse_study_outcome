package nv2;

import android.view.View;
import com.bytedance.android.livesdk.config.ge1;
import com.bytedance.android.livesdk.widget.playertips.PlayerTipsTetris;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PlayerTipsTetris f520817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ge1 f520818b;

    public c(PlayerTipsTetris r100, ge1 r101) {
        this.f520817a = r100;
        this.f520818b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f520817a.V(this.f520818b.f120279e, 8);
        Function0<Unit> r101 = this.f520818b.f120281g;
        if (r101 == null) goto L6;
        Unit r102 = r101.invoke();
        return;
    }
}
