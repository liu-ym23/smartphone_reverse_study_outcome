package com.bytedance.flow.search.kmp.api.model.payload;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import juc.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001a\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u001b\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0002\u0010\bJ\u0006\u0010\r\u001a\u00020\u0005J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005J%\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0001¢\u0006\u0002\b\u0019R\u001c\u0010\t\u001a\u00020\u00058\u0016X\u0097D¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/flow/search/kmp/api/model/payload/DividerPayload;", "Lcom/bytedance/flow/search/kmp/api/model/ISearchDataPayload;", "<init>", "()V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "type", "getType$annotations", "getType", "()I", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$aggregate_search_kmp_api_release", "$serializer", "Companion", "aggregate_search_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class DividerPayload extends ISearchDataPayload {
    public static final Parcelable.Creator<DividerPayload> CREATOR = null;
    public static final b Companion = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f243368i;

    public static final class b {
        public b() {
        }

        public final d<DividerPayload> serializer() {
            return a.f243369a;
        }
    }

    public static final class c implements Parcelable.Creator<DividerPayload> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final DividerPayload createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            r100.readInt();
            return new DividerPayload();
        }

        @Override // android.os.Parcelable.Creator
        public final DividerPayload[] newArray(int r100) {
            return new DividerPayload[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(1);
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public DividerPayload() {
        this.f243368i = 104;
    }

    @Override // com.bytedance.flow.search.kmp.api.model.ISearchDataPayload
    public int getType() {
        return this.f243368i;
    }

    public DividerPayload(int r100) {
        this.f243368i = 104;
    }
}
