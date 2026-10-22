package com.bytedance.pitaya.api.bean.py;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.pitaya.api.bean.PTYClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B=\b\u0012\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000bB?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/bytedance/pitaya/api/bean/py/PTYMemoryViewBuffer;", "Lcom/bytedance/pitaya/api/bean/PTYClass;", "rawBytes", "", "rawFloats", "", "readOnly", "", "shape", "", "customInfo", "([B[FZLjava/lang/String;Ljava/lang/String;)V", "", "Lorg/json/JSONObject;", "([B[FZ[ILorg/json/JSONObject;)V", "customInfoStr", "getCustomInfoStr", "()Ljava/lang/String;", "getRawBytes", "()[B", "rawDataType", "", "getRawDataType$annotations", "()V", "getRawFloats", "()[F", "getReadOnly", "()Z", "getShape", "()[I", "size", "", "getSize", "()J", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PTYMemoryViewBuffer extends PTYClass {
    private final String customInfoStr;
    private final byte[] rawBytes;
    private final int rawDataType;
    private final float[] rawFloats;
    private final boolean readOnly;
    private final int[] shape;
    private final long size;

    public PTYMemoryViewBuffer() {
        this(null, null, false, null, null, 31, null);
    }

    private static /* synthetic */ void getRawDataType$annotations() {
    }

    public final String getCustomInfoStr() {
        return this.customInfoStr;
    }

    public final byte[] getRawBytes() {
        return this.rawBytes;
    }

    public final float[] getRawFloats() {
        return this.rawFloats;
    }

    public final boolean getReadOnly() {
        return this.readOnly;
    }

    public final int[] getShape() {
        return this.shape;
    }

    public final long getSize() {
        return this.size;
    }

    public PTYMemoryViewBuffer(byte[] r100, float[] r101, boolean r102, int[] r103, JSONObject r104) {
        super(1);
        this.rawBytes = r100;
        this.rawFloats = r101;
        this.readOnly = r102;
        this.shape = r103;
        if (r100 == null) goto L5;
        long r105 = r100.length;
    L8:
        this.size = r105;
        if (r104 == null) goto L11;
        String r106 = r104.toString();
    L12:
        this.customInfoStr = r106;
        if (r102 == false) goto L23;
        if (r100 == null) goto L16;
        int r107 = 2;
    L18:
        this.rawDataType = r107;
        return;
    L16:
        if (r101 == null) goto L21;
        r107 = 3;
        goto L18
    L21:
        throw new IllegalArgumentException("Tensor has no data!");
    L23:
        throw new IllegalArgumentException("Only READ_ONLY MemoryViewBuffer is supported since Pitaya 2.7,More information please contact with mabenteng");
    L11:
        r106 = null;
        goto L12
    L5:
        if (r101 == null) goto L7;
        r105 = ((long) r101.length) * 4;
        goto L8
    L7:
        r105 = 0;
        goto L8
    }

    private PTYMemoryViewBuffer(byte[] r110, float[] r111, boolean r112, String r113, String r114) {
        JSONObject r100 = null;
        if (r113 != null) goto L17;
        int[] r101 = null;
    L11:
        if (r114 != null) goto L19;
    L14:
        this(r110, r111, r112, r101, r100);
        return;
    L19:
        r100 = new JSONObject(r114);     // Catch: Exception -> L16
        goto L14
    L17:
        JSONArray r102 = new JSONArray(r113);     // Catch: Exception -> L8
        int r115 = r102.length();     // Catch: Exception -> L8
        int[] r103 = new int[r115];     // Catch: Exception -> L8
        int r104 = 0;
    L5:
        if (r104 >= r115) goto L9;
        r103[r104] = JSONArrayProtectorUtils.getInt(r102, r104);     // Catch: Exception -> L8
        r104 = r104 + 1;
    L9:
        r101 = r103;
    L8:
        r103 = null;
        goto L9
    }

    public /* synthetic */ PTYMemoryViewBuffer(byte[] r100, float[] r101, boolean r102, int[] r103, JSONObject r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        byte[] r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        float[] r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        boolean r106 = true;
    L15:
        if ((r110 & 8) == 0) goto L17;
        int[] r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        JSONObject r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }

    public /* synthetic */ PTYMemoryViewBuffer(byte[] r100, float[] r101, boolean r102, String r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 4) == 0) goto L5;
        boolean r103 = true;
    L7:
        if ((r112 & 8) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r112 & 16) == 0) goto L13;
        String r105 = null;
    L14:
        this(r100, r101, r103, r104, r105);
        return;
    L13:
        r105 = r111;
        goto L14
    L9:
        r104 = r110;
        goto L11
    L5:
        r103 = r102;
        goto L7
    }
}
