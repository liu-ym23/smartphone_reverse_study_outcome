package com.ss.android.lark.biz.im.api.page.plugin;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/biz/im/api/page/plugin/PluginType;", "", "<init>", "(Ljava/lang/String;I)V", "BOT_CHAT_PLUGIN_FACTORY", "SECRET_CHAT_PLUGIN_FACTORY", "AI_CHAT_PLUGIN_FACTORY", "ENTER_CHAT_HIT_POINT", "FLOW_CHAT_PLUGIN_FACTORY", "REPLY_IN_THREAD_PLUGIN_FACTORY", "MERGE_FORWARD_PLUGIN_FACTORY", "FLOW_THREAD_WINDOW_PLUGIN_FACTORY", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PluginType extends Enum<PluginType> {
    public static final PluginType AI_CHAT_PLUGIN_FACTORY = null;
    public static final PluginType BOT_CHAT_PLUGIN_FACTORY = null;
    public static final PluginType ENTER_CHAT_HIT_POINT = null;
    public static final PluginType FLOW_CHAT_PLUGIN_FACTORY = null;
    public static final PluginType FLOW_THREAD_WINDOW_PLUGIN_FACTORY = null;
    public static final PluginType MERGE_FORWARD_PLUGIN_FACTORY = null;
    public static final PluginType REPLY_IN_THREAD_PLUGIN_FACTORY = null;
    public static final PluginType SECRET_CHAT_PLUGIN_FACTORY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PluginType[] f410433a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410434b = null;

    public static EnumEntries<PluginType> getEntries() {
        return f410434b;
    }

    static {
        PluginType r100 = new PluginType("BOT_CHAT_PLUGIN_FACTORY", 0);
        BOT_CHAT_PLUGIN_FACTORY = r100;
        PluginType r101 = new PluginType("SECRET_CHAT_PLUGIN_FACTORY", 1);
        SECRET_CHAT_PLUGIN_FACTORY = r101;
        PluginType r102 = new PluginType("AI_CHAT_PLUGIN_FACTORY", 2);
        AI_CHAT_PLUGIN_FACTORY = r102;
        PluginType r103 = new PluginType("ENTER_CHAT_HIT_POINT", 3);
        ENTER_CHAT_HIT_POINT = r103;
        PluginType r104 = new PluginType("FLOW_CHAT_PLUGIN_FACTORY", 4);
        FLOW_CHAT_PLUGIN_FACTORY = r104;
        PluginType r105 = new PluginType("REPLY_IN_THREAD_PLUGIN_FACTORY", 5);
        REPLY_IN_THREAD_PLUGIN_FACTORY = r105;
        PluginType r110 = new PluginType("MERGE_FORWARD_PLUGIN_FACTORY", 6);
        MERGE_FORWARD_PLUGIN_FACTORY = r110;
        PluginType r111 = new PluginType("FLOW_THREAD_WINDOW_PLUGIN_FACTORY", 7);
        FLOW_THREAD_WINDOW_PLUGIN_FACTORY = r111;
        PluginType[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f410433a = r112;
        f410434b = EnumEntriesKt.enumEntries(r112);
    }

    public static PluginType[] values() {
        return (PluginType[]) f410433a.clone();
    }

    public static PluginType valueOf(String r100) {
        return (PluginType) a.a(PluginType.class, r100);
    }

    public PluginType(String r100, int r101) {
        super(r100, r101);
    }
}
