package vcb;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.ss.android.lark.chatwindow.view.preview.g;
import com.ss.android.lark.export.params.URLPreviewParams;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d extends r6c.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleOwner f554142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f554143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final URLPreviewParams f554144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public bdb.a f554145e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f554146f;

    public /* synthetic */ d(Context r100, LifecycleOwner r101, URLPreviewParams r110) {
        this(r100, r101, null, r110, null, false);
    }

    public d(Context r100, LifecycleOwner r101, g r102, URLPreviewParams r103, bdb.a r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "urlPreviewParams");
        super(r100);
        this.f554142b = r101;
        this.f554143c = r102;
        this.f554144d = r103;
        this.f554145e = r104;
        this.f554146f = r105;
    }
}
