package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VETransitionFilterParam extends VEBaseFilterParam {
    public static final Parcelable.Creator<VETransitionFilterParam> CREATOR = null;
    public static final int TransitionDuration_DEFAULT = 500;
    public int tranDuration;
    public int tranType;
    public String transName;

    public static final enum TransitionType extends Enum<TransitionType> {
        private static final /* synthetic */ TransitionType[] $VALUES = null;
        public static final TransitionType TransitionType_DEFAULT = null;
        public static final TransitionType TransitionType_SINGLE = null;
        public static final TransitionType TransitionType_VARIABLE_TIME = null;

        private static /* synthetic */ TransitionType[] $values() {
            return new TransitionType[]{TransitionType_DEFAULT, TransitionType_VARIABLE_TIME, TransitionType_SINGLE};
        }

        static {
            TransitionType_DEFAULT = new TransitionType("TransitionType_DEFAULT", 0);
            TransitionType_VARIABLE_TIME = new TransitionType("TransitionType_VARIABLE_TIME", 1);
            TransitionType_SINGLE = new TransitionType("TransitionType_SINGLE", 2);
            $VALUES = $values();
        }

        public static TransitionType[] values() {
            return (TransitionType[]) $VALUES.clone();
        }

        public static TransitionType valueOf(String r100) {
            return (TransitionType) r27.a.a(TransitionType.class, r100);
        }

        private TransitionType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a implements Parcelable.Creator<VETransitionFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VETransitionFilterParam createFromParcel(Parcel r100) {
            return new VETransitionFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VETransitionFilterParam[] newArray(int r100) {
            return new VETransitionFilterParam[r100];
        }
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam
    public String toString() {
        return "VETransitionFilterParam{transName='" + this.transName + "', tranType=" + this.tranType + ", tranDuration=" + this.tranDuration + ", filterType=" + this.filterType + ", filterName='" + this.filterName + "', filterDurationType=" + this.filterDurationType + '}';
    }

    public VETransitionFilterParam() {
        this.filterName = "tran filter";
        this.filterType = 14;
        this.transName = "";
        this.tranType = TransitionType.TransitionType_DEFAULT.ordinal();
        this.tranDuration = 500;
    }

    public VETransitionFilterParam(Parcel r100) {
        super(r100);
        this.transName = r100.readString();
        this.tranType = r100.readInt();
        this.tranDuration = r100.readInt();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeString(this.transName);
        r100.writeInt(this.tranType);
        r100.writeInt(this.tranDuration);
    }
}
