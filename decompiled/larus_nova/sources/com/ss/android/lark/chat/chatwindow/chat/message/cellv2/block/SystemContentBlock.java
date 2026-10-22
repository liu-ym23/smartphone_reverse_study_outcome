package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.api.extension.message.system.SystemMessageConfig;
import com.ss.android.lark.blueprint.BlueprintCell;
import com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.system.open.SystemContentUtilV2;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.content.SystemContent;
import com.ss.android.lark.chat.entity.wallpaper.ChatThemeInfo;
import com.ss.android.lark.chat.export.entity.message.content.ContentValue;
import com.ss.android.lark.chat.export.entity.message.content.SystemMessageType;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class SystemContentBlock implements com.ss.android.lark.blueprint.i<y6b.a<?>, com.ss.android.lark.chat.base.view.vo.message.d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.blueprint.g f412975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IMMessageKeys$Blocks f412976b;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.blueprint.k<View> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f412977a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f412978b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f412979c;

        @Override // com.ss.android.lark.blueprint.k
        public final View getView() {
            return this.f412977a;
        }

        public b(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f412977a = r100;
            TextView r101 = (TextView) r100.findViewById(R.id.system_label);
            this.f412978b = r101;
            this.f412979c = (TextView) r100.findViewById(R.id.system_label_action);
            r101.setHighlightColor(UIUtils.getColor(r100.getContext(), R.color.color_transparent));
            r101.setTextSize(0, zz7.b.h(r100.getContext(), 14));
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f412980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y6b.b f412981b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Chat f412982c;

        public c(Context r100, y6b.b r101, Chat r102) {
            this.f412980a = r100;
            this.f412981b = r101;
            this.f412982c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            w4b.c r101 = ChatCoreModule.a();
            if (r101 == null) goto L8;
            w4b.b0 r102 = r101.getProfileDependency();
            if (r102 == null) goto L9;
            r102.b(this.f412980a, this.f412981b, this.f412982c);
            return;
        L9:
            return;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.blueprint.i
    public final Class<com.ss.android.lark.chat.base.view.vo.message.d> b() {
        return null;
    }

    @Override // com.ss.android.lark.blueprint.i
    public final com.ss.android.lark.blueprint.j getKey() {
        return this.f412976b;
    }

    public SystemContentBlock(com.ss.android.lark.blueprint.g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        this.f412975a = r100;
        this.f412976b = IMMessageKeys$Blocks.SYSTEM_CONTENT;
    }

    @Override // com.ss.android.lark.blueprint.i
    public final void a(com.ss.android.lark.blueprint.m<y6b.a<?>> r100, com.ss.android.lark.blueprint.q<y6b.a<?>> r101) {
        com.ss.android.lark.blueprint.i.a.a(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v52, types: [android.text.SpannableStringBuilder] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13, types: [m2b.a] */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r8v25, types: [android.text.SpannableStringBuilder, java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(com.ss.android.lark.blueprint.m<y6b.a<?>> r210, com.ss.android.lark.blueprint.q<y6b.a<?>> r211, y6b.a<?> r212) {
        Intrinsics.checkNotNullParameter(r210, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r211, "layout");
        Intrinsics.checkNotNullParameter(r212, "data");
        b r100 = (b) r211.c(this.f412976b, IMMessageKeys$Slots.CONTENT, SystemContentBlock$update$itemView$1.INSTANCE);
        Context r101 = this.f412975a.getContext();
        i3b.d r102 = (i3b.d) this.f412975a.f410652c.a(i3b.d.class);
        if (r102 == null) goto L269;
        m2b.a r103 = r102.a();
        if (r103 != null) goto L8;
        return;
    L8:
        if ((r212 instanceof v5b.c) == false) goto L10;
        y6b.a<?> r104 = r212;
    L11:
        if (r104 != null) goto L13;
        return;
    L13:
        SystemContentUtilV2.f412222a.getClass();
        Intrinsics.checkNotNullParameter(r103, "chatContext");
        com.ss.android.lark.chat.base.view.vo.message.d r105 = (com.ss.android.lark.chat.base.view.vo.message.d) r104.b();
        String r110 = "";
        if (r105 == null) goto L191;
        SystemContent r106 = (SystemContent) r105.f553338a;
        if (r106 == null) goto L191;
        Lazy r111 = SystemContentUtilV2.f412223b;
        List r112 = (List) ((Pair) r111.getValue()).getFirst();
        List r113 = (List) ((Pair) r111.getValue()).getSecond();
        com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.system.open.c r114 = new com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.system.open.c(r106, r104, r103);
        if (r106.getType() != SystemMessageType.LOCAL_MENTION_BOTS_NOT_IN_CHAT) goto L151;
        String r107 = r114.context().getString(R.string.Lark_IM_ServerMsg_AgentNotInGroup_Text);
        Intrinsics.checkNotNullParameter(r107, ThumbGlideUrl.SOURCE_TEMPLATE);
        Intrinsics.checkNotNullParameter(r106, "systemContent");
        Intrinsics.checkNotNullParameter(r112, "contentProcessorList");
        Intrinsics.checkNotNullParameter(r113, "extraProcessorList");
        Intrinsics.checkNotNullParameter(r114, "systemActionContext");
        int r115 = 0;
        int r116 = 0;
    L21:
        int r117 = StringsKt.indexOf$default(r107, "{add}", r116, false, 4, null);
        if (r117 < 0) goto L25;
        r115 = r115 + 1;
        r116 = r117 + 5;
        goto L21
    L25:
        if (r106.getType() != SystemMessageType.LOCAL_MENTION_BOTS_NOT_IN_CHAT) goto L147;
        int r118 = StringsKt.indexOf$default(r107, "{agent}", 0, false, 6, null);
        if (r118 >= 0) goto L29;
    L31:
        boolean r108 = false;
    L32:
        if (r108 == false) goto L147;
        if (r115 > 1) goto L147;
        ArrayList<String> r109 = r106.getLocalMentionAgentIds();
        Iterator r119 = r106.getSystemContents().entrySet().iterator();
    L38:
        if (r119.hasNext() == false) goto L43;
        Object r120 = r119.next();
        Iterator r121 = r119;
        if (Intrinsics.areEqual(((Map.Entry) r120).getKey(), "agent") == true) goto L44;
        r119 = r121;
    L44:
        Map.Entry r122 = (Map.Entry) r120;
        if (r122 == null) goto L51;
        List r123 = (List) r122.getValue();
        if (r109.isEmpty() == true) goto L51;
        if (r109.size() != r123.size()) goto L51;
        HashSet r124 = new HashSet(r109.size());
        Iterator<Integer> r125 = CollectionsKt.getIndices(r109).iterator();
    L54:
        if (r125.hasNext() == false) goto L83;
        String r126 = r110;
        int r127 = ((IntIterator) r125).nextInt();
        Long r128 = StringsKt.toLongOrNull((String) ListProtector.get(r109, r127));
        if (r128 == null) goto L84;
        if (r128.longValue() <= 0) goto L60;
        boolean r213 = true;
    L61:
        if (r213 == true) goto L64;
        r128 = null;
    L64:
        if (r128 == null) goto L84;
        ArrayList<String> r214 = r109;
        String r129 = r128.toString();
        if (r129 == null) goto L84;
        ContentValue r130 = (ContentValue) ListProtector.get(r123, r127);
        if (r124.add(r129) == false) goto L84;
        HashSet r131 = r124;
        if (Intrinsics.areEqual(r130.getId(), r129) == false) goto L84;
        if (SystemContentUtilV2.f412224c.contains(r130.getContentValueType()) == false) goto L84;
        String r132 = r130.getValue();
        if (r132 != null) goto L76;
    L79:
        boolean r133 = true;
    L80:
        if (r133 == true) goto L84;
        r124 = r131;
        r110 = r126;
        r109 = r214;
        goto L54
    L76:
        if (StringsKt.isBlank(r132) == true) goto L79;
        r133 = false;
        goto L80
    L60:
        r213 = false;
    L84:
        Map.Entry r134 = null;
    L85:
        if (r134 != null) goto L87;
        Log.e("SystemContentUtilV2", "local mention-bot raw and resolved agents do not match");
    L148:
        CharSequence r135 = r126;
    L149:
        CharSequence r136 = r135;
        ContentValue r137 = null;
    L192:
        com.ss.android.lark.biz.im.api.message.params.x r138 = (com.ss.android.lark.biz.im.api.message.params.x) r103.d0(com.ss.android.lark.biz.im.api.message.params.x.class);
        int r139 = UIUtils.dp2px(r101, 30.0f);
        if (r138 == null) goto L197;
        int r140 = r138.f410395f;
        if (r140 <= 0) goto L197;
        float r141 = r140;
    L198:
        int r142 = UIUtils.dp2px(r101, r141);
        r100.f412977a.setPadding(r139, r142, r139, r142);
        ChatThemeInfo r143 = r103.r8();
        if (r143 != null) goto L201;
    L209:
        r100.f412978b.setTextColor(UIUtils.getColor(r101, R.color.text_placeholder));
        r100.f412978b.setBackgroundColor(UIUtils.getColor(r101, R.color.transparent));
    L210:
        com.ss.android.lark.biz.im.api.message.params.x r144 = (com.ss.android.lark.biz.im.api.message.params.x) r103.d0(com.ss.android.lark.biz.im.api.message.params.x.class);
        if (r144 == null) goto L240;
        int r145 = r144.f410390a;
        if (r145 <= 0) goto L215;
        r100.f412978b.setTextSize(0, r145);
    L215:
        i3b.d r146 = (i3b.d) this.f412975a.f410652c.a(i3b.d.class);
        if (r146 == null) goto L218;
        ?? r147 = r146.a();
    L220:
        if (r144.f410392c == false) goto L239;
        if (r147 == 0) goto L239;
        Object r148 = r212.b();
        if (r148 == null) goto L229;
        Object r149 = ((com.ss.android.lark.chat.base.view.vo.message.d) r148).f553338a;
        if (r149 == null) goto L229;
        if (((SystemContent) r149).getSystemTypeValue() != 175) goto L229;
        boolean r150 = true;
    L230:
        if (r150 == false) goto L239;
        Chat r151 = r147.getChat();
        y6b.b r152 = r147.x8();
        String r153 = UIUtils.getString(r101, r144.f410394e);
        if (r152 == null) goto L240;
        if (r151 == null) goto L240;
        if (com.ss.android.lark.message.lynxcard.message.r.a(r153) == false) goto L240;
        r100.f412979c.setText(r153);
        r100.f412979c.setTextColor(r144.f410393d);
        r100.f412979c.setVisibility(0);
        r100.f412979c.setOnClickListener(new c(r101, r152, r151));
        int r154 = r144.f410390a;
        if (r154 <= 0) goto L240;
        r100.f412979c.setTextSize(0, r154);
    L229:
        r150 = false;
    L239:
        r100.f412979c.setVisibility(8);
        goto L240
    L218:
        r147 = r137;
    L240:
        r100.f412978b.setText(r136);
        if ((r136 instanceof SpannableStringBuilder) == false) goto L270;
        r100.f412978b.setMovementMethod(LinkMovementMethod.getInstance());
        return;
    L270:
        return;
    L201:
        if (com.ss.android.lark.chat.utils.p.g(r143.getComponentScene()) == false) goto L209;
        if (r136.length() != 0) goto L205;
        boolean r155 = true;
    L206:
        if (r155 == true) goto L209;
        r100.f412978b.setTextColor(com.ss.android.lark.chat.utils.p.c(r101));
        r100.f412978b.setBackground(UIUtils.getDrawable(r101, R.drawable.bg_system_msg));
        goto L210
    L205:
        r155 = false;
    L197:
        r141 = 12.0f;
        goto L198
    L87:
        SpannableStringBuilder r156 = SystemContentUtilV2.a(r134, r112, r114);
        if (r156.length() != 0) goto L90;
        boolean r157 = true;
    L91:
        if (r157 == false) goto L94;
        Log.e("SystemContentUtilV2", "local mention-bot resolved agent text is empty");
        goto L148
    L94:
        SpannableStringBuilder r158 = SystemContentUtilV2.b(new SpannableStringBuilder(r107), "{agent}", r156);
        Iterator r159 = r113.iterator();
    L96:
        if (r159.hasNext() == false) goto L100;
        Object r160 = r159.next();
        ContentValue r161 = null;
        if (((com.ss.android.lark.biz.im.api.extension.message.system.c) r160).a(null, r114) == false) goto L96;
        Object r162 = r160;
    L101:
        com.ss.android.lark.biz.im.api.extension.message.system.c r163 = (com.ss.android.lark.biz.im.api.extension.message.system.c) r162;
        ?? r164 = r161;
        if (r163 == null) goto L111;
        SpannableStringBuilder r165 = new SpannableStringBuilder();
        r163.c(r165, r161, r114);
        r165.append(r163.b(r161, r114));
        if (r165.length() <= 0) goto L107;
        boolean r166 = true;
    L108:
        if (r166 == false) goto L110;
        r165.setSpan(new com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.system.open.b(r163, r114, r161, r114.context()), 0, r165.length(), 33);
    L110:
        r164 = r165;
        goto L111
    L107:
        r166 = false;
    L111:
        if (r164 != 0) goto L113;
    L116:
        boolean r167 = true;
    L117:
        if (r167 == true) goto L119;
    L134:
        if (r164 != 0) goto L136;
    L139:
        boolean r168 = true;
    L140:
        if (r168 == false) goto L143;
    L141:
        r135 = r158;
        goto L149
    L143:
        if (r115 != 1) goto L145;
        SpannableStringBuilder r169 = SystemContentUtilV2.b(r158, "{add}", r164);
    L146:
        r135 = r169;
        goto L149
    L145:
        r169 = r158.append(" ").append(r164);
        Intrinsics.checkNotNull(r169);
        goto L146
    L136:
        if (r164.length() == 0) goto L139;
        r168 = false;
        goto L140
    L119:
        if (r115 != 1) goto L134;
        int r170 = StringsKt.indexOf$default(r158, "{add}", 0, false, 6, null);
        if (r170 < 0) goto L141;
        int r171 = r170 + 5;
        if (r170 <= 0) goto L129;
        int r172 = r170 - 1;
        if (CharsKt.isWhitespace(r158.charAt(r172)) == false) goto L129;
        r170 = r172;
    L133:
        r158.delete(r170, r171);
    L129:
        if (r171 >= r158.length()) goto L133;
        if (CharsKt.isWhitespace(r158.charAt(r171)) == false) goto L133;
        r171 = r171 + 1;
        goto L133
    L113:
        if (r164.length() == 0) goto L116;
        r167 = false;
        goto L117
    L100:
        r161 = null;
        r162 = null;
        goto L101
    L90:
        r157 = false;
        goto L91
    L83:
        r126 = r110;
        r134 = r122;
    L51:
        r126 = "";
        goto L84
    L43:
        r120 = null;
        goto L44
    L29:
        if (r118 != StringsKt.lastIndexOf$default(r107, "{agent}", 0, false, 6, null)) goto L31;
        r108 = true;
    L147:
        r126 = "";
        Log.e("SystemContentUtilV2", "invalid local mention-bot template or system type");
        goto L148
    L151:
        if (r106.getVersion() != 0) goto L154;
        boolean r173 = ((EnumSet) SystemMessageConfig.f410214a.getValue()).contains(r106.getType());
    L160:
        if (((EnumSet) SystemMessageConfig.f410215b.getValue()).contains(r106.getType()) == false) goto L162;
        r173 = true;
    L162:
        if (r173 == false) goto L190;
        Intrinsics.checkNotNullParameter(r106, "systemContent");
        Intrinsics.checkNotNullParameter(r112, "processorList");
        Intrinsics.checkNotNullParameter(r114, "systemActionContext");
        SpannableStringBuilder r174 = new SpannableStringBuilder();
        Intrinsics.checkNotNullParameter(r106, "systemContent");
        String r175 = r106.getMessageTemplate();
        Set<String> r176 = r106.getSystemContents().keySet();
        Iterator<Map.Entry<String, String>> r177 = r106.getContents().entrySet().iterator();
        String r215 = r175;
    L165:
        if (r177.hasNext() == false) goto L172;
        Map.Entry<String, String> r178 = r177.next();
        if (r176.contains(r178.getKey()) == true) goto L165;
        if (r215 == null) goto L170;
        r215 = StringsKt.replace$default(r215, "{" + r178.getKey() + '}', Matcher.quoteReplacement(r178.getValue()), false, 4, null);
        goto L165
    L170:
        r215 = null;
        goto L165
    L172:
        if (r215 != null) goto L174;
        String r179 = "";
    L175:
        SpannableStringBuilder r180 = r174.append(r179);
        Iterator<Map.Entry<String, List<ContentValue>>> r181 = r106.getSystemContents().entrySet().iterator();
        SpannableStringBuilder r182 = r180;
    L177:
        if (r181.hasNext() == false) goto L179;
        Map.Entry<String, List<ContentValue>> r183 = r181.next();
        Intrinsics.checkNotNull(r182);
        r182 = SystemContentUtilV2.b(r182, "{" + r183.getKey() + '}', SystemContentUtilV2.a(r183, r112, r114));
        goto L177
    L179:
        Intrinsics.checkNotNull(r182);
        Intrinsics.checkNotNullParameter(r182, "result");
        Intrinsics.checkNotNullParameter(r113, "processorList");
        Intrinsics.checkNotNullParameter(r114, "actionContext");
        Iterator r184 = r113.iterator();
    L181:
        if (r184.hasNext() == false) goto L185;
        Object r185 = r184.next();
        r137 = null;
        if (((com.ss.android.lark.biz.im.api.extension.message.system.c) r185).a(null, r114) == false) goto L181;
    L186:
        com.ss.android.lark.biz.im.api.extension.message.system.c r186 = (com.ss.android.lark.biz.im.api.extension.message.system.c) r185;
        r136 = r182;
        if (r186 == null) goto L192;
        int r187 = r182.length();
        r182.append(" ");
        r186.c(r182, r137, r114);
        r182.append(r186.b(r137, r114));
        r182.setSpan(new com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.system.open.b(r186, r114, r137, r114.context()), r187, r182.length(), 33);
        r136 = r182;
        goto L192
    L185:
        r137 = null;
        r185 = null;
        goto L186
    L174:
        r179 = r215;
        goto L175
    L190:
        r137 = null;
        r136 = r106.getFormattedContent();
        goto L192
    L154:
        if (r106.getVersion() > 0) goto L156;
    L158:
        r173 = false;
        goto L160
    L156:
        if (r106.isMsgClickable() == false) goto L158;
        r173 = true;
    L191:
        r137 = null;
        r136 = "";
        goto L192
    L10:
        r104 = null;
        goto L11
    }

    @Override // com.ss.android.lark.blueprint.i
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r100, com.ss.android.lark.blueprint.q<y6b.a<?>> r101, y6b.a<?> r102) {
        update2(r100, r101, r102);
    }

    @Override // com.ss.android.lark.blueprint.i
    public final void c(BlueprintCell r100, com.ss.android.lark.blueprint.q r101, Object r102, Object r103) {
        com.ss.android.lark.blueprint.i.a.b(this, r100, r101, (y6b.a) r102, (com.ss.android.lark.chat.base.view.vo.message.d) r103);
    }
}
