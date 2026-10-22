package j99;

import com.larus.common_ui.widget.UrlSpanTextView;
import com.larus.extension.chat_extension.impl.databinding.LarusItemLtmTitleBinding;
import com.larus.platform.service.q;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class i implements UrlSpanTextView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LarusItemLtmTitleBinding f497828a;

    public i(LarusItemLtmTitleBinding r100) {
        this.f497828a = r100;
    }

    @Override // com.larus.common_ui.widget.UrlSpanTextView.a
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        q.f365787a.e(this.f497828a.f342783c.getContext(), com.larus.utils.f.c(new Pair[]{TuplesKt.to("link_url", r100)}), null);
    }
}
