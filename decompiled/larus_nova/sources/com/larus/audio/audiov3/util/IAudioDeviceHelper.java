package com.larus.audio.audiov3.util;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0006J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/larus/audio/audiov3/util/IAudioDeviceHelper;", "", "getAudioDeviceInfo", "Lcom/larus/audio/audiov3/util/IAudioDeviceHelper$DeviceInfo;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "DeviceInfo", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAudioDeviceHelper {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f288703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f288704b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f288705c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f288703a, r101.f288703a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f288704b, r101.f288704b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f288705c, r101.f288705c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f288703a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f288704b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f288705c;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "DeviceInfo(inputDevice=" + this.f288703a + ", outputDevice=" + this.f288704b + ", bluetoothDeviceName=" + this.f288705c + ')';
        }

        public a(String r100, String r101, String r102) {
            this.f288703a = r100;
            this.f288704b = r101;
            this.f288705c = r102;
        }
    }

    a a(Context r100);
}
