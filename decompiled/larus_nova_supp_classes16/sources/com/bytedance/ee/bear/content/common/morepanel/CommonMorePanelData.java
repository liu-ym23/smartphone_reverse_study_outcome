package com.bytedance.ee.bear.content.common.morepanel;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/content/common/morepanel/CommonMorePanelData;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "showReset", "", "getShowReset", "()Z", "setShowReset", "(Z)V", "items", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/content/common/morepanel/CommonMorePanelItemData;", "Lkotlin/collections/ArrayList;", "getItems", "()Ljava/util/ArrayList;", "setItems", "(Ljava/util/ArrayList;)V", "writeToParcel", "", "flags", "", "describeContents", "CREATOR", "contentmanager-content-widget_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonMorePanelData implements Parcelable {
    public static final a CREATOR = null;
    public String a;
    public boolean b;
    public ArrayList<CommonMorePanelItemData> c;

    public static final class a implements Parcelable.Creator<CommonMorePanelData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CommonMorePanelData createFromParcel(Parcel r4) {
            Intrinsics.checkNotNullParameter(r4, "parcel");
            Intrinsics.checkNotNullParameter(r4, "parcel");
            CommonMorePanelData r1 = new CommonMorePanelData();
            String r0 = r4.readString();
            if (r0 != null) goto L5;
            r0 = "";
        L5:
            r1.a = r0;
            boolean r2 = true;
            if (r4.readInt() == 1) goto L9;
            r2 = false;
        L9:
            r1.b = r2;
            ArrayList r5 = r4.createTypedArrayList(CommonMorePanelItemData.CREATOR);
            if (r5 == null) goto L15;
            Iterator r6 = r5.iterator();
        L13:
            if (r6.hasNext() == false) goto L15;
            CommonMorePanelItemData r3 = (CommonMorePanelItemData) r6.next();
            r1.c.add(r3);
        L15:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public final CommonMorePanelData[] newArray(int r1) {
            return new CommonMorePanelData[r1];
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
        this.a = "";
        this.c = new ArrayList();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(this.a);
        r1.writeTypedList(this.c);
        r1.writeInt(this.b ? 1 : 0);
    }
}
