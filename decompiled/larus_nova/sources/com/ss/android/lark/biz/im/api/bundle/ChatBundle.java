package com.ss.android.lark.biz.im.api.bundle;

import android.os.Bundle;
import android.text.TextUtils;
import com.ss.android.lark.biz.im.api.ChatIntentExtraBundle;
import com.ss.android.lark.biz.im.api.ChatWindowPrepareData;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.LarkAgentContext;
import fxa.b;

/* JADX INFO: loaded from: classes34.dex */
public final class ChatBundle implements b {
    public final LarkAgentContext A;
    public final ChatIntentExtraBundle B;
    public final boolean C;
    public final boolean D;
    public final boolean E;
    public final Chat.ChatMode F;
    public final boolean G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f409908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f409909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f409910c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f409911d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f409912e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f409913f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f409914g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SourceType f409915h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Chat.ChatMode f409916i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f409917j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f409918k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f409919l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f409920m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ChatWindowPrepareData f409921n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f409922o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f409923p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Bundle f409924q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f409925r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f409926s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f409927t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f409928u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f409929v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ChatTeamBundle f409930w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Bundle f409931x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f409932y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ChatAIBundle f409933z;

    public @interface TRANSITION {
        public static final int MULTITASK_BACK = 2;
        public static final int MULTITASK_IN = 1;
        public static final int NORMAL = 0;
    }

    public static class a {
        public boolean A;
        public boolean B;
        public ChatAIBundle C;
        public LarkAgentContext D;
        public ChatIntentExtraBundle E;
        public Chat.ChatMode F;
        public boolean G;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f409934a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f409935b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f409936c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f409937d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f409938e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f409939f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f409940g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public SourceType f409941h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f409942i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public ChatWindowPrepareData f409943j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Chat.ChatMode f409944k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f409945l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f409946m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f409947n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f409948o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Bundle f409949p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f409950q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f409951r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f409952s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f409953t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public String f409954u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public String f409955v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public ChatTeamBundle f409956w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public Bundle f409957x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f409958y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public boolean f409959z;

        public a() {
            this.f409936c = -1;
            this.f409939f = -1;
            this.f409944k = Chat.ChatMode.UNKNOWN;
            this.f409945l = true;
            this.f409946m = false;
            this.f409947n = false;
            this.f409950q = false;
            this.f409951r = false;
            this.f409952s = false;
            this.f409953t = false;
            this.f409954u = null;
            this.f409955v = null;
            this.f409958y = 0;
            this.f409959z = false;
            this.A = true;
            this.B = false;
            this.G = false;
        }

        public final void a(Chat.ChatMode r100) {
            if (r100 != null) goto L4;
            r100 = Chat.ChatMode.UNKNOWN;
        L4:
            this.f409944k = r100;
        }

        public final void b(Boolean r100) {
            this.f409959z = r100.booleanValue();
        }
    }

    @Override // fxa.b
    public final boolean a() {
        return false;
    }

    @Override // fxa.b
    public final Bundle k() {
        Bundle r100 = this.f409924q;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new Bundle();
    }

    public final Bundle l() {
        Bundle r100 = new Bundle();
        String r101 = this.f409908a;
        if (r101 == null) goto L5;
        r100.putString("chatID", r101);
    L5:
        String r102 = this.f409909b;
        if (r102 == null) goto L8;
        r100.putString("chatterID", r102);
    L8:
        String r103 = this.f409911d;
        if (r103 == null) goto L11;
        r100.putString("gochatwin_from", r103);
    L11:
        String r104 = this.f409913f;
        if (r104 == null) goto L14;
        r100.putString("messageId", r104);
    L14:
        r100.putBoolean("need_show_position", this.f409922o);
        r100.putLong("tabId", this.f409923p);
        ChatWindowPrepareData r105 = this.f409921n;
        if (r105 == null) goto L17;
        r100.putSerializable("initData", r105);
    L17:
        r100.putInt("extra_chat_mode", this.f409916i.getNumber());
        if (TextUtils.isEmpty(this.f409912e) == true) goto L20;
        r100.putString("extra_key_app_id", this.f409912e);
    L20:
        r100.putInt("showPosition", this.f409910c);
        r100.putBoolean("extra_need_badge", this.f409917j);
        r100.putBoolean("extra_is_secret_chat", this.f409918k);
        r100.putBoolean("extra_is_cloud_apply", this.f409919l);
        r100.putParcelable("option_bundle", this.f409924q);
        r100.putBoolean("key_param_from_offline_push", this.f409925r);
        r100.putBoolean("key_param_immediate_open_chat", this.f409926s);
        r100.putBoolean("key_is_show_group_profile", this.f409927t);
        r100.putBoolean("key_show_apply_chat", this.f409920m);
        r100.putString("extra_select_messages_random_key", this.f409928u);
        ChatTeamBundle r106 = this.f409930w;
        if (r106 == null) goto L23;
        r100.putParcelable("key_team_bundle", r106);
    L23:
        SourceType r107 = this.f409915h;
        if (r107 == null) goto L26;
        r100.putString("key_source_type", r107.value);
    L26:
        r100.putBundle("key_extra_params", this.f409931x);
        r100.putInt("key_ai_chat_type", this.f409932y);
        r100.putBoolean("key_bottom_sheet_container_start", this.C);
        r100.putBoolean("key_newintent_rebuild_chat", this.D);
        r100.putBoolean("key_show_message_not_found_tip", this.E);
        r100.putParcelable("ai_bundle", this.f409933z);
        r100.putParcelable("lark_nexus_context", this.A);
        r100.putParcelable("intent_bundle", this.B);
        Chat.ChatMode r108 = this.F;
        if (r108 == null) goto L29;
        r100.putInt("override_chat_mode", r108.getNumber());
    L29:
        r100.putBoolean("is_embedded", this.G);
        return r100;
    }

    @Override // fxa.b
    public final boolean D() {
        return this.C;
    }

    @Override // fxa.b
    public final String b() {
        return this.f409909b;
    }

    @Override // fxa.b
    public final String c() {
        return this.f409928u;
    }

    @Override // fxa.b
    public final boolean d() {
        return this.f409925r;
    }

    @Override // fxa.b
    public final ChatTeamBundle e() {
        return this.f409930w;
    }

    @Override // fxa.b
    public final ChatWindowPrepareData g() {
        return this.f409921n;
    }

    @Override // fxa.b
    public final String getAppId() {
        return this.f409912e;
    }

    @Override // fxa.b
    public final String getChatId() {
        return this.f409908a;
    }

    @Override // fxa.b
    public final Bundle getExtraParams() {
        return this.f409931x;
    }

    @Override // fxa.b
    public final String getMessageId() {
        return this.f409913f;
    }

    @Override // fxa.b
    public final SourceType getSourceType() {
        return this.f409915h;
    }

    @Override // fxa.b
    public final long getTabId() {
        return this.f409923p;
    }

    @Override // fxa.b
    public final String h() {
        return this.f409929v;
    }

    @Override // fxa.b
    public final boolean i() {
        return this.f409917j;
    }

    @Override // fxa.b
    public final boolean isSecretChat() {
        return this.f409918k;
    }

    @Override // fxa.b
    public final ChatIntentExtraBundle j() {
        return this.B;
    }

    @Override // fxa.b
    public final int o() {
        return this.f409910c;
    }

    @Override // fxa.b
    public final String q() {
        return this.f409911d;
    }

    @Override // fxa.b
    public final boolean s() {
        return this.D;
    }

    @Override // fxa.b
    public final boolean t() {
        return this.E;
    }

    public ChatBundle(a r100) {
        this.D = true;
        this.E = false;
        this.F = null;
        this.G = false;
        this.f409908a = r100.f409934a;
        this.f409909b = r100.f409935b;
        this.f409910c = r100.f409936c;
        this.f409911d = r100.f409937d;
        this.f409912e = r100.f409938e;
        this.f409914g = r100.f409939f;
        this.f409915h = r100.f409941h;
        this.f409921n = r100.f409943j;
        this.f409922o = r100.f409948o;
        this.f409923p = r100.f409942i;
        this.f409913f = r100.f409940g;
        this.f409916i = r100.f409944k;
        this.f409917j = r100.f409945l;
        this.f409918k = r100.f409946m;
        this.f409919l = r100.f409947n;
        this.f409924q = r100.f409949p;
        this.f409925r = r100.f409950q;
        this.f409926s = r100.f409951r;
        this.f409927t = r100.f409952s;
        this.f409920m = r100.f409953t;
        this.f409928u = r100.f409954u;
        this.f409929v = r100.f409955v;
        this.f409930w = r100.f409956w;
        this.f409931x = r100.f409957x;
        this.f409932y = r100.f409958y;
        this.C = r100.f409959z;
        this.D = r100.A;
        this.E = r100.B;
        this.f409933z = r100.C;
        this.A = r100.D;
        this.B = r100.E;
        this.F = r100.F;
        this.G = r100.G;
    }

    public static ChatBundle f(Bundle r100) {
        a r101 = new a();
        r101.f409934a = r100.getString("chatID");
        r101.f409935b = r100.getString("chatterID");
        r101.f409943j = (ChatWindowPrepareData) r100.getSerializable("initData");
        r101.f409936c = r100.getInt("showPosition");
        r101.f409940g = r100.getString("messageId");
        r101.f409942i = r100.getLong("tabId");
        r101.f409948o = r100.getBoolean("need_show_position");
        r101.f409937d = r100.getString("gochatwin_from");
        Chat.ChatMode r102 = Chat.ChatMode.UNKNOWN;
        r101.a(Chat.ChatMode.forNumber(r100.getInt("extra_chat_mode", r102.getNumber())));
        r101.f409945l = r100.getBoolean("extra_need_badge");
        r101.f409946m = r100.getBoolean("extra_is_secret_chat");
        r101.f409947n = r100.getBoolean("extra_is_cloud_apply");
        r101.f409949p = (Bundle) r100.getParcelable("option_bundle");
        r101.f409938e = r100.getString("extra_key_app_id");
        r101.f409950q = r100.getBoolean("key_param_from_offline_push");
        r101.f409951r = r100.getBoolean("key_param_immediate_open_chat");
        r101.f409952s = r100.getBoolean("key_is_show_group_profile");
        r101.f409953t = r100.getBoolean("key_show_apply_chat");
        r101.f409954u = r100.getString("extra_select_messages_random_key", "");
        r101.f409956w = (ChatTeamBundle) r100.getParcelable("key_team_bundle");
        r101.f409941h = SourceType.fromValue(r100.getString("key_source_type", ""));
        r101.f409957x = r100.getBundle("key_extra_params");
        r101.f409958y = r100.getInt("key_ai_chat_type", 0);
        r101.b(Boolean.valueOf(r100.getBoolean("key_bottom_sheet_container_start")));
        r101.A = r100.getBoolean("key_newintent_rebuild_chat", true);
        r101.B = r100.getBoolean("key_show_message_not_found_tip", false);
        r101.C = (ChatAIBundle) r100.getParcelable("ai_bundle");
        r101.D = (LarkAgentContext) r100.getParcelable("lark_nexus_context");
        r101.E = (ChatIntentExtraBundle) r100.getParcelable("intent_bundle");
        r101.F = Chat.ChatMode.forNumber(r100.getInt("override_chat_mode", r102.getNumber()));
        r101.G = r100.getBoolean("is_embedded");
        return new ChatBundle(r101);
    }

    @Override // fxa.b
    public final void r(int r100) {
        this.f409910c = r100;
    }

    @Override // fxa.b
    public final void z(String r100) {
        this.f409908a = r100;
    }
}
