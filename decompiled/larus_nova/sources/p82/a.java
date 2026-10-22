package p82;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.bytedance.android.live.base.model.message.i4;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums.PanelItemSymbol;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class a implements com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f528070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.api.entity.l f528071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.e f528072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PanelItemSymbol f528073d;

    /* JADX INFO: renamed from: p82.a$a, reason: collision with other inner class name */
    public static final class C7160a {
    }

    static {
    }

    public abstract int e();

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public void onDestroyView() {
        this.f528070a = null;
    }

    public final String d() {
        com.bytedance.android.livesdk.interactivity.api.entity.l r100 = this.f528071b;
        if (r100 == null) goto L5;
        com.bytedance.android.live.base.model.message.t r101 = r100.f133174b;
    L7:
        if ((r101 instanceof i4) == false) goto L9;
        return "reply";
    L9:
        return "create";
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final PanelItemSymbol a() {
        return this.f528073d;
    }

    public a(PanelItemSymbol r100) {
        Intrinsics.checkNotNullParameter(r100, "symbol");
        this.f528073d = r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final View getView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (this.f528070a != null) goto L8;
        View r101 = LayoutInflater.from(r100).inflate(e(), null);
        this.f528070a = r101;
        if (r101 == null) goto L8;
        r101.setTag(this.f528073d);
    L8:
        return this.f528070a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public void onClick(View r100) {
        Map r101 = MapsKt.mapOf(TuplesKt.to("event_user_type", d()));
        int r102 = com.bytedance.android.livesdk.interactivity.utils.r.f141414a;
        long r103 = this.f528073d.getId();
        RoomContext r104 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r104 == null) goto L9;
        com.bytedance.live.datacontext.i<Boolean> r105 = r104.isAnchor();
        if (r105 == null) goto L9;
        boolean r106 = true;
        if (r105.getValue().booleanValue() != true) goto L9;
    L10:
        com.bytedance.android.livesdk.interactivity.utils.r.a(r103, r106, r101);
        return;
    L9:
        r106 = false;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public void c(com.bytedance.android.livesdk.interactivity.api.entity.l r100, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.e r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "bridge");
        this.f528071b = r100;
        this.f528072c = r101;
    }
}
