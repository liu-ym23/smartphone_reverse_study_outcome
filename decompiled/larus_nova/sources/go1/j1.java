package go1;

import android.util.SparseArray;
import com.bytedance.android.livesdk.ktvapi.AbsKtvControlWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class j1 implements AbsKtvControlWidget.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.ui.framework.a f481884a;

    public j1(com.bytedance.android.livesdk.chatroom.ui.framework.a r100) {
        this.f481884a = r100;
        new SparseArray();
    }

    @Override // com.bytedance.android.livesdk.ktvapi.AbsKtvControlWidget.a
    public final void k(Widget r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        this.f481884a.Uj(r100);
    }

    @Override // com.bytedance.android.livesdk.ktvapi.AbsKtvControlWidget.a
    public final void a(AbsKtvControlWidget.WidgetType r100, Widget r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "widget");
        switch(i1.f481883a[r100.ordinal()]) {
            case 1: goto L7;
            case 2: goto L7;
            case 3: goto L7;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L6;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L11;
        };
    L5:
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C1672a.a(this.f481884a, R.id.midi_score_debug_view, r101, false, 12);
        return;
    L6:
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C1672a.b(this.f481884a, r101, 6);
        return;
    L7:
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C1672a.a(this.f481884a, R.id.ktv_container, r101, false, 12);
        return;
    }
}
