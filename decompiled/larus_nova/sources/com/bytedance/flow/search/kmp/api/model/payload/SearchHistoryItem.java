package com.bytedance.flow.search.kmp.api.model.payload;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.huawei.hms.support.feature.result.CommonConstant;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00060\u0001j\u0002`\u0002:\u0002+,B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB9\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010\u0018\u001a\u00020\u000bJ\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000bJ%\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006-"}, d2 = {"Lcom/bytedance/flow/search/kmp/api/model/payload/SearchHistoryItem;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", CommonConstant.KEY_DISPLAY_NAME, "", "displayState", "action", "Lcom/bytedance/flow/search/kmp/api/model/payload/SearchHistoryAction;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/flow/search/kmp/api/model/payload/SearchHistoryAction;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lcom/bytedance/flow/search/kmp/api/model/payload/SearchHistoryAction;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDisplayName", "()Ljava/lang/String;", "getDisplayState", "getAction", "()Lcom/bytedance/flow/search/kmp/api/model/payload/SearchHistoryAction;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$aggregate_search_kmp_api_release", "$serializer", "Companion", "aggregate_search_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class SearchHistoryItem implements Parcelable {
    public static final Parcelable.Creator<SearchHistoryItem> CREATOR = null;
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f243486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f243487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SearchHistoryAction f243488c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<SearchHistoryItem> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f243489a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f243490b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            return new d[]{r100, r100, SearchHistoryAction.a.f243484a};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f243490b;
        }

        static {
            a r100 = new a();
            f243489a = r100;
            g2 r101 = new g2("com.bytedance.flow.search.kmp.api.model.payload.SearchHistoryItem", r100, 3);
            r101.j(CommonConstant.KEY_DISPLAY_NAME, false);
            r101.j("displayState", false);
            r101.j("action", false);
            f243490b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f243490b;
            muc.c r111 = r110.beginStructure(r100);
            String r101 = null;
            if (r111.decodeSequentially() == false) goto L5;
            String r102 = r111.decodeStringElement(r100, 0);
            String r103 = r111.decodeStringElement(r100, 1);
            SearchHistoryAction r104 = (SearchHistoryAction) r111.decodeSerializableElement(r100, 2, SearchHistoryAction.a.f243484a, null);
            int r105 = 7;
        L19:
            r111.endStructure(r100);
            return new SearchHistoryItem(r105, r102, r103, r104);
        L5:
            String r106 = null;
            SearchHistoryAction r107 = null;
            int r108 = 0;
            boolean r109 = true;
        L6:
            if (r109 == false) goto L18;
            int r112 = r111.decodeElementIndex(r100);
            if (r112 != (-1)) goto L9;
            r109 = false;
            goto L6
        L9:
            if (r112 != 0) goto L10;
            r101 = r111.decodeStringElement(r100, 0);
            r108 = r108 | 1;
            goto L6
        L10:
            if (r112 != 1) goto L11;
            r106 = r111.decodeStringElement(r100, 1);
            r108 = r108 | 2;
            goto L6
        L11:
            if (r112 != 2) goto L14;
            r107 = (SearchHistoryAction) r111.decodeSerializableElement(r100, 2, SearchHistoryAction.a.f243484a, r107);
            r108 = r108 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r112);
        L18:
            r105 = r108;
            r102 = r101;
            r103 = r106;
            r104 = r107;
            goto L19
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            SearchHistoryItem r102 = (SearchHistoryItem) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f243490b;
            muc.d r104 = r100.beginStructure(r103);
            r104.encodeStringElement(r103, 0, r102.f243486a);
            r104.encodeStringElement(r103, 1, r102.f243487b);
            r104.encodeSerializableElement(r103, 2, SearchHistoryAction.a.f243484a, r102.f243488c);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<SearchHistoryItem> serializer() {
            return a.f243489a;
        }
    }

    public static final class c implements Parcelable.Creator<SearchHistoryItem> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final SearchHistoryItem createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new SearchHistoryItem(r100.readString(), r100.readString(), SearchHistoryAction.CREATOR.createFromParcel(r100));
        }

        @Override // android.os.Parcelable.Creator
        public final SearchHistoryItem[] newArray(int r100) {
            return new SearchHistoryItem[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SearchHistoryItem) == true) goto L8;
        return false;
    L8:
        SearchHistoryItem r101 = (SearchHistoryItem) r100;
        if (Intrinsics.areEqual(this.f243486a, r101.f243486a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f243487b, r101.f243487b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f243488c, r101.f243488c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f243486a.hashCode() * 31) + this.f243487b.hashCode()) * 31) + this.f243488c.hashCode();
    }

    public final String toString() {
        return "SearchHistoryItem(displayName=" + this.f243486a + ", displayState=" + this.f243487b + ", action=" + this.f243488c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f243486a);
        r100.writeString(this.f243487b);
        this.f243488c.writeToParcel(r100, r101);
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public SearchHistoryItem(String r100, String r101, SearchHistoryAction r102) {
        Intrinsics.checkNotNullParameter(r100, CommonConstant.KEY_DISPLAY_NAME);
        Intrinsics.checkNotNullParameter(r101, "displayState");
        Intrinsics.checkNotNullParameter(r102, "action");
        this.f243486a = r100;
        this.f243487b = r101;
        this.f243488c = r102;
    }

    public SearchHistoryItem(int r100, String r101, String r102, SearchHistoryAction r103) {
        if (7 != (r100 & 7)) goto L6;
        this.f243486a = r101;
        this.f243487b = r102;
        this.f243488c = r103;
        return;
    L6:
        b2.b(r100, 7, a.f243490b);
        throw null;
    }
}
