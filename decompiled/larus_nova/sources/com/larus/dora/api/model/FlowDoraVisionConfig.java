package com.larus.dora.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.ttvideoengine.model.SubInfo;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 42\u00020\u0001:\u00014BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u001f\u001a\u00020 H\u0016J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003JO\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0006\u0010)\u001a\u00020\u0003J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020\u0003HÖ\u0001J\u0016\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0010¨\u00065"}, d2 = {"Lcom/larus/dora/api/model/FlowDoraVisionConfig;", "Landroid/os/Parcelable;", "mode", "", "width", "height", GearStrategyConsts.EV_QUALITY, "fps", "", "type", SubInfo.KEY_FORMAT, "<init>", "(IIIIFII)V", "getMode", "()I", "setMode", "(I)V", "getWidth", "setWidth", "getHeight", "setHeight", "getQuality", "setQuality", "getFps", "()F", "setFps", "(F)V", "getType", "setType", "getFormat", "setFormat", "toString", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "", "other", "", "hashCode", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowDoraVisionConfig implements Parcelable {
    public static final Parcelable.Creator<FlowDoraVisionConfig> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f331758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f331759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f331760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f331761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f331762e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f331763f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f331764g;

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<FlowDoraVisionConfig> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final FlowDoraVisionConfig createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            return new FlowDoraVisionConfig(r110.readInt(), r110.readInt(), r110.readInt(), r110.readInt(), r110.readFloat(), r110.readInt(), r110.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final FlowDoraVisionConfig[] newArray(int r100) {
            return new FlowDoraVisionConfig[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FlowDoraVisionConfig) == true) goto L8;
        return false;
    L8:
        FlowDoraVisionConfig r101 = (FlowDoraVisionConfig) r100;
        if (this.f331758a == r101.f331758a) goto L12;
        return false;
    L12:
        if (this.f331759b == r101.f331759b) goto L15;
        return false;
    L15:
        if (this.f331760c == r101.f331760c) goto L18;
        return false;
    L18:
        if (this.f331761d == r101.f331761d) goto L21;
        return false;
    L21:
        if (Float.compare(this.f331762e, r101.f331762e) == 0) goto L24;
        return false;
    L24:
        if (this.f331763f == r101.f331763f) goto L27;
        return false;
    L27:
        if (this.f331764g == r101.f331764g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        return (((((((((((this.f331758a * 31) + this.f331759b) * 31) + this.f331760c) * 31) + this.f331761d) * 31) + Float.floatToIntBits(this.f331762e)) * 31) + this.f331763f) * 31) + this.f331764g;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.f331758a);
        r100.writeInt(this.f331759b);
        r100.writeInt(this.f331760c);
        r100.writeInt(this.f331761d);
        r100.writeFloat(this.f331762e);
        r100.writeInt(this.f331763f);
        r100.writeInt(this.f331764g);
    }

    public final String toString() {
        return "VisionQualitySetting(mode=" + this.f331758a + ", width=" + this.f331759b + ", height=" + this.f331760c + ", quality=" + this.f331761d + ", fps=" + this.f331762e + ", type=" + this.f331763f + ", format=" + this.f331764g + ')';
    }

    public final int getType() {
        return this.f331763f;
    }

    public FlowDoraVisionConfig(int r100, int r101, int r102, int r103, float r104, int r105, int r106) {
        this.f331758a = r100;
        this.f331759b = r101;
        this.f331760c = r102;
        this.f331761d = r103;
        this.f331762e = r104;
        this.f331763f = r105;
        this.f331764g = r106;
    }
}
