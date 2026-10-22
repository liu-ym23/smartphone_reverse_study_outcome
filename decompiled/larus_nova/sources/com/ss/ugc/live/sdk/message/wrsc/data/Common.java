package com.ss.ugc.live.sdk.message.wrsc.data;

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
import okio.ByteString;

/* JADX INFO: loaded from: classes36.dex */
public final class Common extends AndroidMessage<Common, Builder> {
    public static final ProtoAdapter<Common> ADAPTER = null;
    public static final Parcelable.Creator<Common> CREATOR = null;
    public static final Long DEFAULT_CHANNEL_ID = null;
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final String DEFAULT_METHOD = "";
    public static final Long DEFAULT_MSG_ID = null;
    public static final Long DEFAULT_ROOM_ID = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 21)
    public final Long channel_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    public final Long create_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String method;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    public final Long msg_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 3)
    public final Long room_id;

    public static final class Builder extends Message.Builder<Common, Builder> {
        public Long channel_id;
        public Long create_time;
        public String method;
        public Long msg_id;
        public Long room_id;

        @Override // com.squareup.wire.Message.Builder
        public Common build() {
            return new Common(this.method, this.msg_id, this.room_id, this.create_time, this.channel_id, super.buildUnknownFields());
        }

        public Builder() {
            this.method = "";
            this.msg_id = 0L;
            this.room_id = 0L;
            this.create_time = 0L;
            this.channel_id = 0L;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder channel_id(Long r100) {
            this.channel_id = r100;
            return this;
        }

        public Builder create_time(Long r100) {
            this.create_time = r100;
            return this;
        }

        public Builder method(String r100) {
            this.method = r100;
            return this;
        }

        public Builder msg_id(Long r100) {
            this.msg_id = r100;
            return this;
        }

        public Builder room_id(Long r100) {
            this.room_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Common extends ProtoAdapter<Common> {
        public ProtoAdapter_Common() {
            super(FieldEncoding.LENGTH_DELIMITED, Common.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Common decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.method(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.msg_id(ProtoAdapter.INT64.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.room_id(ProtoAdapter.INT64.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.create_time(ProtoAdapter.INT64.decode(r100));
            goto L3
        L14:
            if (r103 != 21) goto L15;
            r101.channel_id(ProtoAdapter.INT64.decode(r100));
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Common r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.method);
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            return ((((r101 + r102.encodedSizeWithTag(2, r100.msg_id)) + r102.encodedSizeWithTag(3, r100.room_id)) + r102.encodedSizeWithTag(4, r100.create_time)) + r102.encodedSizeWithTag(4, r100.channel_id)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public Common redact2(Common r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Common decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Common r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Common redact(Common r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Common r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.method);
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            r102.encodeWithTag(r100, 2, r101.msg_id);
            r102.encodeWithTag(r100, 3, r101.room_id);
            r102.encodeWithTag(r100, 4, r101.create_time);
            r102.encodeWithTag(r100, 21, r101.channel_id);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Common r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_Common r100 = new ProtoAdapter_Common();
        ADAPTER = r100;
        CREATOR = AndroidMessage.newCreator(r100);
        DEFAULT_MSG_ID = 0L;
        DEFAULT_ROOM_ID = 0L;
        DEFAULT_CREATE_TIME = 0L;
        DEFAULT_CHANNEL_ID = 0L;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L25;
        int r101 = unknownFields().hashCode() * 37;
        String r102 = this.method;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        Long r106 = this.msg_id;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (r105 + r107) * 37;
        Long r109 = this.room_id;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L16:
        int r111 = (r108 + r110) * 37;
        Long r112 = this.create_time;
        if (r112 == null) goto L19;
        int r113 = r112.hashCode();
    L20:
        int r114 = (r111 + r113) * 37;
        Long r115 = this.channel_id;
        if (r115 == null) goto L23;
        r103 = r115.hashCode();
    L23:
        int r116 = r114 + r103;
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
        r100.method = this.method;
        r100.msg_id = this.msg_id;
        r100.room_id = this.room_id;
        r100.create_time = this.create_time;
        r100.channel_id = this.channel_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.method == null) goto L6;
        r100.append(", method=");
        r100.append(this.method);
    L6:
        if (this.msg_id == null) goto L9;
        r100.append(", msg_id=");
        r100.append(this.msg_id);
    L9:
        if (this.room_id == null) goto L12;
        r100.append(", room_id=");
        r100.append(this.room_id);
    L12:
        if (this.create_time == null) goto L15;
        r100.append(", create_time=");
        r100.append(this.create_time);
    L15:
        if (this.channel_id == null) goto L17;
        r100.append(", channel_id=");
        r100.append(this.channel_id);
    L17:
        StringBuilder r101 = r100.replace(0, 2, "Common{");
        r101.append('}');
        return r101.toString();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof Common) == true) goto L8;
        return false;
    L8:
        Common r101 = (Common) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L21:
        return false;
    L11:
        if (Internal.equals(this.method, r101.method) == false) goto L21;
        if (Internal.equals(this.msg_id, r101.msg_id) == false) goto L21;
        if (Internal.equals(this.room_id, r101.room_id) == false) goto L21;
        if (Internal.equals(this.create_time, r101.create_time) == false) goto L21;
        if (Internal.equals(this.channel_id, r101.channel_id) == false) goto L21;
        return true;
    }

    public Common(String r100, Long r101, Long r110, Long r111, Long r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public Common(String r100, Long r101, Long r102, Long r103, Long r104, ByteString r105) {
        super(ADAPTER, r105);
        this.method = r100;
        this.msg_id = r101;
        this.room_id = r102;
        this.create_time = r103;
        this.channel_id = r104;
    }
}
