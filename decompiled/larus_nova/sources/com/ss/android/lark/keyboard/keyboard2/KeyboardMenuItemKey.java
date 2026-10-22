package com.ss.android.lark.keyboard.keyboard2;

import com.bytedance.speech.speechengine.SpeechEngineDefines;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/keyboard/keyboard2/KeyboardMenuItemKey;", "", "<init>", "(Ljava/lang/String;I)V", "AaStyle", "At", "Emoji", "Plus", "Photo", "Voice", "UploadLog", "BurnLife", "TodoAttachment", "HashTag", "RestrictedBurnLife", SpeechEngineDefines.RECORDER_TYPE_FILE, "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum KeyboardMenuItemKey extends Enum<KeyboardMenuItemKey> {
    public static final KeyboardMenuItemKey AaStyle = null;
    public static final KeyboardMenuItemKey At = null;
    public static final KeyboardMenuItemKey BurnLife = null;
    public static final KeyboardMenuItemKey Emoji = null;
    public static final KeyboardMenuItemKey File = null;
    public static final KeyboardMenuItemKey HashTag = null;
    public static final KeyboardMenuItemKey Photo = null;
    public static final KeyboardMenuItemKey Plus = null;
    public static final KeyboardMenuItemKey RestrictedBurnLife = null;
    public static final KeyboardMenuItemKey TodoAttachment = null;
    public static final KeyboardMenuItemKey UploadLog = null;
    public static final KeyboardMenuItemKey Voice = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KeyboardMenuItemKey[] f429490a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f429491b = null;

    public static EnumEntries<KeyboardMenuItemKey> getEntries() {
        return f429491b;
    }

    static {
        KeyboardMenuItemKey r100 = new KeyboardMenuItemKey("AaStyle", 0);
        AaStyle = r100;
        KeyboardMenuItemKey r101 = new KeyboardMenuItemKey("At", 1);
        At = r101;
        KeyboardMenuItemKey r102 = new KeyboardMenuItemKey("Emoji", 2);
        Emoji = r102;
        KeyboardMenuItemKey r103 = new KeyboardMenuItemKey("Plus", 3);
        Plus = r103;
        KeyboardMenuItemKey r104 = new KeyboardMenuItemKey("Photo", 4);
        Photo = r104;
        KeyboardMenuItemKey r105 = new KeyboardMenuItemKey("Voice", 5);
        Voice = r105;
        KeyboardMenuItemKey r110 = new KeyboardMenuItemKey("UploadLog", 6);
        UploadLog = r110;
        KeyboardMenuItemKey r111 = new KeyboardMenuItemKey("BurnLife", 7);
        BurnLife = r111;
        KeyboardMenuItemKey r112 = new KeyboardMenuItemKey("TodoAttachment", 8);
        TodoAttachment = r112;
        KeyboardMenuItemKey r113 = new KeyboardMenuItemKey("HashTag", 9);
        HashTag = r113;
        KeyboardMenuItemKey r114 = new KeyboardMenuItemKey("RestrictedBurnLife", 10);
        RestrictedBurnLife = r114;
        KeyboardMenuItemKey r115 = new KeyboardMenuItemKey(SpeechEngineDefines.RECORDER_TYPE_FILE, 11);
        File = r115;
        KeyboardMenuItemKey[] r106 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
        f429490a = r106;
        f429491b = EnumEntriesKt.enumEntries(r106);
    }

    public static KeyboardMenuItemKey[] values() {
        return (KeyboardMenuItemKey[]) f429490a.clone();
    }

    public static KeyboardMenuItemKey valueOf(String r100) {
        return (KeyboardMenuItemKey) r27.a.a(KeyboardMenuItemKey.class, r100);
    }

    public KeyboardMenuItemKey(String r100, int r101) {
        super(r100, r101);
    }
}
