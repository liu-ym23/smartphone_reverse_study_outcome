package n10;

import android.widget.CompoundButton;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class e implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f516657a = null;

    static {
        f516657a = new e();
    }

    public e() {
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<anonymous parameter 0>");
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r102 = AnchorGameContext.a.a();
        if (r102 == null) goto L8;
        m<Boolean> r103 = r102.getOpenGamePerfPanel();
        if (r103 == null) goto L9;
        r103.setValue(Boolean.valueOf(r101));
        return;
    L9:
        return;
    }
}
