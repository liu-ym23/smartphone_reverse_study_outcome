package com.larus.office.card.doc;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.bmhome.chat.ChatBubbleParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.view.b0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.im.bean.message.block.ArtifactStatus;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.nova.R;
import com.larus.office.card.databinding.LarusCardDocumentBinding;
import com.larus.office.card.databinding.LarusCardDocumentNewStyleBinding;
import com.larus.office.card.databinding.LarusLayoutDocumentCollapseBinding;
import com.larus.platform.service.LarkConnectorArtifactService;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import kc8.z;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import tx9.u0;
import v19.i5;

/* JADX INFO: loaded from: classes29.dex */
public final class DocumentCard extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f361349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f361350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f361351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f361352d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f361353e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f361354f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f361355g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f361356h;

    private final LarusCardDocumentBinding getBinding() {
        return (LarusCardDocumentBinding) this.f361351c.getValue();
    }

    private final LarusCardDocumentNewStyleBinding getBindingNew() {
        return (LarusCardDocumentNewStyleBinding) this.f361352d.getValue();
    }

    private final b0<LarusLayoutDocumentCollapseBinding> getCollapseViewStub() {
        return (b0) this.f361355g.getValue();
    }

    private final b0<LarusLayoutDocumentCollapseBinding> getCollapseViewStubNew() {
        return (b0) this.f361356h.getValue();
    }

    private final boolean getExportIconStyleOpt() {
        return ((Boolean) this.f361350b.getValue()).booleanValue();
    }

    public DocumentCard(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f361349a = "DocumentCard";
        this.f361350b = LazyKt.lazy(new c());
        this.f361351c = LazyKt.lazy(new l(r100, this));
        this.f361352d = LazyKt.lazy(new m(r100, this));
        this.f361353e = "";
        this.f361355g = LazyKt.lazy(new n(this));
        this.f361356h = LazyKt.lazy(new o(this));
    }

    public static void a(DocumentCard r100) {
        int r101 = r100.getBinding().f361299m.getMeasuredHeight();
        FLogger.f375446a.i(r100.f361349a, "height:" + r101);
        ViewGroup.MarginLayoutParams r102 = null;
        if (r101 >= ((Number) i5.E1.getValue()).intValue()) goto L14;
        e1.o(r100.getBinding().f361293g);
        CustomMarkdownTextView r103 = r100.getBinding().f361299m;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if (r104 == null) goto L13;
        if ((r104 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        r102 = (ViewGroup.MarginLayoutParams) r104;
    L9:
        if (r102 == null) goto L11;
        r102.bottomMargin = i5.q();
    L11:
        r103.setLayoutParams(r104);
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L14:
        e1.x(r100.getBinding().f361293g);
        CustomMarkdownTextView r105 = r100.getBinding().f361299m;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if (r106 == null) goto L24;
        if ((r106 instanceof ViewGroup.MarginLayoutParams) == false) goto L19;
        r102 = (ViewGroup.MarginLayoutParams) r106;
    L19:
        if (r102 == null) goto L21;
        r102.bottomMargin = i5.b0();
    L21:
        r105.setLayoutParams(r106);
        return;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public static b0 b(DocumentCard r100) {
        return new b0(r100.getBindingNew().f361302c, DocumentCard$collapseViewStubNew$2$1.INSTANCE);
    }

    public static b0 c(DocumentCard r100) {
        return new b0(r100.getBinding().f361289c, DocumentCard$collapseViewStub$2$1.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int e(Fragment r100) {
        if ((r100 instanceof xe8.a) == false) goto L5;
        xe8.a r101 = (xe8.a) r100;
    L7:
        if (r101 == null) goto L11;
        ChatBubbleParams r102 = r101.Mz();
        if (r102 == null) goto L11;
        int r103 = r102.f296842c;
    L13:
        return RangesKt.coerceAtLeast(r103 - getContext().getResources().getDimensionPixelSize(R.dimen.larus_message_item_start_margin), 0);
    L11:
        r103 = 0;
        goto L13
    L5:
        r101 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(final Fragment r310, final z r311, final Block r312, final Message r313, int r410, final LifecycleCoroutineScope r411, kc8.u r412) {
        Intrinsics.checkNotNullParameter(r312, "block");
        Intrinsics.checkNotNullParameter(r313, "message");
        if (r310 != 0) goto L5;
        return;
    L5:
        BlockContent r100 = r312.getContent();
        if (r100 == null) goto L190;
        final ArtifactBlock r101 = r100.getDocBlock();
        if (r101 == null) goto L191;
        FLogger r102 = FLogger.f375446a;
        String r103 = this.f361349a;
        StringBuilder r104 = new StringBuilder("bindData, doc_render_mode=");
        Map<String, String> r110 = r313.getExt();
        if (r110 == null) goto L13;
        String r111 = r110.get("doc_render_mode");
    L14:
        r104.append(r111);
        r102.i(r103, r104.toString());
        Map<String, String> r105 = r313.getExt();
        if (r105 == null) goto L17;
        String r106 = r105.get("doc_render_mode");
    L19:
        if (Intrinsics.areEqual(r106, "1") == false) goto L76;
        int r107 = r410 - e(r310);
        LarusCardDocumentNewStyleBinding r112 = getBindingNew();
        if (r112.f361300a.getWidth() == r107) goto L27;
        View r113 = r112.f361300a;
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
        if (r114 == null) goto L26;
        r114.width = r107;
        r113.setLayoutParams(r114);
        goto L27
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L27:
        r102.i(this.f361349a, "[updateCardView] brief:" + o0.d(r101.getBrief()));
        Integer r108 = r101.getStatus();
        ArtifactStatus r109 = ArtifactStatus.GENERATING;
        int r115 = r109.getValue();
        if (r108 != null) goto L31;
    L32:
        int r116 = ArtifactStatus.GENERATED.getValue();
        if (r108 != null) goto L36;
    L38:
        int r117 = ArtifactStatus.OUTDATED.getValue();
        if (r108 != null) goto L42;
    L46:
        int r118 = ArtifactStatus.DELETED.getValue();
        if (r108 != null) goto L50;
    L54:
        Unit r119 = Unit.INSTANCE;
    L70:
        e1.d(getBindingNew().f361301b, new q(this, r101, r313, r310));
        getBindingNew().f361300a.setOnLongClickListener(new r(r311));
        if (r412 == null) goto L75;
        Integer r120 = r412.f502575a;
        if (r120 == null) goto L75;
        getBindingNew().f361300a.setBackgroundResource(r120.intValue());
    L75:
        final ArtifactBlock r121 = r101;
        final Message r122 = r313;
    L188:
        ExposeXTrackerExtKt.b(this, new p(r122, r312, this, r121));
        return;
    L50:
        if (r108.intValue() != r118) goto L54;
        getCollapseViewStubNew().b();
        e1.o(r112.f361308i);
        LarusLayoutDocumentCollapseBinding r123 = (LarusLayoutDocumentCollapseBinding) getCollapseViewStubNew().f328321c;
        if (r123 == null) goto L70;
        r123.f361347d.setText(getContext().getString(R.string.larus_aiDoc_msgCard_deletedDoc));
        r123.f361347d.setTextColor(ContextCompat.getColor(getContext(), v19.c.b(R.attr.larus_neutral_50, getContext(), R.color.larus_neutral_50)));
        r123.f361346c.setAlpha(0.4f);
        goto L70
    L42:
        if (r108.intValue() != r117) goto L46;
        getCollapseViewStubNew().b();
        e1.o(r112.f361308i);
        LarusLayoutDocumentCollapseBinding r124 = (LarusLayoutDocumentCollapseBinding) getCollapseViewStubNew().f328321c;
        if (r124 == null) goto L70;
        r124.f361347d.setText(r101.getTitle());
        r124.f361347d.setTextColor(ContextCompat.getColor(getContext(), v19.c.b(R.attr.larus_neutral_100, getContext(), R.color.larus_neutral_100)));
        r124.f361346c.setAlpha(1.0f);
        goto L70
    L36:
        if (r108.intValue() != r116) goto L38;
    L55:
        e1.x(r112.f361308i);
        getCollapseViewStubNew().a();
        if (o0.d(r101.getTitle()) == false) goto L68;
        e1.o(r112.f361306g);
        e1.x(r112.f361305f);
        e1.x(r112.f361301b);
        r112.f361307h.setText(r101.getTitle());
        Integer r125 = r101.getStatus();
        int r126 = r109.getValue();
        if (r125 != null) goto L61;
    L63:
        TextView r127 = r112.f361304e;
        Date r128 = new Date(r313.getCreateTime() * ((long) 1000));
        Calendar r129 = Calendar.getInstance();
        Calendar r130 = Calendar.getInstance();
        r130.setTime(r128);
        int r131 = r129.get(1);
        int r132 = r130.get(1);
        int r133 = r130.get(2) + 1;
        int r134 = r130.get(5);
        SimpleDateFormat r135 = new SimpleDateFormat("HH:mm", Locale.getDefault());
        if (r131 != r132) goto L66;
        StringBuilder r136 = new StringBuilder();
        StringCompanionObject r137 = StringCompanionObject.INSTANCE;
        r136.append(String.format(AppHost.f326268a.getApplication().getString(R.string.larus_aiDoc_history_timestamp), Arrays.copyOf(new Object[]{Integer.valueOf(r133), Integer.valueOf(r134)}, 2)));
        r136.append(' ');
        r136.append(r135.format(r128));
        String r138 = r136.toString();
    L67:
        r127.setText(r138);
    L69:
        Unit r139 = Unit.INSTANCE;
        goto L70
    L66:
        StringBuilder r140 = new StringBuilder();
        StringCompanionObject r141 = StringCompanionObject.INSTANCE;
        r140.append(String.format(AppHost.f326268a.getApplication().getString(R.string.larus_aiDoc_history_timestampYear), Arrays.copyOf(new Object[]{Integer.valueOf(r132), Integer.valueOf(r133), Integer.valueOf(r134)}, 3)));
        r140.append(' ');
        r140.append(r135.format(r128));
        r138 = r140.toString();
        goto L67
    L61:
        if (r125.intValue() != r126) goto L63;
        r112.f361304e.setText(getContext().getString(R.string.larus_aiDoc_writing_hint));
        goto L69
    L68:
        e1.x(r112.f361306g);
        e1.o(r112.f361305f);
        e1.o(r112.f361301b);
        goto L69
    L31:
        if (r108.intValue() == r115) goto L55;
    L76:
        int r142 = r410 - e(r310);
        LarusCardDocumentBinding r143 = getBinding();
        if (r143.f361287a.getWidth() == r142) goto L84;
        View r144 = r143.f361287a;
        ViewGroup.LayoutParams r145 = r144.getLayoutParams();
        if (r145 == null) goto L82;
        r145.width = r142;
        r144.setLayoutParams(r145);
        goto L84
    L82:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L84:
        if (getExportIconStyleOpt() == false) goto L88;
        AppCompatImageView r146 = r143.f361296j;
        if (r146 == null) goto L88;
        r146.setImageResource(v19.c.b(R.attr.larus_ic_card_deep_research_report_export_opt, r146.getContext(), R.drawable.larus_ic_card_deep_research_report_export_opt));
    L88:
        r102.i(this.f361349a, "[updateCardView] brief:" + o0.d(r101.getBrief()));
        Integer r147 = r101.getStatus();
        int r148 = ArtifactStatus.GENERATING.getValue();
        if (r147 != null) goto L92;
    L93:
        int r149 = ArtifactStatus.GENERATED.getValue();
        if (r147 != null) goto L97;
    L99:
        int r150 = ArtifactStatus.OUTDATED.getValue();
        if (r147 != null) goto L103;
    L107:
        int r151 = ArtifactStatus.DELETED.getValue();
        if (r147 != null) goto L111;
    L115:
        Unit r152 = Unit.INSTANCE;
    L175:
        r121 = r101;
        r122 = r313;
        e1.d(getBinding().f361291e, new s(r101, this, r411, r310, r313));
        e1.d(getBinding().f361296j, new t(r121, this, r310, r122));
        e1.d(getBinding().f361297k, new d(this, r121, r122, r310));
        e1.d(getBinding().f361288b, new e(this, r121, r122, r310));
        getBinding().f361288b.setOnLongClickListener(new f(r311));
        LarusLayoutDocumentCollapseBinding r153 = (LarusLayoutDocumentCollapseBinding) getCollapseViewStub().f328321c;
        if (r153 == null) goto L178;
        ConstraintLayout r154 = r153.f361344a;
    L179:
        e1.d(r154, new g(r121, this, r122, r310));
        if (r412 == null) goto L184;
        Integer r155 = r412.f502575a;
        if (r155 == null) goto L184;
        getBinding().f361287a.setBackgroundResource(r155.intValue());
    L184:
        if (r412 == null) goto L188;
        Integer r156 = r412.f502576b;
        if (r156 == null) goto L188;
        getBinding().f361293g.setBackgroundResource(r156.intValue());
        goto L188
    L178:
        r154 = null;
        goto L179
    L111:
        if (r147.intValue() != r151) goto L115;
        getCollapseViewStub().b();
        e1.o(r143.f361295i);
        LarusLayoutDocumentCollapseBinding r157 = (LarusLayoutDocumentCollapseBinding) getCollapseViewStub().f328321c;
        if (r157 == null) goto L175;
        r157.f361347d.setText(getContext().getString(R.string.larus_aiDoc_msgCard_deletedDoc));
        r157.f361347d.setTextColor(ContextCompat.getColor(getContext(), v19.c.b(R.attr.larus_neutral_50, getContext(), R.color.larus_neutral_50)));
        r157.f361346c.setAlpha(0.4f);
        e1.d(r157.f361345b, new j());
        goto L175
    L103:
        if (r147.intValue() != r150) goto L107;
        getCollapseViewStub().b();
        e1.o(r143.f361295i);
        LarusLayoutDocumentCollapseBinding r158 = (LarusLayoutDocumentCollapseBinding) getCollapseViewStub().f328321c;
        if (r158 == null) goto L175;
        r158.f361347d.setText(r101.getTitle());
        r158.f361347d.setTextColor(ContextCompat.getColor(getContext(), v19.c.b(R.attr.larus_neutral_100, getContext(), R.color.larus_neutral_100)));
        r158.f361346c.setAlpha(1.0f);
        goto L175
    L97:
        if (r147.intValue() != r149) goto L99;
    L116:
        e1.x(r143.f361295i);
        getCollapseViewStub().a();
        boolean r159 = o0.d(r101.getBrief());
        Integer r160 = r101.getStatus();
        int r161 = ArtifactStatus.GENERATED.getValue();
        if (r160 != null) goto L120;
    L123:
        boolean r162 = false;
    L124:
        LarusCardDocumentBinding r163 = getBinding();
        boolean r164 = !LarkConnectorArtifactService.f365709a.c(r313);
        if (r164 == false) goto L127;
        e1.x(r163.f361291e);
        e1.x(r163.f361296j);
    L128:
        if (r162 == false) goto L148;
        getBinding().f361294h.setText(getContext().getString(R.string.larus_aiDoc_feature_name));
        getBinding().f361291e.setAlpha(1.0f);
        getBinding().f361291e.setEnabled(true);
        getBinding().f361296j.setAlpha(1.0f);
        getBinding().f361296j.setEnabled(true);
        if (r164 == false) goto L149;
        String r210 = r101.getResourceId();
        String r211 = r101.getArtifactMetaId();
        Integer r212 = r101.getResourceType();
        JSONObject r165 = new JSONObject();
        r165.put(MusicAppletPage.KEY_MESSAGE_ID, r313.getMessageId());
        Map<String, String> r166 = r313.getExt();
        if (r166 == null) goto L134;
        String r167 = r166.get("feishu_record_id");
    L135:
        r165.put("feishu_record_id", r167);
        Map<String, String> r168 = r313.getExt();
        if (r168 == null) goto L138;
        String r169 = r168.get("feishu_record_generated_type");
    L139:
        r165.put("feishu_record_generated_type", r169);
        Map<String, String> r170 = r313.getExt();
        if (r170 == null) goto L142;
        String r171 = r170.get("feishu_record_generated_type");
    L143:
        r165.put("record_scene", tx9.l.a(r171));
        r165.put("is_general_agent", com.larus.im.bean.message.a.r(r313));
        r165.put("chat_id", com.larus.im.bean.message.a.s(r313));
        Unit r172 = Unit.INSTANCE;
        if ((r310 instanceof by7.e) == false) goto L146;
        by7.e r314 = (by7.e) r310;
    L147:
        u0.e("message_card", r210, r211, r212, null, null, null, null, null, null, r165, r314, 1008);
        goto L149
    L146:
        r314 = null;
        goto L147
    L142:
        r171 = null;
        goto L143
    L138:
        r169 = null;
        goto L139
    L134:
        r167 = null;
    L149:
        if (r159 == false) goto L173;
        String r173 = r101.getBrief();
        if (r173 != null) goto L153;
        r173 = "";
    L153:
        LarusCardDocumentBinding r174 = getBinding();
        if (StringsKt.isBlank(r173) == false) goto L156;
        r174.f361299m.setTextColor(ContextCompat.getColor(getContext(), v19.c.b(R.attr.larus_neutral_30, getContext(), R.color.larus_neutral_30)));
        r173 = "# " + getContext().getString(R.string.larus_aiDoc_msgCard_emptyDoc);
    L157:
        e1.x(r174.f361299m);
        e1.o(r174.f361292f);
        String r175 = this.f361349a;
        StringBuilder r176 = new StringBuilder("lastLength:");
        String r177 = this.f361353e;
        if (r177 == null) goto L160;
        Integer r178 = Integer.valueOf(r177.length());
    L161:
        r176.append(r178);
        r176.append(", newLength:");
        if (r173 == null) goto L164;
        Integer r179 = Integer.valueOf(r173.length());
    L165:
        r176.append(r179);
        r102.i(r175, r176.toString());
        if (Intrinsics.areEqual(this.f361353e, r173) == true) goto L172;
        gw8.c.f483071a.getClass();
        gw8.c r213 = gw8.c.a.b();
        if (r213 == null) goto L170;
        Context r214 = getContext();
        int r215 = r142 - (i5.q() * 2);
        Lazy r180 = dg8.s.f468532a;
        lw8.l r181 = gw8.c.b.a(r213, r214, r215, r173, true, dg8.s.a(getContext(), false, false, r313, Integer.valueOf(i5.r0()), null, false, false, false, false, 1632), null, null, 224);
    L171:
        getBinding().f361299m.setMarkdown(r181);
        goto L172
    L170:
        r181 = null;
    L172:
        this.f361353e = r173;
        getBinding().f361287a.post(new k(this));
    L174:
        Unit r182 = Unit.INSTANCE;
        goto L175
    L164:
        r179 = null;
        goto L165
    L160:
        r178 = null;
        goto L161
    L156:
        r174.f361299m.setTextColor(ContextCompat.getColor(getContext(), v19.c.b(R.attr.larus_neutral_100, getContext(), R.color.larus_neutral_100)));
        goto L157
    L173:
        LarusCardDocumentBinding r183 = getBinding();
        e1.o(r183.f361299m);
        e1.x(r183.f361292f);
        e1.o(r183.f361293g);
        goto L174
    L148:
        r163.f361294h.setText(getContext().getString(R.string.larus_aiDoc_writing_hint));
        r163.f361291e.setAlpha(0.6f);
        r163.f361291e.setEnabled(false);
        r163.f361296j.setAlpha(0.6f);
        r163.f361296j.setEnabled(false);
        goto L149
    L127:
        e1.o(r163.f361291e);
        e1.o(r163.f361296j);
        goto L128
    L120:
        if (r160.intValue() != r161) goto L123;
        if (r159 == false) goto L123;
        r162 = true;
        goto L124
    L92:
        if (r147.intValue() == r148) goto L116;
    L17:
        r106 = null;
        goto L19
    L13:
        r111 = null;
        goto L14
    L191:
        return;
    }
}
