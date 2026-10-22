package com.larus.bmhome.chat.standarduikit.browsercontrol.view;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/browsercontrol/view/ButtonStatus;", "", "<init>", "(Ljava/lang/String;I)V", "DISABLED", "ENABLED", "HIDE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ButtonStatus extends Enum<ButtonStatus> {
    public static final ButtonStatus DISABLED = null;
    public static final ButtonStatus ENABLED = null;
    public static final ButtonStatus HIDE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ButtonStatus[] f308936a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f308937b = null;

    public static EnumEntries<ButtonStatus> getEntries() {
        return f308937b;
    }

    static {
        ButtonStatus r100 = new ButtonStatus("DISABLED", 0);
        DISABLED = r100;
        ButtonStatus r101 = new ButtonStatus("ENABLED", 1);
        ENABLED = r101;
        ButtonStatus r102 = new ButtonStatus("HIDE", 2);
        HIDE = r102;
        ButtonStatus[] r103 = {r100, r101, r102};
        f308936a = r103;
        f308937b = EnumEntriesKt.enumEntries(r103);
    }

    public static ButtonStatus[] values() {
        return (ButtonStatus[]) f308936a.clone();
    }

    public static ButtonStatus valueOf(String r100) {
        return (ButtonStatus) a.a(ButtonStatus.class, r100);
    }

    public ButtonStatus(String r100, int r101) {
        super(r100, r101);
    }
}
