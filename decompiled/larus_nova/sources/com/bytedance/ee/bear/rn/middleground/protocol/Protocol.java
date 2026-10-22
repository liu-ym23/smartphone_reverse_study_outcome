package com.bytedance.ee.bear.rn.middleground.protocol;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ee.bear.rn.middleground.protocol.Protocol.Body;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class Protocol<T extends Body> {
    private T mBody;
    private Entity.Header mHeader;
    private Entity.Identifier mIdentifier;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Body;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity;", "Empty", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Body extends Entity {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Body$Empty;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Body;", "<init>", "()V", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Empty implements Body {
            public Empty() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity;", "Ljava/io/Serializable;", "Base", "Data", "Header", "Extra", "Identifier", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Entity extends Serializable {

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity$Base;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity;", "business", "", "data", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity$Data;", "<init>", "(Ljava/lang/String;Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity$Data;)V", "getBusiness", "()Ljava/lang/String;", "getData", "()Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity$Data;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Base implements Entity {
            private final String business;
            private final Data data;

            public static /* synthetic */ Base copy$default(Base r100, String r101, Data r102, int r103, Object r104) {
                if ((r103 & 1) == 0) goto L6;
                r101 = r100.business;
            L6:
                if ((r103 & 2) == 0) goto L9;
                r102 = r100.data;
            L9:
                return r100.copy(r101, r102);
            }

            public final String component1() {
                return this.business;
            }

            public final Data component2() {
                return this.data;
            }

            public final Base copy(String r100, Data r101) {
                Intrinsics.checkNotNullParameter(r100, "business");
                Intrinsics.checkNotNullParameter(r101, "data");
                return new Base(r100, r101);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof Base) == true) goto L8;
                return false;
            L8:
                Base r101 = (Base) r100;
                if (Intrinsics.areEqual(this.business, r101.business) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.data, r101.data) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                return (this.business.hashCode() * 31) + this.data.hashCode();
            }

            public String toString() {
                return "Base(business=" + this.business + ", data=" + this.data + ')';
            }

            public final String getBusiness() {
                return this.business;
            }

            public final Data getData() {
                return this.data;
            }

            public Base(String r100, Data r101) {
                Intrinsics.checkNotNullParameter(r100, "business");
                Intrinsics.checkNotNullParameter(r101, "data");
                this.business = r100;
                this.data = r101;
            }
        }

        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity$Data;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity;", WikiFolderPushPlugin.OPT, "", "header", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity$Header;", LocationMonitorConst.IDENTIFIER, "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity$Identifier;", ContainerPosition.BODY, "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Body;", "extra", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity$Extra;", "<init>", "(Ljava/lang/String;Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity$Header;Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity$Identifier;Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Body;Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity$Extra;)V", "getOperation", "()Ljava/lang/String;", "getHeader", "()Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity$Header;", "getIdentifier", "()Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity$Identifier;", "getBody", "()Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Body;", "getExtra", "()Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity$Extra;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Data implements Entity {
            private final Body body;
            private final Extra extra;
            private final Header header;
            private final Identifier identifier;
            private final String operation;

            public Data() {
                this(null, null, null, null, null, 31, null);
            }

            public static /* synthetic */ Data copy$default(Data r100, String r101, Header r102, Identifier r103, Body r104, Extra r105, int r106, Object r110) {
                if ((r106 & 1) == 0) goto L6;
                r101 = r100.operation;
            L6:
                if ((r106 & 2) == 0) goto L8;
                r102 = r100.header;
            L8:
                Header r111 = r102;
                if ((r106 & 4) == 0) goto L11;
                r103 = r100.identifier;
            L11:
                Identifier r107 = r103;
                if ((r106 & 8) == 0) goto L14;
                r104 = r100.body;
            L14:
                Body r108 = r104;
                if ((r106 & 16) == 0) goto L17;
                r105 = r100.extra;
            L17:
                String r109 = r101;
                return r100.copy(r109, r111, r107, r108, r105);
            }

            public final String component1() {
                return this.operation;
            }

            public final Header component2() {
                return this.header;
            }

            public final Identifier component3() {
                return this.identifier;
            }

            public final Body component4() {
                return this.body;
            }

            public final Extra component5() {
                return this.extra;
            }

            public final Data copy(String r100, Header r101, Identifier r110, Body r111, Extra r112) {
                return new Data(r100, r101, r110, r111, r112);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof Data) == true) goto L8;
                return false;
            L8:
                Data r101 = (Data) r100;
                if (Intrinsics.areEqual(this.operation, r101.operation) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.header, r101.header) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.identifier, r101.identifier) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.body, r101.body) == true) goto L21;
                return false;
            L21:
                if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L23;
                return false;
            L23:
                return true;
            }

            public int hashCode() {
                String r100 = this.operation;
                int r101 = 0;
                if (r100 != null) goto L5;
                int r102 = 0;
            L6:
                int r103 = r102 * 31;
                Header r104 = this.header;
                if (r104 != null) goto L9;
                int r105 = 0;
            L10:
                int r106 = (r103 + r105) * 31;
                Identifier r107 = this.identifier;
                if (r107 != null) goto L13;
                int r108 = 0;
            L14:
                int r109 = (r106 + r108) * 31;
                Body r110 = this.body;
                if (r110 != null) goto L17;
                int r111 = 0;
            L18:
                int r112 = (r109 + r111) * 31;
                Extra r113 = this.extra;
                if (r113 == null) goto L23;
                r101 = r113.hashCode();
            L23:
                return r112 + r101;
            L17:
                r111 = r110.hashCode();
                goto L18
            L13:
                r108 = r107.hashCode();
                goto L14
            L9:
                r105 = r104.hashCode();
                goto L10
            L5:
                r102 = r100.hashCode();
                goto L6
            }

            public String toString() {
                return "Data(operation=" + this.operation + ", header=" + this.header + ", identifier=" + this.identifier + ", body=" + this.body + ", extra=" + this.extra + ')';
            }

            public final Body getBody() {
                return this.body;
            }

            public final Extra getExtra() {
                return this.extra;
            }

            public final Header getHeader() {
                return this.header;
            }

            public final Identifier getIdentifier() {
                return this.identifier;
            }

            public final String getOperation() {
                return this.operation;
            }

            public Data(String r100, Header r101, Identifier r102, Body r103, Extra r104) {
                this.operation = r100;
                this.header = r101;
                this.identifier = r102;
                this.body = r103;
                this.extra = r104;
            }

            public /* synthetic */ Data(String r100, Header r101, Identifier r102, Body r103, Extra r104, int r110, DefaultConstructorMarker r111) {
                if ((r110 & 1) == 0) goto L5;
                String r112 = null;
            L7:
                if ((r110 & 2) == 0) goto L9;
                Header r105 = null;
            L11:
                if ((r110 & 4) == 0) goto L13;
                Identifier r106 = null;
            L15:
                if ((r110 & 8) == 0) goto L17;
                Body r107 = null;
            L19:
                if ((r110 & 16) == 0) goto L21;
                Extra r113 = null;
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
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity$Extra;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity;", "type", "", "<init>", "(Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Extra implements Entity {
            private final String type;

            /* JADX WARN: Multi-variable type inference failed */
            public Extra() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ Extra copy$default(Extra r100, String r101, int r102, Object r103) {
                if ((r102 & 1) == 0) goto L6;
                r101 = r100.type;
            L6:
                return r100.copy(r101);
            }

            public final String component1() {
                return this.type;
            }

            public final Extra copy(String r100) {
                Intrinsics.checkNotNullParameter(r100, "type");
                return new Extra(r100);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof Extra) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.type, ((Extra) r100).type) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.type.hashCode();
            }

            public String toString() {
                return "Extra(type=" + this.type + ')';
            }

            public final String getType() {
                return this.type;
            }

            public Extra(String r100) {
                Intrinsics.checkNotNullParameter(r100, "type");
                this.type = r100;
            }

            public /* synthetic */ Extra(String r100, int r101, DefaultConstructorMarker r102) {
                if ((r101 & 1) == 0) goto L5;
                r100 = "";
            L5:
                this(r100);
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity$Header;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity;", "requestId", "", "<init>", "(Ljava/lang/String;)V", "getRequestId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Header implements Entity {
            private final String requestId;

            /* JADX WARN: Multi-variable type inference failed */
            public Header() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ Header copy$default(Header r100, String r101, int r102, Object r103) {
                if ((r102 & 1) == 0) goto L6;
                r101 = r100.requestId;
            L6:
                return r100.copy(r101);
            }

            public final String component1() {
                return this.requestId;
            }

            public final Header copy(String r100) {
                Intrinsics.checkNotNullParameter(r100, "requestId");
                return new Header(r100);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof Header) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.requestId, ((Header) r100).requestId) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.requestId.hashCode();
            }

            public String toString() {
                return "Header(requestId=" + this.requestId + ')';
            }

            public final String getRequestId() {
                return this.requestId;
            }

            public Header(String r100) {
                Intrinsics.checkNotNullParameter(r100, "requestId");
                this.requestId = r100;
            }

            public /* synthetic */ Header(String r100, int r101, DefaultConstructorMarker r102) {
                if ((r101 & 1) == 0) goto L5;
                r100 = "";
            L5:
                this(r100);
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity$Identifier;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity;", "type", "", "token", "", "owner", "", "appId", "<init>", "(ILjava/lang/String;ZLjava/lang/String;)V", "getType", "()I", "getToken", "()Ljava/lang/String;", "getOwner", "()Z", "getAppId", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Identifier implements Entity {
            private final String appId;
            private final boolean owner;
            private final String token;
            private final int type;

            public static /* synthetic */ Identifier copy$default(Identifier r100, int r101, String r102, boolean r103, String r104, int r105, Object r106) {
                if ((r105 & 1) == 0) goto L6;
                r101 = r100.type;
            L6:
                if ((r105 & 2) == 0) goto L9;
                r102 = r100.token;
            L9:
                if ((r105 & 4) == 0) goto L12;
                r103 = r100.owner;
            L12:
                if ((r105 & 8) == 0) goto L15;
                r104 = r100.appId;
            L15:
                return r100.copy(r101, r102, r103, r104);
            }

            public final int component1() {
                return this.type;
            }

            public final String component2() {
                return this.token;
            }

            public final boolean component3() {
                return this.owner;
            }

            public final String component4() {
                return this.appId;
            }

            public final Identifier copy(int r100, String r101, boolean r102, String r103) {
                Intrinsics.checkNotNullParameter(r101, "token");
                return new Identifier(r100, r101, r102, r103);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof Identifier) == true) goto L8;
                return false;
            L8:
                Identifier r101 = (Identifier) r100;
                if (this.type == r101.type) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.token, r101.token) == true) goto L15;
                return false;
            L15:
                if (this.owner == r101.owner) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L20;
                return false;
            L20:
                return true;
            }

            public int hashCode() {
                int r100 = ((this.type * 31) + this.token.hashCode()) * 31;
                if (this.owner == false) goto L5;
                int r101 = 1231;
            L6:
                int r102 = (r100 + r101) * 31;
                String r103 = this.appId;
                if (r103 != null) goto L9;
                int r104 = 0;
            L11:
                return r102 + r104;
            L9:
                r104 = r103.hashCode();
                goto L11
            L5:
                r101 = 1237;
                goto L6
            }

            public String toString() {
                return "Identifier(type=" + this.type + ", token=" + this.token + ", owner=" + this.owner + ", appId=" + this.appId + ')';
            }

            public final String getAppId() {
                return this.appId;
            }

            public final boolean getOwner() {
                return this.owner;
            }

            public final String getToken() {
                return this.token;
            }

            public final int getType() {
                return this.type;
            }

            public Identifier(int r100, String r101, boolean r102, String r103) {
                Intrinsics.checkNotNullParameter(r101, "token");
                this.type = r100;
                this.token = r101;
                this.owner = r102;
                this.appId = r103;
            }

            public /* synthetic */ Identifier(int r100, String r101, boolean r102, String r103, int r104, DefaultConstructorMarker r105) {
                if ((r104 & 4) == 0) goto L6;
                r102 = false;
            L6:
                if ((r104 & 8) == 0) goto L8;
                r103 = "";
            L8:
                this(r100, r101, r102, r103);
            }
        }
    }

    public Protocol() {
    }

    public abstract String getJsonString();

    public final T getMBody() {
        return this.mBody;
    }

    public final Entity.Header getMHeader() {
        return this.mHeader;
    }

    public final Entity.Identifier getMIdentifier() {
        return this.mIdentifier;
    }

    public final void setBody(T r100) {
        Intrinsics.checkNotNullParameter(r100, ContainerPosition.BODY);
        this.mBody = r100;
    }

    public final void setHeader(Entity.Header r100) {
        Intrinsics.checkNotNullParameter(r100, "header");
        this.mHeader = r100;
    }

    public final void setIdentifier(Entity.Identifier r100) {
        Intrinsics.checkNotNullParameter(r100, LocationMonitorConst.IDENTIFIER);
        this.mIdentifier = r100;
    }

    public final void setMBody(T r100) {
        this.mBody = r100;
    }

    public final void setMHeader(Entity.Header r100) {
        this.mHeader = r100;
    }

    public final void setMIdentifier(Entity.Identifier r100) {
        this.mIdentifier = r100;
    }
}
