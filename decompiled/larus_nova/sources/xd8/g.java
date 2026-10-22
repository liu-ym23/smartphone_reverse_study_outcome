package xd8;

import com.alibaba.gaiax.render.view.basic.GXImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.component.list.ChatListComponentViewModel;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.bmhome.social.userchat.model.c0;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import ic8.n;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import xc8.l;

/* JADX INFO: loaded from: classes25.dex */
public final class g implements td8.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final td8.d f563289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f563290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f563291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Set<Integer> f563292d;

    public static final class a {
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues((Integer) ((Pair) r101).getFirst(), (Integer) ((Pair) r100).getFirst());
        }
    }

    static {
    }

    @Override // td8.c
    public final boolean a(int r100, xc8.b r101, xc8.b r102, List<? extends xc8.b> r103) {
        Intrinsics.checkNotNullParameter(r102, "current");
        Intrinsics.checkNotNullParameter(r103, "input");
        return true;
    }

    public g(td8.d r100) {
        Intrinsics.checkNotNullParameter(r100, "taskContext");
        this.f563289a = r100;
        this.f563290b = LazyKt.lazy(new e());
        this.f563291c = LazyKt.lazy(new f());
        this.f563292d = SetsKt.emptySet();
    }

    @Override // td8.c
    public final List<xc8.b> b(int r210, xc8.b r211, xc8.b r310, List<xc8.b> r311) {
        Intrinsics.checkNotNullParameter(r310, "current");
        Intrinsics.checkNotNullParameter(r311, "input");
        int r110 = 2;
        xc8.b r111 = null;
        boolean r100 = true;
        if (r210 >= 0) goto L144;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r311.iterator();
    L5:
        int r103 = 1002;
        if (r102.hasNext() == false) goto L19;
        Object r104 = r102.next();
        xc8.b r105 = (xc8.b) r104;
        if (r105.getMessage().getContentType() != 1002) goto L16;
        Map<String, String> r106 = r105.getMessage().getExt();
        if (r106 == null) goto L12;
        String r107 = r106.get("visible_message_timestamp");
    L14:
        if (Intrinsics.areEqual(r107, "1") == false) goto L16;
        boolean r108 = true;
    L17:
        if (r108 == true) goto L5;
        r101.add(r104);
        goto L5
    L12:
        r107 = null;
    L16:
        r108 = false;
        goto L17
    L19:
        List<xc8.b> r112 = CollectionsKt.toMutableList(r101);
        wc9.e r113 = this.f563289a.g();
        int r109 = ra9.a.f536860a;
        int r114 = ga9.a.d("insert_visible_message_timestamp_interval", 900);
        if (r114 > 0) goto L26;
        c0 r115 = this.f563289a.l();
        if (r115 == null) goto L24;
        r115.a();
    L24:
        return r112;
    L26:
        if (com.larus.bmhome.utils.i.f(r113) == true) goto L28;
    L142:
        return r112;
    L28:
        if (this.f563289a.E8() == true) goto L142;
        c0 r116 = this.f563289a.l();
        if (r116 != null) goto L33;
    L35:
        boolean r117 = false;
    L36:
        ArrayList r118 = new ArrayList();
        Iterator<T> r119 = r112.iterator();
        int r120 = -1;
        int r121 = -1;
        boolean r122 = false;
        int r212 = 0;
    L38:
        if (r119.hasNext() == false) goto L120;
        Object r123 = r119.next();
        int r213 = r212 + 1;
        if (r212 >= 0) goto L42;
        CollectionsKt.throwIndexOverflow();
    L42:
        xc8.b r214 = (xc8.b) r123;
        Message r124 = r214.getMessage();
        if (com.larus.bmhome.chat.bean.d.i0(r124) == false) goto L48;
        if (com.larus.bmhome.chat.bean.d.w(r124) == true) goto L48;
    L67:
        boolean r125 = false;
    L68:
        if (r125 == true) goto L70;
    L94:
        boolean r126 = false;
    L95:
        if (r126 == true) goto L109;
        if (r111 != null) goto L98;
    L108:
        ArrayList r127 = r118;
        r114 = r114;
        r214 = r111;
    L119:
        r118 = r127;
        r114 = r114;
        r212 = r213;
        r111 = r214;
        r100 = true;
        r103 = 1002;
        r110 = 2;
        goto L38
    L98:
        if (r214.getMessage().getContentType() != r103) goto L101;
        r122 = true;
        goto L108
    L101:
        if (com.larus.bmhome.chat.bean.d.Y(r214.getMessage()) == true) goto L107;
        Integer r128 = b0.c(r214.getMessage());
        if (r128 == null) goto L108;
        if (r128.intValue() != 3) goto L108;
    L107:
        r121 = r213;
        goto L108
    L109:
        if (r111 != null) goto L111;
    L117:
        r127 = r118;
    L118:
        r120 = r212;
        r121 = -1;
        r122 = false;
        goto L119
    L111:
        if ((r111.getMessage().getCreateTime() - r214.getMessage().getCreateTime()) < r114) goto L117;
        if (r122 == true) goto L117;
        if (r121 >= 0) goto L116;
        r121 = r120 + 1;
    L116:
        r127 = r118;
        r127.add(TuplesKt.to(Integer.valueOf(r121), c(this, r111.getMessage(), r214.getMessage(), false, false, false, true, 28)));
        goto L118
    L70:
        if (r124.getCreateTime() <= 0) goto L94;
        if (b0.f(r124) == true) goto L94;
        if (com.larus.bmhome.chat.bean.d.z0(r124) == true) goto L94;
        if (com.larus.bmhome.chat.bean.d.O0(r124) == true) goto L94;
        if (com.larus.bmhome.chat.bean.d.I0(r124) == true) goto L94;
        CopyOnWriteArraySet<xc8.f.a> r129 = xc8.f.f563237a;
        xc8.g r130 = (xc8.g) xc8.f.f563240d.getValue();
        if (r130 != null) goto L82;
    L84:
        boolean r131 = false;
    L85:
        if (r131 == true) goto L94;
        int r132 = r124.getContentType();
        if (r132 == 0) goto L91;
        if (r132 == r110) goto L91;
        switch(r132) {
            case 1001: goto L91;
            case 1002: goto L91;
            case 1003: goto L91;
            default: goto L90;
        };
    L90:
        boolean r133 = true;
    L92:
        if (r133 == false) goto L94;
        r126 = true;
    L91:
        r133 = false;
        goto L92
    L82:
        if (r130.a(r124) != r100) goto L84;
        r131 = true;
    L48:
        if (com.larus.bmhome.chat.bean.d.T(r124) == true) goto L67;
        if (com.larus.bmhome.chat.bean.d.p0(r124) == true) goto L67;
        if (com.larus.bmhome.chat.bean.d.C0(r124) == true) goto L55;
    L57:
        MessageStatus r134 = r124.getMessageStatus();
        if (r134 != null) goto L60;
    L62:
        boolean r135 = false;
    L63:
        if (r135 == false) goto L65;
    L66:
        r125 = true;
        goto L68
    L65:
        if (b0.f(r124) == false) goto L67;
    L60:
        if (r134.isVisible() != r100) goto L62;
        r135 = true;
        goto L63
    L55:
        if (r124.getRegenVisible() == true) goto L57;
    L120:
        ArrayList r136 = r118;
        int r137 = r114;
        if (this.f563289a.e() == true) goto L125;
        if (r117 == true) goto L125;
        boolean r138 = false;
    L127:
        if (n.D(r113) == true) goto L129;
    L135:
        Iterator r139 = CollectionsKt.sortedWith(r136, new b()).iterator();
    L137:
        if (r139.hasNext() == false) goto L140;
        Pair r140 = (Pair) r139.next();
        ListProtector.add(r112, ((Number) r140.component1()).intValue(), (l) r140.component2());
        goto L137
    L140:
        if ((!r136.isEmpty()) == false) goto L142;
        FLogger.f375446a.i("Pipeline_List_TimeStampDividerTask", "insert visible message timestamps, count=" + r136.size() + ", interval=" + r137 + ", hasReachedVisibleHistoryTop=" + r138);
        goto L142
    L129:
        if (Intrinsics.areEqual(this.f563289a.extraInfo().get("visible_timestamp_search_mode"), Boolean.TRUE) == true) goto L135;
        if (r138 == false) goto L135;
        if (r111 == null) goto L135;
        if (CollectionsKt.lastOrNull(r112) != r111) goto L135;
        r136.add(TuplesKt.to(Integer.valueOf(r112.size()), c(this, r111.getMessage(), r111.getMessage(), false, false, false, true, 28)));
    L125:
        r138 = true;
        goto L127
    L33:
        if (r116.a() != true) goto L35;
        r117 = true;
        goto L36
    L144:
        if (this.f563289a.E8() == false) goto L162;
        if (r211 == null) goto L147;
        Message r141 = r211.getMessage();
    L148:
        Message r142 = r310.getMessage();
        xc8.b r143 = this.f563289a.n();
        if (r143 == null) goto L151;
        Message r144 = r143.getMessage();
    L152:
        boolean r145 = Intrinsics.areEqual(r142, r144);
        if (r141 != null) goto L155;
    L157:
        l r146 = null;
    L158:
        if (r145 == false) goto L160;
        r111 = c(this, r142, r142, false, false, true, false, 36);
    L160:
        FLogger.f375446a.i("Pipeline_List_TimeStampDividerTask", "create service bot timestamp, index=" + r210 + " current=" + r142.getMessageId() + " isOldestCell=" + r145);
        return CollectionsKt.toMutableList(CollectionsKt.listOfNotNull(new xc8.b[]{r146, r310, r111}));
    L155:
        if (this.f563292d.contains(Integer.valueOf(r210 - 1)) == false) goto L157;
        r146 = c(this, r141, r142, false, false, true, false, 36);
        goto L158
    L151:
        r144 = null;
        goto L152
    L147:
        r141 = null;
        goto L148
    L162:
        xc8.b r147 = (xc8.b) CollectionsKt.lastOrNull(r311);
        wc9.e r148 = this.f563289a.g();
        if (r147 == null) goto L165;
        Message r149 = r147.getMessage();
    L166:
        Message r150 = r310.getMessage();
        if (r149 == null) goto L169;
        String r151 = r149.getSectionId();
    L170:
        String r152 = r150.getSectionId();
        if (r210 > 0) goto L173;
    L191:
        boolean r153 = false;
    L192:
        if (r149 == null) goto L201;
        CopyOnWriteArraySet<xc8.f.a> r154 = xc8.f.f563237a;
        xc8.g r155 = (xc8.g) xc8.f.f563240d.getValue();
        if (r155 != null) goto L196;
    L198:
        boolean r156 = false;
    L199:
        if (r156 == false) goto L201;
        boolean r157 = true;
    L202:
        if (r153 == false) goto L230;
        if (r149 == null) goto L230;
        Regex r158 = com.larus.bmhome.chat.bean.d.f297444a;
        Intrinsics.checkNotNullParameter(r149, "<this>");
        String r159 = r149.getMessageId();
        if (r159 != null) goto L207;
    L209:
        boolean r160 = false;
    L210:
        if (r160 == true) goto L230;
        if (r157 == true) goto L230;
        if (com.larus.bmhome.chat.bean.d.O0(r149) == false) goto L216;
    L250:
        if (r111 == null) goto L254;
        return CollectionsKt.mutableListOf(new xc8.b[]{r111, r310});
    L254:
        return CollectionsKt.mutableListOf(new xc8.b[]{r310});
    L216:
        if (com.larus.bmhome.chat.bean.d.x(r149).isClickClearContext() == true) goto L218;
    L222:
        FLogger.f375446a.i("Pipeline_List_TimeStampDividerTask", "create timestamp by section changed, preSectionId = " + r151 + ", currentSectionId = " + r152);
        if (((Boolean) this.f563290b.getValue()).booleanValue() == true) goto L225;
    L227:
        boolean r161 = false;
    L228:
        r111 = c(this, r149, r150, false, r161, false, false, 52);
        goto L250
    L225:
        if (com.larus.bmhome.utils.i.f(r148) == true) goto L227;
        r161 = true;
        goto L228
    L218:
        if (com.larus.bmhome.chat.bean.d.G0(r149) == false) goto L222;
        if (Intrinsics.areEqual(com.larus.bmhome.chat.bean.d.x(r149).getSource(), "onboarding_welcome_back_sug") == true) goto L222;
    L207:
        if (StringsKt.contains$default(r159, "-welcome-back", false, 2, null) != true) goto L209;
        r160 = true;
    L230:
        if (r149 == null) goto L239;
        ChatListComponentViewModel.Companion.getClass();
        if (ChatListComponentViewModel.b.a(r149) == false) goto L239;
        if (ChatListComponentViewModel.b.a(r150) == true) goto L236;
    L237:
        FLogger.f375446a.i("Pipeline_List_TimeStampDividerTask", "create timestamp by positive message, preMessage.createTime = " + r149.getCreateTime() + ", currentMessage.createTime = " + r150.getCreateTime() + ", interval = " + z2.f365865a.positiveMsgSplitTimeInterval());
        r111 = c(this, r149, r150, true, false, false, false, 56);
        goto L250
    L236:
        if ((r149.getCreateTime() - r150.getCreateTime()) > z2.f365865a.positiveMsgSplitTimeInterval()) goto L237;
    L239:
        if (((Boolean) this.f563290b.getValue()).booleanValue() == true) goto L241;
    L243:
        boolean r162 = false;
    L244:
        if (r162 == false) goto L250;
        if (r149 == null) goto L250;
        if ((r149.getCreateTime() - r150.getCreateTime()) <= ((Number) this.f563291c.getValue()).intValue()) goto L250;
        if (r157 == true) goto L250;
        FLogger.f375446a.i("Pipeline_List_TimeStampDividerTask", "create timestamp by show ugc timestamp, preMessage.createTime = " + r149.getCreateTime() + ", currentMessage.createTime = " + r150.getCreateTime() + ", interval = " + ((Number) this.f563291c.getValue()).intValue());
        r111 = c(this, r149, r150, false, false, false, false, 60);
        goto L250
    L241:
        if (com.larus.bmhome.utils.i.f(r148) == true) goto L243;
        r162 = true;
        goto L244
    L196:
        if (r155.a(r149) != true) goto L198;
        r156 = true;
    L201:
        r157 = false;
        goto L202
    L173:
        if (Intrinsics.areEqual(r152, r151) == true) goto L191;
        if (r152 != null) goto L176;
    L179:
        boolean r163 = true;
    L180:
        if (r163 == true) goto L191;
        if (r151 != null) goto L183;
    L186:
        boolean r164 = true;
    L187:
        if (r164 == true) goto L191;
        if (b0.f(r149) == true) goto L191;
        r153 = true;
        goto L192
    L183:
        if (r151.length() == 0) goto L186;
        r164 = false;
        goto L187
    L176:
        if (r152.length() == 0) goto L179;
        r163 = false;
        goto L180
    L169:
        r151 = null;
        goto L170
    L165:
        r149 = null;
        goto L166
    }

    public static l c(g r510, Message r511, Message r512, boolean r513, boolean r610, boolean r611, boolean r612, int r613) {
        if ((r613 & 4) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r613 & 8) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r613 & 16) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r613 & 32) == 0) goto L17;
        boolean r103 = false;
    L18:
        r510.getClass();
        String r104 = r511.getLocalMessageId();
        if (r104 != null) goto L21;
    L24:
        boolean r105 = true;
    L26:
        if (r105 == true) goto L28;
        String r106 = GXImageView.LOCAL_PREFIX + r511.getLocalMessageId();
    L38:
        String r107 = r512.getLocalMessageId();
        String r110 = null;
        if (r107 != null) goto L41;
    L45:
        r107 = r512.getMessageId();
        if (r107 != null) goto L48;
    L50:
        r107 = null;
    L51:
        if (r107 != null) goto L54;
        r107 = "index:" + r512.getLocalIndex() + ':' + r512.getCreateTime();
    L54:
        if (r103 == false) goto L57;
        String r108 = "visible_timestamp:" + r511.getConversationId() + ':' + r106;
    L56:
        String r210 = r108;
        if (r103 == false) goto L63;
        String r211 = r210;
    L64:
        Pair[] r109 = new Pair[1];
        if (r100 == false) goto L67;
        String r111 = "1";
    L68:
        r109[0] = TuplesKt.to("show_time_line", r111);
        Map r112 = MapsKt.mutableMapOf(r109);
        if (r103 == false) goto L71;
        r112.put("visible_message_timestamp", "1");
    L71:
        String r113 = r512.getConversationId();
        if (r101 == false) goto L74;
        String r212 = AppHost.f326268a.getApplication().getString(R.string.larus_message_section_newTopic);
    L75:
        long r410 = r511.getCreateTime();
        if (r103 == false) goto L78;
        long r114 = r511.getLocalIndex();
    L79:
        long r213 = r114;
        String r310 = r511.getSectionId();
        if (r102 == true) goto L85;
        if (r103 == true) goto L85;
        r110 = r511.getSectionName();
    L85:
        return new l(b0.j(new Message(r113, null, null, 0, 21, null, 1002, false, null, r212, null, null, null, r112, r211, r210, r213, 0, false, r310, r110, null, null, null, null, 0, false, 0, null, null, false, null, null, r410, null, null, null, -1696338, 29, null), 3));
    L78:
        r114 = r512.getLocalIndex() + 1;
        goto L79
    L74:
        r212 = null;
        goto L75
    L67:
        r111 = "0";
        goto L68
    L63:
        r211 = r107 + "-time-stamp";
        goto L64
    L57:
        String r115 = r512.getMessageId();
        if (r115 != null) goto L60;
        r115 = "";
    L60:
        r108 = r115.concat("-time-stamp");
        goto L56
    L48:
        if ((!StringsKt.isBlank(r107)) == false) goto L50;
    L41:
        if ((!StringsKt.isBlank(r107)) == true) goto L44;
        r107 = null;
    L44:
        if (r107 != null) goto L54;
    L28:
        String r116 = r511.getMessageId();
        if (r116 != null) goto L31;
    L34:
        boolean r117 = true;
    L35:
        if (r117 == true) goto L37;
        r106 = "message:" + r511.getMessageId();
        goto L38
    L37:
        r106 = "index:" + r511.getLocalIndex() + ':' + r511.getCreateTime();
        goto L38
    L31:
        if (StringsKt.isBlank(r116) == true) goto L34;
        r117 = false;
        goto L35
    L21:
        if (StringsKt.isBlank(r104) == true) goto L24;
        r105 = false;
        goto L26
    L17:
        r103 = r612;
        goto L18
    L13:
        r102 = r611;
        goto L15
    L9:
        r101 = r610;
        goto L11
    L5:
        r100 = r513;
        goto L7
    }
}
