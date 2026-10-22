package com.larus.livetutor.impl.home.viewmodel;

import com.obric.trace.ObricActionBarTrackType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/livetutor/impl/home/viewmodel/InputScene;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Keyboard", "Speak", "Album", "Shoot", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InputScene extends Enum<InputScene> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ InputScene[] $VALUES = null;
    public static final InputScene Album = null;
    public static final InputScene Keyboard = null;
    public static final InputScene Shoot = null;
    public static final InputScene Speak = null;
    private final String value;

    private static final /* synthetic */ InputScene[] $values() {
        return new InputScene[]{Keyboard, Speak, Album, Shoot};
    }

    public static EnumEntries<InputScene> getEntries() {
        return $ENTRIES;
    }

    static {
        Keyboard = new InputScene("Keyboard", 0, ObricActionBarTrackType.KEY_BOARD);
        Speak = new InputScene("Speak", 1, ObricActionBarTrackType.SPEAK);
        Album = new InputScene("Album", 2, "album");
        Shoot = new InputScene("Shoot", 3, "shoot");
        InputScene[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static InputScene[] values() {
        return (InputScene[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static InputScene valueOf(String r100) {
        return (InputScene) r27.a.a(InputScene.class, r100);
    }

    private InputScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
