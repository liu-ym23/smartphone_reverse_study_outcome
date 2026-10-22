package ve5;

import android.net.Uri;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotCheckConfigStatusResult;
import com.bytedance.ee.bear.middleground.comment.input.b2;
import com.bytedance.ee.bear.middleground.comment.widget.BotAtHintActionType;
import com.bytedance.ee.bear.middleground.comment.widget.BotAtHintView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
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
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public final BotAtHintView a;
    public final gn4.a b;
    public final Function0<l> c;
    public final ve5.a d;
    public Disposable e;
    public n f;
    public final Map<Long, ve5.b> g;
    public final Map<String, Integer> h;

    public static final class a {
        public final long a;
        public final String b;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            return (((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "BotMention(botId=" + this.a + ", botName=" + this.b + ')';
        }

        public a(long r2, String r4) {
            Intrinsics.checkNotNullParameter(r4, "botName");
            this.a = r2;
            this.b = r4;
        }
    }

    public static final class b {
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ List<Long> a;
        public final /* synthetic */ e b;
        public final /* synthetic */ Map<Long, m> c;

        public c(List<Long> r1, e r2, Map<Long, m> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r18) {
            AiBotCheckConfigStatusResult r1 = (AiBotCheckConfigStatusResult) r18;
            tt5.a.h("BotMentionHintCoordinator", "check ai bot config status success, botIds=" + this.a + ", result=" + r1);
            e r2 = this.b;
            List<Long> r3 = this.a;
            Map<Long, m> r4 = this.c;
            Intrinsics.checkNotNull(r1);
            r2.getClass();
            if (((Result) r1).code == 0) goto L5;
            return;
        L5:
            if (((Result) r1).data == null) goto L98;
            r2.a(r1);
            AiBotCheckConfigStatusResult.ResultsData r5 = (AiBotCheckConfigStatusResult.ResultsData) ((Result) r1).data;
            if (r5 == null) goto L15;
            ArrayList<AiBotCheckConfigStatusResult.Data> r6 = r5.results;
            if (r6 == null) goto L15;
            Map r8 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r6, 10)), 16));
            Iterator<T> r7 = r6.iterator();
        L13:
            if (r7.hasNext() == false) goto L16;
            T r9 = r7.next();
            r8.put(Long.valueOf(((AiBotCheckConfigStatusResult.Data) r9).botId), r9);
        L16:
            if (r8 != null) goto L18;
            r8 = MapsKt.emptyMap();
        L18:
            Iterator<T> r10 = r3.iterator();
        L20:
            if (r10.hasNext() == false) goto L99;
            long r11 = ((Number) r10.next()).longValue();
            m r12 = r4.get(Long.valueOf(r11));
            if (r12 == null) goto L20;
            if (((AiBotCheckConfigStatusResult.Data) r8.get(Long.valueOf(r11))) == null) goto L26;
            r2.h.put(r12.a, 4);
            String r13 = r12.b;
            AiBotCheckConfigStatusResult.ResultsData r14 = (AiBotCheckConfigStatusResult.ResultsData) ((Result) r1).data;
            if (r14 == null) goto L42;
            ArrayList<AiBotCheckConfigStatusResult.Data> r15 = r14.results;
            if (r15 == null) goto L42;
            Iterator<T> r16 = r15.iterator();
        L33:
            if (r16.hasNext() == false) goto L40;
            T r17 = r16.next();
            if (((AiBotCheckConfigStatusResult.Data) r17).botId != r11) goto L37;
            boolean r19 = true;
        L38:
            if (r19 == false) goto L33;
        L41:
            AiBotCheckConfigStatusResult.Data r20 = r17;
        L44:
            if (((Result) r1).code != 0) goto L81;
            if (r20 == null) goto L81;
            if (r20.isStoreApp == false) goto L51;
            ve5.d r21 = ve5.d.a.a;
        L82:
            r2.b(r21);
            goto L20
        L51:
            if (r20.hasAppVisibility == true) goto L54;
            r21 = new ve5.d.b(r11);
            goto L82
        L54:
            if (r20.finishedConfig == false) goto L57;
            r21 = new ve5.d.b(r11);
            goto L82
        L57:
            if (r20.isAppManager == false) goto L59;
            String r22 = r20.authUrl;
            if (r22 != null) goto L74;
        L80:
            r21 = new ve5.d.b(r11);
            goto L82
        L74:
            if (e.f(r22) == false) goto L76;
            String r110 = r22;
        L77:
            if (r110 == null) goto L80;
            r21 = new ve5.d.c(new com.bytedance.ee.bear.middleground.comment.widget.b(r11, r13, BotAtHintActionType.CONFIGURE_NOW, r110, r20.deviceCode, r20.deviceCodeExpireTime));
            goto L82
        L76:
            r110 = null;
            goto L77
        L59:
            if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.comment.permission_guide_non_admin_bot") == true) goto L61;
            r21 = new ve5.d.b(r11);
            goto L82
        L61:
            String r23 = r20.helpDocUrl;
            if (r23 != null) goto L64;
        L70:
            r21 = new ve5.d.b(r11);
            goto L82
        L64:
            if (e.f(r23) == false) goto L66;
            String r111 = r23;
        L67:
            if (r111 == null) goto L70;
            r21 = new ve5.d.c(new com.bytedance.ee.bear.middleground.comment.widget.b(r11, r13, BotAtHintActionType.LEARN_MORE, r111, r20.deviceCode, r20.deviceCodeExpireTime));
            goto L82
        L66:
            r111 = null;
        L81:
            r21 = ve5.d.a.a;
            goto L82
        L37:
            r19 = false;
            goto L38
        L40:
            r17 = (T) null;
        L42:
            r20 = null;
            goto L44
        L26:
            r2.h.put(r12.a, 1);
            r2.a.d(r11);
            goto L20
        L99:
            return;
        L15:
            r8 = null;
            goto L16
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ List<Long> a;

        public d(List<Long> r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            tt5.a.e("BotMentionHintCoordinator", "check ai bot config status failed, botIds=" + this.a, (Throwable) r4, false);
        }
    }

    static {
    }

    public e() {
        throw null;
    }

    public final void d() {
        StringBuilder r0 = new StringBuilder("[BOT_POLL_TRACE] clearPendingBotAuth, pendingBotId=");
        n r1 = this.f;
        if (r1 == null) goto L5;
        Long r2 = Long.valueOf(r1.a);
    L6:
        r0.append(r2);
        r0.append(", hasPolling=");
        if (this.e == null) goto L9;
        boolean r3 = true;
    L10:
        r0.append(r3);
        tt5.a.h("BotMentionHintCoordinator", r0.toString());
        this.f = null;
        m();
        return;
    L9:
        r3 = false;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final void j() {
        n r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        StringBuilder r1 = new StringBuilder("[BOT_POLL_TRACE] onReturnFromBotConfigPage, botId=");
        r1.append(r0.a);
        r1.append(", deviceCodeEmpty=");
        String r2 = r0.c;
        if (r2 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        r1.append(r3);
        r1.append(", expireTime=");
        r1.append(r0.d);
        tt5.a.h("BotMentionHintCoordinator", r1.toString());
        g(r0);
        return;
    L8:
        if (StringsKt.isBlank(r2) == true) goto L11;
        r3 = false;
        goto L12
    }

    public final void m() {
        if (this.e == null) goto L5;
        tt5.a.h("BotMentionHintCoordinator", "[BOT_POLL_TRACE] stopAuthPolling");
    L5:
        Disposable r0 = this.e;
        if (r0 == null) goto L8;
        r0.dispose();
    L8:
        this.e = null;
    }

    public static boolean e(Long r6) {
        if (r6 != null) goto L4;
    L9:
        return false;
    L4:
        if (r6.longValue() <= 0) goto L9;
        if (System.currentTimeMillis() < (r6.longValue() * 1000)) goto L9;
        return true;
    }

    public static boolean f(String r4) {
        if (StringsKt.isBlank(r4) == false) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L28;
        return false;
    L28:
        kotlin.Result.Companion r1 = kotlin.Result.Companion;     // Catch: Throwable -> L10
        Object r5 = kotlin.Result.constructor-impl(UriProtector.parse(r4));     // Catch: Throwable -> L10
    L12:
        String r3 = null;
        if (kotlin.Result.isFailure-impl(r5) == false) goto L15;
        r5 = null;
    L15:
        Uri r6 = (Uri) r5;
        if (r6 != null) goto L18;
        return false;
    L18:
        String r7 = r6.getScheme();
        if (r7 == null) goto L22;
        r3 = r7.toLowerCase(Locale.US);
    L22:
        if (Intrinsics.areEqual(r3, "http") == false) goto L24;
        return true;
    L24:
        if (Intrinsics.areEqual(r3, "https") == true) goto L31;
        return false;
    L31:
        return true;
    L10:
        th = move-exception;
        kotlin.Result.Companion r2 = kotlin.Result.Companion;
        r5 = kotlin.Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L5:
        r0 = false;
        goto L6
    }

    public final void a(AiBotCheckConfigStatusResult r19) {
        AiBotCheckConfigStatusResult.ResultsData r0 = (AiBotCheckConfigStatusResult.ResultsData) ((Result) r19).data;
        if (r0 == null) goto L10;
        ArrayList<AiBotCheckConfigStatusResult.Data> r1 = r0.results;
        if (r1 == null) goto L12;
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        AiBotCheckConfigStatusResult.Data r3 = (AiBotCheckConfigStatusResult.Data) r2.next();
        long r4 = r3.botId;
        Long r15 = Long.valueOf(r4);
        this.g.put(r15, new ve5.b(r4, r3.finishedConfig, r3.authUrl, r3.deviceCode, r3.deviceCodeExpireTime, r3.helpDocUrl, r3.isStoreApp, r3.isAppManager, r3.hasAppVisibility, System.currentTimeMillis()));
        r2 = r2;
        goto L8
    L13:
        return;
    L12:
        return;
    }

    public final void b(ve5.d r13) {
        if ((r13 instanceof ve5.d.c) == false) goto L22;
        BotAtHintView r0 = this.a;
        com.bytedance.ee.bear.middleground.comment.widget.b r14 = ((ve5.d.c) r13).a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r14, "hintInfo");
        int r2 = r0.b.z2();
        com.bytedance.ee.bear.middleground.comment.widget.a r3 = r0.b;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r14, "hintInfo");
        Iterator r1 = ((ArrayList) r3.a).iterator();
        int r5 = 0;
    L6:
        if (r1.hasNext() == false) goto L14;
        if (((com.bytedance.ee.bear.middleground.comment.widget.b) r1.next()).a != r14.a) goto L10;
        boolean r6 = true;
    L11:
        if (r6 == true) goto L15;
        r5 = r5 + 1;
    L15:
        if (r5 < 0) goto L17;
        ListProtector.set(r3.a, r5, r14);
        r3.A2();
        r3.notifyDataSetChanged();
    L18:
        int r4 = r0.b.z2();
        r0.c(r2, r4, "upsertHint");
        r0.g(r4);
        if (r0.getVisibility() != 0) goto L26;
        r0.l = r14;
        int r15 = r0.m + 1;
        r0.m = r15;
        r0.a.addOnLayoutChangeListener(new com.bytedance.ee.bear.middleground.comment.widget.c(r15, r0));
        return;
    L26:
        return;
    L17:
        ((ArrayList) r3.a).add(r14);
        r3.A2();
        r3.notifyDataSetChanged();
        goto L18
    L10:
        r6 = false;
        goto L11
    L14:
        r5 = -1;
        goto L15
    L22:
        if ((r13 instanceof ve5.d.b) == false) goto L25;
        this.a.d(((ve5.d.b) r13).a);
        return;
    L25:
        if (Intrinsics.areEqual(r13, ve5.d.a.a) == false) goto L28;
        return;
    L28:
        throw new NoWhenBranchMatchedException();
    }

    public final void g(n r9) {
        StringBuilder r0 = new StringBuilder("[BOT_POLL_TRACE] maybeStartPolling, botId=");
        r0.append(r9.a);
        r0.append(", deviceCodeEmpty=");
        String r2 = r9.c;
        boolean r3 = true;
        if (r2 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        r0.append(r4);
        r0.append(", expired=");
        r0.append(e(r9.d));
        r0.append(", expireTime=");
        r0.append(r9.d);
        tt5.a.h("BotMentionHintCoordinator", r0.toString());
        String r1 = r9.c;
        if (r1 != null) goto L12;
    L15:
        boolean r5 = true;
    L16:
        if (r5 == false) goto L18;
    L24:
        StringBuilder r6 = new StringBuilder("[BOT_POLL_TRACE] refreshCheckConfigBeforePollingIfNeeded, botId=");
        r6.append(r9.a);
        r6.append(", deviceCodeEmpty=");
        String r7 = r9.c;
        if (r7 != null) goto L27;
    L30:
        r6.append(r3);
        r6.append(", expireTime=");
        r6.append(r9.d);
        tt5.a.h("BotMentionHintCoordinator", r6.toString());
        m();
        l r8 = (l) this.c.invoke();
        this.b.a(this.d.a(CollectionsKt.listOf(Long.valueOf(r9.a)), r8.a, r8.b, r8.c).subscribeOn(fo5.d.c()).observeOn(fo5.d.d()).subscribe(new f(r9, this), new g(r9)));
        return;
    L27:
        if (StringsKt.isBlank(r7) == true) goto L30;
        r3 = false;
        goto L30
    L18:
        if (e(r9.d) == true) goto L24;
        long r10 = r9.a;
        String r11 = r9.c;
        tt5.a.h("BotMentionHintCoordinator", "[BOT_POLL_TRACE] startAuthPolling, botId=" + r10 + ", deviceCodePrefix=" + StringsKt.take(r11, 12));
        m();
        Disposable r12 = Flowable.interval(0, 5, TimeUnit.SECONDS).take(10).observeOn(fo5.d.c()).switchMap(new h(r10, this, r11)).observeOn(fo5.d.d()).subscribe(new i(r10, this), new j(r10, this), new k(r10, this));
        this.e = r12;
        if (r12 == null) goto L32;
        this.b.a(r12);
        return;
    L32:
        return;
    L12:
        if (StringsKt.isBlank(r1) == true) goto L15;
        r5 = false;
        goto L16
    L5:
        if (StringsKt.isBlank(r2) == true) goto L8;
        r4 = false;
        goto L9
    }

    public final void h(bo4.a r7) {
        Intrinsics.checkNotNullParameter(r7, "at");
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.comment.permission_guide_bot") == true) goto L5;
        return;
    L5:
        c(r7.e, r7.y);
        a r2 = null;
        if (r7.y != 4) goto L27;
        String r0 = r7.e;
        if (r0 == null) goto L27;
        Long r1 = StringsKt.toLongOrNull(r0);
        if (r1 == null) goto L27;
        long r3 = r1.longValue();
        String r8 = r7.g;
        if (r8 == null) goto L17;
        String r9 = StringsKt.removePrefix(r8, "@");
        if (r9 == null) goto L17;
        String r10 = StringsKt.trim(r9).toString();
    L18:
        if (r10 != null) goto L21;
        r10 = "";
    L21:
        if (r10.length() != 0) goto L23;
        boolean r4 = true;
    L24:
        if (r4 == true) goto L27;
        r2 = new a(r3, r10);
        goto L27
    L23:
        r4 = false;
    L17:
        r10 = null;
    L27:
        if (r2 != null) goto L29;
        return;
    L29:
        k(CollectionsKt.listOf(Long.valueOf(r2.a)), MapsKt.mapOf(TuplesKt.to(Long.valueOf(r2.a), new m(String.valueOf(r2.a), r2.b, 4))));
    }

    public final ve5.c i(com.bytedance.ee.bear.middleground.comment.widget.b r10) {
        Intrinsics.checkNotNullParameter(r10, "hintInfo");
        String r0 = r10.d;
        if (r0 == null) goto L27;
        if (f(r0) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L27;
        if (r10.c == BotAtHintActionType.CONFIGURE_NOW) goto L15;
        tt5.a.h("BotMentionHintCoordinator", "[BOT_POLL_TRACE] onHintActionClick skip pending, actionType=" + r10.c + ", botId=" + r10.a);
        return new ve5.c.b(r0);
    L15:
        if (this.e == null) goto L17;
        tt5.a.h("BotMentionHintCoordinator", "[BOT_POLL_TRACE] onHintActionClick stop previous polling before navigate, botId=" + r10.a);
        m();
    L17:
        this.f = new n(r10.a, r0, r10.e, r10.f);
        StringBuilder r1 = new StringBuilder("[BOT_POLL_TRACE] onHintActionClick set pending, botId=");
        r1.append(r10.a);
        r1.append(", deviceCodeEmpty=");
        String r2 = r10.e;
        if (r2 != null) goto L20;
    L23:
        boolean r3 = true;
    L24:
        r1.append(r3);
        r1.append(", expireTime=");
        r1.append(r10.f);
        r1.append(", url=");
        r1.append(r0);
        tt5.a.h("BotMentionHintCoordinator", r1.toString());
        return new ve5.c.b(r0);
    L20:
        if (StringsKt.isBlank(r2) == true) goto L23;
        r3 = false;
    L27:
        return ve5.c.a.a;
    }

    public final void l(List<m> r19) {
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.comment.permission_guide_bot") == true) goto L5;
        return;
    L5:
        LinkedHashSet r1 = new LinkedHashSet();
        Iterator<T> r2 = r19.iterator();
    L7:
        if (r2.hasNext() == false) goto L22;
        m r3 = (m) r2.next();
        Long r5 = StringsKt.toLongOrNull(r3.a);
        if (r5 == null) goto L7;
        long r6 = r5.longValue();
        int r7 = r3.c;
        if (r7 == 0) goto L13;
        int r4 = r7;
    L17:
        if (r4 == 0) goto L21;
        if (r4 != 4) goto L7;
    L21:
        r1.add(Long.valueOf(r6));
        goto L7
    L13:
        Integer r8 = (Integer) ((LinkedHashMap) this.h).get(r3.a);
        if (r8 == null) goto L16;
        r4 = r8.intValue();
        goto L17
    L16:
        r4 = 0;
        goto L17
    L22:
        List r9 = CollectionsKt.toList(r1);
        if (r9.isEmpty() == false) goto L25;
        return;
    L25:
        LinkedHashMap r10 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r19, 10)), 16));
        Iterator<T> r11 = r19.iterator();
    L26:
        long r12 = -1;
        if (r11.hasNext() == false) goto L32;
        m r13 = (m) r11.next();
        Long r14 = StringsKt.toLongOrNull(r13.a);
        if (r14 == null) goto L31;
        r12 = r14.longValue();
    L31:
        r10.put(Long.valueOf(r12), r13);
        goto L26
    L32:
        LinkedHashMap r15 = new LinkedHashMap();
        Iterator r16 = r10.entrySet().iterator();
    L33:
        boolean r17 = true;
        if (r16.hasNext() == false) goto L41;
        Map.Entry r18 = (Map.Entry) r16.next();
        if (((Number) r18.getKey()).longValue() != (-1)) goto L39;
        r17 = false;
    L39:
        if (r17 == false) goto L33;
        r15.put(r18.getKey(), r18.getValue());
        goto L33
    L41:
        ArrayList r20 = new ArrayList();
        Iterator r21 = r9.iterator();
    L43:
        if (r21.hasNext() == false) goto L110;
        long r22 = ((Number) r21.next()).longValue();
        m r23 = (m) r15.get(Long.valueOf(r22));
        if (r23 == null) goto L43;
        ve5.b r24 = (ve5.b) ((LinkedHashMap) this.g).get(Long.valueOf(r22));
        if (r24 != null) goto L51;
    L71:
        boolean r25 = false;
    L107:
        if (r25 == true) goto L43;
        r20.add(Long.valueOf(r22));
        goto L43
    L51:
        if (r24.b == false) goto L53;
    L68:
        boolean r110 = true;
    L69:
        if (r110 == true) goto L72;
        this.g.remove(Long.valueOf(r22));
        goto L71
    L72:
        String r111 = r23.b;
        if (r24.i == true) goto L76;
        ve5.d r26 = new ve5.d.b(r24.a);
    L106:
        b(r26);
        r25 = true;
        goto L107
    L76:
        if (r24.b == false) goto L79;
        r26 = new ve5.d.b(r24.a);
        goto L106
    L79:
        if (r24.g == false) goto L82;
        r26 = ve5.d.a.a;
        goto L106
    L82:
        if (r24.h == false) goto L84;
        String r27 = r24.c;
        if (r27 != null) goto L99;
    L105:
        r26 = new ve5.d.b(r24.a);
        goto L106
    L99:
        if (f(r27) == false) goto L101;
        String r112 = r27;
    L102:
        if (r112 == null) goto L105;
        r26 = new ve5.d.c(new com.bytedance.ee.bear.middleground.comment.widget.b(r24.a, r111, BotAtHintActionType.CONFIGURE_NOW, r112, r24.d, r24.e));
        goto L106
    L101:
        r112 = null;
        goto L102
    L84:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.comment.permission_guide_non_admin_bot") == true) goto L86;
        r26 = new ve5.d.b(r24.a);
        goto L106
    L86:
        String r28 = r24.f;
        if (r28 != null) goto L89;
    L95:
        r26 = new ve5.d.b(r24.a);
        goto L106
    L89:
        if (f(r28) == false) goto L91;
        String r113 = r28;
    L92:
        if (r113 == null) goto L95;
        r26 = new ve5.d.c(new com.bytedance.ee.bear.middleground.comment.widget.b(r24.a, r111, BotAtHintActionType.LEARN_MORE, r113, r24.d, r24.e));
        goto L106
    L91:
        r113 = null;
        goto L92
    L53:
        if (r24.i == false) goto L68;
        if (r24.g == true) goto L68;
        if (r24.h == false) goto L60;
        boolean r114 = e(r24.e);
    L67:
        r110 = !r114;
        goto L69
    L60:
        String r115 = r24.f;
        if (r115 != null) goto L63;
    L66:
        r114 = true;
        goto L67
    L63:
        if (StringsKt.isBlank(r115) == true) goto L66;
        r114 = false;
        goto L67
    L110:
        if ((!r20.isEmpty()) == false) goto L136;
        k(CollectionsKt.distinct(r20), r15);
        return;
    }

    public final void n(Set<Long> r5) {
        Intrinsics.checkNotNullParameter(r5, "tokens");
        this.a.f(r5);
        n r0 = this.f;
        if (r0 != null) goto L5;
    L7:
        r0 = null;
    L8:
        this.f = r0;
        return;
    L5:
        if (r5.contains(Long.valueOf(r0.a)) == false) goto L7;
        goto L7
    }

    public final void c(String r2, int r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if ((!StringsKt.isBlank(r2)) == true) goto L7;
        r2 = null;
    L7:
        if (r2 == null) goto L14;
        if (r3 != 0) goto L11;
        return;
    L11:
        this.h.put(r2, Integer.valueOf(r3));
        return;
    }

    public final void k(List<Long> r8, Map<Long, m> r9) {
        if (r8.isEmpty() == false) goto L5;
        return;
    L5:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.comment.permission_guide_bot") == false) goto L10;
        l r0 = (l) this.c.invoke();
        Disposable r10 = this.d.a(r8, r0.a, r0.b, r0.c).subscribeOn(fo5.d.c()).observeOn(fo5.d.d()).subscribe(new c(r8, this, r9), new d(r8));
        this.b.a(r10);
        return;
    }

    public e(BotAtHintView r3, b2 r4, Function0 r5) {
        ve5.a r0 = new ve5.a();
        Intrinsics.checkNotNullParameter(r3, "hintView");
        Intrinsics.checkNotNullParameter(r4, "disposableOwner");
        Intrinsics.checkNotNullParameter(r5, "sceneContextProvider");
        Intrinsics.checkNotNullParameter(r0, "repository");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r0;
        this.g = new LinkedHashMap();
        this.h = new LinkedHashMap();
    }
}
