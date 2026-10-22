package oh8;

import android.text.Spanned;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.bmhome.chat.markdown.lynx.MarkdownLynxWidget;
import com.larus.common.apphost.AppHost;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements com.larus.business.markdown.api.depend.a {
    public b() {
    }

    @Override // com.larus.business.markdown.api.depend.a
    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "dataType");
        Intrinsics.checkNotNullParameter(r100, "dataType");
        if (Intrinsics.areEqual(r100, "lynx") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r100, "lynx_ruyi") == true) goto L8;
        return false;
    }

    @Override // com.larus.business.markdown.api.depend.a
    public final usc.f b(FrameLayout r100, TextView r101, Spanned r102, usc.e r103, Map<String, ? extends Object> r104) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "textView");
        Intrinsics.checkNotNullParameter(r102, "text");
        Intrinsics.checkNotNullParameter(r103, "span");
        if (AppHost.f326268a.isOversea() == false) goto L6;
        return new MarkdownLynxWidget(r100.getContext(), null);
    L6:
        return new am8.g(r100.getContext());
    }
}
