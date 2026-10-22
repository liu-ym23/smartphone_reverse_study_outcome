package com.bytedance.ee.bear.bitable.pro;

import android.content.Context;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u00042\u00020\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\tJ\u0006\u0010\u000f\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/BaseRule;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "Ljava/io/Serializable;", "<init>", "()V", "enableCopy", "", "unsetCopy", "getCopyPermDesc", "context", "Landroid/content/Context;", "enableExport", "unsetExport", "getExportPermDesc", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BaseRule extends HashMap<String, Integer> implements Serializable {
    public final boolean enableCopy() {
        Integer r0 = (Integer) get("7");
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (1 != r0.intValue()) goto L8;
        return true;
    }

    public final boolean enableExport() {
        Integer r0 = (Integer) get("17");
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (1 != r0.intValue()) goto L8;
        return true;
    }

    public final boolean unsetCopy() {
        Integer r0 = (Integer) get("7");
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if ((-1) != r0.intValue()) goto L8;
        return true;
    }

    public final boolean unsetExport() {
        Integer r0 = (Integer) get("17");
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if ((-1) != r0.intValue()) goto L8;
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
    public final /* bridge */ boolean containsKey(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return false;
    L7:
        return containsKey((String) r2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object r2) {
        if ((r2 instanceof Integer) == true) goto L7;
        return false;
    L7:
        return containsValue((Integer) r2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Integer get(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r2);
    }

    public final String getCopyPermDesc(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (enableCopy() == false) goto L6;
        String r3 = r2.getString(2131886226);
        Intrinsics.checkNotNull(r3);
        return r3;
    L6:
        if (unsetCopy() == false) goto L8;
        String r4 = r2.getString(2131886246);
        Intrinsics.checkNotNull(r4);
        return r4;
    L8:
        String r5 = r2.getString(2131886225);
        Intrinsics.checkNotNull(r5);
        return r5;
    }

    public final String getExportPermDesc(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (enableExport() == false) goto L6;
        String r3 = r2.getString(2131886235);
        Intrinsics.checkNotNull(r3);
        return r3;
    L6:
        if (unsetExport() == false) goto L8;
        String r4 = r2.getString(2131886246);
        Intrinsics.checkNotNull(r4);
        return r4;
    L8:
        String r5 = r2.getString(2131886241);
        Intrinsics.checkNotNull(r5);
        return r5;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Integer remove(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r2);
    }

    public /* bridge */ boolean containsKey(String r1) {
        return super.containsKey(r1);
    }

    public /* bridge */ boolean containsValue(Integer r1) {
        return super.containsValue(r1);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r2);
    }

    public /* bridge */ Integer get(String r1) {
        return (Integer) super.get(r1);
    }

    public /* bridge */ Integer remove(String r1) {
        return (Integer) super.remove(r1);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object r2, Object r3) {
        if ((r2 instanceof String) == true) goto L6;
        return r3;
    L6:
        return getOrDefault((String) r2, (Integer) r3);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object r3, Object r4) {
        if ((r3 instanceof String) == true) goto L6;
        return false;
    L6:
        if ((r4 instanceof Integer) == true) goto L9;
        return false;
    L9:
        return remove((String) r3, (Integer) r4);
    }

    public final /* bridge */ Integer getOrDefault(Object r2, Integer r3) {
        if ((r2 instanceof String) == true) goto L6;
        return r3;
    L6:
        return getOrDefault((String) r2, r3);
    }

    public /* bridge */ boolean remove(String r1, Integer r2) {
        return super.remove(r1, r2);
    }

    public /* bridge */ Integer getOrDefault(String r1, Integer r2) {
        return (Integer) super.getOrDefault(r1, r2);
    }
}
