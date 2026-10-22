package com.larus.chat.job.impl.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larus.chat.job.impl.page.g0;
import com.larus.home.impl.sdk.FlowAppletServiceImpl;
import com.larus.im.bean.job.AIJob;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.e4;
import com.larus.platform.service.c1;
import com.larus.ui.arch.component.external.api.Component;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.capabilitykit.common.Ext;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.texturerender.TextureRenderKeys;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 '2\u00020\u0001:\u0001'B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u0011J$\u0010\u0014\u001a\u00020\u0015*\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\rH\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0002J\b\u0010\u001a\u001a\u00020\rH\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\rH\u0002J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u000bH\u0002J\b\u0010\u001f\u001a\u00020\u0011H\u0002J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\tH\u0002J\b\u0010!\u001a\u00020\u0011H\u0002J\u000e\u0010\"\u001a\u00020\t*\u0004\u0018\u00010#H\u0002J\u000e\u0010$\u001a\u0004\u0018\u00010#*\u00020\u000fH\u0002J\u0012\u0010%\u001a\u0004\u0018\u00010\t2\u0006\u0010&\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/chat/job/impl/component/ChatJobLynxItemComponent;", "Lcom/larus/ui/arch/component/external/api/Component;", KtvSubElement.CONTAINER, "Landroid/widget/FrameLayout;", "<init>", "(Landroid/widget/FrameLayout;)V", "lynxView", "Lcom/larus/platform/api/IvyPluginView;", "templateUrl", "", "fallbackView", "Landroid/view/View;", "renderGeneration", "", "boundItem", "Lcom/larus/chat/job/impl/page/ChatJobListItem$Job;", "bind", "", MapController.ITEM_LAYER_TAG, MapMonitorConst.EVENT_DESTROY, "lifeCycle", "Lcom/larus/platform/api/IvyPluginViewLifeCycle;", "url", "data", "generation", "clearLynxView", "nextRenderGeneration", "isCurrentRender", "", "showLynxView", "view", "showFallbackCard", "updateLynxData", "clearContainerPlaceholderHeight", "toRenderData", "Lorg/json/JSONObject;", "projectPayload", "statusText", "lastRunStatus", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatJobLynxItemComponent extends Component {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f324955r = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final FrameLayout f324956l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public e4 f324957m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f324958n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f324959o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f324960p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.larus.chat.job.impl.page.i.a f324961q;

    public static final class a {
        public a() {
        }

        public static final String a(com.larus.chat.job.impl.page.i.a r100) {
            int r101 = ChatJobLynxItemComponent.f324955r;
            if (r100.f325376b == false) goto L5;
            return "recommend";
        L5:
            return "task";
        }

        public static final String b(AIJob r100) {
            int r101 = ChatJobLynxItemComponent.f324955r;
            StringBuilder r102 = new StringBuilder("id=");
            String r103 = StringsKt.takeLast(r100.getJobId(), 6);
            if (StringsKt.isBlank(r103) == false) goto L5;
            r103 = "blank";
        L5:
            r102.append(r103);
            r102.append(",type=");
            r102.append(r100.getJobType());
            r102.append(",status=");
            r102.append(r100.getStatus());
            r102.append(",contentLength=");
            r102.append(r100.getContent().length());
            r102.append(",extLength=");
            r102.append(r100.getExt().length());
            return r102.toString();
        }
    }

    static {
        new a();
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.larus.chat.job.impl.component.m, java.lang.Object] */
    public final void N2() {
        e4 r100 = this.f324957m;
        if (r100 == null) goto L5;
        r100.destroy();
    L5:
        this.f324957m = null;
        this.f324958n = null;
        this.f324956l.setMinimumHeight(0);
        View r101 = this.f324959o;
        if (r101 != null) goto L8;
        int r102 = fz8.h.f479403a;
        Context r103 = this.f324956l.getContext();
        final ?? r104 = new m(this);
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, "onRetry");
        LinearLayout r105 = new LinearLayout(r103);
        r105.setOrientation(1);
        r105.setGravity(17);
        Resources r106 = r103.getResources();
        r105.setMinimumHeight((int) ((157 * WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics()).density) + 0.5f));
        r105.setPadding(i5.q(), i5.q(), i5.q(), i5.q());
        GradientDrawable r107 = gz8.g.a(r103);
        r107.setStroke(i5.b(), gz8.g.d(r103));
        r105.setBackground(r107);
        r105.setClickable(true);
        e1.d(r105, new fz8.g(r104));
        AppCompatImageView r108 = new AppCompatImageView(r103);
        r108.setImageResource(R.drawable.larus_chat_job_load_failed_ic);
        r105.addView(r108, new LinearLayout.LayoutParams(i5.Z(), i5.Z()));
        TextView r109 = new TextView(r103);
        r109.setGravity(17);
        r109.setIncludeFontPadding(false);
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        r109.setTextColor(v19.c.a(R.attr.larus_neutral_70, r103, R.color.larus_neutral_70));
        r109.setTextSize(15.0f);
        r109.setLineSpacing(0.0f, 1.5f);
        r109.setTypeface(Typeface.create("sans-serif-medium", 0));
        r109.setText(gz8.f.b("scheduledTasks_taskPage_desc_loadFail"));
        LinearLayout.LayoutParams r110 = new LinearLayout.LayoutParams(-2, -2);
        r110.topMargin = i5.h();
        Unit r111 = Unit.INSTANCE;
        r105.addView(r109, r110);
        this.f324959o = r105;
        r101 = r105;
    L8:
        this.f324956l.removeAllViews();
        this.f324956l.addView(r101, new FrameLayout.LayoutParams(-1, -2));
    }

    public ChatJobLynxItemComponent(fz8.k r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        this.f324956l = r100;
    }

    public final void L2(com.larus.chat.job.impl.page.i.a r310) {
        Intrinsics.checkNotNullParameter(r310, MapController.ITEM_LAYER_TAG);
        com.larus.chat.job.impl.page.i.a r100 = this.f324961q;
        if (r100 == null) goto L7;
        AIJob r101 = r100.f325375a;
        if (r101 == null) goto L7;
        String r102 = r101.getJobId();
    L9:
        if (Intrinsics.areEqual(r102, r310.f325375a.getJobId()) == true) goto L11;
        this.f324959o = null;
    L11:
        this.f324961q = r310;
        String r103 = r310.f325375a.getTemplateUrl();
        if (r103 != null) goto L14;
    L255:
        FLogger.f375446a.e("ChatJobLynxItem", "template url is empty cardType=" + a.a(r310) + " job=" + a.b(r310.f325375a));
        N2();
        return;
    L14:
        if ((!StringsKt.isBlank(r103)) == true) goto L17;
        r103 = null;
    L17:
        if (r103 == null) goto L255;
        Uri r104 = y0.j(r103);
        if (r104 != null) goto L21;
    L20:
        String r110 = r103;
        if (r110 == null) goto L255;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L36
        Object r106 = Result.m9449constructorimpl(new JSONObject(r310.f325375a.getContent()));     // Catch: Throwable -> L36
    L39:
        if (Result.m9455isFailureimpl(r106) == false) goto L41;
        r106 = null;
    L41:
        JSONObject r107 = (JSONObject) r106;
        if (r107 != null) goto L44;
        JSONObject r108 = null;
        String r111 = " job=";
        String r112 = "ChatJobLynxItem";
        r110 = r110;
    L225:
        if (r108 == null) goto L229;
        String r109 = new JSONObject().put("widget_data", r108).toString();
        if (r109 == null) goto L229;
    L231:
        if (this.f324957m == null) goto L238;
        String r113 = r110;
        if (Intrinsics.areEqual(this.f324958n, r113) == false) goto L239;
        this.f324956l.setMinimumHeight(0);
        this.f324960p++;
        e4 r114 = this.f324957m;
        if (r114 == null) goto L262;
        r114.updateData(r109);
        return;
    L262:
        return;
    L239:
        e4 r115 = this.f324957m;
        if (r115 == null) goto L242;
        r115.destroy();
    L242:
        this.f324957m = null;
        this.f324958n = null;
        this.f324956l.removeAllViews();
        this.f324959o = null;
        int r116 = this.f324960p + 1;
        this.f324960p = r116;
        c1 r117 = c1.f365723a;
        if (r117.d() == true) goto L245;
        r117.f();
    L245:
        this.f324958n = r113;
        e4 r118 = r117.g(this.f324956l.getContext(), r113, r109, new n(r310, this, r113, r116, r109));
        this.f324957m = r118;
        if (r118 == null) goto L248;
        View r119 = r118.getView();
    L249:
        if (r119 != null) goto L251;
        FLogger.f375446a.e(r112, "create ivy view failed cardType=" + a.a(r310) + r111 + a.b(r310.f325375a));
        N2();
        return;
    L251:
        this.f324956l.setMinimumHeight(0);
        this.f324959o = null;
        this.f324956l.removeAllViews();
        this.f324956l.addView(r119, new FrameLayout.LayoutParams(-1, -2));
        e4 r120 = this.f324957m;
        if (r120 == null) goto L265;
        r120.updateData(r109);
        return;
    L265:
        return;
    L248:
        r119 = null;
        goto L249
    L238:
        r113 = r110;
    L229:
        r109 = SliceInitService.DEFAULT_SWITCH;
        goto L231
    L44:
        String r121 = "conversation_id";
        if (r310.f325376b == false) goto L67;
        JSONObject r122 = r107.optJSONObject("recommend_job");
        if (r122 != null) goto L49;
    L66:
        r112 = "ChatJobLynxItem";
    L212:
        r111 = " job=";
        r110 = r110;
        r121 = "conversation_id";
        JSONObject r123 = null;
    L213:
        if (r123 == null) goto L224;
        AIJob r124 = r310.f325375a;
        Intrinsics.checkNotNullParameter(r124, "<this>");
        JSONObject r125 = new JSONObject().put(Ext.KEY_JOB_ID, r124.getJobId()).put("job_type", r124.getJobType()).put("status", r124.getStatus()).put("update_version", r124.getUpdateVersion());
        String r126 = r124.getConversationId();
        if (r126 == null) goto L217;
        r125.put(r121, r126);
    L217:
        JSONObject r127 = r125.put("create_time", r124.getCreateTime()).put("update_time", r124.getUpdateTime()).put("content", r124.getContent()).put("ext", r124.getExt());
        String r128 = r124.getLocalJobId();
        if (r128 == null) goto L220;
        r127.put("local_job_id", r128);
    L220:
        String r129 = r124.getTemplateUrl();
        if (r129 == null) goto L223;
        r127.put("template_url", r129);
    L223:
        r108 = r123.put("job", r127);
        goto L225
    L224:
        r108 = null;
        goto L225
    L49:
        if (r122.optInt("status") != 1) goto L51;
        boolean r130 = true;
    L52:
        if (r130 == true) goto L55;
        r122 = null;
    L55:
        if (r122 == null) goto L66;
        String r131 = r122.optString(Ext.KEY_JOB_ID);
        if (StringsKt.isBlank(r131) == false) goto L59;
        r131 = r310.f325375a.getJobId();
    L59:
        String r132 = StringsKt.trim(r122.optString("description")).toString();
        if (r132.length() != 0) goto L62;
        boolean r133 = true;
    L63:
        if (r133 == false) goto L65;
        r132 = r122.optString(EventConstant.Key.RETAIN_PROMPT);
    L65:
        r112 = "ChatJobLynxItem";
        r123 = new JSONObject().put("job_template_id", r131).put("display", new JSONObject().put("title", r122.optString("title")).put("summary", r132));
        r111 = " job=";
        r110 = r110;
        r121 = "conversation_id";
        goto L213
    L62:
        r133 = false;
        goto L63
    L51:
        r130 = false;
        goto L52
    L67:
        r112 = "ChatJobLynxItem";
        int r134 = g0.f325370a;
        JSONObject r135 = r107.optJSONObject(g0.a(r310.f325375a.getJobType()));
        if (r135 == null) goto L212;
        JSONObject r136 = new JSONObject().put(Ext.KEY_JOB_ID, r310.f325375a.getJobId()).put("job_type", r310.f325375a.getJobType()).put("conversation_id", r310.f325375a.getConversationId()).put("enter_method", "cron_job");
        JSONObject r137 = new JSONObject().put("title", r135.optString("title")).put("summary", r135.optString(EventConstant.Key.RETAIN_PROMPT));
        int r138 = r310.f325375a.getJobType();
        if (r138 == 1) goto L74;
        if (r138 != 3) goto L76;
        String r139 = gz8.f.b("from_feishu_trigger");
        r111 = " job=";
        r110 = r110;
        r121 = "conversation_id";
    L207:
        JSONObject r140 = r137.put("schedule_text", r139);
        if (r135.optInt("last_run_status") != 2) goto L210;
        String r141 = gz8.f.b("scheduledTasks_header_failed");
    L211:
        r123 = r136.put("display", r140.put("status_text", r141).put("status_code", r310.f325375a.getStatus()));
        goto L213
    L210:
        r141 = null;
    L76:
        r111 = " job=";
        r110 = r110;
        r121 = "conversation_id";
    L206:
        r139 = null;
        goto L207
    L74:
        JSONObject r142 = r135.optJSONObject("schedule_config");
        if (r142 == null) goto L76;
        if (r142.has("display_frequency") == false) goto L80;
        String r143 = StringsKt.trim(r142.optString("display_frequency")).toString();
    L81:
        int r144 = r142.optInt(TextureRenderKeys.KEY_IS_TEXTURE_REPEAT_TYPE);
        r111 = " job=";
        if (r144 == 1) goto L84;
        r110 = r110;
        r121 = "conversation_id";
        if (r143 == null) goto L119;
        if (r143.length() <= 0) goto L112;
        boolean r145 = true;
    L113:
        if (r145 == true) goto L116;
        r143 = null;
    L116:
        if (r143 == null) goto L119;
    L117:
        r139 = r143;
        goto L207
    L112:
        r145 = false;
    L119:
        if (r144 == 1) goto L206;
        if (r144 != 2) goto L123;
        JSONObject r146 = r142.optJSONObject("time");
        if (r146 == null) goto L205;
        Integer r147 = gz8.e.b(r146, "minute");
        if (r147 == null) goto L205;
        gz8.d r148 = gz8.d.f483418a;
        int r149 = r147.intValue();
        r148.getClass();
        r139 = gz8.d.d(r149);
        if (r139 != null) goto L207;
    L205:
        r139 = gz8.f.e();
        goto L207
    L123:
        if (r144 != 3) goto L125;
        JSONObject r150 = r142.optJSONObject("time");
        if (r150 == null) goto L197;
        String r151 = gz8.e.a(r150);
        if (r151 == null) goto L197;
        r139 = gz8.f.d() + " · " + r151;
        if (r139 != null) goto L207;
    L197:
        r139 = gz8.f.d();
        goto L207
    L125:
        if (r144 == 4) goto L131;
        if (r144 != 5) goto L206;
        if (r142.has("custom_schedule_prompt") == false) goto L206;
        r139 = r142.optString("custom_schedule_prompt");
        goto L207
    L131:
        JSONArray r152 = r142.optJSONArray("weekdays");
        if (r152 == null) goto L134;
        int r153 = r152.length();
    L135:
        IntRange r154 = RangesKt.until(0, r153);
        ArrayList r155 = new ArrayList();
        Iterator<Integer> r156 = r154.iterator();
    L137:
        if (r156.hasNext() == false) goto L182;
        int r157 = ((IntIterator) r156).nextInt();
        gz8.d r210 = gz8.d.f483418a;
        if (r152 == null) goto L141;
        int r158 = r152.optInt(r157);
    L142:
        r210.getClass();
        Integer r159 = gz8.d.e(r158);
        if (r159 != null) goto L146;
    L148:
        if (r159 != null) goto L151;
    L153:
        if (r159 != null) goto L156;
    L158:
        if (r159 != null) goto L161;
    L163:
        if (r159 != null) goto L166;
    L168:
        if (r159 != null) goto L171;
    L173:
        if (r159 != null) goto L176;
    L178:
        String r160 = null;
    L179:
        if (r160 == null) goto L137;
        r155.add(r160);
        goto L137
    L176:
        if (r159.intValue() != 7) goto L178;
        r160 = gz8.f.b("scheduledTasks_newTask_frequency_sun");
        goto L179
    L171:
        if (r159.intValue() != 6) goto L173;
        r160 = gz8.f.b("scheduledTasks_newTask_frequency_sat");
        goto L179
    L166:
        if (r159.intValue() != 5) goto L168;
        r160 = gz8.f.b("scheduledTasks_newTask_frequency_fri");
        goto L179
    L161:
        if (r159.intValue() != 4) goto L163;
        r160 = gz8.f.b("scheduledTasks_newTask_frequency_thur");
        goto L179
    L156:
        if (r159.intValue() != 3) goto L158;
        r160 = gz8.f.b("scheduledTasks_newTask_frequency_wed");
        goto L179
    L151:
        if (r159.intValue() != 2) goto L153;
        r160 = gz8.f.b("scheduledTasks_newTask_frequency_tue");
        goto L179
    L146:
        if (r159.intValue() != 1) goto L148;
        r160 = gz8.f.b("scheduledTasks_newTask_frequency_mon");
        goto L179
    L141:
        r158 = 0;
        goto L142
    L182:
        String r161 = gz8.f.h(r155);
        String[] r162 = new String[2];
        if (StringsKt.isBlank(r161) == false) goto L185;
        r161 = gz8.f.g();
    L185:
        r162[0] = r161;
        JSONObject r163 = r142.optJSONObject("time");
        if (r163 == null) goto L188;
        String r164 = gz8.e.a(r163);
    L189:
        r162[1] = r164;
        r139 = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(r162), " · ", null, null, 0, null, null, 62, null);
        goto L207
    L188:
        r164 = null;
        goto L189
    L134:
        r153 = 0;
        goto L135
    L84:
        if (r142.has("execute_at") == false) goto L86;
        String r165 = r142.optString("execute_at");
    L87:
        if (r165 != null) goto L89;
    L96:
        String r166 = r143;
    L97:
        if (r166 == null) goto L104;
        gz8.d.f483418a.getClass();
        Intrinsics.checkNotNullParameter(r166, "value");
        Long r167 = gz8.d.f(r166);
        if (r167 == null) goto L101;
        String r168 = r165;
        long r169 = r167.longValue();
        String r170 = r168;
        Date r171 = new Date(r169);
        Locale r172 = Locale.getDefault();
        String r173 = DateFormat.getDateInstance(1, r172).format(r171);
        Calendar r174 = Calendar.getInstance(r172);
        r174.setTimeInMillis(r169);
        r139 = r173 + " · " + gz8.d.c(r174.get(11), r174.get(12));
    L102:
        if (r139 != null) goto L207;
    L105:
        if (r143 != null) goto L117;
        r139 = r170;
        goto L207
    L101:
        r170 = r165;
        r139 = null;
        goto L102
    L104:
        r170 = r165;
        r110 = r110;
        r121 = "conversation_id";
        goto L105
    L89:
        if (r165.length() <= 0) goto L91;
        boolean r175 = true;
    L92:
        if (r175 == false) goto L94;
        r166 = r165;
    L95:
        if (r166 != null) goto L97;
    L94:
        r166 = null;
        goto L95
    L91:
        r175 = false;
        goto L92
    L86:
        r165 = null;
        goto L87
    L80:
        r143 = null;
    L36:
        th = move-exception;
        Result.Companion r176 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L39
    L21:
        Uri r177 = y0.l(y0.l(y0.l(r104, "loader_name", "forest"), "forest_newly_builtin", "1"), "enable_lynx_generic_fetcher", "1");
        IFlowSdkDepend r178 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r178 == null) goto L24;
        FlowAppletServiceImpl r179 = r178.g0();
    L25:
        if (r179 != null) goto L27;
    L29:
        boolean r180 = false;
    L30:
        if (r180 == false) goto L32;
        r177 = y0.a(r177, r179.f());
    L32:
        r103 = r177.toString();
        goto L20
    L27:
        if (r179.e() != true) goto L29;
        r180 = true;
        goto L30
    L24:
        r179 = null;
    L7:
        r102 = null;
        goto L9
    }

    public static final boolean F2(ChatJobLynxItemComponent r100, String r101, int r102) {
        if (Intrinsics.areEqual(r100.f324958n, r101) == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.f324960p != r102) goto L7;
        return true;
    }
}
