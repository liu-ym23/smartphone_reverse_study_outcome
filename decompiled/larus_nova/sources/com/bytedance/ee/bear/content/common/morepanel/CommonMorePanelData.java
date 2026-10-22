package com.bytedance.ee.bear.content.common.morepanel;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/content/common/morepanel/CommonMorePanelData;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "title", "", "getTitle", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "showReset", "", "getShowReset", "()Z", "setShowReset", "(Z)V", "items", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/content/common/morepanel/CommonMorePanelItemData;", "Lkotlin/collections/ArrayList;", "getItems", "()Ljava/util/ArrayList;", "setItems", "(Ljava/util/ArrayList;)V", "writeToParcel", "", "flags", "", "describeContents", "CREATOR", "contentmanager-content-widget_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonMorePanelData implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f216773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f216774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList<CommonMorePanelItemData> f216775c;

    public static final class a implements Parcelable.Creator<CommonMorePanelData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CommonMorePanelData createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            CommonMorePanelData r101 = new CommonMorePanelData();
            String r102 = r100.readString();
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            r101.f216773a = r102;
            boolean r103 = true;
            if (r100.readInt() == 1) goto L9;
            r103 = false;
        L9:
            r101.f216774b = r103;
            ArrayList r104 = r100.createTypedArrayList(CommonMorePanelItemData.CREATOR);
            if (r104 == null) goto L15;
            Iterator r105 = r104.iterator();
        L13:
            if (r105.hasNext() == false) goto L15;
            CommonMorePanelItemData r106 = (CommonMorePanelItemData) r105.next();
            r101.f216775c.add(r106);
        L15:
            return r101;
        }

        @Override // android.os.Parcelable.Creator
        public final CommonMorePanelData[] newArray(int r100) {
            return new CommonMorePanelData[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public CommonMorePanelData() {
        this.f216773a = "";
        this.f216775c = new ArrayList();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.f216773a);
        r100.writeTypedList(this.f216775c);
        r100.writeInt(this.f216774b ? 1 : 0);
    }
}
