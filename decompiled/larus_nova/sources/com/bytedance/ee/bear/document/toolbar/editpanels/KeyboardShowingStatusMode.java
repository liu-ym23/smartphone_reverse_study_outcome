package com.bytedance.ee.bear.document.toolbar.editpanels;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/document/toolbar/editpanels/KeyboardShowingStatusMode;", "", "<init>", "(Ljava/lang/String;I)V", "ALWAYS_SHOW", "FOLLOW_KEYBOARD", "docs-edit-toolbar-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum KeyboardShowingStatusMode extends Enum<KeyboardShowingStatusMode> {
    public static final KeyboardShowingStatusMode ALWAYS_SHOW = null;
    public static final KeyboardShowingStatusMode FOLLOW_KEYBOARD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KeyboardShowingStatusMode[] f222318a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f222319b = null;

    public static EnumEntries<KeyboardShowingStatusMode> getEntries() {
        return f222319b;
    }

    static {
        KeyboardShowingStatusMode r100 = new KeyboardShowingStatusMode("ALWAYS_SHOW", 0);
        ALWAYS_SHOW = r100;
        KeyboardShowingStatusMode r101 = new KeyboardShowingStatusMode("FOLLOW_KEYBOARD", 1);
        FOLLOW_KEYBOARD = r101;
        KeyboardShowingStatusMode[] r102 = {r100, r101};
        f222318a = r102;
        f222319b = EnumEntriesKt.enumEntries(r102);
    }

    public static KeyboardShowingStatusMode[] values() {
        return (KeyboardShowingStatusMode[]) f222318a.clone();
    }

    public static KeyboardShowingStatusMode valueOf(String r100) {
        return (KeyboardShowingStatusMode) a.a(KeyboardShowingStatusMode.class, r100);
    }

    public KeyboardShowingStatusMode(String r100, int r101) {
        super(r100, r101);
    }
}
