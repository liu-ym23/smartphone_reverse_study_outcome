package com.bytedance.pitaya.api.bean;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001$B=\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003JK\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019R\u0017\u0010\f\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u001e\u0010\u0019R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0017\u001a\u0004\b \u0010\u0019¨\u0006%"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYModelInfo;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "", "component1", "component2", "", "component3", "component4", "component5", "component6", "name", "version", "engineType", "modelGroup", "originModelPath", "extraParams", "copy", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "getVersion", "I", "getEngineType", "()I", "getModelGroup", "getOriginModelPath", "getExtraParams", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "pitayacore_release"}, k = 1, mv = {1, 7, 1})
public final class PTYModelInfo implements ReflectionCall {
    public static final a Companion = null;
    public static final int ENGINE_TYPE_BYTEDT = 2;
    public static final int ENGINE_TYPE_BYTENN = 1;
    public static final int ENGINE_TYPE_NONE = 0;
    public static final int ENGINE_TYPE_PYTORCH = 4;
    public static final int ENGINE_TYPE_TFLITE = 3;
    public static final int ENGINE_TYPE_TVM = 5;
    private final int engineType;
    private final String extraParams;
    private final String modelGroup;
    private final String name;
    private final String originModelPath;
    private final String version;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ PTYModelInfo copy$default(PTYModelInfo r100, String r101, String r102, int r103, String r104, String r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.name;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.version;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.engineType;
    L11:
        int r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.modelGroup;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.originModelPath;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.extraParams;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.version;
    }

    public final int component3() {
        return this.engineType;
    }

    public final String component4() {
        return this.modelGroup;
    }

    public final String component5() {
        return this.originModelPath;
    }

    public final String component6() {
        return this.extraParams;
    }

    public final PTYModelInfo copy(String r100, String r110, int r111, String r112, String r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r110, "version");
        return new PTYModelInfo(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PTYModelInfo) == true) goto L8;
        return false;
    L8:
        PTYModelInfo r101 = (PTYModelInfo) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L15;
        return false;
    L15:
        if (this.engineType == r101.engineType) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.modelGroup, r101.modelGroup) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.originModelPath, r101.originModelPath) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.extraParams, r101.extraParams) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.name.hashCode() * 31) + this.version.hashCode()) * 31) + this.engineType) * 31;
        String r101 = this.modelGroup;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.originModelPath;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.extraParams;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "PTYModelInfo(name=" + this.name + ", version=" + this.version + ", engineType=" + this.engineType + ", modelGroup=" + this.modelGroup + ", originModelPath=" + this.originModelPath + ", extraParams=" + this.extraParams + ')';
    }

    public final int getEngineType() {
        return this.engineType;
    }

    public final String getExtraParams() {
        return this.extraParams;
    }

    public final String getModelGroup() {
        return this.modelGroup;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOriginModelPath() {
        return this.originModelPath;
    }

    public final String getVersion() {
        return this.version;
    }

    public PTYModelInfo(String r100, String r101, int r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "version");
        this.name = r100;
        this.version = r101;
        this.engineType = r102;
        this.modelGroup = r103;
        this.originModelPath = r104;
        this.extraParams = r105;
    }
}
