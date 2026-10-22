package j62;

import com.bytedance.android.livesdk.interactivity.common.utils.LimitQueue;
import com.bytedance.android.livesdk.interactivity.service.messagelist.c;
import com.bytedance.android.livesdk.interactivity.service.messagelist.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LimitQueue f497490a;

    public a() {
        this.f497490a = new LimitQueue(50);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.d
    public final boolean a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        long r101 = r100.getId();
        boolean r102 = r100 instanceof i62.a;
        boolean r103 = true;
        if (r102 == true) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == false) goto L10;
        return true;
    L10:
        long r105 = r100.getId();
        if (r102 == false) goto L17;
        i62.a r106 = (i62.a) r100;
        if (r106.f() == false) goto L15;
    L18:
        if (r103 == true) goto L20;
        return false;
    L20:
        if (r105 == (-1)) goto L25;
        this.f497490a.add(Long.valueOf(r105));
        return false;
    L25:
        return false;
    L15:
        if (r106.f488360a == true) goto L18;
    L17:
        r103 = false;
        goto L18
    L5:
        if (this.f497490a.contains(Long.valueOf(r101)) == false) goto L7;
        r104 = true;
        goto L8
    }
}
