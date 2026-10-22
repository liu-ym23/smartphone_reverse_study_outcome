package com.ss.android.lark.intent.export.entity.output;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/ASRRecognizeIntentOutput;", "Lcom/ss/android/lark/intent/export/entity/output/common/CommonSuccessIntentOutput;", "entity", "Lcom/ss/android/lark/intent/export/entity/output/ASROutput;", "display", "", "<init>", "(Lcom/ss/android/lark/intent/export/entity/output/ASROutput;Ljava/lang/String;)V", "getEntity", "()Lcom/ss/android/lark/intent/export/entity/output/ASROutput;", "getDisplay", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ASRRecognizeIntentOutput extends CommonSuccessIntentOutput {
    public static final Parcelable.Creator<ASRRecognizeIntentOutput> CREATOR = null;
    private final String display;
    private final ASROutput entity;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ASRRecognizeIntentOutput> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ASRRecognizeIntentOutput createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new ASRRecognizeIntentOutput(ASROutput.CREATOR.createFromParcel(r100), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ASRRecognizeIntentOutput createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ASRRecognizeIntentOutput[] newArray(int r100) {
            return new ASRRecognizeIntentOutput[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ASRRecognizeIntentOutput[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public static /* synthetic */ ASRRecognizeIntentOutput copy$default(ASRRecognizeIntentOutput r100, ASROutput r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.entity;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.display;
    L9:
        return r100.copy(r101, r102);
    }

    public final ASROutput component1() {
        return this.entity;
    }

    public final String component2() {
        return this.display;
    }

    public final ASRRecognizeIntentOutput copy(ASROutput r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "entity");
        return new ASRRecognizeIntentOutput(r100, r101);
    }

    @Override // com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput, com.ss.android.lark.intent.export.entity.output.IntentOutput, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ASRRecognizeIntentOutput) == true) goto L8;
        return false;
    L8:
        ASRRecognizeIntentOutput r101 = (ASRRecognizeIntentOutput) r100;
        if (Intrinsics.areEqual(this.entity, r101.entity) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.display, r101.display) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.entity.hashCode() * 31;
        String r101 = this.display;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "ASRRecognizeIntentOutput(entity=" + this.entity + ", display=" + this.display + ')';
    }

    @Override // com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput, com.ss.android.lark.intent.export.entity.output.IntentOutput, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        this.entity.writeToParcel(r100, r101);
        r100.writeString(this.display);
    }

    public final String getDisplay() {
        return this.display;
    }

    public final ASROutput getEntity() {
        return this.entity;
    }

    public ASRRecognizeIntentOutput(ASROutput r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "entity");
        super(Direction.CALLBACK_ASR_RESULT, r101);
        this.entity = r100;
        this.display = r101;
    }

    public /* synthetic */ ASRRecognizeIntentOutput(ASROutput r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
