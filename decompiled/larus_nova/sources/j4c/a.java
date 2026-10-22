package j4c;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.search.dto.info.TagContent;
import com.ss.android.lark.search.ui.result.SearchDependencyHolder;
import com.ss.android.lark.utils.UIHelper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: j4c.a$a, reason: collision with other inner class name */
    public static final class C6393a implements sz7.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f497402a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f497403b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f497404c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f497405d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f497406e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ TextView f497407f;

        @Override // sz7.l
        public final void onError(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            Drawable r101 = UDIconUtils.getIconDrawable(this.f497407f.getContext(), R.drawable.ud_icon_link_copy_outlined);
            int r102 = this.f497402a;
            int r103 = this.f497403b;
            r101.setTint(r102);
            r101.setBounds(0, 0, r103, r103);
            r101.setTint(this.f497402a);
            int r104 = this.f497403b;
            r101.setBounds(0, 0, r104, r104);
            this.f497404c.setSpan(new b0(r101), this.f497405d + 1, this.f497406e - 1, 33);
            this.f497407f.setText(this.f497404c);
        }

        @Override // sz7.l
        public final void onSuccess(Drawable r100) {
            Intrinsics.checkNotNullParameter(r100, "drawable");
            r100.setTint(this.f497402a);
            int r101 = this.f497403b;
            r100.setBounds(0, 0, r101, r101);
            this.f497404c.setSpan(new b0(r100), this.f497405d + 1, this.f497406e - 1, 33);
            this.f497407f.setText(this.f497404c);
        }

        public C6393a(int r100, int r101, SpannableStringBuilder r102, int r103, int r104, TextView r105) {
            this.f497402a = r100;
            this.f497403b = r101;
            this.f497404c = r102;
            this.f497405d = r103;
            this.f497406e = r104;
            this.f497407f = r105;
        }
    }

    public static final void a(SpannableStringBuilder r210, TextView r211, List<TagContent> r212, int r310) {
        Intrinsics.checkNotNullParameter(r210, "<this>");
        Intrinsics.checkNotNullParameter(r211, "textView");
        if (r212 == null) goto L90;
        Iterator<T> r110 = r212.iterator();
        int r111 = 0;
    L6:
        if (r110.hasNext() == false) goto L90;
        TagContent r100 = (TagContent) r110.next();
        int r101 = r100.getContent().getStart() + r111;
        if (r101 >= r210.length()) goto L6;
        if ((r100.getContent().getContent().length() + r101) > r210.length()) goto L6;
        int r102 = r101 + r100.getContent().getContent().length();
        String r103 = r100.getTag();
        int r104 = r103.hashCode();
        boolean r105 = true;
        if (r104 != 98) goto L15;
        if (r103.equals("b") == false) goto L6;
        r210.setSpan(new StyleSpan(1), r101, r102, 33);
        r210.setSpan(new ForegroundColorSpan(UIHelper.getColor(R.color.text_caption)), r101, r102, 33);
        goto L6
    L15:
        if (r104 != 104) goto L17;
        if (r103.equals("h") == false) goto L6;
        r210.setSpan(new ForegroundColorSpan(r310), r101, r102, 33);
        goto L6
    L17:
        if (r104 != 3205) goto L19;
        if (r103.equals("di") == false) goto L6;
        String r106 = r100.getAttributeMap().get("color");
        if (r106 != null) goto L71;
        r106 = "grey";
    L71:
        String r107 = r100.getAttributeMap().get("type");
        if (r107 == null) goto L76;
        Integer r108 = StringsKt.toIntOrNull(r107);
        if (r108 == null) goto L76;
        int r109 = r108.intValue();
    L78:
        if (Intrinsics.areEqual(r106, "grey") == false) goto L80;
        Drawable r112 = UDIconUtils.getIconDrawable(r211.getContext(), ((com.ss.android.lark.search.ui.result.b) SearchDependencyHolder.f440254a.getValue()).getDocInlineGreyIcon(r109), UIHelper.getColor(R.color.ud_N500));
    L81:
        Drawable r113 = r112;
        Context r114 = r211.getContext();
        ncc.e.a r115 = new ncc.e.a("$");
        int r213 = UIUtils.dp2px(r114, 3.0f);
        int r214 = UIUtils.dp2px(r114, 3.0f);
        int r215 = r114.getResources().getColor(R.color.text_link_hover);
        int r216 = r114.getResources().getColor(R.color.text_link_hover);
        int r116 = (int) r211.getTextSize();
        r210.insert(r101, "$");
        r111 = r111 + 1;
        r210.setSpan(new ncc.e(r114, r115, "", null, r113, r116, false, 0, r215, r216, r213, r214), r101, r101 + 1, 33);
        goto L6
    L80:
        r112 = UDIconUtils.getIconDrawable(r211.getContext(), ((com.ss.android.lark.search.ui.result.b) SearchDependencyHolder.f440254a.getValue()).getDocInlineBlueIcon(r109), UIHelper.getColor(R.color.ud_B600));
    L76:
        r109 = 0;
        goto L78
    L19:
        if (r104 != 3322) goto L21;
        if (r103.equals("hb") == false) goto L6;
        r210.setSpan(new ForegroundColorSpan(r310), r101, r102, 33);
        r210.setSpan(new StyleSpan(1), r101, r102, 33);
        goto L6
    L21:
        if (r104 != 3577) goto L23;
        if (r103.equals("pi") == false) goto L6;
        String r117 = r100.getAttributeMap().get("ud");
        if (r117 != null) goto L39;
        r117 = "";
    L39:
        String r118 = r100.getAttributeMap().get("icon");
        if (r118 != null) goto L42;
        String r119 = "";
    L43:
        int r120 = (int) r211.getTextSize();
        int r121 = r211.getCurrentTextColor();
        if (r117.length() <= 0) goto L46;
        boolean r122 = true;
    L47:
        int r123 = R.drawable.ud_icon_link_copy_outlined;
        if (r122 == true) goto L49;
        if (r119.length() > 0) goto L58;
        r105 = false;
    L58:
        if (r105 == true) goto L59;
        Drawable r124 = UDIconUtils.getIconDrawable(r211.getContext(), R.drawable.ud_icon_link_copy_outlined);
        r124.setTint(r121);
        r124.setBounds(0, 0, r120, r120);
        r210.setSpan(new b0(r124), r101 + 1, r102 - 1, 33);
        goto L6
    L59:
        rz7.a.f539978a.getEncryptIconLoader().a(r211.getContext(), r119, r120, r120, new C6393a(r121, r120, r210, r101, r102, r211));
        goto L6
    L49:
        int r125 = ((com.ss.android.lark.search.ui.result.b) SearchDependencyHolder.f440254a.getValue()).getUDIconByKey(r117);
        if (r125 <= 0) goto L53;
        r123 = r125;
    L53:
        Drawable r126 = UDIconUtils.getIconDrawable(r211.getContext(), r123);
        r126.setTint(r121);
        r126.setBounds(0, 0, r120, r120);
        r210.setSpan(new b0(r126), r101 + 1, r102 - 1, 33);
        goto L6
    L46:
        r122 = false;
        goto L47
    L42:
        r119 = r118;
        goto L43
    L23:
        if (r104 != 2089511070) goto L6;
        if (r103.equals("asl-style") == false) goto L6;
        Integer r127 = (Integer) ((LinkedHashMap) v3c.m.f552981a).get(r100.getAttributeMap().get("color"));
        if (r127 == null) goto L31;
        int r128 = r127.intValue();
    L32:
        r210.setSpan(new ForegroundColorSpan(UIHelper.getColor(r128)), r101, r102, 33);
        goto L6
    L31:
        r128 = R.color.text_disable;
    L90:
        r211.setText(r210);
    }
}
