package com.bytedance.mira.pm.filters;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
abstract class IntentFilterResolver<F extends IntentFilter, R> {
    private static final String TAG = "IntentFilterResolver";
    private static final Comparator mResolvePrioritySorter = null;
    private final HashMap<String, F[]> mActionToFilter;
    private final HashMap<String, F[]> mBaseTypeToFilter;
    private final HashSet<F> mFilters;
    private final HashMap<String, F[]> mSchemeToFilter;
    private final HashMap<String, F[]> mTypeToFilter;
    private final HashMap<String, F[]> mTypedActionToFilter;
    private final HashMap<String, F[]> mWildTypeToFilter;

    /* JADX INFO: loaded from: classes21.dex */
    public class IteratorWrapper implements Iterator<F> {
        private F mCur;
        private final Iterator<F> mI;
        final /* synthetic */ IntentFilterResolver this$0;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.mI.hasNext();
        }

        @Override // java.util.Iterator
        public F next() {
            F r100 = this.mI.next();
            this.mCur = r100;
            return r100;
        }

        @Override // java.util.Iterator
        public void remove() {
            F r100 = this.mCur;
            if (r100 == null) goto L5;
            IntentFilterResolver.access$000(this.this$0, r100);
        L5:
            this.mI.remove();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        public IteratorWrapper(IntentFilterResolver r100, Iterator<F> r101) {
            this.this$0 = r100;
            this.mI = r101;
        }
    }

    public boolean allowFilterResult(F r100, List<R> r101) {
        return true;
    }

    public abstract boolean isPackageForFilter(String r100, F r101);

    public abstract F[] newArray(int r100);

    /* JADX WARN: Multi-variable type inference failed */
    public R newResult(F r100, int r101, int r102) {
        return r100;
    }

    static {
        mResolvePrioritySorter = new AnonymousClass1();
    }

    public IntentFilterResolver() {
        this.mFilters = new HashSet();
        this.mSchemeToFilter = new HashMap();
        this.mTypeToFilter = new HashMap();
        this.mBaseTypeToFilter = new HashMap();
        this.mWildTypeToFilter = new HashMap();
        this.mActionToFilter = new HashMap();
        this.mTypedActionToFilter = new HashMap();
    }

    private void addFilterInternal(F r100) {
        int r101 = registerFilter(r100, r100.schemesIterator(), this.mSchemeToFilter);
        int r102 = registerMimeTypes(r100, r100.typesIterator());
        if (r101 != 0) goto L6;
        if (r102 != 0) goto L6;
        registerFilter(r100, r100.actionsIterator(), this.mActionToFilter);
    L6:
        if (r102 == 0) goto L9;
        registerFilter(r100, r100.actionsIterator(), this.mTypedActionToFilter);
        return;
    }

    private static HashSet<String> getFastIntentCategories(Intent r100) {
        Set<String> r101 = r100.getCategories();
        if (r101 != null) goto L6;
        return null;
    L6:
        HashSet<String> r102 = new HashSet();
        r102.addAll(r101);
        return r102;
    }

    private void removeFilterInternal(F r100) {
        int r101 = unregisterFilter(r100, r100.schemesIterator(), this.mSchemeToFilter);
        int r102 = unregisterMimeTypes(r100, r100.typesIterator());
        if (r101 != 0) goto L6;
        if (r102 != 0) goto L6;
        unregisterFilter(r100, r100.actionsIterator(), this.mActionToFilter);
    L6:
        if (r102 == 0) goto L9;
        unregisterFilter(r100, r100.actionsIterator(), this.mTypedActionToFilter);
        return;
    }

    public void addFilter(F r100) {
        this.mFilters.add(r100);
        addFilterInternal(r100);
    }

    public void removeFilter(F r100) {
        removeFilterInternal(r100);
        this.mFilters.remove(r100);
    }

    public void sortResults(List<R> r100) {
        Collections.sort(r100, mResolvePrioritySorter);
    }

    public static /* synthetic */ void access$000(IntentFilterResolver r100, IntentFilter r101) {
        r100.removeFilterInternal(r101);
    }

    private int registerMimeTypes(F r100, Iterator<String> r101) {
        if (r101 != null) goto L5;
        return 0;
    L5:
        int r102 = 0;
    L7:
        if (r101.hasNext() == false) goto L16;
        String r103 = r101.next();
        r102 = r102 + 1;
        int r104 = r103.indexOf(47);
        if (r104 <= 0) goto L11;
        String r105 = r103.substring(0, r104).intern();
    L12:
        addFilter(this.mTypeToFilter, r103, r100);
        if (r104 > 0) goto L14;
        addFilter(this.mWildTypeToFilter, r105, r100);
        goto L7
    L14:
        addFilter(this.mBaseTypeToFilter, r105, r100);
        goto L7
    L11:
        r105 = r103;
        r103 = r103.concat("/*");
        goto L12
    L16:
        return r102;
    }

    private int unregisterMimeTypes(F r100, Iterator<String> r101) {
        if (r101 != null) goto L5;
        return 0;
    L5:
        int r102 = 0;
    L7:
        if (r101.hasNext() == false) goto L16;
        String r103 = r101.next();
        r102 = r102 + 1;
        int r104 = r103.indexOf(47);
        if (r104 <= 0) goto L11;
        String r105 = r103.substring(0, r104).intern();
    L12:
        removeAllObjects(this.mTypeToFilter, r103, r100);
        if (r104 > 0) goto L14;
        removeAllObjects(this.mWildTypeToFilter, r105, r100);
        goto L7
    L14:
        removeAllObjects(this.mBaseTypeToFilter, r105, r100);
        goto L7
    L11:
        r105 = r103;
        r103 = r103.concat("/*");
        goto L12
    L16:
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void addFilter(HashMap<String, F[]> r100, String r101, F r102) {
        IntentFilter[] r103 = (IntentFilter[]) r100.get(r101);
        if (r103 != null) goto L5;
        IntentFilter[] r104 = newArray(2);
        r100.put(r101, r104);
        r104[0] = r102;
        return;
    L5:
        int r105 = r103.length;
        int r106 = r105;
    L6:
        if (r106 <= 0) goto L10;
        if (r103[r106 - 1] != null) goto L10;
        r106 = r106 - 1;
    L10:
        if (r106 >= r105) goto L12;
        r103[r106] = r102;
        return;
    L12:
        IntentFilter[] r107 = newArray((r105 * 3) / 2);
        System.arraycopy(r103, 0, r107, 0, r105);
        r107[r105] = r102;
        r100.put(r101, r107);
    }

    private int registerFilter(F r100, Iterator<String> r101, HashMap<String, F[]> r102) {
        int r103 = 0;
        if (r101 != null) goto L6;
        return 0;
    L6:
        if (r101.hasNext() == false) goto L8;
        r103 = r103 + 1;
        addFilter(r102, r101.next(), r100);
        goto L6
    L8:
        return r103;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void removeAllObjects(HashMap<String, F[]> r100, String r101, Object r102) {
        IntentFilter[] r103 = (IntentFilter[]) r100.get(r101);
        if (r103 == null) goto L29;
        int r104 = r103.length - 1;
    L5:
        if (r104 < 0) goto L9;
        if (r103[r104] != null) goto L9;
        r104 = r104 - 1;
    L9:
        int r105 = r104;
    L10:
        if (r104 < 0) goto L18;
        if (r103[r104] != r102) goto L17;
        int r106 = r105 - r104;
        if (r106 <= 0) goto L16;
        System.arraycopy(r103, r104 + 1, r103, r104, r106);
    L16:
        r103[r105] = null;
        r105 = r105 - 1;
    L17:
        r104 = r104 - 1;
        goto L10
    L18:
        if (r105 >= 0) goto L21;
        r100.remove(r101);
        return;
    L21:
        if (r105 >= (r103.length / 2)) goto L31;
        IntentFilter[] r107 = newArray(r105 + 2);
        System.arraycopy(r103, 0, r107, 0, r105 + 1);
        r100.put(r101, r107);
        return;
    L31:
        return;
    }

    private int unregisterFilter(F r100, Iterator<String> r101, HashMap<String, F[]> r102) {
        int r103 = 0;
        if (r101 != null) goto L6;
        return 0;
    L6:
        if (r101.hasNext() == false) goto L8;
        r103 = r103 + 1;
        removeAllObjects(r102, r101.next(), r100);
        goto L6
    L8:
        return r103;
    }

    public List<R> queryIntent(Intent r110, String r111, boolean r210, int r211) {
        String r112 = r110.getScheme();
        ArrayList r113 = new ArrayList();
        F[] r100 = null;
        if (r111 == null) goto L19;
        int r101 = r111.indexOf(47);
        if (r101 <= 0) goto L19;
        String r102 = r111.substring(0, r101);
        if (r102.equals("*") == true) goto L17;
        if (r111.length() == (r101 + 2)) goto L11;
    L14:
        F[] r103 = this.mTypeToFilter.get(r111);
        F[] r104 = this.mWildTypeToFilter.get(r102);
    L15:
        F[] r114 = r104;
        F[] r115 = this.mWildTypeToFilter.get("*");
    L21:
        if (r112 == null) goto L23;
        r100 = this.mSchemeToFilter.get(r112);
    L23:
        F[] r116 = r100;
        if (r111 != null) goto L29;
        if (r112 != null) goto L29;
        if (r110.getAction() == null) goto L29;
        F[] r105 = this.mActionToFilter.get(r110.getAction());
    L30:
        HashSet<String> r117 = getFastIntentCategories(r110);
        if (r105 == null) goto L33;
        buildResolveList(r110, r117, r210, r111, r112, r105, r113, r211);
    L33:
        if (r114 == null) goto L35;
        buildResolveList(r110, r117, r210, r111, r112, r114, r113, r211);
    L35:
        if (r115 == null) goto L37;
        buildResolveList(r110, r117, r210, r111, r112, r115, r113, r211);
    L37:
        if (r116 == null) goto L39;
        buildResolveList(r110, r117, r210, r111, r112, r116, r113, r211);
    L39:
        sortResults(r113);
        return r113;
    L29:
        r105 = r103;
        goto L30
    L11:
        if (r111.charAt(r101 + 1) != '*') goto L14;
        r103 = this.mBaseTypeToFilter.get(r102);
        r104 = this.mWildTypeToFilter.get(r102);
        goto L15
    L17:
        if (r110.getAction() == null) goto L19;
        r103 = this.mTypedActionToFilter.get(r110.getAction());
        r114 = null;
    L20:
        r115 = r114;
    L19:
        r103 = null;
        r114 = null;
        goto L20
    }

    public List<R> queryIntentFromList(Intent r110, String r111, boolean r112, ArrayList<F[]> r113, int r210) {
        ArrayList r100 = new ArrayList();
        HashSet<String> r114 = getFastIntentCategories(r110);
        String r115 = r110.getScheme();
        int r116 = r113.size();
        int r117 = 0;
    L3:
        if (r117 >= r116) goto L5;
        buildResolveList(r110, r114, r112, r111, r115, (IntentFilter[]) ListProtector.get(r113, r117), r100, r210);
        r117 = r117 + 1;
        goto L3
    L5:
        sortResults(r100);
        return r100;
    }

    private void buildResolveList(Intent r110, HashSet<String> r111, boolean r112, String r210, String r211, F[] r212, List<R> r213, int r214) {
        String r113 = r110.getAction();
        Uri r114 = r110.getData();
        String r115 = r110.getPackage();
        if (r212 == null) goto L5;
        int r116 = r212.length;
    L6:
        int r117 = 0;
    L7:
        if (r117 >= r116) goto L27;
        F r118 = r212[r117];
        if (r118 == null) goto L33;
        if (r115 == null) goto L15;
        if (isPackageForFilter(r115, r118) == true) goto L15;
    L26:
        r117 = r117 + 1;
    L15:
        if (allowFilterResult(r118, r213) == false) goto L26;
        int r100 = r118.match(r113, r210, r211, r114, r111, TAG);
        if (r100 < 0) goto L26;
        if (r112 == true) goto L21;
    L22:
        R r101 = newResult(r118, r100, r214);
        if (r101 == null) goto L26;
        r213.add(r101);
        goto L26
    L21:
        if (r118.hasCategory("android.intent.category.DEFAULT") == false) goto L26;
    L33:
        return;
    L27:
        return;
    L5:
        r116 = 0;
        goto L6
    }
}
