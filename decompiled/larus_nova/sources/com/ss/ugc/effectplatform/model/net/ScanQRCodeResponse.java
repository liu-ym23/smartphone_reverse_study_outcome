package com.ss.ugc.effectplatform.model.net;

import com.ss.ugc.effectplatform.model.PlatformEffect;
import com.ss.ugc.effectplatform.model.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0015\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B)\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b%\u0010&J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\f\u001a\u00020\bHÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000f\u001a\u00020\bHÆ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0012\u001a\u00020\bHÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003R$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/ScanQRCodeResponse;", "Lcom/ss/ugc/effectplatform/model/e;", "Lcom/ss/ugc/effectplatform/model/net/ScanQRCodeResponse$DataNode;", "getResponseData", "", "getResponseMessage", "", "checkValue", "", "getStatusCode", "component1", "component2", "component3", "data", "message", "status_code", "copy", "toString", "hashCode", "", "other", "equals", "Lcom/ss/ugc/effectplatform/model/net/ScanQRCodeResponse$DataNode;", "getData", "()Lcom/ss/ugc/effectplatform/model/net/ScanQRCodeResponse$DataNode;", "setData", "(Lcom/ss/ugc/effectplatform/model/net/ScanQRCodeResponse$DataNode;)V", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "I", "getStatus_code", "()I", "setStatus_code", "(I)V", "<init>", "(Lcom/ss/ugc/effectplatform/model/net/ScanQRCodeResponse$DataNode;Ljava/lang/String;I)V", "DataNode", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public final class ScanQRCodeResponse extends e<DataNode> {
    private DataNode data;
    private String message;
    private int status_code;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/ScanQRCodeResponse$DataNode;", "", "effect", "Lcom/ss/ugc/effectplatform/model/PlatformEffect;", "url_prefix", "", "", "(Lcom/ss/ugc/effectplatform/model/PlatformEffect;Ljava/util/List;)V", "getEffect", "()Lcom/ss/ugc/effectplatform/model/PlatformEffect;", "setEffect", "(Lcom/ss/ugc/effectplatform/model/PlatformEffect;)V", "getUrl_prefix", "()Ljava/util/List;", "setUrl_prefix", "(Ljava/util/List;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
    public static final class DataNode {
        private PlatformEffect effect;
        private List<String> url_prefix;

        /* JADX WARN: Multi-variable type inference failed */
        public DataNode() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DataNode copy$default(DataNode r100, PlatformEffect r101, List r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.effect;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.url_prefix;
        L9:
            return r100.copy(r101, r102);
        }

        public final PlatformEffect component1() {
            return this.effect;
        }

        public final List<String> component2() {
            return this.url_prefix;
        }

        public final DataNode copy(PlatformEffect r100, List<String> r101) {
            return new DataNode(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof DataNode) == false) goto L10;
            DataNode r101 = (DataNode) r100;
            if (Intrinsics.areEqual(this.effect, r101.effect) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.url_prefix, r101.url_prefix) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            PlatformEffect r100 = this.effect;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            List<String> r104 = this.url_prefix;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "DataNode(effect=" + this.effect + ", url_prefix=" + this.url_prefix + ")";
        }

        public final PlatformEffect getEffect() {
            return this.effect;
        }

        public final List<String> getUrl_prefix() {
            return this.url_prefix;
        }

        public final void setEffect(PlatformEffect r100) {
            this.effect = r100;
        }

        public final void setUrl_prefix(List<String> r100) {
            this.url_prefix = r100;
        }

        public DataNode(PlatformEffect r100, List<String> r101) {
            this.effect = r100;
            this.url_prefix = r101;
        }

        public /* synthetic */ DataNode(PlatformEffect r100, List r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this(r100, r101);
        }
    }

    public ScanQRCodeResponse() {
        this(null, null, 0, 7, null);
    }

    public static /* synthetic */ ScanQRCodeResponse copy$default(ScanQRCodeResponse r100, DataNode r101, String r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.data;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.message;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.status_code;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final DataNode component1() {
        return this.data;
    }

    public final String component2() {
        return this.message;
    }

    public final int component3() {
        return this.status_code;
    }

    public final ScanQRCodeResponse copy(DataNode r100, String r101, int r102) {
        return new ScanQRCodeResponse(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ScanQRCodeResponse) == false) goto L12;
        ScanQRCodeResponse r101 = (ScanQRCodeResponse) r100;
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L10;
        return false;
    L10:
        if (this.status_code == r101.status_code) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        DataNode r100 = this.data;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.message;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return ((r103 + r101) * 31) + this.status_code;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ScanQRCodeResponse(data=" + this.data + ", message=" + this.message + ", status_code=" + this.status_code + ")";
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public boolean checkValue() {
        DataNode r100 = this.data;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getEffect() == null) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public /* bridge */ /* synthetic */ DataNode getResponseData() {
        return getResponseData();
    }

    public final DataNode getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public String getResponseMessage() {
        return this.message;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public int getStatusCode() {
        return this.status_code;
    }

    public final int getStatus_code() {
        return this.status_code;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ss.ugc.effectplatform.model.e
    public DataNode getResponseData() {
        return this.data;
    }

    public final void setData(DataNode r100) {
        this.data = r100;
    }

    public final void setMessage(String r100) {
        this.message = r100;
    }

    public final void setStatus_code(int r100) {
        this.status_code = r100;
    }

    public ScanQRCodeResponse(DataNode r100, String r101, int r102) {
        this.data = r100;
        this.message = r101;
        this.status_code = r102;
    }

    public /* synthetic */ ScanQRCodeResponse(DataNode r100, String r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        this(r100, r101, r102);
    }
}
