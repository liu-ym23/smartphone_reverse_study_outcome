package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class QuickActionInfo extends com.squareup.wire.Message<QuickActionInfo, Builder> {
    public static final ProtoAdapter<QuickActionInfo> ADAPTER = null;
    public static final String DEFAULT_ACTION_ID = "";
    public static final Integer DEFAULT_ACTION_TYPE = null;
    public static final String DEFAULT_CALLER = "";
    private static final long serialVersionUID = 0;
    public final String action_id;
    public final Integer action_type;
    public final String caller;
    public final Map<String, String> input_map;

    public static final class Builder extends com.squareup.wire.Message.Builder<QuickActionInfo, Builder> {
        public String action_id;
        public Integer action_type;
        public String caller;
        public Map<String, String> input_map;

        @Override // com.squareup.wire.Message.Builder
        public QuickActionInfo build() {
            String r100 = this.caller;
            if (r100 == null) goto L7;
            return new QuickActionInfo(this.action_id, this.input_map, this.caller, this.action_type, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "caller"});
        }

        public Builder() {
            this.input_map = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder action_id(String r100) {
            this.action_id = r100;
            return this;
        }

        public Builder action_type(Integer r100) {
            this.action_type = r100;
            return this;
        }

        public Builder caller(String r100) {
            this.caller = r100;
            return this;
        }

        public Builder input_map(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.input_map = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_QuickActionInfo extends ProtoAdapter<QuickActionInfo> {
        private final ProtoAdapter<Map<String, String>> input_map;

        public ProtoAdapter_QuickActionInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, QuickActionInfo.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.input_map = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public QuickActionInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.action_id = "";
            r101.caller = "";
            r101.action_type = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.action_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.input_map.putAll(this.input_map.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.caller = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.action_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(QuickActionInfo r100) {
            String r101 = r100.action_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            int r104 = (r103 + this.input_map.encodedSizeWithTag(2, r100.input_map)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r100.caller);
            Integer r105 = r100.action_type;
            if (r105 == null) goto L10;
            r102 = ProtoAdapter.INT32.encodedSizeWithTag(4, r105);
        L10:
            return (r104 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ QuickActionInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(QuickActionInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, QuickActionInfo r101) throws IOException {
            String r102 = r101.action_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            this.input_map.encodeWithTag(r100, 2, r101.input_map);
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r101.caller);
            Integer r103 = r101.action_type;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, QuickActionInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_QuickActionInfo();
        DEFAULT_ACTION_TYPE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.action_id = this.action_id;
        r100.input_map = Internal.copyOf("input_map", this.input_map);
        r100.caller = this.caller;
        r100.action_type = this.action_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return QuickActionInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public QuickActionInfo(String r100, Map<String, String> r101, String r102, Integer r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public QuickActionInfo(String r100, Map<String, String> r101, String r102, Integer r103, ByteString r104) {
        super(ADAPTER, r104);
        this.action_id = r100;
        this.input_map = Internal.immutableCopyOf("input_map", r101);
        this.caller = r102;
        this.action_type = r103;
    }
}
