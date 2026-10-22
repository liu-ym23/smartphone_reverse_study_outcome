package com.bytedance.ee.bear.bitable.pro;

import android.content.Context;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 )2\u00020\u0001:\u0001)BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0018\u001a\u00020\nJ\u0006\u0010\u0019\u001a\u00020\nJ\u0006\u0010\u001a\u001a\u00020\nJ\u0006\u0010\u001b\u001a\u00020\nJ\u0006\u0010\u001c\u001a\u00020\nJ\u0006\u0010\u001d\u001a\u00020\nJ\u0006\u0010\u001e\u001a\u00020\nJ\u0006\u0010\u001f\u001a\u00020\nJ\u0006\u0010 \u001a\u00020\nJ\u0006\u0010!\u001a\u00020\nJ\u000e\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$J\u0013\u0010%\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010'H\u0096\u0002J\b\u0010(\u001a\u00020\u0006H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014¨\u0006*"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/TableRole;", "Lcom/bytedance/ee/util/io/NonProguard;", "tableId", "", "tableName", "perm", "", "recRule", "Lcom/bytedance/ee/bear/bitable/pro/RecRule;", "hasFieldPerm", "", "otherRecRule", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILcom/bytedance/ee/bear/bitable/pro/RecRule;ZLcom/bytedance/ee/bear/bitable/pro/RecRule;)V", "getTableId", "()Ljava/lang/String;", "getTableName", "getPerm", "()I", "getRecRule", "()Lcom/bytedance/ee/bear/bitable/pro/RecRule;", "getHasFieldPerm", "()Z", "getOtherRecRule", "canRead", "canEdit", "canEditAllRowAndColumn", "canEditAllRow", "canEditPartAndReadOtherRow", "canEditPartAndReadPartRow", "canEditPartAndInvisibleOtherRow", "canReadAllRow", "canReadPartRow", "noPermission", "getPermDescV2", "context", "Landroid/content/Context;", "equals", "other", "", "hashCode", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TableRole implements NonProguard {
    public static final a Companion = null;
    private static final int PERM_EDIT = 2;
    private static final int PERM_FORBIDDEN = 0;
    private static final int PERM_MANAGER = 4;
    private static final int PERM_READ = 1;
    private final boolean hasFieldPerm;
    private final RecRule otherRecRule;
    private final int perm;
    private final RecRule recRule;
    private final String tableId;
    private final String tableName;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final boolean canEdit() {
        int r0 = this.perm;
        if (r0 != 2) goto L5;
    L8:
        return true;
    L5:
        if (r0 == 4) goto L8;
        return false;
    }

    public final boolean canEditAllRow() {
        if (this.perm == 2) goto L5;
    L7:
        return false;
    L5:
        if (this.recRule != null) goto L7;
        return true;
    }

    public final boolean canEditAllRowAndColumn() {
        if (this.perm != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean canEditPartAndInvisibleOtherRow() {
        RecRule r0 = this.recRule;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getPerm() == 2) goto L7;
        return false;
    L7:
        if (this.recRule.getOtherPerm() != 0) goto L20;
        RecRule r1 = this.otherRecRule;
        if (r1 == null) goto L16;
        if (r1 != null) goto L12;
    L14:
        boolean r2 = false;
    L15:
        if (r2 == true) goto L16;
        return false;
    L12:
        if (r1.getPerm() != 0) goto L14;
        r2 = true;
    L16:
        return true;
    L20:
        return false;
    }

    public final boolean canEditPartAndReadOtherRow() {
        RecRule r0 = this.recRule;
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.getPerm() != 2) goto L9;
        if (this.recRule.getOtherPerm() != 1) goto L9;
        return true;
    }

    public final boolean canEditPartAndReadPartRow() {
        RecRule r0 = this.recRule;
        if (r0 != null) goto L5;
    L13:
        return false;
    L5:
        if (r0.getPerm() != 2) goto L13;
        if (this.recRule.getOtherPerm() != 0) goto L13;
        RecRule r1 = this.otherRecRule;
        if (r1 == null) goto L13;
        if (r1.getPerm() != 1) goto L13;
        return true;
    }

    public final boolean canRead() {
        if (this.perm == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean canReadAllRow() {
        if (this.perm == 1) goto L5;
    L7:
        return false;
    L5:
        if (this.recRule != null) goto L7;
        return true;
    }

    public final boolean canReadPartRow() {
        if (this.perm == 1) goto L5;
    L7:
        return false;
    L5:
        if (this.recRule == null) goto L7;
        return true;
    }

    public int hashCode() {
        return this.tableId.hashCode();
    }

    public final boolean noPermission() {
        if (this.perm != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean getHasFieldPerm() {
        return this.hasFieldPerm;
    }

    public final RecRule getOtherRecRule() {
        return this.otherRecRule;
    }

    public final int getPerm() {
        return this.perm;
    }

    public final RecRule getRecRule() {
        return this.recRule;
    }

    public final String getTableId() {
        return this.tableId;
    }

    public final String getTableName() {
        return this.tableName;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 == null) goto L8;
        Class<?> r2 = r4.getClass();
    L10:
        if (Intrinsics.areEqual(TableRole.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.pro.TableRole");
        if (Intrinsics.areEqual(this.tableId, ((TableRole) r4).tableId) == true) goto L15;
        return false;
    L15:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public final String getPermDescV2(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (canEditAllRowAndColumn() == false) goto L6;
        int r0 = 2131886128;
    L25:
        return r2.getString(r0);
    L6:
        if (canEditAllRow() == false) goto L9;
        r0 = 2131886127;
        goto L25
    L9:
        if (canEditPartAndReadOtherRow() == false) goto L12;
        r0 = 2131886129;
        goto L25
    L12:
        if (canEditPartAndReadPartRow() == false) goto L15;
        r0 = 2131886230;
        goto L25
    L15:
        if (canEditPartAndInvisibleOtherRow() == false) goto L18;
        r0 = 2131886130;
        goto L25
    L18:
        if (canReadAllRow() == false) goto L21;
        r0 = 2131886131;
        goto L25
    L21:
        if (canReadPartRow() == false) goto L23;
        r0 = 2131886132;
        goto L25
    L23:
        r0 = 2131886110;
        goto L25
    }

    public TableRole(String r2, String r3, int r4, RecRule r5, boolean r6, RecRule r7) {
        Intrinsics.checkNotNullParameter(r2, "tableId");
        Intrinsics.checkNotNullParameter(r3, "tableName");
        this.tableId = r2;
        this.tableName = r3;
        this.perm = r4;
        this.recRule = r5;
        this.hasFieldPerm = r6;
        this.otherRecRule = r7;
    }

    public /* synthetic */ TableRole(String r10, String r11, int r12, RecRule r13, boolean r14, RecRule r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 1) == 0) goto L5;
        String r3 = "";
    L7:
        if ((r17 & 2) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r17 & 4) == 0) goto L13;
        int r5 = 0;
    L15:
        if ((r17 & 16) == 0) goto L17;
        boolean r7 = false;
    L19:
        if ((r17 & 32) == 0) goto L21;
        RecRule r8 = null;
    L22:
        this(r3, r4, r5, r13, r7, r8);
        return;
    L21:
        r8 = r16;
        goto L22
    L17:
        r7 = r14;
        goto L19
    L13:
        r5 = r12;
        goto L15
    L9:
        r4 = r11;
        goto L11
    L5:
        r3 = r10;
        goto L7
    }
}
