package com.ss.android.lark.export.entity.turtle;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/export/entity/turtle/TurtleCanvasEntity;", "Ljava/io/Serializable;", "scriptKey", "", "scriptVersion", "", "scriptPath", "pbData", "Lokio/ByteString;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lokio/ByteString;)V", "getScriptKey", "()Ljava/lang/String;", "getScriptVersion", "()I", "getScriptPath", "getPbData", "()Lokio/ByteString;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TurtleCanvasEntity implements Serializable {
    private final ByteString pbData;
    private final String scriptKey;
    private final String scriptPath;
    private final int scriptVersion;

    public TurtleCanvasEntity() {
        this(null, 0, null, null, 15, null);
    }

    public static /* synthetic */ TurtleCanvasEntity copy$default(TurtleCanvasEntity r100, String r101, int r102, String r103, ByteString r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.scriptKey;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.scriptVersion;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.scriptPath;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.pbData;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.scriptKey;
    }

    public final int component2() {
        return this.scriptVersion;
    }

    public final String component3() {
        return this.scriptPath;
    }

    public final ByteString component4() {
        return this.pbData;
    }

    public final TurtleCanvasEntity copy(String r100, int r101, String r102, ByteString r103) {
        return new TurtleCanvasEntity(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TurtleCanvasEntity) == true) goto L8;
        return false;
    L8:
        TurtleCanvasEntity r101 = (TurtleCanvasEntity) r100;
        if (Intrinsics.areEqual(this.scriptKey, r101.scriptKey) == true) goto L12;
        return false;
    L12:
        if (this.scriptVersion == r101.scriptVersion) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.scriptPath, r101.scriptPath) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.pbData, r101.pbData) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.scriptKey;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.scriptVersion) * 31;
        String r104 = this.scriptPath;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        ByteString r107 = this.pbData;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "TurtleCanvasEntity(scriptKey=" + this.scriptKey + ", scriptVersion=" + this.scriptVersion + ", scriptPath=" + this.scriptPath + ", pbData=" + this.pbData + ')';
    }

    public final ByteString getPbData() {
        return this.pbData;
    }

    public final String getScriptKey() {
        return this.scriptKey;
    }

    public final String getScriptPath() {
        return this.scriptPath;
    }

    public final int getScriptVersion() {
        return this.scriptVersion;
    }

    public TurtleCanvasEntity(String r100, int r101, String r102, ByteString r103) {
        this.scriptKey = r100;
        this.scriptVersion = r101;
        this.scriptPath = r102;
        this.pbData = r103;
    }

    public /* synthetic */ TurtleCanvasEntity(String r100, int r101, String r102, ByteString r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
