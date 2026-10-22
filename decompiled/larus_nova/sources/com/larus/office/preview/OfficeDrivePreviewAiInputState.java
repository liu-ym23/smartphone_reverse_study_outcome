package com.larus.office.preview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/office/preview/OfficeDrivePreviewAiInputState;", "", "interactionActive", "", "<init>", "(Ljava/lang/String;IZ)V", "getInteractionActive", "()Z", "Hidden", "Collapsed", "Expanded", "Voice", "Keyboard", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeDrivePreviewAiInputState extends Enum<OfficeDrivePreviewAiInputState> {
    public static final OfficeDrivePreviewAiInputState Collapsed = null;
    public static final OfficeDrivePreviewAiInputState Expanded = null;
    public static final OfficeDrivePreviewAiInputState Hidden = null;
    public static final OfficeDrivePreviewAiInputState Keyboard = null;
    public static final OfficeDrivePreviewAiInputState Voice = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeDrivePreviewAiInputState[] f363607a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f363608b = null;
    private final boolean interactionActive;

    public static EnumEntries<OfficeDrivePreviewAiInputState> getEntries() {
        return f363608b;
    }

    static {
        OfficeDrivePreviewAiInputState r100 = new OfficeDrivePreviewAiInputState("Hidden", 0, false);
        Hidden = r100;
        OfficeDrivePreviewAiInputState r101 = new OfficeDrivePreviewAiInputState("Collapsed", 1, false);
        Collapsed = r101;
        OfficeDrivePreviewAiInputState r102 = new OfficeDrivePreviewAiInputState("Expanded", 2, true);
        Expanded = r102;
        OfficeDrivePreviewAiInputState r103 = new OfficeDrivePreviewAiInputState("Voice", 3, true);
        Voice = r103;
        OfficeDrivePreviewAiInputState r104 = new OfficeDrivePreviewAiInputState("Keyboard", 4, true);
        Keyboard = r104;
        OfficeDrivePreviewAiInputState[] r105 = {r100, r101, r102, r103, r104};
        f363607a = r105;
        f363608b = EnumEntriesKt.enumEntries(r105);
    }

    public static OfficeDrivePreviewAiInputState[] values() {
        return (OfficeDrivePreviewAiInputState[]) f363607a.clone();
    }

    public final boolean getInteractionActive() {
        return this.interactionActive;
    }

    public static OfficeDrivePreviewAiInputState valueOf(String r100) {
        return (OfficeDrivePreviewAiInputState) a.a(OfficeDrivePreviewAiInputState.class, r100);
    }

    public OfficeDrivePreviewAiInputState(String r100, int r101, boolean r102) {
        super(r100, r101);
        this.interactionActive = r102;
    }
}
