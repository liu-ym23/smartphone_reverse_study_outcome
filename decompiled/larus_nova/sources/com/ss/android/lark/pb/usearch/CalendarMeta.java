package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.Icon;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class CalendarMeta extends Message<CalendarMeta, Builder> {
    public static final ProtoAdapter<CalendarMeta> ADAPTER = null;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_URI = "";
    private static final long serialVersionUID = 0;
    public final String mdescription;
    public final Icon micon;
    public final String mid;
    public final String muri;

    public static final class Builder extends Message.Builder<CalendarMeta, Builder> {
        public String mdescription;
        public Icon micon;
        public String mid;
        public String muri;

        @Override // com.squareup.wire.Message.Builder
        public CalendarMeta build() {
            String r100 = this.mid;
            if (r100 == null) goto L7;
            return new CalendarMeta(this.mid, this.muri, this.mdescription, this.micon, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mid"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder description(String r100) {
            this.mdescription = r100;
            return this;
        }

        public Builder icon(Icon r100) {
            this.micon = r100;
            return this;
        }

        public Builder id(String r100) {
            this.mid = r100;
            return this;
        }

        public Builder uri(String r100) {
            this.muri = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CalendarMeta extends ProtoAdapter<CalendarMeta> {
        public ProtoAdapter_CalendarMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, CalendarMeta.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CalendarMeta decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mid = "";
            r101.muri = "";
            r101.mdescription = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.muri = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mdescription = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.micon = Icon.ADAPTER.decode(r100);
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
        public int encodedSize2(CalendarMeta r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.mid);
            String r103 = r100.muri;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.mdescription;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            Icon r110 = r100.micon;
            if (r110 == null) goto L14;
            r104 = Icon.ADAPTER.encodedSizeWithTag(4, r110);
        L14:
            return (r109 + r104) + r100.unknownFields().size();
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CalendarMeta decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CalendarMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CalendarMeta r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.mid);
            String r103 = r101.muri;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.mdescription;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            Icon r105 = r101.micon;
            if (r105 == null) goto L11;
            Icon.ADAPTER.encodeWithTag(r100, 4, r105);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CalendarMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CalendarMeta();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mid = this.mid;
        r100.muri = this.muri;
        r100.mdescription = this.mdescription;
        r100.micon = this.micon;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CalendarMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CalendarMeta(String r100, String r101, String r102, Icon r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public CalendarMeta(String r100, String r101, String r102, Icon r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mid = r100;
        this.muri = r101;
        this.mdescription = r102;
        this.micon = r103;
    }
}
