package com.story.ai.biz.comment.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0001J\u0006\u0010\u0016\u001a\u00020\u0017J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006!"}, d2 = {"Lcom/story/ai/biz/comment/model/CommentAction;", "Landroid/os/Parcelable;", "text", "", "dangerColor", "", "clickCallback", "Lkotlin/Function1;", "Lcom/story/ai/biz/comment/model/CommentSection;", "", "<init>", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;)V", "getText", "()Ljava/lang/String;", "getDangerColor", "()Z", "getClickCallback", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentAction implements Parcelable {
    public static final Parcelable.Creator<CommentAction> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f459889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f459890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<CommentSection, Unit> f459891c;

    public static final class a implements Parcelable.Creator<CommentAction> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CommentAction createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            if (r100.readInt() == 0) goto L5;
            boolean r102 = true;
        L7:
            return new CommentAction(r101, r102, (Function1) r100.readSerializable());
        L5:
            r102 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final CommentAction[] newArray(int r100) {
            return new CommentAction[r100];
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
        if ((r100 instanceof CommentAction) == true) goto L8;
        return false;
    L8:
        CommentAction r101 = (CommentAction) r100;
        if (Intrinsics.areEqual(this.f459889a, r101.f459889a) == true) goto L12;
        return false;
    L12:
        if (this.f459890b == r101.f459890b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f459891c, r101.f459891c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f459889a.hashCode() * 31;
        if (this.f459890b == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.f459891c.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "CommentAction(text=" + this.f459889a + ", dangerColor=" + this.f459890b + ", clickCallback=" + this.f459891c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f459889a);
        r100.writeInt(this.f459890b ? 1 : 0);
        r100.writeSerializable((Serializable) this.f459891c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommentAction(String r100, boolean r101, Function1<? super CommentSection, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r102, "clickCallback");
        this.f459889a = r100;
        this.f459890b = r101;
        this.f459891c = r102;
    }
}
