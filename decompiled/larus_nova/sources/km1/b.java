package km1;

import com.bytedance.android.livesdk.chatroom.x;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements x<String, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f504046a;

    @Override // com.bytedance.android.livesdk.chatroom.x
    public final void clear() {
        ((HashMap) this.f504046a).clear();
    }

    public b() {
        this.f504046a = new HashMap();
    }

    @Override // com.bytedance.android.livesdk.chatroom.x
    public final String get(String r100) {
        String r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "key");
        return (String) ((HashMap) this.f504046a).get(r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.x
    public final void put(String r100, String r101) {
        String r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "key");
        HashMap r103 = (HashMap) this.f504046a;
        r103.put(r102, r101);
    }
}
