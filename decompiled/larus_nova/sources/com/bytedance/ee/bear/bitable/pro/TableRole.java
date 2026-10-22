package com.bytedance.ee.bear.bitable.pro;

import android.content.Context;
import com.bytedance.ee.util.io.NonProguard;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 )2\u00020\u0001:\u0001)BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0018\u001a\u00020\nJ\u0006\u0010\u0019\u001a\u00020\nJ\u0006\u0010\u001a\u001a\u00020\nJ\u0006\u0010\u001b\u001a\u00020\nJ\u0006\u0010\u001c\u001a\u00020\nJ\u0006\u0010\u001d\u001a\u00020\nJ\u0006\u0010\u001e\u001a\u00020\nJ\u0006\u0010\u001f\u001a\u00020\nJ\u0006\u0010 \u001a\u00020\nJ\u0006\u0010!\u001a\u00020\nJ\u000e\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$J\u0013\u0010%\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010'H\u0096\u0002J\b\u0010(\u001a\u00020\u0006H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014¨\u0006*"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/TableRole;", "Lcom/bytedance/ee/util/io/NonProguard;", "tableId", "", "tableName", "perm", "", "recRule", "Lcom/bytedance/ee/bear/bitable/pro/RecRule;", "hasFieldPerm", "", "otherRecRule", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILcom/bytedance/ee/bear/bitable/pro/RecRule;ZLcom/bytedance/ee/bear/bitable/pro/RecRule;)V", "getTableId", "()Ljava/lang/String;", "getTableName", "getPerm", "()I", "getRecRule", "()Lcom/bytedance/ee/bear/bitable/pro/RecRule;", "getHasFieldPerm", "()Z", "getOtherRecRule", "canRead", "canEdit", "canEditAllRowAndColumn", "canEditAllRow", "canEditPartAndReadOtherRow", "canEditPartAndReadPartRow", "canEditPartAndInvisibleOtherRow", "canReadAllRow", "canReadPartRow", "noPermission", "getPermDescV2", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "equals", "other", "", "hashCode", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
        int r100 = this.perm;
        if (r100 != 2) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 4) goto L8;
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
        RecRule r100 = this.recRule;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getPerm() == 2) goto L7;
        return false;
    L7:
        if (this.recRule.getOtherPerm() != 0) goto L20;
        RecRule r101 = this.otherRecRule;
        if (r101 == null) goto L16;
        if (r101 != null) goto L12;
    L14:
        boolean r102 = false;
    L15:
        if (r102 == true) goto L16;
        return false;
    L12:
        if (r101.getPerm() != 0) goto L14;
        r102 = true;
    L16:
        return true;
    L20:
        return false;
    }

    public final boolean canEditPartAndReadOtherRow() {
        RecRule r100 = this.recRule;
        if (r100 != null) goto L5;
    L9:
        return false;
    L5:
        if (r100.getPerm() != 2) goto L9;
        if (this.recRule.getOtherPerm() != 1) goto L9;
        return true;
    }

    public final boolean canEditPartAndReadPartRow() {
        RecRule r100 = this.recRule;
        if (r100 != null) goto L5;
    L13:
        return false;
    L5:
        if (r100.getPerm() != 2) goto L13;
        if (this.recRule.getOtherPerm() != 0) goto L13;
        RecRule r101 = this.otherRecRule;
        if (r101 == null) goto L13;
        if (r101.getPerm() != 1) goto L13;
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

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(TableRole.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.pro.TableRole");
        if (Intrinsics.areEqual(this.tableId, ((TableRole) r100).tableId) == true) goto L15;
        return false;
    L15:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final String getPermDescV2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (canEditAllRowAndColumn() == false) goto L6;
        int r101 = R.string.Bitable_AdvancedPermission_CanEditFieldAndRecord;
    L25:
        return r100.getString(r101);
    L6:
        if (canEditAllRow() == false) goto L9;
        r101 = R.string.Bitable_AdvancedPermission_CanEditAllRecord;
        goto L25
    L9:
        if (canEditPartAndReadOtherRow() == false) goto L12;
        r101 = R.string.Bitable_AdvancedPermission_CanEditSomeRecordAndViewOthers;
        goto L25
    L12:
        if (canEditPartAndReadPartRow() == false) goto L15;
        r101 = R.string.Bitable_AdvancedPermissions_Dashboard_EditOrViewRecords_Desc_Mob;
        goto L25
    L15:
        if (canEditPartAndInvisibleOtherRow() == false) goto L18;
        r101 = R.string.Bitable_AdvancedPermission_CanEditSomeRecordOnly;
        goto L25
    L18:
        if (canReadAllRow() == false) goto L21;
        r101 = R.string.Bitable_AdvancedPermission_CanViewAllRecord;
        goto L25
    L21:
        if (canReadPartRow() == false) goto L23;
        r101 = R.string.Bitable_AdvancedPermission_CanViewSomeRecord;
        goto L25
    L23:
        r101 = R.string.Bitable_AdvancedPermUpgrade_Docs_NoAccess_Radio;
        goto L25
    }

    public TableRole(String r100, String r101, int r102, RecRule r103, boolean r104, RecRule r105) {
        Intrinsics.checkNotNullParameter(r100, "tableId");
        Intrinsics.checkNotNullParameter(r101, "tableName");
        this.tableId = r100;
        this.tableName = r101;
        this.perm = r102;
        this.recRule = r103;
        this.hasFieldPerm = r104;
        this.otherRecRule = r105;
    }

    public /* synthetic */ TableRole(String r110, String r111, int r112, RecRule r113, boolean r114, RecRule r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r116 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r116 & 4) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r116 & 16) == 0) goto L17;
        boolean r103 = false;
    L19:
        if ((r116 & 32) == 0) goto L21;
        RecRule r104 = null;
    L22:
        this(r100, r101, r102, r113, r103, r104);
        return;
    L21:
        r104 = r115;
        goto L22
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
