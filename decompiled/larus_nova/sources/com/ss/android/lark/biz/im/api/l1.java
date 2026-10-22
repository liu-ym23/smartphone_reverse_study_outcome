package com.ss.android.lark.biz.im.api;

import android.os.Bundle;
import android.text.TextUtils;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.entity.thread.TopicGroup;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class l1 {
    public final String A;
    public final boolean B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f410268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f410269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f410270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f410271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f410272e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f410273f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ThreadTopic f410274g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Chat f410275h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TopicGroup f410276i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f410277j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f410278k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f410279l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f410280m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f410281n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f410282o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f410283p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f410284q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Message f410285r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Message f410286s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final MergeForwardContent f410287t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f410288u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f410289v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Boolean f410290w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final MessageInfo f410291x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f410292y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f410293z;

    public static class a {
        public String A;
        public boolean B;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f410294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f410295b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Chat f410296c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f410297d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f410298e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f410299f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f410300g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ThreadTopic f410301h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public TopicGroup f410302i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f410303j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f410304k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f410305l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f410306m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f410307n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f410308o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public String f410309p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f410310q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public Message f410311r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public Message f410312s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public MergeForwardContent f410313t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public String f410314u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public String f410315v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public Boolean f410316w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public MessageInfo f410317x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public String f410318y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public String f410319z;

        public final l1 a() {
            return new l1(this);
        }

        public a() {
            this.f410299f = -100;
            this.f410300g = true;
            this.f410303j = "";
            this.f410304k = -1;
            this.f410307n = true;
            this.f410308o = true;
            this.f410309p = "";
            this.f410310q = 0;
            this.f410311r = null;
            this.f410312s = null;
            this.f410313t = null;
            this.f410314u = "";
            this.f410315v = "";
            this.f410316w = Boolean.FALSE;
            this.f410317x = null;
            this.f410318y = null;
            this.f410319z = null;
            this.A = null;
            this.B = false;
        }
    }

    public final Bundle a() {
        Bundle r100 = new Bundle();
        String r101 = this.f410268a;
        if (r101 == null) goto L5;
        r100.putString("key_params_thread_id", r101);
    L5:
        String r102 = this.f410271d;
        if (r102 == null) goto L8;
        r100.putString("key_params_thread_source", r102);
    L8:
        r100.putInt("key_params_jump_position", this.f410269b);
        r100.putBoolean("key_params_need_show_bubble", this.f410270c);
        r100.putBoolean("key_params_show_reply", false);
        r100.putBoolean("key_params_show_keyboard", this.f410272e);
        r100.putBoolean("key_params_load_from_start", this.f410273f);
        r100.putBoolean("key_params_open_thread_window", true);
        r100.putBoolean("key_params_is_from_tab", false);
        r100.putSerializable("key_params_topic_group", this.f410276i);
        r100.putInt("key_params_feed_card_type", this.f410278k);
        r100.putString("key_params_from", this.f410279l);
        r100.putString("key_params_chat_id", this.f410277j);
        r100.putBoolean("key_params_is_from_card", this.f410280m);
        r100.putBoolean("key_params_has_create_thread", this.f410281n);
        r100.putBoolean("key_params_show_chat_name", this.f410282o);
        r100.putString("key_params_origin_merge_forward_message_id", this.f410283p);
        r100.putInt("key_params_merge_forward_from_type", this.f410284q);
        r100.putString("key_params_root_message_id", this.f410288u);
        r100.putString("key_params_auto_translate_target_lang_by_card", this.f410289v);
        r100.putBoolean("key_bottom_sheet_container_start", this.f410290w.booleanValue());
        ThreadTopic r103 = this.f410274g;
        if (r103 == null) goto L12;
        r100.putSerializable("key_params_thread", r103);
    L12:
        if (TextUtils.isEmpty(this.f410292y) == true) goto L15;
        r100.putString("key_params_preview_id", this.f410292y);
    L15:
        if (TextUtils.isEmpty(this.f410293z) == true) goto L17;
        r100.putString("key_params_msg_link_token", this.f410293z);
    L17:
        Chat r104 = this.f410275h;
        if (r104 == null) goto L20;
        r100.putSerializable("key_params_thread_chat", r104);
    L20:
        Message r105 = this.f410285r;
        if (r105 == null) goto L30;
        String r106 = r105.getId();
        Map<String, Message> r107 = k1.f410262a;
        Message r108 = this.f410285r;
        Intrinsics.checkNotNullParameter(r106, "messageId");
        if (r108 == null) goto L26;
        k1.f410262a.put(r106, r108);
    L26:
        r100.putString("key_params_merge_forward_message_id", r106);
        Message r109 = this.f410286s;
        if (r109 == null) goto L30;
        Intrinsics.checkNotNullParameter(r106, "messageId");
        k1.f410263b.put(r106, r109);
    L30:
        if (this.f410287t == null) goto L36;
        String r110 = UUID.randomUUID().toString();
        Map<String, Message> r111 = k1.f410262a;
        MergeForwardContent r112 = this.f410287t;
        Intrinsics.checkNotNullParameter(r110, "key");
        if (r112 == null) goto L35;
        k1.f410264c.put(r110, r112);
    L35:
        r100.putString("key_params_parent_message_content", r110);
    L36:
        MessageInfo r113 = this.f410291x;
        if (r113 == null) goto L42;
        Map<String, Message> r114 = k1.f410262a;
        String r115 = r113.getId();
        MessageInfo r116 = this.f410291x;
        Intrinsics.checkNotNullParameter(r115, "messageId");
        if (r116 == null) goto L42;
        k1.f410265d.put(r115, r116);
    L42:
        String r117 = this.A;
        if (r117 == null) goto L45;
        r100.putString("key_params_thread_source_type", r117);
    L45:
        r100.putBoolean("is_embedded", this.B);
        return r100;
    }

    public l1(a r100) {
        this.f410278k = -1;
        this.f410279l = "";
        this.f410281n = true;
        this.f410282o = true;
        this.f410283p = "";
        this.f410284q = 0;
        this.f410285r = null;
        this.f410286s = null;
        this.f410287t = null;
        this.f410288u = "";
        this.f410289v = "";
        this.B = false;
        this.f410268a = r100.f410298e;
        this.f410277j = r100.f410305l;
        this.f410269b = r100.f410299f;
        this.f410270c = r100.f410300g;
        this.f410274g = r100.f410301h;
        this.f410271d = r100.f410294a;
        this.f410272e = r100.f410295b;
        this.f410275h = r100.f410296c;
        this.f410273f = r100.f410297d;
        this.f410276i = r100.f410302i;
        this.f410278k = r100.f410304k;
        this.f410279l = r100.f410303j;
        this.f410280m = r100.f410306m;
        this.f410281n = r100.f410307n;
        this.f410282o = r100.f410308o;
        this.f410283p = r100.f410309p;
        this.f410284q = r100.f410310q;
        this.f410285r = r100.f410311r;
        this.f410286s = r100.f410312s;
        this.f410287t = r100.f410313t;
        this.f410288u = r100.f410314u;
        this.f410289v = r100.f410315v;
        this.f410290w = r100.f410316w;
        this.f410291x = r100.f410317x;
        this.f410292y = r100.f410318y;
        this.f410293z = r100.f410319z;
        this.A = r100.A;
        this.B = r100.B;
    }
}
