package com.bytedance.lark.pb.tool.v1;

import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import we6.a;
import we6.b;

/* JADX INFO: loaded from: classes20.dex */
public final class SendSteamLogsRequest extends Message<SendSteamLogsRequest, Builder> {
    public static final ProtoAdapter<SendSteamLogsRequest> ADAPTER = null;
    public static final String DEFAULT_BIZ_ID = "";
    public static final ProtoAdapter_SendSteamLogsRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String biz_id;
    public final SteamGeneral general;
    public final List<SteamSpecial> special;

    public static final class Builder extends Message.Builder<SendSteamLogsRequest, Builder> implements b<SendSteamLogsRequest> {
        public String biz_id;
        public SteamGeneral general;
        public List<SteamSpecial> special;

        @Override // com.squareup.wire.Message.Builder
        public SendSteamLogsRequest build() {
            String r100 = this.biz_id;
            if (r100 == null) goto L7;
            return new SendSteamLogsRequest(this.biz_id, this.general, this.special, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID});
        }

        public Builder() {
            this.special = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder biz_id(String r100) {
            this.biz_id = r100;
            return this;
        }

        public Builder general(SteamGeneral r100) {
            this.general = r100;
            return this;
        }

        public Builder special(List<SteamSpecial> r100) {
            Internal.checkElementsNotNull(r100);
            this.special = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SendSteamLogsRequest extends ProtoAdapter<SendSteamLogsRequest> implements a<SendSteamLogsRequest> {
        public ProtoAdapter_SendSteamLogsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SendSteamLogsRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SendSteamLogsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.biz_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.biz_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.general = SteamGeneral.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.special.add(SteamSpecial.ADAPTER.decode(r100));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SendSteamLogsRequest r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.biz_id);
            SteamGeneral r102 = r100.general;
            if (r102 == null) goto L5;
            int r103 = SteamGeneral.ADAPTER.encodedSizeWithTag(2, r102);
        L7:
            return ((r101 + r103) + SteamSpecial.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.special)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SendSteamLogsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SendSteamLogsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SendSteamLogsRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.biz_id);
            SteamGeneral r102 = r101.general;
            if (r102 == null) goto L5;
            SteamGeneral.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            SteamSpecial.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.special);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SendSteamLogsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class SteamGeneral extends Message<SteamGeneral, Builder> {
        public static final ProtoAdapter<SteamGeneral> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final Map<String, StringList> keys;
        public final Map<String, String> values;

        public static final class Builder extends Message.Builder<SteamGeneral, Builder> {
            public Map<String, StringList> keys;
            public Map<String, String> values;

            @Override // com.squareup.wire.Message.Builder
            public SteamGeneral build() {
                return new SteamGeneral(this.keys, this.values, super.buildUnknownFields());
            }

            public Builder() {
                this.keys = Internal.newMutableMap();
                this.values = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder keys(Map<String, StringList> r100) {
                Internal.checkElementsNotNull(r100);
                this.keys = r100;
                return this;
            }

            public Builder values(Map<String, String> r100) {
                Internal.checkElementsNotNull(r100);
                this.values = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_SteamGeneral extends ProtoAdapter<SteamGeneral> {
            private final ProtoAdapter<Map<String, StringList>> keys;
            private final ProtoAdapter<Map<String, String>> values;

            public ProtoAdapter_SteamGeneral() {
                super(FieldEncoding.LENGTH_DELIMITED, SteamGeneral.class);
                ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                this.keys = ProtoAdapter.newMapAdapter(r100, StringList.ADAPTER);
                this.values = ProtoAdapter.newMapAdapter(r100, r100);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SteamGeneral decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.keys.putAll(this.keys.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.values.putAll(this.values.decode(r100));
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(SteamGeneral r100) {
                return (this.keys.encodedSizeWithTag(1, r100.keys) + this.values.encodedSizeWithTag(2, r100.values)) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ SteamGeneral decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SteamGeneral r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SteamGeneral r101) throws IOException {
                this.keys.encodeWithTag(r100, 1, r101.keys);
                this.values.encodeWithTag(r100, 2, r101.values);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SteamGeneral r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SteamGeneral();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.keys = Internal.copyOf("keys", this.keys);
            r100.values = Internal.copyOf("values", this.values);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SteamGeneral.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public SteamGeneral(Map<String, StringList> r100, Map<String, String> r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public SteamGeneral(Map<String, StringList> r100, Map<String, String> r101, ByteString r102) {
            super(ADAPTER, r102);
            this.keys = Internal.immutableCopyOf("keys", r100);
            this.values = Internal.immutableCopyOf("values", r101);
        }
    }

    public static final class SteamSpecial extends Message<SteamSpecial, Builder> {
        public static final ProtoAdapter<SteamSpecial> ADAPTER = null;
        public static final String DEFAULT_EVENT_ID = "";
        private static final long serialVersionUID = 0;
        public final String event_id;
        public final Map<String, StringList> keys;
        public final Map<String, String> values;

        public static final class Builder extends Message.Builder<SteamSpecial, Builder> {
            public String event_id;
            public Map<String, StringList> keys;
            public Map<String, String> values;

            @Override // com.squareup.wire.Message.Builder
            public SteamSpecial build() {
                String r100 = this.event_id;
                if (r100 == null) goto L7;
                return new SteamSpecial(this.event_id, this.keys, this.values, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "event_id"});
            }

            public Builder() {
                this.keys = Internal.newMutableMap();
                this.values = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder event_id(String r100) {
                this.event_id = r100;
                return this;
            }

            public Builder keys(Map<String, StringList> r100) {
                Internal.checkElementsNotNull(r100);
                this.keys = r100;
                return this;
            }

            public Builder values(Map<String, String> r100) {
                Internal.checkElementsNotNull(r100);
                this.values = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_SteamSpecial extends ProtoAdapter<SteamSpecial> {
            private final ProtoAdapter<Map<String, StringList>> keys;
            private final ProtoAdapter<Map<String, String>> values;

            public ProtoAdapter_SteamSpecial() {
                super(FieldEncoding.LENGTH_DELIMITED, SteamSpecial.class);
                ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                this.keys = ProtoAdapter.newMapAdapter(r100, StringList.ADAPTER);
                this.values = ProtoAdapter.newMapAdapter(r100, r100);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SteamSpecial decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.event_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.event_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.keys.putAll(this.keys.decode(r100));
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.values.putAll(this.values.decode(r100));
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(SteamSpecial r100) {
                return ((ProtoAdapter.STRING.encodedSizeWithTag(1, r100.event_id) + this.keys.encodedSizeWithTag(2, r100.keys)) + this.values.encodedSizeWithTag(3, r100.values)) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ SteamSpecial decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SteamSpecial r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SteamSpecial r101) throws IOException {
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.event_id);
                this.keys.encodeWithTag(r100, 2, r101.keys);
                this.values.encodeWithTag(r100, 3, r101.values);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SteamSpecial r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SteamSpecial();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.event_id = this.event_id;
            r100.keys = Internal.copyOf("keys", this.keys);
            r100.values = Internal.copyOf("values", this.values);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SteamSpecial.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public SteamSpecial(String r100, Map<String, StringList> r101, Map<String, String> r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public SteamSpecial(String r100, Map<String, StringList> r101, Map<String, String> r102, ByteString r103) {
            super(ADAPTER, r103);
            this.event_id = r100;
            this.keys = Internal.immutableCopyOf("keys", r101);
            this.values = Internal.immutableCopyOf("values", r102);
        }
    }

    public static final class StringList extends Message<StringList, Builder> {
        public static final ProtoAdapter<StringList> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> value;

        public static final class Builder extends Message.Builder<StringList, Builder> {
            public List<String> value;

            @Override // com.squareup.wire.Message.Builder
            public StringList build() {
                return new StringList(this.value, super.buildUnknownFields());
            }

            public Builder() {
                this.value = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder value(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.value = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_StringList extends ProtoAdapter<StringList> {
            public ProtoAdapter_StringList() {
                super(FieldEncoding.LENGTH_DELIMITED, StringList.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public StringList decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.value.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(StringList r100) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.value) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ StringList decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(StringList r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, StringList r101) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.value);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, StringList r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_StringList();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.value = Internal.copyOf("value", this.value);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return StringList.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public StringList(List<String> r100) {
            this(r100, ByteString.EMPTY);
        }

        public StringList(List<String> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.value = Internal.immutableCopyOf("value", r100);
        }
    }

    static {
        ProtoAdapter_SendSteamLogsRequest r100 = new ProtoAdapter_SendSteamLogsRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.biz_id = this.biz_id;
        r100.general = this.general;
        r100.special = Internal.copyOf("special", this.special);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SendSteamLogsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SendSteamLogsRequest(String r100, SteamGeneral r101, List<SteamSpecial> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public SendSteamLogsRequest(String r100, SteamGeneral r101, List<SteamSpecial> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.biz_id = r100;
        this.general = r101;
        this.special = Internal.immutableCopyOf("special", r102);
    }
}
