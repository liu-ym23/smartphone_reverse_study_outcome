package r80;

import android.content.Context;
import android.os.Build;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class h implements com.bytedance.android.live.core.utils.screen.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f536497a = null;

    public h() {
    }

    static {
        f536497a = Arrays.asList(new String[]{"ONEPLUS A6000"});
    }

    @Override // com.bytedance.android.live.core.utils.screen.a
    public final boolean b(Context r100) {
        return f536497a.contains(Build.MODEL);
    }
}
