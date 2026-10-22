package com.bytedance.ee.bear.document.toolbar.editpanels;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/document/toolbar/editpanels/KeyboardShowingStatusMode;", "", "<init>", "(Ljava/lang/String;I)V", "ALWAYS_SHOW", "FOLLOW_KEYBOARD", "docs-edit-toolbar-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum KeyboardShowingStatusMode extends Enum<KeyboardShowingStatusMode> {
    public static final KeyboardShowingStatusMode ALWAYS_SHOW = null;
    public static final KeyboardShowingStatusMode FOLLOW_KEYBOARD = null;
    public static final /* synthetic */ KeyboardShowingStatusMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<KeyboardShowingStatusMode> getEntries() {
        return b;
    }

    static {
        KeyboardShowingStatusMode r0 = new KeyboardShowingStatusMode("ALWAYS_SHOW", 0);
        ALWAYS_SHOW = r0;
        KeyboardShowingStatusMode r1 = new KeyboardShowingStatusMode("FOLLOW_KEYBOARD", 1);
        FOLLOW_KEYBOARD = r1;
        KeyboardShowingStatusMode[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static KeyboardShowingStatusMode[] values() {
        return (KeyboardShowingStatusMode[]) a.clone();
    }

    public static KeyboardShowingStatusMode valueOf(String r1) {
        return (KeyboardShowingStatusMode) a.a(KeyboardShowingStatusMode.class, r1);
    }

    public KeyboardShowingStatusMode(String r1, int r2) {
        super(r1, r2);
    }
}
