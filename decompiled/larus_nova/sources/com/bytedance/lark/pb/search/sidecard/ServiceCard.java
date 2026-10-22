package com.bytedance.lark.pb.search.sidecard;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ServiceCard extends Message<ServiceCard, Builder> {
    public static final ProtoAdapter<ServiceCard> ADAPTER = null;
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_RENDER_CONTENT = "";
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253683id;
    public final String render_content;

    public static final class Builder extends Message.Builder<ServiceCard, Builder> {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253684id;
        public String render_content;

        @Override // com.squareup.wire.Message.Builder
        public ServiceCard build() {
            String r100 = this.f253684id;
            if (r100 == null) goto L9;
            if (this.render_content == null) goto L9;
            return new ServiceCard(this.f253684id, this.render_content, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "id", this.render_content, "render_content"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder id(String r100) {
            this.f253684id = r100;
            return this;
        }

        public Builder render_content(String r100) {
            this.render_content = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ServiceCard extends ProtoAdapter<ServiceCard> {
        public ProtoAdapter_ServiceCard() {
            super(FieldEncoding.LENGTH_DELIMITED, ServiceCard.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ServiceCard decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253684id = "";
            r101.render_content = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.f253684id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.render_content = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(ServiceCard r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (r101.encodedSizeWithTag(1, r100.f253683id) + r101.encodedSizeWithTag(2, r100.render_content)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ServiceCard decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ServiceCard r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ServiceCard r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253683id);
            r102.encodeWithTag(r100, 2, r101.render_content);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ServiceCard r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ServiceCard();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253684id = this.f253683id;
        r100.render_content = this.render_content;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ServiceCard.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ServiceCard(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public ServiceCard(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.f253683id = r100;
        this.render_content = r101;
    }
}
