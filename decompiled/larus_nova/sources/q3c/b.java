package q3c;

import android.content.Context;
import android.content.Intent;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.search.doubao.chat.DoubaoChatSearchActivity;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@OfficeSDKUserScope
public final class b implements p3c.b {
    @Inject
    public b() {
    }

    @Override // p3c.b
    public final void l3(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "cxt");
        Intrinsics.checkNotNullParameter(r101, "chatID");
        Intent r102 = new Intent(r100, DoubaoChatSearchActivity.class);
        r102.putExtra("chat_id", r101);
        r100.startActivity(r102);
    }
}
