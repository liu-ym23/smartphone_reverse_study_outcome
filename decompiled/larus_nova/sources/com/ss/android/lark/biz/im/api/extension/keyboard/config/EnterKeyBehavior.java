package com.ss.android.lark.biz.im.api.extension.keyboard.config;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/keyboard/config/EnterKeyBehavior;", "", "<init>", "(Ljava/lang/String;I)V", "SEND", "NEWLINE", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EnterKeyBehavior extends Enum<EnterKeyBehavior> {
    public static final EnterKeyBehavior NEWLINE = null;
    public static final EnterKeyBehavior SEND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EnterKeyBehavior[] f410141a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410142b = null;

    public static EnumEntries<EnterKeyBehavior> getEntries() {
        return f410142b;
    }

    static {
        EnterKeyBehavior r100 = new EnterKeyBehavior("SEND", 0);
        SEND = r100;
        EnterKeyBehavior r101 = new EnterKeyBehavior("NEWLINE", 1);
        NEWLINE = r101;
        EnterKeyBehavior[] r102 = {r100, r101};
        f410141a = r102;
        f410142b = EnumEntriesKt.enumEntries(r102);
    }

    public static EnterKeyBehavior[] values() {
        return (EnterKeyBehavior[]) f410141a.clone();
    }

    public static EnterKeyBehavior valueOf(String r100) {
        return (EnterKeyBehavior) a.a(EnterKeyBehavior.class, r100);
    }

    public EnterKeyBehavior(String r100, int r101) {
        super(r100, r101);
    }
}
