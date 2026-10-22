package tv2;

import com.bytedance.android.livesdk.interactivity.api.expression.i;
import com.bytedance.android.livesdk.model.ExpressionSection;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c extends ExpressionSection {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f547669c;

    @Override // com.bytedance.android.livesdk.model.ExpressionSection
    public final /* bridge */ /* synthetic */ CharSequence c() {
        return "小表情";
    }

    @Override // com.bytedance.android.livesdk.model.ExpressionSection
    public final int b() {
        return this.f547669c;
    }

    public c(i r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        int r101 = r100.f133219e;
        if (r101 != 0) goto L5;
        r101 = R.drawable.ttlive_ic_emoji_section;
    L5:
        this.f547669c = r101;
    }
}
