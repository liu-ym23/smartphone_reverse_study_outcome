package lark_biz_feed.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class ViewFlowError extends Message<ViewFlowError, Builder> {
    public static final ProtoAdapter<ViewFlowError> ADAPTER = null;
    public static final Boolean DEFAULT_NO_CONTAINER_HANDLE = null;
    public static final Boolean DEFAULT_VIEW_FLOW_IS_SHUT_DOWN = null;
    private static final long serialVersionUID = 0;
    public final BizError biz;
    public final Boolean no_container_handle;
    public final Boolean view_flow_is_shut_down;

    public static final class Builder extends Message.Builder<ViewFlowError, Builder> {
        public BizError biz;
        public Boolean no_container_handle;
        public Boolean view_flow_is_shut_down;

        @Override // com.squareup.wire.Message.Builder
        public ViewFlowError build() {
            return new ViewFlowError(this.view_flow_is_shut_down, this.no_container_handle, this.biz, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder biz(BizError r100) {
            this.biz = r100;
            this.view_flow_is_shut_down = null;
            this.no_container_handle = null;
            return this;
        }

        public Builder no_container_handle(Boolean r100) {
            this.no_container_handle = r100;
            this.view_flow_is_shut_down = null;
            this.biz = null;
            return this;
        }

        public Builder view_flow_is_shut_down(Boolean r100) {
            this.view_flow_is_shut_down = r100;
            this.no_container_handle = null;
            this.biz = null;
            return this;
        }
    }

    public static final class ProtoAdapter_ViewFlowError extends ProtoAdapter<ViewFlowError> {
        public ProtoAdapter_ViewFlowError() {
            super(FieldEncoding.LENGTH_DELIMITED, ViewFlowError.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public ViewFlowError decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.view_flow_is_shut_down(ProtoAdapter.BOOL.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.no_container_handle(ProtoAdapter.BOOL.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.biz(BizError.ADAPTER.decode(r100));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ViewFlowError r100) {
            Boolean r101 = r100.view_flow_is_shut_down;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.no_container_handle;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            BizError r107 = r100.biz;
            if (r107 == null) goto L14;
            r102 = BizError.ADAPTER.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ ViewFlowError decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ViewFlowError r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ViewFlowError r101) throws IOException {
            Boolean r102 = r101.view_flow_is_shut_down;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.no_container_handle;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            BizError r104 = r101.biz;
            if (r104 == null) goto L11;
            BizError.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ViewFlowError r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ViewFlowError();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_VIEW_FLOW_IS_SHUT_DOWN = r100;
        DEFAULT_NO_CONTAINER_HANDLE = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.view_flow_is_shut_down = this.view_flow_is_shut_down;
        r100.no_container_handle = this.no_container_handle;
        r100.biz = this.biz;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ViewFlowError.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ViewFlowError(Boolean r100, Boolean r101, BizError r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public ViewFlowError(Boolean r100, Boolean r101, BizError r102, ByteString r103) {
        super(ADAPTER, r103);
        if (Internal.countNonNull(r100, r101, r102) > 1) goto L7;
        this.view_flow_is_shut_down = r100;
        this.no_container_handle = r101;
        this.biz = r102;
        return;
    L7:
        throw new IllegalArgumentException("at most one of view_flow_is_shut_down, no_container_handle, biz may be non-null");
    }
}
