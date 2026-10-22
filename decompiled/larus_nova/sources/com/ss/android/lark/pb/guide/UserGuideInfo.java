package com.ss.android.lark.pb.guide;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class UserGuideInfo extends Message<UserGuideInfo, Builder> {
    public static final ProtoAdapter<UserGuideInfo> ADAPTER = null;
    public static final String DEFAULT_CONTEXT = "";
    public static final Integer DEFAULT_CUR_COUNT = null;
    public static final Integer DEFAULT_CUR_STEP = null;
    public static final String DEFAULT_KEY = "";
    public static final Integer DEFAULT_MAX_COUNT = null;
    public static final Integer DEFAULT_MAX_STEP = null;
    public static final Long DEFAULT_PRIORITY = null;
    private static final long serialVersionUID = 0;
    public final String mcontext;
    public final Integer mcur_count;
    public final Integer mcur_step;
    public final String mkey;
    public final Integer mmax_count;
    public final Integer mmax_step;
    public final Long mpriority;

    public static final class Builder extends Message.Builder<UserGuideInfo, Builder> {
        public String mcontext;
        public Integer mcur_count;
        public Integer mcur_step;
        public String mkey;
        public Integer mmax_count;
        public Integer mmax_step;
        public Long mpriority;

        @Override // com.squareup.wire.Message.Builder
        public UserGuideInfo build() {
            return new UserGuideInfo(this.mkey, this.mpriority, this.mcur_step, this.mmax_step, this.mcontext, this.mcur_count, this.mmax_count, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder context(String r100) {
            this.mcontext = r100;
            return this;
        }

        public Builder cur_count(Integer r100) {
            this.mcur_count = r100;
            return this;
        }

        public Builder cur_step(Integer r100) {
            this.mcur_step = r100;
            return this;
        }

        public Builder key(String r100) {
            this.mkey = r100;
            return this;
        }

        public Builder max_count(Integer r100) {
            this.mmax_count = r100;
            return this;
        }

        public Builder max_step(Integer r100) {
            this.mmax_step = r100;
            return this;
        }

        public Builder priority(Long r100) {
            this.mpriority = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UserGuideInfo extends ProtoAdapter<UserGuideInfo> {
        public ProtoAdapter_UserGuideInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, UserGuideInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UserGuideInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mkey = "";
            r101.mpriority = 0L;
            r101.mcur_step = 0;
            r101.mmax_step = 0;
            r101.mcontext = "";
            r101.mcur_count = 0;
            r101.mmax_count = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L14;
            switch(r103) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r101.mmax_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            r101.mcur_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L9:
            r101.mcontext = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.mmax_step = ProtoAdapter.INT32.decode(r100);
            goto L3
        L11:
            r101.mcur_step = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            r101.mpriority = ProtoAdapter.INT64.decode(r100);
            goto L3
        L13:
            r101.mkey = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L14:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UserGuideInfo r100) {
            String r101 = r100.mkey;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.mpriority;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Integer r107 = r100.mcur_step;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Integer r110 = r100.mmax_step;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.INT32.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.mcontext;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Integer r116 = r100.mcur_count;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.INT32.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Integer r119 = r100.mmax_count;
            if (r119 == null) goto L30;
            r102 = ProtoAdapter.INT32.encodedSizeWithTag(7, r119);
        L30:
            return (r118 + r102) + r100.unknownFields().size();
        L25:
            r117 = 0;
            goto L26
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
        public /* bridge */ /* synthetic */ UserGuideInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UserGuideInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UserGuideInfo r101) throws IOException {
            String r102 = r101.mkey;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.mpriority;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            Integer r104 = r101.mcur_step;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
        L11:
            Integer r105 = r101.mmax_step;
            if (r105 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.mcontext;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            Integer r107 = r101.mcur_count;
            if (r107 == null) goto L20;
            ProtoAdapter.INT32.encodeWithTag(r100, 6, r107);
        L20:
            Integer r108 = r101.mmax_count;
            if (r108 == null) goto L23;
            ProtoAdapter.INT32.encodeWithTag(r100, 7, r108);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserGuideInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UserGuideInfo();
        DEFAULT_PRIORITY = 0L;
        DEFAULT_CUR_STEP = 0;
        DEFAULT_MAX_STEP = 0;
        DEFAULT_CUR_COUNT = 0;
        DEFAULT_MAX_COUNT = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mkey = this.mkey;
        r100.mpriority = this.mpriority;
        r100.mcur_step = this.mcur_step;
        r100.mmax_step = this.mmax_step;
        r100.mcontext = this.mcontext;
        r100.mcur_count = this.mcur_count;
        r100.mmax_count = this.mmax_count;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UserGuideInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UserGuideInfo(String r110, Long r111, Integer r112, Integer r113, String r114, Integer r115, Integer r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public UserGuideInfo(String r100, Long r101, Integer r102, Integer r103, String r104, Integer r105, Integer r106, ByteString r107) {
        super(ADAPTER, r107);
        this.mkey = r100;
        this.mpriority = r101;
        this.mcur_step = r102;
        this.mmax_step = r103;
        this.mcontext = r104;
        this.mcur_count = r105;
        this.mmax_count = r106;
    }
}
