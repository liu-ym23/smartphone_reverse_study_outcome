package com.ss.ugc.effectplatform.model.algorithm;

import com.larus.bmhome.share.panel.ShareType;
import com.ss.ugc.effectplatform.f;
import com.ss.ugc.effectplatform.j;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\b\u0017\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\u00038VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\f\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\b\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\n\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\u001a\u0010\u0005\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016¨\u0006%"}, d2 = {"Lcom/ss/ugc/effectplatform/model/algorithm/ModelInfo;", "", "_name", "", "name_sec", "version", ShareType.FILE_URL, "Lcom/ss/ugc/effectplatform/model/algorithm/ExtendedUrlModel;", "totalSize", "", "type", "", "status", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/algorithm/ExtendedUrlModel;JII)V", "getFile_url", "()Lcom/ss/ugc/effectplatform/model/algorithm/ExtendedUrlModel;", "setFile_url", "(Lcom/ss/ugc/effectplatform/model/algorithm/ExtendedUrlModel;)V", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getName_sec", "setName_sec", "getStatus", "()I", "setStatus", "(I)V", "getTotalSize", "()J", "setTotalSize", "(J)V", "getType", "setType", "getVersion", "setVersion", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class ModelInfo {
    private String _name;
    private ExtendedUrlModel file_url;
    private String name;
    private String name_sec;
    private int status;
    private long totalSize;
    private int type;
    private String version;

    public ModelInfo() {
        this(null, null, null, null, 0, 0, 0, 127, null);
    }

    public String getName() {
        if (StringsKt.isBlank(this._name) == false) goto L14;
        if ((!StringsKt.isBlank(getName_sec())) == false) goto L14;
        j r100 = f.f457400a;
        j r101 = f.f457400a;
        if (r101 == null) goto L11;
        String r102 = r101.decrypt(getName_sec());
        if (r102 == null) goto L11;
    L12:
        this._name = r102;
    L11:
        r102 = "";
    L14:
        if (StringsKt.isBlank(this._name) == false) goto L17;
        return this.name;
    L17:
        return this._name;
    }

    public ExtendedUrlModel getFile_url() {
        return this.file_url;
    }

    public String getName_sec() {
        return this.name_sec;
    }

    public int getStatus() {
        return this.status;
    }

    public long getTotalSize() {
        return this.totalSize;
    }

    public int getType() {
        return this.type;
    }

    public String getVersion() {
        return this.version;
    }

    public void setFile_url(ExtendedUrlModel r100) {
        this.file_url = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setName_sec(String r100) {
        this.name_sec = r100;
    }

    public void setStatus(int r100) {
        this.status = r100;
    }

    public void setTotalSize(long r100) {
        this.totalSize = r100;
    }

    public void setType(int r100) {
        this.type = r100;
    }

    public void setVersion(String r100) {
        this.version = r100;
    }

    public ModelInfo(String r100, String r101, String r102, ExtendedUrlModel r103, long r104, int r105, int r106) {
        this._name = r100;
        this.name_sec = r101;
        this.version = r102;
        this.file_url = r103;
        this.totalSize = r104;
        this.type = r105;
        this.status = r106;
        this.name = "";
    }

    public /* synthetic */ ModelInfo(String r100, String r110, String r111, ExtendedUrlModel r112, long r113, int r114, int r115, int r116, DefaultConstructorMarker r117) {
        String r101 = "";
        if ((r116 & 1) == 0) goto L5;
        String r102 = "";
    L7:
        if ((r116 & 2) == 0) goto L9;
        String r103 = "";
    L11:
        if ((r116 & 4) != 0) goto L15;
        r101 = r111;
    L15:
        if ((r116 & 8) == 0) goto L17;
        ExtendedUrlModel r104 = null;
    L19:
        if ((r116 & 16) == 0) goto L21;
        long r105 = 0;
    L23:
        if ((r116 & 32) == 0) goto L25;
        int r106 = 0;
    L27:
        if ((r116 & 64) == 0) goto L29;
        int r107 = 1;
    L30:
        this(r102, r103, r101, r104, r105, r106, r107);
        return;
    L29:
        r107 = r115;
        goto L30
    L25:
        r106 = r114;
        goto L27
    L21:
        r105 = r113;
        goto L23
    L17:
        r104 = r112;
        goto L19
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r100;
        goto L7
    }
}
