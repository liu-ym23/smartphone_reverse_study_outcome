package com.story.ai.biz.comment.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0006\u0010\u0015\u001a\u00020\bJ\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\""}, d2 = {"Lcom/story/ai/biz/comment/model/CommentActionDialogParams;", "Landroid/os/Parcelable;", "actionsList", "", "Lcom/story/ai/biz/comment/model/CommentAction;", "itemData", "Lcom/story/ai/biz/comment/model/CommentSection;", "bgColor", "", "<init>", "(Ljava/util/List;Lcom/story/ai/biz/comment/model/CommentSection;I)V", "getActionsList", "()Ljava/util/List;", "getItemData", "()Lcom/story/ai/biz/comment/model/CommentSection;", "getBgColor", "()I", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentActionDialogParams implements Parcelable {
    public static final Parcelable.Creator<CommentActionDialogParams> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<CommentAction> f459892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CommentSection f459893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f459894c;

    public static final class a implements Parcelable.Creator<CommentActionDialogParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CommentActionDialogParams createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            int r101 = r100.readInt();
            ArrayList r102 = new ArrayList(r101);
            int r103 = 0;
        L3:
            if (r103 == r101) goto L6;
            r102.add(CommentAction.CREATOR.createFromParcel(r100));
            r103 = r103 + 1;
            goto L3
        L6:
            return new CommentActionDialogParams(r102, (CommentSection) r100.readSerializable(), r100.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final CommentActionDialogParams[] newArray(int r100) {
            return new CommentActionDialogParams[r100];
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
        if ((r100 instanceof CommentActionDialogParams) == true) goto L8;
        return false;
    L8:
        CommentActionDialogParams r101 = (CommentActionDialogParams) r100;
        if (Intrinsics.areEqual(this.f459892a, r101.f459892a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f459893b, r101.f459893b) == true) goto L15;
        return false;
    L15:
        if (this.f459894c == r101.f459894c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f459892a.hashCode() * 31) + this.f459893b.hashCode()) * 31) + this.f459894c;
    }

    public final String toString() {
        return "CommentActionDialogParams(actionsList=" + this.f459892a + ", itemData=" + this.f459893b + ", bgColor=" + this.f459894c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        List<CommentAction> r102 = this.f459892a;
        r100.writeInt(r102.size());
        Iterator<CommentAction> r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().writeToParcel(r100, r101);
        goto L4
    L6:
        r100.writeSerializable(this.f459893b);
        r100.writeInt(this.f459894c);
    }

    public CommentActionDialogParams(List<CommentAction> r100, CommentSection r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "actionsList");
        Intrinsics.checkNotNullParameter(r101, "itemData");
        this.f459892a = r100;
        this.f459893b = r101;
        this.f459894c = r102;
    }
}
