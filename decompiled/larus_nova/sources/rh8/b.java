package rh8;

import android.text.Spanned;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.bmhome.chat.markdown.EmptyWidget;
import com.larus.bmhome.chat.standarduikit.videogroup.binder.RelatedVideoBinder;
import com.larus.im.bean.message.ContainerAttribute;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.RichMediaMeta;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements com.larus.business.markdown.api.depend.a {
    public b() {
    }

    @Override // com.larus.business.markdown.api.depend.a
    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "dataType");
        return Intrinsics.areEqual("video-group", r100);
    }

    public static usc.f c(FrameLayout r100, int r101, int r102) {
        if (r101 <= 0) goto L10;
        if (r102 <= 0) goto L10;
        if (r101 <= r102) goto L12;
        return new RelatedVideoBinder(r100.getContext(), true);
    L12:
        return new RelatedVideoBinder(r100.getContext(), false);
    L10:
        return new EmptyWidget(r100.getContext(), null, 6, 0);
    }

    @Override // com.larus.business.markdown.api.depend.a
    public final usc.f b(FrameLayout r100, TextView r101, Spanned r102, usc.e r103, Map<String, ? extends Object> r104) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "textView");
        Intrinsics.checkNotNullParameter(r102, "text");
        Intrinsics.checkNotNullParameter(r103, "span");
        if (r104 == null) goto L5;
        fh8.f r105 = fh8.h.b(r104);
    L6:
        if (r105 == null) goto L8;
        Message r106 = r105.f477072b;
    L10:
        if (o0.d(r103.k()) == false) goto L15;
        if (r106 == null) goto L13;
        String r107 = r106.getMessageId();
    L14:
        RichMediaMeta r108 = wc8.b.f559187a.h(r107, r103.k(), "ViewGroupBinder");
    L17:
        if (r108 == null) goto L21;
        ContainerAttribute r109 = r108.getContainerAttribute();
        if (r109 == null) goto L21;
        boolean r110 = Intrinsics.areEqual(r109.isMixedVideo(), Boolean.TRUE);
    L22:
        if (r110 == true) goto L24;
        int r111 = -1;
        if (r108 == null) goto L59;
        ContainerAttribute r112 = r108.getContainerAttribute();
        if (r112 == null) goto L32;
        Long r113 = r112.videoHeight;
        if (r113 == null) goto L32;
        int r114 = (int) r113.longValue();
    L33:
        ContainerAttribute r115 = r108.getContainerAttribute();
        if (r115 == null) goto L39;
        Long r116 = r115.videoWidth;
        if (r116 == null) goto L39;
        r111 = (int) r116.longValue();
    L39:
        return c(r100, r114, r111);
    L32:
        r114 = -1;
        goto L33
    L59:
    L56:
        e = move-exception;
        FLogger.f375446a.e("VideoGroupDataHandler", "getWidget called, " + e.getMessage());
        return new EmptyWidget(r100.getContext(), null, 6, 0);
    L41:
        if (r103.k().length() != 0) goto L43;
        boolean r117 = true;
    L44:
        if (r117 == false) goto L46;
        String r118 = r103.h();     // Catch: Exception -> L56
    L53:
        JSONObject r119 = new JSONObject(r118);     // Catch: Exception -> L56
        return c(r100, r119.optInt("video_height", -1), r119.optInt("video_width", -1));
    L46:
        if (r106 == null) goto L52;
        wc8.b r120 = wc8.b.f559187a;     // Catch: Exception -> L56
        String r121 = r106.getMessageId();     // Catch: Exception -> L56
        if (r121 != null) goto L50;
        r121 = "";
    L50:
        r118 = r120.c(r121, r103.k(), "VideoGroupDataHandler");     // Catch: Exception -> L56
        if (r118 != null) goto L53;
    L52:
        r118 = wc8.b.f559187a.b(r103.k(), "VideoGroupDataHandler");     // Catch: Exception -> L56
        goto L53
    L43:
        r117 = false;
        goto L44
    L24:
        return new com.larus.bmhome.chat.standarduikit.videogroup.binder.e(r100.getContext());
    L21:
        r110 = false;
        goto L22
    L13:
        r107 = null;
        goto L14
    L15:
        r108 = null;
        goto L17
    L8:
        r106 = null;
        goto L10
    L5:
        r105 = null;
        goto L6
    }
}
