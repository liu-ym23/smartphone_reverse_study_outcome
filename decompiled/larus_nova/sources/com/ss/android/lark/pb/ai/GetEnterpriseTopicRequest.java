package com.ss.android.lark.pb.ai;

import com.android.ttcjpaysdk.bdpay.counter.outer.bean.ConfirmNextAction;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class GetEnterpriseTopicRequest extends Message<GetEnterpriseTopicRequest, Builder> {
    public static final ProtoAdapter<GetEnterpriseTopicRequest> ADAPTER = null;
    public static final String DEFAULT_ABBR_ID = "";
    public static final String DEFAULT_LOCALE = "";
    public static final String DEFAULT_QUERY = "";
    private static final long serialVersionUID = 0;
    public final String mabbr_id;
    public final String mlocale;
    public final Method mmethod;
    public final String mquery;
    public final Scene mscene;

    public static final class Builder extends Message.Builder<GetEnterpriseTopicRequest, Builder> {
        public String mabbr_id;
        public String mlocale;
        public Method mmethod;
        public String mquery;
        public Scene mscene;

        @Override // com.squareup.wire.Message.Builder
        public GetEnterpriseTopicRequest build() {
            Scene r100 = this.mscene;
            if (r100 == null) goto L9;
            if (this.mquery == null) goto L9;
            return new GetEnterpriseTopicRequest(this.mscene, this.mquery, this.mlocale, this.mabbr_id, this.mmethod, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "mscene", this.mquery, "mquery"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder abbr_id(String r100) {
            this.mabbr_id = r100;
            return this;
        }

        public Builder locale(String r100) {
            this.mlocale = r100;
            return this;
        }

        public Builder method(Method r100) {
            this.mmethod = r100;
            return this;
        }

        public Builder query(String r100) {
            this.mquery = r100;
            return this;
        }

        public Builder scene(Scene r100) {
            this.mscene = r100;
            return this;
        }
    }

    public static final enum Method extends Enum<Method> implements WireEnum {
        private static final /* synthetic */ Method[] $VALUES = null;
        public static final ProtoAdapter<Method> ADAPTER = null;
        public static final Method CLICK = null;
        public static final Method QUERY = null;
        private final int value;

        static {
            Method r100 = new Method("CLICK", 0, 0);
            CLICK = r100;
            Method r101 = new Method(ConfirmNextAction.ACTION_TYPE_QUERY, 1, 1);
            QUERY = r101;
            $VALUES = new Method[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(Method.class);
        }

        public static Method[] values() {
            return (Method[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Method fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return QUERY;
        L10:
            return CLICK;
        }

        public static Method valueOf(String r100) {
            return (Method) a.a(Method.class, r100);
        }

        private Method(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_GetEnterpriseTopicRequest extends ProtoAdapter<GetEnterpriseTopicRequest> {
        public ProtoAdapter_GetEnterpriseTopicRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetEnterpriseTopicRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetEnterpriseTopicRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mquery = "";
            r101.mlocale = "";
            r101.mabbr_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L27;
            if (r103 != 1) goto L8;
            r101.mscene = Scene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
        L25:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mquery = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mlocale = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.mabbr_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.mmethod = Method.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L27:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetEnterpriseTopicRequest r100) {
            int r101 = Scene.ADAPTER.encodedSizeWithTag(1, r100.mscene);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            int r103 = r101 + r102.encodedSizeWithTag(2, r100.mquery);
            String r104 = r100.mlocale;
            int r105 = 0;
            if (r104 == null) goto L5;
            int r106 = r102.encodedSizeWithTag(3, r104);
        L6:
            int r107 = r103 + r106;
            String r108 = r100.mabbr_id;
            if (r108 == null) goto L9;
            int r109 = r102.encodedSizeWithTag(4, r108);
        L10:
            int r110 = r107 + r109;
            Method r111 = r100.mmethod;
            if (r111 == null) goto L14;
            r105 = Method.ADAPTER.encodedSizeWithTag(5, r111);
        L14:
            return (r110 + r105) + r100.unknownFields().size();
        L9:
            r109 = 0;
            goto L10
        L5:
            r106 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetEnterpriseTopicRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetEnterpriseTopicRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetEnterpriseTopicRequest r101) throws IOException {
            Scene.ADAPTER.encodeWithTag(r100, 1, r101.mscene);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 2, r101.mquery);
            String r103 = r101.mlocale;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            String r104 = r101.mabbr_id;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 4, r104);
        L8:
            Method r105 = r101.mmethod;
            if (r105 == null) goto L11;
            Method.ADAPTER.encodeWithTag(r100, 5, r105);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetEnterpriseTopicRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Scene extends Enum<Scene> implements WireEnum {
        private static final /* synthetic */ Scene[] $VALUES = null;
        public static final ProtoAdapter<Scene> ADAPTER = null;
        public static final Scene BROWSER = null;
        public static final Scene DOCS = null;
        public static final Scene EMAIL = null;
        public static final Scene MESSENGER = null;
        public static final Scene SEARCH = null;
        public static final Scene UNKNOWN = null;
        public static final Scene VC = null;
        private final int value;

        static {
            Scene r100 = new Scene("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Scene r101 = new Scene("MESSENGER", 1, 1);
            MESSENGER = r101;
            Scene r102 = new Scene(CommonConstant.RETKEY.EMAIL, 2, 2);
            EMAIL = r102;
            Scene r103 = new Scene("DOCS", 3, 3);
            DOCS = r103;
            Scene r104 = new Scene("BROWSER", 4, 4);
            BROWSER = r104;
            Scene r105 = new Scene("VC", 5, 5);
            VC = r105;
            Scene r110 = new Scene("SEARCH", 6, 6);
            SEARCH = r110;
            $VALUES = new Scene[]{r100, r101, r102, r103, r104, r105, r110};
            ADAPTER = ProtoAdapter.newEnumAdapter(Scene.class);
        }

        public static Scene[] values() {
            return (Scene[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Scene fromValue(int r100) {
            switch(r100) {
                case 0: goto L18;
                case 1: goto L16;
                case 2: goto L14;
                case 3: goto L12;
                case 4: goto L10;
                case 5: goto L8;
                case 6: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return SEARCH;
        L8:
            return VC;
        L10:
            return BROWSER;
        L12:
            return DOCS;
        L14:
            return EMAIL;
        L16:
            return MESSENGER;
        L18:
            return UNKNOWN;
        }

        public static Scene valueOf(String r100) {
            return (Scene) a.a(Scene.class, r100);
        }

        private Scene(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetEnterpriseTopicRequest();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mscene = this.mscene;
        r100.mquery = this.mquery;
        r100.mlocale = this.mlocale;
        r100.mabbr_id = this.mabbr_id;
        r100.mmethod = this.mmethod;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetEnterpriseTopicRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetEnterpriseTopicRequest(Scene r100, String r101, String r110, String r111, Method r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public GetEnterpriseTopicRequest(Scene r100, String r101, String r102, String r103, Method r104, ByteString r105) {
        super(ADAPTER, r105);
        this.mscene = r100;
        this.mquery = r101;
        this.mlocale = r102;
        this.mabbr_id = r103;
        this.mmethod = r104;
    }
}
