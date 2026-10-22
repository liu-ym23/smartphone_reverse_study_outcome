package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class UpdateHongbaoRequest extends Message<UpdateHongbaoRequest, Builder> {
    public static final ProtoAdapter<UpdateHongbaoRequest> ADAPTER = null;
    public static final Boolean DEFAULT_CLICKED = null;
    public static final Boolean DEFAULT_GRABBED = null;
    public static final Boolean DEFAULT_GRABBED_FINISH = null;
    public static final HongbaoType DEFAULT_HONGBAO_TYPE = null;
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_EXPIRED = null;
    public static final ProtoAdapter_UpdateHongbaoRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean clicked;
    public final Boolean grabbed;
    public final Boolean grabbed_finish;
    public final HongbaoType hongbao_type;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253665id;
    public final Boolean is_expired;

    public static final class Builder extends Message.Builder<UpdateHongbaoRequest, Builder> implements d<UpdateHongbaoRequest> {
        public Boolean clicked;
        public Boolean grabbed;
        public Boolean grabbed_finish;
        public HongbaoType hongbao_type;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253666id;
        public Boolean is_expired;

        @Override // com.squareup.wire.Message.Builder
        public UpdateHongbaoRequest build() {
            String r100 = this.f253666id;
            if (r100 == null) goto L7;
            return new UpdateHongbaoRequest(this.f253666id, this.clicked, this.grabbed, this.grabbed_finish, this.hongbao_type, this.is_expired, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder clicked(Boolean r100) {
            this.clicked = r100;
            return this;
        }

        public Builder grabbed(Boolean r100) {
            this.grabbed = r100;
            return this;
        }

        public Builder grabbed_finish(Boolean r100) {
            this.grabbed_finish = r100;
            return this;
        }

        public Builder hongbao_type(HongbaoType r100) {
            this.hongbao_type = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253666id = r100;
            return this;
        }

        public Builder is_expired(Boolean r100) {
            this.is_expired = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateHongbaoRequest extends ProtoAdapter<UpdateHongbaoRequest> implements c<UpdateHongbaoRequest> {
        public ProtoAdapter_UpdateHongbaoRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateHongbaoRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateHongbaoRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253666id = "";
            Boolean r102 = Boolean.FALSE;
            r101.clicked = r102;
            r101.grabbed = r102;
            r101.grabbed_finish = r102;
            r101.hongbao_type = HongbaoType.NORMAL;
            r101.is_expired = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L16;
            switch(r104) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L18;
                case 6: goto L7;
                default: goto L6;
            };
        L18:
            r101.hongbao_type = HongbaoType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.is_expired = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.grabbed_finish = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.grabbed = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            r101.clicked = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L15:
            r101.f253666id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L16:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UpdateHongbaoRequest r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.f253665id);
            Boolean r102 = r100.clicked;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            Boolean r106 = r100.grabbed;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r106);
        L10:
            int r108 = r105 + r107;
            Boolean r109 = r100.grabbed_finish;
            if (r109 == null) goto L13;
            int r110 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r109);
        L14:
            int r111 = r108 + r110;
            HongbaoType r112 = r100.hongbao_type;
            if (r112 == null) goto L17;
            int r113 = HongbaoType.ADAPTER.encodedSizeWithTag(5, r112);
        L18:
            int r114 = r111 + r113;
            Boolean r115 = r100.is_expired;
            if (r115 == null) goto L22;
            r103 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r115);
        L22:
            return (r114 + r103) + r100.unknownFields().size();
        L17:
            r113 = 0;
            goto L18
        L13:
            r110 = 0;
            goto L14
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpdateHongbaoRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateHongbaoRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateHongbaoRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.f253665id);
            Boolean r102 = r101.clicked;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
        L5:
            Boolean r103 = r101.grabbed;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
        L8:
            Boolean r104 = r101.grabbed_finish;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r104);
        L11:
            HongbaoType r105 = r101.hongbao_type;
            if (r105 == null) goto L14;
            HongbaoType.ADAPTER.encodeWithTag(r100, 5, r105);
        L14:
            Boolean r106 = r101.is_expired;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateHongbaoRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UpdateHongbaoRequest r100 = new ProtoAdapter_UpdateHongbaoRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_CLICKED = r101;
        DEFAULT_GRABBED = r101;
        DEFAULT_GRABBED_FINISH = r101;
        DEFAULT_HONGBAO_TYPE = HongbaoType.NORMAL;
        DEFAULT_IS_EXPIRED = r101;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253666id = this.f253665id;
        r100.clicked = this.clicked;
        r100.grabbed = this.grabbed;
        r100.grabbed_finish = this.grabbed_finish;
        r100.hongbao_type = this.hongbao_type;
        r100.is_expired = this.is_expired;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateHongbaoRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateHongbaoRequest(String r100, Boolean r110, Boolean r111, Boolean r112, HongbaoType r113, Boolean r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public UpdateHongbaoRequest(String r100, Boolean r101, Boolean r102, Boolean r103, HongbaoType r104, Boolean r105, ByteString r106) {
        super(ADAPTER, r106);
        this.f253665id = r100;
        this.clicked = r101;
        this.grabbed = r102;
        this.grabbed_finish = r103;
        this.hongbao_type = r104;
        this.is_expired = r105;
    }
}
