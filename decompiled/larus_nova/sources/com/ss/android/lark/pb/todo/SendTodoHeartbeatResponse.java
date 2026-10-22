package com.ss.android.lark.pb.todo;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class SendTodoHeartbeatResponse extends Message<SendTodoHeartbeatResponse, Builder> {
    public static final ProtoAdapter<SendTodoHeartbeatResponse> ADAPTER = null;
    public static final Boolean DEFAULT_SHOW_OPEN_MEEGO_TIP = null;
    public static final Boolean DEFAULT_SHOW_SYNC_FROM_MEEGO = null;
    public static final Boolean DEFAULT_SYNC_FROM_MEEGO = null;
    private static final long serialVersionUID = 0;
    public final Boolean mshow_open_meego_tip;
    public final Boolean mshow_sync_from_meego;
    public final Boolean msync_from_meego;

    public static final class Builder extends Message.Builder<SendTodoHeartbeatResponse, Builder> {
        public Boolean mshow_open_meego_tip;
        public Boolean mshow_sync_from_meego;
        public Boolean msync_from_meego;

        @Override // com.squareup.wire.Message.Builder
        public SendTodoHeartbeatResponse build() {
            return new SendTodoHeartbeatResponse(this.msync_from_meego, this.mshow_open_meego_tip, this.mshow_sync_from_meego, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder show_open_meego_tip(Boolean r100) {
            this.mshow_open_meego_tip = r100;
            return this;
        }

        public Builder show_sync_from_meego(Boolean r100) {
            this.mshow_sync_from_meego = r100;
            return this;
        }

        public Builder sync_from_meego(Boolean r100) {
            this.msync_from_meego = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SendTodoHeartbeatResponse extends ProtoAdapter<SendTodoHeartbeatResponse> {
        public ProtoAdapter_SendTodoHeartbeatResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SendTodoHeartbeatResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SendTodoHeartbeatResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.msync_from_meego = r102;
            r101.mshow_open_meego_tip = r102;
            r101.mshow_sync_from_meego = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L15;
            if (r104 != 1) goto L8;
            r101.msync_from_meego = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.mshow_open_meego_tip = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L11;
            r101.mshow_sync_from_meego = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SendTodoHeartbeatResponse r100) {
            Boolean r101 = r100.msync_from_meego;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.mshow_open_meego_tip;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.mshow_sync_from_meego;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SendTodoHeartbeatResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SendTodoHeartbeatResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SendTodoHeartbeatResponse r101) throws IOException {
            Boolean r102 = r101.msync_from_meego;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.mshow_open_meego_tip;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.mshow_sync_from_meego;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SendTodoHeartbeatResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SendTodoHeartbeatResponse();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_SYNC_FROM_MEEGO = r100;
        DEFAULT_SHOW_OPEN_MEEGO_TIP = r100;
        DEFAULT_SHOW_SYNC_FROM_MEEGO = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.msync_from_meego = this.msync_from_meego;
        r100.mshow_open_meego_tip = this.mshow_open_meego_tip;
        r100.mshow_sync_from_meego = this.mshow_sync_from_meego;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SendTodoHeartbeatResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SendTodoHeartbeatResponse(Boolean r100, Boolean r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public SendTodoHeartbeatResponse(Boolean r100, Boolean r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.msync_from_meego = r100;
        this.mshow_open_meego_tip = r101;
        this.mshow_sync_from_meego = r102;
    }
}
