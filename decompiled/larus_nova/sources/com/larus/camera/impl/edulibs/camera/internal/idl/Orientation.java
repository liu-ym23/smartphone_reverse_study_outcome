package com.larus.camera.impl.edulibs.camera.internal.idl;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/camera/impl/edulibs/camera/internal/idl/Orientation;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Angle_0", "Angle_90", "Angle_180", "Angle_270", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Orientation extends Enum<Orientation> {

    @SerializedName("0")
    public static final Orientation Angle_0 = null;

    @SerializedName("2")
    public static final Orientation Angle_180 = null;

    @SerializedName("3")
    public static final Orientation Angle_270 = null;

    @SerializedName("1")
    public static final Orientation Angle_90 = null;
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Orientation[] f321619a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f321620b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<Orientation> getEntries() {
        return f321620b;
    }

    static {
        Orientation r100 = new Orientation("Angle_0", 0, 0);
        Angle_0 = r100;
        Orientation r101 = new Orientation("Angle_90", 1, 1);
        Angle_90 = r101;
        Orientation r102 = new Orientation("Angle_180", 2, 2);
        Angle_180 = r102;
        Orientation r103 = new Orientation("Angle_270", 3, 3);
        Angle_270 = r103;
        Orientation[] r104 = {r100, r101, r102, r103};
        f321619a = r104;
        f321620b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static Orientation[] values() {
        return (Orientation[]) f321619a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final Orientation findByValue(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L15;
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L17;
        return null;
    L17:
        return Angle_270;
    L18:
        return Angle_180;
    L19:
        return Angle_90;
    L15:
        return Angle_0;
    }

    public static Orientation valueOf(String r100) {
        return (Orientation) r27.a.a(Orientation.class, r100);
    }

    public Orientation(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
