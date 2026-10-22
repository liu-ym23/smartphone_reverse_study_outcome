package oj8;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.ShimmerLinearLayout;
import com.larus.bmhome.chat.markdown.code.ClickableMarkdownCodeView;
import com.larus.bmhome.chat.markdown.code.p0;
import com.larus.bmhome.chat.standarduikit.coderenderandinterceptor.view.FlowMarkdownCodeView;
import com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt;
import com.larus.im.bean.message.Message;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.mainbot.impl.databinding.LarusFlowMarkdownCodeViewHeaderBinding;
import com.larus.mainbot.impl.databinding.MarkdownRenderCodeViewLayoutBinding;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import qj8.e;
import qj8.f;
import qj8.g;
import qj8.h;
import qj8.m;
import rj8.d;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f523594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f523595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f523596c;

    public final FlowMarkdownCodeView b() {
        return (FlowMarkdownCodeView) this.f523595b.getValue();
    }

    public final void c() {
        FlowMarkdownCodeView r100 = b();
        ClickableMarkdownCodeView r101 = r100.f308981a;
        if (r101 == null) goto L5;
        r101.p();
    L5:
        LarusFlowMarkdownCodeViewHeaderBinding r102 = r100.f308982b;
        if (r102 == null) goto L10;
        ShimmerLinearLayout r103 = r102.f358597a;
        if (r103 == null) goto L10;
        ExposeXTrackerExtKt.e(r103);
    L10:
        ClickableMarkdownCodeView r104 = r100.f308981a;
        if (r104 == null) goto L13;
        ExposeXTrackerExtKt.e(r104);
    L13:
        g r105 = r100.f308986f;
        if (r105 == null) goto L22;
        ClickableMarkdownCodeView r106 = r100.f308981a;
        if (r106 == null) goto L20;
        Handler r107 = r106.getHandler();
        if (r107 == null) goto L20;
        r107.removeCallbacks(r105);
    L20:
        r100.f308986f = null;
        return;
    }

    public final Context getContext() {
        return this.f523594a;
    }

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f523594a = r100;
        this.f523595b = LazyKt.lazy(new a(this));
        this.f523596c = LazyKt.lazy(new b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v29, types: [qj8.d] */
    /* JADX WARN: Type inference failed for: r3v30, types: [qj8.e] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Runnable, qj8.g] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a(rj8.a r310, p0 r311) {
        Intrinsics.checkNotNullParameter(r310, "vmData");
        d r100 = (d) this.f523596c.getValue();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r310, "vmData");
        r100.f538162a = r310;
        r100.f538163b = r311;
        final m r101 = ((d) this.f523596c.getValue()).a();
        d r102 = (d) this.f523596c.getValue();
        r102.getClass();
        final rj8.c r103 = new rj8.c(r102);
        final FlowMarkdownCodeView r104 = b();
        r104.getClass();
        Intrinsics.checkNotNullParameter(r101, "input");
        Intrinsics.checkNotNullParameter(r103, BdpAppEventConstant.PARAMS_OUTPUT);
        ClickableMarkdownCodeView r105 = r104.f308981a;
        boolean r106 = false;
        if (r105 == null) goto L5;
        String r110 = r101.f533406a;
        Message r111 = r101.f533407b;
        boolean r112 = r101.f533408c;
        Long r113 = r101.f533409d;
        RecyclerView r114 = r101.f533412g;
        ClickableMarkdownCodeView.n(r105, r110, r111, r112, r113, r101.f533411f, r114, new qj8.a(r103, r104), r101.f533413h, r101.f533414i, new qj8.d(r103), new e(r104, r101, r103), null, FlowMarkdownCodeView.b(r101, false), r101.f533415j, r101.f533416k, r101.f533417l, r101.f533425t, r101.f533426u, r101.f533427v, r101.B, r101.f533430y, 2048);
    L5:
        String r107 = r101.f533420o;
        Intrinsics.checkNotNullParameter(r107, "info");
        List<String> r108 = new Regex("\\s+").split(StringsKt.trim(r107).toString(), 2);
        String r115 = (String) ListProtector.get(r108, 0);
        String r109 = (String) CollectionsKt.getOrNull(r108, 1);
        if (r109 == null) goto L13;
        Sequence r116 = Regex.findAll$default(new Regex("(\\w+)=\"([^\"]*)\""), r109, 0, 2, null);
        if (r116 == null) goto L13;
        Map r117 = new LinkedHashMap();
        Iterator r118 = r116.iterator();
    L11:
        if (r118.hasNext() == false) goto L14;
        MatchResult r119 = (MatchResult) r118.next();
        Pair r120 = TuplesKt.to((String) ListProtector.get(r119.getGroupValues(), 1), (String) ListProtector.get(r119.getGroupValues(), 2));
        r117.put(r120.getFirst(), r120.getSecond());
    L14:
        Map r121 = r117;
        Intrinsics.checkNotNullParameter(r115, "realLanguage");
        Intrinsics.checkNotNullParameter(r121, "extraMap");
        ClickableMarkdownCodeView r122 = r104.f308981a;
        if (r122 == null) goto L48;
        String r123 = r101.f533418m;
        boolean r124 = r101.f533421p;
        String r125 = r101.f533428w;
        Integer r126 = r101.f533431z;
        Integer r127 = r101.A;
        Intrinsics.checkNotNullParameter(r123, "code");
        Intrinsics.checkNotNullParameter(r115, "language");
        if (ClickableMarkdownCodeView.f(r115, r121) == 0) goto L32;
        Boolean r128 = r122.f306932h;
        MarkdownRenderCodeViewLayoutBinding r129 = r122.Q;
        if (r129 == null) goto L27;
        FrameLayout r130 = r129.f358866p;
        if (r130 == null) goto L27;
        if (r130.getVisibility() != 0) goto L25;
        boolean r131 = true;
    L26:
        Boolean r132 = Boolean.valueOf(r131);
    L29:
        if (Intrinsics.areEqual(r128, r132) == true) goto L32;
    L45:
        boolean r133 = true;
    L46:
        if (r133 == true) goto L48;
        boolean r134 = true;
    L49:
        if (r134 == true) goto L161;
        String r135 = r101.f533418m;
        String r136 = r101.f533419n;
        boolean r137 = r101.f533421p;
        if (Intrinsics.areEqual(r121.get("type"), "interpreter") == true) goto L59;
        LarusFlowMarkdownCodeViewHeaderBinding r138 = r104.f308982b;
        if (r138 == null) goto L127;
        ShimmerLinearLayout r139 = r138.f358597a;
        if (r139 == null) goto L127;
        r139.setVisibility(8);
    L127:
        String r140 = r101.f533418m;
        boolean r141 = r101.f533421p;
        String r142 = r101.f533428w;
        boolean r143 = r101.f533429x;
        Integer r144 = r101.f533431z;
        Integer r145 = r101.A;
        ClickableMarkdownCodeView r146 = r104.f308981a;
        if (r146 == 0) goto L133;
        r146.c(r140, r115, r141, r121, r142, r143, r144, r145);
        if (r104.d() == false) goto L132;
        r146.setVisibility(0);
        goto L133
    L132:
        r146.setVisibility(8);
    L133:
        r104.e();
        ?? r147 = new g(r104, r101, r103);
        r104.f308986f = r147;
        r104.post(r147);
        ClickableMarkdownCodeView r148 = r104.f308981a;
        if (r148 == null) goto L141;
        String r149 = r148.getLanguage();
        if (r149 != null) goto L139;
        r149 = "";
    L139:
        if (ClickableMarkdownCodeView.f(r149, r121) != 0) goto L141;
        r106 = true;
    L141:
        if (r106 == true) goto L143;
    L147:
        Integer r150 = r101.f533423r;
        if (r150 == null) goto L152;
        int r151 = r150.intValue();
        ClickableMarkdownCodeView r152 = r104.f308981a;
        if (r152 == null) goto L152;
        r152.setupMarkdownCodeLinearLayoutRes(Integer.valueOf(r151));
    L152:
        Integer r153 = r101.f533424s;
        if (r153 == null) goto L159;
        int r154 = r153.intValue();
        ClickableMarkdownCodeView r155 = r104.f308981a;
        if (r155 == null) goto L160;
        r155.setupExpandAllBackgroundResult(Integer.valueOf(r154));
        return;
    L160:
        return;
    L159:
        return;
    L143:
        if (r101.f533421p == false) goto L147;
        FLogger.f375446a.d("FlowMarkdownCodeView", "FlowMarkdownCodeView bindData can not show render tab, language: " + r101.f533420o);
        ClickableMarkdownCodeView r156 = r104.f308981a;
        if (r156 == null) goto L147;
        ExposeXTrackerExtKt.b(r156, new h(r104, r101, r103, null, 0 == true ? 1 : 0));
        goto L147
    L59:
        if (r104.f308984d == true) goto L62;
        r104.f308983c = true;
    L62:
        if (r104.f308982b != null) goto L81;
        View r157 = LayoutInflater.from(r104.getContext()).inflate(R.layout.larus_flow_markdown_code_view_header, r104, false);
        ShimmerLinearLayout r158 = (ShimmerLinearLayout) r157;
        int r159 = R.id.flowMarkdownCodeHeaderArrow;
        AppCompatImageView r160 = (AppCompatImageView) ViewBindings.findChildViewById(r157, R.id.flowMarkdownCodeHeaderArrow);
        if (r160 == null) goto L80;
        r159 = R.id.flowMarkdownCodeHeaderIcon;
        SimpleDraweeView r210 = (SimpleDraweeView) ViewBindings.findChildViewById(r157, R.id.flowMarkdownCodeHeaderIcon);
        if (r210 == null) goto L80;
        r159 = R.id.flowMarkdownCodeHeaderTitle;
        TextView r211 = (TextView) ViewBindings.findChildViewById(r157, R.id.flowMarkdownCodeHeaderTitle);
        if (r211 == null) goto L80;
        r104.f308982b = new LarusFlowMarkdownCodeViewHeaderBinding(r158, r158, r160, r210, r211);
        r104.addView(r158, 0);
        LarusFlowMarkdownCodeViewHeaderBinding r161 = r104.f308982b;
        if (r161 == null) goto L74;
        TextView r162 = r161.f358601e;
        if (r162 == null) goto L74;
        we8.a.b(r162, MarkdownDimensExtKt.d(), false, null, null, 12);
    L74:
        LarusFlowMarkdownCodeViewHeaderBinding r163 = r104.f308982b;
        if (r163 == null) goto L81;
        ShimmerLinearLayout r164 = r163.f358598b;
        if (r164 == null) goto L81;
        r164.setOnClickListener(new f(r104, r103, r101));
    L80:
        throw new NullPointerException("Missing required view with ID: ".concat(r157.getResources().getResourceName(r159)));
    L81:
        LarusFlowMarkdownCodeViewHeaderBinding r165 = r104.f308982b;
        if (r165 == null) goto L86;
        ShimmerLinearLayout r166 = r165.f358597a;
        if (r166 == null) goto L86;
        r166.setVisibility(0);
    L86:
        LarusFlowMarkdownCodeViewHeaderBinding r167 = r104.f308982b;
        if (r167 != null) goto L89;
    L110:
        r104.f(false, r104.f308983c);
        if (o0.d(r136) == false) goto L122;
        LarusFlowMarkdownCodeViewHeaderBinding r168 = r104.f308982b;
        if (r168 == null) goto L117;
        SimpleDraweeView r169 = r168.f358600d;
        if (r169 == null) goto L117;
        e1.x(r169);
    L117:
        LarusFlowMarkdownCodeViewHeaderBinding r170 = r104.f308982b;
        if (r170 == null) goto L127;
        SimpleDraweeView r171 = r170.f358600d;
        if (r171 == null) goto L127;
        ImageLoaderKt.u(r171, r136, "general_internet_code_header_icon");
        goto L127
    L122:
        LarusFlowMarkdownCodeViewHeaderBinding r172 = r104.f308982b;
        if (r172 == null) goto L127;
        SimpleDraweeView r173 = r172.f358600d;
        if (r173 == null) goto L127;
        e1.o(r173);
        goto L127
    L89:
        if (r135.length() != 0) goto L91;
        boolean r174 = true;
    L93:
        if (r174 == false) goto L99;
        TextView r175 = r167.f358601e;
        Context r176 = r104.getContext();
        if (r176 == null) goto L97;
        CharSequence r177 = r176.getString(R.string.larus_codeBlock_labelSatus_runningCode);
    L98:
        r175.setText(r177);
        r167.f358599c.setVisibility(8);
        r167.f358597a.b();
        goto L110
    L97:
        r177 = null;
        goto L98
    L99:
        if (r137 == false) goto L105;
        r167.f358597a.a();
        TextView r178 = r167.f358601e;
        Context r179 = r104.getContext();
        if (r179 == null) goto L103;
        CharSequence r180 = r179.getString(R.string.larus_codeBlock_labelSatus_codeDone);
    L104:
        r178.setText(r180);
        r167.f358599c.setVisibility(0);
        goto L110
    L103:
        r180 = null;
        goto L104
    L105:
        r167.f358597a.b();
        TextView r181 = r167.f358601e;
        Context r182 = r104.getContext();
        if (r182 == null) goto L108;
        CharSequence r183 = r182.getString(R.string.larus_codeBlock_labelSatus_runningCode);
    L109:
        r181.setText(r183);
        r167.f358599c.setVisibility(0);
        goto L110
    L108:
        r183 = null;
        goto L109
    L91:
        r174 = false;
        goto L93
    L161:
        return;
    L25:
        r131 = false;
    L27:
        r132 = null;
    L32:
        if (Intrinsics.areEqual(r122.f306933i, r123) == false) goto L45;
        if (Intrinsics.areEqual(r122.f306934j, r115) == false) goto L45;
        if (r122.f306943q != r124) goto L45;
        if (Intrinsics.areEqual(r122.f306937l, r125) == false) goto L45;
        if (Intrinsics.areEqual(r122.f306940o, r126) == false) goto L45;
        if (Intrinsics.areEqual(r122.f306941p, r127) == false) goto L45;
        r133 = false;
    L48:
        r134 = false;
    L13:
        r117 = MapsKt.emptyMap();
        goto L14
    }
}
