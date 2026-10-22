package com.ss.android.token;

import android.content.Context;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.sdk.account.utils.LazySerializedData;
import com.bytedance.sdk.account.utils.LazyUnserializedData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class TicketTrackData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f449651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f449652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f449653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f449654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f449655e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f449656f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f449657g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f449658h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f449659i;

    public static final class Serialized extends LazySerializedData<TicketTrackData> {

        /* JADX INFO: renamed from: com.ss.android.token.TicketTrackData$Serialized$1, reason: invalid class name */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0017\u0010\u0002\u001a\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/ss/android/token/TicketTrackData;", "p1", "", "Lkotlin/ParameterName;", "name", "json", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 15})
        public static final /* synthetic */ class AnonymousClass1 extends FunctionReference implements Function1<String, TicketTrackData> {
            public AnonymousClass1(a r100) {
                super(1, r100);
            }

            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            public final String getName() {
                return "createFromJson";
            }

            @Override // kotlin.jvm.internal.CallableReference
            public final KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(a.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            public final String getSignature() {
                return "createFromJson$account_sdk_core_release(Ljava/lang/String;)Lcom/ss/android/token/TicketTrackData;";
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final TicketTrackData invoke2(String r110) {
                a r100 = (a) this.receiver;
                a r101 = a.f449660a;
                if (r110 != null) goto L5;
            L8:
                boolean r102 = true;
            L10:
                if (r102 == true) goto L20;
                JSONObject r103 = new JSONObject(r110);     // Catch: Exception -> L14
                return new TicketTrackData(r103.optString("sourcePath"), r103.optString("sourceLogId"), r103.optString("teePub"), r103.optString("reePub"), r103.optString("updateAttestTsSignPath"), r103.optString("updateAttestTsSignLogId"), r103.optInt("version", 0), r103.optLong("tokenUpdateTime", 0), r103.optString("tokenUpdateAppVersion", ""));
            L14:
                e = move-exception;
                tb7.a.c("TicketTrackData", "createFromJson error", e);
                return null;
            L20:
                return null;
            L5:
                if (r110.length() == 0) goto L8;
                r102 = false;
                goto L10
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ TicketTrackData invoke(String r100) {
                return invoke2(r100);
            }
        }

        public Serialized(String r100) {
            super(r100, new AnonymousClass1(a.f449660a));
        }
    }

    /* JADX INFO: loaded from: classes38.dex */
    public static final class Unserialized extends LazyUnserializedData<TicketTrackData> {

        /* JADX INFO: renamed from: com.ss.android.token.TicketTrackData$Unserialized$1, reason: invalid class name */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "Lcom/ss/android/token/TicketTrackData;", "Lkotlin/ParameterName;", "name", "ticketTrackData", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 15})
        public static final /* synthetic */ class AnonymousClass1 extends FunctionReference implements Function1<TicketTrackData, String> {
            public AnonymousClass1(a r100) {
                super(1, r100);
            }

            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            public final String getName() {
                return "serializeToJson";
            }

            @Override // kotlin.jvm.internal.CallableReference
            public final KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(a.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            public final String getSignature() {
                return "serializeToJson$account_sdk_core_release(Lcom/ss/android/token/TicketTrackData;)Ljava/lang/String;";
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final String invoke2(TicketTrackData r100) {
                a r101 = (a) this.receiver;
                a r102 = a.f449660a;
                if (r100 == null) goto L7;
                JSONObject r103 = new JSONObject();
                r103.put("sourcePath", r100.f449651a);
                r103.put("sourceLogId", r100.f449652b);
                r103.put("teePub", r100.f449653c);
                r103.put("reePub", r100.f449654d);
                r103.put("updateAttestTsSignPath", r100.f449655e);
                r103.put("updateAttestTsSignLogId", r100.f449656f);
                r103.put("version", r100.f449657g);
                r103.put("tokenUpdateTime", r100.f449658h);
                r103.put("tokenUpdateAppVersion", r100.f449659i);
                String r104 = r103.toString();
                if (r104 == null) goto L7;
                return r104;
            L7:
                return "";
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ String invoke(TicketTrackData r100) {
                return invoke2(r100);
            }
        }

        public Unserialized(TicketTrackData r100) {
            super(r100, new AnonymousClass1(a.f449660a));
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f449660a = null;

        public a() {
        }

        static {
            f449660a = new a();
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L32:
        return true;
    L5:
        if ((r100 instanceof TicketTrackData) == false) goto L31;
        TicketTrackData r101 = (TicketTrackData) r100;
        if (Intrinsics.areEqual(this.f449651a, r101.f449651a) == false) goto L31;
        if (Intrinsics.areEqual(this.f449652b, r101.f449652b) == false) goto L31;
        if (Intrinsics.areEqual(this.f449653c, r101.f449653c) == false) goto L31;
        if (Intrinsics.areEqual(this.f449654d, r101.f449654d) == false) goto L31;
        if (Intrinsics.areEqual(this.f449655e, r101.f449655e) == false) goto L31;
        if (Intrinsics.areEqual(this.f449656f, r101.f449656f) == false) goto L31;
        if (this.f449657g != r101.f449657g) goto L21;
        boolean r102 = true;
    L22:
        if (r102 == false) goto L31;
        if (this.f449658h != r101.f449658h) goto L26;
        boolean r103 = true;
    L27:
        if (r103 == false) goto L31;
        if (Intrinsics.areEqual(this.f449659i, r101.f449659i) == false) goto L31;
    L26:
        r103 = false;
        goto L27
    L21:
        r102 = false;
    L31:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f449651a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f449652b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f449653c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f449654d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f449655e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f449656f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (((r115 + r117) * 31) + this.f449657g) * 31;
        long r119 = this.f449658h;
        int r120 = (r118 + ((int) (r119 ^ (r119 >>> 32)))) * 31;
        String r121 = this.f449659i;
        if (r121 == null) goto L30;
        r101 = r121.hashCode();
    L30:
        return r120 + r101;
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
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TicketTrackData(sourcePath=" + this.f449651a + ", sourceLogId=" + this.f449652b + ", teePub=" + this.f449653c + ", reePub=" + this.f449654d + ", updateAttestTsSignPath=" + this.f449655e + ", updateAttestTsSignLogId=" + this.f449656f + ", version=" + this.f449657g + ", tokenUpdateTime=" + this.f449658h + ", tokenUpdateAppVersion=" + this.f449659i + ")";
    }

    public TicketTrackData(TicketTrackData r110, String r111, String r112) {
        this(r110.f449651a, r110.f449652b, r110.f449653c, r110.f449654d, r111, r112, 2, r110.f449658h, r110.f449659i);
    }

    public TicketTrackData(String r110, String r111, String r112, String r113, boolean r114) {
        if (r114 == false) goto L5;
        long r100 = System.currentTimeMillis();
    L6:
        long r101 = r100;
        if (r114 == false) goto L15;
        Context r102 = com.ss.android.account.k.c();
        if (r102 == null) goto L15;
        String r103 = r102.getPackageManager().getPackageInfo(r102.getPackageName(), 0).versionName;     // Catch: Throwable -> L13
    L16:
        this(r110, r111, r112, r113, "", "", 2, r101, r103);
        return;
    L13:
        th = move-exception;
        tb7.a.f("Utils", "getClientVersionCode error", th);
    L15:
        r103 = "";
        goto L16
    L5:
        r100 = 0;
        goto L6
    }

    public TicketTrackData(String r100, String r101, String r102, String r103, String r104, String r105, int r106, long r107, String r110) {
        this.f449651a = r100;
        this.f449652b = r101;
        this.f449653c = r102;
        this.f449654d = r103;
        this.f449655e = r104;
        this.f449656f = r105;
        this.f449657g = r106;
        this.f449658h = r107;
        this.f449659i = r110;
    }
}
