package com.ss.android.lark.component.appcontext.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/component/appcontext/model/DynamicPlugins;", "", "<init>", "(Ljava/lang/String;I)V", "FCM", "UPDATE", "BYTED_CERT", "LYNX_DEVTOOL", "HW", "appcontext_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DynamicPlugins extends Enum<DynamicPlugins> {
    public static final DynamicPlugins BYTED_CERT = null;
    public static final DynamicPlugins FCM = null;
    public static final DynamicPlugins HW = null;
    public static final DynamicPlugins LYNX_DEVTOOL = null;
    public static final DynamicPlugins UPDATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DynamicPlugins[] f417278a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f417279b = null;

    public static EnumEntries<DynamicPlugins> getEntries() {
        return f417279b;
    }

    static {
        DynamicPlugins r100 = new DynamicPlugins("FCM", 0);
        FCM = r100;
        DynamicPlugins r101 = new DynamicPlugins("UPDATE", 1);
        UPDATE = r101;
        DynamicPlugins r102 = new DynamicPlugins("BYTED_CERT", 2);
        BYTED_CERT = r102;
        DynamicPlugins r103 = new DynamicPlugins("LYNX_DEVTOOL", 3);
        LYNX_DEVTOOL = r103;
        DynamicPlugins r104 = new DynamicPlugins("HW", 4);
        HW = r104;
        DynamicPlugins[] r105 = {r100, r101, r102, r103, r104};
        f417278a = r105;
        f417279b = EnumEntriesKt.enumEntries(r105);
    }

    public static DynamicPlugins[] values() {
        return (DynamicPlugins[]) f417278a.clone();
    }

    public static DynamicPlugins valueOf(String r100) {
        return (DynamicPlugins) a.a(DynamicPlugins.class, r100);
    }

    public DynamicPlugins(String r100, int r101) {
        super(r100, r101);
    }
}
