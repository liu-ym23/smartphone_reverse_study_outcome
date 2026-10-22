package com.ss.android.lark.image.impl.preload;

import com.bytedance.apm.core.ActivityLifeObserver;
import com.larksuite.framework.utils.NetworkUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.json.JSONObject;
import xwa.b;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/image/impl/preload/ImagePreloadMonitor;", "", "<init>", "()V", "TAG", "", "EVENT_KEY_IMAGE_PRELOAD", "onPreloadFinish", "", "isSuccess", "", "latency", "", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImagePreloadMonitor {
    public static final ImagePreloadMonitor INSTANCE = null;

    static {
        INSTANCE = new ImagePreloadMonitor();
    }

    private ImagePreloadMonitor() {
    }

    @JvmStatic
    public static final void onPreloadFinish(boolean r100, int r101) {
        boolean r102 = NetworkUtils.d(LarkContext.getApplication());
        boolean r103 = ActivityLifeObserver.getInstance().isForeground();
        boolean r104 = ((b) k.a(LarkContext.getApplication(), b.class)).a();
        if (r100 == false) goto L5;
        String r105 = "success";
    L6:
        String r106 = "1";
        if (r102 == false) goto L9;
        Object r107 = "1";
    L10:
        if (r103 == false) goto L12;
        Object r108 = "1";
    L13:
        if (r104 == true) goto L16;
        r106 = "0";
    L16:
        JSONObject r109 = new JSONObject().put("result", r105).put("latency", r101).put("net_state", r107).put("app_is_front", r108).put("is_in_doze", r106);
        Log.i("ImagePreloadMonitor", "onPreloadFinish, params:" + r109);
        Statistics.sendEvent("image_preload_result_dev", r109);
        return;
    L12:
        r108 = "0";
        goto L13
    L9:
        r107 = "0";
        goto L10
    L5:
        r105 = "failed";
        goto L6
    }
}
