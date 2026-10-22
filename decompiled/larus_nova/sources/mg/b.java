package mg;

import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes43.dex */
public final class b {
    public static final CoroutineScope a(QViewModel r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$viewModelScope");
        CoroutineScope r101 = (CoroutineScope) r100.getTag("QViewModel.JOB_KEY");
        if (r101 == null) goto L6;
        return r101;
    L6:
        return (CoroutineScope) r100.setTagIfAbsent("QViewModel.JOB_KEY", new a(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain())));
    }
}
