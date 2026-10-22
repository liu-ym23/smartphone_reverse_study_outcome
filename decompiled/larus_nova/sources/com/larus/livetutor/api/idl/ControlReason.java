package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0087\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/larus/livetutor/api/idl/ControlReason;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", "PauseContinueButton", "Subtitle", "DownloadBoard", "ImageSearch", "Keyboard", "Photo", "SystemInterrupt", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ControlReason extends Enum<ControlReason> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ControlReason[] $VALUES = null;
    public static final a Companion = null;

    @SerializedName("3")
    public static final ControlReason DownloadBoard = null;

    @SerializedName("4")
    public static final ControlReason ImageSearch = null;

    @SerializedName("5")
    public static final ControlReason Keyboard = null;

    @SerializedName("1")
    public static final ControlReason PauseContinueButton = null;

    @SerializedName("6")
    public static final ControlReason Photo = null;

    @SerializedName("2")
    public static final ControlReason Subtitle = null;

    @SerializedName("7")
    public static final ControlReason SystemInterrupt = null;

    @SerializedName("0")
    public static final ControlReason Unknown = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    private static final /* synthetic */ ControlReason[] $values() {
        return new ControlReason[]{Unknown, PauseContinueButton, Subtitle, DownloadBoard, ImageSearch, Keyboard, Photo, SystemInterrupt};
    }

    public static EnumEntries<ControlReason> getEntries() {
        return $ENTRIES;
    }

    static {
        Unknown = new ControlReason("Unknown", 0, 0);
        PauseContinueButton = new ControlReason("PauseContinueButton", 1, 1);
        Subtitle = new ControlReason("Subtitle", 2, 2);
        DownloadBoard = new ControlReason("DownloadBoard", 3, 3);
        ImageSearch = new ControlReason("ImageSearch", 4, 4);
        Keyboard = new ControlReason("Keyboard", 5, 5);
        Photo = new ControlReason("Photo", 6, 6);
        SystemInterrupt = new ControlReason("SystemInterrupt", 7, 7);
        ControlReason[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
    }

    public static ControlReason[] values() {
        return (ControlReason[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final ControlReason findByValue(int r100) {
        Companion.getClass();
        switch(r100) {
            case 0: goto L13;
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            default: goto L4;
        };
    L4:
        return null;
    L15:
        return SystemInterrupt;
    L16:
        return Photo;
    L17:
        return Keyboard;
    L18:
        return ImageSearch;
    L19:
        return DownloadBoard;
    L20:
        return Subtitle;
    L21:
        return PauseContinueButton;
    L13:
        return Unknown;
    }

    public static ControlReason valueOf(String r100) {
        return (ControlReason) r27.a.a(ControlReason.class, r100);
    }

    private ControlReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
