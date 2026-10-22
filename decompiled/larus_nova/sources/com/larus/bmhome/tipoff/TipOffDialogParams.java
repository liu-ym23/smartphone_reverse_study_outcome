package com.larus.bmhome.tipoff;

import android.os.Parcel;
import android.os.Parcelable;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b-\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001IBÇ\u0001\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0013\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013\u0012\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010C\u001a\u00020\u0003J\u0016\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001f\"\u0004\b)\u0010!R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001f\"\u0004\b+\u0010!R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001b\"\u0004\b-\u0010\u001dR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u001f\"\u0004\b2\u0010!R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001f\"\u0004\b4\u0010!R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001f\"\u0004\b6\u0010!R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001f\"\u0004\b8\u0010!R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010:\"\u0004\b>\u0010<R(\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006J"}, d2 = {"Lcom/larus/bmhome/tipoff/TipOffDialogParams;", "Landroid/os/Parcelable;", "reportType", "", "entityId", "", "recommendFrom", "Lcom/larus/platform/model/RecommendFrom;", "fromPage", "conversationId", "serverIndex", "reportSource", "searchMobParam", "Lcom/larus/platform/model/SearchMobParam;", "isImmerse", "botId", "commonMobParam", "successReportToastString", "batchIds", "", "overrideReportReason", "Lcom/larus/bmhome/auth/ReportReason;", "extra", "", "<init>", "(ILjava/lang/String;Lcom/larus/platform/model/RecommendFrom;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/larus/platform/model/SearchMobParam;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/Map;)V", "getReportType", "()I", "setReportType", "(I)V", "getEntityId", "()Ljava/lang/String;", "setEntityId", "(Ljava/lang/String;)V", "getRecommendFrom", "()Lcom/larus/platform/model/RecommendFrom;", "setRecommendFrom", "(Lcom/larus/platform/model/RecommendFrom;)V", "getFromPage", "setFromPage", "getConversationId", "setConversationId", "getServerIndex", "setServerIndex", "getReportSource", "setReportSource", "getSearchMobParam", "()Lcom/larus/platform/model/SearchMobParam;", "setSearchMobParam", "(Lcom/larus/platform/model/SearchMobParam;)V", "setImmerse", "getBotId", "setBotId", "getCommonMobParam", "setCommonMobParam", "getSuccessReportToastString", "setSuccessReportToastString", "getBatchIds", "()Ljava/util/List;", "setBatchIds", "(Ljava/util/List;)V", "getOverrideReportReason", "setOverrideReportReason", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Builder", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TipOffDialogParams implements Parcelable {
    public static final Parcelable.Creator<TipOffDialogParams> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f314694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f314695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecommendFrom f314696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f314697d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f314698e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f314699f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f314700g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SearchMobParam f314701h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f314702i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f314703j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f314704k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f314705l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<String> f314706m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<com.larus.bmhome.auth.ReportReason> f314707n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Map<String, String> f314708o;

    public static final class a implements Parcelable.Creator<TipOffDialogParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TipOffDialogParams createFromParcel(Parcel r210) {
            Intrinsics.checkNotNullParameter(r210, "parcel");
            int r100 = r210.readInt();
            String r101 = r210.readString();
            RecommendFrom r102 = (RecommendFrom) r210.readParcelable(TipOffDialogParams.class.getClassLoader());
            String r103 = r210.readString();
            String r104 = r210.readString();
            String r105 = r210.readString();
            int r106 = r210.readInt();
            SearchMobParam r110 = (SearchMobParam) r210.readParcelable(TipOffDialogParams.class.getClassLoader());
            String r111 = r210.readString();
            String r112 = r210.readString();
            String r113 = r210.readString();
            String r114 = r210.readString();
            ArrayList<String> r115 = r210.createStringArrayList();
            if (r210.readInt() != 0) goto L5;
            ArrayList r107 = null;
        L10:
            if (r210.readInt() != 0) goto L12;
            ArrayList r116 = r107;
            LinkedHashMap r108 = null;
        L17:
            return new TipOffDialogParams(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r108);
        L12:
            int r109 = r210.readInt();
            LinkedHashMap r117 = new LinkedHashMap(r109);
            int r118 = 0;
        L13:
            if (r118 == r109) goto L15;
            int r119 = r109;
            ArrayList r120 = r107;
            r117.put(r210.readString(), r210.readString());
            r118 = r118 + 1;
            r109 = r119;
            r107 = r120;
            goto L13
        L15:
            r116 = r107;
            r108 = r117;
            goto L17
        L5:
            int r121 = r210.readInt();
            ArrayList r122 = new ArrayList(r121);
            int r123 = 0;
        L6:
            if (r123 == r121) goto L8;
            int r211 = r121;
            r122.add(r210.readParcelable(TipOffDialogParams.class.getClassLoader()));
            r123 = r123 + 1;
            r121 = r211;
            goto L6
        L8:
            r107 = r122;
            goto L10
        }

        @Override // android.os.Parcelable.Creator
        public final TipOffDialogParams[] newArray(int r100) {
            return new TipOffDialogParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.f314694a);
        r100.writeString(this.f314695b);
        r100.writeParcelable(this.f314696c, r101);
        r100.writeString(this.f314697d);
        r100.writeString(this.f314698e);
        r100.writeString(this.f314699f);
        r100.writeInt(this.f314700g);
        r100.writeParcelable(this.f314701h, r101);
        r100.writeString(this.f314702i);
        r100.writeString(this.f314703j);
        r100.writeString(this.f314704k);
        r100.writeString(this.f314705l);
        r100.writeStringList(this.f314706m);
        List<com.larus.bmhome.auth.ReportReason> r102 = this.f314707n;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L9:
        Map<String, String> r103 = this.f314708o;
        if (r103 != null) goto L12;
        r100.writeInt(0);
        return;
    L12:
        r100.writeInt(1);
        r100.writeInt(r103.size());
        Iterator<Map.Entry<String, String>> r104 = r103.entrySet().iterator();
    L14:
        if (r104.hasNext() == false) goto L19;
        Map.Entry<String, String> r105 = r104.next();
        r100.writeString(r105.getKey());
        r100.writeString(r105.getValue());
        goto L14
    L19:
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<com.larus.bmhome.auth.ReportReason> r106 = r102.iterator();
    L7:
        if (r106.hasNext() == false) goto L9;
        r100.writeParcelable(r106.next(), r101);
        goto L7
    }

    public TipOffDialogParams(int r100, String r101, RecommendFrom r102, String r103, String r104, String r105, int r106, SearchMobParam r107, String r108, String r110, String r111, String r112, List<String> r113, List<com.larus.bmhome.auth.ReportReason> r114, Map<String, String> r115) {
        this.f314694a = r100;
        this.f314695b = r101;
        this.f314696c = r102;
        this.f314697d = r103;
        this.f314698e = r104;
        this.f314699f = r105;
        this.f314700g = r106;
        this.f314701h = r107;
        this.f314702i = r108;
        this.f314703j = r110;
        this.f314704k = r111;
        this.f314705l = r112;
        this.f314706m = r113;
        this.f314707n = r114;
        this.f314708o = r115;
    }
}
