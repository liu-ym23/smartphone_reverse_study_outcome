package com.ss.android.lark.time.format.entity;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/time/format/entity/DataRepresentation;", "", "<init>", "(Ljava/lang/String;I)V", ExifInterface.TAG_RW2_ISO, "ASIAN", "time-format_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DataRepresentation extends Enum<DataRepresentation> {
    public static final DataRepresentation ASIAN = null;
    public static final DataRepresentation ISO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DataRepresentation[] f441326a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f441327b = null;

    public static EnumEntries<DataRepresentation> getEntries() {
        return f441327b;
    }

    static {
        DataRepresentation r100 = new DataRepresentation(ExifInterface.TAG_RW2_ISO, 0);
        ISO = r100;
        DataRepresentation r101 = new DataRepresentation("ASIAN", 1);
        ASIAN = r101;
        DataRepresentation[] r102 = {r100, r101};
        f441326a = r102;
        f441327b = EnumEntriesKt.enumEntries(r102);
    }

    public static DataRepresentation[] values() {
        return (DataRepresentation[]) f441326a.clone();
    }

    public static DataRepresentation valueOf(String r100) {
        return (DataRepresentation) a.a(DataRepresentation.class, r100);
    }

    public DataRepresentation(String r100, int r101) {
        super(r100, r101);
    }
}
