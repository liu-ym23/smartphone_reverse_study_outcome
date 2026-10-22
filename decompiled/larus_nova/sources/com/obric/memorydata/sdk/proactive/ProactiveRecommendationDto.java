package com.obric.memorydata.sdk.proactive;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.sdk.account.platform.api.IVKService;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 b2\u00020\u0001:\u0001bBÝ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u000e¢\u0006\u0004\b\u001d\u0010\u001eB\u0011\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020 ¢\u0006\u0004\b\u001d\u0010!J\u0018\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020 2\u0006\u0010B\u001a\u00020\u0014H\u0016J\b\u0010C\u001a\u00020\u0014H\u0016J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00030\fHÆ\u0003J\t\u0010M\u001a\u00020\u000eHÆ\u0003J\t\u0010N\u001a\u00020\u0010HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0014HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\u0010\u0010T\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u00108J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010X\u001a\u00020\u000eHÆ\u0003J\t\u0010Y\u001a\u00020\u000eHÆ\u0003Jþ\u0001\u0010Z\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u000eHÆ\u0001¢\u0006\u0002\u0010[J\u0013\u0010\\\u001a\u00020]2\b\u0010^\u001a\u0004\u0018\u00010_HÖ\u0003J\t\u0010`\u001a\u00020\u0014HÖ\u0001J\t\u0010a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010#R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010#R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010#R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010#R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010#R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010#R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u00109\u001a\u0004\b7\u00108R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010#R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010#R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010#R\u0011\u0010\u001b\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b=\u0010.R\u0011\u0010\u001c\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b>\u0010.¨\u0006c"}, d2 = {"Lcom/obric/memorydata/sdk/proactive/ProactiveRecommendationDto;", "Landroid/os/Parcelable;", "recommendId", "", DBDefinition.TASK_ID, "subscriptionId", "recommendText", "emoji", "actionCondition", "actionExecuteInstruction", "actionContext", "sourcePackages", "", IVKService.ResponseConstants.CREATED, "", com.bytedance.android.ec.core.event.a.KEY_SCORE, "", "reason", "evidence", "recommendStatus", "", "status", "type", "expireAtMs", "inspirationId", "inspirationFeedbackAction", "inspirationUserFeedback", "inspirationUpdated", "inspirationTimestamp", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;JDLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getRecommendId", "()Ljava/lang/String;", "getTaskId", "getSubscriptionId", "getRecommendText", "getEmoji", "getActionCondition", "getActionExecuteInstruction", "getActionContext", "getSourcePackages", "()Ljava/util/List;", "getCreated", "()J", "getScore", "()D", "getReason", "getEvidence", "getRecommendStatus", "()I", "getStatus", "getType", "getExpireAtMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getInspirationId", "getInspirationFeedbackAction", "getInspirationUserFeedback", "getInspirationUpdated", "getInspirationTimestamp", "writeToParcel", "", "dest", "flags", "describeContents", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;JDLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)Lcom/obric/memorydata/sdk/proactive/ProactiveRecommendationDto;", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProactiveRecommendationDto implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f397170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f397171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f397172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f397173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f397174e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f397175f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f397176g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f397177h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<String> f397178i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f397179j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final double f397180k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f397181l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f397182m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f397183n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f397184o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f397185p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Long f397186q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f397187r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f397188s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f397189t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final long f397190u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f397191v;

    public static final class a implements Parcelable.Creator<ProactiveRecommendationDto> {
        public a() {
        }

        public static ProactiveRecommendationDto a(Parcel r310) {
            Intrinsics.checkNotNullParameter(r310, "parcel");
            Intrinsics.checkNotNullParameter(r310, "parcel");
            String r100 = r310.readString();
            if (r100 != null) goto L5;
            String r101 = "";
        L6:
            String r102 = r310.readString();
            if (r102 != null) goto L9;
            String r103 = "";
        L10:
            String r104 = r310.readString();
            if (r104 != null) goto L13;
            String r105 = "";
        L14:
            String r106 = r310.readString();
            if (r106 != null) goto L17;
            String r107 = "";
        L18:
            String r108 = r310.readString();
            if (r108 != null) goto L21;
            String r109 = "";
        L22:
            String r110 = r310.readString();
            String r111 = r310.readString();
            String r112 = r310.readString();
            List r113 = r310.createStringArrayList();
            if (r113 != null) goto L25;
            r113 = CollectionsKt.emptyList();
        L25:
            List r114 = r113;
            long r115 = r310.readLong();
            double r116 = r310.readDouble();
            String r117 = r310.readString();
            if (r117 != null) goto L28;
            String r118 = "";
        L29:
            String r119 = r310.readString();
            int r120 = r310.readInt();
            String r121 = r310.readString();
            if (r121 != null) goto L32;
            String r122 = "";
        L33:
            String r123 = r310.readString();
            if (r123 != null) goto L36;
            String r210 = "";
        L37:
            ska.a.f542434a.getClass();
            if (ska.a.a() == true) goto L40;
        L43:
            Long r124 = null;
        L44:
            Long r211 = r124;
            String r125 = r310.readString();
            if (r125 != null) goto L47;
            String r212 = "";
        L49:
            return new ProactiveRecommendationDto(r101, r103, r105, r107, r109, r110, r111, r112, r114, r115, r116, r118, r119, r120, r122, r210, r211, r212, r310.readString(), r310.readString(), r310.readLong(), r310.readLong());
        L47:
            r212 = r125;
            goto L49
        L40:
            if (r310.readInt() == 0) goto L43;
            r124 = Long.valueOf(r310.readLong());
            goto L44
        L36:
            r210 = r123;
            goto L37
        L32:
            r122 = r121;
            goto L33
        L28:
            r118 = r117;
            goto L29
        L21:
            r109 = r108;
            goto L22
        L17:
            r107 = r106;
            goto L18
        L13:
            r105 = r104;
            goto L14
        L9:
            r103 = r102;
            goto L10
        L5:
            r101 = r100;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ProactiveRecommendationDto createFromParcel(Parcel r100) {
            return a(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ProactiveRecommendationDto[] newArray(int r100) {
            return new ProactiveRecommendationDto[r100];
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
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ProactiveRecommendationDto) == true) goto L8;
        return false;
    L8:
        ProactiveRecommendationDto r101 = (ProactiveRecommendationDto) r100;
        if (Intrinsics.areEqual(this.f397170a, r101.f397170a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f397171b, r101.f397171b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f397172c, r101.f397172c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f397173d, r101.f397173d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f397174e, r101.f397174e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f397175f, r101.f397175f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f397176g, r101.f397176g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f397177h, r101.f397177h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f397178i, r101.f397178i) == true) goto L36;
        return false;
    L36:
        if (this.f397179j == r101.f397179j) goto L39;
        return false;
    L39:
        if (Double.compare(this.f397180k, r101.f397180k) == 0) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f397181l, r101.f397181l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f397182m, r101.f397182m) == true) goto L48;
        return false;
    L48:
        if (this.f397183n == r101.f397183n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f397184o, r101.f397184o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f397185p, r101.f397185p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f397186q, r101.f397186q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f397187r, r101.f397187r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f397188s, r101.f397188s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.f397189t, r101.f397189t) == true) goto L69;
        return false;
    L69:
        if (this.f397190u == r101.f397190u) goto L72;
        return false;
    L72:
        if (this.f397191v == r101.f397191v) goto L74;
        return false;
    L74:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f397170a.hashCode() * 31) + this.f397171b.hashCode()) * 31) + this.f397172c.hashCode()) * 31) + this.f397173d.hashCode()) * 31) + this.f397174e.hashCode()) * 31;
        String r101 = this.f397175f;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f397176g;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f397177h;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (((r107 + r109) * 31) + this.f397178i.hashCode()) * 31;
        long r111 = this.f397179j;
        int r112 = (r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31;
        long r113 = Double.doubleToLongBits(this.f397180k);
        int r114 = (((r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31) + this.f397181l.hashCode()) * 31;
        String r115 = this.f397182m;
        if (r115 != null) goto L17;
        int r116 = 0;
    L18:
        int r117 = (((((((r114 + r116) * 31) + this.f397183n) * 31) + this.f397184o.hashCode()) * 31) + this.f397185p.hashCode()) * 31;
        Long r118 = this.f397186q;
        if (r118 != null) goto L21;
        int r119 = 0;
    L22:
        int r120 = (((r117 + r119) * 31) + this.f397187r.hashCode()) * 31;
        String r121 = this.f397188s;
        if (r121 != null) goto L25;
        int r122 = 0;
    L26:
        int r123 = (r120 + r122) * 31;
        String r124 = this.f397189t;
        if (r124 == null) goto L30;
        r102 = r124.hashCode();
    L30:
        int r125 = (r123 + r102) * 31;
        long r126 = this.f397190u;
        int r127 = (r125 + ((int) (r126 ^ (r126 >>> 32)))) * 31;
        long r128 = this.f397191v;
        return r127 + ((int) (r128 ^ (r128 >>> 32)));
    L25:
        r122 = r121.hashCode();
        goto L26
    L21:
        r119 = r118.hashCode();
        goto L22
    L17:
        r116 = r115.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ProactiveRecommendationDto(recommendId=" + this.f397170a + ", taskId=" + this.f397171b + ", subscriptionId=" + this.f397172c + ", recommendText=" + this.f397173d + ", emoji=" + this.f397174e + ", actionCondition=" + this.f397175f + ", actionExecuteInstruction=" + this.f397176g + ", actionContext=" + this.f397177h + ", sourcePackages=" + this.f397178i + ", created=" + this.f397179j + ", score=" + this.f397180k + ", reason=" + this.f397181l + ", evidence=" + this.f397182m + ", recommendStatus=" + this.f397183n + ", status=" + this.f397184o + ", type=" + this.f397185p + ", expireAtMs=" + this.f397186q + ", inspirationId=" + this.f397187r + ", inspirationFeedbackAction=" + this.f397188s + ", inspirationUserFeedback=" + this.f397189t + ", inspirationUpdated=" + this.f397190u + ", inspirationTimestamp=" + this.f397191v + ')';
    }

    public final String getType() {
        return this.f397185p;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f397170a);
        r100.writeString(this.f397171b);
        r100.writeString(this.f397172c);
        r100.writeString(this.f397173d);
        r100.writeString(this.f397174e);
        r100.writeString(this.f397175f);
        r100.writeString(this.f397176g);
        r100.writeString(this.f397177h);
        r100.writeStringList(this.f397178i);
        r100.writeLong(this.f397179j);
        r100.writeDouble(this.f397180k);
        r100.writeString(this.f397181l);
        r100.writeString(this.f397182m);
        r100.writeInt(this.f397183n);
        r100.writeString(this.f397184o);
        r100.writeString(this.f397185p);
        ska.a.f542434a.getClass();
        if (ska.a.a() == false) goto L8;
        Long r102 = this.f397186q;
        if (r102 != null) goto L7;
        r100.writeInt(0);
        goto L8
    L7:
        r100.writeInt(1);
        r100.writeLong(r102.longValue());
    L8:
        r100.writeString(this.f397187r);
        r100.writeString(this.f397188s);
        r100.writeString(this.f397189t);
        r100.writeLong(this.f397190u);
        r100.writeLong(this.f397191v);
    }

    public ProactiveRecommendationDto(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r210, List<String> r211, long r212, double r213, String r214, String r215, int r216, String r217, String r310, Long r311, String r312, String r313, String r314, long r315, long r316) {
        Intrinsics.checkNotNullParameter(r110, "recommendId");
        Intrinsics.checkNotNullParameter(r111, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r112, "subscriptionId");
        Intrinsics.checkNotNullParameter(r113, "recommendText");
        Intrinsics.checkNotNullParameter(r114, "emoji");
        Intrinsics.checkNotNullParameter(r211, "sourcePackages");
        Intrinsics.checkNotNullParameter(r214, "reason");
        Intrinsics.checkNotNullParameter(r217, "status");
        Intrinsics.checkNotNullParameter(r310, "type");
        Intrinsics.checkNotNullParameter(r312, "inspirationId");
        this.f397170a = r110;
        this.f397171b = r111;
        this.f397172c = r112;
        this.f397173d = r113;
        this.f397174e = r114;
        this.f397175f = r115;
        this.f397176g = r116;
        this.f397177h = r210;
        this.f397178i = r211;
        this.f397179j = r212;
        this.f397180k = r213;
        this.f397181l = r214;
        this.f397182m = r215;
        this.f397183n = r216;
        this.f397184o = r217;
        this.f397185p = r310;
        this.f397186q = r311;
        this.f397187r = r312;
        this.f397188s = r313;
        this.f397189t = r314;
        this.f397190u = r315;
        this.f397191v = r316;
    }
}
