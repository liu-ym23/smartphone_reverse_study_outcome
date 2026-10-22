package com.larus.camera.impl.edulibs.camera.internal.idl;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/camera/impl/edulibs/camera/internal/idl/ProcessType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", ExifInterface.TAG_ORIENTATION, "Detection", "RemoveHandwriting", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ProcessType extends Enum<ProcessType> {
    public static final a Companion = null;

    @SerializedName("2")
    public static final ProcessType Detection = null;

    @SerializedName("1")
    public static final ProcessType Orientation = null;

    @SerializedName("3")
    public static final ProcessType RemoveHandwriting = null;

    @SerializedName("0")
    public static final ProcessType Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProcessType[] f321621a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f321622b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<ProcessType> getEntries() {
        return f321622b;
    }

    static {
        ProcessType r100 = new ProcessType("Unknown", 0, 0);
        Unknown = r100;
        ProcessType r101 = new ProcessType(ExifInterface.TAG_ORIENTATION, 1, 1);
        Orientation = r101;
        ProcessType r102 = new ProcessType("Detection", 2, 2);
        Detection = r102;
        ProcessType r103 = new ProcessType("RemoveHandwriting", 3, 3);
        RemoveHandwriting = r103;
        ProcessType[] r104 = {r100, r101, r102, r103};
        f321621a = r104;
        f321622b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static ProcessType[] values() {
        return (ProcessType[]) f321621a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final ProcessType findByValue(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L15;
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L17;
        return null;
    L17:
        return RemoveHandwriting;
    L18:
        return Detection;
    L19:
        return Orientation;
    L15:
        return Unknown;
    }

    public static ProcessType valueOf(String r100) {
        return (ProcessType) r27.a.a(ProcessType.class, r100);
    }

    public ProcessType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
