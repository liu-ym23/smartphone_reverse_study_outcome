package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.Draft;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PushDraftChange extends Message<PushDraftChange, Builder> {
    public static final ProtoAdapter<PushDraftChange> ADAPTER = null;
    public static final ProtoAdapter_PushDraftChange RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Draft> draft;

    public static final class Builder extends Message.Builder<PushDraftChange, Builder> implements d<PushDraftChange> {
        public List<Draft> draft;

        @Override // com.squareup.wire.Message.Builder
        public PushDraftChange build() {
            return new PushDraftChange(this.draft, super.buildUnknownFields());
        }

        public Builder() {
            this.draft = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder draft(List<Draft> r100) {
            Internal.checkElementsNotNull(r100);
            this.draft = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushDraftChange extends ProtoAdapter<PushDraftChange> implements c<PushDraftChange> {
        public ProtoAdapter_PushDraftChange() {
            super(FieldEncoding.LENGTH_DELIMITED, PushDraftChange.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushDraftChange decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.draft.add(Draft.ADAPTER.decode(r100));
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
        public int encodedSize2(PushDraftChange r100) {
            return Draft.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.draft) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushDraftChange decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushDraftChange r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushDraftChange r101) throws IOException {
            Draft.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.draft);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushDraftChange r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushDraftChange r100 = new ProtoAdapter_PushDraftChange();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.draft = Internal.copyOf("draft", this.draft);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushDraftChange.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushDraftChange(List<Draft> r100) {
        this(r100, ByteString.EMPTY);
    }

    public PushDraftChange(List<Draft> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.draft = Internal.immutableCopyOf("draft", r100);
    }
}
