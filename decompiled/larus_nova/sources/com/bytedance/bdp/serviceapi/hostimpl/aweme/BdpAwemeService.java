package com.bytedance.bdp.serviceapi.hostimpl.aweme;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.bdp.bdpbase.service.IBdpService;

/* JADX INFO: loaded from: classes3.dex */
public interface BdpAwemeService extends IBdpService {

    /* JADX INFO: loaded from: classes11.dex */
    public static class AwemeCameraRequest implements Parcelable {
        public static final Parcelable.Creator<AwemeCameraRequest> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f201592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f201593b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f201594c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f201595d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f201596e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f201597f;

        public class a implements Parcelable.Creator<AwemeCameraRequest> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final AwemeCameraRequest createFromParcel(Parcel r100) {
                return new AwemeCameraRequest(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final AwemeCameraRequest[] newArray(int r100) {
                return new AwemeCameraRequest[r100];
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        static {
            CREATOR = new a();
        }

        public final String toString() {
            return "AwemeCameraRequest{cameraPosition='" + this.f201592a + "', finishButtonText='" + this.f201593b + "', enableImage=" + this.f201594c + ", enableVideo=" + this.f201595d + ", maxVideoDuration=" + this.f201596e + ", minVideoDuration=" + this.f201597f + '}';
        }

        public AwemeCameraRequest() {
            this.f201592a = NewBroadcastMonitor.CAPTURE.FRONT;
            this.f201593b = "下一步";
            this.f201594c = true;
            this.f201595d = true;
            this.f201596e = 300;
            this.f201597f = 0;
        }

        public AwemeCameraRequest(Parcel r100) {
            this.f201592a = NewBroadcastMonitor.CAPTURE.FRONT;
            this.f201593b = "下一步";
            boolean r101 = true;
            this.f201594c = true;
            this.f201595d = true;
            this.f201596e = 300;
            this.f201597f = 0;
            this.f201592a = r100.readString();
            this.f201593b = r100.readString();
            if (r100.readByte() == 0) goto L5;
            boolean r102 = true;
        L6:
            this.f201594c = r102;
            if (r100.readByte() != 0) goto L10;
            r101 = false;
        L10:
            this.f201595d = r101;
            this.f201596e = r100.readInt();
            this.f201597f = r100.readInt();
            return;
        L5:
            r102 = false;
            goto L6
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            r100.writeString(this.f201592a);
            r100.writeString(this.f201593b);
            r100.writeByte(this.f201594c ? 1 : 0);
            r100.writeByte(this.f201595d ? 1 : 0);
            r100.writeInt(this.f201596e);
            r100.writeInt(this.f201597f);
        }
    }

    /* JADX INFO: loaded from: classes11.dex */
    public static final enum IMUserMock extends Enum<IMUserMock> {
        public static final IMUserMock AVATAR_SMALL = null;
        public static final IMUserMock IS_FREQUENCY_CONTROL = null;
        public static final IMUserMock IS_FRIEND = null;
        public static final IMUserMock NICK_NAME = null;
        public static final IMUserMock SEC_UID = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ IMUserMock[] f201598a = null;
        String value;

        static {
            IMUserMock r100 = new IMUserMock("NICK_NAME", 0, "name");
            NICK_NAME = r100;
            IMUserMock r101 = new IMUserMock("AVATAR_SMALL", 1, "avatar_url");
            AVATAR_SMALL = r101;
            IMUserMock r102 = new IMUserMock("SEC_UID", 2, "sec_uid");
            SEC_UID = r102;
            IMUserMock r103 = new IMUserMock("IS_FRIEND", 3, "is_friend");
            IS_FRIEND = r103;
            IMUserMock r104 = new IMUserMock("IS_FREQUENCY_CONTROL", 4, "is_frequency_control");
            IS_FREQUENCY_CONTROL = r104;
            f201598a = new IMUserMock[]{r100, r101, r102, r103, r104};
        }

        public static IMUserMock[] values() {
            return (IMUserMock[]) f201598a.clone();
        }

        public String value() {
            return this.value;
        }

        public static IMUserMock valueOf(String r100) {
            return (IMUserMock) r27.a.a(IMUserMock.class, r100);
        }

        public IMUserMock(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }
}
