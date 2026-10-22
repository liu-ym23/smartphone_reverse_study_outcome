package com.ss.ugc.live.sdk.platform.bytelink.data.idl;

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
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes36.dex */
public final class PublisherInfo extends AndroidMessage<PublisherInfo, Builder> {
    public static final ProtoAdapter<PublisherInfo> ADAPTER = null;
    public static final Parcelable.Creator<PublisherInfo> CREATOR = null;
    public static final Long DEFAULT_CLIENT_VISIBLE_ROOM_ID = null;
    public static final Integer DEFAULT_DISTRIBUTION_SCENE = null;
    public static final Long DEFAULT_FEED_TIME_MS = null;
    public static final String DEFAULT_PUBLISHER_ID = "";
    public static final Long DEFAULT_USER_ID = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 5)
    public final Long client_visible_room_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer distribution_scene;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 100)
    public final Map<String, String> extra_info;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    public final Long feed_time_ms;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String publisher_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    public final Long user_id;

    public static final class Builder extends Message.Builder<PublisherInfo, Builder> {
        public Long client_visible_room_id;
        public Integer distribution_scene;
        public Map<String, String> extra_info;
        public Long feed_time_ms;
        public String publisher_id;
        public Long user_id;

        @Override // com.squareup.wire.Message.Builder
        public PublisherInfo build() {
            return new PublisherInfo(this.publisher_id, this.user_id, this.distribution_scene, this.feed_time_ms, this.client_visible_room_id, this.extra_info, super.buildUnknownFields());
        }

        public Builder() {
            this.publisher_id = "";
            this.user_id = 0L;
            this.distribution_scene = 0;
            this.feed_time_ms = 0L;
            this.client_visible_room_id = 0L;
            this.extra_info = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder client_visible_room_id(Long r100) {
            this.client_visible_room_id = r100;
            return this;
        }

        public Builder distribution_scene(Integer r100) {
            this.distribution_scene = r100;
            return this;
        }

        public Builder extra_info(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.extra_info = r100;
            return this;
        }

        public Builder feed_time_ms(Long r100) {
            this.feed_time_ms = r100;
            return this;
        }

        public Builder publisher_id(String r100) {
            this.publisher_id = r100;
            return this;
        }

        public Builder user_id(Long r100) {
            this.user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PublisherInfo extends ProtoAdapter<PublisherInfo> {
        private final ProtoAdapter<Map<String, String>> extra_info;

        public ProtoAdapter_PublisherInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, PublisherInfo.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.extra_info = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PublisherInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.publisher_id(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.user_id(ProtoAdapter.INT64.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.distribution_scene(ProtoAdapter.INT32.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.feed_time_ms(ProtoAdapter.INT64.decode(r100));
            goto L3
        L14:
            if (r103 != 5) goto L16;
            r101.client_visible_room_id(ProtoAdapter.INT64.decode(r100));
            goto L3
        L16:
            if (r103 != 100) goto L17;
            r101.extra_info.putAll(this.extra_info.decode(r100));
            goto L3
        L17:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PublisherInfo r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.publisher_id);
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            return (((((r101 + r102.encodedSizeWithTag(2, r100.user_id)) + ProtoAdapter.INT32.encodedSizeWithTag(3, r100.distribution_scene)) + r102.encodedSizeWithTag(4, r100.feed_time_ms)) + r102.encodedSizeWithTag(5, r100.client_visible_room_id)) + this.extra_info.encodedSizeWithTag(100, r100.extra_info)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public PublisherInfo redact2(PublisherInfo r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PublisherInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PublisherInfo r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PublisherInfo redact(PublisherInfo r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PublisherInfo r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.publisher_id);
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            r102.encodeWithTag(r100, 2, r101.user_id);
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r101.distribution_scene);
            r102.encodeWithTag(r100, 4, r101.feed_time_ms);
            r102.encodeWithTag(r100, 5, r101.client_visible_room_id);
            this.extra_info.encodeWithTag(r100, 100, r101.extra_info);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PublisherInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PublisherInfo r100 = new ProtoAdapter_PublisherInfo();
        ADAPTER = r100;
        CREATOR = AndroidMessage.newCreator(r100);
        DEFAULT_USER_ID = 0L;
        DEFAULT_DISTRIBUTION_SCENE = 0;
        DEFAULT_FEED_TIME_MS = 0L;
        DEFAULT_CLIENT_VISIBLE_ROOM_ID = 0L;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L25;
        int r101 = unknownFields().hashCode() * 37;
        String r102 = this.publisher_id;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        Long r106 = this.user_id;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (r105 + r107) * 37;
        Integer r109 = this.distribution_scene;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L16:
        int r111 = (r108 + r110) * 37;
        Long r112 = this.feed_time_ms;
        if (r112 == null) goto L19;
        int r113 = r112.hashCode();
    L20:
        int r114 = (r111 + r113) * 37;
        Long r115 = this.client_visible_room_id;
        if (r115 == null) goto L23;
        r103 = r115.hashCode();
    L23:
        int r116 = ((r114 + r103) * 37) + this.extra_info.hashCode();
        this.hashCode = r116;
        return r116;
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
    L25:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.publisher_id = this.publisher_id;
        r100.user_id = this.user_id;
        r100.distribution_scene = this.distribution_scene;
        r100.feed_time_ms = this.feed_time_ms;
        r100.client_visible_room_id = this.client_visible_room_id;
        r100.extra_info = Internal.copyOf("extra_info", this.extra_info);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.publisher_id == null) goto L6;
        r100.append(", publisher_id=");
        r100.append(this.publisher_id);
    L6:
        if (this.user_id == null) goto L9;
        r100.append(", user_id=");
        r100.append(this.user_id);
    L9:
        if (this.distribution_scene == null) goto L12;
        r100.append(", distribution_scene=");
        r100.append(this.distribution_scene);
    L12:
        if (this.feed_time_ms == null) goto L15;
        r100.append(", feed_time_ms=");
        r100.append(this.feed_time_ms);
    L15:
        if (this.client_visible_room_id == null) goto L17;
        r100.append(", client_visible_room_id=");
        r100.append(this.client_visible_room_id);
    L17:
        Map<String, String> r101 = this.extra_info;
        if (r101 != null) goto L20;
    L22:
        StringBuilder r102 = r100.replace(0, 2, "PublisherInfo{");
        r102.append('}');
        return r102.toString();
    L20:
        if (r101.isEmpty() == true) goto L22;
        r100.append(", extra_info=");
        r100.append(this.extra_info);
        goto L22
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof PublisherInfo) == true) goto L8;
        return false;
    L8:
        PublisherInfo r101 = (PublisherInfo) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L23:
        return false;
    L11:
        if (Internal.equals(this.publisher_id, r101.publisher_id) == false) goto L23;
        if (Internal.equals(this.user_id, r101.user_id) == false) goto L23;
        if (Internal.equals(this.distribution_scene, r101.distribution_scene) == false) goto L23;
        if (Internal.equals(this.feed_time_ms, r101.feed_time_ms) == false) goto L23;
        if (Internal.equals(this.client_visible_room_id, r101.client_visible_room_id) == false) goto L23;
        if (this.extra_info.equals(r101.extra_info) == false) goto L23;
        return true;
    }

    public PublisherInfo(String r100, Long r110, Integer r111, Long r112, Long r113, Map<String, String> r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public PublisherInfo(String r100, Long r101, Integer r102, Long r103, Long r104, Map<String, String> r105, ByteString r106) {
        super(ADAPTER, r106);
        this.publisher_id = r100;
        this.user_id = r101;
        this.distribution_scene = r102;
        this.feed_time_ms = r103;
        this.client_visible_room_id = r104;
        this.extra_info = Internal.immutableCopyOf("extra_info", r105);
    }
}
