package kg2;

import android.os.Bundle;
import com.bytedance.android.livesdk.chatroom.utils.f0;
import com.bytedance.android.livesdk.live.f;
import com.bytedance.android.livesdk.viewmodel.MergeDrawerViewModel;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public final Bundle a;
    public final Bundle b;
    public final String c;
    public final String d;
    public final f0 e;
    public final boolean f;
    public final a g;
    public final MergeDrawerViewModel h;
    public final Room i;
    public final f j;
    public final boolean k;

    public final String toString() {
        StringBuilder r0 = new StringBuilder("roomArgs= ");
        r0.append(this.a.hashCode());
        r0.append(", enterExtra= ");
        Bundle r1 = this.b;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L6:
        r0.append(r2);
        r0.append(", enterFromMerge= ");
        r0.append(this.c);
        r0.append(", enterMethod= ");
        r0.append(this.d);
        r0.append(", preload = ");
        r0.append(this.f);
        r0.append(", isSingleRoomDrawFeed = ");
        r0.append(this.k);
        r0.append(", innerDrawData = ");
        r0.append(this.e);
        return r0.toString();
    L5:
        r2 = 0;
        goto L6
    }

    public c(Bundle r2, Bundle r3, String r4, String r5, f0 r6, boolean r7, a r8, MergeDrawerViewModel r9, Room r10, f r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r2, "roomArgs");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
    }
}
