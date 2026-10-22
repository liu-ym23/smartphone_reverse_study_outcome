package com.bytedance.android.shopping.mall.settings;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0012R.\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/mall/settings/a;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "pageName", "Ljava/util/ArrayList;", "getPageName", "()Ljava/util/ArrayList;", "", "useWhiteBoard", "Ljava/lang/Integer;", "getUseWhiteBoard", "()Ljava/lang/Integer;", "pauseToStop", "getPauseToStop", "delayRemoveUnExposure", "getDelayRemoveUnExposure", "a", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("delay_remove_un_exposure")
    private final Integer delayRemoveUnExposure;

    @SerializedName(PdpOpenThirdParam.KEY_PAGE_NAME)
    private final ArrayList<String> pageName;

    @SerializedName("pause_to_stop")
    private final Integer pauseToStop;

    @SerializedName("use_white_board")
    private final Integer useWhiteBoard;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.settings.a$a, reason: collision with other inner class name */
    public static final class C0112a {
    }

    static {
    }

    public a() {
        this(null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L14;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.pageName, r4.pageName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.useWhiteBoard, r4.useWhiteBoard) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.pauseToStop, r4.pauseToStop) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.delayRemoveUnExposure, r4.delayRemoveUnExposure) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        ArrayList<String> r0 = this.pageName;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.useWhiteBoard;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.pauseToStop;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.delayRemoveUnExposure;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "EnterPdOptSetting(pageName=" + this.pageName + ", useWhiteBoard=" + this.useWhiteBoard + ", pauseToStop=" + this.pauseToStop + ", delayRemoveUnExposure=" + this.delayRemoveUnExposure + ")";
    }

    public a(Object r1) {
        this.pageName = null;
        this.useWhiteBoard = null;
        this.pauseToStop = null;
        this.delayRemoveUnExposure = null;
    }

    public final boolean a(String r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        ArrayList<String> r1 = this.pageName;
        if (r1 != null) goto L8;
    L9:
        ArrayList<String> r2 = this.pageName;
        if (r2 != null) goto L12;
        return false;
    L12:
        if (r2.contains(r5) != true) goto L21;
    L13:
        Integer r6 = this.delayRemoveUnExposure;
        if (r6 != null) goto L17;
        return false;
    L17:
        if (r6.intValue() != 1) goto L22;
        return true;
    L22:
        return false;
    L21:
        return false;
    L8:
        if (r1.contains("all_page") == true) goto L13;
        goto L9
    }

    public final boolean b(String r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        ArrayList<String> r1 = this.pageName;
        if (r1 != null) goto L8;
    L9:
        ArrayList<String> r2 = this.pageName;
        if (r2 != null) goto L12;
        return false;
    L12:
        if (r2.contains(r5) != true) goto L21;
    L13:
        Integer r6 = this.pauseToStop;
        if (r6 != null) goto L17;
        return false;
    L17:
        if (r6.intValue() != 1) goto L22;
        return true;
    L22:
        return false;
    L21:
        return false;
    L8:
        if (r1.contains("all_page") == true) goto L13;
        goto L9
    }

    public final boolean c(String r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        ArrayList<String> r1 = this.pageName;
        if (r1 != null) goto L8;
    L9:
        ArrayList<String> r2 = this.pageName;
        if (r2 != null) goto L12;
        return false;
    L12:
        if (r2.contains(r5) != true) goto L21;
    L13:
        Integer r6 = this.useWhiteBoard;
        if (r6 != null) goto L17;
        return false;
    L17:
        if (r6.intValue() != 1) goto L22;
        return true;
    L22:
        return false;
    L21:
        return false;
    L8:
        if (r1.contains("all_page") == true) goto L13;
        goto L9
    }
}
