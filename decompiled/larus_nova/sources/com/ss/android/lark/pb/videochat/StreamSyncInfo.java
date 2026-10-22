package com.ss.android.lark.pb.videochat;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class StreamSyncInfo extends Message<StreamSyncInfo, Builder> {
    public static final ProtoAdapter<StreamSyncInfo> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final SIStreamSyncInfo msiInfo;

    public static final class Builder extends Message.Builder<StreamSyncInfo, Builder> {
        public SIStreamSyncInfo msiInfo;

        @Override // com.squareup.wire.Message.Builder
        public StreamSyncInfo build() {
            return new StreamSyncInfo(this.msiInfo, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder siInfo(SIStreamSyncInfo r100) {
            this.msiInfo = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_StreamSyncInfo extends ProtoAdapter<StreamSyncInfo> {
        public ProtoAdapter_StreamSyncInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, StreamSyncInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public StreamSyncInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.siInfo(SIStreamSyncInfo.ADAPTER.decode(r100));
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
        public int encodedSize2(StreamSyncInfo r100) {
            SIStreamSyncInfo r101 = r100.msiInfo;
            if (r101 == null) goto L5;
            int r102 = SIStreamSyncInfo.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ StreamSyncInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(StreamSyncInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, StreamSyncInfo r101) throws IOException {
            SIStreamSyncInfo r102 = r101.msiInfo;
            if (r102 == null) goto L5;
            SIStreamSyncInfo.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, StreamSyncInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_StreamSyncInfo();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.msiInfo = this.msiInfo;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return StreamSyncInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public StreamSyncInfo(SIStreamSyncInfo r100) {
        this(r100, ByteString.EMPTY);
    }

    public StreamSyncInfo(SIStreamSyncInfo r100, ByteString r101) {
        super(ADAPTER, r101);
        this.msiInfo = r100;
    }
}
