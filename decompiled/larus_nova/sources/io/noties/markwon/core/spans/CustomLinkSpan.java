package io.noties.markwon.core.spans;

import android.text.TextPaint;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lio/noties/markwon/core/spans/CustomLinkSpan;", "Lio/noties/markwon/core/spans/LinkSpan;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1})
public final class CustomLinkSpan extends LinkSpan {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final lsc.d f492291e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.larus.business.markdown.api.depend.f f492292f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View.OnClickListener f492293g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f492294h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f492295i;

    public static final class a implements com.larus.business.markdown.api.depend.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomLinkSpan f492296a;

        @Override // com.larus.business.markdown.api.depend.f
        public final boolean a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "link");
            return false;
        }

        @Override // com.larus.business.markdown.api.depend.f
        public final boolean b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "link");
            return true;
        }

        @Override // com.larus.business.markdown.api.depend.f
        public final void e(String r100) {
            Intrinsics.checkNotNullParameter(r100, "url");
        }

        public a(CustomLinkSpan r100) {
            this.f492296a = r100;
        }

        @Override // lsc.d
        public final void d(View r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "link");
            this.f492296a.f492299c.d(r100, r101);
        }

        @Override // com.larus.business.markdown.api.depend.f
        public final void c(View r100, String r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "link");
            if (r102 == false) goto L6;
            d(r100, r101);
            return;
        }
    }

    @Override // io.noties.markwon.core.spans.LinkSpan, android.text.style.URLSpan, android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        View.OnClickListener r101 = this.f492293g;
        if (r101 == null) goto L5;
        r101.onClick(r100);
    L5:
        this.f492292f.c(r100, this.f492298b, this.f492295i);
    }

    @Override // io.noties.markwon.core.spans.LinkSpan, android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        lsc.d r101 = this.f492299c;
        if ((r101 instanceof com.larus.business.markdown.api.depend.f) == false) goto L6;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.larus.business.markdown.api.depend.LinkResolverWithStyle");
        ((com.larus.business.markdown.api.depend.f) r101).e(this.f492298b);
    L6:
        if (this.f492295i == false) goto L9;
        super.updateDrawState(r100);
        return;
    }

    public CustomLinkSpan(msc.s r100, String r101, lsc.d r102) {
        Intrinsics.checkNotNullParameter(r100, "theme");
        Intrinsics.checkNotNullParameter(r101, "link");
        Intrinsics.checkNotNullParameter(r102, "resolver");
        com.larus.business.markdown.api.depend.f r103 = null;
        super(r100, r101, null, r102);
        this.f492291e = r102;
        lsc.d r104 = this.f492299c;
        if ((r104 instanceof com.larus.business.markdown.api.depend.f) == false) goto L5;
        r103 = (com.larus.business.markdown.api.depend.f) r104;
    L5:
        if (r103 != null) goto L7;
        r103 = new a(this);
    L7:
        this.f492292f = r103;
        this.f492294h = r103.a(r101);
        this.f492295i = r103.b(r101);
    }
}
