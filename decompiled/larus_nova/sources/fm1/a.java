package fm1;

import com.bytedance.android.livesdk.chatroom.vs_base.base.api.b;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<? extends com.bytedance.android.livesdk.chatroom.vs_base.base.api.a>, com.bytedance.android.livesdk.chatroom.vs_base.base.api.a> f477775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f477776b;

    public a() {
        this.f477775a = new LinkedHashMap();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.api.b
    public final boolean isDestroyed() {
        return this.f477776b;
    }

    public final void a(com.bytedance.android.livesdk.chatroom.vs_base.base.api.a... r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        com.bytedance.android.livesdk.chatroom.vs_base.base.api.a r103 = r100[r102];
        this.f477775a.put((Class<? extends com.bytedance.android.livesdk.chatroom.vs_base.base.api.a>) r103.getClass(), r103);
        Intrinsics.checkNotNullParameter(this, "<set-?>");
        r103.f117880a = this;
        r102 = r102 + 1;
        goto L3
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.api.b
    public final void start(Class<? extends com.bytedance.android.livesdk.chatroom.vs_base.base.api.a> r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Intrinsics.checkNotNullParameter(r101, "extra");
        if (this.f477775a.containsKey(r100) == true) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.chatroom.vs_base.base.api.a r102 = (com.bytedance.android.livesdk.chatroom.vs_base.base.api.a) ((LinkedHashMap) this.f477775a).get(r100);
        if (r102 == null) goto L9;
        r102.b(r101);
        return;
    }
}
