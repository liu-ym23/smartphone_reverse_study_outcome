package com.ss.android.lark.im.sdk.statistics;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class ImSdkChatHitPointV2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f426133a = null;

    static {
        f426133a = LazyKt.lazy(ImSdkChatHitPointV2$statistics$2.INSTANCE);
    }

    @JvmStatic
    public static final void a(String r100, String r101, Map<String, ? extends Object> r102, Map<String, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "click");
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r102, "chatParams");
        JSONObject r104 = new JSONObject(r102).put("click", r100).put(PickerReporterConstants.KEY.TARGET, r101);
        if (r103 == null) goto L8;
        Iterator<Map.Entry<String, ? extends Object>> r105 = r103.entrySet().iterator();
    L6:
        if (r105.hasNext() == false) goto L8;
        Map.Entry<String, ? extends Object> r106 = r105.next();
        r104.put(r106.getKey(), r106.getValue());
    L8:
        Log.d("ChatHitPointNew", "IM_CHAT_MAIN_CLICK, params:" + r104);
        ((o5c.b) f426133a.getValue()).sendEvent("im_chat_main_click", r104);
    }
}
