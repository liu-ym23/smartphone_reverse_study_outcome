package com.ss.android.lark.pb.security_event;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class Extend extends Message<Extend, Builder> {
    public static final ProtoAdapter<Extend> ADAPTER = null;
    public static final Long DEFAULT_CREATEGROUP = null;
    public static final Long DEFAULT_DISMISSGROUP = null;
    private static final long serialVersionUID = 0;
    public final AppDetail mAppDetail;
    public final CommentType mCommentType;
    public final CommonDrawer mCommonDrawer;
    public final Long mCreateGroup;
    public final Long mDismissGroup;
    public final Status mstatus;

    public static final class Builder extends Message.Builder<Extend, Builder> {
        public AppDetail mAppDetail;
        public CommentType mCommentType;
        public CommonDrawer mCommonDrawer;
        public Long mCreateGroup;
        public Long mDismissGroup;
        public Status mstatus;

        @Override // com.squareup.wire.Message.Builder
        public Extend build() {
            return new Extend(this.mCommentType, this.mAppDetail, this.mCreateGroup, this.mDismissGroup, this.mCommonDrawer, this.mstatus, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder AppDetail(AppDetail r100) {
            this.mAppDetail = r100;
            return this;
        }

        public Builder CommentType(CommentType r100) {
            this.mCommentType = r100;
            return this;
        }

        public Builder CommonDrawer(CommonDrawer r100) {
            this.mCommonDrawer = r100;
            return this;
        }

        public Builder CreateGroup(Long r100) {
            this.mCreateGroup = r100;
            return this;
        }

        public Builder DismissGroup(Long r100) {
            this.mDismissGroup = r100;
            return this;
        }

        public Builder status(Status r100) {
            this.mstatus = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Extend extends ProtoAdapter<Extend> {
        public ProtoAdapter_Extend() {
            super(FieldEncoding.LENGTH_DELIMITED, Extend.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Extend decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mCreateGroup = 0L;
            r101.mDismissGroup = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L33;
            if (r103 != 1) goto L8;
            r101.mCommentType = CommentType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L31
        L31:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mAppDetail = AppDetail.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L27
        L27:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mCreateGroup = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.mDismissGroup = ProtoAdapter.INT64.decode(r100);
            goto L3
        L14:
            if (r103 != 100) goto L16;
            r101.mCommonDrawer = CommonDrawer.ADAPTER.decode(r100);
            goto L3
        L16:
            if (r103 != 9000001) goto L17;
            r101.mstatus = Status.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L17:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L33:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Extend r100) {
            CommentType r101 = r100.mCommentType;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = CommentType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            AppDetail r104 = r100.mAppDetail;
            if (r104 == null) goto L9;
            int r105 = AppDetail.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.mCreateGroup;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Long r110 = r100.mDismissGroup;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.INT64.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            CommonDrawer r113 = r100.mCommonDrawer;
            if (r113 == null) goto L21;
            int r114 = CommonDrawer.ADAPTER.encodedSizeWithTag(100, r113);
        L22:
            int r115 = r112 + r114;
            Status r116 = r100.mstatus;
            if (r116 == null) goto L26;
            r102 = Status.ADAPTER.encodedSizeWithTag(9000001, r116);
        L26:
            return (r115 + r102) + r100.unknownFields().size();
        L21:
            r114 = 0;
            goto L22
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
        public /* bridge */ /* synthetic */ Extend decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Extend r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Extend r101) throws IOException {
            CommentType r102 = r101.mCommentType;
            if (r102 == null) goto L5;
            CommentType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            AppDetail r103 = r101.mAppDetail;
            if (r103 == null) goto L8;
            AppDetail.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.mCreateGroup;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            Long r105 = r101.mDismissGroup;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r105);
        L14:
            CommonDrawer r106 = r101.mCommonDrawer;
            if (r106 == null) goto L17;
            CommonDrawer.ADAPTER.encodeWithTag(r100, 100, r106);
        L17:
            Status r107 = r101.mstatus;
            if (r107 == null) goto L20;
            Status.ADAPTER.encodeWithTag(r100, 9000001, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Extend r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Extend();
        DEFAULT_CREATEGROUP = 0L;
        DEFAULT_DISMISSGROUP = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mCommentType = this.mCommentType;
        r100.mAppDetail = this.mAppDetail;
        r100.mCreateGroup = this.mCreateGroup;
        r100.mDismissGroup = this.mDismissGroup;
        r100.mCommonDrawer = this.mCommonDrawer;
        r100.mstatus = this.mstatus;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Extend.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public Extend(CommentType r100, AppDetail r110, Long r111, Long r112, CommonDrawer r113, Status r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public Extend(CommentType r100, AppDetail r101, Long r102, Long r103, CommonDrawer r104, Status r105, ByteString r106) {
        super(ADAPTER, r106);
        this.mCommentType = r100;
        this.mAppDetail = r101;
        this.mCreateGroup = r102;
        this.mDismissGroup = r103;
        this.mCommonDrawer = r104;
        this.mstatus = r105;
    }
}
