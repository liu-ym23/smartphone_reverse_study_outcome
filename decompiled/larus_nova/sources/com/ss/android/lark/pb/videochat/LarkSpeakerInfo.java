package com.ss.android.lark.pb.videochat;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class LarkSpeakerInfo extends Message<LarkSpeakerInfo, Builder> {
    public static final ProtoAdapter<LarkSpeakerInfo> ADAPTER = null;
    public static final String DEFAULT_DEPARTMENT = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    public final Image mavatar;
    public final String mdepartment;
    public final String mid;
    public final String mname;

    public static final class Builder extends Message.Builder<LarkSpeakerInfo, Builder> {
        public Image mavatar;
        public String mdepartment;
        public String mid;
        public String mname;

        @Override // com.squareup.wire.Message.Builder
        public LarkSpeakerInfo build() {
            String r100 = this.mid;
            if (r100 == null) goto L13;
            if (this.mname == null) goto L13;
            if (this.mdepartment == null) goto L13;
            if (this.mavatar == null) goto L13;
            return new LarkSpeakerInfo(this.mid, this.mname, this.mdepartment, this.mavatar, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "mid", this.mname, "mname", this.mdepartment, "mdepartment", this.mavatar, "mavatar"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder avatar(Image r100) {
            this.mavatar = r100;
            return this;
        }

        public Builder department(String r100) {
            this.mdepartment = r100;
            return this;
        }

        public Builder id(String r100) {
            this.mid = r100;
            return this;
        }

        public Builder name(String r100) {
            this.mname = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_LarkSpeakerInfo extends ProtoAdapter<LarkSpeakerInfo> {
        public ProtoAdapter_LarkSpeakerInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, LarkSpeakerInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public LarkSpeakerInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mid = "";
            r101.mname = "";
            r101.mdepartment = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mname = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mdepartment = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mavatar = Image.ADAPTER.decode(r100);
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
        public int encodedSize2(LarkSpeakerInfo r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (((r101.encodedSizeWithTag(1, r100.mid) + r101.encodedSizeWithTag(2, r100.mname)) + r101.encodedSizeWithTag(3, r100.mdepartment)) + Image.ADAPTER.encodedSizeWithTag(4, r100.mavatar)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ LarkSpeakerInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(LarkSpeakerInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, LarkSpeakerInfo r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.mid);
            r102.encodeWithTag(r100, 2, r101.mname);
            r102.encodeWithTag(r100, 3, r101.mdepartment);
            Image.ADAPTER.encodeWithTag(r100, 4, r101.mavatar);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LarkSpeakerInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LarkSpeakerInfo();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mid = this.mid;
        r100.mname = this.mname;
        r100.mdepartment = this.mdepartment;
        r100.mavatar = this.mavatar;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return LarkSpeakerInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public LarkSpeakerInfo(String r100, String r101, String r102, Image r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public LarkSpeakerInfo(String r100, String r101, String r102, Image r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mid = r100;
        this.mname = r101;
        this.mdepartment = r102;
        this.mavatar = r103;
    }
}
