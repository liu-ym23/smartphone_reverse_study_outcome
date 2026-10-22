package com.larus.feedback.api.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.larus.bmhome.auth.FeedbackMeta;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010 \u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001aJ\t\u0010$\u001a\u00020\u000eHÆ\u0003J\t\u0010%\u001a\u00020\u000eHÆ\u0003Jn\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eHÆ\u0001¢\u0006\u0002\u0010'J\u0006\u0010(\u001a\u00020\fJ\u0013\u0010)\u001a\u00020\u000e2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\fHÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\u0016\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R%\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001d¨\u00063"}, d2 = {"Lcom/larus/feedback/api/model/FlowDislikePanelConfig;", "Landroid/os/Parcelable;", "requestKey", "", "metaList", "Ljava/util/ArrayList;", "Lcom/larus/bmhome/auth/FeedbackMeta;", "Lkotlin/collections/ArrayList;", "inputPlaceholder", ControlRule.KEY_EXTRA_DATA, "Landroid/os/Bundle;", "conversationType", "", "directReportReason", "", "reportForNewEndpointOutside", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/Integer;ZZ)V", "getRequestKey", "()Ljava/lang/String;", "getMetaList", "()Ljava/util/ArrayList;", "getInputPlaceholder", "getExtraData", "()Landroid/os/Bundle;", "getConversationType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDirectReportReason", "()Z", "getReportForNewEndpointOutside", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/Integer;ZZ)Lcom/larus/feedback/api/model/FlowDislikePanelConfig;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowDislikePanelConfig implements Parcelable {
    public static final Parcelable.Creator<FlowDislikePanelConfig> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f343028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<FeedbackMeta> f343029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f343030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bundle f343031d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f343032e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f343033f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f343034g;

    public static final class a implements Parcelable.Creator<FlowDislikePanelConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FlowDislikePanelConfig createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r100 = r110.readString();
            Integer r101 = null;
            if (r110.readInt() != 0) goto L5;
            ArrayList r102 = null;
        L8:
            String r103 = r110.readString();
            Bundle r104 = r110.readBundle(FlowDislikePanelConfig.class.getClassLoader());
            if (r110.readInt() == 0) goto L12;
            r101 = Integer.valueOf(r110.readInt());
        L12:
            Integer r105 = r101;
            if (r110.readInt() == 0) goto L15;
            boolean r106 = true;
        L17:
            if (r110.readInt() == 0) goto L19;
            boolean r111 = true;
        L21:
            return new FlowDislikePanelConfig(r100, r102, r103, r104, r105, r106, r111);
        L19:
            r111 = false;
            goto L21
        L15:
            r106 = false;
            goto L17
        L5:
            int r107 = r110.readInt();
            r102 = new ArrayList(r107);
            int r108 = 0;
        L6:
            if (r108 == r107) goto L8;
            r102.add(r110.readParcelable(FlowDislikePanelConfig.class.getClassLoader()));
            r108 = r108 + 1;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final FlowDislikePanelConfig[] newArray(int r100) {
            return new FlowDislikePanelConfig[r100];
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
        if ((r100 instanceof FlowDislikePanelConfig) == true) goto L8;
        return false;
    L8:
        FlowDislikePanelConfig r101 = (FlowDislikePanelConfig) r100;
        if (Intrinsics.areEqual(this.f343028a, r101.f343028a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f343029b, r101.f343029b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f343030c, r101.f343030c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f343031d, r101.f343031d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f343032e, r101.f343032e) == true) goto L24;
        return false;
    L24:
        if (this.f343033f == r101.f343033f) goto L27;
        return false;
    L27:
        if (this.f343034g == r101.f343034g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f343028a.hashCode() * 31;
        ArrayList<FeedbackMeta> r101 = this.f343029b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f343030c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Bundle r108 = this.f343031d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.f343032e;
        if (r111 == null) goto L18;
        r102 = r111.hashCode();
    L18:
        int r112 = (r110 + r102) * 31;
        int r113 = 1231;
        if (this.f343033f == false) goto L21;
        int r114 = 1231;
    L22:
        int r115 = (r112 + r114) * 31;
        if (this.f343034g == true) goto L27;
        r113 = 1237;
    L27:
        return r115 + r113;
    L21:
        r114 = 1237;
        goto L22
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
        return "FlowDislikePanelConfig(requestKey=" + this.f343028a + ", metaList=" + this.f343029b + ", inputPlaceholder=" + this.f343030c + ", extraData=" + this.f343031d + ", conversationType=" + this.f343032e + ", directReportReason=" + this.f343033f + ", reportForNewEndpointOutside=" + this.f343034g + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f343028a);
        ArrayList<FeedbackMeta> r102 = this.f343029b;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L9:
        r100.writeString(this.f343030c);
        r100.writeBundle(this.f343031d);
        Integer r103 = this.f343032e;
        if (r103 != null) goto L12;
        r100.writeInt(0);
    L13:
        r100.writeInt(this.f343033f ? 1 : 0);
        r100.writeInt(this.f343034g ? 1 : 0);
        return;
    L12:
        r100.writeInt(1);
        r100.writeInt(r103.intValue());
        goto L13
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<FeedbackMeta> r104 = r102.iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        r100.writeParcelable(r104.next(), r101);
        goto L7
    }

    public FlowDislikePanelConfig(String r100, ArrayList<FeedbackMeta> r101, String r102, Bundle r103, Integer r104, boolean r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "requestKey");
        this.f343028a = r100;
        this.f343029b = r101;
        this.f343030c = r102;
        this.f343031d = r103;
        this.f343032e = r104;
        this.f343033f = r105;
        this.f343034g = r106;
    }
}
