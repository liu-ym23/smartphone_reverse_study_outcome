package j7b;

import com.ss.android.lark.chat.entity.Channel;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.im.sdk.service.z;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements d {
    public b() {
    }

    @Override // j7b.d
    public final void a(Channel r100, int r101, int r102, boolean r103) {
        Log.i("chatwindow", "clear Badge, channel: " + r100 + " maxPosition: " + r101);
        z.a r104 = new z.a();
        r104.a(r100);
        r104.b(new ArrayList());
        ArrayList r105 = new ArrayList();
        Intrinsics.checkNotNullParameter(r105, "foldIds");
        r104.f426128c = r105;
        r104.f426129d = r101;
        r104.f426130e = r102;
        r104.f426132g = r103;
        ImSdkService.f().yb(new z(r104));
    }
}
