package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class FetchQuickActionsResponse extends Message<FetchQuickActionsResponse, Builder> {
    public static final ProtoAdapter<FetchQuickActionsResponse> ADAPTER = null;
    public static final String DEFAULT_MESSAGE = "";
    public static final String DEFAULT_ROUND_ID = "";
    public static final Long DEFAULT_STATUS = null;
    private static final long serialVersionUID = 0;
    public final String mmessage;
    public final List<QuickAction> mquick_actions;
    public final String mround_id;
    public final Long mstatus;

    public static final class Builder extends Message.Builder<FetchQuickActionsResponse, Builder> {
        public String mmessage;
        public List<QuickAction> mquick_actions;
        public String mround_id;
        public Long mstatus;

        @Override // com.squareup.wire.Message.Builder
        public FetchQuickActionsResponse build() {
            return new FetchQuickActionsResponse(this.mstatus, this.mmessage, this.mquick_actions, this.mround_id, super.buildUnknownFields());
        }

        public Builder() {
            this.mquick_actions = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder message(String r100) {
            this.mmessage = r100;
            return this;
        }

        public Builder quick_actions(List<QuickAction> r100) {
            Internal.checkElementsNotNull(r100);
            this.mquick_actions = r100;
            return this;
        }

        public Builder round_id(String r100) {
            this.mround_id = r100;
            return this;
        }

        public Builder status(Long r100) {
            this.mstatus = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FetchQuickActionsResponse extends ProtoAdapter<FetchQuickActionsResponse> {
        public ProtoAdapter_FetchQuickActionsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, FetchQuickActionsResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FetchQuickActionsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mstatus = 0L;
            r101.mmessage = "";
            r101.mround_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mstatus = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mmessage = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mquick_actions.add(QuickAction.ADAPTER.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mround_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FetchQuickActionsResponse r100) {
            Long r101 = r100.mstatus;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mmessage;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = (r103 + r105) + QuickAction.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.mquick_actions);
            String r107 = r100.mround_id;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r107);
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
        public /* bridge */ /* synthetic */ FetchQuickActionsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FetchQuickActionsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FetchQuickActionsResponse r101) throws IOException {
            Long r102 = r101.mstatus;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mmessage;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            QuickAction.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.mquick_actions);
            String r104 = r101.mround_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FetchQuickActionsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FetchQuickActionsResponse();
        DEFAULT_STATUS = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mstatus = this.mstatus;
        r100.mmessage = this.mmessage;
        r100.mquick_actions = Internal.copyOf("mquick_actions", this.mquick_actions);
        r100.mround_id = this.mround_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FetchQuickActionsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FetchQuickActionsResponse(Long r100, String r101, List<QuickAction> r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public FetchQuickActionsResponse(Long r100, String r101, List<QuickAction> r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mstatus = r100;
        this.mmessage = r101;
        this.mquick_actions = Internal.immutableCopyOf("mquick_actions", r102);
        this.mround_id = r103;
    }
}
