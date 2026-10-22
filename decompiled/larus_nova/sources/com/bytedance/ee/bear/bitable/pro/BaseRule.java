package com.bytedance.ee.bear.bitable.pro;

import android.content.Context;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.connect.common.Constants;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u00042\u00020\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\tJ\u0006\u0010\u000f\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/BaseRule;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "Ljava/io/Serializable;", "<init>", "()V", "enableCopy", "", "unsetCopy", "getCopyPermDesc", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "enableExport", "unsetExport", "getExportPermDesc", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BaseRule extends HashMap<String, Integer> implements Serializable {
    public final boolean enableCopy() {
        Integer r100 = (Integer) get("7");
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (1 != r100.intValue()) goto L8;
        return true;
    }

    public final boolean enableExport() {
        Integer r100 = (Integer) get(Constants.VIA_REPORT_TYPE_START_GROUP);
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (1 != r100.intValue()) goto L8;
        return true;
    }

    public final boolean unsetCopy() {
        Integer r100 = (Integer) get("7");
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if ((-1) != r100.intValue()) goto L8;
        return true;
    }

    public final boolean unsetExport() {
        Integer r100 = (Integer) get(Constants.VIA_REPORT_TYPE_START_GROUP);
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if ((-1) != r100.intValue()) goto L8;
        return true;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, Integer>> entrySet() {
        return getEntries();
    }

    public /* bridge */ Set<Map.Entry<String, Integer>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<Integer> getValues() {
        return super.values();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<Integer> values() {
        return getValues();
    }

    public BaseRule() {
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return false;
    L7:
        return containsKey((String) r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object r100) {
        if ((r100 instanceof Integer) == true) goto L7;
        return false;
    L7:
        return containsValue((Integer) r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Integer get(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r100);
    }

    public final String getCopyPermDesc(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (enableCopy() == false) goto L6;
        String r101 = r100.getString(R.string.Bitable_AdvancedPermissions_CopyBaseContent_Desc_Mob);
        Intrinsics.checkNotNull(r101);
        return r101;
    L6:
        if (unsetCopy() == false) goto L8;
        String r102 = r100.getString(R.string.Bitable_AdvancedPermissions_Unset_Desc_Mob);
        Intrinsics.checkNotNull(r102);
        return r102;
    L8:
        String r103 = r100.getString(R.string.Bitable_AdvancedPermissions_CannotCopyBaseContent_Desc_Mob);
        Intrinsics.checkNotNull(r103);
        return r103;
    }

    public final String getExportPermDesc(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (enableExport() == false) goto L6;
        String r101 = r100.getString(R.string.Bitable_AdvancedPermissions_MakeCopyDownloadPrintBase_Desc_Mob);
        Intrinsics.checkNotNull(r101);
        return r101;
    L6:
        if (unsetExport() == false) goto L8;
        String r102 = r100.getString(R.string.Bitable_AdvancedPermissions_Unset_Desc_Mob);
        Intrinsics.checkNotNull(r102);
        return r102;
    L8:
        String r103 = r100.getString(R.string.Bitable_AdvancedPermissions_NoMakingCopyAllowed_Desc_Mob);
        Intrinsics.checkNotNull(r103);
        return r103;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Integer remove(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r100);
    }

    public /* bridge */ boolean containsKey(String r100) {
        return super.containsKey(r100);
    }

    public /* bridge */ boolean containsValue(Integer r100) {
        return super.containsValue(r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r100);
    }

    public /* bridge */ Integer get(String r100) {
        return (Integer) super.get(r100);
    }

    public /* bridge */ Integer remove(String r100) {
        return (Integer) super.remove(r100);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object r100, Object r101) {
        if ((r100 instanceof String) == true) goto L6;
        return r101;
    L6:
        return getOrDefault((String) r100, (Integer) r101);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object r100, Object r101) {
        if ((r100 instanceof String) == true) goto L6;
        return false;
    L6:
        if ((r101 instanceof Integer) == true) goto L9;
        return false;
    L9:
        return remove((String) r100, (Integer) r101);
    }

    public final /* bridge */ Integer getOrDefault(Object r100, Integer r101) {
        if ((r100 instanceof String) == true) goto L6;
        return r101;
    L6:
        return getOrDefault((String) r100, r101);
    }

    public /* bridge */ boolean remove(String r100, Integer r101) {
        return super.remove(r100, r101);
    }

    public /* bridge */ Integer getOrDefault(String r100, Integer r101) {
        return (Integer) super.getOrDefault(r100, r101);
    }
}
