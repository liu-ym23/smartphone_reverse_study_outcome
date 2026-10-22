package com.bytedance.lark.pb.search.v2;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class FacilityMeta extends Message<FacilityMeta, Builder> {
    public static final ProtoAdapter<FacilityMeta> ADAPTER = null;
    public static final String DEFAULT_APP_LINK = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_SOURCE_KEY = "";
    private static final long serialVersionUID = 0;
    public final String app_link;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253713id;
    public final String source_key;

    public static final class Builder extends Message.Builder<FacilityMeta, Builder> {
        public String app_link;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253714id;
        public String source_key;

        @Override // com.squareup.wire.Message.Builder
        public FacilityMeta build() {
            String r100 = this.f253714id;
            if (r100 == null) goto L7;
            return new FacilityMeta(this.f253714id, this.source_key, this.app_link, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_link(String r100) {
            this.app_link = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253714id = r100;
            return this;
        }

        public Builder source_key(String r100) {
            this.source_key = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FacilityMeta extends ProtoAdapter<FacilityMeta> {
        public ProtoAdapter_FacilityMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, FacilityMeta.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FacilityMeta decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253714id = "";
            r101.source_key = "";
            r101.app_link = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.f253714id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.source_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.app_link = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(FacilityMeta r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.f253713id);
            String r103 = r100.source_key;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.app_link;
            if (r107 == null) goto L10;
            r104 = r101.encodedSizeWithTag(3, r107);
        L10:
            return (r106 + r104) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FacilityMeta decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FacilityMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FacilityMeta r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253713id);
            String r103 = r101.source_key;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.app_link;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FacilityMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FacilityMeta();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253714id = this.f253713id;
        r100.source_key = this.source_key;
        r100.app_link = this.app_link;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FacilityMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FacilityMeta(String r100, String r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public FacilityMeta(String r100, String r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.f253713id = r100;
        this.source_key = r101;
        this.app_link = r102;
    }
}
