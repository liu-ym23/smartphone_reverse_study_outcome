package yg8;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;
import t19.s;

/* JADX INFO: loaded from: classes25.dex */
public final class f implements IIMCallback<Boolean> {
    public f() {
    }

    @Override // com.larus.im.callback.IIMCallback
    public final boolean mustInMain() {
        return true;
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onFailure(IIMError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        s r101 = s.f544207a;
        Application r102 = AppHost.f326268a.getApplication();
        r101.getClass();
        s.s(r102, R.string.larus_edit_chat_name_failed);
    }

    @Override // com.larus.im.callback.IIMCallback
    public final /* bridge */ /* synthetic */ void onSuccess(Boolean r100) {
        r100.booleanValue();
    }
}
