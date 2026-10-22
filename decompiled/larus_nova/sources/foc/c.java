package foc;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogController;
import com.larus.nova.R;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.platform.component.cta.databinding.CtaDialogContentBinding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class c extends UDDialogController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f478203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<goc.b.l> f478204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f478205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f478206d;

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final int getDefaultContentRes() {
        return R.layout.cta_dialog_content;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final View onCreateContent() {
        View r100 = LayoutInflater.from(getContext()).inflate(R.layout.cta_dialog_content, null, false);
        int r101 = R.id.cta_image;
        ImageView r102 = (ImageView) ViewBindings.findChildViewById(r100, R.id.cta_image);
        if (r102 == null) goto L65;
        r101 = R.id.ud_dialog_content_message_tv;
        TextView r103 = (TextView) ViewBindings.findChildViewById(r100, R.id.ud_dialog_content_message_tv);
        if (r103 == null) goto L65;
        CtaDialogContentBinding r104 = new CtaDialogContentBinding((LinearLayout) r100, r102, r103);
        String r105 = this.f478203a;
        if (r105 != null) goto L9;
    L12:
        boolean r106 = true;
    L14:
        if (r106 == false) goto L16;
        r102.setImageResource(R.drawable.illustration_specialized_cta_banner_mobile);
    L17:
        List<goc.b.l> r107 = this.f478204b;
        Intrinsics.checkNotNullParameter(r107, "<this>");
        SpannableStringBuilder r108 = new SpannableStringBuilder();
        Iterator r109 = r107.iterator();
        int r110 = 0;
    L19:
        if (r109.hasNext() == false) goto L62;
        Object r111 = r109.next();
        int r112 = r110 + 1;
        if (r110 >= 0) goto L23;
        CollectionsKt.throwIndexOverflow();
    L23:
        goc.b.l r113 = (goc.b.l) r111;
        String r114 = r113.a();
        if (r114 != null) goto L26;
        r114 = "";
    L26:
        SpannableStringBuilder r115 = new SpannableStringBuilder(d.a(r114));
        List<goc.b.i> r116 = r113.b();
        if (r116 != null) goto L29;
        r116 = CollectionsKt.emptyList();
    L29:
        Iterator r117 = CollectionsKt.filterNotNull(r116).iterator();
    L31:
        if (r117.hasNext() == false) goto L58;
        goc.b.i r118 = (goc.b.i) r117.next();
        String r119 = r118.getType();
        if (Intrinsics.areEqual(r119, "user") == false) goto L44;
        String r120 = r118.c();
        if (r120 != null) goto L37;
        r120 = "";
    L37:
        Iterator r121 = r109;
        MatchResult r122 = Regex.find$default(new Regex("\\{\\{" + r120 + "\\}\\}"), r115, 0, 2, null);
        if (r122 == null) goto L56;
        String r123 = r118.b();
        if (r123 != null) goto L43;
        r123 = "";
    L43:
        String r124 = "@".concat(r123);
        r115.replace(r122.getRange().getFirst(), r122.getRange().getLast() + 1, r124);
        r115.setSpan(new b18.a(this.f478206d, new b(this, r120)), r122.getRange().getFirst(), r122.getRange().getFirst() + r124.length(), 17);
    L56:
        r109 = r121;
        goto L31
    L44:
        r121 = r109;
        if (Intrinsics.areEqual(r119, "plain_text") == false) goto L56;
        String r125 = r118.c();
        if (r125 != null) goto L49;
        r125 = "";
    L49:
        MatchResult r126 = Regex.find$default(new Regex("\\{\\{" + r125 + "\\}\\}"), r115, 0, 2, null);
        if (r126 != null) goto L52;
    L51:
        r109 = r121;
        goto L31
    L52:
        int r127 = r126.getRange().getFirst();
        int r128 = r126.getRange().getLast() + 1;
        String r129 = r118.b();
        if (r129 != null) goto L55;
        r129 = "";
    L55:
        r115.replace(r127, r128, r129);
        goto L51
    L58:
        Iterator r130 = r109;
        r108.append(r115);
        if (r110 == CollectionsKt.getLastIndex(r107)) goto L61;
        r108.append('\n');
    L61:
        r110 = r112;
        r109 = r130;
        goto L19
    L62:
        r103.setText(r108);
        r103.setMovementMethod(LinkMovementMethod.getInstance());
        return r104.f460488a;
    L16:
        ImageLoader.with(getContext()).load(this.f478203a).error(R.drawable.illustration_specialized_cta_banner_mobile).into(r102);
        goto L17
    L9:
        if (StringsKt.isBlank(r105) == true) goto L12;
        r106 = false;
    L65:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f478204b = CollectionsKt.emptyList();
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r100, UDDialog r101) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        Intrinsics.checkNotNullParameter(r101, "dialog");
        super.apply(r100, r101);
        if ((r100 instanceof a) == false) goto L7;
        a r102 = (a) r100;
        this.f478203a = r102.f478197a;
        this.f478204b = new ArrayList(r102.f478198b);
        this.f478205c = r102.f478199c;
        this.f478206d = r102.f478200d;
        return;
    L7:
        throw new IllegalArgumentException("builder should be CTADialogBuilder, but actually ".concat(r100.getClass().getSimpleName()).toString());
    }
}
