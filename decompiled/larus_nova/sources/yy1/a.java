package yy1;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.livesdk.gift.guide.view.CommentGiftGuideView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements h12.a {
    public a() {
    }

    @Override // h12.a
    public final CommentGiftGuideView a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        return new CommentGiftGuideView(r100, r101, 6, 0);
    }
}
