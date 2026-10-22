package nx1;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.android.live.base.model.feedback.Question;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kx1.c;

/* JADX INFO: loaded from: classes8.dex */
public abstract class a<T extends c> extends FrameLayout implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Question f521036a;

    public abstract lx1.b<T> getOptionFactory();

    public abstract /* synthetic */ String getSelectResult();

    public abstract /* synthetic */ String getSelectToast();

    public abstract /* synthetic */ Long getSubQuestionId();

    public final List<T> a() {
        return getOptionFactory().a(this.f521036a.options);
    }

    public final Question getQuestion() {
        return this.f521036a;
    }

    public a(Context r100, Question r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.VALUE_QUESTION);
        super(r100, null, 0);
        this.f521036a = r101;
    }
}
