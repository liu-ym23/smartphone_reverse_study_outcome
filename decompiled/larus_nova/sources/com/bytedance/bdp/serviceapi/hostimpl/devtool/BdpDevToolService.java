package com.bytedance.bdp.serviceapi.hostimpl.devtool;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/bdp/serviceapi/hostimpl/devtool/BdpDevToolService;", "Lcom/bytedance/bdp/bdpbase/service/IBdpService;", "DevEnvEntity", "ReflectResult", "bdp-service-api_release"}, k = 1, mv = {1, 4, 0})
public interface BdpDevToolService extends IBdpService {

    /* JADX INFO: loaded from: classes11.dex */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/bdp/serviceapi/hostimpl/devtool/BdpDevToolService$DevEnvEntity;", "Landroid/os/Parcelable;", "bdp-service-api_release"}, k = 1, mv = {1, 4, 0})
    public static final class DevEnvEntity implements Parcelable {
        public static final Parcelable.Creator<DevEnvEntity> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f201602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f201603b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f201604c;

        public static class a implements Parcelable.Creator<DevEnvEntity> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final DevEnvEntity createFromParcel(Parcel r100) {
                boolean r101 = false;
                if (r100.readInt() == 0) goto L5;
                boolean r102 = true;
            L7:
                if (r100.readInt() == 0) goto L10;
                r101 = true;
            L10:
                return new DevEnvEntity(r102, r101, r100.readString());
            L5:
                r102 = false;
                goto L7
            }

            @Override // android.os.Parcelable.Creator
            public final DevEnvEntity[] newArray(int r100) {
                return new DevEnvEntity[r100];
            }
        }

        static {
            CREATOR = new a();
        }

        public DevEnvEntity() {
            this(false, false, "prod");
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof DevEnvEntity) == false) goto L12;
            DevEnvEntity r101 = (DevEnvEntity) r100;
            if (this.f201602a == r101.f201602a) goto L8;
            return false;
        L8:
            if (this.f201603b == r101.f201603b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f201604c, r101.f201604c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6 */
        public final int hashCode() {
            boolean r100 = this.f201602a;
            ?? r101 = 1;
            ?? r102 = r100;
            if (r100 == false) goto L5;
            r102 = 1;
        L5:
            int r103 = r102 * 31;
            boolean r104 = this.f201603b;
            if (r104 == true) goto L9;
            r101 = r104;
        L9:
            int r105 = (r103 + r101) * 31;
            String r106 = this.f201604c;
            if (r106 == null) goto L12;
            int r107 = r106.hashCode();
        L14:
            return r105 + r107;
        L12:
            r107 = 0;
            goto L14
        }

        public final String toString() {
            return "DevEnvEntity(isBoe=" + this.f201602a + ", isPpe=" + this.f201603b + ", lane=" + this.f201604c + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            r100.writeInt(this.f201602a ? 1 : 0);
            r100.writeInt(this.f201603b ? 1 : 0);
            r100.writeString(this.f201604c);
        }

        public DevEnvEntity(boolean r100, boolean r101, String r102) {
            this.f201602a = r100;
            this.f201603b = r101;
            this.f201604c = r102;
        }
    }

    /* JADX INFO: loaded from: classes11.dex */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/bdp/serviceapi/hostimpl/devtool/BdpDevToolService$ReflectResult;", "Landroid/os/Parcelable;", "bdp-service-api_release"}, k = 1, mv = {1, 4, 0})
    public static final class ReflectResult implements Parcelable {
        public static final Parcelable.Creator<ReflectResult> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f201605a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f201606b;

        public static class a implements Parcelable.Creator<ReflectResult> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final ReflectResult createFromParcel(Parcel r100) {
                return new ReflectResult(r100.readInt(), r100.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final ReflectResult[] newArray(int r100) {
                return new ReflectResult[r100];
            }
        }

        static {
            CREATOR = new a();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof ReflectResult) == false) goto L10;
            ReflectResult r101 = (ReflectResult) r100;
            if (this.f201605a == r101.f201605a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f201606b, r101.f201606b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            int r100 = this.f201605a * 31;
            String r101 = this.f201606b;
            if (r101 == null) goto L5;
            int r102 = r101.hashCode();
        L7:
            return r100 + r102;
        L5:
            r102 = 0;
            goto L7
        }

        public final String toString() {
            return "ReflectResult(code=" + this.f201605a + ", message=" + this.f201606b + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            r100.writeInt(this.f201605a);
            r100.writeString(this.f201606b);
        }

        public ReflectResult(int r100, String r101) {
            this.f201605a = r100;
            this.f201606b = r101;
        }
    }
}
