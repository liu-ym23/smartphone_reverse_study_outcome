package com.obric.assistant.settings;

import com.obric.assistant.ObricSettingsAuthenticationType;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH&J\b\u0010\u0013\u001a\u00020\u0014H'J\u0012\u0010\u0015\u001a\u00020\u00112\b\b\u0001\u0010\u0016\u001a\u00020\u0014H&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/settings/LockedUseAuthSettingItem;", "", "settingKey", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getSettingKey", "()Ljava/lang/String;", "CHAT_AND_ONLINE_QA", "SIMPLE_COMMAND", "LOCAL_APP_DATA", "CHAT_HISTORY", "GLOBAL_MEMORY", "AUTO_GUI", "isEnabled", "", "saveEnabled", "", "enabled", "getAuthType", "", "saveAuthType", "type", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract enum LockedUseAuthSettingItem extends Enum<LockedUseAuthSettingItem> {
    public static final LockedUseAuthSettingItem AUTO_GUI = null;
    public static final LockedUseAuthSettingItem CHAT_AND_ONLINE_QA = null;
    public static final LockedUseAuthSettingItem CHAT_HISTORY = null;
    public static final a Companion = null;

    @Deprecated(message = "锁定策略 LocalData/Memory 二合一后，GLOBAL_MEMORY 不再作为独立锁屏鉴权事实源，其取值跟随 LOCAL_APP_DATA；请勿新增对该枚举项的读写。")
    public static final LockedUseAuthSettingItem GLOBAL_MEMORY = null;
    public static final LockedUseAuthSettingItem LOCAL_APP_DATA = null;
    public static final LockedUseAuthSettingItem SIMPLE_COMMAND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LockedUseAuthSettingItem[] f391709a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f391710b = null;
    private final String settingKey;

    public static final class a {
        public a() {
        }
    }

    public LockedUseAuthSettingItem() {
        throw null;
    }

    public static EnumEntries<LockedUseAuthSettingItem> getEntries() {
        return f391710b;
    }

    @ObricSettingsAuthenticationType
    public abstract int getAuthType();

    public abstract boolean isEnabled();

    public abstract void saveAuthType(@ObricSettingsAuthenticationType int r100);

    public abstract void saveEnabled(boolean r100);

    static {
        final String r100 = "CHAT_AND_ONLINE_QA";
        final int r101 = 0;
        LockedUseAuthSettingItem r102 = new CHAT_AND_ONLINE_QA(r100, r101);
        CHAT_AND_ONLINE_QA = r102;
        final String r103 = "SIMPLE_COMMAND";
        final int r104 = 1;
        LockedUseAuthSettingItem r105 = new SIMPLE_COMMAND(r103, r104);
        SIMPLE_COMMAND = r105;
        final String r106 = "LOCAL_APP_DATA";
        final int r107 = 2;
        LockedUseAuthSettingItem r108 = new LOCAL_APP_DATA(r106, r107);
        LOCAL_APP_DATA = r108;
        final String r109 = "CHAT_HISTORY";
        final int r110 = 3;
        LockedUseAuthSettingItem r111 = new CHAT_HISTORY(r109, r110);
        CHAT_HISTORY = r111;
        final String r112 = "GLOBAL_MEMORY";
        final int r113 = 4;
        LockedUseAuthSettingItem r114 = new GLOBAL_MEMORY(r112, r113);
        GLOBAL_MEMORY = r114;
        final String r115 = "AUTO_GUI";
        final int r116 = 5;
        LockedUseAuthSettingItem r117 = new AUTO_GUI(r115, r116);
        AUTO_GUI = r117;
        LockedUseAuthSettingItem[] r118 = {r102, r105, r108, r111, r114, r117};
        f391709a = r118;
        f391710b = EnumEntriesKt.enumEntries(r118);
        Companion = new a();
    }

    public static LockedUseAuthSettingItem[] values() {
        return (LockedUseAuthSettingItem[]) f391709a.clone();
    }

    public final String getSettingKey() {
        return this.settingKey;
    }

    public static LockedUseAuthSettingItem valueOf(String r100) {
        return (LockedUseAuthSettingItem) r27.a.a(LockedUseAuthSettingItem.class, r100);
    }

    public LockedUseAuthSettingItem(String r100, int r101, String r102, DefaultConstructorMarker r103) {
        super(r100, r101);
        this.settingKey = r102;
    }
}
