package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.ss.android.lark.pb.entities.ThreadState;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PullAIChatModeThreadResponse extends Message<PullAIChatModeThreadResponse, Builder> {
    public static final ProtoAdapter<PullAIChatModeThreadResponse> ADAPTER = null;
    public static final Boolean DEFAULT_SCENE_USABLE = null;
    private static final long serialVersionUID = 0;
    public final Boolean mscene_usable;
    public final ThreadState mstatus;

    public static final class Builder extends Message.Builder<PullAIChatModeThreadResponse, Builder> {
        public Boolean mscene_usable;
        public ThreadState mstatus;

        @Override // com.squareup.wire.Message.Builder
        public PullAIChatModeThreadResponse build() {
            return new PullAIChatModeThreadResponse(this.mstatus, this.mscene_usable, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder scene_usable(Boolean r100) {
            this.mscene_usable = r100;
            return this;
        }

        public Builder status(ThreadState r100) {
            this.mstatus = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PullAIChatModeThreadResponse extends ProtoAdapter<PullAIChatModeThreadResponse> {
        public ProtoAdapter_PullAIChatModeThreadResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullAIChatModeThreadResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullAIChatModeThreadResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mscene_usable = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mstatus = ThreadState.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mscene_usable = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PullAIChatModeThreadResponse r100) {
            ThreadState r101 = r100.mstatus;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ThreadState.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.mscene_usable;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PullAIChatModeThreadResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullAIChatModeThreadResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullAIChatModeThreadResponse r101) throws IOException {
            ThreadState r102 = r101.mstatus;
            if (r102 == null) goto L5;
            ThreadState.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.mscene_usable;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullAIChatModeThreadResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullAIChatModeThreadResponse();
        DEFAULT_SCENE_USABLE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mstatus = this.mstatus;
        r100.mscene_usable = this.mscene_usable;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullAIChatModeThreadResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullAIChatModeThreadResponse(ThreadState r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PullAIChatModeThreadResponse(ThreadState r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mstatus = r100;
        this.mscene_usable = r101;
    }
}
