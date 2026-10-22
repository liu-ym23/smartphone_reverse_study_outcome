package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class AIBot extends Message<AIBot, Builder> {
    public static final ProtoAdapter<AIBot> ADAPTER = null;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final String DEFAULT_ICON_URL = "";
    public static final Long DEFAULT_ID = null;
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    public final AppLink mapp_link;
    public final String mdescription;
    public final String micon_url;
    public final Long mid;
    public final String mname;

    public static final class Builder extends Message.Builder<AIBot, Builder> {
        public AppLink mapp_link;
        public String mdescription;
        public String micon_url;
        public Long mid;
        public String mname;

        @Override // com.squareup.wire.Message.Builder
        public AIBot build() {
            return new AIBot(this.mid, this.mname, this.mdescription, this.micon_url, this.mapp_link, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_link(AppLink r100) {
            this.mapp_link = r100;
            return this;
        }

        public Builder description(String r100) {
            this.mdescription = r100;
            return this;
        }

        public Builder icon_url(String r100) {
            this.micon_url = r100;
            return this;
        }

        public Builder id(Long r100) {
            this.mid = r100;
            return this;
        }

        public Builder name(String r100) {
            this.mname = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AIBot extends ProtoAdapter<AIBot> {
        public ProtoAdapter_AIBot() {
            super(FieldEncoding.LENGTH_DELIMITED, AIBot.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AIBot decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mid = 0L;
            r101.mname = "";
            r101.mdescription = "";
            r101.micon_url = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.mid = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mname = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mdescription = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.micon_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.mapp_link = AppLink.ADAPTER.decode(r100);
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
        public int encodedSize2(AIBot r100) {
            Long r101 = r100.mid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mname;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mdescription;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.micon_url;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            AppLink r113 = r100.mapp_link;
            if (r113 == null) goto L22;
            r102 = AppLink.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            return (r112 + r102) + r100.unknownFields().size();
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ AIBot decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AIBot r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AIBot r101) throws IOException {
            Long r102 = r101.mid;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mname;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mdescription;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.micon_url;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            AppLink r106 = r101.mapp_link;
            if (r106 == null) goto L17;
            AppLink.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AIBot r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AIBot();
        DEFAULT_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mid = this.mid;
        r100.mname = this.mname;
        r100.mdescription = this.mdescription;
        r100.micon_url = this.micon_url;
        r100.mapp_link = this.mapp_link;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AIBot.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AIBot(Long r100, String r101, String r110, String r111, AppLink r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public AIBot(Long r100, String r101, String r102, String r103, AppLink r104, ByteString r105) {
        super(ADAPTER, r105);
        this.mid = r100;
        this.mname = r101;
        this.mdescription = r102;
        this.micon_url = r103;
        this.mapp_link = r104;
    }
}
