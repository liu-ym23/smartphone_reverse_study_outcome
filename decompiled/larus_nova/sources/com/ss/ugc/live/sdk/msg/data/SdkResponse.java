package com.ss.ugc.live.sdk.msg.data;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes36.dex */
public final class SdkResponse extends AndroidMessage<SdkResponse, Builder> {
    public static final ProtoAdapter<SdkResponse> ADAPTER = null;
    public static final Parcelable.Creator<SdkResponse> CREATOR = null;
    public static final String DEFAULT_CURSOR = "";
    public static final Long DEFAULT_FETCH_INTERVAL = null;
    public static final Integer DEFAULT_FETCH_TYPE = null;
    public static final Long DEFAULT_HEARTBEAT_DURATION = null;
    public static final Boolean DEFAULT_HISTORY_NO_MORE = null;
    public static final String DEFAULT_INTERNAL_EXT = "";
    public static final String DEFAULT_LIVE_CURSOR = "";
    public static final Boolean DEFAULT_NEED_ACK = null;
    public static final Long DEFAULT_NOW = null;
    public static final String DEFAULT_PROXY_SERVER = "";
    public static final String DEFAULT_PUSH_SERVER = "";
    public static final String DEFAULT_PUSH_SERVER_V2 = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String cursor;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 3)
    public final Long fetch_interval;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 6)
    public final Integer fetch_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 8)
    public final Long heartbeat_duration;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 12)
    public final Boolean history_no_more;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String internal_ext;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final String live_cursor;

    @WireField(adapter = "com.ss.ugc.live.sdk.msg.SdkMessage#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<SdkMessage> messages;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 9)
    public final Boolean need_ack;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    public final Long now;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 13)
    public final String proxy_server;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String push_server;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 14)
    public final String push_server_v2;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final Map<String, String> route_params;

    public static final class Builder extends Message.Builder<SdkResponse, Builder> {
        public String cursor;
        public Long fetch_interval;
        public Integer fetch_type;
        public Long heartbeat_duration;
        public Boolean history_no_more;
        public String internal_ext;
        public String live_cursor;
        public List<SdkMessage> messages;
        public Boolean need_ack;
        public Long now;
        public String proxy_server;
        public String push_server;
        public String push_server_v2;
        public Map<String, String> route_params;

        @Override // com.squareup.wire.Message.Builder
        public SdkResponse build() {
            return new SdkResponse(this.messages, this.cursor, this.fetch_interval, this.now, this.internal_ext, this.fetch_type, this.route_params, this.heartbeat_duration, this.need_ack, this.push_server, this.live_cursor, this.history_no_more, this.proxy_server, this.push_server_v2, super.buildUnknownFields());
        }

        public Builder() {
            this.cursor = "";
            this.fetch_interval = 0L;
            this.now = 0L;
            this.internal_ext = "";
            this.fetch_type = 0;
            this.heartbeat_duration = 0L;
            Boolean r100 = Boolean.FALSE;
            this.need_ack = r100;
            this.push_server = "";
            this.live_cursor = "";
            this.history_no_more = r100;
            this.proxy_server = "";
            this.push_server_v2 = "";
            this.messages = Internal.newMutableList();
            this.route_params = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder cursor(String r100) {
            this.cursor = r100;
            return this;
        }

        public Builder fetch_interval(Long r100) {
            this.fetch_interval = r100;
            return this;
        }

        public Builder fetch_type(Integer r100) {
            this.fetch_type = r100;
            return this;
        }

        public Builder heartbeat_duration(Long r100) {
            this.heartbeat_duration = r100;
            return this;
        }

        public Builder history_no_more(Boolean r100) {
            this.history_no_more = r100;
            return this;
        }

        public Builder internal_ext(String r100) {
            this.internal_ext = r100;
            return this;
        }

        public Builder live_cursor(String r100) {
            this.live_cursor = r100;
            return this;
        }

        public Builder messages(List<SdkMessage> r100) {
            Internal.checkElementsNotNull(r100);
            this.messages = r100;
            return this;
        }

        public Builder need_ack(Boolean r100) {
            this.need_ack = r100;
            return this;
        }

        public Builder now(Long r100) {
            this.now = r100;
            return this;
        }

        public Builder proxy_server(String r100) {
            this.proxy_server = r100;
            return this;
        }

        public Builder push_server(String r100) {
            this.push_server = r100;
            return this;
        }

        public Builder push_server_v2(String r100) {
            this.push_server_v2 = r100;
            return this;
        }

        public Builder route_params(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.route_params = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SdkResponse extends ProtoAdapter<SdkResponse> {
        private final ProtoAdapter<Map<String, String>> route_params;

        public ProtoAdapter_SdkResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SdkResponse.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.route_params = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SdkResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            switch(r103) {
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L15;
                case 7: goto L14;
                case 8: goto L13;
                case 9: goto L12;
                case 10: goto L11;
                case 11: goto L10;
                case 12: goto L9;
                case 13: goto L8;
                case 14: goto L7;
                default: goto L6;
            };
        L7:
            r101.push_server_v2(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            r101.proxy_server(ProtoAdapter.STRING.decode(r100));
            goto L3
        L9:
            r101.history_no_more(ProtoAdapter.BOOL.decode(r100));
            goto L3
        L10:
            r101.live_cursor(ProtoAdapter.STRING.decode(r100));
            goto L3
        L11:
            r101.push_server(ProtoAdapter.STRING.decode(r100));
            goto L3
        L12:
            r101.need_ack(ProtoAdapter.BOOL.decode(r100));
            goto L3
        L13:
            r101.heartbeat_duration(ProtoAdapter.INT64.decode(r100));
            goto L3
        L14:
            r101.route_params.putAll(this.route_params.decode(r100));
            goto L3
        L15:
            r101.fetch_type(ProtoAdapter.INT32.decode(r100));
            goto L3
        L16:
            r101.internal_ext(ProtoAdapter.STRING.decode(r100));
            goto L3
        L17:
            r101.now(ProtoAdapter.INT64.decode(r100));
            goto L3
        L18:
            r101.fetch_interval(ProtoAdapter.INT64.decode(r100));
            goto L3
        L19:
            r101.cursor(ProtoAdapter.STRING.decode(r100));
            goto L3
        L20:
            r101.messages.add(SdkMessage.ADAPTER.decode(r100));
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SdkResponse r100) {
            int r101 = SdkMessage.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.messages);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            int r103 = r101 + r102.encodedSizeWithTag(2, r100.cursor);
            ProtoAdapter<Long> r104 = ProtoAdapter.INT64;
            int r105 = (((((r103 + r104.encodedSizeWithTag(3, r100.fetch_interval)) + r104.encodedSizeWithTag(4, r100.now)) + r102.encodedSizeWithTag(5, r100.internal_ext)) + ProtoAdapter.INT32.encodedSizeWithTag(6, r100.fetch_type)) + this.route_params.encodedSizeWithTag(7, r100.route_params)) + r104.encodedSizeWithTag(8, r100.heartbeat_duration);
            ProtoAdapter<Boolean> r106 = ProtoAdapter.BOOL;
            return ((((((r105 + r106.encodedSizeWithTag(9, r100.need_ack)) + r102.encodedSizeWithTag(10, r100.push_server)) + r102.encodedSizeWithTag(11, r100.live_cursor)) + r106.encodedSizeWithTag(12, r100.history_no_more)) + r102.encodedSizeWithTag(13, r100.proxy_server)) + r102.encodedSizeWithTag(14, r100.push_server_v2)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public SdkResponse redact2(SdkResponse r100) {
            Builder r101 = r100.newBuilder();
            Internal.redactElements(r101.messages, SdkMessage.ADAPTER);
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SdkResponse r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkResponse redact(SdkResponse r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SdkResponse r101) throws IOException {
            SdkMessage.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.messages);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 2, r101.cursor);
            ProtoAdapter<Long> r103 = ProtoAdapter.INT64;
            r103.encodeWithTag(r100, 3, r101.fetch_interval);
            r103.encodeWithTag(r100, 4, r101.now);
            r102.encodeWithTag(r100, 5, r101.internal_ext);
            ProtoAdapter.INT32.encodeWithTag(r100, 6, r101.fetch_type);
            this.route_params.encodeWithTag(r100, 7, r101.route_params);
            r103.encodeWithTag(r100, 8, r101.heartbeat_duration);
            ProtoAdapter<Boolean> r104 = ProtoAdapter.BOOL;
            r104.encodeWithTag(r100, 9, r101.need_ack);
            r102.encodeWithTag(r100, 10, r101.push_server);
            r102.encodeWithTag(r100, 11, r101.live_cursor);
            r104.encodeWithTag(r100, 12, r101.history_no_more);
            r102.encodeWithTag(r100, 13, r101.proxy_server);
            r102.encodeWithTag(r100, 14, r101.push_server_v2);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SdkResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SdkResponse r100 = new ProtoAdapter_SdkResponse();
        ADAPTER = r100;
        CREATOR = AndroidMessage.newCreator(r100);
        DEFAULT_FETCH_INTERVAL = 0L;
        DEFAULT_NOW = 0L;
        DEFAULT_FETCH_TYPE = 0;
        DEFAULT_HEARTBEAT_DURATION = 0L;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_NEED_ACK = r101;
        DEFAULT_HISTORY_NO_MORE = r101;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L53;
        int r101 = ((unknownFields().hashCode() * 37) + this.messages.hashCode()) * 37;
        String r102 = this.cursor;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        Long r106 = this.fetch_interval;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (r105 + r107) * 37;
        Long r109 = this.now;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L16:
        int r111 = (r108 + r110) * 37;
        String r112 = this.internal_ext;
        if (r112 == null) goto L19;
        int r113 = r112.hashCode();
    L20:
        int r114 = (r111 + r113) * 37;
        Integer r115 = this.fetch_type;
        if (r115 == null) goto L23;
        int r116 = r115.hashCode();
    L24:
        int r117 = (((r114 + r116) * 37) + this.route_params.hashCode()) * 37;
        Long r118 = this.heartbeat_duration;
        if (r118 == null) goto L27;
        int r119 = r118.hashCode();
    L28:
        int r120 = (r117 + r119) * 37;
        Boolean r121 = this.need_ack;
        if (r121 == null) goto L31;
        int r122 = r121.hashCode();
    L32:
        int r123 = (r120 + r122) * 37;
        String r124 = this.push_server;
        if (r124 == null) goto L35;
        int r125 = r124.hashCode();
    L36:
        int r126 = (r123 + r125) * 37;
        String r127 = this.live_cursor;
        if (r127 == null) goto L39;
        int r128 = r127.hashCode();
    L40:
        int r129 = (r126 + r128) * 37;
        Boolean r130 = this.history_no_more;
        if (r130 == null) goto L43;
        int r131 = r130.hashCode();
    L44:
        int r132 = (r129 + r131) * 37;
        String r133 = this.proxy_server;
        if (r133 == null) goto L47;
        int r134 = r133.hashCode();
    L48:
        int r135 = (r132 + r134) * 37;
        String r136 = this.push_server_v2;
        if (r136 == null) goto L51;
        r103 = r136.hashCode();
    L51:
        int r137 = r135 + r103;
        this.hashCode = r137;
        return r137;
    L47:
        r134 = 0;
        goto L48
    L43:
        r131 = 0;
        goto L44
    L39:
        r128 = 0;
        goto L40
    L35:
        r125 = 0;
        goto L36
    L31:
        r122 = 0;
        goto L32
    L27:
        r119 = 0;
        goto L28
    L23:
        r116 = 0;
        goto L24
    L19:
        r113 = 0;
        goto L20
    L15:
        r110 = 0;
        goto L16
    L11:
        r107 = 0;
        goto L12
    L7:
        r104 = 0;
        goto L8
    L53:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.messages = Internal.copyOf("messages", this.messages);
        r100.cursor = this.cursor;
        r100.fetch_interval = this.fetch_interval;
        r100.now = this.now;
        r100.internal_ext = this.internal_ext;
        r100.fetch_type = this.fetch_type;
        r100.route_params = Internal.copyOf("route_params", this.route_params);
        r100.heartbeat_duration = this.heartbeat_duration;
        r100.need_ack = this.need_ack;
        r100.push_server = this.push_server;
        r100.live_cursor = this.live_cursor;
        r100.history_no_more = this.history_no_more;
        r100.proxy_server = this.proxy_server;
        r100.push_server_v2 = this.push_server_v2;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        List<SdkMessage> r101 = this.messages;
        if (r101 == null) goto L8;
        if (r101.isEmpty() == true) goto L8;
        r100.append(", messages=");
        r100.append(this.messages);
    L8:
        if (this.cursor == null) goto L11;
        r100.append(", cursor=");
        r100.append(this.cursor);
    L11:
        if (this.fetch_interval == null) goto L14;
        r100.append(", fetch_interval=");
        r100.append(this.fetch_interval);
    L14:
        if (this.now == null) goto L17;
        r100.append(", now=");
        r100.append(this.now);
    L17:
        if (this.internal_ext == null) goto L20;
        r100.append(", internal_ext=");
        r100.append(this.internal_ext);
    L20:
        if (this.fetch_type == null) goto L22;
        r100.append(", fetch_type=");
        r100.append(this.fetch_type);
    L22:
        Map<String, String> r102 = this.route_params;
        if (r102 == null) goto L28;
        if (r102.isEmpty() == true) goto L28;
        r100.append(", route_params=");
        r100.append(this.route_params);
    L28:
        if (this.heartbeat_duration == null) goto L31;
        r100.append(", heartbeat_duration=");
        r100.append(this.heartbeat_duration);
    L31:
        if (this.need_ack == null) goto L34;
        r100.append(", need_ack=");
        r100.append(this.need_ack);
    L34:
        if (this.push_server == null) goto L37;
        r100.append(", push_server=");
        r100.append(this.push_server);
    L37:
        if (this.live_cursor == null) goto L40;
        r100.append(", live_cursor=");
        r100.append(this.live_cursor);
    L40:
        if (this.history_no_more == null) goto L43;
        r100.append(", history_no_more=");
        r100.append(this.history_no_more);
    L43:
        if (this.proxy_server == null) goto L46;
        r100.append(", proxy_server=");
        r100.append(this.proxy_server);
    L46:
        if (this.push_server_v2 == null) goto L48;
        r100.append(", push_server_v2=");
        r100.append(this.push_server_v2);
    L48:
        StringBuilder r103 = r100.replace(0, 2, "SdkResponse{");
        r103.append('}');
        return r103.toString();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof SdkResponse) == true) goto L8;
        return false;
    L8:
        SdkResponse r101 = (SdkResponse) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L39:
        return false;
    L11:
        if (this.messages.equals(r101.messages) == false) goto L39;
        if (Internal.equals(this.cursor, r101.cursor) == false) goto L39;
        if (Internal.equals(this.fetch_interval, r101.fetch_interval) == false) goto L39;
        if (Internal.equals(this.now, r101.now) == false) goto L39;
        if (Internal.equals(this.internal_ext, r101.internal_ext) == false) goto L39;
        if (Internal.equals(this.fetch_type, r101.fetch_type) == false) goto L39;
        if (this.route_params.equals(r101.route_params) == false) goto L39;
        if (Internal.equals(this.heartbeat_duration, r101.heartbeat_duration) == false) goto L39;
        if (Internal.equals(this.need_ack, r101.need_ack) == false) goto L39;
        if (Internal.equals(this.push_server, r101.push_server) == false) goto L39;
        if (Internal.equals(this.live_cursor, r101.live_cursor) == false) goto L39;
        if (Internal.equals(this.history_no_more, r101.history_no_more) == false) goto L39;
        if (Internal.equals(this.proxy_server, r101.proxy_server) == false) goto L39;
        if (Internal.equals(this.push_server_v2, r101.push_server_v2) == false) goto L39;
        return true;
    }

    public SdkResponse(List<SdkMessage> r110, String r111, Long r112, Long r210, String r211, Integer r212, Map<String, String> r213, Long r214, Boolean r215, String r216, String r217, Boolean r218, String r219, String r310) {
        this(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, ByteString.EMPTY);
    }

    public SdkResponse(List<SdkMessage> r100, String r101, Long r102, Long r103, String r104, Integer r105, Map<String, String> r110, Long r111, Boolean r112, String r113, String r114, Boolean r115, String r116, String r117, ByteString r118) {
        super(ADAPTER, r118);
        this.messages = Internal.immutableCopyOf("messages", r100);
        this.cursor = r101;
        this.fetch_interval = r102;
        this.now = r103;
        this.internal_ext = r104;
        this.fetch_type = r105;
        this.route_params = Internal.immutableCopyOf("route_params", r110);
        this.heartbeat_duration = r111;
        this.need_ack = r112;
        this.push_server = r113;
        this.live_cursor = r114;
        this.history_no_more = r115;
        this.proxy_server = r116;
        this.push_server_v2 = r117;
    }
}
