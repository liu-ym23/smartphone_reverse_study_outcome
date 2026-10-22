package com.bytedance.helios.sdk.detector;

import android.provider.MediaStore;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements com.bytedance.helios.sdk.detector.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f245539a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, a> f245540b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o f245541c = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f245542a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f245543b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f245544c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f245542a, r101.f245542a) == true) goto L8;
            return false;
        L8:
            if (this.f245543b == r101.f245543b) goto L10;
            return false;
        L10:
            if (this.f245544c == r101.f245544c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f245542a;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L7:
            return (((r101 * 31) + this.f245543b) * 31) + this.f245544c;
        L5:
            r101 = 0;
            goto L7
        }

        public final String toString() {
            return "ContentProviderConfig(permissionType=" + this.f245542a + ", queryApiId=" + this.f245543b + ", applyBatchApiId=" + this.f245544c + ")";
        }

        public a(String r100, int r101, int r102) {
            this.f245542a = r100;
            this.f245543b = r101;
            this.f245544c = r102;
        }
    }

    public o() {
    }

    @Override // com.bytedance.helios.sdk.detector.a
    public final String b() {
        return "ContentProvider";
    }

    @Override // com.bytedance.helios.sdk.detector.a
    public final String getResourceId() {
        return "cp";
    }

    static {
        f245541c = new o();
        f245539a = new int[]{240020, 240021, 240022, 240023, 240024, 240025, 240026, 240027, 240028, 240029, 240030, 240031, 240032, 240033, 240034, 240035, 240036, 240037, 240038, 240039, 240040, 240041};
        f245540b = MapsKt.mapOf(new Pair[]{TuplesKt.to("media", new a("Album", 240020, 240021)), TuplesKt.to("call_log", new a("Calls", 240022, 240023)), TuplesKt.to("sms", new a("Messages", 240024, 240025)), TuplesKt.to("mms", new a("Messages", 240026, 240027)), TuplesKt.to("browser", new a("Browser", 240028, 240029)), TuplesKt.to("mms-sms", new a("Messages", 240030, 240031)), TuplesKt.to("com.android.calendar", new a("Calendar", 240032, 240033)), TuplesKt.to("com.android.contacts", new a("Contacts", 240034, 240035)), TuplesKt.to("com.android.chrome.browser", new a("Chrome", 240036, 240037)), TuplesKt.to(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.getAuthority(), new a("ExternalImages", 240038, 240039)), TuplesKt.to(MediaStore.Images.Media.INTERNAL_CONTENT_URI.getAuthority(), new a("InternalImages", 240040, 240041))});
    }

    @Override // com.bytedance.helios.sdk.detector.a
    public final int[] a() {
        return f245539a;
    }
}
