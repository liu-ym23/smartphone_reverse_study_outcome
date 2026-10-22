package lark_bitable.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class BitableWorkspaceMoveResult extends Message<BitableWorkspaceMoveResult, Builder> {
    public static final ProtoAdapter<BitableWorkspaceMoveResult> ADAPTER = null;
    public static final WorkspaceBitableMoveStatus DEFAULT_MOVE_RESULT = null;
    public static final String DEFAULT_MSG = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    public final WorkspaceBitableMoveStatus move_result;
    public final String msg;
    public final String token;

    public static final class Builder extends Message.Builder<BitableWorkspaceMoveResult, Builder> {
        public WorkspaceBitableMoveStatus move_result;
        public String msg;
        public String token;

        @Override // com.squareup.wire.Message.Builder
        public BitableWorkspaceMoveResult build() {
            String r100 = this.token;
            if (r100 == null) goto L11;
            if (this.msg == null) goto L11;
            if (this.move_result == null) goto L11;
            return new BitableWorkspaceMoveResult(this.token, this.msg, this.move_result, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "token", this.msg, "msg", this.move_result, "move_result"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder move_result(WorkspaceBitableMoveStatus r100) {
            this.move_result = r100;
            return this;
        }

        public Builder msg(String r100) {
            this.msg = r100;
            return this;
        }

        public Builder token(String r100) {
            this.token = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BitableWorkspaceMoveResult extends ProtoAdapter<BitableWorkspaceMoveResult> {
        public ProtoAdapter_BitableWorkspaceMoveResult() {
            super(FieldEncoding.LENGTH_DELIMITED, BitableWorkspaceMoveResult.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public BitableWorkspaceMoveResult decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.msg = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.move_result = WorkspaceBitableMoveStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(BitableWorkspaceMoveResult r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return ((r101.encodedSizeWithTag(1, r100.token) + r101.encodedSizeWithTag(2, r100.msg)) + WorkspaceBitableMoveStatus.ADAPTER.encodedSizeWithTag(3, r100.move_result)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BitableWorkspaceMoveResult decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BitableWorkspaceMoveResult r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BitableWorkspaceMoveResult r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.token);
            r102.encodeWithTag(r100, 2, r101.msg);
            WorkspaceBitableMoveStatus.ADAPTER.encodeWithTag(r100, 3, r101.move_result);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BitableWorkspaceMoveResult r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BitableWorkspaceMoveResult();
        DEFAULT_MOVE_RESULT = WorkspaceBitableMoveStatus.VAR_WORKSPACE_BITABLE_MOVE_STATUS_UNSUPPORTED;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.token = this.token;
        r100.msg = this.msg;
        r100.move_result = this.move_result;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BitableWorkspaceMoveResult.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BitableWorkspaceMoveResult(String r100, String r101, WorkspaceBitableMoveStatus r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public BitableWorkspaceMoveResult(String r100, String r101, WorkspaceBitableMoveStatus r102, ByteString r103) {
        super(ADAPTER, r103);
        this.token = r100;
        this.msg = r101;
        this.move_result = r102;
    }
}
