package mw2;

import com.bytedance.android.livesdkapi.distribution.externalinjectcomponent.IRoomInfoProvider;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements IRoomInfoProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataCenter f515924a;

    public b(DataCenter r100) {
        this.f515924a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.distribution.externalinjectcomponent.IRoomInfoProvider
    public final <T> T get(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r100.hashCode() == 1379893381) goto L6;
        return null;
    L6:
        if (r100.equals("room_uv") == false) goto L16;
        DataCenter r101 = this.f515924a;
        if (r101 == null) goto L10;
        Object r102 = r101.get("data_member_count");
    L12:
        if ((r102 instanceof Object) == true) goto L15;
        return null;
    L15:
        return (T) r102;
    L10:
        r102 = null;
        goto L12
    L16:
        return null;
    }
}
