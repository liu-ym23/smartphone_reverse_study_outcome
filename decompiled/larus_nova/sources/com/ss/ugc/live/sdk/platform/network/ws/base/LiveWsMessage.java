package com.ss.ugc.live.sdk.platform.network.ws.base;

import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public class LiveWsMessage implements Parcelable {
    public static final Parcelable.Creator<LiveWsMessage> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f458529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f458530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f458531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f458532d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<MsgHeader> f458533e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f458534f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f458535g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f458536h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ComponentName f458537i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f458538j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f458539k;

    public static class MsgHeader implements Parcelable {
        public static final Parcelable.Creator<MsgHeader> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f458540a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f458541b;

        public static class a implements Parcelable.Creator<MsgHeader> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final MsgHeader createFromParcel(Parcel r100) {
                MsgHeader r101 = new MsgHeader();
                r101.f458540a = r100.readString();
                r101.f458541b = r100.readString();
                return r101;
            }

            @Override // android.os.Parcelable.Creator
            public final MsgHeader[] newArray(int r100) {
                return new MsgHeader[r100];
            }
        }

        public MsgHeader() {
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        static {
            CREATOR = new a();
        }

        public final String toString() {
            return "MsgHeader{key='" + this.f458540a + "', value='" + this.f458541b + "'}";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            r100.writeString(this.f458540a);
            r100.writeString(this.f458541b);
        }
    }

    public static class a implements Parcelable.Creator<LiveWsMessage> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LiveWsMessage createFromParcel(Parcel r100) {
            return new LiveWsMessage(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final LiveWsMessage[] newArray(int r100) {
            return new LiveWsMessage[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
        new LiveWsMessage();
    }

    public final String toString() {
        return "LiveWsMessage{, channelId = " + this.f458538j + ", logId=" + this.f458530b + ", service=" + this.f458531c + ", method=" + this.f458532d + ", msgHeaders=" + this.f458533e + ", payloadEncoding='" + this.f458534f + "', payloadType='" + this.f458535g + "', payload=" + Arrays.toString(this.f458536h) + ", from= " + this.f458539k + ", replayToComponentName=" + this.f458537i + '}';
    }

    public LiveWsMessage() {
        this.f458539k = 0;
    }

    public LiveWsMessage(Parcel r100) {
        this.f458539k = 0;
        this.f458529a = r100.readLong();
        this.f458530b = r100.readLong();
        this.f458531c = r100.readInt();
        this.f458532d = r100.readInt();
        this.f458533e = r100.createTypedArrayList(MsgHeader.CREATOR);
        this.f458534f = r100.readString();
        this.f458535g = r100.readString();
        this.f458536h = r100.createByteArray();
        this.f458537i = (ComponentName) r100.readParcelable(ComponentName.class.getClassLoader());
        this.f458538j = r100.readInt();
        this.f458539k = r100.readInt();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeLong(this.f458529a);
        r100.writeLong(this.f458530b);
        r100.writeInt(this.f458531c);
        r100.writeInt(this.f458532d);
        r100.writeTypedList(this.f458533e);
        r100.writeString(this.f458534f);
        r100.writeString(this.f458535g);
        r100.writeByteArray(this.f458536h);
        r100.writeParcelable(this.f458537i, r101);
        r100.writeInt(this.f458538j);
        r100.writeInt(this.f458539k);
    }
}
