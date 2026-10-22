package kqc;

import android.content.res.Resources;
import com.volcengine.zeus.Zeus;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes41.dex */
public final class c implements Function0<Resources> {
    @Override // kotlin.jvm.functions.Function0
    public final Resources invoke() {
        return Zeus.getAppApplication().getResources();
    }

    public c() {
    }
}
