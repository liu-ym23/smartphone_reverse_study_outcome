package dz9;

import android.text.Spanned;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.uaigc.chat.markdown.CreationCustomWidgetBinder;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import usc.e;
import usc.f;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements com.larus.business.markdown.api.depend.a {
    public a() {
    }

    @Override // com.larus.business.markdown.api.depend.a
    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "dataType");
        return Intrinsics.areEqual(r100, "creation");
    }

    @Override // com.larus.business.markdown.api.depend.a
    public final f b(FrameLayout r100, TextView r101, Spanned r102, e r103, Map<String, ? extends Object> r104) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "textView");
        Intrinsics.checkNotNullParameter(r102, "text");
        Intrinsics.checkNotNullParameter(r103, "span");
        return new CreationCustomWidgetBinder(r100.getContext(), null);
    }
}
