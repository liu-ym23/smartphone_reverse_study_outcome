package com.bytedance.ee.bear.document.offline.sync.preloadexecutor.nextpage;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.util.io.NonProguard;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B/\u0012&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\u0004\b\b\u0010\tJ)\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J3\u0010\r\u001a\u00020\u00002(\b\u0002\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fR1\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/document/offline/sync/preloadexecutor/nextpage/InitAttr;", "Lcom/bytedance/ee/util/io/NonProguard;", "Landroid/os/Parcelable;", "", "text", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/util/HashMap;)V", "getText", "()Ljava/util/HashMap;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitAttr implements NonProguard, Parcelable, Cloneable {
    public static final Parcelable.Creator<InitAttr> CREATOR = null;
    private final HashMap<String, String> text;

    public static final class a implements Parcelable.Creator<InitAttr> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final InitAttr createFromParcel(Parcel r6) {
            Intrinsics.checkNotNullParameter(r6, "parcel");
            if (r6.readInt() != 0) goto L5;
            HashMap r7 = null;
        L10:
            return new InitAttr(r7);
        L5:
            int r0 = r6.readInt();
            HashMap r1 = new HashMap(r0);
            int r2 = 0;
        L6:
            if (r2 == r0) goto L8;
            r1.put(r6.readString(), r6.readString());
            r2 = r2 + 1;
            goto L6
        L8:
            r7 = r1;
            goto L10
        }

        @Override // android.os.Parcelable.Creator
        public final InitAttr[] newArray(int r1) {
            return new InitAttr[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InitAttr copy$default(InitAttr r0, HashMap r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.text;
    L6:
        return r0.copy(r1);
    }

    public final HashMap<String, String> component1() {
        return this.text;
    }

    public final InitAttr copy(HashMap<String, String> r2) {
        return new InitAttr(r2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof InitAttr) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.text, ((InitAttr) r4).text) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        HashMap<String, String> r0 = this.text;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "InitAttr(text=" + this.text + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        HashMap<String, String> r5 = this.text;
        if (r5 != null) goto L5;
        r3.writeInt(0);
        return;
    L5:
        r3.writeInt(1);
        r3.writeInt(r5.size());
        Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();
    L7:
        if (r6.hasNext() == false) goto L11;
        Map.Entry<String, String> r0 = r6.next();
        r3.writeString(r0.getKey());
        r3.writeString(r0.getValue());
        goto L7
    }

    public Object clone() {
        return super.clone();
    }

    public final HashMap<String, String> getText() {
        return this.text;
    }

    public InitAttr(HashMap<String, String> r1) {
        this.text = r1;
    }
}
