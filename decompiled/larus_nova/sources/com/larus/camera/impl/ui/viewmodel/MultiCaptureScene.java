package com.larus.camera.impl.ui.viewmodel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/camera/impl/ui/viewmodel/MultiCaptureScene;", "", "scene", "", "<init>", "(Ljava/lang/String;II)V", "getScene", "()I", "DEFAULT", "MAIN_BOT", "OTHER_BOT", "ALL_BOT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MultiCaptureScene extends Enum<MultiCaptureScene> {
    public static final MultiCaptureScene ALL_BOT = null;
    public static final MultiCaptureScene DEFAULT = null;
    public static final MultiCaptureScene MAIN_BOT = null;
    public static final MultiCaptureScene OTHER_BOT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MultiCaptureScene[] f322631a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f322632b = null;
    private final int scene;

    public static EnumEntries<MultiCaptureScene> getEntries() {
        return f322632b;
    }

    static {
        MultiCaptureScene r100 = new MultiCaptureScene("DEFAULT", 0, 0);
        DEFAULT = r100;
        MultiCaptureScene r101 = new MultiCaptureScene("MAIN_BOT", 1, 1);
        MAIN_BOT = r101;
        MultiCaptureScene r102 = new MultiCaptureScene("OTHER_BOT", 2, 2);
        OTHER_BOT = r102;
        MultiCaptureScene r103 = new MultiCaptureScene("ALL_BOT", 3, 3);
        ALL_BOT = r103;
        MultiCaptureScene[] r104 = {r100, r101, r102, r103};
        f322631a = r104;
        f322632b = EnumEntriesKt.enumEntries(r104);
    }

    public static MultiCaptureScene[] values() {
        return (MultiCaptureScene[]) f322631a.clone();
    }

    public final int getScene() {
        return this.scene;
    }

    public static MultiCaptureScene valueOf(String r100) {
        return (MultiCaptureScene) r27.a.a(MultiCaptureScene.class, r100);
    }

    public MultiCaptureScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.scene = r102;
    }
}
