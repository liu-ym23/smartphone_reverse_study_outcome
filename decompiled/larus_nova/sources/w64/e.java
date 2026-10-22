package w64;

import android.text.TextUtils;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.pseudo.interfaces.IMobileResultCallback;
import com.bytedance.badger.collect.impl.pseudo.model.PseudoCodeResult;
import com.bytedance.badger.collect.impl.utils.KLog;
import com.bytedance.badger.network.d0;
import com.bytedance.badger.network.z0;
import java.util.Objects;

/* JADX INFO: loaded from: classes47.dex */
public final class e implements IMobileResultCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f558421a;

    public e(h r100) {
        this.f558421a = r100;
    }

    @Override // com.bytedance.badger.collect.impl.pseudo.interfaces.IMobileResultCallback
    public final void onComplete(Object r100) {
        PseudoCodeResult r101 = (PseudoCodeResult) r100;
        if (Objects.equals(r101.errorCode, Constants.StatusCode.SUCCESS) == true) goto L5;
    L7:
        KLog.w(Constants.TAGS.INIT, "network change error: " + r101.errorMsg);
        return;
    L5:
        if (TextUtils.isEmpty(r101.data) == true) goto L7;
        z0 r102 = d0.f199093a;
        d0.b(23, z64.h.b.f570472a, new d(this), true);
    }
}
