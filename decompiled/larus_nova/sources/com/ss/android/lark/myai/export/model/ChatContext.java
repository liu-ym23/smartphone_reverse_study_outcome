package com.ss.android.lark.myai.export.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB%\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0015\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J+\u0010\u0017\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0013HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/myai/export/model/ChatContext;", "Landroid/os/Parcelable;", "extraMap", "", "", "aiSceneObject", "Lcom/ss/android/lark/myai/export/model/AISceneObject;", "<init>", "(Ljava/util/Map;Lcom/ss/android/lark/myai/export/model/AISceneObject;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getExtraMap", "()Ljava/util/Map;", "getAiSceneObject", "()Lcom/ss/android/lark/myai/export/model/AISceneObject;", "writeToParcel", "", "flags", "", "describeContents", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "myai-export-officesdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatContext implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f432886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final osb.a f432887b;

    public static final class a implements Parcelable.Creator<ChatContext> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ChatContext createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            ChatContext.CREATOR.getClass();
            Bundle r101 = r100.readBundle(Bundle.class.getClassLoader());
            if (r101 != null) goto L5;
            r101 = new Bundle();
        L5:
            LinkedHashMap r102 = new LinkedHashMap();
            Iterator<T> r103 = r101.keySet().iterator();
        L6:
            String r104 = "";
            if (r103.hasNext() == false) goto L9;
            String r105 = (String) r103.next();
            r102.put(r105, r101.getString(r105, ""));
            goto L6
        L9:
            ChatContext.CREATOR.getClass();
            String r106 = r100.readString();
            String r107 = r100.readString();
            boolean r108 = false;
            if (r106 != null) goto L12;
        L15:
            boolean r109 = true;
        L16:
            if (r109 == false) goto L24;
            if (r107 != null) goto L19;
        L20:
            r108 = true;
        L21:
            if (r108 == false) goto L24;
            osb.a r110 = null;
        L31:
            return new ChatContext(r102, r110);
        L19:
            if (r107.length() != 0) goto L21;
        L24:
            if (r106 != null) goto L26;
            r106 = "";
        L26:
            if (r107 == null) goto L29;
            r104 = r107;
        L29:
            r110 = new osb.a(r106, r104);
            goto L31
        L12:
            if (r106.length() == 0) goto L15;
            r109 = false;
            goto L16
        }

        @Override // android.os.Parcelable.Creator
        public final ChatContext[] newArray(int r100) {
            return new ChatContext[r100];
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
        if ((r100 instanceof ChatContext) == true) goto L8;
        return false;
    L8:
        ChatContext r101 = (ChatContext) r100;
        if (Intrinsics.areEqual(this.f432886a, r101.f432886a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f432887b, r101.f432887b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f432886a.hashCode() * 31;
        osb.a r101 = this.f432887b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ChatContext(extraMap=" + this.f432886a + ", aiSceneObject=" + this.f432887b + ')';
    }

    public ChatContext(Map<String, String> r100, osb.a r101) {
        Intrinsics.checkNotNullParameter(r100, "extraMap");
        this.f432886a = r100;
        this.f432887b = r101;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        Bundle r102 = new Bundle();
        Iterator<Map.Entry<String, String>> r103 = this.f432886a.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry<String, String> r104 = r103.next();
        r102.putString(r104.getKey(), r104.getValue());
        goto L4
    L6:
        r100.writeBundle(r102);
        osb.a r105 = this.f432887b;
        String r106 = null;
        if (r105 == null) goto L9;
        String r107 = r105.f526595a;
    L10:
        r100.writeString(r107);
        osb.a r108 = this.f432887b;
        if (r108 == null) goto L13;
        r106 = r108.f526596b;
    L13:
        r100.writeString(r106);
        return;
    L9:
        r107 = null;
        goto L10
    }
}
