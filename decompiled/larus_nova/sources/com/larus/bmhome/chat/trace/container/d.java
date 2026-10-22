package com.larus.bmhome.chat.trace.container;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.list.cell.text.cells.base.CellComponentType;
import com.larus.bmhome.chat.trace.appreciable.z;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f310200a;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bO\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001Bë\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\b\u0012\b\b\u0002\u0010\u0019\u001a\u00020\b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\b\u0012\b\b\u0002\u0010\u001b\u001a\u00020\b\u0012\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u001d\u0012\b\b\u0002\u0010\u001e\u001a\u00020\b\u0012\b\b\u0002\u0010\u001f\u001a\u00020\b\u0012\b\b\u0002\u0010 \u001a\u00020\b\u0012\u001c\b\u0002\u0010!\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010$0#0\"\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&¢\u0006\u0004\b'\u0010(J\u0006\u0010u\u001a\u00020vR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010.\"\u0004\b2\u00100R\"\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\b8\u00104\"\u0004\b9\u00106R\"\u0010\n\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\b:\u00104\"\u0004\b;\u00106R\"\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\b<\u00104\"\u0004\b=\u00106R\"\u0010\f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\b>\u00104\"\u0004\b?\u00106R \u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010*\"\u0004\bA\u0010,R \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010*\"\u0004\bC\u0010,R \u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010*\"\u0004\bE\u0010,R \u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010*\"\u0004\bG\u0010,R\"\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\bH\u00104\"\u0004\bI\u00106R \u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010*\"\u0004\bK\u0010,R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010P\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\bQ\u00104\"\u0004\bR\u00106R\"\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\bS\u00104\"\u0004\bT\u00106R\"\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\bU\u00104\"\u0004\bV\u00106R\u001a\u0010\u0017\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001a\u0010\u0018\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010X\"\u0004\b\\\u0010ZR\u001a\u0010\u0019\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010X\"\u0004\b^\u0010ZR\u001a\u0010\u001a\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010X\"\u0004\b`\u0010ZR\u001a\u0010\u001b\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010X\"\u0004\bb\u0010ZR&\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u001a\u0010\u001e\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010X\"\u0004\bh\u0010ZR\u001a\u0010\u001f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010X\"\u0004\bj\u0010ZR\u001a\u0010 \u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010X\"\u0004\bl\u0010ZR.\u0010!\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010$0#0\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010t¨\u0006w"}, d2 = {"Lcom/larus/bmhome/chat/trace/container/FirstScreenRenderTrace$FirstFeedRenderRecord;", "Lcom/larus/bmhome/chat/trace/container/AppreciableRecord;", "enterChatMethod", "", "cellCount", "", "lynxCardCount", "firstCreateStartDuration", "", "firstBindStartDuration", "allBindFinishDuration", "firstLynxRenderStartDuration", "allLynxRenderFinishDuration", "lastLynxMessageId", "lastLynxCardId", "lastLynxCardIntention", "lastLynxCardIntentionDetail", "lastLynxCardFmp", "longestMessageId", "longestContentType", "longestAllDuration", "longestBindDuration", "longestCellComponentType", "openChatPageTime", "lastCreateStartTime", "lastCreateEndTime", "lastBindStartTime", "lastBindEndTime", "lynxCardStartTimeMap", "", "firstScreenRenderOverTime", "lastLynxRenderEndTime", "endRenderLynxCardCount", "bindMessageList", "", "Lkotlin/Pair;", "Lcom/larus/bmhome/chat/list/cell/text/cells/base/CellComponentType;", "longestMessage", "Lcom/larus/im/bean/message/Message;", "<init>", "(Ljava/lang/String;IILjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;JJJJJLjava/util/Map;JJJLjava/util/List;Lcom/larus/im/bean/message/Message;)V", "getEnterChatMethod", "()Ljava/lang/String;", "setEnterChatMethod", "(Ljava/lang/String;)V", "getCellCount", "()I", "setCellCount", "(I)V", "getLynxCardCount", "setLynxCardCount", "getFirstCreateStartDuration", "()Ljava/lang/Long;", "setFirstCreateStartDuration", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getFirstBindStartDuration", "setFirstBindStartDuration", "getAllBindFinishDuration", "setAllBindFinishDuration", "getFirstLynxRenderStartDuration", "setFirstLynxRenderStartDuration", "getAllLynxRenderFinishDuration", "setAllLynxRenderFinishDuration", "getLastLynxMessageId", "setLastLynxMessageId", "getLastLynxCardId", "setLastLynxCardId", "getLastLynxCardIntention", "setLastLynxCardIntention", "getLastLynxCardIntentionDetail", "setLastLynxCardIntentionDetail", "getLastLynxCardFmp", "setLastLynxCardFmp", "getLongestMessageId", "setLongestMessageId", "getLongestContentType", "()Ljava/lang/Integer;", "setLongestContentType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getLongestAllDuration", "setLongestAllDuration", "getLongestBindDuration", "setLongestBindDuration", "getLongestCellComponentType", "setLongestCellComponentType", "getOpenChatPageTime", "()J", "setOpenChatPageTime", "(J)V", "getLastCreateStartTime", "setLastCreateStartTime", "getLastCreateEndTime", "setLastCreateEndTime", "getLastBindStartTime", "setLastBindStartTime", "getLastBindEndTime", "setLastBindEndTime", "getLynxCardStartTimeMap", "()Ljava/util/Map;", "setLynxCardStartTimeMap", "(Ljava/util/Map;)V", "getFirstScreenRenderOverTime", "setFirstScreenRenderOverTime", "getLastLynxRenderEndTime", "setLastLynxRenderEndTime", "getEndRenderLynxCardCount", "setEndRenderLynxCardCount", "getBindMessageList", "()Ljava/util/List;", "setBindMessageList", "(Ljava/util/List;)V", "getLongestMessage", "()Lcom/larus/im/bean/message/Message;", "setLongestMessage", "(Lcom/larus/im/bean/message/Message;)V", "tryReport", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends com.larus.bmhome.chat.trace.container.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public transient long f310201a;

        @SerializedName("all_bind_finish_duration")
        private Long allBindFinishDuration;

        @SerializedName("all_lynx_render_finish_duration")
        private Long allLynxRenderFinishDuration;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public transient long f310202b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public transient long f310203c;

        @SerializedName("cell_count")
        private int cellCount;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public transient long f310204d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final transient Map<String, Long> f310205e;

        @SerializedName("enter_chat_method")
        private String enterChatMethod;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public transient long f310206f;

        @SerializedName("first_bind_start_duration")
        private Long firstBindStartDuration;

        @SerializedName("first_create_start_duration")
        private Long firstCreateStartDuration;

        @SerializedName("first_lynx_render_start_duration")
        private Long firstLynxRenderStartDuration;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public transient long f310207g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public transient long f310208h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final transient List<Pair<String, CellComponentType>> f310209i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public transient Message f310210j;

        @SerializedName("last_lynx_card_fmp")
        private Long lastLynxCardFmp;

        @SerializedName("last_lynx_card_id")
        private String lastLynxCardId;

        @SerializedName("last_lynx_card_intention")
        private String lastLynxCardIntention;

        @SerializedName("last_lynx_card_intention_detail")
        private String lastLynxCardIntentionDetail;

        @SerializedName("last_lynx_message_id")
        private String lastLynxMessageId;

        @SerializedName("longest_all_duration")
        private Long longestAllDuration;

        @SerializedName("longest_bind_duration")
        private Long longestBindDuration;

        @SerializedName("longest_cell_component_type")
        private Long longestCellComponentType;

        @SerializedName("longest_content_type")
        private Integer longestContentType;

        @SerializedName("longest_message_id")
        private String longestMessageId;

        @SerializedName("lynx_card_count")
        private int lynxCardCount;

        public a() {
            this(null);
        }

        public final void y() {
            long r100 = this.f310201a;
            if (r100 <= 0) goto L34;
            long r101 = this.f310204d;
            if (r101 <= 0) goto L35;
            Long r102 = Long.valueOf(r101 - r100);
            this.allBindFinishDuration = r102;
            long r103 = this.f310207g;
            if (r103 <= this.f310204d) goto L9;
            r102 = Long.valueOf(r103 - this.f310201a);
            this.allLynxRenderFinishDuration = r102;
        L9:
            d(r102);
            Message r104 = this.f310210j;
            String r105 = null;
            if (r104 == null) goto L12;
            String r106 = r104.getMessageId();
        L13:
            this.longestMessageId = r106;
            Message r107 = this.f310210j;
            if (r107 == null) goto L16;
            Integer r108 = Integer.valueOf(r107.getContentType());
        L17:
            this.longestContentType = r108;
            Message r109 = this.f310210j;
            if (r109 == null) goto L22;
            Map<String, String> r110 = r109.getExt();
            if (r110 == null) goto L22;
            r105 = r110.get("tea_tags_time_cost");
        L22:
            if (r105 != null) goto L24;
        L27:
            boolean r111 = true;
        L29:
            if (r111 == false) goto L31;
            Map<String, String> r112 = new LinkedHashMap();
        L32:
            a("FirstScreenRenderTrace", r112);
            return;
        L31:
            r112 = z.a(r105, "FirstScreenRenderTrace");
            goto L32
        L24:
            if (r105.length() == 0) goto L27;
            r111 = false;
            goto L29
        L16:
            r108 = null;
            goto L17
        L12:
            r106 = null;
            goto L13
        L35:
            return;
        }

        public final int e() {
            return this.cellCount;
        }

        public final Long f() {
            return this.firstBindStartDuration;
        }

        public final Long g() {
            return this.firstCreateStartDuration;
        }

        public final Long h() {
            return this.firstLynxRenderStartDuration;
        }

        public final Long i() {
            return this.longestAllDuration;
        }

        public final int j() {
            return this.lynxCardCount;
        }

        public a(Object r100) {
            LinkedHashMap r101 = new LinkedHashMap();
            ArrayList r102 = new ArrayList();
            Intrinsics.checkNotNullParameter(r101, "lynxCardStartTimeMap");
            Intrinsics.checkNotNullParameter(r102, "bindMessageList");
            super(0);
            this.enterChatMethod = null;
            this.cellCount = 0;
            this.lynxCardCount = 0;
            this.firstCreateStartDuration = null;
            this.firstBindStartDuration = null;
            this.allBindFinishDuration = null;
            this.firstLynxRenderStartDuration = null;
            this.allLynxRenderFinishDuration = null;
            this.lastLynxMessageId = null;
            this.lastLynxCardId = null;
            this.lastLynxCardIntention = null;
            this.lastLynxCardIntentionDetail = null;
            this.lastLynxCardFmp = null;
            this.longestMessageId = null;
            this.longestContentType = null;
            this.longestAllDuration = null;
            this.longestBindDuration = null;
            this.longestCellComponentType = null;
            this.f310201a = 0;
            this.f310202b = 0;
            this.f310203c = 0;
            this.f310204d = 0;
            this.f310205e = r101;
            this.f310206f = 0;
            this.f310207g = 0;
            this.f310208h = 0;
            this.f310209i = r102;
            this.f310210j = null;
        }

        public final void k(int r100) {
            this.cellCount = r100;
        }

        public final void l(String r100) {
            this.enterChatMethod = r100;
        }

        public final void m(Long r100) {
            this.firstBindStartDuration = r100;
        }

        public final void n(Long r100) {
            this.firstCreateStartDuration = r100;
        }

        public final void o(Long r100) {
            this.firstLynxRenderStartDuration = r100;
        }

        public final void p(Long r100) {
            this.lastLynxCardFmp = r100;
        }

        public final void q(String r100) {
            this.lastLynxCardId = r100;
        }

        public final void r(String r100) {
            this.lastLynxCardIntention = r100;
        }

        public final void s(String r100) {
            this.lastLynxCardIntentionDetail = r100;
        }

        public final void t(String r100) {
            this.lastLynxMessageId = r100;
        }

        public final void u(Long r100) {
            this.longestAllDuration = r100;
        }

        public final void v(Long r100) {
            this.longestBindDuration = r100;
        }

        public final void w(Long r100) {
            this.longestCellComponentType = r100;
        }

        public final void x(int r100) {
            this.lynxCardCount = r100;
        }
    }

    static {
    }
}
