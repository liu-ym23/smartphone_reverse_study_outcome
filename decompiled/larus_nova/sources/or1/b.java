package or1;

import com.bytedance.android.livehostapi.foundation.depend.OnBindPhoneListener;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements OnBindPhoneListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f524914a;

    public b(Function1 r100) {
        this.f524914a = r100;
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.OnBindPhoneListener
    public final void onBindPhone(boolean r100) {
        this.f524914a.invoke(Boolean.valueOf(r100));
    }
}
