package iw3;

import androidx.core.os.BundleKt;
import com.bytedance.applet.model.bottomsheet.DoubaoBottomSheetDialogFragment;
import com.larus.common_ui.widget.UrlSpanTextView;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m implements UrlSpanTextView.a {
    public final /* synthetic */ DoubaoBottomSheetDialogFragment a;

    public m(DoubaoBottomSheetDialogFragment r1) {
        this.a = r1;
    }

    public final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "url");
        com.larus.platform.service.q.a.e(this.a.requireContext(), BundleKt.bundleOf(new Pair[]{TuplesKt.to("link_url", r5)}), null);
    }
}
