package com.obric.assistant.card.bean;

import com.obric.aiagent.assistant.idl.bean.DataSource;
import com.obric.capabilitykit.entity.app.AppEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0006\b\u0001\u0012\u00020\u000e0\rj\n\u0012\u0006\b\u0001\u0012\u00020\u000e`\u000f\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\u001d\u0010'\u001a\u0016\u0012\u0006\b\u0001\u0012\u00020\u000e0\rj\n\u0012\u0006\b\u0001\u0012\u00020\u000e`\u000fHÆ\u0003J\u0017\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0011HÆ\u0003J\u0085\u0001\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0006\b\u0001\u0012\u00020\u000e0\rj\n\u0012\u0006\b\u0001\u0012\u00020\u000e`\u000f2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0011HÆ\u0001J\u0013\u0010*\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R%\u0010\f\u001a\u0016\u0012\u0006\b\u0001\u0012\u00020\u000e0\rj\n\u0012\u0006\b\u0001\u0012\u00020\u000e`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001f\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00060"}, d2 = {"Lcom/obric/assistant/card/bean/HybridAppEntityMessage;", "Ljava/io/Serializable;", "dataSource", "Lcom/obric/aiagent/assistant/idl/bean/DataSource;", "isEnable", "", "needConfirm", "confirmNlg", "", "refuseNlg", "isPaused", "showRecentContact", "data", "Ljava/util/ArrayList;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lkotlin/collections/ArrayList;", "ext", "", "<init>", "(Lcom/obric/aiagent/assistant/idl/bean/DataSource;ZZLjava/lang/String;Ljava/lang/String;ZZLjava/util/ArrayList;Ljava/util/Map;)V", "getDataSource", "()Lcom/obric/aiagent/assistant/idl/bean/DataSource;", "()Z", "getNeedConfirm", "getConfirmNlg", "()Ljava/lang/String;", "getRefuseNlg", "getShowRecentContact", "getData", "()Ljava/util/ArrayList;", "getExt", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toString", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HybridAppEntityMessage implements Serializable {
    private final String confirmNlg;
    private final ArrayList<? extends AppEntity> data;
    private final DataSource dataSource;
    private final Map<String, String> ext;
    private final boolean isEnable;
    private final boolean isPaused;
    private final boolean needConfirm;
    private final String refuseNlg;
    private final boolean showRecentContact;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HybridAppEntityMessage copy$default(HybridAppEntityMessage r110, DataSource r111, boolean r112, boolean r113, String r114, String r115, boolean r116, boolean r117, ArrayList r118, Map r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        DataSource r100 = r110.dataSource;
    L7:
        if ((r210 & 2) == 0) goto L9;
        boolean r101 = r110.isEnable;
    L11:
        if ((r210 & 4) == 0) goto L13;
        boolean r102 = r110.needConfirm;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = r110.confirmNlg;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.refuseNlg;
    L23:
        if ((r210 & 32) == 0) goto L25;
        boolean r105 = r110.isPaused;
    L27:
        if ((r210 & 64) == 0) goto L29;
        boolean r106 = r110.showRecentContact;
    L31:
        if ((r210 & 128) == 0) goto L33;
        ArrayList r107 = r110.data;
    L35:
        if ((r210 & 256) == 0) goto L37;
        Map r108 = r110.ext;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
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

    public final DataSource component1() {
        return this.dataSource;
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

    public final ArrayList<? extends AppEntity> component8() {
        return this.data;
    }

    public final Map<String, String> component9() {
        return this.ext;
    }

    public final HybridAppEntityMessage copy(DataSource r110, boolean r111, boolean r112, String r113, String r114, boolean r115, boolean r116, ArrayList<? extends AppEntity> r117, Map<String, String> r210) {
        Intrinsics.checkNotNullParameter(r110, "dataSource");
        Intrinsics.checkNotNullParameter(r113, "confirmNlg");
        Intrinsics.checkNotNullParameter(r114, "refuseNlg");
        Intrinsics.checkNotNullParameter(r117, "data");
        return new HybridAppEntityMessage(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof HybridAppEntityMessage) == true) goto L8;
        return false;
    L8:
        HybridAppEntityMessage r101 = (HybridAppEntityMessage) r100;
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
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L35;
        return false;
    L35:
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
        int r108 = (((r107 + r101) * 31) + this.data.hashCode()) * 31;
        Map<String, String> r109 = this.ext;
        if (r109 != null) goto L21;
        int r110 = 0;
    L23:
        return r108 + r110;
    L21:
        r110 = r109.hashCode();
        goto L23
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
        return "HybridAppEntityMessage(dataSource=" + this.dataSource + ", isEnable=" + this.isEnable + ", needConfirm=" + this.needConfirm + ", confirmNlg=" + this.confirmNlg + ", refuseNlg=" + this.refuseNlg + ", isPaused=" + this.isPaused + ", showRecentContact=" + this.showRecentContact + ", data=" + this.data + ", ext=" + this.ext + ')';
    }

    public final String getConfirmNlg() {
        return this.confirmNlg;
    }

    public final ArrayList<? extends AppEntity> getData() {
        return this.data;
    }

    public final DataSource getDataSource() {
        return this.dataSource;
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

    public HybridAppEntityMessage(DataSource r100, boolean r101, boolean r102, String r103, String r104, boolean r105, boolean r106, ArrayList<? extends AppEntity> r107, Map<String, String> r110) {
        Intrinsics.checkNotNullParameter(r100, "dataSource");
        Intrinsics.checkNotNullParameter(r103, "confirmNlg");
        Intrinsics.checkNotNullParameter(r104, "refuseNlg");
        Intrinsics.checkNotNullParameter(r107, "data");
        this.dataSource = r100;
        this.isEnable = r101;
        this.needConfirm = r102;
        this.confirmNlg = r103;
        this.refuseNlg = r104;
        this.isPaused = r105;
        this.showRecentContact = r106;
        this.data = r107;
        this.ext = r110;
    }

    public /* synthetic */ HybridAppEntityMessage(DataSource r100, boolean r110, boolean r111, String r112, String r113, boolean r114, boolean r115, ArrayList r116, Map r117, int r118, DefaultConstructorMarker r119) {
        if ((r118 & 2) == 0) goto L5;
        boolean r101 = true;
    L6:
        boolean r102 = false;
        if ((r118 & 4) == 0) goto L9;
        boolean r103 = false;
    L10:
        String r104 = "";
        if ((r118 & 8) == 0) goto L13;
        String r105 = "";
    L15:
        if ((r118 & 16) != 0) goto L19;
        r104 = r113;
    L19:
        if ((r118 & 32) == 0) goto L21;
        boolean r106 = false;
    L23:
        if ((r118 & 64) != 0) goto L27;
        r102 = r115;
    L27:
        if ((r118 & 128) == 0) goto L29;
        ArrayList r107 = new ArrayList();
    L31:
        if ((r118 & 256) == 0) goto L33;
        Map r108 = null;
    L34:
        this(r100, r101, r103, r105, r104, r106, r102, r107, r108);
        return;
    L33:
        r108 = r117;
        goto L34
    L29:
        r107 = r116;
        goto L31
    L21:
        r106 = r114;
        goto L23
    L13:
        r105 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L10
    L5:
        r101 = r110;
        goto L6
    }
}
