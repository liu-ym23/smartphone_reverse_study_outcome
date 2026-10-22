package com.ss.android.lark.passportc.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/passportc/api/Scene;", "", "<init>", "(Ljava/lang/String;I)V", "FIRST_ONLINE", "SWITCH_ONLINE", "FAST_ONLINE", "SWITCH_BACKGROUND", "SWITCH_FOREGROUND", "CREATE_USER_COMPONENT", "passport-container-manager_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Scene extends Enum<Scene> {
    public static final Scene CREATE_USER_COMPONENT = null;
    public static final Scene FAST_ONLINE = null;
    public static final Scene FIRST_ONLINE = null;
    public static final Scene SWITCH_BACKGROUND = null;
    public static final Scene SWITCH_FOREGROUND = null;
    public static final Scene SWITCH_ONLINE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Scene[] f438106a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f438107b = null;

    public static EnumEntries<Scene> getEntries() {
        return f438107b;
    }

    static {
        Scene r100 = new Scene("FIRST_ONLINE", 0);
        FIRST_ONLINE = r100;
        Scene r101 = new Scene("SWITCH_ONLINE", 1);
        SWITCH_ONLINE = r101;
        Scene r102 = new Scene("FAST_ONLINE", 2);
        FAST_ONLINE = r102;
        Scene r103 = new Scene("SWITCH_BACKGROUND", 3);
        SWITCH_BACKGROUND = r103;
        Scene r104 = new Scene("SWITCH_FOREGROUND", 4);
        SWITCH_FOREGROUND = r104;
        Scene r105 = new Scene("CREATE_USER_COMPONENT", 5);
        CREATE_USER_COMPONENT = r105;
        Scene[] r110 = {r100, r101, r102, r103, r104, r105};
        f438106a = r110;
        f438107b = EnumEntriesKt.enumEntries(r110);
    }

    public static Scene[] values() {
        return (Scene[]) f438106a.clone();
    }

    public static Scene valueOf(String r100) {
        return (Scene) r27.a.a(Scene.class, r100);
    }

    public Scene(String r100, int r101) {
        super(r100, r101);
    }
}
