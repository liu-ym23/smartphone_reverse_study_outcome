package com.bytedance.ee.bear.sheet.panel;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.document.export.ExportPlugin;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel;
import com.bytedance.ee.bear.sheet.panel.SheetItem;
import g45.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes18.dex */
public abstract class BaseCellPanelViewModel<T extends SheetItem> extends BaseEditPanelViewModel {
    private static final String TAG = "BaseCellPanelViewModel";
    private String[] badges;
    private a mDelegate;
    private MutableLiveData<T[]> mItems;
    private List<String> mNewSubItems;
    private Map<String, MutableLiveData<T[]>> mSubItems;
    private Map<String, String> mTitles;

    public interface a {
        <V> void a(String r100, V r101);
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public abstract /* synthetic */ int getPanelHeight(Context r100);

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public abstract /* synthetic */ String getPanelName();

    private void removeUnusedSubItems() {
        Iterator<String> r100 = this.mSubItems.keySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        String r101 = r100.next();
        if (this.mNewSubItems.contains(r101) == true) goto L4;
        this.mSubItems.get(r101).setValue(null);
        r100.remove();
        goto L4
    }

    public BaseCellPanelViewModel() {
        this.mItems = new MutableLiveData();
        this.mSubItems = new HashMap();
        this.mNewSubItems = new ArrayList();
        this.mTitles = new HashMap();
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.ALWAYS_SHOW;
    }

    public MutableLiveData<T[]> getTopItems() {
        return this.mItems;
    }

    private void updateSubItems(T[] r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L11;
        T r103 = r100[r102];
        SheetItem[] r104 = r103.getItems();
        if (r104 != null) goto L7;
    L9:
        this.mTitles.put(r103.getId(), r103.getTitle());
    L10:
        r102 = r102 + 1;
        goto L3
    L7:
        if (r104.length <= 0) goto L9;
        SheetItem.sortByGroupId(r104);
        this.mNewSubItems.add(r103.getId());
        getSubItems(r103.getId()).setValue(r104);
        this.mTitles.put(r103.getId(), r103.getTitle());
        updateSubItems(r104);
        goto L10
    }

    public void clearBadges(String r100) {
        if (showBadges(r100) == false) goto L6;
        JSONObject r101 = new JSONObject();
        r101.put2("panelName", getPanelName());
        r101.put2("badges", new String[]{r100});
        execJS(ExportPlugin.BIZ_SHEET_CLEAR_BADGES, r101);
        tt5.a.b(TAG, "clear badges: " + r101.toJSONString());
        return;
    }

    public String getPanelTitle(String r100) {
        String r101 = this.mTitles.get(r100);
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101;
    }

    public MutableLiveData<T[]> getSubItems(String r100) {
        MutableLiveData<T[]> r101 = this.mSubItems.get(r100);
        if (r101 != null) goto L6;
        MutableLiveData<T[]> r102 = new MutableLiveData();
        this.mSubItems.put(r100, r102);
        return r102;
    L6:
        return r101;
    }

    public void setBadges(String[] r100) {
        this.badges = r100;
    }

    public void setDelegate(a r100) {
        this.mDelegate = r100;
    }

    public boolean showBadges(String r100) {
        String[] r101 = this.badges;
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (Arrays.asList(r101).contains(r100) == false) goto L7;
        return true;
    }

    public void updateItems(T[] r100) {
        this.mItems.setValue(r100);
        this.mNewSubItems.clear();
        updateSubItems(r100);
        removeUnusedSubItems();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public <V> void clickItem(String r100, V r101) {
        a r102 = this.mDelegate;
        if (r102 == null) goto L8;
        if (r101 != null) goto L6;
        r101 = (V) "";
    L6:
        r102.a(r100, r101);
        return;
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public void onBecomeActive(d r100, g45.a r101) {
        r100.requestUpdateWebContentHeight();
    }

    @Override // com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public void onBecomeInactive(d r100, g45.a r101) {
        setActive(false);
    }
}
