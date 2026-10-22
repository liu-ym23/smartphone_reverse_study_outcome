package com.ss.android.lark.vote.message.content;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010%\u001a\u00020\r2\b\u0010&\u001a\u0004\u0018\u00010'H\u0096\u0002J\b\u0010(\u001a\u00020)H\u0016J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u0019\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bHÆ\u0003J\t\u0010/\u001a\u00020\rHÆ\u0003J\t\u00100\u001a\u00020\rHÆ\u0003Ja\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rHÆ\u0001J\t\u00102\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R*\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u000e\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010!\"\u0004\b$\u0010#¨\u00063"}, d2 = {"Lcom/ss/android/lark/vote/message/content/VoteOption;", "Ljava/io/Serializable;", "optionIndex", "", "content", "", "totalNum", "selectedNum", "users", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/vote/message/content/VoteUser;", "Lkotlin/collections/ArrayList;", "isSelected", "", "isEnable", "<init>", "(JLjava/lang/String;JJLjava/util/ArrayList;ZZ)V", "getOptionIndex", "()J", "setOptionIndex", "(J)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getTotalNum", "setTotalNum", "getSelectedNum", "setSelectedNum", "getUsers", "()Ljava/util/ArrayList;", "setUsers", "(Ljava/util/ArrayList;)V", "()Z", "setSelected", "(Z)V", "setEnable", "equals", "other", "", "hashCode", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "toString", "vote_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoteOption implements Serializable {
    private String content;
    private boolean isEnable;
    private boolean isSelected;
    private long optionIndex;
    private long selectedNum;
    private long totalNum;
    private ArrayList<VoteUser> users;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VoteOption copy$default(VoteOption r110, long r111, String r112, long r113, long r114, ArrayList r115, boolean r210, boolean r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        long r100 = r110.optionIndex;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r101 = r110.content;
    L11:
        if ((r212 & 4) == 0) goto L13;
        long r102 = r110.totalNum;
    L15:
        if ((r212 & 8) == 0) goto L17;
        long r103 = r110.selectedNum;
    L19:
        if ((r212 & 16) == 0) goto L21;
        ArrayList r104 = r110.users;
    L23:
        if ((r212 & 32) == 0) goto L25;
        boolean r105 = r110.isSelected;
    L27:
        if ((r212 & 64) == 0) goto L29;
        boolean r116 = r110.isEnable;
    L31:
        return r110.copy(r100, r101, r102, r103, r104, r105, r116);
    L29:
        r116 = r211;
        goto L31
    L25:
        r105 = r210;
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

    public final long component1() {
        return this.optionIndex;
    }

    public final String component2() {
        return this.content;
    }

    public final long component3() {
        return this.totalNum;
    }

    public final long component4() {
        return this.selectedNum;
    }

    public final ArrayList<VoteUser> component5() {
        return this.users;
    }

    public final boolean component6() {
        return this.isSelected;
    }

    public final boolean component7() {
        return this.isEnable;
    }

    public final VoteOption copy(long r110, String r111, long r112, long r113, ArrayList<VoteUser> r210, boolean r211, boolean r212) {
        Intrinsics.checkNotNullParameter(r210, "users");
        return new VoteOption(r110, r111, r112, r113, r210, r211, r212);
    }

    public String toString() {
        return "VoteOption(optionIndex=" + this.optionIndex + ", content=" + this.content + ", totalNum=" + this.totalNum + ", selectedNum=" + this.selectedNum + ", users=" + this.users + ", isSelected=" + this.isSelected + ", isEnable=" + this.isEnable + ')';
    }

    public int hashCode() {
        long r100 = this.optionIndex;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.content;
        if (r102 == null) goto L5;
        int r103 = r102.hashCode();
    L6:
        int r104 = (r101 + r103) * 31;
        int r105 = 1231;
        if (this.isSelected == false) goto L9;
        int r106 = 1231;
    L10:
        int r107 = (r104 + r106) * 31;
        boolean r108 = this.isEnable;
        if (r108 == true) goto L14;
        r105 = 1237;
    L14:
        int r109 = r107 + r105;
        if (r108 == true) goto L18;
        long r110 = this.totalNum;
        int r111 = ((r109 * 31) + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        long r112 = this.selectedNum;
        return ((r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31) + this.users.hashCode();
    L18:
        return r109;
    L9:
        r106 = 1237;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String getContent() {
        return this.content;
    }

    public final long getOptionIndex() {
        return this.optionIndex;
    }

    public final long getSelectedNum() {
        return this.selectedNum;
    }

    public final long getTotalNum() {
        return this.totalNum;
    }

    public final ArrayList<VoteUser> getUsers() {
        return this.users;
    }

    public final boolean isEnable() {
        return this.isEnable;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public boolean equals(Object r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L29:
        return false;
    L5:
        if ((r100 instanceof VoteOption) == false) goto L29;
        VoteOption r102 = (VoteOption) r100;
        if (this.optionIndex == r102.optionIndex) goto L10;
    L16:
        boolean r103 = false;
    L18:
        if (this.isEnable == true) goto L30;
        if (r103 == false) goto L28;
        if (this.totalNum != r102.totalNum) goto L28;
        if (this.selectedNum != r102.selectedNum) goto L28;
        if (Intrinsics.areEqual(this.users, r102.users) == false) goto L28;
        r101 = true;
    L28:
        return r101;
    L30:
        return r103;
    L10:
        if (Intrinsics.areEqual(this.content, r102.content) == false) goto L16;
        if (this.isSelected != r102.isSelected) goto L16;
        if (this.isEnable != r102.isEnable) goto L16;
        r103 = true;
        goto L18
    }

    public final void setContent(String r100) {
        this.content = r100;
    }

    public final void setEnable(boolean r100) {
        this.isEnable = r100;
    }

    public final void setOptionIndex(long r100) {
        this.optionIndex = r100;
    }

    public final void setSelected(boolean r100) {
        this.isSelected = r100;
    }

    public final void setSelectedNum(long r100) {
        this.selectedNum = r100;
    }

    public final void setTotalNum(long r100) {
        this.totalNum = r100;
    }

    public final void setUsers(ArrayList<VoteUser> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.users = r100;
    }

    public VoteOption(long r100, String r101, long r102, long r103, ArrayList<VoteUser> r104, boolean r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r104, "users");
        this.optionIndex = r100;
        this.content = r101;
        this.totalNum = r102;
        this.selectedNum = r103;
        this.users = r104;
        this.isSelected = r110;
        this.isEnable = r111;
    }
}
