package com.larus.office.plugins.slides.orientation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/office/plugins/slides/orientation/OrientationMode;", "", "mode", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getMode", "()Ljava/lang/String;", "LANDSCAPE", "PORTRAIT", "AUTO", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OrientationMode extends Enum<OrientationMode> {
    public static final OrientationMode AUTO = null;
    public static final OrientationMode LANDSCAPE = null;
    public static final OrientationMode PORTRAIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OrientationMode[] f363445a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f363446b = null;
    private final String mode;

    public static EnumEntries<OrientationMode> getEntries() {
        return f363446b;
    }

    static {
        OrientationMode r100 = new OrientationMode("LANDSCAPE", 0, "landscape");
        LANDSCAPE = r100;
        OrientationMode r101 = new OrientationMode("PORTRAIT", 1, "portrait");
        PORTRAIT = r101;
        OrientationMode r102 = new OrientationMode("AUTO", 2, "auto");
        AUTO = r102;
        OrientationMode[] r103 = {r100, r101, r102};
        f363445a = r103;
        f363446b = EnumEntriesKt.enumEntries(r103);
    }

    public static OrientationMode[] values() {
        return (OrientationMode[]) f363445a.clone();
    }

    public final String getMode() {
        return this.mode;
    }

    public static OrientationMode valueOf(String r100) {
        return (OrientationMode) r27.a.a(OrientationMode.class, r100);
    }

    public OrientationMode(String r100, int r101, String r102) {
        super(r100, r101);
        this.mode = r102;
    }
}
