package com.larus.mirabridge.api.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/mirabridge/api/bean/PluginUpdateMethod;", "", "<init>", "(Ljava/lang/String;I)V", "AUTO_FIT", "UPDATE_FIRST", "DO_NOT_UPDATE", "UPDATE_BACKGROUND", "UPDATE_WHEN_APP_BACKGROUND", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PluginUpdateMethod extends Enum<PluginUpdateMethod> {
    public static final PluginUpdateMethod AUTO_FIT = null;
    public static final PluginUpdateMethod DO_NOT_UPDATE = null;
    public static final PluginUpdateMethod UPDATE_BACKGROUND = null;
    public static final PluginUpdateMethod UPDATE_FIRST = null;
    public static final PluginUpdateMethod UPDATE_WHEN_APP_BACKGROUND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PluginUpdateMethod[] f359317a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f359318b = null;

    public static EnumEntries<PluginUpdateMethod> getEntries() {
        return f359318b;
    }

    static {
        PluginUpdateMethod r100 = new PluginUpdateMethod("AUTO_FIT", 0);
        AUTO_FIT = r100;
        PluginUpdateMethod r101 = new PluginUpdateMethod("UPDATE_FIRST", 1);
        UPDATE_FIRST = r101;
        PluginUpdateMethod r102 = new PluginUpdateMethod("DO_NOT_UPDATE", 2);
        DO_NOT_UPDATE = r102;
        PluginUpdateMethod r103 = new PluginUpdateMethod("UPDATE_BACKGROUND", 3);
        UPDATE_BACKGROUND = r103;
        PluginUpdateMethod r104 = new PluginUpdateMethod("UPDATE_WHEN_APP_BACKGROUND", 4);
        UPDATE_WHEN_APP_BACKGROUND = r104;
        PluginUpdateMethod[] r105 = {r100, r101, r102, r103, r104};
        f359317a = r105;
        f359318b = EnumEntriesKt.enumEntries(r105);
    }

    public static PluginUpdateMethod[] values() {
        return (PluginUpdateMethod[]) f359317a.clone();
    }

    public static PluginUpdateMethod valueOf(String r100) {
        return (PluginUpdateMethod) a.a(PluginUpdateMethod.class, r100);
    }

    public PluginUpdateMethod(String r100, int r101) {
        super(r100, r101);
    }
}
