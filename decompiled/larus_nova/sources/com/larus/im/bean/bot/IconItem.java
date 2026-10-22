package com.larus.im.bean.bot;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.c;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00060\u0001j\u0002`\u0002:\u0002'(B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\tHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R&\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006)"}, d2 = {"Lcom/larus/im/bean/bot/IconItem;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "uri", "", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUri$annotations", "()V", "getUri", "()Ljava/lang/String;", "setUri", "(Ljava/lang/String;)V", "getUrl$annotations", "getUrl", "setUrl", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class IconItem implements java.io.Serializable {
    public static final b Companion = null;
    private String uri;
    private String url;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<IconItem> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346476a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346477b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            return new d[]{kuc.a.d(r100), kuc.a.d(r100)};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346477b;
        }

        static {
            a r100 = new a();
            f346476a = r100;
            g2 r101 = new g2("com.larus.im.bean.bot.IconItem", r100, 2);
            r101.j("uri", true);
            r101.j("url", true);
            f346477b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f346477b;
            c r111 = r110.beginStructure(r100);
            if (r111.decodeSequentially() == false) goto L5;
            v2 r101 = v2.f520790a;
            String r102 = (String) r111.decodeNullableSerializableElement(r100, 0, r101, null);
            String r103 = (String) r111.decodeNullableSerializableElement(r100, 1, r101, null);
            int r104 = 3;
        L17:
            r111.endStructure(r100);
            return new IconItem(r104, r102, r103, null);
        L5:
            r103 = null;
            String r105 = null;
            int r106 = 0;
            boolean r107 = true;
        L6:
            if (r107 == false) goto L16;
            int r108 = r111.decodeElementIndex(r100);
            if (r108 != (-1)) goto L9;
            r107 = false;
            goto L6
        L9:
            if (r108 != 0) goto L10;
            r105 = (String) r111.decodeNullableSerializableElement(r100, 0, v2.f520790a, r105);
            r106 = r106 | 1;
            goto L6
        L10:
            if (r108 != 1) goto L13;
            r103 = (String) r111.decodeNullableSerializableElement(r100, 1, v2.f520790a, r103);
            r106 = r106 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r108);
        L16:
            r102 = r105;
            r104 = r106;
            goto L17
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            IconItem r102 = (IconItem) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346477b;
            muc.d r104 = r100.beginStructure(r103);
            IconItem.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<IconItem> serializer() {
            return a.f346476a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public IconItem() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ IconItem copy$default(IconItem r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.uri;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.url;
    L9:
        return r100.copy(r101, r102);
    }

    @SerialName("uri")
    public static /* synthetic */ void getUri$annotations() {
    }

    @SerialName("url")
    public static /* synthetic */ void getUrl$annotations() {
    }

    public final String component1() {
        return this.uri;
    }

    public final String component2() {
        return this.url;
    }

    public final IconItem copy(String r100, String r101) {
        return new IconItem(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IconItem) == true) goto L8;
        return false;
    L8:
        IconItem r101 = (IconItem) r100;
        if (Intrinsics.areEqual(this.uri, r101.uri) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.uri;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.url;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "IconItem(uri=" + this.uri + ", url=" + this.url + ')';
    }

    static {
        Companion = new b();
    }

    public final String getUri() {
        return this.uri;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUri(String r100) {
        this.uri = r100;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }

    public IconItem(String r100, String r101) {
        this.uri = r100;
        this.url = r101;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(IconItem r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.uri);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        r103 = true;
    L17:
        if (r103 == false) goto L20;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.url);
        return;
    L20:
        return;
    L15:
        if (Intrinsics.areEqual(r100.url, "") == true) goto L17;
    L6:
        if (Intrinsics.areEqual(r100.uri, "") == false) goto L4;
        r104 = false;
        goto L9
    }

    public IconItem(int r100, String r101, String r102, q2 r103) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346477b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.uri = "";
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.url = "";
        return;
    L11:
        this.url = r102;
        return;
    L7:
        this.uri = r101;
        goto L9
    }

    public /* synthetic */ IconItem(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101);
    }
}
