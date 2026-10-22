package lk8;

import android.content.Context;
import com.larus.bmhome.chat.ChatParam;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ResearchBlock;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ne8.k;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public lk8.a f509604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f509605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f509606c;

    public static final class a implements kk8.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f509607a;

        public final void c() {
            final e r100 = this.f509607a;
            lk8.a r101 = r100.f509604a;
            if (r101 == null) goto L22;
            final Message r102 = r101.f509595a;
            if (r102 == null) goto L25;
            b r103 = r100.f509605b;
            if (r103 == null) goto L10;
            Set<Object> r104 = r103.c();
        L11:
            String r105 = "deep_research_card_show_" + r102.getMessageId();
            Function0 r106 = new c(r100, r102);
            if (r104 == null) goto L16;
            boolean r107 = true;
            if (r104.contains(r105) != true) goto L16;
        L17:
            if (r107 == true) goto L23;
            r106.invoke();
            if (r104 == null) goto L24;
            r104.add(r105);
            return;
        L24:
            return;
        L23:
            return;
        L16:
            r107 = false;
            goto L17
        L10:
            r104 = null;
            goto L11
        L25:
            return;
        }

        public a(e r100) {
            this.f509607a = r100;
        }

        @Override // kk8.e
        public final void a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            b r101 = this.f509607a.f509605b;
            if (r101 == null) goto L6;
            r101.a();
            return;
        }

        @Override // kk8.e
        public final void b(Context r510) {
            Intrinsics.checkNotNullParameter(r510, PerfLog.PARAM_KEY_CONTEXT_ID);
            lk8.a r100 = this.f509607a.f509604a;
            if (r100 == null) goto L50;
            ResearchBlock r101 = r100.f509598d;
            if (r101 == null) goto L51;
            Message r102 = r100.f509595a;
            if (r102 == null) goto L52;
            String r103 = r101.getResourceId();
            if (r103 != null) goto L13;
        L16:
            boolean r104 = true;
        L17:
            if (r104 == false) goto L19;
            return;
        L19:
            b r105 = this.f509607a.f509605b;
            String r110 = null;
            if (r105 == null) goto L22;
            BotModel r106 = r105.B0();
        L23:
            b r107 = this.f509607a.f509605b;
            if (r107 == null) goto L26;
            Long r108 = r107.b();
        L27:
            int r109 = k.f518899a;
            String r111 = r101.getResourceId();
            if (r111 != null) goto L30;
            r111 = "";
        L30:
            k.b(r510, r111, false, r102, r102.getConversationId(), r106, r108, null, "dr_report_card");
            b r112 = this.f509607a.f509605b;
            if (r112 == null) goto L33;
            ChatParam r113 = r112.getChatParam();
        L34:
            ri8.c r114 = ri8.c.f537890a;
            String r210 = r102.getSenderId();
            if (r113 == null) goto L37;
            String r115 = r113.f296892d;
        L38:
            Map<String, String> r116 = r102.getExt();
            if (r116 == null) goto L41;
            String r117 = r116.get("deep_research_id");
        L42:
            if (r117 != null) goto L44;
            String r310 = "";
        L45:
            String r118 = r102.getMessageId();
            String r119 = r102.getConversationId();
            String r120 = r102.getReplyId();
            if (r113 == null) goto L48;
            r110 = r113.f296891c;
        L48:
            ri8.c.m(null, r118, r119, r120, r115, r110, null, null, null, null, "dr_report_card", r210, null, null, "unfold", null, null, null, null, null, null, null, null, r310, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -8408576, 63);
            return;
        L44:
            r310 = r117;
            goto L45
        L41:
            r117 = null;
            goto L42
        L37:
            r115 = null;
            goto L38
        L33:
            r113 = null;
            goto L34
        L26:
            r108 = null;
            goto L27
        L22:
            r106 = null;
            goto L23
        L13:
            if (r103.length() == 0) goto L16;
            r104 = false;
            goto L17
        L52:
            return;
        L51:
            return;
        }
    }

    public e() {
        this.f509606c = LazyKt.lazy(new d(this));
    }
}
