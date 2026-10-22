package qeb;

import com.bytedance.lark.pb.feed.v1.AppFeedCardType;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.app.entity.UIFeedCardExtraKt;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import z5c.g;
import z5c.j;
import z5c.p0;
import z5c.q0;
import z5c.x1;

/* JADX INFO: loaded from: classes35.dex */
public final class d {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f532710a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f532711b = null;

        static {
            int[] r100 = new int[FeedCard.Type.values().length];
            r100[FeedCard.Type.CHAT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L45:
            r100[FeedCard.Type.DOC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L61:
            r100[FeedCard.Type.APP_FEED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L47:
            r100[FeedCard.Type.OPEN_APP_CHAT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
        L49:
            r100[FeedCard.Type.THREAD.ordinal()] = 5;     // Catch: NoSuchFieldError -> L28
        L37:
            r100[FeedCard.Type.MSG_THREAD.ordinal()] = 6;     // Catch: NoSuchFieldError -> L29
        L51:
            r100[FeedCard.Type.TOPIC.ordinal()] = 7;     // Catch: NoSuchFieldError -> L30
        L15:
            f532710a = r100;
            int[] r101 = new int[AppFeedCardType.values().length];
            r101[AppFeedCardType.CALENDAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L31
        L43:
            r101[AppFeedCardType.MAIL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L32
        L55:
            r101[AppFeedCardType.DOUBAO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L33
        L41:
            r101[AppFeedCardType.OPEN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L34
        L53:
            r101[AppFeedCardType.AI_UNREAD_SUMMARY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L35
        L39:
            r101[AppFeedCardType.MINUTES.ordinal()] = 6;     // Catch: NoSuchFieldError -> L36
        L22:
            f532711b = r101;
        }
    }

    public static final Map<String, Object> a(UIFeedCard r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (UIFeedCardExtraKt.isOnTop(r100) == false) goto L5;
        s5c.a r101 = x1.f570401c;
    L6:
        FeedCard.Type r102 = r100.getType();
        Intrinsics.checkNotNullParameter(r102, "<this>");
        String r103 = "";
        switch(a.f532710a[r102.ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            default: goto L16;
        };
    L9:
        s5c.a r104 = q0.f570303d;
    L17:
        s5c.a r105 = j.f570224c.a(r100.getBizId());
        s5c.a r106 = p0.f570279c.a(r100.getId());
        AppFeedCardType r107 = r100.getBizType();
        if (r107 == null) goto L28;
        Intrinsics.checkNotNullParameter(r107, "<this>");
        switch(a.f532711b[r107.ordinal()]) {
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L24;
            case 5: goto L23;
            case 6: goto L22;
            default: goto L28;
        };
    L22:
        String r108 = "hardware_connection";
    L29:
        g r109 = g.f570203c;
        String r110 = r100.getAppId();
        if (r110 == null) goto L33;
        r103 = r110;
    L33:
        s5c.a r111 = r109.a(r103);
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(r101.f540771a, r101.f540772b), TuplesKt.to(r104.f540771a, r104.f540772b), TuplesKt.to(r105.f540771a, r105.f540772b), TuplesKt.to(r106.f540771a, r106.f540772b), TuplesKt.to(r111.f540771a, r111.f540772b), TuplesKt.to("biz_type", r108), TuplesKt.to("app_feed_card_id", r100.getId())});
    L23:
        r108 = "ai_unread_summary";
        goto L29
    L24:
        r108 = "open";
        goto L29
    L25:
        r108 = "doubao";
        goto L29
    L26:
        r108 = IOfflineExtraParser.ParserType.MAIL;
        goto L29
    L27:
        r108 = "cal";
    L28:
        r108 = "";
        goto L29
    L10:
        r104 = q0.f570303d;
        goto L17
    L11:
        r104 = q0.f570303d;
        goto L17
    L12:
        r104 = q0.f570305f;
        goto L17
    L13:
        r104 = q0.f570306g;
        goto L17
    L14:
        r104 = q0.f570304e;
        goto L17
    L15:
        r104 = q0.f570302c;
        goto L17
    L16:
        r104 = q0.f570307h.a("");
        goto L17
    L5:
        r101 = x1.f570402d;
        goto L6
    }
}
