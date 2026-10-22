package rh8;

import android.text.Spanned;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.bmhome.chat.markdown.videogroup.VideoGroupV2Widget;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements com.larus.business.markdown.api.depend.a {
    public c() {
    }

    @Override // com.larus.business.markdown.api.depend.a
    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "dataType");
        return Intrinsics.areEqual("video-group-v2", r100);
    }

    @Override // com.larus.business.markdown.api.depend.a
    public final usc.f b(FrameLayout r100, TextView r101, Spanned r102, usc.e r103, Map<String, ? extends Object> r104) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "textView");
        Intrinsics.checkNotNullParameter(r102, "text");
        Intrinsics.checkNotNullParameter(r103, "span");
        return new VideoGroupV2Widget(r100.getContext(), null);
    }
}
