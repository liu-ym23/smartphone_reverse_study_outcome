package com.ss.android.lark.pb.ai;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class Polygon extends Message<Polygon, Builder> {
    public static final ProtoAdapter<Polygon> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Point> mpoints;
    public final ContentType mtype;

    public static final class Builder extends Message.Builder<Polygon, Builder> {
        public List<Point> mpoints;
        public ContentType mtype;

        @Override // com.squareup.wire.Message.Builder
        public Polygon build() {
            ContentType r100 = this.mtype;
            if (r100 == null) goto L7;
            return new Polygon(this.mpoints, this.mtype, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, GearStrategyConsts.EV_MEDIA_TYPE});
        }

        public Builder() {
            this.mpoints = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder points(List<Point> r100) {
            Internal.checkElementsNotNull(r100);
            this.mpoints = r100;
            return this;
        }

        public Builder type(ContentType r100) {
            this.mtype = r100;
            return this;
        }
    }

    public static final enum ContentType extends Enum<ContentType> implements WireEnum {
        private static final /* synthetic */ ContentType[] $VALUES = null;
        public static final ProtoAdapter<ContentType> ADAPTER = null;
        public static final ContentType AVATAR = null;
        public static final ContentType TEXT = null;
        public static final ContentType UNKNOWN = null;
        private final int value;

        static {
            ContentType r100 = new ContentType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            ContentType r101 = new ContentType(CardAdapter.TEXT, 1, 1);
            TEXT = r101;
            ContentType r102 = new ContentType("AVATAR", 2, 2);
            AVATAR = r102;
            $VALUES = new ContentType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(ContentType.class);
        }

        public static ContentType[] values() {
            return (ContentType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ContentType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return AVATAR;
        L12:
            return TEXT;
        L14:
            return UNKNOWN;
        }

        public static ContentType valueOf(String r100) {
            return (ContentType) a.a(ContentType.class, r100);
        }

        private ContentType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_Polygon extends ProtoAdapter<Polygon> {
        public ProtoAdapter_Polygon() {
            super(FieldEncoding.LENGTH_DELIMITED, Polygon.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Polygon decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mpoints.add(Point.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mtype = ContentType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Polygon r100) {
            return (Point.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mpoints) + ContentType.ADAPTER.encodedSizeWithTag(2, r100.mtype)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Polygon decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Polygon r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Polygon r101) throws IOException {
            Point.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mpoints);
            ContentType.ADAPTER.encodeWithTag(r100, 2, r101.mtype);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Polygon r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Polygon();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mpoints = Internal.copyOf("mpoints", this.mpoints);
        r100.mtype = this.mtype;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Polygon.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public Polygon(List<Point> r100, ContentType r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public Polygon(List<Point> r100, ContentType r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mpoints = Internal.immutableCopyOf("mpoints", r100);
        this.mtype = r101;
    }
}
