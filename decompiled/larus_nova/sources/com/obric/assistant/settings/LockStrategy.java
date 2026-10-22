package com.obric.assistant.settings;

import com.baidu.platform.comapi.map.MapController;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/settings/LockStrategy;", "", "value", "", MapController.ITEM_LAYER_TAG, "Lcom/obric/assistant/settings/LockedUseAuthSettingItem;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lcom/obric/assistant/settings/LockedUseAuthSettingItem;)V", "getItem", "()Lcom/obric/assistant/settings/LockedUseAuthSettingItem;", "Chat", "SimpleIntent", "LocalData", "ChatHistory", "Memory", "AutoGui", "getName", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LockStrategy extends Enum<LockStrategy> {
    public static final LockStrategy AutoGui = null;
    public static final LockStrategy Chat = null;
    public static final LockStrategy ChatHistory = null;
    public static final a Companion = null;
    public static final LockStrategy LocalData = null;
    public static final LockStrategy Memory = null;
    public static final LockStrategy SimpleIntent = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LockStrategy[] f391707a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f391708b = null;
    private final LockedUseAuthSettingItem item;
    private final String value;

    public static EnumEntries<LockStrategy> getEntries() {
        return f391708b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.assistant.settings.LockStrategy$a] */
    static {
        LockStrategy r100 = new LockStrategy("Chat", 0, "Chat", LockedUseAuthSettingItem.CHAT_AND_ONLINE_QA);
        Chat = r100;
        LockStrategy r101 = new LockStrategy("SimpleIntent", 1, "SimpleIntent", LockedUseAuthSettingItem.SIMPLE_COMMAND);
        SimpleIntent = r101;
        LockStrategy r102 = new LockStrategy("LocalData", 2, "LocalData", LockedUseAuthSettingItem.LOCAL_APP_DATA);
        LocalData = r102;
        LockStrategy r103 = new LockStrategy("ChatHistory", 3, "ChatHistory", LockedUseAuthSettingItem.CHAT_HISTORY);
        ChatHistory = r103;
        LockStrategy r104 = new LockStrategy("Memory", 4, "Memory", LockedUseAuthSettingItem.GLOBAL_MEMORY);
        Memory = r104;
        LockStrategy r105 = new LockStrategy("AutoGui", 5, "AutoGui", LockedUseAuthSettingItem.AUTO_GUI);
        AutoGui = r105;
        LockStrategy[] r110 = {r100, r101, r102, r103, r104, r105};
        f391707a = r110;
        f391708b = EnumEntriesKt.enumEntries(r110);
        Companion = new a();
    }

    public static LockStrategy[] values() {
        return (LockStrategy[]) f391707a.clone();
    }

    public final LockedUseAuthSettingItem getItem() {
        return this.item;
    }

    public final String getName() {
        return this.value;
    }

    public static final /* synthetic */ String access$getValue$p(LockStrategy r100) {
        return r100.value;
    }

    public static LockStrategy valueOf(String r100) {
        return (LockStrategy) r27.a.a(LockStrategy.class, r100);
    }

    public LockStrategy(String r100, int r101, String r102, LockedUseAuthSettingItem r103) {
        super(r100, r101);
        this.value = r102;
        this.item = r103;
    }
}
