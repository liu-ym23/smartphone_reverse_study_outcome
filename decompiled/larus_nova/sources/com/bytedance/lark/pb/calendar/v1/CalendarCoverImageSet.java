package com.bytedance.lark.pb.calendar.v1;

import com.bytedance.lark.pb.basic.v1.Image;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class CalendarCoverImageSet extends Message<CalendarCoverImageSet, Builder> {
    public static final ProtoAdapter<CalendarCoverImageSet> ADAPTER = null;
    public static final String DEFAULT_KEY = "";
    private static final long serialVersionUID = 0;
    public final String key;
    public final Image middle;
    public final Image origin;
    public final Image thumb;

    public static final class Builder extends Message.Builder<CalendarCoverImageSet, Builder> {
        public String key;
        public Image middle;
        public Image origin;
        public Image thumb;

        @Override // com.squareup.wire.Message.Builder
        public CalendarCoverImageSet build() {
            return new CalendarCoverImageSet(this.key, this.thumb, this.middle, this.origin, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }

        public Builder middle(Image r100) {
            this.middle = r100;
            return this;
        }

        public Builder origin(Image r100) {
            this.origin = r100;
            return this;
        }

        public Builder thumb(Image r100) {
            this.thumb = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CalendarCoverImageSet extends ProtoAdapter<CalendarCoverImageSet> {
        public ProtoAdapter_CalendarCoverImageSet() {
            super(FieldEncoding.LENGTH_DELIMITED, CalendarCoverImageSet.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CalendarCoverImageSet decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.key = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.thumb = Image.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.middle = Image.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.origin = Image.ADAPTER.decode(r100);
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
        public int encodedSize2(CalendarCoverImageSet r100) {
            String r101 = r100.key;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Image r104 = r100.thumb;
            if (r104 == null) goto L9;
            int r105 = Image.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Image r107 = r100.middle;
            if (r107 == null) goto L13;
            int r108 = Image.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Image r110 = r100.origin;
            if (r110 == null) goto L18;
            r102 = Image.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ CalendarCoverImageSet decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CalendarCoverImageSet r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CalendarCoverImageSet r101) throws IOException {
            String r102 = r101.key;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Image r103 = r101.thumb;
            if (r103 == null) goto L8;
            Image.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Image r104 = r101.middle;
            if (r104 == null) goto L11;
            Image.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            Image r105 = r101.origin;
            if (r105 == null) goto L14;
            Image.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CalendarCoverImageSet r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CalendarCoverImageSet();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.key = this.key;
        r100.thumb = this.thumb;
        r100.middle = this.middle;
        r100.origin = this.origin;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CalendarCoverImageSet.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CalendarCoverImageSet(String r100, Image r101, Image r102, Image r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public CalendarCoverImageSet(String r100, Image r101, Image r102, Image r103, ByteString r104) {
        super(ADAPTER, r104);
        this.key = r100;
        this.thumb = r101;
        this.middle = r102;
        this.origin = r103;
    }
}
