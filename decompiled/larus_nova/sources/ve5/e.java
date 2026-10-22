package ve5;

import android.net.Uri;
import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotCheckConfigStatusResult;
import com.bytedance.ee.bear.middleground.comment.input.b2;
import com.bytedance.ee.bear.middleground.comment.widget.BotAtHintActionType;
import com.bytedance.ee.bear.middleground.comment.widget.BotAtHintView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BotAtHintView f554365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gn4.a f554366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<l> f554367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ve5.a f554368d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f554369e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public n f554370f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<Long, ve5.b> f554371g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, Integer> f554372h;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f554373a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f554374b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f554373a == r101.f554373a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f554374b, r101.f554374b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f554373a;
            return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f554374b.hashCode();
        }

        public final String toString() {
            return "BotMention(botId=" + this.f554373a + ", botName=" + this.f554374b + ')';
        }

        public a(long r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "botName");
            this.f554373a = r100;
            this.f554374b = r101;
        }
    }

    public static final class b {
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List<Long> f554375a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f554376b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map<Long, m> f554377c;

        public c(List<Long> r100, e r101, Map<Long, m> r102) {
            this.f554375a = r100;
            this.f554376b = r101;
            this.f554377c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            AiBotCheckConfigStatusResult r100 = (AiBotCheckConfigStatusResult) r110;
            tt5.a.h("BotMentionHintCoordinator", "check ai bot config status success, botIds=" + this.f554375a + ", result=" + r100);
            e r101 = this.f554376b;
            List<Long> r102 = this.f554375a;
            Map<Long, m> r103 = this.f554377c;
            Intrinsics.checkNotNull(r100);
            r101.getClass();
            if (r100.code == 0) goto L5;
            return;
        L5:
            if (r100.data == 0) goto L98;
            r101.a(r100);
            AiBotCheckConfigStatusResult.ResultsData r104 = (AiBotCheckConfigStatusResult.ResultsData) r100.data;
            if (r104 == null) goto L15;
            ArrayList<AiBotCheckConfigStatusResult.Data> r105 = r104.results;
            if (r105 == null) goto L15;
            Map r106 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r105, 10)), 16));
            Iterator<T> r107 = r105.iterator();
        L13:
            if (r107.hasNext() == false) goto L16;
            T r108 = r107.next();
            r106.put(Long.valueOf(((AiBotCheckConfigStatusResult.Data) r108).botId), r108);
        L16:
            if (r106 != null) goto L18;
            r106 = MapsKt.emptyMap();
        L18:
            Iterator<T> r109 = r102.iterator();
        L20:
            if (r109.hasNext() == false) goto L99;
            long r111 = ((Number) r109.next()).longValue();
            m r112 = r103.get(Long.valueOf(r111));
            if (r112 == null) goto L20;
            if (((AiBotCheckConfigStatusResult.Data) r106.get(Long.valueOf(r111))) == null) goto L26;
            r101.f554372h.put(r112.f554395a, 4);
            String r113 = r112.f554396b;
            AiBotCheckConfigStatusResult.ResultsData r114 = (AiBotCheckConfigStatusResult.ResultsData) r100.data;
            if (r114 == null) goto L42;
            ArrayList<AiBotCheckConfigStatusResult.Data> r115 = r114.results;
            if (r115 == null) goto L42;
            Iterator<T> r116 = r115.iterator();
        L33:
            if (r116.hasNext() == false) goto L40;
            T r117 = r116.next();
            if (((AiBotCheckConfigStatusResult.Data) r117).botId != r111) goto L37;
            boolean r118 = true;
        L38:
            if (r118 == false) goto L33;
        L41:
            AiBotCheckConfigStatusResult.Data r119 = r117;
        L44:
            if (r100.code != 0) goto L81;
            if (r119 == null) goto L81;
            if (r119.isStoreApp == false) goto L51;
            ve5.d r120 = ve5.d.a.f554362a;
        L82:
            r101.b(r120);
            goto L20
        L51:
            if (r119.hasAppVisibility == true) goto L54;
            r120 = new ve5.d.b(r111);
            goto L82
        L54:
            if (r119.finishedConfig == false) goto L57;
            r120 = new ve5.d.b(r111);
            goto L82
        L57:
            if (r119.isAppManager == false) goto L59;
            String r121 = r119.authUrl;
            if (r121 != null) goto L74;
        L80:
            r120 = new ve5.d.b(r111);
            goto L82
        L74:
            if (e.f(r121) == false) goto L76;
            String r122 = r121;
        L77:
            if (r122 == null) goto L80;
            r120 = new ve5.d.c(new com.bytedance.ee.bear.middleground.comment.widget.b(r111, r113, BotAtHintActionType.CONFIGURE_NOW, r122, r119.deviceCode, r119.deviceCodeExpireTime));
            goto L82
        L76:
            r122 = null;
            goto L77
        L59:
            if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.comment.permission_guide_non_admin_bot") == true) goto L61;
            r120 = new ve5.d.b(r111);
            goto L82
        L61:
            String r123 = r119.helpDocUrl;
            if (r123 != null) goto L64;
        L70:
            r120 = new ve5.d.b(r111);
            goto L82
        L64:
            if (e.f(r123) == false) goto L66;
            String r124 = r123;
        L67:
            if (r124 == null) goto L70;
            r120 = new ve5.d.c(new com.bytedance.ee.bear.middleground.comment.widget.b(r111, r113, BotAtHintActionType.LEARN_MORE, r124, r119.deviceCode, r119.deviceCodeExpireTime));
            goto L82
        L66:
            r124 = null;
        L81:
            r120 = ve5.d.a.f554362a;
            goto L82
        L37:
            r118 = false;
            goto L38
        L40:
            r117 = (T) null;
        L42:
            r119 = null;
            goto L44
        L26:
            r101.f554372h.put(r112.f554395a, 1);
            r101.f554365a.d(r111);
            goto L20
        L99:
            return;
        L15:
            r106 = null;
            goto L16
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List<Long> f554378a;

        public d(List<Long> r100) {
            this.f554378a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.e("BotMentionHintCoordinator", "check ai bot config status failed, botIds=" + this.f554378a, (Throwable) r100, false);
        }
    }

    static {
    }

    public e() {
        throw null;
    }

    public final void d() {
        StringBuilder r100 = new StringBuilder("[BOT_POLL_TRACE] clearPendingBotAuth, pendingBotId=");
        n r101 = this.f554370f;
        if (r101 == null) goto L5;
        Long r102 = Long.valueOf(r101.f554398a);
    L6:
        r100.append(r102);
        r100.append(", hasPolling=");
        if (this.f554369e == null) goto L9;
        boolean r103 = true;
    L10:
        r100.append(r103);
        tt5.a.h("BotMentionHintCoordinator", r100.toString());
        this.f554370f = null;
        m();
        return;
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public final void j() {
        n r100 = this.f554370f;
        if (r100 != null) goto L5;
        return;
    L5:
        StringBuilder r101 = new StringBuilder("[BOT_POLL_TRACE] onReturnFromBotConfigPage, botId=");
        r101.append(r100.f554398a);
        r101.append(", deviceCodeEmpty=");
        String r102 = r100.f554400c;
        if (r102 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        r101.append(r103);
        r101.append(", expireTime=");
        r101.append(r100.f554401d);
        tt5.a.h("BotMentionHintCoordinator", r101.toString());
        g(r100);
        return;
    L8:
        if (StringsKt.isBlank(r102) == true) goto L11;
        r103 = false;
        goto L12
    }

    public final void m() {
        if (this.f554369e == null) goto L5;
        tt5.a.h("BotMentionHintCoordinator", "[BOT_POLL_TRACE] stopAuthPolling");
    L5:
        Disposable r100 = this.f554369e;
        if (r100 == null) goto L8;
        r100.dispose();
    L8:
        this.f554369e = null;
    }

    public static boolean e(Long r100) {
        if (r100 != null) goto L4;
    L9:
        return false;
    L4:
        if (r100.longValue() <= 0) goto L9;
        if (System.currentTimeMillis() < (r100.longValue() * 1000)) goto L9;
        return true;
    }

    public static boolean f(String r100) {
        if (StringsKt.isBlank(r100) == false) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L28;
        return false;
    L28:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L10
        Object r103 = Result.m9449constructorimpl(UriProtector.parse(r100));     // Catch: Throwable -> L10
    L12:
        String r104 = null;
        if (Result.m9455isFailureimpl(r103) == false) goto L15;
        r103 = null;
    L15:
        Uri r105 = (Uri) r103;
        if (r105 != null) goto L18;
        return false;
    L18:
        String r106 = r105.getScheme();
        if (r106 == null) goto L22;
        r104 = r106.toLowerCase(Locale.US);
    L22:
        if (Intrinsics.areEqual(r104, "http") == false) goto L24;
        return true;
    L24:
        if (Intrinsics.areEqual(r104, "https") == true) goto L31;
        return false;
    L31:
        return true;
    L10:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    L5:
        r101 = false;
        goto L6
    }

    public final void a(AiBotCheckConfigStatusResult r110) {
        AiBotCheckConfigStatusResult.ResultsData r100 = (AiBotCheckConfigStatusResult.ResultsData) r110.data;
        if (r100 == null) goto L10;
        ArrayList<AiBotCheckConfigStatusResult.Data> r101 = r100.results;
        if (r101 == null) goto L12;
        Iterator r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L13;
        AiBotCheckConfigStatusResult.Data r103 = (AiBotCheckConfigStatusResult.Data) r102.next();
        long r104 = r103.botId;
        Long r111 = Long.valueOf(r104);
        this.f554371g.put(r111, new ve5.b(r104, r103.finishedConfig, r103.authUrl, r103.deviceCode, r103.deviceCodeExpireTime, r103.helpDocUrl, r103.isStoreApp, r103.isAppManager, r103.hasAppVisibility, System.currentTimeMillis()));
        r102 = r102;
        goto L8
    L13:
        return;
    L12:
        return;
    }

    public final void b(ve5.d r110) {
        if ((r110 instanceof ve5.d.c) == false) goto L22;
        BotAtHintView r100 = this.f554365a;
        com.bytedance.ee.bear.middleground.comment.widget.b r111 = ((ve5.d.c) r110).f554364a;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r111, "hintInfo");
        int r101 = r100.f232260b.z2();
        com.bytedance.ee.bear.middleground.comment.widget.a r102 = r100.f232260b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r111, "hintInfo");
        Iterator r103 = ((ArrayList) r102.f232313a).iterator();
        int r104 = 0;
    L6:
        if (r103.hasNext() == false) goto L14;
        if (((com.bytedance.ee.bear.middleground.comment.widget.b) r103.next()).f232318a != r111.f232318a) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == true) goto L15;
        r104 = r104 + 1;
    L15:
        if (r104 < 0) goto L17;
        ListProtector.set(r102.f232313a, r104, r111);
        r102.A2();
        r102.notifyDataSetChanged();
    L18:
        int r106 = r100.f232260b.z2();
        r100.c(r101, r106, "upsertHint");
        r100.g(r106);
        if (r100.getVisibility() != 0) goto L26;
        r100.f232270l = r111;
        int r112 = r100.f232271m + 1;
        r100.f232271m = r112;
        r100.f232259a.addOnLayoutChangeListener(new com.bytedance.ee.bear.middleground.comment.widget.c(r112, r100));
        return;
    L26:
        return;
    L17:
        ((ArrayList) r102.f232313a).add(r111);
        r102.A2();
        r102.notifyDataSetChanged();
        goto L18
    L10:
        r105 = false;
        goto L11
    L14:
        r104 = -1;
        goto L15
    L22:
        if ((r110 instanceof ve5.d.b) == false) goto L25;
        this.f554365a.d(((ve5.d.b) r110).f554363a);
        return;
    L25:
        if (Intrinsics.areEqual(r110, ve5.d.a.f554362a) == false) goto L28;
        return;
    L28:
        throw new NoWhenBranchMatchedException();
    }

    public final void g(n r100) {
        StringBuilder r101 = new StringBuilder("[BOT_POLL_TRACE] maybeStartPolling, botId=");
        r101.append(r100.f554398a);
        r101.append(", deviceCodeEmpty=");
        String r102 = r100.f554400c;
        boolean r103 = true;
        if (r102 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        r101.append(r104);
        r101.append(", expired=");
        r101.append(e(r100.f554401d));
        r101.append(", expireTime=");
        r101.append(r100.f554401d);
        tt5.a.h("BotMentionHintCoordinator", r101.toString());
        String r105 = r100.f554400c;
        if (r105 != null) goto L12;
    L15:
        boolean r106 = true;
    L16:
        if (r106 == false) goto L18;
    L24:
        StringBuilder r107 = new StringBuilder("[BOT_POLL_TRACE] refreshCheckConfigBeforePollingIfNeeded, botId=");
        r107.append(r100.f554398a);
        r107.append(", deviceCodeEmpty=");
        String r108 = r100.f554400c;
        if (r108 != null) goto L27;
    L30:
        r107.append(r103);
        r107.append(", expireTime=");
        r107.append(r100.f554401d);
        tt5.a.h("BotMentionHintCoordinator", r107.toString());
        m();
        l r109 = this.f554367c.invoke();
        this.f554366b.a(this.f554368d.a(CollectionsKt.listOf(Long.valueOf(r100.f554398a)), r109.f554391a, r109.f554392b, r109.f554393c).subscribeOn(fo5.d.c()).observeOn(fo5.d.d()).subscribe(new f(r100, this), new g(r100)));
        return;
    L27:
        if (StringsKt.isBlank(r108) == true) goto L30;
        r103 = false;
        goto L30
    L18:
        if (e(r100.f554401d) == true) goto L24;
        long r110 = r100.f554398a;
        String r111 = r100.f554400c;
        tt5.a.h("BotMentionHintCoordinator", "[BOT_POLL_TRACE] startAuthPolling, botId=" + r110 + ", deviceCodePrefix=" + StringsKt.take(r111, 12));
        m();
        Disposable r112 = Flowable.interval(0, 5, TimeUnit.SECONDS).take(10).observeOn(fo5.d.c()).switchMap(new h(r110, this, r111)).observeOn(fo5.d.d()).subscribe(new i(r110, this), new j(r110, this), new k(r110, this));
        this.f554369e = r112;
        if (r112 == null) goto L32;
        this.f554366b.a(r112);
        return;
    L32:
        return;
    L12:
        if (StringsKt.isBlank(r105) == true) goto L15;
        r106 = false;
        goto L16
    L5:
        if (StringsKt.isBlank(r102) == true) goto L8;
        r104 = false;
        goto L9
    }

    public final void h(bo4.a r100) {
        Intrinsics.checkNotNullParameter(r100, INotificationHitPoint.NoticeType.AT);
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.comment.permission_guide_bot") == true) goto L5;
        return;
    L5:
        c(r100.f19815e, r100.f19835y);
        a r101 = null;
        if (r100.f19835y != 4) goto L27;
        String r102 = r100.f19815e;
        if (r102 == null) goto L27;
        Long r103 = StringsKt.toLongOrNull(r102);
        if (r103 == null) goto L27;
        long r104 = r103.longValue();
        String r105 = r100.f19817g;
        if (r105 == null) goto L17;
        String r106 = StringsKt.removePrefix(r105, "@");
        if (r106 == null) goto L17;
        String r107 = StringsKt.trim(r106).toString();
    L18:
        if (r107 != null) goto L21;
        r107 = "";
    L21:
        if (r107.length() != 0) goto L23;
        boolean r108 = true;
    L24:
        if (r108 == true) goto L27;
        r101 = new a(r104, r107);
        goto L27
    L23:
        r108 = false;
    L17:
        r107 = null;
    L27:
        if (r101 != null) goto L29;
        return;
    L29:
        k(CollectionsKt.listOf(Long.valueOf(r101.f554373a)), MapsKt.mapOf(TuplesKt.to(Long.valueOf(r101.f554373a), new m(String.valueOf(r101.f554373a), r101.f554374b, 4))));
    }

    public final ve5.c i(com.bytedance.ee.bear.middleground.comment.widget.b r110) {
        Intrinsics.checkNotNullParameter(r110, "hintInfo");
        String r100 = r110.f232321d;
        if (r100 == null) goto L27;
        if (f(r100) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L27;
        if (r110.f232320c == BotAtHintActionType.CONFIGURE_NOW) goto L15;
        tt5.a.h("BotMentionHintCoordinator", "[BOT_POLL_TRACE] onHintActionClick skip pending, actionType=" + r110.f232320c + ", botId=" + r110.f232318a);
        return new ve5.c.b(r100);
    L15:
        if (this.f554369e == null) goto L17;
        tt5.a.h("BotMentionHintCoordinator", "[BOT_POLL_TRACE] onHintActionClick stop previous polling before navigate, botId=" + r110.f232318a);
        m();
    L17:
        this.f554370f = new n(r110.f232318a, r100, r110.f232322e, r110.f232323f);
        StringBuilder r101 = new StringBuilder("[BOT_POLL_TRACE] onHintActionClick set pending, botId=");
        r101.append(r110.f232318a);
        r101.append(", deviceCodeEmpty=");
        String r102 = r110.f232322e;
        if (r102 != null) goto L20;
    L23:
        boolean r103 = true;
    L24:
        r101.append(r103);
        r101.append(", expireTime=");
        r101.append(r110.f232323f);
        r101.append(", url=");
        r101.append(r100);
        tt5.a.h("BotMentionHintCoordinator", r101.toString());
        return new ve5.c.b(r100);
    L20:
        if (StringsKt.isBlank(r102) == true) goto L23;
        r103 = false;
    L27:
        return ve5.c.a.f554360a;
    }

    public final void l(List<m> r110) {
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.comment.permission_guide_bot") == true) goto L5;
        return;
    L5:
        LinkedHashSet r100 = new LinkedHashSet();
        Iterator<T> r101 = r110.iterator();
    L7:
        if (r101.hasNext() == false) goto L22;
        m r102 = (m) r101.next();
        Long r103 = StringsKt.toLongOrNull(r102.f554395a);
        if (r103 == null) goto L7;
        long r104 = r103.longValue();
        int r105 = r102.f554397c;
        if (r105 == 0) goto L13;
        int r106 = r105;
    L17:
        if (r106 == 0) goto L21;
        if (r106 != 4) goto L7;
    L21:
        r100.add(Long.valueOf(r104));
        goto L7
    L13:
        Integer r107 = (Integer) ((LinkedHashMap) this.f554372h).get(r102.f554395a);
        if (r107 == null) goto L16;
        r106 = r107.intValue();
        goto L17
    L16:
        r106 = 0;
        goto L17
    L22:
        List r108 = CollectionsKt.toList(r100);
        if (r108.isEmpty() == false) goto L25;
        return;
    L25:
        LinkedHashMap r109 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r110, 10)), 16));
        Iterator<T> r111 = r110.iterator();
    L26:
        long r112 = -1;
        if (r111.hasNext() == false) goto L32;
        m r113 = (m) r111.next();
        Long r114 = StringsKt.toLongOrNull(r113.f554395a);
        if (r114 == null) goto L31;
        r112 = r114.longValue();
    L31:
        r109.put(Long.valueOf(r112), r113);
        goto L26
    L32:
        LinkedHashMap r115 = new LinkedHashMap();
        Iterator r116 = r109.entrySet().iterator();
    L33:
        boolean r117 = true;
        if (r116.hasNext() == false) goto L41;
        Map.Entry r118 = (Map.Entry) r116.next();
        if (((Number) r118.getKey()).longValue() != (-1)) goto L39;
        r117 = false;
    L39:
        if (r117 == false) goto L33;
        r115.put(r118.getKey(), r118.getValue());
        goto L33
    L41:
        ArrayList r119 = new ArrayList();
        Iterator r120 = r108.iterator();
    L43:
        if (r120.hasNext() == false) goto L110;
        long r121 = ((Number) r120.next()).longValue();
        m r122 = (m) r115.get(Long.valueOf(r121));
        if (r122 == null) goto L43;
        ve5.b r123 = (ve5.b) ((LinkedHashMap) this.f554371g).get(Long.valueOf(r121));
        if (r123 != null) goto L51;
    L71:
        boolean r124 = false;
    L107:
        if (r124 == true) goto L43;
        r119.add(Long.valueOf(r121));
        goto L43
    L51:
        if (r123.f554351b == false) goto L53;
    L68:
        boolean r125 = true;
    L69:
        if (r125 == true) goto L72;
        this.f554371g.remove(Long.valueOf(r121));
        goto L71
    L72:
        String r126 = r122.f554396b;
        if (r123.f554358i == true) goto L76;
        ve5.d r127 = new ve5.d.b(r123.f554350a);
    L106:
        b(r127);
        r124 = true;
        goto L107
    L76:
        if (r123.f554351b == false) goto L79;
        r127 = new ve5.d.b(r123.f554350a);
        goto L106
    L79:
        if (r123.f554356g == false) goto L82;
        r127 = ve5.d.a.f554362a;
        goto L106
    L82:
        if (r123.f554357h == false) goto L84;
        String r128 = r123.f554352c;
        if (r128 != null) goto L99;
    L105:
        r127 = new ve5.d.b(r123.f554350a);
        goto L106
    L99:
        if (f(r128) == false) goto L101;
        String r129 = r128;
    L102:
        if (r129 == null) goto L105;
        r127 = new ve5.d.c(new com.bytedance.ee.bear.middleground.comment.widget.b(r123.f554350a, r126, BotAtHintActionType.CONFIGURE_NOW, r129, r123.f554353d, r123.f554354e));
        goto L106
    L101:
        r129 = null;
        goto L102
    L84:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.comment.permission_guide_non_admin_bot") == true) goto L86;
        r127 = new ve5.d.b(r123.f554350a);
        goto L106
    L86:
        String r130 = r123.f554355f;
        if (r130 != null) goto L89;
    L95:
        r127 = new ve5.d.b(r123.f554350a);
        goto L106
    L89:
        if (f(r130) == false) goto L91;
        String r131 = r130;
    L92:
        if (r131 == null) goto L95;
        r127 = new ve5.d.c(new com.bytedance.ee.bear.middleground.comment.widget.b(r123.f554350a, r126, BotAtHintActionType.LEARN_MORE, r131, r123.f554353d, r123.f554354e));
        goto L106
    L91:
        r131 = null;
        goto L92
    L53:
        if (r123.f554358i == false) goto L68;
        if (r123.f554356g == true) goto L68;
        if (r123.f554357h == false) goto L60;
        boolean r132 = e(r123.f554354e);
    L67:
        r125 = !r132;
        goto L69
    L60:
        String r133 = r123.f554355f;
        if (r133 != null) goto L63;
    L66:
        r132 = true;
        goto L67
    L63:
        if (StringsKt.isBlank(r133) == true) goto L66;
        r132 = false;
        goto L67
    L110:
        if ((!r119.isEmpty()) == false) goto L136;
        k(CollectionsKt.distinct(r119), r115);
        return;
    }

    public final void n(Set<Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "tokens");
        this.f554365a.f(r100);
        n r101 = this.f554370f;
        if (r101 != null) goto L5;
    L7:
        r101 = null;
    L8:
        this.f554370f = r101;
        return;
    L5:
        if (r100.contains(Long.valueOf(r101.f554398a)) == false) goto L7;
        goto L7
    }

    public final void c(String r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if ((!StringsKt.isBlank(r100)) == true) goto L7;
        r100 = null;
    L7:
        if (r100 == null) goto L14;
        if (r101 != 0) goto L11;
        return;
    L11:
        this.f554372h.put(r100, Integer.valueOf(r101));
        return;
    }

    public final void k(List<Long> r100, Map<Long, m> r101) {
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.comment.permission_guide_bot") == false) goto L10;
        l r102 = this.f554367c.invoke();
        Disposable r103 = this.f554368d.a(r100, r102.f554391a, r102.f554392b, r102.f554393c).subscribeOn(fo5.d.c()).observeOn(fo5.d.d()).subscribe(new c(r100, this, r101), new d(r100));
        this.f554366b.a(r103);
        return;
    }

    public e(BotAtHintView r100, b2 r101, Function0 r102) {
        ve5.a r103 = new ve5.a();
        Intrinsics.checkNotNullParameter(r100, "hintView");
        Intrinsics.checkNotNullParameter(r101, "disposableOwner");
        Intrinsics.checkNotNullParameter(r102, "sceneContextProvider");
        Intrinsics.checkNotNullParameter(r103, "repository");
        this.f554365a = r100;
        this.f554366b = r101;
        this.f554367c = r102;
        this.f554368d = r103;
        this.f554371g = new LinkedHashMap();
        this.f554372h = new LinkedHashMap();
    }
}
