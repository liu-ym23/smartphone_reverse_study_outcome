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
public final class BitableMorePanelPermission extends Message<BitableMorePanelPermission, Builder> {
    public static final ProtoAdapter<BitableMorePanelPermission> ADAPTER = null;
    public static final Boolean DEFAULT_CAN_CHANGE_WORKSPACE = null;
    public static final Boolean DEFAULT_CAN_MOVE_IN_WORKSPACE = null;
    public static final Boolean DEFAULT_CAN_MOVE_OUT_WORKSPACE = null;
    public static final String DEFAULT_WORKSPACE_NAME = "";
    public static final String DEFAULT_WORKSPACE_TOKEN = "";
    private static final long serialVersionUID = 0;
    public final Boolean can_change_workspace;
    public final Boolean can_move_in_workspace;
    public final Boolean can_move_out_workspace;
    public final String workspace_name;
    public final String workspace_token;

    public static final class Builder extends Message.Builder<BitableMorePanelPermission, Builder> {
        public Boolean can_change_workspace;
        public Boolean can_move_in_workspace;
        public Boolean can_move_out_workspace;
        public String workspace_name;
        public String workspace_token;

        @Override // com.squareup.wire.Message.Builder
        public BitableMorePanelPermission build() {
            Boolean r100 = this.can_change_workspace;
            if (r100 == null) goto L11;
            if (this.can_move_out_workspace == null) goto L11;
            if (this.can_move_in_workspace == null) goto L11;
            return new BitableMorePanelPermission(this.can_change_workspace, this.can_move_out_workspace, this.can_move_in_workspace, this.workspace_token, this.workspace_name, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "can_change_workspace", this.can_move_out_workspace, "can_move_out_workspace", this.can_move_in_workspace, "can_move_in_workspace"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder can_change_workspace(Boolean r100) {
            this.can_change_workspace = r100;
            return this;
        }

        public Builder can_move_in_workspace(Boolean r100) {
            this.can_move_in_workspace = r100;
            return this;
        }

        public Builder can_move_out_workspace(Boolean r100) {
            this.can_move_out_workspace = r100;
            return this;
        }

        public Builder workspace_name(String r100) {
            this.workspace_name = r100;
            return this;
        }

        public Builder workspace_token(String r100) {
            this.workspace_token = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BitableMorePanelPermission extends ProtoAdapter<BitableMorePanelPermission> {
        public ProtoAdapter_BitableMorePanelPermission() {
            super(FieldEncoding.LENGTH_DELIMITED, BitableMorePanelPermission.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public BitableMorePanelPermission decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.can_change_workspace = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.can_move_out_workspace = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.can_move_in_workspace = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.workspace_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.workspace_name = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(BitableMorePanelPermission r100) {
            ProtoAdapter<Boolean> r101 = ProtoAdapter.BOOL;
            int r102 = (r101.encodedSizeWithTag(1, r100.can_change_workspace) + r101.encodedSizeWithTag(2, r100.can_move_out_workspace)) + r101.encodedSizeWithTag(3, r100.can_move_in_workspace);
            String r103 = r100.workspace_token;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(4, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.workspace_name;
            if (r107 == null) goto L10;
            r104 = ProtoAdapter.STRING.encodedSizeWithTag(5, r107);
        L10:
            return (r106 + r104) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BitableMorePanelPermission decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BitableMorePanelPermission r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BitableMorePanelPermission r101) throws IOException {
            ProtoAdapter<Boolean> r102 = ProtoAdapter.BOOL;
            r102.encodeWithTag(r100, 1, r101.can_change_workspace);
            r102.encodeWithTag(r100, 2, r101.can_move_out_workspace);
            r102.encodeWithTag(r100, 3, r101.can_move_in_workspace);
            String r103 = r101.workspace_token;
            if (r103 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r103);
        L5:
            String r104 = r101.workspace_name;
            if (r104 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BitableMorePanelPermission r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BitableMorePanelPermission();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_CAN_CHANGE_WORKSPACE = r100;
        DEFAULT_CAN_MOVE_OUT_WORKSPACE = r100;
        DEFAULT_CAN_MOVE_IN_WORKSPACE = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.can_change_workspace = this.can_change_workspace;
        r100.can_move_out_workspace = this.can_move_out_workspace;
        r100.can_move_in_workspace = this.can_move_in_workspace;
        r100.workspace_token = this.workspace_token;
        r100.workspace_name = this.workspace_name;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BitableMorePanelPermission.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BitableMorePanelPermission(Boolean r100, Boolean r101, Boolean r110, String r111, String r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public BitableMorePanelPermission(Boolean r100, Boolean r101, Boolean r102, String r103, String r104, ByteString r105) {
        super(ADAPTER, r105);
        this.can_change_workspace = r100;
        this.can_move_out_workspace = r101;
        this.can_move_in_workspace = r102;
        this.workspace_token = r103;
        this.workspace_name = r104;
    }
}
