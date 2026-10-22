package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.app.AppEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000f\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003J\t\u0010+\u001a\u00020\bHÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\u001d\u0010.\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000fHÆ\u0003J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0003J\u0017\u00100\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0014HÆ\u0003J\u0097\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0014HÆ\u0001J\u0006\u00102\u001a\u000203J\u0013\u00104\u001a\u00020\u00052\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u000203HÖ\u0001J\t\u00108\u001a\u00020\bHÖ\u0001J\u0016\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u000203R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R0\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001f\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u0006>"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/AppIntentMessage;", "Landroid/os/Parcelable;", "dataSource", "Lcom/obric/aiagent/assistant/idl/bean/DataSource;", "isEnable", "", "needConfirm", "confirmNlg", "", "refuseNlg", "isPaused", "showRecentContact", "data", "Ljava/util/ArrayList;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lkotlin/collections/ArrayList;", "dataV2", "", "Lcom/obric/aiagent/assistant/idl/bean/AppIntentCardData;", "ext", "", "<init>", "(Lcom/obric/aiagent/assistant/idl/bean/DataSource;ZZLjava/lang/String;Ljava/lang/String;ZZLjava/util/ArrayList;Ljava/util/List;Ljava/util/Map;)V", "getDataSource", "()Lcom/obric/aiagent/assistant/idl/bean/DataSource;", "()Z", "getNeedConfirm", "getConfirmNlg", "()Ljava/lang/String;", "getRefuseNlg", "getShowRecentContact", "getData$annotations", "()V", "getData", "()Ljava/util/ArrayList;", "getDataV2", "()Ljava/util/List;", "getExt", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppIntentMessage implements Parcelable {
    public static final Parcelable.Creator<AppIntentMessage> CREATOR = null;
    private final String confirmNlg;
    private final ArrayList<AppEntity> data;
    private final DataSource dataSource;
    private final List<AppIntentCardData> dataV2;
    private final Map<String, String> ext;
    private final boolean isEnable;
    private final boolean isPaused;
    private final boolean needConfirm;
    private final String refuseNlg;
    private final boolean showRecentContact;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a implements Parcelable.Creator<AppIntentMessage> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AppIntentMessage createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            DataSource r100 = DataSource.CREATOR.createFromParcel(r110);
            int r101 = 0;
            if (r110.readInt() == 0) goto L5;
            boolean r102 = true;
        L7:
            if (r110.readInt() == 0) goto L9;
            boolean r103 = true;
        L10:
            String r104 = r110.readString();
            String r105 = r110.readString();
            if (r110.readInt() == 0) goto L13;
            boolean r106 = true;
        L15:
            if (r110.readInt() == 0) goto L17;
            boolean r107 = true;
        L18:
            LinkedHashMap r108 = null;
            if (r110.readInt() != 0) goto L21;
            ArrayList r111 = null;
        L25:
            if (r110.readInt() != 0) goto L27;
            ArrayList r112 = null;
        L31:
            if (r110.readInt() == 0) goto L37;
            int r109 = r110.readInt();
            r108 = new LinkedHashMap(r109);
        L34:
            if (r101 == r109) goto L37;
            r108.put(r110.readString(), r110.readString());
            r101 = r101 + 1;
        L37:
            return new AppIntentMessage(r100, r102, r103, r104, r105, r106, r107, r111, r112, r108);
        L27:
            int r113 = r110.readInt();
            r112 = new ArrayList(r113);
            int r114 = 0;
        L28:
            if (r114 == r113) goto L31;
            r112.add(AppIntentCardData.CREATOR.createFromParcel(r110));
            r114 = r114 + 1;
            goto L28
        L21:
            int r115 = r110.readInt();
            r111 = new ArrayList(r115);
            int r116 = 0;
        L22:
            if (r116 == r115) goto L25;
            r111.add(r110.readParcelable(AppIntentMessage.class.getClassLoader()));
            r116 = r116 + 1;
            goto L22
        L17:
            r107 = false;
            goto L18
        L13:
            r106 = false;
            goto L15
        L9:
            r103 = false;
            goto L10
        L5:
            r102 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final AppIntentMessage[] newArray(int r100) {
            return new AppIntentMessage[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppIntentMessage copy$default(AppIntentMessage r110, DataSource r111, boolean r112, boolean r113, String r114, String r115, boolean r116, boolean r117, ArrayList r118, List r210, Map r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        DataSource r100 = r110.dataSource;
    L7:
        if ((r212 & 2) == 0) goto L9;
        boolean r101 = r110.isEnable;
    L11:
        if ((r212 & 4) == 0) goto L13;
        boolean r102 = r110.needConfirm;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.confirmNlg;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r104 = r110.refuseNlg;
    L23:
        if ((r212 & 32) == 0) goto L25;
        boolean r105 = r110.isPaused;
    L27:
        if ((r212 & 64) == 0) goto L29;
        boolean r106 = r110.showRecentContact;
    L31:
        if ((r212 & 128) == 0) goto L33;
        ArrayList r107 = r110.data;
    L35:
        if ((r212 & 256) == 0) goto L37;
        List r119 = r110.dataV2;
    L39:
        if ((r212 & 512) == 0) goto L41;
        Map r108 = r110.ext;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    @Deprecated(message = "use dataV2 instead")
    public static /* synthetic */ void getData$annotations() {
    }

    public final DataSource component1() {
        return this.dataSource;
    }

    public final Map<String, String> component10() {
        return this.ext;
    }

    public final boolean component2() {
        return this.isEnable;
    }

    public final boolean component3() {
        return this.needConfirm;
    }

    public final String component4() {
        return this.confirmNlg;
    }

    public final String component5() {
        return this.refuseNlg;
    }

    public final boolean component6() {
        return this.isPaused;
    }

    public final boolean component7() {
        return this.showRecentContact;
    }

    public final ArrayList<AppEntity> component8() {
        return this.data;
    }

    public final List<AppIntentCardData> component9() {
        return this.dataV2;
    }

    public final AppIntentMessage copy(DataSource r110, boolean r111, boolean r112, String r113, String r114, boolean r115, boolean r116, ArrayList<AppEntity> r210, List<AppIntentCardData> r211, Map<String, String> r212) {
        Intrinsics.checkNotNullParameter(r110, "dataSource");
        Intrinsics.checkNotNullParameter(r113, "confirmNlg");
        Intrinsics.checkNotNullParameter(r114, "refuseNlg");
        return new AppIntentMessage(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AppIntentMessage) == true) goto L8;
        return false;
    L8:
        AppIntentMessage r101 = (AppIntentMessage) r100;
        if (Intrinsics.areEqual(this.dataSource, r101.dataSource) == true) goto L12;
        return false;
    L12:
        if (this.isEnable == r101.isEnable) goto L15;
        return false;
    L15:
        if (this.needConfirm == r101.needConfirm) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.confirmNlg, r101.confirmNlg) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.refuseNlg, r101.refuseNlg) == true) goto L24;
        return false;
    L24:
        if (this.isPaused == r101.isPaused) goto L27;
        return false;
    L27:
        if (this.showRecentContact == r101.showRecentContact) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.dataV2, r101.dataV2) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        int r100 = this.dataSource.hashCode() * 31;
        int r101 = 1231;
        if (this.isEnable == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.needConfirm == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (((((r103 + r104) * 31) + this.confirmNlg.hashCode()) * 31) + this.refuseNlg.hashCode()) * 31;
        if (this.isPaused == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.showRecentContact == true) goto L18;
        r101 = 1237;
    L18:
        int r108 = (r107 + r101) * 31;
        ArrayList<AppEntity> r109 = this.data;
        int r110 = 0;
        if (r109 != null) goto L21;
        int r111 = 0;
    L22:
        int r112 = (r108 + r111) * 31;
        List<AppIntentCardData> r113 = this.dataV2;
        if (r113 != null) goto L25;
        int r114 = 0;
    L26:
        int r115 = (r112 + r114) * 31;
        Map<String, String> r116 = this.ext;
        if (r116 == null) goto L31;
        r110 = r116.hashCode();
    L31:
        return r115 + r110;
    L25:
        r114 = r113.hashCode();
        goto L26
    L21:
        r111 = r109.hashCode();
        goto L22
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "AppIntentMessage(dataSource=" + this.dataSource + ", isEnable=" + this.isEnable + ", needConfirm=" + this.needConfirm + ", confirmNlg=" + this.confirmNlg + ", refuseNlg=" + this.refuseNlg + ", isPaused=" + this.isPaused + ", showRecentContact=" + this.showRecentContact + ", data=" + this.data + ", dataV2=" + this.dataV2 + ", ext=" + this.ext + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        this.dataSource.writeToParcel(r100, r101);
        r100.writeInt(this.isEnable ? 1 : 0);
        r100.writeInt(this.needConfirm ? 1 : 0);
        r100.writeString(this.confirmNlg);
        r100.writeString(this.refuseNlg);
        r100.writeInt(this.isPaused ? 1 : 0);
        r100.writeInt(this.showRecentContact ? 1 : 0);
        ArrayList<AppEntity> r102 = this.data;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L9:
        List<AppIntentCardData> r103 = this.dataV2;
        if (r103 != null) goto L12;
        r100.writeInt(0);
    L16:
        Map<String, String> r104 = this.ext;
        if (r104 != null) goto L19;
        r100.writeInt(0);
        return;
    L19:
        r100.writeInt(1);
        r100.writeInt(r104.size());
        Iterator<Map.Entry<String, String>> r105 = r104.entrySet().iterator();
    L21:
        if (r105.hasNext() == false) goto L27;
        Map.Entry<String, String> r106 = r105.next();
        r100.writeString(r106.getKey());
        r100.writeString(r106.getValue());
        goto L21
    L27:
        return;
    L12:
        r100.writeInt(1);
        r100.writeInt(r103.size());
        Iterator<AppIntentCardData> r107 = r103.iterator();
    L14:
        if (r107.hasNext() == false) goto L16;
        r107.next().writeToParcel(r100, r101);
        goto L14
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<AppEntity> r108 = r102.iterator();
    L7:
        if (r108.hasNext() == false) goto L9;
        r100.writeParcelable(r108.next(), r101);
        goto L7
    }

    public final String getConfirmNlg() {
        return this.confirmNlg;
    }

    public final ArrayList<AppEntity> getData() {
        return this.data;
    }

    public final DataSource getDataSource() {
        return this.dataSource;
    }

    public final List<AppIntentCardData> getDataV2() {
        return this.dataV2;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final boolean getNeedConfirm() {
        return this.needConfirm;
    }

    public final String getRefuseNlg() {
        return this.refuseNlg;
    }

    public final boolean getShowRecentContact() {
        return this.showRecentContact;
    }

    public final boolean isEnable() {
        return this.isEnable;
    }

    public final boolean isPaused() {
        return this.isPaused;
    }

    public AppIntentMessage(DataSource r100, boolean r101, boolean r102, String r103, String r104, boolean r105, boolean r106, ArrayList<AppEntity> r107, List<AppIntentCardData> r110, Map<String, String> r111) {
        Intrinsics.checkNotNullParameter(r100, "dataSource");
        Intrinsics.checkNotNullParameter(r103, "confirmNlg");
        Intrinsics.checkNotNullParameter(r104, "refuseNlg");
        this.dataSource = r100;
        this.isEnable = r101;
        this.needConfirm = r102;
        this.confirmNlg = r103;
        this.refuseNlg = r104;
        this.isPaused = r105;
        this.showRecentContact = r106;
        this.data = r107;
        this.dataV2 = r110;
        this.ext = r111;
    }

    public /* synthetic */ AppIntentMessage(DataSource r110, boolean r111, boolean r112, String r113, String r114, boolean r115, boolean r116, ArrayList r117, List r118, Map r210, int r211, DefaultConstructorMarker r212) {
        if ((r211 & 2) == 0) goto L5;
        boolean r100 = true;
    L6:
        boolean r101 = false;
        if ((r211 & 4) == 0) goto L9;
        boolean r102 = false;
    L10:
        String r103 = "";
        if ((r211 & 8) == 0) goto L13;
        String r104 = "";
    L15:
        if ((r211 & 16) != 0) goto L19;
        r103 = r114;
    L19:
        if ((r211 & 32) == 0) goto L21;
        boolean r105 = false;
    L23:
        if ((r211 & 64) != 0) goto L26;
        r101 = r116;
    L26:
        Map r106 = null;
        if ((r211 & 128) == 0) goto L29;
        ArrayList r107 = null;
    L31:
        if ((r211 & 256) == 0) goto L33;
        List r108 = null;
    L35:
        if ((r211 & 512) != 0) goto L38;
        r106 = r210;
    L38:
        this(r110, r100, r102, r104, r103, r105, r101, r107, r108, r106);
        return;
    L33:
        r108 = r118;
        goto L35
    L29:
        r107 = r117;
        goto L31
    L21:
        r105 = r115;
        goto L23
    L13:
        r104 = r113;
        goto L15
    L9:
        r102 = r112;
        goto L10
    L5:
        r100 = r111;
        goto L6
    }
}
