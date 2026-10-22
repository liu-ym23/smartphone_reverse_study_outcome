package com.obric.memorydata.sdk.screencapture;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.lynx.serval.svg.SVGRenderEngine;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0013\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u001eHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006)"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/ViewTreeNode;", "Landroid/os/Parcelable;", "text", "", "contentDescription", "id", PushClientConstants.TAG_CLASS_NAME, SVGRenderEngine.RECT, "Landroid/graphics/Rect;", "visible", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Rect;Z)V", "getText", "()Ljava/lang/String;", "getContentDescription", "getId", "getClassName", "getRect", "()Landroid/graphics/Rect;", "getVisible", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ViewTreeNode implements Parcelable {
    public static final Parcelable.Creator<ViewTreeNode> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f397212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f397213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f397214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f397215d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f397216e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f397217f;

    public static final class a implements Parcelable.Creator<ViewTreeNode> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ViewTreeNode createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            String r102 = r100.readString();
            String r103 = r100.readString();
            String r104 = r100.readString();
            Rect r105 = (Rect) r100.readParcelable(ViewTreeNode.class.getClassLoader());
            if (r100.readInt() == 0) goto L5;
            boolean r106 = true;
        L7:
            return new ViewTreeNode(r101, r102, r103, r104, r105, r106);
        L5:
            r106 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ViewTreeNode[] newArray(int r100) {
            return new ViewTreeNode[r100];
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
        if ((r100 instanceof ViewTreeNode) == true) goto L8;
        return false;
    L8:
        ViewTreeNode r101 = (ViewTreeNode) r100;
        if (Intrinsics.areEqual(this.f397212a, r101.f397212a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f397213b, r101.f397213b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f397214c, r101.f397214c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f397215d, r101.f397215d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f397216e, r101.f397216e) == true) goto L24;
        return false;
    L24:
        if (this.f397217f == r101.f397217f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f397212a.hashCode() * 31) + this.f397213b.hashCode()) * 31) + this.f397214c.hashCode()) * 31) + this.f397215d.hashCode()) * 31) + this.f397216e.hashCode()) * 31;
        if (this.f397217f == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "ViewTreeNode(text=" + this.f397212a + ", contentDescription=" + this.f397213b + ", id=" + this.f397214c + ", className=" + this.f397215d + ", rect=" + this.f397216e + ", visible=" + this.f397217f + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f397212a);
        r100.writeString(this.f397213b);
        r100.writeString(this.f397214c);
        r100.writeString(this.f397215d);
        r100.writeParcelable(this.f397216e, r101);
        r100.writeInt(this.f397217f ? 1 : 0);
    }

    public ViewTreeNode(String r100, String r101, String r102, String r103, Rect r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "contentDescription");
        Intrinsics.checkNotNullParameter(r102, "id");
        Intrinsics.checkNotNullParameter(r103, PushClientConstants.TAG_CLASS_NAME);
        Intrinsics.checkNotNullParameter(r104, SVGRenderEngine.RECT);
        this.f397212a = r100;
        this.f397213b = r101;
        this.f397214c = r102;
        this.f397215d = r103;
        this.f397216e = r104;
        this.f397217f = r105;
    }
}
