package com.obric.aiagent.assistant.idl.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u0002H\t¢\u0006\u0002\u0010\rJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u0010\u001a\u00020\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0017\u001a\u00020\u000bHÖ\u0001J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/OSkillManagerConfig;", "Landroid/os/Parcelable;", "values", "Landroid/os/Bundle;", "<init>", "(Landroid/os/Bundle;)V", "getValues", "()Landroid/os/Bundle;", "getValue", ExifInterface.GPS_DIRECTION_TRUE, "key", "", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OSkillManagerConfig implements Parcelable {
    public static final Parcelable.Creator<OSkillManagerConfig> CREATOR = null;
    public static final a Companion = null;
    public static final boolean DEFAULT_SKILL_EXTENSION_ENABLED = true;
    public static final String KEY_SKILL_EXTENSION_ENABLED = "skill_extension_enabled";
    private final Bundle values;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public static final class b implements Parcelable.Creator<OSkillManagerConfig> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final OSkillManagerConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new OSkillManagerConfig(r100.readBundle(OSkillManagerConfig.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final OSkillManagerConfig[] newArray(int r100) {
            return new OSkillManagerConfig[r100];
        }
    }

    static {
        Companion = new a();
        CREATOR = new b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OSkillManagerConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ OSkillManagerConfig copy$default(OSkillManagerConfig r100, Bundle r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.values;
    L6:
        return r100.copy(r101);
    }

    public final Bundle component1() {
        return this.values;
    }

    public final OSkillManagerConfig copy(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "values");
        return new OSkillManagerConfig(r100);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OSkillManagerConfig) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.values, ((OSkillManagerConfig) r100).values) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.values.hashCode();
    }

    public String toString() {
        return "OSkillManagerConfig(values=" + this.values + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeBundle(this.values);
    }

    public final Bundle getValues() {
        return this.values;
    }

    public OSkillManagerConfig(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "values");
        this.values = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T getValue(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Object r102 = this.values.get(r100);
        if (r102 != null) goto L5;
        return r101;
    L5:
        Object r103 = null;
        Boolean r104 = null;
        Integer r105 = null;
        Long r106 = null;
        Double r107 = null;
        if ((r101 instanceof Boolean) == false) goto L15;
        if ((r102 instanceof Boolean) == false) goto L10;
        r104 = (Boolean) r102;
    L10:
        if (r104 == null) goto L12;
        boolean r108 = r104.booleanValue();
    L50:
        return (T) Boolean.valueOf(r108);
    L12:
        r108 = ((Boolean) r101).booleanValue();
        goto L50
    L15:
        if ((r101 instanceof Integer) == false) goto L24;
        if ((r102 instanceof Integer) == false) goto L19;
        r105 = (Integer) r102;
    L19:
        if (r105 == null) goto L21;
        int r109 = r105.intValue();
    L51:
        return (T) Integer.valueOf(r109);
    L21:
        r109 = ((Number) r101).intValue();
        goto L51
    L24:
        if ((r101 instanceof Long) == false) goto L33;
        if ((r102 instanceof Long) == false) goto L28;
        r106 = (Long) r102;
    L28:
        if (r106 == null) goto L30;
        long r110 = r106.longValue();
    L52:
        return (T) Long.valueOf(r110);
    L30:
        r110 = ((Number) r101).longValue();
        goto L52
    L33:
        if ((r101 instanceof Double) == false) goto L42;
        if ((r102 instanceof Double) == false) goto L37;
        r107 = (Double) r102;
    L37:
        if (r107 == null) goto L39;
        double r111 = r107.doubleValue();
    L53:
        return (T) Double.valueOf(r111);
    L39:
        r111 = ((Number) r101).doubleValue();
        goto L53
    L42:
        if ((r101 instanceof String) == true) goto L44;
        return r101;
    L44:
        if ((r102 instanceof String) == false) goto L46;
        r103 = (String) r102;
    L46:
        if (r103 != null) goto L49;
        return (T) ((String) r101);
    L49:
        return (T) r103;
    }

    public /* synthetic */ OSkillManagerConfig(Bundle r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = new Bundle();
    L5:
        this(r100);
    }
}
