package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\f\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/adapter/ItemType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "Header", "SendTypeAction", "AsrLanguage", "IconWithTitle", "Divider", "SwitchAction", "value", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ItemType extends Enum<ItemType> {
    public static final ItemType AsrLanguage = null;
    public static final ItemType Divider = null;
    public static final ItemType Header = null;
    public static final ItemType IconWithTitle = null;
    public static final ItemType SendTypeAction = null;
    public static final ItemType SwitchAction = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ItemType[] f430176a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f430177b = null;
    private final int type;

    public static EnumEntries<ItemType> getEntries() {
        return f430177b;
    }

    static {
        ItemType r100 = new ItemType("Header", 0, 0);
        Header = r100;
        ItemType r101 = new ItemType("SendTypeAction", 1, 1);
        SendTypeAction = r101;
        ItemType r102 = new ItemType("AsrLanguage", 2, 2);
        AsrLanguage = r102;
        ItemType r103 = new ItemType("IconWithTitle", 3, 3);
        IconWithTitle = r103;
        ItemType r104 = new ItemType("Divider", 4, 4);
        Divider = r104;
        ItemType r105 = new ItemType("SwitchAction", 5, 5);
        SwitchAction = r105;
        ItemType[] r110 = {r100, r101, r102, r103, r104, r105};
        f430176a = r110;
        f430177b = EnumEntriesKt.enumEntries(r110);
    }

    public static ItemType[] values() {
        return (ItemType[]) f430176a.clone();
    }

    public final int value() {
        return this.type;
    }

    public static ItemType valueOf(String r100) {
        return (ItemType) a.a(ItemType.class, r100);
    }

    public ItemType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
