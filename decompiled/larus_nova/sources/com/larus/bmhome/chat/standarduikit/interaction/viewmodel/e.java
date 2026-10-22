package com.larus.bmhome.chat.standarduikit.interaction.viewmodel;

import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.pitaya.api.PTYSocketStateCallback;
import com.larus.bmhome.interactionpanel.w;
import com.larus.bmhome.interactionpanel.x;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.bean.message.block.QuickReplyInteractionType;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f309333g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Set<Integer> f309334h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Long> f309335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.bmhome.chat.standarduikit.interaction.viewmodel.a f309336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<String, JSONObject, Unit> f309337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f309338d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f309339e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f309340f;

    public static final class a {
        public a() {
        }

        public static String a(String r100) {
            if (r100 == null) goto L11;
            String r101 = StringsKt.trim(r100).toString();
            if (r101 == null) goto L11;
            if (r101.length() <= 0) goto L8;
            boolean r102 = true;
        L9:
            if (r102 == false) goto L11;
            return r101;
        L8:
            r102 = false;
        L11:
            return null;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f309341a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f309342b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f309343c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f309344d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f309345e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f309346f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f309347g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final w f309348h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f309349i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String f309350j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final String f309351k;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f309341a, r101.f309341a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f309342b, r101.f309342b) == true) goto L15;
            return false;
        L15:
            if (this.f309343c == r101.f309343c) goto L18;
            return false;
        L18:
            if (this.f309344d == r101.f309344d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f309345e, r101.f309345e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f309346f, r101.f309346f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f309347g, r101.f309347g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f309348h, r101.f309348h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.f309349i, r101.f309349i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.f309350j, r101.f309350j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.f309351k, r101.f309351k) == true) goto L41;
            return false;
        L41:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f309341a.hashCode() * 31) + this.f309342b.hashCode()) * 31) + this.f309343c) * 31;
            if (this.f309344d == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = (((((((r100 + r101) * 31) + this.f309345e.hashCode()) * 31) + this.f309346f.hashCode()) * 31) + this.f309347g.hashCode()) * 31;
            w r103 = this.f309348h;
            int r104 = 0;
            if (r103 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r102 + r105) * 31;
            String r107 = this.f309349i;
            if (r107 == null) goto L15;
            r104 = r107.hashCode();
        L15:
            return ((((r106 + r104) * 31) + this.f309350j.hashCode()) * 31) + this.f309351k.hashCode();
        L9:
            r105 = r103.hashCode();
            goto L10
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "Context(blockId=" + this.f309341a + ", messageId=" + this.f309342b + ", interactionType=" + this.f309343c + ", folderSpecified=" + this.f309344d + ", currentPage=" + this.f309345e + ", displayType=" + this.f309346f + ", agentType=" + this.f309347g + ", trackContext=" + this.f309348h + ", triggerScene=" + this.f309349i + ", conversationId=" + this.f309350j + ", accountId=" + this.f309351k + ')';
        }

        public b(String r100, String r101, int r102, boolean r103, String r104, String r105, String r106, w r107, String r110, String r111, String r112) {
            Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.BLOCK_ID);
            Intrinsics.checkNotNullParameter(r101, "messageId");
            Intrinsics.checkNotNullParameter(r104, "currentPage");
            Intrinsics.checkNotNullParameter(r105, "displayType");
            Intrinsics.checkNotNullParameter(r106, "agentType");
            Intrinsics.checkNotNullParameter(r111, "conversationId");
            Intrinsics.checkNotNullParameter(r112, "accountId");
            this.f309341a = r100;
            this.f309342b = r101;
            this.f309343c = r102;
            this.f309344d = r103;
            this.f309345e = r104;
            this.f309346f = r105;
            this.f309347g = r106;
            this.f309348h = r107;
            this.f309349i = r110;
            this.f309350j = r111;
            this.f309351k = r112;
        }
    }

    static {
        f309333g = new a();
        f309334h = SetsKt.setOf(new Integer[]{Integer.valueOf(QuickReplyInteractionType.QUICK_REPLY_INTERACTION_TYPE_REQUEST_ACTION.getValue()), Integer.valueOf(QuickReplyInteractionType.QUICK_REPLY_INTERACTION_TYPE_BASH_WARN.getValue()), Integer.valueOf(QuickReplyInteractionType.QUICK_REPLY_INTERACTION_TYPE_AUTHORIZE_FOLDER.getValue())});
    }

    public final void b() {
        Intrinsics.checkNotNullParameter(PTYSocketStateCallback.CLOSED, "result");
        if (this.f309340f == true) goto L13;
        b r100 = this.f309338d;
        if (r100 == null) goto L14;
        Long r101 = this.f309339e;
        if (r101 == null) goto L12;
        c(r100, r101.longValue(), PTYSocketStateCallback.CLOSED);
        return;
    L12:
        return;
    L14:
        return;
    }

    public final void d() {
        if (this.f309339e == null) goto L5;
        return;
    L5:
        b r100 = this.f309338d;
        if (r100 != null) goto L8;
        return;
    L8:
        com.larus.bmhome.chat.standarduikit.interaction.viewmodel.a r101 = this.f309336b;
        com.larus.bmhome.chat.standarduikit.interaction.viewmodel.a.b r102 = e(r100);
        monitor-enter(r101);
        Intrinsics.checkNotNullParameter(r102, "key");     // Catch: Throwable -> L16
        boolean r103 = r101.f309322b.contains(r102);     // Catch: Throwable -> L16
        monitor-exit(r101);
        if (r103 == false) goto L14;
        return;
    L14:
        this.f309339e = this.f309335a.invoke();
        this.f309337c.invoke("interaction_component_show", a(r100, true));
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public e(int r100) {
        InteractionQuickReplyTracker$1 r101 = InteractionQuickReplyTracker$1.INSTANCE;
        com.larus.bmhome.chat.standarduikit.interaction.viewmodel.a r102 = com.larus.bmhome.chat.standarduikit.interaction.viewmodel.a.f309320e;
        Function2<String, JSONObject, Unit> r103 = new com.larus.bmhome.chat.standarduikit.interaction.viewmodel.b();
        Intrinsics.checkNotNullParameter(r101, "elapsedRealtime");
        Intrinsics.checkNotNullParameter(r102, "resultStore");
        Intrinsics.checkNotNullParameter(r103, "reportEvent");
        this.f309335a = r101;
        this.f309336b = r102;
        this.f309337c = r103;
    }

    public static com.larus.bmhome.chat.standarduikit.interaction.viewmodel.a.b e(b r100) {
        return new com.larus.bmhome.chat.standarduikit.interaction.viewmodel.a.b(r100.f309351k, r100.f309350j, r100.f309342b, r100.f309341a);
    }

    public static JSONObject a(b r100, boolean r101) {
        JSONObject r102 = new JSONObject();
        r102.put(BitableResourceData.KEY_BLOCK_ID, r100.f309341a);
        r102.put(MusicAppletPage.KEY_MESSAGE_ID, r100.f309342b);
        r102.put("current_page", r100.f309345e);
        r102.put(com.bytedance.android.ec.core.event.a.KEY_INTERACTION_TYPE, r100.f309343c);
        x.a(r102, r100.f309348h);
        r102.put("display_type", r100.f309346f);
        r102.put("agent_type", r100.f309347g);
        String r103 = r100.f309349i;
        if (r103 == null) goto L5;
        r102.put("trigger_scene", r103);
    L5:
        if (r101 == true) goto L7;
    L9:
        return r102;
    L7:
        if (r100.f309343c != QuickReplyInteractionType.QUICK_REPLY_INTERACTION_TYPE_AUTHORIZE_FOLDER.getValue()) goto L9;
        r102.put("folder_specified", r100.f309344d ? 1 : 0);
        goto L9
    }

    public final void c(final b r110, final long r111, final String r112) {
        com.larus.bmhome.chat.standarduikit.interaction.viewmodel.a.b r100 = e(r110);
        com.larus.bmhome.chat.standarduikit.interaction.viewmodel.a.b r101 = null;
        if (Intrinsics.areEqual(r112, PTYSocketStateCallback.CLOSED) == false) goto L34;
        com.larus.bmhome.chat.standarduikit.interaction.viewmodel.a r113 = this.f309336b;
        Function0<Unit> r114 = new c(this, r110, r111, r112);
        monitor-enter(r113);
        Intrinsics.checkNotNullParameter(r100, "key");     // Catch: Throwable -> L30
        Intrinsics.checkNotNullParameter(r114, "report");     // Catch: Throwable -> L30
        if (r113.f309322b.contains(r100) == false) goto L11;
        monitor-exit(r113);
    L18:
        boolean r102 = true;
    L19:
        if (r102 == false) goto L21;
        return;
    L21:
        b r103 = this.f309338d;
        if (r103 == null) goto L24;
        com.larus.bmhome.chat.standarduikit.interaction.viewmodel.a.b r104 = e(r103);
    L26:
        if (Intrinsics.areEqual(r104, r100) == true) goto L28;
    L36:
        b r105 = this.f309338d;
        if (r105 == null) goto L40;
        r101 = e(r105);
    L40:
        if (Intrinsics.areEqual(r101, r100) == false) goto L42;
        this.f309340f = true;
    L42:
        Function2<String, JSONObject, Unit> r106 = this.f309337c;
        JSONObject r107 = a(r110, false);
        r107.put("result", r112);
        r107.put("duration", RangesKt.coerceAtLeast(this.f309335a.invoke().longValue() - r111, 0));
        Unit r108 = Unit.INSTANCE;
        r106.invoke("interaction_result", r107);
        return;
    L28:
        if (this.f309340f == false) goto L36;
        return;
    L24:
        r104 = null;
        goto L26
    L11:
        if (r113.f309323c.containsKey(r100) == true) goto L15;
        monitor-exit(r113);
        r102 = false;
        goto L19
    L15:
        if (r113.f309324d.containsKey(r100) == true) goto L17;
        r113.f309324d.put(r100, r114);     // Catch: Throwable -> L30
    L17:
        monitor-exit(r113);
    L30:
        th = move-exception;
        throw th;
    L34:
        if (this.f309336b.a(r100) == true) goto L36;
    }
}
