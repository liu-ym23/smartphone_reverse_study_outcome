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
import okio.ByteString;

/* JADX INFO: loaded from: classes36.dex */
public final class HeartbeatPacket extends AndroidMessage<HeartbeatPacket, Builder> {
    public static final ProtoAdapter<HeartbeatPacket> ADAPTER = null;
    public static final Parcelable.Creator<HeartbeatPacket> CREATOR = null;
    public static final Long DEFAULT_ROOMID = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    public final Long roomID;

    @WireField(adapter = "com.ss.ugc.live.sdk.msg.HeartbeatPacket$WrdsKeyVersion#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<WrdsKeyVersion> wrdsKeyVersions;

    public static final class Builder extends Message.Builder<HeartbeatPacket, Builder> {
        public Long roomID;
        public List<WrdsKeyVersion> wrdsKeyVersions;

        @Override // com.squareup.wire.Message.Builder
        public HeartbeatPacket build() {
            return new HeartbeatPacket(this.wrdsKeyVersions, this.roomID, super.buildUnknownFields());
        }

        public Builder() {
            this.roomID = 0L;
            this.wrdsKeyVersions = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder roomID(Long r100) {
            this.roomID = r100;
            return this;
        }

        public Builder wrdsKeyVersions(List<WrdsKeyVersion> r100) {
            Internal.checkElementsNotNull(r100);
            this.wrdsKeyVersions = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_HeartbeatPacket extends ProtoAdapter<HeartbeatPacket> {
        public ProtoAdapter_HeartbeatPacket() {
            super(FieldEncoding.LENGTH_DELIMITED, HeartbeatPacket.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public HeartbeatPacket decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.wrdsKeyVersions.add(WrdsKeyVersion.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.roomID(ProtoAdapter.INT64.decode(r100));
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
        public int encodedSize2(HeartbeatPacket r100) {
            return (WrdsKeyVersion.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.wrdsKeyVersions) + ProtoAdapter.INT64.encodedSizeWithTag(2, r100.roomID)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public HeartbeatPacket redact2(HeartbeatPacket r100) {
            Builder r101 = r100.newBuilder();
            Internal.redactElements(r101.wrdsKeyVersions, WrdsKeyVersion.ADAPTER);
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ HeartbeatPacket decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(HeartbeatPacket r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ HeartbeatPacket redact(HeartbeatPacket r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, HeartbeatPacket r101) throws IOException {
            WrdsKeyVersion.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.wrdsKeyVersions);
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r101.roomID);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, HeartbeatPacket r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class WrdsKeyVersion extends AndroidMessage<WrdsKeyVersion, Builder> {
        public static final ProtoAdapter<WrdsKeyVersion> ADAPTER = null;
        public static final Parcelable.Creator<WrdsKeyVersion> CREATOR = null;
        public static final String DEFAULT_SYNCKEY = "";
        public static final Long DEFAULT_VERSION = null;
        private static final long serialVersionUID = 0;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
        public final String syncKey;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
        public final Long version;

        public static final class Builder extends Message.Builder<WrdsKeyVersion, Builder> {
            public String syncKey;
            public Long version;

            @Override // com.squareup.wire.Message.Builder
            public WrdsKeyVersion build() {
                return new WrdsKeyVersion(this.syncKey, this.version, super.buildUnknownFields());
            }

            public Builder() {
                this.syncKey = "";
                this.version = 0L;
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder syncKey(String r100) {
                this.syncKey = r100;
                return this;
            }

            public Builder version(Long r100) {
                this.version = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_WrdsKeyVersion extends ProtoAdapter<WrdsKeyVersion> {
            public ProtoAdapter_WrdsKeyVersion() {
                super(FieldEncoding.LENGTH_DELIMITED, WrdsKeyVersion.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public WrdsKeyVersion decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.syncKey(ProtoAdapter.STRING.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.version(ProtoAdapter.INT64.decode(r100));
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
            public int encodedSize2(WrdsKeyVersion r100) {
                return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.syncKey) + ProtoAdapter.INT64.encodedSizeWithTag(2, r100.version)) + r100.unknownFields().size();
            }

            /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
            public WrdsKeyVersion redact2(WrdsKeyVersion r100) {
                Builder r101 = r100.newBuilder();
                r101.clearUnknownFields();
                return r101.build();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ WrdsKeyVersion decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(WrdsKeyVersion r100) {
                return encodedSize2(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ WrdsKeyVersion redact(WrdsKeyVersion r100) {
                return redact2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, WrdsKeyVersion r101) throws IOException {
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.syncKey);
                ProtoAdapter.INT64.encodeWithTag(r100, 2, r101.version);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, WrdsKeyVersion r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ProtoAdapter_WrdsKeyVersion r100 = new ProtoAdapter_WrdsKeyVersion();
            ADAPTER = r100;
            CREATOR = AndroidMessage.newCreator(r100);
            DEFAULT_VERSION = 0L;
        }

        public int hashCode() {
            int r100 = this.hashCode;
            if (r100 != 0) goto L13;
            int r101 = unknownFields().hashCode() * 37;
            String r102 = this.syncKey;
            int r103 = 0;
            if (r102 == null) goto L7;
            int r104 = r102.hashCode();
        L8:
            int r105 = (r101 + r104) * 37;
            Long r106 = this.version;
            if (r106 == null) goto L11;
            r103 = r106.hashCode();
        L11:
            int r107 = r105 + r103;
            this.hashCode = r107;
            return r107;
        L7:
            r104 = 0;
            goto L8
        L13:
            return r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.syncKey = this.syncKey;
            r100.version = this.version;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            StringBuilder r100 = new StringBuilder();
            if (this.syncKey == null) goto L6;
            r100.append(", syncKey=");
            r100.append(this.syncKey);
        L6:
            if (this.version == null) goto L8;
            r100.append(", version=");
            r100.append(this.version);
        L8:
            StringBuilder r101 = r100.replace(0, 2, "WrdsKeyVersion{");
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
            if ((r100 instanceof WrdsKeyVersion) == true) goto L8;
            return false;
        L8:
            WrdsKeyVersion r101 = (WrdsKeyVersion) r100;
            if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
        L15:
            return false;
        L11:
            if (Internal.equals(this.syncKey, r101.syncKey) == false) goto L15;
            if (Internal.equals(this.version, r101.version) == false) goto L15;
            return true;
        }

        public WrdsKeyVersion(String r100, Long r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public WrdsKeyVersion(String r100, Long r101, ByteString r102) {
            super(ADAPTER, r102);
            this.syncKey = r100;
            this.version = r101;
        }
    }

    static {
        ProtoAdapter_HeartbeatPacket r100 = new ProtoAdapter_HeartbeatPacket();
        ADAPTER = r100;
        CREATOR = AndroidMessage.newCreator(r100);
        DEFAULT_ROOMID = 0L;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L10;
        int r101 = ((unknownFields().hashCode() * 37) + this.wrdsKeyVersions.hashCode()) * 37;
        Long r102 = this.roomID;
        if (r102 == null) goto L7;
        int r103 = r102.hashCode();
    L8:
        int r104 = r101 + r103;
        this.hashCode = r104;
        return r104;
    L7:
        r103 = 0;
        goto L8
    L10:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.wrdsKeyVersions = Internal.copyOf("wrdsKeyVersions", this.wrdsKeyVersions);
        r100.roomID = this.roomID;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        List<WrdsKeyVersion> r101 = this.wrdsKeyVersions;
        if (r101 == null) goto L8;
        if (r101.isEmpty() == true) goto L8;
        r100.append(", wrdsKeyVersions=");
        r100.append(this.wrdsKeyVersions);
    L8:
        if (this.roomID == null) goto L10;
        r100.append(", roomID=");
        r100.append(this.roomID);
    L10:
        StringBuilder r102 = r100.replace(0, 2, "HeartbeatPacket{");
        r102.append('}');
        return r102.toString();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof HeartbeatPacket) == true) goto L8;
        return false;
    L8:
        HeartbeatPacket r101 = (HeartbeatPacket) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L15:
        return false;
    L11:
        if (this.wrdsKeyVersions.equals(r101.wrdsKeyVersions) == false) goto L15;
        if (Internal.equals(this.roomID, r101.roomID) == false) goto L15;
        return true;
    }

    public HeartbeatPacket(List<WrdsKeyVersion> r100, Long r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public HeartbeatPacket(List<WrdsKeyVersion> r100, Long r101, ByteString r102) {
        super(ADAPTER, r102);
        this.wrdsKeyVersions = Internal.immutableCopyOf("wrdsKeyVersions", r100);
        this.roomID = r101;
    }
}
