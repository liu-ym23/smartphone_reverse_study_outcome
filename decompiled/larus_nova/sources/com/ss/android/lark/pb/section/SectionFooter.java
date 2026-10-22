package com.ss.android.lark.pb.section;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class SectionFooter extends Message<SectionFooter, Builder> {
    public static final ProtoAdapter<SectionFooter> ADAPTER = null;
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final String DEFAULT_TEXT = "";
    private static final long serialVersionUID = 0;
    public final Action maction;
    public final String mavatar_key;
    public final String mtext;

    public static final class Builder extends Message.Builder<SectionFooter, Builder> {
        public Action maction;
        public String mavatar_key;
        public String mtext;

        @Override // com.squareup.wire.Message.Builder
        public SectionFooter build() {
            return new SectionFooter(this.mavatar_key, this.mtext, this.maction, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder action(Action r100) {
            this.maction = r100;
            return this;
        }

        public Builder avatar_key(String r100) {
            this.mavatar_key = r100;
            return this;
        }

        public Builder text(String r100) {
            this.mtext = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SectionFooter extends ProtoAdapter<SectionFooter> {
        public ProtoAdapter_SectionFooter() {
            super(FieldEncoding.LENGTH_DELIMITED, SectionFooter.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SectionFooter decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mavatar_key = "";
            r101.mtext = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mavatar_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mtext = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.maction = Action.ADAPTER.decode(r100);
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
        public int encodedSize2(SectionFooter r100) {
            String r101 = r100.mavatar_key;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mtext;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Action r107 = r100.maction;
            if (r107 == null) goto L14;
            r102 = Action.ADAPTER.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ SectionFooter decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SectionFooter r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SectionFooter r101) throws IOException {
            String r102 = r101.mavatar_key;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mtext;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Action r104 = r101.maction;
            if (r104 == null) goto L11;
            Action.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SectionFooter r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SectionFooter();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mavatar_key = this.mavatar_key;
        r100.mtext = this.mtext;
        r100.maction = this.maction;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SectionFooter.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SectionFooter(String r100, String r101, Action r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public SectionFooter(String r100, String r101, Action r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mavatar_key = r100;
        this.mtext = r101;
        this.maction = r102;
    }
}
