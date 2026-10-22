package com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import com.larksuite.rucket.job.compat.f;
import com.larus.nova.R;
import com.ss.android.lark.keyboard.dtocompat.UrlInlinePreviewEntity;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import com.ss.android.lark.keyboard.edittext2.span.e;
import com.ss.android.lark.keyboard.edittext2.span.m;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.light.span.p;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import hob.j;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes36.dex */
public class d extends fob.b<j> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f429005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UrlInlinePreviewConfig f429006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f429007d;

    public static final class a {
    }

    static {
    }

    public void j() {
    }

    public /* synthetic */ d(j r100) {
        int r101 = UrlInlinePreviewConfig.f428993b;
        this(r100, UrlInlinePreviewConfig.a.a());
    }

    public void g(UrlInlinePreviewEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "entity");
        j r101 = this.f429005b;
        boolean r102 = true;
        r101.f486342g = true;
        String r103 = StringsKt.trim(r100.f428709b).toString();
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r101.f486340e = r103;
        String r104 = r100.f428714g;
        if (r104 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == true) goto L14;
        if (r100.f428720m == false) goto L14;
        j.a r106 = this.f429005b.f486341f;
        r106.f486345c = r100.f428714g;
        r106.f486347e = true;
        return;
    L14:
        if (r100.f428715h != 0) goto L16;
    L22:
        String r107 = r100.f428717j;
        if (r107 != null) goto L25;
    L28:
        boolean r108 = true;
    L29:
        if (r108 == false) goto L31;
    L33:
        String r109 = r100.f428718k;
        if (r109 != null) goto L36;
    L39:
        boolean r110 = true;
    L40:
        if (r110 == false) goto L42;
    L44:
        String r111 = r100.f428713f;
        if (r111 != null) goto L47;
    L50:
        if (r102 == true) goto L52;
        this.f429005b.f486341f.f486345c = r100.f428713f;
        return;
    L52:
        int r112 = r100.f428711d;
        if (r112 == 0) goto L58;
        j.a r113 = this.f429005b.f486341f;
        r113.f486343a = r112;
        int r114 = r100.f428712e;
        if (r114 != 0) goto L57;
        r113.f486348f = UIHelper.getColor(R.color.text_link_normal);
        return;
    L57:
        r113.f486348f = r114;
        return;
    L58:
        j.a r115 = this.f429005b.f486341f;
        String r116 = r100.f428710c;
        r115.getClass();
        Intrinsics.checkNotNullParameter(r116, "<set-?>");
        r115.f486344b = r116;
        this.f429005b.f486341f.f486348f = UIHelper.getColor(R.color.text_link_normal);
        return;
    L47:
        if (r111.length() == 0) goto L50;
        r102 = false;
        goto L50
    L42:
        if (r100.f428720m == false) goto L44;
        j.a r117 = this.f429005b.f486341f;
        r117.f486346d = r100.f428718k;
        r117.f486348f = r100.f428719l;
        r117.f486347e = true;
        return;
    L36:
        if (r109.length() == 0) goto L39;
        r110 = false;
        goto L40
    L31:
        if (r100.f428720m == false) goto L33;
        j.a r118 = this.f429005b.f486341f;
        String r119 = r100.f428717j;
        r118.getClass();
        Intrinsics.checkNotNullParameter(r119, "<set-?>");
        r118.f486344b = r119;
        j.a r120 = this.f429005b.f486341f;
        r120.f486348f = r100.f428719l;
        r120.f486347e = true;
        return;
    L25:
        if (r107.length() == 0) goto L28;
        r108 = false;
        goto L29
    L16:
        if (r100.f428720m == false) goto L22;
        j.a r121 = this.f429005b.f486341f;
        if ((!com.ss.android.lark.keyboard.edittext2.utils.d.a("messenger.im.disable_doubao_url_inline_icon_fix")) == false) goto L20;
        int r122 = r100.f428715h;
    L21:
        r121.f486343a = r122;
        j.a r123 = this.f429005b.f486341f;
        r123.f486348f = r100.f428716i;
        r123.f486347e = true;
        return;
    L20:
        r122 = r100.f428711d;
        goto L21
    L5:
        if (r104.length() == 0) goto L8;
        r105 = false;
        goto L9
    }

    public final boolean h(Editable r110) {
        Intrinsics.checkNotNullParameter(r110, "editable");
        Intrinsics.checkNotNullParameter(r110, "editable");
        Pair<Integer, Integer> r100 = b(r110);
        int r101 = r100.component1().intValue();
        int r102 = r100.component2().intValue();
        if (r101 == (-1)) goto L7;
        if (r102 == (-1)) goto L7;
        boolean r103 = false;
    L8:
        if (r102 >= r101) goto L10;
        boolean r104 = true;
    L11:
        if (r101 >= 0) goto L13;
    L15:
        boolean r105 = false;
    L16:
        if (r105 == false) goto L24;
        if (r102 >= 0) goto L19;
    L21:
        boolean r106 = false;
    L22:
        if (r106 == false) goto L24;
        boolean r107 = true;
    L26:
        if (r103 == true) goto L31;
        if (r104 == true) goto L31;
        if (r107 == false) goto L31;
        boolean r108 = Intrinsics.areEqual(r110.subSequence(r101, r102), this.f429007d);
    L32:
        if (r108 == false) goto L35;
        Log.i("AnchorEditor", "prepareSpan: this url has been modified by user. now return");
        Intrinsics.checkNotNullParameter(r110, "editable");
        r110.removeSpan(this);
        return true;
    L35:
        return false;
    L31:
        Log.i("AnchorEditor", "checkUrlChanged: url has been changed.");
        r108 = true;
        goto L32
    L19:
        if (r102 > r110.length()) goto L21;
        r106 = true;
    L24:
        r107 = false;
        goto L26
    L13:
        if (r101 > r110.length()) goto L15;
        r105 = true;
        goto L16
    L10:
        r104 = false;
    L7:
        r103 = true;
        goto L8
    }

    public void k(final FunctionEditText r210) {
        Intrinsics.checkNotNullParameter(r210, "targetView");
        Editable r100 = r210.getEditableText();
        Log.d("AnchorEditor", "prepareSpan called");
        Intrinsics.checkNotNull(r100);
        if (h(r100) == false) goto L5;
        return;
    L5:
        boolean r101 = !com.ss.android.lark.keyboard.edittext2.utils.d.a("messenger.im.disable_doubao_url_inline_layout_fix");
        if (r101 == false) goto L15;
        Pair<Integer, Integer> r102 = b(r100);
        int r103 = r102.component1().intValue();
        int r104 = r102.component2().intValue();
        int r110 = r210.getSelectionEnd();
        if (r210.getSelectionStart() != r110) goto L15;
        if (r103 > r110) goto L12;
        if (r110 > r104) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == false) goto L15;
        boolean r106 = true;
    L16:
        Log.d("AnchorEditor", "prepareSpannableString: start");
        Intrinsics.checkNotNullParameter(r210, "targetView");
        Log.i("AnchorEditor", "prepareURLPreviewSpanString");
        j r107 = this.f429005b;
        j.a r108 = r107.f486341f;
        Object r109 = ((HashMap) r107.f486306c).get(e.class.getName());
        if ((r109 instanceof e) == false) goto L19;
        e r111 = (e) r109;
    L21:
        if (r108.f486347e == false) goto L23;
    L25:
        if (r111 != null) goto L27;
        r111 = new e((int) r210.getTextSize(), r108.f486348f, 4);
    L27:
        boolean r112 = r106;
        m.a r113 = new m.a(r210.getContext(), this.f429005b.f486340e, this.f429007d, r108.f486343a, r108.f486344b, r108.f486345c, r108.f486346d, r108.f486347e);
        r113.f429233a = r111.f429215c;
        r113.f429235c = r111.f429213a;
        r113.f429234b = r111.f429214b;
        final m r114 = new m(r113);
        ncc.d r115 = new UrlInlineSpanHolder$getDrawableCallback$1(r210, this, r114);
        Intrinsics.checkNotNullParameter(r115, "callback");
        r114.f429232f.setCallback(r115);
        r114.f429232f.invalidateSelf();
        SpannableStringBuilder r116 = r114.f429231e;
        if (r116 == null) goto L44;
        Log.d("AnchorEditor", "prepareSpannableString: end");
        i(r116, this.f429005b, r116.length());
        f(r100, r116, true);
        if (r101 == false) goto L45;
        r210.requestLayout();
        int r117 = r210.getSelectionEnd();
        if (r112 == true) goto L34;
        return;
    L34:
        if (r210.getSelectionStart() != r117) goto L47;
        if (r117 >= 0) goto L37;
    L39:
        boolean r118 = false;
    L40:
        if (r118 == false) goto L48;
        r210.bringPointIntoView(r117);
        return;
    L48:
        return;
    L37:
        if (r117 > r210.length()) goto L39;
        r118 = true;
        goto L40
    L47:
        return;
    L45:
        return;
    L44:
        throw new IllegalArgumentException("Required value was null.".toString());
    L23:
        if (r108.f486348f != 0) goto L25;
        r108.f486348f = UIHelper.getColor(R.color.text_link_normal);
        goto L25
    L19:
        r111 = null;
    L12:
        r105 = false;
    L15:
        r106 = false;
        goto L16
    }

    public d(j r100, UrlInlinePreviewConfig r101) {
        Intrinsics.checkNotNullParameter(r100, "anchorInfo");
        Intrinsics.checkNotNullParameter(r101, "urlPreviewConfig");
        this.f429005b = r100;
        this.f429006c = r101;
        this.f429007d = r100.f486304a;
        if (r100.f486339d == false) goto L5;
        f.a(new UrlInlineSpanHolder$loadUrlPreviewFormMiddlePlatform$1(this)).then(Dispatchers.getMain(), new UrlInlineSpanHolder$loadUrlPreviewFormMiddlePlatform$2(this, null)).error(Dispatchers.getMain(), new UrlInlineSpanHolder$loadUrlPreviewFormMiddlePlatform$3(this, null));
        Log.i("AnchorEditor", "init: anchor info parsed form net");
        return;
    L5:
        a(new UrlInlineSpanHolder$schedulePrepareSpan$1(this));
    }

    public void i(SpannableStringBuilder r100, j r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "data");
        RichTextElement.AnchorProperty r103 = RichTextElementCreator.a(r101.f486340e, r101.f486304a);
        r103.setLocalIconRes(r101.f486341f.f486343a);
        r103.setIconKey(r101.f486341f.f486344b);
        r103.setUnicode(r101.f486341f.f486345c);
        r103.setFaviconUrl(r101.f486341f.f486346d);
        r103.setIconColor(r101.f486341f.f486348f);
        r103.setColorIcon(r101.f486341f.f486347e);
        r103.setDisplayTitle(r101.f486340e);
        r103.setUrlPreview(r101.f486342g);
        r103.setScene(r103.getScene());
        RichTextElement r104 = RichTextElementCreator.h(r103);
        r100.setSpan(new p(r104, r100.subSequence(0, r102).toString()), 0, r102, 33);
        d(r100, r101, r102, r104);
    }
}
