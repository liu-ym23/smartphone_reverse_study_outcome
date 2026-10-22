package com.larus.bmhome.chat.zoom;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import jc8.a;
import kotlin.Metadata;
import so8.c;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H&J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/chat/zoom/IZoomInAnimationProvider;", "", "blockBizModelClassName", "", "isSupport", "", "blockBizModel", "Lcom/larus/bmhome/chat/block/base/BaseBlockBizModel;", "supportContext", "Lcom/larus/bmhome/chat/zoom/SupportContext;", "getAnimationID", "getAnimationView", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "bindAnimationView", "", "view", "providerBindContext", "Lcom/larus/bmhome/chat/zoom/ProviderBindContext;", "onRecycle", "getAnimationAction", "Lcom/larus/bmhome/chat/zoom/ZoomInAnimationAction;", "getAnimationConfig", "Lcom/larus/bmhome/chat/zoom/ZoomInAnimationConfig;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IZoomInAnimationProvider {
    String a(a r100);

    c b(a r100);

    View c(Context r100, a r101);

    void d(View r100, a r101);

    void e(View r100);

    ZoomInAnimationAction f(a r100);

    boolean g(a r100, so8.a r101);

    String h();
}
