package com.bytedance.android.shopping.model;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.common.utility.StringUtils;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b4\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u008d\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\u000b\u00107\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u00108\u001a\u00020\nHÆ\u0003J\t\u00109\u001a\u00020\nHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010\u001eJ\t\u0010<\u001a\u00020\u0006HÆ\u0003J\t\u0010=\u001a\u00020\u0006HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010?\u001a\u00020\nHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010A\u001a\u00020\nHÆ\u0003J\t\u0010B\u001a\u00020\nHÆ\u0003J\t\u0010C\u001a\u00020\nHÆ\u0003J\u009a\u0001\u0010D\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u0010EJ\u0013\u0010F\u001a\u00020\n2\b\u0010G\u001a\u0004\u0018\u00010HHÖ\u0003J\t\u0010I\u001a\u00020\u0013HÖ\u0001J\u0006\u0010J\u001a\u00020\nJ\t\u0010K\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001a\"\u0004\b&\u0010\u001cR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001cR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001a\"\u0004\b*\u0010\u001cR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001a\"\u0004\b,\u0010\u001cR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\"\"\u0004\b.\u0010$R\u001a\u0010\f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\"\"\u0004\b0\u0010$R\u001a\u0010\u0010\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\"\"\u0004\b2\u0010$R\u001a\u0010\u000e\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\"\"\u0004\b4\u0010$R\u001a\u0010\r\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\"\"\u0004\b6\u0010$¨\u0006L"}, d2 = {"Lcom/bytedance/android/shopping/model/CommerceUser;", "Ljava/io/Serializable;", "()V", "avatarMedium", "Lcom/bytedance/android/ec/model/ECUrlModel;", "uid", "", "secUid", "nickname", "isHasOrders", "", "bindPhone", "withCommerceRights", "withShopEntry", "withNewGoods", "withCommerceNewbieTask", "withItemCommerceEntry", "shopMicroApp", "followStatus", "", "(Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZZZZZLjava/lang/String;Ljava/lang/Integer;)V", "getAvatarMedium", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setAvatarMedium", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "getBindPhone", "()Ljava/lang/String;", "setBindPhone", "(Ljava/lang/String;)V", "getFollowStatus", "()Ljava/lang/Integer;", "setFollowStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "()Z", "setHasOrders", "(Z)V", "getNickname", "setNickname", "getSecUid", "setSecUid", "getShopMicroApp", "setShopMicroApp", "getUid", "setUid", "getWithCommerceNewbieTask", "setWithCommerceNewbieTask", "getWithCommerceRights", "setWithCommerceRights", "getWithItemCommerceEntry", "setWithItemCommerceEntry", "getWithNewGoods", "setWithNewGoods", "getWithShopEntry", "setWithShopEntry", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZZZZZLjava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/model/CommerceUser;", "equals", "other", "", "hashCode", "isMe", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommerceUser implements Serializable {
    private ECUrlModel avatarMedium;
    private String bindPhone;
    private Integer followStatus;
    private boolean isHasOrders;
    private String nickname;
    private String secUid;
    private String shopMicroApp;
    private String uid;
    private boolean withCommerceNewbieTask;
    private boolean withCommerceRights;
    private boolean withItemCommerceEntry;
    private boolean withNewGoods;
    private boolean withShopEntry;

    public CommerceUser() {
        this(null, "", "", "", false, "", false, false, false, false, false, null, null, 7680, null);
    }

    public static /* synthetic */ CommerceUser copy$default(CommerceUser r14, ECUrlModel r15, String r16, String r17, String r18, boolean r19, String r20, boolean r21, boolean r22, boolean r23, boolean r24, boolean r25, String r26, Integer r27, int r28, Object r29) {
        if ((r28 & 1) == 0) goto L5;
        ECUrlModel r2 = r14.avatarMedium;
    L7:
        if ((r28 & 2) == 0) goto L9;
        String r3 = r14.uid;
    L11:
        if ((r28 & 4) == 0) goto L13;
        String r4 = r14.secUid;
    L15:
        if ((r28 & 8) == 0) goto L17;
        String r5 = r14.nickname;
    L19:
        if ((r28 & 16) == 0) goto L21;
        boolean r6 = r14.isHasOrders;
    L23:
        if ((r28 & 32) == 0) goto L25;
        String r7 = r14.bindPhone;
    L27:
        if ((r28 & 64) == 0) goto L29;
        boolean r8 = r14.withCommerceRights;
    L31:
        if ((r28 & 128) == 0) goto L33;
        boolean r9 = r14.withShopEntry;
    L35:
        if ((r28 & 256) == 0) goto L37;
        boolean r10 = r14.withNewGoods;
    L39:
        if ((r28 & 512) == 0) goto L41;
        boolean r11 = r14.withCommerceNewbieTask;
    L43:
        if ((r28 & 1024) == 0) goto L45;
        boolean r12 = r14.withItemCommerceEntry;
    L47:
        if ((r28 & 2048) == 0) goto L49;
        String r13 = r14.shopMicroApp;
    L51:
        if ((r28 & 4096) == 0) goto L53;
        Integer r1 = r14.followStatus;
    L55:
        return r14.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r1);
    L53:
        r1 = r27;
        goto L55
    L49:
        r13 = r26;
        goto L51
    L45:
        r12 = r25;
        goto L47
    L41:
        r11 = r24;
        goto L43
    L37:
        r10 = r23;
        goto L39
    L33:
        r9 = r22;
        goto L35
    L29:
        r8 = r21;
        goto L31
    L25:
        r7 = r20;
        goto L27
    L21:
        r6 = r19;
        goto L23
    L17:
        r5 = r18;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r3 = r16;
        goto L11
    L5:
        r2 = r15;
        goto L7
    }

    public final ECUrlModel component1() {
        return this.avatarMedium;
    }

    public final boolean component10() {
        return this.withCommerceNewbieTask;
    }

    public final boolean component11() {
        return this.withItemCommerceEntry;
    }

    public final String component12() {
        return this.shopMicroApp;
    }

    public final Integer component13() {
        return this.followStatus;
    }

    public final String component2() {
        return this.uid;
    }

    public final String component3() {
        return this.secUid;
    }

    public final String component4() {
        return this.nickname;
    }

    public final boolean component5() {
        return this.isHasOrders;
    }

    public final String component6() {
        return this.bindPhone;
    }

    public final boolean component7() {
        return this.withCommerceRights;
    }

    public final boolean component8() {
        return this.withShopEntry;
    }

    public final boolean component9() {
        return this.withNewGoods;
    }

    public final CommerceUser copy(ECUrlModel r16, String r17, String r18, String r19, boolean r20, String r21, boolean r22, boolean r23, boolean r24, boolean r25, boolean r26, String r27, Integer r28) {
        Intrinsics.checkNotNullParameter(r17, "uid");
        Intrinsics.checkNotNullParameter(r18, "secUid");
        return new CommerceUser(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof CommerceUser) == false) goto L32;
        CommerceUser r4 = (CommerceUser) r3;
        if (Intrinsics.areEqual(this.avatarMedium, r4.avatarMedium) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.uid, r4.uid) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.secUid, r4.secUid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.nickname, r4.nickname) == true) goto L14;
        return false;
    L14:
        if (this.isHasOrders == r4.isHasOrders) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.bindPhone, r4.bindPhone) == true) goto L18;
        return false;
    L18:
        if (this.withCommerceRights == r4.withCommerceRights) goto L20;
        return false;
    L20:
        if (this.withShopEntry == r4.withShopEntry) goto L22;
        return false;
    L22:
        if (this.withNewGoods == r4.withNewGoods) goto L24;
        return false;
    L24:
        if (this.withCommerceNewbieTask == r4.withCommerceNewbieTask) goto L26;
        return false;
    L26:
        if (this.withItemCommerceEntry == r4.withItemCommerceEntry) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.shopMicroApp, r4.shopMicroApp) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.followStatus, r4.followStatus) == true) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15, types: [int] */
    /* JADX WARN: Type inference failed for: r2v17, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19, types: [int] */
    /* JADX WARN: Type inference failed for: r2v21, types: [int] */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        ECUrlModel r0 = this.avatarMedium;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.uid;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.secUid;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.nickname;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        boolean r13 = this.isHasOrders;
        ?? r14 = 1;
        ?? r15 = r13;
        if (r13 == false) goto L21;
        r15 = 1;
    L21:
        int r16 = (r12 + r15) * 31;
        String r17 = this.bindPhone;
        if (r17 == null) goto L24;
        int r18 = r17.hashCode();
    L25:
        int r19 = (r16 + r18) * 31;
        boolean r20 = this.withCommerceRights;
        ?? r21 = r20;
        if (r20 == false) goto L28;
        r21 = 1;
    L28:
        int r22 = (r19 + r21) * 31;
        boolean r23 = this.withShopEntry;
        ?? r24 = r23;
        if (r23 == false) goto L31;
        r24 = 1;
    L31:
        int r25 = (r22 + r24) * 31;
        boolean r26 = this.withNewGoods;
        ?? r27 = r26;
        if (r26 == false) goto L34;
        r27 = 1;
    L34:
        int r28 = (r25 + r27) * 31;
        boolean r29 = this.withCommerceNewbieTask;
        ?? r30 = r29;
        if (r29 == false) goto L37;
        r30 = 1;
    L37:
        int r31 = (r28 + r30) * 31;
        boolean r32 = this.withItemCommerceEntry;
        if (r32 == true) goto L41;
        r14 = r32;
    L41:
        int r33 = (r31 + r14) * 31;
        String r34 = this.shopMicroApp;
        if (r34 == null) goto L44;
        int r35 = r34.hashCode();
    L45:
        int r36 = (r33 + r35) * 31;
        Integer r37 = this.followStatus;
        if (r37 == null) goto L49;
        r1 = r37.hashCode();
    L49:
        return r36 + r1;
    L44:
        r35 = 0;
        goto L45
    L24:
        r18 = 0;
        goto L25
    L17:
        r11 = 0;
        goto L18
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

    public String toString() {
        return "CommerceUser(avatarMedium=" + this.avatarMedium + ", uid=" + this.uid + ", secUid=" + this.secUid + ", nickname=" + this.nickname + ", isHasOrders=" + this.isHasOrders + ", bindPhone=" + this.bindPhone + ", withCommerceRights=" + this.withCommerceRights + ", withShopEntry=" + this.withShopEntry + ", withNewGoods=" + this.withNewGoods + ", withCommerceNewbieTask=" + this.withCommerceNewbieTask + ", withItemCommerceEntry=" + this.withItemCommerceEntry + ", shopMicroApp=" + this.shopMicroApp + ", followStatus=" + this.followStatus + ")";
    }

    public final boolean isMe() {
        return StringUtils.equal(this.uid, r.a.getCurrentUserId());
    }

    public final ECUrlModel getAvatarMedium() {
        return this.avatarMedium;
    }

    public final String getBindPhone() {
        return this.bindPhone;
    }

    public final Integer getFollowStatus() {
        return this.followStatus;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final String getSecUid() {
        return this.secUid;
    }

    public final String getShopMicroApp() {
        return this.shopMicroApp;
    }

    public final String getUid() {
        return this.uid;
    }

    public final boolean getWithCommerceNewbieTask() {
        return this.withCommerceNewbieTask;
    }

    public final boolean getWithCommerceRights() {
        return this.withCommerceRights;
    }

    public final boolean getWithItemCommerceEntry() {
        return this.withItemCommerceEntry;
    }

    public final boolean getWithNewGoods() {
        return this.withNewGoods;
    }

    public final boolean getWithShopEntry() {
        return this.withShopEntry;
    }

    public final boolean isHasOrders() {
        return this.isHasOrders;
    }

    public final void setAvatarMedium(ECUrlModel r1) {
        this.avatarMedium = r1;
    }

    public final void setBindPhone(String r1) {
        this.bindPhone = r1;
    }

    public final void setFollowStatus(Integer r1) {
        this.followStatus = r1;
    }

    public final void setHasOrders(boolean r1) {
        this.isHasOrders = r1;
    }

    public final void setNickname(String r1) {
        this.nickname = r1;
    }

    public final void setSecUid(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.secUid = r2;
    }

    public final void setShopMicroApp(String r1) {
        this.shopMicroApp = r1;
    }

    public final void setUid(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.uid = r2;
    }

    public final void setWithCommerceNewbieTask(boolean r1) {
        this.withCommerceNewbieTask = r1;
    }

    public final void setWithCommerceRights(boolean r1) {
        this.withCommerceRights = r1;
    }

    public final void setWithItemCommerceEntry(boolean r1) {
        this.withItemCommerceEntry = r1;
    }

    public final void setWithNewGoods(boolean r1) {
        this.withNewGoods = r1;
    }

    public final void setWithShopEntry(boolean r1) {
        this.withShopEntry = r1;
    }

    public CommerceUser(ECUrlModel r2, String r3, String r4, String r5, boolean r6, String r7, boolean r8, boolean r9, boolean r10, boolean r11, boolean r12, String r13, Integer r14) {
        Intrinsics.checkNotNullParameter(r3, "uid");
        Intrinsics.checkNotNullParameter(r4, "secUid");
        this.avatarMedium = r2;
        this.uid = r3;
        this.secUid = r4;
        this.nickname = r5;
        this.isHasOrders = r6;
        this.bindPhone = r7;
        this.withCommerceRights = r8;
        this.withShopEntry = r9;
        this.withNewGoods = r10;
        this.withCommerceNewbieTask = r11;
        this.withItemCommerceEntry = r12;
        this.shopMicroApp = r13;
        this.followStatus = r14;
    }

    public /* synthetic */ CommerceUser(ECUrlModel r18, String r19, String r20, String r21, boolean r22, String r23, boolean r24, boolean r25, boolean r26, boolean r27, boolean r28, String r29, Integer r30, int r31, DefaultConstructorMarker r32) {
        if ((r31 & 2) == 0) goto L5;
        String r5 = "";
    L7:
        if ((r31 & 4) == 0) goto L9;
        String r6 = "";
    L11:
        if ((r31 & 8) == 0) goto L13;
        String r7 = "";
    L15:
        if ((r31 & 32) == 0) goto L17;
        String r9 = "";
    L19:
        if ((r31 & 64) == 0) goto L21;
        boolean r10 = false;
    L23:
        if ((r31 & 128) == 0) goto L25;
        boolean r11 = false;
    L27:
        if ((r31 & 256) == 0) goto L29;
        boolean r12 = false;
    L31:
        if ((r31 & 512) == 0) goto L33;
        boolean r13 = false;
    L35:
        if ((r31 & 1024) == 0) goto L37;
        boolean r14 = false;
    L39:
        if ((r31 & 2048) == 0) goto L41;
        String r15 = "";
    L43:
        if ((r31 & 4096) == 0) goto L45;
        Integer r16 = -1;
    L46:
        this(r18, r5, r6, r7, r22, r9, r10, r11, r12, r13, r14, r15, r16);
        return;
    L45:
        r16 = r30;
        goto L46
    L41:
        r15 = r29;
        goto L43
    L37:
        r14 = r28;
        goto L39
    L33:
        r13 = r27;
        goto L35
    L29:
        r12 = r26;
        goto L31
    L25:
        r11 = r25;
        goto L27
    L21:
        r10 = r24;
        goto L23
    L17:
        r9 = r23;
        goto L19
    L13:
        r7 = r21;
        goto L15
    L9:
        r6 = r20;
        goto L11
    L5:
        r5 = r19;
        goto L7
    }
}
