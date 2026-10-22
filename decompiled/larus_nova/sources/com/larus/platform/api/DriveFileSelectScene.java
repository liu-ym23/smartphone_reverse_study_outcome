package com.larus.platform.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/platform/api/DriveFileSelectScene;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UNKNOWN", "ATTACHMENT_PANEL", "CHAT_SELECTOR", "INPUT_UPLOAD", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DriveFileSelectScene extends Enum<DriveFileSelectScene> {
    public static final DriveFileSelectScene ATTACHMENT_PANEL = null;
    public static final DriveFileSelectScene CHAT_SELECTOR = null;
    public static final a Companion = null;
    public static final DriveFileSelectScene INPUT_UPLOAD = null;
    public static final DriveFileSelectScene UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DriveFileSelectScene[] f364766a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f364767b = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<DriveFileSelectScene> getEntries() {
        return f364767b;
    }

    static {
        DriveFileSelectScene r100 = new DriveFileSelectScene("UNKNOWN", 0, "unknown");
        UNKNOWN = r100;
        DriveFileSelectScene r101 = new DriveFileSelectScene("ATTACHMENT_PANEL", 1, "attachment_panel");
        ATTACHMENT_PANEL = r101;
        DriveFileSelectScene r102 = new DriveFileSelectScene("CHAT_SELECTOR", 2, "chat_selector");
        CHAT_SELECTOR = r102;
        DriveFileSelectScene r103 = new DriveFileSelectScene("INPUT_UPLOAD", 3, "input_upload");
        INPUT_UPLOAD = r103;
        DriveFileSelectScene[] r104 = {r100, r101, r102, r103};
        f364766a = r104;
        f364767b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static DriveFileSelectScene[] values() {
        return (DriveFileSelectScene[]) f364766a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static DriveFileSelectScene valueOf(String r100) {
        return (DriveFileSelectScene) r27.a.a(DriveFileSelectScene.class, r100);
    }

    public DriveFileSelectScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
