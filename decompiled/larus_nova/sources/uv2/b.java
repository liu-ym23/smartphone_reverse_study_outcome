package uv2;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.model.ExpressionSection;
import com.bytedance.android.livesdk.model.h;
import com.bytedance.android.livesdk.widget.board.k;
import com.bytedance.android.livesdk.widget.ui.subscribe.SubscribeSelectPanel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f551799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f551800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f551801c;

    @Override // com.bytedance.android.livesdk.model.h
    public final void getPageCount() {
    }

    @Override // com.bytedance.android.livesdk.model.h
    public final String getPageName() {
        return "unknown";
    }

    @Override // com.bytedance.android.livesdk.model.h
    public final ExpressionSection b() {
        return this.f551799a;
    }

    @Override // com.bytedance.android.livesdk.model.h
    public final View a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new SubscribeSelectPanel(r100, this.f551801c);
    }

    public b(boolean r100, String r101) {
        this.f551800b = r100;
        this.f551801c = r101;
        c r102 = new c(r101);
        if (l42.a.f507337x.getValue().intValue() >= 3) goto L5;
        boolean r103 = true;
    L6:
        r102.f(r103);
        Unit r104 = Unit.INSTANCE;
        this.f551799a = r102;
        return;
    L5:
        r103 = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.model.h
    public final k c(Context r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "pageView");
        return new a(r101, this.f551800b);
    }
}
