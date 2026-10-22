package com.bytedance.ee.bear.rn.middleground.protocol;

import com.bytedance.ee.bear.rn.middleground.protocol.Protocol.Body;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity$Base;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity;", "business", "", WikiFolderPushPlugin.DATA, "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity$Data;", "<init>", "(Ljava/lang/String;Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity$Data;)V", "getBusiness", "()Ljava/lang/String;", "getData", "()Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity$Data;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Base implements Entity {
            private final String business;
            private final Data data;

            public static /* synthetic */ Base copy$default(Base r0, String r1, Data r2, int r3, Object r4) {
                if ((r3 & 1) == 0) goto L6;
                r1 = r0.business;
            L6:
                if ((r3 & 2) == 0) goto L9;
                r2 = r0.data;
            L9:
                return r0.copy(r1, r2);
            }

            public final String component1() {
                return this.business;
            }

            public final Data component2() {
                return this.data;
            }

            public final Base copy(String r2, Data r3) {
                Intrinsics.checkNotNullParameter(r2, "business");
                Intrinsics.checkNotNullParameter(r3, WikiFolderPushPlugin.DATA);
                return new Base(r2, r3);
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof Base) == true) goto L8;
                return false;
            L8:
                Base r6 = (Base) r5;
                if (Intrinsics.areEqual(this.business, r6.business) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.data, r6.data) == true) goto L14;
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

            public Base(String r2, Data r3) {
                Intrinsics.checkNotNullParameter(r2, "business");
                Intrinsics.checkNotNullParameter(r3, WikiFolderPushPlugin.DATA);
                this.business = r2;
                this.data = r3;
            }
        }

        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity$Data;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity;", WikiFolderPushPlugin.OPT, "", "header", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity$Header;", "identifier", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity$Identifier;", "body", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Body;", "extra", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity$Extra;", "<init>", "(Ljava/lang/String;Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity$Header;Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity$Identifier;Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Body;Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity$Extra;)V", "getOperation", "()Ljava/lang/String;", "getHeader", "()Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity$Header;", "getIdentifier", "()Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity$Identifier;", "getBody", "()Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Body;", "getExtra", "()Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity$Extra;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Data implements Entity {
            private final Body body;
            private final Extra extra;
            private final Header header;
            private final Identifier identifier;
            private final String operation;

            public Data() {
                this(null, null, null, null, null, 31, null);
            }

            public static /* synthetic */ Data copy$default(Data r3, String r4, Header r5, Identifier r6, Body r7, Extra r8, int r9, Object r10) {
                if ((r9 & 1) == 0) goto L6;
                r4 = r3.operation;
            L6:
                if ((r9 & 2) == 0) goto L8;
                r5 = r3.header;
            L8:
                Header r11 = r5;
                if ((r9 & 4) == 0) goto L11;
                r6 = r3.identifier;
            L11:
                Identifier r0 = r6;
                if ((r9 & 8) == 0) goto L14;
                r7 = r3.body;
            L14:
                Body r1 = r7;
                if ((r9 & 16) == 0) goto L17;
                r8 = r3.extra;
            L17:
                String r12 = r4;
                return r3.copy(r12, r11, r0, r1, r8);
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

            public final Data copy(String r8, Header r9, Identifier r10, Body r11, Extra r12) {
                return new Data(r8, r9, r10, r11, r12);
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof Data) == true) goto L8;
                return false;
            L8:
                Data r6 = (Data) r5;
                if (Intrinsics.areEqual(this.operation, r6.operation) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.header, r6.header) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.identifier, r6.identifier) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.body, r6.body) == true) goto L21;
                return false;
            L21:
                if (Intrinsics.areEqual(this.extra, r6.extra) == true) goto L23;
                return false;
            L23:
                return true;
            }

            public int hashCode() {
                String r0 = this.operation;
                int r1 = 0;
                if (r0 != null) goto L5;
                int r2 = 0;
            L6:
                int r3 = r2 * 31;
                Header r4 = this.header;
                if (r4 != null) goto L9;
                int r5 = 0;
            L10:
                int r6 = (r3 + r5) * 31;
                Identifier r7 = this.identifier;
                if (r7 != null) goto L13;
                int r8 = 0;
            L14:
                int r9 = (r6 + r8) * 31;
                Body r10 = this.body;
                if (r10 != null) goto L17;
                int r11 = 0;
            L18:
                int r12 = (r9 + r11) * 31;
                Extra r13 = this.extra;
                if (r13 == null) goto L23;
                r1 = r13.hashCode();
            L23:
                return r12 + r1;
            L17:
                r11 = r10.hashCode();
                goto L18
            L13:
                r8 = r7.hashCode();
                goto L14
            L9:
                r5 = r4.hashCode();
                goto L10
            L5:
                r2 = r0.hashCode();
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

            public Data(String r1, Header r2, Identifier r3, Body r4, Extra r5) {
                this.operation = r1;
                this.header = r2;
                this.identifier = r3;
                this.body = r4;
                this.extra = r5;
            }

            public /* synthetic */ Data(String r5, Header r6, Identifier r7, Body r8, Extra r9, int r10, DefaultConstructorMarker r11) {
                if ((r10 & 1) == 0) goto L5;
                String r12 = null;
            L7:
                if ((r10 & 2) == 0) goto L9;
                Header r1 = null;
            L11:
                if ((r10 & 4) == 0) goto L13;
                Identifier r2 = null;
            L15:
                if ((r10 & 8) == 0) goto L17;
                Body r3 = null;
            L19:
                if ((r10 & 16) == 0) goto L21;
                Extra r13 = null;
            L22:
                this(r12, r1, r2, r3, r13);
                return;
            L21:
                r13 = r9;
                goto L22
            L17:
                r3 = r8;
                goto L19
            L13:
                r2 = r7;
                goto L15
            L9:
                r1 = r6;
                goto L11
            L5:
                r12 = r5;
                goto L7
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity$Extra;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity;", ResourceData.KEY_TYPE, "", "<init>", "(Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Extra implements Entity {
            private final String type;

            public Extra() {
                String r0 = null;
                this(r0, 1, r0);
            }

            public static /* synthetic */ Extra copy$default(Extra r0, String r1, int r2, Object r3) {
                if ((r2 & 1) == 0) goto L6;
                r1 = r0.type;
            L6:
                return r0.copy(r1);
            }

            public final String component1() {
                return this.type;
            }

            public final Extra copy(String r2) {
                Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TYPE);
                return new Extra(r2);
            }

            public boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof Extra) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.type, ((Extra) r4).type) == true) goto L11;
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

            public Extra(String r2) {
                Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TYPE);
                this.type = r2;
            }

            public /* synthetic */ Extra(String r1, int r2, DefaultConstructorMarker r3) {
                if ((r2 & 1) == 0) goto L5;
                r1 = "";
            L5:
                this(r1);
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity$Header;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity;", "requestId", "", "<init>", "(Ljava/lang/String;)V", "getRequestId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Header implements Entity {
            private final String requestId;

            public Header() {
                String r0 = null;
                this(r0, 1, r0);
            }

            public static /* synthetic */ Header copy$default(Header r0, String r1, int r2, Object r3) {
                if ((r2 & 1) == 0) goto L6;
                r1 = r0.requestId;
            L6:
                return r0.copy(r1);
            }

            public final String component1() {
                return this.requestId;
            }

            public final Header copy(String r2) {
                Intrinsics.checkNotNullParameter(r2, "requestId");
                return new Header(r2);
            }

            public boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof Header) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.requestId, ((Header) r4).requestId) == true) goto L11;
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

            public Header(String r2) {
                Intrinsics.checkNotNullParameter(r2, "requestId");
                this.requestId = r2;
            }

            public /* synthetic */ Header(String r1, int r2, DefaultConstructorMarker r3) {
                if ((r2 & 1) == 0) goto L5;
                r1 = "";
            L5:
                this(r1);
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity$Identifier;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Entity;", ResourceData.KEY_TYPE, "", ResourceData.KEY_TOKEN, "", "owner", "", "appId", "<init>", "(ILjava/lang/String;ZLjava/lang/String;)V", "getType", "()I", "getToken", "()Ljava/lang/String;", "getOwner", "()Z", "getAppId", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Identifier implements Entity {
            private final String appId;
            private final boolean owner;
            private final String token;
            private final int type;

            public static /* synthetic */ Identifier copy$default(Identifier r0, int r1, String r2, boolean r3, String r4, int r5, Object r6) {
                if ((r5 & 1) == 0) goto L6;
                r1 = r0.type;
            L6:
                if ((r5 & 2) == 0) goto L9;
                r2 = r0.token;
            L9:
                if ((r5 & 4) == 0) goto L12;
                r3 = r0.owner;
            L12:
                if ((r5 & 8) == 0) goto L15;
                r4 = r0.appId;
            L15:
                return r0.copy(r1, r2, r3, r4);
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

            public final Identifier copy(int r2, String r3, boolean r4, String r5) {
                Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
                return new Identifier(r2, r3, r4, r5);
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof Identifier) == true) goto L8;
                return false;
            L8:
                Identifier r6 = (Identifier) r5;
                if (this.type == r6.type) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.token, r6.token) == true) goto L15;
                return false;
            L15:
                if (this.owner == r6.owner) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.appId, r6.appId) == true) goto L20;
                return false;
            L20:
                return true;
            }

            public int hashCode() {
                int r0 = ((this.type * 31) + this.token.hashCode()) * 31;
                if (this.owner == false) goto L5;
                int r1 = 1231;
            L6:
                int r2 = (r0 + r1) * 31;
                String r3 = this.appId;
                if (r3 != null) goto L9;
                int r4 = 0;
            L11:
                return r2 + r4;
            L9:
                r4 = r3.hashCode();
                goto L11
            L5:
                r1 = 1237;
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

            public Identifier(int r2, String r3, boolean r4, String r5) {
                Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
                this.type = r2;
                this.token = r3;
                this.owner = r4;
                this.appId = r5;
            }

            public /* synthetic */ Identifier(int r1, String r2, boolean r3, String r4, int r5, DefaultConstructorMarker r6) {
                if ((r5 & 4) == 0) goto L6;
                r3 = false;
            L6:
                if ((r5 & 8) == 0) goto L8;
                r4 = "";
            L8:
                this(r1, r2, r3, r4);
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

    public final void setBody(T r2) {
        Intrinsics.checkNotNullParameter(r2, "body");
        this.mBody = r2;
    }

    public final void setHeader(Entity.Header r2) {
        Intrinsics.checkNotNullParameter(r2, "header");
        this.mHeader = r2;
    }

    public final void setIdentifier(Entity.Identifier r2) {
        Intrinsics.checkNotNullParameter(r2, "identifier");
        this.mIdentifier = r2;
    }

    public final void setMBody(T r1) {
        this.mBody = r1;
    }

    public final void setMHeader(Entity.Header r1) {
        this.mHeader = r1;
    }

    public final void setMIdentifier(Entity.Identifier r1) {
        this.mIdentifier = r1;
    }
}
