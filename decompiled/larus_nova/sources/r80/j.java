package r80;

import android.content.res.Configuration;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.sysoptimizer.SmEditTextLeakOpt;
import j40.o2;
import java.util.List;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class j implements com.bytedance.android.live.core.utils.screen.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f536500a;

    @Override // com.bytedance.android.live.core.utils.screen.b
    public final boolean isFoldScreen() {
        if (StringsKt.equals(SmEditTextLeakOpt.SAMSUNG, Build.BRAND, true) == true) goto L5;
    L7:
        String r100 = Build.MODEL;
        if (TextUtils.isEmpty(r100) == false) goto L10;
    L18:
        return false;
    L10:
        if (StringsKt.startsWith$default(r100, "SM-F9", false, 2, null) == false) goto L12;
    L17:
        return true;
    L12:
        if (StringsKt.startsWith$default(r100, "SM-W202", false, 2, null) == true) goto L17;
        if (StringsKt.startsWith$default(r100, "SM-W90", false, 2, null) == true) goto L17;
        if (this.f536500a.contains(r100) == false) goto L18;
    L5:
        if (StringsKt.equals("winner", Build.DEVICE, true) == false) goto L7;
        return true;
    }

    public j() {
        this.f536500a = (List) o2.f497275a.getValue();
    }

    @Override // com.bytedance.android.live.core.utils.screen.b
    public final int a(Configuration r100) {
        if (r100 != null) goto L6;
        return -1;
    L6:
        if (isFoldScreen() == true) goto L8;
        return -1;
    L8:
        float r101 = (r100.screenHeightDp * 1.0f) / r100.screenWidthDp;
        ALogger.d("ttlive_ratio", new i(r100, r101));
        if (r101 >= 0.75f) goto L11;
        return -1;
    L11:
        if (r101 > 1.5f) goto L15;
        return 0;
    L15:
        return -1;
    }
}
