package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class SaveTodoDraftRequest extends Message<SaveTodoDraftRequest, Builder> {
    public static final ProtoAdapter<SaveTodoDraftRequest> ADAPTER = null;
    public static final ProtoAdapter_SaveTodoDraftRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final DraftScene scene;
    public final Todo todo;

    public static final class Builder extends Message.Builder<SaveTodoDraftRequest, Builder> implements d<SaveTodoDraftRequest> {
        public DraftScene scene;
        public Todo todo;

        @Override // com.squareup.wire.Message.Builder
        public SaveTodoDraftRequest build() {
            return new SaveTodoDraftRequest(this.todo, this.scene, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder scene(DraftScene r100) {
            this.scene = r100;
            return this;
        }

        public Builder todo(Todo r100) {
            this.todo = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SaveTodoDraftRequest extends ProtoAdapter<SaveTodoDraftRequest> implements c<SaveTodoDraftRequest> {
        public ProtoAdapter_SaveTodoDraftRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SaveTodoDraftRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SaveTodoDraftRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.todo = Todo.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.scene = DraftScene.ADAPTER.decode(r100);
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
        public int encodedSize2(SaveTodoDraftRequest r100) {
            Todo r101 = r100.todo;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Todo.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            DraftScene r104 = r100.scene;
            if (r104 == null) goto L10;
            r102 = DraftScene.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SaveTodoDraftRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SaveTodoDraftRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SaveTodoDraftRequest r101) throws IOException {
            Todo r102 = r101.todo;
            if (r102 == null) goto L5;
            Todo.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            DraftScene r103 = r101.scene;
            if (r103 == null) goto L8;
            DraftScene.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SaveTodoDraftRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SaveTodoDraftRequest r100 = new ProtoAdapter_SaveTodoDraftRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.todo = this.todo;
        r100.scene = this.scene;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SaveTodoDraftRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SaveTodoDraftRequest(Todo r100, DraftScene r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public SaveTodoDraftRequest(Todo r100, DraftScene r101, ByteString r102) {
        super(ADAPTER, r102);
        this.todo = r100;
        this.scene = r101;
    }
}
