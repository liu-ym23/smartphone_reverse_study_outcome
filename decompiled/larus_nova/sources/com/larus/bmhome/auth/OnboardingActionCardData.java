package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.larus.platform.model.upload.ImageInstantUploadPolicyFamily;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001:\u0002\u001a\u001bB\u001b\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\f\u001a\u00020\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rR(\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/auth/OnboardingActionCardData;", "Landroid/os/Parcelable;", "actionCards", "", "Lcom/larus/bmhome/auth/OnboardingActionCardItemData;", "<init>", "(Ljava/util/List;)V", "getActionCards", "()Ljava/util/List;", "setActionCards", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "CardScene", "CardType", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OnboardingActionCardData implements Parcelable {
    public static final Parcelable.Creator<OnboardingActionCardData> CREATOR = null;

    @SerializedName("skill_cards")
    private List<OnboardingActionCardItemData> actionCards;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/auth/OnboardingActionCardData$CardScene;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "FirstMet", "ActionCard", "NewTopics", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CardScene extends Enum<CardScene> {
        public static final CardScene ActionCard = null;
        public static final CardScene FirstMet = null;
        public static final CardScene NewTopics = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CardScene[] f295733a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f295734b = null;
        private final int value;

        public static EnumEntries<CardScene> getEntries() {
            return f295734b;
        }

        static {
            CardScene r100 = new CardScene("FirstMet", 0, 1);
            FirstMet = r100;
            CardScene r101 = new CardScene("ActionCard", 1, 2);
            ActionCard = r101;
            CardScene r102 = new CardScene("NewTopics", 2, 3);
            NewTopics = r102;
            CardScene[] r103 = {r100, r101, r102};
            f295733a = r103;
            f295734b = EnumEntriesKt.enumEntries(r103);
        }

        public static CardScene[] values() {
            return (CardScene[]) f295733a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static CardScene valueOf(String r100) {
            return (CardScene) r27.a.a(CardScene.class, r100);
        }

        public CardScene(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/auth/OnboardingActionCardData$CardType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "AISearch", "Text2Img", "Music", "TextCreate", "ReadFile", "ImageRecognize", "ScanQuestion", "Universal", "toTea", "", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CardType extends Enum<CardType> {
        public static final CardType AISearch = null;
        public static final a Companion = null;
        public static final CardType ImageRecognize = null;
        public static final CardType Music = null;
        public static final CardType ReadFile = null;
        public static final CardType ScanQuestion = null;
        public static final CardType Text2Img = null;
        public static final CardType TextCreate = null;
        public static final CardType Universal = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CardType[] f295735a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f295736b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<CardType> getEntries() {
            return f295736b;
        }

        static {
            CardType r100 = new CardType("AISearch", 0, 1);
            AISearch = r100;
            CardType r101 = new CardType("Text2Img", 1, 2);
            Text2Img = r101;
            CardType r102 = new CardType("Music", 2, 3);
            Music = r102;
            CardType r103 = new CardType("TextCreate", 3, 4);
            TextCreate = r103;
            CardType r104 = new CardType("ReadFile", 4, 5);
            ReadFile = r104;
            CardType r110 = new CardType("ImageRecognize", 5, 6);
            ImageRecognize = r110;
            CardType r111 = new CardType("ScanQuestion", 6, 7);
            ScanQuestion = r111;
            CardType r112 = new CardType("Universal", 7, 8);
            Universal = r112;
            CardType[] r113 = {r100, r101, r102, r103, r104, r110, r111, r112};
            f295735a = r113;
            f295736b = EnumEntriesKt.enumEntries(r113);
            Companion = new a();
        }

        public static CardType[] values() {
            return (CardType[]) f295735a.clone();
        }

        public final String toTea() {
            switch(this.value) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                case 7: goto L6;
                case 8: goto L5;
                default: goto L4;
            };
        L4:
            return "";
        L5:
            return "universal";
        L6:
            return "edu_ocr";
        L7:
            return "ocr";
        L8:
            return "pdf_read";
        L9:
            return "text_creation";
        L10:
            return "music_creation";
        L11:
            return ImageInstantUploadPolicyFamily.IMAGE_CREATION;
        L12:
            return "ai_search";
        }

        public final int getValue() {
            return this.value;
        }

        public static CardType valueOf(String r100) {
            return (CardType) r27.a.a(CardType.class, r100);
        }

        public CardType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a implements Parcelable.Creator<OnboardingActionCardData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final OnboardingActionCardData createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            ArrayList r101 = null;
            if (r100.readInt() == 0) goto L14;
            int r102 = r100.readInt();
            ArrayList r103 = new ArrayList(r102);
            int r104 = 0;
        L6:
            if (r104 == r102) goto L12;
            if (r100.readInt() != 0) goto L10;
            OnboardingActionCardItemData r105 = null;
        L11:
            r103.add(r105);
            r104 = r104 + 1;
            goto L6
        L10:
            r105 = OnboardingActionCardItemData.CREATOR.createFromParcel(r100);
            goto L11
        L12:
            r101 = r103;
        L14:
            return new OnboardingActionCardData(r101);
        }

        @Override // android.os.Parcelable.Creator
        public final OnboardingActionCardData[] newArray(int r100) {
            return new OnboardingActionCardData[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public OnboardingActionCardData() {
        this(null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OnboardingActionCardData) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.actionCards, ((OnboardingActionCardData) r100).actionCards) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        List<OnboardingActionCardItemData> r100 = this.actionCards;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "OnboardingActionCardData(actionCards=" + this.actionCards + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        List<OnboardingActionCardItemData> r102 = this.actionCards;
        if (r102 != null) goto L5;
        r100.writeInt(0);
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<OnboardingActionCardItemData> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L19;
        OnboardingActionCardItemData r104 = r103.next();
        if (r104 == null) goto L10;
        r100.writeInt(1);
        r104.writeToParcel(r100, r101);
        goto L7
    L10:
        r100.writeInt(0);
        goto L7
    }

    public final List<OnboardingActionCardItemData> a() {
        return this.actionCards;
    }

    public OnboardingActionCardData(List<OnboardingActionCardItemData> r100) {
        this.actionCards = r100;
    }
}
