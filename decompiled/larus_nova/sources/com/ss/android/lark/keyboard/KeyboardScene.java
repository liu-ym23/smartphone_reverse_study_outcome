package com.ss.android.lark.keyboard;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/keyboard/KeyboardScene;", "", "<init>", "(Ljava/lang/String;I)V", "ChatMain", "ThreadMain", "UNKNOWN", "Moments", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum KeyboardScene extends Enum<KeyboardScene> {
    public static final KeyboardScene ChatMain = null;
    public static final KeyboardScene Moments = null;
    public static final KeyboardScene ThreadMain = null;
    public static final KeyboardScene UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KeyboardScene[] f428210a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f428211b = null;

    public static EnumEntries<KeyboardScene> getEntries() {
        return f428211b;
    }

    static {
        KeyboardScene r100 = new KeyboardScene("ChatMain", 0);
        ChatMain = r100;
        KeyboardScene r101 = new KeyboardScene("ThreadMain", 1);
        ThreadMain = r101;
        KeyboardScene r102 = new KeyboardScene("UNKNOWN", 2);
        UNKNOWN = r102;
        KeyboardScene r103 = new KeyboardScene("Moments", 3);
        Moments = r103;
        KeyboardScene[] r104 = {r100, r101, r102, r103};
        f428210a = r104;
        f428211b = EnumEntriesKt.enumEntries(r104);
    }

    public static KeyboardScene[] values() {
        return (KeyboardScene[]) f428210a.clone();
    }

    public static KeyboardScene valueOf(String r100) {
        return (KeyboardScene) r27.a.a(KeyboardScene.class, r100);
    }

    public KeyboardScene(String r100, int r101) {
        super(r100, r101);
    }
}
